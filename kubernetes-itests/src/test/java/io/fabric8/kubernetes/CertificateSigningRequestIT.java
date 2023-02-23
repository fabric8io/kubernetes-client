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
package io.fabric8.kubernetes;

import io.fabric8.junit.jupiter.api.RequireK8sVersionAtLeast;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestBuilder;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.assertj.core.groups.Tuple;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.util.Base64;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import javax.security.auth.x500.X500Principal;

import static org.assertj.core.api.Assertions.assertThat;

@RequireK8sVersionAtLeast(majorVersion = 1, minorVersion = 19)
class CertificateSigningRequestIT {

  private static final String CREATE = "test-k8s-csr-create";
  private static final String LIST = "test-k8s-csr-list";
  private static final String SIGN = "test-k8s-csr-sign";

  static KubernetesClient client;

  @AfterAll
  static void afterAll() {
    Stream.of(CREATE, LIST, SIGN)
        .forEach(name -> client.certificates().v1().certificateSigningRequests().withName(name).delete());
  }

  @Test
  void create() throws Exception {
    // Given
    final CertificateSigningRequest csr = createCertificateSigningRequest(CREATE);
    // When
    final CertificateSigningRequest result = client.certificates().v1().certificateSigningRequests()
        .resource(csr).create();
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("metadata.name", "test-k8s-csr-create");
  }

  @Test
  void list() throws Exception {
    // Given
    client.certificates().v1().certificateSigningRequests()
        .resource(createCertificateSigningRequest(LIST)).create();
    // When
    final CertificateSigningRequestList result = client.certificates().v1().certificateSigningRequests().list();
    // Then
    assertThat(result.getItems())
        .hasSizeGreaterThanOrEqualTo(1)
        .extracting("metadata.name")
        .contains("test-k8s-csr-list");
  }

  @Test
  void approve() throws Exception {
    // Given
    final CertificateSigningRequest csr = client.certificates().v1()
        .certificateSigningRequests()
        .resource(createCertificateSigningRequest(SIGN))
        .create();
    // When
    client.certificates().v1().certificateSigningRequests().resource(csr).approve();
    // Then
    final CertificateSigningRequest signed = client.certificates().v1().certificateSigningRequests().withName(SIGN)
        .waitUntilCondition(s -> s.getStatus().getConditions().stream().anyMatch(c -> c.getType().equals("Approved")), 30,
            TimeUnit.SECONDS);
    assertThat(signed.getStatus().getConditions())
        .extracting("type", "status")
        .contains(Tuple.tuple("Approved", "True"));
  }

  static CertificateSigningRequest createCertificateSigningRequest(String name) throws Exception {
    return new CertificateSigningRequestBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withRequest(Base64.getEncoder().encodeToString(generateCSR().getBytes(StandardCharsets.UTF_8)))
        .withSignerName("kubernetes.io/kube-apiserver-client") // https://kubernetes.io/docs/reference/access-authn-authz/certificate-signing-requests/#kubernetes-signers
        .addToGroups("system:authenticated")
        .addToUsages("client auth")
        .endSpec()
        .build();
  }

  static String generateCSR() throws Exception {
    final KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    kpg.initialize(2048);
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    final KeyPair kp = kpg.generateKeyPair();
    final PKCS10CertificationRequestBuilder p10Builder = new JcaPKCS10CertificationRequestBuilder(
        new X500Principal("CN=*.cluster.local"), kp.getPublic());
    ContentSigner signer = new JcaContentSignerBuilder("SHA256withRSA").build(kp.getPrivate());
    PKCS10CertificationRequest csr = p10Builder.build(signer);
    try (StringWriter stringWriter = new StringWriter(); JcaPEMWriter pemWriter = new JcaPEMWriter(stringWriter)) {
      pemWriter.writeObject(csr);
      pemWriter.flush();
      return stringWriter.toString();
    }
  }
}
