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

import java.util.Map;

public interface ImageUpdateable<T> {

  /**
   * Update existing container image(s) of resources
   *
   * @param containerToImageMap Map with keys as container name and value as image
   * @return updated resource
   */
  T updateImage(Map<String, String> containerToImageMap);

  /**
   * Update existing container image of single container resource
   *
   * @param image image to be updated
   * @return updated resource
   */
  T updateImage(String image);

}
