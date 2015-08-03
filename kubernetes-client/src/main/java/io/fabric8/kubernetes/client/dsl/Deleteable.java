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

public interface Deleteable<V, B> {

  /**
   * Deletes resource & all managed resources.
   * @throws io.fabric8.kubernetes.client.KubernetesClientException if resource is not found.
   */
  V delete();

  /**
   * Deletes resource & all managed resources if cascade is true.
   * @throws io.fabric8.kubernetes.client.KubernetesClientException if resource is not found.
   */
  V delete(boolean cascade);

  /**
   * Deletes resource if exists & all managed resources.
   * @throws io.fabric8.kubernetes.client.KubernetesClientException if an error occurs (including errors due to namespace not exists).
   */
  B deleteIfExists();
  /**
   * Deletes resource if exists & all managed resources if cascade is true.
   * @throws io.fabric8.kubernetes.client.KubernetesClientException if an error occurs (including errors due to namespace not exists).
   */
  B deleteIfExists(boolean cascade);
}
