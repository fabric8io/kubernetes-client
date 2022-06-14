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

import io.fabric8.openshift.api.model.config.v1.Console;
import io.fabric8.openshift.api.model.config.v1.ConsoleBuilder;
import io.fabric8.openshift.api.model.config.v1.ConsoleList;
import io.fabric8.openshift.api.model.config.v1.ConsoleListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ConsoleTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/config.openshift.io/v1/consoles/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewConsole("test-get"))
        .once();

    // When
    Console console = client.config().consoles().withName("test-get").get();

    // Then
    assertThat(console)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/config.openshift.io/v1/consoles")
        .andReturn(HttpURLConnection.HTTP_OK, new ConsoleListBuilder()
            .addToItems(createNewConsole("test-list"))
            .build())
        .once();

    // When
    ConsoleList consoleList = client.config().consoles().list();

    // Then
    assertThat(consoleList).isNotNull();
    assertThat(consoleList.getItems()).hasSize(1);
    assertThat(consoleList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/config.openshift.io/v1/consoles/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewConsole("cluster"))
        .once();

    // When
    boolean isDeleted = client.config().consoles().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Console createNewConsole(String name) {
    return new ConsoleBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .endSpec()
        .withNewStatus()
        .withConsoleURL("https://console-openshift-console.apps-example.testing")
        .endStatus()
        .build();
  }
}
