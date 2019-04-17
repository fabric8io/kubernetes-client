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

import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionList;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionVersionBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class CustomResourceDefinitionIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private CustomResourceDefinition crd1;

  @Before
  public void init() {
    crd1 = new CustomResourceDefinitionBuilder()
      .withApiVersion("apiextensions.k8s.io/v1beta1")
      .withNewMetadata()
      .withName("itests.examples.fabric8.io")
      .endMetadata()
      .withNewSpec()
      .withGroup("examples.fabric8.io")
      .withVersion("v1")
      .addAllToVersions(Collections.singletonList(new CustomResourceDefinitionVersionBuilder()
        .withName("v1")
        .withServed(true)
        .withStorage(true)
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

    client.customResourceDefinitions().create(crd1);
  }

  @Test
  public void testCrdOperations() {
    // Load
    CustomResourceDefinition aCustomResourceDefinition = client.customResourceDefinitions().load(getClass().getResourceAsStream("/test-crd.yml")).get();
    assertThat(aCustomResourceDefinition).isNotNull();

    // Get
    crd1 = client.customResourceDefinitions().withName(crd1.getMetadata().getName()).get();
    assertThat(crd1).isNotNull();

    // List
    CustomResourceDefinitionList crdList = client.customResourceDefinitions().list();
    assertThat(crdList).isNotNull();
    assertThat(crdList.getItems().size()).isGreaterThan(0);

    // Update
    CustomResourceDefinition updatedCrd = client.customResourceDefinitions().withName(crd1.getMetadata().getName()).edit().editSpec().editOrNewNames().addNewShortName("its").endNames().endSpec().done();
    assertThat(updatedCrd.getSpec().getNames().getShortNames().size()).isEqualTo(2);

    // Delete
    boolean bDeleted = client.customResourceDefinitions().withName(crd1.getMetadata().getName()).delete();
    assertThat(bDeleted).isTrue();
  }
}
