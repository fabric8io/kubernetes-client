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
import io.fabric8.openshift.api.model.Role;
import io.fabric8.openshift.api.model.RoleBuilder;
import io.fabric8.openshift.api.model.RoleList;
import io.fabric8.openshift.api.model.RoleListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableOpenShiftMockClient
class OpenshiftRoleTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void testList() {
    server.expect().withPath("/apis/authorization.openshift.io/v1/namespaces/test/roles")
        .andReturn(200, new RoleListBuilder().build()).once();
    server.expect().withPath("/apis/authorization.openshift.io/v1/namespaces/ns1/roles").andReturn(200, new RoleListBuilder()
        .addNewItem().and()
        .addNewItem().and().build()).once();
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

    server.expect().withPath("/apis/authorization.openshift.io/v1/roles").andReturn(200, new RoleListBuilder()
        .addNewItem().and()
        .addNewItem().and()
        .addNewItem()
        .and().build()).once();

    RoleList roleList = client.roles().list();
    assertNotNull(roleList);
    assertEquals(0, roleList.getItems().size());

    roleList = client.roles().inNamespace("ns1").list();
    assertNotNull(roleList);
    assertEquals(2, roleList.getItems().size());

    roleList = client.roles().inAnyNamespace().list();
    assertNotNull(roleList);
    assertEquals(3, roleList.getItems().size());
  }

  @Test
  void testGet() {
    server.expect().withPath("/apis/authorization.openshift.io/v1/namespaces/test/roles/role1").andReturn(200, new RoleBuilder()
        .withNewMetadata().withName("role1").endMetadata()
        .build()).once();

    server.expect().withPath("/apis/authorization.openshift.io/v1/namespaces/ns1/roles/role2").andReturn(200, new RoleBuilder()
        .withNewMetadata().withName("role2").endMetadata()
        .build()).once();

    Role role = client.roles().withName("role1").get();
    assertNotNull(role);
    assertEquals("role1", role.getMetadata().getName());

    role = client.roles().withName("role2").get();
    assertNull(role);

    role = client.roles().inNamespace("ns1").withName("role2").get();
    assertNotNull(role);
    assertEquals("role2", role.getMetadata().getName());
  }

}
