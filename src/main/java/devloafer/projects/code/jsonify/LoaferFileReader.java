package devloafer.projects.code.jsonify;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import devloafer.projects.code.jsonify.util.HeaderNameHelper;

/**
 * @author Pankaj Tirpude [tirpudepankaj@gmail.com]
 * @date 20190601
 */

public class LoaferFileReader
{
  public void readFile(String filePath, String fileSeparator) throws IOException
  {
    Stream<String> lines = Files.lines(Paths.get(filePath));
    Set<String> headerSet = HeaderNameHelper.parseHeaderName(lines.findFirst().get(), Optional.of(fileSeparator));
    
    lines.close();
  }
}
