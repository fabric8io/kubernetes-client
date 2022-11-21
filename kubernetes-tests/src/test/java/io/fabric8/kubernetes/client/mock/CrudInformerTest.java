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
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableKubernetesMockClient(crud = true)
class CrudInformerTest {

  KubernetesClient client;

  // https://github.com/fabric8io/kubernetes-client/issues/2306
  @Test
  void testCrudInformer() throws InterruptedException {
    Pod podToCreate = new PodBuilder().withNewMetadata().withName("pod1").endMetadata().build();
    SharedInformerFactory factory = client.informers();
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, 4000);
    BlockingQueue<Pod> events = new LinkedBlockingQueue<>();
    podInformer.addEventHandler(
        new ResourceEventHandler<Pod>() {
          @Override
          public void onAdd(Pod obj) {
            events.add(obj);
          }

          @Override
          public void onUpdate(Pod oldObj, Pod newObj) {
          }

          @Override
          public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) {
          }
        });
    factory.startAllRegisteredInformers();
    client.pods().create(podToCreate);
    Pod readPod = events.poll(10, TimeUnit.SECONDS);
    assertNotNull(readPod);
    assertEquals(readPod.getMetadata().getName(), podToCreate.getMetadata().getName());
    factory.stopAllRegisteredInformers();
  }
}
