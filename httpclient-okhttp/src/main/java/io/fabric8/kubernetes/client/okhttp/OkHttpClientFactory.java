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
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class OkHttpClientFactory implements HttpClient.Factory {

  @Override
  public int priority() {
    return -1;
  }

  /**
   * Subclasses may use this to apply a base configuration to the builder
   */
  protected OkHttpClient.Builder newOkHttpClientBuilder() {
    return new OkHttpClient.Builder().dispatcher(initDispatcher());
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

      // after #4911 the httpclients should default to unlimited read/write timeouts
      // with the value set on the request as needed
      httpClientBuilder.readTimeout(Duration.ZERO).writeTimeout(Duration.ZERO);

      if (config.isTrustCerts() || config.isDisableHostnameVerification()) {
        httpClientBuilder.hostnameVerifier((s, sslSession) -> true);
      }

      if (config.getWebsocketPingInterval() > 0) {
        httpClientBuilder.pingInterval(config.getWebsocketPingInterval(), TimeUnit.MILLISECONDS);
      }

      HttpClientUtils.applyCommonConfiguration(config, builderWrapper, this);

      if (shouldDisableHttp2() && !config.isHttp2Disable()) {
        builderWrapper.preferHttp11();
      }

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

  protected Dispatcher initDispatcher() {
    Dispatcher dispatcher = new Dispatcher();
    // websockets and long-running http requests count against this and eventually starve
    // the work that can be done
    dispatcher.setMaxRequests(Integer.MAX_VALUE);
    // long-running http requests count against this and eventually exhaust
    // the work that can be done
    dispatcher.setMaxRequestsPerHost(Integer.MAX_VALUE);
    return dispatcher;
  }

}
