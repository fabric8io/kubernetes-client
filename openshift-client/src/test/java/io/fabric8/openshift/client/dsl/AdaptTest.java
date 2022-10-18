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
package io.fabric8.openshift.client.dsl;

import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.OpenShiftConfigBuilder;
import io.fabric8.openshift.client.impl.OpenShiftClientImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdaptTest {

  @Test
  void testAdaptDisabledCheck() {
    // Given
    OpenShiftClient client = new OpenShiftClientImpl(new OpenShiftConfigBuilder().withDisableApiGroupCheck(true).build());

    // When + Then
    assertTrue(client.isAdaptable(OpenShiftClient.class));
  }

  @Test
  void testAdaptDSLs() {
    // Given
    OpenShiftClient client = new OpenShiftClientImpl(
        new OpenShiftConfigBuilder().withDisableApiGroupCheck(true).build());

    assertNotNull(client.v1());
    assertNotNull(client.apps());
    assertNotNull(client.autoscaling());
    assertNotNull(client.batch());
    assertNotNull(client.buildConfigs());
    assertNotNull(client.builds());
    assertNotNull(client.clusterRoleBindings());
    assertNotNull(client.deploymentConfigs());
    assertNotNull(client.extensions());
    assertNotNull(client.groups());
    assertNotNull(client.imageStreams());
    assertNotNull(client.imageStreamTags());
    assertNotNull(client.network());
    assertNotNull(client.oAuthAccessTokens());
    assertNotNull(client.oAuthAuthorizeTokens());
    assertNotNull(client.oAuthClients());
    assertNotNull(client.projectrequests());
    assertNotNull(client.projects());
    assertNotNull(client.pods());
    assertNotNull(client.rbac());
    assertNotNull(client.roleBindings());
    assertNotNull(client.storage());
    assertNotNull(client.templates());
    assertNotNull(client.users());
  }
}
