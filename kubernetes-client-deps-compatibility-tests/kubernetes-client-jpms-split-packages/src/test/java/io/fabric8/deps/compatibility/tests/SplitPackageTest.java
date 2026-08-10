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
package io.fabric8.deps.compatibility.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Guards the JPMS packaging invariant: no two published artifacts may contribute classes to the
 * same package. Split packages are legal on the classpath and tolerated by OSGi, but the module
 * system rejects them, so the affected artifacts cannot sit on the module path together.
 * <p>
 * The staged artifacts are the pairs that regressed historically. Adding an artifact to the
 * {@code copy-split-package-candidate-jars} execution in the pom automatically extends coverage,
 * since every staged jar is compared against every other one.
 * <p>
 * Packages are read from the jar entries rather than through {@code ModuleFinder}, which cannot
 * derive a module name from the evergreen {@code 999-SNAPSHOT} version these jars carry in CI.
 */
class SplitPackageTest {

  private static final int EXPECTED_JAR_COUNT = 4;
  private static final String MULTI_RELEASE_PREFIX = "META-INF/versions/";

  private static Map<String, Set<String>> packagesByJar;

  @BeforeAll
  static void setUp() throws IOException {
    final String jarsDirProperty = System.getProperty("split.package.jars.dir");
    assertThat(jarsDirProperty)
        .as("System property 'split.package.jars.dir' must be set")
        .isNotNull();
    final Path jarsDir = Paths.get(jarsDirProperty);
    assertThat(jarsDir).isDirectory();
    try (Stream<Path> jarFiles = Files.list(jarsDir)) {
      packagesByJar = jarFiles
          .filter(p -> p.toString().endsWith(".jar"))
          .sorted()
          .collect(Collectors.toMap(
              p -> p.getFileName().toString(),
              SplitPackageTest::packagesOf,
              (a, b) -> a,
              LinkedHashMap::new));
    }
  }

  @Test
  @DisplayName("every candidate artifact is staged, so a copy that silently stopped resolving cannot pass the suite")
  void allCandidateJarsAreStaged() {
    assertThat(packagesByJar)
        .as("Jars staged for split package verification")
        .hasSize(EXPECTED_JAR_COUNT);
    assertThat(packagesByJar.values())
        .as("Each staged jar must contribute at least one package")
        .allSatisfy(packages -> assertThat(packages).isNotEmpty());
  }

  @Test
  @DisplayName("no package is contributed by more than one published artifact, so the artifacts can share a module path")
  void publishedArtifactsDoNotShareAnyPackage() {
    final List<String> jars = new ArrayList<>(packagesByJar.keySet());
    final List<String> splits = new ArrayList<>();
    for (int i = 0; i < jars.size(); i++) {
      for (int j = i + 1; j < jars.size(); j++) {
        final String left = jars.get(i);
        final String right = jars.get(j);
        final Set<String> shared = new TreeSet<>(packagesByJar.get(left));
        shared.retainAll(packagesByJar.get(right));
        shared.forEach(pkg -> splits.add(pkg + " <- " + left + " + " + right));
      }
    }
    assertThat(splits)
        .as("Packages split across published artifacts")
        .isEmpty();
  }

  private static Set<String> packagesOf(Path jarPath) {
    try (JarFile jarFile = new JarFile(jarPath.toFile())) {
      return jarFile.stream()
          .map(entry -> packageOf(entry.getName()))
          .filter(pkg -> !pkg.isEmpty())
          .collect(Collectors.toCollection(TreeSet::new));
    } catch (IOException e) {
      throw new UncheckedIOException("Failed to read JAR: " + jarPath, e);
    }
  }

  /**
   * @return the package of a class entry, or the empty string for anything that does not place a
   *         class in a named package (resources, {@code module-info}, default-package classes).
   */
  private static String packageOf(String entryName) {
    String name = entryName;
    if (name.startsWith(MULTI_RELEASE_PREFIX)) {
      name = name.substring(name.indexOf('/', MULTI_RELEASE_PREFIX.length()) + 1);
    }
    if (!name.endsWith(".class") || name.equals("module-info.class")) {
      return "";
    }
    final int lastSlash = name.lastIndexOf('/');
    return lastSlash < 0 ? "" : name.substring(0, lastSlash).replace('/', '.');
  }
}
