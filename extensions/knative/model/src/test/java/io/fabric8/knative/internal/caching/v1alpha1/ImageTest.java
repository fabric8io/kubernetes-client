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
package io.fabric8.knative.internal.caching.v1alpha1;

import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ImageTest {
  @Test
  void apiVersion() {
    assertThat(new Image().getApiVersion()).isEqualTo("caching.internal.knative.dev/v1alpha1");
  }

  @Test
  void isNamespaceScoped() {
    assertThat(new Image()).isInstanceOf(Namespaced.class);
  }

  @Test
  void builder() {
    // Given
    ImageBuilder imageBuilder = new ImageBuilder()
        .withNewMetadata()
        .withName("test-image")
        .endMetadata()
        .withNewSpec()
        .withImage("registry.example.com/test-public/knative-serving-queue:b082cf")
        .endSpec();

    // When
    Image image = imageBuilder.build();

    // Then
    assertThat(image)
        .hasFieldOrPropertyWithValue("metadata.name", "test-image")
        .hasFieldOrPropertyWithValue("spec.image", "registry.example.com/test-public/knative-serving-queue:b082cf");
  }
}
