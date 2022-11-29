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

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

/**
 * If we need support other than UTF-8, see jdk.internal.net.http.common.Utils.charsetFrom
 */
class SendAsyncUtils {

  private SendAsyncUtils() {
    // just utils
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
    return bytes(request, client)
        .thenApply(res -> new HttpResponseAdapter<>(res, new String(res.body(), StandardCharsets.UTF_8)));
  }

}
