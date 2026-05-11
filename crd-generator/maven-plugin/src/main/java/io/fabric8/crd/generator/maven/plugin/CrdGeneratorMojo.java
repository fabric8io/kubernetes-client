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
package io.fabric8.crd.generator.maven.plugin;

import io.fabric8.crd.generator.collector.CustomResourceCollector;
import io.fabric8.crdv2.generator.CRDGenerationInfo;
import io.fabric8.crdv2.generator.CRDGenerator;
import io.fabric8.kubernetes.api.model.HasMetadata;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.descriptor.PluginDescriptor;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.apache.maven.toolchain.Toolchain;
import org.apache.maven.toolchain.ToolchainManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;

import static java.util.Optional.ofNullable;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.PROCESS_CLASSES, requiresDependencyCollection = ResolutionScope.COMPILE_PLUS_RUNTIME, requiresDependencyResolution = ResolutionScope.COMPILE_PLUS_RUNTIME, threadSafe = true)
public class CrdGeneratorMojo extends AbstractMojo {

  @Parameter(defaultValue = "${project}", required = true, readonly = true)
  MavenProject mavenProject;

  @Parameter(defaultValue = "${session}", required = true, readonly = true)
  MavenSession session;

  @Parameter(defaultValue = "${plugin}", readonly = true)
  PluginDescriptor pluginDescriptor;

  /**
   * The input directory to be used to scan for Custom Resource classes
   */
  @Parameter(property = "fabric8.crd-generator.classesToScan", defaultValue = "${project.build.outputDirectory}", readonly = true)
  File classesToScan;

  /**
   * Custom Resource classes, which should be considered to generate the CRDs.
   * If set, scanning is disabled.
   */
  @Parameter(property = "fabric8.crd-generator.customResourceClasses")
  List<String> customResourceClasses = new LinkedList<>();

  /**
   * Dependencies which should be scanned for Custom Resources.
   */
  @Parameter(property = "fabric8.crd-generator.dependenciesToScan")
  List<Dependency> dependenciesToScan = new LinkedList<>();

  /**
   * Inclusions, used to filter Custom Resource classes after scanning.
   */
  @Parameter(property = "fabric8.crd-generator.inclusions")
  FilterSet inclusions = new FilterSet();

  /**
   * Exclusions, used to filter Custom Resource classes after scanning.
   */
  @Parameter(property = "fabric8.crd-generator.exclusions")
  FilterSet exclusions = new FilterSet();

  /**
   * The classpath which should be used during the CRD generation.
   * <br>
   * Choice of:
   * <ul>
   * <li>{@code PROJECT_ONLY}: Only classes in the project.</li>
   * <li>{@code WITH_RUNTIME_DEPENDENCIES}: Classes from the project and any runtime dependencies.</li>
   * <li>{@code WITH_COMPILE_DEPENDENCIES}: Classes from the project and any compile time dependencies.</li>
   * <li>{@code WITH_ALL_DEPENDENCIES}: Classes from the project, compile time and runtime dependencies.</li>
   * <li>{@code WITH_ALL_DEPENDENCIES_AND_TESTS}: Classes from the project (including tests), compile time, runtime and test
   * dependencies.</li>
   * </ul>
   */
  @Parameter(property = "fabric8.crd-generator.classpath", defaultValue = "WITH_RUNTIME_DEPENDENCIES")
  ClasspathType classpath;

  /**
   * The output directory where the CRDs are emitted.
   */
  @Parameter(property = "fabric8.crd-generator.outputDirectory", defaultValue = "${project.build.outputDirectory}/META-INF/fabric8/")
  File outputDirectory;

  /**
   * If {@code true}, a Jandex index will be created even if the directory or JAR file contains an existing index.
   */
  @Parameter(property = "fabric8.crd-generator.forceIndex", defaultValue = "false")
  boolean forceIndex;

  /**
   * If {@code true}, directories and JAR files are scanned even if Custom Resource classes are given.
   */
  @Parameter(property = "fabric8.crd-generator.forceScan", defaultValue = "false")
  boolean forceScan;

  /**
   * If {@code true}, the CRDs will be generated in parallel.
   */
  @Parameter(property = "fabric8.crd-generator.parallel", defaultValue = "true")
  boolean parallel;

  /**
   * If {@code true}, {@code x-kubernetes-preserve-unknown-fields: true} will be added on objects
   * which contain an any-setter or any-getter.
   */
  @Parameter(property = "fabric8.crd-generator.implicitPreserveUnknownFields", defaultValue = "false")
  boolean implicitPreserveUnknownFields;

  /**
   * If {@code true}, execution will be skipped.
   */
  @Parameter(property = "fabric8.crd-generator.skip", defaultValue = "false")
  boolean skip;

  /**
   * If {@code true}, quotes will only be included where necessary
   */
  @Parameter(property = "fabric8.crd-generator.minimizeQuotes", defaultValue = "false")
  boolean minimizeQuotes;

  /**
   * Path to the Java executable used to run CRD generation in a forked process.
   * If not set, the JDK toolchain will be used if configured via {@code maven-toolchains-plugin}.
   * If neither is configured, CRD generation runs in-process within the current JVM.
   * <p>
   * Forking is required when the project is compiled with a newer JDK than the one running Maven.
   * For example, if Maven runs on JDK 11 but the project is compiled with JDK 17, the in-process
   * classloader cannot load class files compiled for JDK 17 and will throw
   * {@code UnsupportedClassVersionError}.
   * </p>
   */
  @Parameter(property = "fabric8.crd-generator.javaExecutable")
  String javaExecutable;

  private final ToolchainManager toolchainManager;
  private final CustomResourceCollector customResourceCollector;
  private final CRDGenerator crdGenerator;

  @Inject
  public CrdGeneratorMojo(ToolchainManager toolchainManager) {
    this(toolchainManager, null, null);
  }

  CrdGeneratorMojo(ToolchainManager toolchainManager, CustomResourceCollector customResourceCollector,
      CRDGenerator crdGenerator) {
    this.toolchainManager = toolchainManager;
    this.customResourceCollector = ofNullable(customResourceCollector)
        .orElseGet(CustomResourceCollector::new);
    this.crdGenerator = ofNullable(crdGenerator)
        .orElseGet(CRDGenerator::new);
  }

  @Override
  public void execute() throws MojoExecutionException {
    if (skip) {
      getLog().info("CRD-Generator execution skipped");
      return;
    }

    String resolvedJavaExecutable = resolveJavaExecutable();
    if (resolvedJavaExecutable != null) {
      executeForked(resolvedJavaExecutable);
      return;
    }

    List<File> filesToScan = new LinkedList<>();
    if (classesToScan.exists()) {
      filesToScan.add(classesToScan);
    }
    filesToScan.addAll(getDependencyArchives());

    customResourceCollector
        .withParentClassLoader(Thread.currentThread().getContextClassLoader())
        .withClasspathElements(classpath.getClasspathElements(mavenProject))
        .withFilesToScan(filesToScan)
        .withForceIndex(forceIndex)
        .withForceScan(forceScan)
        .withIncludePackages(inclusions.getPackages())
        .withExcludePackages(exclusions.getPackages())
        .withCustomResourceClasses(customResourceClasses);

    List<Class<? extends HasMetadata>> customResourceClassesLoaded = customResourceCollector.findCustomResourceClasses();

    try {
      Files.createDirectories(outputDirectory.toPath());
    } catch (IOException e) {
      throw new MojoExecutionException("Could not create output directory: " + e.getMessage());
    }

    crdGenerator
        .customResourceClasses(customResourceClassesLoaded)
        .withParallelGenerationEnabled(parallel)
        .withImplicitPreserveUnknownFields(implicitPreserveUnknownFields)
        .withMinQuotes(minimizeQuotes)
        .inOutputDir(outputDirectory);

    CRDGenerationInfo crdGenerationInfo = crdGenerator.detailedGenerate();
    crdGenerationInfo.getCRDDetailsPerNameAndVersion().forEach((crdName, versionToInfo) -> {
      getLog().info("Generated CRD " + crdName + ":");
      versionToInfo.forEach(
          (version, info) -> getLog().info(" " + version + " -> " + info.getFilePath()));
    });
  }

  /**
   * Returns the Java executable to use for forked CRD generation, or {@code null} if the
   * generation should run in-process.
   * <p>
   * Resolution order:
   * <ol>
   * <li>Explicit {@code javaExecutable} parameter</li>
   * <li>JDK toolchain configured via {@code maven-toolchains-plugin}</li>
   * <li>{@code null} — run in-process (default behaviour)</li>
   * </ol>
   * </p>
   */
  String resolveJavaExecutable() {
    if (javaExecutable != null) {
      return javaExecutable;
    }
    if (toolchainManager != null) {
      Toolchain tc = toolchainManager.getToolchainFromBuildContext("jdk", session);
      if (tc != null) {
        String java = tc.findTool("java");
        if (java != null) {
          getLog().info("CRD-Generator: using toolchain JDK java executable: " + java);
          return java;
        }
      }
    }
    return null;
  }

  /**
   * Forks the CRD generation into a separate JVM process using the given Java executable.
   * The forked process runs {@code CRDGeneratorCLI} with the same parameters as the mojo.
   */
  private void executeForked(String javaExe) throws MojoExecutionException {
    List<String> cmd = new ArrayList<>();
    cmd.add(javaExe);

    // Build the forked JVM classpath from the plugin's own class realm (includes crd-generator-cli,
    // picocli, crd-generator-api-v2, crd-generator-collector and their transitive dependencies).
    List<String> pluginClasspath = new ArrayList<>();
    for (URL url : pluginDescriptor.getClassRealm().getURLs()) {
      try {
        pluginClasspath.add(Paths.get(url.toURI()).toAbsolutePath().toString());
      } catch (URISyntaxException | IllegalArgumentException e) {
        pluginClasspath.add(new File(url.getFile()).getAbsolutePath());
      }
    }
    cmd.add("-cp");
    cmd.add(String.join(File.pathSeparator, pluginClasspath));
    cmd.add("io.fabric8.crd.generator.cli.CRDGeneratorCLI");

    // Output directory
    try {
      Files.createDirectories(outputDirectory.toPath());
    } catch (IOException e) {
      throw new MojoExecutionException("Could not create output directory: " + e.getMessage());
    }
    cmd.add("--output-dir");
    cmd.add(outputDirectory.getAbsolutePath());

    // Project classpath (passed to the CLI so it can load the user's custom resource classes)
    for (String cpElement : classpath.getClasspathElements(mavenProject)) {
      cmd.add("--classpath");
      cmd.add(cpElement);
    }

    // Options
    if (forceIndex) {
      cmd.add("--force-index");
    }
    if (forceScan) {
      cmd.add("--force-scan");
    }
    if (!parallel) {
      cmd.add("--no-parallel");
    }
    if (implicitPreserveUnknownFields) {
      cmd.add("--implicit-preserve-unknown-fields");
    }
    if (minimizeQuotes) {
      cmd.add("--min-quotes");
    }
    if (inclusions.getPackages() != null) {
      for (String pkg : inclusions.getPackages()) {
        cmd.add("--include-package");
        cmd.add(pkg);
      }
    }
    if (exclusions.getPackages() != null) {
      for (String pkg : exclusions.getPackages()) {
        cmd.add("--exclude-package");
        cmd.add(pkg);
      }
    }

    // Sources (positional parameters): directories/JARs to scan and explicit class names
    List<File> dependencyArchives = getDependencyArchives();
    if (!classesToScan.exists() && dependencyArchives.isEmpty() && customResourceClasses.isEmpty()) {
      getLog().warn("CRD-Generator: no sources to scan, skipping forked generation");
      return;
    }
    if (classesToScan.exists()) {
      cmd.add(classesToScan.getAbsolutePath());
    }
    for (File archive : dependencyArchives) {
      cmd.add(archive.getAbsolutePath());
    }
    cmd.addAll(customResourceClasses);

    getLog().debug("CRD-Generator forked command: " + String.join(" ", cmd));

    try {
      ProcessBuilder pb = new ProcessBuilder(cmd);
      pb.redirectErrorStream(true);
      Process process = pb.start();
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
        String line;
        while ((line = reader.readLine()) != null) {
          getLog().info(line);
        }
      }
      int exitCode = process.waitFor();
      if (exitCode != 0) {
        throw new MojoExecutionException("Forked CRD generation failed with exit code " + exitCode);
      }
    } catch (IOException e) {
      throw new MojoExecutionException("Failed to start forked CRD generator process: " + e.getMessage(), e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new MojoExecutionException("Forked CRD generation was interrupted", e);
    }
  }

  /**
   * Returns a list of archive files derived from the given dependencies.
   *
   * @return the archive files
   */
  private List<File> getDependencyArchives() {
    return dependenciesToScan.stream()
        .map(this::getDependencyArchive)
        .flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty))
        .collect(Collectors.toList());
  }

  private Optional<File> getDependencyArchive(Dependency dependency) {
    for (Artifact artifact : mavenProject.getArtifacts()) {
      if (artifact.getGroupId().equals(dependency.getGroupId())
          && artifact.getArtifactId().equals(dependency.getArtifactId())
          && (dependency.getClassifier() == null || artifact.getClassifier()
              .equals(dependency.getClassifier()))) {
        File jarFile = artifact.getFile();
        if (jarFile == null) {
          getLog().warn(
              "Skip scanning dependency, artifact file does not exist for dependency: " + dependency);
          return Optional.empty();
        }

        return Optional.of(jarFile);
      }
    }
    getLog().warn("Skip scanning dependency, artifact for dependency not found: " + dependency);
    return Optional.empty();
  }

}
