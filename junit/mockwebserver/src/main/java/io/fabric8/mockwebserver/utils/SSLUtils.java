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
package io.fabric8.mockwebserver.utils;

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

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import static io.fabric8.mockwebserver.utils.CertUtils.createKeyStore;

public final class SSLUtils {

  private SSLUtils() {
    //Utility
  }

  public static SSLContext sslContext(KeyManager[] keyManagers, TrustManager[] trustManagers, boolean trustCerts)
      throws KeyManagementException, NoSuchAlgorithmException {
    if (trustManagers == null && trustCerts) {
      trustManagers = new TrustManager[] { new X509TrustManager() {
        public void checkClientTrusted(X509Certificate[] chain, String s) {
        }

        public void checkServerTrusted(X509Certificate[] chain, String s) {
        }

        public X509Certificate[] getAcceptedIssuers() {
          return new X509Certificate[0];
        }
      } };
    }
    SSLContext sslContext = SSLContext.getInstance("TLS");
    sslContext.init(keyManagers, trustManagers, new SecureRandom());
    return sslContext;
  }

  public static KeyManager[] keyManagers(InputStream certInputStream, InputStream keyInputStream, String algo,
      String passphrase) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, CertificateException,
      InvalidKeySpecException, IOException {
    KeyStore keyStore = createKeyStore(certInputStream, keyInputStream, algo, passphrase.toCharArray());
    KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    kmf.init(keyStore, passphrase.toCharArray());
    return kmf.getKeyManagers();
  }
}
