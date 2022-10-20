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
package io.fabric8.verticalpodautoscaler.examples.v1;

import io.fabric8.verticalpodautoscaler.api.model.v1.VerticalPodAutoscaler;
import io.fabric8.verticalpodautoscaler.api.model.v1.VerticalPodAutoscalerBuilder;
import io.fabric8.verticalpodautoscaler.api.model.v1.VerticalPodAutoscalerList;
import io.fabric8.verticalpodautoscaler.client.DefaultVerticalPodAutoscalerClient;
import io.fabric8.verticalpodautoscaler.client.NamespacedVerticalPodAutoscalerClient;

public class VerticalPodAutoscalerCreate {
  public static void main(String[] args) {
    try (NamespacedVerticalPodAutoscalerClient verticalPodAutoscalerClient = new DefaultVerticalPodAutoscalerClient()) {
      String namespace = "default";

      VerticalPodAutoscaler verticalPodAutoscaler = new VerticalPodAutoscalerBuilder()
          .build();

      // Create VerticalPodAutoscaler
      verticalPodAutoscalerClient.v1().verticalpodautoscalers().inNamespace(namespace).create(verticalPodAutoscaler);
      System.out.println("Created: " + verticalPodAutoscaler.getMetadata().getName());

      // List VerticalPodAutoscaler
      VerticalPodAutoscalerList verticalPodAutoscalerList = verticalPodAutoscalerClient.v1().verticalpodautoscalers()
          .inNamespace(namespace).list();
      System.out.println(
          "There are " + verticalPodAutoscalerList.getItems().size() + " VerticalPodAutoscaler objects in " + namespace);
    }
  }
}
