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


import io.fabric8.openshift.api.model.RoleBinding;
import io.fabric8.openshift.api.model.RoleBindingBuilder;
import io.fabric8.openshift.api.model.RoleBindingList;
import io.fabric8.openshift.api.model.RoleBindingListBuilder;
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import org.junit.Assert;
import org.junit.Test;

public class RoleBindingMockTest {

  @Test
  public void testCreate() {
    RoleBinding rb1 = new RoleBindingBuilder().withNewMetadata().withName("rb1").endMetadata()
      .withUserNames("user1")
      .withGroupNames("group1")
      .build();

    OpenShiftMockClient mock = new OpenShiftMockClient();


    mock.roleBindings().inNamespace("ns1").create(rb1).andReturn(rb1).anyTimes();

    NamespacedOpenShiftClient client = mock.replay();

    RoleBinding response = client.roleBindings().inNamespace("ns1").create(rb1);
    Assert.assertEquals(rb1, response);
  }

  @Test
  public void testList() {
    RoleBinding rb1 = new RoleBindingBuilder().withNewMetadata().withName("rb1").endMetadata()
      .withUserNames("user1")
      .withGroupNames("group1")
      .build();

    OpenShiftMockClient mock = new OpenShiftMockClient();


    mock.roleBindings().inNamespace("ns1").list().andReturn(new RoleBindingListBuilder().addToItems(rb1).build()).anyTimes();

    NamespacedOpenShiftClient client = mock.replay();

    RoleBindingList response = client.roleBindings().inNamespace("ns1").list();

    Assert.assertNotNull(response);
    Assert.assertEquals(1, response.getItems().size());
    Assert.assertTrue(response.getItems().contains(rb1));
  }
}
