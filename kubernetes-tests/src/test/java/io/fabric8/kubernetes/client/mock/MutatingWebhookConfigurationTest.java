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
import io.fabric8.kubernetes.api.model.admissionregistration.MutatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.admissionregistration.MutatingWebhookConfigurationBuilder;
import io.fabric8.kubernetes.api.model.admissionregistration.WebhookBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MutatingWebhookConfigurationTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void create() {
    MutatingWebhookConfiguration mutatingWebhookConfiguration = new MutatingWebhookConfigurationBuilder()
      .withNewMetadata().withName("mutatingWebhookConfiguration1").endMetadata()
      .addToWebhooks(new WebhookBuilder()
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

    server.expect().post().withPath("/apis/admissionregistration.k8s.io/v1beta1/mutatingwebhookconfigurations").andReturn(201, mutatingWebhookConfiguration).once();

    KubernetesClient client = server.getClient();
    HasMetadata response = client.resource(mutatingWebhookConfiguration).createOrReplace();
    assertEquals(mutatingWebhookConfiguration, response);
  }
}
