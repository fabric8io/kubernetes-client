---
name: graalvm-metadata-pr
description: Use when generating GraalVM reachability metadata from the Fabric8 Kubernetes Client and raising a PR against oracle/graalvm-reachability-metadata. Triggers include creating a PR for GraalVM native image support, generating reachability-metadata.json for fabric8 modules, updating GraalVM metadata for a new fabric8 release tag, or contributing metadata to the GraalVM reachability metadata repo.
argument-hint: "<tag-or-commit-id> [strategy]"
disable-model-invocation: true
allowed-tools: Read, Edit, Write, Grep, Glob, Bash(make *), Bash(mvn *), Bash(git *), Bash(gh *), Bash(jbang *), Bash(find *), Bash(cp *), Bash(mkdir *), Bash(python3 *), Bash(sed *), Bash(${CLAUDE_SKILL_DIR}/scripts/*), WebFetch, AskUserQuestion
---

# GraalVM Reachability Metadata PR

Generates GraalVM reachability metadata from the Fabric8 Kubernetes Client at a specific tag or commit, then raises a draft PR against [oracle/graalvm-reachability-metadata](https://github.com/oracle/graalvm-reachability-metadata).

### Arguments

- `$0` — Git tag (e.g., `v7.5.2`) or commit ID to generate metadata from **(required)**
- `$1` — Inclusion strategy for the JBang script (default: `JACKSON_ANNOTATIONS`) **(optional)**
  - Options: `JACKSON_ANNOTATIONS`, `SUNDRIO_BUILDERS`, `KUBERNETES_RESOURCES`, `COMPREHENSIVE`, `ALL_PUBLIC_CLASSES`

### Pre-fetched Context

```
!`${CLAUDE_SKILL_DIR}/scripts/get-graalvm-context.sh $0 $1`
```

---

## Phase 1: Prepare the workspace

### 1. Preserve the generation scripts

The JBang scripts may not exist in the target tag/commit. Copy them to a temp location before checking out.

```bash
cp scripts/GenerateGraalvmMetadata.java /tmp/GenerateGraalvmMetadata.java
cp scripts/GenerateAllGraalvmMetadata.java /tmp/GenerateAllGraalvmMetadata.java
```

### 2. Checkout the target tag or commit

```bash
git checkout $0
```

### 3. Restore the generation scripts

Copy the scripts back into the checked-out tree so JBang can run them.

```bash
mkdir -p scripts
cp /tmp/GenerateGraalvmMetadata.java scripts/GenerateGraalvmMetadata.java
cp /tmp/GenerateAllGraalvmMetadata.java scripts/GenerateAllGraalvmMetadata.java
```

### 4. Build the project to generate Jandex indexes

```bash
make quickly
```

This runs `mvn clean install -DskipTests` across all modules, producing `target/classes/META-INF/jandex.idx` in each subproject. The JBang script needs these indexes.

**If `make quickly` fails** on the older tag, fall back to:
```bash
mvn clean install -DskipTests -T 1C
```

---

## Phase 2: Generate reachability-metadata.json files

### 5. Run the JBang metadata generator

```bash
jbang scripts/GenerateAllGraalvmMetadata.java -s ${1:-JACKSON_ANNOTATIONS}
```

This scans every module's Jandex index and writes a `reachability-metadata.json` at:
```
<module>/target/classes/META-INF/native-image/io.fabric8/<artifactId>/reachability-metadata.json
```

The output is already in the oracle repo's required format (`{"reflection": [...]}` with `typeReached` and `type` fields).

The script prints a summary showing which modules produced metadata (`WROTE`), which had no matching classes (`EMPTY`/`No matches`), and which were skipped (`SKIP` — no Jandex index).

### 6. Collect the generated files

Find all the generated `reachability-metadata.json` files:

```bash
find . -path '*/META-INF/native-image/io.fabric8/*/reachability-metadata.json' -type f
```

For each file, extract the artifactId from the path (`io.fabric8/<artifactId>/reachability-metadata.json`).

**Record the list of modules that produced metadata** — this will be shown to the user before creating the PR.

### 7. Determine the version

Extract the version from the tag or from the root `pom.xml`:

```bash
# From tag (strip leading 'v')
VERSION=$(echo "$0" | sed 's/^v//')

# Or from pom.xml
VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
```

---

## Phase 3: Place in oracle repo

### 8. Fork/clone the oracle repo

```bash
gh repo fork oracle/graalvm-reachability-metadata --clone=false 2>/dev/null || true
gh repo clone $(gh api user --jq '.login')/graalvm-reachability-metadata /tmp/graalvm-reachability-metadata
cd /tmp/graalvm-reachability-metadata
git checkout -b fabric8-metadata-${VERSION}
```

### 9. Copy each module's metadata

For each module with a generated `reachability-metadata.json`:

1. **Create the metadata directory and copy the file:**
   ```
   metadata/io.fabric8/<artifactId>/<VERSION>/reachability-metadata.json
   ```

2. **Create or update `metadata/io.fabric8/<artifactId>/index.json`:**

   If `index.json` already exists, add the new version to `tested-versions`. If it doesn't exist, create it:

   ```json
   [
     {
       "latest": true,
       "metadata-version": "<VERSION>",
       "source-code-url": "https://repo.maven.apache.org/maven2/io/fabric8/<artifactId>/$version$/<artifactId>-$version$-sources.jar",
       "repository-url": "https://github.com/fabric8io/kubernetes-client",
       "test-code-url": "https://github.com/fabric8io/kubernetes-client/tree/v$version$/kubernetes-model-generator/<artifactId>/src/test",
       "documentation-url": "https://repo.maven.apache.org/maven2/io/fabric8/<artifactId>/$version$/<artifactId>-$version$-javadoc.jar",
       "description": "<Two-sentence description of the module.>",
       "tested-versions": [
         "<VERSION>"
       ],
       "allowed-packages": [
         "<package-prefix>"
       ]
     }
   ]
   ```

   **`allowed-packages` by module pattern:**
   - `kubernetes-model-common` → `["io.fabric8.kubernetes"]`
   - `kubernetes-model-core` → `["io.fabric8.kubernetes.api.model"]`
   - `kubernetes-model-<group>` → `["io.fabric8.kubernetes.api.model.<group>"]`
   - `kubernetes-client-api` → `["io.fabric8.kubernetes.client"]`
   - `kubernetes-client` → `["io.fabric8.kubernetes.client"]`
   - `zjsonpatch` → `["io.fabric8.zjsonpatch"]`

---

### CHECKPOINT 1

Present to the user:
- The list of modules for which `reachability-metadata.json` was generated (with entry count per module)
- The list of modules that were empty or skipped
- Which modules are **new** vs **updates** to existing entries in the oracle repo
- A preview of the `reachability-metadata.json` for the largest module

**Get explicit approval before proceeding to PR creation.**

---

## Phase 4: Create the draft PR

### 10. Commit the changes

```bash
cd /tmp/graalvm-reachability-metadata
git add metadata/io.fabric8/
git commit -m "Add GraalVM reachability metadata for io.fabric8 modules (${VERSION})"
```

### 11. Push and create the draft PR

```bash
git push -u origin fabric8-metadata-${VERSION}

gh pr create \
  --repo oracle/graalvm-reachability-metadata \
  --draft \
  --title "Add GraalVM reachability metadata for io.fabric8 modules (${VERSION})" \
  --body "$(cat <<EOF
## What does this PR do?

Adds GraalVM reachability metadata for Fabric8 Kubernetes Client modules at version ${VERSION}.

The [Fabric8 Kubernetes Client](https://github.com/fabric8io/kubernetes-client) is a Java client library providing access to the Kubernetes REST API via a fluent DSL. These modules heavily use Jackson annotations and Sundrio-generated builders, requiring reflection metadata for GraalVM native image.

Related to: https://github.com/oracle/graalvm-reachability-metadata/issues/955

### Modules included

<table with module name, entry count, new/update status>

### How metadata was generated

Metadata was generated using annotation-scanning JBang scripts from the Fabric8 project:
1. Checked out tag \`$0\` of \`fabric8io/kubernetes-client\`
2. Built to generate Jandex indexes (\`make quickly\`)
3. Ran \`GenerateAllGraalvmMetadata.java\` with strategy \`${1:-JACKSON_ANNOTATIONS}\`

The scripts scan for classes annotated with Jackson annotations (\`@JsonDeserialize\`, \`@JsonSerialize\`, \`@JsonTypeInfo\`, \`@JsonSubTypes\`, \`@JsonProperty\`) and classes implementing \`KubernetesResource\`, and output directly in the \`reachability-metadata.json\` format.

## Code sections where the PR accesses files, network, docker or some external service

- No external access — metadata is static JSON configuration
EOF
)"
```

### 12. Return to the original branch

```bash
cd <fabric8-project-dir>
git checkout -
# Clean up the restored scripts if they weren't in the original tag
git checkout -- scripts/ 2>/dev/null || true
```
