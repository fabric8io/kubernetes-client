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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.mockwebserver.crud.ResponseComposer;

import java.util.Collection;

public class KubernetesResponseComposer implements ResponseComposer {

  // This is a reimplementation of Java 8's String.join.
  private static String join(String sep, Collection<String> collection) {
    StringBuilder builder = new StringBuilder();
    boolean first = true;
    for (String element : collection) {
      if (first) {
        first = false;
      } else {
        builder.append(sep);
      }
      builder.append(element);
    }
    return builder.toString();
  }

  @Override
  public String compose(Collection<String> collection) {
    return String.format(
        "{\"apiVersion\":\"v1\",\"kind\":\"List\", \"items\": [%s], " +
         "\"metadata\": {\"resourceVersion\": \"\", \"selfLink\": \"\"}}",
        join(",", collection));
  }
}
