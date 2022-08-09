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

package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.APIResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;

/**
 * Used to perform operations across all resources known to the api server.
 */
public interface ApiVisitor {

  public enum ApiVisitResult {
    /**
     * If returned, stop the visiting process immediately
     */
    TERMINATE,
    /**
     * Continue visiting
     */
    CONTINUE,
    /**
     * Skip any visiting that would occur under this point
     */
    SKIP
  }

  /**
   * Visit the api group.
   *
   * @param group the group name, will be empty for the core group
   * @return the result to control future actions. {@link ApiVisitResult#SKIP} will skip visiting all versions of this api
   *         group.
   */
  default ApiVisitResult visitApiGroup(String group) {
    return ApiVisitResult.CONTINUE;
  }

  /**
   * Visit the group version.
   * Use {@link ApiVersionUtil} to separate components if needed.
   *
   * @param group the group name, will be empty for the core group
   * @return the result to control future actions. {@link ApiVisitResult#SKIP} will skip visiting all resources under this
   *         api group version.
   */
  default ApiVisitResult visitApiGroupVersion(String group, String version) {
    return ApiVisitResult.CONTINUE;
  }

  /**
   * Visit the resource.
   *
   * @param group the group name, will be empty for the core group. Generally used instead of {@link APIResource#getGroup()}
   * @param version generally used instead of {@link APIResource#getVersion()}
   * @param apiResource can be used to look at applicable verbs and other resource information
   * @param operation the {@link GenericKubernetesResource} operation for the current resource. Will be in the namespace of the
   *        client by default.
   * @return {@link ApiVisitResult#TERMINATE} to terminate. SKIP and CONTINUE will both continue visiting.
   */
  ApiVisitResult visitResource(String group, String version, APIResource apiResource,
      MixedOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> operation);

}
