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
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.NamespaceableResource;
import io.fabric8.kubernetes.client.dsl.NonDeletingOperation;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@EnableKubernetesMockClient
class CreateOrTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  @DisplayName("Should replace an existing resource in Kubernetes Cluster")
  void testResourceReplace() {
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_CONFLICT, new PodBuilder()
        .withNewMetadata().withResourceVersion("12345").and().build()).once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(HttpURLConnection.HTTP_OK, new PodBuilder()
        .withNewMetadata().withResourceVersion("12345").and().build()).times(2);

    server.expect().put().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(HttpURLConnection.HTTP_OK, new PodBuilder()
        .withNewMetadata().withResourceVersion("12345").and().build()).once();

    Pod pod = client.resource(new PodBuilder().withNewMetadata().withName("pod123").and().withNewSpec().and().build())
        .createOr(NonDeletingOperation::update);
    assertNotNull(pod);
    assertEquals("12345", pod.getMetadata().getResourceVersion());
  }

  @Test
  @DisplayName("Should create a new resource in Kubernetes Cluster")
  void testResourceCreate() {
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_CREATED, new PodBuilder()
        .withNewMetadata().withResourceVersion("12345").and().build()).once();

    HasMetadata result = client
        .resource(new PodBuilder().withNewMetadata().withName("pod123").and().withNewSpec().and().build())
        .createOr(NonDeletingOperation::update);
    assertNotNull(result);
    assertEquals("12345", result.getMetadata().getResourceVersion());
  }

  @Test
  @DisplayName("Should throw Exception on failed create")
  void testResourceCreateFailure() {
    // Given
    server.expect().post().withPath("/api/v1/namespaces/test/pods")
        .andReturn(HttpURLConnection.HTTP_BAD_REQUEST, new PodBuilder()
            .withNewMetadata().withResourceVersion("12345").endMetadata().build())
        .once();
    NamespaceableResource<Pod> podOperation = client
        .resource(new PodBuilder().withNewMetadata().withName("pod123").endMetadata().build());

    // When
    assertThrows(KubernetesClientException.class, () -> podOperation.createOr(NonDeletingOperation::update));
  }

  @Test
  void testUnlock() {
    // Given
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_CONFLICT, "").once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(HttpURLConnection.HTTP_OK, new PodBuilder()
        .withNewMetadata().withResourceVersion("12345").and().build()).once();

    server.expect().put().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(HttpURLConnection.HTTP_OK, new PodBuilder()
        .withNewMetadata().withResourceVersion("12346").and().build()).once();

    NamespaceableResource<Pod> podOperation = client
        .resource(new PodBuilder().withNewMetadata().withResourceVersion("12344").withName("pod123").endMetadata().build());

    Pod pod = podOperation.unlock().createOr(NonDeletingOperation::update);
    assertNotNull(pod);
    assertEquals("12346", pod.getMetadata().getResourceVersion());
  }

}
