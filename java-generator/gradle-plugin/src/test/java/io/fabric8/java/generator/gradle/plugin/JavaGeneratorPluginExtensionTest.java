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
package io.fabric8.java.generator.gradle.plugin;

import io.fabric8.java.generator.Config;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.ListProperty;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaGeneratorPluginExtensionTest {
  static Stream<Arguments> testGettersAndSetters() {
    JavaGeneratorPluginExtension extension = new JavaGeneratorPluginExtensionTestImpl();
    return Stream.of(
        Arguments.of(Config.DEFAULT_ALWAYS_PRESERVE_UNKNOWN, !Config.DEFAULT_ALWAYS_PRESERVE_UNKNOWN, null,
            (Supplier<Boolean>) extension::getAlwaysPreserveUnknown, (Consumer<Boolean>) extension::setAlwaysPreserveUnknown),
        Arguments.of(Config.DEFAULT_UPPERCASE_ENUM, !Config.DEFAULT_UPPERCASE_ENUM, null,
            (Supplier<Boolean>) extension::getEnumUppercase, (Consumer<Boolean>) extension::setEnumUppercase),
        Arguments.of(Config.DEFAULT_ADD_EXTRA_ANNOTATIONS, !Config.DEFAULT_ADD_EXTRA_ANNOTATIONS, null,
            (Supplier<Boolean>) extension::getExtraAnnotations, (Consumer<Boolean>) extension::setExtraAnnotations),
        Arguments.of(Config.DEFAULT_ADD_GENERATED_ANNOTATIONS, !Config.DEFAULT_ADD_GENERATED_ANNOTATIONS, null,
            (Supplier<Boolean>) extension::getGeneratedAnnotations, (Consumer<Boolean>) extension::setGeneratedAnnotations),
        Arguments.of(Config.DEFAULT_DESER_DATETIME_FORMAT, UUID.randomUUID().toString(), "",
            (Supplier<String>) extension::getDeserializationDatetimeFormat,
            (Consumer<String>) extension::setDeserializationDatetimeFormat),
        Arguments.of(Config.DEFAULT_SER_DATETIME_FORMAT, UUID.randomUUID().toString(), "",
            (Supplier<String>) extension::getSerializationDatetimeFormat,
            (Consumer<String>) extension::setSerializationDatetimeFormat),
        Arguments.of(Config.DEFAULT_FILES_SUFFIXES,
            Collections.singletonList(UUID.randomUUID().toString()), Collections.emptyList(),
            (Supplier<List<String>>) extension::getFilesSuffixes, (Consumer<List<String>>) extension::setFilesSuffixes),
        Arguments.of(Config.DEFAULT_EXISTING_JAVA_TYPES_OVERRIDES,
            Collections.singletonMap(UUID.randomUUID().toString(), UUID.randomUUID().toString()), Collections.emptyMap(),
            (Supplier<Map<String, String>>) extension::getExistingJavaTypes,
            (Consumer<Map<String, String>>) extension::setExistingJavaTypes),
        Arguments.of(Config.DEFAULT_PACKAGE_OVERRIDES,
            Collections.singletonMap(UUID.randomUUID().toString(), UUID.randomUUID().toString()), Collections.emptyMap(),
            (Supplier<Map<String, String>>) extension::getPackageOverrides,
            (Consumer<Map<String, String>>) extension::setPackageOverrides));
  }

  @ParameterizedTest
  @MethodSource
  <T> void testGettersAndSetters(T defaultValue, T alternateValue, T emptyValue, Supplier<T> getter, Consumer<T> setter) {
    assertEquals(defaultValue, getter.get());

    setter.accept(alternateValue);
    assertEquals(alternateValue, getter.get());

    setter.accept(null);
    assertEquals(defaultValue, getter.get());

    setter.accept(alternateValue);
    assertEquals(alternateValue, getter.get());

    setter.accept(emptyValue);
    assertEquals(defaultValue, getter.get());

    setter.accept(alternateValue);
    assertEquals(alternateValue, getter.get());
  }

  static class JavaGeneratorPluginExtensionTestImpl extends JavaGeneratorPluginExtension {
    public JavaGeneratorPluginExtensionTestImpl() {
      super(null);
    }

    @Override
    public RegularFileProperty getSource() {
      return null;
    }

    @Override
    public ListProperty<String> getUrls() {
      return null;
    }

    @Override
    public DirectoryProperty getDownloadTarget() {
      return null;
    }

    @Override
    public DirectoryProperty getTarget() {
      return null;
    }
  }
}
