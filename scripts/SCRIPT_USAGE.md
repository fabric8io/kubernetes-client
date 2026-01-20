# GraalVM Reflection Config Generator Script

A comprehensive shell script to generate and aggregate GraalVM reflection configurations for all Fabric8 Kubernetes and OpenShift model modules.

## Features

✅ **Flexible Source Options**
- Use current project directory
- Clone from any git repository
- Checkout specific tag, commit, or branch

✅ **Automated Workflow**
- Automatic model generation
- Aggregation of all reflect-config.json files
- JSON validation
- Summary report generation

✅ **Robust Error Handling**
- Dependency checking
- Detailed logging with color output
- Automatic cleanup
- Progress indicators

## Quick Start

### 1. Use Current Project
```bash
cd kubernetes-model-generator
./generate-graalvm-reflect-config.sh
```

Output: `./graalvm-config/reflect-config.json`

### 2. Generate for Specific Tag
```bash
./generate-graalvm-reflect-config.sh --tag v6.9.0
```

### 3. Generate for Specific Commit
```bash
./generate-graalvm-reflect-config.sh --commit abc123def456
```

### 4. Generate for Specific Branch
```bash
./generate-graalvm-reflect-config.sh --branch main
```

### 5. Generate from Fork
```bash
./generate-graalvm-reflect-config.sh \
  --repo https://github.com/myuser/kubernetes-client \
  --branch my-feature
```

## Command-Line Options

### Source Options

| Option | Description | Example |
|--------|-------------|---------|
| `-t, --tag TAG` | Clone and checkout a specific git tag | `--tag v6.9.0` |
| `-c, --commit COMMIT` | Clone and checkout a specific commit | `--commit abc123` |
| `-b, --branch BRANCH` | Clone and checkout a specific branch | `--branch main` |
| `-r, --repo URL` | Git repository URL | `--repo https://github.com/fabric8io/kubernetes-client.git` |

### Output Options

| Option | Description | Default | Example |
|--------|-------------|---------|---------|
| `-o, --output DIR` | Output directory for aggregated config | `./graalvm-config` | `--output /tmp/configs` |
| `-w, --work-dir DIR` | Working directory for clone | `/tmp/k8s-client-build-XXXXX` | `--work-dir /tmp/build` |

### Behavior Options

| Option | Description |
|--------|-------------|
| `-k, --keep` | Keep the cloned repository after completion |
| `-s, --skip-generate` | Skip model generation (use existing configs) |
| `-h, --help` | Show help message |

## Usage Examples

### Example 1: Generate for Release v6.9.0
```bash
./generate-graalvm-reflect-config.sh \
  --tag v6.9.0 \
  --output ./configs/v6.9.0
```

**Output:**
```
./configs/v6.9.0/
├── reflect-config.json          # Aggregated config
├── GENERATION_SUMMARY.txt       # Summary report
├── README.md                    # Documentation
├── NATIVE_IMAGE_USAGE.md        # Usage guide
├── QUICK_START.md               # Quick start
└── pom-example.xml              # Maven example
```

### Example 2: Generate and Keep Work Directory
```bash
./generate-graalvm-reflect-config.sh \
  --branch main \
  --work-dir /tmp/k8s-build \
  --keep \
  --output ./latest-config
```

This keeps the cloned repository at `/tmp/k8s-build` for inspection.

### Example 3: Use Existing Generated Configs
```bash
# First time: generate models
./generate-graalvm-reflect-config.sh

# Later: just re-aggregate without regenerating
./generate-graalvm-reflect-config.sh --skip-generate
```

### Example 4: Generate from Your Fork
```bash
./generate-graalvm-reflect-config.sh \
  --repo git@github.com:myusername/kubernetes-client.git \
  --branch feature/graalvm-support \
  --output ./my-feature-config
```

## What the Script Does

### Step-by-Step Process

1. **Validation**
   - Checks for required tools (git, maven/mvnw, optionally jq)
   - Validates command-line arguments

2. **Repository Setup**
   - Clones repository (if tag/commit/branch specified)
   - Or uses current directory
   - Checks out specified reference

3. **Model Generation** (unless --skip-generate)
   - Runs `mvn clean install -Pgenerate -DskipTests`
   - Generates all Kubernetes and OpenShift model classes
   - Creates individual reflect-config.json files

4. **Config Discovery**
   - Searches for all `META-INF/native-image/reflect-config.json` files
   - Reports number of modules found

5. **Aggregation**
   - Merges all individual configs into single JSON array
   - Preserves all reflection metadata
   - Creates unified reflect-config.json

6. **Validation**
   - Validates JSON syntax (if jq available)
   - Counts total entries
   - Calculates file size

7. **Output**
   - Copies aggregated config to output directory
   - Copies documentation files
   - Creates summary report

8. **Cleanup** (unless --keep)
   - Removes temporary work directory
   - Preserves output directory

## Output Files

### reflect-config.json
The main output file containing all reflection configurations:
```json
[
  {
    "condition": {
      "typeReachable": "io.fabric8.kubernetes.api.model.Pod"
    },
    "name": "io.fabric8.kubernetes.api.model.Pod",
    "allDeclaredConstructors": true,
    "allDeclaredMethods": true,
    "allDeclaredFields": true
  },
  ...
]
```

**Statistics (typical):**
- **Size**: ~965 KB
- **Entries**: ~3,274 classes
- **Modules**: 38 Kubernetes + OpenShift modules

### GENERATION_SUMMARY.txt
Detailed report including:
- Timestamp and script version
- Repository and reference information
- Generation statistics
- Output file locations
- Sample configuration entry
- Usage instructions

## Requirements

### Required Tools
- **git**: For cloning repository
- **maven** or **mvnw**: For building project
- **bash**: Version 4.0 or higher

### Optional Tools
- **jq**: For JSON validation (recommended)
- **curl**: If downloading from remote URLs

### System Requirements
- **Disk Space**: ~2 GB for full clone and build
- **Memory**: 4 GB RAM minimum (8 GB recommended for build)
- **Time**: 5-15 minutes depending on network and CPU

## Troubleshooting

### "No reflect-config.json files found"

**Cause:** Model generation didn't create config files

**Solution:**
```bash
# Check if generation succeeded
cat /tmp/maven-build.log | grep ERROR

# Try manual generation
cd kubernetes-model-generator
mvn clean install -Pgenerate -DskipTests -X
```

### "Missing required tools: maven"

**Cause:** Maven not installed and mvnw not found

**Solution:**
```bash
# On macOS
brew install maven

# On Ubuntu/Debian
sudo apt-get install maven

# Or use the wrapper
./mvnw --version
```

### "Generated JSON is invalid"

**Cause:** JSON merge created invalid syntax

**Solution:**
```bash
# Install jq for validation
brew install jq  # macOS
sudo apt-get install jq  # Ubuntu/Debian

# Manually validate
jq empty graalvm-config/reflect-config.json
```

### Build Fails with Compilation Errors

**Cause:** Pre-existing issues in the project

**Solution:**
```bash
# Skip tests and use existing configs
./generate-graalvm-reflect-config.sh --skip-generate

# Or try a stable release tag
./generate-graalvm-reflect-config.sh --tag v6.9.0
```

### Permission Denied

**Cause:** Script not executable

**Solution:**
```bash
chmod +x generate-graalvm-reflect-config.sh
```

## Advanced Usage

### Integration with CI/CD

```yaml
# GitHub Actions example
- name: Generate GraalVM Config
  run: |
    cd kubernetes-model-generator
    ./generate-graalvm-reflect-config.sh \
      --tag ${{ github.ref_name }} \
      --output ./artifacts/graalvm-config

- name: Upload Artifact
  uses: actions/upload-artifact@v3
  with:
    name: graalvm-reflect-config
    path: kubernetes-model-generator/artifacts/graalvm-config/
```

### Automated Releases

```bash
#!/bin/bash
# Generate configs for all release tags

TAGS=("v6.8.0" "v6.8.1" "v6.9.0" "v6.9.1")

for tag in "${TAGS[@]}"; do
  ./generate-graalvm-reflect-config.sh \
    --tag "$tag" \
    --output "./releases/$tag" \
    --keep
done
```

### Custom Maven Goals

Modify the script to use custom Maven profiles:

```bash
# Edit the generate_models function
generate_models() {
    # ... existing code ...

    # Custom build with your profile
    $MVN_CMD clean install \
      -Pgenerate \
      -Pcustom-profile \
      -DskipTests \
      -Dcustom.property=value
}
```

## Environment Variables

The script respects these environment variables:

```bash
# Override default repository
export K8S_CLIENT_REPO="https://github.com/myorg/kubernetes-client.git"

# Override output directory
export GRAALVM_CONFIG_OUTPUT="/opt/configs"

# Use custom Maven command
export MVN_CMD="/usr/local/bin/mvn"

./generate-graalvm-reflect-config.sh
```

## Logging

The script provides color-coded logging:

- 🔵 **[INFO]** - Informational messages
- 🟢 **[SUCCESS]** - Successful operations
- 🟡 **[WARN]** - Warnings (non-fatal)
- 🔴 **[ERROR]** - Errors (fatal)

Build logs are saved to `/tmp/maven-build.log` for troubleshooting.

## Performance Tips

### Speed Up Generation

1. **Use existing clone**:
   ```bash
   # First run with --keep
   ./generate-graalvm-reflect-config.sh --branch main --keep

   # Subsequent runs without clone
   cd /tmp/k8s-client-build-XXXXX/kubernetes-client/kubernetes-model-generator
   ./generate-graalvm-reflect-config.sh --skip-generate
   ```

2. **Use shallow clone** (already default):
   The script uses `git clone --depth 1` for faster cloning

3. **Skip unnecessary modules**:
   Edit the script to filter modules if you only need specific ones

## License

This script is part of the Fabric8 Kubernetes Client project and follows the same Apache 2.0 license.

## Support

For issues or questions:
- Check the troubleshooting section above
- Review `/tmp/maven-build.log` for build errors
- Check the generated `GENERATION_SUMMARY.txt` for details
- Open an issue on the Fabric8 Kubernetes Client GitHub repository