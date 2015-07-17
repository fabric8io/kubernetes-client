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

import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.BuilderUpdate;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.NamedNamespacedResource;
import io.fabric8.kubernetes.client.Update;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class NamedResource<T extends HasMetadata, B extends Builder<T>, D extends Doneable<T>>
  extends BaseResource<T, B, D>
  implements io.fabric8.kubernetes.client.NamedResource<T, B, D>,
  NamedNamespacedResource<T, B, D> {

  private URL resourceUrl;

  NamedResource(String name, DefaultResourceList<T, ?, B, D> resourceList) throws MalformedURLException {
    super(resourceList.getHttpClient(), resourceList.getRootUrl(), resourceList.getResourceT(), resourceList.getClazz(), resourceList.getBuilderClazz(), resourceList.getDoneableClazz());
    URL requestUrl = getNamespacedUrl();
    this.resourceUrl = new URL(requestUrl, name);
  }

  NamedResource(String name, NamespacedResourceList<T, ?, B, D> resourceList) throws MalformedURLException {
    super(resourceList.getHttpClient(), resourceList.getRootUrl(), resourceList.getResourceT(), resourceList.getClazz(), resourceList.getBuilderClazz(), resourceList.getDoneableClazz());
    setNamespace(resourceList.getNamespace());
    URL requestUrl = getNamespacedUrl();
    this.resourceUrl = new URL(requestUrl, name);
  }

  @Override
  public T get() throws KubernetesClientException {
    try {
      return handleGet(resourceUrl);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public D edit() throws KubernetesClientException {

    final Visitor<T> visitor = new Visitor<T>() {
      @Override
      public void visit(T resource) {
        try {
          handleUpdate(resourceUrl, resource);
        } catch (Exception e) {
          throw KubernetesClientException.launderThrowable(e);
        }
      }
    };

    try {

      return getDoneableClazz().getDeclaredConstructor(getClazz(), Visitor.class).newInstance(get(), visitor);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public T update(BuilderUpdate<T, B> update) throws KubernetesClientException {
    try {
      T current = this.get();
      T updated = update.apply(getBuilderClazz().getDeclaredConstructor(getClazz()).newInstance(current));
      return handleUpdate(resourceUrl, updated);
    } catch (InterruptedException | ExecutionException | IOException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public T update(Update<T> update) throws KubernetesClientException {
    try {
      T current = this.get();
      T updated = update.apply(current);
      return handleUpdate(resourceUrl, updated);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public void delete() throws KubernetesClientException {
    try {
      handleDelete(resourceUrl);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }
}
