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

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@EnableKubernetesMockClient
class TypedResourcesApiTest {
  KubernetesClient client;

  @Test
  void resources_whenUsedWithGenericKubernetesResource_shouldThrowException() {
    // Given + When
    KubernetesClientException kubernetesClientException = assertThrows(KubernetesClientException.class,
        () -> client.resources(GenericKubernetesResource.class));

    // Then
    assertThat(kubernetesClientException)
        .hasMessage("resources cannot be called with a generic type");
  }

  @Test
  void resources_whenUsedWithHasMetadata_shouldThrowException() {
    // Given + When
    IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
        () -> client.resources(HasMetadata.class));

    // Then
    assertThat(illegalArgumentException)
        .hasMessage("resources cannot be called with an interface");
  }
}
