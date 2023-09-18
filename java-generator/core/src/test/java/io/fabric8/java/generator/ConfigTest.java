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

import static org.assertj.core.api.Assertions.assertThat;

class ConfigTest {

  @Test
  void defaultValuesWithAllArgsConstructor() {
    final Config result = new Config(null, null, null, null, null, null, null, null);
    assertThat(result)
        .returns(Config.DEFAULT_UPPERCASE_ENUM, Config::isUppercaseEnums)
        .returns(Config.DEFAULT_ADD_EXTRA_ANNOTATIONS, Config::isObjectExtraAnnotations)
        .returns(Config.DEFAULT_ADD_GENERATED_ANNOTATIONS, Config::isGeneratedAnnotations)
        .returns(Config.DEFAULT_ALWAYS_PRESERVE_UNKNOWN, Config::isAlwaysPreserveUnknown)
        .returns(Config.DEFAULT_PACKAGE_OVERRIDES, Config::getPackageOverrides)
        .returns(Config.DEFAULT_FILES_SUFFIXES, Config::getFilesSuffixes)
        .returns(Config.DEFAULT_SER_DATETIME_FORMAT, Config::getSerDatetimeFormat)
        .returns(Config.DEFAULT_DESER_DATETIME_FORMAT, Config::getDeserDatetimeFormat);
  }

  @Test
  void defaultValuesWithNoArgsConstructor() {
    final Config result = new Config();
    assertThat(result)
        .returns(Config.DEFAULT_UPPERCASE_ENUM, Config::isUppercaseEnums)
        .returns(Config.DEFAULT_ADD_EXTRA_ANNOTATIONS, Config::isObjectExtraAnnotations)
        .returns(Config.DEFAULT_ADD_GENERATED_ANNOTATIONS, Config::isGeneratedAnnotations)
        .returns(Config.DEFAULT_ALWAYS_PRESERVE_UNKNOWN, Config::isAlwaysPreserveUnknown)
        .returns(Config.DEFAULT_PACKAGE_OVERRIDES, Config::getPackageOverrides)
        .returns(Config.DEFAULT_FILES_SUFFIXES, Config::getFilesSuffixes)
        .returns(Config.DEFAULT_SER_DATETIME_FORMAT, Config::getSerDatetimeFormat)
        .returns(Config.DEFAULT_DESER_DATETIME_FORMAT, Config::getDeserDatetimeFormat);
  }

  @Test
  void defaultValuesWithBuilder() {
    final Config result = Config.builder().build();
    assertThat(result)
        .returns(Config.DEFAULT_UPPERCASE_ENUM, Config::isUppercaseEnums)
        .returns(Config.DEFAULT_ADD_EXTRA_ANNOTATIONS, Config::isObjectExtraAnnotations)
        .returns(Config.DEFAULT_ADD_GENERATED_ANNOTATIONS, Config::isGeneratedAnnotations)
        .returns(Config.DEFAULT_ALWAYS_PRESERVE_UNKNOWN, Config::isAlwaysPreserveUnknown)
        .returns(Config.DEFAULT_PACKAGE_OVERRIDES, Config::getPackageOverrides)
        .returns(Config.DEFAULT_FILES_SUFFIXES, Config::getFilesSuffixes)
        .returns(Config.DEFAULT_SER_DATETIME_FORMAT, Config::getSerDatetimeFormat)
        .returns(Config.DEFAULT_DESER_DATETIME_FORMAT, Config::getDeserDatetimeFormat);
  }
}
