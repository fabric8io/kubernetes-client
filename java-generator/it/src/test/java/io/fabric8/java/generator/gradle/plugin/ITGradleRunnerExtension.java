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
package io.fabric8.java.generator.gradle.plugin;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.File;
import java.net.URI;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Simplified/updated version of
 * https://github.com/eclipse/jkube/blob/master/gradle-plugin/it/src/test/java/org/eclipse/jkube/gradle/plugin/tests/ITGradleRunnerExtension.java
 */
public class ITGradleRunnerExtension implements BeforeEachCallback, AfterEachCallback {
  private GradleRunner gradleRunner;

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    gradleRunner = GradleRunner.create()
        .withGradleDistribution(new URI("https://services.gradle.org/distributions/gradle-8.1-bin.zip"))
        .withDebug(true)
        .withPluginClasspath(Arrays.stream(System.getProperty("java.class.path").split(File.pathSeparator))
            .map(File::new).collect(Collectors.toList()));
  }

  @Override
  public void afterEach(ExtensionContext context) {
    gradleRunner = null;
  }

  public ITGradleRunnerExtension withITProject(String name) {
    final String baseDir = System.getProperty("itDir", "");
    gradleRunner = gradleRunner
        .withProjectDir(new File(baseDir).toPath()
            .resolve("src")
            .resolve("it")
            .resolve("plugin")
            .resolve("gradle").resolve(name).toFile());
    return this;
  }

  public ITGradleRunnerExtension withArguments(String... originalArguments) {
    final String[] arguments = new String[originalArguments.length + 1];
    arguments[0] = "--console=plain";
    System.arraycopy(originalArguments, 0, arguments, 1, originalArguments.length);
    gradleRunner = gradleRunner.withArguments(arguments);
    return this;
  }

  public BuildResult build() {
    return gradleRunner.build();
  }
}
