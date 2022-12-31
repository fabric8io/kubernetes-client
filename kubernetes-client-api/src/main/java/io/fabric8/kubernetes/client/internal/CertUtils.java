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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.Utils;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.util.Base64;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class CertUtils {
  private CertUtils() {
  }

  private static final Logger LOG = LoggerFactory.getLogger(CertUtils.class);
  private static final String TRUST_STORE_SYSTEM_PROPERTY = "javax.net.ssl.trustStore";
  private static final String TRUST_STORE_PASSWORD_SYSTEM_PROPERTY = "javax.net.ssl.trustStorePassword";
  private static final String TRUST_STORE_TYPE_SYSTEM_PROPERTY = "javax.net.ssl.trustStoreType";
  private static final String KEY_STORE_SYSTEM_PROPERTY = "javax.net.ssl.keyStore";
  private static final String KEY_STORE_PASSWORD_SYSTEM_PROPERTY = "javax.net.ssl.keyStorePassword";

  public static ByteArrayInputStream getInputStreamFromDataOrFile(String data, String file) throws IOException {
    if (data != null) {
      return createInputStreamFromBase64EncodedString(data);
    }
    if (file != null) {
      return new ByteArrayInputStream(new String(Files.readAllBytes(Paths.get(file))).trim().getBytes());
    }
    return null;
  }

  public static KeyStore createTrustStore(String caCertData, String caCertFile, String trustStoreFile,
      String trustStorePassphrase) throws IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException {
    try (ByteArrayInputStream pemInputStream = getInputStreamFromDataOrFile(caCertData, caCertFile)) {
      return createTrustStore(pemInputStream, trustStoreFile, getTrustStorePassphrase(trustStorePassphrase));
    }
  }

  private static char[] getTrustStorePassphrase(String trustStorePassphrase) {
    if (Utils.isNullOrEmpty(trustStorePassphrase)) {
      return System.getProperty(TRUST_STORE_PASSWORD_SYSTEM_PROPERTY, "changeit").toCharArray();
    }
    return trustStorePassphrase.toCharArray();
  }

  private static KeyStore createTrustStore(ByteArrayInputStream pemInputStream, String trustStoreFile,
      char[] trustStorePassphrase)
      throws IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException {

    final String trustStoreType = System.getProperty(TRUST_STORE_TYPE_SYSTEM_PROPERTY, KeyStore.getDefaultType());
    KeyStore trustStore = KeyStore.getInstance(trustStoreType);

    if (Utils.isNotNullOrEmpty(trustStoreFile)) {
      try (FileInputStream fis = new FileInputStream(trustStoreFile)) {
        trustStore.load(fis, trustStorePassphrase);
      }
    } else {
      loadDefaultTrustStoreFile(trustStore, trustStorePassphrase);
    }

    CertificateFactory certFactory = CertificateFactory.getInstance("X509");
    while (pemInputStream.available() > 0) {
      try {
        X509Certificate cert = (X509Certificate) certFactory.generateCertificate(pemInputStream);
        String alias = cert.getSubjectX500Principal().getName() + "_" + cert.getSerialNumber().toString(16);
        trustStore.setCertificateEntry(alias, cert);
      } catch (CertificateException e) {
        if (pemInputStream.available() > 0) {
          // any remaining input means there is an actual problem with the key contents or file format
          throw e;
        }
        LOG.debug("The trailing entry generated a certificate exception.  More than likely the contents end with comments.", e);
      }
    }
    return trustStore;
  }

  public static KeyStore createKeyStore(InputStream certInputStream, InputStream keyInputStream, String clientKeyAlgo,
      char[] clientKeyPassphrase, String keyStoreFile, char[] keyStorePassphrase)
      throws IOException, CertificateException, NoSuchAlgorithmException, InvalidKeySpecException, KeyStoreException {
    CertificateFactory certFactory = CertificateFactory.getInstance("X509");
    Collection<? extends Certificate> certificates = certFactory.generateCertificates(certInputStream);
    PrivateKey privateKey = loadKey(keyInputStream, clientKeyAlgo);

    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    if (Utils.isNotNullOrEmpty(keyStoreFile)) {
      try (FileInputStream fis = new FileInputStream(keyStoreFile)) {
        keyStore.load(fis, keyStorePassphrase);
      }
    } else {
      loadDefaultKeyStoreFile(keyStore, keyStorePassphrase);
    }

    String alias = certificates.stream().map(cert -> ((X509Certificate) cert).getIssuerX500Principal().getName())
        .collect(Collectors.joining("_"));
    keyStore.setKeyEntry(alias, privateKey, clientKeyPassphrase, certificates.toArray(new Certificate[0]));

    return keyStore;
  }

  private static PrivateKey loadKey(InputStream keyInputStream, String clientKeyAlgo)
      throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
    if (clientKeyAlgo == null) {
      clientKeyAlgo = "RSA"; // by default let's assume it's RSA
    }
    if (clientKeyAlgo.equals("EC")) {
      return handleECKey(keyInputStream);
    } else if (clientKeyAlgo.equals("RSA")) {
      return handleOtherKeys(keyInputStream, clientKeyAlgo);
    }

    throw new InvalidKeySpecException("Unknown type of PKCS8 Private Key, tried RSA and ECDSA");
  }

  private static PrivateKey handleECKey(InputStream keyInputStream) {
    // Let's wrap the code to a callable inner class to avoid NoClassDef when loading this class.
    try {
      return new Callable<PrivateKey>() {
        @Override
        public PrivateKey call() {
          try {
            if (Security.getProvider("BC") == null && Security.getProvider("BCFIPS") == null) {
              Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            }
            PEMKeyPair keys = (PEMKeyPair) new PEMParser(new InputStreamReader(keyInputStream)).readObject();
            return new JcaPEMKeyConverter().getKeyPair(keys).getPrivate();
          } catch (IOException exception) {
            exception.printStackTrace();
          }
          return null;
        }
      }.call();
    } catch (NoClassDefFoundError e) {
      throw new KubernetesClientException(
          "JcaPEMKeyConverter is provided by BouncyCastle, an optional dependency. To use support for EC Keys you must explicitly add this dependency to classpath.");
    }
  }

  private static PrivateKey handleOtherKeys(InputStream keyInputStream, String clientKeyAlgo)
      throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
    byte[] keyBytes = decodePem(keyInputStream);
    try {
      // First let's try PKCS8
      return KeyFactory.getInstance(clientKeyAlgo).generatePrivate(new PKCS8EncodedKeySpec(keyBytes));
    } catch (InvalidKeySpecException e) {
      // Otherwise try PKCS8
      RSAPrivateCrtKeySpec keySpec = PKCS1Util.decodePKCS1(keyBytes);
      return KeyFactory.getInstance(clientKeyAlgo).generatePrivate(keySpec);
    }
  }

  private static void loadDefaultTrustStoreFile(KeyStore keyStore, char[] trustStorePassphrase)
      throws CertificateException, NoSuchAlgorithmException, IOException {

    File trustStoreFile = getDefaultTrustStoreFile();

    if (!loadDefaultStoreFile(keyStore, trustStoreFile, trustStorePassphrase)) {
      keyStore.load(null);
    }
  }

  private static File getDefaultTrustStoreFile() {
    String securityDirectory = System.getProperty("java.home") + File.separator + "lib" + File.separator + "security"
        + File.separator;

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

  private static boolean loadDefaultStoreFile(KeyStore keyStore, File fileToLoad, char[] passphrase) {

    String notLoadedMessage = "There is a problem with reading default keystore/truststore file %s with the passphrase %s "
        + "- the file won't be loaded. The reason is: %s";

    if (fileToLoad.exists() && fileToLoad.isFile() && fileToLoad.length() > 0) {
      try {
        try (FileInputStream fis = new FileInputStream(fileToLoad)) {
          keyStore.load(fis, passphrase);
        }
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
    try (InputStream certInputStream = getInputStreamFromDataOrFile(clientCertData, clientCertFile);
        InputStream keyInputStream = getInputStreamFromDataOrFile(clientKeyData, clientKeyFile)) {
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
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(keyInputStream))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.contains("-----BEGIN ")) {
          return readBytes(reader, line.trim().replace("BEGIN", "END"));
        }
      }
      throw new IOException("PEM is invalid: no begin marker");
    }
  }

  private static byte[] readBytes(BufferedReader reader, String endMarker) throws IOException {
    String line;
    StringBuffer buf = new StringBuffer();

    while ((line = reader.readLine()) != null) {
      if (line.indexOf(endMarker) != -1) {
        return Base64.getDecoder().decode(buf.toString());
      }
      buf.append(line.trim());
    }
    throw new IOException("PEM is invalid : No end marker");
  }

  private static ByteArrayInputStream createInputStreamFromBase64EncodedString(String data) {
    byte[] bytes;
    try {
      bytes = Base64.getDecoder().decode(data);
    } catch (IllegalArgumentException illegalArgumentException) {
      bytes = data.getBytes();
    }

    return new ByteArrayInputStream(bytes);
  }
}
