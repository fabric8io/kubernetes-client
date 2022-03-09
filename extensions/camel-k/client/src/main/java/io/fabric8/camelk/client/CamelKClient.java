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
package io.fabric8.camelk.client;

import io.fabric8.camelk.client.dsl.V1APIGroupDSL;
import io.fabric8.camelk.client.dsl.V1alpha1APIGroupDSL;
import io.fabric8.kubernetes.client.Client;

/**
 * Main interface for CamelK client library.
 */
public interface CamelKClient extends Client {
  /**
   * API entrypoint for camel.apache.org/v1 API group resources
   *
   * @return {@link V1APIGroupDSL} for CamelK resource operations in this API group.
   */
  V1APIGroupDSL v1();

  /**
   * API entrypoint for camel.apache.org/v1alpha1 API group resources
   * @return {@link V1alpha1APIGroupDSL} for CamelK resource operations in this API group.
   */
  V1alpha1APIGroupDSL v1alpha1();

}
