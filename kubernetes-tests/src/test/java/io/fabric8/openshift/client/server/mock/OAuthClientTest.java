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

import io.fabric8.openshift.api.model.OAuthClient;
import io.fabric8.openshift.api.model.OAuthClientBuilder;
import io.fabric8.openshift.api.model.OAuthClientList;
import io.fabric8.openshift.api.model.OAuthClientListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class OAuthClientTest {
  @Rule
  public OpenShiftServer server = new OpenShiftServer();

  @Test
  public void testList() {
   server.expect().withPath("/oapi/v1/oauthclients").andReturn(200, new OAuthClientListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();


    OpenShiftClient client = server.getOpenshiftClient();

    OAuthClientList oauthclientList = client.oAuthClients().list();
    assertNotNull(oauthclientList);
    assertEquals(2, oauthclientList.getItems().size());
  }


  @Test
  public void testGet() {
   server.expect().withPath("/oapi/v1/oauthclients/client1").andReturn(200, new OAuthClientBuilder()
      .withNewMetadata().withName("client1").endMetadata()
      .build()).once();

   server.expect().withPath("/oapi/v1/oauthclients/client2").andReturn(200, new OAuthClientBuilder()
      .withNewMetadata().withName("client2").endMetadata()
      .build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

    OAuthClient oauthclient = client.oAuthClients().withName("client1").get();
    assertNotNull(oauthclient);
    assertEquals("client1", oauthclient.getMetadata().getName());

    oauthclient = client.oAuthClients().withName("client2").get();
    assertNotNull(oauthclient);
    assertEquals("client2", oauthclient.getMetadata().getName());

    oauthclient = client.oAuthClients().withName("client3").get();
    assertNull(oauthclient);
  }


  @Test
  public void testDelete() {
   server.expect().withPath("/oapi/v1/oauthclients/client1").andReturn(200, new OAuthClientBuilder().build()).once();
   server.expect().withPath("/oapi/v1/oauthclients/client2").andReturn(200, new OAuthClientBuilder().build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

    Boolean deleted = client.oAuthClients().withName("client1").delete();
    assertNotNull(deleted);

    deleted = client.oAuthClients().withName("client2").delete();
    assertTrue(deleted);

    deleted = client.oAuthClients().withName("client3").delete();
    assertFalse(deleted);
  }
}
