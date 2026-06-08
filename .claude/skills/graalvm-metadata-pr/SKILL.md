---
name: graalvm-metadata-pr
description: Use when generating GraalVM reachability metadata from the Fabric8 Kubernetes Client and raising a PR against oracle/graalvm-reachability-metadata. Triggers include creating a PR for GraalVM native image support, generating reachability-metadata.json for fabric8 modules, updating GraalVM metadata for a new fabric8 release tag, or contributing metadata to the GraalVM reachability metadata repo.
argument-hint: "<tag-or-commit-id> [strategy]"
disable-model-invocation: true
allowed-tools: Read, Edit, Write, Grep, Glob, Bash(make *), Bash(mvn *), Bash(git *), Bash(gh *), Bash(jbang *), Bash(find *), Bash(cp *), Bash(mkdir *), Bash(rm *), Bash(python3 *), Bash(sed *), Bash(wc *), Bash(chmod *), Bash(${CLAUDE_SKILL_DIR}/scripts/*), WebFetch, AskUserQuestion
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

### 1. Preserve the generation scripts and skill helper scripts

The JBang scripts and skill helper scripts do not exist in older tags/commits. Copy them to `/tmp/` before checking out.

```bash
cp scripts/GenerateGraalvmMetadata.java /tmp/GenerateGraalvmMetadata.java
cp scripts/GenerateAllGraalvmMetadata.java /tmp/GenerateAllGraalvmMetadata.java
cp ${CLAUDE_SKILL_DIR}/scripts/create-or-update-index.sh /tmp/create-or-update-index.sh
cp ${CLAUDE_SKILL_DIR}/scripts/collect-metadata-summary.sh /tmp/collect-metadata-summary.sh
```

If `${CLAUDE_SKILL_DIR}` is not accessible (e.g. running outside the skill context), extract from git:
```bash
git show <branch>:.claude/skills/graalvm-metadata-pr/scripts/create-or-update-index.sh > /tmp/create-or-update-index.sh
git show <branch>:.claude/skills/graalvm-metadata-pr/scripts/collect-metadata-summary.sh > /tmp/collect-metadata-summary.sh
chmod +x /tmp/create-or-update-index.sh /tmp/collect-metadata-summary.sh
```

### 2. Record the current branch for later return

```bash
ORIGINAL_BRANCH=$(git branch --show-current)
```

### 3. Checkout the target tag or commit

```bash
git checkout $0
```

### 4. Restore the generation scripts and skill helper scripts

Copy the scripts back into the checked-out tree. The `.claude/skills/` directory won't exist in older tags — recreate it.

```bash
mkdir -p scripts
cp /tmp/GenerateGraalvmMetadata.java scripts/GenerateGraalvmMetadata.java
cp /tmp/GenerateAllGraalvmMetadata.java scripts/GenerateAllGraalvmMetadata.java

mkdir -p .claude/skills/graalvm-metadata-pr/scripts
cp /tmp/create-or-update-index.sh .claude/skills/graalvm-metadata-pr/scripts/create-or-update-index.sh
cp /tmp/collect-metadata-summary.sh .claude/skills/graalvm-metadata-pr/scripts/collect-metadata-summary.sh
```

### 5. Build the project to generate Jandex indexes

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

### 6. Run the JBang metadata generator

```bash
jbang scripts/GenerateAllGraalvmMetadata.java -s ${1:-JACKSON_ANNOTATIONS}
```

This scans every module's Jandex index and writes a `reachability-metadata.json` at:
```
<module>/target/classes/META-INF/native-image/io.fabric8/<artifactId>/reachability-metadata.json
```

The output is already in the oracle repo's required format (`{"reflection": [...]}` with `typeReached` and `type` fields).

The script prints a summary showing which modules produced metadata (`WROTE`), which had no matching classes (`EMPTY`/`No matches`), and which were skipped (`SKIP` — no Jandex index).

### 7. Collect and summarize the generated files

Use the helper script to list all generated files with entry counts:

```bash
.claude/skills/graalvm-metadata-pr/scripts/collect-metadata-summary.sh "$(pwd)" "/tmp/graalvm-reachability-metadata"
```

This prints both a terminal summary table and a markdown table for the PR body.

**Exclude `kubernetes-examples`** — it produces metadata but is a test/example module, not a library.

### 8. Determine the version

Extract the version from the tag or from the root `pom.xml`:

```bash
# From tag (strip leading 'v')
VERSION=$(echo "$0" | sed 's/^v//')

# Or from pom.xml if using a commit ID
VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
```

---

## Phase 3: Place in oracle repo

### 9. Fork/clone the oracle repo

```bash
gh repo fork oracle/graalvm-reachability-metadata --clone=false 2>/dev/null || true
gh repo clone $(gh api user --jq '.login')/graalvm-reachability-metadata /tmp/graalvm-reachability-metadata
cd /tmp/graalvm-reachability-metadata
git checkout -b fabric8-metadata-${VERSION}
```

**Note:** The clone can be slow (25k+ files). Run it in the background while collecting metadata.

### 10. Copy each module's metadata and create index.json

For each module with a generated `reachability-metadata.json`:

```bash
# Copy the metadata file
mkdir -p metadata/io.fabric8/<artifactId>/${VERSION}
cp <path-to-generated>/reachability-metadata.json metadata/io.fabric8/<artifactId>/${VERSION}/

# Create or update index.json using the helper script
.claude/skills/graalvm-metadata-pr/scripts/create-or-update-index.sh /tmp/graalvm-reachability-metadata <artifactId> ${VERSION}
```

The `create-or-update-index.sh` script handles:
- Deriving `allowed-packages` from the artifactId (maps module names to Java package prefixes)
- Generating a two-sentence `description`
- For existing modules: adding the version to `tested-versions`
- For new modules: creating a complete `index.json`

Loop over all modules (excluding `kubernetes-examples`):

```bash
find <project-root> -path '*/META-INF/native-image/io.fabric8/*/reachability-metadata.json' -type f | grep -v kubernetes-examples | sort | while read f; do
  aid=$(echo "$f" | sed 's|.*io\.fabric8/\([^/]*\)/reachability-metadata\.json|\1|')
  mkdir -p /tmp/graalvm-reachability-metadata/metadata/io.fabric8/${aid}/${VERSION}
  cp "$f" /tmp/graalvm-reachability-metadata/metadata/io.fabric8/${aid}/${VERSION}/reachability-metadata.json
  .claude/skills/graalvm-metadata-pr/scripts/create-or-update-index.sh /tmp/graalvm-reachability-metadata "$aid" "${VERSION}"
done
```

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

### 11. Commit the changes

```bash
cd /tmp/graalvm-reachability-metadata
git add metadata/io.fabric8/
git commit -m "Add GraalVM reachability metadata for io.fabric8 modules (${VERSION})"
```

### 12. Push and create the draft PR

The draft PR is created against the user's fork by default. Use the markdown module table from `collect-metadata-summary.sh` in the PR body.

```bash
git push -u origin fabric8-metadata-${VERSION}

gh pr create \
  --repo <user-fork>/graalvm-reachability-metadata \
  --draft \
  --title "Add GraalVM reachability metadata for io.fabric8 modules (${VERSION})" \
  --body "$(cat <<EOF
## What does this PR do?

Adds GraalVM reachability metadata for Fabric8 Kubernetes Client modules at version ${VERSION}.

The [Fabric8 Kubernetes Client](https://github.com/fabric8io/kubernetes-client) is a Java client library providing access to the Kubernetes REST API via a fluent DSL. These modules heavily use Jackson annotations and Sundrio-generated builders, requiring reflection metadata for GraalVM native image.

### Modules included

<paste markdown table from collect-metadata-summary.sh>

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

### 13. Return to the original branch

The restored scripts are untracked files in the checked-out tag — `git checkout -- scripts/` will NOT work. Delete them first, then switch back.

```bash
cd <fabric8-project-dir>
rm scripts/GenerateGraalvmMetadata.java scripts/GenerateAllGraalvmMetadata.java
rm -rf .claude/skills/graalvm-metadata-pr
git checkout ${ORIGINAL_BRANCH}
```

---

## Gotchas and known issues

- **`status` is a read-only variable in zsh.** Do not use `status` as a variable name in shell commands. Use `oracle_tag`, `st`, or another name.
- **Returning to the original branch after detached HEAD checkout.** The restored JBang scripts are untracked files that block `git checkout`. You must `rm` them before switching branches — `git checkout -- scripts/` does not remove untracked files.
- **`kubernetes-examples` generates metadata** (typically 1 entry) but should be excluded — it's a test/example module, not a published library.
- **The oracle repo clone is large** (~25k files). Start it in the background early or use `--depth 1` for a shallow clone.
- **`index.json` format is strict.** The `allowed-packages` must match exactly what the oracle repo's `checkMetadataFiles` expects. Use the `create-or-update-index.sh` script to derive them automatically.
- **Skill helper scripts are lost after checkout** — `.claude/skills/` doesn't exist in older tags. Phase 1 copies them to `/tmp/`, then Phase 4 (step 4) recreates `.claude/skills/graalvm-metadata-pr/scripts/` in the checked-out tree and restores them there. All post-checkout steps reference the restored path, not `/tmp/`. The `get-graalvm-context.sh` script does NOT need preserving — it runs as pre-fetched context before the checkout happens. Clean up the recreated `.claude/` directory before returning to the original branch (step 13).
