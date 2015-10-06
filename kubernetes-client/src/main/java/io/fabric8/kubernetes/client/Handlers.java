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

import io.fabric8.kubernetes.api.model.HasMetadata;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public final class Handlers {

  private static final Map<String, ResourceHandler> RESOURCE_HANDLER_MAP = new HashMap<>();

  private Handlers() {
    //Utility
  }

  static {
    //Register handlers
    for (ResourceHandler handler : ServiceLoader.load(ResourceHandler.class)) {
      register(handler);
    }
  }

  public static <T extends HasMetadata, C extends Client> void register(ResourceHandler<T> handler) {
    RESOURCE_HANDLER_MAP.put(handler.getKind().toLowerCase(), handler);
  }

  public static <T extends HasMetadata, C extends Client> void unregister(ResourceHandler<T> handler) {
    RESOURCE_HANDLER_MAP.remove(handler.getKind().toLowerCase());
  }

  public static <T extends HasMetadata, C extends Client> ResourceHandler<T> get(String kind) {
    return RESOURCE_HANDLER_MAP.get(kind.toLowerCase());
  }
}
