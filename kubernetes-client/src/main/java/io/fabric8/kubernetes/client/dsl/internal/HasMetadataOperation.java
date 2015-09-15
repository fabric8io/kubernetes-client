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
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

public class HasMetadataOperation<K extends KubernetesClient, T extends HasMetadata, L extends KubernetesResourceList, D extends Doneable<T>, R extends ClientResource<T, D>>
  extends BaseOperation<K, T, L, D, R> {

  private static final Logger logger = LoggerFactory.getLogger(HasMetadataOperation.class);

  protected HasMetadataOperation(K client, String resourceT, String namespace, String name, Boolean cascading, T item) {
    super(client, resourceT, namespace, name, cascading, item);
  }

  protected HasMetadataOperation(K client, String resourceT, String namespace, String name, Boolean cascading, T item, Class<K> clientType, Class<T> type, Class<L> listType, Class<D> doneableType) {
    super(client, resourceT, namespace, name, cascading, item, clientType, type, listType, doneableType);
  }

  @Override
  public D edit() throws KubernetesClientException {
    final BaseOperation oper = this;

    final Visitor<T> visitor = new Visitor<T>() {
      @Override
      public void visit(T resource) {
        try {
          if (isCascading() && !isReaping()) {
            Reaper reaper = ReaperFactory.getReaper(oper);
            if (reaper != null) {
              setReaping(true);
              reaper.reap();
            }
          }
          replace(resource);
        } catch (Exception e) {
          throw KubernetesClientException.launderThrowable(e);
        }
      }
    };

    try {
      return (D) getDoneableType().getDeclaredConstructor(getType(), Visitor.class).newInstance(get(), visitor);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public T replace(T item) {
    Exception caught = null;
    int maxTries = 5;
    for (int i = 0; i < maxTries; i++) {
      try {
        if (isCascading()) {
          Reaper reaper = ReaperFactory.getReaper(this);
          if (reaper != null && !isReaping()) {
            setReaping(true);
            reaper.reap();
          }
        }
        item.getMetadata().setResourceVersion(null);
        return handleReplace(getResourceUrl(), item);
      } catch (Exception e) {
        caught = e;
        if (i < maxTries - 1) {
          try {
            TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e1) {
            // Ignore this... would only hide the proper exception
          }
        }
      }
    }
    throw KubernetesClientException.launderThrowable(caught);
  }
}
