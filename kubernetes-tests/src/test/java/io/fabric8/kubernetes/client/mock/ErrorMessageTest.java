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

import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventBuilder;
import io.fabric8.kubernetes.api.model.EventList;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@EnableKubernetesMockClient
class ErrorMessageTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void whenCustomErrorMessageInConfig_thenErrorMessageShouldNotContainCustomMessage() {
    // Given
    String customMessage = "INVALID";
    client.getConfiguration().getErrorMessages().put(403, customMessage);
    server.expect().delete()
        .withPath("/api/v1/namespaces/test/events")
        .andReturn(HTTP_FORBIDDEN, new StatusBuilder()
            .withCode(HTTP_FORBIDDEN)
            .withMessage("forbidden")
            .build())
        .once();
    NonNamespaceOperation<Event, EventList, Resource<Event>> eventResource = client.v1().events().inNamespace("test");

    // When + Then
    assertThatExceptionOfType(KubernetesClientException.class)
        .isThrownBy(eventResource::delete)
        .withMessageContaining(customMessage)
        .hasFieldOrPropertyWithValue("code", HTTP_FORBIDDEN);
  }

  @Test
  void whenResponseBodyContainsKubernetesStatus_thenErrorMessageShouldContainStatusMessage() {
    // Given
    Status badRequestStatus = new StatusBuilder()
        .withMessage("This operation invalid for some reason")
        .withReason("Invalid")
        .withCode(HTTP_BAD_REQUEST)
        .build();
    server.expect().post()
        .withPath("/api/v1/namespaces/test/events")
        .andReturn(HTTP_BAD_REQUEST, badRequestStatus)
        .always();
    Resource<Event> eventResource = client.v1().events().inNamespace("test")
        .resource(new EventBuilder().withNewMetadata().withName("event1").endMetadata().build());

    // When + Then
    assertThatExceptionOfType(KubernetesClientException.class)
        .isThrownBy(eventResource::create)
        .withMessageContaining("Message: This operation invalid for some reason.")
        .hasFieldOrPropertyWithValue("code", HTTP_BAD_REQUEST)
        .extracting(KubernetesClientException::getStatus)
        .isEqualTo(badRequestStatus);
  }
}
