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

import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.DoneableKubernetesList;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.Creators;
import io.fabric8.kubernetes.client.GenericKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.ResourceCreator;
import io.fabric8.kubernetes.client.dsl.ClientKubernetesListMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientKubernetesListNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientKubernetesListOperation;
import io.fabric8.kubernetes.client.dsl.CreateGettable;
import io.fabric8.kubernetes.client.dsl.Loadable;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class KubernetesListOperationsImpl<C extends GenericKubernetesClient<C>>
  implements ClientKubernetesListOperation<C>,
  ClientKubernetesListMixedOperation<C>,
  Loadable<InputStream, CreateGettable<KubernetesList, KubernetesList, DoneableKubernetesList>>,
  CreateGettable<KubernetesList, KubernetesList, DoneableKubernetesList> {

  private final C client;
  private KubernetesList item;
  private String namespace;

  public KubernetesListOperationsImpl(C client) {
    this(client, client.getNamespace());
  }

  public KubernetesListOperationsImpl(C client, String namespace) {
    this.client = client;
    this.namespace = namespace;
  }

  @Override
  public C getClient() {
    return client;
  }

  @Override
  public ClientKubernetesListNonNamespaceOperation<C> inNamespace(String namespace) {
    return new KubernetesListOperationsImpl(client, namespace);
  }

  @Override
  public KubernetesList create(KubernetesList... items) {
    List<HasMetadata> createdItems = new ArrayList<>();
    for (KubernetesList i : items) {
      for (HasMetadata r : i.getItems()) {
        HasMetadata created = create(r);
        createdItems.add(created);
      }
    }

    KubernetesList createdList = new KubernetesList();
    createdList.setItems(createdItems);
    return createdList;
  }

  @Override
  public DoneableKubernetesList createNew() {
    return new DoneableKubernetesList(new Visitor<KubernetesList>() {
      @Override
      public void visit(KubernetesList list) {
        try {
          create(list);
        } catch (Exception e) {
          throw KubernetesClientException.launderThrowable(e);
        }
      }
    });
  }

  @Override
  public CreateGettable<KubernetesList, KubernetesList, DoneableKubernetesList> load(InputStream is) {
    item = client.unmarshal(is, KubernetesList.class);
    return this;
  }

  @Override
  public KubernetesList get() {
    return item;
  }

  private <T extends HasMetadata> T create(T resource) {
    ResourceCreator<T> creator = (ResourceCreator<T>) Creators.get(resource.getClass());
    if (creator != null) {
      return creator.create(client, namespace, resource);
    }
    throw new IllegalStateException("Could not find creator");
  }
}
