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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.openshift.api.model.monitoring.v1.AlertingSpec;
import io.fabric8.openshift.api.model.monitoring.v1.AlertmanagerEndpoints;
import io.fabric8.openshift.api.model.monitoring.v1.AlertmanagerEndpointsBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.Prometheus;
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusList;
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class PrometheusTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void load() {
    List<HasMetadata> items = client.load(getClass().getResourceAsStream("/test-prometheus.yml")).items();
    assertEquals(1, items.size());
    assertTrue(items.get(0) instanceof Prometheus);
    Prometheus prometheus = (Prometheus) items.get(0);
    assertEquals("prometheus", prometheus.getMetadata().getName());
    assertEquals(1, prometheus.getSpec().getAlerting().getAlertmanagers().size());
  }

  @Test
  void create() {
    // Given
    Prometheus prometheus = getPrometheus();
    server.expect().post()
        .withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/prometheuses")
        .andReturn(HttpURLConnection.HTTP_OK, prometheus)
        .once();

    // When
    prometheus = client.monitoring().prometheuses().inNamespace("ns1").create(prometheus);

    // Then
    assertNotNull(prometheus);
    assertEquals("foo", prometheus.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/prometheuses/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getPrometheus())
        .once();

    // When
    Prometheus f = client.monitoring().prometheuses().inNamespace("ns1").withName("foo").get();

    // Then
    assertNotNull(f);
    assertEquals("foo", f.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/prometheuses")
        .andReturn(HttpURLConnection.HTTP_OK, new PrometheusListBuilder().withItems(getPrometheus()).build())
        .once();

    // When
    PrometheusList fgList = client.monitoring().prometheuses().inNamespace("ns1").list();

    // Then
    assertNotNull(fgList);
    assertNotNull(fgList.getItems());
    assertEquals(1, fgList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/prometheuses/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getPrometheus())
        .once();

    // When
    boolean deleted = client.monitoring().prometheuses().inNamespace("ns1").withName("foo").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private Prometheus getPrometheus() {
    AlertmanagerEndpoints alertmanagerEndpoints = new AlertmanagerEndpointsBuilder()
        .withName("alertmanager-main")
        .withNamespace("monitoring")
        .withPort(new IntOrString("web"))
        .build();
    List<AlertmanagerEndpoints> alertmanagerEndpointsList = new ArrayList<>();
    alertmanagerEndpointsList.add(alertmanagerEndpoints);

    AlertingSpec alertingSpec = new AlertingSpec();
    alertingSpec.setAlertmanagers(alertmanagerEndpointsList);

    return new PrometheusBuilder()
        .withNewMetadata().withName("foo").endMetadata()
        .withNewSpec()
        .withServiceAccountName("prometheus-k8s")
        .withAlerting(alertingSpec)
        .endSpec()
        .build();
  }
}
