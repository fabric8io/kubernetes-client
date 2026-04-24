---
name: k8s-model-update
description: Updates Fabric8 Kubernetes Client models and DSL when a new Kubernetes version is released. Handles downloading the OpenAPI spec, regenerating Java models, analyzing API changes (new GA resources, graduations, deprecations, removals), updating the client DSL, and raising a PR. Use this skill whenever the user mentions updating Kubernetes models, bumping a K8s version, generating models from an OpenAPI spec, supporting a new Kubernetes release, or downloading swagger.json for a new K8s version — even if they don't say "skill" or "model update" explicitly.
argument-hint: "<k8s-version> <github-issue-number>"
disable-model-invocation: true
allowed-tools: Read, Edit, Write, Grep, Glob, Bash(make *), Bash(mvn *), Bash(git *), Bash(gh *), Bash(java *), Bash(${CLAUDE_SKILL_DIR}/scripts/*), Bash(du *), Bash(find *), WebSearch, WebFetch, AskUserQuestion
---

# Kubernetes Model Update

You are updating the Fabric8 Kubernetes Client to support a new Kubernetes release — from downloading the OpenAPI spec through model generation, change analysis, DSL updates, and PR creation.

The process has three user-confirmation checkpoints so nothing ships without review.

### Arguments

- `$0` — The Kubernetes version (e.g., `1.36.0`) **(required)**
- `$1` — The GitHub issue number for this update (e.g., `7500`) **(required)**

### Pre-fetched Context

```
!`${CLAUDE_SKILL_DIR}/scripts/get-update-context.sh $0 $1`
```

---

## Prerequisites

- **Minimum Java 11** — required to build and run the project.
- **Java 11 is the preferred JDK for model generation** (`make generate-model`). JDK 25 is NOT supported.
- **`make format` requires minimum Java 17** — the Spotless formatter and license-header tooling need JDK 17+.

Before starting, verify the active JDK version (`java -version`). Switch JDK versions between steps as needed (e.g., JDK 11 for generation, JDK 17+ for formatting).

---

## Phase 1: Setup and Model Generation

### 1. Create a working branch

```
git checkout -b k8s-releases/k8s-$0
```

### 2. Build the base project

Run `make quickly` to confirm a clean starting state (~3-5 minutes). Fix any failures before continuing.

### 3. Download the OpenAPI spec

Use the bundled download script:

```
!`${CLAUDE_SKILL_DIR}/scripts/download-k8s-schema.sh $0`
```

The script auto-detects the project root and saves the spec as `kubernetes-model-generator/openapi/schemas/kubernetes-$0.json`.

### 4. Update the schema path

In `kubernetes-model-generator/pom.xml`, update the `<openapi.schema.kubernetes-latest>` property in the `<properties>` section to point to the new file:

```xml
<openapi.schema.kubernetes-latest>${project.parent.basedir}/openapi/schemas/kubernetes-$0.json</openapi.schema.kubernetes-latest>
```

### 5. Generate updated models

```
make generate-model
```

This runs the Go-based OpenAPI generator and Maven code-generation plugin across all `kubernetes-model-*` modules. Takes several minutes.

**When `make generate-model` fails with unknown types or unresolved imports:**

Do **NOT** modify Go code, update Go dependencies, or change anything in the generator project itself. Instead, fix the issue in the failing model module's `pom.xml` by adding a `refToJavaTypeMappings` entry that maps the unresolved schema reference to a Java type.

For example, in `kubernetes-model-generator/openshift-model-installer/pom.xml`:

```xml
<refToJavaTypeMappings>
  <property>
    <name>#/components/schemas/com.github.openshift.installer.pkg.ipnet.IPNet</name>
    <value>java.lang.String</value>
  </property>
  <property>
    <name>#/components/schemas/com.github.openshift.installer.pkg.types.azure.MachinePool</name>
    <value>java.lang.Object</value>
  </property>
</refToJavaTypeMappings>
```

Map to `java.lang.String` for simple value types (IPs, names) and `java.lang.Object` for complex types that don't have a corresponding model in the client. Find the failing module, locate its `pom.xml`, and identify the mapping needed.

**Always present the proposed `refToJavaTypeMappings` changes to the user and get explicit approval before modifying any `pom.xml`.** Show which module, which schema refs, and which Java types you plan to map them to.

After fixing, re-run `make generate-model` until it succeeds.

### 6. Verify the build compiles

```
make quickly
```

If the build fails, investigate and fix before continuing.

---

## Phase 2: Investigation

Understanding what changed is essential — it determines which DSL updates are needed and what to communicate in the PR.

### 7. Analyze the diff

Run `git diff --stat` and `git diff` against the generated changes. Categorize into:

| Category | What to look for |
|----------|-----------------|
| **New GA APIs** | New classes appearing directly in `v1` packages for the first time |
| **Graduated APIs** | Resources that moved from `v1alpha*`/`v1beta*` to `v1` — look for new `v1` files that mirror existing alpha/beta ones |
| **Deprecated APIs** | Fields or resources with new deprecation annotations |
| **Removed APIs** | Deleted classes or fields |
| **Model field changes** | New fields, type changes, renamed fields in existing resources |

Pay special attention to the `kubernetes-model-*` submodules that changed — each corresponds to a K8s API group (apps, batch, networking, etc.).

### 8. Cross-reference with the release blog

Search for the official release blog at `https://kubernetes.io/blog/` for the target version. The blog covers major themes, graduated features, deprecations, and removals. Use it to:

- Verify your diff analysis matches the highlighted changes
- Catch behavioral changes not reflected in models
- Find the release code name (needed for CHANGELOG entry)

### 9. Write the investigation report

Create a detailed markdown file at `k8s-$0-investigation.md` in the project root. This file is for local reference only — **do not commit it**.

Structure:

```markdown
# Kubernetes <version> (<Release Name>) — Investigation Report

## Overview
Release theme and scope of model changes.

## New GA/Stable APIs
Each new GA resource: API group, kind, purpose.

## Graduated APIs (alpha/beta → GA)
Each graduation: source version → v1, what changed in the process.

## Deprecated APIs
Resources/fields deprecated, timeline if known.

## Removed APIs
Resources/fields removed, replacements if any.

## Significant Model Changes
Field additions, type changes, structural modifications worth noting.

## Release Blog Highlights
Key themes and features from the official blog.

## DSL Candidates
APIs that graduated to GA and likely need DSL additions in the client.
```

---

### CHECKPOINT 1

Present the investigation findings to the user. Show the categorized changes and the DSL candidates list. Confirm accuracy before proceeding.

Also present a preview of the GitHub issue comment (under 30 lines, linking the release blog and highlighting the most impactful changes). **Get explicit approval before posting** to issue #$1, since this is publicly visible.

```bash
gh issue comment $1 --body "..."
```

---

## Phase 3: DSL Updates

### 11. Present DSL candidates

From the investigation, list every API that graduated to GA and could benefit from a dedicated DSL method. For each candidate, note:

- API group and resource kind
- Whether it's a new API group or an addition to an existing one
- Whether the resource is namespaced or cluster-scoped

---

### CHECKPOINT 2

Present the candidates and let the user decide which ones to implement. Do not proceed until the user confirms.

---

### 12. Implement DSL changes

For each user-approved API, follow the established pattern in the codebase. The exact files depend on whether the resource belongs to an existing API group or a new one.

**Adding a resource to an existing API group** (e.g., `FooBar` in `storage.k8s.io/v1`):

Three files to touch:

1. **DSL interface** — add the method to the existing `V1<Group>APIGroupDSL.java` in `kubernetes-client-api/src/main/java/io/fabric8/kubernetes/client/dsl/`:

   ```java
   // Use NonNamespaceOperation for cluster-scoped resources
   NonNamespaceOperation<FooBar, FooBarList, Resource<FooBar>> fooBars();

   // Use MixedOperation for namespaced resources
   MixedOperation<FooBar, FooBarList, Resource<FooBar>> fooBars();
   ```

2. **Implementation** — add the method to `V1<Group>APIGroupClient.java` in `kubernetes-client/src/main/java/io/fabric8/kubernetes/client/impl/`:

   ```java
   @Override
   public NonNamespaceOperation<FooBar, FooBarList, Resource<FooBar>> fooBars() {
       return resources(FooBar.class, FooBarList.class);
   }
   ```

3. **Tests** — add CRUD tests in `kubernetes-tests/` using `@EnableKubernetesMockClient(crud = true)`.

**Adding a brand-new API group** (e.g., `foobar.k8s.io/v1`):

More files involved — use a recently added API group as a template. The pattern:

1. Create `<Group>APIGroupDSL.java` — router interface with version methods like `v1()`
2. Create `V1<Group>APIGroupDSL.java` — resource method declarations
3. Add `<Group>APIGroupDSL <group>()` to `KubernetesClient.java`
4. Create `<Group>APIGroupClient.java` and `V1<Group>APIGroupClient.java` implementations extending `ClientAdapter`
5. Register both in `KubernetesClientImpl.registerDefaultAdapters()`:
   ```java
   adapters.registerClient(V1<Group>APIGroupDSL.class, new V1<Group>APIGroupClient());
   adapters.registerClient(<Group>APIGroupDSL.class, new <Group>APIGroupClient());
   ```
6. Add tests

Look at the `VolumeAttributesClass` addition in `V1StorageAPIGroupDSL` / `V1StorageAPIGroupClient` (K8s 1.35) or `V1FlowControlAPIGroupDSL` as recent reference implementations.

**OpenShift client**: Also check whether any graduated API is re-exposed through the OpenShift client. If so, the corresponding DSL changes may be needed in `openshift-client-api/` and `openshift-client/` as well.

---

## Phase 4: Finalize

### 13. Update CHANGELOG.md

Add under the current SNAPSHOT version, in the **New Features** section:

```
* Fix #$1: Support for Kubernetes v$0 (<Release Name>)
```

If there are breaking changes from API removals, add those to the **Breaking changes** section too.

### 14. Regenerate javadoc links

```bash
make generate-javadoc-links
```

A Kubernetes version bump adds/removes packages, so the javadoc element-list files need regenerating for cross-module linking.

### 15. Format and verify

```bash
make format
make quickly
```

Formatting applies license headers and spotless Java formatting (requires JDK 17+). The build verifies everything compiles cleanly.

### 16. Commit

Stage all generated model changes, DSL additions, pom.xml update, and CHANGELOG. **Do not stage** the investigation markdown file.

Commit message pattern:

```
feat(openapi): support for Kubernetes v$0 (<Release Name>) (#$1)
```

---

### CHECKPOINT 3

Show the user a summary of all changes: files modified, new DSL methods added, changelog entry. Confirm before pushing and raising the PR.

---

### 17. Push and create PR

```bash
git push -u origin k8s-releases/k8s-$0
```

PR title: `feat(openapi): support for Kubernetes v$0 (<Release Name>)`

PR body should include:
- Summary of changes (model updates, new DSL methods)
- Link to the tracking GitHub issue
- List of graduated APIs with new DSL support
- Link to the K8s release blog
- Any breaking changes