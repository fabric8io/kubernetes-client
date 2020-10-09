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

import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableRuleMigrationSupport
class BuildTest {
  @Rule
  public OpenShiftServer server = new OpenShiftServer();

  @Test
  void testLogWithoutTimestamps() {
    server.expect().withPath("/apis/build.openshift.io/v1/namespaces/ns1/builds/test-build/log?pretty=false").andReturn(200, "test build output").times(2);
    OpenShiftClient openShiftClient = server.getOpenshiftClient();

    String log = openShiftClient.builds().inNamespace("ns1").withName("test-build").getLog();
    assertEquals("test build output", log);
  }

  @Test
  void testLogWithTimestamps() {
    server.expect().withPath("/apis/build.openshift.io/v1/namespaces/ns1/builds/test-build/log?pretty=false&timestamps=true").andReturn(200, "test build output").times(2);
    OpenShiftClient openShiftClient = server.getOpenshiftClient();

    String log = openShiftClient.builds().inNamespace("ns1").withName("test-build").usingTimestamps().getLog();
    assertEquals("test build output", log);
  }
}
