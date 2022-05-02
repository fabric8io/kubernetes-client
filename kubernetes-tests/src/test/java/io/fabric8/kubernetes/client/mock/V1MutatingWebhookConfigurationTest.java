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
import io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookBuilder;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookConfigurationBuilder;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookConfigurationList;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookConfigurationListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
public class V1MutatingWebhookConfigurationTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  public void create() {
    MutatingWebhookConfiguration mutatingWebhookConfiguration = getMutatingWebhookConfigurationSample();

    server.expect().post().withPath("/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations")
        .andReturn(201, mutatingWebhookConfiguration).once();

    HasMetadata response = client.resource(mutatingWebhookConfiguration).inNamespace("test").createOrReplace();
    assertEquals(mutatingWebhookConfiguration, response);
  }

  @Test
  public void get() {
    // Given
    server.expect().get()
        .withPath("/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations/mutatingWebhookConfiguration1")
        .andReturn(200, getMutatingWebhookConfigurationSample()).once();

    // When
    MutatingWebhookConfiguration mutatingWebhookConfiguration = client.admissionRegistration().v1()
        .mutatingWebhookConfigurations().withName("mutatingWebhookConfiguration1").get();

    // Then
    assertNotNull(mutatingWebhookConfiguration);
    assertEquals("mutatingWebhookConfiguration1", mutatingWebhookConfiguration.getMetadata().getName());
  }

  @Test
  public void list() {
    // Given
    server.expect().get().withPath("/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations")
        .andReturn(200,
            new MutatingWebhookConfigurationListBuilder().withItems(getMutatingWebhookConfigurationSample()).build())
        .once();

    // When
    MutatingWebhookConfigurationList mutatingWebhookConfigurationList = client.admissionRegistration().v1()
        .mutatingWebhookConfigurations().list();

    // Then
    assertNotNull(mutatingWebhookConfigurationList);
    assertEquals(1, mutatingWebhookConfigurationList.getItems().size());
    assertEquals("mutatingWebhookConfiguration1", mutatingWebhookConfigurationList.getItems().get(0).getMetadata().getName());
  }

  @Test
  public void createOrReplace() {
    MutatingWebhookConfiguration mutatingWebhookConfiguration = getMutatingWebhookConfigurationSample();

    server.expect().post().withPath("/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations")
        .andReturn(200, mutatingWebhookConfiguration).once();

    MutatingWebhookConfiguration mutatingWebhookConfiguration1 = client.admissionRegistration().v1()
        .mutatingWebhookConfigurations().createOrReplace(mutatingWebhookConfiguration);
    assertNotNull(mutatingWebhookConfiguration1);
    assertEquals("mutatingWebhookConfiguration1", mutatingWebhookConfiguration1.getMetadata().getName());
  }

  @Test
  public void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations/mutatingWebhookConfiguration1")
        .andReturn(200, getMutatingWebhookConfigurationSample()).once();

    // When
    Boolean isDeleted = client.admissionRegistration().v1().mutatingWebhookConfigurations()
        .withName("mutatingWebhookConfiguration1").delete().size() == 1;

    // Then
    assertTrue(isDeleted);
  }

  public MutatingWebhookConfiguration getMutatingWebhookConfigurationSample() {
    return new MutatingWebhookConfigurationBuilder()
        .withNewMetadata().withName("mutatingWebhookConfiguration1").endMetadata()
        .addToWebhooks(new MutatingWebhookBuilder()
            .withName("webhook1")
            .withNewClientConfig()
            .withNewService()
            .withName("svc1")
            .withNamespace("test")
            .withPath("/mutate")
            .endService()
            .endClientConfig()
            .build())
        .build();
  }
}
