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

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JType;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.util.NameHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Renames reserved fields name to predefined values (PROTECTED_WORD_MAP)
 * <p>
 * Overrides default provided NameHelper to overcome getter/setter naming convention mismatch between Sundr.io
 * and jsonschema2pojo.
 * <p>
 * There are issues with properties such as x-kubernetes-foo or xKubernetesFoo, sundrio expects a getter as
 * getXKubernetesFoo while jsonschema2pojo produces getxKubernetesFoo.
 */
public class Fabric8NameHelper extends NameHelper {

  private static final Map<String, String> PROTECTED_WORD_MAP = new HashMap<>();
  static {
    PROTECTED_WORD_MAP.put("class", "className");
  }
  private static final Pattern SINGLE_LETTER_PREFIX_WORD_PROPERTY = Pattern.compile("^[a-z]((-[a-zA-Z])|[A-Z])(.*)$");

  public Fabric8NameHelper(GenerationConfig generationConfig) {
    super(generationConfig);
  }

  @Override
  public String getFieldName(String propertyName, JsonNode node) {
    final String fieldName = super.getFieldName(propertyName, node);
    return PROTECTED_WORD_MAP.getOrDefault(fieldName, fieldName);
  }

  @Override
  public String getGetterName(String propertyName, JType type, JsonNode node) {
    return correctCamelCaseWithPrefix(propertyName, super.getGetterName(propertyName, type, node));
  }

  @Override
  public String getSetterName(String propertyName, JsonNode node) {
    return correctCamelCaseWithPrefix(propertyName, super.getSetterName(propertyName, node));
  }

  static String correctCamelCaseWithPrefix(String propertyName, String functionName) {
    final Matcher m = SINGLE_LETTER_PREFIX_WORD_PROPERTY.matcher(propertyName);
    if (m.matches()) {
      // https://github.com/joelittlejohn/jsonschema2pojo/issues/1028 + Sundr.io expecting the opposite (setXKubernetes... instead of setxKubernetes)
      return functionName.substring(0, 3) + functionName.substring(3, 4).toUpperCase() + functionName.substring(4);
    }
    return functionName;
  }
}
