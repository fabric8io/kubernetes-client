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
package io.fabric8.kubernetes.schema.validator;

import com.fasterxml.jackson.databind.JsonNode;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

  private static Validator validator;

  @BeforeAll
  static void setUpAll() {
    validator = Validator.newInstance();
  }

  @Test
  @DisplayName("With null String, has no validation errors")
  void withNullString() throws IOException {
    assertThat(validator.validate((String) null)).returns(false, ValidationReport::hasErrors);
  }

  @Test
  @DisplayName("With null InputStream, has no validation errors")
  void withNullStream() throws IOException {
    assertThat(validator.validate((InputStream) null)).returns(false, ValidationReport::hasErrors);
  }

  @Test
  @DisplayName("With null JsonNode, has no validation errors")
  void withNullNode() {
    assertThat(validator.validate((JsonNode) null)).returns(false, ValidationReport::hasErrors);
  }

  @Test
  @DisplayName("With empty String, has missing kind error")
  void withEmptyString() throws IOException {
    assertThat(validator.validate(""))
        .returns(true, ValidationReport::hasErrors)
        .extracting(ValidationReport::getMessages)
        .asInstanceOf(InstanceOfAssertFactories.iterable(ValidationMessage.class))
        .extracting(ValidationMessage::getMessage)
        .containsExactly("[Path '/'] Object has missing required properties ([\"kind\"])");
  }

  @Test
  @DisplayName("With no kind, has missing kind error")
  void withNoKind() throws IOException {
    assertThat(validator.validate("{\"apiVersion\":\"v1\"}"))
        .returns(true, ValidationReport::hasErrors)
        .extracting(ValidationReport::getMessages)
        .asInstanceOf(InstanceOfAssertFactories.iterable(ValidationMessage.class))
        .extracting(ValidationMessage::getMessage)
        .containsExactly("[Path '/'] Object has missing required properties ([\"kind\"])");
  }

  @Test
  @DisplayName("With kind and no apiVersion, has missing apiVersion error")
  void withNoApiVersion() throws IOException {
    assertThat(validator.validate("{\"kind\":\"Pod\"}"))
        .returns(true, ValidationReport::hasErrors)
        .extracting(ValidationReport::getMessages)
        .asInstanceOf(InstanceOfAssertFactories.iterable(ValidationMessage.class))
        .extracting(ValidationMessage::getMessage)
        .containsExactly("[Path '/'] Object has missing or invalid required properties ([\"apiVersion\"])");
  }

  @Test
  @DisplayName("With kind and no apiVersion, has missing apiVersion error")
  void withBlankApiVersion() throws IOException {
    assertThat(validator.validate("{\"kind\":\"Pod\",\"apiVersion\":\"\"}"))
        .returns(true, ValidationReport::hasErrors)
        .extracting(ValidationReport::getMessages)
        .asInstanceOf(InstanceOfAssertFactories.iterable(ValidationMessage.class))
        .extracting(ValidationMessage::getMessage)
        .containsExactly("[Path '/'] Object has missing or invalid required properties ([\"apiVersion\"])");
  }

  @Test
  @DisplayName("With kind and apiVersion=v2, has missing apiVersion error")
  void withV2ApiVersion() throws IOException {
    assertThat(validator.validate("{\"kind\":\"Pod\",\"apiVersion\":\"v2\"}"))
        .returns(true, ValidationReport::hasErrors)
        .extracting(ValidationReport::getMessages)
        .asInstanceOf(InstanceOfAssertFactories.iterable(ValidationMessage.class))
        .extracting(ValidationMessage::getMessage)
        .containsExactly("[Path '/'] Object has missing or invalid required properties ([\"apiVersion\"])");
  }

  @Test
  @DisplayName("With kind and invalid apiVersion, has missing apiVersion error")
  void withInvalidApiVersion() throws IOException {
    assertThat(validator.validate("{\"kind\":\"Pod\",\"apiVersion\":\"not/valid/version\"}"))
        .returns(true, ValidationReport::hasErrors)
        .extracting(ValidationReport::getMessages)
        .asInstanceOf(InstanceOfAssertFactories.iterable(ValidationMessage.class))
        .extracting(ValidationMessage::getMessage)
        .containsExactly("[Path '/'] Object has missing or invalid required properties ([\"apiVersion\"])");
  }

  @Test
  @DisplayName("With valid pod, has no validation errors")
  void withValidPod() throws IOException {
    assertThat(validator.validate(ValidatorTest.class.getResourceAsStream("/valid-pod.yml")))
        .returns(false, ValidationReport::hasErrors);
  }

  @Test
  @DisplayName("With invalid pod, has validation errors")
  void withInvalidPod() throws IOException {
    assertThat(validator.validate(ValidatorTest.class.getResourceAsStream("/invalid-pod.yml")))
        .returns(true, ValidationReport::hasErrors)
        .extracting(ValidationReport::getMessages)
        .asInstanceOf(InstanceOfAssertFactories.iterable(ValidationMessage.class))
        .extracting(ValidationMessage::getMessage)
        .contains("[Path '/spec'] Object has missing required properties ([\"containers\"])")
        .contains("[Path '/spec'] Object instance has properties which are not allowed by the schema: [\"containerrs\"]");
  }

  @Test
  @DisplayName("With valid deployment, has no validation errors")
  void withValidDeployment() throws IOException {
    assertThat(validator.validate(ValidatorTest.class.getResourceAsStream("/valid-deployment.yml")))
        .returns(false, ValidationReport::hasErrors);
  }

  @Test
  @DisplayName("With invalid deployment, has validation errors")
  void withInvalidDeployment() throws IOException {
    assertThat(validator.validate(ValidatorTest.class.getResourceAsStream("/invalid-deployment.yml")))
        .returns(true, ValidationReport::hasErrors)
        .extracting(ValidationReport::getMessages)
        .asInstanceOf(InstanceOfAssertFactories.iterable(ValidationMessage.class))
        .extracting(ValidationMessage::getMessage)
        .contains("[Path '/spec'] Object instance has properties which are not allowed by the schema: [\"templates\"]")
        .contains("[Path '/spec'] Object has missing required properties ([\"template\"])")
        .contains(
            "[Path '/spec/replicas'] Instance type (string) does not match any allowed primitive type (allowed: [\"integer\"])");
  }

  @Test
  @DisplayName("With valid DeploymentConfig, has no validation errors")
  void withValidDeploymentConfig() throws IOException {
    assertThat(validator.validate(ValidatorTest.class.getResourceAsStream("/valid-deployment-config.yml")))
        .returns(false, ValidationReport::hasErrors);
  }

  @Test
  @DisplayName("With invalid DeploymentConfig, has validation errors")
  void withInvalidDeploymentConfig() throws IOException {
    assertThat(validator.validate(ValidatorTest.class.getResourceAsStream("/invalid-deployment-config.yml")))
        .returns(true, ValidationReport::hasErrors)
        .extracting(ValidationReport::getMessages)
        .asInstanceOf(InstanceOfAssertFactories.iterable(ValidationMessage.class))
        .extracting(ValidationMessage::getMessage)
        .contains("[Path '/spec'] Object instance has properties which are not allowed by the schema: [\"templates\"]")
        .contains("[Path '/spec/triggers/1/imageChangeParams'] Object has missing required properties ([\"from\"])")
        .contains(
            "[Path '/spec/replicas'] Instance type (string) does not match any allowed primitive type (allowed: [\"integer\"])");
  }

  @Test
  @DisplayName("With resource not in OpenAPI schema, has no validation errors")
  void withUnknownResource() throws IOException {
    assertThat(validator.validate(ValidatorTest.class.getResourceAsStream("/custom-resource-not-in-schema.yml")))
        .returns(false, ValidationReport::hasErrors);
  }
}
