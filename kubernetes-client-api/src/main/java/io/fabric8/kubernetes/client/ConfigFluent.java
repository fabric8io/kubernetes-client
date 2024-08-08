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
      this.withFile(instance.getFile());
    }
  }
}
