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
package io.fabric8.java.generator;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import io.fabric8.java.generator.exceptions.JavaGeneratorException;
import io.sundr.builder.internal.processor.BuildableProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.tools.JavaFileObject;

import static com.google.testing.compile.Compiler.javac;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CompilationTest {

  @TempDir
  private File tempDir;

  private Config config;

  @BeforeEach
  void setUp() {
    config = Config.builder()
        .generatedAnnotations(false)
        .build();
  }

  private static Stream<Arguments> compilationTestData() {
    return Stream.of(
        Arguments.of("dummy-crd.yml", 2),
        Arguments.of("crontab-crd.yml", 3),
        Arguments.of("keycloak-crd.yml", 50),
        Arguments.of("akka-microservices-crd.yml", 28),
        Arguments.of("strimzi-kafka-crd.yml", 704),
        Arguments.of("spark-crd.yml", 358),
        Arguments.of("crunchy-postgres-crd.yml", 267),
        Arguments.of("kamelet-crd.yml", 16),
        Arguments.of("jokerequests-crd.yml", 3),
        Arguments.of("cert-manager-crd.yml", 5),
        Arguments.of("camel-integrationplatforms-crd.yaml", 192),
        Arguments.of("two-crds.yml", 6),
        Arguments.of("folder", 6),
        Arguments.of("calico-ippool-crd.yml", 3),
        Arguments.of("emissary-crds.yaml", 242),
        Arguments.of("colliding-enums-crd.yml", 2));
  }

  @ParameterizedTest(name = "{0} should generate {1} source files and compile OK")
  @MethodSource("compilationTestData")
  void yamlCompiles(String yamlFile, int expectedGeneratedSourceFiles) throws Exception {
    // Arrange
    final var crd = getCRD(yamlFile);

    // Act
    new FileJavaGenerator(config, crd).run(tempDir);
    final var compilation = javac().compile(getSources(tempDir));

    // Assert
    assertThat(compilation.errors()).isEmpty();
    assertThat(compilation.sourceFiles()).hasSize(expectedGeneratedSourceFiles);
    assertThat(compilation.status()).isEqualTo(Compilation.Status.SUCCESS);
  }

  @Disabled("Requires support from sundrio to work with compile-testing, see sundrio PR #469")
  @Test
  void testCrontabCRDCompilesWithExtraAnnotations() throws Exception {
    // Arrange
    final var crd = getCRD("crontab-crd.yml");
    config = config.toBuilder()
        .objectExtraAnnotations(true)
        .build();

    // Act
    new FileJavaGenerator(config, crd).run(tempDir);
    final var compilation = javac()
        .withProcessors(new BuildableProcessor())
        .compile(getSources(tempDir));

    // Assert
    assertThat(compilation.errors()).isEmpty();
    assertThat(compilation.sourceFiles()).hasSize(3);
    assertThat(compilation.status()).isEqualTo(Compilation.Status.SUCCESS);
  }

  @Test
  void testCalicoIPPoolCRDDoesNotCompileWhenDuplicatesAreNotDeprecated() throws Exception {
    // Arrange
    final var crd = getCRD("calico-ippool-broken-crd.yml");
    config = config.toBuilder()
        .objectExtraAnnotations(true)
        .build();

    // Assert
    assertThatThrownBy(() -> {
      // Act
      new FileJavaGenerator(config, crd).run(tempDir);
      javac().compile(getSources(tempDir));
    }).as("The current CRD should not compile since it contains duplicate fields which are not marked as deprecated")
        .isInstanceOf(JavaGeneratorException.class);
  }

  static List<JavaFileObject> getSources(File basePath) throws Exception {
    final var sources = new ArrayList<JavaFileObject>();
    try (final var pathStream = Files.list(basePath.toPath())) {
      for (final var path : pathStream.collect(Collectors.toList())) {
        final var file = path.toFile();
        if (file.isDirectory()) {
          sources.addAll(getSources(file));
        } else {
          sources.add(JavaFileObjects.forResource(path.toUri().toURL()));
        }
      }
    }
    return sources;
  }

  static File getCRD(String name) throws Exception {
    final var resource = CompilationTest.class.getClassLoader().getResource(name);
    assertThat(resource).isNotNull();
    return Paths.get(resource.toURI()).toFile();
  }
}
