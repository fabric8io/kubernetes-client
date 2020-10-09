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
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import junit.framework.AssertionFailedError;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableRuleMigrationSupport
public class PodCrudTest {

  @Rule
  public KubernetesServer server = new KubernetesServer(true, true);

  @Test
  public void testCrud() { KubernetesClient client = server.getClient();
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
    pod2 = client.pods().inNamespace("ns1").withName("pod2").edit()
      .editMetadata().addToLabels("key1", "value1").endMetadata().done();
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
  public void testPodWatchOnName() throws InterruptedException {
    KubernetesClient client = server.getClient();
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").addToLabels("testKey", "testValue").endMetadata().build();
    final CountDownLatch deleteLatch = new CountDownLatch(1);
    final CountDownLatch closeLatch = new CountDownLatch(1);
    final CountDownLatch editLatch = new CountDownLatch(2);
    final CountDownLatch addLatch = new CountDownLatch(1);

    pod1 = client.pods().inNamespace("ns1").create(pod1);
    Watch watch = client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName()).watch(new Watcher<Pod>() {
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
      public void onClose(KubernetesClientException cause) {
        closeLatch.countDown();
      }
    });

    pod1 = client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName())
      .patch(new PodBuilder().withNewMetadataLike(pod1.getMetadata()).endMetadata().build());

    pod1.setSpec(new PodSpecBuilder().addNewContainer().withImage("nginx").withName("nginx").endContainer().build());

    client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName()).replace(pod1);

    client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName()).delete();

    client.pods().inNamespace("ns1").create(new PodBuilder().withNewMetadata().withName("pod1").addToLabels("testKey", "testValue").endMetadata().build());

    assertEquals(1, client.pods().inNamespace("ns1").list().getItems().size());
    assertTrue(addLatch.await(1, TimeUnit.MINUTES));
    assertTrue(editLatch.await(1, TimeUnit.MINUTES));
    assertTrue(deleteLatch.await(1, TimeUnit.MINUTES));

    watch.close();

    assertTrue(closeLatch.await(1, TimeUnit.MINUTES));
  }

  @Test
  public void testPodWatchOnNamespace() throws InterruptedException {
    KubernetesClient client = server.getClient();
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").addToLabels("testKey", "testValue").endMetadata().build();

    final CountDownLatch deleteLatch = new CountDownLatch(3);
    final CountDownLatch closeLatch = new CountDownLatch(1);
    final CountDownLatch addLatch = new CountDownLatch(3);
    final CountDownLatch editLatch = new CountDownLatch(2);

    client.pods().inNamespace("ns1").create(pod1);
    Watch watch = client.pods().inNamespace("ns1").watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        switch (action) {
          case DELETED:
            deleteLatch.countDown();
            break;
          case ADDED:
            addLatch.countDown();
            break;
          case MODIFIED:
            editLatch.countDown();
            break;
          default:
            throw new AssertionFailedError(action.toString());
        }
      }
      @Override
      public void onClose(KubernetesClientException cause) {
        closeLatch.countDown();
      }
    });


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
    assertTrue(closeLatch.await(2, TimeUnit.MINUTES));
  }

  @Test
  public void testPodWatchOnLabels() throws InterruptedException {
    KubernetesClient client = server.getClient();
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").addToLabels("test", "watch").endMetadata().build();

    final CountDownLatch deleteLatch = new CountDownLatch(1);
    final CountDownLatch closeLatch = new CountDownLatch(1);
    final CountDownLatch addLatch = new CountDownLatch(2);
    final CountDownLatch editLatch = new CountDownLatch(1);

    client.pods().inNamespace("ns1").create(pod1);
    Watch watch = client.pods().inNamespace("ns1")
      .withLabels(new HashMap<String, String>() {{ put("test", "watch");}})
      .watch(new Watcher<Pod>() {
        @Override
        public void eventReceived(Action action, Pod resource) {
          switch (action) {
            case DELETED:
              deleteLatch.countDown();
              break;
            case ADDED:
              addLatch.countDown();
              break;
            case MODIFIED:
              editLatch.countDown();
              break;
            default:
              throw new AssertionFailedError(action.toString());
          }
        }

        @Override
        public void onClose(KubernetesClientException cause) {
          closeLatch.countDown();
        }
    });

    Map<String, String> m = pod1.getMetadata().getLabels();
    m.put("foo", "bar");
    client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName())
      .patch(new PodBuilder().withNewMetadataLike(pod1.getMetadata()).endMetadata().build());

    client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName()).delete();

    client.pods().inNamespace("ns1").create(new PodBuilder()
      .withNewMetadata().withName("pod-new").addToLabels("test", "watch").endMetadata()
      .build());

    assertEquals(1, client.pods().inNamespace("ns1").list().getItems().size());
    assertTrue(deleteLatch.await(1, TimeUnit.MINUTES));
    assertTrue(editLatch.await(1, TimeUnit.MINUTES));

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
    assertTrue(addLatch.await(1, TimeUnit.MINUTES));

    watch.close();
    assertTrue(closeLatch.await(1, TimeUnit.MINUTES));
  }

  @Test
  public void testPodWatchClientSocketError() throws InterruptedException {
    KubernetesClient client = server.getClient();
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").addToLabels("testKey", "testValue").endMetadata().build();

    final CountDownLatch deleteLatch = new CountDownLatch(1);
    final CountDownLatch closeLatch = new CountDownLatch(1);
    final CountDownLatch editLatch = new CountDownLatch(1);
    final CountDownLatch addLatch = new CountDownLatch(1);

    client.pods().inNamespace("ns1").create(pod1);

    try (Watch watch = client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName()).watch(new Watcher<Pod>() {
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
        public void onClose(KubernetesClientException e) {
            closeLatch.countDown();
        }
      })) {
        client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName())
        .patch(new PodBuilder().withNewMetadataLike(pod1.getMetadata()).endMetadata().build());

        client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName()).delete();

        client.pods().inNamespace("ns1").create(new PodBuilder().withNewMetadata().withName("pod1").addToLabels("testKey", "testValue").endMetadata().build());

        assertEquals(1, client.pods().inNamespace("ns1").list().getItems().size());
        assertTrue(addLatch.await(1, TimeUnit.SECONDS));
        assertTrue(editLatch.await(1, TimeUnit.SECONDS));
        assertTrue(deleteLatch.await(1, TimeUnit.SECONDS));
      } finally {
        assertTrue(closeLatch.await(3, TimeUnit.SECONDS));
      }
    }
}
