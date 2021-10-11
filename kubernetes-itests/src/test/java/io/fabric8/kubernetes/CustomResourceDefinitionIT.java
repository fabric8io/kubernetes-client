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
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionList;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class CustomResourceDefinitionIT {
  @ArquillianResource
  KubernetesClient client;

  @ClassRule
  public static final AssumingK8sVersionAtLeast assumingK8sVersion =
    new AssumingK8sVersionAtLeast("1", "16");

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

  @Test
  public void testCrdOperations() {
    // Load
    CustomResourceDefinition crd1 = client.apiextensions().v1().customResourceDefinitions().load(getClass().getResourceAsStream("/test-crd.yml")).get();
    assertThat(crd1).isNotNull();

    // Create
    crd1 = client.apiextensions().v1().customResourceDefinitions().create(createCRD());
    assertNotNull(crd1);

    // Get
    crd1 = client.apiextensions().v1().customResourceDefinitions().withName(crd1.getMetadata().getName()).get();
    assertThat(crd1).isNotNull();

    // List
    CustomResourceDefinitionList crdList = client.apiextensions().v1().customResourceDefinitions().list();
    assertThat(crdList).isNotNull();
    assertThat(crdList.getItems().size()).isPositive();

    // Update
    CustomResourceDefinition updatedCrd = client.apiextensions().v1().customResourceDefinitions().withName(crd1.getMetadata().getName()).edit(c -> new CustomResourceDefinitionBuilder(c).editSpec().editOrNewNames().addNewShortName("its").endNames().endSpec().build());
    assertThat(updatedCrd.getSpec().getNames().getShortNames().size()).isEqualTo(2);

    // Delete
    boolean bDeleted = client.apiextensions().v1().customResourceDefinitions().withName(crd1.getMetadata().getName()).delete();
    assertThat(bDeleted).isTrue();
  }

}
