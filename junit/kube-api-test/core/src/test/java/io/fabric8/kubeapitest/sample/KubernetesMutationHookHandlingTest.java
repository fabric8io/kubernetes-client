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

import com.fasterxml.jackson.databind.JsonNode;
import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubeapitest.junit.KubeConfig;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.admission.v1.AdmissionRequest;
import io.fabric8.kubernetes.api.model.admission.v1.AdmissionReview;
import io.fabric8.kubernetes.api.model.admission.v1.AdmissionReviewBuilder;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookConfiguration;
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
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.zjsonpatch.JsonDiff;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test demonstrates how to test locally Mutating Webhooks, in real like you implementation such an
 * endpoint would be simpler, using frameworks like
 * <a href="https://github.com/java-operator-sdk/kubernetes-webooks-framework">Kubernetes Webhook
 * Framework</a> with combination of Quarkus or Spring.
 */
@EnableKubeAPIServer
class KubernetesMutationHookHandlingTest extends AbstractWebhookHandlingTest {

  private static final int PORT = 8443;
  private static final File keyFile = new File("target", "mutation.key");
  private static final File certFile = new File("target", "mutation.crt");
  private static final Server server = new Server();

  @KubeConfig
  static String kubeConfig;

  @Test
  void handleMutatingWebhook() {
    KubernetesClient client = new KubernetesClientBuilder().withConfig(Config.fromKubeconfig(kubeConfig)).build();
    applyConfig(client);

    Ingress ingress = client.resource(testIngress()).create();

    assertThat(ingress.getMetadata().getLabels()).containsEntry("test", "mutation");
  }

  @BeforeAll
  static void startWebhookServer() throws Exception {
    startServer(server, PORT, keyFile, certFile,
        KubernetesMutationHookHandlingTest::handleMutatingWebhook);
  }

  private static void handleMutatingWebhook(HttpServletRequest request, HttpServletResponse response) {
    try {
      AdmissionReview admissionReview = parseAdmissionReview(request);
      AdmissionRequest admissionRequest = admissionReview.getRequest();
      Object resource = getResourceFromAdmissionRequest(admissionRequest);

      if (resource instanceof HasMetadata) {
        HasMetadata hasMetadata = (HasMetadata) resource;
        JsonNode originalJson = Serialization.jsonMapper().valueToTree(resource);
        hasMetadata.getMetadata().setLabels(Collections.singletonMap("test", "mutation"));
        JsonNode editedJson = Serialization.jsonMapper().valueToTree(resource);

        AdmissionReview responseReview = new AdmissionReviewBuilder()
            .withNewResponse()
            .withAllowed()
            .withPatchType("JSONPatch")
            .withPatch(Base64.getEncoder().encodeToString(
                JsonDiff.asJson(originalJson, editedJson).toString().getBytes(StandardCharsets.UTF_8)))
            .withUid(admissionRequest.getUid())
            .endResponse()
            .build();

        writeJsonResponse(response, responseReview);
      } else {
        response.setStatus(422);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @AfterAll
  static void stopWebhookServer() throws Exception {
    stopServer(server);
  }

  private void applyConfig(KubernetesClient client) {
    try (InputStream resource = KubernetesMutationHookHandlingTest.class
        .getResourceAsStream("/MutatingWebhookConfig.yaml")) {
      MutatingWebhookConfiguration hook = (MutatingWebhookConfiguration) client.load(resource).items().get(0);
      hook.getWebhooks().get(0).getClientConfig().setCaBundle(getEncodedCertificate(certFile));
      client.resource(hook).serverSideApply();
    } catch (IOException e) {
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
