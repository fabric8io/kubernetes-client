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

import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.PartialObjectMetadata;
import io.fabric8.kubernetes.api.model.PartialObjectMetadataList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.mockwebserver.http.RecordedRequest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(https = false)
class PartialObjectMetadataAcceptHeaderTest {

  private static final String EXPECTED_GET_ACCEPT = "application/json;as=PartialObjectMetadata;g=meta.k8s.io;v=v1,"
      + "application/json;as=PartialObjectMetadata;g=meta.k8s.io;v=v1beta1,"
      + "application/json";
  private static final String EXPECTED_LIST_ACCEPT = "application/json;as=PartialObjectMetadataList;g=meta.k8s.io;v=v1,"
      + "application/json;as=PartialObjectMetadataList;g=meta.k8s.io;v=v1beta1,"
      + "application/json";

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void getSendsCorrectAcceptHeader() throws InterruptedException {
    server.expect().get()
        .withPath("/api/v1/namespaces/default/pods/my-pod")
        .andReturn(200, podPartialMetadata("my-pod", "default"))
        .once();

    client.pods().inNamespace("default").withName("my-pod").getAsPartialObjectMetadata();

    RecordedRequest request = server.getLastRequest();
    assertThat(request.getHeader("Accept")).isEqualTo(EXPECTED_GET_ACCEPT);
  }

  @Test
  void listSendsCorrectAcceptHeader() throws InterruptedException {
    server.expect().get()
        .withPath("/api/v1/namespaces/default/pods")
        .andReturn(200, partialMetadataList(podPartialMetadata("pod-1", "default")))
        .once();

    client.pods().inNamespace("default").listAsPartialObjectMetadata();

    RecordedRequest request = server.getLastRequest();
    assertThat(request.getHeader("Accept")).isEqualTo(EXPECTED_LIST_ACCEPT);
  }

  @Test
  void getAcceptHeaderForNonCoreApiResources() throws InterruptedException {
    server.expect().get()
        .withPath("/apis/apps/v1/namespaces/staging/deployments/my-deploy")
        .andReturn(200, deploymentPartialMetadata("my-deploy", "staging"))
        .once();

    client.apps().deployments().inNamespace("staging").withName("my-deploy").getAsPartialObjectMetadata();

    RecordedRequest request = server.getLastRequest();
    assertThat(request.getHeader("Accept")).isEqualTo(EXPECTED_GET_ACCEPT);
  }

  @Test
  void listAcceptHeaderForClusterScopedResources() throws InterruptedException {
    server.expect().get()
        .withPath("/api/v1/nodes")
        .andReturn(200, partialMetadataList(clusterScopedPartialMetadata("node-1")))
        .once();

    client.nodes().listAsPartialObjectMetadata();

    RecordedRequest request = server.getLastRequest();
    assertThat(request.getHeader("Accept")).isEqualTo(EXPECTED_LIST_ACCEPT);
  }

  @Test
  void listAcceptHeaderInAnyNamespace() throws InterruptedException {
    server.expect().get()
        .withPath("/apis/apps/v1/deployments")
        .andReturn(200, partialMetadataList(deploymentPartialMetadata("deploy-a", "ns-1")))
        .once();

    client.apps().deployments().inAnyNamespace().listAsPartialObjectMetadata();

    RecordedRequest request = server.getLastRequest();
    assertThat(request.getHeader("Accept")).isEqualTo(EXPECTED_LIST_ACCEPT);
  }

  @Test
  void getReturnsNullOn404() {
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

  private static PartialObjectMetadata podPartialMetadata(String name, String namespace) {
    PartialObjectMetadata meta = new PartialObjectMetadata();
    meta.setApiVersion("v1");
    meta.setKind("PartialObjectMetadata");
    meta.setMetadata(new ObjectMetaBuilder().withName(name).withNamespace(namespace).build());
    return meta;
  }

  private static PartialObjectMetadata deploymentPartialMetadata(String name, String namespace) {
    PartialObjectMetadata meta = new PartialObjectMetadata();
    meta.setApiVersion("apps/v1");
    meta.setKind("PartialObjectMetadata");
    meta.setMetadata(new ObjectMetaBuilder().withName(name).withNamespace(namespace).build());
    return meta;
  }

  private static PartialObjectMetadata clusterScopedPartialMetadata(String name) {
    PartialObjectMetadata meta = new PartialObjectMetadata();
    meta.setApiVersion("v1");
    meta.setKind("PartialObjectMetadata");
    meta.setMetadata(new ObjectMetaBuilder().withName(name).build());
    return meta;
  }

  private static PartialObjectMetadataList partialMetadataList(PartialObjectMetadata... items) {
    PartialObjectMetadataList list = new PartialObjectMetadataList();
    list.setItems(Arrays.asList(items));
    return list;
  }
}
