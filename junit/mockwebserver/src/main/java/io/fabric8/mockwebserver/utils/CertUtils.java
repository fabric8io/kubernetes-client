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

import okio.ByteString;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.util.Base64;

public class CertUtils {

  private CertUtils() {
  }

  public static InputStream getInputStreamFromDataOrFile(String data, String file) throws FileNotFoundException {
    if (data != null) {
      final byte[] bytes;
      ByteString decoded = ByteString.decodeBase64(data);
      if (decoded != null) {
        bytes = decoded.toByteArray();
      } else {
        bytes = data.getBytes();
      }

      return new ByteArrayInputStream(bytes);
    }
    if (file != null) {
      return new FileInputStream(file);
    }
    return null;
  }

  public static KeyStore createKeyStore(InputStream certInputStream, InputStream keyInputStream, String clientKeyAlgo,
      char[] clientKeyPassphrase)
      throws IOException, CertificateException, NoSuchAlgorithmException, InvalidKeySpecException, KeyStoreException {
    CertificateFactory certFactory = CertificateFactory.getInstance("X509");
    X509Certificate cert = (X509Certificate) certFactory.generateCertificate(certInputStream);

    byte[] keyBytes = decodeKey(keyInputStream);

    PrivateKey privateKey;

    KeyFactory keyFactory = KeyFactory.getInstance(clientKeyAlgo);
    try {
      // First let's try PKCS8
      privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(keyBytes));
    } catch (InvalidKeySpecException e) {
      // Otherwise try PKCS8
      RSAPrivateCrtKeySpec keySpec = PKCS1Util.decodePKCS1(keyBytes);
      privateKey = keyFactory.generatePrivate(keySpec);
    }

    KeyStore keyStore = KeyStore.getInstance("JKS");
    keyStore.load(null, clientKeyPassphrase);

    String alias = cert.getSubjectX500Principal().getName();
    keyStore.setKeyEntry(alias, privateKey, clientKeyPassphrase, new Certificate[] { cert });

    return keyStore;
  }

  public static KeyStore createKeyStore(String clientCertData, String clientCertFile, String clientKeyData,
      String clientKeyFile, String clientKeyAlgo, char[] clientKeyPassphrase)
      throws IOException, CertificateException, NoSuchAlgorithmException, InvalidKeySpecException, KeyStoreException {
    try (InputStream certInputStream = getInputStreamFromDataOrFile(clientCertData, clientCertFile);
        InputStream keyInputStream = getInputStreamFromDataOrFile(clientKeyData, clientKeyFile)) {
      return createKeyStore(certInputStream, keyInputStream, clientKeyAlgo, clientKeyPassphrase);
    }
  }

  private static byte[] decodeKey(InputStream keyInputStream) throws IOException {
    try (BufferedReader keyReader = new BufferedReader(new InputStreamReader(keyInputStream));
        ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      String line;
      while ((line = keyReader.readLine()) != null) {
        baos.write(line.trim().getBytes());
      }
      return Base64.getDecoder().decode(baos.toByteArray());
    }
  }
}
