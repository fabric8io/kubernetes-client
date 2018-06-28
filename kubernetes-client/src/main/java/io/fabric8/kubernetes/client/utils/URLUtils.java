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

import java.net.URI;
import java.net.URISyntaxException;

public class URLUtils {
    private URLUtils() {}

    public static String join(String... parts) {
        StringBuilder sb = new StringBuilder();

        String queryParams = "";
        if (parts.length > 0) {
          String urlWithoutQuery = parts[0];
          try {
            URI uri = new URI(parts[0]);
            if (uri.getQuery() != null) {
              queryParams = "?" + uri.getQuery();
              urlWithoutQuery = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, uri.getFragment())
                .toString();
            }
          } catch (URISyntaxException e) {
            // Not all first parameters are URL
          }
          sb.append(urlWithoutQuery).append("/");
        }

        for (int i = 1; i < parts.length; i++) {
            sb.append(parts[i]);
            if (i < parts.length - 1) {
                sb.append("/");
            }
        }

        sb.append(queryParams);
        String joined = sb.toString();

        // And normalize it...
        return joined
                .replaceAll("/+", "/")
                .replaceAll("/\\?", "?")
                .replaceAll("/#", "#")
                .replaceAll(":/", "://");

    }
}
