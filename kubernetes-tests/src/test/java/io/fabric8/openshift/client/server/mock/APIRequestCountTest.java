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

import io.fabric8.openshift.api.model.miscellaneous.apiserver.v1.APIRequestCount;
import io.fabric8.openshift.api.model.miscellaneous.apiserver.v1.APIRequestCountBuilder;
import io.fabric8.openshift.api.model.miscellaneous.apiserver.v1.APIRequestCountList;
import io.fabric8.openshift.api.model.miscellaneous.apiserver.v1.APIRequestCountListBuilder;
import io.fabric8.openshift.api.model.miscellaneous.apiserver.v1.PerResourceAPIRequestLogBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class APIRequestCountTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/apiserver.openshift.io/v1/apirequestcounts/pods.v1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewAPIRequestCount("pods.v1"))
        .once();

    // When
    APIRequestCount apiRequestCount = client.apiRequestCounts().withName("pods.v1").get();

    // Then
    assertThat(apiRequestCount)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "pods.v1");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/apiserver.openshift.io/v1/apirequestcounts")
        .andReturn(HttpURLConnection.HTTP_OK, new APIRequestCountListBuilder()
            .addToItems(createNewAPIRequestCount("example.v1"))
            .build())
        .once();

    // When
    APIRequestCountList apiRequestCountList = client.apiRequestCounts().list();

    // Then
    assertThat(apiRequestCountList).isNotNull();
    assertThat(apiRequestCountList.getItems()).hasSize(1);
    assertThat(apiRequestCountList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "example.v1");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/apiserver.openshift.io/v1/apirequestcounts/secrets.v1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewAPIRequestCount("secrets.v1"))
        .once();

    // When
    boolean isDeleted = client.apiRequestCounts().withName("secrets.v1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private APIRequestCount createNewAPIRequestCount(String name) {
    return new APIRequestCountBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withNumberOfUsersToReport(10L)
        .endSpec()
        .withNewStatus()
        .withLast24h(new PerResourceAPIRequestLogBuilder()
            .addNewByNode()
            .withNodeName("192.168.126.10")
            .withRequestCount(0L)
            .endByNode()
            .withRequestCount(0L)
            .build())
        .endStatus()
        .build();
  }

}
