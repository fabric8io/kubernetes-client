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
package io.fabric8.crd.generator.types;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TypeMappingsTest {

  private CustomResourceDefinition crd;

  @BeforeEach
  void setUp() {
    crd = Serialization.unmarshal(
        TypeMappingsTest.class.getResourceAsStream("/META-INF/fabric8/typemappings.type-mappings.fabric8.io-v1.yml"),
        CustomResourceDefinition.class);
  }

  @ParameterizedTest(name = "{0} type maps to {1}")
  @MethodSource("targetTypeCases")
  void targetType(String propertyName, String expectedType) {
    assertThat(crd.getSpec().getVersions().iterator().next().getSchema().getOpenAPIV3Schema().getProperties())
        .extracting(schema -> schema.get("spec").getProperties())
        .returns(expectedType, specProps -> specProps.get(propertyName).getType());
  }

  private static Stream<Arguments> targetTypeCases() {
    return Stream.of(
        Arguments.of("date", "string"),
        Arguments.of("localDate", "object"), // to review
        Arguments.of("localDateTime", "object"), // to review
        Arguments.of("zonedDateTime", "object"), // to review
        Arguments.of("offsetDateTime", "object"), // to review
        Arguments.of("offsetTime", "object"), // to review
        Arguments.of("yearMonth", "object"), // to review
        Arguments.of("monthDay", "object"), // to review
        Arguments.of("instant", "object"), // to review
        Arguments.of("duration", "object"), // to review
        Arguments.of("period", "object"), // to review
        Arguments.of("timestamp", "object"), // to review
        // Arguments.of("aShort", "integer"), // TODO: Not even present in the CRD
        Arguments.of("aShortObj", "object"), // to review
        Arguments.of("aInt", "integer"),
        Arguments.of("aIntegerObj", "integer"),
        Arguments.of("aLong", "integer"),
        Arguments.of("aLongObj", "integer"),
        Arguments.of("aDouble", "number"),
        Arguments.of("aDoubleObj", "number"),
        Arguments.of("aFloat", "number"),
        Arguments.of("aFloatObj", "number"),
        Arguments.of("aNumber", "object"), // to review
        Arguments.of("aBigInteger", "object"), // to review
        Arguments.of("aBigDecimal", "object"), // to review
        Arguments.of("aBoolean", "boolean"),
        Arguments.of("aBooleanObj", "boolean"),
        // Arguments.of("aChar", "string"), // TODO: Not even present in the CRD
        Arguments.of("aCharacterObj", "object"), // to review
        Arguments.of("aCharArray", "array"),
        Arguments.of("aCharSequence", "object"), // to review
        Arguments.of("aString", "string"),
        Arguments.of("aStringArray", "array"),
        // Arguments.of("aByte", "?"), // TODO: Not even present in the CRD
        Arguments.of("aByteObj", "object"), // to review
        Arguments.of("aByteArray", "array"), // to review, should be string (base64)
        Arguments.of("uuid", "object")); // to review, should be string
  }

}
