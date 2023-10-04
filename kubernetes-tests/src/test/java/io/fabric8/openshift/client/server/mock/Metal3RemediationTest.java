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

import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3Remediation;
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3RemediationBuilder;
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3RemediationList;
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3RemediationListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class Metal3RemediationTest {
  KubernetesMockServer server;
  OpenShiftClient client;

  @Test
  void create() throws ParseException {
    // Given
    Metal3Remediation metal3Remediation = getMetal3Remediation();
    server.expect().post()
        .withPath("/apis/infrastructure.cluster.x-k8s.io/v1beta1/namespaces/ns1/metal3remediations")
        .andReturn(HttpURLConnection.HTTP_OK, metal3Remediation)
        .once();

    // When
    metal3Remediation = client.metal3Remediations().inNamespace("ns1").resource(metal3Remediation).create();

    // Then
    assertNotNull(metal3Remediation);
    assertEquals("test-remediation", metal3Remediation.getMetadata().getName());
  }

  @Test
  void get() throws ParseException {
    // Given
    server.expect().get()
        .withPath("/apis/infrastructure.cluster.x-k8s.io/v1beta1/namespaces/ns1/metal3remediations/test-remediation")
        .andReturn(HttpURLConnection.HTTP_OK, getMetal3Remediation())
        .once();

    // When
    Metal3Remediation controlPlaneMachineSet = client.metal3Remediations().inNamespace("ns1").withName("test-remediation")
        .get();

    // Then
    assertNotNull(controlPlaneMachineSet);
    assertEquals("test-remediation", controlPlaneMachineSet.getMetadata().getName());
  }

  @Test
  void list() throws ParseException {
    // Given
    server.expect().get()
        .withPath("/apis/infrastructure.cluster.x-k8s.io/v1beta1/namespaces/ns1/metal3remediations")
        .andReturn(HttpURLConnection.HTTP_OK, new Metal3RemediationListBuilder().withItems(getMetal3Remediation()).build())
        .once();

    // When
    Metal3RemediationList controlPlaneMachineSetList = client.metal3Remediations().inNamespace("ns1").list();

    // Then
    assertNotNull(controlPlaneMachineSetList);
    assertNotNull(controlPlaneMachineSetList.getItems());
    assertEquals(1, controlPlaneMachineSetList.getItems().size());
  }

  @Test
  void delete() throws ParseException {
    // Given
    server.expect().delete()
        .withPath("/apis/infrastructure.cluster.x-k8s.io/v1beta1/namespaces/ns1/metal3remediations/test-remediation")
        .andReturn(HttpURLConnection.HTTP_OK, getMetal3Remediation())
        .once();

    // When
    boolean deleted = client.metal3Remediations().inNamespace("ns1").withName("test-remediation").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private Metal3Remediation getMetal3Remediation() throws ParseException {
    return new Metal3RemediationBuilder()
        .withNewMetadata()
        .withName("test-remediation")
        .endMetadata()
        .withNewSpec()
        .withNewStrategy()
        .withTimeout(Duration.parse("5s"))
        .withRetryLimit(5)
        .withType("Done")
        .endStrategy()
        .endSpec()
        .build();
  }
}
