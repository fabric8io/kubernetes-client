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

import java.io.InputStream;
import java.nio.file.Path;

public interface CopyOrReadable {

  /**
   * Upload file located at specified {@link Path} to Pod
   *
   * @param path path of the file which needs to be uploaded
   * @return boolean value regarding upload was successful or not.
   */
  boolean upload(Path path);

  /**
   * Upload file extracted from provided InputStream to Pod
   *
   * @param inputStream {@link InputStream} which will be uploaded
   * @return boolean value regarding upload was successful or not.
   */
  boolean upload(InputStream inputStream);

  InputStream read();

  boolean copy(Path destination);

  /**
   * How long to wait for a ready pod before performing the copy or read operation.
   *
   * @param timeout in milliseconds
   */
  CopyOrReadable withReadyWaitTimeout(Integer timeout);

}
