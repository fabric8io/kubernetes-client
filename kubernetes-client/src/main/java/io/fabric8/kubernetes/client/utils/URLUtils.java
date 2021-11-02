/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client.utils;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLUtils {
  private URLUtils() {
    throw new IllegalStateException("Utility class");
  }
  public static String join(String... parts) {
        StringBuilder sb = new StringBuilder();

        String urlQueryParams = "";
        if (parts.length > 0) {
          String urlWithoutQuery = parts[0];
          try {
            URI uri = new URI(parts[0]);
            if (containsQueryParam(uri)) {
              urlQueryParams = uri.getQuery();
              urlWithoutQuery = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, uri.getFragment())
                .toString();
            }
          } catch (URISyntaxException e) {
            // Not all first parameters are URL
          }
          sb.append(urlWithoutQuery).append("/");
        }

        StringBuilder queryParams = new StringBuilder();
        for (int i = 1; i < parts.length; i++) {
          try {
            URI partUri = new URI(parts[i]);
            if (containsQueryParam(partUri)) {
              queryParams = getQueryParams(partUri, parts, i+1);
              // If we start detecting query params then everything will be query params part
              break;
            }

            sb.append(parts[i]);

          } catch (URISyntaxException e) {
            sb.append(parts[i]);
          }

          if (i < parts.length - 1) {
            sb.append("/");
          }

        }

        appendQueryParametersFromOriginalUrl(sb, urlQueryParams, queryParams);
        String joined = sb.toString();

        // And normalize it...
        return joined
                .replaceAll("/+", "/")
                .replaceAll("/\\?", "?")
                .replaceAll("/#", "#")
                .replaceAll(":/", "://");

    }

  private static void appendQueryParametersFromOriginalUrl(StringBuilder sb, String urlQueryParams, StringBuilder queryParams) {
    if (!urlQueryParams.isEmpty()) {
      if (queryParams.length() == 0) {
        queryParams.append("?");
      } else {
        queryParams.append("&");
      }
      queryParams.append(urlQueryParams);
    }

    sb.append(queryParams);
  }

  private static StringBuilder getQueryParams(URI firstPart, String[] parts, int index) {
        StringBuilder queryParams = new StringBuilder();
        queryParams.append(firstPart.toString());

        for (int i = index; i < parts.length; i++) {
            String param = parts[i];

            if (!param.startsWith("&")) {
                queryParams.append("&");
            }
            queryParams.append((param));
        }

        return queryParams;
    }

    private static boolean containsQueryParam(URI uri) {
       return uri.getQuery() != null;
    }

  /**
   * Joins all the given strings, ignoring nulls so that they form a URL with / between the paths without a // if the previous path ends with / and the next path starts with / unless a path item is blank
   *
   * @param strings A list of strings which you need to concatenate.
   * @return the strings concatenated together with / while avoiding a double // between non blank strings.
   */
  public static String pathJoin(String... strings) {
    StringBuilder buffer = new StringBuilder();
    for (String string : strings) {
      if (string == null) {
        continue;
      }
      if (buffer.length() > 0) {
        boolean bufferEndsWithSeparator = buffer.toString().endsWith("/");
        boolean stringStartsWithSeparator = string.startsWith("/");
        if (bufferEndsWithSeparator) {
          if (stringStartsWithSeparator) {
            string = string.substring(1);
          }
        } else {
          if (!stringStartsWithSeparator) {
            buffer.append("/");
          }
        }
      }
      buffer.append(string);
    }
    return buffer.toString();
  }

  public static boolean isValidURL(String url) {
    if (url != null) {
      try {
        URI u = new URI(url);
      } catch (URISyntaxException exception) {
        return false;
      }
      return true;
    } else {
      return false;
    }
  }

  public static String encodeToUTF(String url) throws UnsupportedEncodingException {
	  return URLEncoder.encode(url, StandardCharsets.UTF_8.displayName());
  }
}
