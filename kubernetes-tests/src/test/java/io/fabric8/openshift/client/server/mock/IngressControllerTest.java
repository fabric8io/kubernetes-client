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

import io.fabric8.kubernetes.api.model.runtime.RawExtension;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openshift.api.model.operator.v1.IngressController;
import io.fabric8.openshift.api.model.operator.v1.IngressControllerBuilder;
import io.fabric8.openshift.api.model.operator.v1.IngressControllerList;
import io.fabric8.openshift.api.model.operator.v1.IngressControllerListBuilder;
import io.fabric8.openshift.api.model.operator.v1.IngressControllerSpec;
import io.fabric8.openshift.api.model.operator.v1.IngressControllerSpecBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class IngressControllerTest {

  KubernetesMockServer server;
  OpenShiftClient client;

  @Test
  void build() {
    IngressControllerSpec ic = new IngressControllerSpecBuilder()
        .withUnsupportedConfigOverrides(new RawExtension(Arrays.asList(1, 2)))
        .build();
    // make sure the value is not dropped
    assertNotNull(ic.getUnsupportedConfigOverrides());
  }

  @Test
  void create() {
    // Given
    IngressController dnsrecord = getIngressController();
    server.expect()
        .post()
        .withPath("/apis/operator.openshift.io/v1/namespaces/ns1/ingresscontrollers")
        .andReturn(HttpURLConnection.HTTP_OK, dnsrecord)
        .once();

    // When
    dnsrecord = client.operator().ingressControllers().inNamespace("ns1").create(dnsrecord);

    // Then
    assertNotNull(dnsrecord);
    assertEquals("foo", dnsrecord.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect()
        .get()
        .withPath("/apis/operator.openshift.io/v1/namespaces/ns1/ingresscontrollers/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getIngressController())
        .once();

    // When
    IngressController f = client.operator().ingressControllers().inNamespace("ns1").withName("foo").get();

    // Then
    assertNotNull(f);
    assertEquals("foo", f.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect()
        .get()
        .withPath("/apis/operator.openshift.io/v1/namespaces/ns1/ingresscontrollers")
        .andReturn(HttpURLConnection.HTTP_OK,
            new IngressControllerListBuilder().withItems(getIngressController()).build())
        .once();

    // When
    IngressControllerList fgList = client.operator().ingressControllers().inNamespace("ns1").list();

    // Then
    assertNotNull(fgList);
    assertNotNull(fgList.getItems());
    assertEquals(1, fgList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect()
        .delete()
        .withPath("/apis/operator.openshift.io/v1/namespaces/ns1/ingresscontrollers/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getIngressController())
        .once();

    // When
    boolean deleted = client.operator().ingressControllers().inNamespace("ns1").withName("foo").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private IngressController getIngressController() {
    return new IngressControllerBuilder()
        .withNewMetadata()
        .withName("foo")
        .withNamespace("ns1")
        .endMetadata()
        .withNewSpec()
        .withDomain("example.fabric8.io")
        .withNewNodePlacement()
        .withNewNodeSelector()
        .addToMatchLabels("node-role.kubernetes.io/worker", "")
        .endNodeSelector()
        .endNodePlacement()
        .withNewRouteSelector()
        .addToMatchLabels("type", "sharded")
        .endRouteSelector()
        .endSpec()
        .build();
  }
}
