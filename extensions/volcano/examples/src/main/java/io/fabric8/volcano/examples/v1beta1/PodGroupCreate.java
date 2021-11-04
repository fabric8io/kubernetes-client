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
package io.fabric8.volcano.examples.v1beta1;

import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.QuantityBuilder;
import io.fabric8.volcano.client.DefaultVolcanoClient;
import io.fabric8.volcano.client.NamespacedVolcanoClient;
import io.fabric8.volcano.scheduling.v1beta1.PodGroup;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupBuilder;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupList;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class PodGroupCreate {
  public static void main(String[] args) {
    try (NamespacedVolcanoClient volcanoClient = new DefaultVolcanoClient()) {
      String namespace = "default";
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
      PodGroup podGroup = new PodGroupBuilder()
        .editOrNewMetadata()
        .withName("group1")
        .withNamespace(namespace)
        .endMetadata()
        .editOrNewSpec()
        .withMinResources(resourceMap)
        .endSpec()
        .build();

      // Create PodGroup
      volcanoClient.v1beta1().PodGroups().inNamespace(namespace).createOrReplace(podGroup);
      System.out.println("Created: " + podGroup.getMetadata().getName());

      // Wait for status or 5s timeout
      volcanoClient.v1beta1().PodGroups().inNamespace(namespace).withName("group1").waitUntilCondition(
        group -> Objects.nonNull(group.getStatus()) && group.getStatus().getPhase().equals("Running"),
        5,
        TimeUnit.SECONDS
      );
      System.out.println("Created: " + podGroup.getMetadata().getName());

      // List PodGroup
      PodGroupList podGroupList = volcanoClient.v1beta1().PodGroups().inNamespace(namespace).list();
      System.out.println("There are " + podGroupList.getItems().size() + " PodGroup objects in " + namespace);

      // Delete PodGroup
      volcanoClient.v1beta1().PodGroups().inNamespace(namespace).withName("group1").delete();
    }
  }
}
