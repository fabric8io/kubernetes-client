/*
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
package io.fabric8.kubernetes.schema.generator;

import java.util.Comparator;
import java.util.Set;

public class ImportOrderComparator implements Comparator<String> {
  private static final Set<String> JAVA_PACKAGES = Set.of("java", "javax");

  @Override
  public int compare(String o1, String o2) {
    final String o1Root = o1.substring(0, o1.indexOf('.'));
    final String o2Root = o2.substring(0, o2.indexOf('.'));
    if (JAVA_PACKAGES.contains(o1Root) && !JAVA_PACKAGES.contains(o2Root)) {
      return -1;
    } else if (!JAVA_PACKAGES.contains(o1Root) && JAVA_PACKAGES.contains(o2Root)) {
      return 1;
    }
    return o1.compareTo(o2);
  }
}
