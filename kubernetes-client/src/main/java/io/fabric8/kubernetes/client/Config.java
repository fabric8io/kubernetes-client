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

package io.fabric8.kubernetes.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.fabric8.kubernetes.api.model.ConfigBuilder;
import okhttp3.TlsVersion;
import io.fabric8.kubernetes.api.model.AuthInfo;
import io.fabric8.kubernetes.api.model.Cluster;
import io.fabric8.kubernetes.api.model.Context;
import io.fabric8.kubernetes.client.internal.KubeConfigUtils;
import io.fabric8.kubernetes.client.internal.SSLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.sundr.builder.annotations.Buildable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import static okhttp3.TlsVersion.TLS_1_2;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true, allowSetters = true)
public class Config {

  private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);

  public static final String KUBERNETES_MASTER_SYSTEM_PROPERTY = "kubernetes.master";
  public static final String KUBERNETES_API_VERSION_SYSTEM_PROPERTY = "kubernetes.api.version";
  public static final String KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY = "kubernetes.trust.certificates";
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
  public static final String KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY = "kubernetes.auth.token";
  public static final String KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY = "kubernetes.watch.reconnectInterval";
  public static final String KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY = "kubernetes.watch.reconnectLimit";
  public static final String KUBERNETES_CONNECTION_TIMEOUT_SYSTEM_PROPERTY = "kubernetes.connection.timeout";
  public static final String KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY = "kubernetes.request.timeout";
  public static final String KUBERNETES_ROLLING_TIMEOUT_SYSTEM_PROPERTY = "kubernetes.rolling.timeout";
  public static final String KUBERNETES_LOGGING_INTERVAL_SYSTEM_PROPERTY = "kubernetes.logging.interval";
  public static final String KUBERNETES_SCALE_TIMEOUT_SYSTEM_PROPERTY = "kubernetes.scale.timeout";
  public static final String KUBERNETES_WEBSOCKET_TIMEOUT_SYSTEM_PROPERTY = "kubernetes.websocket.timeout";
  public static final String KUBERNETES_WEBSOCKET_PING_INTERVAL_SYSTEM_PROPERTY = "kubernetes.websocket.ping.interval";
  public static final String KUBERNETES_MAX_CONCURRENT_REQUESTS_PER_HOST ="kubernetes.max.concurrent.requests.per.host";

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
  public static final String KUBERNETES_SERVICE_ACCOUNT_TOKEN_PATH = "/var/run/secrets/kubernetes.io/serviceaccount/token";
  public static final String KUBERNETES_SERVICE_ACCOUNT_CA_CRT_PATH = "/var/run/secrets/kubernetes.io/serviceaccount/ca.crt";
  public static final String KUBERNETES_HTTP_PROXY = "http.proxy";
  public static final String KUBERNETES_HTTPS_PROXY = "https.proxy";
  public static final String KUBERNETES_ALL_PROXY = "all.proxy";
  public static final String KUBERNETES_NO_PROXY = "no.proxy";
  public static final String KUBERNETES_PROXY_USERNAME = "proxy.username";
  public static final String KUBERNETES_PROXY_PASSWORD = "proxy.password";

  public static final String KUBERNETES_USER_AGENT = "fabric8-kubernetes-client/" + Version.clientVersion() ;

  public static final Long DEFAULT_ROLLING_TIMEOUT = 15 * 60 * 1000L;
  public static final Long DEFAULT_SCALE_TIMEOUT = 10 * 60 * 1000L;
  public static final int DEFAULT_LOGGING_INTERVAL = 20 * 1000;
  public static final Long DEFAULT_WEBSOCKET_TIMEOUT = 5 * 1000L;
  public static final Long DEFAULT_WEBSOCKET_PING_INTERVAL = 1 * 1000L;

  public static final Integer DEFAULT_MAX_CONCURRENT_REQUESTS_PER_HOST = 5;

  public static final String HTTP_PROTOCOL_PREFIX = "http://";
  public static final String HTTPS_PROTOCOL_PREFIX = "https://";

  private static final String ACCESS_TOKEN = "access-token";

  private boolean trustCerts;
  private String masterUrl = "https://kubernetes.default.svc";
  private String apiVersion = "v1";
  private String namespace;
  private String caCertFile;
  private String caCertData;
  private String clientCertFile;
  private String clientCertData;
  private String clientKeyFile;
  private String clientKeyData;
  private String clientKeyAlgo = "RSA";
  private String clientKeyPassphrase = "changeit";
  private String trustStoreFile;
  private String trustStorePassphrase;
  private String keyStoreFile;
  private String keyStorePassphrase;

  private RequestConfig requestConfig = new RequestConfig();

  /**
   * fields not used but needed for builder generation.
   */
  private String username;
  private String password;
  private String oauthToken;
  private int watchReconnectInterval = 1000;
  private int watchReconnectLimit = -1;
  private int connectionTimeout = 10 * 1000;
  private int requestTimeout = 10 * 1000;
  private long rollingTimeout = DEFAULT_ROLLING_TIMEOUT;
  private long scaleTimeout = DEFAULT_SCALE_TIMEOUT;
  private int loggingInterval = DEFAULT_LOGGING_INTERVAL;
  private long websocketTimeout = DEFAULT_WEBSOCKET_TIMEOUT;
  private long websocketPingInterval = DEFAULT_WEBSOCKET_PING_INTERVAL;
  private int maxConcurrentRequestsPerHost = DEFAULT_MAX_CONCURRENT_REQUESTS_PER_HOST;
  /**
   * end of fields not used but needed for builder generation.
   */

  private String httpProxy;
  private String httpsProxy;
  private String proxyUsername;
  private String proxyPassword;
  private String[] noProxy;
  private String userAgent;
  private TlsVersion[] tlsVersions = new TlsVersion[]{TLS_1_2};

  private Map<Integer, String> errorMessages = new HashMap<>();

  //In future releases (2.4.x) the public constructor will be empty.
  //The current functionality will be provided by autoConfigure().
  //This is a necessary change to allow us distinguish between auto configured values and builder values.
  @Deprecated
  public Config() {
    autoConfigure(this);
  }

  public static Config autoConfigure() {
    Config config = new Config();
    return autoConfigure(config);
  }

  private static Config autoConfigure(Config config) {
    if (!tryKubeConfig(config)) {
      tryServiceAccount(config);
      tryNamespaceFromPath(config);
    }
    configFromSysPropsOrEnvVars(config);

    if (!config.masterUrl.toLowerCase().startsWith(HTTP_PROTOCOL_PREFIX) && !config.masterUrl.toLowerCase().startsWith(HTTPS_PROTOCOL_PREFIX)) {
      config.masterUrl = (SSLUtils.isHttpsAvailable(config) ? HTTPS_PROTOCOL_PREFIX : HTTP_PROTOCOL_PREFIX) + config.masterUrl;
    }

    if (!config.masterUrl.endsWith("/")) {
      config.masterUrl = config.masterUrl + "/";
    }
    return config;
  }

  @Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", editableEnabled = false)
  public Config(String masterUrl, String apiVersion, String namespace, boolean trustCerts, String caCertFile, String caCertData, String clientCertFile, String clientCertData, String clientKeyFile, String clientKeyData, String clientKeyAlgo, String clientKeyPassphrase, String username, String password, String oauthToken, int watchReconnectInterval, int watchReconnectLimit, int connectionTimeout, int requestTimeout, long rollingTimeout, long scaleTimeout, int loggingInterval, int maxConcurrentRequestsPerHost, String httpProxy, String httpsProxy, String[] noProxy, Map<Integer, String> errorMessages, String userAgent, TlsVersion[] tlsVersions, long websocketTimeout, long websocketPingInterval, String proxyUsername, String proxyPassword, String trustStoreFile, String trustStorePassphrase, String keyStoreFile, String keyStorePassphrase) {
    this.masterUrl = masterUrl;
    this.apiVersion = apiVersion;
    this.namespace = namespace;
    this.trustCerts = trustCerts;
    this.caCertFile = caCertFile;
    this.caCertData = caCertData;
    this.clientCertFile = clientCertFile;
    this.clientCertData = clientCertData;
    this.clientKeyFile = clientKeyFile;
    this.clientKeyData = clientKeyData;
    this.clientKeyAlgo = clientKeyAlgo;
    this.clientKeyPassphrase = clientKeyPassphrase;

    this.requestConfig = new RequestConfig(username, password, oauthToken, watchReconnectLimit, watchReconnectInterval, connectionTimeout, rollingTimeout, requestTimeout, scaleTimeout, loggingInterval, websocketTimeout, websocketPingInterval, maxConcurrentRequestsPerHost);

    this.httpProxy= httpProxy;
    this.httpsProxy= httpsProxy;
    this.noProxy= noProxy;
    this.proxyUsername = proxyUsername;
    this.proxyPassword = proxyPassword;
    this.errorMessages = errorMessages;
    this.userAgent = userAgent;
    this.tlsVersions = tlsVersions;

    if (!this.masterUrl.toLowerCase().startsWith(HTTP_PROTOCOL_PREFIX) && !this.masterUrl.startsWith(HTTPS_PROTOCOL_PREFIX)) {
      this.masterUrl = (SSLUtils.isHttpsAvailable(this) ? HTTPS_PROTOCOL_PREFIX : HTTP_PROTOCOL_PREFIX) + this.masterUrl;
    }

    if (!this.masterUrl.endsWith("/")) {
      this.masterUrl = this.masterUrl + "/";
    }

    this.trustStoreFile = trustStoreFile;
    this.trustStorePassphrase = trustStorePassphrase;
    this.keyStoreFile = keyStoreFile;
    this.keyStorePassphrase = keyStorePassphrase;
  }

  public static void configFromSysPropsOrEnvVars(Config config) {
    config.setTrustCerts(Utils.getSystemPropertyOrEnvVar(KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY, config.isTrustCerts()));
    config.setMasterUrl(Utils.getSystemPropertyOrEnvVar(KUBERNETES_MASTER_SYSTEM_PROPERTY, config.getMasterUrl()));
    config.setApiVersion(Utils.getSystemPropertyOrEnvVar(KUBERNETES_API_VERSION_SYSTEM_PROPERTY, config.getApiVersion()));
    config.setNamespace(Utils.getSystemPropertyOrEnvVar(KUBERNETES_NAMESPACE_SYSTEM_PROPERTY, config.getNamespace()));
    config.setCaCertFile(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY, config.getCaCertFile()));
    config.setCaCertData(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY, config.getCaCertData()));
    config.setClientCertFile(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY, config.getClientCertFile()));
    config.setClientCertData(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY, config.getClientCertData()));
    config.setClientKeyFile(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY, config.getClientKeyFile()));
    config.setClientKeyData(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY, config.getClientKeyData()));
    config.setClientKeyAlgo(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY, config.getClientKeyAlgo()));
    config.setClientKeyPassphrase(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY, new String(config.getClientKeyPassphrase())));
    config.setUserAgent(Utils.getSystemPropertyOrEnvVar(KUBERNETES_USER_AGENT, config.getUserAgent()));

    config.setTrustStorePassphrase(Utils.getSystemPropertyOrEnvVar(KUBERNETES_TRUSTSTORE_PASSPHRASE_PROPERTY, config.getTrustStorePassphrase()));
    config.setTrustStoreFile(Utils.getSystemPropertyOrEnvVar(KUBERNETES_TRUSTSTORE_FILE_PROPERTY, config.getTrustStoreFile()));
    config.setKeyStorePassphrase(Utils.getSystemPropertyOrEnvVar(KUBERNETES_KEYSTORE_PASSPHRASE_PROPERTY, config.getKeyStorePassphrase()));
    config.setKeyStoreFile(Utils.getSystemPropertyOrEnvVar(KUBERNETES_KEYSTORE_FILE_PROPERTY, config.getKeyStoreFile()));

    config.setOauthToken(Utils.getSystemPropertyOrEnvVar(KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY, config.getOauthToken()));
    config.setUsername(Utils.getSystemPropertyOrEnvVar(KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY, config.getUsername()));
    config.setPassword(Utils.getSystemPropertyOrEnvVar(KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY, config.getPassword()));
    String configuredWatchReconnectInterval = Utils.getSystemPropertyOrEnvVar(KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY);
    if (configuredWatchReconnectInterval != null) {
      config.setWatchReconnectInterval(Integer.parseInt(configuredWatchReconnectInterval));
    }

    String configuredWatchReconnectLimit = Utils.getSystemPropertyOrEnvVar(KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY);
    if (configuredWatchReconnectLimit != null) {
      config.setWatchReconnectLimit(Integer.parseInt(configuredWatchReconnectLimit));
    }

    String configuredRollingTimeout = Utils.getSystemPropertyOrEnvVar(KUBERNETES_ROLLING_TIMEOUT_SYSTEM_PROPERTY, String.valueOf(DEFAULT_ROLLING_TIMEOUT));
    if (configuredRollingTimeout != null) {
      config.setRollingTimeout(Long.parseLong(configuredRollingTimeout));
    }

    String configuredScaleTimeout = Utils.getSystemPropertyOrEnvVar(KUBERNETES_SCALE_TIMEOUT_SYSTEM_PROPERTY, String.valueOf(DEFAULT_SCALE_TIMEOUT));
    if (configuredScaleTimeout != null) {
      config.setScaleTimeout(Long.parseLong(configuredScaleTimeout));
    }


    String configuredLoggingInterval = Utils.getSystemPropertyOrEnvVar(KUBERNETES_LOGGING_INTERVAL_SYSTEM_PROPERTY, String.valueOf(DEFAULT_LOGGING_INTERVAL));
    if (configuredLoggingInterval != null) {
      config.setLoggingInterval(Integer.parseInt(configuredLoggingInterval));
    }

    config.setConnectionTimeout(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CONNECTION_TIMEOUT_SYSTEM_PROPERTY, config.getConnectionTimeout()));
    config.setRequestTimeout(Utils.getSystemPropertyOrEnvVar(KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY, config.getRequestTimeout()));

    String configuredWebsocketTimeout = Utils.getSystemPropertyOrEnvVar(KUBERNETES_WEBSOCKET_TIMEOUT_SYSTEM_PROPERTY, String.valueOf(config.getWebsocketTimeout()));
    if (configuredWebsocketTimeout != null) {
      config.setWebsocketTimeout(Long.parseLong(configuredWebsocketTimeout));
    }

    String configuredWebsocketPingInterval = Utils.getSystemPropertyOrEnvVar(KUBERNETES_WEBSOCKET_PING_INTERVAL_SYSTEM_PROPERTY, String.valueOf(config.getWebsocketPingInterval()));
    if (configuredWebsocketPingInterval != null) {
      config.setWebsocketPingInterval(Long.parseLong(configuredWebsocketPingInterval));
    }

    String configuredMaxConcurrentReqeustsPerHost = Utils.getSystemPropertyOrEnvVar(KUBERNETES_MAX_CONCURRENT_REQUESTS_PER_HOST, String.valueOf(config.getMaxConcurrentRequestsPerHost()));
    if (configuredMaxConcurrentReqeustsPerHost != null) {
      config.setMaxConcurrentRequestsPerHost(Integer.parseInt(configuredMaxConcurrentReqeustsPerHost));
    }

    config.setHttpProxy(Utils.getSystemPropertyOrEnvVar(KUBERNETES_ALL_PROXY, config.getHttpProxy()));
    config.setHttpsProxy(Utils.getSystemPropertyOrEnvVar(KUBERNETES_ALL_PROXY, config.getHttpsProxy()));

    config.setHttpsProxy(Utils.getSystemPropertyOrEnvVar(KUBERNETES_HTTPS_PROXY, config.getHttpsProxy()));
    config.setHttpProxy(Utils.getSystemPropertyOrEnvVar(KUBERNETES_HTTP_PROXY, config.getHttpProxy()));

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
    if (Utils.getSystemPropertyOrEnvVar(KUBERNETES_AUTH_TRYSERVICEACCOUNT_SYSTEM_PROPERTY, true)) {
      boolean serviceAccountCaCertExists = Files.isRegularFile(new File(KUBERNETES_SERVICE_ACCOUNT_CA_CRT_PATH).toPath());
      if (serviceAccountCaCertExists) {
        LOGGER.debug("Found service account ca cert at: ["+KUBERNETES_SERVICE_ACCOUNT_CA_CRT_PATH+"].");
        config.setCaCertFile(KUBERNETES_SERVICE_ACCOUNT_CA_CRT_PATH);
      } else {
        LOGGER.debug("Did not find service account ca cert at: ["+KUBERNETES_SERVICE_ACCOUNT_CA_CRT_PATH+"].");
      }
      try {
        String serviceTokenCandidate = new String(Files.readAllBytes(new File(KUBERNETES_SERVICE_ACCOUNT_TOKEN_PATH).toPath()));
        if (serviceTokenCandidate != null) {
          LOGGER.debug("Found service account token at: ["+KUBERNETES_SERVICE_ACCOUNT_TOKEN_PATH+"].");
          config.setOauthToken(serviceTokenCandidate);
          String txt = "Configured service account doesn't have access. Service account may have been revoked.";
          config.getErrorMessages().put(401, "Unauthorized! " + txt);
          config.getErrorMessages().put(403, "Forbidden!" + txt);
          return true;
        } else {
          LOGGER.debug("Did not find service account token at: ["+KUBERNETES_SERVICE_ACCOUNT_TOKEN_PATH+"].");
        }
      } catch (IOException e) {
        // No service account token available...
        LOGGER.warn("Error reading service account token from: ["+KUBERNETES_SERVICE_ACCOUNT_TOKEN_PATH+"]. Ignoring.");
      }
    }
    return false;
  }

  private static String absolutify(File relativeTo, String filename) {
    if (filename == null) {
      return null;
    }

    File file = new File(filename);
    if (file.isAbsolute()) {
      return file.getAbsolutePath();
    }

    return new File(relativeTo.getParentFile(), filename).getAbsolutePath();
  }

  private static boolean tryKubeConfig(Config config) {
    LOGGER.debug("Trying to configure client from Kubernetes config...");
    if (Utils.getSystemPropertyOrEnvVar(KUBERNETES_AUTH_TRYKUBECONFIG_SYSTEM_PROPERTY, true)) {
      File kubeConfigFile = new File(
          Utils.getSystemPropertyOrEnvVar(KUBERNETES_KUBECONFIG_FILE, new File(getHomeDir(), ".kube" + File.separator + "config").toString()));
      boolean kubeConfigFileExists = Files.isRegularFile(kubeConfigFile.toPath());
      if (kubeConfigFileExists) {
        LOGGER.debug("Found for Kubernetes config at: ["+kubeConfigFile.getPath()+"].");
        try {
          io.fabric8.kubernetes.api.model.Config kubeConfig = KubeConfigUtils.parseConfig(kubeConfigFile);
          Context currentContext = KubeConfigUtils.getCurrentContext(kubeConfig);
          Cluster currentCluster = KubeConfigUtils.getCluster(kubeConfig, currentContext);
          if (currentCluster != null) {
            config.setMasterUrl(currentCluster.getServer());
            config.setNamespace(currentContext.getNamespace());
            config.setTrustCerts(currentCluster.getInsecureSkipTlsVerify() != null && currentCluster.getInsecureSkipTlsVerify());
            config.setCaCertFile(absolutify(kubeConfigFile, currentCluster.getCertificateAuthority()));
            config.setCaCertData(currentCluster.getCertificateAuthorityData());
            AuthInfo currentAuthInfo = KubeConfigUtils.getUserAuthInfo(kubeConfig, currentContext);
            if (currentAuthInfo != null) {
              config.setClientCertFile(absolutify(kubeConfigFile, currentAuthInfo.getClientCertificate()));
              config.setClientCertData(currentAuthInfo.getClientCertificateData());
              config.setClientKeyFile(absolutify(kubeConfigFile, currentAuthInfo.getClientKey()));
              config.setClientKeyData(currentAuthInfo.getClientKeyData());
              config.setOauthToken(currentAuthInfo.getToken());
              config.setUsername(currentAuthInfo.getUsername());
              config.setPassword(currentAuthInfo.getPassword());

              if (Utils.isNullOrEmpty(config.getOauthToken()) && currentAuthInfo.getAuthProvider() != null && !Utils.isNullOrEmpty(currentAuthInfo.getAuthProvider().getConfig().get(ACCESS_TOKEN))) {
                config.setOauthToken(currentAuthInfo.getAuthProvider().getConfig().get(ACCESS_TOKEN));
              }

              config.getErrorMessages().put(401, "Unauthorized! Token may have expired! Please log-in again.");
              config.getErrorMessages().put(403, "Forbidden! User "+currentContext.getUser()+ " doesn't have permission.");
            }
            return true;
          }
        } catch (IOException e) {
          LOGGER.error("Could not load Kubernetes config file from {}", kubeConfigFile.getPath(), e);
        }
      } else {
        LOGGER.debug("Did not find Kubernetes config at: ["+kubeConfigFile.getPath()+"]. Ignoring.");
      }
    }
    return false;
  }

  private static boolean tryNamespaceFromPath(Config config) {
    LOGGER.debug("Trying to configure client namespace from Kubernetes service account namespace path...");
    if (Utils.getSystemPropertyOrEnvVar(KUBERNETES_TRYNAMESPACE_PATH_SYSTEM_PROPERTY, true)) {
      String serviceAccountNamespace = Utils.getSystemPropertyOrEnvVar(KUBERNETES_NAMESPACE_FILE, KUBERNETES_NAMESPACE_PATH);
      boolean serviceAccountNamespaceExists = Files.isRegularFile(new File(serviceAccountNamespace).toPath());
      if (serviceAccountNamespaceExists) {
        LOGGER.debug("Found service account namespace at: [" + serviceAccountNamespace + "].");
        try {
          String namespace = new String(Files.readAllBytes(new File(serviceAccountNamespace).toPath()));
          config.setNamespace(namespace.replace(System.lineSeparator(), ""));
          return true;
        } catch (IOException e) {
          LOGGER.error("Error reading service account namespace from: [" + serviceAccountNamespace + "].", e);
        }
      } else {
        LOGGER.debug("Did not find service account namespace at: [" + serviceAccountNamespace + "]. Ignoring.");
      }
    }
    return false;
  }

  private static String getHomeDir() {
    String osName = System.getProperty("os.name").toLowerCase();
    if (osName.startsWith("win")) {
      String homeDrive = System.getenv("HOMEDRIVE");
      String homePath = System.getenv("HOMEPATH");
      if (homeDrive != null && !homeDrive.isEmpty() && homePath != null && !homePath.isEmpty()) {
        String homeDir = homeDrive + homePath;
        File f = new File(homeDir);
        if (f.exists() && f.isDirectory()) {
          return homeDir;
        }
      }
      String userProfile = System.getenv("USERPROFILE");
      if (userProfile != null && !userProfile.isEmpty()) {
        File f = new File(userProfile);
        if (f.exists() && f.isDirectory()) {
          return userProfile;
        }
      }
    }
    String home = System.getenv("HOME");
    if (home != null && !home.isEmpty()) {
      File f = new File(home);
      if (f.exists() && f.isDirectory()) {
        return home;
      }
    }

    //Fall back to user.home should never really get here
    return System.getProperty("user.home", ".");
  }

  @JsonProperty("oauthToken")
  public String getOauthToken() {
    return getRequestConfig().getOauthToken();
  }

  public void setOauthToken(String oauthToken) {
    this.requestConfig.setOauthToken(oauthToken);
  }

  @JsonProperty("password")
  public String getPassword() {
    return getRequestConfig().getPassword();
  }

  public void setPassword(String password) {
   this.requestConfig.setPassword(password);
  }

  @JsonProperty("username")
  public String getUsername() {
    return getRequestConfig().getUsername();
  }

  public void setUsername(String username) {
    this.requestConfig.setUsername(username);
  }

  @JsonProperty("clientKeyPassphrase")
  public String getClientKeyPassphrase() {
    return clientKeyPassphrase;
  }

  public void setClientKeyPassphrase(String clientKeyPassphrase) {
    this.clientKeyPassphrase = clientKeyPassphrase;
  }

  @JsonProperty("clientKeyAlgo")
  public String getClientKeyAlgo() {
    return clientKeyAlgo;
  }

  public void setClientKeyAlgo(String clientKeyAlgo) {
    this.clientKeyAlgo = clientKeyAlgo;
  }

  @JsonProperty("clientKeyData")
  public String getClientKeyData() {
    return clientKeyData;
  }

  public void setClientKeyData(String clientKeyData) {
    this.clientKeyData = clientKeyData;
  }

  @JsonProperty("clientKeyFile")
  public String getClientKeyFile() {
    return clientKeyFile;
  }

  public void setClientKeyFile(String clientKeyFile) {
    this.clientKeyFile = clientKeyFile;
  }

  @JsonProperty("clientCertData")
  public String getClientCertData() {
    return clientCertData;
  }

  public void setClientCertData(String clientCertData) {
    this.clientCertData = clientCertData;
  }

  @JsonProperty("clientCertFile")
  public String getClientCertFile() {
    return clientCertFile;
  }

  public void setClientCertFile(String clientCertFile) {
    this.clientCertFile = clientCertFile;
  }

  @JsonProperty("caCertData")
  public String getCaCertData() {
    return caCertData;
  }

  public void setCaCertData(String caCertData) {
    this.caCertData = caCertData;
  }

  @JsonProperty("caCertFile")
  public String getCaCertFile() {
    return caCertFile;
  }

  public void setCaCertFile(String caCertFile) {
    this.caCertFile = caCertFile;
  }

  @JsonProperty("apiVersion")
  public String getApiVersion() {
    return apiVersion;
  }

  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }

  @JsonProperty("masterUrl")
  public String getMasterUrl() {
    return masterUrl;
  }

  public void setMasterUrl(String masterUrl) {
    this.masterUrl = masterUrl;
  }

  @JsonProperty("trustCerts")
  public boolean isTrustCerts() {
    return trustCerts;
  }

  public void setTrustCerts(boolean trustCerts) {
    this.trustCerts = trustCerts;
  }

  @JsonProperty("watchReconnectInterval")
  public int getWatchReconnectInterval() {
    return requestConfig.getWatchReconnectInterval();
  }

  public void setWatchReconnectInterval(int watchReconnectInterval) {
    this.requestConfig.setWatchReconnectInterval(watchReconnectInterval);
  }

  @JsonProperty("watchReconnectLimit")
  public int getWatchReconnectLimit() {
    return getRequestConfig().getWatchReconnectLimit();
  }

  public void setWatchReconnectLimit(int watchReconnectLimit) {
    this.requestConfig.setWatchReconnectLimit(watchReconnectLimit);
  }

  @JsonProperty("errorMessages")
  public Map<Integer, String> getErrorMessages() {
    return errorMessages;
  }

  public void setErrorMessages(Map<Integer, String> errorMessages) {
    this.errorMessages = errorMessages;
  }

  public static ConfigBuilder builder() {
    return new ConfigBuilder();
  }

  @JsonProperty("connectionTimeout")
  public int getConnectionTimeout() {
    return getRequestConfig().getConnectionTimeout();
  }

  public void setConnectionTimeout(int connectionTimeout) {
    this.requestConfig.setConnectionTimeout(connectionTimeout);
  }

  @JsonProperty("requestTimeout")
  public int getRequestTimeout() {
    return getRequestConfig().getRequestTimeout();
  }

  public void setRequestTimeout(int requestTimeout) {
    this.requestConfig.setRequestTimeout(requestTimeout);
  }

  @JsonProperty("rollingTimeout")
  public long getRollingTimeout() {
    return getRequestConfig().getRollingTimeout();
  }

  public void setRollingTimeout(long rollingTimeout) {
    this.requestConfig.setRollingTimeout(rollingTimeout);
  }

  @JsonProperty("scaleTimeout")
  public long getScaleTimeout() {
    return getRequestConfig().getScaleTimeout();
  }

  public void setScaleTimeout(long scaleTimeout) {
    this.requestConfig.setScaleTimeout(scaleTimeout);
  }

  @JsonProperty("loggingInterval")
  public int getLoggingInterval() {
    return getRequestConfig().getLoggingInterval();
  }

  public void setLoggingInterval(int loggingInterval) {
    this.requestConfig.setLoggingInterval(loggingInterval);
  }


  public void setHttpProxy(String httpProxy) {
    this.httpProxy= httpProxy;
  }

  @JsonProperty("httpProxy")
  public String getHttpProxy() {
    return httpProxy;
  }

  public void setHttpsProxy(String httpsProxy) {
    this.httpsProxy= httpsProxy;
  }

  @JsonProperty("httpsProxy")
  public String getHttpsProxy() {
    return httpsProxy;
  }

  public void setNoProxy(String[] noProxy) {
    this.noProxy = noProxy;
  }

  @JsonProperty("noProxy")
  public String[] getNoProxy() {
    return noProxy;
  }

  @JsonProperty("namespace")
  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  @JsonProperty("userAgent")
  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  @JsonProperty("tlsVersions")
  public TlsVersion[] getTlsVersions() {
    return tlsVersions;
  }

  public void setTlsVersions(TlsVersion[] tlsVersions) {
    this.tlsVersions = tlsVersions;
  }

  @JsonProperty("websocketTimeout")
  public long getWebsocketTimeout() {
    return getRequestConfig().getWebsocketTimeout();
  }

  public void setWebsocketTimeout(long websocketTimeout) {
    this.requestConfig.setWebsocketTimeout(websocketTimeout);
  }

  @JsonProperty("websocketPingInterval")
  public long getWebsocketPingInterval() {
    return getRequestConfig().getWebsocketPingInterval();
  }

  public void setWebsocketPingInterval(long websocketPingInterval) {
    this.requestConfig.setWebsocketPingInterval(websocketPingInterval);
  }

  public int getMaxConcurrentRequestsPerHost() {
    return getRequestConfig().getMaxConcurrentRequestsPerHost();
  }

  public void setMaxConcurrentRequestsPerHost(int maxConcurrentRequestsPerHost) {
    this.requestConfig.setMaxConcurrentRequestsPerHost(maxConcurrentRequestsPerHost);
  }

  @JsonProperty("proxyUsername")
  public String getProxyUsername() {
    return proxyUsername;
  }

  public void setProxyUsername(String proxyUsername) {
    this.proxyUsername = proxyUsername;
  }

  @JsonProperty("proxyPassword")
  public String getProxyPassword() {
    return proxyPassword;
  }

  public void setProxyPassword(String proxyPassword) {
    this.proxyPassword = proxyPassword;
  }

  public RequestConfig getRequestConfig() {
    RequestConfig rc = RequestConfigHolder.get();
    return rc != null ? rc : this.requestConfig;
  }

  public void setTrustStorePassphrase(String trustStorePassphrase) {
    this.trustStorePassphrase = trustStorePassphrase;
  }

  @JsonProperty("trustStorePassphrase")
  public String getTrustStorePassphrase() {
    return trustStorePassphrase;
  }

  public void setKeyStorePassphrase(String keyStorePassphrase) {
    this.keyStorePassphrase = keyStorePassphrase;
  }

  @JsonProperty("keyStorePassphrase")
  public String getKeyStorePassphrase() {
    return keyStorePassphrase;
  }

  public void setTrustStoreFile(String trustStoreFile) {
    this.trustStoreFile = trustStoreFile;
  }

  @JsonProperty("trustStoreFile")
  public String getTrustStoreFile() {
    return trustStoreFile;
  }

  public void setKeyStoreFile(String keyStoreFile) {
    this.keyStoreFile = keyStoreFile;
  }

  @JsonProperty("keyStoreFile")
  public String getKeyStoreFile() {
    return keyStoreFile;
  }

}
