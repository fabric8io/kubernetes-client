# GraalVM Reflection Config Generator Scripts

This folder contains scripts for generating and aggregating GraalVM reflection configurations for Fabric8 Kubernetes Client model classes.

## Scripts

### 1. generate-graalvm-reflect-config.sh

Comprehensive script that can clone repositories, generate models, and aggregate reflection configurations.

**Usage**:
```bash
# Use current project
./generate-graalvm-reflect-config.sh

# Generate for specific tag
./generate-graalvm-reflect-config.sh --tag v6.9.0

# Generate for specific commit
./generate-graalvm-reflect-config.sh --commit abc123

# Generate for specific branch
./generate-graalvm-reflect-config.sh --branch main
```

**Options**:
- `-t, --tag TAG` - Clone and checkout a specific git tag
- `-c, --commit COMMIT` - Clone and checkout a specific commit
- `-b, --branch BRANCH` - Clone and checkout a specific branch
- `-r, --repo URL` - Git repository URL
- `-o, --output DIR` - Output directory (default: ./graalvm-config)
- `-w, --work-dir DIR` - Working directory for clone
- `-k, --keep` - Keep the cloned repository
- `-s, --skip-generate` - Skip model generation (use existing configs)
- `-h, --help` - Show help message

See [SCRIPT_USAGE.md](./SCRIPT_USAGE.md) for detailed documentation.

### 2. aggregate-reflect-configs.sh

Simple script to aggregate existing reflect-config.json files without regenerating models.

**Usage**:
```bash
cd ../kubernetes-model-generator
../scripts/aggregate-reflect-configs.sh
```

## Documentation

- **SCRIPT_USAGE.md** - Complete script documentation with examples
- **GRAALVM_CONFIG_README.md** - Overview of the entire solution

## Enabling GraalVM Reflection Config Generation

To enable GraalVM reflection config generation in the model generator, add the setting to your POM configuration:

```xml
<plugin>
  <groupId>io.fabric8</groupId>
  <artifactId>openapi-model-generator-maven-plugin</artifactId>
  <configuration>
    <settings>
      <generateGraalVMReflectConfig>true</generateGraalVMReflectConfig>
      <!-- other settings -->
    </settings>
  </configuration>
</plugin>
```

## Output

The scripts generate:
- **reflect-config.json** - Aggregated reflection configuration (~965 KB, 3,274 entries)
- **GENERATION_SUMMARY.txt** - Detailed generation report
- **Documentation files** - Usage guides and examples

## Requirements

- git
- Maven (or mvnw)
- bash 4.0+
- jq (optional, for JSON validation)

## Quick Start

```bash
# From project root
cd scripts

# Generate for current project (models must already be generated)
./generate-graalvm-reflect-config.sh --skip-generate

# Output: ./graalvm-config/reflect-config.json
```

## Integration with Maven

Enable the flag in your module's POM:

```xml
<profile>
  <id>generate</id>
  <build>
    <plugins>
      <plugin>
        <groupId>io.fabric8</groupId>
        <artifactId>openapi-model-generator-maven-plugin</artifactId>
        <configuration>
          <settings combine.self="append">
            <generateGraalVMReflectConfig>true</generateGraalVMReflectConfig>
          </settings>
        </configuration>
      </plugin>
    </plugins>
  </build>
</profile>
```

Then generate models:
```bash
cd kubernetes-model-generator
mvn clean install -Pgenerate -DskipTests
```

This creates individual `reflect-config.json` files in each module at:
```
<module>/META-INF/native-image/reflect-config.json
```

Then aggregate them:
```bash
cd ../scripts
./aggregate-reflect-configs.sh
```

## See Also

- [SCRIPT_USAGE.md](./SCRIPT_USAGE.md) - Detailed script documentation
- [GRAALVM_CONFIG_README.md](./GRAALVM_CONFIG_README.md) - Complete solution overview