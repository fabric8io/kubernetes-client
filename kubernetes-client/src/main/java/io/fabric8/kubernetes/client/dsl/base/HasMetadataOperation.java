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

package io.fabric8.kubernetes.client.dsl.base;

import com.squareup.okhttp.OkHttpClient;
import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ClientResource;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

public class HasMetadataOperation<T extends HasMetadata, L extends KubernetesResourceList, D extends Doneable<T>, R extends ClientResource<T, D>>
  extends BaseOperation< T, L, D, R> {

  protected HasMetadataOperation(OkHttpClient client, Config config, String apiGroup, String apiVersion, String resourceT, String namespace, String name, Boolean cascading, T item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds) {
    super(client, config, apiGroup, apiVersion, resourceT, namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  @Override
  public D edit() throws KubernetesClientException {
    final Function<T, T> visitor = new Function<T, T>() {
      @Override
      public T apply(T resource) {
        try {
          if (isCascading() && !isReaping()) {
            if (reaper != null) {
              setReaping(true);
              reaper.reap();
            }
          }
          return replace(resource);
        } catch (Exception e) {
          throw KubernetesClientException.launderThrowable(e);
        }
      }
    };

    try {
      T item = getMandatory();
      return (D) getDoneableType().getDeclaredConstructor(getType(), Function.class).newInstance(item, visitor);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public T replace(T item) {
    Exception caught = null;
    int maxTries = 10;
    for (int i = 0; i < maxTries; i++) {
      try {
        if (isCascading()) {
          if (reaper != null && !isReaping()) {
            setReaping(true);
            reaper.reap();
          }
        }
        T got = get();
        if (got == null) {
          return null;
        }
        item.getMetadata().setResourceVersion(got.getMetadata().getResourceVersion());
        return handleReplace(item);
      } catch (KubernetesClientException e) {
        caught = e;
        // Only retry if there's a conflict - this is normally to do with resource version & server updates.
        if (e.getCode() != 409) {
          break;
        }
        if (i < maxTries - 1) {
          try {
            TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e1) {
            // Ignore this... would only hide the proper exception
          }
        }
      } catch (Exception e) {
        caught = e;
      }
    }
    throw KubernetesClientException.launderThrowable(caught);
  }
}
