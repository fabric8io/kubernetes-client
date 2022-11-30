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
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class WatchHTTPManager<T extends HasMetadata, L extends KubernetesResourceList<T>> extends AbstractWatchManager<T> {
  private static final Logger logger = LoggerFactory.getLogger(WatchHTTPManager.class);
  private CompletableFuture<HttpResponse<AsyncBody>> call;
  private volatile AsyncBody body;

  public WatchHTTPManager(final HttpClient client,
      final BaseOperation<T, L, ?> baseOperation,
      final ListOptions listOptions, final Watcher<T> watcher, final int reconnectInterval,
      final int reconnectLimit)
      throws MalformedURLException {
    // Default max 32x slowdown from base interval
    this(client, baseOperation, listOptions, watcher, reconnectInterval, reconnectLimit, 5);
  }

  public WatchHTTPManager(final HttpClient client,
      final BaseOperation<T, L, ?> baseOperation,
      final ListOptions listOptions, final Watcher<T> watcher, final int reconnectInterval,
      final int reconnectLimit, int maxIntervalExponent)
      throws MalformedURLException {

    super(
        watcher, baseOperation, listOptions, reconnectLimit, reconnectInterval, maxIntervalExponent,
        () -> client.newBuilder()
            .readTimeout(0, TimeUnit.MILLISECONDS)
            .forStreaming()
            .build());

  }

  @Override
  protected synchronized void start(URL url, Map<String, String> headers) {
    HttpRequest.Builder builder = client.newHttpRequestBuilder().url(url);
    headers.forEach(builder::header);
    StringBuffer buffer = new StringBuffer();
    call = client.consumeBytes(builder.build(), (b, a) -> {
      for (ByteBuffer content : b) {
        for (char c : StandardCharsets.UTF_8.decode(content).array()) {
          if (c == '\n') {
            onMessage(buffer.toString());
            buffer.setLength(0);
          } else {
            buffer.append(c);
          }
        }
      }
      a.consume();
    });
    call.whenComplete((response, t) -> {
      if (!call.isCancelled() && t != null) {
        logger.info("Watch connection failed. reason: {}", t.getMessage());
        scheduleReconnect();
      }
      if (response != null) {
        body = response.body();
        if (!response.isSuccessful()) {
          body.cancel();
          if (onStatus(OperationSupport.createStatus(response.code(), response.message()))) {
            return; // terminal state
          }
          if (!call.isCancelled()) {
            scheduleReconnect();
          }
        } else {
          resetReconnectAttempts();
          body.consume();
          body.done().whenComplete((v, e) -> {
            if (e != null) {
              logger.info("Watch terminated unexpectedly. reason: {}", e.getMessage());
            }
            if (!call.isCancelled()) {
              scheduleReconnect();
            }
          });
        }
      }
    });
  }

  @Override
  protected synchronized void closeRequest() {
    Optional.ofNullable(call).ifPresent(theFuture -> {
      theFuture.cancel(true);
    });
    Optional.ofNullable(body).ifPresent(AsyncBody::cancel);
  }
}
