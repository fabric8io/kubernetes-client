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

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ResourceTest {

  @Rule
  public KubernetesServer server = new KubernetesServer();


    @Test
    public void testCreateOrReplace() {
        Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();

        server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(404, "").once();
        server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(201, pod1).once();

        KubernetesClient client = server.getClient();
        HasMetadata response = client.resource(pod1).createOrReplace();
        assertEquals(pod1, response);
    }

    @Test
    public void testCreateWithExplicitNamespace() {
        Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();

        server.expect().get().withPath("/api/v1/namespaces/ns1/pods/pod1").andReturn(404, "").once();
        server.expect().post().withPath("/api/v1/namespaces/ns1/pods").andReturn(201, pod1).once();

        KubernetesClient client = server.getClient();
        HasMetadata response = client.resource(pod1).inNamespace("ns1").apply();
        assertEquals(pod1, response);
    }

  @Test
  public void testDelete() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").withNamespace("ns1").and().build();
    Pod pod3 = new PodBuilder().withNewMetadata().withName("pod3").withNamespace("any").and().build();

   server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, pod1).once();
   server.expect().withPath("/api/v1/namespaces/ns1/pods/pod2").andReturn(200, pod2).once();

    KubernetesClient client = server.getClient();
    Boolean deleted = client.resource(pod1).delete();
    assertTrue(deleted);
    deleted = client.resource(pod2).delete();
    assertTrue(deleted);

    deleted = client.resource(pod3).delete();
    assertFalse(deleted);
  }


  @Test
  public void testWatch() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
        .withName("pod1")
        .withResourceVersion("1")
      .withNamespace("test").and().build();

      server.expect().get().withPath("/api/v1/namespaces/test/pods").andReturn(200, pod1).once();
      server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(201, pod1).once();

     server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&watch=true").andUpgradeToWebSocket()
        .open()
          .waitFor(1000).andEmit(new WatchEvent(pod1, "DELETED"))
        .done()
      .always();

    KubernetesClient client = server.getClient();
    final CountDownLatch latch = new CountDownLatch(1);

    Watch watch = client.resource(pod1).watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        latch.countDown();
      }

      @Override
      public void onClose(KubernetesClientException cause) {

      }
    });
    Assert.assertTrue(latch.await(5000, TimeUnit.MILLISECONDS));
    watch.close();
  }


  @Test
  public void testWaitUntilReady() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
      .withName("pod1")
      .withResourceVersion("1")
      .withNamespace("test").and().build();


    Pod noReady = new PodBuilder(pod1).withNewStatus()
      .addNewCondition()
          .withType("Ready")
          .withStatus("False")
        .endCondition()
      .endStatus()
      .build();

    Pod ready = new PodBuilder(pod1).withNewStatus()
        .addNewCondition()
          .withType("Ready")
          .withStatus("True")
        .endCondition()
      .endStatus()
      .build();

    server.expect().get().withPath("/api/v1/namespaces/test/pods").andReturn(200, noReady).once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&watch=true").andUpgradeToWebSocket()
      .open()
      .waitFor(1000).andEmit(new WatchEvent(ready, "MODIFIED"))
      .done()
      .always();

    KubernetesClient client = server.getClient();
    Pod p = client.resource(noReady).waitUntilReady(5, TimeUnit.SECONDS);
    Assert.assertTrue(Readiness.isPodReady(p));
  }

  @Test
  public void testCreateAndWaitUntilReady() throws InterruptedException {
    Pod pod1 = new PodBuilder().withNewMetadata()
      .withName("pod1")
      .withResourceVersion("1")
      .withNamespace("test").and().build();


    Pod noReady = new PodBuilder(pod1).withNewStatus()
      .addNewCondition()
      .withType("Ready")
      .withStatus("False")
      .endCondition()
      .endStatus()
      .build();

    Pod ready = new PodBuilder(pod1).withNewStatus()
      .addNewCondition()
      .withType("Ready")
      .withStatus("True")
      .endCondition()
      .endStatus()
      .build();

    server.expect().get().withPath("/api/v1/namespaces/test/pods").andReturn(200, noReady).once();
    server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(201, noReady).once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&watch=true").andUpgradeToWebSocket()
      .open()
      .waitFor(1000).andEmit(new WatchEvent(ready, "MODIFIED"))
      .done()
      .always();

    KubernetesClient client = server.getClient();
    Pod p = client.resource(noReady).createOrReplaceAnd().waitUntilReady(5, TimeUnit.SECONDS);
    Assert.assertTrue(Readiness.isPodReady(p));
  }
}

