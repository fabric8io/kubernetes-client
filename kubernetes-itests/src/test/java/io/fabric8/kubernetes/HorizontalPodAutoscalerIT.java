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
package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscaler;
import io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscalerBuilder;
import io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscalerList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
class HorizontalPodAutoscalerIT {

  static KubernetesClient client;

  @BeforeAll
  public static void init() {
    client.load(HorizontalPodAutoscalerIT.class.getResourceAsStream("/horizontalpodautoscaler-it.yml")).create();
  }

  @AfterAll
  public static void cleanup() {
    client.load(HorizontalPodAutoscalerIT.class.getResourceAsStream("/horizontalpodautoscaler-it.yml")).withGracePeriod(0L).delete();
  }

  @Test
  void get() {
    HorizontalPodAutoscaler horizontalPodAutoscaler = client.autoscaling().v1().horizontalPodAutoscalers()
        .withName("horizontalpodautoscaler-get").get();
    assertThat(horizontalPodAutoscaler).isNotNull();
  }

  @Test
  void list() {
    HorizontalPodAutoscalerList aEndpointList = client.autoscaling().v1().horizontalPodAutoscalers()
        .list();
    assertNotNull(aEndpointList);
    assertTrue(aEndpointList.getItems().size() >= 1);
  }

  @Test
  void update() {
    HorizontalPodAutoscaler horizontalPodAutoscaler = client.autoscaling().v1().horizontalPodAutoscalers()
        .withName("horizontalpodautoscaler-update")
        .edit(c -> new HorizontalPodAutoscalerBuilder(c)
            .editOrNewMetadata().addToAnnotations("foo", "bar").endMetadata().build());

    assertNotNull(horizontalPodAutoscaler);
    assertEquals("bar", horizontalPodAutoscaler.getMetadata().getAnnotations().get("foo"));
  }

  @Test
  void delete() {
    assertTrue(client.autoscaling().v1().horizontalPodAutoscalers()
        .withName("horizontalpodautoscaler-delete").delete());
  }
}
