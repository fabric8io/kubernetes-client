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
package io.fabric8.kubernetes.api.model.apiextensions.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.model.util.Helper;
import io.fabric8.zjsonpatch.JsonDiff;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomResourceDefinitionTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void testBuilder() {
    CustomResourceDefinition crd = new io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionBuilder()
        .withApiVersion("apiextensions.k8s.io/v1")
        .withNewMetadata()
        .withName("itests.examples.fabric8.io")
        .endMetadata()
        .withNewSpec()
        .withGroup("examples.fabric8.io")
        .addNewVersion()
        .withName("v1")
        .withServed(true)
        .withStorage(true)
        .endVersion()
        .withScope("Namespaced")
        .withNewNames()
        .withPlural("itests")
        .withSingular("itest")
        .withKind("Itest")
        .withShortNames("it")
        .endNames()
        .endSpec()
        .build();

    assertEquals("itests.examples.fabric8.io", crd.getMetadata().getName());
    assertEquals("examples.fabric8.io", crd.getSpec().getGroup());
    assertEquals("v1", crd.getSpec().getVersions().get(0).getName());
    assertEquals("Namespaced", crd.getSpec().getScope());
  }

  @Test
  void testLoadFromJsonSchemaPropsOrBool() throws JsonProcessingException {
    // Given
    final String originalJson = Helper.loadJson("/valid-v1-crd.json");
    final CustomResourceDefinition customResourceDefinition = mapper.readValue(originalJson,
        CustomResourceDefinition.class);
    // When
    final var diff = JsonDiff.asJson(mapper.readTree(originalJson),
        mapper.readTree(mapper.writeValueAsString(customResourceDefinition)));
    // Then
    assertThat(diff).isEmpty();
  }

  @Test
  void testLoadFromJsonSchemaPropsOrArray() throws JsonProcessingException {
    // Given
    final String originalJson = Helper.loadJson("/valid-crd-jsonschemapropsorarray.json");
    final CustomResourceDefinition result = mapper.readValue(originalJson, CustomResourceDefinition.class);
    // When
    final var diff = JsonDiff.asJson(mapper.readTree(originalJson), mapper.readTree(mapper.writeValueAsString(result)));
    // Then
    assertThat(diff).isEmpty();
  }

  @Test
  void testLoadFromJsonSchemaPropsOrStringArray() throws JsonProcessingException {
    // Given
    final String originalJson = Helper.loadJson("/valid-crd-jsonschemapropsorstringarray.json");
    final CustomResourceDefinition result = mapper.readValue(originalJson, CustomResourceDefinition.class);
    // When
    final var diff = JsonDiff.asJson(mapper.readTree(originalJson), mapper.readTree(mapper.writeValueAsString(result)));
    // Then
    assertThat(diff).isEmpty();
  }

  @Test
  void testLoadFromCrdWithValidationExpressionLanguage() throws JsonProcessingException {
    // Given
    final String originalJson = Helper.loadJson("/valid-v1-crd-validation-expression.json");
    final CustomResourceDefinition result = mapper.readValue(originalJson, CustomResourceDefinition.class);
    // When
    final var diff = JsonDiff.asJson(mapper.readTree(originalJson), mapper.readTree(mapper.writeValueAsString(result)));
    // Then
    assertThat(diff).isEmpty();
    assertThat(result)
        .extracting(CustomResourceDefinition::getSpec)
        .extracting(CustomResourceDefinitionSpec::getVersions)
        .asInstanceOf(InstanceOfAssertFactories.list(CustomResourceDefinitionVersion.class))
        .singleElement()
        .extracting(CustomResourceDefinitionVersion::getSchema)
        .extracting(CustomResourceValidation::getOpenAPIV3Schema)
        .extracting(JSONSchemaProps::getProperties, as(InstanceOfAssertFactories.type(Map.class)))
        .extracting("spec", as(InstanceOfAssertFactories.type(JSONSchemaProps.class)))
        .extracting(JSONSchemaProps::getXKubernetesValidations)
        .asList()
        .contains(
            new ValidationRuleBuilder()
                .withRule("self.minReplicas <= self.maxReplicas")
                .withMessage("minReplicas cannot be larger than maxReplicas")
                .build(),
            new ValidationRuleBuilder()
                .withRule("self.health.startsWith('ok')")
                .withMessage("Validate a 'health' string field has the prefix 'ok'")
                .build(),
            new ValidationRuleBuilder()
                .withRule("self.metadata.name.startsWith(self.prefix)")
                .withMessage("Validate that an object's name has the prefix of another field value")
                .build(),
            new ValidationRuleBuilder()
                .withRule("has(self.expired) && self.created + self.ttl < self.expired")
                .withMessage("Validate that 'expired' date is after a 'create' date plus a 'ttl' duration")
                .build());
  }
}
