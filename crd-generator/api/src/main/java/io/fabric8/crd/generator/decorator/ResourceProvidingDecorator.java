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
package io.fabric8.crd.generator.decorator;

import java.util.HashMap;
import java.util.Map;

public abstract class ResourceProvidingDecorator<T> extends Decorator<T> {

  protected Map<String, String> toMap(String[] arr) {
    Map<String, String> res = new HashMap<>();
    if (arr != null) {
      for (String e : arr) {
        String[] splitted = e.split("\\=");
        if (splitted.length >= 2) {
          res.put(splitted[0], e.substring(splitted[0].length() + 1));
        } else {
          throw new IllegalArgumentException(
              "Invalid value: " + e + " cannot be parsed as a key-value pair. Expected format is 'key=value'.");
        }
      }
    }
    return res;
  }

}
