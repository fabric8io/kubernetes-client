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
package io.fabric8.kubeapitest.sample;

import io.fabric8.kubeapitest.cert.CertManager;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.admission.v1.AdmissionRequest;
import io.fabric8.kubernetes.api.model.admission.v1.AdmissionReview;
import io.fabric8.kubernetes.client.utils.Serialization;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.SecureRequestCustomizer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Objects;

/**
 * Abstract base class for webhook handling tests that provides common functionality
 * for setting up HTTPS servers with TLS certificates.
 */
abstract class AbstractWebhookHandlingTest {

  private static final Logger logger = LoggerFactory.getLogger(AbstractWebhookHandlingTest.class);
  protected static final String PASSWORD = "secret";

  /**
   * Starts the webhook server with the configured port, certificates, and handler.
   *
   * @param server the Jetty server instance
   * @param port the port to listen on
   * @param keyFile the file to write the generated private key
   * @param certFile the file to write the generated certificate
   * @param handler the webhook request handler
   */
  protected static void startServer(Server server, int port, File keyFile, File certFile,
      WebhookHandler handler) throws Exception {
    configureServer(server, port, keyFile, certFile, new AbstractHandler() {
      @Override
      public void handle(String target, Request baseRequest, HttpServletRequest request,
          HttpServletResponse response) {
        try {
          baseRequest.setHandled(true);
          handler.handleWebhook(request, response);
        } catch (Exception e) {
          logger.error("Error in webhook", e);
          throw new RuntimeException(e);
        }
      }
    });
    server.start();
  }

  /**
   * Stops the webhook server.
   */
  protected static void stopServer(Server server) throws Exception {
    server.stop();
  }

  /**
   * Functional interface for handling webhook requests.
   */
  @FunctionalInterface
  protected interface WebhookHandler {
    void handleWebhook(HttpServletRequest request, HttpServletResponse response) throws Exception;
  }

  /**
   * Writes the JSON response to the HTTP response.
   */
  protected static void writeJsonResponse(HttpServletResponse response, Object responseObject) throws IOException {
    var out = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
    response.setStatus(HttpServletResponse.SC_OK);
    out.println(Serialization.asJson(responseObject));
  }

  /**
   * Extracts the resource object from an AdmissionRequest, handling DELETE operations.
   */
  protected static Object getResourceFromAdmissionRequest(AdmissionRequest admissionRequest) {
    return Objects.equals("DELETE", admissionRequest.getOperation())
        ? admissionRequest.getOldObject()
        : admissionRequest.getObject();
  }

  /**
   * Deserializes an AdmissionReview from the request input stream.
   */
  protected static AdmissionReview parseAdmissionReview(HttpServletRequest request) throws IOException {
    return Serialization.unmarshal(request.getInputStream());
  }

  /**
   * Casts a resource to HasMetadata if possible.
   */
  protected static HasMetadata asHasMetadata(Object resource) {
    return resource instanceof HasMetadata ? (HasMetadata) resource : null;
  }

  /**
   * Reads the certificate from file and returns it as a Base64-encoded string
   * suitable for use in webhook configurations.
   */
  protected static String getEncodedCertificate(File certFile) {
    try {
      String cert = Files.readString(certFile.toPath(), StandardCharsets.UTF_8);
      return new String(Base64.getEncoder().encode(cert.getBytes()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Configures the HTTPS server with TLS.
   */
  private static void configureServer(Server server, int port, File keyFile, File certFile,
      AbstractHandler handler) {
    HttpConfiguration httpConfig = new HttpConfiguration();
    httpConfig.addCustomizer(new SecureRequestCustomizer());
    HttpConnectionFactory http11 = new HttpConnectionFactory(httpConfig);

    SslContextFactory.Server sslContextFactory = new SslContextFactory.Server();

    CertManager.generateKeyAndCertificate("CN=example.org", keyFile, certFile,
        new GeneralName(GeneralName.iPAddress, "127.0.0.1"));
    sslContextFactory.setKeyStore(createKeyStoreFrom(keyFile, certFile));
    sslContextFactory.setKeyStorePassword(PASSWORD);
    SslConnectionFactory tls = new SslConnectionFactory(sslContextFactory, http11.getProtocol());

    ServerConnector connector = new ServerConnector(server, tls, http11);
    connector.setPort(port);
    server.addConnector(connector);
    server.setHandler(handler);
  }

  /**
   * Creates a KeyStore from PEM-formatted key and certificate files.
   */
  private static KeyStore createKeyStoreFrom(File keyPem, File certPem) {
    try (var certReader = new PEMParser(new InputStreamReader(new FileInputStream(certPem)));
        var keyReader = new PEMParser(new InputStreamReader(new FileInputStream(keyPem)))) {
      var certConverter = new JcaX509CertificateConverter();
      X509Certificate cert = certConverter.getCertificate((X509CertificateHolder) certReader.readObject());

      JcaPEMKeyConverter keyConverter = new JcaPEMKeyConverter();
      PrivateKey key = keyConverter.getPrivateKey(((PEMKeyPair) keyReader.readObject()).getPrivateKeyInfo());

      KeyStore keystore = KeyStore.getInstance("JKS");
      keystore.load(null);
      keystore.setCertificateEntry("cert-alias", cert);
      keystore.setKeyEntry("key-alias", key, PASSWORD.toCharArray(), new Certificate[] { cert });

      return keystore;
    } catch (IOException | CertificateException | KeyStoreException | NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }
}
