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

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.model.APIResourceList;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.NamespacedInOutCreateable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public final class Handlers {

  private final Map<Class<?>, ResourceHandler<?, ?>> resourceHandlers = new ConcurrentHashMap<>();
  private final Map<List<String>, ResourceDefinitionContext> genericDefinitions = new ConcurrentHashMap<>();

  public <T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>> void register(Class<T> type,
      Function<Client, HasMetadataOperation<T, L, R>> operationConstructor) {
    if (resourceHandlers.put(type, new ResourceHandlerImpl(type, operationConstructor)) != null) {
      throw new AssertionError(String.format("%s already registered", type.getName()));
    }
  }

  public <T extends HasMetadata> void unregister(Class<T> type) {
    resourceHandlers.remove(type);
  }

  /**
   * Returns a {@link ResourceHandler} for the given item. The client is optional, if it is supplied, then the server can be
   * consulted for resource metadata if a generic item is passed in.
   *
   * @return the handler
   * @throws KubernetesClientException if a handler cannot be found
   */
  public <T extends HasMetadata, V extends VisitableBuilder<T, V>> ResourceHandler<T, V> get(T meta, Client client) {
    Class<T> type = (Class<T>) meta.getClass();

    if (type.equals(GenericKubernetesResource.class)) {
      GenericKubernetesResource gkr = (GenericKubernetesResource) meta;
      ResourceDefinitionContext rdc = getResourceDefinitionContext(gkr.getApiVersion(), gkr.getKind(), client);

      if (rdc != null) {
        return new ResourceHandlerImpl(GenericKubernetesResource.class, GenericKubernetesResourceList.class, rdc);
      }
    }

    ResourceHandler<T, V> result = get(type);
    if (result == null) {
      throw new KubernetesClientException("Could not find a registered handler for item: [" + meta + "].");
    }
    return result;
  }

  public ResourceDefinitionContext getResourceDefinitionContext(String apiVersion, String kind,
      Client client) {
    // check if it's built-in
    Class<? extends KubernetesResource> clazz = client.adapt(BaseClient.class).getKubernetesSerialization()
        .getRegisteredKubernetesResource(apiVersion, kind);

    ResourceDefinitionContext rdc = null;
    if (clazz != null) {
      rdc = ResourceDefinitionContext.fromResourceType(clazz);
    } else {
      // if a client has been supplied, we can try to look this up from the server
      if (kind == null || apiVersion == null) {
        return null;
      }
      String api = ApiVersionUtil.trimGroupOrNull(apiVersion);
      if (api == null) {
        return null;
      }
      String version = ApiVersionUtil.trimVersion(apiVersion);
      // assume that resource metadata won't change for the lifetime of the client
      rdc = genericDefinitions.computeIfAbsent(Arrays.asList(kind, apiVersion), k -> {
        APIResourceList resourceList = client.getApiResources(apiVersion);
        if (resourceList == null) {
          return null;
        }
        return resourceList.getResources()
            .stream()
            .filter(r -> kind.equals(r.getKind()))
            .findFirst()
            .map(resource -> new ResourceDefinitionContext.Builder().withGroup(api)
                .withKind(kind)
                .withNamespaced(Boolean.TRUE.equals(resource.getNamespaced()))
                .withPlural(resource.getName())
                .withVersion(version)
                .build())
            .orElse(null);
      });
    }
    return rdc;
  }

  private <T extends HasMetadata, V extends VisitableBuilder<T, V>> ResourceHandler<T, V> get(Class<T> type) {
    if (type.equals(GenericKubernetesResource.class)) {
      return null;
    }
    return (ResourceHandler<T, V>) resourceHandlers.computeIfAbsent(type, k -> new ResourceHandlerImpl<>(type, null));
  }

  public <T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>> HasMetadataOperation<T, L, R> getOperation(
      Class<T> type, Class<L> listType, Client client) {
    ResourceHandler<T, ?> resourceHandler = get(type);
    if (resourceHandler == null) {
      throw new IllegalStateException();
    }
    return (HasMetadataOperation<T, L, R>) resourceHandler.operation(client, listType);
  }

  public <T extends HasMetadata> HasMetadataOperation<T, ?, Resource<T>> getNonListingOperation(Class<T> type, Client client) {
    return getOperation(type, KubernetesResourceUtil.inferListType(type), client);
  }

  public <T extends HasMetadata> NamespacedInOutCreateable<T, T> getNamespacedHasMetadataCreateOnlyOperation(Class<T> type,
      Client client) {
    HasMetadataOperation<T, ?, Resource<T>> operation = getNonListingOperation(type, client);
    return operation::inNamespace;
  }

}
