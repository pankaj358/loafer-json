package devloafer.projects.code.jsonify.util;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Pankaj Tirpude [tirpudepankaj@gmail.com]
 * @date 20190601
 */

public class HeaderNameHelper
{
  private final static Logger logger = LoggerFactory.getLogger(HeaderNameHelper.class);
  
  public final static String getFormattedHeaderMethodName(String headerName)
  {
    logger.info("formatting header name ...");
    headerName = headerName.toLowerCase();
    char[] headerChars = headerName.toCharArray();
    for (int headerCharsIndex = 0; headerCharsIndex < headerChars.length; headerCharsIndex++)
    {
      if (headerChars[headerCharsIndex] == '_'
          && headerChars.length > headerCharsIndex + 1)
        headerChars[headerCharsIndex + 1] = Character
            .toUpperCase(headerChars[headerCharsIndex + 1]);
    }
    headerChars[0] = Character.toUpperCase(headerChars[0]);
    headerName = new String(headerChars);
    return String.format("%s%s", headerName.replace("_", ""));
  }
  
  public final static Set<String> parseHeaderName(String headers, Optional<String> separator)
  {
    logger.info("parsing header name ...");
    Set<String> methodNames = new HashSet<String>();
    String []headerKeys = headers.split(Pattern.quote(separator.orElse(LoaferHeaderFieldSeparatorConstant.SEPARATE_BY_PIPE)));
    for(String headerKey : headerKeys) methodNames.add(getFormattedHeaderMethodName(headerKey));
    return methodNames;
  }
  
}
