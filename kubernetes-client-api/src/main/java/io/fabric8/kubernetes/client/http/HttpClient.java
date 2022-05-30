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

import io.fabric8.kubernetes.client.Config;

import java.io.BufferedReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

public interface HttpClient extends AutoCloseable {

  interface Factory {

    HttpClient createHttpClient(Config config);

    HttpClient.Builder newBuilder();

    /**
     * If the implementation should be considered default. If default any other implementation in the classpath will
     * be used instead.
     *
     * @return true if default
     */
    default boolean isDefault() {
      return false;
    }

  }

  interface DerivedClientBuilder {

    HttpClient build();

    DerivedClientBuilder readTimeout(long readTimeout, TimeUnit unit);

    DerivedClientBuilder writeTimeout(long writeTimeout, TimeUnit unit);

    /**
     * Sets the HttpClient to be used to perform HTTP requests whose responses
     * will be streamed.
     *
     * @return this Builder instance.
     */
    DerivedClientBuilder forStreaming();

    DerivedClientBuilder addOrReplaceInterceptor(String name, Interceptor interceptor);

    /**
     * Prevents any built-in authenticator to respond to challenges from origin server.
     * <p>
     * <i>OkHttp specific option.</i>
     *
     * @return this Builder instance.
     */
    DerivedClientBuilder authenticatorNone();
  }

  interface Builder extends DerivedClientBuilder {

    /**
     * {@inheritDoc}
     */
    @Override
    HttpClient build();

    /**
     * {@inheritDoc}
     */
    @Override
    Builder readTimeout(long readTimeout, TimeUnit unit);

    /**
     * {@inheritDoc}
     */
    @Override
    Builder writeTimeout(long writeTimeout, TimeUnit unit);

    Builder connectTimeout(long connectTimeout, TimeUnit unit);

    /**
     * {@inheritDoc}
     */
    @Override
    Builder forStreaming();

    /**
     * {@inheritDoc}
     */
    @Override
    Builder addOrReplaceInterceptor(String name, Interceptor interceptor);

    /**
     * {@inheritDoc}
     */
    @Override
    Builder authenticatorNone();

    Builder sslContext(KeyManager[] keyManagers, TrustManager[] trustManagers);

    Builder followAllRedirects();

    Builder proxyAddress(InetSocketAddress proxyAddress);

    Builder proxyAuthorization(String credentials);

    Builder tlsVersions(TlsVersion... tlsVersions);

    Builder preferHttp11();
  }

  /**
   * A simplified java.util.concurrent.Flow.Subscription and a future tracking done.
   * <br>
   * The body should be consumed until the end or cancelled.
   */
  interface AsyncBody {
    /**
     * Called to deliver results to the {@link BodyConsumer}
     */
    void consume();

    /**
     * Tracks the completion of the body.
     *
     * @return the future
     */
    CompletableFuture<Void> done();

    void cancel();
  }

  /**
   * A functional interface for consuming async result bodies
   */
  @FunctionalInterface
  interface BodyConsumer<T> {
    void consume(T value, AsyncBody asyncBody) throws Exception;
  }

  @Override
  void close();

  /**
   * Create a builder that starts with the same state as this client.
   * <br>
   * The client resources will be shared across derived instances.
   *
   * @return a new builder
   */
  DerivedClientBuilder newBuilder();

  /**
   * Send an async request
   * <br>
   * A Reader or InputStream result must be closed by the caller to properly cleanup resources.
   * <br>
   * A Reader or InputStream result should not be consumed by the thread completing the returned future
   * as that will hijack a client thread.
   *
   * @param <T> return type
   * @param request the HttpRequest to send asynchronously
   * @param type one of InputStream, Reader, String, byte[]
   * @return a CompletableFuture that returns the resulting HttpResponse when complete
   */
  <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, Class<T> type);

  /**
   * Send a request and consume the lines of the response body using the same logic as {@link BufferedReader} to
   * break up the lines.
   *
   * @param request the HttpRequest to send
   * @param consumer the response body consumer
   * @return the future which will be ready after the headers have been read
   */
  CompletableFuture<HttpResponse<AsyncBody>> consumeLines(HttpRequest request, BodyConsumer<String> consumer);

  /**
   * Send a request and consume the bytes of the resulting response body
   *
   * @param request the HttpRequest to send
   * @param consumer the response body consumer
   * @return the future which will be ready after the headers have been read
   */
  CompletableFuture<HttpResponse<AsyncBody>> consumeBytes(HttpRequest request, BodyConsumer<List<ByteBuffer>> consumer);

  WebSocket.Builder newWebSocketBuilder();

  HttpRequest.Builder newHttpRequestBuilder();

  HttpClient.Factory getFactory();

}
