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

import io.fabric8.openshift.api.model.operator.v1.CloudCredential;
import io.fabric8.openshift.api.model.operator.v1.CloudCredentialBuilder;
import io.fabric8.openshift.api.model.operator.v1.CloudCredentialList;
import io.fabric8.openshift.api.model.operator.v1.CloudCredentialListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class CloudCredentialTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/operator.openshift.io/v1/cloudcredentials/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewCloudCredential("test-get"))
        .once();

    // When
    CloudCredential cloudCredential = client.operator().cloudCredentials().withName("test-get").get();

    // Then
    assertThat(cloudCredential)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/operator.openshift.io/v1/cloudcredentials")
        .andReturn(HttpURLConnection.HTTP_OK, new CloudCredentialListBuilder()
            .addToItems(createNewCloudCredential("test-list"))
            .build())
        .once();

    // When
    CloudCredentialList cloudCredentialList = client.operator().cloudCredentials().list();

    // Then
    assertThat(cloudCredentialList).isNotNull();
    assertThat(cloudCredentialList.getItems()).hasSize(1);
    assertThat(cloudCredentialList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/operator.openshift.io/v1/cloudcredentials/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewCloudCredential("cluster"))
        .once();

    // When
    boolean isDeleted = client.operator().cloudCredentials().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private CloudCredential createNewCloudCredential(String name) {
    return new CloudCredentialBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withCredentialsMode("")
        .withLogLevel("Normal")
        .withOperatorLogLevel("Normal")
        .endSpec()
        .build();
  }
}
