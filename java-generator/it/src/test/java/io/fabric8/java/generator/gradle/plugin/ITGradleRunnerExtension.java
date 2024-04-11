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

import io.fabric8.java.generator.testing.GradleProperties;
import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Simplified/updated version of
 * https://github.com/eclipse/jkube/blob/master/gradle-plugin/it/src/test/java/org/eclipse/jkube/gradle/plugin/tests/ITGradleRunnerExtension.java
 */
public class ITGradleRunnerExtension implements BeforeEachCallback, AfterEachCallback {
  public static final String GRADLE_PROJECT_PROPERTY_KUBERNETES_CLIENT_VERSION = "kubernetesClientVersion";
  public static final String GRADLE_PROJECT_PROPERTY_LOMBOK_VERSION = "lombokVersion";
  public static final String GRADLE_PROJECT_PROPERTY_SUNDRIO_VERSION = "sundrioVersion";
  public static final String GRADLE_PROJECT_PROPERTY_IT_DIR = "itDir";
  public static final String MAVEN_PROJECT_PROPERTY_KUBERNETES_CLIENT_VERSION = GRADLE_PROJECT_PROPERTY_KUBERNETES_CLIENT_VERSION;
  public static final String MAVEN_PROJECT_PROPERTY_LOMBOK_VERSION = GRADLE_PROJECT_PROPERTY_LOMBOK_VERSION;
  public static final String MAVEN_PROJECT_PROPERTY_SUNDRIO_VERSION = GRADLE_PROJECT_PROPERTY_SUNDRIO_VERSION;
  public static final String GRADLE_RUNNER_BINARIES_ARCHIVE_URL = "https://services.gradle.org/distributions/gradle-"
      + GradleProperties.binariesVersion() + "-bin.zip";
  private GradleRunner gradleRunner;

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    gradleRunner = GradleRunner.create()
        .withGradleDistribution(new URI(GRADLE_RUNNER_BINARIES_ARCHIVE_URL))
        .withDebug(true)
        .withPluginClasspath(Arrays.stream(System.getProperty("java.class.path").split(File.pathSeparator))
            .map(File::new).collect(Collectors.toList()));
  }

  @Override
  public void afterEach(ExtensionContext context) {
    gradleRunner = null;
  }

  public ITGradleRunnerExtension withITProject(String name) {
    final String baseDir = System.getProperty(GRADLE_PROJECT_PROPERTY_IT_DIR, "");
    gradleRunner = gradleRunner
        .withProjectDir(new File(baseDir).toPath()
            .resolve("src")
            .resolve("it")
            .resolve("plugin")
            .resolve("gradle").resolve(name).toFile());
    return this;
  }

  public ITGradleRunnerExtension withArguments(String... originalArguments) {
    List<String> arguments = new ArrayList<>();
    arguments.add(String.format("-P%s=%s", GRADLE_PROJECT_PROPERTY_KUBERNETES_CLIENT_VERSION,
        System.getProperty(MAVEN_PROJECT_PROPERTY_KUBERNETES_CLIENT_VERSION)));
    arguments.add(String.format("-P%s=%s", GRADLE_PROJECT_PROPERTY_LOMBOK_VERSION,
        System.getProperty(MAVEN_PROJECT_PROPERTY_LOMBOK_VERSION)));
    arguments.add(String.format("-P%s=%s", GRADLE_PROJECT_PROPERTY_SUNDRIO_VERSION,
        System.getProperty(MAVEN_PROJECT_PROPERTY_SUNDRIO_VERSION)));
    arguments.add("--console=plain");
    arguments.addAll(Arrays.asList(originalArguments));
    gradleRunner = gradleRunner.withArguments(arguments.toArray(new String[0]));
    return this;
  }

  public BuildResult build() {
    return gradleRunner.build();
  }
}
