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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Rule;
import org.junit.Test;

import io.fabric8.openshift.api.model.OpenshiftRole;
import io.fabric8.openshift.api.model.OpenshiftRoleBuilder;
import io.fabric8.openshift.api.model.OpenshiftRoleList;
import io.fabric8.openshift.api.model.OpenshiftRoleListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;

public class OpenshiftRoleTest {
  @Rule
  public OpenShiftServer server = new OpenShiftServer();

  @Test
  public void testList() {
   server.expect().withPath("/oapi/v1/namespaces/test/roles").andReturn(200, new OpenshiftRoleListBuilder().build()).once();
   server.expect().withPath("/oapi/v1/namespaces/ns1/roles").andReturn(200, new OpenshiftRoleListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();

   server.expect().withPath("/oapi/v1/roles").andReturn(200, new OpenshiftRoleListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

    OpenshiftRoleList roleList = client.roles().list();
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
  public void testGet() {
   server.expect().withPath("/oapi/v1/namespaces/test/roles/role1").andReturn(200, new OpenshiftRoleBuilder()
      .withNewMetadata().withName("role1").endMetadata()
      .build()).once();

   server.expect().withPath("/oapi/v1/namespaces/ns1/roles/role2").andReturn(200, new OpenshiftRoleBuilder()
      .withNewMetadata().withName("role2").endMetadata()
      .build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

    OpenshiftRole role = client.roles().withName("role1").get();
    assertNotNull(role);
    assertEquals("role1", role.getMetadata().getName());

    role = client.roles().withName("role2").get();
    assertNull(role);

    role = client.roles().inNamespace("ns1").withName("role2").get();
    assertNotNull(role);
    assertEquals("role2", role.getMetadata().getName());
  }

}
