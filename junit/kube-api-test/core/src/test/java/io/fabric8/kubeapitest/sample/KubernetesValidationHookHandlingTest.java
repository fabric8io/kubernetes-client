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

import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubeapitest.junit.KubeConfig;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.admission.v1.AdmissionReviewBuilder;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.networking.v1.*;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.eclipse.jetty.server.Server;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Test demonstrates how to test locally Validating Webhooks using the kube-api-test module.
 * The validating webhook rejects Ingress resources that have the annotation "reject=true".
 */
@EnableKubeAPIServer
class KubernetesValidationHookHandlingTest extends AbstractWebhookHandlingTest {

  private static final int PORT = 8444;
  private static final File keyFile = new File("target", "validation.key");
  private static final File certFile = new File("target", "validation.crt");
  private static final Server server = new Server();

  @KubeConfig
  static String kubeConfig;

  @Test
  void validatingWebhookAllowsValidResource() {
    var client = new KubernetesClientBuilder().withConfig(Config.fromKubeconfig(kubeConfig)).build();
    applyConfig(client);

    var ingress = client.resource(validIngress()).create();

    assertThat(ingress.getMetadata().getName()).isEqualTo("valid-ingress");
  }

  @Test
  void validatingWebhookRejectsInvalidResource() {
    var client = new KubernetesClientBuilder().withConfig(Config.fromKubeconfig(kubeConfig)).build();
    applyConfig(client);

    assertThatThrownBy(() -> client.resource(invalidIngress()).create())
        .isInstanceOf(KubernetesClientException.class)
        .hasMessageContaining("Ingress with annotation 'reject=true' is not allowed");
  }

  @BeforeAll
  static void startWebhookServer() throws Exception {
    startServer(server, PORT, keyFile, certFile, (request, response) -> {
      var admissionReview = parseAdmissionReview(request);
      var admissionRequest = admissionReview.getRequest();
      var resource = getResourceFromAdmissionRequest(admissionRequest);

      boolean allowed = true;
      String message = null;

      HasMetadata hasMetadata = asHasMetadata(resource);
      if (hasMetadata != null) {
        var metadata = hasMetadata.getMetadata();
        if (metadata.getAnnotations() != null
            && "true".equals(metadata.getAnnotations().get("reject"))) {
          allowed = false;
          message = "Ingress with annotation 'reject=true' is not allowed";
        }
      }

      var responseReview = allowed
          ? new AdmissionReviewBuilder()
              .withNewResponse()
              .withAllowed(true)
              .withUid(admissionRequest.getUid())
              .endResponse()
              .build()
          : new AdmissionReviewBuilder()
              .withNewResponse()
              .withAllowed(false)
              .withStatus(new StatusBuilder()
                  .withCode(403)
                  .withMessage(message)
                  .build())
              .withUid(admissionRequest.getUid())
              .endResponse()
              .build();

      writeJsonResponse(response, responseReview);
    });
  }

  @AfterAll
  static void stopWebhookServer() throws Exception {
    stopServer(server);
  }

  private void applyConfig(KubernetesClient client) {
    try (var resource = KubernetesValidationHookHandlingTest.class
        .getResourceAsStream("/ValidatingWebhookConfig.yaml")) {
      ValidatingWebhookConfiguration hook = (ValidatingWebhookConfiguration) client.load(resource).items().get(0);
      hook.getWebhooks().get(0).getClientConfig().setCaBundle(getEncodedCertificate(certFile));
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
