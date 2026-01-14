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

import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Build;
import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.Profile;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
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
import java.util.List;
import java.util.Properties;

/**
 * Maven Mojo to copy build plugins from a source profile (typically 'release')
 * to target BOM POM files, resolving all property placeholders.
 *
 * <p>
 * This plugin ensures that generated BOMs contain all necessary release plugins
 * with resolved versions, making them ready for deployment without manual intervention.
 * </p>
 */
@Mojo(name = "copy-plugins", threadSafe = true)
public class CopyPluginsToBomMojo extends AbstractMojo {

  private static final String DEFAULT_MAVEN_PLUGINS_GROUP = "org.apache.maven.plugins";

  @Parameter(defaultValue = "${project}", required = true, readonly = true)
  private MavenProject project;

  @Parameter(defaultValue = "${session}", required = true, readonly = true)
  private MavenSession session;

  /**
   * The parent POM file containing the source profile with plugins to copy.
   */
  @Parameter(property = "bom.parentPomFile", defaultValue = "${maven.multiModuleProjectDirectory}/pom.xml")
  private File parentPomFile;

  /**
   * The profile ID from which to copy plugins.
   */
  @Parameter(property = "bom.sourceProfileId", defaultValue = "release")
  private String sourceProfileId;

  /**
   * List of BOM directories where plugins should be copied.
   * Paths are relative to the parent POM directory.
   */
  @Parameter(property = "bom.bomDirectories")
  private List<String> bomDirectories;

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    // Skip execution on child modules - only run on the execution root
    if (!isExecutionRoot()) {
      getLog().debug("Skipping plugin execution on child module: " + project.getArtifactId());
      return;
    }

    // Skip if no BOM directories configured
    if (bomDirectories == null || bomDirectories.isEmpty()) {
      getLog().debug("No BOM directories configured. Skipping.");
      return;
    }

    validateParameters();

    try {
      Model parentModel = readParentModel();
      List<Plugin> pluginsToCopy = getPluginsFromProfile(parentModel);

      if (pluginsToCopy.isEmpty()) {
        getLog().warn("No plugins found in '" + sourceProfileId + "' profile. Skipping.");
        return;
      }

      getLog().info(String.format("Found %d plugin(s) in '%s' profile", pluginsToCopy.size(), sourceProfileId));

      processBomDirectories(pluginsToCopy, parentModel);

    } catch (IOException e) {
      throw new MojoExecutionException("I/O error while processing BOMs", e);
    } catch (XmlPullParserException e) {
      throw new MojoExecutionException("XML parsing error", e);
    }
  }

  /**
   * Checks if the current project is the execution root.
   * This ensures the plugin only runs on the parent project, not on child modules.
   *
   * @return true if this is the execution root, false otherwise
   */
  private boolean isExecutionRoot() {
    String executionRootDir = session.getExecutionRootDirectory();
    String projectDir = project.getBasedir().getAbsolutePath();
    return executionRootDir.equals(projectDir);
  }

  private void validateParameters() throws MojoFailureException {
    if (!parentPomFile.exists()) {
      throw new MojoFailureException("Parent POM file not found: " + parentPomFile.getAbsolutePath());
    }

    if (!parentPomFile.canRead()) {
      throw new MojoFailureException("Cannot read parent POM file: " + parentPomFile.getAbsolutePath());
    }
  }

  private Model readParentModel() throws IOException, XmlPullParserException {
    MavenXpp3Reader reader = new MavenXpp3Reader();
    try (FileReader fileReader = new FileReader(parentPomFile)) {
      return reader.read(fileReader);
    }
  }

  private List<Plugin> getPluginsFromProfile(Model parentModel) throws MojoExecutionException {
    Profile profile = findProfile(parentModel, sourceProfileId);

    if (profile == null) {
      throw new MojoExecutionException("Profile '" + sourceProfileId + "' not found in " + parentPomFile);
    }

    if (profile.getBuild() == null || profile.getBuild().getPlugins() == null) {
      return new ArrayList<>();
    }

    return new ArrayList<>(profile.getBuild().getPlugins());
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

  private void processBomDirectories(List<Plugin> pluginsToCopy, Model parentModel)
      throws IOException, XmlPullParserException {

    for (String bomDir : bomDirectories) {
      File bomPomFile = resolveBomPomFile(bomDir);

      if (!bomPomFile.exists()) {
        getLog().warn("BOM POM not found, skipping: " + bomPomFile.getAbsolutePath());
        continue;
      }

      processBomFile(bomPomFile, pluginsToCopy, parentModel);
    }
  }

  private File resolveBomPomFile(String bomDir) {
    File baseDir = parentPomFile.getParentFile();
    return new File(baseDir, bomDir + "/pom.xml");
  }

  private void processBomFile(File bomPomFile, List<Plugin> pluginsToCopy, Model parentModel)
      throws IOException, XmlPullParserException {

    Model bomModel = readBomModel(bomPomFile);
    int[] counts = updateBomModel(bomModel, pluginsToCopy, parentModel);
    writeBomModel(bomPomFile, bomModel);

    getLog().info(String.format("BOM updated: %s (added: %d, updated: %d)",
        bomPomFile.getName(), counts[0], counts[1]));
  }

  private Model readBomModel(File bomPomFile) throws IOException, XmlPullParserException {
    MavenXpp3Reader reader = new MavenXpp3Reader();
    try (FileReader fileReader = new FileReader(bomPomFile)) {
      return reader.read(fileReader);
    }
  }

  private int[] updateBomModel(Model bomModel, List<Plugin> pluginsToCopy, Model parentModel) {
    ensureBuildSection(bomModel);

    int added = 0;
    int updated = 0;

    for (Plugin sourcePlugin : pluginsToCopy) {
      Plugin resolvedPlugin = cloneAndResolvePlugin(sourcePlugin, parentModel);

      // Skip plugins that don't have a resolvable version
      if (resolvedPlugin == null) {
        getLog().debug("Skipping plugin " + sourcePlugin.getArtifactId() +
            " - no version found in plugin or pluginManagement");
        continue;
      }

      Plugin existingPlugin = findExistingPlugin(bomModel, resolvedPlugin);

      if (existingPlugin != null) {
        replacePlugin(bomModel, existingPlugin, resolvedPlugin);
        updated++;
      } else {
        bomModel.getBuild().addPlugin(resolvedPlugin);
        added++;
      }
    }

    return new int[] { added, updated };
  }

  private void ensureBuildSection(Model model) {
    if (model.getBuild() == null) {
      model.setBuild(new Build());
    }
    if (model.getBuild().getPlugins() == null) {
      model.getBuild().setPlugins(new ArrayList<>());
    }
  }

  private Plugin findExistingPlugin(Model model, Plugin plugin) {
    if (model.getBuild() == null || model.getBuild().getPlugins() == null) {
      return null;
    }

    String targetGroupId = plugin.getGroupId() != null ? plugin.getGroupId() : DEFAULT_MAVEN_PLUGINS_GROUP;

    return model.getBuild().getPlugins().stream()
        .filter(p -> {
          String groupId = p.getGroupId() != null ? p.getGroupId() : DEFAULT_MAVEN_PLUGINS_GROUP;
          return targetGroupId.equals(groupId) && plugin.getArtifactId().equals(p.getArtifactId());
        })
        .findFirst()
        .orElse(null);
  }

  private void replacePlugin(Model model, Plugin oldPlugin, Plugin newPlugin) {
    int index = model.getBuild().getPlugins().indexOf(oldPlugin);
    if (index >= 0) {
      model.getBuild().getPlugins().set(index, newPlugin);
    }
  }

  private Plugin cloneAndResolvePlugin(Plugin source, Model parentModel) {
    Plugin clone = source.clone();
    Properties properties = parentModel.getProperties();

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

    Xpp3Dom resolved = new Xpp3Dom(dom.getName());

    // Copy and resolve attributes
    String[] attrNames = dom.getAttributeNames();
    if (attrNames != null) {
      for (String attrName : attrNames) {
        String attrValue = dom.getAttribute(attrName);
        resolved.setAttribute(attrName, resolveProperties(attrValue, properties));
      }
    }

    // Resolve value
    String value = dom.getValue();
    if (value != null && !value.isEmpty()) {
      resolved.setValue(resolveProperties(value, properties));
    }

    // Resolve children recursively
    Xpp3Dom[] children = dom.getChildren();
    if (children != null) {
      for (Xpp3Dom child : children) {
        resolved.addChild(resolveXpp3Dom(child, properties));
      }
    }

    return resolved;
  }

  /**
   * Resolves Maven property placeholders in a string.
   *
   * @param value the string potentially containing ${property} placeholders
   * @param properties the properties to resolve from
   * @return the resolved string
   */
  private String resolveProperties(String value, Properties properties) {
    if (value == null || !value.contains("${")) {
      return value;
    }

    String result = value;
    for (String propName : properties.stringPropertyNames()) {
      String placeholder = "${" + propName + "}";
      if (result.contains(placeholder)) {
        String propValue = properties.getProperty(propName);
        result = result.replace(placeholder, propValue != null ? propValue : placeholder);
      }
    }

    return result;
  }

  private void writeBomModel(File bomPomFile, Model model) throws IOException {
    MavenXpp3Writer writer = new MavenXpp3Writer();
    try (FileWriter fileWriter = new FileWriter(bomPomFile)) {
      writer.write(fileWriter, model);
    }
  }
}
