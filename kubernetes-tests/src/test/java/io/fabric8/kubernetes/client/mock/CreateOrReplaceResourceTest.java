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

import com.fasterxml.jackson.databind.ObjectMapper;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.net.HttpURLConnection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@EnableRuleMigrationSupport
class CreateOrReplaceResourceTest {

  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  @DisplayName("Should replace an existing resource in Kubernetes Cluster")
  void testResourceReplace() {
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_CONFLICT, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).always();

    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(HttpURLConnection.HTTP_OK, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).times(2);

    server.expect().put().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(HttpURLConnection.HTTP_OK, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    Pod pod = client.resource(new PodBuilder().withNewMetadata().withName("pod123").and().withNewSpec().and().build()).createOrReplace();
    assertNotNull(pod);
    assertEquals("12345", pod.getMetadata().getResourceVersion());
  }

  @Test
  @DisplayName("Should create a new resource in Kubernetes Cluster")
  void testResourceCreate() {
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_CREATED, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    HasMetadata result = client.resource(new PodBuilder().withNewMetadata().withName("pod123").and().withNewSpec().and().build()).createOrReplace();
    assertNotNull(result);
    assertEquals("12345", result.getMetadata().getResourceVersion());
  }

  @Test
  @DisplayName("Should throw Exception on failed create")
  void testResourceCreateFailure() {
    // Given
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_BAD_REQUEST, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").endMetadata().build()).once();
    KubernetesClient client = server.getClient();
    NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<Pod> podOperation = client.resource(new PodBuilder().withNewMetadata().withName("pod123").endMetadata().build());

    // When
    assertThrows(KubernetesClientException.class, podOperation::createOrReplace);
  }

  @Test
  @DisplayName("Should create a new resource in Kubernetes Cluster")
  void testCreate() {
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_CREATED, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    Pod pod = client.pods().createOrReplace(new PodBuilder().withNewMetadata().withName("pod123").and().withNewSpec().and().build());
    assertNotNull(pod);
    assertEquals("12345", pod.getMetadata().getResourceVersion());
  }

  @Test
  @DisplayName("Shoulc replace an existing resource in Kubernetes Cluster")
  void testReplace() {
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_CONFLICT, new PodBuilder().withNewMetadata().withResourceVersion("12345").and().build()).always();

    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(HttpURLConnection.HTTP_OK, new PodBuilder().withNewMetadata().withResourceVersion("12345").and().build()).times(2);
    server.expect().put().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(HttpURLConnection.HTTP_OK, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    Pod pod = client.pods().createOrReplace(new PodBuilder().withNewMetadata().withName("pod123").and().withNewSpec().and().build());
    assertNotNull(pod);
    assertEquals("12345", pod.getMetadata().getResourceVersion());
  }

  @Test
  @DisplayName("Should throw exception on failed replace")
  void testFailedReplace() {
    // Given
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_CONFLICT, new PodBuilder().withNewMetadata().withResourceVersion("12345").and().build()).always();
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(HttpURLConnection.HTTP_OK, new PodBuilder().withNewMetadata().withResourceVersion("12345").and().build()).times(2);
    server.expect().put().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(HttpURLConnection.HTTP_BAD_REQUEST, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();
    final Pod toCreate = new PodBuilder().withNewMetadata().withName("pod123").and().withNewSpec().and().build();
    final MixedOperation<Pod, PodList, PodResource<Pod>> pods = server.getClient().pods();
    // When
    assertThrows(KubernetesClientException.class, () -> pods.create(toCreate));
  }

  @Test
  @DisplayName("Should create a new resource in Kubernetes Cluster")
  void testResourceCreateFromLoad() throws Exception {
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_CREATED, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    List<HasMetadata> result = client.load(getClass().getResourceAsStream("/test-pod-create-from-load.yml")).createOrReplace();
    assertNotNull(result);
    assertEquals(1, result.size());
    Pod pod = (Pod) result.get(0);
    assertEquals("12345", pod.getMetadata().getResourceVersion());

    RecordedRequest request = server.getMockServer().takeRequest();
    assertEquals("/api/v1/namespaces/test/pods", request.getPath());
    Pod requestPod = new ObjectMapper().readerFor(Pod.class).readValue(request.getBody().inputStream());
    assertEquals("nginx", requestPod.getMetadata().getName());
  }

  @Test
  @DisplayName("Should replace an existing resource in Kubernetes Cluster")
  void testResourceReplaceFromLoad() throws Exception {
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_CONFLICT, new PodBuilder().withNewMetadata().withResourceVersion("12345").and().build()).always();

    server.expect().get().withPath("/api/v1/namespaces/test/pods/nginx").andReturn(HttpURLConnection.HTTP_OK, new PodBuilder().withNewMetadata().withResourceVersion("12345").and().build()).times(2);
    server.expect().put().withPath("/api/v1/namespaces/test/pods/nginx").andReturn(HttpURLConnection.HTTP_OK, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    List<HasMetadata> result = client.load(getClass().getResourceAsStream("/test-pod-create-from-load.yml")).createOrReplace();
    assertNotNull(result);
    assertEquals(1, result.size());
    Pod pod = (Pod) result.get(0);
    assertEquals("12345", pod.getMetadata().getResourceVersion());

    RecordedRequest request = server.getLastRequest();
    assertEquals("/api/v1/namespaces/test/pods/nginx", request.getPath());
    Pod requestPod = new ObjectMapper().readerFor(Pod.class).readValue(request.getBody().inputStream());
    assertEquals("nginx", requestPod.getMetadata().getName());
  }

  @Test
  @DisplayName("Should create a new resource from yaml")
  void testCreateFromLoad() throws Exception {
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_CREATED, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    Pod pod = client.pods().load(getClass().getResourceAsStream("/test-pod-create-from-load.yml")).createOrReplace();
    assertNotNull(pod);
    assertEquals("12345", pod.getMetadata().getResourceVersion());

    RecordedRequest request = server.getLastRequest();
    Pod requestPod = new ObjectMapper().readerFor(Pod.class).readValue(request.getBody().inputStream());
    assertEquals("nginx", requestPod.getMetadata().getName());
  }

  @Test
  @DisplayName("Should update existing resource")
  void testReplaceFromLoad() throws Exception {
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_CONFLICT, new PodBuilder().build()).always();

    server.expect().get().withPath("/api/v1/namespaces/test/pods/nginx").andReturn(HttpURLConnection.HTTP_OK, new PodBuilder().build()).times(2);
    server.expect().put().withPath("/api/v1/namespaces/test/pods/nginx").andReturn(HttpURLConnection.HTTP_OK, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    Pod pod = client.pods().load(getClass().getResourceAsStream("/test-pod-create-from-load.yml")).createOrReplace();
    assertNotNull(pod);
    assertEquals("12345", pod.getMetadata().getResourceVersion());


    RecordedRequest request = server.getLastRequest();
    assertEquals("/api/v1/namespaces/test/pods/nginx", request.getPath());
    Pod requestPod = new ObjectMapper().readerFor(Pod.class).readValue(request.getBody().inputStream());
    assertEquals("nginx", requestPod.getMetadata().getName());
  }

  @Test
  @DisplayName("Should replace an existing ConfigMap without lock")
  void testReplaceWithoutLock() throws Exception {
    server.expect().get().withPath("/api/v1/namespaces/test/configmaps/map1").andReturn(HttpURLConnection.HTTP_OK, new ConfigMapBuilder()
      .withNewMetadata().withResourceVersion("1000").and().build()).always();

    server.expect().put().withPath("/api/v1/namespaces/test/configmaps/map1").andReturn(HttpURLConnection.HTTP_OK, new ConfigMapBuilder()
      .withNewMetadata().withResourceVersion("1001").and().build()).once();

    KubernetesClient client = server.getClient();
    ConfigMap map = client.configMaps().withName("map1").replace(new ConfigMapBuilder()
      .withNewMetadata().withName("map1").and().build());
    assertNotNull(map);
    assertEquals("1001", map.getMetadata().getResourceVersion());

    RecordedRequest request = server.getLastRequest();
    ConfigMap replacedMap = new ObjectMapper().readerFor(ConfigMap.class).readValue(request.getBody().inputStream());
    assertEquals("1000", replacedMap.getMetadata().getResourceVersion());
  }

  @Test
  @DisplayName("Should replace an existing resource with lock")
  void testReplaceWithLock() throws Exception {
    server.expect().put().withPath("/api/v1/namespaces/test/configmaps/map1").andReturn(HttpURLConnection.HTTP_OK, new ConfigMapBuilder()
      .withNewMetadata().withResourceVersion("1001").and().build()).once();

    KubernetesClient client = server.getClient();
    ConfigMap map = client.configMaps().withName("map1")
      .lockResourceVersion("900")
      .replace(new ConfigMapBuilder().withNewMetadata().withName("map1").and().build());
    assertNotNull(map);
    assertEquals("1001", map.getMetadata().getResourceVersion());

    RecordedRequest request = server.getLastRequest();
    ConfigMap replacedMap = new ObjectMapper().readerFor(ConfigMap.class).readValue(request.getBody().inputStream());
    assertEquals("900", replacedMap.getMetadata().getResourceVersion());
  }
}
