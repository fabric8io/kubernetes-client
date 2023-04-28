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

import io.fabric8.kubernetes.api.model.HasMetadata;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.exceptions.ConstructorException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

// https://github.com/fabric8io/kubernetes-client/issues/3653
class SerializationYamlTest {

  @Test
  @DisplayName("unmarshal, evaluates non standard Java classes (needs fix)")
  @Disabled("This test should only pass in case SnakeYAML is set to evaluate non standard Java classes (which implies a security threat)")
  void unmarshalEvaluatesNonStandardClasses() {
    // Given
    final String genericResourceYaml = "kind: MyCustomResource\n" +
        "apiVersion: my.custom.resource.example.com/v1\n" +
        "spec:\n" +
        "  complex: !!io.fabric8.kubernetes.client.utils.SerializationYamlTest$NonStandardJavaClass [ evil ]";
    // When
    final HasMetadata resource = Serialization.unmarshal(genericResourceYaml);
    // Then
    assertThat(resource)
        .hasFieldOrPropertyWithValue("additionalProperties.spec.complex.field", "evil");
  }

  @Test
  @DisplayName("unmarshal, SHOULD NOT evaluate non standard Java classes")
  void unmarshalShouldNotEvaluateNonStandardClasses() {
    // Given
    final String genericResourceYaml = "kind: MyCustomResource\n" +
        "apiVersion: my.custom.resource.example.com/v1\n" +
        "spec:\n" +
        "  complex: !!io.fabric8.kubernetes.client.utils.SerializationYamlTest$NonStandardJavaClass [ evil ]";
    // When
    final Exception result = assertThrows(ConstructorException.class, () -> Serialization.unmarshal(genericResourceYaml));
    // Then
    assertThat(result).hasMessageStartingWith("could not determine a constructor for the tag " +
        "tag:yaml.org,2002:io.fabric8.kubernetes.client.utils.SerializationYamlTest$NonStandardJavaClass");
  }

  static final class NonStandardJavaClass {
    public String field;

    NonStandardJavaClass() {

    }

    NonStandardJavaClass(String field) {
      this.field = field;
    }
  }

}
