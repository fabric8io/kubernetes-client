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
import org.jboss.netty.handler.ssl.util.InsecureTrustManagerFactory;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;

import static io.fabric8.kubernetes.client.internal.CertUtils.createKeyStore;
import static io.fabric8.kubernetes.client.internal.CertUtils.createTrustStore;
import static io.fabric8.kubernetes.client.internal.Utils.isNotNullOrEmpty;

public final class SSLUtils {

  private SSLUtils() {
    //Utility
  }

  public static SSLContext sslContext(Config config) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, IOException, InvalidKeySpecException, KeyManagementException {
    return sslContext(keyManagers(config), trustManagers(config), config.isTrustCerts());
  }

  public static SSLContext sslContext(KeyManager[] keyManagers,  TrustManager[] trustManagers, boolean trustCerts) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, IOException, InvalidKeySpecException, KeyManagementException {
    if (trustManagers == null && trustCerts) {
      trustManagers = InsecureTrustManagerFactory.INSTANCE.getTrustManagers();
    }
    SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
    sslContext.init(keyManagers, trustManagers, new SecureRandom());
    return sslContext;
  }

  public static TrustManager[] trustManagers(Config config) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
    return trustManagers(config.getCaCertData(), config.getCaCertFile());
  }

  public static TrustManager[] trustManagers(String certData, String certFile) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
    TrustManager[] trustManagers = null;
    if (isNotNullOrEmpty(certData) || isNotNullOrEmpty(certFile)) {
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
      KeyStore keyStore = createKeyStore(certData,certFile, keyData, keyFile, algo, passphrase.toCharArray());
      KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
      kmf.init(keyStore, passphrase.toCharArray());
      keyManagers = kmf.getKeyManagers();
    }
    return keyManagers;
  }
}
