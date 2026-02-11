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
package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.AsyncBody;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpClientResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("VertxAsyncBody")
class VertxAsyncBodyTest {

  @Mock
  private HttpClientResponse response;

  @Mock
  private HttpClientRequest request;

  @Mock
  private AsyncBody.Consumer<List<ByteBuffer>> consumer;

  @Captor
  private ArgumentCaptor<Handler<Buffer>> dataHandlerCaptor;

  @Captor
  private ArgumentCaptor<Handler<Void>> endHandlerCaptor;

  @Captor
  private ArgumentCaptor<Handler<Throwable>> exceptionHandlerCaptor;

  @Captor
  private ArgumentCaptor<List<ByteBuffer>> listBufferCaptor;

  private VertxAsyncBody asyncBody;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    when(response.handler(dataHandlerCaptor.capture())).thenReturn(response);
    when(response.endHandler(endHandlerCaptor.capture())).thenReturn(response);
    when(response.exceptionHandler(exceptionHandlerCaptor.capture())).thenReturn(response);
    when(response.request()).thenReturn(request);
  }

  @Test
  @DisplayName("Should setup data, end, and exception handlers during construction")
  void constructor_shouldSetupHandlersCorrectly() {
    asyncBody = new VertxAsyncBody(response, consumer);

    verify(response).handler(Mockito.any());
    verify(response).endHandler(Mockito.any());
    verify(response).exceptionHandler(Mockito.any());

    assertThat(dataHandlerCaptor.getValue()).isNotNull();
    assertThat(endHandlerCaptor.getValue()).isNotNull();
    assertThat(exceptionHandlerCaptor.getValue()).isNotNull();
  }

  @Test
  @DisplayName("Should call fetch(1) on response when consume is called")
  void consume_shouldCallFetchOnResponse() {
    asyncBody = new VertxAsyncBody(response, consumer);

    asyncBody.consume();

    verify(response).fetch(1);
  }

  @Test
  @DisplayName("Should convert Vert.x buffer to ByteBuffer and call consumer when data arrives")
  void dataHandler_shouldConsumeBufferAsByteBuffer() throws Exception {
    asyncBody = new VertxAsyncBody(response, consumer);
    Buffer buffer = Buffer.buffer("test data");

    dataHandlerCaptor.getValue().handle(buffer);

    verify(consumer).consume(listBufferCaptor.capture(), Mockito.eq(asyncBody));

    List<ByteBuffer> capturedBuffers = listBufferCaptor.getValue();
    assertThat(capturedBuffers).hasSize(1);

    ByteBuffer capturedBuffer = capturedBuffers.get(0);
    byte[] capturedBytes = new byte[capturedBuffer.remaining()];
    capturedBuffer.get(capturedBytes);
    assertThat(new String(capturedBytes)).isEqualTo("test data");
  }

  @Test
  @DisplayName("Should reset request and complete exceptionally when consumer throws exception")
  void dataHandler_shouldCompleteExceptionallyOnConsumerException() {
    RuntimeException consumerException = new RuntimeException("Consumer failed");
    asyncBody = new VertxAsyncBody(response, (data, body) -> {
      throw consumerException;
    });

    dataHandlerCaptor.getValue().handle(Buffer.buffer("test"));

    verify(request).reset();

    CompletableFuture<Void> done = asyncBody.done();
    assertThat(done).isCompletedExceptionally();

    assertThatThrownBy(() -> done.get(1, TimeUnit.SECONDS))
        .isInstanceOf(ExecutionException.class)
        .hasCause(consumerException);
  }

  @Test
  @DisplayName("Should complete done future when end handler is triggered")
  void endHandler_shouldCompleteDoneFuture() throws Exception {
    asyncBody = new VertxAsyncBody(response, consumer);

    endHandlerCaptor.getValue().handle(null);

    CompletableFuture<Void> done = asyncBody.done();
    assertThat(done.get(1, TimeUnit.SECONDS)).isNull();
    assertThat(done).isCompleted();
  }

  @Test
  @DisplayName("Should complete exceptionally when response exception occurs")
  void exceptionHandler_shouldCompleteExceptionallyOnResponseException() {
    asyncBody = new VertxAsyncBody(response, consumer);
    RuntimeException responseException = new RuntimeException("Response failed");

    exceptionHandlerCaptor.getValue().handle(responseException);

    CompletableFuture<Void> done = asyncBody.done();
    assertThat(done).isCompletedExceptionally();

    assertThatThrownBy(() -> done.get(1, TimeUnit.SECONDS))
        .isInstanceOf(ExecutionException.class)
        .hasCause(responseException);
  }

  @Test
  @DisplayName("Should return same CompletableFuture instance on multiple done() calls")
  void done_shouldReturnSameCompletableFuture() {
    asyncBody = new VertxAsyncBody(response, consumer);

    CompletableFuture<Void> done1 = asyncBody.done();
    CompletableFuture<Void> done2 = asyncBody.done();

    assertThat(done1).isSameAs(done2);
  }

  @Test
  @DisplayName("Should clear handlers, reset request, and cancel future when cancelled")
  void cancel_shouldClearHandlersAndResetRequest() {
    asyncBody = new VertxAsyncBody(response, consumer);

    asyncBody.cancel();

    verify(response).handler(isNull());
    verify(response).endHandler(isNull());
    verify(request).reset();

    CompletableFuture<Void> done = asyncBody.done();
    assertThat(done).isCancelled();
  }

  @Test
  @DisplayName("Should cancel done future when cancel is called")
  void cancel_shouldCancelDoneFuture() {
    asyncBody = new VertxAsyncBody(response, consumer);
    CompletableFuture<Void> done = asyncBody.done();

    asyncBody.cancel();

    assertThat(done.isCancelled()).isTrue();
  }

  @Test
  @DisplayName("Should call consumer for each data chunk and complete on end")
  void multipleDataChunks_shouldCallConsumerForEach() throws Exception {
    asyncBody = new VertxAsyncBody(response, consumer);

    dataHandlerCaptor.getValue().handle(Buffer.buffer("chunk1"));
    dataHandlerCaptor.getValue().handle(Buffer.buffer("chunk2"));
    endHandlerCaptor.getValue().handle(null);

    // Then – the consumer must be invoked once per chunk (2 times total)
    verify(consumer, Mockito.times(2))
        .consume(listBufferCaptor.capture(), Mockito.eq(asyncBody));

    // We captured two separate lists (one per chunk)
    List<List<ByteBuffer>> allBuffers = listBufferCaptor.getAllValues();
    assertThat(allBuffers).hasSize(2);
    assertThat(allBuffers.get(0).get(0).remaining()).isGreaterThan(0);
    assertThat(allBuffers.get(1).get(0).remaining()).isGreaterThan(0);

    CompletableFuture<Void> done = asyncBody.done();
    assertThat(done.get(1, TimeUnit.SECONDS)).isNull();
  }

  @Test
  @DisplayName("Should request one buffer at a time for backpressure control")
  void backpressureHandling_shouldOnlyConsumeOneBufferAtATime() {
    asyncBody = new VertxAsyncBody(response, consumer);

    asyncBody.consume();
    asyncBody.consume();
    asyncBody.consume();

    verify(response, times(3)).fetch(1);
  }
}
