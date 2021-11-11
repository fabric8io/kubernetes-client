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
package io.fabric8.volcano.examples;

import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.QuantityBuilder;
import io.fabric8.volcano.scheduling.v1beta1.PodGroup;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupBuilder;

import java.util.HashMap;
import java.util.Map;

public class Utils {

  private Utils() {
  }

  public static PodGroup buildDefaultPodGroups(String namespace, String groupName) {
    Quantity cpu = new QuantityBuilder(false)
      .withAmount("1")
      .build();
    Quantity memory = new QuantityBuilder(false)
      .withAmount("1024")
      .build();
    Map<String, Quantity> resourceMap = new HashMap<>();
    resourceMap.put("cpu", cpu);
    resourceMap.put("memory", memory);

    // Build PodGroup with metadata and spec
    return new PodGroupBuilder()
      .editOrNewMetadata()
      .withName(groupName)
      .withNamespace(namespace)
      .endMetadata()
      .editOrNewSpec()
      .withMinResources(resourceMap)
      .endSpec()
      .build();
  }
}
