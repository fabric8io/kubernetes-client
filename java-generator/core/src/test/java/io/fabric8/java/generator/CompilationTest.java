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

import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.tools.JavaFileObject;

import static com.google.testing.compile.Compiler.javac;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CompilationTest {

  @TempDir
  private File tempDir;

  private Config config;

  @BeforeEach
  void setUp() {
    config = Config.builder()
        .structure(Config.CodeStructure.PACKAGE_NESTED)
        .generatedAnnotations(false)
        .build();
  }

  private static Stream<Arguments> compilationTestData() {
    return Stream.of(
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
        Arguments.of("folder", 6));
  }

  @ParameterizedTest(name = "{0} should generate {1} source files and compile OK")
  @MethodSource("compilationTestData")
  void yamlCompiles(String yamlFile, int expectedGeneratedSourceFiles) throws Exception {
    // Arrange
    File crd = getCRD(yamlFile);

    // Act
    new FileJavaGenerator(config, crd).run(tempDir);
    Compilation compilation = javac().compile(getSources(tempDir));

    // Assert
    assertTrue(compilation.errors().isEmpty());
    assertEquals(expectedGeneratedSourceFiles, compilation.sourceFiles().size());
    assertEquals(Compilation.Status.SUCCESS, compilation.status());
  }

  @Test
  void crontabCRDCompilesWithFlatPackage() throws Exception {
    // Arrange
    File crd = getCRD("crontab-crd.yml");
    config = config.toBuilder()
        .structure(Config.CodeStructure.FLAT)
        .build();

    // Act
    new FileJavaGenerator(config, crd).run(tempDir);
    Compilation compilation = javac().compile(getSources(tempDir));

    // Assert
    assertTrue(compilation.errors().isEmpty());
    assertEquals(3, compilation.sourceFiles().size());
    assertEquals(Compilation.Status.SUCCESS, compilation.status());
  }

  @Test
  void testCrontabCRDCompilesWithExtraAnnotationsAndUnknownFields() throws Exception {
    // Arrange
    File crd = getCRD("crontab-crd.yml");
    config = config.toBuilder()
        .objectExtraAnnotations(true)
        .alwaysPreserveUnknownFields(true)
        .build();

    // Act
    new FileJavaGenerator(config, crd).run(tempDir);
    Compilation compilation = javac().compile(getSources(tempDir));

    // Assert
    assertTrue(compilation.errors().isEmpty());
    assertEquals(3, compilation.sourceFiles().size());
    assertEquals(Compilation.Status.SUCCESS, compilation.status());
  }

  static List<JavaFileObject> getSources(File basePath) throws IOException {
    List<JavaFileObject> sources = new ArrayList<JavaFileObject>();
    for (Path f : Files.list(basePath.toPath()).collect(Collectors.toList())) {
      if (f.toFile().isDirectory()) {
        sources.addAll(getSources(f.toFile()));
      } else {
        sources.add(JavaFileObjects.forResource(f.toUri().toURL()));
      }
    }

    return sources;
  }

  static File getCRD(String name) throws Exception {
    return Paths.get(CompilationTest.class.getClassLoader().getResource(name).toURI()).toFile();
  }
}
