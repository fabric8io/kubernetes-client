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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersionBuilder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class KubernetesVersionPriorityTest {

  @Test
  void should_version_with_highest_priority() {
    // given
    String highest = "v10";
    List<String> versions = Arrays.asList(
        "foo10",
        "v11alpha2",
        "foo1",
        "v3beta1",
        "v2",
        "v10beta3",
        highest,
        "v11beta2",
        "v1",
        "v12alpha1");
    // when
    String computed = KubernetesVersionPriority.highestPriority(versions);
    // then
    assertThat(computed).isEqualTo(highest);
  }

  @Test
  void should_sort_with_highest_priority() {
    // given
    CustomResourceDefinitionVersion foo10 = createCustomResourceDefinitionVersion("foo10");
    CustomResourceDefinitionVersion v11alpha2 = createCustomResourceDefinitionVersion("v11alpha2");
    CustomResourceDefinitionVersion foo1 = createCustomResourceDefinitionVersion("foo1");
    CustomResourceDefinitionVersion v3beta1 = createCustomResourceDefinitionVersion("v3beta1");
    CustomResourceDefinitionVersion v2 = createCustomResourceDefinitionVersion("v2");
    CustomResourceDefinitionVersion v10beta3 = createCustomResourceDefinitionVersion("v10beta3");
    CustomResourceDefinitionVersion v10 = createCustomResourceDefinitionVersion("v10");
    CustomResourceDefinitionVersion v11beta2 = createCustomResourceDefinitionVersion("v11beta2");
    CustomResourceDefinitionVersion v1 = createCustomResourceDefinitionVersion("v1");
    CustomResourceDefinitionVersion v12alpha1 = createCustomResourceDefinitionVersion("v12alpha1");

    List<CustomResourceDefinitionVersion> versions = Arrays.asList(
        foo10,
        v11alpha2,
        foo1,
        v3beta1,
        v2,
        v10beta3,
        v10,
        v11beta2,
        v1,
        v12alpha1);
    // when
    List<CustomResourceDefinitionVersion> computed = KubernetesVersionPriority
        .sortByPriority(versions, CustomResourceDefinitionVersion::getName);
    // then
    List<CustomResourceDefinitionVersion> expected = Arrays.asList(
        v10,
        v2,
        v1,
        v11beta2,
        v10beta3,
        v3beta1,
        v12alpha1,
        v11alpha2,
        foo1,
        foo10);
    // ensure same size and ordering
    assertThat(computed).isEqualTo(expected);
    // ensure that the implementation works only on references
    assertThat(computed.get(0)).isSameAs(v10);
  }

  private static CustomResourceDefinitionVersion createCustomResourceDefinitionVersion(String name) {
    return new CustomResourceDefinitionVersionBuilder()
        .withName(name)
        .build();
  }
}
