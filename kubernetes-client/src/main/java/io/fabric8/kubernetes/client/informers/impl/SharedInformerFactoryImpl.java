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
package io.fabric8.kubernetes.client.informers.impl;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Informable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.SharedInformerEventListener;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;

/**
 * SharedInformerFactory class constructs and caches informers for api types.
 *
 * This has been taken from
 * https://github.com/kubernetes-client/java/blob/master/util/src/main/java/io/kubernetes/client/informer/SharedInformerFactory.java
 * which is ported from official go client https://github.com/kubernetes/client-go/blob/master/informers/factory.go
 */
public class SharedInformerFactoryImpl implements SharedInformerFactory {
  private static final Logger log = LoggerFactory.getLogger(SharedInformerFactoryImpl.class);

  private final List<SharedIndexInformer<?>> informers = new ArrayList<>();

  private final ConcurrentLinkedQueue<SharedInformerEventListener> eventListeners = new ConcurrentLinkedQueue<>();

  private String name;
  private String namespace;

  private KubernetesClient client;

  public SharedInformerFactoryImpl(KubernetesClient client) {
    this.client = client;
  }

  @Override
  public SharedInformerFactory inNamespace(String namespace) {
    this.namespace = namespace;
    return this;
  }

  @Override
  public SharedInformerFactory withName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public synchronized <T extends HasMetadata> SharedIndexInformer<T> sharedIndexInformerFor(Class<T> apiTypeClass,
      long resyncPeriodInMillis) {
    MixedOperation<T, KubernetesResourceList<T>, Resource<T>> resources = client.resources(apiTypeClass);

    Informable<T> informable = null;

    if (namespace != null) {
      NonNamespaceOperation<T, KubernetesResourceList<T>, Resource<T>> nonNamespaceOp = resources.inNamespace(namespace);
      informable = nonNamespaceOp;
      if (name != null) {
        informable = nonNamespaceOp.withName(name);
      }
    } else if (name != null) {
      informable = resources.withName(name);
    } else {
      informable = resources.inAnyNamespace();
    }

    SharedIndexInformer<T> informer = informable.runnableInformer(resyncPeriodInMillis);
    this.informers.add(informer);
    return informer;
  }

  @Override
  public synchronized <T> SharedIndexInformer<T> getExistingSharedIndexInformer(Class<T> apiTypeClass) {
    for (SharedIndexInformer<?> informer : this.informers) {
      if (informer.getApiTypeClass().equals(apiTypeClass)) {
        return (SharedIndexInformer<T>) informer;
      }
    }
    return null;
  }

  @Override
  public synchronized Future<Void> startAllRegisteredInformers() {
    List<CompletableFuture<Void>> startInformerTasks = new ArrayList<>();

    if (!informers.isEmpty()) {
      for (SharedIndexInformer<?> informer : informers) {
        CompletableFuture<Void> future = informer.start();
        startInformerTasks.add(future);
        future.whenComplete((v, t) -> {
          if (t != null) {
            if (this.eventListeners.isEmpty()) {
              log.warn("Failed to start informer", t);
            } else {
              this.eventListeners
                  .forEach(listener -> listener.onException(informer, KubernetesClientException.launderThrowable(t)));
            }
          }
        });
      }
    }
    return CompletableFuture.allOf(startInformerTasks.toArray(new CompletableFuture[] {}));
  }

  @Override
  public synchronized void stopAllRegisteredInformers() {
    informers.forEach(SharedIndexInformer::stop);
  }

  @Override
  public void addSharedInformerEventListener(SharedInformerEventListener event) {
    this.eventListeners.add(event);
  }

}
