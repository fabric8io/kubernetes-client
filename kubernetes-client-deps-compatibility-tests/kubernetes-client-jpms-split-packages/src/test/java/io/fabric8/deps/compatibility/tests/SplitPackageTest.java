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
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Guards the JPMS packaging invariant across the published artifacts: no package may be
 * contributed by more than one of them. Split packages are legal on the classpath and tolerated by
 * OSGi, but the module system rejects them, so affected artifacts cannot sit on a module path
 * together.
 * <p>
 * The jars are staged by {@code maven-dependency-plugin:copy-dependencies} from the io.fabric8
 * closure of the roots declared in the pom, so a newly added model or extension module is covered
 * automatically once something depends on it. Deliberately-shaded artifacts and the OSGi
 * {@code bundle} classifier are excluded there, with the reasoning recorded inline.
 * <p>
 * Packages are read from the jar entries rather than through {@code ModuleFinder}, which cannot
 * derive a module name from the evergreen {@code 999-SNAPSHOT} version these jars carry in CI.
 */
class SplitPackageTest {

  /**
   * Lower bound on the staged artifact count, so a staging step that silently stopped resolving
   * cannot leave the suite trivially green. Deliberately well below the real count (~98) to avoid
   * churn whenever a module is added or removed.
   */
  private static final int MINIMUM_STAGED_ARTIFACTS = 60;

  private static final String MULTI_RELEASE_PREFIX = "META-INF/versions/";

  private static Map<String, Set<String>> packagesByArtifact;

  @BeforeAll
  static void setUp() throws IOException {
    final String jarsDirProperty = System.getProperty("published.jars.dir");
    assertThat(jarsDirProperty)
        .as("System property 'published.jars.dir' must be set")
        .isNotNull();
    final Path jarsDir = Paths.get(jarsDirProperty);
    assertThat(jarsDir).isDirectory();
    try (Stream<Path> jarFiles = Files.list(jarsDir)) {
      packagesByArtifact = jarFiles
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
  @DisplayName("the published artifacts are actually staged, so a broken staging step cannot leave this suite trivially green")
  void publishedArtifactsAreStaged() {
    assertThat(packagesByArtifact)
        .as("Artifacts staged for split package verification")
        .hasSizeGreaterThanOrEqualTo(MINIMUM_STAGED_ARTIFACTS);
  }

  @Test
  @DisplayName("no package is contributed by more than one published artifact, so they can share a module path")
  void publishedArtifactsDoNotShareAnyPackage() {
    final Map<String, List<String>> artifactsByPackage = new TreeMap<>();
    packagesByArtifact.forEach((artifact, packages) -> packages
        .forEach(pkg -> artifactsByPackage.computeIfAbsent(pkg, k -> new ArrayList<>()).add(artifact)));
    final List<String> splits = artifactsByPackage.entrySet().stream()
        .filter(entry -> entry.getValue().size() > 1)
        .map(entry -> entry.getKey() + " <- " + String.join(" + ", entry.getValue()))
        .collect(Collectors.toList());
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
