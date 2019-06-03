package devloafer.projects.code.jsonify;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import devloafer.projects.code.jsonify.util.HeaderNameHelper;

/**
 * @author Pankaj Tirpude [tirpudepankaj@gmail.com]
 * @date 20190601
 */

public class LoaferFileReader
{
  private final static Logger logger = LoggerFactory.getLogger(LoaferFileReader.class);
  
  public void readFile(String filePath, String fileSeparator) throws IOException
  {
    logger.info(" Reading file : {} with separator : {} ", filePath, fileSeparator);
    Stream<String> lines = Files.lines(Paths.get(filePath));
    Set<String> headerSet = HeaderNameHelper.parseHeaderName(lines.findFirst().get(), Optional.of(fileSeparator));
    LoaferCreateCompileDynamicObject.generate(null, headerSet);
    lines.close();
  }
}
