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
import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetricsBuilder;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetricsList;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetricsListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class NodeMetricsTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testMetrics() {
    // Given
    server.expect().withPath("/apis/metrics.k8s.io/v1beta1/nodes/the-node").andReturn(HTTP_OK,
        new NodeMetricsListBuilder().addToItems(new NodeMetricsBuilder()
            .withNewMetadata().withName("the-metric").endMetadata()
            .build()).build())
        .once();
    // When
    final NodeMetricsList result = client.top().nodes().withName("the-node").metrics();
    // Then
    assertThat(result)
        .extracting(NodeMetricsList::getItems).asList().singleElement()
        .hasFieldOrPropertyWithValue("Kind", "NodeMetrics")
        .hasFieldOrPropertyWithValue("metadata.name", "the-metric");
  }

  @Test
  void testInform() {
    // Given
    server.expect().withPath("/apis/metrics.k8s.io/v1beta1/nodes?resourceVersion=0").andReturn(HTTP_OK,
        new NodeMetricsListBuilder().withMetadata(new ListMeta()).build()).once();
    server.expect().withPath("/apis/metrics.k8s.io/v1beta1/nodes?timeoutSeconds=600&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .done()
        .once();
    // When
    try (SharedIndexInformer<NodeMetrics> result = client.resources(NodeMetrics.class).inAnyNamespace().inform()) {
      // Then
      assertThat(result).isNotNull();
    }
  }
}
