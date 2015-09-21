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

import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsList;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

import static org.easymock.EasyMock.eq;

public class KubernetesMockClientTest {

  @Test
  public void testGetPod() {
    KubernetesMockClient mock = new KubernetesMockClient();
    mock.pods().inNamespace(eq("ns1")).withName(eq("pod1")).get().andReturn(new PodBuilder()
        .withNewMetadata().withName("pod1").endMetadata()
        .build()
    ).anyTimes();

    mock.pods().inNamespace("ns1").withName("pod2").get().andReturn(new PodBuilder()
        .withNewMetadata().withName("pod2").endMetadata()
        .build()
    ).once();

    mock.pods().inNamespace("ns1").withName("pod2").get().andReturn(null).once();

    KubernetesClient client = mock.replay();

    //We are testing the internal anyTimes() on namespace and name.
    for (int i = 0; i < 5; i++) {
      Object o = client.pods().inNamespace("ns1").withName("pod1");
      Assert.assertNotNull(client.pods().inNamespace("ns1").withName("pod1").get());
    }
    Assert.assertNotNull(client.pods().inNamespace("ns1").withName("pod2").get());
    Assert.assertNull(client.pods().inNamespace("ns1").withName("pod2").get());
  }

  @Test
  public void testListPods() {
    KubernetesMockClient mock = new KubernetesMockClient();
    mock.pods().inNamespace("ns1").withLabel("component", "f1").list().andReturn(new PodListBuilder()
        .addNewItem()
        .withNewMetadata().withName("pod1").endMetadata()
        .endItem()
        .addNewItem()
        .withNewMetadata().withName("pod2").endMetadata()
        .endItem()
        .build()
    ).anyTimes();

    mock.pods().inNamespace("ns1").withLabel("component", "f2").list().andReturn(new PodListBuilder()
        .addNewItem()
        .withNewMetadata().withName("pod1").endMetadata()
        .endItem()
        .build()
    ).anyTimes();

    KubernetesClient client = mock.replay();

    for (int i = 0; i < 5; i++) {
      PodList result = client.pods().inNamespace("ns1").withLabel("component", "f1").list();
      Assert.assertNotNull(result);
      Assert.assertEquals(2, result.getItems().size());
    }

    for (int i = 0; i < 5; i++) {
      PodList result = client.pods().inNamespace("ns1").withLabel("component", "f2").list();
      Assert.assertNotNull(result);
      Assert.assertEquals(1, result.getItems().size());
    }
  }


  @Test
  public void testCascading() {
    KubernetesMockClient mock = new KubernetesMockClient();
    mock.pods().inNamespace("ns1").withName("name").cascading(false).delete().andReturn(true).anyTimes();

    KubernetesClient client = mock.replay();

    for (int i = 0; i < 5; i++) {
      client.pods().inNamespace("ns1").withName("name").cascading(false).delete();
    }

    Boolean assertionError = false;
    try {
      mock.pods().inNamespace("ns1").withName("name").delete().andReturn(true).anyTimes();
    } catch (AssertionError e) {
      //unexpected call without cascading
      assertionError = true;
    }
    Assert.assertTrue(assertionError);
  }

  @Test
  public void testScaling() {
    KubernetesMockClient mock = new KubernetesMockClient();

    ReplicationController repl1 = new ReplicationControllerBuilder()
      .withNewMetadata()
      .withName("repl1")
      .endMetadata()
      .build();

    mock.replicationControllers().inNamespace("ns1").withName("repl1").scale(1).andReturn(repl1).once();
    mock.replicationControllers().inNamespace("ns1").withName("repl1").scale(2).andReturn(repl1).once();
    mock.replicationControllers().inNamespace("ns1").withName("repl1").scale(3).andReturn(repl1).once();


    KubernetesClient client = mock.replay();

    client.replicationControllers().inNamespace("ns1").withName("repl1").scale(1);
    client.replicationControllers().inNamespace("ns1").withName("repl1").scale(2);
    client.replicationControllers().inNamespace("ns1").withName("repl1").scale(3);

    EasyMock.verify(client);
  }


  @Test
  public void testRolling() {
    KubernetesMockClient mock = new KubernetesMockClient();

    ReplicationController repl1 = new ReplicationControllerBuilder()
      .withNewMetadata()
      .withName("repl1")
      .endMetadata()
      .build();

    mock.replicationControllers().inNamespace("ns1").withName("repl1").rolling().updateImage("myimage").andReturn(repl1).once();
    mock.replicationControllers().inNamespace("ns1").withName("repl1").rolling().updateImage("myimage2").andReturn(repl1).once();


    KubernetesClient client = mock.replay();

    client.replicationControllers().inNamespace("ns1").withName("repl1").rolling().updateImage("myimage");
    client.replicationControllers().inNamespace("ns1").withName("repl1").rolling().updateImage("myimage2");

    EasyMock.verify(client);
  }


  @Test
  public void testLoad() {
    KubernetesMockClient mock = new KubernetesMockClient();

    ReplicationController repl1 = new ReplicationControllerBuilder()
      .withNewMetadata()
      .withName("repl1")
      .endMetadata()
      .build();

    mock.replicationControllers().inNamespace("ns1").load(EasyMock.<InputStream>anyObject()).get().andReturn(repl1);
    KubernetesClient client = mock.replay();

    InputStream is = EasyMock.createMock(InputStream.class);
    Assert.assertEquals(repl1, client.replicationControllers().inNamespace("ns1").load(is).get());

    EasyMock.verify(client);
  }

  @Test
  public void testKubernetesList() {
    KubernetesMockClient mock = new KubernetesMockClient();

    KubernetesList list1 = new KubernetesListBuilder()
      .addNewReplicationControllerItem()
      .withNewMetadata()
      .withName("repl1")
      .endMetadata()
      .endReplicationControllerItem()
      .addNewServiceItem()
      .withNewMetadata()
      .withName("srv1")
      .endMetadata()
      .endServiceItem()
      .build();

    mock.lists().inNamespace("ns1").load(EasyMock.<InputStream>anyObject()).get().andReturn(list1);
    KubernetesClient client = mock.replay();

    InputStream is = EasyMock.createMock(InputStream.class);
    Assert.assertEquals(list1, client.lists().inNamespace("ns1").load(is).get());

    EasyMock.verify(client);
  }


  @Test
  public void testListSecurityContextConstraints() {
    KubernetesMockClient mock = new KubernetesMockClient();
    mock.securityContextConstraints().list().andReturn(new SecurityContextConstraintsListBuilder()
      .addNewItem()
      .withNewMetadata()
      .withName("scc1")
      .endMetadata()
      .withAllowHostPorts(true)
      .withAllowPrivilegedContainer(true)
      .endItem()
      .build()).anyTimes();

    KubernetesClient client = mock.replay();

    for (int i = 0; i < 5; i++) {
      SecurityContextConstraintsList result = client.securityContextConstraints().list();
      Assert.assertNotNull(result);
      Assert.assertEquals(1, result.getItems().size());
    }
  }

  @Test
  public void testGetLog() {
    KubernetesMockClient mock = new KubernetesMockClient();

    mock.pods().inNamespace("ns1").withName("myPod").getLog("cnt1", true).andReturn("log1").anyTimes();
    mock.pods().inNamespace("ns1").withName("myPod").getLog("cnt2", true).andReturn("log2").anyTimes();

    KubernetesClient client = mock.replay();

    Assert.assertEquals("log1", client.pods().inNamespace("ns1").withName("myPod").getLog("cnt1", true));
    Assert.assertEquals("log2", client.pods().inNamespace("ns1").withName("myPod").getLog("cnt2", true));

    EasyMock.verify(client);
  }

  @Test
  public void testNamespaced() {
    KubernetesMockClient mock = new KubernetesMockClient();
    KubernetesMockClient ns1 = mock.inNamespace("ns1");
    KubernetesMockClient ns2 = ns1.inNamespace("ns2");

    KubernetesMockClient all = ns2.inAnyNamespace();

    ns1.replicationControllers().withName("repl1").get().andReturn(new ReplicationControllerBuilder().withNewMetadata().withName("repl1").endMetadata().build());
    ns2.replicationControllers().withName("repl2").get().andReturn(new ReplicationControllerBuilder().withNewMetadata().withName("repl1").endMetadata().build());

    KubernetesClient client = mock.replay();
    client = client.inNamespace("ns1");
    Assert.assertNotNull(client);
    Assert.assertNotNull(client.replicationControllers().withName("repl1").get());

    client = client.inNamespace("ns2");
    Assert.assertNotNull(client);
  }
}
