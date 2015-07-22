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

import com.ning.http.util.Base64;
import net.oauth.signature.pem.PEMReader;
import net.oauth.signature.pem.PKCS1EncodedKeySpec;

import java.io.*;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;

public class CertUtils {

  public static InputStream getInputStreamFromDataOrFile(String data, String file) throws FileNotFoundException {
    if (data != null) {
      return new ByteArrayInputStream(Base64.decode(data));
    }
    if (file != null) {
      return new FileInputStream(file);
    }
    return null;
  }

  public static KeyStore createTrustStore(String caCertData, String caCertFile) throws IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException {
    try (InputStream pemInputStream = getInputStreamFromDataOrFile(caCertData, caCertFile)) {
      CertificateFactory certFactory = CertificateFactory.getInstance("X509");
      X509Certificate cert = (X509Certificate) certFactory.generateCertificate(pemInputStream);

      KeyStore trustStore = KeyStore.getInstance("JKS");
      trustStore.load(null);

      String alias = cert.getSubjectX500Principal().getName();
      trustStore.setCertificateEntry(alias, cert);

      return trustStore;
    }
  }

  public static KeyStore createKeyStore(String clientCertData, String clientCertFile, String clientKeyData, String clientKeyFile, String clientKeyAlgo, char[] clientKeyPassphrase) throws IOException, CertificateException, NoSuchAlgorithmException, InvalidKeySpecException, KeyStoreException {
    try (InputStream certInputStream = getInputStreamFromDataOrFile(clientCertData, clientCertFile)) {
      CertificateFactory certFactory = CertificateFactory.getInstance("X509");
      X509Certificate cert = (X509Certificate) certFactory.generateCertificate(certInputStream);

      InputStream keyInputStream = getInputStreamFromDataOrFile(clientKeyData, clientKeyFile);
      PEMReader reader = new PEMReader(keyInputStream);
      RSAPrivateCrtKeySpec keySpec = new PKCS1EncodedKeySpec(reader.getDerBytes()).getKeySpec();
      KeyFactory kf = KeyFactory.getInstance(clientKeyAlgo);
      RSAPrivateKey privKey = (RSAPrivateKey) kf.generatePrivate(keySpec);

      KeyStore keyStore = KeyStore.getInstance("JKS");
      keyStore.load(null, clientKeyPassphrase);

      String alias = cert.getSubjectX500Principal().getName();
      keyStore.setKeyEntry(alias, privKey, clientKeyPassphrase, new Certificate[]{cert});

      return keyStore;
    }
  }
}
