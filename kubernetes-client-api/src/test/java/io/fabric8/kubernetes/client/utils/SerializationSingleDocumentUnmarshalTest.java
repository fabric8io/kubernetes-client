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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.Service;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class SerializationSingleDocumentUnmarshalTest {
  @ParameterizedTest(name = "#{index} - unmarshal {0}")
  @ValueSource(strings = {
      "document-with-trailing-document-delimiter.yml",
      "document-with-leading-document-delimiter.yml",
      "document-with-leading-and-trailing-document-delimiter.yml",
      "document-with-no-document-delimiter.yml"
  })
  void unmarshalWithSingleDocumentWithDocumentDelimiterShouldReturnKubernetesResource(String arg) {
    // When
    final KubernetesResource result = Serialization.unmarshal(
        SerializationTest.class.getResourceAsStream(String.format("/serialization/%s", arg)));
    // Then
    assertThat(result)
        .asInstanceOf(InstanceOfAssertFactories.type(Service.class))
        .hasFieldOrPropertyWithValue("apiVersion", "v1")
        .hasFieldOrPropertyWithValue("kind", "Service")
        .hasFieldOrPropertyWithValue("metadata.name", "redis-master")
        .hasFieldOrPropertyWithValue("metadata.labels.app", "redis")
        .hasFieldOrPropertyWithValue("metadata.labels.tier", "backend")
        .hasFieldOrPropertyWithValue("metadata.labels.role", "master")
        .hasFieldOrPropertyWithValue("spec.selector.app", "redis")
        .hasFieldOrPropertyWithValue("spec.selector.tier", "backend")
        .hasFieldOrPropertyWithValue("spec.selector.role", "master");
  }
}
