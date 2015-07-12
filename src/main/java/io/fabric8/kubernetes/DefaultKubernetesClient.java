package io.fabric8.kubernetes;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Realm;
import com.ning.http.client.filter.FilterContext;
import com.ning.http.client.filter.FilterException;
import com.ning.http.client.filter.RequestFilter;
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.internal.Utils;
import io.fabric8.openshift.api.model.*;
import org.jboss.netty.handler.ssl.util.InsecureTrustManagerFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;

public class DefaultKubernetesClient implements KubernetesClient, OpenShiftClient {

  public static final String KUBERNETES_MASTER_SYSTEM_PROPERTY = "kubernetes.master";
  public static final String KUBERNETES_API_VERSION_SYSTEM_PROPERTY = "kubernetes.api.version";
  public static final String KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY = "kubernetes.oapi.version";
  public static final String KUBERNETES_TLS_PROTOCOLS_SYSTEM_PROPERTY = "kubernetes.tls.protocols";

  public static final String KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY = "kubernetes.certs.ca.file";
  public static final String KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY = "kubernetes.certs.ca.data";
  public static final String KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY = "kubernetes.certs.client.file";
  public static final String KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY = "kubernetes.certs.client.data";
  public static final String KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY = "kubernetes.certs.client.key.file";
  public static final String KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY = "kubernetes.certs.client.key.data";
  public static final String KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY = "kubernetes.certs.client.key.algo";
  public static final String KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY = "kubernetes.certs.client.key.passphrase";

  public static final String KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY = "kubernetes.trust.certificates";

  public static final String KUBERNETES_USERNAME = "kubernetes.auth.basic.username";
  public static final String KUBERNETES_PASSWORD = "kubernetes.auth.basic.password";

  public static final String KUBERNETES_TRY_SERVICE_TOKEN = "kubernetes.auth.tryServiceToken";
  public static final String KUBERNETES_OAUTH_TOKEN = "kubernetes.auth.token";

  public static final String KUBERNETES_SERVICE_ACCOUNT_TOKEN_PATH = "/var/run/secrets/kubernetes.io/serviceaccount/token";

  private AsyncHttpClient httpClient;
  private URL masterUrl;
  private URL openShiftUrl;

  private DefaultKubernetesClient(String masterUrl, String openShiftUrl, AsyncHttpClient httpClient) throws KubernetesClientException {

    if (masterUrl == null) {
      throw new KubernetesClientException("Unknown Kubernetes master URL - " +
        "please set with the builder, or set with either system property \"" + KUBERNETES_MASTER_SYSTEM_PROPERTY + "\"" +
        " or environment variable \"" + Utils.convertSystemPropertyNameToEnvVar(KUBERNETES_MASTER_SYSTEM_PROPERTY) + "\"");
    }

    try {
      if (!masterUrl.endsWith("/")) {
        masterUrl += "/";
      }
      this.masterUrl = new URL(masterUrl);

      if (!openShiftUrl.endsWith("/")) {
        openShiftUrl += "/";
      }
      this.openShiftUrl = new URL(openShiftUrl);

      this.httpClient = httpClient;
    } catch (Exception e) {
      throw new KubernetesClientException("Could not create Kubernetes client", e);
    }
  }

  @Override
  public void close() {
    httpClient.close();
  }

  @Override
  public NamespaceAwareResourceList<Endpoints, EndpointsList, EndpointsBuilder> endpoints() {
    return new io.fabric8.kubernetes.internal.NamespaceAwareResourceList<>(httpClient, masterUrl, "endpoints", Endpoints.class, EndpointsList.class, EndpointsBuilder.class);
  }

  @Override
  public NonNamespacedResourceList<Namespace, NamespaceList, NamespaceBuilder> namespaces() {
    return new io.fabric8.kubernetes.internal.NonNamespacedResourceList<>(httpClient, masterUrl, "namespaces", Namespace.class, NamespaceList.class, NamespaceBuilder.class);
  }

  @Override
  public NonNamespacedResourceList<Node, NodeList, NodeBuilder> nodes() {
    return new io.fabric8.kubernetes.internal.NonNamespacedResourceList<>(httpClient, masterUrl, "nodes", Node.class, NodeList.class, NodeBuilder.class);
  }

  @Override
  public NamespaceAwareResourceList<Pod, PodList, PodBuilder> pods() {
    return new io.fabric8.kubernetes.internal.NamespaceAwareResourceList<>(httpClient, masterUrl, "pods", Pod.class, PodList.class, PodBuilder.class);
  }

  @Override
  public NamespaceAwareResourceList<ReplicationController, ReplicationControllerList, ReplicationControllerBuilder> replicationControllers() {
    return new io.fabric8.kubernetes.internal.NamespaceAwareResourceList<>(httpClient, masterUrl, "replicationcontrollers", ReplicationController.class, ReplicationControllerList.class, ReplicationControllerBuilder.class);
  }

  @Override
  public NamespaceAwareResourceList<Secret, SecretList, SecretBuilder> secrets() {
    return new io.fabric8.kubernetes.internal.NamespaceAwareResourceList<>(httpClient, masterUrl, "secrets", Secret.class, SecretList.class, SecretBuilder.class);
  }

  @Override
  public NamespaceAwareResourceList<Service, ServiceList, ServiceBuilder> services() {
    return new io.fabric8.kubernetes.internal.NamespaceAwareResourceList<>(httpClient, masterUrl, "services", Service.class, ServiceList.class, ServiceBuilder.class);
  }

  @Override
  public NamespaceAwareResourceList<ServiceAccount, ServiceAccountList, ServiceAccountBuilder> serviceAccounts() {
    return new io.fabric8.kubernetes.internal.NamespaceAwareResourceList<>(httpClient, masterUrl, "serviceaccounts", ServiceAccount.class, ServiceAccountList.class, ServiceAccountBuilder.class);
  }

  @Override
  public NamespaceAwareResourceList<BuildConfig, BuildConfigList, BuildConfigBuilder> buildConfigs() {
    return new io.fabric8.kubernetes.internal.NamespaceAwareResourceList<>(httpClient, openShiftUrl, "buildconfigs", BuildConfig.class, BuildConfigList.class, BuildConfigBuilder.class);
  }

  @Override
  public NamespaceAwareResourceList<DeploymentConfig, DeploymentConfigList, DeploymentConfigBuilder> deploymentConfigs() {
    return new io.fabric8.kubernetes.internal.NamespaceAwareResourceList<>(httpClient, openShiftUrl, "deploymentconfigs", DeploymentConfig.class, DeploymentConfigList.class, DeploymentConfigBuilder.class);
  }

  @Override
  public NamespaceAwareResourceList<ImageStream, ImageStreamList, ImageStreamBuilder> imageStreams() {
    return new io.fabric8.kubernetes.internal.NamespaceAwareResourceList<>(httpClient, openShiftUrl, "imagestreams", ImageStream.class, ImageStreamList.class, ImageStreamBuilder.class);
  }

  @Override
  public NonNamespacedResourceList<OAuthAccessToken, OAuthAccessTokenList, OAuthAccessTokenBuilder> oAuthAccessTokens() {
    return new io.fabric8.kubernetes.internal.NonNamespacedResourceList<>(httpClient, openShiftUrl, "oauthaccesstokens", OAuthAccessToken.class, OAuthAccessTokenList.class, OAuthAccessTokenBuilder.class);
  }

  @Override
  public NonNamespacedResourceList<OAuthAuthorizeToken, OAuthAuthorizeTokenList, OAuthAuthorizeTokenBuilder> oAuthAuthorizeTokens() {
    return new io.fabric8.kubernetes.internal.NonNamespacedResourceList<>(httpClient, openShiftUrl, "oauthauthorizetokens", OAuthAuthorizeToken.class, OAuthAuthorizeTokenList.class, OAuthAuthorizeTokenBuilder.class);
  }

  @Override
  public NonNamespacedResourceList<OAuthClient, OAuthClientList, OAuthClientBuilder> oAuthClients() {
    return new io.fabric8.kubernetes.internal.NonNamespacedResourceList<>(httpClient, openShiftUrl, "oauthclients", OAuthClient.class, OAuthClientList.class, OAuthClientBuilder.class);
  }

  @Override
  public NamespaceAwareResourceList<Route, RouteList, RouteBuilder> routes() {
    return new io.fabric8.kubernetes.internal.NamespaceAwareResourceList<>(httpClient, openShiftUrl, "routes", Route.class, RouteList.class, RouteBuilder.class);
  }

  private static abstract class AbstractBuilder<T extends AbstractBuilder> {
    protected boolean trustCerts = false;
    protected String masterUrl;
    protected String apiVersion = "v1";
    protected String oapiVersion = "v1";
    protected String[] enabledProtocols = new String[]{"TLSv1.2"};
    protected String caCertFile;
    protected String caCertData;
    protected String clientCertFile;
    protected String clientCertData;
    protected String clientKeyFile;
    protected String clientKeyData;
    protected String clientKeyAlgo = "RSA";
    protected char[] clientKeyPassphrase = "changeit".toCharArray();
    protected String username;
    protected String password;
    protected String oauthToken;

    public KubernetesClient build() throws KubernetesClientException {
      try {
        if (!masterUrl.endsWith("/")) {
          masterUrl += "/";
        }
        String openShiftUrl = masterUrl + "oapi/" + oapiVersion;
        masterUrl += "api/" + apiVersion;

        AsyncHttpClientConfig.Builder clientConfigBuilder = new AsyncHttpClientConfig.Builder();

        clientConfigBuilder.setEnabledProtocols(enabledProtocols);

        // Follow any redirects
        clientConfigBuilder.setFollowRedirect(true);

        // Should we disable all server certificate checks?
        clientConfigBuilder.setAcceptAnyCertificate(this.trustCerts);

        TrustManager[] trustManagers = null;
        if (caCertFile != null || caCertData != null) {
          KeyStore trustStore = Utils.createTrustStore(caCertData, caCertFile);
          TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
          tmf.init(trustStore);
          trustManagers = tmf.getTrustManagers();
        }

        KeyManager[] keyManagers = null;
        if ((clientCertFile != null || clientCertData != null) && (clientKeyFile != null || clientKeyData != null)) {
          KeyStore keyStore = Utils.createKeyStore(clientCertData, clientCertFile, clientKeyData, clientKeyFile, clientKeyAlgo, clientKeyPassphrase);
          KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
          kmf.init(keyStore, clientKeyPassphrase);
          keyManagers = kmf.getKeyManagers();
        }

        if (keyManagers != null || trustManagers != null) {
          if (trustManagers == null && trustCerts) {
            trustManagers = InsecureTrustManagerFactory.INSTANCE.getTrustManagers();
            clientConfigBuilder.setHostnameVerifier(null);
          }
          SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
          sslContext.init(keyManagers, trustManagers, new SecureRandom());
          clientConfigBuilder.setSSLContext(sslContext);
        }

        if (username != null && password != null) {
          Realm realm = new Realm.RealmBuilder()
            .setPrincipal(username)
            .setPassword(password)
            .setUsePreemptiveAuth(true)
            .setScheme(Realm.AuthScheme.BASIC)
            .build();
          clientConfigBuilder.setRealm(realm);
        } else if (oauthToken != null) {
          clientConfigBuilder.addRequestFilter(new RequestFilter() {
            @Override
            public <T> FilterContext<T> filter(FilterContext<T> ctx) throws FilterException {
              ctx.getRequest().getHeaders().add("Authorization", "Bearer " + oauthToken);
              return ctx;
            }
          });
        }

        AsyncHttpClient httpClient = new AsyncHttpClient(clientConfigBuilder.build());

        return new DefaultKubernetesClient(masterUrl, openShiftUrl, httpClient);
      } catch (UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException | KeyManagementException | InvalidKeySpecException | IOException | CertificateException e) {
        throw new KubernetesClientException("Could not create HTTP client", e);
      }
    }

    public T configFromSysPropsOrEnvVars() {
      trustCerts = Utils.getSystemPropertyOrEnvVar(KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY, trustCerts);
      masterUrl = Utils.getSystemPropertyOrEnvVar(KUBERNETES_MASTER_SYSTEM_PROPERTY, masterUrl);
      apiVersion = Utils.getSystemPropertyOrEnvVar(KUBERNETES_API_VERSION_SYSTEM_PROPERTY, apiVersion);
      oapiVersion = Utils.getSystemPropertyOrEnvVar(KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY, oapiVersion);
      caCertFile = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY, caCertFile);
      caCertData = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY, caCertData);
      clientCertFile = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY, clientCertFile);
      clientCertData = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY, clientCertData);
      clientKeyFile = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY, clientKeyFile);
      clientKeyData = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY, clientKeyData);
      clientKeyAlgo = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY, clientKeyAlgo);
      clientKeyPassphrase = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY, new String(clientKeyPassphrase)).toCharArray();

      oauthToken = Utils.getSystemPropertyOrEnvVar(KUBERNETES_OAUTH_TOKEN, oauthToken);
      username = Utils.getSystemPropertyOrEnvVar(KUBERNETES_USERNAME, username);
      password = Utils.getSystemPropertyOrEnvVar(KUBERNETES_PASSWORD, password);
      String configuredProtocols = Utils.getSystemPropertyOrEnvVar(KUBERNETES_TLS_PROTOCOLS_SYSTEM_PROPERTY);
      if (configuredProtocols != null) {
        enabledProtocols = configuredProtocols.split(",");
      }
      boolean tryServiceToken = Utils.getSystemPropertyOrEnvVar(KUBERNETES_TRY_SERVICE_TOKEN, true);
      if (tryServiceToken) {
        tryServiceToken();
      }

      return (T) this;
    }

    private void tryServiceToken() {
      try {
        String serviceTokenCandidate = new String(Files.readAllBytes(Paths.get(KUBERNETES_SERVICE_ACCOUNT_TOKEN_PATH)));
        if (serviceTokenCandidate != null) {
          oauthToken = serviceTokenCandidate;
        }
      } catch (IOException e) {
        // No service account token available...
      }
    }

    public T enabledProtocols(String[] enabledProtocols) {
      this.enabledProtocols = enabledProtocols;
      return (T) this;
    }

    public T trustCerts(boolean trustCerts) {
      this.trustCerts = trustCerts;
      return (T) this;
    }

    public T caCertFile(String caCertFile) {
      this.caCertFile = caCertFile;
      return (T) this;
    }

    public T caCertData(String caCertData) {
      this.caCertData = caCertData;
      return (T) this;
    }

    public T clientCertFile(String clientCertFile) {
      this.clientCertFile = clientCertFile;
      return (T) this;
    }

    public T clientCertData(String clientCertData) {
      this.clientCertData = clientCertData;
      return (T) this;
    }

    public T clientKeyFile(String clientKeyFile) {
      this.clientKeyFile = clientKeyFile;
      return (T) this;
    }

    public T clientKeyData(String clientKeyData) {
      this.clientKeyData = clientKeyData;
      return (T) this;
    }

    public T clientKeyAlgo(String clientKeyAlgo) {
      this.clientKeyAlgo = clientKeyAlgo;
      return (T) this;
    }

    public T clientKeyPassphrase(char[] clientKeyPassphrase) {
      this.clientKeyPassphrase = clientKeyPassphrase;
      return (T) this;
    }

    public T masterUrl(String masterUrl) {
      this.masterUrl = masterUrl;
      return (T) this;
    }

    public T apiVersion(String apiVersion) {
      this.apiVersion = apiVersion;
      return (T) this;
    }

    public T basicAuth(String username, String password) {
      this.username = username;
      this.password = password;
      return (T) this;
    }

    public T token(String token) {
      this.oauthToken = token;
      return (T) this;
    }

    public T tryServiceAccountToken() {
      tryServiceToken();
      return (T) this;
    }
  }

  public static class Builder extends AbstractBuilder<Builder> {
    public Builder() {
    }

    public KubernetesClient build() throws KubernetesClientException {
      return (KubernetesClient) super.build();
    }
  }

  public static class OpenShiftBuilder extends AbstractBuilder<OpenShiftBuilder> {
    public OpenShiftBuilder() {
    }

    public OpenShiftClient build() throws KubernetesClientException {
      return (OpenShiftClient) super.build();
    }

    public OpenShiftBuilder oapiVersion(String oapiVersion) {
      this.oapiVersion = oapiVersion;
      return this;
    }
  }
}
