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
package io.fabric8.bom.plugin;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DefaultArtifact;
import org.apache.maven.artifact.handler.DefaultArtifactHandler;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactResolutionRequest;
import org.apache.maven.artifact.resolver.ArtifactResolutionResult;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Build;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.DependencyManagement;
import org.apache.maven.model.Developer;
import org.apache.maven.model.DistributionManagement;
import org.apache.maven.model.License;
import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.Profile;
import org.apache.maven.model.Scm;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Maven Mojo to generate BOM (Bill of Materials) POM files.
 *
 * <p>
 * This plugin generates BOMs from the reactor projects, filtering modules based on
 * include/exclude patterns and optionally including transitive dependencies.
 * It also copies release plugins from a specified profile.
 * </p>
 *
 * <p>
 * This plugin consolidates the functionality of sundrio-maven-plugin's generate-bom goal
 * and the bom-manipulator-plugin's copy-plugins goal.
 * </p>
 */
@Mojo(name = "generate-boms", defaultPhase = LifecyclePhase.VALIDATE, threadSafe = true)
public class GenerateBomsMojo extends AbstractMojo {

  @Parameter(defaultValue = "${project}", required = true, readonly = true)
  private MavenProject project;

  @Parameter(defaultValue = "${session}", required = true, readonly = true)
  private MavenSession session;

  @Component
  private ArtifactResolver artifactResolver;

  @Parameter(defaultValue = "${project.remoteArtifactRepositories}", readonly = true)
  private List<ArtifactRepository> remoteRepositories;

  /**
   * List of BOM configurations to generate.
   */
  @Parameter
  private List<BomConfig> boms;

  /**
   * The profile ID from which to copy plugins.
   */
  @Parameter(property = "bom.sourceProfileId", defaultValue = "release")
  private String sourceProfileId;

  /**
   * Output directory for generated BOMs.
   */
  @Parameter(property = "bom.outputDirectory", defaultValue = "${project.build.outputDirectory}")
  private File outputDirectory;

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    // Skip execution on child modules - only run on the execution root
    if (!isExecutionRoot()) {
      getLog().debug("Skipping plugin execution on child module: " + project.getArtifactId());
      return;
    }

    if (boms == null || boms.isEmpty()) {
      getLog().warn("No BOM configurations provided. Skipping.");
      return;
    }

    try {
      final Model parentModel = readParentModel();
      final List<MavenProject> reactorProjects = session.getProjects();

      getLog().info("Generating " + boms.size() + " BOM(s) from " + reactorProjects.size() + " reactor projects");

      for (final BomConfig bomConfig : boms) {
        generateBom(bomConfig, parentModel, reactorProjects);
      }

    } catch (IOException e) {
      throw new MojoExecutionException("I/O error while generating BOMs", e);
    } catch (XmlPullParserException e) {
      throw new MojoExecutionException("XML parsing error", e);
    }
  }

  private boolean isExecutionRoot() {
    final String executionRootDir = session.getExecutionRootDirectory();
    final String projectDir = project.getBasedir().getAbsolutePath();
    return executionRootDir.equals(projectDir);
  }

  private Model readParentModel() throws IOException, XmlPullParserException {
    final File parentPomFile = new File(session.getExecutionRootDirectory(), "pom.xml");
    final MavenXpp3Reader reader = new MavenXpp3Reader();
    try (FileReader fileReader = new FileReader(parentPomFile)) {
      return reader.read(fileReader);
    }
  }

  private void generateBom(BomConfig bomConfig, Model parentModel, List<MavenProject> reactorProjects)
      throws IOException {

    getLog().info("Generating BOM: " + bomConfig.getArtifactId());

    // Create the BOM model
    final Model bomModel = createBomModel(bomConfig, parentModel);

    // Collect and filter module dependencies
    final List<Dependency> moduleDependencies = collectModuleDependencies(reactorProjects, bomConfig);
    getLog().info("  - Found " + moduleDependencies.size() + " module dependencies");

    // Collect transitive dependencies if include patterns are specified
    final List<Dependency> transitiveDependencies = collectTransitiveDependencies(reactorProjects, bomConfig, parentModel);
    if (!transitiveDependencies.isEmpty()) {
      getLog().info("  - Found " + transitiveDependencies.size() + " transitive dependencies");
    }

    // Combine dependencies - module deps first, then transitive deps
    // TODO: Remove duplicates in a subsequent PR once output compatibility with sundrio is verified.
    //       Currently, duplicates are intentionally kept to match sundrio's exact output for comparison.
    //       To remove duplicates:
    //       1. Use a LinkedHashMap<String, Dependency> keyed by groupId:artifactId[:type][:classifier]
    //       2. Only add each dependency once (first occurrence wins)
    //       3. This will eliminate the duplicate entries for reactor modules that appear in both
    //          module dependencies and transitive dependencies (when they match include patterns)
    //       Note: Duplicates in BOMs are technically allowed but wasteful; Maven uses the first match.
    final List<Dependency> allDependencies = new ArrayList<>();
    allDependencies.addAll(moduleDependencies);
    allDependencies.addAll(transitiveDependencies);

    // Set dependency management
    final DependencyManagement depMgmt = new DependencyManagement();
    depMgmt.setDependencies(allDependencies);
    bomModel.setDependencyManagement(depMgmt);

    // Collect and add plugins from release profile
    final List<Plugin> plugins = collectPluginsFromProfile(parentModel);
    if (!plugins.isEmpty()) {
      final Build build = new Build();
      build.setPlugins(plugins);
      bomModel.setBuild(build);
    }

    // Write the BOM
    final File bomDir = new File(outputDirectory, bomConfig.getArtifactId());
    bomDir.mkdirs();
    final File bomFile = new File(bomDir, "pom.xml");
    writeBomModel(bomFile, bomModel);

    getLog().info("  - Generated: " + bomFile.getAbsolutePath());
  }

  private Model createBomModel(BomConfig bomConfig, Model parentModel) {
    final Model bom = new Model();
    bom.setModelVersion("4.0.0");
    bom.setGroupId(parentModel.getGroupId());
    bom.setArtifactId(bomConfig.getArtifactId());
    bom.setVersion(parentModel.getVersion());
    bom.setPackaging("pom");
    bom.setName(bomConfig.getName());
    bom.setDescription("Generated Bom");
    bom.setUrl(parentModel.getUrl());

    // Copy licenses
    if (parentModel.getLicenses() != null) {
      for (final License license : parentModel.getLicenses()) {
        final License bomLicense = new License();
        bomLicense.setName(license.getName());
        bomLicense.setUrl(license.getUrl());
        bomLicense.setDistribution(license.getDistribution());
        bom.addLicense(bomLicense);
      }
    }

    // Copy developers
    if (parentModel.getDevelopers() != null) {
      for (final Developer dev : parentModel.getDevelopers()) {
        final Developer bomDev = new Developer();
        bomDev.setId(dev.getId());
        bomDev.setName(dev.getName());
        bomDev.setOrganization(dev.getOrganization());
        bomDev.setOrganizationUrl(dev.getOrganizationUrl());
        bom.addDeveloper(bomDev);
      }
    }

    // Copy SCM
    if (parentModel.getScm() != null) {
      final Scm scm = new Scm();
      scm.setConnection(parentModel.getScm().getConnection());
      scm.setDeveloperConnection(parentModel.getScm().getDeveloperConnection());
      // Resolve tag property
      String tag = parentModel.getScm().getTag();
      if (tag != null && tag.contains("${")) {
        tag = resolveProperties(tag, parentModel.getProperties());
        if (tag.contains("${")) {
          tag = parentModel.getVersion();
        }
      }
      scm.setTag(tag);
      scm.setUrl(parentModel.getScm().getUrl());
      bom.setScm(scm);
    }

    // Copy distribution management
    if (parentModel.getDistributionManagement() != null) {
      final DistributionManagement dm = new DistributionManagement();
      if (parentModel.getDistributionManagement().getSnapshotRepository() != null) {
        final org.apache.maven.model.DeploymentRepository sr = new org.apache.maven.model.DeploymentRepository();
        sr.setId(parentModel.getDistributionManagement().getSnapshotRepository().getId());
        sr.setName(parentModel.getDistributionManagement().getSnapshotRepository().getName());
        sr.setUrl(parentModel.getDistributionManagement().getSnapshotRepository().getUrl());
        dm.setSnapshotRepository(sr);
      }
      if (parentModel.getDistributionManagement().getRepository() != null) {
        final org.apache.maven.model.DeploymentRepository r = new org.apache.maven.model.DeploymentRepository();
        r.setId(parentModel.getDistributionManagement().getRepository().getId());
        r.setName(parentModel.getDistributionManagement().getRepository().getName());
        r.setUrl(parentModel.getDistributionManagement().getRepository().getUrl());
        dm.setRepository(r);
      }
      bom.setDistributionManagement(dm);
    }

    return bom;
  }

  private List<Dependency> collectModuleDependencies(List<MavenProject> reactorProjects, BomConfig bomConfig) {
    final List<Dependency> dependencies = new ArrayList<>();

    for (final MavenProject reactorProject : reactorProjects) {
      // Skip the parent project itself
      if (reactorProject.equals(project)) {
        continue;
      }

      // Skip pom-packaged modules (aggregator parents) - they don't produce deployable artifacts
      if ("pom".equals(reactorProject.getPackaging())) {
        continue;
      }

      final String coords = reactorProject.getGroupId() + ":" + reactorProject.getArtifactId();

      // Check exclusion patterns
      if (matchesAnyPattern(coords, bomConfig.getModules().getExcludes())) {
        continue;
      }

      // Check inclusion patterns (if specified, only include matching)
      if (!bomConfig.getModules().getIncludes().isEmpty() &&
          !matchesAnyPattern(coords, bomConfig.getModules().getIncludes())) {
        continue;
      }

      final Dependency dep = new Dependency();
      dep.setGroupId(reactorProject.getGroupId());
      dep.setArtifactId(reactorProject.getArtifactId());
      dep.setVersion(reactorProject.getVersion());

      // Set type for maven-plugin packaging
      if ("maven-plugin".equals(reactorProject.getPackaging())) {
        dep.setType("maven-plugin");
      }

      dependencies.add(dep);
    }

    return dependencies;
  }

  /**
   * Collects transitive dependencies matching the include patterns.
   * This replicates sundrio's algorithm for proper ordering:
   * 1. Collect dependencies from all projects in topological order
   * 2. Separate test vs non-test dependencies
   * 3. Resolve both transitively
   * 4. Mark test-only transitives with test scope
   * 5. Filter by include patterns
   */
  private List<Dependency> collectTransitiveDependencies(List<MavenProject> reactorProjects,
      BomConfig bomConfig, Model parentModel) {

    final List<String> includePatterns = bomConfig.getDependencies().getIncludes();
    if (includePatterns.isEmpty()) {
      return Collections.emptyList();
    }

    // Collect all project dependencies from topologically sorted projects
    // This matches sundrio's getProjectDependencies() method
    List<MavenProject> sortedProjects;
    try {
      sortedProjects = session.getProjectDependencyGraph().getSortedProjects();
    } catch (Exception e) {
      // Fallback to reactor order if dependency graph is not available
      sortedProjects = reactorProjects;
    }

    final Set<Artifact> projectDependencies = new LinkedHashSet<>();
    for (final MavenProject p : sortedProjects) {
      if (p.getDependencies() != null) {
        for (final Dependency dep : p.getDependencies()) {
          projectDependencies.add(toArtifact(dep));
        }
      }
    }

    // Separate test vs non-test dependencies (like sundrio's getDependencies method)
    final Set<Artifact> testDependencies = new LinkedHashSet<>();
    final Set<Artifact> nonTestDependencies = new LinkedHashSet<>();
    for (final Artifact artifact : projectDependencies) {
      if (Artifact.SCOPE_TEST.equals(artifact.getScope())) {
        testDependencies.add(artifact);
      } else {
        nonTestDependencies.add(artifact);
      }
    }

    // Resolve both separately
    final Set<Artifact> testTransitives = resolveTransitively(testDependencies);
    final Set<Artifact> nonTestTransitives = resolveTransitively(nonTestDependencies);

    // Combine: start with project dependencies, add test-only transitives with test scope,
    // then add all resolved dependencies
    final Set<Artifact> allDependencies = new LinkedHashSet<>(projectDependencies);

    // Find test-only transitives (in test but not in non-test)
    final Set<String> nonTestKeys = nonTestTransitives.stream()
        .map(a -> a.getGroupId() + ":" + a.getArtifactId())
        .collect(Collectors.toCollection(LinkedHashSet::new));

    for (final Artifact testArtifact : testTransitives) {
      final String key = testArtifact.getGroupId() + ":" + testArtifact.getArtifactId();
      if (!nonTestKeys.contains(key)) {
        // This is a test-only transitive, add with test scope
        final Artifact testScopedArtifact = new DefaultArtifact(
            testArtifact.getGroupId(), testArtifact.getArtifactId(), testArtifact.getVersion(),
            Artifact.SCOPE_TEST, testArtifact.getType(), testArtifact.getClassifier(),
            testArtifact.getArtifactHandler());
        allDependencies.add(testScopedArtifact);
      }
    }

    // Add all resolved project dependencies
    allDependencies.addAll(resolveTransitively(projectDependencies));

    // Filter artifacts based on include patterns
    // Note: We DON'T exclude reactor modules here, as sundrio includes them if they match
    // the dependency filter patterns. This may result in duplicates which is expected.
    // TODO: In a future PR, consider removing duplicates once we've verified output compatibility.
    //       This can be done by tracking seen keys and skipping duplicates in the final output.
    //       For now, we keep duplicates to match sundrio's exact output for verification.
    final List<Dependency> transitiveDeps = new ArrayList<>();
    final Set<String> seenKeys = new LinkedHashSet<>();

    for (final Artifact artifact : allDependencies) {
      // Skip POM artifacts
      if ("pom".equals(artifact.getType())) {
        continue;
      }

      final String coords = artifact.getGroupId() + ":" + artifact.getArtifactId();

      // Check if matches include patterns
      if (matchesAnyPattern(coords, includePatterns)) {
        final String key = artifactKey(artifact);

        if (seenKeys.add(key)) {
          transitiveDeps.add(artifactToDependency(artifact));
        }
      }
    }

    // Also collect from parent model's dependencyManagement (but skip BOM imports)
    // This catches dependencies that may not be in the reactor but are declared
    if (parentModel.getDependencyManagement() != null &&
        parentModel.getDependencyManagement().getDependencies() != null) {
      for (final Dependency dep : parentModel.getDependencyManagement().getDependencies()) {
        // Skip BOM imports (type=pom, scope=import)
        if ("pom".equals(dep.getType()) && "import".equals(dep.getScope())) {
          continue;
        }

        final String coords = dep.getGroupId() + ":" + dep.getArtifactId();

        if (matchesAnyPattern(coords, includePatterns)) {
          final String key = dependencyKey(dep);

          if (seenKeys.add(key)) {
            // Resolve version properties if needed
            final Dependency bomDep = cloneDependencyWithResolvedVersion(dep, parentModel);
            transitiveDeps.add(bomDep);
          }
        }
      }
    }

    return transitiveDeps;
  }

  /**
   * Converts an Artifact to a Dependency for BOM output.
   */
  private Dependency artifactToDependency(Artifact artifact) {
    final Dependency dep = new Dependency();
    dep.setGroupId(artifact.getGroupId());
    dep.setArtifactId(artifact.getArtifactId());
    dep.setVersion(artifact.getVersion());

    if (artifact.getScope() != null && !"compile".equals(artifact.getScope())) {
      dep.setScope(artifact.getScope());
    }
    if (artifact.getType() != null && !"jar".equals(artifact.getType())) {
      dep.setType(artifact.getType());
    }
    if (artifact.getClassifier() != null) {
      dep.setClassifier(artifact.getClassifier());
    }

    return dep;
  }

  /**
   * Clones a dependency and resolves its version properties.
   */
  private Dependency cloneDependencyWithResolvedVersion(Dependency source, Model parentModel) {
    final Dependency dep = new Dependency();
    dep.setGroupId(source.getGroupId());
    dep.setArtifactId(source.getArtifactId());

    String version = source.getVersion();
    if (version != null && version.contains("${")) {
      version = resolveProperties(version, parentModel.getProperties(), parentModel.getVersion());
    }
    dep.setVersion(version);

    if (source.getScope() != null && !"compile".equals(source.getScope())) {
      dep.setScope(source.getScope());
    }
    if (source.getType() != null && !"jar".equals(source.getType())) {
      dep.setType(source.getType());
    }
    if (source.getClassifier() != null) {
      dep.setClassifier(source.getClassifier());
    }

    return dep;
  }

  /**
   * Convert a Dependency to an Artifact for resolution.
   */
  private Artifact toArtifact(Dependency dependency) {
    final String type = dependency.getType() != null && !dependency.getType().isEmpty()
        ? dependency.getType()
        : "jar";

    final DefaultArtifactHandler handler = new DefaultArtifactHandler(type);
    handler.setExtension(type);
    handler.setAddedToClasspath(!"provided".equals(dependency.getScope()));

    return new DefaultArtifact(
        dependency.getGroupId(),
        dependency.getArtifactId(),
        dependency.getVersion(),
        dependency.getScope(),
        type,
        dependency.getClassifier(),
        handler);
  }

  /**
   * Resolve dependencies transitively using Maven's ArtifactResolver.
   */
  private Set<Artifact> resolveTransitively(Set<Artifact> dependencies) {
    if (dependencies == null || dependencies.isEmpty()) {
      return new LinkedHashSet<>();
    }

    final ArtifactResolutionRequest request = new ArtifactResolutionRequest();
    request.setArtifact(project.getArtifact());
    request.setArtifactDependencies(dependencies);
    request.setLocalRepository(session.getLocalRepository());
    request.setRemoteRepositories(remoteRepositories);
    request.setManagedVersionMap(project.getManagedVersionMap());
    request.setResolveTransitively(true);

    final ArtifactResolutionResult result = artifactResolver.resolve(request);
    return result.getArtifacts() != null ? result.getArtifacts() : new LinkedHashSet<>();
  }

  private String artifactKey(Artifact artifact) {
    return artifact.getGroupId() + ":" + artifact.getArtifactId() +
        (artifact.getType() != null && !"jar".equals(artifact.getType()) ? ":" + artifact.getType() : "") +
        (artifact.getClassifier() != null ? ":" + artifact.getClassifier() : "");
  }

  private String dependencyKey(Dependency dep) {
    return dep.getGroupId() + ":" + dep.getArtifactId() +
        (dep.getType() != null && !"jar".equals(dep.getType()) ? ":" + dep.getType() : "") +
        (dep.getClassifier() != null ? ":" + dep.getClassifier() : "");
  }

  private boolean matchesAnyPattern(String coords, List<String> patterns) {
    if (patterns == null || patterns.isEmpty()) {
      return false;
    }
    return patterns.stream().anyMatch(pattern -> matchesPattern(coords, pattern));
  }

  private boolean matchesPattern(String coords, String pattern) {
    // Convert glob pattern to regex
    // Patterns are in the format groupId:artifactId with * wildcards
    final String regex = pattern
        .replace(".", "\\.")
        .replace("*", ".*")
        .replace("?", ".");

    return Pattern.matches(regex, coords);
  }

  /**
   * Collects plugins from the specified profile and resolves their properties.
   */
  private List<Plugin> collectPluginsFromProfile(Model parentModel) {
    final Profile profile = findProfile(parentModel, sourceProfileId);

    if (profile == null) {
      getLog().warn("Profile '" + sourceProfileId + "' not found. Skipping plugin copy.");
      return Collections.emptyList();
    }

    if (profile.getBuild() == null || profile.getBuild().getPlugins() == null) {
      return Collections.emptyList();
    }

    final List<Plugin> pluginsToCopy = profile.getBuild().getPlugins();
    if (pluginsToCopy.isEmpty()) {
      return Collections.emptyList();
    }

    final Properties properties = parentModel.getProperties();

    return pluginsToCopy.stream()
        .map(plugin -> cloneAndResolvePlugin(plugin, properties))
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
  }

  private Profile findProfile(Model model, String profileId) {
    if (model.getProfiles() == null) {
      return null;
    }

    return model.getProfiles().stream()
        .filter(p -> profileId.equals(p.getId()))
        .findFirst()
        .orElse(null);
  }

  private Plugin cloneAndResolvePlugin(Plugin source, Properties properties) {
    final Plugin clone = source.clone();

    // Skip plugin if no groupId is present
    if (clone.getGroupId() == null || clone.getGroupId().isEmpty()) {
      return null;
    }

    // Resolve version properties
    if (clone.getVersion() != null) {
      clone.setVersion(resolveProperties(clone.getVersion(), properties));
    }

    // Skip plugin if no version is present after property resolution
    if (clone.getVersion() == null || clone.getVersion().isEmpty()) {
      return null;
    }

    // Resolve configuration
    if (clone.getConfiguration() != null) {
      clone.setConfiguration(resolveXpp3Dom((Xpp3Dom) clone.getConfiguration(), properties));
    }

    // Resolve executions
    if (clone.getExecutions() != null) {
      clone.getExecutions().forEach(execution -> {
        if (execution.getConfiguration() != null) {
          execution.setConfiguration(resolveXpp3Dom((Xpp3Dom) execution.getConfiguration(), properties));
        }
      });
    }

    return clone;
  }

  private Xpp3Dom resolveXpp3Dom(Xpp3Dom dom, Properties properties) {
    if (dom == null) {
      return null;
    }

    final Xpp3Dom resolved = new Xpp3Dom(dom.getName());

    // Copy and resolve attributes
    final String[] attrNames = dom.getAttributeNames();
    if (attrNames != null) {
      for (final String attrName : attrNames) {
        final String attrValue = dom.getAttribute(attrName);
        resolved.setAttribute(attrName, resolveProperties(attrValue, properties));
      }
    }

    // Resolve value
    final String value = dom.getValue();
    if (value != null && !value.isEmpty()) {
      resolved.setValue(resolveProperties(value, properties));
    }

    // Resolve children recursively
    final Xpp3Dom[] children = dom.getChildren();
    if (children != null) {
      for (final Xpp3Dom child : children) {
        resolved.addChild(resolveXpp3Dom(child, properties));
      }
    }

    return resolved;
  }

  private String resolveProperties(String value, Properties properties) {
    return resolveProperties(value, properties, null);
  }

  private String resolveProperties(String value, Properties properties, String projectVersion) {
    if (value == null || !value.contains("${")) {
      return value;
    }

    String result = value;

    // Handle special ${project.version} placeholder
    if (projectVersion != null && result.contains("${project.version}")) {
      result = result.replace("${project.version}", projectVersion);
    }

    for (final String propName : properties.stringPropertyNames()) {
      final String placeholder = "${" + propName + "}";
      if (result.contains(placeholder)) {
        final String propValue = properties.getProperty(propName);
        result = result.replace(placeholder, propValue != null ? propValue : placeholder);
      }
    }

    return result;
  }

  private void writeBomModel(File bomPomFile, Model model) throws IOException {
    final MavenXpp3Writer writer = new MavenXpp3Writer();
    try (FileWriter fileWriter = new FileWriter(bomPomFile)) {
      writer.write(fileWriter, model);
    }
  }
}
