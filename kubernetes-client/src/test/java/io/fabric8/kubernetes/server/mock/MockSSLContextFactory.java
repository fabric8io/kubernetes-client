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

package io.fabric8.kubernetes.server.mock;

import com.ning.http.util.Base64;
import io.fabric8.kubernetes.client.internal.SSLUtils;
import sun.security.x509.AlgorithmId;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateValidity;
import sun.security.x509.CertificateVersion;
import sun.security.x509.CertificateX509Key;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.xml.bind.DatatypeConverter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Random;

public class MockSSLContextFactory {

  // Begin markers for all supported PEM files
  public static final String CERTIFICATE_FORMAT = "-----BEGIN PRIVATE KEY-----\n%s\n-----END PRIVATE KEY-----";
  public static final String PRIVATE_RSA_FORMAT = "-----BEGIN RSA PRIVATE KEY-----\n%s\n-----END RSA PRIVATE KEY-----";

  public static SSLContext create() {
    try {
      KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
      KeyPair keyPair = keyPairGenerator.generateKeyPair();
      X500Name name = new X500Name("CN=My Kubernetes Mock Server,O=My Organisation,L=My City,C=GR");
      PublicKey publicKey = keyPair.getPublic();
      PrivateKey privateKey = keyPair.getPrivate();
      X509Certificate certificate = createCertificate(name, publicKey, privateKey);
      String certificateData = Base64.encode(String.format(CERTIFICATE_FORMAT, DatatypeConverter.printBase64Binary(certificate.getEncoded())).getBytes());
      String privateKeyData = Base64.encode(String.format(PRIVATE_RSA_FORMAT, DatatypeConverter.printBase64Binary(privateKey.getEncoded())).getBytes());
      KeyManager[] keyManagers = SSLUtils.keyManagers(certificateData, null, privateKeyData, null, "RSA", "");
      return SSLUtils.sslContext(keyManagers, null, true);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static X509Certificate createCertificate(X500Name name, PublicKey publicKey, PrivateKey privateKey) throws Exception {
    Date notBefore = new Date();
    Date notAfter = new Date();
    notAfter.setTime(System.currentTimeMillis() + 24 * 60 * 60 * 1000L);

    CertificateValidity certificateValidity = new CertificateValidity(notBefore, notAfter);
    X509CertInfo certInfo = new X509CertInfo();
    certInfo.set("version", new CertificateVersion(2));
    certInfo.set("serialNumber", new CertificateSerialNumber((new Random()).nextInt() & 2147483647));
    AlgorithmId algorithmId = AlgorithmId.get("SHA256withRSA");
    certInfo.set("algorithmID", new CertificateAlgorithmId(algorithmId));
    certInfo.set("subject", name);
    certInfo.set("key", new CertificateX509Key(publicKey));
    certInfo.set("validity", certificateValidity);
    certInfo.set("issuer", name);

    X509CertImpl cert = new X509CertImpl(certInfo);
    cert.sign(privateKey, "SHA256withRSA");
    return cert;
  }
}
