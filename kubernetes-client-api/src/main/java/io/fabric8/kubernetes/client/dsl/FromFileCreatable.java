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
package io.fabric8.kubernetes.client.dsl;

import java.nio.file.Path;

public interface FromFileCreatable<T> {
  /**
   * Create or update an entry from a directory or file contents.
   *
   * @param key key for Kubernetes resource's .data field
   * @param dirOrFilePath a file or directory path
   * @return Resource instance for operations to do with this resource
   */
  T fromFile(String key, Path dirOrFilePath);

  /**
   * Create or update an entry with data populated with entry with key matching file name
   * and value matching file contents. If it's a directory, key value pairs would be names
   * of files present in directory as keys and their contents as value respectively
   *
   * @param dirOrFilePath a file or directory path
   * @return Resource instance for operations to do with this resource
   */
  default T fromFile(Path dirOrFilePath) {
    return fromFile(dirOrFilePath.toFile().getName(), dirOrFilePath);
  }
}
