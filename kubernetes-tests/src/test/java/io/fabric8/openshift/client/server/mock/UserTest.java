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

import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.api.model.UserBuilder;
import io.fabric8.openshift.api.model.UserList;
import io.fabric8.openshift.api.model.UserListBuilder;
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class UserTest {

  OpenShiftMockServer server;
  NamespacedOpenShiftClient client;

  @BeforeEach
  void setUp() {
    client = server.createOpenShiftClient();
  }

  @Test
  void testList() {
    server.expect().withPath("/apis/user.openshift.io/v1/users").andReturn(200, new UserListBuilder()
        .addNewItem().and()
        .addNewItem().and().build()).always();

    UserList userList = client.users().list();
    assertNotNull(userList);
    assertEquals(2, userList.getItems().size());

    //Test using namespace
    client.inNamespace("test").users().list();
    assertNotNull(userList);
    assertEquals(2, userList.getItems().size());
  }

  @Test
  void testGet() {
    server.expect().withPath("/apis/user.openshift.io/v1/users/user1").andReturn(200, new UserBuilder()
        .withNewMetadata().withName("user1").endMetadata()
        .build()).once();

    server.expect().withPath("/apis/user.openshift.io/v1/users/User2").andReturn(200, new UserBuilder()
        .withNewMetadata().withName("User2").endMetadata()
        .build()).once();

    User user = client.users().withName("user1").get();
    assertNotNull(user);
    assertEquals("user1", user.getMetadata().getName());

    user = client.users().withName("User2").get();
    assertNotNull(user);
    assertEquals("User2", user.getMetadata().getName());

    user = client.users().withName("User3").get();
    assertNull(user);
  }

  @Test
  void testDelete() {
    server.expect().withPath("/apis/user.openshift.io/v1/users/user1").andReturn(200, new UserBuilder().build()).once();
    server.expect().withPath("/apis/user.openshift.io/v1/users/User2").andReturn(200, new UserBuilder().build()).once();

    boolean deleted = client.users().withName("user1").delete().size() == 1;

    deleted = client.users().withName("User2").delete().size() == 1;
    assertTrue(deleted);

    deleted = client.users().withName("User3").delete().size() == 1;
    assertFalse(deleted);
  }
}
