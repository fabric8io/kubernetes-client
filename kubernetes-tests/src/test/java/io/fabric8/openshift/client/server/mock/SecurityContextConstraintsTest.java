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

import io.fabric8.openshift.api.model.SecurityContextConstraints;
import io.fabric8.openshift.api.model.SecurityContextConstraintsBuilder;
import io.fabric8.openshift.api.model.SecurityContextConstraintsList;
import io.fabric8.openshift.api.model.SecurityContextConstraintsListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableRuleMigrationSupport
public class SecurityContextConstraintsTest {
  @Rule
  public OpenShiftServer server = new OpenShiftServer();

  @Test
  public void testList() {
   server.expect().withPath("/apis/security.openshift.io/v1/securitycontextconstraints").andReturn(200, new SecurityContextConstraintsListBuilder()
            .addNewItem().endItem()
            .build()).once();


    OpenShiftClient client = server.getOpenshiftClient();
    SecurityContextConstraintsList sccList = client.securityContextConstraints().list();
    assertNotNull(sccList);
    assertEquals(1, sccList.getItems().size());
  }

  @Test
  public void testDelete() {
   server.expect().withPath("/apis/security.openshift.io/v1/securitycontextconstraints/scc1").andReturn(200, new SecurityContextConstraintsBuilder().build()).once();
   server.expect().withPath("/apis/security.openshift.io/v1/securitycontextconstraints/scc2").andReturn(200, new SecurityContextConstraintsBuilder().build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

    Boolean deleted = client.securityContextConstraints().withName("scc1").delete();
    assertNotNull(deleted);

    deleted = client.securityContextConstraints().withName("scc1").delete();
    assertFalse(deleted);

    deleted = client.securityContextConstraints().withName("scc2").delete();
    assertTrue(deleted);
  }

  @Test
  public void testEdit() {
   server.expect().withPath("/apis/security.openshift.io/v1/securitycontextconstraints/scc1").andReturn(200, new SecurityContextConstraintsBuilder().withNewMetadata().withName("scc1").and().build()).times(2);
   server.expect().withPath("/apis/security.openshift.io/v1/securitycontextconstraints/scc1").andReturn(200, new SecurityContextConstraintsBuilder().withNewMetadata().withName("scc1").and().addToAllowedCapabilities("allowed").build()).once();

    OpenShiftClient client = server.getOpenshiftClient();
    SecurityContextConstraints scc = client.securityContextConstraints().withName("scc1").edit().addToAllowedCapabilities("allowed").done();
    assertNotNull(scc);
    assertEquals(1, scc.getAllowedCapabilities().size());
  }

}
