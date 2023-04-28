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
package io.fabric8.openshift;

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.openshift.api.model.SecurityContextConstraints;
import io.fabric8.openshift.api.model.SecurityContextConstraintsBuilder;
import io.fabric8.openshift.api.model.SecurityContextConstraintsList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sSupport(SecurityContextConstraints.class)
@LoadKubernetesManifests("/securitycontextconstraints-it.yml")
class SecurityContextConstraintsIT {

  OpenShiftClient client;

  private SecurityContextConstraints scc;

  @Test
  void load() {

    SecurityContextConstraints loadedSCC = client.securityContextConstraints()
        .load(getClass().getResourceAsStream("/test-scc.yml")).item();

    assertNotNull(loadedSCC);
    assertEquals("test-scc", loadedSCC.getMetadata().getName());
    assertTrue(loadedSCC.getAllowPrivilegedContainer());
    assertEquals("RunAsAny", loadedSCC.getRunAsUser().getType());
    assertEquals("RunAsAny", loadedSCC.getSeLinuxContext().getType());
    assertEquals(1, loadedSCC.getUsers().size());
    assertEquals("admin", loadedSCC.getUsers().get(0));
    assertEquals(1, loadedSCC.getGroups().size());
    assertEquals("admin-group", loadedSCC.getGroups().get(0));
  }

  @Test
  void get() {

    SecurityContextConstraints getSCC = client.securityContextConstraints()
        .withName("scc-get").get();
    assertNotNull(getSCC);
    assertEquals("scc-get", getSCC.getMetadata().getName());
    assertTrue(getSCC.getAllowPrivilegedContainer());
    assertEquals("RunAsAny", getSCC.getRunAsUser().getType());
    assertEquals("RunAsAny", getSCC.getFsGroup().getType());
    assertEquals("RunAsAny", getSCC.getSeLinuxContext().getType());
    assertEquals("RunAsAny", getSCC.getSupplementalGroups().getType());
    assertEquals(1, getSCC.getUsers().size());
    assertEquals("admin", getSCC.getUsers().get(0));
    assertEquals(1, getSCC.getGroups().size());
    assertEquals("admin-group", getSCC.getGroups().get(0));
  }

  @Test
  void list() {

    SecurityContextConstraintsList sccList = client.securityContextConstraints()
        .withLabels(Collections.singletonMap("foo", "bar")).list();

    assertNotNull(sccList);
    assertEquals(1, sccList.getItems().size());
    assertEquals("scc-list", sccList.getItems().get(0).getMetadata().getName());
    assertTrue(sccList.getItems().get(0).getAllowPrivilegedContainer());
    assertEquals("RunAsAny", sccList.getItems().get(0).getRunAsUser().getType());
    assertEquals("RunAsAny", sccList.getItems().get(0).getFsGroup().getType());
    assertEquals("RunAsAny", sccList.getItems().get(0).getSeLinuxContext().getType());
    assertEquals("RunAsAny", sccList.getItems().get(0).getSupplementalGroups().getType());
    assertEquals(1, sccList.getItems().get(0).getUsers().size());
    assertEquals("admin", sccList.getItems().get(0).getUsers().get(0));
    assertEquals(1, sccList.getItems().get(0).getGroups().size());
    assertEquals("admin-group", sccList.getItems().get(0).getGroups().get(0));
  }

  @Test
  void update() {

    scc = client.securityContextConstraints().withName("scc-update").edit(s -> new SecurityContextConstraintsBuilder(s)
        .editMetadata().withResourceVersion(null).endMetadata()
        .withAllowPrivilegedContainer(false)
        .build());

    assertNotNull(scc);
    assertEquals("scc-update", scc.getMetadata().getName());
    assertFalse(scc.getAllowPrivilegedContainer());
    assertEquals("RunAsAny", scc.getRunAsUser().getType());
    assertEquals("RunAsAny", scc.getFsGroup().getType());
    assertEquals("RunAsAny", scc.getSeLinuxContext().getType());
    assertEquals("RunAsAny", scc.getSupplementalGroups().getType());
    assertEquals(1, scc.getUsers().size());
    assertEquals("admin", scc.getUsers().get(0));
    assertEquals(1, scc.getGroups().size());
    assertEquals("admin-group", scc.getGroups().get(0));
  }

  @Test
  void delete() {

    scc = client.securityContextConstraints().withName("scc-delete").get();
    boolean deleted = client.securityContextConstraints().delete(scc).size() == 1;
    assertTrue(deleted);
    SecurityContextConstraintsList sccList = client.securityContextConstraints().list();
    assertFalse(sccList.getItems().contains(scc));
  }
}
