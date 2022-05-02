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
package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WaitUntilReadyIT {

  KubernetesClient client;

  private final Pod pod = new PodBuilder()
      .withNewMetadata().withName("p1").addToLabels("test", "WaitUntilReadyIT").endMetadata()
      .withNewSpec()
      .addNewContainer()
      .withName("myapp-container")
      .withImage("busybox")
      .withCommand("sh", "-c", "echo The app is running!; sleep 60")
      .endContainer()
      .addNewInitContainer()
      .withName("init-myservice")
      .withImage("busybox")
      .withCommand("sh", "-c", "echo inititalizing...; sleep 1")
      .endInitContainer()
      .endSpec()
      .build();

  private final Pod secondPod = new PodBuilder()
      .withNewMetadata().withName("p2").addToLabels("test", "WaitUntilReadyIT").endMetadata()
      .withNewSpec()
      .addNewContainer()
      .withName("myapp2-container")
      .withImage("busybox")
      .withCommand("sh", "-c", "echo The app is running!; sleep 60")
      .endContainer()
      .addNewInitContainer()
      .withName("init2-mypod")
      .withImage("busybox")
      .withCommand("sh", "-c", "echo initializing...; sleep 1")
      .endInitContainer()
      .endSpec()
      .build();

  private final Secret mySecret = new SecretBuilder()
      .withNewMetadata().withName("my-secret").addToLabels("test", "WaitUntilReadyIT").endMetadata()
      .withType("Opaque")
      .addToData("username", "YWRtaW4=")
      .addToData("password", "MWYyZDFlMmU2N2Rm")
      .build();

  @Test
  void testBatchWaitUntilReady() throws InterruptedException, ExecutionException, TimeoutException {
    Pod podCreated = client.pods().create(pod);
    Pod secondPodCreated = client.pods().create(secondPod);
    Secret mySecretCreated = client.secrets().create(mySecret);

    // For waiting for single resource use this.
    client.resourceList(new KubernetesListBuilder().withItems(podCreated, secondPodCreated, mySecretCreated).build())
        .waitUntilReady(60, TimeUnit.SECONDS);

    // Cleanup
    assertTrue(client.pods().withName("p1").withGracePeriod(0L).delete().size() == 1);
    assertTrue(client.pods().withName("p2").withGracePeriod(0L).delete().size() == 1);
    assertTrue(client.secrets().withName("my-secret").delete().size() == 1);

    // wait for all pods to be deleted
    CompletableFuture<List<Pod>> pods = client.pods()
        .withLabel("test", "WaitUntilReadyIT")
        .informOnCondition(Collection::isEmpty);
    try {
      pods.get(60, TimeUnit.SECONDS);
    } finally {
      pods.cancel(true);
    }
  }
}
