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
import io.fabric8.kubernetes.api.model.admissionregistration.ValidatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.admissionregistration.ValidatingWebhookConfigurationBuilder;
import io.fabric8.kubernetes.api.model.admissionregistration.WebhookBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidatingWebhookConfigurationTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void create() {
    ValidatingWebhookConfiguration validatingWebhookConfiguration = new ValidatingWebhookConfigurationBuilder()
      .withNewMetadata().withName("validatingWebhookConfiguration1").endMetadata()
      .addToWebhooks(new WebhookBuilder()
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

    server.expect().post().withPath("/apis/admissionregistration.k8s.io/v1beta1/validatingwebhookconfigurations").andReturn(201, validatingWebhookConfiguration).once();

    KubernetesClient client = server.getClient();
    HasMetadata response = client.resource(validatingWebhookConfiguration).createOrReplace();
    assertEquals(validatingWebhookConfiguration, response);
  }
}
