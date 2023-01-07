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
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.FlowSchema;
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.FlowSchemaBuilder;
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.FlowSchemaList;
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.FlowSchemaListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class V1beta2FlowSchemaTest {
  private KubernetesMockServer server;
  private KubernetesClient client;

  @Test
  void load() {
    List<HasMetadata> items = client.load(getClass().getResourceAsStream("/v1beta2-flowschema.yml")).items();
    assertThat(items).isNotNull().hasSize(1);
    AssertionsForClassTypes.assertThat(items.get(0))
        .isInstanceOf(FlowSchema.class)
        .hasFieldOrPropertyWithValue("metadata.name", "health-for-strangers");
  }

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/exempt")
        .andReturn(HttpURLConnection.HTTP_OK, createFlowSchema("exempt"))
        .once();

    // When
    FlowSchema flowSchema = client.flowControl().v1beta2().flowSchema().withName("exempt").get();

    // Then
    AssertionsForClassTypes.assertThat(flowSchema)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "exempt");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas")
        .andReturn(HttpURLConnection.HTTP_OK, new FlowSchemaListBuilder()
            .addToItems(createFlowSchema("exempt"))
            .build())
        .once();

    // When
    FlowSchemaList flowSchemas = client.flowControl().v1beta2().flowSchema().list();

    // Then
    AssertionsForClassTypes.assertThat(flowSchemas).isNotNull();
    assertThat(flowSchemas.getItems()).hasSize(1);
    AssertionsForClassTypes.assertThat(flowSchemas.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "exempt");
  }

  @Test
  void create() {
    // Given
    FlowSchema flowSchema = createFlowSchema("flowschema1");
    server.expect().post().withPath("/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas")
        .andReturn(HttpURLConnection.HTTP_OK, flowSchema)
        .once();

    // When
    FlowSchema createdFlowSchema = client.flowControl().v1beta2().flowSchema().create(flowSchema);

    // Then
    AssertionsForClassTypes.assertThat(createdFlowSchema).isNotNull();
    AssertionsForClassTypes.assertThat(createdFlowSchema)
        .hasFieldOrPropertyWithValue("metadata.name", "flowschema1");
  }

  @Test
  void delete() {
    // Given
    FlowSchema flowSchema = createFlowSchema("flowschema1");
    server.expect().delete().withPath("/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/flowschema1")
        .andReturn(HttpURLConnection.HTTP_OK, flowSchema)
        .once();

    // When
    boolean isDeleted = client.flowControl().v1beta2().flowSchema().withName("flowschema1").delete().size() == 1;

    // Then
    AssertionsForClassTypes.assertThat(isDeleted).isTrue();
  }

  private FlowSchema createFlowSchema(String name) {
    return new FlowSchemaBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withMatchingPrecedence(1)
        .withNewPriorityLevelConfiguration()
        .withName(name)
        .endPriorityLevelConfiguration()
        .addNewRule()
        .addNewNonResourceRule()
        .addToNonResourceURLs("*")
        .addToVerbs("*")
        .endNonResourceRule()
        .addNewResourceRule()
        .addToApiGroups("*")
        .endResourceRule()
        .addNewSubject()
        .withNewGroup()
        .withName("system:masters")
        .endGroup()
        .withKind("Group")
        .endSubject()
        .endRule()
        .endSpec()
        .build();
  }
}
