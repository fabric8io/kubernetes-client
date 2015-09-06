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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.DoneableEndpoints;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.CreateFromLoadable;

public class EndpointsOperationsImpl extends HasMetadataOperation<KubernetesClient, Endpoints, EndpointsList, DoneableEndpoints,
  ClientResource<Endpoints, DoneableEndpoints>>,
  CreateFromLoadable<Endpoints, DoneableEndpoints>> {

  public EndpointsOperationsImpl(KubernetesClient client) {
    super(client, "endpoints", null, null, true);
  }

  public EndpointsOperationsImpl(KubernetesClient client, String namespace, String name, Boolean cascading) {
    super(client, "endpoints", namespace, name, cascading);
  }

public EndpointsOperationsImpl(KubernetesClient client, String namespace, String name, Boolean cascading, Endpoints item) {
  super(client, "endpoints", namespace, name, cascading, item);
  }
}
