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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.dsl.KubernetesListNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Createable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.RecreateFromServerGettable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.utils.Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KubernetesListOperationsImpl
  implements KubernetesListOperation,
  KubernetesListMixedOperation,
  Loadable<RecreateFromServerGettable<KubernetesList>>,
        RecreateFromServerGettable<KubernetesList> {

  private final boolean deletingExisting;
  private final OperationContext context;

  public KubernetesListOperationsImpl(OkHttpClient client, Config config) {
    this.context = HasMetadataOperationsImpl.defaultContext(new OperationContext(), client, config);
    this.deletingExisting = false;
  }
  
  public KubernetesListOperationsImpl(OperationContext context, boolean deletingExisting) {
    this.context = context;
    this.deletingExisting = deletingExisting;
  }

  @Override
  public KubernetesListNonNamespaceOperation inNamespace(String namespace) {
    return new KubernetesListOperationsImpl(context.withNamespace(namespace), deletingExisting);
  }

  @Override
  public KubernetesList create(KubernetesList... items) {
    List<HasMetadata> createdItems = new ArrayList<>();
    if (items.length == 0) {
      items = new KubernetesList[]{get()};
    }
    for (KubernetesList i : items) {
      createdItems.addAll(createItemsInKubernetesList(i));
    }

    KubernetesList createdList = new KubernetesList();
    createdList.setItems(createdItems);
    return createdList;
  }

  @Override
  public KubernetesList create(KubernetesList list) {
    return create(new KubernetesList[]{list});
  }

  @Override
  public RecreateFromServerGettable<KubernetesList> load(URL url) {
    try (InputStream inputStream = url.openStream()) {
      return load(inputStream);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public RecreateFromServerGettable<KubernetesList> load(File file) {
    try (FileInputStream fis = new FileInputStream(file)) {
      return load(fis);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public RecreateFromServerGettable<KubernetesList> load(String path) {
    return load(new File(path));
  }

  @Override
  public RecreateFromServerGettable<KubernetesList> load(InputStream is) {
    return new KubernetesListOperationsImpl(context.withItem(Serialization.unmarshal(is, KubernetesList.class)), deletingExisting);
  }

  @Override
  public KubernetesList get() {
    KubernetesList list = (KubernetesList)context.getItem();
    if (list == null) {
      return null;
    }
    return new KubernetesListBuilder(list).withItems(list.getItems().stream().map(meta -> getResource(meta).get()).collect(Collectors.toList())).build();
  }

  private Resource<HasMetadata> getResource(HasMetadata resource) {
    ResourceHandler<HasMetadata, ?> handler = NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl.handlerOf(resource, context);
    return handler.operation(context.getClient(), context.getConfig(), null).newInstance(context.withItem(resource));
  }

  @Override
  public Boolean delete(KubernetesList... lists) {
    return delete(Arrays.asList(lists));
  }

  @Override
  public Boolean delete(List<KubernetesList> lists) {
    for (KubernetesList list : lists) {
      for (HasMetadata item : list.getItems()) {
        if (!getResource(item).delete()) {
           return false;
        }
      }
    }
    return true;
  }

  @Override
  public Gettable<KubernetesList> fromServer() {
    return new KubernetesListOperationsImpl(context.withReloadingFromServer(true), deletingExisting);
  }

  @Override
  public Createable<KubernetesList> deletingExisting() {
    return new KubernetesListOperationsImpl(context, true);
  }

  private List<HasMetadata> createItemsInKubernetesList(KubernetesList list) {
    List<HasMetadata> createdItems = new ArrayList<>();
    for (HasMetadata r : list.getItems()) {
      HasMetadata created = getResource(r).create(r);
      createdItems.add(created);
    }
    return createdItems;
  }
}
