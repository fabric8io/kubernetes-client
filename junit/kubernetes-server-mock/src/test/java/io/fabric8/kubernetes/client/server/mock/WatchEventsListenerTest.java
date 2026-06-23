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

import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.crud.AttributeSet;
import io.fabric8.mockwebserver.http.RecordedRequest;
import io.fabric8.mockwebserver.http.WebSocket;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class WatchEventsListenerTest {

  // Regression for #7857: when the client closes the watch while events are still
  // queued on the listener's executor, the server must deliver those events before
  // it processes the close. Previously onClosing called WebSocket.close synchronously
  // on the Vert.x event loop, racing past any sends still sitting in the executor.
  @Test
  void onClosingDrainsPendingSendsBeforeClose() throws Exception {
    final Context context = new Context(Serialization.jsonMapper());
    final Set<WatchEventsListener> registry = new CopyOnWriteArraySet<>();
    final WatchEventsListener listener = new WatchEventsListener(
        context, new AttributeSet(), registry,
        LoggerFactory.getLogger(WatchEventsListenerTest.class), l -> {
        });

    final List<String> operations = Collections.synchronizedList(new ArrayList<>());
    final CountDownLatch firstSendStarted = new CountDownLatch(1);
    final CountDownLatch releaseFirstSend = new CountDownLatch(1);
    final CountDownLatch closeInvoked = new CountDownLatch(1);

    final WebSocket ws = new WebSocket() {
      @Override
      public RecordedRequest request() {
        return null;
      }

      @Override
      public boolean send(String text) {
        // Mark which send by looking for the embedded resource name.
        if (text.contains("\"first\"")) {
          operations.add("send:first");
          firstSendStarted.countDown();
          try {
            releaseFirstSend.await(10, TimeUnit.SECONDS);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        } else if (text.contains("\"second\"")) {
          operations.add("send:second");
        } else {
          operations.add("send:other");
        }
        return true;
      }

      @Override
      public boolean send(byte[] bytes) {
        return true;
      }

      @Override
      public boolean close(int code, String reason) {
        // onClosed also invokes close after the executor drains; only record the
        // first invocation so the test can assert on relative ordering.
        if (closeInvoked.getCount() > 0) {
          operations.add("close");
          closeInvoked.countDown();
        }
        return true;
      }
    };

    listener.onOpen(ws, null);

    try {
      // First event — executor picks it up immediately and blocks inside send().
      listener.sendWebSocketResponse("{\"metadata\":{\"name\":\"first\"}}", Watcher.Action.ADDED);
      assertThat(firstSendStarted.await(10, TimeUnit.SECONDS))
          .as("executor must have started the first send")
          .isTrue();

      // Second event — queued behind the blocked first send.
      listener.sendWebSocketResponse("{\"metadata\":{\"name\":\"second\"}}", Watcher.Action.ADDED);

      // Client closes the watch. Before the fix this called ws.close() synchronously,
      // recording "close" while "send:second" was still queued.
      listener.onClosing(ws, 1000, "client close");

      releaseFirstSend.countDown();

      // Wait for the close task to run on the executor. In production Vert.x only
      // fires onClosed after its endHandler observes the close handshake, which
      // can only happen after our scheduled close task has actually called
      // ws.close(); the test reproduces that ordering with this latch.
      assertThat(closeInvoked.await(10, TimeUnit.SECONDS))
          .as("close must eventually be invoked on the executor")
          .isTrue();

      assertThat(operations).containsExactly("send:first", "send:second", "close");
    } finally {
      // Unblock anything still parked in send() and shut the executor down so the
      // non-daemon thread doesn't outlive a failing assertion.
      releaseFirstSend.countDown();
      listener.onClosed(ws, 1000, "test cleanup");
    }
  }

  // Regression for #7867: a CRUD event scheduled before Vert.x fires onOpen (while
  // webSocketRef is still null) must not be dropped. Pre-fix it scheduled a send that
  // NPE'd on the null webSocketRef and the exception was silently swallowed by the
  // executor. The event is now buffered and replayed once the WebSocket is available, and
  // the replay lands AFTER the initial-sync events so the watcher still observes the
  // initial ADDED before the buffered MODIFIED.
  @Test
  void eventBufferedBeforeOnOpenIsReplayedAfterInitialSync() throws Exception {
    final Context context = new Context(Serialization.jsonMapper());
    final Set<WatchEventsListener> registry = new CopyOnWriteArraySet<>();
    // onOpenAction mirrors the dispatcher's initial sync: a single ADDED for "initial-sync".
    final WatchEventsListener listener = new WatchEventsListener(
        context, new AttributeSet(), registry,
        LoggerFactory.getLogger(WatchEventsListenerTest.class),
        l -> l.sendWebSocketResponse("{\"metadata\":{\"name\":\"initial-sync\"}}", Watcher.Action.ADDED));

    final List<String> sends = Collections.synchronizedList(new ArrayList<>());
    final CountDownLatch bothSent = new CountDownLatch(2);
    final WebSocket ws = new WebSocket() {
      @Override
      public RecordedRequest request() {
        return null;
      }

      @Override
      public boolean send(String text) {
        if (text.contains("\"initial-sync\"")) {
          sends.add("initial-sync");
        } else if (text.contains("\"race-window\"")) {
          sends.add("race-window");
        } else {
          sends.add("other");
        }
        bothSent.countDown();
        return true;
      }

      @Override
      public boolean send(byte[] bytes) {
        return true;
      }

      @Override
      public boolean close(int code, String reason) {
        return true;
      }
    };

    try {
      // CRUD event lands in the open-race window, before onOpen has populated webSocketRef.
      listener.sendWebSocketResponse("{\"metadata\":{\"name\":\"race-window\"}}", Watcher.Action.MODIFIED);

      // Vert.x opens the socket: webSocketRef is set, the initial sync runs, then the
      // buffered event is replayed.
      listener.onOpen(ws, null);

      assertThat(bothSent.await(10, TimeUnit.SECONDS))
          .as("both the initial-sync ADDED and the buffered MODIFIED reach the socket")
          .isTrue();
      // The buffered MODIFIED is not lost, and arrives AFTER the initial-sync ADDED.
      assertThat(sends).containsExactly("initial-sync", "race-window");
    } finally {
      listener.onClosed(ws, 1000, "test cleanup");
    }
  }
}
