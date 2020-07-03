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

import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventBuilder;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableRuleMigrationSupport
class EventTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  @DisplayName("Should be able to watch events in specified namespace")
  void watch() throws InterruptedException {
    // Given
    Event testEvent = new EventBuilder()
      .withNewMetadata()
      .withName("nginx-deployment-54f57cf6bf-84ssh.161e26b7b76b629e")
      .withNamespace("ns1")
      .endMetadata()
      .build();

    server.expect()
      .withPath("/api/v1/namespaces/ns1/events?watch=true")
      .andUpgradeToWebSocket().open().waitFor(50)
      .andEmit(new WatchEvent(testEvent, "ADDED"))
      .done().once();
    KubernetesClient client = server.getClient();
    final CountDownLatch eventReceivedLatch = new CountDownLatch(1);

    // When
    Watch watch = client.v1().events().inNamespace("ns1").watch(new Watcher<Event>() {
      @Override
      public void eventReceived(Action action, Event resource) {
        eventReceivedLatch.countDown();
      }

      @Override
      public void onClose(KubernetesClientException cause) {

      }
    });

    // Then
    assertTrue(eventReceivedLatch.await(1, TimeUnit.SECONDS));
    watch.close();
  }
}
