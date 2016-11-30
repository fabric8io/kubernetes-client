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

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public interface Loadable<T> {

  /**
   * Load from an {@link InputStream}.
   * @param is  The input stream.
   * @return
   */
  T load(InputStream is);

  /**
   * Load from a {@link URL}.
   * @param url  The url.
   * @return
   */
  T load(URL url);

  /**
   * Load from a {@link File}.
   * @param file  The file.
   * @return
   */
  T load(File file);

  /**
   * Load from path.
   * @param path  The path.
   * @return
   */
  T load(String path);
}
