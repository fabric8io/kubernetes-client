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
package io.fabric8.ovn.client;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.ovn.client.dsl.V1OpenVirtualNetworkingAPIGroupDSL;

public interface OpenVirtualNetworkingClient extends Client {
  /**
   * DSL entrypoint for entrypoint for k8s.ovn.org/v1 resources
   *
   * @return {@link V1OpenVirtualNetworkingAPIGroupDSL}
   */
  V1OpenVirtualNetworkingAPIGroupDSL v1();
}
