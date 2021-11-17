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

package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableKubernetesMockClient
class VersionInfoTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @BeforeEach
  void setUp() {
    server.clearExpectations();
  }

  @Test
  void testClusterVersioning() throws ParseException {
    server.expect().withPath("/version").andReturn(200, "{" +
      "    \"buildDate\": \"2018-03-01T14:27:17Z\"," +
      "    \"gitCommit\": \"e6301f88a8\"," +
      "    \"gitVersion\": \"v1.6.1+5115d708d7\"," +
      "    \"major\": \"3\"," +
      "    \"minor\": \"6\"" +
      "}").always();

    assertEquals("v1.6.1+5115d708d7", client.getVersion().getGitVersion());
    assertEquals("e6301f88a8", client.getVersion().getGitCommit());
    assertEquals("3", client.getVersion().getMajor());
    assertEquals("6", client.getVersion().getMinor());
    assertEquals(118, client.getVersion().getBuildDate().getYear());
    assertEquals(new SimpleDateFormat(VersionInfo.VersionKeys.BUILD_DATE_FORMAT).parse("2018-03-01T14:27:17Z").getTime(),
      client.getVersion().getBuildDate().getTime());
  }

  @Test
  void testClusterVersioningWithMissingBuildDate() {
    server.expect().withPath("/version").andReturn(200, "{" +
      "    \"gitCommit\": \"e6301f88a8\"," +
      "    \"gitVersion\": \"v1.6.1+5115d708d7\"," +
      "    \"major\": \"3\"," +
      "    \"minor\": \"6\"" +
      "}").always();

    assertEquals("v1.6.1+5115d708d7", client.getVersion().getGitVersion());
    assertEquals("e6301f88a8", client.getVersion().getGitCommit());
    assertEquals("3", client.getVersion().getMajor());
    assertEquals("6", client.getVersion().getMinor());
    assertNull(client.getVersion().getBuildDate());
  }
}
