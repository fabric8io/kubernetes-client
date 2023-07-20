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

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class MetricTest {
  @Test
  void apiVersion() {
    assertThat(new Metric().getApiVersion()).isEqualTo("autoscaling.internal.knative.dev/v1alpha1");
  }

  @Test
  void isNamespaceScoped() {
    assertThat(new Metric()).isInstanceOf(Namespaced.class);
  }

  @Test
  void builder() {
    // Given
    MetricBuilder metricBuilder = new MetricBuilder()
        .withNewMetadata()
        .withName("test-metric")
        .endMetadata()
        .withNewSpec()
        .withPanicWindow(600000L)
        .withStableWindow(600000L)
        .withScrapeTarget("test-target")
        .endSpec();

    // When
    Metric metric = metricBuilder.build();

    // Then
    assertThat(metric)
        .hasFieldOrPropertyWithValue("metadata.name", "test-metric")
        .hasFieldOrPropertyWithValue("spec.panicWindow", 600000L)
        .hasFieldOrPropertyWithValue("spec.stableWindow", 600000L)
        .hasFieldOrPropertyWithValue("spec.scrapeTarget", "test-target");
  }
}
