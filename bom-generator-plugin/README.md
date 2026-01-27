# BOM Generator Plugin

Maven plugin to generate BOM (Bill of Materials) POMs with dependency management and release plugins.

## Purpose

This plugin consolidates the functionality of sundrio-maven-plugin's `generate-bom` goal and the previous `bom-manipulator-plugin` into a single, self-contained plugin. It generates BOM POMs from the reactor projects with:

- Filtered module dependencies based on include/exclude patterns
- Optional transitive dependency inclusion based on patterns
- Release plugins copied from a specified profile with resolved property placeholders
- Full project metadata (licenses, developers, SCM, distribution management)

## Usage

### Basic Configuration

Add the plugin to your POM's build section (typically within a profile):

```xml
<profile>
  <id>bom</id>
  <build>
    <plugins>
      <plugin>
        <groupId>io.fabric8</groupId>
        <artifactId>bom-generator-plugin</artifactId>
        <version>${project.version}</version>
        <inherited>false</inherited>
        <configuration>
          <sourceProfileId>release</sourceProfileId>
          <boms>
            <bom>
              <artifactId>kubernetes-client-bom</artifactId>
              <name>Fabric8 :: Kubernetes :: BOM</name>
              <modules>
                <excludes>
                  <exclude>io.fabric8:*-tests</exclude>
                  <exclude>io.fabric8:*-itests</exclude>
                  <exclude>io.fabric8*:*-examples</exclude>
                </excludes>
              </modules>
            </bom>
            <bom>
              <artifactId>kubernetes-client-bom-with-deps</artifactId>
              <name>Fabric8 :: Kubernetes :: BOM with Dependencies</name>
              <modules>
                <excludes>
                  <exclude>io.fabric8:*-tests</exclude>
                  <exclude>io.fabric8:*-itests</exclude>
                  <exclude>io.fabric8*:*-examples</exclude>
                </excludes>
              </modules>
              <dependencies>
                <includes>
                  <include>io.sundr*:*</include>
                  <include>org.projectlombok:lombok*</include>
                  <include>com.fasterxml.jackson*:*</include>
                </includes>
              </dependencies>
            </bom>
          </boms>
        </configuration>
        <executions>
          <execution>
            <id>generate-boms</id>
            <goals>
              <goal>generate-boms</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
</profile>
```

### Configuration Parameters

#### Plugin Parameters

- **boms** (required): List of BOM configurations to generate.

- **sourceProfileId** (optional): The profile ID from which to copy release plugins.
  - Default: `release`

- **outputDirectory** (optional): Output directory for generated BOMs.
  - Default: `${project.build.outputDirectory}` (typically `target/classes`)

#### BOM Configuration

Each `<bom>` element supports:

- **artifactId** (required): The artifact ID for the generated BOM.

- **name** (required): The display name for the BOM.

- **modules**: Filtering for reactor project modules.
  - **includes**: Patterns for modules to include (if empty, all are included)
  - **excludes**: Patterns for modules to exclude

- **dependencies**: Filtering for transitive dependencies to include.
  - **includes**: Patterns for dependencies to include in the BOM
  - **excludes**: Patterns for dependencies to exclude

### Pattern Syntax

Patterns use glob-style matching with the format `groupId:artifactId`:

- `*` matches any sequence of characters
- `?` matches any single character

Examples:
- `io.fabric8:*-tests` - matches all artifactIds ending with `-tests` in groupId `io.fabric8`
- `com.fasterxml.jackson*:*` - matches any artifactId in any groupId starting with `com.fasterxml.jackson`

## How It Works

1. Reads all reactor projects from the Maven session
2. For each BOM configuration:
   - Creates a new POM model with metadata from the parent project
   - Filters reactor modules based on include/exclude patterns
   - Collects transitive dependencies matching include patterns
   - Adds release plugins from the specified profile (with property resolution)
   - Writes the generated BOM to the output directory

## Example Workflow

```bash
# Generate BOMs (single command, no separate plugin invocation needed)
mvn clean install -Pbom

# The BOMs are generated in:
# - target/classes/kubernetes-client-bom/pom.xml
# - target/classes/kubernetes-client-bom-with-deps/pom.xml

# Release with updated BOMs
mvn clean install -Prelease
```

## Generated BOM Content

Each generated BOM includes:

- **Metadata**: groupId, artifactId, version, name, description, URL
- **Licenses**: Copied from parent project
- **Developers**: Copied from parent project
- **SCM**: Copied from parent project (with property resolution)
- **Distribution Management**: Copied from parent project
- **Dependency Management**: Filtered reactor modules and optional transitive dependencies
- **Build Plugins**: Release plugins from the specified profile with resolved versions

## Migration from sundrio-maven-plugin

If you were previously using sundrio-maven-plugin and bom-manipulator-plugin:

Before:
```xml
<plugin>
  <groupId>io.sundr</groupId>
  <artifactId>sundr-maven-plugin</artifactId>
  <version>${sundrio.version}</version>
  <configuration>
    <boms>...</boms>
  </configuration>
</plugin>
<plugin>
  <groupId>io.fabric8</groupId>
  <artifactId>bom-manipulator-plugin</artifactId>
  <version>${project.version}</version>
  <configuration>
    <bomDirectories>...</bomDirectories>
  </configuration>
</plugin>
```

After:
```xml
<plugin>
  <groupId>io.fabric8</groupId>
  <artifactId>bom-generator-plugin</artifactId>
  <version>${project.version}</version>
  <configuration>
    <boms>...</boms>  <!-- Same format as sundrio -->
    <sourceProfileId>release</sourceProfileId>
  </configuration>
</plugin>
```
