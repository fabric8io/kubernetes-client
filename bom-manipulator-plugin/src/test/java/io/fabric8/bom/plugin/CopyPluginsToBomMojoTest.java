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
import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Comprehensive test suite for CopyPluginsToBomMojo.
 */
class CopyPluginsToBomMojoTest {

  @TempDir
  Path tempDir;

  private CopyPluginsToBomMojo mojo;
  private Log mockLog;

  @BeforeEach
  void setUp() {
    mojo = new CopyPluginsToBomMojo();
    mockLog = mock(Log.class);
    MavenProject mockProject = mock(MavenProject.class);
    MavenSession mockSession = mock(MavenSession.class);

    // Mock session and project to make isExecutionRoot() return true
    when(mockSession.getExecutionRootDirectory()).thenReturn(tempDir.toAbsolutePath().toString());
    when(mockProject.getBasedir()).thenReturn(tempDir.toFile());

    setField(mojo, "project", mockProject);
    setField(mojo, "session", mockSession);
    mojo.setLog(mockLog);
  }

  @Test
  void testPropertyResolution() throws Exception {
    // Create parent POM with properties and release profile
    File parentPom = createParentPomWithProperties();

    // Create a BOM POM
    File bomDir = tempDir.resolve("bom").toFile();
    bomDir.mkdirs();
    File bomPom = createBomPom(bomDir);

    // Configure mojo
    setField(mojo, "parentPomFile", parentPom);
    setField(mojo, "sourceProfileId", "release");
    List<String> bomDirs = new ArrayList<>();
    bomDirs.add("bom");
    setField(mojo, "bomDirectories", bomDirs);

    // Execute
    mojo.execute();

    // Verify the BOM was updated with resolved properties
    Model bomModel = readModel(bomPom);
    assertThat(bomModel.getBuild()).isNotNull();
    assertThat(bomModel.getBuild().getPlugins()).isNotEmpty();

    // Find the GPG plugin
    Plugin gpgPlugin = findPlugin(bomModel, "org.apache.maven.plugins", "maven-gpg-plugin");
    assertThat(gpgPlugin).isNotNull();
    assertThat(gpgPlugin.getVersion()).isEqualTo("3.2.8");
  }

  @Test
  void testPluginAddedToBom() throws Exception {
    // Create parent POM with release profile containing plugins
    File parentPom = createParentPomWithPlugins();

    // Create a BOM POM without plugins
    File bomDir = tempDir.resolve("bom").toFile();
    bomDir.mkdirs();
    File bomPom = createBomPom(bomDir);

    // Configure mojo
    setField(mojo, "parentPomFile", parentPom);
    setField(mojo, "sourceProfileId", "release");
    List<String> bomDirs = new ArrayList<>();
    bomDirs.add("bom");
    setField(mojo, "bomDirectories", bomDirs);

    // Execute
    mojo.execute();

    // Verify plugins were added
    Model bomModel = readModel(bomPom);
    assertThat(bomModel.getBuild()).isNotNull();
    assertThat(bomModel.getBuild().getPlugins()).hasSize(2); // GPG + Source plugins

    Plugin gpgPlugin = findPlugin(bomModel, "org.apache.maven.plugins", "maven-gpg-plugin");
    assertThat(gpgPlugin).isNotNull();
    assertThat(gpgPlugin.getVersion()).isEqualTo("3.2.8");

    Plugin sourcePlugin = findPlugin(bomModel, "org.apache.maven.plugins", "maven-source-plugin");
    assertThat(sourcePlugin).isNotNull();
    assertThat(sourcePlugin.getVersion()).isEqualTo("3.3.1");
  }

  @Test
  void testPluginUpdatedInBom() throws Exception {
    // Create parent POM with release profile
    File parentPom = createParentPomWithPlugins();

    // Create a BOM POM with existing plugin (old version)
    File bomDir = tempDir.resolve("bom").toFile();
    bomDir.mkdirs();
    File bomPom = createBomPomWithExistingPlugin(bomDir);

    // Read initial state
    Model initialBomModel = readModel(bomPom);
    Plugin oldPlugin = findPlugin(initialBomModel, "org.apache.maven.plugins", "maven-gpg-plugin");
    assertThat(oldPlugin.getVersion()).isEqualTo("3.0.0"); // Old version

    // Configure mojo
    setField(mojo, "parentPomFile", parentPom);
    setField(mojo, "sourceProfileId", "release");
    List<String> bomDirs = new ArrayList<>();
    bomDirs.add("bom");
    setField(mojo, "bomDirectories", bomDirs);

    // Execute
    mojo.execute();

    // Verify plugin was updated
    Model updatedBomModel = readModel(bomPom);
    Plugin updatedPlugin = findPlugin(updatedBomModel, "org.apache.maven.plugins", "maven-gpg-plugin");
    assertThat(updatedPlugin).isNotNull();
    assertThat(updatedPlugin.getVersion()).isEqualTo("3.2.8"); // Updated version
  }

  @Test
  void testBomDependenciesPreserved() throws Exception {
    // Create parent POM
    File parentPom = createParentPomWithPlugins();

    // Create a BOM POM with dependencies
    File bomDir = tempDir.resolve("bom").toFile();
    bomDir.mkdirs();
    File bomPom = createBomPomWithDependencies(bomDir);

    // Read initial dependencies
    Model initialBomModel = readModel(bomPom);
    int initialDependencyCount = initialBomModel.getDependencyManagement().getDependencies().size();
    assertThat(initialDependencyCount).isEqualTo(3);

    // Configure mojo
    setField(mojo, "parentPomFile", parentPom);
    setField(mojo, "sourceProfileId", "release");
    List<String> bomDirs = new ArrayList<>();
    bomDirs.add("bom");
    setField(mojo, "bomDirectories", bomDirs);

    // Execute
    mojo.execute();

    // Verify dependencies are preserved
    Model updatedBomModel = readModel(bomPom);
    assertThat(updatedBomModel.getDependencyManagement().getDependencies()).hasSize(initialDependencyCount);

    // Verify plugins were added
    assertThat(updatedBomModel.getBuild().getPlugins()).isNotEmpty();
  }

  @Test
  void testMultipleBomDirectories() throws Exception {
    // Create parent POM
    File parentPom = createParentPomWithPlugins();

    // Create two BOM POMs
    File bomDir1 = tempDir.resolve("bom1").toFile();
    bomDir1.mkdirs();
    File bomPom1 = createBomPom(bomDir1);

    File bomDir2 = tempDir.resolve("bom2").toFile();
    bomDir2.mkdirs();
    File bomPom2 = createBomPom(bomDir2);

    // Configure mojo
    setField(mojo, "parentPomFile", parentPom);
    setField(mojo, "sourceProfileId", "release");
    List<String> bomDirs = new ArrayList<>();
    bomDirs.add("bom1");
    bomDirs.add("bom2");
    setField(mojo, "bomDirectories", bomDirs);

    // Execute
    mojo.execute();

    // Verify both BOMs were updated
    Model bomModel1 = readModel(bomPom1);
    assertThat(bomModel1.getBuild().getPlugins()).hasSize(2);

    Model bomModel2 = readModel(bomPom2);
    assertThat(bomModel2.getBuild().getPlugins()).hasSize(2);
  }

  @Test
  void testMissingParentPomThrowsException() {
    File nonExistentPom = tempDir.resolve("nonexistent.xml").toFile();
    setField(mojo, "parentPomFile", nonExistentPom);
    setField(mojo, "bomDirectories", List.of("bom"));

    assertThatThrownBy(() -> mojo.execute())
        .isInstanceOf(MojoFailureException.class)
        .hasMessageContaining("Parent POM file not found");
  }

  @Test
  void testMissingProfileThrowsException() throws Exception {
    File parentPom = createParentPomWithoutProfile();
    setField(mojo, "parentPomFile", parentPom);
    setField(mojo, "sourceProfileId", "nonexistent");

    File bomDir = tempDir.resolve("bom").toFile();
    bomDir.mkdirs();
    createBomPom(bomDir);

    List<String> bomDirs = new ArrayList<>();
    bomDirs.add("bom");
    setField(mojo, "bomDirectories", bomDirs);

    assertThatThrownBy(() -> mojo.execute())
        .isInstanceOf(MojoExecutionException.class)
        .hasMessageContaining("Profile 'nonexistent' not found");
  }

  @Test
  void testEmptyBomDirectoriesSkipsGracefully() throws Exception {
    File parentPom = tempDir.resolve("pom.xml").toFile();
    setField(mojo, "parentPomFile", parentPom);
    setField(mojo, "bomDirectories", new ArrayList<>());

    // Should skip gracefully without throwing exception
    mojo.execute();

    // Verify debug log was called
    verify(mockLog).debug(Mockito.contains("No BOM directories configured"));
  }

  @Test
  void testMissingBomPomLogsWarning() throws Exception {
    // Create parent POM
    File parentPom = createParentPomWithPlugins();

    // Don't create the BOM directory/POM
    setField(mojo, "parentPomFile", parentPom);
    setField(mojo, "sourceProfileId", "release");
    List<String> bomDirs = new ArrayList<>();
    bomDirs.add("nonexistent-bom");
    setField(mojo, "bomDirectories", bomDirs);

    // Execute should succeed with warning
    mojo.execute();

    // Verify warning was logged
    verify(mockLog).warn(Mockito.contains("BOM POM not found"));
  }

  @Test
  void testEmptyProfileLogsWarning() throws Exception {
    // Create parent POM with empty release profile
    File parentPom = createParentPomWithEmptyProfile();

    File bomDir = tempDir.resolve("bom").toFile();
    bomDir.mkdirs();
    createBomPom(bomDir);

    setField(mojo, "parentPomFile", parentPom);
    setField(mojo, "sourceProfileId", "release");
    List<String> bomDirs = new ArrayList<>();
    bomDirs.add("bom");
    setField(mojo, "bomDirectories", bomDirs);

    // Execute should succeed with warning
    mojo.execute();

    // Verify warning was logged
    verify(mockLog).warn(Mockito.contains("No plugins found"));
  }

  @Test
  void testPluginWithExecution() throws Exception {
    // Create parent POM with plugin that has executions
    File parentPom = createParentPomWithPluginExecutions();

    File bomDir = tempDir.resolve("bom").toFile();
    bomDir.mkdirs();
    File bomPom = createBomPom(bomDir);

    setField(mojo, "parentPomFile", parentPom);
    setField(mojo, "sourceProfileId", "release");
    List<String> bomDirs = new ArrayList<>();
    bomDirs.add("bom");
    setField(mojo, "bomDirectories", bomDirs);

    // Execute
    mojo.execute();

    // Verify plugin with executions was copied
    Model bomModel = readModel(bomPom);
    Plugin sourcePlugin = findPlugin(bomModel, "org.apache.maven.plugins", "maven-source-plugin");
    assertThat(sourcePlugin).isNotNull();
    assertThat(sourcePlugin.getExecutions()).isNotEmpty();
    assertThat(sourcePlugin.getExecutions().get(0).getId()).isEqualTo("attach-sources");
  }

  @Test
  void testPluginWithConfiguration() throws Exception {
    // Create parent POM with plugin that has configuration with properties
    File parentPom = createParentPomWithPluginConfiguration();

    File bomDir = tempDir.resolve("bom").toFile();
    bomDir.mkdirs();
    File bomPom = createBomPom(bomDir);

    setField(mojo, "parentPomFile", parentPom);
    setField(mojo, "sourceProfileId", "release");
    List<String> bomDirs = new ArrayList<>();
    bomDirs.add("bom");
    setField(mojo, "bomDirectories", bomDirs);

    // Execute
    mojo.execute();

    // Verify plugin configuration was copied and properties resolved
    Model bomModel = readModel(bomPom);
    Plugin gpgPlugin = findPlugin(bomModel, "org.apache.maven.plugins", "maven-gpg-plugin");
    assertThat(gpgPlugin).isNotNull();
    assertThat(gpgPlugin.getConfiguration()).isNotNull();

    Xpp3Dom config = (Xpp3Dom) gpgPlugin.getConfiguration();
    Xpp3Dom passphrase = config.getChild("passphrase");
    assertThat(passphrase).isNotNull();
    assertThat(passphrase.getValue()).isEqualTo("secret-value");
  }

  // Helper methods

  private File createParentPomWithProperties() throws IOException {
    String pom = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<project>\n" +
        "  <modelVersion>4.0.0</modelVersion>\n" +
        "  <groupId>test</groupId>\n" +
        "  <artifactId>parent</artifactId>\n" +
        "  <version>1.0</version>\n" +
        "  <properties>\n" +
        "    <maven.gpg.plugin.version>3.2.8</maven.gpg.plugin.version>\n" +
        "    <maven.source.plugin.version>3.3.1</maven.source.plugin.version>\n" +
        "  </properties>\n" +
        "  <profiles>\n" +
        "    <profile>\n" +
        "      <id>release</id>\n" +
        "      <build>\n" +
        "        <plugins>\n" +
        "          <plugin>\n" +
        "            <groupId>org.apache.maven.plugins</groupId>\n" +
        "            <artifactId>maven-gpg-plugin</artifactId>\n" +
        "            <version>${maven.gpg.plugin.version}</version>\n" +
        "          </plugin>\n" +
        "        </plugins>\n" +
        "      </build>\n" +
        "    </profile>\n" +
        "  </profiles>\n" +
        "</project>";

    File parentPom = tempDir.resolve("pom.xml").toFile();
    try (FileWriter writer = new FileWriter(parentPom)) {
      writer.write(pom);
    }
    return parentPom;
  }

  private File createParentPomWithPlugins() throws IOException {
    String pom = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<project>\n" +
        "  <modelVersion>4.0.0</modelVersion>\n" +
        "  <groupId>test</groupId>\n" +
        "  <artifactId>parent</artifactId>\n" +
        "  <version>1.0</version>\n" +
        "  <properties>\n" +
        "    <maven.gpg.plugin.version>3.2.8</maven.gpg.plugin.version>\n" +
        "    <maven.source.plugin.version>3.3.1</maven.source.plugin.version>\n" +
        "  </properties>\n" +
        "  <profiles>\n" +
        "    <profile>\n" +
        "      <id>release</id>\n" +
        "      <build>\n" +
        "        <plugins>\n" +
        "          <plugin>\n" +
        "            <groupId>org.apache.maven.plugins</groupId>\n" +
        "            <artifactId>maven-gpg-plugin</artifactId>\n" +
        "            <version>${maven.gpg.plugin.version}</version>\n" +
        "          </plugin>\n" +
        "          <plugin>\n" +
        "            <groupId>org.apache.maven.plugins</groupId>\n" +
        "            <artifactId>maven-source-plugin</artifactId>\n" +
        "            <version>${maven.source.plugin.version}</version>\n" +
        "          </plugin>\n" +
        "        </plugins>\n" +
        "      </build>\n" +
        "    </profile>\n" +
        "  </profiles>\n" +
        "</project>";

    File parentPom = tempDir.resolve("pom.xml").toFile();
    try (FileWriter writer = new FileWriter(parentPom)) {
      writer.write(pom);
    }
    return parentPom;
  }

  private File createParentPomWithoutProfile() throws IOException {
    String pom = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<project>\n" +
        "  <modelVersion>4.0.0</modelVersion>\n" +
        "  <groupId>test</groupId>\n" +
        "  <artifactId>parent</artifactId>\n" +
        "  <version>1.0</version>\n" +
        "</project>";

    File parentPom = tempDir.resolve("pom.xml").toFile();
    try (FileWriter writer = new FileWriter(parentPom)) {
      writer.write(pom);
    }
    return parentPom;
  }

  private File createParentPomWithEmptyProfile() throws IOException {
    String pom = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<project>\n" +
        "  <modelVersion>4.0.0</modelVersion>\n" +
        "  <groupId>test</groupId>\n" +
        "  <artifactId>parent</artifactId>\n" +
        "  <version>1.0</version>\n" +
        "  <profiles>\n" +
        "    <profile>\n" +
        "      <id>release</id>\n" +
        "    </profile>\n" +
        "  </profiles>\n" +
        "</project>";

    File parentPom = tempDir.resolve("pom.xml").toFile();
    try (FileWriter writer = new FileWriter(parentPom)) {
      writer.write(pom);
    }
    return parentPom;
  }

  private File createParentPomWithPluginExecutions() throws IOException {
    String pom = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<project>\n" +
        "  <modelVersion>4.0.0</modelVersion>\n" +
        "  <groupId>test</groupId>\n" +
        "  <artifactId>parent</artifactId>\n" +
        "  <version>1.0</version>\n" +
        "  <properties>\n" +
        "    <maven.source.plugin.version>3.3.1</maven.source.plugin.version>\n" +
        "  </properties>\n" +
        "  <profiles>\n" +
        "    <profile>\n" +
        "      <id>release</id>\n" +
        "      <build>\n" +
        "        <plugins>\n" +
        "          <plugin>\n" +
        "            <groupId>org.apache.maven.plugins</groupId>\n" +
        "            <artifactId>maven-source-plugin</artifactId>\n" +
        "            <version>${maven.source.plugin.version}</version>\n" +
        "            <executions>\n" +
        "              <execution>\n" +
        "                <id>attach-sources</id>\n" +
        "                <goals>\n" +
        "                  <goal>jar-no-fork</goal>\n" +
        "                </goals>\n" +
        "              </execution>\n" +
        "            </executions>\n" +
        "          </plugin>\n" +
        "        </plugins>\n" +
        "      </build>\n" +
        "    </profile>\n" +
        "  </profiles>\n" +
        "</project>";

    File parentPom = tempDir.resolve("pom.xml").toFile();
    try (FileWriter writer = new FileWriter(parentPom)) {
      writer.write(pom);
    }
    return parentPom;
  }

  private File createParentPomWithPluginConfiguration() throws IOException {
    String pom = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<project>\n" +
        "  <modelVersion>4.0.0</modelVersion>\n" +
        "  <groupId>test</groupId>\n" +
        "  <artifactId>parent</artifactId>\n" +
        "  <version>1.0</version>\n" +
        "  <properties>\n" +
        "    <maven.gpg.plugin.version>3.2.8</maven.gpg.plugin.version>\n" +
        "    <gpg.passphrase>secret-value</gpg.passphrase>\n" +
        "  </properties>\n" +
        "  <profiles>\n" +
        "    <profile>\n" +
        "      <id>release</id>\n" +
        "      <build>\n" +
        "        <plugins>\n" +
        "          <plugin>\n" +
        "            <groupId>org.apache.maven.plugins</groupId>\n" +
        "            <artifactId>maven-gpg-plugin</artifactId>\n" +
        "            <version>${maven.gpg.plugin.version}</version>\n" +
        "            <configuration>\n" +
        "              <passphrase>${gpg.passphrase}</passphrase>\n" +
        "            </configuration>\n" +
        "          </plugin>\n" +
        "        </plugins>\n" +
        "      </build>\n" +
        "    </profile>\n" +
        "  </profiles>\n" +
        "</project>";

    File parentPom = tempDir.resolve("pom.xml").toFile();
    try (FileWriter writer = new FileWriter(parentPom)) {
      writer.write(pom);
    }
    return parentPom;
  }

  private File createBomPom(File bomDir) throws IOException {
    String pom = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<project>\n" +
        "  <modelVersion>4.0.0</modelVersion>\n" +
        "  <groupId>test</groupId>\n" +
        "  <artifactId>bom</artifactId>\n" +
        "  <version>1.0</version>\n" +
        "  <packaging>pom</packaging>\n" +
        "</project>";

    File bomPom = new File(bomDir, "pom.xml");
    try (FileWriter writer = new FileWriter(bomPom)) {
      writer.write(pom);
    }
    return bomPom;
  }

  private File createBomPomWithExistingPlugin(File bomDir) throws IOException {
    String pom = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<project>\n" +
        "  <modelVersion>4.0.0</modelVersion>\n" +
        "  <groupId>test</groupId>\n" +
        "  <artifactId>bom</artifactId>\n" +
        "  <version>1.0</version>\n" +
        "  <packaging>pom</packaging>\n" +
        "  <build>\n" +
        "    <plugins>\n" +
        "      <plugin>\n" +
        "        <groupId>org.apache.maven.plugins</groupId>\n" +
        "        <artifactId>maven-gpg-plugin</artifactId>\n" +
        "        <version>3.0.0</version>\n" +
        "      </plugin>\n" +
        "    </plugins>\n" +
        "  </build>\n" +
        "</project>";

    File bomPom = new File(bomDir, "pom.xml");
    try (FileWriter writer = new FileWriter(bomPom)) {
      writer.write(pom);
    }
    return bomPom;
  }

  private File createBomPomWithDependencies(File bomDir) throws IOException {
    String pom = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<project>\n" +
        "  <modelVersion>4.0.0</modelVersion>\n" +
        "  <groupId>test</groupId>\n" +
        "  <artifactId>bom</artifactId>\n" +
        "  <version>1.0</version>\n" +
        "  <packaging>pom</packaging>\n" +
        "  <dependencyManagement>\n" +
        "    <dependencies>\n" +
        "      <dependency>\n" +
        "        <groupId>io.fabric8</groupId>\n" +
        "        <artifactId>kubernetes-client</artifactId>\n" +
        "        <version>7.0.0</version>\n" +
        "      </dependency>\n" +
        "      <dependency>\n" +
        "        <groupId>io.fabric8</groupId>\n" +
        "        <artifactId>openshift-client</artifactId>\n" +
        "        <version>7.0.0</version>\n" +
        "      </dependency>\n" +
        "      <dependency>\n" +
        "        <groupId>io.fabric8</groupId>\n" +
        "        <artifactId>kubernetes-model</artifactId>\n" +
        "        <version>7.0.0</version>\n" +
        "      </dependency>\n" +
        "    </dependencies>\n" +
        "  </dependencyManagement>\n" +
        "</project>";

    File bomPom = new File(bomDir, "pom.xml");
    try (FileWriter writer = new FileWriter(bomPom)) {
      writer.write(pom);
    }
    return bomPom;
  }

  private Model readModel(File pomFile) throws Exception {
    MavenXpp3Reader reader = new MavenXpp3Reader();
    try (FileReader fileReader = new FileReader(pomFile)) {
      return reader.read(fileReader);
    }
  }

  private Plugin findPlugin(Model model, String groupId, String artifactId) {
    if (model.getBuild() == null || model.getBuild().getPlugins() == null) {
      return null;
    }

    String targetGroupId = groupId != null ? groupId : "org.apache.maven.plugins";

    return model.getBuild().getPlugins().stream()
        .filter(p -> {
          String gId = p.getGroupId() != null ? p.getGroupId() : "org.apache.maven.plugins";
          return targetGroupId.equals(gId) && artifactId.equals(p.getArtifactId());
        })
        .findFirst()
        .orElse(null);
  }

  private void setField(Object target, String fieldName, Object value) {
    try {
      Field field = target.getClass().getDeclaredField(fieldName);
      field.setAccessible(true);
      field.set(target, value);
    } catch (Exception e) {
      throw new RuntimeException("Failed to set field: " + fieldName, e);
    }
  }
}
