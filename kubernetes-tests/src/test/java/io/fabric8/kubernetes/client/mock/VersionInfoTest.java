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
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.server.mock.OpenShiftServer;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableRuleMigrationSupport
public class VersionInfoTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void testClusterVersioning() throws ParseException {
    server.expect().withPath("/version").andReturn(200, "{" +
      "    \"buildDate\": \"2018-03-01T14:27:17Z\"," +
      "    \"gitCommit\": \"e6301f88a8\"," +
      "    \"gitVersion\": \"v1.6.1+5115d708d7\"," +
      "    \"major\": \"3\"," +
      "    \"minor\": \"6\"" +
      "}").always();

    KubernetesClient client = server.getClient();
    assertEquals("v1.6.1+5115d708d7", client.getVersion().getGitVersion());
    assertEquals("e6301f88a8", client.getVersion().getGitCommit());
    assertEquals("3", client.getVersion().getMajor());
    assertEquals("6", client.getVersion().getMinor());
    assertEquals(118, client.getVersion().getBuildDate().getYear());
    assertEquals(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse("2018-03-01T14:27:17Z").getTime(), client.getVersion().getBuildDate().getTime());
  }
}
