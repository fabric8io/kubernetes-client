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

import com.github.javaparser.StaticJavaParser;
import io.fabric8.java.generator.exceptions.JavaGeneratorException;
import io.fabric8.java.generator.nodes.GeneratorResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Covers the filesystem containment guard of {@link WritableCRCompilationUnit}.
 * <p>
 * The guard cannot be reached through a CRD document: the structural validation performed while a
 * class is generated rejects any package or class name that is not valid Java, long before the
 * write phase runs (see {@code CompilationTest#rejectsPathTraversalInCrdVersion}). These tests
 * therefore drive the write phase directly, which is the only way to prove the guard is wired in.
 * <p>
 * The output directory is nested inside a sandbox so that an escape shows up as an entry next to
 * it, rather than being invisible to an assertion that only looks at the output directory.
 */
class WritableCRCompilationUnitTest {

  @TempDir
  private File sandbox;

  private File outputDirectory;

  @BeforeEach
  void setUp() throws IOException {
    outputDirectory = Files.createDirectory(sandbox.toPath().resolve("out")).toFile();
  }

  private static GeneratorResult.ClassResult classNamed(String name) {
    return new GeneratorResult.ClassResult(
        name, StaticJavaParser.parse("package com.example.v1; public class Escape {}"));
  }

  @Test
  @DisplayName("A class file resolving outside the output directory is rejected and never written")
  void rejectsClassFileEscapingOutputDirectory() throws Exception {
    // Arrange: the compilation unit is valid Java, so it survives structural validation. The
    // traversal rides on the class name, which is what the generated file is named after.
    WritableCRCompilationUnit unit = new WritableCRCompilationUnit(
        Collections.singletonList(classNamed("../../../../pwned")), "com.example");

    // Act & Assert
    assertThatThrownBy(() -> unit.writeAllJavaClasses(outputDirectory))
        .isInstanceOf(JavaGeneratorException.class)
        .hasMessageContaining("escapes the target directory");

    assertThat(everythingUnder(sandbox))
        .containsExactly("out", "out/com", "out/com/example", "out/com/example/v1");
  }

  @Test
  @DisplayName("A base package resolving outside the output directory is rejected before any folder is created")
  void rejectsBasePackageEscapingOutputDirectory() throws Exception {
    // Arrange: splitting a package on "." can never yield a ".." segment, but it does yield
    // absolute ones, and Path#resolve discards everything to the left of those.
    WritableCRCompilationUnit unit = new WritableCRCompilationUnit(Collections.emptyList(), "/pwned");

    // Act & Assert
    assertThatThrownBy(() -> unit.writeAllJavaClasses(outputDirectory))
        .isInstanceOf(JavaGeneratorException.class)
        .hasMessageContaining("escapes the target directory");

    assertThat(everythingUnder(sandbox)).containsExactly("out");
  }

  @Test
  @DisplayName("A package contained in the output directory is written without complaint")
  void writesClassContainedInOutputDirectory() throws Exception {
    // Arrange
    WritableCRCompilationUnit unit = new WritableCRCompilationUnit(
        Collections.singletonList(classNamed("Escape")), "com.example");

    // Act
    unit.writeAllJavaClasses(outputDirectory);

    // Assert
    assertThat(everythingUnder(sandbox)).contains("out/com/example/v1/Escape.java");
  }

  /** Every path below the sandbox, so an escape surfaces as an entry outside {@code out}. */
  private static List<String> everythingUnder(File root) throws IOException {
    Path rootPath = root.toPath();
    try (Stream<Path> paths = Files.walk(rootPath)) {
      return paths
          .map(p -> rootPath.relativize(p).toString().replace(File.separatorChar, '/'))
          .filter(p -> !p.isEmpty())
          .sorted()
          .collect(Collectors.toList());
    }
  }
}
