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

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Realm;
import com.ning.http.client.filter.FilterContext;
import com.ning.http.client.filter.FilterException;
import com.ning.http.client.filter.RequestFilter;
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.dsl.*;
import io.fabric8.kubernetes.client.dsl.internal.*;
import io.fabric8.kubernetes.client.internal.KubeConfigUtils;
import io.fabric8.kubernetes.client.internal.Utils;
import io.fabric8.openshift.api.model.*;
import org.jboss.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;

import static io.fabric8.kubernetes.client.internal.CertUtils.createKeyStore;
import static io.fabric8.kubernetes.client.internal.CertUtils.createTrustStore;

public class DefaultKubernetesClient implements KubernetesClient, OpenShiftClient {

  public static final String KUBERNETES_MASTER_SYSTEM_PROPERTY = "kubernetes.master";
  public static final String KUBERNETES_API_VERSION_SYSTEM_PROPERTY = "kubernetes.api.version";
  public static final String KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY = "kubernetes.oapi.version";

  public static final String KUBERNETES_TLS_PROTOCOLS_SYSTEM_PROPERTY = "kubernetes.tls.protocols";
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

  public static final String KUBERNETES_KUBECONFIG_FILE = "kubeconfig";
  public static final String KUBERNETES_SERVICE_ACCOUNT_TOKEN_PATH = "/var/run/secrets/kubernetes.io/serviceaccount/token";
  public static final String KUBERNETES_SERVICE_ACCOUNT_CA_CRT_PATH = "/var/run/secrets/kubernetes.io/serviceaccount/ca.crt";

  private AsyncHttpClient httpClient;
  private URL masterUrl;
  private URL openShiftUrl;

  public DefaultKubernetesClient() throws KubernetesClientException {
    this(new ConfigBuilder().build());
  }

  public DefaultKubernetesClient(final Config config) throws KubernetesClientException {
    if (config.getMasterUrl() == null) {
      throw new KubernetesClientException("Unknown Kubernetes master URL - " +
        "please set with the builder, or set with either system property \"" + KUBERNETES_MASTER_SYSTEM_PROPERTY + "\"" +
        " or environment variable \"" + Utils.convertSystemPropertyNameToEnvVar(KUBERNETES_MASTER_SYSTEM_PROPERTY) + "\"");
    }

    try {
      this.masterUrl = new URL(config.getMasterUrl());
      this.openShiftUrl = new URL(config.getOpenShiftUrl());

      AsyncHttpClientConfig.Builder clientConfigBuilder = new AsyncHttpClientConfig.Builder();

      clientConfigBuilder.setEnabledProtocols(config.getEnabledProtocols());

      // Follow any redirects
      clientConfigBuilder.setFollowRedirect(true);

      // Should we disable all server certificate checks?
      clientConfigBuilder.setAcceptAnyCertificate(config.isTrustCerts());

      TrustManager[] trustManagers = null;
      if (config.getCaCertFile() != null || config.getCaCertData() != null) {
        KeyStore trustStore = createTrustStore(config.getCaCertData(), config.getCaCertFile());
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);
        trustManagers = tmf.getTrustManagers();
      }

      KeyManager[] keyManagers = null;
      if ((config.getClientCertFile() != null || config.getClientCertData() != null) && (config.getClientKeyFile() != null || config.getClientKeyData() != null)) {
        KeyStore keyStore = createKeyStore(config.getClientCertData(), config.getClientCertFile(), config.getClientKeyData(), config.getClientKeyFile(), config.getClientKeyAlgo(), config.getClientKeyPassphrase());
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, config.getClientKeyPassphrase());
        keyManagers = kmf.getKeyManagers();
      }

      if (keyManagers != null || trustManagers != null) {
        if (trustManagers == null && config.isTrustCerts()) {
          trustManagers = InsecureTrustManagerFactory.INSTANCE.getTrustManagers();
          clientConfigBuilder.setHostnameVerifier(null);
        }
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(keyManagers, trustManagers, new SecureRandom());
        clientConfigBuilder.setSSLContext(sslContext);
      }

      if (config.getUsername() != null && config.getPassword() != null) {
        Realm realm = new Realm.RealmBuilder()
          .setPrincipal(config.getUsername())
          .setPassword(config.getPassword())
          .setUsePreemptiveAuth(true)
          .setScheme(Realm.AuthScheme.BASIC)
          .build();
        clientConfigBuilder.setRealm(realm);
      } else if (config.getOauthToken() != null) {
        clientConfigBuilder.addRequestFilter(new RequestFilter() {
          @Override
          public <T> FilterContext<T> filter(FilterContext<T> ctx) throws FilterException {
            ctx.getRequest().getHeaders().add("Authorization", "Bearer " + config.getOauthToken());
            return ctx;
          }
        });
      }

      this.httpClient = new AsyncHttpClient(clientConfigBuilder.build());
    } catch (UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException | KeyManagementException | InvalidKeySpecException | IOException | CertificateException e) {
      throw new KubernetesClientException("Could not create HTTP client", e);
    }
  }

  public DefaultKubernetesClient(String masterUrl) throws KubernetesClientException {
   this(new ConfigBuilder().masterUrl(masterUrl).build());
  }

  @Override
  public void close() {
    httpClient.close();
  }

  @Override
  public ClientOperation<KubernetesClient, Endpoints, EndpointsList, DoneableEndpoints, ClientResource<Endpoints, DoneableEndpoints>> endpoints() {
    return new EndpointsOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, Event, EventList, DoneableEvent, ClientResource<Event, DoneableEvent>> events() {
    return new EventOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<KubernetesClient, Namespace, NamespaceList, DoneableNamespace, ClientResource<Namespace, DoneableNamespace>> namespaces() {
    return new NamespaceOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<KubernetesClient, Node, NodeList, DoneableNode, ClientResource<Node, DoneableNode>> nodes() {
    return new NodeOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, ClientResource<PersistentVolume, DoneablePersistentVolume>> persistentVolumes() {
    return new PersistentVolumeOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, ClientResource<PersistentVolumeClaim, DoneablePersistentVolumeClaim>> persistentVolumeClaims() {
    return new PersistentVolumeClaimOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, Pod, PodList, DoneablePod, ClientResource<Pod, DoneablePod>> pods() {
    return new PodOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, ReplicationController, ReplicationControllerList, DoneableReplicationController, ReplicationControllerClientResource<ReplicationController, DoneableReplicationController>> replicationControllers() {
    return new ReplicationControllerOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, ResourceQuota, ResourceQuotaList, DoneableResourceQuota, ClientResource<ResourceQuota, DoneableResourceQuota>> resourceQuotas() {
    return new ResourceQuotaOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, Secret, SecretList, DoneableSecret, ClientResource<Secret, DoneableSecret>> secrets() {
    return new SecretOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, Service, ServiceList, DoneableService, ClientResource<Service, DoneableService>> services() {
    return new ServiceOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, ServiceAccount, ServiceAccountList, DoneableServiceAccount, ClientResource<ServiceAccount, DoneableServiceAccount>> serviceAccounts() {
    return new ServiceAccountOperationsImpl(this);
  }

  @Override
  public ClientOperation<OpenShiftClient, Template, TemplateList, DoneableTemplate, ProcessableClientResource<Template, DoneableTemplate>> templates() {
    return new TemplateOperationsImpl(this);
  }

  @Override
  public AsyncHttpClient getHttpClient() {
    return httpClient;
  }

  @Override
  public URL getMasterUrl() {
    return masterUrl;
  }

  @Override
  public URL getOpenshiftUrl() {
    return openShiftUrl;
  }

  @Override
  public RootPaths rootPaths() {
    return (RootPaths) new BaseOperation(this, "", null, null, KubernetesClient.class, RootPaths.class, null, null) {
    }.get();
  }


  @Override
  public ClientOperation<OpenShiftClient, Build, BuildList, DoneableBuild, ClientResource<Build, DoneableBuild>> builds() {
    return new BuildOperationsImpl(this);
  }

  @Override
  public ClientOperation<OpenShiftClient, BuildConfig, BuildConfigList, DoneableBuildConfig, BuildConfigClientResource<BuildConfig, DoneableBuildConfig, Void, Void>> buildConfigs() {
    return new BuildConfigOperationsImpl(this, null, null);
  }

  @Override
  public ClientOperation<OpenShiftClient, DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig, ClientResource<DeploymentConfig, DoneableDeploymentConfig>> deploymentConfigs() {
    return new DeploymentConfigOperationsImpl(this);
  }

  @Override
  public ClientOperation<OpenShiftClient, ImageStream, ImageStreamList, DoneableImageStream, ClientResource<ImageStream, DoneableImageStream>> imageStreams() {
    return new ImageStreamOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<OpenShiftClient, OAuthAccessToken, OAuthAccessTokenList, DoneableOAuthAccessToken, ClientResource<OAuthAccessToken, DoneableOAuthAccessToken>> oAuthAccessTokens() {
    return new OAuthAccessTokenOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<OpenShiftClient, OAuthAuthorizeToken, OAuthAuthorizeTokenList, DoneableOAuthAuthorizeToken, ClientResource<OAuthAuthorizeToken, DoneableOAuthAuthorizeToken>> oAuthAuthorizeTokens() {
    return new OAuthAuthorizeTokenOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<OpenShiftClient, OAuthClient, OAuthClientList, DoneableOAuthClient, ClientResource<OAuthClient, DoneableOAuthClient>> oAuthClients() {
    return new OAuthClientOperationsImpl(this);
  }

  @Override
  public ClientOperation<OpenShiftClient, Route, RouteList, DoneableRoute, ClientResource<Route, DoneableRoute>> routes() {
    return new RouteOperationsImpl(this);
  }

  public static class Config {
    private boolean trustCerts = false;
    private String masterUrl = "https://kubernetes.default.svc";
    private String apiVersion = "v1";
    private String oapiVersion = "v1";
    private String[] enabledProtocols = new String[]{"TLSv1.2"};
    private String caCertFile;
    private String caCertData;
    private String clientCertFile;
    private String clientCertData;
    private String clientKeyFile;
    private String clientKeyData;
    private String clientKeyAlgo = "RSA";
    private char[] clientKeyPassphrase = "changeit".toCharArray();
    private String username;
    private String password;
    private String oauthToken;
    private String openShiftUrl;

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

    public char[] getClientKeyPassphrase() {
      return clientKeyPassphrase;
    }

    public void setClientKeyPassphrase(char[] clientKeyPassphrase) {
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

    public String[] getEnabledProtocols() {
      return enabledProtocols;
    }

    public void setEnabledProtocols(String[] enabledProtocols) {
      this.enabledProtocols = enabledProtocols;
    }

    public String getOapiVersion() {
      return oapiVersion;
    }

    public void setOapiVersion(String oapiVersion) {
      this.oapiVersion = oapiVersion;
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

    public String getOpenShiftUrl() {
      return openShiftUrl;
    }

    public void setOpenShiftUrl(String openShiftUrl) {
      this.openShiftUrl = openShiftUrl;
    }
  }

  public static class ConfigBuilder {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Config config = new Config();

    public ConfigBuilder() {
      if (Utils.getSystemPropertyOrEnvVar(KUBERNETES_AUTH_TRYSERVICEACCOUNT_SYSTEM_PROPERTY, true)) {
        tryServiceAccount(config);
      }
      if (Utils.getSystemPropertyOrEnvVar(KUBERNETES_AUTH_TRYKUBECONFIG_SYSTEM_PROPERTY, true)) {
        tryKubeConfig(config);
      }
      configFromSysPropsOrEnvVars(config);
    }

    public Config build() {
      if (!config.getMasterUrl().endsWith("/")) {
        config.setMasterUrl(config.getMasterUrl() + "/");
      }
      if (config.getOpenShiftUrl() == null) {
        config.setOpenShiftUrl(config.getMasterUrl() + "oapi/" + config.getOapiVersion() + "/");
      }
      config.setMasterUrl(config.getMasterUrl() + "api/" + config.getApiVersion() + "/");

      return config;
    }

    private void configFromSysPropsOrEnvVars(Config config) {
      config.setTrustCerts(Utils.getSystemPropertyOrEnvVar(KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY, config.isTrustCerts()));
      config.setMasterUrl(Utils.getSystemPropertyOrEnvVar(KUBERNETES_MASTER_SYSTEM_PROPERTY, config.getMasterUrl()));
      config.setApiVersion(Utils.getSystemPropertyOrEnvVar(KUBERNETES_API_VERSION_SYSTEM_PROPERTY, config.getApiVersion()));
      config.setOapiVersion(Utils.getSystemPropertyOrEnvVar(KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY, config.getOapiVersion()));
      config.setCaCertFile(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY, config.getCaCertFile()));
      config.setCaCertData(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY, config.getCaCertData()));
      config.setClientCertFile(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY, config.getClientCertFile()));
      config.setClientCertData(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY, config.getClientCertData()));
      config.setClientKeyFile(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY, config.getClientKeyFile()));
      config.setClientKeyData(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY, config.getClientKeyData()));
      config.setClientKeyAlgo(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY, config.getClientKeyAlgo()));
      config.setClientKeyPassphrase(Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY, new String(config.getClientKeyPassphrase())).toCharArray());

      config.setOauthToken(Utils.getSystemPropertyOrEnvVar(KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY, config.getOauthToken()));
      config.setUsername(Utils.getSystemPropertyOrEnvVar(KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY, config.getUsername()));
      config.setPassword(Utils.getSystemPropertyOrEnvVar(KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY, config.getPassword()));
      String configuredProtocols = Utils.getSystemPropertyOrEnvVar(KUBERNETES_TLS_PROTOCOLS_SYSTEM_PROPERTY);
      if (configuredProtocols != null) {
        config.setEnabledProtocols(configuredProtocols.split(","));
      }
    }

    private void tryServiceAccount(Config config) {
      boolean serviceAccountCaCertExists = Files.isRegularFile(Paths.get(KUBERNETES_SERVICE_ACCOUNT_CA_CRT_PATH));
      if (serviceAccountCaCertExists) {
        config.setCaCertFile(KUBERNETES_SERVICE_ACCOUNT_CA_CRT_PATH);
      }
      try {
        String serviceTokenCandidate = new String(Files.readAllBytes(Paths.get(KUBERNETES_SERVICE_ACCOUNT_TOKEN_PATH)));
        if (serviceTokenCandidate != null) {
          config.setOauthToken(serviceTokenCandidate);
        }
      } catch (IOException e) {
        // No service account token available...
      }
    }

    private void tryKubeConfig(Config config) {
      String kubeConfigFile = Utils.getSystemPropertyOrEnvVar(KUBERNETES_KUBECONFIG_FILE, new File(System.getProperty("user.home", "."), ".kube/config").toString());
      boolean kubeConfigFileExists = Files.isRegularFile(Paths.get(kubeConfigFile));
      if (kubeConfigFileExists) {
        try {
          io.fabric8.kubernetes.api.model.Config kubeConfig = KubeConfigUtils.parseConfig(new File(kubeConfigFile));
          Context currentContext = KubeConfigUtils.getCurrentContext(kubeConfig);
          Cluster currentCluster = KubeConfigUtils.getCluster(kubeConfig, currentContext);
          if (currentCluster != null) {
            config.setMasterUrl(currentCluster.getServer());
            config.setTrustCerts(currentCluster.getInsecureSkipTlsVerify() != null && currentCluster.getInsecureSkipTlsVerify());
            config.setCaCertFile(currentCluster.getCertificateAuthority());
            config.setCaCertData(currentCluster.getCertificateAuthorityData());
            AuthInfo currentAuthInfo = KubeConfigUtils.getUserAuthInfo(kubeConfig, currentContext);
            if (currentAuthInfo != null) {
              config.setClientCertFile(currentAuthInfo.getClientCertificate());
              config.setClientCertData(currentAuthInfo.getClientCertificateData());
              config.setClientKeyFile(currentAuthInfo.getClientKey());
              config.setClientKeyData(currentAuthInfo.getClientKeyData());
              config.setOauthToken(currentAuthInfo.getToken());
              config.setUsername(currentAuthInfo.getUsername());
              config.setPassword(currentAuthInfo.getPassword());
            }
          }
        } catch (IOException e) {
          logger.error("Could not load kube config file from {}", kubeConfigFile, e);
        }
      }
    }

    public ConfigBuilder enabledProtocols(String[] enabledProtocols) {
      config.setEnabledProtocols(enabledProtocols);
      return this;
    }

    public ConfigBuilder trustCerts(boolean trustCerts) {
      config.setTrustCerts(trustCerts);
      return this;
    }

    public ConfigBuilder caCertFile(String caCertFile) {
      config.setCaCertFile(caCertFile);
      return this;
    }

    public ConfigBuilder caCertData(String caCertData) {
      config.setCaCertData(caCertData);
      return this;
    }

    public ConfigBuilder clientCertFile(String clientCertFile) {
      config.setClientCertFile(clientCertFile);
      return this;
    }

    public ConfigBuilder clientCertData(String clientCertData) {
      config.setClientCertData(clientCertData);
      return this;
    }

    public ConfigBuilder clientKeyFile(String clientKeyFile) {
      config.setClientKeyFile(clientKeyFile);
      return this;
    }

    public ConfigBuilder clientKeyData(String clientKeyData) {
      config.setClientKeyData(clientKeyData);
      return this;
    }

    public ConfigBuilder clientKeyAlgo(String clientKeyAlgo) {
      config.setClientKeyAlgo(clientKeyAlgo);
      return this;
    }

    public ConfigBuilder clientKeyPassphrase(char[] clientKeyPassphrase) {
      config.setClientKeyPassphrase(clientKeyPassphrase);
      return this;
    }

    public ConfigBuilder masterUrl(String masterUrl) {
      config.setMasterUrl(masterUrl);
      return this;
    }

    public ConfigBuilder apiVersion(String apiVersion) {
      config.setApiVersion(apiVersion);
      return this;
    }

    public ConfigBuilder basicAuth(String username, String password) {
      config.setUsername(username);
      config.setPassword(password);
      return this;
    }

    public ConfigBuilder token(String token) {
      config.setOauthToken(token);
      return this;
    }
  }
}
