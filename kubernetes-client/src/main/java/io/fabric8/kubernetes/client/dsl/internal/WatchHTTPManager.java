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

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.BufferedSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static java.net.HttpURLConnection.HTTP_GONE;

public class WatchHTTPManager<T extends HasMetadata, L extends KubernetesResourceList<T>> implements
  Watch {
  private static final Logger logger = LoggerFactory.getLogger(WatchHTTPManager.class);
  private static final ObjectMapper mapper = new ObjectMapper();

  private final BaseOperation<T, L, ?, ?> baseOperation;
  private final Watcher<T> watcher;
  private final AtomicBoolean forceClosed = new AtomicBoolean();
  private final AtomicReference<String> resourceVersion;
  private final int reconnectLimit;
  private final int reconnectInterval;

  private final AtomicBoolean reconnectPending = new AtomicBoolean(false);
  private int maxIntervalExponent;
  private final URL requestUrl;
  private final AtomicInteger currentReconnectAttempt = new AtomicInteger(0);
  private OkHttpClient clonedClient;

  private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(r -> {
    Thread ret = new Thread(r, "Executor for Watch " + System.identityHashCode(WatchHTTPManager.this));
    ret.setDaemon(true);
    return ret;
  });

  public WatchHTTPManager(final OkHttpClient client,
                          final BaseOperation<T, L, ?, ?> baseOperation,
                          final String version, final Watcher<T> watcher, final int reconnectInterval,
                          final int reconnectLimit, long connectTimeout)
    throws MalformedURLException {
    // Default max 32x slowdown from base interval
    this(client, baseOperation, version, watcher, reconnectInterval, reconnectLimit, connectTimeout, 5);
  }

  public WatchHTTPManager(final OkHttpClient client,
                          final BaseOperation<T, L, ?, ?> baseOperation,
                          final String version, final Watcher<T> watcher, final int reconnectInterval,
                          final int reconnectLimit, long connectTimeout, int maxIntervalExponent)
    throws MalformedURLException {

    this.resourceVersion = new AtomicReference<>(version); // may be a reference to null
    this.baseOperation = baseOperation;
    this.watcher = watcher;
    this.reconnectInterval = reconnectInterval;
    this.reconnectLimit = reconnectLimit;
    this.maxIntervalExponent = maxIntervalExponent;

    OkHttpClient clonedClient = client.newBuilder()
      .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
      .readTimeout(0, TimeUnit.MILLISECONDS)
      .cache(null)
      .build();

    // If we set the HttpLoggingInterceptor's logging level to Body (as it is by default), it does
    // not let us stream responses from the server.
    for (Interceptor i : clonedClient.networkInterceptors()) {
      if (i instanceof HttpLoggingInterceptor) {
        HttpLoggingInterceptor interceptor = (HttpLoggingInterceptor) i;
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
      }
    }

    this.clonedClient = clonedClient;
    requestUrl = baseOperation.getNamespacedUrl();
    runWatch();
  }

  private final void runWatch() {
    logger.debug("Watching via HTTP GET ... {}", this);

    HttpUrl.Builder httpUrlBuilder = HttpUrl.get(requestUrl).newBuilder();
    String labelQueryParam = baseOperation.getLabelQueryParam();
    if (Utils.isNotNullOrEmpty(labelQueryParam)) {
      httpUrlBuilder.addQueryParameter("labelSelector", labelQueryParam);
    }

    String fieldQueryString = baseOperation.getFieldQueryParam();
    String name = baseOperation.getName();

    // for API groups we can use the name in the path rather than a fieldSelector
    // which is more likely to work well for API Groups
    if (name != null && name.length() > 0) {
      if (baseOperation.isApiGroup()) {
        httpUrlBuilder.addPathSegment(name);
      } else {
        if (fieldQueryString.length() > 0) {
          fieldQueryString += ",";
        }
        fieldQueryString += "metadata.name=" + name;
      }
    }

    if (Utils.isNotNullOrEmpty(fieldQueryString)) {
      httpUrlBuilder.addQueryParameter("fieldSelector", fieldQueryString);
    }

    if (this.resourceVersion.get() != null) {
      httpUrlBuilder.addQueryParameter("resourceVersion", this.resourceVersion.get());
    }

    httpUrlBuilder.addQueryParameter("watch", "true");

    String origin = requestUrl.getProtocol() + "://" + requestUrl.getHost();
    if (requestUrl.getPort() != -1) {
        origin += ":" + requestUrl.getPort();
    }

    final Request request = new Request.Builder()
      .get()
      .url(httpUrlBuilder.build())
      .addHeader("Origin", origin)
      .build();

    clonedClient.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        logger.info("Watch connection failed. reason: {}", e.getMessage());
        scheduleReconnect();
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        if (!response.isSuccessful()) {
          throw OperationSupport.requestFailure(request,
            OperationSupport.createStatus(response.code(), response.message()));
        }

        try {
          BufferedSource source = response.body().source();
          while (!source.exhausted()) {
            String message = source.readUtf8LineStrict();
            onMessage(message);
          }
        } catch (Exception e) {
          logger.info("Watch terminated unexpectedly. reason: {}", e.getMessage());
        }

        // if we get here, the source is exhausted, so, we have lost our "watch".
        // we must reconnect.
        if (response != null) {
          response.body().close();
        }
        scheduleReconnect();
      }
    });
  }

  private void scheduleReconnect() {
    if (forceClosed.get()) {
      logger.warn("Ignoring error for already closed/closing connection");
      return;
    }

    if (currentReconnectAttempt.get() >= reconnectLimit && reconnectLimit >= 0) {
      watcher.onClose(new KubernetesClientException("Connection unexpectedly closed"));
      return;
    }

    logger.debug("Submitting reconnect task to the executor");
    // Don't submit new tasks after having called shutdown() on executor
    if(!executor.isShutdown()) {
      // make sure that whichever thread calls this method, the tasks are
      // performed serially in the executor.
      executor.submit(() -> {
        if (!reconnectPending.compareAndSet(false, true)) {
          logger.debug("Reconnect already scheduled");
          return;
        }
        try {
          // actual reconnect only after the back-off time has passed, without
          // blocking the thread
          logger.debug("Scheduling reconnect task");
          executor.schedule(() -> {
            try {
              WatchHTTPManager.this.runWatch();
              reconnectPending.set(false);
            } catch (Exception e) {
              // An unexpected error occurred and we didn't even get an onFailure callback.
              logger.error("Exception in reconnect", e);
              close();
              watcher.onClose(new KubernetesClientException("Unhandled exception in reconnect attempt", e));
            }
          }, nextReconnectInterval(), TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
          // This is a standard exception if we close the scheduler. We should not print it
          if (!forceClosed.get()) {
            logger.error("Exception in reconnect", e);
          }
          reconnectPending.set(false);
        }
      });
    }
  }

  public void onMessage(String messageSource) throws IOException {
    try {
      WatchEvent event = readWatchEvent(messageSource);
      Object object = event.getObject();
      if (object instanceof HasMetadata) {
        @SuppressWarnings("unchecked")
        T obj = (T) object;
        // Dirty cast - should always be valid though
        resourceVersion.set(((HasMetadata) obj).getMetadata().getResourceVersion());
        Watcher.Action action = Watcher.Action.valueOf(event.getType());
        watcher.eventReceived(action, obj);
      } else if (object instanceof KubernetesResourceList) {
        @SuppressWarnings("unchecked")

        KubernetesResourceList list = (KubernetesResourceList) object;
        // Dirty cast - should always be valid though
        resourceVersion.set(list.getMetadata().getResourceVersion());
        Watcher.Action action = Watcher.Action.valueOf(event.getType());
        List<HasMetadata> items = list.getItems();
        if (items != null) {
          String name = baseOperation.getName();
          for (HasMetadata item : items) {
            watcher.eventReceived(action, (T) item);
          }
        }
      } else if (object instanceof Status) {
        Status status = (Status) object;
        // The resource version no longer exists - this has to be handled by the caller.
        if (status.getCode() == HTTP_GONE) {
          // exception
          // shut down executor, etc.
          close();
          watcher.onClose(new KubernetesClientException(status));
          return;
        }

        logger.error("Error received: {}", status.toString());
      } else {
        logger.error("Unknown message received: {}", messageSource);
      }
    } catch (IOException e) {
      logger.error("Could not deserialize watch event: {}", messageSource, e);
    } catch (ClassCastException e) {
      logger.error("Received wrong type of object for watch", e);
    } catch (IllegalArgumentException e) {
      logger.error("Invalid event type", e);
    }
  }

  protected static WatchEvent readWatchEvent(String messageSource) throws IOException {
    WatchEvent event = mapper.readValue(messageSource, WatchEvent.class);
    Object object = null;
    if (event != null) {
      object = event.getObject();;
    }
    // when watching API Groups we don't get a WatchEvent resource
    // so the object will be null
    // so lets try parse the message as a KubernetesResource
    // as it will probably be a list of resources like a BuildList
    if (object == null) {
      object = mapper.readValue(messageSource, KubernetesResource.class);
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

  private long nextReconnectInterval() {
    int exponentOfTwo = currentReconnectAttempt.getAndIncrement();
    if (exponentOfTwo > maxIntervalExponent)
      exponentOfTwo = maxIntervalExponent;
    long ret = reconnectInterval * (1 << exponentOfTwo);
    logger.debug("Current reconnect backoff is " + ret + " milliseconds (T" + exponentOfTwo + ")");
    return ret;
  }

  @Override
  public void close() {
    logger.debug("Force closing the watch {}", this);
    forceClosed.set(true);
    if (!executor.isShutdown()) {
      try {
        executor.shutdown();
        if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
          logger.warn("Executor didn't terminate in time after shutdown in close(), killing it in: {}", this);
          executor.shutdownNow();
        }
      } catch (Throwable t) {
        throw KubernetesClientException.launderThrowable(t);
      }
    }
  }
}
