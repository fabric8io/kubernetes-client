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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.spi.ToolProvider;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class JavadocRenderingTest {

  @TempDir
  private File tempDir;

  private Config config;
  private File javadocOutputDir;

  @BeforeEach
  void setUp() {
    config = Config.builder()
        .generatedAnnotations(false)
        .build();
    javadocOutputDir = new File(tempDir, "javadoc-output");
    javadocOutputDir.mkdirs();
  }

  @Test
  void javadocRendersHtmlEscapedDescriptionsWithoutErrors() throws Exception {
    ToolProvider javadocTool = ToolProvider.findFirst("javadoc").orElse(null);
    assumeTrue(javadocTool != null, "javadoc tool not available in this JDK");

    File crd = CompilationTest.getCRD("html-description-crd.yml");
    new FileJavaGenerator(config, crd).run(tempDir);

    List<String> sourceFiles = collectJavaFiles(tempDir.toPath());
    assertThat(sourceFiles).isNotEmpty();

    int exitCode = runJavadoc(javadocTool, sourceFiles);

    assertThat(exitCode)
        .as("javadoc should complete without errors")
        .isZero();
  }

  @Test
  void javadocRenderedHtmlContainsCorrectDescriptions() throws Exception {
    ToolProvider javadocTool = ToolProvider.findFirst("javadoc").orElse(null);
    assumeTrue(javadocTool != null, "javadoc tool not available in this JDK");

    File crd = CompilationTest.getCRD("html-description-crd.yml");
    new FileJavaGenerator(config, crd).run(tempDir);

    List<String> sourceFiles = collectJavaFiles(tempDir.toPath());
    int exitCode = runJavadoc(javadocTool, sourceFiles);
    assertThat(exitCode).as("javadoc exit code").isZero();

    File specHtml = findFile(javadocOutputDir.toPath(), "WidgetSpec.html");
    assertThat(specHtml).isNotNull().exists();
    String html = Files.readString(specHtml.toPath());

    assertThat(html)
        .contains("&lt;DatabaseName&gt;")
        .contains("A &amp; B")
        .contains("&lt;min&gt;")
        .contains("&lt;max&gt;")
        .contains("&lt;protocol&gt;")
        .contains("&lt;host&gt;")
        .contains("&amp;key2=val2")
        .contains("A simple name with no special characters.");

    File statusHtml = findFile(javadocOutputDir.toPath(), "WidgetStatus.html");
    assertThat(statusHtml).isNotNull().exists();
    String statusContent = Files.readString(statusHtml.toPath());

    assertThat(statusContent)
        .contains("&lt;Pending&gt;")
        .contains("&lt;Running&gt;")
        .contains("&lt;Failed&gt;");
  }

  private int runJavadoc(ToolProvider javadocTool, List<String> sourceFiles) {
    String classpath = System.getProperty("java.class.path");
    List<String> args = new ArrayList<>();
    args.add("-d");
    args.add(javadocOutputDir.getAbsolutePath());
    args.add("-classpath");
    args.add(classpath);
    args.add("-quiet");
    args.add("--show-members=private");
    args.add("-Xdoclint:all");
    args.addAll(sourceFiles);

    StringWriter outWriter = new StringWriter();
    StringWriter errWriter = new StringWriter();
    return javadocTool.run(
        new PrintWriter(outWriter),
        new PrintWriter(errWriter),
        args.toArray(new String[0]));
  }

  private static List<String> collectJavaFiles(Path dir) throws Exception {
    try (Stream<Path> walk = Files.walk(dir)) {
      return walk
          .map(Path::toString)
          .filter(string -> string.endsWith(".java"))
          .collect(Collectors.toList());
    }
  }

  private static File findFile(Path dir, String fileName) throws Exception {
    try (Stream<Path> walk = Files.walk(dir)) {
      return walk
          .filter(p -> p.getFileName().toString().equals(fileName))
          .map(Path::toFile)
          .findFirst()
          .orElse(null);
    }
  }
}
