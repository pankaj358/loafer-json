package devloafer.projects.code.jsonify;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import devloafer.projects.code.jsonify.util.LoaferHeaderFieldSeparatorConstant;

/**
 * @author Pankaj Tirpude [tirpudepankaj@gmail.com]
 * @date 20190601
 */

public class LoaferCreateCompileDynamicObject
{
  private final static Logger logger = LoggerFactory.getLogger(LoaferCreateCompileDynamicObject.class);
  
  public static Path generate(Optional<String> modalName, Set<String> dataMember) throws IOException
  {
    logger.info("generating modal...");
    String modalClassName = String.format("%s.%s", modalName.orElse(LoaferHeaderFieldSeparatorConstant.DEVLOAFER_MODEL_NAME), "java");
    logger.info("Modal class name generated : {} ", modalClassName);
    Path currentPath = FileSystems.getDefault().getPath(".");
    Path modalClassPath = Paths.get(String.format("%s%s%", currentPath.getFileName(), FileSystems.getDefault().getSeparator(), modalClassName));
    BufferedWriter writter = Files.newBufferedWriter(modalClassPath);
    pushClassDeclaration(writter);
    pushDataMember(writter, dataMember);
    pushGetters(writter, dataMember);
    pushSetters(writter, dataMember);
    closeClassDeclaration(writter);
    writter.close();
    logger.info("modal has been generated : {} ", modalClassPath);
    return modalClassPath;
  }
  
  private static BufferedWriter closeClassDeclaration(BufferedWriter writter) throws IOException
  {
    logger.info("pushing class close token...");
    writter.write("}");
    return writter;
  }
  
  private static BufferedWriter pushClassDeclaration(BufferedWriter writter) throws IOException
  {
    logger.info("pushing class declaration...");
    writter.write(LoaferHeaderFieldSeparatorConstant.GENERATED_CLASS_PACKAGE);
    writter.write(LoaferHeaderFieldSeparatorConstant.DEVLOAFER_CLASS_DECLARATION);
    return writter;
  }
  
  private static BufferedWriter pushDataMember(BufferedWriter writter, Set<String> dataMember) throws IOException
  {
    logger.info("pushing data member...");
    for(String member : dataMember)
        writter.write(String.format(LoaferHeaderFieldSeparatorConstant.DATA_MEMBER_DECLARATION, member));
    return writter;
  }
  
  private static BufferedWriter pushGetters(BufferedWriter writter, Set<String> dataMember) throws IOException
  {
    logger.info("pushing getters...");
    for(String member : dataMember)
       writter.write(String.format(LoaferHeaderFieldSeparatorConstant.MEMBER_GETTER_DECLARATION, member, member, member));
    return writter; 
  }
  
  private static BufferedWriter pushSetters(BufferedWriter writter, Set<String> dataMember) throws IOException
  {
    logger.info("pushing setters...");
    for(String member: dataMember)
      writter.write(String.format(LoaferHeaderFieldSeparatorConstant.MEMBER_SETTER_DECLARATION, member, member, member,member));
    return writter;
  }
  
  @SuppressWarnings("unchecked")
  public static <T> T compile(Path modalClassPath) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException
  {
    logger.info("compiling modal : {} ", modalClassPath);
    JavaCompiler runtimeCompiler = ToolProvider.getSystemJavaCompiler();
    runtimeCompiler.run(null, null, null, modalClassPath.toFile().getPath());
    URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] {modalClassPath.toFile().getParentFile().toURI().toURL()});
    Class<?> modalClass = Class.forName(modalClassPath.toFile().getAbsolutePath(), true, classLoader);
    Object instance = modalClass.newInstance();
    logger.info("modal has been successfully compile : {} ", instance);
    return (T) instance;
  }
}
