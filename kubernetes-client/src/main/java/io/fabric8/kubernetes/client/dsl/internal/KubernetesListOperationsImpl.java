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

import com.squareup.okhttp.OkHttpClient;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.DoneableKubernetesList;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.ResourceNotFoundException;
import io.fabric8.kubernetes.client.dsl.ClientKubernetesListMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientKubernetesListNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientKubernetesListOperation;
import io.fabric8.kubernetes.client.dsl.CreateGettable;
import io.fabric8.kubernetes.client.dsl.Loadable;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KubernetesListOperationsImpl
  extends OperationSupport
  implements ClientKubernetesListOperation,
  ClientKubernetesListMixedOperation,
  Loadable<InputStream, CreateGettable<KubernetesList, KubernetesList, DoneableKubernetesList>>,
  CreateGettable<KubernetesList, KubernetesList, DoneableKubernetesList> {

  private KubernetesList item;

  public KubernetesListOperationsImpl(OkHttpClient client, Config config, String namespace) {
    super(client, config, null, null, null, namespace, null);
  }

  @Override
  public ClientKubernetesListNonNamespaceOperation inNamespace(String namespace) {
    return new KubernetesListOperationsImpl(client, config, namespace);
  }

  @Override
  public KubernetesList create(KubernetesList... items) {
    List<HasMetadata> createdItems = new ArrayList<>();
    if (items.length == 0) {
      items = new KubernetesList[]{get()};
    }
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
    item = unmarshal(is, KubernetesList.class);
    return this;
  }

  @Override
  public KubernetesList get() {
    return item;
  }

  @Override
  public KubernetesList getRequired() throws ResourceNotFoundException {
    KubernetesList result = get();
    if (result != null) {
      return null;
    }
    StringBuilder sb = new StringBuilder();
    sb.append("Failed to load resource ").append(" of type: " + KubernetesList.class.getName()).append(".");
    throw new ResourceNotFoundException(sb.toString());
  }

  private <T extends HasMetadata> T create(T resource) {
    ResourceHandler<T> handler = Handlers.get(resource.getKind());
    if (handler != null) {
      return handler.create(client, config, namespace, resource);
    }
    throw new IllegalStateException("Could not find handler");
  }

  @Override
  public Boolean delete(KubernetesList... lists) {
    return delete(Arrays.asList(lists));
  }

  @Override
  public Boolean delete(List<KubernetesList> lists) {
    for (KubernetesList list : lists) {
      for (HasMetadata item : list.getItems()) {
        ResourceHandler handler = (ResourceHandler) Handlers.get(item.getKind());
        if (!handler.delete(client, config, namespace, item)) {
          return false;
        }
      }
    }
    return true;
  }
}
