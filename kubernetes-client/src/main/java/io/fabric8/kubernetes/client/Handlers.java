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

package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.model.APIResourceList;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.dsl.NamespacedInOutCreateable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import io.fabric8.kubernetes.client.utils.Serialization;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public final class Handlers {

  private static final Map<Class<?>, ResourceHandler<?, ?>> RESOURCE_HANDLER_MAP = new ConcurrentHashMap<>();
  private static final Map<List<String>, ResourceDefinitionContext> GENERIC_RESOURCE_HANDLER_MAP = new ConcurrentHashMap<>();
  
  private Handlers() {
    //Utility
  }

  public static <T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>> void register(Class<T> type, Function<ClientState, HasMetadataOperation<T, L, R>> operationConstructor) {
    if (RESOURCE_HANDLER_MAP.put(type, new ResourceHandlerImpl(type, operationConstructor)) != null) {
      throw new AssertionError(String.format("%s already registered", type.getName()));
    }
  }
  
  public static <T extends HasMetadata> void unregister(Class<T> type) {
    RESOURCE_HANDLER_MAP.remove(type);
  }
  
  /**
   * Returns a {@link ResourceHandler} for the given item.  The client is optional, if it is supplied, then the server can be 
   * consulted for resource metadata if a generic item is passed in. 
   */
  public static <T extends HasMetadata, V extends VisitableBuilder<T, V>> ResourceHandler<T, V> get(T meta, BaseClient client) {
    Class<T> type = (Class<T>)meta.getClass();
    
    if (type.equals(GenericKubernetesResource.class)) {
      ResourceDefinitionContext rdc = getResourceDefinitionContext((GenericKubernetesResource)meta, client);
      
      if (rdc != null) {
        return new ResourceHandlerImpl(GenericKubernetesResource.class, GenericKubernetesResourceList.class, rdc);
      }
    }
    
    return get(type);
  }
  
  public static ResourceDefinitionContext getResourceDefinitionContext(String apiVersion, String kind, BaseClient client) {
    GenericKubernetesResource resource = new GenericKubernetesResource();
    resource.setKind(kind);
    resource.setApiVersion(apiVersion);
    return getResourceDefinitionContext(resource, client);
  }

  public static <T extends HasMetadata> ResourceDefinitionContext getResourceDefinitionContext(GenericKubernetesResource meta, BaseClient client) {
    // check if it's built-in
    Object value = Serialization.unmarshal(Serialization.asJson(meta));
    Class<T> parsedType = (Class<T>) value.getClass();
    
    ResourceDefinitionContext rdc = null;
    if (!parsedType.equals(GenericKubernetesResource.class)) {
      rdc = ResourceDefinitionContext.fromResourceType(parsedType);
    } else if (client != null) {
      // if a client has been supplied, we can try to look this up from the server
      String kind = meta.getKind();
      String apiVersion = meta.getApiVersion();
      if (kind == null || apiVersion == null) {
        return null;
      }
      String api = ApiVersionUtil.trimGroupOrNull(apiVersion);
      if (api == null) {
        return null;
      }
      String version = ApiVersionUtil.trimVersion(apiVersion);
      // assume that resource metadata won't change for the lifetime of the client
      rdc = GENERIC_RESOURCE_HANDLER_MAP.computeIfAbsent(Arrays.asList(kind, apiVersion), k -> {
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

  private static <T extends HasMetadata, V extends VisitableBuilder<T, V>> ResourceHandler<T, V> get(Class<T> type) {
    if (type.equals(GenericKubernetesResource.class)) {
      return null;
    }
    return (ResourceHandler<T, V>) RESOURCE_HANDLER_MAP.computeIfAbsent(type, k -> new ResourceHandlerImpl<>(type, null));
  }
  
  public static <T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>> HasMetadataOperation<T, L, R> getOperation(Class<T> type, Class<L> listType, ClientState clientState) {
    ResourceHandler<T, ?> resourceHandler = get(type);
    if (resourceHandler == null) {
      throw new IllegalStateException();
    }
    return (HasMetadataOperation<T, L, R>) resourceHandler.operation(clientState, listType);
  }
  
  public static <T extends HasMetadata> HasMetadataOperation<T, ?, Resource<T>> getNonListingOperation(Class<T> type, ClientState clientState) {
    return getOperation(type, KubernetesResourceUtil.inferListType(type), clientState);
  }
  
  public static <T extends HasMetadata> boolean shouldRegister(Class<T> type) {
    ResourceHandler<?, ?> handler = RESOURCE_HANDLER_MAP.get(type);
    return !RESOURCE_HANDLER_MAP.isEmpty() && (handler == null || !handler.hasOperation());
  }

  public static <T extends HasMetadata> NamespacedInOutCreateable<T, T> getNamespacedHasMetadataCreateOnlyOperation(Class<T> type, ClientState clientState) {
    HasMetadataOperation<T, ?, Resource<T>> operation = getNonListingOperation(type, clientState);
    return operation::inNamespace;
  }
  
}
