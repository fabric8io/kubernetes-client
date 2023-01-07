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
package io.fabric8.java.generator;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class ConfigTest {

  @Test
  void defaultValuesWithAllArgsConstructor() {
    final Config result = new Config(null, null, null, null, null, null, null, null);
    assertThat(result)
        .returns(true, Config::isUppercaseEnums)
        .returns(Config.Prefix.TOP_LEVEL, Config::getPrefixStrategy)
        .returns(Config.Suffix.TOP_LEVEL, Config::getSuffixStrategy)
        .returns(false, Config::isAlwaysPreserveUnknownFields)
        .returns(false, Config::isObjectExtraAnnotations)
        .returns(Config.CodeStructure.PACKAGE_NESTED, Config::getCodeStructure)
        .returns(true, Config::isGeneratedAnnotations)
        .returns(new HashMap<>(), Config::getPackageOverrides);
  }

  @Test
  void defaultValuesWithNoArgsConstructor() {
    final Config result = new Config();
    assertThat(result)
        .returns(true, Config::isUppercaseEnums)
        .returns(Config.Prefix.TOP_LEVEL, Config::getPrefixStrategy)
        .returns(Config.Suffix.TOP_LEVEL, Config::getSuffixStrategy)
        .returns(false, Config::isAlwaysPreserveUnknownFields)
        .returns(false, Config::isObjectExtraAnnotations)
        .returns(Config.CodeStructure.PACKAGE_NESTED, Config::getCodeStructure)
        .returns(true, Config::isGeneratedAnnotations)
        .returns(new HashMap<>(), Config::getPackageOverrides);
  }

  @Test
  void defaultValuesWithBuilder() {
    final Config result = Config.builder().build();
    assertThat(result)
        .returns(true, Config::isUppercaseEnums)
        .returns(Config.Prefix.TOP_LEVEL, Config::getPrefixStrategy)
        .returns(Config.Suffix.TOP_LEVEL, Config::getSuffixStrategy)
        .returns(false, Config::isAlwaysPreserveUnknownFields)
        .returns(false, Config::isObjectExtraAnnotations)
        .returns(Config.CodeStructure.PACKAGE_NESTED, Config::getCodeStructure)
        .returns(true, Config::isGeneratedAnnotations)
        .returns(new HashMap<>(), Config::getPackageOverrides);
  }
}
