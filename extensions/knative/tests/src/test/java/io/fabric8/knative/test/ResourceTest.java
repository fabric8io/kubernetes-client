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
package io.fabric8.knative.test;

import io.fabric8.knative.serving.v1.Service;
import io.fabric8.knative.serving.v1.ServiceBuilder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableKubernetesMock(crud = true)
class ResourceTest {

  KubernetesClient client;

  // https://github.com/quarkusio/quarkus/issues/19950
  @Test
  @DisplayName("resource, with Knative model in namespace, can createOrReplace")
  void resourceInNamespaceCreate() {
    // Given
    final Service service = new ServiceBuilder().withNewMetadata().withName("service-resource").endMetadata().build();
    // When
    final HasMetadata hm = client.resource(service).inNamespace("default").createOrReplace();
    // Then
    assertNotNull(hm);
  }
}
