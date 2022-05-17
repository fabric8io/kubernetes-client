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

import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.api.model.SecretBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.api.model.ServiceListBuilder;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.apps.StatefulSetBuilder;
import io.fabric8.kubernetes.api.model.batch.v1.JobBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.mock.crd.PodSet;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class PropagationPolicyTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  @DisplayName("Should delete a ConfigMap with PropagationPolicy=Background")
  void testDeleteConfigMap() throws InterruptedException {
    // Given
    server.expect().delete().withPath("/api/v1/namespaces/ns1/configmaps/myconfigMap")
        .andReturn(HttpURLConnection.HTTP_OK, new ConfigMapBuilder().build())
        .once();

    // When
    boolean isDeleted = client.configMaps().inNamespace("ns1").withName("myconfigMap").delete().size() == 1;

    // Then
    assertTrue(isDeleted);
    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.BACKGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a ConfigMap with specified PropagationPolicy")
  void testDeleteConfigMapWithExplicitPropagationPolicy() throws InterruptedException {
    // Given
    server.expect().delete().withPath("/api/v1/namespaces/ns1/configmaps/myconfigMap")
        .andReturn(HttpURLConnection.HTTP_OK, new ConfigMapBuilder().build())
        .once();

    // When
    boolean isDeleted = client.configMaps().inNamespace("ns1").withName("myconfigMap")
        .withPropagationPolicy(DeletionPropagation.FOREGROUND).delete().size() == 1;

    // Then
    assertTrue(isDeleted);
    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.FOREGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a Service with PropagationPolicy=Background")
  void testDeleteService() throws InterruptedException {
    // Given
    server.expect().delete().withPath("/api/v1/namespaces/ns1/services/myservice")
        .andReturn(HttpURLConnection.HTTP_OK, new ServiceBuilder().build())
        .once();

    // When
    boolean isDeleted = client.services().inNamespace("ns1").withName("myservice").delete().size() == 1;

    // Then
    assertTrue(isDeleted);
    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.BACKGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a Service with specified PropagationPolicy")
  void testDeleteServiceWithPropagationPolicy() throws InterruptedException {
    // Given
    server.expect().delete().withPath("/api/v1/namespaces/ns1/services/myservice")
        .andReturn(HttpURLConnection.HTTP_OK, new ServiceBuilder().build())
        .once();

    // When
    boolean isDeleted = client.services().inNamespace("ns1").withName("myservice").delete().size() == 1;

    // Then
    assertTrue(isDeleted);
    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.BACKGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a Service with PropagationPolicy=Background")
  void testDeleteSecret() throws InterruptedException {
    // Given
    server.expect().delete().withPath("/api/v1/namespaces/ns1/secrets/mysecret")
        .andReturn(HttpURLConnection.HTTP_OK, new SecretBuilder().build())
        .once();

    // When
    boolean isDeleted = client.secrets().inNamespace("ns1").withName("mysecret").delete().size() == 1;

    // Then
    assertTrue(isDeleted);
    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.BACKGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a Secret with specified PropagationPolicy")
  void testDeleteSecretWithExplicitPropagationPolicy() throws InterruptedException {
    // Given
    server.expect().delete().withPath("/api/v1/namespaces/ns1/secrets/mysecret")
        .andReturn(HttpURLConnection.HTTP_OK, new SecretBuilder().build())
        .once();

    // When
    boolean isDeleted = client.secrets().inNamespace("ns1").withName("mysecret")
        .withPropagationPolicy(DeletionPropagation.FOREGROUND).delete().size() == 1;

    // Then
    assertTrue(isDeleted);
    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.FOREGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a Deployment with PropagationPolicy=Background")
  void testDeleteDeployment() throws InterruptedException {
    // Given
    server.expect().delete().withPath("/apis/apps/v1/namespaces/ns1/deployments/mydeployment")
        .andReturn(HttpURLConnection.HTTP_OK, new DeploymentBuilder().build())
        .once();

    // When
    boolean isDeleted = client.apps().deployments().inNamespace("ns1").withName("mydeployment").delete().size() == 1;

    // Then
    assertTrue(isDeleted);
    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.BACKGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a Deployment with explicitly set PropagationPolicy")
  void testDeleteDeploymentWithExplicitPropagationPolicy() throws InterruptedException {
    // Given
    server.expect().delete().withPath("/apis/apps/v1/namespaces/ns1/deployments/mydeployment")
        .andReturn(HttpURLConnection.HTTP_OK, new DeploymentBuilder().build())
        .once();

    // When
    boolean isDeleted = client.apps().deployments().inNamespace("ns1").withName("mydeployment")
        .withPropagationPolicy(DeletionPropagation.FOREGROUND).delete().size() == 1;

    // Then
    assertTrue(isDeleted);
    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.FOREGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a Deployment with explicitly set PropagationPolicy And Grace Period")
  void testDeleteDeploymentWithExplicitPropagationPolicyAndGracePeriod() throws InterruptedException {
    // Given
    server.expect().delete().withPath("/apis/apps/v1/namespaces/ns1/deployments/mydeployment")
        .andReturn(HttpURLConnection.HTTP_OK, new DeploymentBuilder().build())
        .once();

    // When
    boolean isDeleted = client.apps().deployments().inNamespace("ns1").withName("mydeployment")
        .withPropagationPolicy(DeletionPropagation.FOREGROUND).withGracePeriod(10).delete().size() == 1;

    // Then
    assertTrue(isDeleted);
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"gracePeriodSeconds\":10,\"propagationPolicy\":\""
        + DeletionPropagation.FOREGROUND + "\"}", server.getLastRequest().getBody().readUtf8());
  }

  @Test
  @DisplayName("Should delete a StatefulSet with PropagationPolicy=Background")
  void testDeleteStatefulSet() throws InterruptedException {
    // Given
    server.expect().delete().withPath("/apis/apps/v1/namespaces/ns1/statefulsets/mystatefulset")
        .andReturn(HttpURLConnection.HTTP_OK, new StatefulSetBuilder().build())
        .once();

    // When
    boolean isDeleted = client.apps().statefulSets().inNamespace("ns1").withName("mystatefulset").delete().size() == 1;

    // Then
    assertTrue(isDeleted);
    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.BACKGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a StatefulSet with explicitly set PropagationPolicy")
  void testDeleteStatefulSetWithExplicitPropagationPolicy() throws InterruptedException {
    // Given
    server.expect().delete().withPath("/apis/apps/v1/namespaces/ns1/statefulsets/mystatefulset")
        .andReturn(HttpURLConnection.HTTP_OK, new StatefulSetBuilder().build())
        .once();

    // When
    boolean isDeleted = client.apps().statefulSets().inNamespace("ns1").withName("mystatefulset")
        .withPropagationPolicy(DeletionPropagation.FOREGROUND).delete().size() == 1;

    // Then
    assertTrue(isDeleted);

    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.FOREGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a ReplicationController with PropagationPolicy=Background")
  void testDeleteReplicationController() throws InterruptedException {
    // Given
    server.expect().delete().withPath("/api/v1/namespaces/ns1/replicationcontrollers/myreplicationcontroller")
        .andReturn(HttpURLConnection.HTTP_OK, new ReplicationControllerBuilder().build())
        .once();

    // When
    boolean isDeleted = client.replicationControllers().inNamespace("ns1").withName("myreplicationcontroller").delete()
        .size() == 1;

    // Then
    assertTrue(isDeleted);

    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.BACKGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a ReplicationController with explicitly specified PropagationPolicy")
  void testDeleteReplicationControllerWithExplicitPropagationPolicy() throws InterruptedException {
    // Given
    server.expect().delete().withPath("/api/v1/namespaces/ns1/replicationcontrollers/myreplicationcontroller")
        .andReturn(HttpURLConnection.HTTP_OK, new ReplicationControllerBuilder().build())
        .once();

    // When
    boolean isDeleted = client.replicationControllers().inNamespace("ns1").withName("myreplicationcontroller")
        .withPropagationPolicy(DeletionPropagation.ORPHAN).delete().size() == 1;

    // Then
    assertTrue(isDeleted);

    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.ORPHAN.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a Job with PropagationPolicy=Background")
  void testDeleteJob() throws InterruptedException {
    // Given
    server.expect().delete().withPath("/apis/batch/v1/namespaces/ns1/jobs/myjob")
        .andReturn(HttpURLConnection.HTTP_OK, new JobBuilder().build())
        .once();

    // When
    boolean isDeleted = client.batch().jobs().inNamespace("ns1").withName("myjob").delete().size() == 1;

    // Then
    assertTrue(isDeleted);

    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.BACKGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a Job with explicitly set PropagationPolicy")
  void testDeleteJobWithExplicitPropagationPolicy() throws InterruptedException {
    // Given
    server.expect().delete().withPath("/apis/batch/v1/namespaces/ns1/jobs/myjob")
        .andReturn(HttpURLConnection.HTTP_OK, new JobBuilder().build())
        .once();

    // When
    boolean isDeleted = client.batch().jobs().inNamespace("ns1").withName("myjob")
        .withPropagationPolicy(DeletionPropagation.FOREGROUND).delete().size() == 1;

    // Then
    assertTrue(isDeleted);

    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.FOREGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a resource with PropagationPolicy=Background")
  void testDeleteResource() throws InterruptedException {
    // Given
    Pod testPod = new PodBuilder().withNewMetadata().withName("testpod").endMetadata().build();
    server.expect().delete().withPath("/api/v1/namespaces/foo/pods/testpod")
        .andReturn(HttpURLConnection.HTTP_OK, testPod)
        .once();

    // When
    Boolean isDeleted = client.resource(testPod).inNamespace("foo").delete().size() == 1;

    // Then
    assertTrue(isDeleted);

    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.BACKGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a resource with specified PropagationPolicy")
  void testDeleteResourceWithSpecifiedPropagationPolicy() throws InterruptedException {
    // Given
    Pod testPod = new PodBuilder().withNewMetadata().withName("testpod").endMetadata().build();
    server.expect().delete().withPath("/api/v1/namespaces/foo/pods/testpod")
        .andReturn(HttpURLConnection.HTTP_OK, testPod)
        .once();

    // When
    Boolean isDeleted = client.resource(testPod).inNamespace("foo").withPropagationPolicy(DeletionPropagation.FOREGROUND)
        .delete().size() == 1;

    // Then
    assertTrue(isDeleted);

    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.FOREGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should deletea resource with specified Propagation policy and Grace Period")
  void testDeleteResourceWithSpecifiedPropagationPolicyAndGracePeriod() throws InterruptedException {
    // Given
    Pod testPod = new PodBuilder().withNewMetadata().withName("testpod").endMetadata().build();
    server.expect().delete().withPath("/api/v1/namespaces/foo/pods/testpod")
        .andReturn(HttpURLConnection.HTTP_OK, testPod)
        .once();

    // When
    Boolean isDeleted = client.resource(testPod).inNamespace("foo").withPropagationPolicy(DeletionPropagation.FOREGROUND)
        .withGracePeriod(5L).delete().size() == 1;

    // Then
    assertTrue(isDeleted);

    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"gracePeriodSeconds\":5,\"propagationPolicy\":\""
        + DeletionPropagation.FOREGROUND.toString() + "\"}", server.getLastRequest().getBody().readUtf8());
  }

  @Test
  @DisplayName("Should delete a resource list with PropagationPolicy=Background")
  void testDeleteResourceList() throws InterruptedException {
    // Given
    Pod testPod = new PodBuilder().withNewMetadata().withName("testpod").endMetadata().build();
    server.expect().delete().withPath("/api/v1/namespaces/foo/pods/testpod")
        .andReturn(HttpURLConnection.HTTP_OK, testPod)
        .once();

    // When
    Boolean isDeleted = client.resourceList(new KubernetesListBuilder().withItems(testPod).build()).inNamespace("foo").delete()
        .size() == 1;

    // Then
    assertTrue(isDeleted);

    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.BACKGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a resource list with specified PropagationPolicy")
  void testDeleteResourceListWithSpecifiedPropagationPolicy() throws InterruptedException {
    // Given
    Pod testPod = new PodBuilder().withNewMetadata().withName("testpod").endMetadata().build();
    server.expect().delete().withPath("/api/v1/namespaces/foo/pods/testpod")
        .andReturn(HttpURLConnection.HTTP_OK, testPod)
        .once();

    // When
    Boolean isDeleted = client.resourceList(new KubernetesListBuilder().withItems(testPod).build()).inNamespace("foo")
        .withPropagationPolicy(DeletionPropagation.FOREGROUND).delete().size() == 1;

    // Then
    assertTrue(isDeleted);

    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.FOREGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a resource list with specified PropagationPolicy")
  void testDeleteResourceListWithSpecifiedPropagationPolicyAndGracePeriod() throws InterruptedException {
    // Given
    Pod testPod = new PodBuilder().withNewMetadata().withName("testpod").endMetadata().build();
    server.expect().delete().withPath("/api/v1/namespaces/foo/pods/testpod")
        .andReturn(HttpURLConnection.HTTP_OK, testPod)
        .once();

    // When
    Boolean isDeleted = client.resourceList(new KubernetesListBuilder().withItems(testPod).build()).inNamespace("foo")
        .withGracePeriod(10L).withPropagationPolicy(DeletionPropagation.FOREGROUND).delete().size() == 1;

    // Then
    assertTrue(isDeleted);

    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"gracePeriodSeconds\":10,\"propagationPolicy\":\""
        + DeletionPropagation.FOREGROUND.toString() + "\"}", server.getLastRequest().getBody().readUtf8());
  }

  @Test
  @DisplayName("Should delete a Raw Custom Resource with PropagationPolicy=Background")
  void testDeleteRawCustomResource() throws InterruptedException, IOException {
    // Given
    server.expect().delete().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello")
        .andReturn(HttpURLConnection.HTTP_OK,
            "{\"metadata\":{},\"apiVersion\":\"v1\",\"kind\":\"Status\",\"details\":{\"name\":\"prometheus-example-rules\",\"group\":\"monitoring.coreos.com\",\"kind\":\"prometheusrules\",\"uid\":\"b3d085bd-6a5c-11e9-8787-525400b18c1d\"},\"status\":\"Success\"}")
        .once();

    // When
    boolean result = client.genericKubernetesResources(new CustomResourceDefinitionContext.Builder()
        .withGroup("test.fabric8.io")
        .withName("hellos.test.fabric8.io")
        .withPlural("hellos")
        .withScope("Namespaced")
        .withVersion("v1alpha1")
        .build())
        .inNamespace("ns1").withName("example-hello").delete().size() == 1;

    // Then
    assertTrue(result);

    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.BACKGROUND.toString(), server.getLastRequest());
  }

  @Test
  @DisplayName("Should delete a Custom Resource with PropagationPolicy=Background")
  void testDeleteCustomResource() throws InterruptedException {
    // Given
    server.expect().delete().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets/example-podset")
        .andReturn(HttpURLConnection.HTTP_OK, new PodSet()).once();
    MixedOperation<PodSet, KubernetesResourceList<PodSet>, Resource<PodSet>> podSetClient = client
        .resources(PodSet.class);

    // When
    boolean isDeleted = podSetClient.inNamespace("test").withName("example-podset").delete().size() == 1;

    // Then
    assertTrue(isDeleted);

    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.BACKGROUND.toString(), server.getLastRequest());
  }

  @Test
  void testFilterWithLabelDeletion() throws InterruptedException {
    // Given
    KubernetesClient kubernetesClient = setMockExpectationsForFilterDeletionAndGetClient("labelSelector=myLabel");

    // When
    Boolean isDeleted = kubernetesClient.services().inNamespace("myNameSpace").withLabel("myLabel")
        .withPropagationPolicy(DeletionPropagation.BACKGROUND).delete().size() == 2;

    // Then
    RecordedRequest recordedRequest = server.getLastRequest();
    assertTrue(isDeleted);
    assertEquals("DELETE", recordedRequest.getMethod());
    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.BACKGROUND.toString(), recordedRequest);
  }

  @Test
  void testFilterWithLabelsDeletion() throws InterruptedException {
    // Given
    KubernetesClient kubernetesClient = setMockExpectationsForFilterDeletionAndGetClient(
        "labelSelector=" + Utils.toUrlEncoded("foo=bar"));

    // When
    Boolean isDeleted = kubernetesClient.services().inNamespace("myNameSpace")
        .withLabels(Collections.singletonMap("foo", "bar")).withPropagationPolicy(DeletionPropagation.BACKGROUND).delete()
        .size() == 2;

    // Then
    assertTrue(isDeleted);
    RecordedRequest recordedRequest = server.getLastRequest();
    assertEquals("DELETE", recordedRequest.getMethod());
    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.BACKGROUND.toString(), recordedRequest);
  }

  @Test
  void testFilterWithFieldDeletion() throws InterruptedException {
    // Given
    KubernetesClient kubernetesClient = setMockExpectationsForFilterDeletionAndGetClient(
        "fieldSelector=" + Utils.toUrlEncoded("status.phase=Running"));

    // When
    Boolean isDeleted = kubernetesClient.services().inNamespace("myNameSpace").withField("status.phase", "Running")
        .withPropagationPolicy(DeletionPropagation.BACKGROUND).delete().size() == 2;

    // Then
    assertTrue(isDeleted);
    RecordedRequest recordedRequest = server.getLastRequest();
    assertEquals("DELETE", recordedRequest.getMethod());
    assertDeleteOptionsInLastRecordedRequest(DeletionPropagation.BACKGROUND.toString(), recordedRequest);

  }

  private KubernetesClient setMockExpectationsForFilterDeletionAndGetClient(String filter) {
    Service svc1 = new ServiceBuilder().withNewMetadata().withName("svc1").endMetadata().build();
    Service svc2 = new ServiceBuilder().withNewMetadata().withName("svc2").endMetadata().build();
    server.expect().delete().withPath("/api/v1/namespaces/myNameSpace/services?" + filter)
        .andReturn(HttpURLConnection.HTTP_OK, new ServiceListBuilder().addToItems(svc1, svc2).build())
        .once();
    return client;
  }

  private void assertDeleteOptionsInLastRecordedRequest(String propagationPolicy, RecordedRequest recordedRequest) {
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"" + propagationPolicy + "\"}",
        recordedRequest.getBody().readUtf8());
  }

}
