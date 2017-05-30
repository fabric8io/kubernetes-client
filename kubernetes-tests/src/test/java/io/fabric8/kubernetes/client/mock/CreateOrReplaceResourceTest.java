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
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateOrReplaceResourceTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void testResourceReplace() throws Exception {
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(200, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).always();

    server.expect().put().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(200, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    assertNotNull(client.resource(new PodBuilder().withNewMetadata().withName("pod123").and().withNewSpec().and().build()).createOrReplace());

    server.getMockServer().takeRequest();
    server.getMockServer().takeRequest();
    RecordedRequest request = server.getMockServer().takeRequest();
    Pod requestPod = new ObjectMapper().readerFor(Pod.class).readValue(request.getBody().inputStream());
    assertEquals("12345", requestPod.getMetadata().getResourceVersion());
  }

  @Test
  public void testResourceCreate() throws Exception {
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(404, new StatusBuilder().build()).always();

    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(201, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    HasMetadata result = client.resource(new PodBuilder().withNewMetadata().withName("pod123").and().withNewSpec().and().build()).createOrReplace();
    assertNotNull(result);
    assertEquals("12345", result.getMetadata().getResourceVersion());
  }

  @Test
  public void testCreate() throws Exception {
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(404, new StatusBuilder().build()).always();

    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(201, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    Pod pod = client.pods().createOrReplaceWithNew().withNewMetadata().withName("pod123").and().withNewSpec().and().done();
    assertNotNull(pod);
    assertEquals("12345", pod.getMetadata().getResourceVersion());
  }

  @Test
  public void testReplace() throws Exception {
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(200, new PodBuilder().withNewMetadata().withResourceVersion("12345").and().build()).always();

    server.expect().put().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(200, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    Pod pod = client.pods().createOrReplaceWithNew().withNewMetadata().withName("pod123").and().withNewSpec().and().done();
    assertNotNull(pod);
    assertEquals("12345", pod.getMetadata().getResourceVersion());
  }

  @Test
  public void testResourceCreateFromLoad() throws Exception {
    server.expect().get().withPath("/api/v1/namespaces/test/pods/nginx").andReturn(404, new StatusBuilder().build()).always();

    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(201, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    List<HasMetadata> result = client.load(getClass().getResourceAsStream("/test-pod-create-from-load.yml")).createOrReplace();
    assertNotNull(result);
    assertEquals(1, result.size());
    Pod pod = (Pod) result.get(0);
    assertEquals("12345", pod.getMetadata().getResourceVersion());

    RecordedRequest request = server.getMockServer().takeRequest();
    assertEquals("/api/v1/namespaces/test/pods/nginx", request.getPath());

    request = server.getMockServer().takeRequest();
    Pod requestPod = new ObjectMapper().readerFor(Pod.class).readValue(request.getBody().inputStream());
    assertEquals("nginx", requestPod.getMetadata().getName());
  }

  @Test
  public void testResourceReplaceFromLoad() throws Exception {
    server.expect().get().withPath("/api/v1/namespaces/test/pods/nginx").andReturn(200, new PodBuilder().withNewMetadata().withResourceVersion("12345").and().build()).always();

    server.expect().put().withPath("/api/v1/namespaces/test/pods/nginx").andReturn(200, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    List<HasMetadata> result = client.load(getClass().getResourceAsStream("/test-pod-create-from-load.yml")).createOrReplace();
    assertNotNull(result);
    assertEquals(1, result.size());
    Pod pod = (Pod) result.get(0);
    assertEquals("12345", pod.getMetadata().getResourceVersion());

    RecordedRequest request = server.getMockServer().takeRequest();
    assertEquals("/api/v1/namespaces/test/pods/nginx", request.getPath());
    server.getMockServer().takeRequest();

    request = server.getMockServer().takeRequest();
    Pod requestPod = new ObjectMapper().readerFor(Pod.class).readValue(request.getBody().inputStream());
    assertEquals("nginx", requestPod.getMetadata().getName());
  }

  @Test
  public void testCreateFromLoad() throws Exception {
    server.expect().get().withPath("/api/v1/namespaces/test/pods/nginx").andReturn(404, new StatusBuilder().build()).always();

    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(201, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    Pod pod = client.pods().load(getClass().getResourceAsStream("/test-pod-create-from-load.yml")).createOrReplace();
    assertNotNull(pod);
    assertEquals("12345", pod.getMetadata().getResourceVersion());

    RecordedRequest request = server.getMockServer().takeRequest();
    assertEquals("/api/v1/namespaces/test/pods/nginx", request.getPath());

    request = server.getMockServer().takeRequest();
    Pod requestPod = new ObjectMapper().readerFor(Pod.class).readValue(request.getBody().inputStream());
    assertEquals("nginx", requestPod.getMetadata().getName());
  }

  @Test
  public void testReplaceFromLoad() throws Exception {
    server.expect().get().withPath("/api/v1/namespaces/test/pods/nginx").andReturn(200, new PodBuilder().build()).always();

    server.expect().put().withPath("/api/v1/namespaces/test/pods/nginx").andReturn(200, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    Pod pod = client.pods().load(getClass().getResourceAsStream("/test-pod-create-from-load.yml")).createOrReplace();
    assertNotNull(pod);
    assertEquals("12345", pod.getMetadata().getResourceVersion());

    RecordedRequest request = server.getMockServer().takeRequest();
    assertEquals("/api/v1/namespaces/test/pods/nginx", request.getPath());

    request = server.getMockServer().takeRequest();
    Pod requestPod = new ObjectMapper().readerFor(Pod.class).readValue(request.getBody().inputStream());
    assertEquals("nginx", requestPod.getMetadata().getName());
  }

  @Test
  public void testReplaceWithoutLock() throws Exception {
    server.expect().get().withPath("/api/v1/namespaces/test/configmaps/map1").andReturn(200, new ConfigMapBuilder()
      .withNewMetadata().withResourceVersion("1000").and().build()).always();

    server.expect().put().withPath("/api/v1/namespaces/test/configmaps/map1").andReturn(200, new ConfigMapBuilder()
      .withNewMetadata().withResourceVersion("1001").and().build()).once();

    KubernetesClient client = server.getClient();
    ConfigMap map = client.configMaps().withName("map1").replace(new ConfigMapBuilder()
      .withNewMetadata().withName("map1").and().build());
    assertNotNull(map);
    assertEquals("1001", map.getMetadata().getResourceVersion());

    server.getMockServer().takeRequest(); // ignore the first request
    RecordedRequest request = server.getMockServer().takeRequest();
    ConfigMap replacedMap = new ObjectMapper().readerFor(ConfigMap.class).readValue(request.getBody().inputStream());
    assertEquals("1000", replacedMap.getMetadata().getResourceVersion());
  }

  @Test
  public void testReplaceWithLock() throws Exception {
    server.expect().put().withPath("/api/v1/namespaces/test/configmaps/map1").andReturn(200, new ConfigMapBuilder()
      .withNewMetadata().withResourceVersion("1001").and().build()).once();

    KubernetesClient client = server.getClient();
    ConfigMap map = client.configMaps().withName("map1")
      .lockResourceVersion("900")
      .replace(new ConfigMapBuilder().withNewMetadata().withName("map1").and().build());
    assertNotNull(map);
    assertEquals("1001", map.getMetadata().getResourceVersion());

    RecordedRequest request = server.getMockServer().takeRequest();
    ConfigMap replacedMap = new ObjectMapper().readerFor(ConfigMap.class).readValue(request.getBody().inputStream());
    assertEquals("900", replacedMap.getMetadata().getResourceVersion());
  }
}
