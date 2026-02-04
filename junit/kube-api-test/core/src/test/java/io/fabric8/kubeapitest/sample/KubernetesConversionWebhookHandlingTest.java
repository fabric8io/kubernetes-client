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
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubeapitest.junit.EnableWebhookServer;
import io.fabric8.kubeapitest.junit.KubeConfig;
import io.fabric8.kubeapitest.junit.WebhookCertFile;
import io.fabric8.kubeapitest.junit.WebhookHandler;
import io.fabric8.kubeapitest.junit.WebhookServerUtils;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceBuilder;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.ConversionRequest;
import io.fabric8.kubernetes.api.model.apiextensions.v1.ConversionReview;
import io.fabric8.kubernetes.api.model.apiextensions.v1.ConversionReviewBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.http.MockResponse;
import io.fabric8.mockwebserver.http.RecordedRequest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test demonstrates how to test locally Conversion Webhooks for CustomResourceDefinitions
 * using the kube-api-test module.
 * <p>
 * The conversion webhook converts between v1alpha1 and v1beta1 versions of a custom resource,
 * specifically converting a "hostPort" field to separate "host" and "port" fields (and vice versa).
 */
@EnableKubeAPIServer
@EnableWebhookServer(port = 8445, certFile = "conversion.crt")
class KubernetesConversionWebhookHandlingTest {

  private static final String GROUP = "kubeapitest.example.com";
  private static final String PLURAL = "testresources";

  @KubeConfig
  static String kubeConfig;

  @WebhookCertFile
  static File certFile;

  @Test
  void conversionWebhookConvertsV1alpha1ToV1beta1() {
    KubernetesClient client = new KubernetesClientBuilder().withConfig(Config.fromKubeconfig(kubeConfig)).build();
    applyCrd(client);

    // Create a v1alpha1 resource with hostPort
    GenericKubernetesResource v1alpha1Resource = new GenericKubernetesResourceBuilder()
        .withApiVersion(GROUP + "/v1alpha1")
        .withKind("TestResource")
        .withNewMetadata()
        .withName("test-resource-1")
        .withNamespace("default")
        .endMetadata()
        .build();
    v1alpha1Resource.setAdditionalProperty("spec", Map.of("hostPort", "localhost:8080"));

    client.genericKubernetesResources(contextForVersion("v1alpha1")).resource(v1alpha1Resource).create();

    // Read it back as v1beta1 - the conversion webhook should have converted it
    GenericKubernetesResource v1beta1Resource = client.genericKubernetesResources(contextForVersion("v1beta1"))
        .inNamespace("default")
        .withName("test-resource-1")
        .get();

    assertThat(v1beta1Resource).isNotNull();
    @SuppressWarnings("unchecked")
    Map<String, Object> spec = (Map<String, Object>) v1beta1Resource.getAdditionalProperties().get("spec");
    assertThat(spec).containsEntry("host", "localhost").containsEntry("port", "8080");
  }

  @Test
  void conversionWebhookConvertsV1beta1ToV1alpha1() {
    KubernetesClient client = new KubernetesClientBuilder().withConfig(Config.fromKubeconfig(kubeConfig)).build();
    applyCrd(client);

    // Create a v1beta1 resource with host and port
    GenericKubernetesResource v1beta1Resource = new GenericKubernetesResourceBuilder()
        .withApiVersion(GROUP + "/v1beta1")
        .withKind("TestResource")
        .withNewMetadata()
        .withName("test-resource-2")
        .withNamespace("default")
        .endMetadata()
        .build();
    v1beta1Resource.setAdditionalProperty("spec", Map.of("host", "example.com", "port", "443"));

    client.genericKubernetesResources(contextForVersion("v1beta1")).resource(v1beta1Resource).create();

    // Read it back as v1alpha1 - the conversion webhook should have converted it
    GenericKubernetesResource v1alpha1Resource = client.genericKubernetesResources(contextForVersion("v1alpha1"))
        .inNamespace("default")
        .withName("test-resource-2")
        .get();

    assertThat(v1alpha1Resource).isNotNull();
    @SuppressWarnings("unchecked")
    Map<String, Object> spec = (Map<String, Object>) v1alpha1Resource.getAdditionalProperties().get("spec");
    assertThat(spec).containsEntry("hostPort", "example.com:443");
  }

  private CustomResourceDefinitionContext contextForVersion(String version) {
    return new CustomResourceDefinitionContext.Builder()
        .withGroup(GROUP)
        .withVersion(version)
        .withPlural(PLURAL)
        .withScope("Namespaced")
        .withKind("TestResource")
        .build();
  }

  @WebhookHandler(path = "/convert")
  static MockResponse handleConversionWebhook(RecordedRequest request) {
    String body = request.getUtf8Body();
    ConversionReview conversionReview = Serialization.unmarshal(body, ConversionReview.class);
    ConversionReview responseReview = buildConversionResponse(conversionReview.getRequest());
    return WebhookServerUtils.createJsonResponse(responseReview);
  }

  private static ConversionReview buildConversionResponse(ConversionRequest conversionRequest) {
    String desiredVersion = conversionRequest.getDesiredAPIVersion();

    List<Object> convertedObjects = new ArrayList<>();
    for (Object obj : conversionRequest.getObjects()) {
      JsonNode node = Serialization.jsonMapper().valueToTree(obj);
      ObjectNode converted = convertResource((ObjectNode) node, desiredVersion);
      try {
        convertedObjects.add(Serialization.jsonMapper().treeToValue(converted, GenericKubernetesResource.class));
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    return new ConversionReviewBuilder()
        .withNewResponse()
        .withUid(conversionRequest.getUid())
        .withConvertedObjects(convertedObjects)
        .withResult(new StatusBuilder().withStatus("Success").build())
        .endResponse()
        .build();
  }

  /**
   * Converts between v1alpha1 (hostPort field) and v1beta1 (host + port fields).
   */
  private static ObjectNode convertResource(ObjectNode resource, String desiredApiVersion) {
    ObjectNode result = resource.deepCopy();
    result.put("apiVersion", desiredApiVersion);

    ObjectNode spec = (ObjectNode) result.get("spec");
    if (spec == null) {
      return result;
    }

    if (desiredApiVersion.endsWith("/v1beta1")) {
      // Convert from v1alpha1 to v1beta1: split hostPort into host and port
      if (spec.has("hostPort")) {
        String hostPort = spec.get("hostPort").asText();
        String[] parts = hostPort.split(":");
        spec.put("host", parts[0]);
        spec.put("port", parts.length > 1 ? parts[1] : "80");
        spec.remove("hostPort");
      }
    } else if (desiredApiVersion.endsWith("/v1alpha1") && spec.has("host") && spec.has("port")) {
      String host = spec.get("host").asText();
      String port = spec.get("port").asText();
      spec.put("hostPort", host + ":" + port);
      spec.remove("host");
      spec.remove("port");
    }

    return result;
  }

  private void applyCrd(KubernetesClient client) {
    try (InputStream resource = KubernetesConversionWebhookHandlingTest.class
        .getResourceAsStream("/ConversionWebhookCRD.yaml")) {
      CustomResourceDefinition crd = (CustomResourceDefinition) client.load(resource).items().get(0);
      crd.getSpec().getConversion().getWebhook().getClientConfig()
          .setCaBundle(WebhookServerUtils.getEncodedCertificate(certFile));
      client.resource(crd).serverSideApply();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
