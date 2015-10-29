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


import io.fabric8.openshift.api.model.BuildBuilder;
import io.fabric8.openshift.api.model.BuildList;
import io.fabric8.openshift.api.model.BuildListBuilder;
import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.GroupBuilder;
import io.fabric8.openshift.api.model.GroupList;
import io.fabric8.openshift.api.model.GroupListBuilder;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.api.model.UserBuilder;
import io.fabric8.openshift.api.model.UserList;
import io.fabric8.openshift.api.model.UserListBuilder;
import io.fabric8.openshift.api.model.WebHookTrigger;
import io.fabric8.openshift.client.OpenShiftClient;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import static org.easymock.EasyMock.eq;

public class OpenShiftMockClientTest {

  @Test
  public void testGetBuild() {
    OpenShiftMockClient mock = new OpenShiftMockClient();

    mock.builds().inNamespace(eq("ns1")).withName("build1").get().andReturn(new BuildBuilder()
        .withNewMetadata().withName("build1").endMetadata()
        .build()
    ).anyTimes();

    mock.builds().inNamespace("ns1").withName("build2").get().andReturn(new BuildBuilder()
        .withNewMetadata().withName("build2").endMetadata()
        .build()
    ).once();

    mock.builds().inNamespace("ns1").withName("build2").get().andReturn(null).once();

    OpenShiftClient client = mock.replay();

    //We are testing the internal anyTimes() on namespace and name.
    for (int i = 0; i < 5; i++) {
      Assert.assertNotNull(client.builds().inNamespace("ns1").withName("build1").get());
    }
    Assert.assertNotNull(client.builds().inNamespace("ns1").withName("build2").get());
    Assert.assertNull(client.builds().inNamespace("ns1").withName("build2").get());
  }

  @Test
  public void testListBuilds() {
    OpenShiftMockClient mock = new OpenShiftMockClient();

    mock.builds().inNamespace("ns1").withLabel("component", "f1").list().andReturn(new BuildListBuilder()
        .addNewItem()
        .withNewMetadata().withName("build1").endMetadata()
        .endItem()
        .addNewItem()
        .withNewMetadata().withName("build2").endMetadata()
        .endItem()
        .build()
    ).anyTimes();

    mock.builds().inNamespace("ns1").withLabel("component", "f2").list().andReturn(new BuildListBuilder()
        .addNewItem()
        .withNewMetadata().withName("build1").endMetadata()
        .endItem()
        .build()
    ).anyTimes();

    OpenShiftClient client = mock.replay();

    for (int i=0;i<5;i++) {
      BuildList result = client.builds().inNamespace("ns1").withLabel("component", "f1").list();
      Assert.assertNotNull(result);
      Assert.assertEquals(2, result.getItems().size());
    }

    for (int i=0;i<5;i++) {
      BuildList result = client.builds().inNamespace("ns1").withLabel("component", "f2").list();
      Assert.assertNotNull(result);
      Assert.assertEquals(1, result.getItems().size());
    }
  }


  @Test
  public void testWebHookTrigger() {
    OpenShiftMockClient mock = new OpenShiftMockClient();
    mock.buildConfigs().inNamespace("ns1").withName("build1").withSecret("secret101").withType("github").trigger(EasyMock.<WebHookTrigger>anyObject()).andReturn(null).once();
    OpenShiftClient client = mock.replay();
    client.buildConfigs().inNamespace("ns1").withName("build1").withSecret("secret101").withType("github").trigger(new WebHookTrigger());
    mock.verify();
  }



  @Test
  public void testUsers() {
    OpenShiftMockClient mock = new OpenShiftMockClient();

    User myuser = new UserBuilder()
      .withNewMetadata()
        .withName("myuser")
        .endMetadata()
        .withFullName("My User")
      .addToIdentities("myuser")
      .build();

    mock.users().list().andReturn(new UserListBuilder().addToItems(myuser).build()).anyTimes();

    mock.users().withLabel("key1", "value1").list().andReturn(new UserListBuilder().addToItems(myuser).build()).anyTimes();


    OpenShiftClient client = mock.replay();
    UserList userList = client.users().list();
    Assert.assertFalse(userList.getItems().isEmpty());

    userList = client.users().withLabel("key1","value1").list();
    Assert.assertFalse(userList.getItems().isEmpty());
    Assert.assertTrue(userList.getItems().get(0).getIdentities().contains("myuser"));
    mock.verify();
  }


  @Test
  public void testGroups() {
    OpenShiftMockClient mock = new OpenShiftMockClient();

    Group mygroup = new GroupBuilder()
      .withNewMetadata()
      .withName("mygroup")
      .endMetadata()
      .addToUsers("myuser", "myotheruser")
      .build();

    mock.groups().list().andReturn(new GroupListBuilder().addToItems(mygroup).build()).anyTimes();

    mock.groups().withLabel("key1", "value1").list().andReturn(new GroupListBuilder().addToItems(mygroup).build()).anyTimes();


    OpenShiftClient client = mock.replay();
    GroupList groupList = client.groups().list();
    Assert.assertFalse(groupList.getItems().isEmpty());

    groupList = client.groups().withLabel("key1","value1").list();
    Assert.assertFalse(groupList.getItems().isEmpty());
    Assert.assertTrue(groupList.getItems().get(0).getUsers().contains("myuser"));
    Assert.assertTrue(groupList.getItems().get(0).getUsers().contains("myotheruser"));
    mock.verify();
  }

}
