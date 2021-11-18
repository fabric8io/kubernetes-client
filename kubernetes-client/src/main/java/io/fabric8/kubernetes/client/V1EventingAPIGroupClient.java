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

import io.fabric8.kubernetes.api.model.events.v1.Event;
import io.fabric8.kubernetes.api.model.events.v1.EventList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.V1EventingAPIGroupDSL;

public class V1EventingAPIGroupClient extends BaseClient implements V1EventingAPIGroupDSL {
  public V1EventingAPIGroupClient() {
    super();
  }

  public V1EventingAPIGroupClient(ClientState clientState) {
    super(clientState);
  }

  @Override
  public MixedOperation<Event, EventList, Resource<Event>> events() {
    return Handlers.getOperation(Event.class, EventList.class, this);
  }
}
