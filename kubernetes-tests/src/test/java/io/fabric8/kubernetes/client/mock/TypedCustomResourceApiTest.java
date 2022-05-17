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

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.CustomResourceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.mock.crd.PodSet;
import io.fabric8.kubernetes.client.mock.crd.PodSetSpec;
import io.fabric8.kubernetes.client.mock.crd.PodSetStatus;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class TypedCustomResourceApiTest {

  KubernetesMockServer server;
  KubernetesClient client;

  private MixedOperation<PodSet, KubernetesResourceList<PodSet>, Resource<PodSet>> podSetClient;

  @Test
  void create() {
    server.expect().post().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets").andReturn(200, getPodSet()).once();

    podSetClient = client.resources(PodSet.class);

    PodSet returnedPodSet = podSetClient.inNamespace("test").create(getPodSet());
    assertNotNull(returnedPodSet);
    assertEquals("example-podset", returnedPodSet.getMetadata().getName());
  }

  @Test
  void list() {
    KubernetesResourceList<PodSet> podSetList = new CustomResourceList<>();
    ((CustomResourceList<PodSet>) podSetList).setItems(Collections.singletonList(getPodSet()));
    server.expect().get().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets").andReturn(200, podSetList).once();
    podSetClient = client.resources(PodSet.class);

    podSetList = podSetClient.inNamespace("test").list();
    assertNotNull(podSetList);
    assertEquals(1, podSetList.getItems().size());
    assertEquals("example-podset", podSetList.getItems().get(0).getMetadata().getName());
  }

  @Test
  void createOrReplace() {
    server.expect().get().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets/example-podset")
        .andReturn(HttpURLConnection.HTTP_OK, getPodSet()).times(2);
    server.expect().post().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets")
        .andReturn(HttpURLConnection.HTTP_CONFLICT, getPodSet()).times(2);
    server.expect().put().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets/example-podset")
        .andReturn(HttpURLConnection.HTTP_OK, getPodSet()).once();

    podSetClient = client.resources(PodSet.class);
    PodSet returnedPodSet = podSetClient.inNamespace("test").createOrReplace(getPodSet());

    assertNotNull(returnedPodSet);
    assertEquals("example-podset", returnedPodSet.getMetadata().getName());
  }

  @Test
  void delete() {
    server.expect().delete().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets/example-podset")
        .andReturn(200, getPodSet()).once();

    podSetClient = client.resources(PodSet.class);

    boolean isDeleted = podSetClient.inNamespace("test").withName("example-podset").delete().size() == 1;
    assertTrue(isDeleted);
  }

  @Test
  void testCascadingDeletion() throws InterruptedException {
    server.expect().delete().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets/example-podset")
        .andReturn(200, getPodSet()).once();

    podSetClient = client.resources(PodSet.class);

    boolean isDeleted = podSetClient.inNamespace("test").withName("example-podset").cascading(true).delete().size() == 1;
    assertTrue(isDeleted);

    RecordedRequest recordedRequest = server.getLastRequest();
    assertEquals("DELETE", recordedRequest.getMethod());
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Background\"}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  void testPropagationPolicyDeletion() throws InterruptedException {
    server.expect().delete().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets/example-podset")
        .andReturn(200, getPodSet()).once();

    podSetClient = client.resources(PodSet.class);

    boolean isDeleted = podSetClient.inNamespace("test").withName("example-podset")
        .withPropagationPolicy(DeletionPropagation.ORPHAN).delete().size() == 1;
    assertTrue(isDeleted);

    RecordedRequest recordedRequest = server.getLastRequest();
    assertEquals("DELETE", recordedRequest.getMethod());
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  void testStatusUpdate() throws InterruptedException {
    PodSet updatedPodSet = getPodSet();
    updatedPodSet.getMetadata().setResourceVersion("1");
    PodSetStatus podSetStatus = new PodSetStatus();
    podSetStatus.setAvailableReplicas(4);
    updatedPodSet.setStatus(podSetStatus);

    server.expect().put().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets/example-podset/status")
        .andReturn(200, updatedPodSet).once();
    podSetClient = client.resources(PodSet.class);

    podSetClient.inNamespace("test").updateStatus(updatedPodSet);
    RecordedRequest recordedRequest = server.getLastRequest();
    assertEquals("PUT", recordedRequest.getMethod());
    assertEquals(
        "{\"apiVersion\":\"demo.k8s.io/v1alpha1\",\"kind\":\"PodSet\",\"metadata\":{\"name\":\"example-podset\",\"resourceVersion\":\"1\"},\"spec\":{\"replicas\":5},\"status\":{\"availableReplicas\":4}}",
        recordedRequest.getBody().readUtf8());
  }

  private PodSet getPodSet() {
    PodSetSpec podSetSpec = new PodSetSpec();
    podSetSpec.setReplicas(5);

    PodSet podSet = new PodSet();
    podSet.setApiVersion("demo.k8s.io/v1alpha1");
    podSet.setMetadata(new ObjectMetaBuilder().withName("example-podset").build());
    podSet.setSpec(podSetSpec);
    return podSet;
  }
}
