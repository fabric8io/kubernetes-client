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

import io.fabric8.junit.jupiter.api.RequireK8sVersionAtLeast;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionList;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RequireK8sVersionAtLeast(majorVersion = 1, minorVersion = 16)
class CustomResourceDefinitionIT {

  KubernetesClient client;

  private String name;
  private String singular;
  private String plural;
  private String group;
  private CustomResourceDefinition crd;

  @BeforeEach
  public void setUp() {
    singular = "a" + UUID.randomUUID().toString().replace("-", "");
    plural = singular + "s";
    group = "examples.fabric8.io";
    name = plural + "." + group;
    crd = createCRD();
  }

  @AfterEach
  public void tearDown() {
    deleteCRD();
  }

  @Test
  void load() {
    // When
    final CustomResourceDefinition result = client.apiextensions().v1().customResourceDefinitions()
        .load(getClass().getResourceAsStream("/test-crd.yml")).item();
    // Then
    assertThat(result).isNotNull();
  }

  @Test
  void get() {
    // When
    final CustomResourceDefinition result = client.apiextensions().v1().customResourceDefinitions()
        .withName(name).get();
    // Then
    assertThat(result).isNotNull();
  }

  @Test
  void list() {
    // When
    final CustomResourceDefinitionList result = client.apiextensions().v1().customResourceDefinitions()
        .list();
    // Then
    assertThat(result.getItems())
        .hasSizeGreaterThan(0)
        .anyMatch(crd -> crd.getMetadata().getName().equals(name));
  }

  @Test
  void create() {
    // Then
    assertThat(crd)
        .hasFieldOrPropertyWithValue("metadata.name", name)
        .extracting("metadata.creationTimestamp")
        .isNotNull();
  }

  @Test
  void update() {
    // When
    final CustomResourceDefinition result = client.apiextensions().v1().customResourceDefinitions()
        .withName(name).edit(c -> new CustomResourceDefinitionBuilder(c)
            .editMetadata().withResourceVersion(null).endMetadata()
            .editSpec().editOrNewNames().addToShortNames("its").endNames().endSpec().build());
    // Then
    assertThat(result.getSpec().getNames().getShortNames())
        .containsExactlyInAnyOrder("its");
  }

  @Test
  void delete() {
    // When
    final boolean result = client.apiextensions().v1().customResourceDefinitions()
        .withName(name).delete().size() == 1;
    // Then
    assertThat(result).isTrue();
  }

  private CustomResourceDefinition createCRD() {
    return client.apiextensions().v1().customResourceDefinitions().create(new CustomResourceDefinitionBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withGroup(group)
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
        .withPlural(plural)
        .withSingular(singular)
        .withKind("Itest")
        .endNames()
        .endSpec()
        .build());
  }

  private void deleteCRD() {
    try {
      client.apiextensions().v1().customResourceDefinitions().delete(crd);
    } catch (Exception e) {
      // ignore
    }
  }
}
