/*
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
package io.fabric8.kubeapitest.cert;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static io.fabric8.kubeapitest.cert.CertManager.API_SERVER_CERT_NAME;
import static io.fabric8.kubeapitest.cert.CertManager.API_SERVER_KEY_NAME;
import static io.fabric8.kubeapitest.cert.CertManager.CLIENT_CERT_NAME;
import static io.fabric8.kubeapitest.cert.CertManager.CLIENT_KEY_NAME;
import static org.assertj.core.api.Assertions.assertThat;

class CertManagerTest {

  @TempDir
  File certsDir;

  @Test
  @DisplayName("generates the API server and client keys and certificates in an empty directory")
  void generatesCertificates() {
    CertManager certManager = new CertManager(certsDir.getPath());
    certManager.createCertificatesIfNeeded();

    assertThat(certsDir.list()).contains(API_SERVER_CERT_NAME, API_SERVER_KEY_NAME, CLIENT_CERT_NAME, CLIENT_KEY_NAME);
  }

  @Test
  @DisplayName("keeps certificates that are valid beyond the validity margin")
  void keepsValidCertificates() throws Exception {
    CertManager certManager = new CertManager(certsDir.getPath());
    certManager.createCertificatesIfNeeded();
    var apiServerCert = Files.readAllBytes(new File(certsDir, API_SERVER_CERT_NAME).toPath());
    var clientCert = Files.readAllBytes(new File(certsDir, CLIENT_CERT_NAME).toPath());

    certManager.createCertificatesIfNeeded();

    assertThat(new File(certsDir, API_SERVER_CERT_NAME)).hasBinaryContent(apiServerCert);
    assertThat(new File(certsDir, CLIENT_CERT_NAME)).hasBinaryContent(clientCert);
  }

  @Test
  @DisplayName("regenerates expired certificates")
  void regeneratesExpiredCertificates() throws Exception {
    var validFrom = Instant.now().minus(2, ChronoUnit.DAYS);
    var validUntil = Instant.now().minus(1, ChronoUnit.DAYS);
    generateCertificate(API_SERVER_KEY_NAME, API_SERVER_CERT_NAME, validFrom, validUntil);
    generateCertificate(CLIENT_KEY_NAME, CLIENT_CERT_NAME, validFrom, validUntil);

    new CertManager(certsDir.getPath()).createCertificatesIfNeeded();

    assertThat(readCertificate(API_SERVER_CERT_NAME).getNotAfter()).isAfter(new Date());
    assertThat(readCertificate(CLIENT_CERT_NAME).getNotAfter()).isAfter(new Date());
  }

  @Test
  @DisplayName("regenerates certificates that expire within the validity margin, so they don't expire during a test run")
  void regeneratesCertificatesExpiringWithinTheValidityMargin() throws Exception {
    var validFrom = Instant.now().minus(1, ChronoUnit.DAYS);
    var validUntil = Instant.now().plus(CertManager.VALIDITY_MARGIN).minus(1, ChronoUnit.HOURS);
    generateCertificate(API_SERVER_KEY_NAME, API_SERVER_CERT_NAME, validFrom, validUntil);
    generateCertificate(CLIENT_KEY_NAME, CLIENT_CERT_NAME, validFrom, validUntil);

    new CertManager(certsDir.getPath()).createCertificatesIfNeeded();

    assertThat(readCertificate(API_SERVER_CERT_NAME).getNotAfter()).isAfter(Date.from(validUntil));
    assertThat(readCertificate(CLIENT_CERT_NAME).getNotAfter()).isAfter(Date.from(validUntil));
  }

  @Test
  @DisplayName("regenerates every key and certificate when only one of the certificates is expired")
  void regeneratesAllCertificatesWhenOnlyTheClientCertificateIsExpired() throws Exception {
    var validFrom = Instant.now().minus(2, ChronoUnit.DAYS);
    generateCertificate(API_SERVER_KEY_NAME, API_SERVER_CERT_NAME, validFrom, validFrom.plus(365, ChronoUnit.DAYS));
    generateCertificate(CLIENT_KEY_NAME, CLIENT_CERT_NAME, validFrom, Instant.now().minus(1, ChronoUnit.DAYS));
    var apiServerCert = Files.readAllBytes(new File(certsDir, API_SERVER_CERT_NAME).toPath());
    var apiServerKey = Files.readAllBytes(new File(certsDir, API_SERVER_KEY_NAME).toPath());

    new CertManager(certsDir.getPath()).createCertificatesIfNeeded();

    assertThat(readCertificate(CLIENT_CERT_NAME).getNotAfter()).isAfter(new Date());
    assertThat(Files.readAllBytes(new File(certsDir, API_SERVER_CERT_NAME).toPath())).isNotEqualTo(apiServerCert);
    assertThat(Files.readAllBytes(new File(certsDir, API_SERVER_KEY_NAME).toPath())).isNotEqualTo(apiServerKey);
  }

  @Test
  @DisplayName("regenerates certificates that can't be parsed")
  void regeneratesUnreadableCertificates() throws Exception {
    new CertManager(certsDir.getPath()).createCertificatesIfNeeded();
    Files.writeString(new File(certsDir, API_SERVER_CERT_NAME).toPath(), "not a certificate");

    new CertManager(certsDir.getPath()).createCertificatesIfNeeded();

    assertThat(readCertificate(API_SERVER_CERT_NAME).getNotAfter()).isAfter(new Date());
  }

  @Test
  @DisplayName("regenerates certificates whose key file holds a different key")
  void regeneratesCertificatesWithMismatchedKey() throws Exception {
    new CertManager(certsDir.getPath()).createCertificatesIfNeeded();
    var apiServerCert = Files.readAllBytes(new File(certsDir, API_SERVER_CERT_NAME).toPath());
    var clientKey = Files.readAllBytes(new File(certsDir, CLIENT_KEY_NAME).toPath());
    Files.write(new File(certsDir, API_SERVER_KEY_NAME).toPath(), clientKey);

    new CertManager(certsDir.getPath()).createCertificatesIfNeeded();

    assertThat(Files.readAllBytes(new File(certsDir, API_SERVER_CERT_NAME).toPath())).isNotEqualTo(apiServerCert);
    assertThat(Files.readAllBytes(new File(certsDir, API_SERVER_KEY_NAME).toPath())).isNotEqualTo(clientKey);
  }

  @Test
  @DisplayName("generates certificates without the cross-JVM lock when the lock file is locked by this JVM (another class loader)")
  void generatesCertificatesWhenTheLockFileIsAlreadyLockedInThisJvm() throws Exception {
    try (var channel = FileChannel.open(new File(certsDir, ".certificates.lock").toPath(),
        StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        var ignored = channel.lock()) {

      new CertManager(certsDir.getPath()).createCertificatesIfNeeded();
    }

    assertThat(readCertificate(API_SERVER_CERT_NAME).getNotAfter()).isAfter(new Date());
    assertThat(readCertificate(CLIENT_CERT_NAME).getNotAfter()).isAfter(new Date());
  }

  @Test
  @DisplayName("generates certificates without the cross-JVM lock when the lock file can't be opened or locked")
  void generatesCertificatesWhenTheLockFileCannotBeLocked() throws Exception {
    // a directory can't be opened for writing, like a lock on a file system without lock support fails
    Files.createDirectory(new File(certsDir, ".certificates.lock").toPath());

    new CertManager(certsDir.getPath()).createCertificatesIfNeeded();

    assertThat(readCertificate(API_SERVER_CERT_NAME).getNotAfter()).isAfter(new Date());
    assertThat(readCertificate(CLIENT_CERT_NAME).getNotAfter()).isAfter(new Date());
  }

  private void generateCertificate(String keyName, String certName, Instant validFrom, Instant validUntil) {
    CertManager.generateKeyAndCertificate("CN=kubeapitest", new File(certsDir, keyName), new File(certsDir, certName),
        validFrom, validUntil);
  }

  private X509Certificate readCertificate(String name) throws Exception {
    try (var in = new FileInputStream(new File(certsDir, name))) {
      return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(in);
    }
  }

}
