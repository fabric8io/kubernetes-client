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

import io.fabric8.kubernetes.client.dsl.KubernetesListMixedOperation;
import io.fabric8.kubernetes.client.dsl.KubernetesListOperation;
import io.fabric8.kubernetes.client.dsl.Loadable;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.model.DoneableKubernetesList;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.HasMetadataVisitiableBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.dsl.KubernetesListNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Createable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.RecreateFromServerGettable;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KubernetesListOperationsImpl
  extends OperationSupport
  implements KubernetesListOperation,
  KubernetesListMixedOperation,
  Loadable<RecreateFromServerGettable<KubernetesList, KubernetesList, DoneableKubernetesList>>,
        RecreateFromServerGettable<KubernetesList, KubernetesList, DoneableKubernetesList> {

  private final KubernetesList item;
  private final Boolean fromServer;
  private final Boolean deletingExisting;

  public KubernetesListOperationsImpl(OkHttpClient client, Config config, String namespace) {
    this(client, config, namespace, null, null, false, false, null, null);
  }

  public KubernetesListOperationsImpl(OkHttpClient client, Config config, String namespace, String name, Boolean cascading, Boolean fromServer, Boolean deletingExisting, KubernetesList item, String resourceVersion) {
    super(client, config, null, null, null, namespace, null);
    this.fromServer = fromServer;
    this.deletingExisting = deletingExisting;
    this.item = item;
  }

  @Override
  public KubernetesListNonNamespaceOperation inNamespace(String namespace) {
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
    return new DoneableKubernetesList(new Function<KubernetesList, KubernetesList>() {
      @Override
      public KubernetesList apply(KubernetesList item) {
        try {
          return create(item);
        } catch (Exception e) {
          throw KubernetesClientException.launderThrowable(e);
        }
      }
    });
  }

  @Override
  public RecreateFromServerGettable<KubernetesList, KubernetesList, DoneableKubernetesList> load(URL url) {
    try (InputStream inputStream = url.openStream()) {
      return load(inputStream);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public RecreateFromServerGettable<KubernetesList, KubernetesList, DoneableKubernetesList>  load(File file) {
    try (FileInputStream fis = new FileInputStream(file)) {
      return load(fis);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public RecreateFromServerGettable<KubernetesList, KubernetesList, DoneableKubernetesList>  load(String path) {
    return load(new File(path));
  }

  @Override
  public RecreateFromServerGettable<KubernetesList, KubernetesList, DoneableKubernetesList> load(InputStream is) {
    return new KubernetesListOperationsImpl(client, config, namespace, null, false, fromServer, deletingExisting, unmarshal(is, KubernetesList.class), null);
  }

  @Override
  public KubernetesList get() {
    return item;
  }

  private <T extends HasMetadata, V extends VisitableBuilder<T, V>> T create(T resource) {
    ResourceHandler<T, V> handler = Handlers.get(resource.getKind());
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
        ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> handler = Handlers.get(item.getKind());
        if (!handler.delete(client, config, namespace, item)) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public Gettable<KubernetesList> fromServer() {
    return new KubernetesListOperationsImpl(client, config, namespace, null, false, true, deletingExisting, item, null);
  }

  @Override
  public Createable<KubernetesList, KubernetesList, DoneableKubernetesList> deletingExisting() {
    return new KubernetesListOperationsImpl(client, config, namespace, null, false, fromServer, true, item, null);
  }
}
