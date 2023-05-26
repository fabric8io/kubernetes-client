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

package io.fabric8.kubernetes.client.jdkhttp;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.StandardHttpClientBuilder;
import io.fabric8.kubernetes.client.http.TlsVersion;

import java.net.ProxySelector;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.util.Arrays;

import javax.net.ssl.SSLParameters;

/**
 * TODO: if there is another implementation that does not support client builder copying, then this needs to be abstracted -
 * or change the paradigm to directly hold the configuration
 *
 * proxyAuthorization is being done as a header that is always added - rather than in response to a proxy auth failure.
 * It also seems to require jdk.http.auth.tunneling.disabledSchemes as an empty list
 * see https://stackoverflow.com/questions/53333556/proxy-authentication-with-jdk-11-httpclient
 *
 */

class JdkHttpClientBuilderImpl
    extends StandardHttpClientBuilder<JdkHttpClientImpl, JdkHttpClientFactory, JdkHttpClientBuilderImpl> {

  public JdkHttpClientBuilderImpl(JdkHttpClientFactory factory) {
    super(factory);
  }

  @Override
  public HttpClient build() {
    if (client != null) {
      return new JdkHttpClientImpl(this, client.getHttpClient());
    }
    java.net.http.HttpClient.Builder builder = clientFactory.createNewHttpClientBuilder();
    if (connectTimeout != null && !java.time.Duration.ZERO.equals(connectTimeout)) {
      builder.connectTimeout(connectTimeout);
    }
    if (sslContext != null) {
      builder.sslContext(sslContext);
    }
    if (followRedirects) {
      builder.followRedirects(Redirect.ALWAYS);
    }
    if (proxyType == HttpClient.ProxyType.DIRECT) {
      builder.proxy(java.net.http.HttpClient.Builder.NO_PROXY);
    } else if (proxyAddress != null) {
      if (proxyType != HttpClient.ProxyType.HTTP) {
        // https://bugs.openjdk.org/browse/JDK-8214516
        throw new KubernetesClientException("JDK HttpClient only support HTTP proxies");
      }
      builder.proxy(ProxySelector.of(proxyAddress));
      addProxyAuthInterceptor();
    }
    if (preferHttp11) {
      builder.version(Version.HTTP_1_1);
    }
    if (tlsVersions != null && tlsVersions.length > 0) {
      builder.sslParameters(new SSLParameters(null,
          Arrays.asList(tlsVersions).stream().map(TlsVersion::javaName).toArray(String[]::new)));
    }
    clientFactory.additionalConfig(builder);
    return new JdkHttpClientImpl(this, builder.build());
  }

  @Override
  protected JdkHttpClientBuilderImpl newInstance(JdkHttpClientFactory clientFactory) {
    return new JdkHttpClientBuilderImpl(clientFactory);
  }

}
