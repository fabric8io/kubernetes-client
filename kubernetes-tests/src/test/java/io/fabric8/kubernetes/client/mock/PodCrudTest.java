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
import io.fabric8.kubernetes.api.model.PodSpecBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import junit.framework.AssertionFailedError;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient(crud = true)
class PodCrudTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testCrud() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").addToLabels("testKey", "testValue").endMetadata().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").addToLabels("testKey", "testValue").endMetadata().build();
    Pod pod3 = new PodBuilder().withNewMetadata().withName("pod3").endMetadata().build();

    client.pods().inNamespace("ns1").create(pod1);
    client.pods().inNamespace("ns1").create(pod2);
    client.pods().inNamespace("ns2").create(pod3);

    PodList podList = client.pods().list();
    assertNotNull(podList);
    assertEquals(0, podList.getItems().size());

    podList = client.pods().inAnyNamespace().withLabels(Collections.singletonMap("testKey", "testValue")).list();
    assertNotNull(podList);
    assertEquals(2, podList.getItems().size());

    podList = client.pods().inNamespace("ns1").list();
    assertNotNull(podList);
    assertEquals(2, podList.getItems().size());

    podList = client.pods().inAnyNamespace().list();
    assertNotNull(podList);
    assertEquals(3, podList.getItems().size());

    client.pods().inNamespace("ns1").withName("pod1").delete();
    podList = client.pods().inNamespace("ns1").list();
    assertNotNull(podList);
    assertEquals(1, podList.getItems().size());

    podList = client.pods().inAnyNamespace().list();
    assertNotNull(podList);
    assertEquals(2, podList.getItems().size());

    // test update
    pod2 = client.pods().inNamespace("ns1").withName("pod2").edit(p -> new PodBuilder(p)
                 .editMetadata().addToLabels("key1", "value1").endMetadata().build());
    assertNotNull(pod2);
    assertEquals("value1", pod2.getMetadata().getLabels().get("key1"));

    podList = client.pods().inNamespace("ns1").list();
    assertNotNull(podList);
    assertEquals(1, podList.getItems().size());

    Pod pod = client.pods().inNamespace("ns1").withName("pod2").get();
    assertNotNull(pod);
    assertEquals(2, pod.getMetadata().getLabels().size());
  }

  @Test
  void testPodWatchOnName() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").addToLabels("testKey", "testValue").endMetadata().build();
    final LatchedWatcher lw = new LatchedWatcher(1, 2, 1, 1, 1);

    pod1 = client.pods().inNamespace("ns1").create(pod1);
    Watch watch = client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName()).watch(lw);

    pod1 = client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName())
      .patch(new PodBuilder().withNewMetadataLike(pod1.getMetadata()).endMetadata().build());

    pod1.setSpec(new PodSpecBuilder().addNewContainer().withImage("nginx").withName("nginx").endContainer().build());

    client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName()).replace(pod1);

    client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName()).delete();

    client.pods().inNamespace("ns1").create(new PodBuilder().withNewMetadata().withName("pod1").addToLabels("testKey", "testValue").endMetadata().build());

    assertEquals(1, client.pods().inNamespace("ns1").list().getItems().size());
    assertTrue(lw.addLatch.await(1, TimeUnit.MINUTES));
    assertTrue(lw.editLatch.await(1, TimeUnit.MINUTES));
    assertTrue(lw.deleteLatch.await(1, TimeUnit.MINUTES));

    watch.close();

    assertTrue(lw.closeLatch.await(1, TimeUnit.MINUTES));
  }

  @Test
  void testPodWatchOnNamespace() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").addToLabels("testKey", "testValue").endMetadata().build();

    final LatchedWatcher lw = new LatchedWatcher();

    client.pods().inNamespace("ns1").create(pod1);
    Watch watch = client.pods().inNamespace("ns1").watch(lw);

    client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName())
      .patch(new PodBuilder().withNewMetadataLike(pod1.getMetadata()).endMetadata().build());

    client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName()).delete();

    client.pods().inNamespace("ns1").create(new PodBuilder()
      .withNewMetadata().withName("pod-new").addToLabels("testKey", "testValue").endMetadata()
      .build());

    assertEquals(1, client.pods().inNamespace("ns1").list().getItems().size());

    client.pods().inNamespace("ns1").withName("pod-new").delete();

    assertEquals(0, client.pods().inNamespace("ns1").list().getItems().size());

    watch.close();
    assertTrue(lw.closeLatch.await(1, TimeUnit.MINUTES));
  }

  @Test
  void testPodWatchOnLabels() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").addToLabels("test", "watch").endMetadata().build();

    final LatchedWatcher lw = new LatchedWatcher(2, 1, 1, 1, 1);

    client.pods().inNamespace("ns1").create(pod1);
    Watch watch = client.pods().inNamespace("ns1")
      .withLabels(new HashMap<String, String>() {{ put("test", "watch");}})
      .watch(lw);

    Map<String, String> m = pod1.getMetadata().getLabels();
    m.put("foo", "bar");
    client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName())
      .patch(new PodBuilder().withNewMetadataLike(pod1.getMetadata()).endMetadata().build());

    client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName()).delete();

    client.pods().inNamespace("ns1").create(new PodBuilder()
      .withNewMetadata().withName("pod-new").addToLabels("test", "watch").endMetadata()
      .build());

    assertEquals(1, client.pods().inNamespace("ns1").list().getItems().size());
    assertTrue(lw.deleteLatch.await(1, TimeUnit.MINUTES));
    assertTrue(lw.editLatch.await(1, TimeUnit.MINUTES));

    Pod pod2 = client.pods().inNamespace("ns1").create(new PodBuilder()
      .withNewMetadata().withName("pod2").addToLabels("foo", "bar").endMetadata()
      .build());

    assertEquals(2, client.pods().inNamespace("ns1").list().getItems().size());
    assertEquals(1, client.pods().inNamespace("ns1").withLabel("test", "watch").list().getItems().size());

    Map<String, String> m1 = pod2.getMetadata().getLabels();
    m1.put("test", "watch");

    client.pods().inNamespace("ns1").withName(pod2.getMetadata().getName())
      .patch(new PodBuilder().withNewMetadataLike(pod2.getMetadata()).endMetadata().build());

    assertEquals(2, client.pods().inNamespace("ns1").list().getItems().size());
    assertEquals(2, client.pods().inNamespace("ns1").withLabel("test", "watch").list().getItems().size());
    assertTrue(lw.addLatch.await(1, TimeUnit.MINUTES));

    watch.close();
    assertTrue(lw.closeLatch.await(1, TimeUnit.MINUTES));
  }

  @Test
  void testPodWatchTryWithResources() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").addToLabels("testKey", "testValue").endMetadata().build();

    final LatchedWatcher lw = new LatchedWatcher();

    client.pods().inNamespace("ns1").create(pod1);

    try (
      Watch watch = client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName()).watch(lw)
    ) {
      client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName())
        .patch(new PodBuilder().withNewMetadataLike(pod1.getMetadata()).endMetadata().build());

      client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName()).delete();

      client.pods().inNamespace("ns1").create(new PodBuilder().withNewMetadata().withName("pod1").addToLabels("testKey", "testValue").endMetadata().build());

      assertEquals(1, client.pods().inNamespace("ns1").list().getItems().size());
      assertTrue(lw.addLatch.await(1, TimeUnit.SECONDS));
      assertTrue(lw.editLatch.await(1, TimeUnit.SECONDS));
      assertTrue(lw.deleteLatch.await(1, TimeUnit.SECONDS));
    }
    assertTrue(lw.closeLatch.await(3, TimeUnit.SECONDS));
  }

    private static final class LatchedWatcher implements Watcher<Pod> {
      final CountDownLatch addLatch;
      final CountDownLatch editLatch;
      final CountDownLatch deleteLatch;
      final CountDownLatch closeErrorLatch;
      final CountDownLatch closeLatch;

      public LatchedWatcher() {
        this(1, 1, 1, 1, 1);
      }
      public LatchedWatcher(int addLatch, int editLatch, int deleteLatch, int closeErrorLatch, int closeLatch) {
        this.addLatch = new CountDownLatch(addLatch);
        this.editLatch = new CountDownLatch(editLatch);
        this.deleteLatch = new CountDownLatch(deleteLatch);
        this.closeErrorLatch = new CountDownLatch(closeErrorLatch);
        this.closeLatch = new CountDownLatch(closeLatch);
      }

      @Override
      public void eventReceived(Action action, Pod resource) {
        switch (action) {
          case DELETED:
            deleteLatch.countDown();
            break;
          case MODIFIED:
            editLatch.countDown();
            break;
          case ADDED:
            addLatch.countDown();
            break;
          default:
            throw new AssertionFailedError(action.toString().concat(" isn't recognised."));
        }
      }

      @Override
      public void onClose(WatcherException e) {
        closeErrorLatch.countDown();
      }

      @Override
      public void onClose() {
        closeLatch.countDown();
      }
    }
}
