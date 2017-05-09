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
import io.fabric8.kubernetes.client.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CertUtilsTest {

  private static String FABRIC8_STORE_PATH = decodeUrl(CertUtilsTest.class.getResource("/ssl/fabric8-store").getPath());
  private static char[] FABRIC8_STORE_PASSPHRASE = "fabric8".toCharArray();
  private Properties systemProperties;

  @Before
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

  @After
  public void resetSystemPropertiesBack() {
    System.setProperties(systemProperties);
  }

  @Ignore
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
    throws InvalidKeySpecException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {

    System.setProperty(CertUtils.KEY_STORE_SYSTEM_PROPERTY, FABRIC8_STORE_PATH);
    System.setProperty(CertUtils.KEY_STORE_PASSWORD_SYSTEM_PROPERTY, String.valueOf(FABRIC8_STORE_PASSPHRASE));

    String privateKeyPath = decodeUrl(getClass().getResource("/ssl/fabric8").getPath());
    String multipleCertsPath = decodeUrl(getClass().getResource("/ssl/multiple-certs.pem").getPath());

    KeyStore trustStore =
      CertUtils.createKeyStore(null, multipleCertsPath, null, privateKeyPath, "RSA", "changeit", null, null);

    assertEquals(2, trustStore.size());
    verifyFabric8InStore(trustStore);
  }

  private void verifyFabric8InStore(KeyStore trustStore)
    throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {

    Certificate certificate = trustStore.getCertificate("fabric8-in-store");
    assertNotNull(certificate);

    InputStream certificateFile = getClass().getResourceAsStream("/ssl/fabric8.crt");
    KeyStore storeWithCert = CertUtils.createTrustStore(certificateFile, null, "".toCharArray());
    String certificateAlias = storeWithCert.getCertificateAlias(certificate);
    assertNotNull(certificateAlias);
  }

  private InputStream getMultipleCertsInputSteam() {
    return getClass().getResourceAsStream("/ssl/multiple-certs.pem");
  }

  private static String decodeUrl(String url) {
    try {
      return URLDecoder.decode(url, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }
}
