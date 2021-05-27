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

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import io.fabric8.kubernetes.client.utils.Serialization;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.BufferedSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.net.HttpURLConnection.HTTP_GONE;

public class WatchHTTPManager<T extends HasMetadata, L extends KubernetesResourceList<T>> extends AbstractWatchManager<T> {
  private static final Logger logger = LoggerFactory.getLogger(WatchHTTPManager.class);
  
  
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
      watcher, listOptions, reconnectLimit, reconnectInterval, maxIntervalExponent, new BaseOperationRequestBuilder<>(baseOperation, listOptions)
    );
    
    initRunner(new HTTPClientRunner<T>(client, this) {
      @Override
      OkHttpClient cloneAndCustomize(OkHttpClient client) {
        final OkHttpClient clonedClient = client.newBuilder()
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
        return clonedClient;
      }
    });
    
    runWatch();
  }
  
  private abstract static class HTTPClientRunner<T extends HasMetadata> extends AbstractWatchManager.ClientRunner {
    private final AbstractWatchManager<T> manager;
    
    public HTTPClientRunner(OkHttpClient client, AbstractWatchManager<T> manager) {
      super(client);
      this.manager = manager;
    }
    
    @Override
    void run(Request request) {
      client().newCall(request).enqueue(new Callback() {
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
      if (manager.isForceClosed()) {
        logger.warn("Ignoring error for already closed/closing connection");
        return;
      }
      
      if (manager.cannotReconnect()) {
        manager.onClose(new WatcherException("Connection unexpectedly closed"));
        return;
      }
      
      manager.scheduleReconnect(() -> {
        try {
          manager.runWatch();
        } catch (Exception e) {
          // An unexpected error occurred and we didn't even get an onFailure callback.
          logger.error("Exception in reconnect", e);
          close();
          manager.onClose(new WatcherException("Unhandled exception in reconnect attempt", e));
        }
      }, shouldBackoff);
    }
    
    public void onMessage(String messageSource) {
      try {
        WatchEvent event = readWatchEvent(messageSource);
        KubernetesResource object = event.getObject();
        if (object instanceof HasMetadata) {
          // Dirty cast - should always be valid though
          @SuppressWarnings("unchecked")
          T obj = (T) object;
          manager.updateResourceVersion(obj.getMetadata().getResourceVersion());
          Watcher.Action action = Watcher.Action.valueOf(event.getType());
          manager.eventReceived(action, obj);
        } else if (object instanceof KubernetesResourceList) {
          KubernetesResourceList list = (KubernetesResourceList) object;
          // Dirty cast - should always be valid though
          manager.updateResourceVersion(list.getMetadata().getResourceVersion());
          Watcher.Action action = Watcher.Action.valueOf(event.getType());
          List<HasMetadata> items = list.getItems();
          if (items != null) {
            for (HasMetadata item : items) {
              manager.eventReceived(action, (T) item);
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
        manager.onClose(new WatcherException(status.getMessage(), new KubernetesClientException(status)));
        return;
      }
      
      manager.eventReceived(Action.ERROR, null);
      logger.error("Error received: {}", status.toString());
    }
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
}
