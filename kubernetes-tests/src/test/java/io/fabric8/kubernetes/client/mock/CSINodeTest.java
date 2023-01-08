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
import io.fabric8.kubernetes.api.model.storage.CSINode;
import io.fabric8.kubernetes.api.model.storage.CSINodeBuilder;
import io.fabric8.kubernetes.api.model.storage.CSINodeList;
import io.fabric8.kubernetes.api.model.storage.CSINodeListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class CSINodeTest {
  private KubernetesMockServer server;
  private KubernetesClient client;

  @Test
  void load() {
    List<HasMetadata> items = client.load(getClass().getResourceAsStream("/test-csinode.yml")).items();
    assertThat(items).isNotNull();
    AssertionsForClassTypes.assertThat(items.get(0))
        .isInstanceOf(CSINode.class)
        .hasFieldOrPropertyWithValue("metadata.name", "node1");
  }

  @Test
  void create() {
    // Given
    CSINode csiNode = createNewCSINode("csinode1");
    server.expect().post().withPath("/apis/storage.k8s.io/v1/csinodes")
        .andReturn(HttpURLConnection.HTTP_CREATED, csiNode)
        .once();

    // When
    CSINode createdCsiNode = client.storage().csiNodes().create(csiNode);

    // Then
    AssertionsForClassTypes.assertThat(createdCsiNode)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "csinode1");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/storage.k8s.io/v1/csinodes")
        .andReturn(HttpURLConnection.HTTP_OK, new CSINodeListBuilder().addToItems(createNewCSINode("c1")).build())
        .once();

    // When
    CSINodeList csiNodeList = client.storage().csiNodes().list();

    // Then
    AssertionsForClassTypes.assertThat(csiNodeList).isNotNull();
    assertThat(csiNodeList.getItems()).hasSize(1);
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/storage.k8s.io/v1/csinodes/c1")
        .andReturn(HttpURLConnection.HTTP_CREATED, createNewCSINode("c1"))
        .once();

    // When
    boolean isDeleted = client.storage().csiNodes().withName("c1").delete().size() == 1;

    // Then
    AssertionsForClassTypes.assertThat(isDeleted).isTrue();
  }

  private CSINode createNewCSINode(String name) {
    return new CSINodeBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .addNewDriver()
        .withName("mydriver.fabric8.io")
        .withNodeID("mynodeid")
        .withTopologyKeys("mycsidriver.example.com/regions", "mycsidriver.example.com/zones")
        .endDriver()
        .endSpec()
        .build();
  }
}
