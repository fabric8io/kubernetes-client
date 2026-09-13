#!/usr/bin/env bash
# Fetches context for a Renovate Go dependency bump PR
# Usage: get-dep-context.sh <pr-number-or-url>
#
# Always exits 0: a failing injected command aborts the whole skill, so failures are
# reported inline with a "!! " prefix and SKILL.md explains how to recover.
set -uo pipefail
# Redirect stderr to stdout so gh errors end up in the context
exec 2>&1

REPO="fabric8io/kubernetes-client"
REPO_ROOT="$(cd "$(dirname "$0")/../../../.." && pwd)"
GO_MOD="$REPO_ROOT/kubernetes-model-generator/openapi/generator/go.mod"

ARG="${1:-}"
if [[ "$ARG" =~ ^#?([0-9]+)$ ]] || [[ "$ARG" =~ /pull/([0-9]+) ]]; then
  PR_NUMBER="${BASH_REMATCH[1]}"
else
  echo "!! NO_PR: expected a Renovate PR number or URL, got '${ARG}'"
  exit 0
fi

echo "=== Local checkout ==="
echo "Branch: $(git -C "$REPO_ROOT" branch --show-current)"
echo "Uncommitted changes: $(git -C "$REPO_ROOT" status --porcelain | wc -l | tr -d ' ') file(s)"

echo ""
echo "=== PR Details ==="
if ! gh pr view "$PR_NUMBER" --repo "$REPO" \
  --json number,title,state,author,headRefName,headRepository,mergeable,url \
  --template '{{printf "Number: %v\nTitle: %s\nState: %s\nAuthor: %s\nBranch: %s\nHead repository: %s\nMergeable: %s\nURL: %s\n" .number .title .state .author.login .headRefName .headRepository.nameWithOwner .mergeable .url}}'; then
  echo "!! GH_FETCH_FAILED"
  exit 0
fi
echo "Your permission on $REPO: $(gh repo view "$REPO" --json viewerPermission -q .viewerPermission)"

echo ""
echo "=== PR Body (first 40 lines) ==="
gh pr view "$PR_NUMBER" --repo "$REPO" --json body -q .body | head -40

echo ""
echo "=== CI Check Status ==="
gh pr checks "$PR_NUMBER" --repo "$REPO"

echo ""
echo "=== Failed CI Run Logs (Generate Model) ==="
BRANCH="$(gh pr view "$PR_NUMBER" --repo "$REPO" --json headRefName -q .headRefName)"
FAILED_RUN_ID="$(gh run list --repo "$REPO" --branch "$BRANCH" --workflow "Generate Model" \
  --status failure --limit 1 --json databaseId -q '.[0].databaseId')"

if [ -n "$FAILED_RUN_ID" ]; then
  echo "Run URL: https://github.com/$REPO/actions/runs/$FAILED_RUN_ID"
  # Drop the job/step/timestamp columns
  LOG="$(gh run view "$FAILED_RUN_ID" --repo "$REPO" --log-failed | cut -f3- | sed -E 's/^[0-9-]+T[0-9:.]+Z ?//')"
  FIRST_ERROR="$(grep -n '##\[error\]' <<<"$LOG" | head -1 | cut -d: -f1)"
  LAST_ERROR="$(grep -n '##\[error\]' <<<"$LOG" | tail -1 | cut -d: -f1)"
  if [ -n "$FIRST_ERROR" ]; then
    # The tail of a failed job is post-job cleanup; show the lead-up to the errors instead
    echo "--- Log up to the last error (max 150 lines) ---"
    sed -n "$(( FIRST_ERROR > 40 ? FIRST_ERROR - 40 : 1 )),${LAST_ERROR}p" <<<"$LOG" | tail -150
  else
    echo "--- Failed job logs (last 100 lines) ---"
    tail -100 <<<"$LOG"
  fi
else
  echo "No failed Generate Model run found."
fi

echo ""
echo "=== go.mod direct dependencies on the local branch (first require block) ==="
awk '/^require \(/{found++} found==1{print} found==1 && /^\)/{exit}' "$GO_MOD"

echo ""
echo "=== replace directives on the local branch ==="
awk '/^\/\/ Required|^\/\/ Issues|^replace \(/,/^\)/' "$GO_MOD"

exit 0
