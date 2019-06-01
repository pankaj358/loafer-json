package devloafer.projects.code.jsonify;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;

import devloafer.projects.code.jsonify.util.LoaferHeaderFieldSeparatorConstant;

/**
 * @author Pankaj Tirpude [tirpudepankaj@gmail.com]
 * @date 20190601
 */

public class LoaferCreateCompileDynamicObject
{
  public <T> T generate(Optional<String> modalName, Set<String> dataMember) throws IOException
  {
    String modalClassName = String.format("%s.%s", modalName.orElse(LoaferHeaderFieldSeparatorConstant.DEVLOAFER_MODEL_NAME), "java");
    Path modalClassPath = Paths.get(modalClassName);
    BufferedWriter writter = Files.newBufferedWriter(modalClassPath);
    pushDataMember(writter, dataMember);
    pushGetters(writter, dataMember);
    pushSetters(writter, dataMember);
    writter.close();
    return null;
  }
  
  private BufferedWriter pushDataMember(BufferedWriter writter, Set<String> dataMember) throws IOException
  {
    for(String member : dataMember)
        writter.write(String.format(LoaferHeaderFieldSeparatorConstant.DATA_MEMBER_DECLARATION, member));
    return writter;
  }
  
  private BufferedWriter pushGetters(BufferedWriter writter, Set<String> dataMember) throws IOException
  {
    for(String member : dataMember)
       writter.write(String.format(LoaferHeaderFieldSeparatorConstant.MEMBER_GETTER_DECLARATION, member, member, member));
    return writter; 
  }
  
  private BufferedWriter pushSetters(BufferedWriter writter, Set<String> dataMember) throws IOException
  {
    for(String member: dataMember)
      writter.write(String.format(LoaferHeaderFieldSeparatorConstant.MEMBER_SETTER_DECLARATION, member, member, member,member));
    return writter;
  }
  
  public <T> T compile()
  {
    return null;
  }
}
