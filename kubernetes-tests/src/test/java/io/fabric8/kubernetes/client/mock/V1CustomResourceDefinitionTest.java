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
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionList;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@EnableRuleMigrationSupport
public class V1CustomResourceDefinitionTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  private CustomResourceDefinition customResourceDefinition;

  @BeforeEach
  void setupCrd() throws IOException {
    customResourceDefinition = new CustomResourceDefinitionBuilder()
      .withNewMetadata()
      .withName("sparkclusters.radanalytics.io")
      .endMetadata()
      .withNewSpec()
      .withGroup("radanalytics.io")
      .addNewVersion()
      .withName("v1")
      .withServed(true)
      .withStorage(true)
      .withNewSchema()
      .withNewOpenAPIV3SchemaLike(readSchema())
      .endOpenAPIV3Schema()
      .endSchema()
      .endVersion()
      .withScope("Namespaced")
      .withNewNames()
      .withPlural("sparkclusters")
      .withSingular("sparkcluster")
      .withKind("SparkCluster")
      .addNewShortName("sc")
      .endNames()
      .endSpec()
      .build();
  }

  @Test
  void testLoad() {
    KubernetesClient client = server.getClient();
    List<HasMetadata> crdList = client.load(getClass().getResourceAsStream("/crd-v1-list.yml")).get();
    assertNotNull(crdList);
    assertEquals(1, crdList.size());
  }

  @Test
  void testGet() {
    server.expect().get().withPath("/apis/apiextensions.k8s.io/v1/customresourcedefinitions/sparkclusters.radanalytics.io").andReturn(HttpURLConnection.HTTP_OK, customResourceDefinition).once();
    KubernetesClient client = server.getClient();

    CustomResourceDefinition crd = client.apiextensions().v1().customResourceDefinitions().withName("sparkclusters.radanalytics.io").get();
    assertNotNull(crd);
    assertEquals("sparkclusters.radanalytics.io", crd.getMetadata().getName());
  }

  @Test
  void testCreate() {
    server.expect().post().withPath("/apis/apiextensions.k8s.io/v1/customresourcedefinitions").andReturn(HttpURLConnection.HTTP_OK, customResourceDefinition).once();
    KubernetesClient client = server.getClient();

    CustomResourceDefinition crd = client.apiextensions().v1().customResourceDefinitions().createOrReplace(customResourceDefinition);
    assertNotNull(crd);
    assertEquals("sparkclusters.radanalytics.io", crd.getMetadata().getName());
    // Assertion to test behavior in https://github.com/fabric8io/kubernetes-client/issues/1486
    assertNull(crd.getSpec().getVersions().get(0).getSchema().getOpenAPIV3Schema().getDependencies());
  }

  @Test
  void testList() {
    server.expect().get().withPath("/apis/apiextensions.k8s.io/v1/customresourcedefinitions").andReturn(HttpURLConnection.HTTP_OK, new KubernetesListBuilder().withItems(customResourceDefinition).build()).once();
    KubernetesClient client = server.getClient();

    CustomResourceDefinitionList crdList = client.apiextensions().v1().customResourceDefinitions().list();
    assertNotNull(crdList);
    assertEquals(1, crdList.getItems().size());
    assertEquals("sparkclusters.radanalytics.io", crdList.getItems().get(0).getMetadata().getName());
  }

  @Test
  void testDelete() {
    server.expect().delete().withPath("/apis/apiextensions.k8s.io/v1/customresourcedefinitions/sparkclusters.radanalytics.io").andReturn(HttpURLConnection.HTTP_OK, customResourceDefinition).once();
    KubernetesClient client = server.getClient();

    Boolean deleted = client.apiextensions().v1().customResourceDefinitions().withName("sparkclusters.radanalytics.io").delete();
    assertTrue(deleted);
  }

  @Test
  void testCustomResourceDefinitionTest() {
    // Given
    KubernetesClient client = server.getClient();

    // When
    List<HasMetadata> items = client.load(getClass().getResourceAsStream("/test-crd-no-apiversion.yml")).get();

    // Then
    Assertions.assertNotNull(items);
    Assertions.assertEquals(1, items.size());
    Assertions.assertTrue(items.get(0) instanceof CustomResourceDefinition);
  }

  JSONSchemaProps readSchema() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    final URL resource = getClass().getResource("/test-crd-validation-schema.json");

    return mapper.readValue(resource, JSONSchemaProps.class);
  }
}
