/*
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
import org.eclipse.jetty.client.Request;
import org.eclipse.jetty.client.Response;
import org.eclipse.jetty.client.Result;
import org.eclipse.jetty.io.Content;

import java.nio.ByteBuffer;
import java.util.Optional;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;

public abstract class JettyAsyncResponseListener implements Response.Listener, AsyncBody {

  private final HttpRequest httpRequest;
  private final CompletableFuture<JettyHttpResponse<AsyncBody>> asyncResponse;
  private final CompletableFuture<Void> asyncBodyDone;
  private Response response;
  private Content.Source contentSource;
  // consume() calls not served with a chunk yet, consumers may call it ahead of delivery (HttpClientReadableByteChannel)
  private long requested;
  // a thread is reading from the content source or waiting on its demand, Content.Source allows a single pending demand
  private boolean reading;
  // done() completes once both the last chunk was read and Jetty reported success, in either order:
  // responses Jetty forwards (a 407 it couldn't authenticate, a redirect it couldn't follow) report success
  // and completion before their body is read
  private boolean lastChunkRead;
  private boolean succeeded;

  JettyAsyncResponseListener(HttpRequest httpRequest) {
    this.httpRequest = httpRequest;
    asyncResponse = new CompletableFuture<>();
    asyncBodyDone = new CompletableFuture<>();
  }

  @Override
  public void consume() {
    synchronized (this) {
      requested++;
      if (contentSource == null || reading) {
        return;
      }
      reading = true;
    }
    read();
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
    if (result.isSucceeded()) {
      synchronized (this) {
        succeeded = true;
        if (!lastChunkRead) {
          return;
        }
      }
      asyncBodyDone.complete(null);
    } else {
      asyncBodyDone.completeExceptionally(
          Optional.ofNullable(result.getFailure()).orElse(new RuntimeException("Request failed, but no failure was given")));
    }
  }

  @Override
  public void onFailure(Response response, Throwable failure) {
    asyncResponse.completeExceptionally(failure);
  }

  public CompletableFuture<HttpResponse<AsyncBody>> listen(Request request) {
    request.send(this);
    return asyncResponse.thenApply(HttpResponse.class::cast);
  }

  @Override
  public void onContentSource(Response response, Content.Source contentSource) {
    synchronized (this) {
      this.response = response;
      this.contentSource = contentSource;
      // nothing is read before the first consume()
      if (requested == 0) {
        return;
      }
      reading = true;
    }
    read();
  }

  /**
   * Serves the pending consume() calls with one chunk each.
   * <p>
   * Only the thread that set {@code reading}, or the demand callback it registered, runs this loop.
   * After the last or a failed chunk {@code reading} stays set, so nothing reads past the end.
   * <p>
   * Failures complete done() here as well: for a forwarded response the exchange is already complete, so the abort
   * doesn't notify onComplete.
   */
  private void read() {
    while (true) {
      synchronized (this) {
        if (requested == 0) {
          reading = false;
          return;
        }
      }
      final Content.Chunk chunk = contentSource.read();
      if (chunk == null) {
        contentSource.demand(this::read);
        return;
      }
      if (Content.Chunk.isFailure(chunk)) {
        response.abort(chunk.getFailure());
        if (!chunk.isLast()) {
          contentSource.fail(chunk.getFailure());
        }
        asyncBodyDone.completeExceptionally(chunk.getFailure());
        return;
      }
      final boolean last = chunk.isLast();
      try {
        if (chunk.hasRemaining()) {
          synchronized (this) {
            requested--;
          }
          if (!asyncBodyDone.isCancelled()) {
            onContent(chunk.getByteBuffer());
          }
        }
      } catch (Exception e) {
        response.abort(e);
        contentSource.fail(e);
        asyncBodyDone.completeExceptionally(e);
        return;
      } finally {
        chunk.release();
      }
      if (last) {
        synchronized (this) {
          lastChunkRead = true;
          if (!succeeded) {
            return;
          }
        }
        asyncBodyDone.complete(null);
        return;
      }
    }
  }

  /**
   * Implement to consume the content of the chunked response.
   * <p>
   * Each chunk will be passed <b>in order</b> to this function, one per {@link #consume()} call.
   * The buffer is released once this method returns, so it must be copied if kept.
   *
   * @param content the ByteBuffer containing a chunk of the response.
   * @throws Exception in case the downstream consumer throws an exception.
   */
  protected abstract void onContent(ByteBuffer content) throws Exception;

}
