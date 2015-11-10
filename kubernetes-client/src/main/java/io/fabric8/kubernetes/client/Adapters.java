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
import java.util.Map;
import java.util.ServiceLoader;

public final class Adapters {

  private static final Map<Class, ExtensionAdapter> EXTENSION_ADAPTER_MAP = new HashMap<>();

  private Adapters() {
    //Utility
  }

  static {
    //Register adapters
    for (ExtensionAdapter adapter : ServiceLoader.load(ExtensionAdapter.class)) {
      register(adapter);
    }
  }

  public static <C> void register(ExtensionAdapter<C> adapter) {
    EXTENSION_ADAPTER_MAP.put(adapter.getExtensionType(), adapter);
  }

  public static <C> void unregister(ExtensionAdapter<C> adapter) {
    EXTENSION_ADAPTER_MAP.remove(adapter.getExtensionType());
  }

  public static <C> ExtensionAdapter<C> get(Class<C> type) {
    return EXTENSION_ADAPTER_MAP.get(type);
  }
}
