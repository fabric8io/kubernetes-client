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
package io.fabric8.kubernetes.api.model.flowcontrol.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class FlowSchemaTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScoped() {
    assertThat(FlowSchema.class.getInterfaces()).doesNotContain(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws JsonProcessingException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-v1-flowschema.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final FlowSchema flowSchema = mapper.readValue(originalJson, FlowSchema.class);
    final String serializedJson = mapper.writeValueAsString(flowSchema);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(flowSchema)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-flowschema")
        .hasFieldOrPropertyWithValue("spec.priorityLevelConfiguration.name", "nameValue")
        .hasFieldOrPropertyWithValue("spec.matchingPrecedence", 2)
        .hasFieldOrPropertyWithValue("spec.distinguisherMethod.type", "typeValue")
        .extracting(FlowSchema::getSpec)
        .extracting(FlowSchemaSpec::getRules)
        .asInstanceOf(InstanceOfAssertFactories.LIST)
        .element(0)
        .hasFieldOrPropertyWithValue("subjects", Collections.singletonList(new SubjectBuilder()
            .withKind("kindValue")
            .withNewUser().withName("nameValue").endUser()
            .withNewGroup().withName("nameValue").endGroup()
            .withNewServiceAccount()
            .withName("nameValue")
            .withNamespace("namespaceValue")
            .endServiceAccount()
            .build()))
        .hasFieldOrPropertyWithValue("resourceRules", Collections.singletonList(new ResourcePolicyRuleBuilder()
            .withVerbs("verbsValue")
            .withApiGroups("apiGroupsValue")
            .withResources("resourcesValue")
            .withClusterScope(true)
            .withNamespaces("namespacesValue")
            .build()))
        .hasFieldOrPropertyWithValue("nonResourceRules", Collections.singletonList(new NonResourcePolicyRuleBuilder()
            .withVerbs("verbsValue")
            .withNonResourceURLs("nonResourceURLsValue")
            .build()));
  }

  @Test
  void builderShouldCreateObjects() {
    // Given
    FlowSchemaBuilder flowSchemaBuilder = new FlowSchemaBuilder()
        .withNewMetadata()
        .withName("test-flowschema")
        .endMetadata()
        .withNewSpec()
        .withNewPriorityLevelConfiguration()
        .withName("nameValue")
        .endPriorityLevelConfiguration()
        .withMatchingPrecedence(2)
        .withNewDistinguisherMethod("typeValue")
        .addNewRule()
        .addNewSubject()
        .withKind("kindValue")
        .withNewUser().withName("nameValue").endUser()
        .withNewGroup().withName("nameValue").endGroup()
        .withNewServiceAccount()
        .withName("nameValue")
        .withNamespace("namespaceValue")
        .endServiceAccount()
        .endSubject()
        .addNewResourceRule()
        .withVerbs("verbsValue")
        .withApiGroups("apiGroupsValue")
        .withResources("resourcesValue")
        .withClusterScope(true)
        .withNamespaces("namespacesValue")
        .endResourceRule()
        .addNewNonResourceRule()
        .withVerbs("verbsValue")
        .withNonResourceURLs("nonResourceURLsValue")
        .endNonResourceRule()
        .endRule()
        .endSpec();
    // When
    FlowSchema flowSchema = flowSchemaBuilder.build();

    // Then
    assertThat(flowSchema)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-flowschema")
        .hasFieldOrPropertyWithValue("spec.priorityLevelConfiguration.name", "nameValue")
        .hasFieldOrPropertyWithValue("spec.matchingPrecedence", 2)
        .hasFieldOrPropertyWithValue("spec.distinguisherMethod.type", "typeValue")
        .extracting(FlowSchema::getSpec)
        .extracting(FlowSchemaSpec::getRules)
        .asInstanceOf(InstanceOfAssertFactories.LIST)
        .element(0)
        .hasFieldOrPropertyWithValue("subjects", Collections.singletonList(new SubjectBuilder()
            .withKind("kindValue")
            .withNewUser().withName("nameValue").endUser()
            .withNewGroup().withName("nameValue").endGroup()
            .withNewServiceAccount()
            .withName("nameValue")
            .withNamespace("namespaceValue")
            .endServiceAccount()
            .build()))
        .hasFieldOrPropertyWithValue("resourceRules", Collections.singletonList(new ResourcePolicyRuleBuilder()
            .withVerbs("verbsValue")
            .withApiGroups("apiGroupsValue")
            .withResources("resourcesValue")
            .withClusterScope(true)
            .withNamespaces("namespacesValue")
            .build()))
        .hasFieldOrPropertyWithValue("nonResourceRules", Collections.singletonList(new NonResourcePolicyRuleBuilder()
            .withVerbs("verbsValue")
            .withNonResourceURLs("nonResourceURLsValue")
            .build()));
  }
}
