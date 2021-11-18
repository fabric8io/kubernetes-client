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

import io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscaler;
import io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscalerList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

public class V2beta2AutoscalingAPIGroupClient extends BaseClient implements V2beta2AutoscalingAPIGroupDSL {

  public V2beta2AutoscalingAPIGroupClient() {
    super();
  }

  public V2beta2AutoscalingAPIGroupClient(ClientState clientState) {
    super(clientState);
  }

  @Override
  public MixedOperation<HorizontalPodAutoscaler, HorizontalPodAutoscalerList, Resource<HorizontalPodAutoscaler>> horizontalPodAutoscalers() {
    return Handlers.getOperation(HorizontalPodAutoscaler.class, HorizontalPodAutoscalerList.class, this);
  }
}
