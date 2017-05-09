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

import io.fabric8.kubernetes.client.utils.Utils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
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
import okio.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CertUtils {

  private static final Logger LOG = LoggerFactory.getLogger(CertUtils.class);
  public static String TRUST_STORE_SYSTEM_PROPERTY = "javax.net.ssl.trustStore";
  public static String TRUST_STORE_PASSWORD_SYSTEM_PROPERTY = "javax.net.ssl.trustStorePassword";
  public static String KEY_STORE_SYSTEM_PROPERTY = "javax.net.ssl.keyStore";
  public static String KEY_STORE_PASSWORD_SYSTEM_PROPERTY = "javax.net.ssl.keyStorePassword";

  public static InputStream getInputStreamFromDataOrFile(String data, String file) throws FileNotFoundException {
    if (data != null) {
      byte[] bytes = null;
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

  public static KeyStore createTrustStore(String caCertData, String caCertFile, String trustStoreFile, String trustStorePassphrase) throws IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException {
    try (InputStream pemInputStream = getInputStreamFromDataOrFile(caCertData, caCertFile)) {
      return createTrustStore(pemInputStream, trustStoreFile, getTrustStorePassphrase(trustStorePassphrase));
    }
  }

  private static char[] getTrustStorePassphrase(String trustStorePassphrase) {
    if (Utils.isNullOrEmpty(trustStorePassphrase)) {
      return System.getProperty(TRUST_STORE_PASSWORD_SYSTEM_PROPERTY, "changeit").toCharArray();
    }
    return trustStorePassphrase.toCharArray();
  }

  public static KeyStore createTrustStore(InputStream pemInputStream, String trustStoreFile, char[] trustStorePassphrase) throws IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException {
    KeyStore trustStore = KeyStore.getInstance("JKS");

    if (Utils.isNotNullOrEmpty(trustStoreFile)) {
      trustStore.load(new FileInputStream(trustStoreFile), trustStorePassphrase);
    } else {
      loadDefaultTrustStoreFile(trustStore, trustStorePassphrase);
    }

    while (pemInputStream.available() > 0) {
      CertificateFactory certFactory = CertificateFactory.getInstance("X509");
      X509Certificate cert = (X509Certificate) certFactory.generateCertificate(pemInputStream);

      String alias = cert.getSubjectX500Principal().getName();
      trustStore.setCertificateEntry(alias, cert);
    }
    return trustStore;
  }

  public static KeyStore createKeyStore(InputStream certInputStream, InputStream keyInputStream, String clientKeyAlgo, char[] clientKeyPassphrase, String keyStoreFile, char[] keyStorePassphrase) throws IOException, CertificateException, NoSuchAlgorithmException, InvalidKeySpecException, KeyStoreException {
      CertificateFactory certFactory = CertificateFactory.getInstance("X509");
      X509Certificate cert = (X509Certificate) certFactory.generateCertificate(certInputStream);

      byte[] keyBytes = decodePem(keyInputStream);

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
      if (Utils.isNotNullOrEmpty(keyStoreFile)){
        keyStore.load(new FileInputStream(keyStoreFile), keyStorePassphrase);
      } else {
        loadDefaultKeyStoreFile(keyStore, keyStorePassphrase);
      }

      String alias = cert.getSubjectX500Principal().getName();
      keyStore.setKeyEntry(alias, privateKey, clientKeyPassphrase, new Certificate[]{cert});

      return keyStore;
  }

  private static void loadDefaultTrustStoreFile(KeyStore keyStore, char[] trustStorePassphrase)
    throws CertificateException, NoSuchAlgorithmException, IOException {

    File trustStoreFile = getDefaultTrustStoreFile();

    if (!loadDefaultStoreFile(keyStore, trustStoreFile, trustStorePassphrase)) {
      keyStore.load(null);
    }
  }

  private static File getDefaultTrustStoreFile() {
    String securityDirectory =
      System.getProperty("java.home") + File.separator + "lib" + File.separator + "security" + File.separator;

    String trustStorePath = System.getProperty(TRUST_STORE_SYSTEM_PROPERTY);
    if (Utils.isNotNullOrEmpty(trustStorePath)) {
      return new File(trustStorePath);
    }

    File jssecacertsFile = new File(securityDirectory + "jssecacerts");
    if (jssecacertsFile.exists() && jssecacertsFile.isFile()) {
      return jssecacertsFile;
    }

    return new File(securityDirectory + "cacerts");
  }

  private static void loadDefaultKeyStoreFile(KeyStore keyStore, char[] keyStorePassphrase)
    throws CertificateException, NoSuchAlgorithmException, IOException {

    String keyStorePath = System.getProperty(KEY_STORE_SYSTEM_PROPERTY);
    if (Utils.isNotNullOrEmpty(keyStorePath)) {
      File keyStoreFile = new File(keyStorePath);
      if (loadDefaultStoreFile(keyStore, keyStoreFile, keyStorePassphrase)) {
        return;
      }
    }

    keyStore.load(null);
  }

  private static boolean loadDefaultStoreFile(KeyStore keyStore, File fileToLoad, char[] passphrase)
    throws CertificateException, NoSuchAlgorithmException, IOException {

    String notLoadedMessage = "There is a problem with reading default keystore/truststore file %s with the passphrase %s "
      + "- the file won't be loaded. The reason is: %s";

    if (fileToLoad.exists() && fileToLoad.isFile() && fileToLoad.length() > 0) {
      try {
        keyStore.load(new FileInputStream(fileToLoad), passphrase);
        return true;
      } catch (Exception e) {
        String passphraseToPrint = passphrase != null ? String.valueOf(passphrase) : null;
        LOG.info(String.format(notLoadedMessage, fileToLoad, passphraseToPrint, e.getMessage()));
      }
    }
    return false;
  }

  public static KeyStore createKeyStore(String clientCertData, String clientCertFile, String clientKeyData,
    String clientKeyFile, String clientKeyAlgo, String clientKeyPassphrase, String keyStoreFile,
    String keyStorePassphrase)
    throws IOException, CertificateException, NoSuchAlgorithmException, InvalidKeySpecException, KeyStoreException {
    try (InputStream certInputStream = getInputStreamFromDataOrFile(clientCertData, clientCertFile); InputStream keyInputStream = getInputStreamFromDataOrFile(clientKeyData, clientKeyFile)) {
      return createKeyStore(certInputStream, keyInputStream, clientKeyAlgo, clientKeyPassphrase.toCharArray(),
        keyStoreFile, getKeyStorePassphrase(keyStorePassphrase));
    }
  }

  private static char[] getKeyStorePassphrase(String keyStorePassphrase) {
    if (Utils.isNullOrEmpty(keyStorePassphrase)) {
      return System.getProperty(KEY_STORE_PASSWORD_SYSTEM_PROPERTY, "changeit").toCharArray();
    }
    return keyStorePassphrase.toCharArray();
  }

  // This method is inspired and partly taken over from
  // http://oauth.googlecode.com/svn/code/java/
  // All credits to belong to them.
  private static byte[] decodePem(InputStream keyInputStream) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(keyInputStream));
    try {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.contains("-----BEGIN ")) {
          return readBytes(reader, line.trim().replace("BEGIN", "END"));
        }
      }
      throw new IOException("PEM is invalid: no begin marker");
    } finally {
      reader.close();
    }
  }

  private static byte[] readBytes(BufferedReader reader, String endMarker) throws IOException {
    String line;
    StringBuffer buf = new StringBuffer();

    while ((line = reader.readLine()) != null) {
      if (line.indexOf(endMarker) != -1) {
        return ByteString.decodeBase64(buf.toString()).toByteArray();
      }
      buf.append(line.trim());
    }
    throw new IOException("PEM is invalid : No end marker");
  }
}
