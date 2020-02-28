/**
 * Copyright (C) 2015 Fabric8 Authors.
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
import io.fabric8.kubernetes.api.model.HasMetadata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

public final class Handlers {

  private static final Set<ClassLoader> CLASS_LOADERS = new HashSet<>();
  private static final Map<ResourceHandler.Key, ResourceHandler> RESOURCE_HANDLER_MAP = new HashMap<>();

  private Handlers() {
    //Utility
  }

  static {
    //Register handlers
    discoverHandlers(ResourceHandler.class.getClassLoader());
  }

  public static <T extends HasMetadata, V extends VisitableBuilder<T, V>> void register(ResourceHandler<T,V> handler) {
    RESOURCE_HANDLER_MAP.put(new ResourceHandler.Key(handler.getKind().toLowerCase(Locale.ROOT), handler.getApiVersion()), handler);
  }

  public static <T extends HasMetadata, V extends VisitableBuilder<T, V>> void unregister(ResourceHandler<T,V> handler) {
    RESOURCE_HANDLER_MAP.remove(new ResourceHandler.Key(handler.getKind().toLowerCase(Locale.ROOT), handler.getApiVersion()));
  }

  public static <T extends HasMetadata, V extends VisitableBuilder<T, V>> ResourceHandler<T, V> get(String kind, String apiVersion) {
    return get(kind, apiVersion, Thread.currentThread().getContextClassLoader());
  }

  public static <T extends HasMetadata, V extends VisitableBuilder<T, V>> ResourceHandler<T, V> get(String kind, String apiVersion, ClassLoader classLoader) {
   return get(new ResourceHandler.Key(kind.toLowerCase(Locale.ROOT), apiVersion), classLoader);
  }

  public static <T extends HasMetadata, V extends VisitableBuilder<T, V>> ResourceHandler<T, V> get(ResourceHandler.Key key) {
    return get(key, Thread.currentThread().getContextClassLoader());
  }

  public static <T extends HasMetadata, V extends VisitableBuilder<T, V>> ResourceHandler<T, V> get(ResourceHandler.Key key, ClassLoader classLoader) {
    if (RESOURCE_HANDLER_MAP.containsKey(key)) {
      return RESOURCE_HANDLER_MAP.get(key);
    } else {
      //1st pass: match kind and apiVersion
      for (ResourceHandler handler : ServiceLoader.load(ResourceHandler.class, classLoader)) {
        if (handler.getKind().toLowerCase(Locale.ROOT).equals(key.getKind()) && handler.getApiVersion().equals(key.getApiVersion())) {
          return handler;
        }
      }
      //2nd pass: match kind.
      for (ResourceHandler handler : ServiceLoader.load(ResourceHandler.class, classLoader)) {
        if (handler.getKind().toLowerCase(Locale.ROOT).equals(key.getKind())) {
          return handler;
        }
      }
      return null;
    }
  }

  private static void discoverHandlers(ClassLoader classLoader) {
    if (classLoader != null && CLASS_LOADERS.add(classLoader)) {
      for (ResourceHandler handler : ServiceLoader.load(ResourceHandler.class, classLoader)) {
        register(handler);
      }
    }
  }
}
