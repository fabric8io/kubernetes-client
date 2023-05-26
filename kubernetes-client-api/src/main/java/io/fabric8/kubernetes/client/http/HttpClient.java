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
import io.fabric8.kubernetes.client.utils.HttpClientUtils;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

public interface HttpClient extends AutoCloseable {

  enum ProxyType {
    HTTP,
    SOCKS4,
    SOCKS5,
    DIRECT
  }

  interface Factory {

    /**
     * Create a builder that is customized by the {@link Config}. By default it
     * will apply the common configuration {@link HttpClientUtils#applyCommonConfiguration(Config, Builder, Factory)}
     *
     * @param config the configuration to apply
     * @return the configured {@link Builder}
     */
    default HttpClient.Builder newBuilder(Config config) {
      Builder builder = newBuilder();
      HttpClientUtils.applyCommonConfiguration(config, builder, this);
      return builder;
    }

    HttpClient.Builder newBuilder();

    /**
     * The priority of the implementation. The higher the priority the more likely it will be used.
     * <br>
     * -1 represents the priority of the Fabric8 project default implementation.
     *
     * @return the priority.
     */
    default int priority() {
      return 0;
    }

  }

  interface DerivedClientBuilder {

    HttpClient build();

    DerivedClientBuilder addOrReplaceInterceptor(String name, Interceptor interceptor);

    /**
     * Prevents any built-in authenticator to respond to challenges from origin server.
     * <p>
     * <i>OkHttp specific option.</i>
     *
     * @return this Builder instance.
     */
    DerivedClientBuilder authenticatorNone();

    /**
     * Will be provided to all interceptors
     */
    DerivedClientBuilder tag(Object value);
  }

  interface Builder extends DerivedClientBuilder {

    /**
     * {@inheritDoc}
     */
    @Override
    HttpClient build();

    Builder connectTimeout(long connectTimeout, TimeUnit unit);

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

    Builder proxyType(ProxyType type);
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
   * Send a request and consume the bytes of the resulting response body
   * <p>
   * HtttpClient implementations will provide ByteBuffers that may be held directly.
   *
   * @param request the HttpRequest to send
   * @param consumer the response body consumer
   * @return the future which will be ready after the headers have been read
   */
  CompletableFuture<HttpResponse<AsyncBody>> consumeBytes(HttpRequest request, AsyncBody.Consumer<List<ByteBuffer>> consumer);

  WebSocket.Builder newWebSocketBuilder();

  HttpRequest.Builder newHttpRequestBuilder();

}
