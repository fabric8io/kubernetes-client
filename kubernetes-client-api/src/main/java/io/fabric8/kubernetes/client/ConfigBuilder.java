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

import io.fabric8.kubernetes.api.builder.VisitableBuilder;

import java.util.Optional;

import static io.fabric8.kubernetes.client.Config.disableAutoConfig;

public class ConfigBuilder extends ConfigFluent<ConfigBuilder> implements VisitableBuilder<Config, ConfigBuilder> {
  public ConfigBuilder() {
    this.fluent = this;
  }

  public ConfigBuilder(ConfigFluent<?> fluent) {
    this.fluent = fluent;
  }

  public ConfigBuilder(ConfigFluent<?> fluent, Config instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigBuilder(Config instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }

  ConfigFluent<?> fluent;

  public Config build() {
    Config buildable = new Config(fluent.getMasterUrl(), fluent.getApiVersion(), fluent.getNamespace(), fluent.getTrustCerts(),
        fluent.getDisableHostnameVerification(), fluent.getCaCertFile(), fluent.getCaCertData(), fluent.getClientCertFile(),
        fluent.getClientCertData(), fluent.getClientKeyFile(), fluent.getClientKeyData(), fluent.getClientKeyAlgo(),
        fluent.getClientKeyPassphrase(), fluent.getUsername(), fluent.getPassword(), fluent.getOauthToken(),
        fluent.getAutoOAuthToken(), fluent.getWatchReconnectInterval(), fluent.getWatchReconnectLimit(),
        fluent.getConnectionTimeout(), fluent.getRequestTimeout(), fluent.getScaleTimeout(), fluent.getLoggingInterval(),
        fluent.getMaxConcurrentRequests(), fluent.getMaxConcurrentRequestsPerHost(), fluent.getHttp2Disable(),
        fluent.getHttpProxy(), fluent.getHttpsProxy(), fluent.getNoProxy(), fluent.getUserAgent(), fluent.getTlsVersions(),
        fluent.getWebsocketPingInterval(), fluent.getProxyUsername(), fluent.getProxyPassword(), fluent.getTrustStoreFile(),
        fluent.getTrustStorePassphrase(), fluent.getKeyStoreFile(), fluent.getKeyStorePassphrase(),
        fluent.getImpersonateUsername(), fluent.getImpersonateGroups(), fluent.getImpersonateExtras(),
        fluent.getOauthTokenProvider(), fluent.getCustomHeaders(), fluent.getRequestRetryBackoffLimit(),
        fluent.getRequestRetryBackoffInterval(), fluent.getUploadRequestTimeout(), fluent.getOnlyHttpWatches(),
        fluent.getCurrentContext(), fluent.getContexts(),
        Optional.ofNullable(fluent.getAutoConfigure()).orElse(!disableAutoConfig()), true, fluent.getFiles());
    buildable.setAuthProvider(fluent.getAuthProvider());
    return buildable;
  }
}
