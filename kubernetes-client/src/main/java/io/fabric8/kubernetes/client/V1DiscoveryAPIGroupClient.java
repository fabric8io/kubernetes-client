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

import io.fabric8.kubernetes.api.model.discovery.v1.EndpointSlice;
import io.fabric8.kubernetes.api.model.discovery.v1.EndpointSliceList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.V1DiscoveryAPIGroupDSL;
import io.fabric8.kubernetes.client.http.HttpClient;

public class V1DiscoveryAPIGroupClient  extends BaseClient implements V1DiscoveryAPIGroupDSL {
  public V1DiscoveryAPIGroupClient() {
    super();
  }

  public V1DiscoveryAPIGroupClient(HttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<EndpointSlice, EndpointSliceList, Resource<EndpointSlice>> endpointSlices() {
    return Handlers.getOperation(EndpointSlice.class, EndpointSliceList.class, httpClient, getConfiguration());
  }
}
