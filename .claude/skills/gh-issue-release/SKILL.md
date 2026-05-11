---
name: gh-issue-release
description: Manage Fabric8 Kubernetes Client release tracking issues. Creates the next version's release issue and completes the current version's issue after a release.
argument-hint: "<released-version> <next-version>"
disable-model-invocation: true
allowed-tools: Read, Grep, Glob, AskUserQuestion, Bash(.claude/skills/gh-issue-release/scripts/*), Bash(gh *)
---

## Release Issue Manager

You are a core maintainer of the Fabric8 Kubernetes Client project (`fabric8io/kubernetes-client`).

After a release is published, you manage the release tracking issues:
1. Create a new tracking issue for the **next** version
2. Update the **current** version's tracking issue marking all tasks as completed with their links
3. Close the current version's tracking issue

### Arguments

- `$0` — The version that was just released (e.g., `7.6.0`) **(required)**
- `$1` — The next version to release (e.g., `7.7.0` or `8.0.0`) **(required)**

### Pre-fetched Release Context

```
!`.claude/skills/gh-issue-release/scripts/get-release-context.sh $0 $1`
```

### Process

#### 1. Validate Context

Review the pre-fetched context above and verify:
- A release tracking issue exists for version `$0` and is **OPEN**
- The release tag `v$0` exists
- The milestone for `$0` exists
- A milestone for the next version `$1` exists
- A Quarkus version bump PR was found

If any critical item is missing (no release issue, no release tag), inform the user and stop.
If the next milestone is missing, ask the user for the milestone URL.
If the Quarkus PR was not found, ask the user for the URL using `AskUserQuestion`.

#### 2. Confirm Plan

Present a summary to the user showing what will be done:
- The next version release issue to be created (title, milestone, labels)
- The updates to the current release issue (body with checked tasks and links)
- The current issue will be closed
- The Quarkus PR that will be linked

Wait for user confirmation via `AskUserQuestion` before proceeding.

#### 3. Create Next Version Release Issue

If a release issue for the next version does **NOT** already exist, create it with `gh issue create`.

Use this exact format:

```
gh issue create --repo fabric8io/kubernetes-client \
  --title "Release Fabric8 Kubernetes Client <NEXT_VERSION>" \
  --label "status/never-stale" \
  --milestone "<NEXT_VERSION>" \
  --body "$(cat <<'EOF'
### Description

Issue to track the required tasks to release Fabric8 Kubernetes Client <NEXT_VERSION>
- [ ] <NEXT_VERSION_MILESTONE_URL>
- [ ] Prepare release
- [ ] Create issue for next release (and milestone if needed)
- [ ] Quarkus Version Bump
EOF
)"
```

If the next version release issue already exists, skip this step and inform the user.

#### 4. Update Current Version Release Issue

Update the current release issue body with all tasks checked and links filled in using `gh issue edit`:

```
gh issue edit <ISSUE_NUMBER> --repo fabric8io/kubernetes-client \
  --body "$(cat <<'EOF'
### Description

Issue to track the required tasks to release Fabric8 Kubernetes Client <VERSION>
- [x] <CURRENT_MILESTONE_URL>
- [x] Prepare release
  <RELEASE_TAG_URL>
- [x] Create issue for next release (and milestone if needed)
  <NEXT_MILESTONE_URL>
  #<NEXT_ISSUE_NUMBER>
- [x] Quarkus Version Bump
  <QUARKUS_PR_URL>
EOF
)"
```

#### 5. Close Current Version Release Issue

Close the current release issue:

```
gh issue close <ISSUE_NUMBER> --repo fabric8io/kubernetes-client --reason completed
```

#### 6. Summary

After all steps are complete, provide a summary with links to:
- The newly created (or existing) next version issue
- The updated and closed current version issue
