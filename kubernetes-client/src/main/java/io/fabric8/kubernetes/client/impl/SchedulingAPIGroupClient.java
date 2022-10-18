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

import io.fabric8.kubernetes.api.model.scheduling.v1beta1.PriorityClass;
import io.fabric8.kubernetes.api.model.scheduling.v1beta1.PriorityClassList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.SchedulingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1SchedulingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta1SchedulingAPIGroupDSL;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class SchedulingAPIGroupClient extends ClientAdapter<SchedulingAPIGroupClient> implements SchedulingAPIGroupDSL {

  @Override
  public MixedOperation<PriorityClass, PriorityClassList, Resource<PriorityClass>> priorityClass() {
    return resources(PriorityClass.class, PriorityClassList.class);
  }

  @Override
  public V1SchedulingAPIGroupDSL v1() {
    return adapt(V1SchedulingAPIGroupClient.class);
  }

  @Override
  public V1beta1SchedulingAPIGroupDSL v1beta1() {
    return adapt(V1beta1SchedulingAPIGroupClient.class);
  }

  @Override
  public SchedulingAPIGroupClient newInstance() {
    return new SchedulingAPIGroupClient();
  }
}
