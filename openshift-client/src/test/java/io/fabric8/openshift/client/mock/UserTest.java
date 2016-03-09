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

package io.fabric8.openshift.client.mock;

import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.api.model.UserBuilder;
import io.fabric8.openshift.api.model.UserList;
import io.fabric8.openshift.api.model.UserListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class UserTest extends OpenShiftMockServerTestBase {


  @Test
  public void testList() {
    expect().withPath("/oapi/v1/users").andReturn(200, new UserListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).always();


    OpenShiftClient client = getOpenshiftClient();

    UserList userList = client.users().list();
    assertNotNull(userList);
    assertEquals(2, userList.getItems().size());

    //Test using namespace
    client.inNamespace("test").users().list();
    assertNotNull(userList);
    assertEquals(2, userList.getItems().size());
  }


  @Test
  public void testGet() {
    expect().withPath("/oapi/v1/users/user1").andReturn(200, new UserBuilder()
      .withNewMetadata().withName("user1").endMetadata()
      .build()).once();

    expect().withPath("/oapi/v1/users/User2").andReturn(200, new UserBuilder()
      .withNewMetadata().withName("User2").endMetadata()
      .build()).once();

    OpenShiftClient client = getOpenshiftClient();

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
  public void testDelete() {
    expect().withPath("/oapi/v1/users/user1").andReturn(200, new UserBuilder().build()).once();
    expect().withPath("/oapi/v1/users/User2").andReturn( 200, new UserBuilder().build()).once();

    OpenShiftClient client = getOpenshiftClient();

    Boolean deleted = client.users().withName("user1").delete();
    assertNotNull(deleted);

    deleted = client.users().withName("User2").delete();
    assertTrue(deleted);

    deleted = client.users().withName("User3").delete();
    assertFalse(deleted);
  }
}
