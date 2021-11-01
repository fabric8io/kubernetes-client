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
import java.net.URI;
import java.net.URL;

public interface HttpRequest extends HttpHeaders {
  
  public interface Builder extends BasicBuilder {

    HttpRequest build();

    Builder uri(String uri);

    // TODO: should be uri
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

  }

  URI uri();

  String method();
  
  /**
   * Return the body as a string, but only if one of the String valued {@link Builder} methods were used
   * otherwise null
   * @return the body
   */
  String bodyString();
  
}
