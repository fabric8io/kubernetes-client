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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.NetworkAttachmentDefinition;
import io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.NetworkAttachmentDefinitionBuilder;
import io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.NetworkAttachmentDefinitionList;
import io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.NetworkAttachmentDefinitionListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class NetworkAttachmentDefinitionTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/k8s.cni.cncf.io/v1/namespaces/ns1/network-attachment-definitions/test-get")
      .andReturn(HttpURLConnection.HTTP_OK, createNewNetworkAttachmentDefinition("test-get"))
      .once();

    // When
    NetworkAttachmentDefinition networkAttachmentDefinition = client.networkAttachmentDefinitions().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(networkAttachmentDefinition)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/k8s.cni.cncf.io/v1/namespaces/ns1/network-attachment-definitions")
      .andReturn(HttpURLConnection.HTTP_OK, new NetworkAttachmentDefinitionListBuilder()
        .addToItems(createNewNetworkAttachmentDefinition("test-list"))
        .build())
      .once();

    // When
    NetworkAttachmentDefinitionList networkAttachmentDefinitionList = client.networkAttachmentDefinitions().inNamespace("ns1").list();

    // Then
    assertThat(networkAttachmentDefinitionList).isNotNull();
    assertThat(networkAttachmentDefinitionList.getItems()).hasSize(1);
    assertThat(networkAttachmentDefinitionList.getItems().get(0))
      .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/k8s.cni.cncf.io/v1/namespaces/ns1/network-attachment-definitions/test-delete")
      .andReturn(HttpURLConnection.HTTP_OK, createNewNetworkAttachmentDefinition("test-delete"))
      .once();

    // When
    Boolean isDeleted = client.networkAttachmentDefinitions().inNamespace("ns1").withName("test-delete").delete();

    // Then
    assertThat(isDeleted).isTrue();
  }

  private NetworkAttachmentDefinition createNewNetworkAttachmentDefinition(String name) {
    return new NetworkAttachmentDefinitionBuilder()
      .withNewMetadata().withName(name).endMetadata()
      .withNewSpec()
      .withConfig("{\"cniVersion\": \"0.3.0\",\"type\": \"foo\"}")
      .endSpec()
      .build();
  }
}
