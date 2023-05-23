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

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface HttpHeaders {

  /**
   * Returns a List of all the Header String values for the provided key/name.
   *
   * @param key The header key/name for which to provide the values.
   * @return the List of header values for the provided key.
   */
  List<String> headers(String key);

  /**
   * Returns a Map containing a list of String values for each Header.
   *
   * @return the Map of Headers and their list of values.
   */
  Map<String, List<String>> headers();

  /**
   * Return the header as a single string value
   *
   * @return will be null if the header is unset
   */
  default String header(String key) {
    List<String> headers = headers(key);
    if (headers.size() == 1) {
      return headers.get(0);
    }
    if (headers.isEmpty()) {
      return null;
    }
    return headers.stream().collect(Collectors.joining(","));
  }

}
