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

import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.CreateFromLoadable;

public class PodOperationsImpl extends HasMetadataOperation<KubernetesClient, Pod, PodList, DoneablePod, ClientResource<Pod, DoneablePod>, CreateFromLoadable<Pod, DoneablePod>> {

  public PodOperationsImpl(KubernetesClient client) {
    super(client,"pods", null, (String) null);
  }

  public PodOperationsImpl(KubernetesClient client, String namespace, String name) {
    super(client,"pods", namespace, name);
  }

  public PodOperationsImpl(KubernetesClient client, String namespace, Pod o) {
    super(client, "pods", namespace, o);
  }
}
