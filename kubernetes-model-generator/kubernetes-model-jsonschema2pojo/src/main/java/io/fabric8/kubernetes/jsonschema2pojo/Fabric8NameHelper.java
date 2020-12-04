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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Overrides default provided NameHelper to overcome getter/setter naming convention mismatch between Sundr.io
 * and jsonschema2pojo.
 *
 * There are issues with properties such as x-kubernetes-foo, sundrio expects a getter as getXKubernetesFoo while
 * jsonschema2pojo produces getxKubernetesFoo.
 */
public class Fabric8NameHelper extends NameHelper {

  private static final Pattern SINGLE_LETTER_DASH_NAME = Pattern.compile("^([a-z])-([a-zA-Z])(.*)$");

  public Fabric8NameHelper(GenerationConfig generationConfig) {
    super(generationConfig);
  }

  @Override
  public String getGetterName(String propertyName, JType type, JsonNode node) {
    final Matcher m = SINGLE_LETTER_DASH_NAME.matcher(propertyName);
    final String getterName = super.getGetterName(propertyName, type, node);
    if (m.matches()) {
      // https://github.com/joelittlejohn/jsonschema2pojo/issues/1028 + Sundr.io expecting the opposite (getXKubernetes... instead of getxKubernetes)
      return "get" + getterName.substring(3, 4).toUpperCase() + getterName.substring(4);
    }
    return getterName;
  }

  @Override
  public String getSetterName(String propertyName, JsonNode node) {
    final Matcher m = SINGLE_LETTER_DASH_NAME.matcher(propertyName);
    final String setterName = super.getSetterName(propertyName, node);
    if (m.matches()) {
      // https://github.com/joelittlejohn/jsonschema2pojo/issues/1028 + Sundr.io expecting the opposite (setXKubernetes... instead of setxKubernetes)
      return "set" + setterName.substring(3, 4).toUpperCase() + setterName.substring(4);
    }
    return setterName;
  }
}
