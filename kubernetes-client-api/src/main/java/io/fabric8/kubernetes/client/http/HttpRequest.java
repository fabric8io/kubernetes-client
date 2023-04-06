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

package io.fabric8.kubernetes.client.http;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public interface HttpRequest extends HttpHeaders {

  interface Builder extends BasicBuilder {

    HttpRequest build();

    /**
     * Sets the target URI for this request.
     *
     * @param uri the URI as String.
     * @return the builder.
     */
    Builder uri(String uri);

    /**
     * Sets the target {@link URL} for this request.
     *
     * @param url the URL.
     * @return the builder.
     */
    Builder url(URL url);

    @Override
    Builder uri(URI uri);

    default Builder put(String contentType, String writeValueAsString) {
      return method("PUT", contentType, writeValueAsString);
    }

    default Builder post(String contentType, String writeValueAsString) {
      return method("POST", contentType, writeValueAsString);
    }

    Builder post(String contentType, byte[] writeValueAsBytes);

    Builder post(String contentType, InputStream stream, long length);

    default Builder delete(String contentType, String writeValueAsString) {
      return method("DELETE", contentType, writeValueAsString);
    }

    default Builder patch(String contentType, String patchForUpdate) {
      return method("PATCH", contentType, patchForUpdate);
    }

    Builder method(String method, String contentType, String body);

    @Override
    Builder header(String k, String v);

    @Override
    Builder setHeader(String k, String v);

    default Builder post(Map<String, String> formData) {
      return post("application/x-www-form-urlencoded",
          formData.entrySet()
              .stream()
              .map(e -> formURLEncode(e.getKey()) + "=" + formURLEncode(e.getValue()))
              .collect(Collectors.joining("&")));
    }

    Builder expectContinue();

  }

  static String formURLEncode(String value) {
    try {
      return URLEncoder.encode(value, StandardCharsets.UTF_8.displayName());
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * The unique id for this HTTP request, used for logging and debugging
   * 
   * @return a UUID.
   */
  UUID id();

  URI uri();

  String method();

  /**
   * Return the body as a string, but only if one of the String valued {@link Builder} methods were used
   * otherwise null
   *
   * @return the body
   */
  String bodyString();

}
