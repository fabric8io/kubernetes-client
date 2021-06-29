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

import io.fabric8.certmanager.api.model.meta.v1.ObjectReferenceBuilder;
import io.fabric8.certmanager.api.model.v1.CertificateRequest;
import io.fabric8.certmanager.api.model.v1.CertificateRequestBuilder;
import io.fabric8.certmanager.client.CertManagerClient;
import io.fabric8.certmanager.server.mock.CertManagerServer;
import io.fabric8.kubernetes.api.model.Duration;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.net.HttpURLConnection;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableRuleMigrationSupport
class V1CertificateRequestTest {
  @Rule
  public CertManagerServer server = new CertManagerServer();

  @Test
  void testCreate() throws Exception {
    // Given
    CertificateRequest certificateRequest = createCertificateRequest();
    server.expect().post().withPath("/apis/cert-manager.io/v1/namespaces/ns1/certificaterequests")
      .andReturn(HttpURLConnection.HTTP_CREATED, certificateRequest)
      .once();
    CertManagerClient certManagerClient = server.getCertManagerClient();

    // When
    CertificateRequest createdRequest = certManagerClient.v1().certificateRequests().inNamespace("ns1").create(certificateRequest);

    // Then
    assertNotNull(createdRequest);
    assertEquals("my-ca-cr", createdRequest.getMetadata().getName());
  }

  private CertificateRequest createCertificateRequest() throws ParseException {
    return new CertificateRequestBuilder()
      .withNewMetadata().withName("my-ca-cr").endMetadata()
      .withNewSpec()
      .withRequest("LS0tLS1CRUdJTiBDRVJUSUZJQ0FURSBSRVFVRVNULS0tLS0KTUlJQzNqQ0N")
      .withIsCA(false)
      .addToUsages("signing", "digital signature", "server auth")
      .withDuration(Duration.parse("90d"))
      .withIssuerRef(new ObjectReferenceBuilder()
        .withName("ca-issuer")
        .withKind("Issuer")
        .withGroup("cert-manager.io")
        .build())
      .endSpec()
      .build();
  }
}
