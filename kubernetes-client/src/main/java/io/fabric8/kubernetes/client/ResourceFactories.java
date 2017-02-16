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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

import io.fabric8.kubernetes.client.dsl.Resource;


public final class ResourceFactories {

  private static final Set<ClassLoader> CLASS_LOADERS = new HashSet<>();
  private static final Map<Class, ResourceFactory> RESOURCE_FACTORY_MAP = new HashMap<>();

  private ResourceFactories() {
    //Utility
  }

  static {
    //Register factories
    discoverHandlers(ResourceHandler.class.getClassLoader());
  }

  public static <R extends Resource> void register(ResourceFactory<R> factory) {
    RESOURCE_FACTORY_MAP.put(factory.getResourceType(), factory);
  }

  public static <R extends Resource> void unregister(ResourceFactory<R> factory) {
    RESOURCE_FACTORY_MAP.remove(factory.getResourceType());
  }

  public static <R extends Resource> ResourceFactory<R> get(Class<R> operationType) {
    if (RESOURCE_FACTORY_MAP.containsKey(operationType)) {
      return RESOURCE_FACTORY_MAP.get(operationType);
    } else {
      for (ResourceFactory factory : ServiceLoader.load(ResourceFactory.class, Thread.currentThread().getContextClassLoader())) {
        if (factory.getResourceType().equals(operationType)) {
          return factory;
        }
      }
      return null;
    }
  }

  private static void discoverHandlers(ClassLoader classLoader) {
    if (classLoader != null && CLASS_LOADERS.add(classLoader)) {
      for (ResourceFactory factory : ServiceLoader.load(ResourceFactory.class, classLoader)) {
        register(factory);
      }
    }
  }
}
