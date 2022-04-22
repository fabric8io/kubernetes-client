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

import io.fabric8.openshift.api.model.console.v1alpha1.ConsolePlugin;
import io.fabric8.openshift.api.model.console.v1alpha1.ConsolePluginBuilder;
import io.fabric8.openshift.api.model.console.v1alpha1.ConsolePluginList;
import io.fabric8.openshift.api.model.console.v1alpha1.ConsolePluginListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ConsolePluginTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/console.openshift.io/v1alpha1/consoleplugins/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewConsolePlugin("test-get"))
        .once();

    // When
    ConsolePlugin consoleQuickStart = client.console().consolePlugins().withName("test-get").get();

    // Then
    assertThat(consoleQuickStart)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/console.openshift.io/v1alpha1/consoleplugins")
        .andReturn(HttpURLConnection.HTTP_OK, new ConsolePluginListBuilder()
            .addToItems(createNewConsolePlugin("test-list"))
            .build())
        .once();

    // When
    ConsolePluginList consoleQuickStartList = client.console().consolePlugins().list();

    // Then
    assertThat(consoleQuickStartList).isNotNull();
    assertThat(consoleQuickStartList.getItems()).hasSize(1);
    assertThat(consoleQuickStartList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/console.openshift.io/v1alpha1/consoleplugins/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewConsolePlugin("cluster"))
        .once();

    // When
    boolean isDeleted = client.console().consolePlugins().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ConsolePlugin createNewConsolePlugin(String name) {
    return new ConsolePluginBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withDisplayName("Dev Sandbox Console Plugin")
        .withNewService()
        .withBasePath("/")
        .withName("dev-sandbox-console-plugin")
        .withNamespace("dev-sandbox-console-plugin")
        .withPort(9001)
        .endService()
        .endSpec()
        .build();
  }
}
