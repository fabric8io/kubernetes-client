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

import io.fabric8.openshift.api.model.console.v1.ConsoleLink;
import io.fabric8.openshift.api.model.console.v1.ConsoleLinkBuilder;
import io.fabric8.openshift.api.model.console.v1.ConsoleLinkList;
import io.fabric8.openshift.api.model.console.v1.ConsoleLinkListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class ConsoleLinkTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void create() {
    // Given
    ConsoleLink consoleLink = getConsoleLink();
    server.expect().post()
        .withPath("/apis/console.openshift.io/v1/consolelinks")
        .andReturn(HttpURLConnection.HTTP_OK, consoleLink)
        .once();

    // When
    consoleLink = client.console().consoleLinks().create(consoleLink);

    // Then
    assertNotNull(consoleLink);
    assertEquals("foo", consoleLink.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/console.openshift.io/v1/consolelinks/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getConsoleLink())
        .once();

    // When
    ConsoleLink f = client.console().consoleLinks().withName("foo").get();

    // Then
    assertNotNull(f);
    assertEquals("foo", f.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/console.openshift.io/v1/consolelinks")
        .andReturn(HttpURLConnection.HTTP_OK, new ConsoleLinkListBuilder().withItems(getConsoleLink()).build())
        .once();

    // When
    ConsoleLinkList fgList = client.console().consoleLinks().list();

    // Then
    assertNotNull(fgList);
    assertNotNull(fgList.getItems());
    assertEquals(1, fgList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/console.openshift.io/v1/consolelinks/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getConsoleLink())
        .once();

    // When
    boolean deleted = client.console().consoleLinks().withName("foo").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private ConsoleLink getConsoleLink() {
    return new ConsoleLinkBuilder()
        .withNewMetadata().withName("foo").endMetadata()
        .withNewSpec()
        .withHref("https://blog.openshift.com")
        .withLocation("HelpMenu")
        .withText("OpenShift Blog")
        .endSpec()
        .build();
  }
}
