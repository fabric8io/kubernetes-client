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

import io.fabric8.kubernetes.api.model.DoneableServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.ClientResource;

public class ServiceAccountOperationsImpl extends HasMetadataOperation<KubernetesClient, ServiceAccount, ServiceAccountList, DoneableServiceAccount, ClientResource<ServiceAccount, DoneableServiceAccount>> {

  public ServiceAccountOperationsImpl(KubernetesClient client) {
    super(client,"serviceaccounts", null, (String) null);
  }

  public ServiceAccountOperationsImpl(KubernetesClient client, String namespace, String name) {
    super(client,"serviceaccounts", namespace, name);
  }

  public ServiceAccountOperationsImpl(KubernetesClient client, String namespace, ServiceAccount o) {
    super(client, "serviceaccounts", namespace, o);
  }
}
