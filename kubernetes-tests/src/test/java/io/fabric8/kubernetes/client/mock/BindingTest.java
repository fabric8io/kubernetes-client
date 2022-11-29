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

import io.fabric8.kubernetes.api.model.Binding;
import io.fabric8.kubernetes.api.model.BindingBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class BindingTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @DisplayName("create, with created response, should return created resource")
  @Test
  void createOK() {
    server.expect().post().withPath("/api/v1/namespaces/default/bindings")
        .andReturn(201, "{\"metadata\": {\"name\": \"binding-name\"}}")
        .once();
    // When
    final Binding result = client.bindings().inNamespace("default").create(new BindingBuilder()
        .withNewMetadata().withName("binding-name").endMetadata()
        .withNewTarget().withKind("Node").withApiVersion("v1").withName("node-name").endTarget()
        .build());
    // Then
    assertThat(result)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "binding-name");
  }
}
