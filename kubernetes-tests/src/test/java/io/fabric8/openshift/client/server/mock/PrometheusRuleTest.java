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
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusRule;
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusRuleBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusRuleList;
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusRuleListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class PrometheusRuleTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void load() {
    List<HasMetadata> items = client.load(getClass().getResourceAsStream("/test-prometheusrule.yml")).items();
    assertEquals(1, items.size());
    assertTrue(items.get(0) instanceof PrometheusRule);
    PrometheusRule prometheusRule = (PrometheusRule) items.get(0);
    assertEquals("prometheus-service-rules", prometheusRule.getMetadata().getName());
    assertEquals(1, prometheusRule.getSpec().getGroups().size());
    assertEquals(2, prometheusRule.getSpec().getGroups().get(0).getRules().size());
  }

  @Test
  void create() {
    // Given
    PrometheusRule prometheusRule = getPrometheusRule();
    server.expect().post()
        .withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/prometheusrules")
        .andReturn(HttpURLConnection.HTTP_OK, prometheusRule)
        .once();

    // When
    prometheusRule = client.monitoring().prometheusRules().inNamespace("ns1").create(prometheusRule);

    // Then
    assertNotNull(prometheusRule);
    assertEquals("foo", prometheusRule.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/prometheusrules/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getPrometheusRule())
        .once();

    // When
    PrometheusRule f = client.monitoring().prometheusRules().inNamespace("ns1").withName("foo").get();

    // Then
    assertNotNull(f);
    assertEquals("foo", f.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/prometheusrules")
        .andReturn(HttpURLConnection.HTTP_OK, new PrometheusRuleListBuilder().withItems(getPrometheusRule()).build())
        .once();

    // When
    PrometheusRuleList fgList = client.monitoring().prometheusRules().inNamespace("ns1").list();

    // Then
    assertNotNull(fgList);
    assertNotNull(fgList.getItems());
    assertEquals(1, fgList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/prometheusrules/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getPrometheusRule())
        .once();

    // When
    boolean deleted = client.monitoring().prometheusRules().inNamespace("ns1").withName("foo").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private PrometheusRule getPrometheusRule() {
    return new PrometheusRuleBuilder()
        .withNewMetadata().withName("foo").endMetadata()
        .withNewSpec()
        .addNewGroup()
        .withName("./example-rules")
        .addNewRule()
        .withAlert("ExampleAlert")
        .withNewExpr("vector(1)")
        .endRule()
        .endGroup()
        .endSpec()
        .build();
  }
}
