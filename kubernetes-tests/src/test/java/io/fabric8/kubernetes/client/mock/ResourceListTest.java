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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;

import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@EnableRuleMigrationSupport
public class ResourceListTest {

  @Rule
  public KubernetesServer server = new KubernetesServer();

  private KubernetesClient client;
  private Service service;
  private Service updatedService;
  private ConfigMap configMap;
  private ConfigMap updatedConfigMap;
  private KubernetesList resourcesToUpdate;

  @BeforeEach
  void setUp() {
    client = server.getClient();
    service = mockService().build();
    configMap = mockConfigMap().build();
    updatedService = mockService().editSpec().editFirstPort()
      .withTargetPort(new IntOrString(9999)).endPort().endSpec()
      .build();
    updatedConfigMap = mockConfigMap().addToData(Collections.singletonMap("foo", "bar")).build();
    resourcesToUpdate = new KubernetesListBuilder()
      .withItems(updatedService, updatedConfigMap).build();
  }

  @Test
  void testCreateOrReplace() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();

    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_CREATED, pod1).once();

    List<HasMetadata> response = client.resourceList(new PodListBuilder().addToItems(pod1).build()).createOrReplace();
    assertTrue(response.contains(pod1));
  }

  @Test
  void testCreateOrReplaceFailedCreate() {
    // Given
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(HttpURLConnection.HTTP_UNAVAILABLE, pod1).once();
    NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> listOp = client.resourceList(new PodListBuilder().addToItems(pod1).build());

    // When
    assertThrows(KubernetesClientException.class, listOp::createOrReplace);
  }

  @Test
  void testCreateWithExplicitNamespace() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();

    server.expect().post().withPath("/api/v1/namespaces/ns1/pods").andReturn(HttpURLConnection.HTTP_CREATED, pod1).once();

    List<HasMetadata> response = client.resourceList(new PodListBuilder().addToItems(pod1).build()).inNamespace("ns1").apply();
    assertTrue(response.contains(pod1));
  }

  @Test
  void testDelete() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").withNamespace("ns1").and().build();
    Pod pod3 = new PodBuilder().withNewMetadata().withName("pod3").withNamespace("any").and().build();


    server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(HttpURLConnection.HTTP_OK, pod1).times(2);
    server.expect().withPath("/api/v1/namespaces/ns1/pods/pod2").andReturn(HttpURLConnection.HTTP_OK, pod2).times(2);
    server.expect().withPath("/api/v1/namespaces/any/pods/pod3").andReturn(HttpURLConnection.HTTP_OK, pod3).times(1);

    //First time all items should be deleted.
    Boolean deleted = client.resourceList(new PodListBuilder().withItems(pod1, pod2, pod3).build()).delete();
    assertTrue(deleted);

    //Now we expect pod3 to fail.
    deleted = client.resourceList(new PodListBuilder().withItems(pod1, pod2, pod3).build()).delete();
    assertFalse(deleted);
  }

  @Test
  void testCreateOrReplaceWithoutDeleteExisting() throws Exception {
    server.expect().post().withPath("/api/v1/namespaces/ns1/services").andReturn(HttpURLConnection.HTTP_CONFLICT, service).once();
    server.expect().post().withPath("/api/v1/namespaces/ns1/configmaps").andReturn(HttpURLConnection.HTTP_CONFLICT, configMap).once();
    server.expect().get().withPath("/api/v1/namespaces/ns1/services/my-service").andReturn(HttpURLConnection.HTTP_OK , service).once();
    server.expect().get().withPath("/api/v1/namespaces/ns1/configmaps/my-configmap").andReturn(HttpURLConnection.HTTP_OK, configMap).once();
    server.expect().put().withPath("/api/v1/namespaces/ns1/services/my-service").andReturn(HttpURLConnection.HTTP_OK, updatedService).once();
    server.expect().put().withPath("/api/v1/namespaces/ns1/configmaps/my-configmap").andReturn(HttpURLConnection.HTTP_OK, updatedConfigMap).once();

    client.resourceList(resourcesToUpdate).inNamespace("ns1").createOrReplace();

    assertEquals(6, server.getMockServer().getRequestCount());
    RecordedRequest request = server.getLastRequest();
    assertEquals("/api/v1/namespaces/ns1/configmaps/my-configmap", request.getPath());
    assertEquals("PUT", request.getMethod());
  }

  @Test
  void testCreateOrReplaceWithDeleteExisting() throws Exception {
    server.expect().post().withPath("/api/v1/namespaces/ns1/services").andReturn(HttpURLConnection.HTTP_CONFLICT, service).once();
    server.expect().post().withPath("/api/v1/namespaces/ns1/configmaps").andReturn(HttpURLConnection.HTTP_CONFLICT, configMap).once();
    server.expect().delete().withPath("/api/v1/namespaces/ns1/services/my-service").andReturn(HttpURLConnection.HTTP_OK , service).once();
    server.expect().delete().withPath("/api/v1/namespaces/ns1/configmaps/my-configmap").andReturn(HttpURLConnection.HTTP_OK, configMap).once();
    server.expect().post().withPath("/api/v1/namespaces/ns1/services").andReturn(HttpURLConnection.HTTP_OK, updatedService).once();
    server.expect().post().withPath("/api/v1/namespaces/ns1/configmaps").andReturn(HttpURLConnection.HTTP_OK, updatedConfigMap).once();

    client.resourceList(resourcesToUpdate).inNamespace("ns1").deletingExisting().createOrReplace();

    assertEquals(6, server.getMockServer().getRequestCount());
    RecordedRequest request = server.getLastRequest();
    assertEquals("/api/v1/namespaces/ns1/configmaps", request.getPath());
    assertEquals("POST", request.getMethod());
  }

  private static ServiceBuilder mockService() {
    return new ServiceBuilder()
      .withNewMetadata().withName("my-service").endMetadata()
      .withNewSpec()
      .addToSelector("app", "my-app")
      .addNewPort().withProtocol("TCP").withPort(80).withTargetPort(new IntOrString(9376)).endPort()
      .endSpec();
  }

  private static ConfigMapBuilder mockConfigMap() {
    return new ConfigMapBuilder()
      .withNewMetadata().withName("my-configmap").endMetadata()
      .addToData(Collections.singletonMap("app", "my-app"));
  }
}
