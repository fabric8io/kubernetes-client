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

package io.fabric8.kubernetes.client.mock;


import io.fabric8.kubernetes.client.OpenShiftClient;
import io.fabric8.openshift.api.model.BuildBuilder;
import io.fabric8.openshift.api.model.BuildList;
import io.fabric8.openshift.api.model.BuildListBuilder;
import io.fabric8.openshift.api.model.WebHookTrigger;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import static org.easymock.EasyMock.eq;

public class OpenshiftMockClientTest {

  @Test
  public void testGetBuild() {
    OpenshiftMockClient mock = new OpenshiftMockClient();

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
    OpenshiftMockClient mock = new OpenshiftMockClient();

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
    OpenshiftMockClient mock = new OpenshiftMockClient();
    mock.buildConfigs().inNamespace("ns1").withName("build1").withSecret("secret101").withType("github").trigger(EasyMock.<WebHookTrigger>anyObject()).andReturn(null).once();
    OpenShiftClient client = mock.replay();
    client.buildConfigs().inNamespace("ns1").withName("build1").withSecret("secret101").withType("github").trigger(new WebHookTrigger());
    mock.verify();
  }

}
