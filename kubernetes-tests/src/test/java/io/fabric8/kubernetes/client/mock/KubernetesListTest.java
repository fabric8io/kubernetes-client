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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
public class KubernetesListTest {

  KubernetesMockServer server;
  KubernetesClient client;

  Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
  Service service1 = new ServiceBuilder().withNewMetadata().withName("service1").withNamespace("test").and().build();
  ReplicationController replicationController1 = new ReplicationControllerBuilder()
      .withNewMetadata().withName("repl1").withNamespace("test").endMetadata()
      .withNewSpec().withReplicas(1).endSpec()
      .withNewStatus().withReplicas(1).endStatus()
      .build();

  KubernetesList list = new KubernetesListBuilder().withItems(pod1, service1, replicationController1).build();

  @Test
  public void testCreate() {
    server.expect().withPath("/api/v1/namespaces/test/pods").andReturn(201, pod1).once();
    server.expect().withPath("/api/v1/namespaces/test/services").andReturn(201, service1).once();
    server.expect().withPath("/api/v1/namespaces/test/replicationcontrollers").andReturn(201, replicationController1).once();

    List<HasMetadata> result = client.resourceList(list.getItems()).inNamespace("test").create();

    assertNotNull(result);
    assertEquals(3, result.size());

    assertTrue(result.contains(pod1));
    assertTrue(result.contains(service1));
    assertTrue(result.contains(replicationController1));
  }

  @Test
  public void testLoadAndCreate() {
    server.expect().withPath("/api/v1/namespaces/test/replicationcontrollers").andReturn(201, replicationController1).times(2);

    InputStream is = KubernetesListTest.class.getResourceAsStream("/test-rclist.json");
    List<HasMetadata> result = client.load(is).inNamespace("test").create();

    assertNotNull(result);
    assertEquals(2, result.size());
  }

  @Test
  public void testDelete() {
    server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, pod1).always();
    server.expect().withPath("/api/v1/namespaces/test/services/service1").andReturn(200, service1).always();
    server.expect().withPath("/api/v1/namespaces/test/replicationcontrollers/repl1").andReturn(200, replicationController1)
        .once();
    server.expect().withPath("/api/v1/namespaces/test/replicationcontrollers/repl1")
        .andReturn(200, new ReplicationControllerBuilder(replicationController1)
            .editSpec().withReplicas(0).and()
            .editStatus().withReplicas(0).and().build())
        .times(5);

    Boolean result = client.resourceList(list).delete().size() == 3;

    assertTrue(result);
  }

  @Test
  public void testDeleteWithMismatch() {
    assertTrue(client.resourceList(list).inNamespace("test1").delete().isEmpty());
  }
}
