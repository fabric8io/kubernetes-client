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

import io.fabric8.kubernetes.client.V1AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.V2AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.V2beta1AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.V2beta2AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class AutoscalingAPIGroupClient extends ClientAdapter<AutoscalingAPIGroupClient> implements AutoscalingAPIGroupDSL {

  @Override
  public V2AutoscalingAPIGroupDSL v2() {
    return adapt(V2AutoscalingAPIGroupClient.class);
  }

  @Override
  public V1AutoscalingAPIGroupDSL v1() {
    return adapt(V1AutoscalingAPIGroupClient.class);
  }

  @Override
  public V2beta1AutoscalingAPIGroupDSL v2beta1() {
    return adapt(V2beta1AutoscalingAPIGroupClient.class);
  }

  @Override
  public V2beta2AutoscalingAPIGroupDSL v2beta2() {
    return adapt(V2beta2AutoscalingAPIGroupClient.class);
  }

  @Override
  public AutoscalingAPIGroupClient newInstance() {
    return new AutoscalingAPIGroupClient();
  }
}
