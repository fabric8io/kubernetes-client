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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.fabric8.kubernetes.client.internal.CertUtils;
import io.fabric8.kubernetes.client.internal.KubeConfigUtils;
import io.fabric8.kubernetes.client.internal.SSLUtils;
import io.fabric8.kubernetes.client.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.IOHelpers;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@SuppressWarnings({ "LombokGetterMayBeUsed", "LombokSetterMayBeUsed" })
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(allowGetters = true, allowSetters = true)
public class Config extends SundrioConfig {

  private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);

  /**
   * Disables autoconfiguration based on opinionated defaults in a {@link Config} object in the all arguments constructor
   */
  public static final String KUBERNETES_DISABLE_AUTO_CONFIG_SYSTEM_PROPERTY = "kubernetes.disable.autoConfig";
  public static final String KUBERNETES_MASTER_SYSTEM_PROPERTY = "kubernetes.master";
  public static final String KUBERNETES_API_VERSION_SYSTEM_PROPERTY = "kubernetes.api.version";
  public static final String KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY = "kubernetes.trust.certificates";
  public static final String KUBERNETES_DISABLE_HOSTNAME_VERIFICATION_SYSTEM_PROPERTY = "kubernetes.disable.hostname.verification";
  public static final String KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY = "kubernetes.certs.ca.file";
  public static final String KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY = "kubernetes.certs.ca.data";
  public static final String KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY = "kubernetes.certs.client.file";
  public static final String KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY = "kubernetes.certs.client.data";
  public static final String KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY = "kubernetes.certs.client.key.file";
  public static final String KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY = "kubernetes.certs.client.key.data";
  public static final String KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY = "kubernetes.certs.client.key.algo";
  public static final String KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY = "kubernetes.certs.client.key.passphrase";
  public static final String KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY = "kubernetes.auth.basic.username";
  public static final String KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY = "kubernetes.auth.basic.password";
  public static final String KUBERNETES_AUTH_TRYKUBECONFIG_SYSTEM_PROPERTY = "kubernetes.auth.tryKubeConfig";
  public static final String KUBERNETES_AUTH_TRYSERVICEACCOUNT_SYSTEM_PROPERTY = "kubernetes.auth.tryServiceAccount";
  public static final String KUBERNETES_AUTH_SERVICEACCOUNT_TOKEN_FILE_SYSTEM_PROPERTY = "kubernetes.auth.serviceAccount.token";
  public static final String KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY = "kubernetes.auth.token";
  public static final String KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY = "kubernetes.watch.reconnectInterval";
  public static final String KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY = "kubernetes.watch.reconnectLimit";
  public static final String KUBERNETES_CONNECTION_TIMEOUT_SYSTEM_PROPERTY = "kubernetes.connection.timeout";
  public static final String KUBERNETES_UPLOAD_REQUEST_TIMEOUT_SYSTEM_PROPERTY = "kubernetes.upload.request.timeout";
  public static final String KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY = "kubernetes.request.timeout";
  public static final String KUBERNETES_REQUEST_RETRY_BACKOFFLIMIT_SYSTEM_PROPERTY = "kubernetes.request.retry.backoffLimit";
  public static final String KUBERNETES_REQUEST_RETRY_BACKOFFINTERVAL_SYSTEM_PROPERTY = "kubernetes.request.retry.backoffInterval";
  public static final String KUBERNETES_LOGGING_INTERVAL_SYSTEM_PROPERTY = "kubernetes.logging.interval";
  public static final String KUBERNETES_SCALE_TIMEOUT_SYSTEM_PROPERTY = "kubernetes.scale.timeout";
  public static final String KUBERNETES_WEBSOCKET_PING_INTERVAL_SYSTEM_PROPERTY = "kubernetes.websocket.ping.interval";
  public static final String KUBERNETES_MAX_CONCURRENT_REQUESTS = "kubernetes.max.concurrent.requests";
  public static final String KUBERNETES_MAX_CONCURRENT_REQUESTS_PER_HOST = "kubernetes.max.concurrent.requests.per.host";

  public static final String KUBERNETES_IMPERSONATE_USERNAME = "kubernetes.impersonate.username";
  public static final String KUBERNETES_IMPERSONATE_GROUP = "kubernetes.impersonate.group";

  public static final String KUBERNETES_TRUSTSTORE_PASSPHRASE_PROPERTY = "kubernetes.truststore.passphrase";
  public static final String KUBERNETES_TRUSTSTORE_FILE_PROPERTY = "kubernetes.truststore.file";
  public static final String KUBERNETES_KEYSTORE_PASSPHRASE_PROPERTY = "kubernetes.keystore.passphrase";
  public static final String KUBERNETES_KEYSTORE_FILE_PROPERTY = "kubernetes.keystore.file";

  public static final String KUBERNETES_TLS_VERSIONS = "kubernetes.tls.versions";

  public static final String KUBERNETES_TRYNAMESPACE_PATH_SYSTEM_PROPERTY = "kubernetes.tryNamespacePath";
  public static final String KUBERNETES_NAMESPACE_PATH = "/var/run/secrets/kubernetes.io/serviceaccount/namespace";
  public static final String KUBERNETES_NAMESPACE_FILE = "kubenamespace";
  public static final String KUBERNETES_NAMESPACE_SYSTEM_PROPERTY = "kubernetes.namespace";
  public static final String KUBERNETES_KUBECONFIG_FILE = "kubeconfig";
  public static final String KUBERNETES_SERVICE_HOST_PROPERTY = "KUBERNETES_SERVICE_HOST";
  public static final String KUBERNETES_SERVICE_PORT_PROPERTY = "KUBERNETES_SERVICE_PORT";
  public static final String KUBERNETES_SERVICE_ACCOUNT_TOKEN_PATH = "/var/run/secrets/kubernetes.io/serviceaccount/token";
  public static final String KUBERNETES_SERVICE_ACCOUNT_CA_CRT_PATH = "/var/run/secrets/kubernetes.io/serviceaccount/ca.crt";
  public static final String KUBERNETES_HTTP2_DISABLE = "http2.disable";
  public static final String KUBERNETES_HTTP_PROXY = "http.proxy";
  public static final String KUBERNETES_HTTPS_PROXY = "https.proxy";
  public static final String KUBERNETES_ALL_PROXY = "all.proxy";
  public static final String KUBERNETES_NO_PROXY = "no.proxy";
  public static final String KUBERNETES_PROXY_USERNAME = "proxy.username";
  public static final String KUBERNETES_PROXY_PASSWORD = "proxy.password";

  public static final String KUBERNETES_USER_AGENT = "kubernetes.user.agent";

  public static final String DEFAULT_MASTER_URL = "https://kubernetes.default.svc";
  public static final Long DEFAULT_SCALE_TIMEOUT = 10 * 60 * 1000L;
  public static final int DEFAULT_REQUEST_TIMEOUT = 10 * 1000;
  public static final int DEFAULT_LOGGING_INTERVAL = 20 * 1000;
  public static final Long DEFAULT_WEBSOCKET_PING_INTERVAL = 30 * 1000L;

  public static final Integer DEFAULT_MAX_CONCURRENT_REQUESTS = 64;
  public static final Integer DEFAULT_MAX_CONCURRENT_REQUESTS_PER_HOST = 5;

  public static final Integer DEFAULT_REQUEST_RETRY_BACKOFFLIMIT = 10;
  public static final Integer DEFAULT_REQUEST_RETRY_BACKOFFINTERVAL = 100;

  public static final int DEFAULT_UPLOAD_REQUEST_TIMEOUT = 120 * 1000;

  public static final String HTTP_PROTOCOL_PREFIX = "http://";
  public static final String HTTPS_PROTOCOL_PREFIX = "https://";
  public static final String SOCKS5_PROTOCOL_PREFIX = "socks5://";

  private static final int DEFAULT_WATCH_RECONNECT_INTERVAL = 1000;
  private static final int DEFAULT_CONNECTION_TIMEOUT = 10 * 1000;
  private static final String DEFAULT_CLIENT_KEY_PASSPHRASE = "changeit";

  private RequestConfig requestConfig = new RequestConfig(null, null, null, null, null, null, null, null);

  protected static boolean disableAutoConfig() {
    return Utils.getSystemPropertyOrEnvVar(KUBERNETES_DISABLE_AUTO_CONFIG_SYSTEM_PROPERTY, false);
  }

  /**
   * Create an empty {@link Config} class without any automatic configuration
   * (i.e. reading system properties/environment variables to set values).
   * <p>
   * The configuration does include the Kubernetes Client default values for timeouts, etc.
   * <p>
   * You can also reuse this object to build your own {@link Config} object
   * without any auto configuration like this:
   *
   * <pre>{@code
   * Config configFromBuilder = new ConfigBuilder(Config.empty())
   *                                // ...
   *                               .build();
   * }</pre>
   *
   * @return a Config object without any automatic configuration.
   */
  public static Config empty() {
    return new Config(false);
  }

  /**
   * Does auto-detection with some opinionated defaults.
   *
   * @param context if null will use current-context
   * @return Config object
   */
  public static Config autoConfigure(String context) {
    final Config config = new Config(false);
    autoConfigure(config, context);
    return config;
  }

  private static void autoConfigure(Config config, String context) {
    final var kubeConfigFiles = findKubeConfigFiles();
    if (!kubeConfigFiles.isEmpty()) {
      final var kubeconfigs = kubeConfigFiles.stream()
          .map(KubeConfigUtils::parseConfig)
          .toArray(io.fabric8.kubernetes.api.model.Config[]::new);
      KubeConfigUtils.merge(config, context, kubeconfigs);
    } else {
      tryServiceAccount(config);
      tryNamespaceFromPath(config);
    }
    postAutoConfigure(config);
    config.autoConfigure = true;
  }

  private static void postAutoConfigure(Config config) {
    configFromSysPropsOrEnvVars(config);
  }

  private static String ensureEndsWithSlash(String masterUrl) {
    if (!masterUrl.endsWith("/")) {
      masterUrl = masterUrl + "/";
    }
    return masterUrl;
  }

  private static String ensureHttps(String masterUrl, Config config) {
    if (!masterUrl.toLowerCase(Locale.ROOT).startsWith(HTTP_PROTOCOL_PREFIX)
        && !masterUrl.toLowerCase(Locale.ROOT).startsWith(HTTPS_PROTOCOL_PREFIX)) {
      masterUrl = (SSLUtils.isHttpsAvailable(config) ? HTTPS_PROTOCOL_PREFIX : HTTP_PROTOCOL_PREFIX) + masterUrl;
    }
    return masterUrl;
  }

  protected Config(boolean autoConfigure) {
    this(new SundrioConfigBuilder().withAutoConfigure(autoConfigure).build(), true);
  }

  protected Config() {
  }

  /**
   * Please use {@link ConfigBuilder} or static factory methods to create new instances.
   * <p>
   * All arguments constructor (only for serialization purposes).
   * 
   * @param config delegate configuration for deserialization.
   */
  @JsonCreator(mode = Mode.DELEGATING)
  public Config(SundrioConfig config) {
    this(config, true);
  }

  /*
   * The Builder is generated in SundrioConfig, if new fields need to be added here, please make sure to add them there too.
   */
  protected Config(SundrioConfig config, Boolean shouldSetDefaultValues) {
    if (Boolean.TRUE.equals(shouldSetDefaultValues)) {
      this.setMasterUrl(DEFAULT_MASTER_URL);
      this.apiVersion = "v1";
      this.defaultNamespace = true;
      this.trustCerts = false;
      this.disableHostnameVerification = false;
      this.onlyHttpWatches = false;
      this.http2Disable = false;
      this.clientKeyAlgo = "RSA";
      this.clientKeyPassphrase = DEFAULT_CLIENT_KEY_PASSPHRASE;
      this.websocketPingInterval = DEFAULT_WEBSOCKET_PING_INTERVAL;
      this.connectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
      this.maxConcurrentRequests = DEFAULT_MAX_CONCURRENT_REQUESTS;
      this.maxConcurrentRequestsPerHost = DEFAULT_MAX_CONCURRENT_REQUESTS_PER_HOST;
      this.contexts = new ArrayList<>();
      this.watchReconnectInterval = DEFAULT_WATCH_RECONNECT_INTERVAL;
      this.watchReconnectLimit = -1;
      this.uploadRequestTimeout = DEFAULT_UPLOAD_REQUEST_TIMEOUT;
      this.requestRetryBackoffInterval = DEFAULT_REQUEST_RETRY_BACKOFFINTERVAL;
      this.requestRetryBackoffLimit = DEFAULT_REQUEST_RETRY_BACKOFFLIMIT;
      this.requestTimeout = DEFAULT_REQUEST_TIMEOUT;
      this.scaleTimeout = DEFAULT_SCALE_TIMEOUT;
      this.loggingInterval = DEFAULT_LOGGING_INTERVAL;
      this.userAgent = "fabric8-kubernetes-client/" + Version.clientVersion();
      this.tlsVersions = new TlsVersion[] { TlsVersion.TLS_1_3, TlsVersion.TLS_1_2 };
      this.requestConfig = new RequestConfig(this.watchReconnectLimit, this.watchReconnectInterval,
          this.requestTimeout, this.scaleTimeout, this.loggingInterval,
          this.requestRetryBackoffLimit, this.requestRetryBackoffInterval, this.uploadRequestTimeout);
    }

    if (Boolean.TRUE.equals(config.autoConfigure)) {
      autoConfigure(this, null);
    }
    if (Utils.isNotNullOrEmpty(config.apiVersion)) {
      this.apiVersion = config.apiVersion;
    }
    if (Utils.isNotNullOrEmpty(config.masterUrl)) {
      this.setMasterUrl(config.masterUrl);
    }
    if (Utils.isNotNullOrEmpty(config.namespace)) {
      this.namespace = config.namespace;
    }
    if (Boolean.TRUE.equals(config.trustCerts)) {
      this.trustCerts = true;
    }
    if (Boolean.TRUE.equals(config.disableHostnameVerification)) {
      this.disableHostnameVerification = true;
    }
    if (Utils.isNotNullOrEmpty(config.caCertFile)) {
      this.caCertFile = config.caCertFile;
    }
    if (Utils.isNotNullOrEmpty(config.caCertData)) {
      this.caCertData = config.caCertData;
    }
    if (Utils.isNotNullOrEmpty(config.clientCertFile)) {
      this.clientCertFile = config.clientCertFile;
    }
    if (Utils.isNotNullOrEmpty(config.clientCertData)) {
      this.clientCertData = config.clientCertData;
    }
    if (Utils.isNotNullOrEmpty(config.clientKeyFile)) {
      this.clientKeyFile = config.clientKeyFile;
    }
    if (Utils.isNotNullOrEmpty(config.clientKeyData)) {
      this.clientKeyData = config.clientKeyData;
    }
    if (Utils.isNotNullOrEmpty(config.clientKeyAlgo)) {
      this.clientKeyAlgo = config.clientKeyAlgo;
    }
    if (Utils.isNotNullOrEmpty(config.clientKeyPassphrase)) {
      this.clientKeyPassphrase = config.clientKeyPassphrase;
    }
    if (Utils.isNotNullOrEmpty(config.username)) {
      this.username = config.username;
    }
    if (Utils.isNotNullOrEmpty(config.password)) {
      this.password = config.password;
    }
    if (Utils.isNotNullOrEmpty(config.oauthToken)) {
      this.oauthToken = config.oauthToken;
    }
    if (config.websocketPingInterval != null) {
      this.websocketPingInterval = config.websocketPingInterval;
    }
    if (config.connectionTimeout != null) {
      this.connectionTimeout = config.connectionTimeout;
    }
    if (config.watchReconnectLimit != null) {
      setWatchReconnectLimit(config.watchReconnectLimit);
    }
    if (config.watchReconnectInterval != null) {
      setWatchReconnectInterval(config.watchReconnectInterval);
    }
    if (config.requestTimeout != null) {
      setRequestTimeout(config.requestTimeout);
    }
    if (config.scaleTimeout != null) {
      setScaleTimeout(config.scaleTimeout);
    }
    if (config.loggingInterval != null) {
      setLoggingInterval(config.loggingInterval);
    }
    if (config.requestRetryBackoffLimit != null) {
      setRequestRetryBackoffLimit(config.requestRetryBackoffLimit);
    }
    if (config.requestRetryBackoffInterval != null) {
      setRequestRetryBackoffInterval(config.requestRetryBackoffInterval);
    }
    if (config.uploadRequestTimeout != null) {
      setUploadRequestTimeout(config.uploadRequestTimeout);
    }
    if (Utils.isNotNullOrEmpty(config.impersonateUsername)) {
      setImpersonateUsername(config.impersonateUsername);
    }
    if (Utils.isNotNullOrEmpty(config.impersonateGroups)) {
      setImpersonateGroups(config.impersonateGroups);
    }
    if (Utils.isNotNullOrEmpty(config.impersonateExtras)) {
      setImpersonateExtras(config.impersonateExtras);
    }
    if (config.http2Disable != null) {
      this.http2Disable = config.http2Disable;
    }
    if (Utils.isNotNullOrEmpty(config.httpProxy)) {
      this.httpProxy = config.httpProxy;
    }
    if (Utils.isNotNullOrEmpty(config.httpsProxy)) {
      this.httpsProxy = config.httpsProxy;
    }
    if (Utils.isNotNullOrEmpty(config.noProxy)) {
      this.noProxy = config.noProxy;
    }
    if (Utils.isNotNullOrEmpty(config.proxyUsername)) {
      this.proxyUsername = config.proxyUsername;
    }
    if (Utils.isNotNullOrEmpty(config.proxyPassword)) {
      this.proxyPassword = config.proxyPassword;
    }
    if (Utils.isNotNullOrEmpty(config.userAgent)) {
      this.userAgent = config.userAgent;
    }
    if (config.tlsVersions != null && config.tlsVersions.length > 0) {
      this.tlsVersions = config.tlsVersions;
    }
    if (Utils.isNotNullOrEmpty(config.trustStoreFile)) {
      this.trustStoreFile = config.trustStoreFile;
    }
    if (Utils.isNotNullOrEmpty(config.trustStorePassphrase)) {
      this.trustStorePassphrase = config.trustStorePassphrase;
    }
    if (Utils.isNotNullOrEmpty(config.keyStoreFile)) {
      this.keyStoreFile = config.keyStoreFile;
    }
    if (Utils.isNotNullOrEmpty(config.keyStorePassphrase)) {
      this.keyStorePassphrase = config.keyStorePassphrase;
    }
    if (config.maxConcurrentRequests != null) {
      this.maxConcurrentRequests = config.maxConcurrentRequests;
    }
    if (config.maxConcurrentRequestsPerHost != null) {
      this.maxConcurrentRequestsPerHost = config.maxConcurrentRequestsPerHost;
    }
    if (Utils.isNotNullOrEmpty(config.autoOAuthToken)) {
      this.autoOAuthToken = config.autoOAuthToken;
    }
    if (config.contexts != null && !config.contexts.isEmpty()) {
      this.contexts = config.contexts;
    }
    if (Utils.isNotNull(config.currentContext)) {
      this.currentContext = config.currentContext;
    }
    if (Utils.isNotNullOrEmpty(config.masterUrl)) {
      setMasterUrl(config.masterUrl);
    }
    this.autoConfigure = config.autoConfigure;
    this.oauthTokenProvider = config.oauthTokenProvider;
    this.customHeaders = config.customHeaders;
    if (config.onlyHttpWatches != null) {
      this.onlyHttpWatches = config.onlyHttpWatches;
    }
    this.authProvider = config.authProvider;
    if (config.additionalProperties != null) {
      this.additionalProperties = new LinkedHashMap<String, Object>(config.additionalProperties);
    }
    if (config.defaultNamespace != null) {
      this.defaultNamespace = config.defaultNamespace;
    }
    if (config.watchList != null) {
      this.watchList = config.watchList;
    }
  }

  public static void configFromSysPropsOrEnvVars(Config config) {
    config.setTrustCerts(Utils.getSystemPropertyOrEnvVar(KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY, config.isTrustCerts()));
    config.setDisableHostnameVerification(Utils.getSystemPropertyOrEnvVar(
        KUBERNETES_DISABLE_HOSTNAME_VERIFICATION_SYSTEM_PROPERTY, config.isDisableHostnameVerification()));
    config.setMasterUrl(Utils.getSystemPropertyOrEnvVar(KUBERNETES_MASTER_SYSTEM_PROPERTY, config.getMasterUrl()));
    config.setApiVersion(Utils.getSystemPropertyOrEnvVar(KUBERNETES_API_VERSION_SYSTEM_PROPERTY, config.getApiVersion()));
    config.setNamespace(Utils.getSystemPropertyOrEnvVar(KUBERNETES_NAMESPACE_SYSTEM_PROPERTY, config.getNamespace()));
    config
        .setCaCertFile(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY, config.getCaCertFile()));
    config
        .setCaCertData(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY, config.getCaCertData()));
    config.setClientCertFile(
        Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY, config.getClientCertFile()));
    config.setClientCertData(
        Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY, config.getClientCertData()));
    config.setClientKeyFile(
        Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY, config.getClientKeyFile()));
    config.setClientKeyData(
        Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY, config.getClientKeyData()));
    config.setClientKeyAlgo(getKeyAlgorithm(config.getClientKeyFile(), config.getClientKeyData()));
    config.setClientKeyPassphrase(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY,
        config.getClientKeyPassphrase()));
    config.setUserAgent(Utils.getSystemPropertyOrEnvVar(KUBERNETES_USER_AGENT, config.getUserAgent()));

    config.setTrustStorePassphrase(
        Utils.getSystemPropertyOrEnvVar(KUBERNETES_TRUSTSTORE_PASSPHRASE_PROPERTY, config.getTrustStorePassphrase()));
    config.setTrustStoreFile(Utils.getSystemPropertyOrEnvVar(KUBERNETES_TRUSTSTORE_FILE_PROPERTY, config.getTrustStoreFile()));
    config.setKeyStorePassphrase(
        Utils.getSystemPropertyOrEnvVar(KUBERNETES_KEYSTORE_PASSPHRASE_PROPERTY, config.getKeyStorePassphrase()));
    config.setKeyStoreFile(Utils.getSystemPropertyOrEnvVar(KUBERNETES_KEYSTORE_FILE_PROPERTY, config.getKeyStoreFile()));

    config
        .setAutoOAuthToken(Utils.getSystemPropertyOrEnvVar(KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY, config.getAutoOAuthToken()));
    config.setUsername(Utils.getSystemPropertyOrEnvVar(KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY, config.getUsername()));
    config.setPassword(Utils.getSystemPropertyOrEnvVar(KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY, config.getPassword()));

    config.setImpersonateUsername(
        Utils.getSystemPropertyOrEnvVar(KUBERNETES_IMPERSONATE_USERNAME, config.getImpersonateUsername()));

    String configuredImpersonateGroups = Utils.getSystemPropertyOrEnvVar(KUBERNETES_IMPERSONATE_GROUP, Arrays
        .stream(Optional.ofNullable(config.getImpersonateGroups()).orElse(new String[0])).collect(Collectors.joining(",")));
    if (Utils.isNotNullOrEmpty(configuredImpersonateGroups)) {
      config.setImpersonateGroups(configuredImpersonateGroups.split(","));
    }

    String configuredWatchReconnectInterval = Utils
        .getSystemPropertyOrEnvVar(KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY);
    if (configuredWatchReconnectInterval != null) {
      config.setWatchReconnectInterval(Integer.parseInt(configuredWatchReconnectInterval));
    }

    String configuredWatchReconnectLimit = Utils.getSystemPropertyOrEnvVar(KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY);
    if (configuredWatchReconnectLimit != null) {
      config.setWatchReconnectLimit(Integer.parseInt(configuredWatchReconnectLimit));
    }

    String configuredScaleTimeout = Utils.getSystemPropertyOrEnvVar(KUBERNETES_SCALE_TIMEOUT_SYSTEM_PROPERTY,
        String.valueOf(DEFAULT_SCALE_TIMEOUT));
    if (configuredScaleTimeout != null) {
      config.setScaleTimeout(Long.parseLong(configuredScaleTimeout));
    }

    String configuredLoggingInterval = Utils.getSystemPropertyOrEnvVar(KUBERNETES_LOGGING_INTERVAL_SYSTEM_PROPERTY,
        String.valueOf(DEFAULT_LOGGING_INTERVAL));
    if (configuredLoggingInterval != null) {
      config.setLoggingInterval(Integer.parseInt(configuredLoggingInterval));
    }

    config.setConnectionTimeout(
        Utils.getSystemPropertyOrEnvVar(KUBERNETES_CONNECTION_TIMEOUT_SYSTEM_PROPERTY, config.getConnectionTimeout()));
    config.setUploadRequestTimeout(
        Utils.getSystemPropertyOrEnvVar(KUBERNETES_UPLOAD_REQUEST_TIMEOUT_SYSTEM_PROPERTY, config.getUploadRequestTimeout()));
    config.setRequestTimeout(
        Utils.getSystemPropertyOrEnvVar(KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY, config.getRequestTimeout()));
    config.setRequestRetryBackoffLimit(Utils.getSystemPropertyOrEnvVar(KUBERNETES_REQUEST_RETRY_BACKOFFLIMIT_SYSTEM_PROPERTY,
        config.getRequestRetryBackoffLimit()));
    config.setRequestRetryBackoffInterval(Utils.getSystemPropertyOrEnvVar(
        KUBERNETES_REQUEST_RETRY_BACKOFFINTERVAL_SYSTEM_PROPERTY, config.getRequestRetryBackoffInterval()));

    String configuredWebsocketPingInterval = Utils.getSystemPropertyOrEnvVar(KUBERNETES_WEBSOCKET_PING_INTERVAL_SYSTEM_PROPERTY,
        String.valueOf(config.getWebsocketPingInterval()));
    if (configuredWebsocketPingInterval != null) {
      config.setWebsocketPingInterval(Long.parseLong(configuredWebsocketPingInterval));
    }

    String configuredMaxConcurrentRequests = Utils.getSystemPropertyOrEnvVar(KUBERNETES_MAX_CONCURRENT_REQUESTS,
        String.valueOf(config.getMaxConcurrentRequests()));
    if (configuredMaxConcurrentRequests != null) {
      config.setMaxConcurrentRequests(Integer.parseInt(configuredMaxConcurrentRequests));
    }

    String configuredMaxConcurrentReqeustsPerHost = Utils.getSystemPropertyOrEnvVar(KUBERNETES_MAX_CONCURRENT_REQUESTS_PER_HOST,
        String.valueOf(config.getMaxConcurrentRequestsPerHost()));
    if (configuredMaxConcurrentReqeustsPerHost != null) {
      config.setMaxConcurrentRequestsPerHost(Integer.parseInt(configuredMaxConcurrentReqeustsPerHost));
    }

    config.setHttp2Disable(Utils.getSystemPropertyOrEnvVar(KUBERNETES_HTTP2_DISABLE, config.isHttp2Disable()));

    // Only set http(s) proxy fields if they're not set. This is done in order to align behavior of
    // KubernetesClient with kubectl / client-go . Please see https://github.com/fabric8io/kubernetes-client/issues/6150
    // Precedence is given to proxy-url read from kubeconfig .
    if (Utils.isNullOrEmpty(config.getHttpProxy())) {
      config.setHttpProxy(Utils.getSystemPropertyOrEnvVar(KUBERNETES_ALL_PROXY, config.getHttpProxy()));
      config.setHttpProxy(Utils.getSystemPropertyOrEnvVar(KUBERNETES_HTTP_PROXY, config.getHttpProxy()));
    }
    if (Utils.isNullOrEmpty(config.getHttpsProxy())) {
      config.setHttpsProxy(Utils.getSystemPropertyOrEnvVar(KUBERNETES_ALL_PROXY, config.getHttpsProxy()));
      config.setHttpsProxy(Utils.getSystemPropertyOrEnvVar(KUBERNETES_HTTPS_PROXY, config.getHttpsProxy()));
    }

    config.setProxyUsername(Utils.getSystemPropertyOrEnvVar(KUBERNETES_PROXY_USERNAME, config.getProxyUsername()));
    config.setProxyPassword(Utils.getSystemPropertyOrEnvVar(KUBERNETES_PROXY_PASSWORD, config.getProxyPassword()));

    String noProxyVar = Utils.getSystemPropertyOrEnvVar(KUBERNETES_NO_PROXY);
    if (noProxyVar != null) {
      config.setNoProxy(noProxyVar.split(","));
    }

    String tlsVersionsVar = Utils.getSystemPropertyOrEnvVar(KUBERNETES_TLS_VERSIONS);
    if (tlsVersionsVar != null && !tlsVersionsVar.isEmpty()) {
      String[] tlsVersionsSplit = tlsVersionsVar.split(",");
      TlsVersion[] tlsVersions = new TlsVersion[tlsVersionsSplit.length];
      for (int i = 0; i < tlsVersionsSplit.length; i++) {
        tlsVersions[i] = TlsVersion.forJavaName(tlsVersionsSplit[i]);
      }
      config.setTlsVersions(tlsVersions);
    }
  }

  private static boolean tryServiceAccount(Config config) {
    LOGGER.debug("Trying to configure client from service account...");
    String masterHost = Utils.getSystemPropertyOrEnvVar(KUBERNETES_SERVICE_HOST_PROPERTY, (String) null);
    String masterPort = Utils.getSystemPropertyOrEnvVar(KUBERNETES_SERVICE_PORT_PROPERTY, (String) null);
    String caCertPath = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY,
        KUBERNETES_SERVICE_ACCOUNT_CA_CRT_PATH);

    if (masterHost != null && masterPort != null) {
      String hostPort = joinHostPort(masterHost, masterPort);
      LOGGER.debug("Found service account host and port: {}", hostPort);
      config.setMasterUrl("https://" + hostPort);
    }
    if (Utils.getSystemPropertyOrEnvVar(KUBERNETES_AUTH_TRYSERVICEACCOUNT_SYSTEM_PROPERTY, true)) {
      boolean serviceAccountCaCertExists = Files.isRegularFile(new File(caCertPath).toPath());
      if (serviceAccountCaCertExists) {
        LOGGER.debug("Found service account ca cert at: [{}}].", caCertPath);
        config.setCaCertFile(caCertPath);
      } else {
        LOGGER.debug("Did not find service account ca cert at: [{}}].", caCertPath);
      }

      File saTokenPathFile = findServiceAccountTokenFile();
      if (saTokenPathFile != null) {
        String saTokenPathLocation = saTokenPathFile.getAbsolutePath();
        try {
          String serviceTokenCandidate = new String(Files.readAllBytes(saTokenPathFile.toPath()));
          LOGGER.debug("Found service account token at: [{}].", saTokenPathLocation);
          config.setAutoOAuthToken(serviceTokenCandidate);
          return true;
        } catch (IOException e) {
          // No service account token available...
          LOGGER.warn("Error reading service account token from: [{}]. Ignoring.", saTokenPathLocation);
        }
      }
    }
    return false;
  }

  private static File findServiceAccountTokenFile() {
    File saTokenPathFile;
    String saTokenPath = Utils.getSystemPropertyOrEnvVar(KUBERNETES_AUTH_SERVICEACCOUNT_TOKEN_FILE_SYSTEM_PROPERTY);
    if (saTokenPath != null) {
      // if user has set the service account token system property, we use it.
      saTokenPathFile = new File(saTokenPath);
    } else {
      // otherwise, let's try the default location iif the location exists.
      saTokenPathFile = new File(KUBERNETES_SERVICE_ACCOUNT_TOKEN_PATH);
      if (!saTokenPathFile.exists()) {
        saTokenPathFile = null;
        LOGGER.debug("Could not find the service account token at the default location: [{}]. Ignoring.",
            KUBERNETES_SERVICE_ACCOUNT_TOKEN_PATH);
      }
    }

    return saTokenPathFile;
  }

  private static String joinHostPort(String host, String port) {
    if (host.indexOf(':') >= 0) {
      // Host is an IPv6
      return "[" + host + "]:" + port;
    }
    return host + ":" + port;
  }

  public static Config fromKubeconfig(String kubeconfigContents) {
    return fromKubeconfig(null, KubeConfigUtils.parseConfigFromString(kubeconfigContents));
  }

  public static Config fromKubeconfig(File kubeconfigFile) {
    return fromKubeconfig(null, kubeconfigFile);
  }

  public static Config fromKubeconfig(String context, File kubeconfig) {
    return fromKubeconfig(context, KubeConfigUtils.parseConfig(kubeconfig));
  }

  private static Config fromKubeconfig(String context, io.fabric8.kubernetes.api.model.Config... kubeconfigs) {
    final Config ret = Config.empty();
    KubeConfigUtils.merge(ret, context, kubeconfigs);
    return ret;
  }

  // Note: kubeconfigPath is optional (see note on loadFromKubeConfig)
  /**
   * @deprecated use {@link #fromKubeconfig(File)} instead
   */
  @Deprecated(since = "7.0.0", forRemoval = true)
  public static Config fromKubeconfig(String context, String kubeconfigContents, String kubeconfigPath) {
    // we allow passing context along here, since downstream accepts it
    Config config = new Config(false);
    if (Utils.isNullOrEmpty(kubeconfigContents)) {
      throw new KubernetesClientException("Could not create Config from kubeconfig");
    }
    final io.fabric8.kubernetes.api.model.Config kubeconfig;
    if (kubeconfigPath != null) {
      // TODO: temp workaround until the method is removed (marked for removal in 7.0.0)
      kubeconfig = KubeConfigUtils.parseConfig(new File(kubeconfigPath));
    } else {
      kubeconfig = KubeConfigUtils.parseConfigFromString(kubeconfigContents);
    }
    KubeConfigUtils.merge(config, context, kubeconfig);
    if (!disableAutoConfig()) {
      postAutoConfigure(config);
    }
    return config;
  }

  /**
   * Refresh the config from file / env sources.
   * Any values that the user have programmatically set will be lost.
   *
   * @return this Config instance with the refreshed values (if applicable)
   */
  public Config refresh() {
    final String currentContextName = getCurrentContext() != null ? getCurrentContext().getName() : null;
    if (Utils.isNotNullOrEmpty(oauthToken)) {
      return this;
    }
    if (autoConfigure) {
      return Config.autoConfigure(currentContextName);
    }
    // Only possible if the Config was created using Config.fromKubeconfig, otherwise autoConfigure would have been called
    if (getFile() != null) {
      if (loadKubeConfigContents(getFile()) == null) {
        return this; // loadKubeConfigContents will have logged an exception
      }
      final var refreshedConfig = Config.fromKubeconfig(currentContextName, getFile());
      if (!disableAutoConfig()) {
        postAutoConfigure(refreshedConfig);
      }
      return refreshedConfig;
    }
    // nothing to refresh - the Config values were directly supplied
    return this;
  }

  private static Collection<File> findKubeConfigFiles() {
    LOGGER.debug("Trying to configure client from Kubernetes config...");
    if (!Utils.getSystemPropertyOrEnvVar(KUBERNETES_AUTH_TRYKUBECONFIG_SYSTEM_PROPERTY, true)) {
      return Collections.emptyList();
    }
    return getKubeconfigFilenames().stream()
        .map(File::new)
        .filter(f -> {
          if (!f.isFile()) {
            LOGGER.debug("Did not find Kubernetes config at: [{}]. Ignoring.", f.getPath());
            return false;
          }
          return true;
        })
        .filter(f -> Utils.isNotNullOrEmpty(loadKubeConfigContents(f)))
        .collect(Collectors.toList());
  }

  public static Collection<String> getKubeconfigFilenames() {
    final var valueOrDefault = Utils.getSystemPropertyOrEnvVar(KUBERNETES_KUBECONFIG_FILE,
        new File(getHomeDir(), ".kube" + File.separator + "config").toString());
    // if system property/env var contains multiple files take the first one based on the environment
    // we are running in (eg. : for Linux, ; for Windows)
    return Arrays.asList(valueOrDefault.split(File.pathSeparator));
  }

  private static String loadKubeConfigContents(File kubeConfigFile) {
    try (FileReader reader = new FileReader(kubeConfigFile)) {
      return IOHelpers.readFully(reader);
    } catch (IOException e) {
      LOGGER.error("Could not load Kubernetes config file from {}", kubeConfigFile.getPath(), e);
      return null;
    }
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static final class ExecCredential {
    public String kind;
    public String apiVersion;
    public ExecCredentialSpec spec;
    public ExecCredentialStatus status;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static final class ExecCredentialSpec {
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static final class ExecCredentialStatus {
    public String token;
    public String clientCertificateData;
    public String clientKeyData;
    // TODO expirationTimestamp
  }

  private static boolean tryNamespaceFromPath(Config config) {
    LOGGER.debug("Trying to configure client namespace from Kubernetes service account namespace path...");
    if (Utils.getSystemPropertyOrEnvVar(KUBERNETES_TRYNAMESPACE_PATH_SYSTEM_PROPERTY, true)) {
      String serviceAccountNamespace = Utils.getSystemPropertyOrEnvVar(KUBERNETES_NAMESPACE_FILE, KUBERNETES_NAMESPACE_PATH);
      boolean serviceAccountNamespaceExists = Files.isRegularFile(new File(serviceAccountNamespace).toPath());
      if (serviceAccountNamespaceExists) {
        LOGGER.debug("Found service account namespace at: [{}].", serviceAccountNamespace);
        try {
          String namespace = new String(Files.readAllBytes(new File(serviceAccountNamespace).toPath()));
          config.setNamespace(namespace.replace(System.lineSeparator(), ""));
          return true;
        } catch (IOException e) {
          LOGGER.error("Error reading service account namespace from: [" + serviceAccountNamespace + "].", e);
        }
      } else {
        LOGGER.debug("Did not find service account namespace at: [{}]. Ignoring.", serviceAccountNamespace);
      }
    }
    return false;
  }

  private static String getHomeDir() {
    return getHomeDir(Config::isDirectoryAndExists, Config::getSystemEnvVariable);
  }

  private static boolean isDirectoryAndExists(String filePath) {
    File f = new File(filePath);
    return f.exists() && f.isDirectory();
  }

  private static String getSystemEnvVariable(String envVariableName) {
    return System.getenv(envVariableName);
  }

  protected static String getHomeDir(Predicate<String> directoryExists, UnaryOperator<String> getEnvVar) {
    String home = getEnvVar.apply("HOME");
    if (home != null && !home.isEmpty() && directoryExists.test(home)) {
      return home;
    }
    String osName = System.getProperty("os.name").toLowerCase(Locale.ROOT);
    if (osName.startsWith("win")) {
      String homeDrive = getEnvVar.apply("HOMEDRIVE");
      String homePath = getEnvVar.apply("HOMEPATH");
      if (homeDrive != null && !homeDrive.isEmpty() && homePath != null && !homePath.isEmpty()) {
        String homeDir = homeDrive + homePath;
        if (directoryExists.test(homeDir)) {
          return homeDir;
        }
      }
      String userProfile = getEnvVar.apply("USERPROFILE");
      if (userProfile != null && !userProfile.isEmpty() && directoryExists.test(userProfile)) {
        return userProfile;
      }
    }

    // Fall back to user.home should never really get here
    return System.getProperty("user.home", ".");
  }

  public static String getKeyAlgorithm(InputStream inputStream) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
      String line, algorithm = null;

      while ((line = bufferedReader.readLine()) != null) {
        if (line.contains("BEGIN EC PRIVATE KEY")) {
          algorithm = "EC";
        } else if (line.contains("BEGIN RSA PRIVATE KEY")) {
          algorithm = "RSA";
        }
      }
      return algorithm;
    }
  }

  public static String getKeyAlgorithm(String clientKeyFile, String clientKeyData) {
    // Check if any system property is set
    if (Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY) != null) {
      return Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY);
    }

    // Detect algorithm
    try {
      if (clientKeyData != null || clientKeyFile != null) {
        ByteArrayInputStream keyInputStream = CertUtils.getInputStreamFromDataOrFile(clientKeyData, clientKeyFile);
        return getKeyAlgorithm(keyInputStream);
      }
    } catch (IOException exception) {
      LOGGER.debug("Failure in determining private key algorithm type, defaulting to RSA {}", exception.getMessage());
    }
    return null;
  }

  @Override
  @JsonProperty("impersonateUsername")
  public String getImpersonateUsername() {
    return getRequestConfig().getImpersonateUsername();
  }

  @Override
  public void setImpersonateUsername(String impersonateUsername) {
    this.requestConfig.setImpersonateUsername(impersonateUsername);
  }

  @Override
  @JsonProperty("impersonateGroups")
  public String[] getImpersonateGroups() {
    return getRequestConfig().getImpersonateGroups();
  }

  @Override
  public void setImpersonateGroups(String... impersonateGroup) {
    this.requestConfig.setImpersonateGroups(impersonateGroup);
  }

  @Override
  @JsonProperty("impersonateExtras")
  public Map<String, List<String>> getImpersonateExtras() {
    return getRequestConfig().getImpersonateExtras();
  }

  @Override
  public void setImpersonateExtras(Map<String, List<String>> impersonateExtras) {
    this.requestConfig.setImpersonateExtras(impersonateExtras);
  }

  @Override
  public void setMasterUrl(String masterUrl) {
    //We set the masterUrl because it's needed by ensureHttps
    this.masterUrl = masterUrl;
    this.masterUrl = ensureEndsWithSlash(ensureHttps(masterUrl, this));
  }

  @JsonProperty("trustCerts")
  public boolean isTrustCerts() {
    return Optional.ofNullable(trustCerts).orElse(false);
  }

  public void setTrustCerts(boolean trustCerts) {
    this.trustCerts = trustCerts;
  }

  @JsonProperty("disableHostnameVerification")
  public boolean isDisableHostnameVerification() {
    return Optional.ofNullable(disableHostnameVerification).orElse(false);
  }

  public void setDisableHostnameVerification(boolean disableHostnameVerification) {
    this.disableHostnameVerification = disableHostnameVerification;
  }

  @Override
  @JsonProperty("watchReconnectInterval")
  public Integer getWatchReconnectInterval() {
    return requestConfig.getWatchReconnectInterval();
  }

  @Override
  public void setWatchReconnectInterval(Integer watchReconnectInterval) {
    this.requestConfig.setWatchReconnectInterval(watchReconnectInterval);
  }

  @Override
  @JsonProperty("watchReconnectLimit")
  public Integer getWatchReconnectLimit() {
    return getRequestConfig().getWatchReconnectLimit();
  }

  @Override
  public void setWatchReconnectLimit(Integer watchReconnectLimit) {
    this.requestConfig.setWatchReconnectLimit(watchReconnectLimit);
  }

  public static ConfigBuilder builder() {
    return new ConfigBuilder();
  }

  @Override
  @JsonProperty("uploadRequestTimeout")
  public Integer getUploadRequestTimeout() {
    return getRequestConfig().getUploadRequestTimeout();
  }

  @Override
  public void setUploadRequestTimeout(Integer requestTimeout) {
    this.requestConfig.setUploadRequestTimeout(requestTimeout);
  }

  @Override
  @JsonProperty("requestTimeout")
  public Integer getRequestTimeout() {
    return getRequestConfig().getRequestTimeout();
  }

  @Override
  public void setRequestTimeout(Integer requestTimeout) {
    this.requestConfig.setRequestTimeout(requestTimeout);
  }

  @Override
  @JsonProperty("requestRetryBackoffLimit")
  public Integer getRequestRetryBackoffLimit() {
    return getRequestConfig().getRequestRetryBackoffLimit();
  }

  @Override
  public void setRequestRetryBackoffLimit(Integer requestRetryBackoffLimit) {
    requestConfig.setRequestRetryBackoffLimit(requestRetryBackoffLimit);
  }

  @Override
  @JsonProperty("requestRetryBackoffInterval")
  public Integer getRequestRetryBackoffInterval() {
    return getRequestConfig().getRequestRetryBackoffInterval();
  }

  @Override
  public void setRequestRetryBackoffInterval(Integer requestRetryBackoffInterval) {
    requestConfig.setRequestRetryBackoffInterval(requestRetryBackoffInterval);
  }

  @Override
  @JsonProperty("scaleTimeout")
  public Long getScaleTimeout() {
    return getRequestConfig().getScaleTimeout();
  }

  @Override
  public void setScaleTimeout(Long scaleTimeout) {
    this.requestConfig.setScaleTimeout(scaleTimeout);
  }

  @Override
  @JsonProperty("loggingInterval")
  public Integer getLoggingInterval() {
    return getRequestConfig().getLoggingInterval();
  }

  @Override
  public void setLoggingInterval(Integer loggingInterval) {
    this.requestConfig.setLoggingInterval(loggingInterval);
  }

  @JsonProperty("http2Disable")
  public boolean isHttp2Disable() {
    return Optional.ofNullable(http2Disable).orElse(false);
  }

  @JsonProperty("defaultNamespace")
  public boolean isDefaultNamespace() {
    return Optional.ofNullable(defaultNamespace).orElse(true);
  }

  public void setDefaultNamespace(boolean defaultNamespace) {
    this.defaultNamespace = defaultNamespace;
  }

  public RequestConfig getRequestConfig() {
    return this.requestConfig;
  }

  /**
   * Returns the path to the file that contains the context from which this configuration was loaded from.
   * <p>
   * Returns {@code null} if no file was used.
   *
   * @return the path to the kubeconfig file.
   */
  public File getFile() {
    return KubeConfigUtils.getFileWithNamedContext(getCurrentContext());
  }

  /**
   * Returns the path to the file that contains the cluster information from which this configuration was loaded from.
   * <p>
   * Returns {@code null} if no file was used.
   *
   * @return the path to the kubeconfig file.
   */
  public File getFileWithCluster() {
    return KubeConfigUtils.getFileWithNamedCluster(getCurrentContext());
  }

  /**
   * Returns the path to the file that contains the user information from which this configuration was loaded from.
   * <p>
   * Returns {@code null} if no file was used.
   *
   * @return the path to the kubeconfig file.
   */
  public File getFileWithAuthInfo() {
    return KubeConfigUtils.getFileWithNamedAuthInfo(getCurrentContext());
  }

  @JsonIgnore
  public Readiness getReadiness() {
    return Readiness.getInstance();
  }

  public boolean isOnlyHttpWatches() {
    return Optional.ofNullable(onlyHttpWatches).orElse(false);
  }

  public void setOnlyHttpWatches(boolean onlyHttpWatches) {
    this.onlyHttpWatches = onlyHttpWatches;
  }

  public boolean isWatchList() {
    return Optional.ofNullable(watchList).orElse(false);
  }

}
