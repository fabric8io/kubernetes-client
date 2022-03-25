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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodStatus;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableKubernetesMockClient(crud = true)
class MetadataCrudTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testResourceVersion() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").addToLabels("testKey", "testValue").endMetadata().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").addToLabels("testKey", "testValue").endMetadata().build();

    NonNamespaceOperation<Pod, PodList, PodResource> podClient = client.pods().inNamespace("ns1");
    pod1 = podClient.create(pod1);
    pod2 = podClient.create(pod2);

    assertEquals("1", pod1.getMetadata().getResourceVersion());
    assertEquals("2", pod2.getMetadata().getResourceVersion());

    PodList podList = client.pods().list();
    assertEquals("2", podList.getMetadata().getResourceVersion());

    // should do nothing
    pod1 = podClient.createOrReplace(pod1);
    assertEquals("1", pod1.getMetadata().getResourceVersion());

    // should increment
    pod1 = podClient.withName("pod1").editStatus(p -> new PodBuilder(p).withStatus(new PodStatus()).build());
    assertEquals("3", pod1.getMetadata().getResourceVersion());
  }

}
