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

import io.fabric8.openshift.api.model.console.v1.ConsoleQuickStart;
import io.fabric8.openshift.api.model.console.v1.ConsoleQuickStartBuilder;
import io.fabric8.openshift.api.model.console.v1.ConsoleQuickStartList;
import io.fabric8.openshift.api.model.console.v1.ConsoleQuickStartListBuilder;
import io.fabric8.openshift.api.model.console.v1.ConsoleQuickStartTaskBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ConsoleQuickStartTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/console.openshift.io/v1/consolequickstarts/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewConsoleQuickStart("test-get"))
        .once();

    // When
    ConsoleQuickStart consoleQuickStart = client.console().consoleQuickStarts().withName("test-get").get();

    // Then
    assertThat(consoleQuickStart)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/console.openshift.io/v1/consolequickstarts")
        .andReturn(HttpURLConnection.HTTP_OK, new ConsoleQuickStartListBuilder()
            .addToItems(createNewConsoleQuickStart("test-list"))
            .build())
        .once();

    // When
    ConsoleQuickStartList consoleQuickStartList = client.console().consoleQuickStarts().list();

    // Then
    assertThat(consoleQuickStartList).isNotNull();
    assertThat(consoleQuickStartList.getItems()).hasSize(1);
    assertThat(consoleQuickStartList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/console.openshift.io/v1/consolequickstarts/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewConsoleQuickStart("cluster"))
        .once();

    // When
    boolean isDeleted = client.console().consoleQuickStarts().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ConsoleQuickStart createNewConsoleQuickStart(String name) {
    return new ConsoleQuickStartBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withConclusion("You have learned how to access workload monitoring and metrics!")
        .withDescription("Now that you’ve created a sample application and added health checks,\n" +
            "    let’s monitor your application.")
        .withDisplayName("Test Monitor your application")
        .withTasks(new ConsoleQuickStartTaskBuilder()
            .withDescription("Console Quickstart task")
            .withTitle("test console quickstart")
            .build())
        .withDurationMinutes(10)
        .withIntroduction("This quick start shows you how to test monitor")
        .withPrerequisites("Kubernetes", "maven", "java")
        .endSpec()
        .build();
  }
}
