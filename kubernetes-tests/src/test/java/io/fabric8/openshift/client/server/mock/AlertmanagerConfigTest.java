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

import io.fabric8.openshift.api.model.monitoring.v1alpha1.AlertmanagerConfig;
import io.fabric8.openshift.api.model.monitoring.v1alpha1.AlertmanagerConfigBuilder;
import io.fabric8.openshift.api.model.monitoring.v1alpha1.AlertmanagerConfigList;
import io.fabric8.openshift.api.model.monitoring.v1alpha1.AlertmanagerConfigListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class AlertmanagerConfigTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/monitoring.coreos.com/v1alpha1/namespaces/ns1/alertmanagerconfigs/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewAlertmanagerConfig("test-get"))
        .once();

    // When
    AlertmanagerConfig alertmanagerConfig = client.monitoring().alertmanagerConfigs().inNamespace("ns1").withName("test-get")
        .get();

    // Then
    assertThat(alertmanagerConfig)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/monitoring.coreos.com/v1alpha1/namespaces/ns1/alertmanagerconfigs")
        .andReturn(HttpURLConnection.HTTP_OK, new AlertmanagerConfigListBuilder()
            .addToItems(createNewAlertmanagerConfig("test-list"))
            .build())
        .once();

    // When
    AlertmanagerConfigList alertmanagerConfigList = client.monitoring().alertmanagerConfigs().inNamespace("ns1").list();

    // Then
    assertThat(alertmanagerConfigList).isNotNull();
    assertThat(alertmanagerConfigList.getItems()).hasSize(1);
    assertThat(alertmanagerConfigList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/monitoring.coreos.com/v1alpha1/namespaces/ns1/alertmanagerconfigs/test-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewAlertmanagerConfig("test-delete"))
        .once();

    // When
    boolean isDeleted = client.monitoring().alertmanagerConfigs().inNamespace("ns1").withName("test-delete").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private AlertmanagerConfig createNewAlertmanagerConfig(String name) {
    return new AlertmanagerConfigBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .addNewInhibitRule()
        .withEqual("foo", "bar")
        .addNewTargetMatch()
        .withName("label1")
        .withValue("value1")
        .endTargetMatch()
        .addNewSourceMatch()
        .withName("label2")
        .withValue("value2")
        .endSourceMatch()
        .endInhibitRule()
        .endSpec()
        .build();
  }
}
