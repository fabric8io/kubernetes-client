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
package io.fabric8.kubernetes.jsonschema2pojo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.fabric8.kubernetes.jsonschema2pojo.Fabric8NameHelper.correctCamelCaseWithPrefix;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Fabric8NameHelperTest {

  private static ObjectMapper M;

  @BeforeAll
  static void beforeAll() {
    M = new ObjectMapper();
  }

  @Test
  void correctCamelCaseWithPrefixWithSingleLetterDash() {
    assertEquals("getXField", correctCamelCaseWithPrefix("x-field", "getxField"));
    assertEquals("setXField", correctCamelCaseWithPrefix("x-field", "setxField"));
  }

  @Test
  void correctCamelCaseWithPrefixWithSingleLetter() {
    assertEquals("getSFlow", correctCamelCaseWithPrefix("sFlow", "getsFlow"));
    assertEquals("setSFlow", correctCamelCaseWithPrefix("sFlow", "setsFlow"));
  }

  @Test
  void correctCamelCaseWithPrefixWithSingleLetterAndSingleLetter() {
    assertEquals("getSF", correctCamelCaseWithPrefix("sF", "getsF"));
    assertEquals("setSF", correctCamelCaseWithPrefix("sF", "setsF"));
  }

  @Test
  void correctCamelCaseWithPrefixWithTwoLetter() {
    assertEquals("getNetsFlow", correctCamelCaseWithPrefix("netsFlow", "getNetsFlow"));
    assertEquals("setNetsFlow", correctCamelCaseWithPrefix("netsFlow", "setNetsFlow"));
  }

  @Test
  void correctCamelCaseWithPrefixWithCapitalFirstLetter() {
    assertEquals("getIpfix", correctCamelCaseWithPrefix("Ipfix", "getIpfix"));
    assertEquals("setIpfix", correctCamelCaseWithPrefix("Ipfix", "setIpfix"));
  }

  @DisplayName("getFieldName, should use javaName and never reserved words")
  @ParameterizedTest(name = "{index}: getFieldName: property ''{0}'' node: ''{1}'', expects: ''{2}''")
  @MethodSource("getFieldNameInput")
  void getFieldName(String propertyName, ObjectNode node, String expectedName) {
    // When
    final String result = new Fabric8NameHelper(null).getFieldName(propertyName, node);
    // Then
    assertEquals(expectedName, result);
  }

  static Stream<Arguments> getFieldNameInput() {
    return Stream.of(
        arguments("field", M.createObjectNode(), "field"),
        arguments("class", M.createObjectNode(), "className"),
        arguments("class", M.createObjectNode().put("javaName", "theClass"), "theClass"),
        arguments("field", M.createObjectNode().put("javaName", "aField"), "aField"),
        arguments("field", M.createObjectNode().put("javaName", "class"), "className"));
  }
}
