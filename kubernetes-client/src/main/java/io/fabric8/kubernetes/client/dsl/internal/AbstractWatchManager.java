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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import okhttp3.OkHttpClient;
import okhttp3.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractWatchManager<T> implements Watch {

  private static final Logger logger = LoggerFactory.getLogger(AbstractWatchManager.class);

  final Watcher<T> watcher;
  final ListOptions listOptions;
  final AtomicReference<String> resourceVersion;
  final OkHttpClient clonedClient;

  final AtomicBoolean forceClosed;
  private final int reconnectLimit;
  private final int reconnectInterval;
  private final int maxIntervalExponent;
  final AtomicInteger currentReconnectAttempt;
  private final ScheduledExecutorService executorService;


  AbstractWatchManager(
    Watcher<T> watcher, ListOptions listOptions, int reconnectLimit, int reconnectInterval, int maxIntervalExponent,
    OkHttpClient clonedClient
  ) {
    this.watcher = watcher;
    this.listOptions = listOptions;
    this.reconnectLimit = reconnectLimit;
    this.reconnectInterval = reconnectInterval;
    this.maxIntervalExponent = maxIntervalExponent;
    this.clonedClient = clonedClient;
    this.resourceVersion = new AtomicReference<>(listOptions.getResourceVersion());
    this.currentReconnectAttempt = new AtomicInteger(0);
    this.forceClosed = new AtomicBoolean();
    this.executorService = Executors.newSingleThreadScheduledExecutor(r -> {
      Thread ret = new Thread(r, "Executor for Watch " + System.identityHashCode(AbstractWatchManager.this));
      ret.setDaemon(true);
      return ret;
    });
  }

  final void closeEvent(WatcherException cause) {
    if (forceClosed.getAndSet(true)) {
      logger.debug("Ignoring duplicate firing of onClose event");
      return;
    }
    watcher.onClose(cause);
  }

  final void closeEvent() {
    if (forceClosed.getAndSet(true)) {
      logger.debug("Ignoring duplicate firing of onClose event");
      return;
    }
    watcher.onClose();
  }

  final void closeExecutorService() {
    if (executorService != null && !executorService.isShutdown()) {
      logger.debug("Closing ExecutorService");
      try {
        executorService.shutdown();
        if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
          logger.warn("Executor didn't terminate in time after shutdown in close(), killing it.");
          executorService.shutdownNow();
        }
      } catch (Exception t) {
        throw KubernetesClientException.launderThrowable(t);
      }
    }
  }

  void submit(Runnable task) {
    if (!executorService.isShutdown()) {
      executorService.submit(task);
    }
  }

  void schedule(Runnable command, long delay, TimeUnit timeUnit) {
    if (!executorService.isShutdown()) {
      executorService.schedule(command, delay, timeUnit);
    }
  }

  final boolean cannotReconnect() {
    return currentReconnectAttempt.get() >= reconnectLimit && reconnectLimit >= 0;
  }

  final long nextReconnectInterval() {
    int exponentOfTwo = currentReconnectAttempt.getAndIncrement();
    if (exponentOfTwo > maxIntervalExponent)
      exponentOfTwo = maxIntervalExponent;
    long ret = (long)reconnectInterval * (1 << exponentOfTwo);
    logger.debug("Current reconnect backoff is {} milliseconds (T{})", ret, exponentOfTwo);
    return ret;
  }

  static void closeWebSocket(WebSocket webSocket) {
    if (webSocket != null) {
      logger.debug("Closing websocket {}", webSocket);
      try {
        if (!webSocket.close(1000, null)) {
          logger.warn("Failed to close websocket");
        }
      } catch (IllegalStateException e) {
        logger.error("Called close on already closed websocket: {} {}", e.getClass(), e.getMessage());
      }
    }
  }
}
