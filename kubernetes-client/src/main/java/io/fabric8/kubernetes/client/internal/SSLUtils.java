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
package io.fabric8.kubernetes.client.internal;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;

import static io.fabric8.kubernetes.client.internal.CertUtils.createKeyStore;
import static io.fabric8.kubernetes.client.internal.CertUtils.createTrustStore;
import static io.fabric8.kubernetes.client.utils.Utils.isNotNullOrEmpty;

public final class SSLUtils {

    private static final Logger LOG = LoggerFactory.getLogger(SSLUtils.class);

    private SSLUtils() {
        //Utility
    }

    public static boolean isHttpsAvailable(Config config) {
        Config sslConfig = new ConfigBuilder(config)
                .withMasterUrl(Config.HTTPS_PROTOCOL_PREFIX + config.getMasterUrl())
                .withRequestTimeout(1000)
                .withConnectionTimeout(1000)
                .build();

        OkHttpClient client = HttpClientUtils.createHttpClient(config);
        try {
            Request request = new Request.Builder().get().url(sslConfig.getMasterUrl())
                    .build();
            Response response = client.newCall(request).execute();
            try (ResponseBody body = response.body()) {
              return response.isSuccessful();
            }
        } catch (Throwable t) {
            LOG.warn("SSL handshake failed. Falling back to insecure connection.");
        } finally {
            if (client != null && client.getConnectionPool() != null) {
                client.getConnectionPool().evictAll();
            }
        }
        return false;
    }

    public static SSLContext sslContext(Config config) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, IOException, InvalidKeySpecException, KeyManagementException {
        return sslContext(keyManagers(config), trustManagers(config), config.isTrustCerts());
    }

    public static SSLContext sslContext(KeyManager[] keyManagers, TrustManager[] trustManagers, boolean trustCerts) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, IOException, InvalidKeySpecException, KeyManagementException {
        if (trustManagers == null && trustCerts) {
            trustManagers = new TrustManager[]{new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String s) {
                }

                public void checkServerTrusted(X509Certificate[] chain, String s) {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};
        }
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagers, trustManagers, new SecureRandom());
        return sslContext;
    }

    public static TrustManager[] trustManagers(Config config) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        return trustManagers(config.getCaCertData(), config.getCaCertFile(), config.isTrustCerts());
    }

    public static TrustManager[] trustManagers(String certData, String certFile, boolean isTrustCerts) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        TrustManager[] trustManagers = null;
        if (!isTrustCerts && (isNotNullOrEmpty(certData) || isNotNullOrEmpty(certFile))) {
            KeyStore trustStore = createTrustStore(certData, certFile);
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(trustStore);
            trustManagers = tmf.getTrustManagers();
        }
        return trustManagers;
    }

    public static KeyManager[] keyManagers(Config config) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, CertificateException, InvalidKeySpecException, IOException {
        return keyManagers(config.getClientCertData(), config.getClientCertFile(), config.getClientKeyData(), config.getClientKeyFile(), config.getClientKeyAlgo(), config.getClientKeyPassphrase());
    }

    public static KeyManager[] keyManagers(String certData, String certFile, String keyData, String keyFile, String algo, String passphrase) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, CertificateException, InvalidKeySpecException, IOException {
        KeyManager[] keyManagers = null;
        if ((isNotNullOrEmpty(certData) || isNotNullOrEmpty(certFile)) && (isNotNullOrEmpty(keyData) || isNotNullOrEmpty(keyFile))) {
            KeyStore keyStore = createKeyStore(certData, certFile, keyData, keyFile, algo, passphrase.toCharArray());
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keyStore, passphrase.toCharArray());
            keyManagers = kmf.getKeyManagers();
        }
        return keyManagers;
    }

    public static KeyManager[] keyManagers(InputStream certInputStream, InputStream keyInputStream, String algo, String passphrase) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, CertificateException, InvalidKeySpecException, IOException {
        KeyStore keyStore = createKeyStore(certInputStream, keyInputStream, algo, passphrase.toCharArray());
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, passphrase.toCharArray());
        return kmf.getKeyManagers();
    }
}
