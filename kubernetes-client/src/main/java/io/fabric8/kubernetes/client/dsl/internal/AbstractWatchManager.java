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
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
  final AtomicReference<String> resourceVersion;

  final AtomicBoolean forceClosed;
  private final int reconnectLimit;
  private final int reconnectInterval;
  private final int maxIntervalExponent;
  final AtomicInteger currentReconnectAttempt;
  private final ScheduledExecutorService executorService;
  
  private final RequestBuilder requestBuilder;
  protected ClientRunner runner;


  AbstractWatchManager(
    Watcher<T> watcher, ListOptions listOptions, int reconnectLimit, int reconnectInterval, int maxIntervalExponent, RequestBuilder requestBuilder
  ) {
    this.watcher = watcher;
    this.reconnectLimit = reconnectLimit;
    this.reconnectInterval = reconnectInterval;
    this.maxIntervalExponent = maxIntervalExponent;
    this.resourceVersion = new AtomicReference<>(listOptions.getResourceVersion());
    this.currentReconnectAttempt = new AtomicInteger(0);
    this.forceClosed = new AtomicBoolean();
    this.executorService = Executors.newSingleThreadScheduledExecutor(Utils.daemonThreadFactory(AbstractWatchManager.this));
    
    this.requestBuilder = requestBuilder;
  }
  
  protected void initRunner(ClientRunner runner) {
    if (this.runner != null) {
      throw new IllegalStateException("ClientRunner has already been initialized");
    }
    this.runner = runner;
  }

  final void closeEvent(WatcherException cause) {
    if (!watcher.reconnecting() && forceClosed.getAndSet(true)) {
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
    return !watcher.reconnecting() && currentReconnectAttempt.get() >= reconnectLimit && reconnectLimit >= 0;
  }

  final long nextReconnectInterval() {
    int exponentOfTwo = currentReconnectAttempt.getAndIncrement();
    if (exponentOfTwo > maxIntervalExponent)
      exponentOfTwo = maxIntervalExponent;
    long ret = (long)reconnectInterval * (1 << exponentOfTwo);
    logger.debug("Current reconnect backoff is {} milliseconds (T{})", ret, exponentOfTwo);
    return ret;
  }
  
  void resetReconnectAttempts() {
    currentReconnectAttempt.set(0);
  }
  
  boolean isForceClosed() {
    return forceClosed.get();
  }
  
  void eventReceived(Watcher.Action action, T resource) {
    watcher.eventReceived(action, resource);
  }
  
  void onClose(WatcherException cause) {
    watcher.onClose(cause);
  }
  
  void updateResourceVersion(final String newResourceVersion) {
    resourceVersion.set(newResourceVersion);
  }
  
  protected void runWatch() {
    final Request request = requestBuilder.build(resourceVersion.get());
    logger.debug("Watching {}...", request.url());
  
    runner.run(request);
  }
  
  public void waitUntilReady() {
    runner.waitUntilReady();
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
  
  @Override
  public void close() {
    logger.debug("Force closing the watch {}", this);
    closeEvent();
    runner.close();
    closeExecutorService();
  }
  
  @FunctionalInterface
  interface RequestBuilder {
    Request build(final String resourceVersion);
  }
  
  abstract static class ClientRunner {
    private final OkHttpClient client;
  
    protected ClientRunner(OkHttpClient client) {
      this.client = cloneAndCustomize(client);
    }
  
    abstract void run(Request request);
    void close() {}
    void waitUntilReady() {}
    abstract OkHttpClient cloneAndCustomize(OkHttpClient client);
    OkHttpClient client() {
      return client;
    }
  }
}
