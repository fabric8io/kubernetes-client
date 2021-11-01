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

import io.fabric8.kubernetes.client.dsl.FlowControlAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta1FlowControlAPIGroupDSL;
import io.fabric8.kubernetes.client.http.HttpClient;

public class FlowControlAPIGroupClient extends BaseClient implements FlowControlAPIGroupDSL {
  public FlowControlAPIGroupClient() {
    super();
  }

  public FlowControlAPIGroupClient(HttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public V1beta1FlowControlAPIGroupDSL v1beta1() {
    return adapt(V1beta1FlowControlAPIGroupClient.class);
  }
}
