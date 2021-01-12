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

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.Watcher.Action;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import okhttp3.OkHttpClient;
import okhttp3.WebSocket;

import static io.fabric8.kubernetes.client.dsl.internal.WatchHTTPManager.readWatchEvent;
import static java.net.HttpURLConnection.HTTP_GONE;

public class WatchConnectionManager<T extends HasMetadata, L extends KubernetesResourceList<T>> extends AbstractWatchManager<T> {
  
  public WatchConnectionManager(final OkHttpClient client, final BaseOperation<T, L, ?> baseOperation, final ListOptions listOptions, final Watcher<T> watcher, final int reconnectInterval, final int reconnectLimit, long websocketTimeout, int maxIntervalExponent) throws MalformedURLException {
    super(
      watcher, listOptions, reconnectLimit, reconnectInterval, maxIntervalExponent, new BaseOperationRequestBuilder<>(baseOperation, listOptions)
    );
    
    initRunner(new WebSocketClientRunner<T>(client) {
      @Override
      WatcherWebSocketListener<T> newListener(BlockingQueue<Object> queue, AtomicReference<WebSocket> webSocketRef) {
        return new TypedWatcherWebSocketListener<>(WatchConnectionManager.this, queue, webSocketRef, baseOperation);
      }
  
      @Override
      OkHttpClient cloneAndCustomize(OkHttpClient client) {
        return client.newBuilder()
          .readTimeout(websocketTimeout, TimeUnit.MILLISECONDS)
          .build();
      }
    });
    runWatch();
  }
  
  public WatchConnectionManager(final OkHttpClient client, final BaseOperation<T, L, ?> baseOperation, final ListOptions listOptions, final Watcher<T> watcher, final int reconnectInterval, final int reconnectLimit, long websocketTimeout) throws MalformedURLException {
    // Default max 32x slowdown from base interval
    this(client, baseOperation, listOptions, watcher, reconnectInterval, reconnectLimit, websocketTimeout, 5);
  }
  
  private static class TypedWatcherWebSocketListener<T extends HasMetadata, L extends KubernetesResourceList<T>> extends WatcherWebSocketListener<T> {
    private final BaseOperation<T, L, ?> operation;
    
    public TypedWatcherWebSocketListener(AbstractWatchManager<T> manager, BlockingQueue<Object> queue, AtomicReference<WebSocket> webSocketRef, final BaseOperation<T, L, ?> baseOperation) {
      super(manager, queue, webSocketRef);
      this.operation = baseOperation;
    }
    
    @Override
    public void onMessage(WebSocket webSocket, String message) {
      try {
        WatchEvent event = readWatchEvent(message);
        Object object = event.getObject();
        if (object instanceof HasMetadata) {
          @SuppressWarnings("unchecked")
          T obj = (T) object;
          manager.updateResourceVersion(obj.getMetadata().getResourceVersion());
          Action action = Action.valueOf(event.getType());
          manager.eventReceived(action, obj);
        } else if (object instanceof KubernetesResourceList) {
          // Dirty cast - should always be valid though
          KubernetesResourceList list = (KubernetesResourceList) object;
          manager.updateResourceVersion(list.getMetadata().getResourceVersion());
          Action action = Action.valueOf(event.getType());
          List<HasMetadata> items = list.getItems();
          if (items != null) {
            for (HasMetadata item : items) {
              manager.eventReceived(action, (T) item);
            }
          }
        } else if (object instanceof Status) {
          Status status = (Status) object;
        
          // The resource version no longer exists - this has to be handled by the caller.
          if (status.getCode() == HTTP_GONE) {
            webSocketRef.set(null); // lose the ref: closing in close() would only generate a Broken pipe exception
            // shut down executor, etc.
            manager.closeEvent(new WatcherException(status.getMessage(), exceptionFor(status)));
            manager.close();
            return;
          }
  
          manager.eventReceived(Action.ERROR, null);
          logger.error("Error received: {}", status);
        } else {
          logger.error("Unknown message received: {}", message);
        }
      } catch (ClassCastException e) {
        logger.error("Received wrong type of object for watch", e);
      } catch (IllegalArgumentException e) {
        logger.error("Invalid event type", e);
      } catch (Throwable e) {
        logger.error("Unhandled exception encountered in watcher event handler", e);
      }
    }
  
    @Override
    protected KubernetesClientException exceptionFor(Status status) {
      return new KubernetesClientException(operation.describe() + " failed: " + status.getMessage(), status.getCode(), status);
    }
  }
}
