---
name: regen-java-models-from-upstream
description: Fix a failing Renovate Go dependency PR in the Kubernetes model generator. Adapts the generator to upstream Go API changes, regenerates Java models, fixes Java compilation and updates CHANGELOG, pushing the fixes onto the Renovate PR itself.
argument-hint: "<renovate-pr-number-or-url>"
disable-model-invocation: true
allowed-tools: Read, Edit, Write, Grep, Glob, AskUserQuestion, Agent, Bash(${CLAUDE_SKILL_DIR}/scripts/get-dep-context.sh *), Bash(${CLAUDE_SKILL_DIR}/scripts/get-pr-state.sh *), Bash(git rev-parse HEAD), Bash(git status), Bash(git diff --stat)
---

# Go Dependency Bump

You are fixing a Go dependency bump for the Fabric8 Kubernetes Client project.
The user provides a Renovate PR (number or URL). Renovate has already bumped `go.mod`/`go.sum` (and run `go mod tidy`), but CI fails. Your job is to make that PR green: adapt the generator, regenerate models, fix any issues, and **push the fixes as new commits onto the Renovate PR branch**. Only open a separate PR when you cannot push to that branch.

ultrathink

## Running in a Sandbox

The Claude Code sandbox gets in the way of anything that needs the network or credentials: on macOS `gh` and `go` can't verify TLS certificates there (`x509: OSStatus -26276`), `gh` can't read keyring-stored tokens (HTTP 401), and Java ignores the sandbox's network proxy (`Unknown host`). Split the work accordingly.

These run outside the sandbox. The repo's `.claude/settings.json` excludes them in the exact forms this skill uses, so they need nothing extra; only if one still fails with a TLS, auth or `Unknown host` error, rerun it with the sandbox disabled:
- `gh` and the scripts in `${CLAUDE_SKILL_DIR}/scripts/`
- `git fetch`, `git pull` and `git push`
- `go -C kubernetes-model-generator/openapi/generator` with `get`, `mod tidy` or `mod download`, which only fetch and checksum-verify modules
- The Java side: `make openapi-generate-java-classes`, `make format` and `mvn`. They build the project's own code, but download Maven artifacts and CRDs from `raw.githubusercontent.com`

Keep `make openapi-generate-schema` inside the sandbox, with `GOCACHE` pointing at the repo's git-ignored `.cache/go-build`: it compiles and runs the freshly bumped Go modules. Once `go mod download` has filled the module cache, it only writes inside the repo, and what it compiles never lands in the build cache that unsandboxed Go builds use.

If any of these fails anyway, stop and report it to the user rather than moving more commands out of the sandbox. Never disable TLS or checksum verification (e.g. `GOINSECURE`, `GONOSUMDB`, `GOSUMDB=off`, `GIT_SSL_NO_VERIFY`, `-Dmaven.wagon.http.ssl.insecure=true`).

## Pre-fetched Context

```
!`${CLAUDE_SKILL_DIR}/scripts/get-dep-context.sh "$0"`
```

- `!! NO_PR` — ask the user for the Renovate PR number or URL (a `fabric8io/kubernetes-client` PR), then run `${CLAUDE_SKILL_DIR}/scripts/get-dep-context.sh "<pr>"` with the Bash tool.
- `!! GH_FETCH_FAILED` — check the error above it. A TLS or auth error means the injected command ran inside the sandbox: rerun `${CLAUDE_SKILL_DIR}/scripts/get-dep-context.sh "<pr>"` with the Bash tool and the sandbox disabled. Anything else (e.g. `Could not resolve to a PullRequest`) means the PR is wrong: confirm it with the user.
- `!! LOOKUP_FAILED` — only that section's lookup failed. Rerun the script before relying on that section.

## Step 1: Analyze the Renovate PR

From the context above, extract:
- **Single-dep or grouped PR?** — see below.
- **Go module path(s)** (e.g., `sigs.k8s.io/kustomize/api`)
- **Old version** and **new version** for each dep (digest updates show short commit hashes, e.g. `4db47f5` → `d70b66a`)
- **CI failure details** — understand what failed and why
- **Where the fixes go** — see Step 2

### Single-dep vs grouped PR

Renovate groups are configured as `groupName` package rules in `renovate.json` (e.g., `kubernetes`, `openshift`, `knative`, `opentelemetry`, `golang-x`, `operator-framework`, etc.). When a group has multiple eligible updates, Renovate opens a single PR for the whole group.

Signals of a grouped PR:
- Title like `chore(deps): update <group-name>` (single-dep PRs read `chore(deps): update module <module-path> to v<new>` or `chore(deps): update <module-path> digest to <hash>`)
- Branch like `renovate/<group-name>` (single-dep PRs use `renovate/<module-path>-<major>.x` or `renovate/<module-path>-digest`)
- PR body table lists several modules

Extract the **group name** and the **full list of (module, old, new)** tuples from the PR body. All subsequent steps (CHANGELOG, commit) must reflect every dep in the group.

Classify the failure:
1. **Model drift** — `make generate-model` produces different output than what's committed (most common, the "Check No Schema file modified" step fails)
2. **Go compilation error** — the Go code itself fails to build (breaking API changes in the dependency)
3. **Java compilation error** — generated Java models fail to compile (rare, usually type mapping issues)
4. **Transitive dependency conflict** — `go mod tidy` fails or runtime conflicts exist

Present your analysis and the plan to the user. Wait for confirmation via `AskUserQuestion` before proceeding.

## Step 2: Check Out the Renovate PR Branch

Decide where the fixes go:
- **Renovate branch (default)** — `Author` is `app/renovate`, `Head repository` is `fabric8io/kubernetes-client` and your permission is `WRITE`, `MAINTAIN` or `ADMIN`.
- **Separate PR (fallback)** — anything else. Follow the _Fallback_ notes in Steps 2, 3, 6, 8 and 9.

If `State` is not `OPEN`, or `Uncommitted changes` is not `0`, stop and ask the user how to proceed.

The PR state in the context may be stale. Fetch it again right before checking out (the script waits while GitHub still reports `Mergeable: UNKNOWN`, which it computes lazily):

```bash
${CLAUDE_SKILL_DIR}/scripts/get-pr-state.sh <renovate-pr-number>
```

- `MERGEABLE` — continue.
- `CONFLICTING` — ask the user to tick Renovate's rebase/retry checkbox, wait for Renovate to rebase, then fetch the state again. Don't start before it's `MERGEABLE`: once someone else pushes to the branch Renovate stops rebasing it, and ticking the checkbox afterwards discards those commits.
- `UNKNOWN` — run the script again. If it stays `UNKNOWN`, ask the user.

Check out the PR branch (this also works when you're already on it, e.g. in a prepared worktree, and fast-forwards it to Renovate's latest commit), then record `git rev-parse HEAD` as the **base commit**. It must match `Head commit` from the state script; Step 9 compares against it:

```bash
gh pr checkout <renovate-pr-number> --repo fabric8io/kubernetes-client
git rev-parse HEAD
```

_Fallback_: create a branch from an up-to-date `main` instead, named `chore/bump-<short-dep-name>-<new-version>` (e.g., `kustomize-api-0.21.1`, `cert-manager-1.20.0`). For grouped PRs use the group and the shared target version (`chore/bump-kubernetes-0.36.0`), or just the group name when there is none (`chore/bump-knative-group`).

## Step 3: Verify the Dependency Bump

Run Go commands from the project root with `go -C kubernetes-model-generator/openapi/generator`, in the exact forms below (see _Running in a Sandbox_).

### 3a. Check go.mod

Renovate already updated `go.mod`/`go.sum`. Verify that for every bumped module:
- The `require` entry is at the new version.
- Any `replace` pin for the module moved too. A `replace` wins over `require`, so a stale pin silently keeps the old version.

_Fallback_: bump it yourself. For grouped PRs, pass **every** module in one invocation so the solver resolves them together, then update any `replace` pin:

```bash
go -C kubernetes-model-generator/openapi/generator get <module-path>@<new-version> [<module-path>@<new-version> ...]
```

### 3b. Check for related dependencies that may need bumping

Some dependencies are coupled. Common patterns:
- **cluster-api-provider-metal3** often requires bumping `sigs.k8s.io/cluster-api` and related replace directives
- **knative** components may need `knative.dev/pkg` pinned via replace directive
- **OpenShift** components are pinned to specific release branches

Review the Go error output and `go.mod` replace directives to determine if related dependencies need updating.

### 3c. Handle replace directives

Check if the dependency (or any of its transitive dependencies) conflicts with existing `replace` directives in `go.mod`. The file has two replace blocks:
1. **Version convergence** — forces compatible versions across OpenShift/K8s ecosystem
2. **Bot workarounds** — forces pseudo-versions for modules where a dependency bot picks invalid tagged major versions

If a new replace directive is needed, add it to the appropriate block with a comment explaining why.

### 3d. Tidy

If you changed `go.mod` (or on the fallback path):

```bash
go -C kubernetes-model-generator/openapi/generator mod tidy
```

If `go mod tidy` fails, analyze the error. Common fixes:
- Add a `replace` directive to pin a conflicting transitive dependency
- Bump a related dependency to a compatible version

## Step 4: Generate Models

Fill the Go module cache first (outside the sandbox):

```bash
go -C kubernetes-model-generator/openapi/generator mod download
```

Then, from the **project root**, run the two targets `make generate-model` consists of, one at a time so the Go half can stay sandboxed (see _Running in a Sandbox_):

```bash
GOCACHE="$PWD/.cache/go-build" make openapi-generate-schema  # inside the sandbox
make openapi-generate-java-classes                           # outside the sandbox
```

**IMPORTANT**: Together these take ~10-15 minutes. Run them with a suitable timeout (600000ms). Do NOT cancel them.

**CRITICAL**: Always generate through these make targets from the project root. NEVER build the Go binary manually or run generator commands individually. If `openapi-generate-java-classes` fails partway, it can leave a model module's generated sources deleted: regenerate, don't commit that state.

### If model generation fails

Common issues and fixes:

#### Go compilation errors
- A type or variable was renamed/removed in the new dependency version (e.g. `GroupVersion` renamed to `SchemeGroupVersion`)
- Fix: update references in Go code (e.g., `cmd/supported-apis.go`, `cmd/reflection.go`, `pkg/packages/packages.go`, `pkg/openapi/openapi-gen-processors.go`)
- After fixing, re-run both generation targets

#### Java compilation errors
- Generated Java code references a type that no longer exists
- Fix: may need `refToJavaTypeMappings` in the relevant module's `pom.xml`, or import path updates
- After fixing, re-run both generation targets

#### Generator logic issues
- New upstream patterns (nested inline embeds, new protobuf patterns) not handled by the generator
- Fix: update processor code in `kubernetes-model-generator/openapi/generator/pkg/openapi/openapi-gen-processors.go`
- After fixing, re-run both generation targets

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

Edit `CHANGELOG.md` and add entries under the current SNAPSHOT section (e.g. `### 8.0-SNAPSHOT`).

Reference the Renovate PR number: `Fix #<renovate-pr-number>`.
_Fallback_: use `Fix #PLACEHOLDER` — the real PR number is not known yet (see Step 10).

**IMPORTANT — Alphabetical ordering**: Insert all entries in **alphabetical order by dependency/topic name** within each section. This is critical for avoiding merge conflicts when multiple dependency bumps run in parallel — each entry lands at a deterministic position, allowing Git to auto-merge.

### Dependency Upgrade entry (always)

Under `#### Dependency Upgrade`, insert in alphabetical order by the readable dependency name:

```
* Fix #<renovate-pr-number>: bump <readable-dep-name> from <old-version> to <new-version>
```

For example, "bump cert-manager..." goes before "bump gateway-api..." which goes before "bump tekton...".

**For grouped PRs**, emit **one entry per dep in the group**, each in its own alphabetical position, all with the same PR number.

### Bug fix entry (if generator code was fixed)

Under `#### Bugs`, insert in alphabetical order by topic:

```
* Fix #<renovate-pr-number>: <description of what was fixed in the generator>
```

### Breaking changes entry (if applicable)

Under `#### _**Note**_: Breaking changes`, insert in alphabetical order by module/topic. Add entries for:
- Removed model classes
- Renamed/moved packages
- Changed type hierarchies

Format:

```
* Fix #<renovate-pr-number>: <module> model `<ClassName>` removed
* Fix #<renovate-pr-number>: <module> model classes moved from package `old.package` to `new.package`
```

### Identifying breaking changes

Compare the generated schemas before and after. Key indicators:
- Files deleted from `src/generated/java/` directories
- Package path changes in generated classes
- Type renames visible in the OpenAPI schema diff

New fields are backward compatible, even though they add a parameter to the generated all-args constructor. They don't need a breaking changes entry.

## Step 7: Format Code

```bash
make format
```

## Step 8: Commit

Stage all changes and create a single commit. Renovate's commit already carries the version bump, so describe what you added on top:

```
chore(deps): regenerate models for <readable-dep-name> <new-version>

<Optional: explanation of special handling — generator fixes, replace directives, cascade bumps>
```

**For grouped PRs**, use `chore(deps): regenerate models for the <group-name> group`.

_Fallback_: the commit carries the bump itself and closes the Renovate PR:

```
chore(deps): bump <readable-dep-name> from <old-version> to <new-version>

<Optional: explanation of special handling>

Closes #<renovate-pr-number>
```

For grouped PRs: subject `chore(deps): bump the <group-name> group`, and list each `<module-path> from <old> to <new>` in the body.

## Step 9: Push

Generating and building takes long enough for the PR to move meanwhile, e.g. a sibling bump merges and Renovate rebases this branch. Fetch the state again right before pushing:

```bash
${CLAUDE_SKILL_DIR}/scripts/get-pr-state.sh <renovate-pr-number>
```

- `Head commit` differs from the base commit — Renovate rebased the branch. Follow _Branch moved_ below.
- `CONFLICTING` with the same head commit — nothing of yours is on the branch yet: ask the user to tick Renovate's rebase/retry checkbox, wait for the rebase, then follow _Branch moved_.
- `UNKNOWN` — run the script again.
- `MERGEABLE` with the same head commit — push.

Push explicitly to the PR's head branch. A bare `git push` follows `remote.pushDefault`, which may point at your fork:

```bash
git push "$(git config branch.<head-branch>.remote)" HEAD:refs/heads/<head-branch>
```

**NEVER force-push** — it would rewrite Renovate's commits. A rejected push means the branch moved: follow _Branch moved_.

Run `get-pr-state.sh` once more and check that `Head commit` now equals `git rev-parse HEAD`, i.e. the push landed on the PR. CI re-runs automatically. Remind the user not to tick Renovate's rebase/retry checkbox from now on, since that would discard the pushed commits.

### Branch moved

Replay your commit onto the new head. The new base can change the generator's output, so regenerate even if the rebase is clean:

```bash
git fetch "$(git config branch.<head-branch>.remote)" <head-branch>
git rebase --onto FETCH_HEAD <base-commit>
```

On conflicts, merge hand-written files (Go code, `pom.xml`, `CHANGELOG.md`) by keeping both sides' changes. Generated files (`kubernetes-model-generator/openapi/schemas/`, `src/generated/`, `src/generated-builders/`) can take either side, since they're regenerated next. Then redo Steps 3–7 on the new base, amend your commit, record `git rev-parse FETCH_HEAD` as the new base commit, and start Step 9 again.

### Conflicts after your push

Renovate doesn't rebase a branch someone else pushed to, so if the PR turns `CONFLICTING` later, merge `main` into it instead:

```bash
git fetch "$(git config branch.<head-branch>.remote)" main
git merge FETCH_HEAD
```

Resolve conflicts as in _Branch moved_, redo Steps 3–7, commit, and push with the explicit command above.

_Fallback_: push the branch to your fork and create the PR:

```
gh pr create --repo fabric8io/kubernetes-client --head <fork-owner>:<branch-name> --title "chore(deps): bump <dep> from <old> to <new>" --body "$(cat <<'EOF'
## Summary
<1-3 bullet points describing what changed>

Closes #<renovate-pr-number>
EOF
)"
```

**For grouped PRs**, mirror the commit style — title `chore(deps): bump the <group-name> group`, body `## Summary` lists each `<module-path> from <old> to <new>` as bullets.

**IMPORTANT**: Do NOT include a "Test plan" section or "Generated with Claude Code" footer in the PR body.

## Step 10 (Fallback only): Update CHANGELOG with Real PR Number

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
| `kubernetes-model-generator/openapi/generator/cmd/supported-apis.go` | Imports every supported API group (group/version identifiers) |
| `kubernetes-model-generator/openapi/generator/cmd/reflection.go` | Reflection-based schema generation (type lists, import paths) |
| `kubernetes-model-generator/openapi/generator/cmd/openapi.go` | OpenAPI schema generation (module definitions) |
| `kubernetes-model-generator/openapi/generator/pkg/packages/packages.go` | Package glob patterns for each API group |
| `kubernetes-model-generator/openapi/generator/pkg/openapi/openapi-gen-processors.go` | Field/package processors (handles inline embeds, protobuf, etc.) |
| `kubernetes-model-generator/openapi/generator/pkg/openapi/openapi-gen.go` | Main generator orchestration |
| `kubernetes-model-generator/openapi/generator/pkg/parser/parser.go` | Extracts fabric8 metadata from Go types |
| `kubernetes-model-generator/openapi/schemas/*.json` | Generated OpenAPI schemas |
| `kubernetes-model-generator/openapi/maven-plugin/src/it/*/expected/` | Integration test expected output |
| `renovate.json` | Renovate groups and Go module update rules |
| `CHANGELOG.md` | Release changelog |

## Reference: Common Dependency Relationships

| Dependency | Often requires |
|-----------|---------------|
| `cluster-api-provider-metal3` | Bumping `sigs.k8s.io/cluster-api`, `sigs.k8s.io/cluster-api-provider-azure`, update replace directives |
| `knative.dev/eventing-*` | May need `knative.dev/pkg` replace directive pinned |
| `tektoncd/*` | Usually straightforward |
| `cert-manager` | Usually straightforward |
| `chaos-mesh/chaos-mesh/api` | Digest updates; the pseudo-version is also pinned in the bot workarounds `replace` block |
| `prometheus-operator` | May expose inline embed edge cases in generator |
| `openshift/*` | Pinned to release branches via replace directives |
| `sigs.k8s.io/kustomize/*` | May need `sigs.k8s.io/kustomize/kyaml` bumped together |
