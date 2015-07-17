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
package io.fabric8.kubernetes.client.internal;

import com.ning.http.client.AsyncHttpClient;
import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.NamedResource;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class NonNamespacedResourceList<T extends HasMetadata, L extends KubernetesResourceList, B extends Builder<T>, D extends Doneable<T>>
  extends DefaultResourceList<T, L, B, D>
  implements io.fabric8.kubernetes.client.NonNamespacedResourceList<T, L, B, D> {

  public NonNamespacedResourceList(AsyncHttpClient httpClient, URL rootUrl, String resourceT, Class<T> clazz, Class<L> listClazz, Class<B> builderClazz, Class<D> updateableClazz) {
    super(httpClient, rootUrl, resourceT, clazz, listClazz, builderClazz, updateableClazz);
  }

  @Override
  public NamedResource<T, B, D> withName(String name) throws KubernetesClientException {
    try {
      return new io.fabric8.kubernetes.client.internal.NamedResource<T, B, D>(name, this);
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Malformed resource URL", e);
    }
  }

  @Override
  public T create(T resource) throws KubernetesClientException {
    try {
      return handleCreate(resource);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw new KubernetesClientException("Unable to create resource", e);
    }
  }

  @Override
  public D createNew() throws KubernetesClientException {
    final Visitor<T> visitor = new Visitor<T>() {
      @Override
      public void visit(T resource) {
        try {
          create(resource);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    };

    try {
      return getDoneableClazz().getDeclaredConstructor(Visitor.class).newInstance(visitor);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw new KubernetesClientException("Unable create doneable.", e);
    }
  }

}
