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

package io.fabric8.openshift.client;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

import java.util.Map;

public class OpenShiftConfig extends Config {

  public static final String KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY = "kubernetes.oapi.version";
  public static final String OPENSHIFT_URL_SYTEM_PROPERTY = "openshift.url";

  private String oapiVersion = "v1";
  private String openShiftUrl;

  //This is not meant to be used. This constructor is used only by the generated builder.
  OpenShiftConfig() {
  }

  public OpenShiftConfig(Config kubernetesConfig) {
    this(kubernetesConfig,
      getDefaultOpenShiftUrl(kubernetesConfig), getDefaultOapiVersion(kubernetesConfig)
    );
  }

  @Buildable(builderPackage = "io.fabric8.kubernetes.api.builder",
    refs = {@BuildableReference(Config.class)}
  )
  public OpenShiftConfig(String openShiftUrl, String oapiVersion, String masterUrl, String apiVersion, String namespace, Boolean trustCerts, String caCertFile, String caCertData, String clientCertFile, String clientCertData, String clientKeyFile, String clientKeyData, String clientKeyAlgo, String clientKeyPassphrase, String username, String password, String oauthToken, int watchReconnectInterval, int watchReconnectLimit, int connectionTimeout, int requestTimeout, long rollingTimeout, int loggingInterval, String httpProxy, String httpsProxy, String[] noProxy, Map<Integer, String> errorMessages, String userAgent) {
    super(masterUrl, apiVersion, namespace, trustCerts, caCertFile, caCertData, clientCertFile, clientCertData, clientKeyFile, clientKeyData, clientKeyAlgo, clientKeyPassphrase, username, password, oauthToken, watchReconnectInterval, watchReconnectLimit, connectionTimeout, requestTimeout, rollingTimeout, loggingInterval, httpProxy, httpsProxy, noProxy, errorMessages, userAgent);
    this.oapiVersion = oapiVersion;
    this.openShiftUrl = openShiftUrl;

    if (this.openShiftUrl == null || this.openShiftUrl.isEmpty()) {
      this.openShiftUrl = URLUtils.join(getMasterUrl(), "oapi", this.oapiVersion);
    }
    if (!this.openShiftUrl.endsWith("/")) {
      this.openShiftUrl = this.openShiftUrl + "/";
    }
  }

  public OpenShiftConfig(Config kubernetesConfig, String openShiftUrl, String oapiVersion) {
    this(openShiftUrl, oapiVersion, kubernetesConfig.getMasterUrl(), kubernetesConfig.getApiVersion(), kubernetesConfig.getNamespace(), kubernetesConfig.isTrustCerts(),
      kubernetesConfig.getCaCertFile(), kubernetesConfig.getCaCertData(),
      kubernetesConfig.getClientCertFile(), kubernetesConfig.getClientCertData(),
      kubernetesConfig.getClientKeyFile(), kubernetesConfig.getClientKeyData(),
      kubernetesConfig.getClientKeyAlgo(), kubernetesConfig.getClientKeyPassphrase(),
      kubernetesConfig.getUsername(), kubernetesConfig.getPassword(), kubernetesConfig.getOauthToken(),
      kubernetesConfig.getWatchReconnectInterval(), kubernetesConfig.getWatchReconnectLimit(),
      kubernetesConfig.getConnectionTimeout(), kubernetesConfig.getRequestTimeout(),
      kubernetesConfig.getRollingTimeout(), kubernetesConfig.getLoggingInterval(),
      kubernetesConfig.getHttpProxy(),
      kubernetesConfig.getHttpsProxy(),
      kubernetesConfig.getNoProxy(),
      kubernetesConfig.getErrorMessages(),
      kubernetesConfig.getUserAgent()
      );
  }

  public static OpenShiftConfig wrap(Config config) {
    return config instanceof OpenShiftConfig ? (OpenShiftConfig) config : new OpenShiftConfig(config);
  }

  private static String getDefaultOapiVersion(Config config) {
    return Utils.getSystemPropertyOrEnvVar(KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY, config.getApiVersion());
  }

  private static String getDefaultOpenShiftUrl(Config config) {
    return Utils.getSystemPropertyOrEnvVar(OPENSHIFT_URL_SYTEM_PROPERTY, URLUtils.join(config.getMasterUrl(), "oapi", getDefaultOapiVersion(config)));
  }

  public String getOapiVersion() {
    return oapiVersion;
  }

  public void setOapiVersion(String oapiVersion) {
    this.oapiVersion = oapiVersion;
  }

  public String getOpenShiftUrl() {
    return openShiftUrl;
  }

  public void setOpenShiftUrl(String openShiftUrl) {
    this.openShiftUrl = openShiftUrl;
  }
}
