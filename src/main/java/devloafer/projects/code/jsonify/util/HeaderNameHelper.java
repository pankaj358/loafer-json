package devloafer.projects.code.jsonify.util;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 
 * @author Pankaj Tirpude [tirpudepankaj@gmail.com]
 * @date 20190601
 */

public class HeaderNameHelper
{
  public final static String getFormattedHeaderMethodName(String headerName)
  {
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
    Set<String> methodNames = new HashSet<String>();
    String []headerKeys = headers.split(Pattern.quote(separator.orElse(LoaferHeaderFieldSeparatorConstant.SEPARATE_BY_PIPE)));
    for(String headerKey : headerKeys) methodNames.add(getFormattedHeaderMethodName(headerKey));
    return methodNames;
  }
  
}
