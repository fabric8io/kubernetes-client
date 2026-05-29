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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.internal.AbstractWatchManager.WatchRequestState;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.TestWebSocket;
import io.fabric8.kubernetes.client.http.WebSocket;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WatchConnectionManagerTest {

  @Test
  void testNoReconnectOnException() throws MalformedURLException, InterruptedException {
    CompletableFuture<WebSocket> future = new CompletableFuture<>();
    CountDownLatch reconnect = new CountDownLatch(1);

    setupWebSocketWatch(future, reconnect);

    future.completeExceptionally(new IOException());
    assertFalse(reconnect.await(1, TimeUnit.SECONDS));
  }

  @Test
  void testReconnectOnException() throws MalformedURLException, InterruptedException {
    CompletableFuture<WebSocket> future = new CompletableFuture<>();
    CountDownLatch reconnect = new CountDownLatch(1);

    WatchConnectionManager<?, ?> manager = setupWebSocketWatch(future, reconnect);
    manager.ready = true;

    future.completeExceptionally(new IOException());
    assertTrue(reconnect.await(1, TimeUnit.SECONDS));
  }

  @Test
  void testCloseRequest() throws Exception {
    CompletableFuture<WebSocket> future = new CompletableFuture<>();
    CountDownLatch reconnect = new CountDownLatch(1);

    WatchConnectionManager<?, ?> manager = setupWebSocketWatch(future, reconnect);

    TestWebSocket testWs = new TestWebSocket();
    future.complete(testWs);

    WatchRequestState state = manager.latestRequestState;
    manager.closeRequest();

    assertThat(testWs.firstClose().get(5, TimeUnit.SECONDS))
        .isEqualTo(new TestWebSocket.CloseFrame(1000, null));

    // we should still be on the same watch that has not ended (onClose / onError not called)
    assertSame(state, manager.latestRequestState);
    assertFalse(manager.latestRequestState.ended.isDone());
  }

  @Test
  void testExceptionalCloseRequest() throws MalformedURLException, InterruptedException {
    CompletableFuture<WebSocket> future = new CompletableFuture<>();
    CountDownLatch reconnect = new CountDownLatch(1);

    WatchConnectionManager<?, ?> manager = setupWebSocketWatch(future, reconnect);

    future.complete(new TestWebSocket());

    WatchRequestState state = manager.latestRequestState;

    // exceptional the watch, should trigger an immediate reconnect
    manager.watchEnded(new IOException(), state);
    assertTrue(state.ended.isDone());
    assertTrue(reconnect.await(1, TimeUnit.SECONDS));
  }

  @Test
  void testFailSafeReconnect() throws MalformedURLException {
    CompletableFuture<WebSocket> future = new CompletableFuture<>();
    AtomicReference<Runnable> scheduledTask = new AtomicReference<>();
    AtomicReference<Long> scheduledDelayMs = new AtomicReference<>();

    WatchConnectionManager<?, ?> manager = setupWebSocketWatch(future, (command, delay, unit) -> {
      scheduledTask.set(command);
      scheduledDelayMs.set(unit.toMillis(delay));
      return new CompletableFuture<>();
    });

    future.complete(new TestWebSocket());

    WatchRequestState state = manager.latestRequestState;
    manager.setWatchEndCheckMs(0);
    manager.closeRequest();

    assertNotNull(scheduledTask.get(), "expected closeRequest to schedule the fail-safe reconnect");
    assertEquals(0L, scheduledDelayMs.get(), "fail-safe reconnect should be scheduled with watchEndCheckMs");
    scheduledTask.get().run();
    assertNotSame(state, manager.latestRequestState,
        "fail-safe reconnect should have replaced latestRequestState with a new watch");
  }

  @FunctionalInterface
  private interface TestScheduler {
    CompletableFuture<Void> schedule(Runnable command, long delay, TimeUnit unit);
  }

  private WatchConnectionManager<?, ?> setupWebSocketWatch(CompletableFuture<WebSocket> future, CountDownLatch reconnect)
      throws MalformedURLException {
    return setupWebSocketWatch(future, reconnect, null);
  }

  private WatchConnectionManager<?, ?> setupWebSocketWatch(CompletableFuture<WebSocket> future, TestScheduler testScheduler)
      throws MalformedURLException {
    return setupWebSocketWatch(future, new CountDownLatch(1), testScheduler);
  }

  private WatchConnectionManager<?, ?> setupWebSocketWatch(CompletableFuture<WebSocket> future, CountDownLatch reconnect,
      TestScheduler testScheduler) throws MalformedURLException {
    HttpClient client = Mockito.mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    BaseOperation baseOperation = AbstractWatchManagerTest.mockOperation();
    Mockito.when(baseOperation.getNamespacedUrl()).thenReturn(new URL("http://localhost"));
    WebSocket.Builder mockBuilder = Mockito.mock(WebSocket.Builder.class, Mockito.RETURNS_SELF);
    Mockito.when(client.newWebSocketBuilder()).thenReturn(mockBuilder);
    Mockito.when(mockBuilder.buildAsync(Mockito.any())).thenReturn(future);

    return new WatchConnectionManager(client,
        baseOperation, Mockito.mock(ListOptions.class), Mockito.mock(Watcher.class), 0, 0, 0) {
      @Override
      void scheduleReconnect(WatchRequestState state) {
        reconnect.countDown();
      }

      @Override
      protected CompletableFuture<Void> schedule(Runnable command, long delay, TimeUnit unit) {
        if (testScheduler != null) {
          return testScheduler.schedule(command, delay, unit);
        }
        return super.schedule(command, delay, unit);
      }
    };
  }

}
