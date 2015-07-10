package io.fabric8.kubernetes;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import io.fabric8.kubernetes.api.model.*;
import org.jboss.netty.handler.ssl.util.InsecureTrustManagerFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.URL;
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
    public ResourceList<NamespaceList> namespaces() {
        return new ResourceList<NamespaceList>(httpClient, masterUrl, "namespaces", NamespaceList.class);
    }

    @Override
    public Resource<Namespace, NamespaceBuilder> namespaces(String name) {
        return new Resource<Namespace, NamespaceBuilder>(httpClient, masterUrl, "namespaces", name, Namespace.class, NamespaceBuilder.class);
    }

    @Override
    public ResourceList<PodList> pods() {
        return new ResourceList<PodList>(httpClient, masterUrl, "pods", PodList.class);
    }

    @Override
    public Resource<Pod, PodBuilder> pods(String name) {
        return new Resource<Pod, PodBuilder>(httpClient, masterUrl, "pods", name, Pod.class, PodBuilder.class);
    }

    @Override
    public ResourceList<ReplicationControllerList> replicationControllers() {
        return new ResourceList<ReplicationControllerList>(httpClient, masterUrl, "replicationcontrollers", ReplicationControllerList.class);
    }

    @Override
    public Resource<ReplicationController, ReplicationControllerBuilder> replicationControllers(String name) {
        return new Resource<ReplicationController, ReplicationControllerBuilder>(httpClient, masterUrl, "replicationcontrollers", name, ReplicationController.class, ReplicationControllerBuilder.class);
    }

    @Override
    public ResourceList<ServiceList> services() {
        return new ResourceList<ServiceList>(httpClient, masterUrl, "services", ServiceList.class);
    }

    @Override
    public Resource<Service, ServiceBuilder> services(String name) {
        return new Resource<Service, ServiceBuilder>(httpClient, masterUrl, "services", name, Service.class, ServiceBuilder.class);
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

                AsyncHttpClient httpClient = new AsyncHttpClient(clientConfigBuilder.build());
                DefaultKubernetesClient client = new DefaultKubernetesClient(masterUrl, httpClient);

                return client;
            } catch (UnrecoverableKeyException e) {
                throw new KubernetesClientException("Could not create HTTP client", e);
            } catch (NoSuchAlgorithmException e) {
                throw new KubernetesClientException("Could not create HTTP client", e);
            } catch (KeyStoreException e) {
                throw new KubernetesClientException("Could not create HTTP client", e);
            } catch (KeyManagementException e) {
                throw new KubernetesClientException("Could not create HTTP client", e);
            } catch (CertificateException e) {
                throw new KubernetesClientException("Could not create HTTP client", e);
            } catch (InvalidKeySpecException e) {
                throw new KubernetesClientException("Could not create HTTP client", e);
            } catch (IOException e) {
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
            String configuredProtocols = Utils.getSystemPropertyOrEnvVar(KUBERNETES_TLS_PROTOCOLS_SYSTEM_PROPERTY);
            if (configuredProtocols != null) {
                enabledProtocols = configuredProtocols.split(",");
            }
            return this;
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
    }
}