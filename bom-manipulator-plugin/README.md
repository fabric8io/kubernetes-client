# BOM Manipulator Plugin

Maven plugin to copy build plugins from parent POM's release profile to BOM modules.

## Purpose

This plugin simplifies the process of copying Maven build plugins from a specific profile (typically the `release` profile) in the parent POM to one or more BOM (Bill of Materials) POM files.

**Important:** This plugin preserves all existing data in the BOM POMs. It only adds or updates the plugins from the release profile without removing any existing content, dependencies, or metadata.

## Usage

### Basic Configuration

Add the plugin to your POM's build section:

```xml
<build>
  <plugins>
    <plugin>
      <groupId>io.fabric8</groupId>
      <artifactId>bom-manipulator-plugin</artifactId>
      <version>${project.version}</version>
      <executions>
        <execution>
          <id>copy-plugins-to-boms</id>
          <phase>process-resources</phase>
          <goals>
            <goal>copy-plugins</goal>
          </goals>
          <configuration>
            <bomDirectories>
              <bomDirectory>target/classes/kubernetes-client-bom</bomDirectory>
              <bomDirectory>target/classes/kubernetes-client-bom-with-deps</bomDirectory>
            </bomDirectories>
          </configuration>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```

### Configuration Parameters

- **parentPomFile** (optional): The parent POM file containing the release profile.
    - Default: `${project.basedir}/pom.xml`

- **sourceProfileId** (optional): The profile ID from which to copy plugins.
    - Default: `release`

- **bomDirectories** (required): List of BOM directories where plugins should be copied.
    - Format: Relative paths from the parent POM directory
    - Example:
      ```xml
      <bomDirectories>
        <bomDirectory>target/classes/kubernetes-client-bom</bomDirectory>
        <bomDirectory>target/classes/kubernetes-client-bom-with-deps</bomDirectory>
      </bomDirectories>
      ```

## How It Works

1. Reads the parent POM file
2. Locates the specified profile (default: `release`)
3. Extracts all build plugins from that profile
4. For each BOM directory specified:
    - Reads the BOM POM file using XML DOM parser
    - Creates a `<build><plugins>` section if it doesn't exist
    - Adds new plugins or updates existing ones with the same groupId:artifactId
    - Preserves all other existing content, formatting, and metadata
    - Writes the updated POM back to disk

## Example Workflow

Typically used in conjunction with the BOM generation profile:

```bash
# Generate BOMs
mvn clean install -Pbom

# Copy release plugins to BOMs
mvn io.fabric8:bom-manipulator-plugin:copy-plugins \
  -Dbom.bomDirectories=target/classes/kubernetes-client-bom,target/classes/kubernetes-client-bom-with-deps

# Release with updated BOMs
mvn clean install -Prelease
```

## Notes

- **Data Preservation**: The plugin preserves all existing data in the BOM POMs including:
  - All metadata (name, description, licenses, SCM, developers, etc.)
  - Dependency management sections
  - Properties
  - Any other existing sections
- The plugin will create a `<build>` section in the BOM POM if it doesn't exist
- If a plugin with the same `groupId:artifactId` already exists in the BOM, it will be updated with the configuration from the release profile
- The plugin uses XML DOM parsing to ensure accurate preservation of the POM structure
- All plugin configurations (executions, goals, configuration) are fully copied from the source profile
