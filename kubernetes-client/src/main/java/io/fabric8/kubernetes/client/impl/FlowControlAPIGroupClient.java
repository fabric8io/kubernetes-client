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

import io.fabric8.kubernetes.client.dsl.FlowControlAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta1FlowControlAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta2FlowControlAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta3FlowControlAPIGroupDSL;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class FlowControlAPIGroupClient extends ClientAdapter<FlowControlAPIGroupClient> implements FlowControlAPIGroupDSL {

  @Override
  public V1beta1FlowControlAPIGroupDSL v1beta1() {
    return adapt(V1beta1FlowControlAPIGroupClient.class);
  }

  @Override
  public V1beta2FlowControlAPIGroupDSL v1beta2() {
    return adapt(V1beta2FlowControlAPIGroupClient.class);
  }

  @Override
  public V1beta3FlowControlAPIGroupDSL v1beta3() {
    return adapt(V1beta3FlowControlAPIGroupClient.class);
  }

  @Override
  public FlowControlAPIGroupClient newInstance() {
    return new FlowControlAPIGroupClient();
  }
}
