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

import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.Request;
import org.eclipse.jetty.client.Result;
import org.eclipse.jetty.client.transport.HttpResponse;
import org.eclipse.jetty.io.content.AsyncContent;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.FuturePromise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

class JettyAsyncResponseListenerTest {

  private List<String> received;
  private AsyncContent source;
  private Request request;
  private HttpResponse response;
  private JettyAsyncResponseListener listener;

  @BeforeEach
  void setUp() {
    received = new CopyOnWriteArrayList<>();
    source = new AsyncContent();
    // never sent, it backs the response so that the listener can abort it
    request = new HttpClient().newRequest("http://localhost");
    response = new HttpResponse(request);
    listener = listener(content -> received.add(StandardCharsets.UTF_8.decode(content).toString()));
    listener.onContentSource(response, source);
  }

  @Test
  @DisplayName("content available before the first consume(), isn't delivered")
  void nothingReadBeforeFirstConsume() {
    // When
    write("first");
    // Then
    assertThat(received).isEmpty();
    // When
    listener.consume();
    // Then
    assertThat(received).containsExactly("first");
  }

  @Test
  @DisplayName("consume(), delivers a single chunk")
  void consumeDeliversOneChunk() {
    // Given
    write("first");
    write("second");
    // When
    listener.consume();
    // Then
    assertThat(received).containsExactly("first");
  }

  @Test
  @DisplayName("consume() called ahead of delivery, delivers one chunk per call as content arrives")
  void consumeAheadOfDelivery() {
    // Given
    listener.consume();
    listener.consume();
    // When
    write("first");
    write("second");
    write("third");
    // Then
    assertThat(received).containsExactly("first", "second");
  }

  @Test
  @DisplayName("empty chunks, don't use up a consume() call")
  void emptyChunkDoesNotUseUpConsume() {
    // Given
    source.write(false, ByteBuffer.allocate(0), Callback.NOOP);
    write("first");
    // When
    listener.consume();
    // Then
    assertThat(received).containsExactly("first");
  }

  @Test
  @DisplayName("delivered chunks, are released back to Jetty")
  void deliveredChunksAreReleased() {
    // Given
    final var released = new FuturePromise<Void>();
    source.write(false, ByteBuffer.wrap("first".getBytes(StandardCharsets.UTF_8)),
        Callback.from(() -> released.succeeded(null), released::failed));
    // When
    listener.consume();
    // Then
    assertThat(released.isDone()).isTrue();
  }

  @Test
  @DisplayName("consumer failure, releases the chunk and aborts the response")
  void consumerFailureReleasesChunkAndAbortsResponse() {
    // Given
    final var failure = new IllegalStateException("consumer failed");
    final var failingListener = listener(content -> {
      throw failure;
    });
    final var failingSource = new AsyncContent();
    failingListener.onContentSource(response, failingSource);
    final var released = new FuturePromise<Void>();
    failingSource.write(false, ByteBuffer.wrap("first".getBytes(StandardCharsets.UTF_8)),
        Callback.from(() -> released.succeeded(null), released::failed));
    // When
    failingListener.consume();
    // Then
    assertThat(released.isDone()).isTrue();
    assertThat(request.getAbortCause()).isSameAs(failure);
  }

  @Test
  @DisplayName("success notified before the body is read (Jetty forwards 407 responses this way), completes done() once the body is consumed")
  void successBeforeBodyIsReadCompletesDoneOnceConsumed() {
    // Given
    source.write(true, ByteBuffer.wrap("forwarded".getBytes(StandardCharsets.UTF_8)), Callback.NOOP);
    // When
    listener.onComplete(new Result(request, response));
    // Then
    assertThat(listener.done()).isNotDone();
    // When
    listener.consume();
    // Then
    assertThat(received).containsExactly("forwarded");
    assertThat(listener.done()).isCompleted();
  }

  private void write(String content) {
    source.write(false, ByteBuffer.wrap(content.getBytes(StandardCharsets.UTF_8)), Callback.NOOP);
  }

  private static JettyAsyncResponseListener listener(Consumer<ByteBuffer> consumer) {
    return new JettyAsyncResponseListener(new StandardHttpRequest.Builder().uri(URI.create("http://localhost")).build()) {
      @Override
      protected void onContent(ByteBuffer content) {
        consumer.accept(content);
      }
    };
  }
}
