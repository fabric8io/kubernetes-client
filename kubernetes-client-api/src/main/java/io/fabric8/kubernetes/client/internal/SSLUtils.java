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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;

import static io.fabric8.kubernetes.client.internal.CertUtils.createKeyStore;
import static io.fabric8.kubernetes.client.internal.CertUtils.createTrustStore;

public final class SSLUtils {

  private static final Logger LOG = LoggerFactory.getLogger(SSLUtils.class);

  private SSLUtils() {
    //Utility
  }

  public static boolean isHttpsAvailable(Config config) {
    HttpsURLConnection conn = null;
    try {
      URL url = new URL(Config.HTTPS_PROTOCOL_PREFIX + config.getMasterUrl());
      conn = (HttpsURLConnection) url.openConnection();

      SSLContext sslContext = SSLUtils.sslContext(config);
      conn.setSSLSocketFactory(sslContext.getSocketFactory());
      conn.setConnectTimeout(1000);
      conn.setReadTimeout(1000);
      conn.connect();
      return true;
    } catch (Throwable t) {
      LOG.warn("SSL handshake failed. Falling back to insecure connection.");
    } finally {
      if (conn != null) {
        conn.disconnect();
      }
    }
    return false;
  }

  public static SSLContext sslContext(Config config) throws CertificateException, UnrecoverableKeyException,
      NoSuchAlgorithmException, KeyStoreException, IOException, InvalidKeySpecException, KeyManagementException {
    return sslContext(keyManagers(config), trustManagers(config));
  }

  public static SSLContext sslContext(KeyManager[] keyManagers, TrustManager[] trustManagers) {
    SSLContext sslContext = null;
    NoSuchAlgorithmException noSuch = null;
    // v1.3 is not supported on all vms, and of course there may be later versions added.
    // so try to find one starting with the latest
    for (TlsVersion version : TlsVersion.values()) {
      try {
        sslContext = SSLContext.getInstance(version.javaName());
        break;
      } catch (NoSuchAlgorithmException e) {
        if (noSuch == null) {
          noSuch = e;
        }
        continue;
      }
    }

    if (sslContext == null) {
      throw KubernetesClientException.launderThrowable(noSuch);
    }

    try {
      sslContext.init(keyManagers, trustManagers, new SecureRandom());
      return sslContext;
    } catch (KeyManagementException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  public static TrustManager[] trustManagers(Config config)
      throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
    return trustManagers(config.getCaCertData(), config.getCaCertFile(), config.isTrustCerts(), config.getTrustStoreFile(),
        config.getTrustStorePassphrase());
  }

  public static TrustManager[] trustManagers(String certData, String certFile, boolean isTrustCerts, String trustStoreFile,
      String trustStorePassphrase) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
    TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    KeyStore trustStore = null;
    if (isTrustCerts) {
      return new TrustManager[] {
          new X509ExtendedTrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String s) {
              //not needed
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String s) {
              //not needed
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
              return new X509Certificate[0];
            }

            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType, Socket socket)
                throws CertificateException {
              //not needed
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType, Socket socket)
                throws CertificateException {
              //not needed
            }

            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType, SSLEngine engine)
                throws CertificateException {
              //not needed
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType, SSLEngine engine)
                throws CertificateException {
              //not needed
            }
          }
      };
    } else if (Utils.isNotNullOrEmpty(certData) || Utils.isNotNullOrEmpty(certFile)) {
      trustStore = createTrustStore(certData, certFile, trustStoreFile, trustStorePassphrase);
    }
    tmf.init(trustStore);
    return tmf.getTrustManagers();
  }

  public static KeyManager[] keyManagers(Config config) throws NoSuchAlgorithmException, UnrecoverableKeyException,
      KeyStoreException, CertificateException, InvalidKeySpecException, IOException {
    return keyManagers(config.getClientCertData(), config.getClientCertFile(), config.getClientKeyData(),
        config.getClientKeyFile(), config.getClientKeyAlgo(), config.getClientKeyPassphrase(), config.getKeyStoreFile(),
        config.getKeyStorePassphrase());
  }

  public static KeyManager[] keyManagers(String certData, String certFile, String keyData, String keyFile, String algo,
      String passphrase, String keyStoreFile, String keyStorePassphrase) throws NoSuchAlgorithmException,
      UnrecoverableKeyException, KeyStoreException, CertificateException, InvalidKeySpecException, IOException {
    KeyManager[] keyManagers = null;
    if ((Utils.isNotNullOrEmpty(certData) || Utils.isNotNullOrEmpty(certFile))
        && (Utils.isNotNullOrEmpty(keyData) || Utils.isNotNullOrEmpty(keyFile))) {
      KeyStore keyStore = createKeyStore(certData, certFile, keyData, keyFile, algo, passphrase, keyStoreFile,
          keyStorePassphrase);
      KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
      kmf.init(keyStore, passphrase.toCharArray());
      keyManagers = kmf.getKeyManagers();
    }
    return keyManagers;
  }

  public static KeyManager[] keyManagers(InputStream certInputStream, InputStream keyInputStream, String algo,
      String passphrase, String keyStoreFile, String keyStorePassphrase) throws NoSuchAlgorithmException,
      UnrecoverableKeyException, KeyStoreException, CertificateException, InvalidKeySpecException, IOException {
    KeyStore keyStore = createKeyStore(certInputStream, keyInputStream, algo, passphrase.toCharArray(), keyStoreFile,
        keyStorePassphrase.toCharArray());
    KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    kmf.init(keyStore, passphrase.toCharArray());
    return kmf.getKeyManagers();
  }
}
