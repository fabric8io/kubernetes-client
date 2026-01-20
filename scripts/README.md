# GraalVM Reflection Config Generator Script

This folder contains the script for generating and aggregating GraalVM reflection configurations for Fabric8 Kubernetes Client model classes.

## Script

### generate-graalvm-reflect-config.sh

Comprehensive script that can clone repositories, generate models, and aggregate reflection configurations.

**Quick Usage**:
```bash
# Generate for current project (models must already exist)
./generate-graalvm-reflect-config.sh --skip-generate

# Generate for specific tag
./generate-graalvm-reflect-config.sh --tag v6.9.0

# Generate for specific commit
./generate-graalvm-reflect-config.sh --commit abc123

# Generate for specific branch
./generate-graalvm-reflect-config.sh --branch main
```

**Common Options**:
- `-t, --tag TAG` - Clone and checkout a specific git tag
- `-c, --commit COMMIT` - Clone and checkout a specific commit
- `-b, --branch BRANCH` - Clone and checkout a specific branch
- `-o, --output DIR` - Output directory (default: ./graalvm-config)
- `-s, --skip-generate` - Skip model generation (use existing configs)
- `-h, --help` - Show help message

See [SCRIPT_USAGE.md](./SCRIPT_USAGE.md) for complete documentation.

## Documentation
- **[SCRIPT_USAGE.md](./SCRIPT_USAGE.md)** - Detailed script documentation

## Enabling Reflection Config Generation

The script automatically enables GraalVM reflection config generation by passing `-DgenerateGraalVMReflectConfig=true` to Maven.

Alternatively, to enable it manually when running Maven directly:

```bash
# Generate models with reflection configs
mvn clean install -Pgenerate -DskipTests -DgenerateGraalVMReflectConfig=true
```

Or add it to your module's POM:

```xml
<plugin>
  <groupId>io.fabric8</groupId>
  <artifactId>openapi-model-generator-maven-plugin</artifactId>
  <configuration>
    <settings combine.self="append">
      <generateGraalVMReflectConfig>true</generateGraalVMReflectConfig>
    </settings>
  </configuration>
</plugin>
```

## Output

The script generates:
- **reflect-config.json** - Aggregated configuration (~965 KB, 3,274 entries)
- **GENERATION_SUMMARY.txt** - Detailed report

## Requirements

- git
- Maven (or mvnw)
- bash 4.0+
- jq (optional, for JSON validation)

## Quick Workflow

### Option 1: Use Script Only (Recommended)

```bash
cd scripts

# For existing project with configs already generated
./generate-graalvm-reflect-config.sh --skip-generate

# For specific release
./generate-graalvm-reflect-config.sh --tag v6.9.0

# Output: ./graalvm-config/reflect-config.json
```

### Option 2: Manual Maven Build

```bash
# Generate models with reflection configs
cd kubernetes-model-generator
mvn clean install -Pgenerate -DskipTests -DgenerateGraalVMReflectConfig=true

# Aggregate configs
cd ../scripts
./generate-graalvm-reflect-config.sh --skip-generate
```

This creates individual configs at `<module>/META-INF/native-image/reflect-config.json` which are then aggregated.

## Using the Generated Config

Copy to your application:
```bash
cp graalvm-config/reflect-config.json \
   your-app/src/main/resources/META-INF/native-image/
```

Or reference directly in `native-maven-plugin`:
```xml
<buildArg>-H:ReflectionConfigurationFiles=${project.basedir}/../scripts/graalvm-config/reflect-config.json</buildArg>
```

GraalVM auto-discovers configs in `META-INF/native-image/`.

## See Also
- **[SCRIPT_USAGE.md](./SCRIPT_USAGE.md)** - Detailed documentation
