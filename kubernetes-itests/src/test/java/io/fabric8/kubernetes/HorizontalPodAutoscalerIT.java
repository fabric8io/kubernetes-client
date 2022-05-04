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

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscaler;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@LoadKubernetesManifests("/horizontalpodautoscaler-it.yml")
class HorizontalPodAutoscalerIT {

  KubernetesClient client;

  @Test
  void hpaWithScalingDisabled() {
    final HorizontalPodAutoscaler result = client.autoscaling().v1().horizontalPodAutoscalers()
        .withName("horizontal-pod-autoscaler").get();
    assertThat(result)
        .extracting(HorizontalPodAutoscaler::getStatus)
        .hasFieldOrPropertyWithValue("currentReplicas", 0)
        .hasFieldOrPropertyWithValue("desiredReplicas", 0);
  }
}
