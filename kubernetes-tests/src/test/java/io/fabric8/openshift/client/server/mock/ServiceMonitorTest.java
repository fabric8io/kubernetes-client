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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.openshift.api.model.monitoring.v1.ServiceMonitor;
import io.fabric8.openshift.api.model.monitoring.v1.ServiceMonitorBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.ServiceMonitorList;
import io.fabric8.openshift.api.model.monitoring.v1.ServiceMonitorListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class ServiceMonitorTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void load() {
    List<HasMetadata> items = client.load(getClass().getResourceAsStream("/test-servicemonitor.yml")).items();
    assertEquals(1, items.size());
    assertTrue(items.get(0) instanceof ServiceMonitor);
    ServiceMonitor serviceMonitor = (ServiceMonitor) items.get(0);
    assertEquals("gitlab-metrics-servicemonitor", serviceMonitor.getMetadata().getName());
    assertEquals(1, serviceMonitor.getSpec().getEndpoints().size());
  }

  @Test
  void create() {
    // Given
    ServiceMonitor serviceMonitor = getServiceMonitor();
    server.expect().post()
        .withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/servicemonitors")
        .andReturn(HttpURLConnection.HTTP_OK, serviceMonitor)
        .once();

    // When
    serviceMonitor = client.monitoring().serviceMonitors().inNamespace("ns1").create(serviceMonitor);

    // Then
    assertNotNull(serviceMonitor);
    assertEquals("foo", serviceMonitor.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/servicemonitors/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getServiceMonitor())
        .once();

    // When
    ServiceMonitor serviceMonitor = client.monitoring().serviceMonitors().inNamespace("ns1").withName("foo").get();

    // Then
    assertNotNull(serviceMonitor);
    assertEquals("foo", serviceMonitor.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/servicemonitors")
        .andReturn(HttpURLConnection.HTTP_OK, new ServiceMonitorListBuilder().withItems(getServiceMonitor()).build())
        .once();

    // When
    ServiceMonitorList fgList = client.monitoring().serviceMonitors().inNamespace("ns1").list();

    // Then
    assertNotNull(fgList);
    assertNotNull(fgList.getItems());
    assertEquals(1, fgList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/servicemonitors/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getServiceMonitor())
        .once();

    // When
    boolean deleted = client.monitoring().serviceMonitors().inNamespace("ns1").withName("foo").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private ServiceMonitor getServiceMonitor() {
    return new ServiceMonitorBuilder()
        .withNewMetadata()
        .withName("foo")
        .addToLabels("prometheus", "frontend")
        .endMetadata()
        .withNewSpec()
        .withNewNamespaceSelector().withAny(true).endNamespaceSelector()
        .withNewSelector()
        .addToMatchLabels("prometheus", "frontend")
        .endSelector()
        .addNewEndpoint()
        .withPort("http-metric")
        .withInterval("15s")
        .endEndpoint()
        .endSpec()
        .build();
  }
}
