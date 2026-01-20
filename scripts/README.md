# GraalVM Reflection Config Generator Script

This folder contains the script for generating and aggregating GraalVM reflection configurations for Fabric8 Kubernetes Client model classes.

## Script

### generate-graalvm-reflect-config.sh

Comprehensive script that can clone repositories, generate models, and aggregate reflection configurations.

**Quick Usage**:
```bash
# Generate for current project (models must already exist)
./generate-graalvm-reflect-config.sh

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
- `-h, --help` - Show help message

See [SCRIPT_USAGE.md](./SCRIPT_USAGE.md) for complete documentation.

## Documentation
- **[SCRIPT_USAGE.md](./SCRIPT_USAGE.md)** - Detailed script documentation

## How It Works

The script generates GraalVM reflection configurations by:
1. Scanning generated Java model source files in `src/generated/java` directories
2. Extracting fully qualified class names from package declarations
3. Creating `reflect-config.json` files in `target/classes/META-INF/native-image/`
4. Aggregating all individual configs into a single file

This approach is simpler and more reliable than the previous Maven plugin-based generation.

## Output

The script generates:
- **reflect-config.json** - Aggregated configuration (~965 KB, 3,274 entries)
- **GENERATION_SUMMARY.txt** - Detailed report

## Requirements

- git (for cloning repositories when using --tag, --branch, or --commit)
- bash 4.0+
- jq (optional, for JSON validation)

## Quick Workflow

### Basic Workflow

```bash
cd scripts

# For existing project with generated models
./generate-graalvm-reflect-config.sh

# For specific release
./generate-graalvm-reflect-config.sh --tag v6.9.0

# Output: ./graalvm-config/reflect-config.json
```

The script will:
1. Scan generated source files in `src/generated/java`
2. Create individual `reflect-config.json` files in `target/classes/META-INF/native-image/`
3. Aggregate all configs into a single file
4. Validate and copy to output directory

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
