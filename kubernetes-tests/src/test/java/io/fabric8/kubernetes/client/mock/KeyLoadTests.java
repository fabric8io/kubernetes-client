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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.client.internal.CertUtils;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableKubernetesMockClient
public class KeyLoadTests {
  @Test
  public void testECKeyLoad()
      throws InvalidKeySpecException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
    String privateKeyPath = Utils.filePath(getClass().getResource("/ssl/fabric8-ec.key"));
    String certPath = Utils.filePath(getClass().getResource("/ssl/fabric8-ec.cert"));

    KeyStore trustStore = CertUtils.createKeyStore(null, certPath, null, privateKeyPath, "EC", "foo", null, null);

    assertEquals(1, trustStore.size());
  }
}
