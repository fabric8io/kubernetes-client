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
package io.fabric8.certmanager.test.crud;

import io.fabric8.certmanager.api.model.v1alpha3.Certificate;
import io.fabric8.certmanager.api.model.v1alpha3.CertificateBuilder;
import io.fabric8.certmanager.api.model.v1alpha3.CertificateList;
import io.fabric8.certmanager.client.CertManagerClient;
import io.fabric8.certmanager.server.mock.CertManagerServer;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@EnableRuleMigrationSupport
class V1alpha3CertificateCrudTest {

  @Rule
  public CertManagerServer server = new CertManagerServer(true, true);

  @Test
  void shouldReturnEmptyList() {
    CertManagerClient client = server.getCertManagerClient();
    CertificateList certificateList = client.v1alpha3().certificates().inNamespace("ns1").list();
    assertNotNull(certificateList);
    assertTrue(certificateList.getItems().isEmpty());
  }

  @Test
  void shouldListAndGetCertificate() {
    CertManagerClient client = server.getCertManagerClient();
    Certificate certificate2 = new CertificateBuilder().withNewMetadata().withName("cert2").endMetadata().build();
    client.v1alpha3().certificates().inNamespace("ns2").create(certificate2);
    CertificateList certificateList = client.v1alpha3().certificates().inNamespace("ns2").list();
    assertNotNull(certificateList);
    assertEquals(1, certificateList.getItems().size());
  }

  @Test
  void shouldDeleteACertificate() {
    CertManagerClient client = server.getCertManagerClient();
    Certificate certificate3 = new CertificateBuilder().withNewMetadata().withName("cert3").endMetadata().build();
    client.v1alpha3().certificates().inNamespace("ns3").create(certificate3);
    Boolean deleted = client.v1alpha3().certificates().inNamespace("ns3").withName("cert3").delete();
    assertTrue(deleted);
  }

  @Test
  void shouldLoadCertificate() {
    CertManagerClient client = server.getCertManagerClient();
    String certificateDefinition = String.join("\n", Arrays.asList(
      "apiVersion: cert-manager.io/v1beta1",
      "kind: Certificate",
      "metadata:",
      "  name: ca-issuer",
      "spec:",
      "  isCA: true",
      "  secretName: ca-key-pair",
      "  commonName: my-csi-app",
      "  issuerRef:",
      "    name: selfsigned-issuer",
      "    kind: Issuer",
      "    group: cert-manager.io"
    ));
    io.fabric8.certmanager.api.model.v1beta1.Certificate certificate = client.v1beta1().certificates().inNamespace("ns4").load(new ByteArrayInputStream(certificateDefinition.getBytes())).createOrReplace();
    assertEquals("ca-issuer", certificate.getMetadata().getName());
    assertEquals("ca-key-pair", certificate.getSpec().getSecretName());
    assertEquals("my-csi-app", certificate.getSpec().getCommonName());
  }

}
