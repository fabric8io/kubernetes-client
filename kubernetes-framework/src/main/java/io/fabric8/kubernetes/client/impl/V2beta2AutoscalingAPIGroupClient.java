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

import io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscaler;
import io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscalerList;
import io.fabric8.kubernetes.client.V2beta2AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V2beta2AutoscalingAPIGroupClient extends ClientAdapter<V2beta2AutoscalingAPIGroupClient>
    implements V2beta2AutoscalingAPIGroupDSL {

  @Override
  public MixedOperation<HorizontalPodAutoscaler, HorizontalPodAutoscalerList, Resource<HorizontalPodAutoscaler>> horizontalPodAutoscalers() {
    return resources(HorizontalPodAutoscaler.class, HorizontalPodAutoscalerList.class);
  }

  @Override
  public V2beta2AutoscalingAPIGroupClient newInstance() {
    return new V2beta2AutoscalingAPIGroupClient();
  }
}
