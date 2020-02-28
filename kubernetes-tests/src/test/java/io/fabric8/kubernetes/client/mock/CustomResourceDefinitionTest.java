/**
 * Copyright (C) 2015 Fabric8 Authors.
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
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionList;
import io.fabric8.kubernetes.api.model.apiextensions.JSONSchemaProps;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.io.IOException;
import java.net.URL;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@EnableRuleMigrationSupport
public class CustomResourceDefinitionTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  private CustomResourceDefinition customResourceDefinition;

  @Before
  public void setupCrd() throws IOException {
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
  public void testLoad() {
    KubernetesClient client = server.getClient();
    CustomResourceDefinition customResourceDefinition = client.customResourceDefinitions().load(getClass().getResourceAsStream("/sparkapplication-crd.yml")).get();
    assertNotNull(customResourceDefinition);
    assertEquals("sparkapplications.sparkoperator.k8s.io", customResourceDefinition.getMetadata().getName());
  }

  @Test
  public void testGet() {
    server.expect().get().withPath("/apis/apiextensions.k8s.io/v1beta1/customresourcedefinitions/sparkclusters.radanalytics.io").andReturn(200, customResourceDefinition).once();
    KubernetesClient client = server.getClient();

    CustomResourceDefinition crd = client.customResourceDefinitions().withName("sparkclusters.radanalytics.io").get();
    assertNotNull(crd);
    assertEquals("sparkclusters.radanalytics.io", crd.getMetadata().getName());
  }

  @Test
  public void testCreate() {
    server.expect().post().withPath("/apis/apiextensions.k8s.io/v1beta1/customresourcedefinitions").andReturn(200, customResourceDefinition).once();
    KubernetesClient client = server.getClient();

    CustomResourceDefinition crd = client.customResourceDefinitions().createOrReplace(customResourceDefinition);
    assertNotNull(crd);
    assertEquals("sparkclusters.radanalytics.io", crd.getMetadata().getName());
    // Assertion to test behavior in https://github.com/fabric8io/kubernetes-client/issues/1486
    assertNull(crd.getSpec().getValidation().getOpenAPIV3Schema().getDependencies());
  }

  @Test
  public void testList() {
    server.expect().get().withPath("/apis/apiextensions.k8s.io/v1beta1/customresourcedefinitions").andReturn(200, new KubernetesListBuilder().withItems(customResourceDefinition).build()).once();
    KubernetesClient client = server.getClient();

    CustomResourceDefinitionList crdList = client.customResourceDefinitions().list();
    assertNotNull(crdList);
    assertEquals(1, crdList.getItems().size());
    assertEquals("sparkclusters.radanalytics.io", crdList.getItems().get(0).getMetadata().getName());
  }

  @Test
  public void testDelete() {
    server.expect().delete().withPath("/apis/apiextensions.k8s.io/v1beta1/customresourcedefinitions/sparkclusters.radanalytics.io").andReturn(200, customResourceDefinition).once();
    KubernetesClient client = server.getClient();

    Boolean deleted = client.customResourceDefinitions().withName("sparkclusters.radanalytics.io").delete();
    assertTrue(deleted);
  }

  public JSONSchemaProps readSchema() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    final URL resource = getClass().getResource("/test-crd-validation-schema.json");

    final JSONSchemaProps jsonSchemaProps = mapper.readValue(resource, JSONSchemaProps.class);
    return jsonSchemaProps;
  }
}
