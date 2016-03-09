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

import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.GroupBuilder;
import io.fabric8.openshift.api.model.GroupList;
import io.fabric8.openshift.api.model.GroupListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class GroupTest extends OpenShiftMockServerTestBase {


  @Test
  public void testList() {
    expect().withPath("/oapi/v1/groups").andReturn(200, new GroupListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).always();


    OpenShiftClient client = getOpenshiftClient();

    GroupList groupList = client.groups().list();
    assertNotNull(groupList);
    assertEquals(2, groupList.getItems().size());

    //Test using namespace
    client.inNamespace("test").groups().list();
    assertNotNull(groupList);
    assertEquals(2, groupList.getItems().size());
  }


  @Test
  public void testGet() {
    expect().withPath("/oapi/v1/groups/group1").andReturn(200, new GroupBuilder()
      .withNewMetadata().withName("group1").endMetadata()
      .build()).once();

    expect().withPath("/oapi/v1/groups/Group2").andReturn(200, new GroupBuilder()
      .withNewMetadata().withName("Group2").endMetadata()
      .build()).once();

    OpenShiftClient client = getOpenshiftClient();

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
  public void testDelete() {
    expect().withPath("/oapi/v1/groups/group1").andReturn(200, new GroupBuilder().build()).once();
    expect().withPath("/oapi/v1/groups/Group2").andReturn( 200, new GroupBuilder().build()).once();

    OpenShiftClient client = getOpenshiftClient();

    Boolean deleted = client.groups().withName("group1").delete();
    assertNotNull(deleted);

    deleted = client.groups().withName("Group2").delete();
    assertTrue(deleted);

    deleted = client.groups().withName("Group3").delete();
    assertFalse(deleted);
  }
}
