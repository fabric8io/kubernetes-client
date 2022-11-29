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
package io.fabric8.kubernetes.client.dsl.base;

import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionNames;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionSpec;
import io.fabric8.kubernetes.client.Custom;
import io.fabric8.kubernetes.client.Good;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomResourceDefinitionContextTest {

  @Test
  @DisplayName("v1beta1CRDFromCustomResourceType correctly generates CRD builder for v1beta1 version")
  void v1beta1CRDFromCustomResourceType() {
    final CustomResourceDefinition crd = CustomResourceDefinitionContext.v1beta1CRDFromCustomResourceType(Good.class).build();
    final CustomResourceDefinitionSpec spec = crd.getSpec();
    final CustomResourceDefinitionNames names = spec.getNames();
    final String plural = "goods";
    Assertions.assertEquals(plural, names.getPlural());
    Assertions.assertEquals("good", names.getSingular());
    Assertions.assertEquals("Good", names.getKind());
    Assertions.assertEquals(plural + "." + Good.GROUP, crd.getMetadata().getName());
    Assertions.assertEquals(Good.VERSION, spec.getVersion());
    Assertions.assertEquals(Good.VERSION, spec.getVersions().get(0).getName());
  }

  @Test
  @DisplayName("v1CRDFromCustomResourceType correctly generates CRD builder for v1 version")
  void v1CRDFromCustomResourceType() {
    final io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition crd = CustomResourceDefinitionContext
        .v1CRDFromCustomResourceType(Custom.class).build();
    final io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpec spec = crd.getSpec();
    final io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionNames names = spec.getNames();
    Assertions.assertEquals(Custom.PLURAL, names.getPlural());
    Assertions.assertEquals(Custom.SINGULAR, names.getSingular());
    Assertions.assertEquals(Custom.KIND, names.getKind());
    Assertions.assertEquals(Custom.PLURAL + "." + Good.GROUP, crd.getMetadata().getName());
    Assertions.assertEquals(Good.VERSION, spec.getVersions().get(0).getName());
  }

  @Test
  @DisplayName("fromCrd, with v1 CRD, should infer correct properties")
  void fromCrdV1() {
    // Given
    final io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition crd = new io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionBuilder()
        .withNewMetadata().withName("foobar.the-foo.com").endMetadata()
        .withNewSpec()
        .withGroup("the-foo.com")
        .withScope("Namespaced")
        .withNewNames().withSingular("foobar").withPlural("foobars").withKind("Foobar").endNames()
        .addNewVersion().withName("v1beta1").endVersion()
        .addNewVersion().withName("v1alpha1").endVersion()
        .addNewVersion().withName("v1").endVersion()
        .endSpec()
        .build();
    // When
    final CustomResourceDefinitionContext result = CustomResourceDefinitionContext.fromCrd(crd);
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("group", "the-foo.com")
        .hasFieldOrPropertyWithValue("version", "v1")
        .hasFieldOrPropertyWithValue("scope", "Namespaced")
        .hasFieldOrPropertyWithValue("name", "foobar.the-foo.com")
        .hasFieldOrPropertyWithValue("plural", "foobars")
        .hasFieldOrPropertyWithValue("kind", "Foobar");
  }

  @Test
  @DisplayName("fromCrd, with v1beta1 CRD with versions, should infer correct properties")
  void fromCrdV1beta1() {
    // Given
    final io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition crd = new io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionBuilder()
        .withNewMetadata().withName("foobar.the-foo.com").endMetadata()
        .withNewSpec()
        .withGroup("the-foo.com")
        .withScope("Namespaced")
        .withNewNames().withSingular("foobar").withPlural("foobars").withKind("Foobar").endNames()
        .addNewVersion().withName("v1beta1").endVersion()
        .addNewVersion().withName("v1alpha1").endVersion()
        .addNewVersion().withName("v1").endVersion()
        .endSpec()
        .build();
    // When
    final CustomResourceDefinitionContext result = CustomResourceDefinitionContext.fromCrd(crd);
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("group", "the-foo.com")
        .hasFieldOrPropertyWithValue("version", "v1")
        .hasFieldOrPropertyWithValue("scope", "Namespaced")
        .hasFieldOrPropertyWithValue("name", "foobar.the-foo.com")
        .hasFieldOrPropertyWithValue("plural", "foobars")
        .hasFieldOrPropertyWithValue("kind", "Foobar");
  }

  @Test
  @DisplayName("fromCrd, with v1beta1 CRD with spec.version, should infer correct properties")
  void fromCrdV1beta1OldVersionStyle() {
    // Given
    final io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition crd = new io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionBuilder()
        .withNewMetadata().withName("foobar.the-foo.com").endMetadata()
        .withNewSpec()
        .withGroup("the-foo.com")
        .withScope("Namespaced")
        .withNewNames().withSingular("foobar").withPlural("foobars").withKind("Foobar").endNames()
        .withVersion("v1")
        .endSpec()
        .build();
    // When
    final CustomResourceDefinitionContext result = CustomResourceDefinitionContext.fromCrd(crd);
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("group", "the-foo.com")
        .hasFieldOrPropertyWithValue("version", "v1")
        .hasFieldOrPropertyWithValue("scope", "Namespaced")
        .hasFieldOrPropertyWithValue("name", "foobar.the-foo.com")
        .hasFieldOrPropertyWithValue("plural", "foobars")
        .hasFieldOrPropertyWithValue("kind", "Foobar");
  }

  @Test
  void isNamespaceScoped() {
    // Given
    CustomResourceDefinitionContext crdc1 = new CustomResourceDefinitionContext.Builder().withPlural("values")
        .withScope("Namespaced").build();
    CustomResourceDefinitionContext crdc2 = new CustomResourceDefinitionContext.Builder().withPlural("values")
        .withScope("Cluster").build();

    // When + Then
    assertThat(crdc1.isNamespaceScoped()).isTrue();
    assertThat(crdc2.isNamespaceScoped()).isFalse();
  }
}
