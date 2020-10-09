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

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.V1AuthorizationAPIGroupDSL;
import io.fabric8.kubernetes.client.V1beta1AuthorizationAPIGroupDSL;

public interface AuthorizationAPIGroupDSL extends Client {
  /**
   * DSL for authorization.k8s.io/v1 api group.
   *
   * @return V1 Authorization API DSL object
   */
  V1AuthorizationAPIGroupDSL v1();

  /**
   * DSL for authorization.k8s.io/v1beta1 api group
   *
   * @return V1beta1 Authorization API DSL object
   */
  V1beta1AuthorizationAPIGroupDSL v1beta1();
}
