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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.client.V1Alpha2DynamicResourceAllocationAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.DynamicResourceAllocationAPIGroupDSL;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class DynamicResourceAllocationAPIGroupClient extends ClientAdapter<DynamicResourceAllocationAPIGroupClient>
    implements DynamicResourceAllocationAPIGroupDSL {
  @Override
  public DynamicResourceAllocationAPIGroupClient newInstance() {
    return new DynamicResourceAllocationAPIGroupClient();
  }

  @Override
  public V1Alpha2DynamicResourceAllocationAPIGroupDSL v1alpha2() {
    return adapt(V1Alpha2DynamicResourceAllocationAPIGroupClient.class);
  }
}
