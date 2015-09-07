/**
 * Copyright (C) 2015 Red Hat, Inc.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
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
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.ResourceCreator;
import io.fabric8.kubernetes.client.dsl.ClientListOperation;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceListOperation;
import io.fabric8.kubernetes.client.dsl.LoadCreateGettable;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class ListOperationsImpl
  implements ClientListOperation<KubernetesClient>,
  ClientNonNamespaceListOperation<KubernetesClient>,
  LoadCreateGettable<KubernetesList> {

  protected final KubernetesClient client;
  protected KubernetesList item;
  private String namespace;

  public ListOperationsImpl(KubernetesClient client) {
    this.client = client;
  }

  public ListOperationsImpl(KubernetesClient client, String namespace) {
    this.client = client;
    this.namespace = namespace;
  }

  @Override
  public KubernetesClient getClient() {
    return client;
  }

  @Override
  public ClientNonNamespaceListOperation<KubernetesClient> inNamespace(String namespace) {
    return new NamespacedListOperationsImpl(client, namespace);
  }

  @Override
  public KubernetesList create(KubernetesList item) {
    List<HasMetadata> createdItems = new ArrayList<>(item.getItems().size());

    for (HasMetadata r : item.getItems()) {
      HasMetadata created = create(r);
      createdItems.add(created);
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
  public KubernetesList get() {
    return item;
  }

  private <T extends HasMetadata> T create(T resource) {
    for (ResourceCreator<T> creator : ServiceLoader.load(ResourceCreator.class)) {
      if (creator.getKind().isAssignableFrom(resource.getClass())) {
        return creator.create(client, namespace, resource);
      }
    }
    throw new IllegalStateException("Could not find creator");
  }


  @Override
  public LoadCreateGettable<KubernetesList> load(InputStream is) {
    item = client.unmarshal(is, KubernetesList.class);
    return this;
  }

  @Override
  public KubernetesList create() {
    throw new KubernetesClientException("Cannot create resources without namespace");
  }
}
