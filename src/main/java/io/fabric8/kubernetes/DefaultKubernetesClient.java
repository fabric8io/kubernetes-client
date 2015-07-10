package io.fabric8.kubernetes;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Realm;
import com.ning.http.client.filter.FilterContext;
import com.ning.http.client.filter.FilterException;
import com.ning.http.client.filter.RequestFilter;
import io.fabric8.kubernetes.api.model.*;
import org.jboss.netty.handler.ssl.util.InsecureTrustManagerFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;

public class DefaultKubernetesClient implements KubernetesClient {

  public static final String KUBERNETES_MASTER_SYSTEM_PROPERTY = "kubernetes.master";
  public static final String KUBERNETES_API_VERSION_SYSTEM_PROPERTY = "kubernetes.api.version";
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

  private DefaultKubernetesClient(String masterUrl, AsyncHttpClient httpClient) throws KubernetesClientException {

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
  public Resource<NamespaceList, Namespace, NamespaceBuilder> namespaces() {
    return new Resource<>(httpClient, masterUrl, "namespaces", NamespaceList.class, Namespace.class, NamespaceBuilder.class);
  }

  @Override
  public Resource<PodList, Pod, PodBuilder> pods() {
    return new Resource<>(httpClient, masterUrl, "pods", PodList.class, Pod.class, PodBuilder.class);
  }

  @Override
  public Resource<ReplicationControllerList, ReplicationController, ReplicationControllerBuilder> replicationControllers() {
    return new Resource<>(httpClient, masterUrl, "replicationcontrollers", ReplicationControllerList.class, ReplicationController.class, ReplicationControllerBuilder.class);
  }

  @Override
  public Resource<ServiceList, Service, ServiceBuilder> services() {
    return new Resource<>(httpClient, masterUrl, "services", ServiceList.class, Service.class, ServiceBuilder.class);
  }

  public static class Builder {
    private boolean trustCerts = false;
    private String masterUrl;
    private String apiVersion = "v1";
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

    public Builder() {
    }

    public KubernetesClient build() throws KubernetesClientException {
      try {
        if (!masterUrl.endsWith("/")) {
          masterUrl += "/";
        }
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

        return new DefaultKubernetesClient(masterUrl, httpClient);
      } catch (UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException | KeyManagementException | InvalidKeySpecException | IOException | CertificateException e) {
        throw new KubernetesClientException("Could not create HTTP client", e);
      }
    }

    public Builder configFromSysPropsOrEnvVars() {
      trustCerts = Utils.getSystemPropertyOrEnvVar(KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY, trustCerts);
      masterUrl = Utils.getSystemPropertyOrEnvVar(KUBERNETES_MASTER_SYSTEM_PROPERTY, masterUrl);
      apiVersion = Utils.getSystemPropertyOrEnvVar(KUBERNETES_API_VERSION_SYSTEM_PROPERTY, apiVersion);
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

      return this;
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

    public Builder enabledProtocols(String[] enabledProtocols) {
      this.enabledProtocols = enabledProtocols;
      return this;
    }

    public Builder trustCerts(boolean trustCerts) {
      this.trustCerts = trustCerts;
      return this;
    }

    public Builder caCertFile(String caCertFile) {
      this.caCertFile = caCertFile;
      return this;
    }

    public Builder caCertData(String caCertData) {
      this.caCertData = caCertData;
      return this;
    }

    public Builder clientCertFile(String clientCertFile) {
      this.clientCertFile = clientCertFile;
      return this;
    }

    public Builder clientCertData(String clientCertData) {
      this.clientCertData = clientCertData;
      return this;
    }

    public Builder clientKeyFile(String clientKeyFile) {
      this.clientKeyFile = clientKeyFile;
      return this;
    }

    public Builder clientKeyData(String clientKeyData) {
      this.clientKeyData = clientKeyData;
      return this;
    }

    public Builder clientKeyAlgo(String clientKeyAlgo) {
      this.clientKeyAlgo = clientKeyAlgo;
      return this;
    }

    public Builder clientKeyPassphrase(char[] clientKeyPassphrase) {
      this.clientKeyPassphrase = clientKeyPassphrase;
      return this;
    }

    public Builder masterUrl(String masterUrl) {
      this.masterUrl = masterUrl;
      return this;
    }

    public Builder apiVersion(String apiVersion) {
      this.apiVersion = apiVersion;
      return this;
    }

    public Builder basicAuth(String username, String password) {
      this.username = username;
      this.password = password;
      return this;
    }

    public Builder token(String token) {
      this.oauthToken = token;
      return this;
    }

    public Builder tryServiceAccountToken() {
      tryServiceToken();
      return this;
    }
  }
}
