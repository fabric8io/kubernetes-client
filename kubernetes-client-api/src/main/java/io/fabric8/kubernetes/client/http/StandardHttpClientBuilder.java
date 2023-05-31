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

import io.fabric8.kubernetes.client.http.HttpClient.DerivedClientBuilder;
import io.fabric8.kubernetes.client.http.HttpClient.ProxyType;
import io.fabric8.kubernetes.client.internal.SSLUtils;
import lombok.Getter;
import org.slf4j.LoggerFactory;

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
  protected SSLContext sslContext;
  protected String proxyAuthorization;
  protected InetSocketAddress proxyAddress;
  protected boolean followRedirects;
  protected boolean preferHttp11;
  protected TlsVersion[] tlsVersions;
  protected boolean authenticatorNone;
  protected C client;
  protected F clientFactory;
  protected TrustManager[] trustManagers;
  protected KeyManager[] keyManagers;
  protected LinkedHashMap<Class<?>, Object> tags = new LinkedHashMap<>();
  protected ProxyType proxyType = ProxyType.HTTP; // for backwards compatibility if the builder is manually configured

  protected StandardHttpClientBuilder(F clientFactory) {
    this.clientFactory = clientFactory;
    // TODO: Find better place or solution
    if (LoggerFactory.getLogger(HttpLoggingInterceptor.class).isTraceEnabled()) {
      interceptors.put("HttpLogging", new HttpLoggingInterceptor());
    }
  }

  @Override
  public T connectTimeout(long connectTimeout, TimeUnit unit) {
    this.connectTimeout = Duration.ofNanos(unit.toNanos(connectTimeout));
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
  public T proxyType(ProxyType type) {
    this.proxyType = type;
    return (T) this;
  }

  @Override
  public T tlsVersions(TlsVersion... tlsVersions) {
    this.tlsVersions = tlsVersions;
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

  @Override
  public DerivedClientBuilder tag(Object value) {
    if (value != null) {
      this.tags.put(value.getClass(), value);
    }
    return this;
  }

  protected abstract T newInstance(F clientFactory);

  public T copy(C client) {
    T copy = newInstance(clientFactory);
    copy.connectTimeout = this.connectTimeout;
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
    copy.client = client;
    copy.tags = new LinkedHashMap<>(this.tags);
    copy.proxyType = this.proxyType;
    return copy;
  }

  protected void addProxyAuthInterceptor() {
    if (proxyAuthorization != null) {
      this.interceptors.put("PROXY-AUTH", new Interceptor() {

        @Override
        public void before(BasicBuilder builder, HttpRequest httpRequest, RequestTags tags) {
          builder.setHeader(StandardHttpHeaders.PROXY_AUTHORIZATION, proxyAuthorization);
        }

      });
    }
  }

}
