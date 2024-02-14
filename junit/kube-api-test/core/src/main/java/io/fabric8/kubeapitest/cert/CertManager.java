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

import io.fabric8.kubeapitest.KubeAPITestException;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class CertManager {

  private static final Logger log = LoggerFactory.getLogger(CertManager.class);

  public static final String API_SERVER_KEY_NAME = "apiserver.key";
  public static final String API_SERVER_CERT_NAME = "apiserver.crt";

  public static final String CLIENT_KEY_NAME = "client.key";
  public static final String CLIENT_CERT_NAME = "client.crt";

  private static final ReentrantLock generatorLock = new ReentrantLock();

  private final String kubeAPITestDir;

  public CertManager(String kubeAPITestDir) {
    this.kubeAPITestDir = kubeAPITestDir;
  }

  public void createCertificatesIfNeeded() {
    if (certFilesPresent()) {
      return;
    }
    generatorLock.lock();
    try {
      if (certFilesPresent()) {
        return;
      }
      generateAPIServerCertificates();
      generateUserCertificates();
    } finally {
      generatorLock.unlock();
    }
  }

  private boolean certFilesPresent() {
    var apiCert = new File(kubeAPITestDir, API_SERVER_CERT_NAME);
    var apiKey = new File(kubeAPITestDir, API_SERVER_KEY_NAME);
    var clientCert = new File(kubeAPITestDir, CLIENT_CERT_NAME);
    var clientKey = new File(kubeAPITestDir, CLIENT_KEY_NAME);

    return apiCert.exists() && apiKey.exists() && clientCert.exists() && clientKey.exists();
  }

  private void generateAPIServerCertificates() {
    log.info("Generating API Server certificates");
    generateKeyAndCertificate("CN=example.org", new File(kubeAPITestDir, API_SERVER_KEY_NAME),
        new File(kubeAPITestDir, API_SERVER_CERT_NAME),
        new GeneralName(GeneralName.iPAddress, "127.0.0.1"),
        dns("kubernetes"), dns("kubernetes.default"),
        dns("kubernetes.default.svc"), dns("kubernetes.default.svc.cluster"),
        dns("kubernetes.default.svc.cluster.local"));
  }

  private GeneralName dns(String dns) {
    return new GeneralName(GeneralName.dNSName, dns);
  }

  private void generateUserCertificates() {
    log.info("Generating Client certificates");
    generateKeyAndCertificate("O=system:masters,CN=kubeapitest",
        new File(kubeAPITestDir, CLIENT_KEY_NAME),
        new File(kubeAPITestDir, CLIENT_CERT_NAME));
  }

  public static void generateKeyAndCertificate(String dirName, File keyFile, File certFile,
      GeneralName... generalNames) {
    try {
      KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");

      KeyPair certKeyPair = keyGen.generateKeyPair();
      X500Name name = new X500Name(dirName);
      // If you issue more than just test certificates, you might want a decent serial number schema
      // ^.^
      BigInteger serialNumber = BigInteger.valueOf(System.currentTimeMillis());
      Instant validFrom = Instant.now();
      Instant validUntil = validFrom.plus(365, ChronoUnit.DAYS);

      JcaX509v3CertificateBuilder builder = new JcaX509v3CertificateBuilder(
          name,
          serialNumber,
          Date.from(validFrom), Date.from(validUntil),
          name, certKeyPair.getPublic());

      if (generalNames.length > 0) {
        builder.addExtension(Extension.subjectAlternativeName, false,
            new GeneralNames(generalNames));
      }

      // Finally, sign the certificate:
      ContentSigner signer = new JcaContentSignerBuilder("SHA256WithRSA").build(certKeyPair.getPrivate());
      X509CertificateHolder certHolder = builder.build(signer);
      X509Certificate cert = new JcaX509CertificateConverter().getCertificate(certHolder);

      try (FileWriter certWriter = new FileWriter(certFile);
          JcaPEMWriter certPemWriter = new JcaPEMWriter(certWriter);
          FileWriter keyWriter = new FileWriter(keyFile);
          JcaPEMWriter keyPemWriter = new JcaPEMWriter(keyWriter)) {
        certPemWriter.writeObject(cert);
        keyPemWriter.writeObject(certKeyPair.getPrivate());
      }
    } catch (NoSuchAlgorithmException | CertificateException | IOException
        | OperatorCreationException e) {
      throw new KubeAPITestException(e);
    }
  }

  public String getClientCertPath() {
    return new File(kubeAPITestDir, CLIENT_CERT_NAME).getAbsolutePath();
  }

  public String getClientKeyPath() {
    return new File(kubeAPITestDir, CLIENT_KEY_NAME).getAbsolutePath();
  }

  public String getAPIServerKeyPath() {
    return new File(kubeAPITestDir, API_SERVER_KEY_NAME).getAbsolutePath();
  }

  public String getAPIServerCertPath() {
    return new File(kubeAPITestDir, API_SERVER_CERT_NAME).getAbsolutePath();
  }
}
