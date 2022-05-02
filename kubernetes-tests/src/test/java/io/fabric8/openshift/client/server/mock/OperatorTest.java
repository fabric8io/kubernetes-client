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

import io.fabric8.openshift.api.model.operatorhub.v1.Operator;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorBuilder;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorList;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class OperatorTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/operators.coreos.com/v1/operators/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewOperator("test-get"))
        .once();

    // When
    Operator operator = client.operatorHub().operators().withName("test-get").get();

    // Then
    assertThat(operator)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/operators.coreos.com/v1/operators")
        .andReturn(HttpURLConnection.HTTP_OK, new OperatorListBuilder()
            .addToItems(createNewOperator("test-list"))
            .build())
        .once();

    // When
    OperatorList operatorList = client.operatorHub().operators().list();

    // Then
    assertThat(operatorList).isNotNull();
    assertThat(operatorList.getItems()).hasSize(1);
    assertThat(operatorList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/operators.coreos.com/v1/operators/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewOperator("cluster"))
        .once();

    // When
    boolean isDeleted = client.operatorHub().operators().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Operator createNewOperator(String name) {
    return new OperatorBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .build();
  }
}
