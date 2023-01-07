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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class OkHttpClientFactory implements HttpClient.Factory {

  @Override
  public boolean isDefault() {
    return true;
  }

  /**
   * Subclasses may use this to apply a base configuration to the builder
   */
  protected OkHttpClient.Builder newOkHttpClientBuilder() {
    return new OkHttpClient.Builder();
  }

  /**
   * Subclasses may use this to apply additional configuration after the Config has been applied
   * This method is only called for clients constructed using the Config.
   *
   * @param builder
   */
  protected void additionalConfig(OkHttpClient.Builder builder) {
    // no default implementation
  }

  @Override
  public OkHttpClientBuilderImpl newBuilder() {
    return new OkHttpClientBuilderImpl(this, newOkHttpClientBuilder());
  }

  /**
   * Creates an HTTP client builder configured to access the Kubernetes API.
   *
   * @param config Kubernetes API client config
   * @return returns an HTTP client builder
   */
  @Override
  public OkHttpClientBuilderImpl newBuilder(Config config) {
    try {
      OkHttpClientBuilderImpl builderWrapper = newBuilder();
      OkHttpClient.Builder httpClientBuilder = builderWrapper.getBuilder();

      if (config.isTrustCerts() || config.isDisableHostnameVerification()) {
        httpClientBuilder.hostnameVerifier((s, sslSession) -> true);
      }

      Logger reqLogger = LoggerFactory.getLogger(HttpLoggingInterceptor.class);
      if (reqLogger.isTraceEnabled()) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder.addNetworkInterceptor(loggingInterceptor);
      }

      if (config.getWebsocketPingInterval() > 0) {
        httpClientBuilder.pingInterval(config.getWebsocketPingInterval(), TimeUnit.MILLISECONDS);
      }

      HttpClientUtils.applyCommonConfiguration(config, builderWrapper, this);

      if (shouldDisableHttp2() && !config.isHttp2Disable()) {
        builderWrapper.preferHttp11();
      }

      additionalConfig(httpClientBuilder);

      return builderWrapper;
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  /**
   * OkHttp wrongfully detects &gt; JDK8u251 as okhttp3.internal.platform.Jdk9Platform which enables Http2
   * unsupported for JDK8.
   *
   * @return true if JDK8 is detected, false otherwise-
   * @see <a href="https://github.com/fabric8io/kubernetes-client/issues/2212">#2212</a>
   */
  protected boolean shouldDisableHttp2() {
    return System.getProperty("java.version", "").startsWith("1.8");
  }

}
