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

package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
import io.fabric8.kubernetes.client.extension.ExtensibleResourceAdapter;
import io.fabric8.kubernetes.client.extension.ExtensionAdapter;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;

import java.util.Collections;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Holds the registration of {@link ExtensionAdapter}s and their associated Clients and Resources
 *
 * TODO: the design matches the old - a flat hierarcy. However there are really two types of
 * of clients extension roots, and then client adapters under that. We could be more hierarchical
 * about this - such as only allowing adapting to the sub when already a parent type (or automatically converting)
 *
 */
public final class Adapters {

  private final Set<ClassLoader> classLoaders = Collections.newSetFromMap(new ConcurrentHashMap<>());
  private final Map<Class<?>, ExtensionAdapter<?>> extensionAdapters = new ConcurrentHashMap<>();
  private final Handlers handlers;

  public Adapters(Handlers handlers) {
    this.handlers = handlers;
    discoverServices(Adapters.class.getClassLoader());
    discoverServices(Thread.currentThread().getContextClassLoader());
  }

  public <T extends Client, C extends ClientAdapter<C>> void registerClient(Class<T> type, ClientAdapter<C> target) {
    if (!type.isAssignableFrom(target.getClass())) {
      throw new IllegalArgumentException("The adapter should implement the type");
    }
    if (target.getClient() != null) {
      throw new IllegalArgumentException("The client adapter should already be initialized");
    }
    ExtensionAdapter<C> adapter = new ExtensionAdapter<C>() {

      @Override
      public Class getExtensionType() {
        return type;
      }

      @Override
      public C adapt(Client client) {
        C result = target.newInstance();
        result.init(client);
        return result;
      }

    };
    extensionAdapters.put(type, adapter);
    // some of the old extension adapters were inconsistent - and
    // specified the client class, rather than the dsl/interface
    // alternatively - we could just leave the type blank and scan the class hierarchy
    extensionAdapters.put(target.getClass(), adapter);
  }

  public <C extends Client> void register(ExtensionAdapter<C> adapter) {
    if (extensionAdapters.putIfAbsent(adapter.getExtensionType(), adapter) == null) {
      adapter.registerResources(this::registerResource);
      adapter.registerClients(this::registerClient);
      if (adapter instanceof InternalExtensionAdapter) {
        ((InternalExtensionAdapter) adapter).registerHandlers(handlers);
      }
    }
  }

  public <C extends Client> void unregister(ExtensionAdapter<C> adapter) {
    extensionAdapters.remove(adapter.getExtensionType());
    // TODO: remove handlers and other state
  }

  public <C extends Client> ExtensionAdapter<C> get(Class<C> type) {
    discoverServices(type.getClassLoader());
    return (ExtensionAdapter<C>) extensionAdapters.get(type);
  }

  private void discoverServices(ClassLoader classLoader) {
    if (classLoader != null && classLoaders.add(classLoader)) {
      for (ExtensionAdapter<?> adapter : ServiceLoader.load(ExtensionAdapter.class, classLoader)) {
        register(adapter);
      }
    }
  }

  public <T extends HasMetadata, R extends ExtensibleResourceAdapter<T>> void registerResource(
      Class<T> type, R target) {
    ResourceDefinitionContext definitionContest = ResourceDefinitionContext.fromResourceType(type);
    Class<? extends KubernetesResourceList> listType = KubernetesResourceUtil.inferListType(type);
    handlers.register(type,
        c -> new ResourcedHasMetadataOperation<>(HasMetadataOperationsImpl.defaultContext(c),
            definitionContest, type,
            listType, target));
  }

}
