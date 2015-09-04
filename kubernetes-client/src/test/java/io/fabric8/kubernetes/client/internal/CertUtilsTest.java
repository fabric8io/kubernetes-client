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
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;

public class CertUtilsTest {

  @Ignore
  @Test
  public void testLoadingDodgyKubeConfig() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, InvalidKeySpecException {
    System.setProperty("kubeconfig", "/tmp/ceposta.kubeconfig");
    KubernetesClient client = new DefaultKubernetesClient();
    Config config = client.getConfiguration();
    KeyStore ts = CertUtils.createTrustStore(config.getCaCertData(), null);
    KeyStore ks = CertUtils.createKeyStore(config.getClientCertData(), null, config.getClientKeyData(), null, "RSA", "changeit".toCharArray());
  }

}
