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

package io.fabric8.kubernetes.client.okhttp;

import io.fabric8.kubernetes.client.http.StandardHttpClientBuilder;
import okhttp3.Authenticator;
import okhttp3.ConnectionSpec;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.logging.HttpLoggingInterceptor;

import java.net.Proxy;
import java.util.Arrays;
import java.util.Collections;

import javax.net.ssl.X509TrustManager;

import static okhttp3.ConnectionSpec.CLEARTEXT;

class OkHttpClientBuilderImpl
    extends StandardHttpClientBuilder<OkHttpClientImpl, OkHttpClientFactory, OkHttpClientBuilderImpl> {

  private okhttp3.OkHttpClient.Builder builder;

  public OkHttpClientBuilderImpl(OkHttpClientFactory clientFactory, okhttp3.OkHttpClient.Builder builder) {
    super(clientFactory);
    this.builder = builder;
  }

  okhttp3.OkHttpClient.Builder getBuilder() {
    return builder;
  }

  @Override
  public OkHttpClientImpl build() {
    if (client != null) {
      return derivedBuild(this.client.getOkHttpClient().newBuilder());
    }
    return initialBuild(builder);
  }

  public OkHttpClientImpl initialBuild(okhttp3.OkHttpClient.Builder builder) {
    // configure the main properties
    if (connectTimeout != null) {
      builder.connectTimeout(this.connectTimeout);
    }
    if (sslContext != null) {
      X509TrustManager trustManager = null;
      if (trustManagers != null && trustManagers.length == 1) {
        trustManager = (X509TrustManager) trustManagers[0];
      }
      builder.sslSocketFactory(sslContext.getSocketFactory(), trustManager);
    }
    if (followRedirects) {
      builder.followRedirects(true).followSslRedirects(true);
    }
    if (proxyAddress == null) {
      builder.proxy(Proxy.NO_PROXY);
    } else {
      builder.proxy(new Proxy(Proxy.Type.HTTP, proxyAddress));
    }
    if (proxyAuthorization != null) {
      builder.proxyAuthenticator(
          (route, response) -> response.request().newBuilder().header("Proxy-Authorization", proxyAuthorization).build());
    }
    if (tlsVersions != null) {
      ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
          .tlsVersions(Arrays.asList(tlsVersions)
              .stream()
              .map(tls -> okhttp3.TlsVersion.valueOf(tls.name()))
              .toArray(okhttp3.TlsVersion[]::new))
          .build();
      builder.connectionSpecs(Arrays.asList(spec, CLEARTEXT));
    }
    if (preferHttp11) {
      builder.protocols(Collections.singletonList(Protocol.HTTP_1_1));
    }
    Dispatcher dispatcher = new Dispatcher();
    // websockets and long running http requests count against this and eventually starve
    // the work that can be done
    dispatcher.setMaxRequests(Integer.MAX_VALUE);
    // long running http requests count against this and eventually exhaust
    // the work that can be done
    dispatcher.setMaxRequestsPerHost(Integer.MAX_VALUE);
    builder.dispatcher(dispatcher);
    return derivedBuild(builder);
  }

  private OkHttpClientImpl derivedBuild(okhttp3.OkHttpClient.Builder builder) {
    if (readTimeout != null) {
      builder.readTimeout(this.readTimeout);
    }
    if (writeTimeout != null) {
      builder.writeTimeout(this.writeTimeout);
    }
    if (authenticatorNone) {
      builder.authenticator(Authenticator.NONE);
    }
    if (forStreaming) {
      builder.cache(null);
    }
    OkHttpClient client = builder.build();
    if (this.forStreaming) {
      // If we set the HttpLoggingInterceptor's logging level to Body (as it is by default), it does
      // not let us stream responses from the server.
      for (Interceptor i : client.networkInterceptors()) {
        if (i instanceof HttpLoggingInterceptor) {
          HttpLoggingInterceptor interceptor = (HttpLoggingInterceptor) i;
          interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }
      }
    }

    return new OkHttpClientImpl(client, this);
  }

  @Override
  protected OkHttpClientBuilderImpl newInstance(OkHttpClientFactory clientFactory) {
    return new OkHttpClientBuilderImpl(clientFactory, this.builder);
  }

}
