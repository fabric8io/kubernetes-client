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
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.BodyContent;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.ByteArrayBodyContent;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.InputStreamBodyContent;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.StringBodyContent;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.http.RequestOptions;
import io.vertx.core.streams.ReadStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("VertxHttpRequest")
class VertxHttpRequestTest {

  @Mock
  private Vertx vertx;

  @Mock
  private RequestOptions options;

  @Mock
  private StandardHttpRequest request;

  @Mock
  private HttpClient httpClient;

  @Mock
  private HttpClientRequest httpClientRequest;

  @Mock
  private HttpClientResponse httpClientResponse;

  @Mock
  private AsyncBody.Consumer<List<ByteBuffer>> consumer;

  @Mock
  private StringBodyContent stringBodyContent;

  @Mock
  private ByteArrayBodyContent byteArrayBodyContent;

  @Mock
  private InputStreamBodyContent inputStreamBodyContent;

  @Mock
  private BodyContent unsupportedBodyContent;

  @Mock
  private MultiMap multiMap;

  @Captor
  private ArgumentCaptor<Buffer> bufferCaptor;

  @Captor
  private ArgumentCaptor<ReadStream<Buffer>> readStreamCaptor;

  private VertxHttpRequest vertxHttpRequest;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    vertxHttpRequest = new VertxHttpRequest(vertx, options, request);

    when(httpClientResponse.handler(any())).thenReturn(httpClientResponse);
    when(httpClientResponse.endHandler(any())).thenReturn(httpClientResponse);
    when(httpClientResponse.exceptionHandler(any())).thenReturn(httpClientResponse);

    when(httpClientResponse.headers()).thenReturn(multiMap);
    when(multiMap.names()).thenReturn(java.util.Set.of());
  }

  @Test
  @DisplayName("Should execute request flow and return CompletableFuture")
  void consumeBytes_shouldExecuteRequestFlowSuccessfully() throws Exception {
    when(httpClient.request(options)).thenReturn(Future.succeededFuture(httpClientRequest));
    when(request.body()).thenReturn(null);
    when(httpClientRequest.send()).thenReturn(Future.succeededFuture(httpClientResponse));

    CompletableFuture<HttpResponse<AsyncBody>> result = vertxHttpRequest.consumeBytes(httpClient, consumer);

    HttpResponse<AsyncBody> response = result.get(1, TimeUnit.SECONDS);
    assertThat(response).isNotNull().isInstanceOf(VertxHttpResponse.class);

    verify(httpClientResponse).pause();
  }

  @Test
  @DisplayName("Should handle failed client request")
  void consumeBytes_shouldHandleFailedClientRequest() {
    RuntimeException clientException = new RuntimeException("Client request failed");
    when(httpClient.request(options)).thenReturn(Future.failedFuture(clientException));
    when(request.body()).thenReturn(null);

    CompletableFuture<HttpResponse<AsyncBody>> result = vertxHttpRequest.consumeBytes(httpClient, consumer);

    assertThat(result).isCompletedExceptionally();
    assertThatThrownBy(() -> result.get(1, TimeUnit.SECONDS))
        .isInstanceOf(ExecutionException.class)
        .hasCause(clientException);
  }

  @Test
  @DisplayName("Should send request without body when body is null")
  void sendBody_shouldSendWithoutBodyWhenBodyIsNull() throws Exception {
    when(httpClient.request(options)).thenReturn(Future.succeededFuture(httpClientRequest));
    when(request.body()).thenReturn(null);
    when(httpClientRequest.send()).thenReturn(Future.succeededFuture(httpClientResponse));

    CompletableFuture<HttpResponse<AsyncBody>> result = vertxHttpRequest.consumeBytes(httpClient, consumer);

    HttpResponse<AsyncBody> response = result.get(1, TimeUnit.SECONDS);
    assertThat(response).isNotNull();
    verify(httpClientRequest).send();
  }

  @Test
  @DisplayName("Should send string body content as Buffer")
  void sendBody_shouldSendStringBodyContentAsBuffer() throws Exception {
    String content = "test string content";
    when(httpClient.request(options)).thenReturn(Future.succeededFuture(httpClientRequest));
    when(request.body()).thenReturn(stringBodyContent);
    when(stringBodyContent.getContent()).thenReturn(content);
    when(httpClientRequest.send(any(Buffer.class))).thenReturn(Future.succeededFuture(httpClientResponse));

    CompletableFuture<HttpResponse<AsyncBody>> result = vertxHttpRequest.consumeBytes(httpClient, consumer);

    HttpResponse<AsyncBody> response = result.get(1, TimeUnit.SECONDS);
    assertThat(response).isNotNull();
    verify(httpClientRequest).send(bufferCaptor.capture());

    Buffer capturedBuffer = bufferCaptor.getValue();
    assertThat(capturedBuffer).hasToString(content);
  }

  @Test
  @DisplayName("Should send byte array body content as Buffer")
  void sendBody_shouldSendByteArrayBodyContentAsBuffer() throws Exception {
    byte[] content = "test byte array".getBytes();
    when(httpClient.request(options)).thenReturn(Future.succeededFuture(httpClientRequest));
    when(request.body()).thenReturn(byteArrayBodyContent);
    when(byteArrayBodyContent.getContent()).thenReturn(content);
    when(httpClientRequest.send(any(Buffer.class))).thenReturn(Future.succeededFuture(httpClientResponse));

    CompletableFuture<HttpResponse<AsyncBody>> result = vertxHttpRequest.consumeBytes(httpClient, consumer);

    HttpResponse<AsyncBody> response = result.get(1, TimeUnit.SECONDS);
    assertThat(response).isNotNull();
    verify(httpClientRequest).send(bufferCaptor.capture());

    Buffer capturedBuffer = bufferCaptor.getValue();
    assertThat(capturedBuffer.getBytes()).isEqualTo(content);
  }

  @Test
  @DisplayName("Should send InputStream body content as ReadStream")
  void sendBody_shouldSendInputStreamBodyContentAsReadStream() throws Exception {
    byte[] content = "test input stream".getBytes();
    InputStream inputStream = new ByteArrayInputStream(content);
    when(httpClient.request(options)).thenReturn(Future.succeededFuture(httpClientRequest));
    when(request.body()).thenReturn(inputStreamBodyContent);
    when(inputStreamBodyContent.getContent()).thenReturn(inputStream);
    when(httpClientRequest.send(any(ReadStream.class))).thenReturn(Future.succeededFuture(httpClientResponse));

    CompletableFuture<HttpResponse<AsyncBody>> result = vertxHttpRequest.consumeBytes(httpClient, consumer);

    HttpResponse<AsyncBody> response = result.get(1, TimeUnit.SECONDS);
    assertThat(response).isNotNull();
    verify(httpClientRequest).send(readStreamCaptor.capture());

    ReadStream<Buffer> capturedStream = readStreamCaptor.getValue();
    assertThat(capturedStream).isInstanceOf(InputStreamReadStream.class);
  }

  @Test
  @DisplayName("Should return failed future for unsupported body content type")
  void sendBody_shouldReturnFailedFutureForUnsupportedBodyContent() {
    when(httpClient.request(options)).thenReturn(Future.succeededFuture(httpClientRequest));
    when(request.body()).thenReturn(unsupportedBodyContent);

    CompletableFuture<HttpResponse<AsyncBody>> result = vertxHttpRequest.consumeBytes(httpClient, consumer);

    assertThat(result).isCompletedExceptionally();
    assertThatThrownBy(() -> result.get(1, TimeUnit.SECONDS))
        .isInstanceOf(ExecutionException.class)
        .hasRootCauseInstanceOf(IllegalArgumentException.class)
        .hasRootCauseMessage("Unsupported body content: " + unsupportedBodyContent.getClass());
  }

  @Test
  @DisplayName("Should create VertxHttpResponse with paused response and VertxAsyncBody")
  void toFabricResponse_shouldCreateResponseWithPausedResponseAndAsyncBody() throws Exception {
    when(httpClient.request(options)).thenReturn(Future.succeededFuture(httpClientRequest));
    when(request.body()).thenReturn(null);
    when(httpClientRequest.send()).thenReturn(Future.succeededFuture(httpClientResponse));

    CompletableFuture<HttpResponse<AsyncBody>> result = vertxHttpRequest.consumeBytes(httpClient, consumer);

    HttpResponse<AsyncBody> response = result.get(1, TimeUnit.SECONDS);
    assertThat(response).isInstanceOf(VertxHttpResponse.class);
    verify(httpClientResponse).pause();

    VertxHttpResponse vertxResponse = (VertxHttpResponse) response;
    assertThat(vertxResponse.body()).isInstanceOf(VertxAsyncBody.class);
  }

  @Test
  @DisplayName("Should convert MultiMap to headers map correctly")
  void toHeadersMap_shouldConvertMultiMapToHeadersMap() {
    when(multiMap.names()).thenReturn(java.util.Set.of("Content-Type", "Authorization", "Custom-Header"));
    when(multiMap.getAll("Content-Type")).thenReturn(List.of("application/json"));
    when(multiMap.getAll("Authorization")).thenReturn(List.of("Bearer token123"));
    when(multiMap.getAll("Custom-Header")).thenReturn(List.of("value1", "value2"));

    Map<String, List<String>> result = VertxHttpRequest.toHeadersMap(multiMap);

    assertThat(result).hasSize(3);
    assertThat(result.get("Content-Type")).containsExactly("application/json");
    assertThat(result.get("Authorization")).containsExactly("Bearer token123");
    assertThat(result.get("Custom-Header")).containsExactly("value1", "value2");
  }

  @Test
  @DisplayName("Should handle empty MultiMap correctly")
  void toHeadersMap_shouldHandleEmptyMultiMap() {
    when(multiMap.names()).thenReturn(java.util.Set.of());

    Map<String, List<String>> result = VertxHttpRequest.toHeadersMap(multiMap);

    assertThat(result).isEmpty();
  }

  @Test
  @DisplayName("Should preserve header order using LinkedHashMap")
  void toHeadersMap_shouldPreserveHeaderOrderUsingLinkedHashMap() {
    java.util.LinkedHashSet<String> orderedNames = new java.util.LinkedHashSet<>();
    orderedNames.add("First");
    orderedNames.add("Second");
    orderedNames.add("Third");
    when(multiMap.names()).thenReturn(orderedNames);
    when(multiMap.getAll("First")).thenReturn(List.of("1"));
    when(multiMap.getAll("Second")).thenReturn(List.of("2"));
    when(multiMap.getAll("Third")).thenReturn(List.of("3"));

    Map<String, List<String>> result = VertxHttpRequest.toHeadersMap(multiMap);

    String[] headerNames = result.keySet().toArray(new String[0]);
    assertThat(headerNames).containsExactly("First", "Second", "Third");
  }

  @Test
  @DisplayName("Should handle single header with multiple values correctly")
  void toHeadersMap_shouldHandleSingleHeaderWithMultipleValues() {
    when(multiMap.names()).thenReturn(java.util.Set.of("Accept"));
    when(multiMap.getAll("Accept")).thenReturn(List.of("application/json", "text/plain", "*/*"));

    Map<String, List<String>> result = VertxHttpRequest.toHeadersMap(multiMap);

    assertThat(result).hasSize(1);
    assertThat(result.get("Accept")).containsExactly("application/json", "text/plain", "*/*");
  }

  @Test
  @DisplayName("Should handle send body failure in consumeBytes")
  void consumeBytes_shouldHandleSendBodyFailure() {
    RuntimeException sendBodyException = new RuntimeException("Send body failed");
    when(httpClient.request(options)).thenReturn(Future.succeededFuture(httpClientRequest));
    when(request.body()).thenReturn(stringBodyContent);
    when(stringBodyContent.getContent()).thenReturn("test");
    when(httpClientRequest.send(any(Buffer.class))).thenReturn(Future.failedFuture(sendBodyException));

    CompletableFuture<HttpResponse<AsyncBody>> result = vertxHttpRequest.consumeBytes(httpClient, consumer);

    assertThat(result).isCompletedExceptionally();
    assertThatThrownBy(() -> result.get(1, TimeUnit.SECONDS))
        .isInstanceOf(ExecutionException.class)
        .hasCause(sendBodyException);
  }

  @Test
  @DisplayName("Should handle response mapping in consumeBytes")
  void consumeBytes_shouldHandleResponseMapping() throws Exception {
    when(httpClient.request(options)).thenReturn(Future.succeededFuture(httpClientRequest));
    when(request.body()).thenReturn(stringBodyContent);
    when(stringBodyContent.getContent()).thenReturn("test content");
    when(httpClientRequest.send(any(Buffer.class))).thenReturn(Future.succeededFuture(httpClientResponse));

    CompletableFuture<HttpResponse<AsyncBody>> result = vertxHttpRequest.consumeBytes(httpClient, consumer);

    HttpResponse<AsyncBody> response = result.get(1, TimeUnit.SECONDS);
    assertThat(response).isNotNull().isInstanceOf(VertxHttpResponse.class);

    verify(httpClientResponse).pause();
    verify(httpClientRequest).send(any(Buffer.class));
  }
}
