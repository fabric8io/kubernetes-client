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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.OAuthTokenProvider;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.fabric8.kubernetes.client.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.client.readiness.OpenShiftReadiness;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true, allowSetters = true)
public class OpenShiftConfig extends Config {

  public static final String KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY = "kubernetes.oapi.version";
  public static final String OPENSHIFT_URL_SYSTEM_PROPERTY = "openshift.url";
  public static final String OPENSHIFT_BUILD_TIMEOUT_SYSTEM_PROPERTY = "openshift.build.timeout";

  public static final String DISABLE_API_GROUP_CHECK = "disableApiGroupCheck";
  public static final String OPENSHIFT_URL = "openShiftUrl";
  public static final String BUILD_TIMEOUT = "buildTimeout";
  public static final String OAPI_VERSION = "oapiVersion";

  public static final Long DEFAULT_BUILD_TIMEOUT = 5 * 60 * 1000L;

  // dummy fields so that Builder is created correctly
  private String oapiVersion;
  private String openShiftUrl;
  private long buildTimeout;
  private boolean disableApiGroupCheck; //If group hasn't been explicitly set.

  //This is not meant to be used. This constructor is used only by the generated builder.
  OpenShiftConfig() {
  }

  public OpenShiftConfig(Config kubernetesConfig) {
    this(kubernetesConfig,
        getDefaultOpenShiftUrl(kubernetesConfig), getDefaultOapiVersion(kubernetesConfig), DEFAULT_BUILD_TIMEOUT);
  }

  public OpenShiftConfig(Config kubernetesConfig, String openShiftUrl) {
    this(kubernetesConfig,
        getDefaultOpenShiftUrl(kubernetesConfig), getDefaultOapiVersion(kubernetesConfig), DEFAULT_BUILD_TIMEOUT);
    this.setOpenShiftUrl(openShiftUrl);
  }

  @Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", editableEnabled = false, refs = {
      @BuildableReference(Config.class) })
  public OpenShiftConfig(String openShiftUrl, String oapiVersion, String masterUrl, String apiVersion, String namespace,
      boolean trustCerts, boolean disableHostnameVerification, String caCertFile, String caCertData,
      String clientCertFile,
      String clientCertData, String clientKeyFile, String clientKeyData, String clientKeyAlgo,
      String clientKeyPassphrase,
      String username, String password, String oauthToken, String autoOAuthToken, int watchReconnectInterval,
      int watchReconnectLimit,
      int connectionTimeout, int requestTimeout, long scaleTimeout, int loggingInterval,
      int maxConcurrentRequests, int maxConcurrentRequestsPerHost, boolean http2Disable, String httpProxy,
      String httpsProxy,
      String[] noProxy, Map<Integer, String> errorMessages, String userAgent, TlsVersion[] tlsVersions,
      long websocketPingInterval, String proxyUsername, String proxyPassword, String trustStoreFile,
      String trustStorePassphrase, String keyStoreFile, String keyStorePassphrase, String impersonateUsername,
      String[] impersonateGroups, Map<String, List<String>> impersonateExtras, OAuthTokenProvider oauthTokenProvider,
      Map<String, String> customHeaders, int requestRetryBackoffLimit, int requestRetryBackoffInterval,
      int uploadRequestTimeout, long buildTimeout,
      boolean disableApiGroupCheck) {
    super(masterUrl, apiVersion, namespace, trustCerts, disableHostnameVerification, caCertFile, caCertData,
        clientCertFile,
        clientCertData, clientKeyFile, clientKeyData, clientKeyAlgo, clientKeyPassphrase, username, password,
        oauthToken, autoOAuthToken,
        watchReconnectInterval, watchReconnectLimit, connectionTimeout, requestTimeout, scaleTimeout,
        loggingInterval, maxConcurrentRequests, maxConcurrentRequestsPerHost, http2Disable, httpProxy, httpsProxy,
        noProxy,
        errorMessages, userAgent, tlsVersions, websocketPingInterval, proxyUsername, proxyPassword,
        trustStoreFile, trustStorePassphrase, keyStoreFile, keyStorePassphrase, impersonateUsername, impersonateGroups,
        impersonateExtras, oauthTokenProvider, customHeaders,
        requestRetryBackoffLimit,
        requestRetryBackoffInterval,
        uploadRequestTimeout);
    this.setOapiVersion(oapiVersion);
    this.setBuildTimeout(buildTimeout);
    this.setDisableApiGroupCheck(disableApiGroupCheck);

    if (openShiftUrl == null || openShiftUrl.isEmpty()) {
      openShiftUrl = URLUtils.join(getMasterUrl(), "oapi", oapiVersion);
    }
    if (!openShiftUrl.endsWith("/")) {
      openShiftUrl += "/";
    }
    this.setOpenShiftUrl(openShiftUrl);
  }

  public OpenShiftConfig(Config kubernetesConfig, String openShiftUrl, String oapiVersion, long buildTimeout) {
    this(openShiftUrl, oapiVersion,
        kubernetesConfig.getMasterUrl(), kubernetesConfig.getApiVersion(),
        kubernetesConfig.getNamespace(), kubernetesConfig.isTrustCerts(),
        kubernetesConfig.isDisableHostnameVerification(), kubernetesConfig.getCaCertFile(),
        kubernetesConfig.getCaCertData(), kubernetesConfig.getClientCertFile(),
        kubernetesConfig.getClientCertData(), kubernetesConfig.getClientKeyFile(),
        kubernetesConfig.getClientKeyData(), kubernetesConfig.getClientKeyAlgo(),
        kubernetesConfig.getClientKeyPassphrase(),
        kubernetesConfig.getUsername(), kubernetesConfig.getPassword(), kubernetesConfig.getOauthToken(),
        kubernetesConfig.getAutoOAuthToken(), kubernetesConfig.getWatchReconnectInterval(),
        kubernetesConfig.getWatchReconnectLimit(),
        kubernetesConfig.getConnectionTimeout(), kubernetesConfig.getRequestTimeout(),
        kubernetesConfig.getScaleTimeout(),
        kubernetesConfig.getLoggingInterval(), kubernetesConfig.getMaxConcurrentRequests(),
        kubernetesConfig.getMaxConcurrentRequestsPerHost(), kubernetesConfig.isHttp2Disable(),
        kubernetesConfig.getHttpProxy(), kubernetesConfig.getHttpsProxy(), kubernetesConfig.getNoProxy(),
        kubernetesConfig.getErrorMessages(), kubernetesConfig.getUserAgent(),
        kubernetesConfig.getTlsVersions(),
        kubernetesConfig.getWebsocketPingInterval(), kubernetesConfig.getProxyUsername(),
        kubernetesConfig.getProxyPassword(), kubernetesConfig.getTrustStoreFile(),
        kubernetesConfig.getTrustStorePassphrase(), kubernetesConfig.getKeyStoreFile(),
        kubernetesConfig.getKeyStorePassphrase(), kubernetesConfig.getImpersonateUsername(),
        kubernetesConfig.getImpersonateGroups(), kubernetesConfig.getImpersonateExtras(),
        kubernetesConfig.getOauthTokenProvider(), kubernetesConfig.getCustomHeaders(),
        kubernetesConfig.getRequestRetryBackoffLimit(), kubernetesConfig.getRequestRetryBackoffInterval(),
        kubernetesConfig.getUploadRequestTimeout(),
        buildTimeout,
        false);
  }

  public static OpenShiftConfig wrap(Config config) {
    return config instanceof OpenShiftConfig ? (OpenShiftConfig) config : new OpenShiftConfig(config);
  }

  private static String getDefaultOapiVersion(Config config) {
    return Utils.getSystemPropertyOrEnvVar(KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY, config.getApiVersion());
  }

  private static String getDefaultOpenShiftUrl(Config config) {
    String openshiftUrl = Utils.getSystemPropertyOrEnvVar(OPENSHIFT_URL_SYSTEM_PROPERTY);
    if (openshiftUrl != null) {
      // The OPENSHIFT_URL environment variable may be set to the root url (i.e. without the '/oapi/version' path) in some configurations
      if (isRootURL(openshiftUrl)) {
        openshiftUrl = URLUtils.join(openshiftUrl, "oapi", getDefaultOapiVersion(config));
      }
      return openshiftUrl;
    } else {
      return URLUtils.join(config.getMasterUrl(), "oapi", getDefaultOapiVersion(config));
    }
  }

  private static boolean isRootURL(String url) {
    try {
      String path = new URL(url).getPath();
      return "".equals(path) || "/".equals(path);
    } catch (MalformedURLException e) {
      return false;
    }
  }

  @JsonIgnore
  public String getOapiVersion() {
    return (String) this.additionalProperties.getOrDefault(OAPI_VERSION, "v1");
  }

  public void setOapiVersion(String oapiVersion) {
    this.additionalProperties.put(OAPI_VERSION, oapiVersion);
  }

  @JsonIgnore
  public String getOpenShiftUrl() {
    return (String) this.additionalProperties.get(OPENSHIFT_URL);
  }

  public void setOpenShiftUrl(String openShiftUrl) {
    this.additionalProperties.put(OPENSHIFT_URL, openShiftUrl);
  }

  public long getBuildTimeout() {
    return (long) this.additionalProperties.getOrDefault(BUILD_TIMEOUT, DEFAULT_BUILD_TIMEOUT);
  }

  public void setBuildTimeout(long buildTimeout) {
    this.additionalProperties.put(BUILD_TIMEOUT, buildTimeout);
  }

  @JsonIgnore
  public boolean isDisableApiGroupCheck() {
    return Boolean.TRUE.equals(additionalProperties.get(DISABLE_API_GROUP_CHECK));
  }

  public void setDisableApiGroupCheck(boolean disableApiGroupCheck) {
    this.additionalProperties.put(DISABLE_API_GROUP_CHECK, disableApiGroupCheck);
  }

  @Override
  public Readiness getReadiness() {
    return OpenShiftReadiness.getInstance();
  }

}
