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

import java.util.Collection;
import java.util.Objects;

public interface ImportManager {

  String getPackageName();

  Collection<String> getImports();

  default void addImport(String importedClass) {
    // Only add import if it belongs to a different package
    if (!Objects.equals(importedClass.substring(0, importedClass.lastIndexOf('.')), getPackageName())) {
      getImports().add(importedClass);
    }
  }

  default void addAllImports(Collection<String> allImports) {
    allImports.forEach(this::addImport);
  }

  /**
   * Returns true if the given fully qualified class name is already imported (as part of a different package).
   *
   * @param className the fully qualified class name to check.
   * @return true if the given simple class name is already imported as part of a different package, false otherwise.
   */
  default boolean hasSimpleClassName(String className) {
    final String simpleClassName = className.substring(className.lastIndexOf('.') + 1);
    return getImports().stream()
        .filter(i -> !Objects.equals(i, className))
        .anyMatch(i -> i.endsWith("." + simpleClassName));
  }
}
