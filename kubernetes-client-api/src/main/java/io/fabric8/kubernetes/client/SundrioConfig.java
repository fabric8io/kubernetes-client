/*
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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.NamedContext;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.sundr.builder.annotations.Buildable;

import java.util.List;
import java.util.Map;

/**
 * This class is necessary to be able to autogenerate a builder for the Config class using Sundrio while providing
 * specific behavior for the build() method.
 *
 * This way we can extend the default SundrioConfigBuilder, overriding the build method and enabling autoconfiguration only in
 * this case.
 *
 * The builder is also capable of having a state of the Config with null values (no defaults or autoconfigured).
 *
 * The end purpose is for users to actually use the builder to override the default values or autoconfigured ones
 * by providing their values through the builder withXxx accessors
 */
class SundrioConfig extends Config {
  @Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", editableEnabled = false)
  public SundrioConfig(String masterUrl, String apiVersion, String namespace, Boolean trustCerts,
      Boolean disableHostnameVerification,
      String caCertFile, String caCertData, String clientCertFile, String clientCertData, String clientKeyFile,
      String clientKeyData, String clientKeyAlgo, String clientKeyPassphrase, String username, String password,
      String oauthToken, String autoOAuthToken, Integer watchReconnectInterval, Integer watchReconnectLimit,
      Integer connectionTimeout,
      Integer requestTimeout,
      Long scaleTimeout, Integer loggingInterval, Integer maxConcurrentRequests, Integer maxConcurrentRequestsPerHost,
      Boolean http2Disable, String httpProxy, String httpsProxy, String[] noProxy,
      String userAgent, TlsVersion[] tlsVersions, Long websocketPingInterval, String proxyUsername,
      String proxyPassword, String trustStoreFile, String trustStorePassphrase, String keyStoreFile, String keyStorePassphrase,
      String impersonateUsername, String[] impersonateGroups, Map<String, List<String>> impersonateExtras,
      OAuthTokenProvider oauthTokenProvider, Map<String, String> customHeaders, Integer requestRetryBackoffLimit,
      Integer requestRetryBackoffInterval, Integer uploadRequestTimeout, Boolean onlyHttpWatches, NamedContext currentContext,
      List<NamedContext> contexts, Boolean autoConfigure, List<KubeConfigFile> kubeConfigFiles) {
    super(masterUrl, apiVersion, namespace, trustCerts, disableHostnameVerification, caCertFile, caCertData,
        clientCertFile, clientCertData, clientKeyFile, clientKeyData, clientKeyAlgo, clientKeyPassphrase, username,
        password, oauthToken, autoOAuthToken, watchReconnectInterval, watchReconnectLimit, connectionTimeout, requestTimeout,
        scaleTimeout, loggingInterval, maxConcurrentRequests, maxConcurrentRequestsPerHost, http2Disable,
        httpProxy, httpsProxy, noProxy, userAgent, tlsVersions, websocketPingInterval, proxyUsername, proxyPassword,
        trustStoreFile, trustStorePassphrase, keyStoreFile, keyStorePassphrase, impersonateUsername, impersonateGroups,
        impersonateExtras, oauthTokenProvider, customHeaders, requestRetryBackoffLimit, requestRetryBackoffInterval,
        uploadRequestTimeout, onlyHttpWatches, currentContext, contexts, autoConfigure, true, kubeConfigFiles);
  }

}
