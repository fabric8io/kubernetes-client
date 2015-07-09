package io.fabric8.kubernetes;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import io.fabric8.kubernetes.api.model.*;
import org.jboss.netty.handler.ssl.util.InsecureTrustManagerFactory;

import javax.net.ssl.*;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;

public class KubernetesClient {

    public static final String KUBERNETES_MASTER_SYSTEM_PROPERTY = "kubernetes.master";

    public static final String KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY = "kubernetes.certs.ca.file";
    public static final String KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY = "kubernetes.certs.ca.data";
    public static final String KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY = "kubernetes.certs.client.file";
    public static final String KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY = "kubernetes.client.data";
    public static final String KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY = "kubernetes.certs.client.key.file";
    public static final String KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY = "kubernetes.certs.client.key.data";
    public static final String KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY = "kubernetes.certs.client.key.algo";
    public static final String KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY = "kubernetes.certs.client.key.passphrase";

    public static final String KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY = "kubernetes.trust.certificates";

    private AsyncHttpClient httpClient;
    private URL masterUrl;

    public KubernetesClient() throws KubernetesClientException {
        this(null);
    }

    public KubernetesClient(String masterUrl) throws KubernetesClientException {

        String discoveredMasterUrl = Utils.getSystemPropertyOrEnvVar(KUBERNETES_MASTER_SYSTEM_PROPERTY);

        if (masterUrl != null) {
            discoveredMasterUrl = masterUrl;
        }

        if (discoveredMasterUrl == null) {
            throw new KubernetesClientException("Unknown Kubernetes master URL - " +
                    "please set with either system property \"" + KUBERNETES_MASTER_SYSTEM_PROPERTY + "\"" +
                    " or environment variable \"" + Utils.convertSystemPropertyNameToEnvVar(KUBERNETES_MASTER_SYSTEM_PROPERTY) + "\"");
        }

        try {
            if (!discoveredMasterUrl.endsWith("/")) {
                discoveredMasterUrl += "/";
            }
            this.masterUrl = new URL(discoveredMasterUrl);

            AsyncHttpClientConfig clientConfig = buildClientConfig();

            httpClient = new AsyncHttpClient(clientConfig);
        } catch (Exception e) {
            throw new KubernetesClientException("Could not create HTTP client", e);
        }
    }

    public void close() {
        httpClient.close();
    }

    private AsyncHttpClientConfig buildClientConfig() throws Exception {
        AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder();

        // Only support TLSv1.2
        builder.setEnabledProtocols(new String[]{"TLSv1.2"});

        // Follow any redirects
        builder.setFollowRedirect(true);

        // Should we disable all server certificate checks?
        boolean trustAllCerts = Utils.getSystemPropertyOrEnvVar(KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY, false);
        builder.setAcceptAnyCertificate(trustAllCerts);

        String caCertFile = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY);
        String caCertData = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY);

        TrustManager[] trustManagers = null;
        if (caCertFile != null || caCertData != null) {
            KeyStore trustStore = Utils.createTrustStore(caCertData, caCertFile);
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(trustStore);
            trustManagers = tmf.getTrustManagers();
        }

        String clientCertFile = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY);
        String clientCertData = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY);
        String clientKeyFile = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY);
        String clientKeyData = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY);
        String clientKeyAlgo = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY, "RSA");
        char[] clientKeyPassphrase = Utils.getSystemPropertyOrEnvVar(KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY, "changeit").toCharArray();

        KeyManager[] keyManagers = null;
        if ((clientCertFile != null || clientCertData != null) && (clientKeyFile != null || clientKeyData != null)) {
            KeyStore keyStore = Utils.createKeyStore(clientCertData, clientCertFile, clientKeyData, clientKeyFile, clientKeyAlgo, clientKeyPassphrase);
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keyStore, clientKeyPassphrase);
            keyManagers = kmf.getKeyManagers();
        }

        if (keyManagers != null || trustManagers != null) {
            if (trustManagers == null && trustAllCerts) {
                trustManagers = InsecureTrustManagerFactory.INSTANCE.getTrustManagers();
                builder.setHostnameVerifier(null);
            }
            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(keyManagers, trustManagers, new SecureRandom());
            builder.setSSLContext(sslContext);
        }

        return builder.build();
    }

    public Resource<Namespace> namespaces(String name) {
        return new Resource<Namespace>(httpClient, masterUrl, "namespaces", name, Namespace.class);
    }

    public Resource<Pod> pods(String name) {
        return new Resource<Pod>(httpClient, masterUrl, "pods", name, Pod.class);
    }

    public ResourceList<NamespaceList> namespaces() {
        return new ResourceList<NamespaceList>(httpClient, masterUrl, "namespaces", NamespaceList.class);
    }

    public ResourceList<PodList> pods() {
        return new ResourceList<PodList>(httpClient, masterUrl, "pods", PodList.class);
    }

    public ResourceList<ReplicationControllerList> replicationControllers() {
        return new ResourceList<ReplicationControllerList>(httpClient, masterUrl, "replicationcontrollers", ReplicationControllerList.class);
    }

    public ResourceList<ServiceList> services() {
        return new ResourceList<ServiceList>(httpClient, masterUrl, "services", ServiceList.class);
    }
}