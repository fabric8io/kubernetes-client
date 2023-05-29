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
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class WatchHTTPManager<T extends HasMetadata, L extends KubernetesResourceList<T>> extends AbstractWatchManager<T> {
  private CompletableFuture<HttpResponse<AsyncBody>> call;
  private volatile AsyncBody body;

  public WatchHTTPManager(final HttpClient client,
      final BaseOperation<T, L, ?> baseOperation,
      final ListOptions listOptions, final Watcher<T> watcher, final int reconnectInterval,
      final int reconnectLimit)
      throws MalformedURLException {
    super(watcher, baseOperation, listOptions, reconnectLimit, reconnectInterval, client);
  }

  @Override
  protected synchronized void start(URL url, Map<String, String> headers, WatchRequestState state) {
    HttpRequest.Builder builder = client.newHttpRequestBuilder().url(url).forStreaming();
    headers.forEach(builder::header);
    StringBuffer buffer = new StringBuffer();
    call = client.consumeBytes(builder.build(), (b, a) -> {
      for (ByteBuffer content : b) {
        for (char c : StandardCharsets.UTF_8.decode(content).array()) {
          if (c == '\n') {
            onMessage(buffer.toString(), state);
            buffer.setLength(0);
          } else {
            buffer.append(c);
          }
        }
      }
      a.consume();
    });
    call.whenComplete((response, t) -> {
      if (t != null) {
        this.watchEnded(t, state);
      }
      if (response != null) {
        body = response.body();
        if (!response.isSuccessful()) {
          Status status = OperationSupport.createStatus(response.code(), response.message());
          if (onStatus(status, state)) {
            return; // terminal state
          }
          watchEnded(new KubernetesClientException(status), state);
        } else {
          resetReconnectAttempts(state);
          body.consume();
          body.done().whenComplete((v, e) -> watchEnded(e, state));
        }
      }
    });
  }

  @Override
  protected synchronized void closeCurrentRequest() {
    Optional.ofNullable(call).ifPresent(theFuture -> {
      theFuture.cancel(true);
    });
    Optional.ofNullable(body).ifPresent(AsyncBody::cancel);
  }
}
