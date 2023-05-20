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

import io.fabric8.kubernetes.client.dsl.EventingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1EventingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta1EventingAPIGroupDSL;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class EventingAPIGroupClient extends ClientAdapter<EventingAPIGroupClient> implements EventingAPIGroupDSL {

  @Override
  public V1EventingAPIGroupDSL v1() {
    return adapt(V1EventingAPIGroupClient.class);
  }

  @Override
  public V1beta1EventingAPIGroupDSL v1beta1() {
    return adapt(V1beta1EventingAPIGroupClient.class);
  }

  @Override
  public EventingAPIGroupClient newInstance() {
    return new EventingAPIGroupClient();
  }
}
