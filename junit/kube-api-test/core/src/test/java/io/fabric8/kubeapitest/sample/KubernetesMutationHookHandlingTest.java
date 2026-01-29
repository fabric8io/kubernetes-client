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
import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubeapitest.junit.KubeConfig;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.admission.v1.AdmissionRequest;
import io.fabric8.kubernetes.api.model.admission.v1.AdmissionReview;
import io.fabric8.kubernetes.api.model.admission.v1.AdmissionReviewBuilder;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.networking.v1.*;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.zjsonpatch.JsonDiff;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
import java.util.Collections;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test demonstrates how to test locally Mutating Webhooks, in real like you implementation such an
 * endpoint would be simpler, using frameworks like
 * <a href="https://github.com/java-operator-sdk/kubernetes-webooks-framework">Kubernetes Webhook
 * Framework</a> with combination of Quarkus or Spring.
 */
@EnableKubeAPIServer
class KubernetesMutationHookHandlingTest {

  @KubeConfig
  static String kubeConfig;

  private static final Logger logger = LoggerFactory.getLogger(KubernetesMutationHookHandlingTest.class);

  public static final String PASSWORD = "secret";

  static File certFile = new File("target", "mutation.crt");
  // server that handles mutation hooks
  static Server server = new Server();

  @Test
  void handleMutatingWebhook() {
    var client = new KubernetesClientBuilder().withConfig(Config.fromKubeconfig(kubeConfig)).build();
    applyConfig(client);

    var ingress = client.resource(testIngress()).create();

    assertThat(ingress.getMetadata().getLabels()).containsEntry("test", "mutation");
  }

  @BeforeAll
  static void startWebhookServer() throws Exception {
    initServerConfigs();
    server.setHandler(new AbstractHandler() {
      @Override
      public void handle(String s, Request request, HttpServletRequest httpServletRequest,
          HttpServletResponse httpServletResponse) {
        try {
          request.setHandled(true);
          final AdmissionReview requestedAdmissionReview = Serialization.unmarshal(httpServletRequest.getInputStream());
          final AdmissionRequest admissionRequest = requestedAdmissionReview.getRequest();
          var originalResource = Objects.equals("DELETE", admissionRequest.getOperation())
              ? admissionRequest.getOldObject()
              : admissionRequest.getObject();
          if (originalResource instanceof HasMetadata) {
            var originalResourceJson = Serialization.jsonMapper().valueToTree(originalResource);
            (((HasMetadata) originalResource)).getMetadata().setLabels(Collections.singletonMap("test", "mutation"));
            var editedResourceJson = Serialization.jsonMapper().valueToTree(originalResource);
            final AdmissionReview responseAdmissionReview = new AdmissionReviewBuilder()
                .withNewResponse()
                .withAllowed()
                .withPatchType("JSONPatch")
                .withPatch(Base64.getEncoder().encodeToString(
                    JsonDiff.asJson(originalResourceJson, editedResourceJson).toString().getBytes(StandardCharsets.UTF_8)))
                .withUid(admissionRequest.getUid())
                .endResponse()
                .build();

            var out = httpServletResponse.getWriter();
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.toString());
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            out.println(Serialization.asJson(responseAdmissionReview));
          } else {
            httpServletResponse.setStatus(422);
          }
        } catch (Exception e) {
          logger.error("Error in webhook", e);
          throw new RuntimeException(e);
        }
      }
    });
    server.start();
  }

  @AfterAll
  static void stopWebhookServer() throws Exception {
    server.stop();
  }

  private void applyConfig(KubernetesClient client) {
    try (var resource = KubernetesMutationHookHandlingTest.class
        .getResourceAsStream("/MutatingWebhookConfig.yaml")) {
      MutatingWebhookConfiguration hook = (MutatingWebhookConfiguration) client.load(resource).items().get(0);

      String cert = Files.readString(certFile.toPath(), StandardCharsets.UTF_8);

      hook.getWebhooks().get(0).getClientConfig()
          .setCaBundle(new String(Base64.getEncoder().encode(cert.getBytes())));

      client.resource(hook).create();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void initServerConfigs() {
    HttpConfiguration httpConfig = new HttpConfiguration();
    httpConfig.addCustomizer(new SecureRequestCustomizer());
    HttpConnectionFactory http11 = new HttpConnectionFactory(httpConfig);

    SslContextFactory.Server sslContextFactory = new SslContextFactory.Server();
    var keyFile = new File("target", "mutation.key");

    // certificates are generated in pem format, since are used also as an input for
    // MutatingWebhookConfiguration CA Bundle
    CertManager.generateKeyAndCertificate("CN=example.org", keyFile, certFile,
        new GeneralName(GeneralName.iPAddress, "127.0.0.1"));
    sslContextFactory.setKeyStore(createKeyStoreFrom(keyFile, certFile));
    sslContextFactory.setKeyStorePassword(PASSWORD);
    SslConnectionFactory tls = new SslConnectionFactory(sslContextFactory, http11.getProtocol());

    ServerConnector connector = new ServerConnector(server, tls, http11);
    connector.setPort(8443);
    server.addConnector(connector);
  }

  /** Creates Keystore from generated Certificate/Key Pem files */
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

  public static Ingress testIngress() {
    return new IngressBuilder()
        .withNewMetadata()
        .withName("test1")
        .endMetadata()
        .withSpec(new IngressSpecBuilder()
            .withIngressClassName("sample")
            .withRules(new IngressRuleBuilder()
                .withHttp(new HTTPIngressRuleValueBuilder()
                    .withPaths(new HTTPIngressPathBuilder()
                        .withPath("/test")
                        .withPathType("Prefix")
                        .withBackend(new IngressBackendBuilder()
                            .withService(new IngressServiceBackendBuilder()
                                .withName("service")
                                .withPort(new ServiceBackendPortBuilder()
                                    .withNumber(80)
                                    .build())
                                .build())
                            .build())
                        .build())
                    .build())
                .build())
            .build())
        .build();
  }

}
