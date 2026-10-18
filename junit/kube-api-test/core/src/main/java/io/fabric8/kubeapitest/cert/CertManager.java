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
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

public class CertManager {

  private static final Logger logger = LoggerFactory.getLogger(CertManager.class);

  public static final String API_SERVER_KEY_NAME = "apiserver.key";
  public static final String API_SERVER_CERT_NAME = "apiserver.crt";

  public static final String CLIENT_KEY_NAME = "client.key";
  public static final String CLIENT_CERT_NAME = "client.crt";

  // certificates expiring within this period are regenerated, so they do not expire during a test run
  private static final Duration VALIDITY_MARGIN = Duration.ofDays(1);
  private static final String LOCK_FILE_NAME = ".certificates.lock";

  // serializes the threads of this JVM; the lock file serializes the JVMs sharing the directory
  private static final ReentrantLock generatorLock = new ReentrantLock();

  private final String kubeAPITestDir;

  public CertManager(String kubeAPITestDir) {
    this.kubeAPITestDir = kubeAPITestDir;
  }

  public void createCertificatesIfNeeded() {
    if (unusableReason().isEmpty()) {
      return;
    }
    generatorLock.lock();
    try (var ignored = lockAgainstOtherJvms()) {
      // re-checked: another thread or JVM may have generated them while this one waited for the locks
      unusableReason().ifPresent(reason -> {
        logger.info("Generating certificates in {}: {}", kubeAPITestDir, reason);
        generateAPIServerCertificates();
        generateUserCertificates();
      });
    } catch (IOException e) {
      throw new KubeAPITestException(e);
    } finally {
      generatorLock.unlock();
    }
  }

  /**
   * @return why the certificates can't be used, empty when both are valid for at least {@link #VALIDITY_MARGIN} and
   *         their key files hold their keys
   */
  private Optional<String> unusableReason() {
    return unusableReason(API_SERVER_CERT_NAME, API_SERVER_KEY_NAME)
        .or(() -> unusableReason(CLIENT_CERT_NAME, CLIENT_KEY_NAME));
  }

  private Optional<String> unusableReason(String certName, String keyName) {
    var certFile = new File(kubeAPITestDir, certName);
    var keyFile = new File(kubeAPITestDir, keyName);
    if (!certFile.isFile() || !keyFile.isFile()) {
      return Optional.of(certName + " or " + keyName + " is missing");
    }
    try {
      if (!(readPem(certFile) instanceof X509CertificateHolder cert)) {
        return Optional.of(certName + " is not a PEM certificate");
      }
      var validOn = Date.from(Instant.now().plus(VALIDITY_MARGIN));
      if (!cert.isValidOn(validOn)) {
        return Optional.of(String.format("%s is valid from %s to %s, not on %s", certName, cert.getNotBefore(),
            cert.getNotAfter(), validOn));
      }
      if (!(readPem(keyFile) instanceof PEMKeyPair key)
          || !key.getPublicKeyInfo().equals(cert.getSubjectPublicKeyInfo())) {
        return Optional.of(keyName + " is not the key of " + certName);
      }
      return Optional.empty();
    } catch (IOException | RuntimeException e) {
      // whatever can't be parsed gets regenerated
      return Optional.of(certName + " or " + keyName + " can't be read: " + e);
    }
  }

  private static Object readPem(File file) throws IOException {
    try (var parser = new PEMParser(new FileReader(file, StandardCharsets.US_ASCII))) {
      return parser.readObject();
    }
  }

  /**
   * Locks the lock file in the certificate directory, falling back to no lock (with a warning) when the file system
   * doesn't support it or another class loader of this JVM holds it.
   *
   * @return releases the lock when closed
   */
  private Closeable lockAgainstOtherJvms() {
    var lockFile = new File(kubeAPITestDir, LOCK_FILE_NAME).toPath();
    try {
      Files.createDirectories(lockFile.getParent());
      var channel = FileChannel.open(lockFile, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
      try {
        channel.lock();
        return channel;
      } catch (IOException | OverlappingFileLockException e) {
        channel.close();
        throw e;
      }
    } catch (IOException | OverlappingFileLockException e) {
      logger.warn("Could not lock {}, certificates are generated without guarding against other JVMs: {}", lockFile,
          e.toString());
      return () -> {
      };
    }
  }

  private void generateAPIServerCertificates() {
    logger.info("Generating API Server certificates");
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
    logger.info("Generating Client certificates");
    generateKeyAndCertificate("O=system:masters,CN=kubeapitest",
        new File(kubeAPITestDir, CLIENT_KEY_NAME),
        new File(kubeAPITestDir, CLIENT_CERT_NAME));
  }

  public static void generateKeyAndCertificate(String dirName, File keyFile, File certFile,
      GeneralName... generalNames) {
    Instant validFrom = Instant.now();
    generateKeyAndCertificate(dirName, keyFile, certFile, validFrom, validFrom.plus(365, ChronoUnit.DAYS),
        generalNames);
  }

  static void generateKeyAndCertificate(String dirName, File keyFile, File certFile, Instant validFrom,
      Instant validUntil, GeneralName... generalNames) {
    try {
      KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");

      KeyPair certKeyPair = keyGen.generateKeyPair();
      X500Name name = new X500Name(dirName);
      // If you issue more than just test certificates, you might want a decent serial number schema
      // ^.^
      BigInteger serialNumber = BigInteger.valueOf(System.currentTimeMillis());

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
