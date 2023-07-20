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
package io.fabric8.knative.internal.autoscaling.v1alpha1;

import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PodAutoscalerTest {
  @Test
  void apiVersion() {
    assertThat(new PodAutoscaler().getApiVersion()).isEqualTo("autoscaling.internal.knative.dev/v1alpha1");
  }

  @Test
  void isNamespaceScoped() {
    assertThat(new PodAutoscaler()).isInstanceOf(Namespaced.class);
  }

  @Test
  void builder() {
    // Given
    PodAutoscalerBuilder podAutoscalerBuilder = new PodAutoscalerBuilder()
        .withNewMetadata()
        .withName("test-pod-autoscaler")
        .endMetadata()
        .withNewSpec()
        .withProtocolType("http1")
        .withReachability("Reachable")
        .withNewScaleTargetRef()
        .withApiVersion("apps/v1")
        .withKind("Deployment")
        .withName("test-deploy")
        .endScaleTargetRef()
        .endSpec();

    // When
    PodAutoscaler podAutoscaler = podAutoscalerBuilder.build();

    // Then
    assertThat(podAutoscaler)
        .hasFieldOrPropertyWithValue("metadata.name", "test-pod-autoscaler")
        .hasFieldOrPropertyWithValue("spec.protocolType", "http1")
        .hasFieldOrPropertyWithValue("spec.reachability", "Reachable")
        .hasFieldOrPropertyWithValue("spec.scaleTargetRef.apiVersion", "apps/v1")
        .hasFieldOrPropertyWithValue("spec.scaleTargetRef.kind", "Deployment")
        .hasFieldOrPropertyWithValue("spec.scaleTargetRef.name", "test-deploy");
  }
}
