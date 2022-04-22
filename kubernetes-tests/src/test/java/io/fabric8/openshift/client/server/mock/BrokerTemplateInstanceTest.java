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

import io.fabric8.openshift.api.model.BrokerTemplateInstance;
import io.fabric8.openshift.api.model.BrokerTemplateInstanceBuilder;
import io.fabric8.openshift.api.model.BrokerTemplateInstanceList;
import io.fabric8.openshift.api.model.BrokerTemplateInstanceListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class BrokerTemplateInstanceTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/template.openshift.io/v1/brokertemplateinstances/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewBrokerTemplateInstance("test-get"))
        .once();

    // When
    BrokerTemplateInstance brokerTemplateInstance = client.brokerTemplateInstances().withName("test-get").get();

    // Then
    assertThat(brokerTemplateInstance)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/template.openshift.io/v1/brokertemplateinstances")
        .andReturn(HttpURLConnection.HTTP_OK, new BrokerTemplateInstanceListBuilder()
            .addToItems(createNewBrokerTemplateInstance("test-list"))
            .build())
        .once();

    // When
    BrokerTemplateInstanceList brokerTemplateInstanceList = client.brokerTemplateInstances().list();

    // Then
    assertThat(brokerTemplateInstanceList).isNotNull();
    assertThat(brokerTemplateInstanceList.getItems()).hasSize(1);
    assertThat(brokerTemplateInstanceList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/template.openshift.io/v1/brokertemplateinstances/test-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewBrokerTemplateInstance("test-delete"))
        .once();

    // When
    boolean isDeleted = client.brokerTemplateInstances().withName("test-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private BrokerTemplateInstance createNewBrokerTemplateInstance(String name) {
    return new BrokerTemplateInstanceBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withNewSecret().withName("secret").withNamespace("ns1").withKind("Secret").endSecret()
        .withNewTemplateInstance()
        .withApiVersion("template.openshift.io/v1")
        .withName("test-templateinstance")
        .withKind("TemplateInstance")
        .withNamespace("ns1")
        .withResourceVersion("202466")
        .withUid("d8eecb23-12ab-4850-a918-b63ca12676f2")
        .endTemplateInstance()
        .endSpec()
        .build();
  }
}
