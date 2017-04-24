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
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CertUtilsTest {

  @Ignore
  @Test
  public void testLoadingDodgyKubeConfig() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, InvalidKeySpecException {
    System.setProperty("kubeconfig", "/tmp/ceposta.kubeconfig");
    KubernetesClient client = new DefaultKubernetesClient();
    Config config = client.getConfiguration();
    KeyStore ts = CertUtils.createTrustStore(config.getCaCertData(), null, null, "changeit");
    KeyStore ks = CertUtils.createKeyStore(config.getClientCertData(), null, config.getClientKeyData(), null, "RSA", "changeit".toCharArray(), null, "changeit".toCharArray());
  }

  @Test
  public void testLoadingMultipleCertsFromSameFile() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
    KeyStore ts = CertUtils.createTrustStore(getMultipleCertsInputSteam(), null, "changeit".toCharArray());
    assertTrue(ts.size() >= 2);
  }

  @Test
  public void testLoadTrustStoreFromFile()
    throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {

    String fabric8StorePath = getClass().getResource("/ssl/fabric8-store").getPath();
    char[] passphrase = "fabric8".toCharArray();

    KeyStore trustStore = CertUtils.createTrustStore(getMultipleCertsInputSteam(), fabric8StorePath, passphrase);

    assertEquals(3, trustStore.size());
    verifyFabric8InStore(trustStore);
  }

  @Test
  public void testLoadKeyStoreFromFile()
    throws InvalidKeySpecException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {

    String fabric8StorePath = getClass().getResource("/ssl/fabric8-store").getPath();
    char[] passphrase = "fabric8".toCharArray();
    InputStream privateKey = getClass().getResourceAsStream("/ssl/fabric8");

    KeyStore trustStore =
      CertUtils.createKeyStore(getMultipleCertsInputSteam(), privateKey, "RSA", "changeit".toCharArray(),
        fabric8StorePath, passphrase);

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
}
