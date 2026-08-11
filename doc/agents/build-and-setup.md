# Build and Setup

## Bootstrap

```bash
# Clone the repository
git clone https://github.com/fabric8io/kubernetes-client.git
cd kubernetes-client

# Quick build without tests, recommended for setup
make quickly
```

## Java Version Check

Before running builds or tests, verify Maven is using a supported Java version
for this checkout:

```bash
mvn -version
rg -n \
  "maven.compiler.release|maven.compiler.source|java.version|maven-enforcer|toolchain|jdk" \
  pom.xml .mvn **/pom.xml
```

Derive the required Java version from the project's Maven configuration; do not
hardcode it in this file. If Maven is using an unsupported JDK, set `JAVA_HOME`
to an installed supported JDK and re-run `mvn -version` before starting the
build or test command.

## Make Targets

The project uses a `Makefile` for common operations. Prefer make targets over
raw Maven commands.

```bash
# Quick build without tests, default target, about 3-5 minutes
make quickly

# Full build with tests, about 10-15 minutes
# WARNING: This is a long-running command. Do not cancel it.
make install

# Clean build artifacts
make clean

# Format code, including license headers and Java formatting
make format

# Generate/regenerate model classes from OpenAPI schemas
make generate-model

# Regenerate javadoc element-list files for cross-module linking
# Run after adding or removing packages in core modules
make generate-javadoc-links
```

## Maven Logging

For agent runs, keep Maven output out of the conversation context unless it is
needed for debugging:

```bash
log="$(mktemp "${TMPDIR:-/tmp}/kubernetes-client-build.XXXXXX.log")"
MAVEN_ARGS="-B -ntp" make install >"$log" 2>&1
rc=$?
echo "Full build log: $log"
tail -200 "$log"
exit "$rc"
```

For long-running Maven commands, write output to a log file and poll with short
tails, for example `tail -80 "$log"` every few minutes. Use Maven's final
summary and report XML for test counts instead of repeatedly streaming the full
log.

## Direct Maven Commands

Use direct Maven commands when make targets do not cover the use case.

```bash
# Build a specific module
mvn clean install -pl kubernetes-client-api -DskipTests -T 1C

# Build with dependencies
mvn clean install -pl kubernetes-client -am -DskipTests -T 1C

# Check formatting without applying
mvn spotless:check
```
