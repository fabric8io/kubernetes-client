---
name: bump-go-dep
description: Bump a Go dependency from a failing Dependabot PR in the Kubernetes model generator. Regenerates models, fixes breaking changes, updates CHANGELOG, and creates a new PR that closes the Dependabot one.
argument-hint: "<dependabot-pr-number>"
disable-model-invocation: true
allowed-tools: Read, Edit, Write, Grep, Glob, Bash, AskUserQuestion, Agent
---

# Go Dependency Bump

You are performing a Go dependency bump for the Fabric8 Kubernetes Client project.
The user provides a Dependabot PR number. Your job is to bump the dependency, regenerate models, fix any issues, and create a clean PR that closes the Dependabot one. The user may already be on a dedicated branch (e.g., in a git worktree) — detect this and skip branch creation if so.

ultrathink

## Pre-fetched Context

```
!`${CLAUDE_SKILL_DIR}/scripts/get-dep-context.sh $0`
```

## Step 1: Analyze the Dependabot PR

From the context above, extract:
- **Single-dep or grouped PR?** — see below.
- **Go module path(s)** (e.g., `sigs.k8s.io/kustomize/api`)
- **Old version** and **new version** for each dep
- **CI failure details** — understand what failed and why

### Single-dep vs grouped PR

Dependabot groups are configured in `.github/dependabot.yml` (e.g., `kubernetes`, `openshift`, `knative`, `opentelemetry`, `golang-x`, `operator-framework`, etc.). When a group has multiple eligible updates, Dependabot opens a single PR for the whole group.

Signals of a grouped PR:
- Title like `chore(deps): bump the <group-name> group in /... with N updates`
- Branch like `dependabot/go_modules/.../<group-name>-<hash>`
- PR body lists multiple `Updates ...` blocks

Extract the **group name** and the **full list of (module, old, new)** tuples from the PR body. All subsequent steps (branch, CHANGELOG, commit, PR) must reflect every dep in the group.

Classify the failure:
1. **Model drift** — `make generate-model` produces different output than what's committed (most common, the "Check No Schema file modified" step fails)
2. **Go compilation error** — the Go code itself fails to build (breaking API changes in the dependency)
3. **Java compilation error** — generated Java models fail to compile (rare, usually type mapping issues)
4. **Transitive dependency conflict** — `go mod tidy` fails or runtime conflicts exist

Present your analysis and the plan to the user. Wait for confirmation via `AskUserQuestion` before proceeding.

## Step 2: Prepare Working Branch

First, check the current branch:

```bash
git branch --show-current
```

- **If already on a non-main branch** (e.g., in a git worktree prepared for this task): use the current branch as-is. Do NOT create a new branch or switch to main.
- **If on `main`**: create a new branch:

```bash
git pull --rebase origin main
git checkout -b chore/bump-<short-dep-name>-<new-version>
```

Use a short, readable name for the dependency (e.g., `kustomize-api-0.21.1`, `gateway-api-1.5.0`, `cert-manager-1.20.0`).

**For grouped PRs**, name the branch after the group and the shared target version when there is one (e.g., `chore/bump-kubernetes-0.36.0`, `chore/bump-opentelemetry-1.43.0`). If there is no single shared version, just use the group name (e.g., `chore/bump-knative-group`).

## Step 3: Bump the Dependency

### 3a. Update go.mod

```bash
cd kubernetes-model-generator/openapi/generator
go get <module-path>@v<new-version>
```

**For grouped PRs**, run `go get` for **every** module in the group, each at its target version. Do this in one invocation when possible (`go get foo@v1 bar@v2 baz@v3`) so the solver resolves them together.

### 3b. Check for related dependencies that may need bumping

Some dependencies are coupled. Common patterns:
- **cluster-api-provider-metal3** often requires bumping `sigs.k8s.io/cluster-api` and related replace directives
- **knative** components may need `knative.dev/pkg` pinned via replace directive
- **OpenShift** components are pinned to specific release branches

Review the Go error output and `go.mod` replace directives to determine if related dependencies need updating.

### 3c. Handle replace directives

Check if the dependency (or any of its transitive dependencies) conflicts with existing `replace` directives in `go.mod`. The file has two replace blocks:
1. **Version convergence** — forces compatible versions across OpenShift/K8s ecosystem
2. **Dependabot workarounds** — forces pseudo-versions for modules where Dependabot picks invalid tagged major versions

If a new replace directive is needed, add it to the appropriate block with a comment explaining why.

### 3d. Tidy

```bash
go mod tidy
```

If `go mod tidy` fails, analyze the error. Common fixes:
- Add a `replace` directive to pin a conflicting transitive dependency
- Bump a related dependency to a compatible version

### 3e. Return to project root

```bash
cd /path/to/kubernetes-client
```

## Step 4: Generate Models

Run from the **project root**:

```bash
make generate-model
```

**IMPORTANT**: This is a long-running command (~10-15 minutes). Run it with a suitable timeout (600000ms). Do NOT cancel it.

**CRITICAL**: Always use `make generate-model` from the project root. NEVER build the Go binary manually or run generator commands individually.

### If model generation fails

Common issues and fixes:

#### Go compilation errors
- A type was renamed/removed in the new dependency version
- Fix: update references in Go code (e.g., `cmd/reflection.go`, `pkg/packages/packages.go`, `pkg/openapi/openapi-gen-processors.go`)
- After fixing, re-run `make generate-model`

#### Java compilation errors
- Generated Java code references a type that no longer exists
- Fix: may need `refToJavaTypeMappings` in the relevant module's `pom.xml`, or import path updates
- After fixing, re-run `make generate-model`

#### Generator logic issues
- New upstream patterns (nested inline embeds, new protobuf patterns) not handled by the generator
- Fix: update processor code in `kubernetes-model-generator/openapi/generator/pkg/openapi/openapi-gen-processors.go`
- After fixing, re-run `make generate-model`

## Step 5: Check for Additional Issues

### 5a. Integration test expected files

Check if integration test `.expected` files need updating:

```bash
# These are in:
# kubernetes-model-generator/openapi/maven-plugin/src/it/*/expected/
```

If the generated output changed for types covered by these expected files, update them to match.

### 5b. Stale references in non-generated code

Search for references to types that may have been deleted or renamed:

```bash
# Look for compilation errors or stale references
```

If the upstream dependency renamed/reorganized packages, you may need to:
- Update import paths in Go code (`cmd/reflection.go`)
- Add type mappings in Maven `pom.xml` (`refToJavaTypeMappings`)
- Update package patterns in `pkg/packages/packages.go`

### 5c. Verify Java compilation

```bash
mvn clean install -DskipTests -T 1C 2>&1 | tail -50
```

If specific modules fail, build just those modules to get clearer error messages:

```bash
mvn clean install -pl <failing-module> -am -DskipTests -T 1C
```

## Step 6: Update CHANGELOG

Edit `CHANGELOG.md` and add entries under the `### 7.7-SNAPSHOT` section (or whatever the current SNAPSHOT version is).

**IMPORTANT — Alphabetical ordering**: Insert all entries in **alphabetical order by dependency/topic name** within each section. This is critical for avoiding merge conflicts when multiple dependency bumps run in parallel — each entry lands at a deterministic position, allowing Git to auto-merge.

Use `PLACEHOLDER` — the real PR number is not known yet.

### Dependency Upgrade entry (always)

Under `#### Dependency Upgrade`, insert in alphabetical order by the readable dependency name:

```
* Fix #PLACEHOLDER: bump <readable-dep-name> from <old-version> to <new-version>
```

For example, "bump cert-manager..." goes before "bump gateway-api..." which goes before "bump tekton...".

**For grouped PRs**, emit **one entry per dep in the group**, each in its own alphabetical position. Use the same `#PLACEHOLDER` for all of them — they all resolve to the single fix PR number in Step 10.

### Bug fix entry (if generator code was fixed)

Under `#### Bugs`, insert in alphabetical order by topic:

```
* Fix #PLACEHOLDER: <description of what was fixed in the generator>
```

### Breaking changes entry (if applicable)

Under `#### _**Note**_: Breaking changes`, insert in alphabetical order by module/topic. Add entries for:
- Removed model classes
- Renamed/moved packages
- Changed type hierarchies

Format:

```
* Fix #PLACEHOLDER: <module> model `<ClassName>` removed
* Fix #PLACEHOLDER: <module> model classes moved from package `old.package` to `new.package`
```

### Identifying breaking changes

Compare the generated schemas before and after. Key indicators:
- Files deleted from `src/generated/java/` directories
- Package path changes in generated classes
- Type renames visible in the OpenAPI schema diff

## Step 7: Format Code

```bash
make format
```

## Step 8: Commit

Stage all changes and create a single commit:

```
chore(deps): bump <readable-dep-name> from <old-version> to <new-version>

<Optional: explanation of special handling — replace directives, generator fixes, cascade bumps>

Closes #<dependabot-pr-number>
```

**IMPORTANT**: Include `Closes #<dependabot-pr-number>` to auto-close the Dependabot PR.

**For grouped PRs**, use a group-level subject and list each dep in the body:

```
chore(deps): bump the <group-name> group

- <module-path> from <old> to <new>
- <module-path> from <old> to <new>
- ...

Closes #<dependabot-pr-number>
```

## Step 9: Push and Create PR

Push the branch and create the PR:

```bash
git push -u origin <branch-name>
```

Create the PR with `gh pr create`. The PR body format:

```
gh pr create --repo fabric8io/kubernetes-client --title "chore(deps): bump <dep> from <old> to <new>" --body "$(cat <<'EOF'
## Summary
<1-3 bullet points describing what changed>

Closes #<dependabot-pr-number>
EOF
)"
```

**For grouped PRs**, mirror the commit style — title `chore(deps): bump the <group-name> group`, body `## Summary` lists each `<module-path> from <old> to <new>` as bullets, and closes the single Dependabot group PR.

**IMPORTANT**: Do NOT include a "Test plan" section or "Generated with Claude Code" footer in the PR body.

## Step 10: Update CHANGELOG with Real PR Number

After the PR is created, you'll have the real PR number. Update `CHANGELOG.md`:

1. Replace all `PLACEHOLDER` references for this bump with the actual PR number
2. Commit the update:

```
chore: update CHANGELOG with PR #<pr-number> reference
```

3. Push the update.

## Reference: Project Structure

Key files you may need to read or modify:

| File | Purpose |
|------|---------|
| `kubernetes-model-generator/openapi/generator/go.mod` | Go dependency versions and replace directives |
| `kubernetes-model-generator/openapi/generator/go.sum` | Go dependency checksums (auto-managed) |
| `kubernetes-model-generator/openapi/generator/cmd/reflection.go` | Reflection-based schema generation (type lists, import paths) |
| `kubernetes-model-generator/openapi/generator/cmd/openapi.go` | OpenAPI schema generation (module definitions) |
| `kubernetes-model-generator/openapi/generator/pkg/packages/packages.go` | Package glob patterns for each API group |
| `kubernetes-model-generator/openapi/generator/pkg/openapi/openapi-gen-processors.go` | Field/package processors (handles inline embeds, protobuf, etc.) |
| `kubernetes-model-generator/openapi/generator/pkg/openapi/openapi-gen.go` | Main generator orchestration |
| `kubernetes-model-generator/openapi/generator/pkg/parser/parser.go` | Extracts fabric8 metadata from Go types |
| `kubernetes-model-generator/openapi/schemas/*.json` | Generated OpenAPI schemas |
| `kubernetes-model-generator/openapi/maven-plugin/src/it/*/expected/` | Integration test expected output |
| `CHANGELOG.md` | Release changelog |

## Reference: Common Dependency Relationships

| Dependency | Often requires |
|-----------|---------------|
| `cluster-api-provider-metal3` | Bumping `sigs.k8s.io/cluster-api`, `sigs.k8s.io/cluster-api-provider-azure`, update replace directives |
| `knative.dev/eventing-*` | May need `knative.dev/pkg` replace directive pinned |
| `tektoncd/*` | Usually straightforward |
| `cert-manager` | Usually straightforward |
| `prometheus-operator` | May expose inline embed edge cases in generator |
| `openshift/*` | Pinned to release branches via replace directives |
| `sigs.k8s.io/kustomize/*` | May need `sigs.k8s.io/kustomize/kyaml` bumped together |
