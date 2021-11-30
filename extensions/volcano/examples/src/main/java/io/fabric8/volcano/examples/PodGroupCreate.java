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

import io.fabric8.volcano.client.DefaultVolcanoClient;
import io.fabric8.volcano.client.NamespacedVolcanoClient;
import io.fabric8.volcano.scheduling.v1beta1.PodGroup;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupList;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class PodGroupCreate {
  public static void main(String[] args) {
    try (NamespacedVolcanoClient volcanoClient = new DefaultVolcanoClient()) {
      String namespace = "default";
      String groupName = "group1";
      PodGroup podGroup = Utils.buildDefaultPodGroups(namespace, groupName);

      // Create PodGroup
      volcanoClient.podGroups().inNamespace(namespace).createOrReplace(podGroup);
      System.out.println("Created: " + podGroup.getMetadata().getName());

      // Wait for status or 5s timeout
      volcanoClient.podGroups().inNamespace(namespace).withName(groupName).waitUntilCondition(
        group -> Objects.nonNull(group.getStatus()) && group.getStatus().getPhase().equals("Running"),
        5,
        TimeUnit.SECONDS
      );
      System.out.println("Created: " + podGroup.getMetadata().getName());

      // List PodGroup
      PodGroupList podGroupList = volcanoClient.podGroups().inNamespace(namespace).list();
      System.out.println("There are " + podGroupList.getItems().size() + " PodGroup objects in " + namespace);

      // Delete PodGroup
      volcanoClient.podGroups().inNamespace(namespace).withName(groupName).delete();
    }
  }
}
