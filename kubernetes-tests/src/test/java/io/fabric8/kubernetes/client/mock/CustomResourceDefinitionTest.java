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
package io.fabric8.kubernetes.client.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionList;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class CustomResourceDefinitionTest {

  KubernetesMockServer server;
  KubernetesClient client;

  private CustomResourceDefinition customResourceDefinition;

  @BeforeEach
  void setupCrd() throws IOException {
    customResourceDefinition = new CustomResourceDefinitionBuilder()
        .withApiVersion("apiextensions.k8s.io/v1beta1")
        .withNewMetadata().withName("sparkclusters.radanalytics.io")
        .endMetadata()
        .withNewSpec()
        .withNewNames()
        .withKind("SparkCluster")
        .withPlural("sparkclusters")
        .endNames()
        .withGroup("radanalytics.io")
        .withVersion("v1")
        .withScope("Namespaced")
        .withNewValidation()
        .withNewOpenAPIV3SchemaLike(readSchema())
        .endOpenAPIV3Schema()
        .endValidation()
        .endSpec()
        .build();
  }

  @Test
  void testLoad() {
    List<HasMetadata> crdList = client.load(getClass().getResourceAsStream("/crd-list.yml")).get();
    assertNotNull(crdList);
    assertEquals(5, crdList.size());
  }

  @Test
  void testLoadWithJsonSchemaPropsOrBool() {
    CustomResourceDefinition customResourceDefinition = client.apiextensions().v1beta1().customResourceDefinitions()
        .load(getClass().getResourceAsStream("/kafka-crd.yml")).item();
    assertNotNull(customResourceDefinition);
    assertEquals("kafkatopics.kafka.test", customResourceDefinition.getMetadata().getName());
  }

  @Test
  void testGet() {
    server.expect().get().withPath("/apis/apiextensions.k8s.io/v1beta1/customresourcedefinitions/sparkclusters.radanalytics.io")
        .andReturn(200, customResourceDefinition).once();

    CustomResourceDefinition crd = client.apiextensions().v1beta1().customResourceDefinitions()
        .withName("sparkclusters.radanalytics.io").get();
    assertNotNull(crd);
    assertEquals("sparkclusters.radanalytics.io", crd.getMetadata().getName());
  }

  @Test
  void testCreate() {
    server.expect().post().withPath("/apis/apiextensions.k8s.io/v1beta1/customresourcedefinitions")
        .andReturn(200, customResourceDefinition).once();

    CustomResourceDefinition crd = client.apiextensions().v1beta1().customResourceDefinitions()
        .createOrReplace(customResourceDefinition);
    assertNotNull(crd);
    assertEquals("sparkclusters.radanalytics.io", crd.getMetadata().getName());
    // Assertion to test behavior in https://github.com/fabric8io/kubernetes-client/issues/1486
    assertFalse(Serialization.asYaml(crd.getSpec().getValidation()).contains("dependencies"));
  }

  @Test
  void testList() {
    server.expect().get().withPath("/apis/apiextensions.k8s.io/v1beta1/customresourcedefinitions")
        .andReturn(200, new KubernetesListBuilder().withItems(customResourceDefinition).build()).once();

    CustomResourceDefinitionList crdList = client.apiextensions().v1beta1().customResourceDefinitions().list();
    assertNotNull(crdList);
    assertEquals(1, crdList.getItems().size());
    assertEquals("sparkclusters.radanalytics.io", crdList.getItems().get(0).getMetadata().getName());
  }

  @Test
  void testDelete() {
    server.expect().delete()
        .withPath("/apis/apiextensions.k8s.io/v1beta1/customresourcedefinitions/sparkclusters.radanalytics.io")
        .andReturn(200, customResourceDefinition).once();

    boolean deleted = client.apiextensions().v1beta1().customResourceDefinitions().withName("sparkclusters.radanalytics.io")
        .delete().size() == 1;
    assertTrue(deleted);
  }

  JSONSchemaProps readSchema() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    final URL resource = getClass().getResource("/test-crd-validation-schema.json");

    final JSONSchemaProps jsonSchemaProps = mapper.readValue(resource, JSONSchemaProps.class);
    return jsonSchemaProps;
  }
}
