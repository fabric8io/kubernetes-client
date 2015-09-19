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

public final class Creators {

  private static final Map<Class, ResourceCreator> RESOURCE_CREATOR_MAP = new HashMap<>();

  private Creators() {
    //Utility
  }

  static {
    //Register creators
    for (ResourceCreator creator : ServiceLoader.load(ResourceCreator.class)) {
      register(creator);
    }
  }

  public static <T extends HasMetadata, C extends Client> void register(ResourceCreator<T> creator) {
    RESOURCE_CREATOR_MAP.put(creator.getKind(), creator);
  }

  public static <T extends HasMetadata, C extends Client> void unregister(ResourceCreator<T> creator) {
    RESOURCE_CREATOR_MAP.remove(creator.getKind());
  }

  public static <T extends HasMetadata, C extends Client> ResourceCreator<T> get(Class<T> type) {
    return RESOURCE_CREATOR_MAP.get(type);
  }

}
