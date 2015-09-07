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

import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceListOperation;
import io.fabric8.kubernetes.client.dsl.LoadCreateGettable;

import java.io.InputStream;

public class NamespacedListOperationsImpl extends ListOperationsImpl
  implements ClientNonNamespaceListOperation<KubernetesClient>,
             LoadCreateGettable<KubernetesList> {

  public NamespacedListOperationsImpl(KubernetesClient client, String namespace) {
    super(client, namespace);
  }

  @Override
  public LoadCreateGettable<KubernetesList> load(InputStream is) {
    item = client.unmarshal(is, KubernetesList.class);
    return this;
  }

  @Override
  public KubernetesList create() {
    return create(item);
  }
}
