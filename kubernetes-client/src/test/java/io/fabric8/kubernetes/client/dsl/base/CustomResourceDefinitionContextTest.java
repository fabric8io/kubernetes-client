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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomResourceDefinitionContextTest {

  @Test
  @DisplayName("formCrd, with v1 CRD, should infer correct properties")
  void fromCrdV1() {
    // Given
    final io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition crd =
      new io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionBuilder()
        .withNewMetadata().withName("foobar.the-foo.com").endMetadata()
        .withNewSpec()
        .withGroup("the-foo.com")
        .withScope("Namespaced")
        .withNewNames().withNewSingular("foobar").withNewPlural("foobars").withKind("Foobar").endNames()
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
  @DisplayName("formCrd, with v1beta1 CRD with versions, should infer correct properties")
  void fromCrdV1beta1() {
    // Given
    final io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition crd =
      new io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionBuilder()
        .withNewMetadata().withName("foobar.the-foo.com").endMetadata()
        .withNewSpec()
        .withGroup("the-foo.com")
        .withScope("Namespaced")
        .withNewNames().withNewSingular("foobar").withNewPlural("foobars").withKind("Foobar").endNames()
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
  @DisplayName("formCrd, with v1beta1 CRD with spec.version, should infer correct properties")
  void fromCrdV1beta1OldVersionStyle() {
    // Given
    final io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition crd =
      new io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionBuilder()
        .withNewMetadata().withName("foobar.the-foo.com").endMetadata()
        .withNewSpec()
        .withGroup("the-foo.com")
        .withScope("Namespaced")
        .withNewNames().withNewSingular("foobar").withNewPlural("foobars").withKind("Foobar").endNames()
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
}
