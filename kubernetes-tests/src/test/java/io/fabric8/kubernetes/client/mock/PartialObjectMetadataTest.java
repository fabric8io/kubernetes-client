/*
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

import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.PartialObjectMetadata;
import io.fabric8.kubernetes.api.model.PartialObjectMetadataList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.mockwebserver.http.RecordedRequest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for PartialObjectMetadata support: fetching only resource metadata
 * (omitting spec and status) via server-side content negotiation.
 */
@EnableKubernetesMockClient
class PartialObjectMetadataTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void getPartialMetadataOfPodReturnsOnlyMetadataFields() throws InterruptedException {
    server.expect().get()
        .withPath("/api/v1/namespaces/default/pods/my-pod")
        .andReturn(200, podPartialMetadata("my-pod", "default", "app", "backend", "version", "v1"))
        .once();

    PartialObjectMetadata result = client.pods()
        .inNamespace("default")
        .withName("my-pod")
        .getAsPartialObjectMetadata();

    assertThat(result).isNotNull();
    assertThat(result.getMetadata().getName()).isEqualTo("my-pod");
    assertThat(result.getMetadata().getNamespace()).isEqualTo("default");
    assertThat(result.getMetadata().getLabels())
        .containsEntry("app", "backend")
        .containsEntry("version", "v1");

    RecordedRequest request = server.getLastRequest();
    assertThat(request.getHeader("Accept"))
        .isEqualTo("application/json;as=PartialObjectMetadata;g=meta.k8s.io;v=v1");
  }

  @Test
  void listPartialMetadataOfPodsInNamespaceReturnsAllItems() throws InterruptedException {
    PartialObjectMetadataList podList = partialMetadataList(
        podPartialMetadata("pod-1", "production"),
        podPartialMetadata("pod-2", "production"),
        podPartialMetadata("pod-3", "production"));

    server.expect().get()
        .withPath("/api/v1/namespaces/production/pods")
        .andReturn(200, podList)
        .once();

    PartialObjectMetadataList result = client.pods()
        .inNamespace("production")
        .listAsPartialObjectMetadata();

    assertThat(result.getItems())
        .hasSize(3)
        .extracting("metadata.name")
        .containsExactly("pod-1", "pod-2", "pod-3");

    RecordedRequest request = server.getLastRequest();
    assertThat(request.getHeader("Accept"))
        .isEqualTo("application/json;as=PartialObjectMetadataList;g=meta.k8s.io;v=v1");
  }

  @Test
  void listPartialMetadataWithLabelSelectorOnlyReturnsMatchingResources() {
    PartialObjectMetadataList filteredList = partialMetadataList(
        podPartialMetadata("app-pod-1", "default", "app", "my-app"),
        podPartialMetadata("app-pod-2", "default", "app", "my-app"));

    server.expect().get()
        .withPath("/api/v1/namespaces/default/pods?labelSelector=" + Utils.toUrlEncoded("app=my-app"))
        .andReturn(200, filteredList)
        .once();

    PartialObjectMetadataList result = client.pods()
        .inNamespace("default")
        .withLabel("app", "my-app")
        .listAsPartialObjectMetadata();

    assertThat(result.getItems())
        .hasSize(2)
        .extracting("metadata.name")
        .containsExactly("app-pod-1", "app-pod-2");
  }

  @Test
  void listPartialMetadataWithLimitOptionReturnsPaginatedResults() {
    PartialObjectMetadataList page = partialMetadataList(
        podPartialMetadata("pod-1", "default"),
        podPartialMetadata("pod-2", "default"));

    server.expect().get()
        .withPath("/api/v1/namespaces/default/pods?limit=2")
        .andReturn(200, page)
        .once();

    PartialObjectMetadataList result = client.pods()
        .inNamespace("default")
        .listAsPartialObjectMetadata(new ListOptionsBuilder().withLimit(2L).build());

    assertThat(result.getItems()).hasSize(2);
  }

  @Test
  void getPartialMetadataWorksForNonCoreApiResources() {
    PartialObjectMetadata deployment = new PartialObjectMetadata();
    deployment.setApiVersion("apps/v1");
    deployment.setKind("PartialObjectMetadata");
    deployment.setMetadata(new ObjectMetaBuilder()
        .withName("my-deploy")
        .withNamespace("staging")
        .addToAnnotations("deployment.kubernetes.io/revision", "3")
        .build());

    server.expect().get()
        .withPath("/apis/apps/v1/namespaces/staging/deployments/my-deploy")
        .andReturn(200, deployment)
        .once();

    PartialObjectMetadata result = client.apps().deployments()
        .inNamespace("staging")
        .withName("my-deploy")
        .getAsPartialObjectMetadata();

    assertThat(result.getMetadata().getName()).isEqualTo("my-deploy");
    assertThat(result.getMetadata().getAnnotations())
        .containsEntry("deployment.kubernetes.io/revision", "3");
  }

  @Test
  void listPartialMetadataForDeploymentsAcrossNamespace() {
    PartialObjectMetadataList deployList = partialMetadataList(
        deploymentPartialMetadata("deploy-a", "ns-1", "env", "prod"),
        deploymentPartialMetadata("deploy-b", "ns-2", "env", "staging"));

    server.expect().get()
        .withPath("/apis/apps/v1/deployments")
        .andReturn(200, deployList)
        .once();

    PartialObjectMetadataList result = client.apps().deployments()
        .inAnyNamespace()
        .listAsPartialObjectMetadata();

    assertThat(result.getItems())
        .hasSize(2)
        .extracting("metadata.namespace")
        .containsExactlyInAnyOrder("ns-1", "ns-2");
  }

  @Test
  void getPartialMetadataOfClusterScopedResourceHasNoNamespaceInUrl() {
    PartialObjectMetadata node = new PartialObjectMetadata();
    node.setApiVersion("v1");
    node.setKind("PartialObjectMetadata");
    node.setMetadata(new ObjectMetaBuilder()
        .withName("worker-node-1")
        .addToLabels("kubernetes.io/role", "worker")
        .build());

    server.expect().get()
        .withPath("/api/v1/nodes/worker-node-1")
        .andReturn(200, node)
        .once();

    PartialObjectMetadata result = client.nodes()
        .withName("worker-node-1")
        .getAsPartialObjectMetadata();

    assertThat(result.getMetadata().getName()).isEqualTo("worker-node-1");
    assertThat(result.getMetadata().getLabels()).containsEntry("kubernetes.io/role", "worker");
  }

  @Test
  void listPartialMetadataOfClusterScopedResourcesHasNoNamespaceInUrl() {
    PartialObjectMetadataList nodeList = partialMetadataList(
        clusterScopedPartialMetadata("node-1", "kubernetes.io/role", "control-plane"),
        clusterScopedPartialMetadata("node-2", "kubernetes.io/role", "worker"),
        clusterScopedPartialMetadata("node-3", "kubernetes.io/role", "worker"));

    server.expect().get()
        .withPath("/api/v1/nodes")
        .andReturn(200, nodeList)
        .once();

    PartialObjectMetadataList result = client.nodes()
        .listAsPartialObjectMetadata();

    assertThat(result.getItems())
        .hasSize(3)
        .extracting("metadata.name")
        .containsExactly("node-1", "node-2", "node-3");
  }

  @Test
  void listPartialMetadataWithFieldSelectorFiltersResults() {
    PartialObjectMetadataList runningPods = partialMetadataList(
        podPartialMetadata("running-pod-1", "default"),
        podPartialMetadata("running-pod-2", "default"));

    server.expect().get()
        .withPath("/api/v1/namespaces/default/pods?fieldSelector=" + Utils.toUrlEncoded("status.phase=Running"))
        .andReturn(200, runningPods)
        .once();

    PartialObjectMetadataList result = client.pods()
        .inNamespace("default")
        .withField("status.phase", "Running")
        .listAsPartialObjectMetadata();

    assertThat(result.getItems())
        .hasSize(2)
        .extracting("metadata.name")
        .containsExactly("running-pod-1", "running-pod-2");
  }

  @Test
  void getPartialMetadataReturnsNullWhenResourceNotFound() {
    server.expect().get()
        .withPath("/api/v1/namespaces/default/pods/missing-pod")
        .andReturn(404,
            "{\"kind\":\"Status\",\"apiVersion\":\"v1\",\"status\":\"Failure\",\"reason\":\"NotFound\",\"code\":404}")
        .once();

    PartialObjectMetadata result = client.pods()
        .inNamespace("default")
        .withName("missing-pod")
        .getAsPartialObjectMetadata();

    assertThat(result).isNull();
  }

  // --- helpers ---

  private static PartialObjectMetadata podPartialMetadata(String name, String namespace, String... labels) {
    PartialObjectMetadata meta = new PartialObjectMetadata();
    meta.setApiVersion("v1");
    meta.setKind("PartialObjectMetadata");
    ObjectMetaBuilder builder = new ObjectMetaBuilder().withName(name).withNamespace(namespace);
    for (int i = 0; i + 1 < labels.length; i += 2) {
      builder.addToLabels(labels[i], labels[i + 1]);
    }
    meta.setMetadata(builder.build());
    return meta;
  }

  private static PartialObjectMetadata deploymentPartialMetadata(String name, String namespace, String... labels) {
    PartialObjectMetadata meta = new PartialObjectMetadata();
    meta.setApiVersion("apps/v1");
    meta.setKind("PartialObjectMetadata");
    ObjectMetaBuilder builder = new ObjectMetaBuilder().withName(name).withNamespace(namespace);
    for (int i = 0; i + 1 < labels.length; i += 2) {
      builder.addToLabels(labels[i], labels[i + 1]);
    }
    meta.setMetadata(builder.build());
    return meta;
  }

  private static PartialObjectMetadata clusterScopedPartialMetadata(String name, String... labels) {
    PartialObjectMetadata meta = new PartialObjectMetadata();
    meta.setApiVersion("v1");
    meta.setKind("PartialObjectMetadata");
    ObjectMetaBuilder builder = new ObjectMetaBuilder().withName(name);
    for (int i = 0; i + 1 < labels.length; i += 2) {
      builder.addToLabels(labels[i], labels[i + 1]);
    }
    meta.setMetadata(builder.build());
    return meta;
  }

  private static PartialObjectMetadataList partialMetadataList(PartialObjectMetadata... items) {
    PartialObjectMetadataList list = new PartialObjectMetadataList();
    list.setItems(Arrays.asList(items));
    return list;
  }

}