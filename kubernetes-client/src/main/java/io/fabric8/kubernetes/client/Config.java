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

  public static final String KUBERNETES_USER_AGENT = "fabric8-kubernetes-client/" + Version.clientVersion() ;

  public static final Long DEFAULT_ROLLING_TIMEOUT = 15 * 60 * 1000L;
  public static final Long DEFAULT_SCALE_TIMEOUT = 10 * 60 * 1000L;
  public static final int DEFAULT_LOGGING_INTERVAL = 20 * 1000;
  public static final Long DEFAULT_WEBSOCKET_TIMEOUT = 5 * 1000L;
  public static final Long DEFAULT_WEBSOCKET_PING_INTERVAL = 1 * 1000L;

  public static final String HTTP_PROTOCOL_PREFIX = "http://";
  public static final String HTTPS_PROTOCOL_PREFIX = "https://";

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
  private String httpProxy;
  private String httpsProxy;
  private String[] noProxy;
  private String userAgent;
  private TlsVersion[] tlsVersions = new TlsVersion[]{TLS_1_2};

  private Map<Integer, String> errorMessages = new HashMap<>();

  public Config() {
    if (!tryKubeConfig(this)) {
      tryServiceAccount(this);
      tryNamespaceFromPath(this);
    }
    configFromSysPropsOrEnvVars(this);

    if (!this.masterUrl.toLowerCase().startsWith(HTTP_PROTOCOL_PREFIX) && !this.masterUrl.toLowerCase().startsWith(HTTPS_PROTOCOL_PREFIX)) {
      this.masterUrl = (SSLUtils.isHttpsAvailable(this) ? HTTPS_PROTOCOL_PREFIX : HTTP_PROTOCOL_PREFIX) + this.masterUrl;
    }

    if (!this.masterUrl.endsWith("/")) {
      this.masterUrl = this.masterUrl + "/";
    }
  }

  @Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", editableEnabled = false)
  public Config(String masterUrl, String apiVersion, String namespace, boolean trustCerts, String caCertFile, String caCertData, String clientCertFile, String clientCertData, String clientKeyFile, String clientKeyData, String clientKeyAlgo, String clientKeyPassphrase, String username, String password, String oauthToken, int watchReconnectInterval, int watchReconnectLimit, int connectionTimeout, int requestTimeout, long rollingTimeout, long scaleTimeout, int loggingInterval, String httpProxy, String httpsProxy, String[] noProxy, Map<Integer, String> errorMessages, String userAgent, TlsVersion[] tlsVersions, long websocketTimeout, long websocketPingInterval) {
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
    this.username = username;
    this.password = password;
    this.oauthToken = oauthToken;
    this.watchReconnectInterval = watchReconnectInterval;
    this.watchReconnectLimit = watchReconnectLimit;
    this.connectionTimeout = connectionTimeout;
    this.requestTimeout = requestTimeout;
    this.rollingTimeout = rollingTimeout;
    this.scaleTimeout = scaleTimeout;
    this.loggingInterval = loggingInterval;
    this.httpProxy= httpProxy;
    this.httpsProxy= httpsProxy;
    this.noProxy= noProxy;
    this.errorMessages = errorMessages;
    this.userAgent = userAgent;
    this.tlsVersions = tlsVersions;
    this.websocketTimeout = websocketTimeout;
    this.websocketPingInterval = websocketPingInterval;

    if (!this.masterUrl.toLowerCase().startsWith(HTTP_PROTOCOL_PREFIX) && !this.masterUrl.startsWith(HTTPS_PROTOCOL_PREFIX)) {
      this.masterUrl = (SSLUtils.isHttpsAvailable(this) ? HTTPS_PROTOCOL_PREFIX : HTTP_PROTOCOL_PREFIX) + this.masterUrl;
    }

    if (!this.masterUrl.endsWith("/")) {
      this.masterUrl = this.masterUrl + "/";
    }
  }

  public void configFromSysPropsOrEnvVars(Config config) {
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

    config.setHttpProxy(Utils.getSystemPropertyOrEnvVar(KUBERNETES_ALL_PROXY, config.getHttpProxy()));
    config.setHttpsProxy(Utils.getSystemPropertyOrEnvVar(KUBERNETES_ALL_PROXY, config.getHttpsProxy()));

    config.setHttpsProxy(Utils.getSystemPropertyOrEnvVar(KUBERNETES_HTTPS_PROXY, config.getHttpsProxy()));
    config.setHttpProxy(Utils.getSystemPropertyOrEnvVar(KUBERNETES_HTTP_PROXY, config.getHttpProxy()));

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

  private boolean tryServiceAccount(Config config) {
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

  private String absolutify(File relativeTo, String filename) {
    if (filename == null) {
      return null;
    }

    File file = new File(filename);
    if (file.isAbsolute()) {
      return file.getAbsolutePath();
    }

    return new File(relativeTo.getParentFile(), filename).getAbsolutePath();
  }

  private boolean tryKubeConfig(Config config) {
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

  private boolean tryNamespaceFromPath(Config config) {
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

  private String getHomeDir() {
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

  public String getOauthToken() {
    return oauthToken;
  }

  public void setOauthToken(String oauthToken) {
    this.oauthToken = oauthToken;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getClientKeyPassphrase() {
    return clientKeyPassphrase;
  }

  public void setClientKeyPassphrase(String clientKeyPassphrase) {
    this.clientKeyPassphrase = clientKeyPassphrase;
  }

  public String getClientKeyAlgo() {
    return clientKeyAlgo;
  }

  public void setClientKeyAlgo(String clientKeyAlgo) {
    this.clientKeyAlgo = clientKeyAlgo;
  }

  public String getClientKeyData() {
    return clientKeyData;
  }

  public void setClientKeyData(String clientKeyData) {
    this.clientKeyData = clientKeyData;
  }

  public String getClientKeyFile() {
    return clientKeyFile;
  }

  public void setClientKeyFile(String clientKeyFile) {
    this.clientKeyFile = clientKeyFile;
  }

  public String getClientCertData() {
    return clientCertData;
  }

  public void setClientCertData(String clientCertData) {
    this.clientCertData = clientCertData;
  }

  public String getClientCertFile() {
    return clientCertFile;
  }

  public void setClientCertFile(String clientCertFile) {
    this.clientCertFile = clientCertFile;
  }

  public String getCaCertData() {
    return caCertData;
  }

  public void setCaCertData(String caCertData) {
    this.caCertData = caCertData;
  }

  public String getCaCertFile() {
    return caCertFile;
  }

  public void setCaCertFile(String caCertFile) {
    this.caCertFile = caCertFile;
  }

  public String getApiVersion() {
    return apiVersion;
  }

  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }

  public String getMasterUrl() {
    return masterUrl;
  }

  public void setMasterUrl(String masterUrl) {
    this.masterUrl = masterUrl;
  }

  public boolean isTrustCerts() {
    return trustCerts;
  }

  public void setTrustCerts(boolean trustCerts) {
    this.trustCerts = trustCerts;
  }

  public int getWatchReconnectInterval() {
    return watchReconnectInterval;
  }

  public void setWatchReconnectInterval(int watchReconnectInterval) {
    this.watchReconnectInterval = watchReconnectInterval;
  }

  public int getWatchReconnectLimit() {
    return watchReconnectLimit;
  }

  public void setWatchReconnectLimit(int watchReconnectLimit) {
    this.watchReconnectLimit = watchReconnectLimit;
  }

  public Map<Integer, String> getErrorMessages() {
    return errorMessages;
  }

  public void setErrorMessages(Map<Integer, String> errorMessages) {
    this.errorMessages = errorMessages;
  }

  public static ConfigBuilder builder() {
    return new ConfigBuilder();
  }

  public int getConnectionTimeout() {
    return connectionTimeout;
  }

  public void setConnectionTimeout(int connectionTimeout) {
    this.connectionTimeout = connectionTimeout;
  }

  public int getRequestTimeout() {
    return requestTimeout;
  }

  public void setRequestTimeout(int requestTimeout) {
    this.requestTimeout = requestTimeout;
  }

  public long getRollingTimeout() {
    return rollingTimeout;
  }

  public void setRollingTimeout(long rollingTimeout) {
    this.rollingTimeout = rollingTimeout;
  }

  public long getScaleTimeout() {
    return scaleTimeout;
  }

  public void setScaleTimeout(long scaleTimeout) {
    this.scaleTimeout = scaleTimeout;
  }

  public int getLoggingInterval() {
    return loggingInterval;
  }

  public void setLoggingInterval(int loggingInterval) {
    this.loggingInterval = loggingInterval;
  }

  public void setHttpProxy(String httpProxy) {
    this.httpProxy= httpProxy;
  }

  public String getHttpProxy() {
    return httpProxy;
  }

  public void setHttpsProxy(String httpsProxy) {
    this.httpsProxy= httpsProxy;
  }

  public String getHttpsProxy() {
    return httpsProxy;
  }

  public void setNoProxy(String[] noProxy) {
    this.noProxy = noProxy;
  }

  public String[] getNoProxy() {
    return noProxy;
  }

  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  public TlsVersion[] getTlsVersions() {
    return tlsVersions;
  }

  public void setTlsVersions(TlsVersion[] tlsVersions) {
    this.tlsVersions = tlsVersions;
  }

  public long getWebsocketTimeout() {
    return websocketTimeout;
  }

  public void setWebsocketTimeout(long websocketTimeout) {
    this.websocketTimeout = websocketTimeout;
  }

  public long getWebsocketPingInterval() {
    return websocketPingInterval;
  }

  public void setWebsocketPingInterval(long websocketPingInterval) {
    this.websocketPingInterval = websocketPingInterval;
  }
}
