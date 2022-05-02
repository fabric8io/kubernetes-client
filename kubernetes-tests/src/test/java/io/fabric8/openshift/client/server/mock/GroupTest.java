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

import io.fabric8.kubernetes.api.model.APIGroupListBuilder;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.GroupBuilder;
import io.fabric8.openshift.api.model.GroupList;
import io.fabric8.openshift.api.model.GroupListBuilder;
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class GroupTest {

  OpenShiftMockServer server;
  NamespacedOpenShiftClient client;

  @BeforeEach
  void setUp() {
    client = server.createOpenShiftClient();
  }

  @Test
  void testList() {
    server.expect().withPath("/apis/user.openshift.io/v1/groups").andReturn(200, new GroupListBuilder()
        .addNewItem().and()
        .addNewItem().and().build()).always();

    server.expect().withPath("/apis").andReturn(200, new APIGroupListBuilder()
        .addNewGroup()
        .withApiVersion("v1")
        .withName("autoscaling.k8s.io")
        .endGroup()
        .addNewGroup()
        .withApiVersion("v1")
        .withName("security.openshift.io")
        .endGroup()
        .build()).always();

    GroupList groupList = client.groups().list();
    assertNotNull(groupList);
    assertEquals(2, groupList.getItems().size());

    //Test using namespace
    client.inNamespace("test").groups().list();
    assertNotNull(groupList);
    assertEquals(2, groupList.getItems().size());
  }

  @Test
  void testGet() {
    server.expect().withPath("/apis/user.openshift.io/v1/groups/group1").andReturn(200, new GroupBuilder()
        .withNewMetadata().withName("group1").endMetadata()
        .build()).once();

    server.expect().withPath("/apis/user.openshift.io/v1/groups/Group2").andReturn(200, new GroupBuilder()
        .withNewMetadata().withName("Group2").endMetadata()
        .build()).once();

    Group group = client.groups().withName("group1").get();
    assertNotNull(group);
    assertEquals("group1", group.getMetadata().getName());

    group = client.groups().withName("Group2").get();
    assertNotNull(group);
    assertEquals("Group2", group.getMetadata().getName());

    group = client.groups().withName("Group3").get();
    assertNull(group);
  }

  @Test
  void testDelete() {
    server.expect().withPath("/apis/user.openshift.io/v1/groups/group1").andReturn(200, new GroupBuilder().build()).once();
    server.expect().withPath("/apis/user.openshift.io/v1/groups/Group2").andReturn(200, new GroupBuilder().build()).once();

    boolean deleted = client.groups().withName("group1").delete().size() == 1;

    deleted = client.groups().withName("Group2").delete().size() == 1;
    assertTrue(deleted);

    deleted = client.groups().withName("Group3").delete().size() == 1;
    assertFalse(deleted);
  }

  @Test
  void testDeleteWithPropagationPolicy() {
    server.expect().withPath("/apis/user.openshift.io/v1/groups/group1").andReturn(200, new GroupBuilder().build()).once();
    server.expect().withPath("/apis/user.openshift.io/v1/groups/Group2").andReturn(200, new GroupBuilder().build()).once();

    boolean deleted = client.groups().withName("group1").withPropagationPolicy(DeletionPropagation.FOREGROUND).delete()
        .size() == 1;

    deleted = client.groups().withName("Group2").withPropagationPolicy(DeletionPropagation.FOREGROUND).delete().size() == 1;
    assertTrue(deleted);

    deleted = client.groups().withName("Group3").withPropagationPolicy(DeletionPropagation.FOREGROUND).delete().size() == 1;
    assertFalse(deleted);
  }
}
