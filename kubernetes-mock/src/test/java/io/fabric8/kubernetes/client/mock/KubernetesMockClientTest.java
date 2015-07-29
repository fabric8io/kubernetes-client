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
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.Assert;
import org.junit.Test;

public class KubernetesMockClientTest {

  @Test
  public void testGetPod() {
    KubernetesMockClient mock = new KubernetesMockClient();
    mock.pods().inNamespace("ns1").withName("pod1").getIfExists().andReturn(new PodBuilder()
        .withNewMetadata().withName("pod1").endMetadata()
        .build()
    ).once();

    mock.pods().inNamespace("ns1").withName("pod2").getIfExists().andReturn(new PodBuilder()
        .withNewMetadata().withName("pod2").endMetadata()
        .build()
    ).once();

    mock.pods().inNamespace("ns1").withName("pod2").getIfExists().andReturn(null).once();

    KubernetesClient client = mock.replay();
    Assert.assertNotNull(client.pods().inNamespace("ns1").withName("pod1").getIfExists());
    Assert.assertNotNull(client.pods().inNamespace("ns1").withName("pod2").getIfExists());
    Assert.assertNull(client.pods().inNamespace("ns1").withName("pod2").getIfExists());
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
    ).once();

    KubernetesClient client = mock.replay();
    PodList result  = client.pods().inNamespace("ns1").withLabel("component", "f1").list();
    Assert.assertNotNull(result);
    Assert.assertEquals(2, result.getItems().size());
  }

}
