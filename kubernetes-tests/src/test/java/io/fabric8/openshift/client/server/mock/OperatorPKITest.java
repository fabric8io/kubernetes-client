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

import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.OperatorPKI;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.OperatorPKIBuilder;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.OperatorPKIList;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.OperatorPKIListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class OperatorPKITest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/network.operator.openshift.io/v1/namespaces/ns1/operatorpkis/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewOperatorPKI("test-get"))
        .once();

    // When
    OperatorPKI networkAttachmentDefinition = client.operatorPKIs().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(networkAttachmentDefinition)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/network.operator.openshift.io/v1/namespaces/ns1/operatorpkis")
        .andReturn(HttpURLConnection.HTTP_OK, new OperatorPKIListBuilder()
            .addToItems(createNewOperatorPKI("test-list"))
            .build())
        .once();

    // When
    OperatorPKIList networkAttachmentDefinitionList = client.operatorPKIs().inNamespace("ns1").list();

    // Then
    assertThat(networkAttachmentDefinitionList).isNotNull();
    assertThat(networkAttachmentDefinitionList.getItems()).hasSize(1);
    assertThat(networkAttachmentDefinitionList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/network.operator.openshift.io/v1/namespaces/ns1/operatorpkis/test-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewOperatorPKI("test-delete"))
        .once();

    // When
    boolean isDeleted = client.operatorPKIs().inNamespace("ns1").withName("test-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private OperatorPKI createNewOperatorPKI(String name) {
    return new OperatorPKIBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withNewTargetCert()
        .withCommonName("test-name")
        .endTargetCert()
        .endSpec()
        .build();
  }
}
