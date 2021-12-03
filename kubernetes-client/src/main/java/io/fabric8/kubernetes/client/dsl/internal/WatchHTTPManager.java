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
import java.util.concurrent.TimeUnit;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
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

public class WatchHTTPManager<T extends HasMetadata, L extends KubernetesResourceList<T>> extends AbstractWatchManager<T> {
  private static final Logger logger = LoggerFactory.getLogger(WatchHTTPManager.class);
  private Call call;
  
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
        watcher, baseOperation, listOptions, reconnectLimit, reconnectInterval, maxIntervalExponent, () -> {
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
        });
    
  }
  
  @Override
  protected synchronized void run(Request request) {
    call = client.newCall(request);
    call.enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        logger.info("Watch connection failed. reason: {}", e.getMessage());
        scheduleReconnect();
      }
      
      @Override
      public void onResponse(Call call, Response response) throws IOException {
        try {
          if (!response.isSuccessful()) {
            if (onStatus(OperationSupport.createStatus(response.code(), response.message()))) {
              return; // terminal state
            }
          } else {
            resetReconnectAttempts();
            BufferedSource source = response.body().source();
            while (!source.exhausted()) {
              String message = source.readUtf8LineStrict();
              onMessage(message);
            }
          }
        } catch (Exception e) {
          logger.info("Watch terminated unexpectedly. reason: {}", e.getMessage());
        } finally {
          WatchConnectionManager.closeBody(response);
        }
        
        // if we get here, the source is exhausted, so, we have lost our "watch".
        // we must reconnect.
        scheduleReconnect();
      }
    });
  }
  
  @Override
  protected synchronized void closeRequest() {
    if (call != null) {
      call.cancel();
      call = null;
    }
  }
}
