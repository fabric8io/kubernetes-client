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

import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetricsBuilder;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetricsList;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetricsListBuilder;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetricsBuilder;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetricsList;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetricsListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableKubernetesMockClient
class MetricsTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testPodMetricsAllNamespace() throws Exception {
    server.expect().get().withPath("/apis/metrics.k8s.io/v1beta1/pods")
        .andReturn(200, new PodMetricsListBuilder().withItems(getPodMetric()).build()).once();

    PodMetricsList podMetricsList = client.top().pods().metrics();
    assertEquals(1, podMetricsList.getItems().size());
    assertEquals("foo", podMetricsList.getItems().get(0).getMetadata().getName());
  }

  @Test
  void testPodMetricsNamespace() throws Exception {
    server.expect().get().withPath("/apis/metrics.k8s.io/v1beta1/namespaces/test/pods")
        .andReturn(200, new PodMetricsListBuilder().withItems(getPodMetric()).build()).once();

    PodMetricsList podMetricsList = client.top().pods().metrics("test");
    assertEquals(1, podMetricsList.getItems().size());
    assertEquals("foo", podMetricsList.getItems().get(0).getMetadata().getName());
  }

  @Test
  void testPodMetricsNamespaceWithName() throws Exception {
    server.expect().get().withPath("/apis/metrics.k8s.io/v1beta1/namespaces/test/pods/test-pod")
        .andReturn(200, getPodMetric()).once();

    PodMetrics podMetrics = client.top().pods().metrics("test", "test-pod");
    assertEquals("foo", podMetrics.getMetadata().getName());
  }

  @Test
  void testPodMetricsInNamespace() throws Exception {
    // Given
    server.expect().get().withPath("/apis/metrics.k8s.io/v1beta1/namespaces/test/pods")
        .andReturn(HttpURLConnection.HTTP_OK, new PodMetricsListBuilder().withItems(getPodMetric()).build())
        .once();

    // When
    PodMetricsList podMetricsList = client.top().pods().inNamespace("test").metrics();

    // Then
    assertEquals(1, podMetricsList.getItems().size());
    assertEquals("foo", podMetricsList.getItems().get(0).getMetadata().getName());
  }

  @Test
  void testPodMetricWithLabels() throws Exception {
    // Given
    server.expect().get().withPath("/apis/metrics.k8s.io/v1beta1/namespaces/ns1/pods?labelSelector=foo%3Dbar")
        .andReturn(HttpURLConnection.HTTP_OK, new PodMetricsListBuilder().withItems(getPodMetric()).build())
        .once();

    // When
    PodMetricsList podMetricsList = client.top().pods().inNamespace("ns1")
        .withLabels(Collections.singletonMap("foo", "bar"))
        .metrics();

    // Then
    assertThat(podMetricsList)
        .isNotNull()
        .extracting(PodMetricsList::getItems).asList().hasSize(1);
  }

  @Test
  void testPodMetricWithLabelsAllNamespaces() throws Exception {
    // Given
    server.expect().get().withPath("/apis/metrics.k8s.io/v1beta1/pods?labelSelector=foo%3Dbar")
        .andReturn(HttpURLConnection.HTTP_OK, new PodMetricsListBuilder().withItems(getPodMetric()).build())
        .once();

    // When
    PodMetricsList podMetricsList = client.top().pods()
        .withLabels(Collections.singletonMap("foo", "bar"))
        .metrics();

    // Then
    assertThat(podMetricsList)
        .isNotNull()
        .extracting(PodMetricsList::getItems).asList().hasSize(1);
  }

  @Test
  void testAllNodeMetrics() {
    server.expect().get().withPath("/apis/metrics.k8s.io/v1beta1/nodes")
        .andReturn(200, new NodeMetricsListBuilder().withItems(getNodeMetric()).build()).once();

    NodeMetricsList nodeMetricsList = client.top().nodes().metrics();
    assertEquals(1, nodeMetricsList.getItems().size());
    assertEquals("foo", nodeMetricsList.getItems().get(0).getMetadata().getName());
  }

  @Test
  void testNodeMetric() {
    server.expect().get().withPath("/apis/metrics.k8s.io/v1beta1/nodes/test-node")
        .andReturn(200, getNodeMetric()).once();

    NodeMetrics nodeMetrics = client.top().nodes().metrics("test-node");
    assertEquals("foo", nodeMetrics.getMetadata().getName());
  }

  @Test
  void testNodeMetricWithLabels() {
    // Given
    server.expect().get().withPath("/apis/metrics.k8s.io/v1beta1/nodes?labelSelector=" + Utils.toUrlEncoded("ss=true,cs=true"))
        .andReturn(200, new NodeMetricsListBuilder().withItems(getNodeMetric()).build()).once();

    Map<String, Object> lablesMap = new HashMap<>();
    lablesMap.put("ss", "true");
    lablesMap.put("cs", "true");

    // When
    NodeMetricsList nodeMetricList = client.top().nodes().metrics(lablesMap);

    // Then
    assertEquals(1, nodeMetricList.getItems().size());
  }

  private PodMetrics getPodMetric() throws Exception {
    return new PodMetricsBuilder()
        .withNewMetadata().withName("foo").endMetadata()
        .withWindow(Duration.parse("1m0s"))
        .addNewContainer()
        .withName("test-container")
        .withUsage(Collections.singletonMap("cpu", new Quantity("38m")))
        .endContainer()
        .build();
  }

  private NodeMetrics getNodeMetric() {
    return new NodeMetricsBuilder()
        .withNewMetadata().withName("foo").endMetadata()
        .withWindow(new Duration(java.time.Duration.ofMinutes(1L)))
        .withUsage(Collections.singletonMap("cpu", new Quantity("38m")))
        .build();
  }

}
