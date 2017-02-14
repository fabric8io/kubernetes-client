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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

import okhttp3.OkHttpClient;

public final class Adapters {

  private static final Logger LOGGER = LoggerFactory.getLogger(Adapters.class);

  private static final Set<ClassLoader> CLASS_LOADERS = new HashSet<>();
  private static final Map<Class, ExtensionAdapter> EXTENSION_ADAPTER_MAP = new HashMap<>();

  private static final ExtensionAdapter<OkHttpClient> OK_HTTP_CLIENT_EXTENSION_ADAPTER = new ExtensionAdapter<OkHttpClient>() {

    @Override
    public Class<OkHttpClient> getExtensionType() {
      return OkHttpClient.class;
    }

    @Override
    public Boolean isAdaptable(Client client) {
      return client instanceof HttpClientAware;
    }

    @Override
    public OkHttpClient adapt(Client client) {
      if (client instanceof HttpClientAware) {
        return ((HttpClientAware)client).getHttpClient().newBuilder().build();
      }
      throw new IllegalArgumentException("This adapter only supports instances of HttpClientAware.");
    }
  };

  static {
    //Register adapters
    discoverServices(Adapters.class.getClassLoader());
    register(OK_HTTP_CLIENT_EXTENSION_ADAPTER);
  }

  private Adapters() {
    //Utility
  }

  public static <C> void register(ExtensionAdapter<C> adapter) {
    EXTENSION_ADAPTER_MAP.put(adapter.getExtensionType(), adapter);
  }

  public static <C> void unregister(ExtensionAdapter<C> adapter) {
    EXTENSION_ADAPTER_MAP.remove(adapter.getExtensionType());
  }

  public static <C> ExtensionAdapter<C> get(Class<C> type) {
    if (EXTENSION_ADAPTER_MAP.containsKey(type)) {
      return EXTENSION_ADAPTER_MAP.get(type);
    } else {

      try {
        for (ExtensionAdapter adapter : ServiceLoader.load(ExtensionAdapter.class, ExtensionAdapter.class.getClassLoader())) {
          if (adapter.getExtensionType().equals(type)) {
            return adapter;
          }
        }
      } catch (Throwable t) {
        LOGGER.warn("Can't read ExtensionAdapter using the ExtensionAdapter class loader. Falling back to type class loader");
      }

      try {
        for (ExtensionAdapter adapter : ServiceLoader.load(ExtensionAdapter.class, type.getClassLoader())) {
          if (adapter.getExtensionType().equals(type)) {
            return adapter;
          }
        }
      } catch (Throwable t) {
        LOGGER.warn("Can't read ExtensionAdapter using type class loader. Falling back to Thread context class loader");
      }

      try {
        for (ExtensionAdapter adapter : ServiceLoader.load(ExtensionAdapter.class, Thread.currentThread().getContextClassLoader())) {
          if (adapter.getExtensionType().equals(type)) {
            return adapter;
          }
        }
      } catch (Throwable t) {
        LOGGER.error("Can't read ExtensionAdapter using type Thread context class loader.");
      }
      return null;
    }
  }

  public static <C> Collection<ExtensionAdapter<? extends C>> list(Class<C> type) {
    List<ExtensionAdapter<? extends C>> result = new ArrayList<>();
    for (ExtensionAdapter candidate : EXTENSION_ADAPTER_MAP.values()) {
        if (type.isAssignableFrom(candidate.getExtensionType())) {
            result.add(candidate);
        }
    }
    return result;
  }

  private static void discoverServices(ClassLoader classLoader) {
    if (classLoader != null && CLASS_LOADERS.add(classLoader)) {
      for (ExtensionAdapter adapter : ServiceLoader.load(ExtensionAdapter.class, classLoader)) {
        register(adapter);
      }
    }
  }
}
