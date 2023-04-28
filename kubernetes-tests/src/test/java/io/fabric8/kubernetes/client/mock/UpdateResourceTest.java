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

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.NamespaceableResource;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@EnableKubernetesMockClient
class UpdateResourceTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testResourceUpdate() {
    server.expect()
        .get()
        .withPath("/api/v1/namespaces/test/pods/pod123")
        .andReturn(HttpURLConnection.HTTP_OK, new PodBuilder()
            .withNewMetadata()
            .withResourceVersion("12345")
            .and()
            .build())
        .times(2);

    server.expect()
        .put()
        .withPath("/api/v1/namespaces/test/pods/pod123")
        .andReturn(HttpURLConnection.HTTP_OK, new PodBuilder()
            .withNewMetadata()
            .withResourceVersion("12346")
            .and()
            .build())
        .once();

    Pod pod = client.resource(new PodBuilder().withNewMetadata().withName("pod123").and().withNewSpec().and().build())
        .update();
    assertNotNull(pod);
    assertEquals("12346", pod.getMetadata().getResourceVersion());
  }

  @Test
  void testResourceConflict() {
    server.expect()
        .put()
        .withPath("/api/v1/namespaces/test/pods/pod123")
        .andReturn(HttpURLConnection.HTTP_CONFLICT, "")
        .always();

    NamespaceableResource<Pod> podResoruce = client.resource(new PodBuilder().withNewMetadata()
        .withName("pod123")
        .withResourceVersion("11")
        .and()
        .withNewSpec()
        .and()
        .build());
    final KubernetesClientException result = assertThrows(KubernetesClientException.class, podResoruce::update);
    assertEquals(409, result.getCode());
  }

  @Test
  void testResourceUpdateStatus() {
    server.expect()
        .put()
        .withPath("/api/v1/namespaces/test/pods/pod123/status")
        .andReturn(HttpURLConnection.HTTP_OK, new PodBuilder()
            .withNewMetadata()
            .withResourceVersion("y")
            .and()
            .build())
        .once();

    Pod pod = client
        .resource(new PodBuilder().withNewMetadata()
            .withName("pod123")
            .withResourceVersion("x")
            .and()
            .withNewSpec()
            .and()
            .build())
        .updateStatus();
    assertEquals("y", pod.getMetadata().getResourceVersion());
  }

  @Test
  void testUpdateNonExistent() {
    Resource<ConfigMap> resource = client.resource(new ConfigMapBuilder().withNewMetadata().withName("map1").and().build());
    final KubernetesClientException result = assertThrows(KubernetesClientException.class,
        resource::update);
    assertEquals(HttpURLConnection.HTTP_NOT_FOUND, result.getCode());
  }

}
