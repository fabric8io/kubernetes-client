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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.utils.ExponentialBackoffIntervalCalculator;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.Watcher.Action;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

import static java.net.HttpURLConnection.HTTP_GONE;

public abstract class AbstractWatchManager<T extends HasMetadata> implements Watch {

  @FunctionalInterface
  interface RequestBuilder {
    Request build(final String resourceVersion);
  }
  
  private static final Logger logger = LoggerFactory.getLogger(AbstractWatchManager.class);

  final Watcher<T> watcher;
  final AtomicReference<String> resourceVersion;

  final AtomicBoolean forceClosed;
  private final int reconnectLimit;
  private final ExponentialBackoffIntervalCalculator retryIntervalCalculator;
  final AtomicInteger currentReconnectAttempt;
  private ScheduledFuture<?> reconnectAttempt;
  
  private final RequestBuilder requestBuilder;
  protected final OkHttpClient client;

  private final AtomicBoolean reconnectPending = new AtomicBoolean(false);

  AbstractWatchManager(
    Watcher<T> watcher, ListOptions listOptions, int reconnectLimit, int reconnectInterval, int maxIntervalExponent, RequestBuilder requestBuilder, Supplier<OkHttpClient> clientSupplier
  ) {
    this.watcher = watcher;
    this.reconnectLimit = reconnectLimit;
    this.retryIntervalCalculator = new ExponentialBackoffIntervalCalculator(reconnectInterval, maxIntervalExponent);
    this.resourceVersion = new AtomicReference<>(listOptions.getResourceVersion());
    this.currentReconnectAttempt = new AtomicInteger(0);
    this.forceClosed = new AtomicBoolean();
    this.requestBuilder = requestBuilder;
    this.client = clientSupplier.get();
    
    runWatch();
  }
  
  protected abstract void run(Request request);
  
  protected abstract void closeRequest();
  
  final void close(WatcherException cause) {
    // proactively close the request (it will be called again in close)
    // for reconnecting watchers, we may not complete onClose for a while
    closeRequest();  
    if (!watcher.reconnecting() && forceClosed.getAndSet(true)) {
      logger.debug("Ignoring duplicate firing of onClose event");
    } else {
      watcher.onClose(cause);
    }
    close();
  }

  final void closeEvent() {
    if (forceClosed.getAndSet(true)) {
      logger.debug("Ignoring duplicate firing of onClose event");
      return;
    }
    watcher.onClose();
  }

  final synchronized void cancelReconnect() {
    if (reconnectAttempt != null) {
      reconnectAttempt.cancel(true);
    }
  }
  
  void scheduleReconnect() {
    if (!reconnectPending.compareAndSet(false, true)) {
      logger.debug("Reconnect already scheduled");
      return;
    }
    
    if (isForceClosed()) {
      logger.debug("Ignoring error for already closed/closing connection");
      return;
    }
    
    if (cannotReconnect()) {
      close(new WatcherException("Exhausted reconnects"));
      return;
    }
    
    logger.debug("Scheduling reconnect task");
    
    long delay = nextReconnectInterval();
    
    synchronized (this) {
      reconnectAttempt = Utils.schedule(Utils.getCommonExecutorSerive(), () -> {
        try {
          runWatch();
          if (isForceClosed()) {
            closeRequest();
          }
        } catch (Exception e) {
          // An unexpected error occurred and we didn't even get an onFailure callback.
          logger.error("Exception in reconnect", e);
          close(new WatcherException("Unhandled exception in reconnect attempt", e));
        } finally {
          reconnectPending.set(false);
        }
      }, delay, TimeUnit.MILLISECONDS);
      if (isForceClosed()) {
        cancelReconnect();
      }
    }
  }

  final boolean cannotReconnect() {
    return !watcher.reconnecting() && currentReconnectAttempt.get() >= reconnectLimit && reconnectLimit >= 0;
  }

  final long nextReconnectInterval() {
    int exponentOfTwo = currentReconnectAttempt.getAndIncrement();
    long ret = retryIntervalCalculator.getInterval(exponentOfTwo);
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
  
  void updateResourceVersion(final String newResourceVersion) {
    resourceVersion.set(newResourceVersion);
  }
  
  protected void runWatch() {
    final Request request = requestBuilder.build(resourceVersion.get());
    logger.debug("Watching {}...", request.url());
  
    closeRequest(); // only one can be active at a time
    run(request);
  }
  
  @Override
  public void close() {
    logger.debug("Force closing the watch {}", this);
    closeEvent();
    closeRequest();
    cancelReconnect();
  }
  
  protected WatchEvent readWatchEvent(String messageSource) {
    WatchEvent event = Serialization.unmarshal(messageSource, WatchEvent.class);
    KubernetesResource object = null;
    if (event != null) {
      object = event.getObject();
    }
    // when watching API Groups we don't get a WatchEvent resource
    // so the object will be null
    // so lets try parse the message as a KubernetesResource
    // as it will probably be a list of resources like a BuildList
    if (object == null) {
      object = Serialization.unmarshal(messageSource, KubernetesResource.class);
      if (event == null) {
        event = new WatchEvent(object, "MODIFIED");
      } else {
        event.setObject(object);
      }
    }
    if (event.getType() == null) {
      event.setType("MODIFIED");
    }
    return event;
  }
  
  protected void onMessage(String message) {
    try {
      WatchEvent event = readWatchEvent(message);
      Object object = event.getObject();
      if (object instanceof HasMetadata) {
        @SuppressWarnings("unchecked")
        T obj = (T) object;
        updateResourceVersion(obj.getMetadata().getResourceVersion());
        Action action = Action.valueOf(event.getType());
        eventReceived(action, obj);
      } else if (object instanceof KubernetesResourceList) {
        // Dirty cast - should always be valid though
        KubernetesResourceList list = (KubernetesResourceList) object;
        updateResourceVersion(list.getMetadata().getResourceVersion());
        Action action = Action.valueOf(event.getType());
        List<HasMetadata> items = list.getItems();
        if (items != null) {
          for (HasMetadata item : items) {
            eventReceived(action, (T) item);
          }
        }
      } else if (object instanceof Status) {
        Status status = (Status) object;
      
        onStatus(status);
      } else {
        logger.error("Unknown message received: {}", message);
      }
    } catch (ClassCastException e) {
      logger.error("Received wrong type of object for watch", e);
    } catch (IllegalArgumentException e) {
      logger.error("Invalid event type", e);
    } catch (Exception e) {
      logger.error("Unhandled exception encountered in watcher event handler", e);
    }
  }
  
  protected boolean onStatus(Status status) {
    // The resource version no longer exists - this has to be handled by the caller.
    if (status.getCode() == HTTP_GONE) {
      close(new WatcherException(status.getMessage(), new KubernetesClientException(status)));
      return true;
    }

    eventReceived(Action.ERROR, null);
    logger.error("Error received: {}", status);
    return false;
  }

}
