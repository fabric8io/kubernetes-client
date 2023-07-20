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
package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ServerlessServiceTest {
  @Test
  void apiVersion() {
    assertThat(new ServerlessService().getApiVersion()).isEqualTo("networking.internal.knative.dev/v1alpha1");
  }

  @Test
  void isNamespaceScoped() {
    assertThat(new ServerlessService()).isInstanceOf(Namespaced.class);
  }

  @Test
  void builder() {
    // Given
    ServerlessServiceBuilder serverlessServiceBuilder = new ServerlessServiceBuilder()
        .withNewMetadata()
        .withName("test-serverlessservice")
        .endMetadata()
        .withNewSpec()
        .withProtocolType("http1")
        .withMode("Proxy")
        .withNumActivators(2)
        .withNewObjectRef()
        .withApiVersion("apps/v1")
        .withKind("Deployment")
        .withName("test-deploy")
        .endObjectRef()
        .endSpec();

    // When
    ServerlessService serverlessService = serverlessServiceBuilder.build();

    // Then
    assertThat(serverlessService)
        .hasFieldOrPropertyWithValue("metadata.name", "test-serverlessservice")
        .hasFieldOrPropertyWithValue("spec.protocolType", "http1")
        .hasFieldOrPropertyWithValue("spec.mode", "Proxy")
        .hasFieldOrPropertyWithValue("spec.numActivators", 2)
        .hasFieldOrPropertyWithValue("spec.objectRef.apiVersion", "apps/v1")
        .hasFieldOrPropertyWithValue("spec.objectRef.kind", "Deployment")
        .hasFieldOrPropertyWithValue("spec.objectRef.name", "test-deploy");
  }
}
