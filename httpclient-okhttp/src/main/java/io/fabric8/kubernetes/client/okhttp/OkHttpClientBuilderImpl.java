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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.HttpClient.ProxyType;
import io.fabric8.kubernetes.client.http.StandardHttpClientBuilder;
import io.fabric8.kubernetes.client.http.StandardHttpHeaders;
import okhttp3.Authenticator;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

import java.net.Proxy;
import java.util.Arrays;
import java.util.Collections;

import javax.net.ssl.X509TrustManager;

import static okhttp3.ConnectionSpec.CLEARTEXT;

class OkHttpClientBuilderImpl
    extends StandardHttpClientBuilder<OkHttpClientImpl, OkHttpClientFactory, OkHttpClientBuilderImpl> {

  private final okhttp3.OkHttpClient.Builder builder;

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
      return completeBuild(this.client.getOkHttpClient().newBuilder(), true);
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
    if (proxyType == ProxyType.DIRECT) {
      builder.proxy(Proxy.NO_PROXY);
    } else if (proxyAddress != null) {
      builder.proxy(new Proxy(convertProxyType(), proxyAddress));
      if (proxyAuthorization != null) {
        builder.proxyAuthenticator(
            (route, response) -> response.request().newBuilder()
                .header(StandardHttpHeaders.PROXY_AUTHORIZATION, proxyAuthorization).build());
      }
    }
    if (tlsVersions != null) {
      ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
          .tlsVersions(Arrays.stream(tlsVersions)
              .map(tls -> okhttp3.TlsVersion.valueOf(tls.name()))
              .toArray(okhttp3.TlsVersion[]::new))
          .build();
      builder.connectionSpecs(Arrays.asList(spec, CLEARTEXT));
    }
    if (preferHttp11) {
      builder.protocols(Collections.singletonList(Protocol.HTTP_1_1));
    }
    return completeBuild(builder, false);
  }

  private Proxy.Type convertProxyType() {
    switch (proxyType) {
      case DIRECT:
        return Proxy.Type.DIRECT;
      case HTTP:
        return Proxy.Type.HTTP;
      case SOCKS4:
      case SOCKS5:
        return Proxy.Type.SOCKS;
      default:
        throw new KubernetesClientException("Unsupported proxy type");
    }
  }

  private OkHttpClientImpl completeBuild(okhttp3.OkHttpClient.Builder builder, boolean derived) {
    if (authenticatorNone) {
      builder.authenticator(Authenticator.NONE);
    }

    if (!derived) {
      clientFactory.additionalConfig(builder);
    }

    OkHttpClient client = builder.build();

    return new OkHttpClientImpl(client, this);
  }

  @Override
  protected OkHttpClientBuilderImpl newInstance(OkHttpClientFactory clientFactory) {
    return new OkHttpClientBuilderImpl(clientFactory, this.builder);
  }

}
