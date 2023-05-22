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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static io.fabric8.kubernetes.client.utils.Utils.interpolateString;

/**
 * Replaces template parameter values in the stream to avoid
 * parsing issues of templates with numeric expressions
 *
 * @deprecated to be removed in future versions
 */
@Deprecated
public class ReplaceValueStream {
  private final Map<String, String> valuesMap;

  /**
   * Returns a stream with the template parameter expressions replaced
   *
   * @param is {@link InputStream} inputstream for
   * @param valuesMap a hashmap containing parameters
   * @return returns stream with template parameter expressions replaced
   * @throws IOException in case of any network/object parse problems
   */
  public static InputStream replaceValues(InputStream is, Map<String, String> valuesMap) throws IOException {
    return new ReplaceValueStream(valuesMap).createInputStream(is);
  }

  private ReplaceValueStream(Map<String, String> valuesMap) {
    this.valuesMap = valuesMap;
  }

  private InputStream createInputStream(InputStream is) throws IOException {
    return new ByteArrayInputStream(
        interpolateString(IOHelpers.readFully(is), valuesMap).getBytes(StandardCharsets.UTF_8));
  }
}
