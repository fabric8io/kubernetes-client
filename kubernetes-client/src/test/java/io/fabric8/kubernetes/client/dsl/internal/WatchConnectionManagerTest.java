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
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

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
  void testCloseRequest() throws MalformedURLException, InterruptedException {
    CompletableFuture<WebSocket> future = new CompletableFuture<>();
    CountDownLatch reconnect = new CountDownLatch(1);

    WatchConnectionManager<?, ?> manager = setupWebSocketWatch(future, reconnect);

    WebSocket mock = Mockito.mock(WebSocket.class);
    future.complete(mock);

    WatchRequestState state = manager.latestRequestState;
    manager.closeRequest();

    Mockito.verify(mock).sendClose(1000, null);

    // we should still be on the same watch that has not ended (onClose / onError not called)
    assertSame(state, manager.latestRequestState);
    assertFalse(manager.latestRequestState.ended.isDone());
  }

  @Test
  void testExceptionalCloseRequest() throws MalformedURLException, InterruptedException {
    CompletableFuture<WebSocket> future = new CompletableFuture<>();
    CountDownLatch reconnect = new CountDownLatch(1);

    WatchConnectionManager<?, ?> manager = setupWebSocketWatch(future, reconnect);

    WebSocket mock = Mockito.mock(WebSocket.class);
    future.complete(mock);

    WatchRequestState state = manager.latestRequestState;

    // exceptional the watch, should trigger an immediate reconnect
    manager.watchEnded(new IOException(), state);
    assertTrue(state.ended.isDone());
    assertTrue(reconnect.await(1, TimeUnit.SECONDS));
  }

  @Test
  void testFailSafeReconnect() throws MalformedURLException, InterruptedException {
    CompletableFuture<WebSocket> future = new CompletableFuture<>();
    CountDownLatch reconnect = new CountDownLatch(1);

    WatchConnectionManager<?, ?> manager = setupWebSocketWatch(future, reconnect);

    WebSocket mock = Mockito.mock(WebSocket.class);
    future.complete(mock);

    WatchRequestState state = manager.latestRequestState;
    manager.setWatchEndCheckMs(0);

    // Intercept Utils.schedule so the fail-safe reconnect runs on the test thread
    // instead of going through SHARED_SCHEDULER, which made this assertion timing-sensitive.
    AtomicReference<Runnable> scheduledTask = new AtomicReference<>();
    AtomicReference<Long> scheduledDelay = new AtomicReference<>();
    try (MockedStatic<Utils> utils = Mockito.mockStatic(Utils.class, Mockito.CALLS_REAL_METHODS)) {
      utils.when(() -> Utils.schedule(Mockito.any(), Mockito.any(Runnable.class), Mockito.anyLong(), Mockito.any()))
          .thenAnswer(inv -> {
            scheduledTask.set(inv.getArgument(1));
            scheduledDelay.set(inv.getArgument(2));
            return new CompletableFuture<Void>();
          });

      manager.closeRequest();

      assertNotNull(scheduledTask.get(), "expected closeRequest to schedule the fail-safe reconnect");
      assertEquals(0L, scheduledDelay.get(), "fail-safe reconnect should be scheduled with watchEndCheckMs");
      scheduledTask.get().run();
      assertNotSame(state, manager.latestRequestState,
          "fail-safe reconnect should have replaced latestRequestState with a new watch");
    }
  }

  private WatchConnectionManager<?, ?> setupWebSocketWatch(CompletableFuture<WebSocket> future, CountDownLatch reconnect)
      throws MalformedURLException {
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
    };
  }

}
