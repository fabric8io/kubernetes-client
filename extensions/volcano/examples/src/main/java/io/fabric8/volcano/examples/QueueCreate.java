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
import io.fabric8.volcano.scheduling.v1beta1.Queue;
import io.fabric8.volcano.scheduling.v1beta1.QueueList;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class QueueCreate {
  public static void main(String[] args) {
    try (NamespacedVolcanoClient volcanoClient = new DefaultVolcanoClient()) {

      String queueName = "queue1";
      Queue queue = Utils.buildDefaultQueues(queueName);

      volcanoClient.queues().createOrReplace(queue);

      // Wait for status or 5s timeout
      volcanoClient.queues().withName(queueName).waitUntilCondition(
          q -> Objects.nonNull(q.getStatus()) && q.getStatus().getState().equals("Open"),
          5,
          TimeUnit.SECONDS);
      System.out.println("Created: " + queue.getMetadata().getName());

      // List queue
      QueueList queueList = volcanoClient.queues().list();
      System.out.println("There are " + queueList.getItems().size() + " queue objects");

      // Delete queue
      volcanoClient.queues().withName(queueName).delete();
    }
  }
}
