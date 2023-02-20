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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.ListMeta;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetricsBuilder;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetricsList;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetricsListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class PodMetricsTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testMetrics() {
    // Given
    server.expect().withPath("/apis/metrics.k8s.io/v1beta1/pods/the-pod").andReturn(HTTP_OK,
        new PodMetricsListBuilder().addToItems(new PodMetricsBuilder()
            .withNewMetadata().withName("the-metric").endMetadata()
            .build()).build())
        .once();
    // When
    final PodMetricsList result = client.top().pods().withName("the-pod").metrics();
    // Then
    assertThat(result)
        .extracting(PodMetricsList::getItems).asList().singleElement()
        .hasFieldOrPropertyWithValue("Kind", "PodMetrics")
        .hasFieldOrPropertyWithValue("metadata.name", "the-metric");
  }

  @Test
  void testMetricsInNamespace() {
    // Given
    server.expect().withPath("/apis/metrics.k8s.io/v1beta1/namespaces/the-namespace/pods/the-pod")
        .andReturn(HTTP_OK, new PodMetricsListBuilder().addToItems(new PodMetricsBuilder()
            .withNewMetadata().withName("the-metric").endMetadata()
            .build()).build())
        .once();
    // When
    final PodMetricsList result = client.top().pods().inNamespace("the-namespace").withName("the-pod").metrics();
    // Then
    assertThat(result)
        .extracting(PodMetricsList::getItems).asList().singleElement()
        .hasFieldOrPropertyWithValue("Kind", "PodMetrics")
        .hasFieldOrPropertyWithValue("metadata.name", "the-metric");
  }

  @Test
  void testInform() {
    // Given
    server.expect().withPath("/apis/metrics.k8s.io/v1beta1/pods?resourceVersion=0").andReturn(HTTP_OK,
        new PodMetricsListBuilder().withMetadata(new ListMeta()).build()).once();
    server.expect().withPath("/apis/metrics.k8s.io/v1beta1/pods?timeoutSeconds=600&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .done()
        .once();
    // When
    try (SharedIndexInformer<PodMetrics> result = client.resources(PodMetrics.class).inAnyNamespace().inform()) {
      // Then
      assertThat(result).isNotNull();
    }
  }
}
