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
package io.fabric8.kubernetes.client.http;

import lombok.Getter;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TestStandardHttpClient
    extends StandardHttpClient<TestStandardHttpClient, TestStandardHttpClientFactory, TestStandardHttpClientBuilder> {

  @Getter
  private final List<CompletableFuture<WebSocketResponse>> wsFutures;
  private int wsIndex;
  @Getter
  private final List<CompletableFuture<HttpResponse<AsyncBody>>> respFutures;
  private int respIndex;

  protected TestStandardHttpClient(TestStandardHttpClientBuilder builder) {
    super(builder);
    wsFutures = new ArrayList<>();
    respFutures = new ArrayList<>();
  }

  @Override
  public void close() {
    wsFutures.clear();
    respFutures.clear();
  }

  @Override
  public synchronized CompletableFuture<WebSocketResponse> buildWebSocketDirect(
      StandardWebSocketBuilder standardWebSocketBuilder,
      WebSocket.Listener listener) {
    if (wsFutures.size() <= wsIndex) {
      wsFutures.add(new CompletableFuture<>());
    }
    return wsFutures.get(wsIndex++);
  }

  @Override
  public synchronized CompletableFuture<HttpResponse<AsyncBody>> consumeBytesDirect(StandardHttpRequest request,
      AsyncBody.Consumer<List<ByteBuffer>> consumer) {
    if (respFutures.size() <= respIndex) {
      respFutures.add(new CompletableFuture<>());
    }
    return respFutures.get(respIndex++);
  }

  @Override
  public TestStandardHttpClientBuilder newBuilder() {
    return (TestStandardHttpClientBuilder) super.newBuilder();
  }
}
