/**
 * Copyright (C) 2015 Fabric8 Authors.
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
package io.fabric8.kubernetes.client.internal;

import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UtilsTest {

  @Test
  public void existingSysPropShouldReturnValue() {
    System.setProperty("something", "value");
    assertEquals("value", Utils.getSystemPropertyOrEnvVar("something"));
    System.getProperties().remove("something");
  }

  @Test
  public void missingSysPropAndEnvVarShouldReturnNull() {
    assertNull(Utils.getSystemPropertyOrEnvVar("doesn't exist"));
  }

  @Test
  public void existingEnvVarShouldReturnValue() {
    assertEquals("value", Utils.getSystemPropertyOrEnvVar("ENV_VAR_EXISTS"));
  }

  @Test
  public void existingEnvVarShouldReturnValueFromConvertedSysPropName() {
    assertEquals("value", Utils.getSystemPropertyOrEnvVar("env.var.exists"));
  }

  @Test
  public void existingEnvVarShouldReturnBooleanValueFromConvertedSysPropName() {
    assertEquals(true, Utils.getSystemPropertyOrEnvVar("env.var.exists.boolean", false));
  }

  @Test
  public void missingEnvVarShouldReturnDefaultValue() {
    assertEquals(true, Utils.getSystemPropertyOrEnvVar("DONT_EXIST", true));
  }

  @Test
  @DisplayName("interpolateString, String with no placeholders and empty parameters, should return input")
  public void interpolateStringTest() {
    // Given
    final String input = "I don't have placeholders";
    // When
    final String result = Utils.interpolateString(input, Collections.emptyMap());
    // Then
    assertEquals("I don't have placeholders", result);
  }

  @Test
  @DisplayName("interpolateString, String with no placeholders and null parameters, should return input")
  public void interpolateStringNullParametersTest() {
    // Given
    final String input = "I don't have placeholders";
    // When
    final String result = Utils.interpolateString(input, null);
    // Then
    assertEquals("I don't have placeholders", result);
  }

  @Test
  @DisplayName("interpolateString, String with no placeholders and null parameter values, should return input")
  public void interpolateStringNullParameterValuesTest() {
    // Given
    final String input = "I don't have placeholders";
    // When
    final String result = Utils.interpolateString(input, Collections.singletonMap("KEY", null));
    // Then
    assertEquals("I don't have placeholders", result);
  }

  @Test
  @DisplayName("interpolateString, String with mixed placeholders and parameters, should return interpolated input")
  public void interpolateStringWithParametersTest() {
    // Given
    final String input = "This is a \"${SINGLE_CURLY_BRACE}\" and the following is code ${NOT_REPLACED}: \"${{RENDER_UNQUOTED}}\" ${{ALREADY_UNQUOTED}}";
    final Map<String, String> parameters = new HashMap<>();
    parameters.put("SINGLE_CURLY_BRACE", "template string");
    parameters.put("RENDER_UNQUOTED", "'1' === '1';");
    parameters.put("ALREADY_UNQUOTED", "/* END */");
    parameters.put("NOT_THERE", "/* END */");
    parameters.put(null, "NULL key is ignored");
    parameters.put("NULL_VALUE", null);
    // When
    final String result = Utils.interpolateString(input, parameters);
    // Then
    assertEquals("This is a \"template string\" and the following is code ${NOT_REPLACED}: '1' === '1'; /* END */", result);
  }
}
