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
import io.fabric8.kubernetes.client.internal.SSLUtils;
import lombok.Getter;

import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

@SuppressWarnings("unchecked")
@Getter
public abstract class StandardHttpClientBuilder<C extends HttpClient, F extends HttpClient.Factory, T extends StandardHttpClientBuilder<C, F, ?>>
    implements HttpClient.Builder {

  protected LinkedHashMap<String, Interceptor> interceptors = new LinkedHashMap<>();
  protected Duration connectTimeout;
  protected Duration readTimeout;
  protected Duration writeTimeout;
  protected SSLContext sslContext;
  protected String proxyAuthorization;
  protected InetSocketAddress proxyAddress;
  protected boolean followRedirects;
  protected boolean preferHttp11;
  protected TlsVersion[] tlsVersions;
  protected boolean forStreaming;
  protected boolean authenticatorNone;
  protected Config requestConfig;
  protected C client;
  protected F clientFactory;
  protected TrustManager[] trustManagers;
  protected KeyManager[] keyManagers;

  protected StandardHttpClientBuilder(F clientFactory) {
    this.clientFactory = clientFactory;
  }

  @Override
  public T readTimeout(long readTimeout, TimeUnit unit) {
    this.readTimeout = Duration.ofNanos(unit.toNanos(readTimeout));
    return (T) this;
  }

  @Override
  public T writeTimeout(long writeTimeout, TimeUnit unit) {
    this.writeTimeout = Duration.ofNanos(unit.toNanos(writeTimeout));
    return (T) this;
  }

  @Override
  public T connectTimeout(long connectTimeout, TimeUnit unit) {
    this.connectTimeout = Duration.ofNanos(unit.toNanos(connectTimeout));
    return (T) this;
  }

  @Override
  public T forStreaming() {
    this.forStreaming = true;
    return (T) this;
  }

  @Override
  public T addOrReplaceInterceptor(String name, Interceptor interceptor) {
    if (interceptor == null) {
      interceptors.remove(name);
    } else {
      interceptors.put(name, interceptor);
    }
    return (T) this;
  }

  @Override
  public T authenticatorNone() {
    this.authenticatorNone = true;
    return (T) this;
  }

  @Override
  public T sslContext(KeyManager[] keyManagers, TrustManager[] trustManagers) {
    this.sslContext = SSLUtils.sslContext(keyManagers, trustManagers);
    this.keyManagers = keyManagers;
    this.trustManagers = trustManagers;
    return (T) this;
  }

  @Override
  public T followAllRedirects() {
    this.followRedirects = true;
    return (T) this;
  }

  @Override
  public T proxyAddress(InetSocketAddress proxyAddress) {
    this.proxyAddress = proxyAddress;
    return (T) this;
  }

  @Override
  public T proxyAuthorization(String credentials) {
    this.proxyAuthorization = credentials;
    return (T) this;
  }

  @Override
  public T tlsVersions(TlsVersion... tlsVersions) {
    this.tlsVersions = tlsVersions;
    return (T) this;
  }

  @Override
  public T requestConfig(Config requestConfig) {
    this.requestConfig = requestConfig;
    return (T) this;
  }

  @Override
  public T preferHttp11() {
    this.preferHttp11 = true;
    return (T) this;
  }

  public T clientFactory(F clientFactory) {
    this.clientFactory = clientFactory;
    return (T) this;
  }

  protected abstract T newInstance(F clientFactory);

  public T copy(C client) {
    T copy = newInstance(clientFactory);
    copy.connectTimeout = this.connectTimeout;
    copy.readTimeout = this.readTimeout;
    copy.sslContext = this.sslContext;
    copy.trustManagers = this.trustManagers;
    copy.keyManagers = this.keyManagers;
    copy.interceptors = new LinkedHashMap<>(this.interceptors);
    copy.proxyAddress = this.proxyAddress;
    copy.proxyAuthorization = this.proxyAuthorization;
    copy.tlsVersions = this.tlsVersions;
    copy.preferHttp11 = this.preferHttp11;
    copy.followRedirects = this.followRedirects;
    copy.authenticatorNone = this.authenticatorNone;
    copy.writeTimeout = this.writeTimeout;
    copy.requestConfig = this.requestConfig;
    copy.client = client;
    return copy;
  }

}
