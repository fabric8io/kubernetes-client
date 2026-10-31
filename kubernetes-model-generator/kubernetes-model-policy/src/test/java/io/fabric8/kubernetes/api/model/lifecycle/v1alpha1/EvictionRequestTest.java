/*
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
package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.Assertions.assertThat;

class EvictionRequestTest {
  private final ObjectMapper mapper = new JsonMapper();

  @Test
  @DisplayName("EvictionRequest is namespaced")
  void isNamespaced() {
    assertThat(new EvictionRequest()).isInstanceOf(Namespaced.class);
  }

  @Test
  @DisplayName("EvictionRequest defaults to lifecycle.k8s.io/v1alpha1")
  void apiVersion() {
    assertThat(new EvictionRequest().getApiVersion()).isEqualTo("lifecycle.k8s.io/v1alpha1");
  }

  @Test
  @DisplayName("EvictionRequest round-trips through JSON")
  void serializationRoundTrip() {
    // Given
    final EvictionRequest evictionRequest = new EvictionRequestBuilder()
        .withNewMetadata().withName("evict-my-pod").withNamespace("ns").endMetadata()
        .withNewSpec()
        .withRequester("requester.example.com")
        .withIntent("Evict")
        .withNewTarget().withNewPod("my-pod", "pod-uid").endTarget()
        .endSpec()
        .build();

    // When
    final EvictionRequest result = mapper.readValue(mapper.writeValueAsString(evictionRequest), EvictionRequest.class);

    // Then
    assertThat(result)
        .isEqualTo(evictionRequest)
        .hasFieldOrPropertyWithValue("kind", "EvictionRequest")
        .hasFieldOrPropertyWithValue("spec.target.pod.name", "my-pod")
        .hasFieldOrPropertyWithValue("spec.target.pod.uid", "pod-uid");
  }

  @Test
  @DisplayName("lifecycle.k8s.io/v1alpha1 EvictionRequest documents deserialize to EvictionRequest")
  void deserializationResolvesApiVersionAndKind() {
    // When
    final KubernetesResource result = mapper.readValue("{" +
        "\"apiVersion\":\"lifecycle.k8s.io/v1alpha1\",\"kind\":\"EvictionRequest\"," +
        "\"metadata\":{\"name\":\"evict-my-pod\"}," +
        "\"spec\":{\"requester\":\"requester.example.com\",\"intent\":\"Evict\"," +
        "\"target\":{\"pod\":{\"name\":\"my-pod\",\"uid\":\"pod-uid\"}}}}", KubernetesResource.class);

    // Then
    assertThat(result)
        .isInstanceOf(EvictionRequest.class)
        .hasFieldOrPropertyWithValue("spec.requester", "requester.example.com");
  }
}
