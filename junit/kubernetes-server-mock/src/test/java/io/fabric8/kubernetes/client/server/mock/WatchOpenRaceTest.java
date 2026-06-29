/*
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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.MockWebServer;
import io.fabric8.mockwebserver.http.MockResponse;
import io.fabric8.mockwebserver.http.Response;
import io.fabric8.mockwebserver.http.WebSocket;
import io.fabric8.mockwebserver.http.WebSocketListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Reproduces the race between {@link KubernetesCrudDispatcher#handleWatch} (which adds the
 * listener to {@code watchEventListeners} synchronously, before {@code WatchResponse.withWebSocketUpgrade}
 * returns) and {@link WatchEventsListener#onOpen} (which is what actually sets
 * {@code webSocketRef}). A CRUD operation that lands in that window calls
 * {@code sendWebSocketResponse}, which schedules a send on the listener's executor while
 * {@code webSocketRef} is still {@code null}; when the executor runs the task it NPEs on
 * {@code webSocketRef.get().send(...)} and the event is silently dropped.
 *
 * <p>
 * The test widens the race window deterministically by wrapping the real
 * {@link WatchEventsListener} with a delegating {@link WebSocketListener} that latches
 * {@code onOpen}. The real listener is what's registered in {@code watchEventListeners}, so
 * CRUD events are dispatched to it as in production; only the timing of its {@code onOpen}
 * is under test control.
 */
class WatchOpenRaceTest {

  private RaceDispatcher dispatcher;
  private KubernetesMockServer server;
  private KubernetesClient client;

  @BeforeEach
  void setUp() {
    dispatcher = new RaceDispatcher();
    server = new KubernetesMockServer(new Context(), new MockWebServer(), new HashMap<>(), dispatcher, false);
    server.start();
    client = server.createClient();
  }

  @AfterEach
  void tearDown() {
    // Make sure no helper thread is left waiting on the latch if an assertion failed earlier.
    dispatcher.onOpenCanComplete.countDown();
    dispatcher.deferredOnOpen.shutdownNow();
    if (client != null) {
      client.close();
    }
    if (server != null) {
      server.shutdown();
    }
    // Surface any unexpected throwable from the deferred delegate.onOpen so it isn't
    // misdiagnosed as "MODIFIED never arrived" in the surefire output.
    assertThat(dispatcher.deferredFailure.get())
        .as("deferred delegate.onOpen completed without an unexpected throwable")
        .isNull();
  }

  @Test
  void modifiedEventDuringOpenRaceReachesWatcher() throws Exception {
    final Queue<String> received = new ConcurrentLinkedQueue<>();
    final CountDownLatch addReceived = new CountDownLatch(1);
    final CountDownLatch modifiedReceived = new CountDownLatch(1);

    client.pods().inNamespace("ns1")
        .resource(new PodBuilder().withNewMetadata().withName("pod1").endMetadata().build())
        .create();

    final Watch watch = client.pods().inNamespace("ns1").watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        received.add(action.name() + ":" + resource.getMetadata().getName());
        if (action == Action.ADDED) {
          addReceived.countDown();
        } else if (action == Action.MODIFIED) {
          modifiedReceived.countDown();
        }
      }

      @Override
      public void onClose(WatcherException cause) {
        // no-op
      }
    });

    try {
      // Wait until Vert.x has fired our wrapper's onOpen. At this point the real
      // WatchEventsListener is already in watchEventListeners but its webSocketRef is null.
      assertThat(dispatcher.onOpenEntered.await(10, TimeUnit.SECONDS))
          .as("server-side onOpen was invoked")
          .isTrue();

      // Trigger a CRUD event inside the race window. The dispatcher schedules a send on
      // the listener's executor while webSocketRef is still null; the executor task will
      // NPE on the null deref and silently drop the event.
      client.pods().inNamespace("ns1").withName("pod1")
          .edit(p -> new PodBuilder(p).editMetadata().addToLabels("touched", "true").endMetadata().build());

      // Let the executor have a chance to drain its (NPEing) task before we release onOpen.
      // Without this delay the fix-side ordering ("event runs after onOpen") would also
      // pass the assertion below, masking the bug.
      Thread.sleep(200);

      // Release onOpen: webSocketRef is finally populated and the initial-sync ADD is queued.
      dispatcher.onOpenCanComplete.countDown();

      // The initial-sync ADD should arrive; current behaviour delivers it.
      assertThat(addReceived.await(10, TimeUnit.SECONDS))
          .as("watcher received the initial-sync ADD for pod1")
          .isTrue();

      // The MODIFIED event triggered during the race window MUST also reach the watcher.
      // With the current code this assertion fails: the event was scheduled on the listener
      // executor while webSocketRef was null, the executor task NPE'd, and no MODIFIED frame
      // was ever sent on the wire.
      assertThat(modifiedReceived.await(5, TimeUnit.SECONDS))
          .as("watcher received the MODIFIED triggered during the open-race window; "
              + "got events=%s", received)
          .isTrue();

      // Ordering guarantee: the buffered MODIFIED must be replayed AFTER the initial-sync
      // ADDED, never before it (the secondary hazard noted in #7867).
      assertThat(received)
          .as("initial-sync ADDED is delivered before the buffered MODIFIED")
          .containsExactly("ADDED:pod1", "MODIFIED:pod1");
    } finally {
      watch.close();
    }
  }

  /**
   * CRUD dispatcher that wraps the real {@link WatchEventsListener} with a delegating
   * listener whose {@code onOpen} is latched. The real listener is what
   * {@code KubernetesCrudDispatcher} registered in {@code watchEventListeners}; only its
   * {@code onOpen} timing is under test control.
   */
  static final class RaceDispatcher extends KubernetesCrudDispatcher {
    final CountDownLatch onOpenEntered = new CountDownLatch(1);
    final CountDownLatch onOpenCanComplete = new CountDownLatch(1);
    // Used to invoke the real delegate.onOpen off the Vert.x event loop once the test
    // releases the latch. Blocking inside wrapper.onOpen would also block any subsequent
    // HTTP requests Vert.x assigns to the same event loop, which would deadlock the test.
    final ScheduledExecutorService deferredOnOpen = Executors.newSingleThreadScheduledExecutor();
    // Captures any throwable from the deferred delegate.onOpen call so the test can fail
    // visibly instead of swallowing it on the helper thread.
    final AtomicReference<Throwable> deferredFailure = new AtomicReference<>();

    @Override
    public MockResponse handleWatch(String path) {
      final MockResponse original = super.handleWatch(path);
      final WebSocketListener delegate = original.getWebSocketListener();
      final WebSocketListener latchedWrapper = new WebSocketListener() {
        @Override
        public void onBeforeAccept(WebSocket webSocket, Response response) {
          delegate.onBeforeAccept(webSocket, response);
        }

        @Override
        public void onOpen(WebSocket webSocket, Response response) {
          onOpenEntered.countDown();
          // Schedule delegate.onOpen on a separate thread so this Vert.x event loop is
          // free immediately. The latch lives in the helper task instead of here.
          deferredOnOpen.submit(() -> {
            try {
              if (!onOpenCanComplete.await(30, TimeUnit.SECONDS)) {
                deferredFailure.set(new IllegalStateException("Test never released onOpenCanComplete"));
                return;
              }
              delegate.onOpen(webSocket, response);
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            } catch (Throwable t) {
              deferredFailure.set(t);
            }
          });
        }

        @Override
        public void onMessage(WebSocket webSocket, String text) {
          delegate.onMessage(webSocket, text);
        }

        @Override
        public void onMessage(WebSocket webSocket, byte[] bytes) {
          delegate.onMessage(webSocket, bytes);
        }

        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
          delegate.onClosing(webSocket, code, reason);
        }

        @Override
        public void onClosed(WebSocket webSocket, int code, String reason) {
          delegate.onClosed(webSocket, code, reason);
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable error, Response response) {
          delegate.onFailure(webSocket, error, response);
        }
      };
      return new MockResponse().withWebSocketUpgrade(latchedWrapper);
    }
  }
}
