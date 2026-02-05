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
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.admission.v1.AdmissionRequest;
import io.fabric8.kubernetes.api.model.admission.v1.AdmissionReview;
import io.fabric8.kubernetes.api.model.admission.v1.AdmissionReviewBuilder;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.networking.v1.HTTPIngressPathBuilder;
import io.fabric8.kubernetes.api.model.networking.v1.HTTPIngressRuleValueBuilder;
import io.fabric8.kubernetes.api.model.networking.v1.Ingress;
import io.fabric8.kubernetes.api.model.networking.v1.IngressBackendBuilder;
import io.fabric8.kubernetes.api.model.networking.v1.IngressBuilder;
import io.fabric8.kubernetes.api.model.networking.v1.IngressRuleBuilder;
import io.fabric8.kubernetes.api.model.networking.v1.IngressServiceBackendBuilder;
import io.fabric8.kubernetes.api.model.networking.v1.IngressSpecBuilder;
import io.fabric8.kubernetes.api.model.networking.v1.ServiceBackendPortBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.NamespaceableResource;
import io.fabric8.mockwebserver.MockWebServer;
import io.fabric8.mockwebserver.http.Dispatcher;
import io.fabric8.mockwebserver.http.MockResponse;
import io.fabric8.mockwebserver.http.RecordedRequest;
import org.bouncycastle.asn1.x509.GeneralName;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Test demonstrates how to test locally Validating Webhooks using the kube-api-test module.
 * The validating webhook rejects Ingress resources that have the annotation "reject=true".
 */
@EnableKubeAPIServer
class KubernetesValidationHookHandlingTest {

  @KubeConfig
  static String kubeConfig;

  static MockWebServer webhookServer;
  static File certFile;

  @BeforeAll
  static void setupWebhookServer() {
    certFile = new File("target/conversion.crt");
    if (certFile.getParentFile() != null) {
      certFile.getParentFile().mkdirs();
    }

    File keyFile = new File("target/conversion.key");

    CertManager.generateKeyAndCertificate("CN=localhost", keyFile, certFile,
      new GeneralName(GeneralName.dNSName, "localhost"));

    webhookServer = new MockWebServer();
    webhookServer.usePemCertificates(keyFile, certFile);
    webhookServer.useHttps();
    webhookServer.setDispatcher(new Dispatcher() {
      @Override
      public MockResponse dispatch(RecordedRequest request) {
        String path = request.getPath();
        if (path != null && path.startsWith("/validate")) {
          return handleValidatingWebhook(request);
        }
        return new MockResponse().setResponseCode(404);
      }
    });
    webhookServer.start(8444);
  }

  @AfterAll
  static void shutdownWebhookServer() {
    if (webhookServer != null) {
      webhookServer.shutdown();
    }
  }

  @Test
  void validatingWebhookAllowsValidResource() {
    KubernetesClient client = new KubernetesClientBuilder().withConfig(Config.fromKubeconfig(kubeConfig)).build();
    applyConfig(client);

    Ingress ingress = client.resource(validIngress()).create();

    assertThat(ingress.getMetadata().getName()).isEqualTo("valid-ingress");
  }

  @Test
  void validatingWebhookRejectsInvalidResource() {
    KubernetesClient client = new KubernetesClientBuilder().withConfig(Config.fromKubeconfig(kubeConfig)).build();
    applyConfig(client);

    NamespaceableResource<Ingress> ingressResource = client.resource(invalidIngress());
    assertThatThrownBy(ingressResource::create)
        .isInstanceOf(KubernetesClientException.class)
        .hasMessageContaining("Ingress with annotation 'reject=true' is not allowed");
  }

  static MockResponse handleValidatingWebhook(RecordedRequest request) {
    AdmissionReview admissionReview = WebhookServerTestUtils.parseAdmissionReview(request);
    AdmissionRequest admissionRequest = admissionReview.getRequest();
    AdmissionReview responseReview = buildValidationResponse(admissionRequest);
    return WebhookServerTestUtils.createJsonResponse(responseReview);
  }

  private static AdmissionReview buildValidationResponse(AdmissionRequest admissionRequest) {
    Object resource = WebhookServerTestUtils.getResourceFromAdmissionRequest(admissionRequest);
    HasMetadata hasMetadata = WebhookServerTestUtils.asHasMetadata(resource);

    if (hasMetadata != null) {
      var annotations = hasMetadata.getMetadata().getAnnotations();
      if (annotations != null && "true".equals(annotations.get("reject"))) {
        return new AdmissionReviewBuilder()
            .withNewResponse()
            .withAllowed(false)
            .withStatus(new StatusBuilder()
                .withCode(403)
                .withMessage("Ingress with annotation 'reject=true' is not allowed")
                .build())
            .withUid(admissionRequest.getUid())
            .endResponse()
            .build();
      }
    }

    return new AdmissionReviewBuilder()
        .withNewResponse()
        .withAllowed(true)
        .withUid(admissionRequest.getUid())
        .endResponse()
        .build();
  }

  private void applyConfig(KubernetesClient client) {
    try (InputStream resource = KubernetesValidationHookHandlingTest.class
        .getResourceAsStream("/ValidatingWebhookConfig.yaml")) {
      ValidatingWebhookConfiguration hook = (ValidatingWebhookConfiguration) client.load(resource).items().get(0);
      hook.getWebhooks().get(0).getClientConfig().setCaBundle(WebhookServerTestUtils.getEncodedCertificate(certFile));
      client.resource(hook).serverSideApply();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static Ingress validIngress() {
    return new IngressBuilder()
        .withNewMetadata()
        .withName("valid-ingress")
        .endMetadata()
        .withSpec(new IngressSpecBuilder()
            .withIngressClassName("sample")
            .withRules(new IngressRuleBuilder()
                .withHttp(new HTTPIngressRuleValueBuilder()
                    .withPaths(new HTTPIngressPathBuilder()
                        .withPath("/valid")
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

  public static Ingress invalidIngress() {
    return new IngressBuilder()
        .withNewMetadata()
        .withName("invalid-ingress")
        .addToAnnotations("reject", "true")
        .endMetadata()
        .withSpec(new IngressSpecBuilder()
            .withIngressClassName("sample")
            .withRules(new IngressRuleBuilder()
                .withHttp(new HTTPIngressRuleValueBuilder()
                    .withPaths(new HTTPIngressPathBuilder()
                        .withPath("/invalid")
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
