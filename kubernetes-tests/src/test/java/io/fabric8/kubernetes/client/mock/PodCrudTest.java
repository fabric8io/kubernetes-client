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
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import junit.framework.AssertionFailedError;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.util.Collections;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableRuleMigrationSupport
public class PodCrudTest {

  @Rule
  public KubernetesServer server = new KubernetesServer(true, true);

  @Test
  public void testCrud() {
    KubernetesClient client = server.getClient();

    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").addToLabels("testKey", "testValue").endMetadata().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").addToLabels("testKey", "testValue").endMetadata().build();
    Pod pod3 = new PodBuilder().withNewMetadata().withName("pod3").endMetadata().build();

    client.pods().inNamespace("ns1").create(pod1);
    client.pods().inNamespace("ns1").create(pod2);
    client.pods().inNamespace("ns2").create(pod3);

    PodList podList = client.pods().list();
    assertNotNull(podList);
    assertEquals(0, podList.getItems().size());

    // test listing with labels
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
  }

  @Test
  public void testPodWatch() {
    KubernetesClient client = server.getClient();
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").addToLabels("testKey", "testValue").endMetadata().build();

    final CountDownLatch deleteLatch = new CountDownLatch(1);
    final CountDownLatch closeLatch = new CountDownLatch(1);
    final CountDownLatch editLatch = new CountDownLatch(1);
    client.pods().inNamespace("ns1").create(pod1);
    client.pods().inNamespace("ns1").withName(pod1.getMetadata().getName()).watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        switch (action) {
          case DELETED:
            deleteLatch.countDown();
            break;
          case MODIFIED:
            editLatch.countDown();
          default:
            throw new AssertionFailedError();
        }
      }

      @Override
      public void onClose(KubernetesClientException cause) {
        closeLatch.countDown();
      }
    });

    Pod pod = client.pods().withName(pod1.getMetadata().getName()).get();

    assertNotNull(pod);
  }
}
/*
*     return new InlineWebSocketSessionBuilder<>(context, new Function<WebSocketSession, TimesOnceableOrHttpHeaderable<Void>>() {
      @Override
      public TimesOnceableOrHttpHeaderable<Void> apply(final WebSocketSession webSocketSession) {
        final Map<String, String> headers = new HashMap<>();
        headers.put("Upgrade", "websocket");
        headers.put("Connection", "Upgrade");

        return new TimesOnceableOrHttpHeaderable<Void>() {
          @Override
          public Void always() {
            enqueue(new SimpleRequest(method, path), new SimpleResponse(true, ResponseProviders.of(101, "", headers) , webSocketSession));
            return null;//Void
          }

          @Override
          public Void once() {
            enqueue(new SimpleRequest(method, path), new SimpleResponse(false, ResponseProviders.of(101, "", headers), webSocketSession));
            return null;//Void
          }

          @Override
          public Void times(int times) {
            for (int i = 0; i < times; i++) {
              once();
            }
            return null;//Void
          }

          @Override
          public TimesOnceableOrHttpHeaderable<Void> withHeader(String header) {
            headers.put(header, "");
            return this;//Void
          }

          @Override
          public TimesOnceableOrHttpHeaderable<Void> withHeader(String name, String value) {
            headers.put(name, value);
            return this;//Void
          }
        };
      }
    });

*
* */
