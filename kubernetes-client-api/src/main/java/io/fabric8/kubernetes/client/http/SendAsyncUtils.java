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

import io.fabric8.kubernetes.client.http.HttpClient.AsyncBody;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * If we need support other than UTF-8, see jdk.internal.net.http.common.Utils.charsetFrom
 */
class SendAsyncUtils {

  /**
   * Allows for changing the body type - there is further redesign that could be done here
   */
  static class HttpResponseAdapter<T> implements HttpResponse<T> {

    private final HttpResponse<?> response;
    private final T body;

    public HttpResponseAdapter(HttpResponse<?> response, T body) {
      this.response = response;
      this.body = body;
    }

    @Override
    public List<String> headers(String key) {
      return response.headers(key);
    }

    @Override
    public boolean isSuccessful() {
      return response.isSuccessful();
    }

    @Override
    public Map<String, List<String>> headers() {
      return response.headers();
    }

    @Override
    public int code() {
      return response.code();
    }

    @Override
    public String message() {
      return response.message();
    }

    @Override
    public HttpRequest request() {
      return response.request();
    }

    @Override
    public Optional<HttpResponse<?>> previousResponse() {
      return response.previousResponse();
    }

    @Override
    public T body() {
      return body;
    }

  }

  static CompletableFuture<HttpResponse<Reader>> reader(HttpRequest request, HttpClient client) {
    return inputStream(request, client)
        .thenApply(res -> new HttpResponseAdapter<>(res, new InputStreamReader(res.body(), StandardCharsets.UTF_8)));
  }

  static CompletableFuture<HttpResponse<InputStream>> inputStream(HttpRequest request, HttpClient client) {
    HttpClientReadableByteChannel byteChannel = new HttpClientReadableByteChannel();
    CompletableFuture<HttpResponse<AsyncBody>> futureResponse = client.consumeBytes(request, byteChannel);
    return futureResponse.thenApply(res -> {
      byteChannel.onResponse(res);
      return new HttpResponseAdapter<>(res, Channels.newInputStream(byteChannel));
    });
  }

  static CompletableFuture<HttpResponse<byte[]>> bytes(HttpRequest request, HttpClient client) {
    ByteArrayBodyHandler byteArrayBodyHandler = new ByteArrayBodyHandler();
    CompletableFuture<HttpResponse<AsyncBody>> futureResponse = client.consumeBytes(request, byteArrayBodyHandler);
    return futureResponse.thenCompose(res -> {
      byteArrayBodyHandler.onResponse(res);
      return byteArrayBodyHandler.getResult()
          .thenApply(b -> new HttpResponseAdapter<>(res, b));
    });
  }

  static CompletableFuture<HttpResponse<String>> string(HttpRequest request, HttpClient client) {
    return bytes(request, client).thenApply(res -> {
      return new HttpResponseAdapter<>(res,
          new String(res.body(), StandardCharsets.UTF_8));
    });
  }

  static <T> CompletableFuture sendAsync(HttpRequest request, Class<T> type, HttpClient httpClient) {
    if (type == String.class) {
      return string(request, httpClient);
    }
    if (type == byte[].class) {
      return bytes(request, httpClient);
    }
    if (type == Reader.class) {
      return reader(request, httpClient);
    }
    if (type == InputStream.class) {
      return inputStream(request, httpClient);
    }
    throw new AssertionError("unknown type");
  }

}
