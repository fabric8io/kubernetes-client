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

import io.fabric8.kubernetes.api.model.ConditionBuilder;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorCondition;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorConditionBuilder;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorConditionList;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorConditionListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class OperatorConditionTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/operators.coreos.com/v1/namespaces/ns1/operatorconditions/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewOperatorCondition("test-get"))
        .once();

    // When
    OperatorCondition operatorCondition = client.operatorHub().operatorConditions().inNamespace("ns1").withName("test-get")
        .get();

    // Then
    assertThat(operatorCondition)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/operators.coreos.com/v1/namespaces/ns1/operatorconditions")
        .andReturn(HttpURLConnection.HTTP_OK, new OperatorConditionListBuilder()
            .addToItems(createNewOperatorCondition("test-list"))
            .build())
        .once();

    // When
    OperatorConditionList operatorConditionList = client.operatorHub().operatorConditions().inNamespace("ns1").list();

    // Then
    assertThat(operatorConditionList).isNotNull();
    assertThat(operatorConditionList.getItems()).hasSize(1);
    assertThat(operatorConditionList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/operators.coreos.com/v1/namespaces/ns1/operatorconditions/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewOperatorCondition("cluster"))
        .once();

    // When
    boolean isDeleted = client.operatorHub().operatorConditions().inNamespace("ns1").withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private OperatorCondition createNewOperatorCondition(String name) {
    return new OperatorConditionBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .addToOverrides(new ConditionBuilder()
            .withType("Upgradeable")
            .withStatus("True")
            .withReason("upgradeIsSafe")
            .withMessage("The cluster admin wants to make the operator eligible for an upgrade.")
            .build())
        .endSpec()
        .build();
  }
}
