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
package io.fabric8.graalvm.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Maven Mojo for generating GraalVM native-image metadata from Jandex indexes.
 */
@Mojo(name = "generate", defaultPhase = LifecyclePhase.PROCESS_CLASSES, threadSafe = true)
public class GraalVmMetadataGeneratorMojo extends AbstractMojo {

  @Parameter(defaultValue = "${project}", readonly = true, required = true)
  private MavenProject project;

  /**
   * Output directory for generated reflect-config.json.
   * Default: ${project.build.outputDirectory}/META-INF/native-image/io.fabric8/${project.artifactId}
   */
  @Parameter(property = "graalvm.metadata.outputDirectory")
  private File outputDirectory;

  /**
   * Strategy for determining which classes to include in reflection configuration.
   */
  @Parameter(property = "graalvm.metadata.inclusionStrategy", defaultValue = "JACKSON_ANNOTATIONS")
  private InclusionStrategy inclusionStrategy;

  /**
   * Package patterns to include (supports wildcards, e.g., "io.fabric8.*").
   * These are additive to the inclusion strategy.
   */
  @Parameter(property = "graalvm.metadata.includePatterns")
  private List<String> includePatterns;

  /**
   * Package patterns to exclude (supports wildcards, e.g., "*.internal.*").
   */
  @Parameter(property = "graalvm.metadata.excludePatterns")
  private List<String> excludePatterns;

  /**
   * Merge with existing reflect-config.json if it exists.
   */
  @Parameter(property = "graalvm.metadata.mergeWithExisting", defaultValue = "true")
  private boolean mergeWithExisting;

  /**
   * Skip execution of this plugin.
   */
  @Parameter(property = "graalvm.metadata.skip", defaultValue = "false")
  private boolean skip;

  /**
   * Enable reflection for all declared constructors.
   */
  @Parameter(property = "graalvm.metadata.allDeclaredConstructors", defaultValue = "true")
  private boolean allDeclaredConstructors;

  /**
   * Enable reflection for all declared methods.
   */
  @Parameter(property = "graalvm.metadata.allDeclaredMethods", defaultValue = "true")
  private boolean allDeclaredMethods;

  /**
   * Enable reflection for all declared fields.
   */
  @Parameter(property = "graalvm.metadata.allDeclaredFields", defaultValue = "true")
  private boolean allDeclaredFields;

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    if (skip) {
      getLog().info("Skipping GraalVM metadata generation (skip=true)");
      return;
    }

    try {
      // Determine output directory
      if (outputDirectory == null) {
        String artifactId = project.getArtifactId();
        outputDirectory = new File(project.getBuild().getOutputDirectory(),
            "META-INF/native-image/io.fabric8/" + artifactId);
      }

      File outputFile = new File(outputDirectory, "reflect-config.json");
      getLog().info("Generating GraalVM reflection configuration: " + outputFile);
      getLog().info("Inclusion strategy: " + inclusionStrategy);

      // Locate Jandex index
      File classesDirectory = new File(project.getBuild().getOutputDirectory());
      File indexFile = new File(classesDirectory, "META-INF/jandex.idx");

      if (!indexFile.exists()) {
        getLog().warn("Jandex index not found at " + indexFile);
        getLog().warn("Consider adding jandex-maven-plugin to your build");
        getLog().warn("Skipping metadata generation");
        return;
      }

      // Scan classes
      JandexReflectionScanner scanner = new JandexReflectionScanner(indexFile);
      Set<String> classes = scanner.findClasses(inclusionStrategy, includePatterns, excludePatterns);

      if (classes.isEmpty()) {
        getLog().info("No classes found matching inclusion criteria");
        return;
      }

      getLog().info("Found " + classes.size() + " classes for reflection configuration");

      // Generate configuration
      ReflectionConfigGenerator generator = new ReflectionConfigGenerator(
          allDeclaredConstructors,
          allDeclaredMethods,
          allDeclaredFields);

      generator.generate(classes, outputFile, mergeWithExisting);

      getLog().info("Successfully generated reflection configuration at: " + outputFile);

    } catch (IOException e) {
      throw new MojoExecutionException("Failed to generate GraalVM metadata", e);
    }
  }
}
