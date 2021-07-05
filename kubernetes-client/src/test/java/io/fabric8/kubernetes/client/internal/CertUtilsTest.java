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
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.utils.IOHelpers;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Objects;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CertUtilsTest {

  private static String FABRIC8_STORE_PATH = Utils.filePath(CertUtilsTest.class.getResource("/ssl/fabric8-store"));
  private static char[] FABRIC8_STORE_PASSPHRASE = "fabric8".toCharArray();
  private Properties systemProperties;

  @BeforeEach
  public void storeSystemProperties() {
    systemProperties = new Properties();
    storeSystemProperty(CertUtils.TRUST_STORE_SYSTEM_PROPERTY);
    storeSystemProperty(CertUtils.TRUST_STORE_PASSWORD_SYSTEM_PROPERTY);
    storeSystemProperty(CertUtils.KEY_STORE_SYSTEM_PROPERTY);
    storeSystemProperty(CertUtils.KEY_STORE_PASSWORD_SYSTEM_PROPERTY);
  }

  private void storeSystemProperty(String systemProperty) {
    String value = System.getProperty(systemProperty);
    if (Utils.isNotNullOrEmpty(value)) {
      systemProperties.put(systemProperty, value);
    }
  }

  @AfterEach
  public void resetSystemPropertiesBack() {
    System.setProperties(systemProperties);
  }

  @Disabled
  @Test
  public void testLoadingDodgyKubeConfig() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, InvalidKeySpecException {
    System.setProperty("kubeconfig", "/tmp/ceposta.kubeconfig");
    KubernetesClient client = new DefaultKubernetesClient();
    Config config = client.getConfiguration();
    KeyStore ts = CertUtils.createTrustStore(config.getCaCertData(), null, null, "changeit");
    KeyStore ks =
      CertUtils.createKeyStore(config.getClientCertData(), null, config.getClientKeyData(), null, "RSA", "changeit", null,
        "changeit");
  }

  @Test
  public void testLoadingMultipleCertsFromSameFile() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
    KeyStore ts = CertUtils.createTrustStore(getMultipleCertsInputSteam(), null, "changeit".toCharArray());
    assertTrue(ts.size() >= 2);
  }

  @Test
  public void testLoadingMultipleCertsWithSameSubjectFromSameFile() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
    KeyStore ts = CertUtils.createTrustStore(CertUtils.getInputStreamFromDataOrFile(
      null,
      "src/test/resources/ssl/nonunique-subject.pem"
    ), null, "changeit".toCharArray());

    assertTrue(ts.size() >= 2);
  }

  @Test
  public void testLoadTrustStoreFromFileUsingConfigProperties()
    throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {

    KeyStore trustStore =
      CertUtils.createTrustStore(getMultipleCertsInputSteam(), FABRIC8_STORE_PATH, FABRIC8_STORE_PASSPHRASE);

    assertEquals(3, trustStore.size());
    verifyFabric8InStore(trustStore);
  }

  @Test
  public void testLoadTrustStoreFromFileUsingSystemProperties()
    throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {

    System.setProperty(CertUtils.TRUST_STORE_SYSTEM_PROPERTY, FABRIC8_STORE_PATH);
    System.setProperty(CertUtils.TRUST_STORE_PASSWORD_SYSTEM_PROPERTY, String.valueOf(FABRIC8_STORE_PASSPHRASE));

    KeyStore trustStore =
      CertUtils.createTrustStore(getMultipleCertsInputSteam(), null, null);

    assertEquals(3, trustStore.size());
    verifyFabric8InStore(trustStore);
  }

  @Test
  public void testLoadKeyStoreFromFileUsingConfigProperties()
    throws InvalidKeySpecException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {

    InputStream privateKey = getClass().getResourceAsStream("/ssl/fabric8");

    KeyStore trustStore =
      CertUtils.createKeyStore(getMultipleCertsInputSteam(), privateKey, "RSA", "changeit".toCharArray(),
        FABRIC8_STORE_PATH, FABRIC8_STORE_PASSPHRASE);

    assertEquals(2, trustStore.size());
    verifyFabric8InStore(trustStore);
  }

  @Test
  public void testLoadKeyStoreFromFileUsingSystemProperties()
    throws InvalidKeySpecException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, URISyntaxException {

    System.setProperty(CertUtils.KEY_STORE_SYSTEM_PROPERTY, FABRIC8_STORE_PATH);
    System.setProperty(CertUtils.KEY_STORE_PASSWORD_SYSTEM_PROPERTY, String.valueOf(FABRIC8_STORE_PASSPHRASE));

    String privateKeyPath = Utils.filePath(getClass().getResource("/ssl/fabric8"));
    String multipleCertsPath = Utils.filePath(getClass().getResource("/ssl/multiple-certs.pem"));

    KeyStore trustStore =
      CertUtils.createKeyStore(null, multipleCertsPath, null, privateKeyPath, "RSA", "changeit", null, null);

    assertEquals(2, trustStore.size());
    verifyFabric8InStore(trustStore);
  }

  @Test
  void testGetInputStreamFromDataOrFileShouldNotDecodedPEMAgain() throws IOException {
    // Given
    File certFile = new File(Objects.requireNonNull(getClass().getResource("/ssl/valid-non-base64-encoded-cert.pem")).getFile());
    String certData = new String(Files.readAllBytes(certFile.toPath()));

    // When
    InputStream inputStream = CertUtils.getInputStreamFromDataOrFile(certData, null);
    String certDataReadFromInputStream = IOHelpers.readFully(inputStream);

    // Then
    assertEquals(certData, certDataReadFromInputStream);
  }

  @Test
  void testGetInputStreamFromDataOrFileShouldDecodeBase64EncodedString() throws IOException {
    // Given
    String inputStr = "this is a test";
    String base64EncodedStr = Base64.getEncoder().encodeToString(inputStr.getBytes());

    // When
    InputStream inputStream = CertUtils.getInputStreamFromDataOrFile(base64EncodedStr, null);
    String certDataReadFromInputStream = IOHelpers.readFully(inputStream);

    // Then
    assertEquals(inputStr, certDataReadFromInputStream);
  }

  private void verifyFabric8InStore(KeyStore trustStore)
    throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {

    Certificate certificate = trustStore.getCertificate("fabric8-in-store");
    assertNotNull(certificate);

    InputStream certificateFile = CertUtils.getInputStreamFromDataOrFile(null, "src/test/resources/ssl/fabric8.crt");
    KeyStore storeWithCert = CertUtils.createTrustStore(certificateFile, null, "".toCharArray());
    String certificateAlias = storeWithCert.getCertificateAlias(certificate);
    assertNotNull(certificateAlias);
  }

  private InputStream getMultipleCertsInputSteam() throws IOException {
    return CertUtils.getInputStreamFromDataOrFile(null, "src/test/resources/ssl/multiple-certs.pem");
  }

}
