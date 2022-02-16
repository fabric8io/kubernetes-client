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

package io.fabric8.kubernetes;

import io.fabric8.commons.AssumingK8sVersionAtLeast;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NamespaceableResource;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.clnt.v4_0.utils.Serialization;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.awaitility.Awaitility;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class GenericResourceIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @ClassRule
  public static final AssumingK8sVersionAtLeast assumingK8sVersion =
    new AssumingK8sVersionAtLeast("1", "16");

  @Test
  public void testGenericBuiltinResourceWithoutMetadata() {
    GenericKubernetesResource configMap = new GenericKubernetesResource();
    configMap.setKind("ConfigMap");
    configMap.setApiVersion("v1");
    configMap.setMetadata(new ObjectMetaBuilder().withName("my-map").build());
    NamespaceableResource<GenericKubernetesResource> resource = client.resource(configMap);
    GenericKubernetesResource result = resource.createOrReplace();
    assertNotNull(result);

    MixedOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> resources =
        client.genericKubernetesResources("v1", "ConfigMap");
    assertTrue(!resources.list().getItems().isEmpty());
  }

  @Test
  public void testGenericCustomResourceWithoutMetadata() {
    CustomResourceDefinition crd1 = client.apiextensions().v1().customResourceDefinitions().createOrReplace(createCRD());

    assertThat(crd1).isNotNull();

    Awaitility.await().atMost(1, TimeUnit.MINUTES).until(() -> client.getApiResources("examples.fabric8.io/v1") != null);

    GenericKubernetesResource itest = new GenericKubernetesResource();
    itest.setKind("Itest");
    itest.setApiVersion("examples.fabric8.io/v1");
    itest.setMetadata(new ObjectMetaBuilder().withName("my-itest").build());

    NamespaceableResource<GenericKubernetesResource> resource = client.resource(itest);

    GenericKubernetesResource result = resource.createOrReplace();
    assertNotNull(result);

    // ensure the namespace can be manipulated
    client.namespaces().create(new NamespaceBuilder().withNewMetadata().withName("x").endMetadata().build());
    result = resource.inNamespace("x").createOrReplace();
    assertEquals("x", result.getMetadata().getNamespace());

    // ensure it can be loaded as a list
    List<HasMetadata> created = client.load(new ByteArrayInputStream(Serialization.asYaml(itest).getBytes(StandardCharsets.UTF_8))).createOrReplace();
    assertEquals(1, created.size());
  }

  public static CustomResourceDefinition createCRD() {
    return new CustomResourceDefinitionBuilder()
      .withApiVersion("apiextensions.k8s.io/v1")
      .withNewMetadata()
      .withName("itests.examples.fabric8.io")
      .endMetadata()
      .withNewSpec()
      .withGroup("examples.fabric8.io")
      .addAllToVersions(Collections.singletonList(new CustomResourceDefinitionVersionBuilder()
        .withName("v1")
        .withServed(true)
        .withStorage(true)
        .withNewSchema()
        .withNewOpenAPIV3Schema()
        .withType("object")
        .addToProperties("spec", new JSONSchemaPropsBuilder()
          .withType("object")
          .addToProperties("field", new JSONSchemaPropsBuilder()
            .withType("string")
            .build())
          .build())
        .endOpenAPIV3Schema()
        .endSchema()
        .build()))
      .withScope("Namespaced")
      .withNewNames()
      .withPlural("itests")
      .withSingular("itest")
      .withKind("Itest")
      .withShortNames("it")
      .endNames()
      .endSpec()
      .build();
  }
}
