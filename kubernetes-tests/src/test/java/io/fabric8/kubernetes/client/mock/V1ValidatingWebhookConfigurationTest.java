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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookBuilder;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfigurationBuilder;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfigurationList;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfigurationListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
public class V1ValidatingWebhookConfigurationTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  public void createUsingResource() {
    ValidatingWebhookConfiguration validatingWebhookConfiguration = getValidatingWebhookConfigurationSample();

    server.expect().post().withPath("/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations")
        .andReturn(201, validatingWebhookConfiguration).once();

    HasMetadata response = client.resource(validatingWebhookConfiguration).inNamespace("test").createOrReplace();
    assertEquals(validatingWebhookConfiguration, response);
  }

  @Test
  public void load() {
    ValidatingWebhookConfiguration vwc = client.admissionRegistration().v1().validatingWebhookConfigurations()
        .load(getClass().getResourceAsStream("/v1-vwc.yml")).item();
    assertNotNull(vwc);
    assertEquals("pod-policy.example.com", vwc.getMetadata().getName());
    assertEquals(1, vwc.getWebhooks().size());
  }

  @Test
  public void get() {
    // Given
    server.expect().get()
        .withPath("/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations/validatingWebhookConfiguration1")
        .andReturn(200, getValidatingWebhookConfigurationSample()).once();

    // When
    ValidatingWebhookConfiguration validatingWebhookConfiguration = client.admissionRegistration().v1()
        .validatingWebhookConfigurations().withName("validatingWebhookConfiguration1").get();

    // Then
    assertNotNull(validatingWebhookConfiguration);
    assertEquals("validatingWebhookConfiguration1", validatingWebhookConfiguration.getMetadata().getName());
  }

  @Test
  public void list() {
    // Given
    server.expect().get().withPath("/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations")
        .andReturn(200,
            new ValidatingWebhookConfigurationListBuilder().withItems(getValidatingWebhookConfigurationSample()).build())
        .once();

    // When
    ValidatingWebhookConfigurationList validatingWebhookConfigurationList = client.admissionRegistration().v1()
        .validatingWebhookConfigurations().list();

    // Then
    assertNotNull(validatingWebhookConfigurationList);
    assertEquals(1, validatingWebhookConfigurationList.getItems().size());
    assertEquals("validatingWebhookConfiguration1",
        validatingWebhookConfigurationList.getItems().get(0).getMetadata().getName());
  }

  @Test
  public void createOrReplace() {
    ValidatingWebhookConfiguration validatingWebhookConfiguration = getValidatingWebhookConfigurationSample();

    server.expect().post().withPath("/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations")
        .andReturn(200, validatingWebhookConfiguration).once();

    ValidatingWebhookConfiguration validatingWebhookConfiguration1 = client.admissionRegistration().v1()
        .validatingWebhookConfigurations().createOrReplace(validatingWebhookConfiguration);
    assertNotNull(validatingWebhookConfiguration1);
    assertEquals("validatingWebhookConfiguration1", validatingWebhookConfiguration1.getMetadata().getName());
  }

  @Test
  public void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations/validatingWebhookConfiguration1")
        .andReturn(200, getValidatingWebhookConfigurationSample()).once();

    // When
    Boolean isDeleted = client.admissionRegistration().v1().validatingWebhookConfigurations()
        .withName("validatingWebhookConfiguration1").delete().size() == 1;

    // Then
    assertTrue(isDeleted);
  }

  public ValidatingWebhookConfiguration getValidatingWebhookConfigurationSample() {
    return new ValidatingWebhookConfigurationBuilder()
        .withNewMetadata().withName("validatingWebhookConfiguration1").endMetadata()
        .addToWebhooks(new ValidatingWebhookBuilder()
            .withName("webhook1")
            .withNewClientConfig()
            .withNewService()
            .withName("svc1")
            .withNamespace("test")
            .withPath("/validate")
            .endService()
            .endClientConfig()
            .build())
        .build();
  }
}
