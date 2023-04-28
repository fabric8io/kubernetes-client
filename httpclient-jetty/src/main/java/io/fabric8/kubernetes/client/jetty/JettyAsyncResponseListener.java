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
package io.fabric8.kubernetes.client.jetty;

import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.util.Callback;

import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.function.LongConsumer;

public abstract class JettyAsyncResponseListener extends Response.Listener.Adapter implements AsyncBody {

  private final HttpRequest httpRequest;
  private final CompletableFuture<JettyHttpResponse<AsyncBody>> asyncResponse;
  private final CompletableFuture<Void> asyncBodyDone;
  private LongConsumer demand;
  private boolean initialConsumeCalled;

  JettyAsyncResponseListener(HttpRequest httpRequest) {
    this.httpRequest = httpRequest;
    asyncResponse = new CompletableFuture<>();
    asyncBodyDone = new CompletableFuture<>();
  }

  @Override
  public synchronized void consume() {
    if (!this.initialConsumeCalled) {
      this.initialConsumeCalled = true;
    }
    if (demand != null) {
      demand.accept(1);
    }
  }

  @Override
  public CompletableFuture<Void> done() {
    return asyncBodyDone;
  }

  @Override
  public void cancel() {
    if (!asyncBodyDone.isDone()) {
      asyncBodyDone.cancel(false);
      asyncResponse.thenAccept(r -> r.getResponse().abort(new CancellationException()));
    }
  }

  @Override
  public void onHeaders(Response response) {
    asyncResponse.complete(new JettyHttpResponse<>(httpRequest, response, this));
  }

  @Override
  public void onComplete(Result result) {
    asyncBodyDone.complete(null);
  }

  public CompletableFuture<HttpResponse<AsyncBody>> listen(Request request) {
    request.send(this);
    return asyncResponse.thenApply(HttpResponse.class::cast);
  }

  @Override
  public void onBeforeContent(Response response, LongConsumer demand) {
    synchronized (this) {
      if (!this.initialConsumeCalled) {
        this.demand = demand;
        return;
      }
    }
    demand.accept(1);
  }

  @Override
  public void onContent(Response response, ByteBuffer content, Callback callback) {
    try {
      if (!asyncBodyDone.isCancelled()) {
        onContent(content);
        callback.succeeded();
      }
    } catch (Exception e) {
      callback.failed(e);
    }
  }

  /**
   * Implement to consume the content of the chunked response.
   * <p>
   * Each chunk will be passed <b>in order</b> to this function (<code>onContent{callback.succeeded}</code>)
   *
   * @param content the ByteBuffer containing a chunk of the response.
   * @throws Exception in case the downstream consumer throws an exception.
   */
  protected abstract void onContent(ByteBuffer content) throws Exception;

}
