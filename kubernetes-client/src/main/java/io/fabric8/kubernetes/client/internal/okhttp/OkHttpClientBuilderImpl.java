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

package io.fabric8.kubernetes.client.internal.okhttp;

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpClient.Builder;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.fabric8.kubernetes.client.internal.okhttp.OkHttpClientImpl.OkHttpResponseImpl;
import okhttp3.Authenticator;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static okhttp3.ConnectionSpec.CLEARTEXT;

public class OkHttpClientBuilderImpl implements Builder {
  
  static final class InteceptorAdapter implements Interceptor {
    private final io.fabric8.kubernetes.client.http.Interceptor interceptor;
    private final String name;

    private InteceptorAdapter(io.fabric8.kubernetes.client.http.Interceptor interceptor, String name) {
      this.interceptor = interceptor;
      this.name = name;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
      Request.Builder requestBuilder = chain.request().newBuilder();
      OkHttpRequestImpl.BuilderImpl builderImpl = new OkHttpRequestImpl.BuilderImpl(requestBuilder);
      interceptor.before(new OkHttpRequestImpl.BuilderImpl(requestBuilder), new OkHttpRequestImpl(chain.request()));
      Response response = chain.proceed(requestBuilder.build());
      if (!response.isSuccessful()) {
        boolean call = interceptor.afterFailure(builderImpl, new OkHttpResponseImpl<>(response, InputStream.class));
        if (call) {
          return chain.proceed(requestBuilder.build());
        }
      }
      return response;
    }
    
    public String getName() {
      return name;
    }
  }
  
  private boolean streaming;
  private OkHttpClient.Builder builder;

  public OkHttpClientBuilderImpl(okhttp3.OkHttpClient.Builder newBuilder) {
    this.builder = newBuilder;
  }

  @Override
  public HttpClient build() {
    OkHttpClient client = builder.build();
    
    if (streaming) {
      // If we set the HttpLoggingInterceptor's logging level to Body (as it is by default), it does
      // not let us stream responses from the server.
      for (Interceptor i : client.networkInterceptors()) {
        if (i instanceof HttpLoggingInterceptor) {
          HttpLoggingInterceptor interceptor = (HttpLoggingInterceptor) i;
          interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }
      }
    }
    
    return new OkHttpClientImpl(client);
  }

  @Override
  public Builder readTimeout(long readTimeout, TimeUnit unit) {
    builder.readTimeout(readTimeout, unit);
    return this;
  }

  @Override
  public Builder connectTimeout(long connectTimeout, TimeUnit unit) {
    builder.connectTimeout(connectTimeout, unit);
    return this;
  }
  
  @Override
  public Builder writeTimeout(long timeout, TimeUnit timeoutUnit) {
    builder.writeTimeout(timeout, timeoutUnit);
    return this;
  }

  @Override
  public Builder forStreaming() {
    builder.cache(null);
    this.streaming = true;
    return this;
  }

  @Override
  public Builder addOrReplaceInterceptor(String name, io.fabric8.kubernetes.client.http.Interceptor interceptor) {
    List<Interceptor> interceptors = builder.interceptors();
    for (int i = 0; i < interceptors.size(); i++) {
      Interceptor exiting = interceptors.get(i);
      if (exiting instanceof InteceptorAdapter) {
        InteceptorAdapter adapter = (InteceptorAdapter)exiting;
        if (adapter.getName().equals(name)) {
          if (interceptor == null) {
            interceptors.remove(i);
          } else {
            interceptors.set(i, new InteceptorAdapter(interceptor, name));
          }
          return this;
        }
      }
    }
    if (interceptor != null) {
      builder.addInterceptor(new InteceptorAdapter(interceptor, name));
    }
    return this;
  }

  @Override
  public Builder authenticatorNone() {
    builder.authenticator(Authenticator.NONE);
    return this;
  }
  
  @Override
  public Builder sslContext(SSLContext context, TrustManager[] trustManagers) {
    X509TrustManager trustManager = null;
    if (trustManagers != null && trustManagers.length == 1) {
      trustManager = (X509TrustManager) trustManagers[0];
    }
    builder.sslSocketFactory(context.getSocketFactory(), trustManager);
    return this;
  }
  
  @Override
  public Builder followAllRedirects() {
    builder.followRedirects(true).followSslRedirects(true);
    return this;
  }
  
  @Override
  public Builder proxyAddress(InetSocketAddress proxyAddress) {
    if (proxyAddress == null) {
      builder.proxy(Proxy.NO_PROXY);
    } else {
      builder.proxy(new Proxy(Proxy.Type.HTTP, proxyAddress));
    }
    return this;
  }
  
  @Override
  public Builder proxyAuthorization(String credentials) {
    builder.proxyAuthenticator(
        (route, response) -> response.request().newBuilder().header("Proxy-Authorization", credentials).build());
    return this;
  }
  
  @Override
  public Builder tlsVersions(TlsVersion[] tlsVersions) {
    ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
        .tlsVersions(Arrays.asList(tlsVersions)
            .stream()
            .map(tls -> okhttp3.TlsVersion.valueOf(tls.name()))
            .toArray(okhttp3.TlsVersion[]::new))
        .build();
    builder.connectionSpecs(Arrays.asList(spec, CLEARTEXT));
    return this;
  }
  
  @Override
  public Builder preferHttp11() {
    builder.protocols(Collections.singletonList(Protocol.HTTP_1_1));
    return this;
  }
  
}