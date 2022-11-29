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
package io.fabric8.kubernetes.api.model.admissionregistration;

import io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfiguration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatingWebhookConfigurationTest {
  @Test
  public void testBuilder() {
    ValidatingWebhookConfiguration vwc = new io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfigurationBuilder()
        .withNewMetadata().withName("pod-policy.example.com").endMetadata()
        .addNewWebhook()
        .withName("pod-policy.example.com")
        .addNewRule()
        .withApiGroups("")
        .withApiVersions("v1")
        .withOperations("CREATE")
        .withResources("pods")
        .withScope("Namespaced")
        .endRule()
        .withNewClientConfig()
        .withNewService()
        .withNamespace("example-namespace")
        .withName("example-service")
        .endService()
        .endClientConfig()
        .withAdmissionReviewVersions("v1", "v1beta1")
        .withSideEffects("None")
        .withTimeoutSeconds(5)
        .endWebhook()
        .build();

    assertEquals("pod-policy.example.com", vwc.getMetadata().getName());
    assertEquals(1, vwc.getWebhooks().size());
  }
}
