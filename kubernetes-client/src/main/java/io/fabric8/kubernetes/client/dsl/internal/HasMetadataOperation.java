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

import com.ning.http.client.AsyncHttpClient;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;

import java.net.URL;

public class HasMetadataOperation<T extends HasMetadata, L extends KubernetesResourceList, D extends Doneable<T>, R extends Resource<T, D, Void, Boolean>> extends BaseOperation<T,L,D,R> {

  protected HasMetadataOperation(AsyncHttpClient httpClient, URL rootUrl, String resourceT, String namespace, String name) {
    super(httpClient, rootUrl, resourceT, namespace, name);
  }

  protected HasMetadataOperation(AsyncHttpClient httpClient, URL rootUrl, String resourceT, String namespace, String name, Class<T> type, Class<L> listType, Class<D> doneableType) {
    super(httpClient, rootUrl, resourceT, namespace, name, type, listType, doneableType);
  }

  @Override
  public T update(T item) {
    try {
      T old = get();
      String resourceVersion = old.getMetadata().getResourceVersion();
      item.getMetadata().setResourceVersion(resourceVersion);
      return handleUpdate(getResourceUrl(), item);
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }
}
