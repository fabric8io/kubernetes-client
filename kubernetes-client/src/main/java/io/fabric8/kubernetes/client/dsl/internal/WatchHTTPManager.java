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

import static java.net.HttpURLConnection.HTTP_GONE;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.Watcher.Action;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.BufferedSource;

public class WatchHTTPManager<T extends HasMetadata, L extends KubernetesResourceList<T>> extends AbstractWatchManager<T> {
  private static final Logger logger = LoggerFactory.getLogger(WatchHTTPManager.class);

  private final BaseOperation<T, L, ?> baseOperation;

  private final AtomicBoolean reconnectPending = new AtomicBoolean(false);
  private final URL requestUrl;

  public WatchHTTPManager(final OkHttpClient client,
                          final BaseOperation<T, L, ?> baseOperation,
                          final ListOptions listOptions, final Watcher<T> watcher, final int reconnectInterval,
                          final int reconnectLimit, long connectTimeout)
    throws MalformedURLException {
    // Default max 32x slowdown from base interval
    this(client, baseOperation, listOptions, watcher, reconnectInterval, reconnectLimit, connectTimeout, 5);
  }

  public WatchHTTPManager(final OkHttpClient client,
                          final BaseOperation<T, L, ?> baseOperation,
                          final ListOptions listOptions, final Watcher<T> watcher, final int reconnectInterval,
                          final int reconnectLimit, long connectTimeout, int maxIntervalExponent)
    throws MalformedURLException {

    super(
      watcher, listOptions, reconnectLimit, reconnectInterval, maxIntervalExponent,
      client.newBuilder()
        .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
        .readTimeout(0, TimeUnit.MILLISECONDS)
        .cache(null)
        .build()
    );
    this.baseOperation = baseOperation;


    // If we set the HttpLoggingInterceptor's logging level to Body (as it is by default), it does
    // not let us stream responses from the server.
    for (Interceptor i : clonedClient.networkInterceptors()) {
      if (i instanceof HttpLoggingInterceptor) {
        HttpLoggingInterceptor interceptor = (HttpLoggingInterceptor) i;
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
      }
    }

    requestUrl = baseOperation.getNamespacedUrl();
    runWatch();
  }

  private void runWatch() {
    HttpUrl.Builder httpUrlBuilder = HttpUrl.get(requestUrl).newBuilder();
    String labelQueryParam = baseOperation.getLabelQueryParam();
    if (Utils.isNotNullOrEmpty(labelQueryParam)) {
      httpUrlBuilder.addQueryParameter("labelSelector", labelQueryParam);
    }

    String fieldQueryString = baseOperation.getFieldQueryParam();
    String name = baseOperation.getName();

    if (name != null && name.length() > 0) {
      if (fieldQueryString.length() > 0) {
        fieldQueryString += ",";
      }
      fieldQueryString += "metadata.name=" + name;
    }

    if (Utils.isNotNullOrEmpty(fieldQueryString)) {
      httpUrlBuilder.addQueryParameter("fieldSelector", fieldQueryString);
    }

    listOptions.setResourceVersion(resourceVersion.get());
    HttpClientUtils.appendListOptionParams(httpUrlBuilder, listOptions);
    String origin = requestUrl.getProtocol() + "://" + requestUrl.getHost();
    if (requestUrl.getPort() != -1) {
      origin += ":" + requestUrl.getPort();
    }

    HttpUrl url = httpUrlBuilder.build();

    logger.debug("Watching via HTTP GET {}", url);

    final Request request = new Request.Builder()
      .get()
      .url(url)
      .addHeader("Origin", origin)
      .build();

    clonedClient.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        logger.info("Watch connection failed. reason: {}", e.getMessage());
        scheduleReconnect(true);
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        if (!response.isSuccessful()) {
          onStatus(OperationSupport.createStatus(response.code(), response.message()));
        }

        boolean shouldBackoff = true;

        try {
          BufferedSource source = response.body().source();
          while (!source.exhausted()) {
            String message = source.readUtf8LineStrict();
            onMessage(message);
          }
          // the normal operation of a long poll get is to return once a response is available.
          // in that case we should reconnect immediately.
          shouldBackoff = false;
        } catch (Exception e) {
          logger.info("Watch terminated unexpectedly. reason: {}", e.getMessage());
        }

        // if we get here, the source is exhausted, so, we have lost our "watch".
        // we must reconnect.
        if (response != null) {
          response.body().close();
        }

        scheduleReconnect(shouldBackoff);
      }
    });
  }

  private void scheduleReconnect(boolean shouldBackoff) {
    if (forceClosed.get()) {
      logger.warn("Ignoring error for already closed/closing connection");
      return;
    }

    if (cannotReconnect()) {
      watcher.onClose(new WatcherException("Connection unexpectedly closed"));
      return;
    }

    logger.debug("Submitting reconnect task to the executor");

    // make sure that whichever thread calls this method, the tasks are
    // performed serially in the executor.
    submit(() -> {
      if (!reconnectPending.compareAndSet(false, true)) {
        logger.debug("Reconnect already scheduled");
        return;
      }
      try {
        // actual reconnect only after the back-off time has passed, without
        // blocking the thread
        logger.debug("Scheduling reconnect task");

        long delay = shouldBackoff
          ? nextReconnectInterval()
          : 0;

        schedule(() -> {
          try {
            WatchHTTPManager.this.runWatch();
            reconnectPending.set(false);
          } catch (Exception e) {
            // An unexpected error occurred and we didn't even get an onFailure callback.
            logger.error("Exception in reconnect", e);
            close();
            watcher.onClose(new WatcherException("Unhandled exception in reconnect attempt", e));
          }
        }, delay, TimeUnit.MILLISECONDS);
      } catch (RejectedExecutionException e) {
        // This is a standard exception if we close the scheduler. We should not print it
        if (!forceClosed.get()) {
          logger.error("Exception in reconnect", e);
        }
        reconnectPending.set(false);
      }
    });
  }

  public void onMessage(String messageSource) {
    try {
      WatchEvent event = readWatchEvent(messageSource);
      KubernetesResource object = event.getObject();
      if (object instanceof HasMetadata) {
        @SuppressWarnings("unchecked")
        T obj = (T) object;
        // Dirty cast - should always be valid though
        resourceVersion.set(obj.getMetadata().getResourceVersion());
        Watcher.Action action = Watcher.Action.valueOf(event.getType());
        watcher.eventReceived(action, obj);
      } else if (object instanceof KubernetesResourceList) {
        KubernetesResourceList list = (KubernetesResourceList) object;
        // Dirty cast - should always be valid though
        resourceVersion.set(list.getMetadata().getResourceVersion());
        Watcher.Action action = Watcher.Action.valueOf(event.getType());
        List<HasMetadata> items = list.getItems();
        if (items != null) {
          for (HasMetadata item : items) {
            watcher.eventReceived(action, (T) item);
          }
        }
      } else if (object instanceof Status) {
        onStatus((Status) object);
      } else {
        logger.error("Unknown message received: {}", messageSource);
      }
    } catch (ClassCastException e) {
      logger.error("Received wrong type of object for watch", e);
    } catch (IllegalArgumentException e) {
      logger.error("Invalid event type", e);
    }
  }

  private void onStatus(Status status) {
    // The resource version no longer exists - this has to be handled by the caller.
    if (status.getCode() == HTTP_GONE) {
      // exception
      // shut down executor, etc.
      close();
      watcher.onClose(new WatcherException(status.getMessage(), new KubernetesClientException(status)));
      return;
    }

    watcher.eventReceived(Action.ERROR, null);
    logger.error("Error received: {}", status.toString());
  }


  protected static WatchEvent readWatchEvent(String messageSource) {
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

  @Override
  public void close() {
    logger.debug("Force closing the watch {}", this);
    closeEvent();
    closeExecutorService();
  }
}
