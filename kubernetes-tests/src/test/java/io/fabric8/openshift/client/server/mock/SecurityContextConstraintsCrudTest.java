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
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient(crud = true)
class SecurityContextConstraintsCrudTest {

  private static final Logger logger = LoggerFactory.getLogger(SecurityContextConstraintsCrudTest.class);

  OpenShiftClient client;

  @Test
  void crudTest() {

    logger.info("Current User " + client.currentUser());

    SecurityContextConstraints scc = new SecurityContextConstraintsBuilder()
        .withNewMetadata().withName("test-scc").endMetadata()
        .withAllowPrivilegedContainer(true)
        .withNewRunAsUser()
        .withType("RunAsAny")
        .endRunAsUser()
        .withNewSeLinuxContext()
        .withType("RunAsAny")
        .endSeLinuxContext()
        .withNewFsGroup()
        .withType("RunAsAny")
        .endFsGroup()
        .withNewSupplementalGroups()
        .withType("RunAsAny")
        .endSupplementalGroups()
        .addToUsers("admin")
        .addToGroups("admin-group")
        .build();

    //test of Creation

    scc = client.securityContextConstraints().create(scc);
    assertNotNull(scc);
    assertEquals("test-scc", scc.getMetadata().getName());
    assertTrue(scc.getAllowPrivilegedContainer());
    assertEquals("RunAsAny", scc.getRunAsUser().getType());
    assertEquals("RunAsAny", scc.getFsGroup().getType());
    assertEquals("RunAsAny", scc.getSeLinuxContext().getType());
    assertEquals("RunAsAny", scc.getSupplementalGroups().getType());
    assertEquals(1, scc.getUsers().size());
    assertEquals("admin", scc.getUsers().get(0));
    assertEquals(1, scc.getGroups().size());
    assertEquals("admin-group", scc.getGroups().get(0));

    //test of list
    SecurityContextConstraintsList sccList = client.securityContextConstraints().list();

    logger.info(sccList.toString());

    assertNotNull(sccList);
    assertEquals(1, sccList.getItems().size());
    assertEquals("test-scc", sccList.getItems().get(0).getMetadata().getName());
    assertTrue(sccList.getItems().get(0).getAllowPrivilegedContainer());
    assertEquals("RunAsAny", sccList.getItems().get(0).getRunAsUser().getType());
    assertEquals("RunAsAny", sccList.getItems().get(0).getFsGroup().getType());
    assertEquals("RunAsAny", sccList.getItems().get(0).getSeLinuxContext().getType());
    assertEquals("RunAsAny", sccList.getItems().get(0).getSupplementalGroups().getType());
    assertEquals(1, sccList.getItems().get(0).getUsers().size());
    assertEquals("admin", sccList.getItems().get(0).getUsers().get(0));
    assertEquals(1, sccList.getItems().get(0).getGroups().size());
    assertEquals("admin-group", sccList.getItems().get(0).getGroups().get(0));

    //test of updation
    SecurityContextConstraints scc2 = new SecurityContextConstraintsBuilder()
        .withNewMetadata().withName("test-scc").endMetadata()
        .withAllowPrivilegedContainer(false)
        .withNewRunAsUser()
        .withType("RunAsAny")
        .endRunAsUser()
        .withNewSeLinuxContext()
        .withType("RunAsAny")
        .endSeLinuxContext()
        .withNewFsGroup()
        .withType("RunAsAny")
        .endFsGroup()
        .withNewSupplementalGroups()
        .withType("RunAsAny")
        .endSupplementalGroups()
        .addToUsers("admin")
        .addToGroups("admin-group")
        .build();

    scc = client.securityContextConstraints().withName("test-scc").patch(scc2);

    logger.info("Updated SecurityContextConstraints : " + scc.toString());

    assertNotNull(scc);
    assertEquals("test-scc", scc.getMetadata().getName());
    assertFalse(scc.getAllowPrivilegedContainer());
    assertEquals("RunAsAny", scc.getRunAsUser().getType());
    assertEquals("RunAsAny", scc.getFsGroup().getType());
    assertEquals("RunAsAny", scc.getSeLinuxContext().getType());
    assertEquals("RunAsAny", scc.getSupplementalGroups().getType());
    assertEquals(1, scc.getUsers().size());
    assertEquals("admin", scc.getUsers().get(0));
    assertEquals(1, scc.getGroups().size());
    assertEquals("admin-group", scc.getGroups().get(0));

    //test of deletion
    boolean deleted = client.securityContextConstraints().delete(scc).size() == 1;
    assertTrue(deleted);
    sccList = client.securityContextConstraints().list();
    assertEquals(0, sccList.getItems().size());

  }
}
