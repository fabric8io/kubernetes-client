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
package io.fabric8.crd.generator.apt;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClassPathUtils {
  private ClassPathUtils() {
  }

  public static List<String> getClassPaths() {
    return Arrays.asList(getProperty("java.class.path")
        .split(getProperty("path.separator")));
  }

  public static List<String> getClassPathsAndReplace(String identifyingClassPathEnding, String appendingPath) {
    return getClassPaths().stream()
        .map(s -> s.endsWith(identifyingClassPathEnding) ? s + "/" + appendingPath : s)
        .collect(Collectors.toList());
  }

  private static String getProperty(String key) {
    return Optional.ofNullable(System.getProperty(key))
        .orElseThrow(() -> new RuntimeException("Could not find system property: " + key));
  }
}
