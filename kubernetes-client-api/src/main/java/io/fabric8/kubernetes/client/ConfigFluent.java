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

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigFluent<A extends ConfigFluent<A>> extends SundrioConfigFluent<A> {
  public ConfigFluent() {
    super();
  }

  public ConfigFluent(Config instance) {
    super();
    this.copyInstance(instance);
  }

  public void copyInstance(Config instance) {
    if (instance != null) {
      this.withMasterUrl(instance.getMasterUrl());
      this.withApiVersion(instance.getApiVersion());
      this.withNamespace(instance.getNamespace());
      this.withTrustCerts(instance.isTrustCerts());
      this.withDisableHostnameVerification(instance.isDisableHostnameVerification());
      this.withCaCertFile(instance.getCaCertFile());
      this.withCaCertData(instance.getCaCertData());
      this.withClientCertFile(instance.getClientCertFile());
      this.withClientCertData(instance.getClientCertData());
      this.withClientKeyFile(instance.getClientKeyFile());
      this.withClientKeyData(instance.getClientKeyData());
      this.withClientKeyAlgo(instance.getClientKeyAlgo());
      this.withClientKeyPassphrase(instance.getClientKeyPassphrase());
      this.withUsername(instance.getUsername());
      this.withPassword(instance.getPassword());
      this.withOauthToken(instance.getOauthToken());
      this.withAutoOAuthToken(instance.getAutoOAuthToken());
      this.withWatchReconnectInterval(instance.getWatchReconnectInterval());
      this.withWatchReconnectLimit(instance.getWatchReconnectLimit());
      this.withConnectionTimeout(instance.getConnectionTimeout());
      this.withRequestTimeout(instance.getRequestTimeout());
      this.withScaleTimeout(instance.getScaleTimeout());
      this.withLoggingInterval(instance.getLoggingInterval());
      this.withMaxConcurrentRequests(instance.getMaxConcurrentRequests());
      this.withMaxConcurrentRequestsPerHost(instance.getMaxConcurrentRequestsPerHost());
      this.withHttp2Disable(instance.isHttp2Disable());
      this.withHttpProxy(instance.getHttpProxy());
      this.withHttpsProxy(instance.getHttpsProxy());
      this.withNoProxy(instance.getNoProxy());
      this.withUserAgent(instance.getUserAgent());
      this.withTlsVersions(instance.getTlsVersions());
      this.withWebsocketPingInterval(instance.getWebsocketPingInterval());
      this.withProxyUsername(instance.getProxyUsername());
      this.withProxyPassword(instance.getProxyPassword());
      this.withTrustStoreFile(instance.getTrustStoreFile());
      this.withTrustStorePassphrase(instance.getTrustStorePassphrase());
      this.withKeyStoreFile(instance.getKeyStoreFile());
      this.withKeyStorePassphrase(instance.getKeyStorePassphrase());
      this.withImpersonateUsername(instance.getImpersonateUsername());
      this.withImpersonateGroups(instance.getImpersonateGroups());
      this.withImpersonateExtras(instance.getImpersonateExtras());
      this.withOauthTokenProvider(instance.getOauthTokenProvider());
      this.withCustomHeaders(instance.getCustomHeaders());
      this.withRequestRetryBackoffLimit(instance.getRequestRetryBackoffLimit());
      this.withRequestRetryBackoffInterval(instance.getRequestRetryBackoffInterval());
      this.withUploadRequestTimeout(instance.getUploadRequestTimeout());
      this.withOnlyHttpWatches(instance.isOnlyHttpWatches());
      this.withCurrentContext(instance.getCurrentContext());
      this.withContexts(instance.getContexts());
      this.withAutoConfigure(instance.getAutoConfigure());
      this.withAuthProvider(instance.getAuthProvider());
      this.withKubeConfigFiles(instance.getKubeConfigFiles());
    }
  }

  // Fix #https://github.com/fabric8io/kubernetes-client/issues/6249
  // Unboxed builder methods (should allow for the co-existience of <6.13.2 and 6.13.x)
  public A withTrustCerts(boolean trustCerts) {
    return this.withTrustCerts(Boolean.valueOf(trustCerts));
  }

  public A withDisableHostnameVerification(boolean disableHostnameVerification) {
    return this.withDisableHostnameVerification(Boolean.valueOf(disableHostnameVerification));
  }

  public A withWebsocketPingInterval(long websocketPingInterval) {
    return this.withWebsocketPingInterval(Long.valueOf(websocketPingInterval));
  }

  public A withConnectionTimeout(int connectionTimeout) {
    return this.withConnectionTimeout(Integer.valueOf(connectionTimeout));
  }

  public A withMaxConcurrentRequests(int maxConcurrentRequests) {
    return this.withMaxConcurrentRequests(Integer.valueOf(maxConcurrentRequests));
  }

  public A withWatchReconnectInterval(int watchReconnectInterval) {
    return this.withWatchReconnectInterval(Integer.valueOf(watchReconnectInterval));
  }

  public A withWatchReconnectLimit(int watchReconnectLimit) {
    return this.withWatchReconnectLimit(Integer.valueOf(watchReconnectLimit));
  }

  public A withUploadRequestTimeout(int uploadRequestTimeout) {
    return this.withUploadRequestTimeout(Integer.valueOf(uploadRequestTimeout));
  }

  public A withRequestRetryBackoffLimit(int requestRetryBackoffLimit) {
    return this.withRequestRetryBackoffLimit(Integer.valueOf(requestRetryBackoffLimit));
  }

  public A withRequestRetryBackoffInterval(int requestRetryBackoffInterval) {
    return this.withRequestRetryBackoffInterval(Integer.valueOf(requestRetryBackoffInterval));
  }

  public A withRequestTimeout(int requestTimeout) {
    return this.withRequestTimeout(Integer.valueOf(requestTimeout));
  }

  public A withScaleTimeout(long scaleTimeout) {
    return this.withScaleTimeout(Long.valueOf(scaleTimeout));
  }

  public A withLoggingInterval(int loggingInterval) {
    return this.withLoggingInterval(Integer.valueOf(loggingInterval));
  }

  public A withHttp2Disable(boolean http2Disable) {
    return this.withHttp2Disable(Boolean.valueOf(http2Disable));
  }

  public A withOnlyHttpWatches(boolean onlyHttpWatches) {
    return this.withOnlyHttpWatches(Boolean.valueOf(onlyHttpWatches));
  }

  public A withAutoConfigure(boolean autoConfigure) {
    return this.withAutoConfigure(Boolean.valueOf(autoConfigure));
  }

  public A withFiles(File... files) {
    if (files != null
        && files.length > 0) {
      List<KubeConfigFile> configFiles = Arrays.stream(files)
          .map(KubeConfigFile::new)
          .collect(Collectors.toList());
      withKubeConfigFiles(configFiles);
    }
    return (A) this;
  }

}
