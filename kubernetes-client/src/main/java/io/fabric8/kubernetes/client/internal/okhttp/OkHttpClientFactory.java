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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpClient.Builder;
import io.fabric8.kubernetes.client.internal.SSLUtils;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import okhttp3.ConnectionSpec;
import okhttp3.Credentials;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static okhttp3.ConnectionSpec.CLEARTEXT;

public class OkHttpClientFactory implements HttpClient.Factory {

  @Override
  public HttpClient createHttpClient(Config config) {
    return createHttpClient(config, builder -> {});
  }
  
  @Override
  public Builder newBuilder() {
    return OkHttpClientImpl.builder();
  }

  /**
   * Creates an HTTP client configured to access the Kubernetes API.
   * @param config Kubernetes API client config
   * @param additionalConfig a consumer that allows overriding HTTP client properties
   * @return returns an HTTP client
   */
  public static io.fabric8.kubernetes.client.http.HttpClient createHttpClient(final Config config,
      final Consumer<OkHttpClient.Builder> additionalConfig) {
    try {
      OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

      // Follow any redirects
      httpClientBuilder.followRedirects(true);
      httpClientBuilder.followSslRedirects(true);

      if (config.isTrustCerts() || config.isDisableHostnameVerification()) {
        httpClientBuilder.hostnameVerifier((s, sslSession) -> true);
      }

      Logger reqLogger = LoggerFactory.getLogger(HttpLoggingInterceptor.class);
      if (reqLogger.isTraceEnabled()) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder.addNetworkInterceptor(loggingInterceptor);
      }

      if (config.getConnectionTimeout() > 0) {
        httpClientBuilder.connectTimeout(config.getConnectionTimeout(), TimeUnit.MILLISECONDS);
      }

      if (config.getRequestTimeout() > 0) {
        httpClientBuilder.readTimeout(config.getRequestTimeout(), TimeUnit.MILLISECONDS);
      }

      if (config.getWebsocketPingInterval() > 0) {
        httpClientBuilder.pingInterval(config.getWebsocketPingInterval(), TimeUnit.MILLISECONDS);
      }

      if (config.getMaxConcurrentRequests() > 0 && config.getMaxConcurrentRequestsPerHost() > 0) {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(config.getMaxConcurrentRequests());
        dispatcher.setMaxRequestsPerHost(config.getMaxConcurrentRequestsPerHost());
        httpClientBuilder.dispatcher(dispatcher);
      }

      // Only check proxy if it's a full URL with protocol
      if (config.getMasterUrl().toLowerCase(Locale.ROOT).startsWith(Config.HTTP_PROTOCOL_PREFIX)
          || config.getMasterUrl().startsWith(Config.HTTPS_PROTOCOL_PREFIX)) {
        try {
          URL proxyUrl = HttpClientUtils.getProxyUrl(config);
          if (proxyUrl != null) {
            httpClientBuilder
                .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyUrl.getHost(), proxyUrl.getPort())));

            if (config.getProxyUsername() != null) {
              httpClientBuilder.proxyAuthenticator((route, response) -> {

                String credential = Credentials.basic(config.getProxyUsername(), config.getProxyPassword());
                return response.request().newBuilder().header("Proxy-Authorization", credential).build();
              });
            }
          } else {
            httpClientBuilder.proxy(Proxy.NO_PROXY);
          }

        } catch (MalformedURLException e) {
          throw new KubernetesClientException("Invalid proxy server configuration", e);
        }
      }

      if (config.getTlsVersions() != null && config.getTlsVersions().length > 0) {
        ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
            .tlsVersions(Arrays.asList(config.getTlsVersions())
                .stream()
                .map(tls -> TlsVersion.valueOf(tls.name()))
                .toArray(TlsVersion[]::new))
            .build();
        httpClientBuilder.connectionSpecs(Arrays.asList(spec, CLEARTEXT));
      }

      if (shouldDisableHttp2() || config.isHttp2Disable()) {
        httpClientBuilder.protocols(Collections.singletonList(Protocol.HTTP_1_1));
      }

      if (additionalConfig != null) {
        additionalConfig.accept(httpClientBuilder);
      }

      Builder builderWrapper = new OkHttpClientImpl.BuilderImpl(httpClientBuilder);
      
      // TODO: the rest can be moved to common logic
      TrustManager[] trustManagers = SSLUtils.trustManagers(config);
      KeyManager[] keyManagers = SSLUtils.keyManagers(config);

      SSLContext sslContext = SSLUtils.sslContext(keyManagers, trustManagers);
      builderWrapper.sslContext(sslContext, trustManagers);
      
      HttpClientUtils.createApplicableInterceptors(config).forEach((s, i) -> builderWrapper.addOrReplaceInterceptor(s, i));
      return builderWrapper.build();
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }
  
  /**
   * OkHttp wrongfully detects >JDK8u251 as {@link okhttp3.internal.platform.Jdk9Platform} which enables Http2
   * unsupported for JDK8.
   *
   * @return true if JDK8 is detected, false otherwise-
   * @see <a href="https://github.com/fabric8io/kubernetes-client/issues/2212">#2212</a>
   */
  private static boolean shouldDisableHttp2() {
      return System.getProperty("java.version", "").startsWith("1.8");
  }

}
