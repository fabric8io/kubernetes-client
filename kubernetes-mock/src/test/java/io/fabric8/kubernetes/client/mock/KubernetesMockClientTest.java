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

import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsList;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.Assert;
import org.junit.Test;

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
}
