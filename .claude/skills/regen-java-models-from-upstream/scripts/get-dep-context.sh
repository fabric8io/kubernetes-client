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
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
REPO_ROOT="$(cd "$SCRIPT_DIR/../../../.." && pwd)"
GO_MOD="$REPO_ROOT/kubernetes-model-generator/openapi/generator/go.mod"

ARG="${1:-}"
PR_NUMBER_RE='^#?([0-9]+)$'
PR_URL_RE='^https://github\.com/fabric8io/kubernetes-client/pull/([0-9]+)([/?#].*)?$'
if [[ "$ARG" =~ $PR_NUMBER_RE ]] || [[ "$ARG" =~ $PR_URL_RE ]]; then
  PR_NUMBER="${BASH_REMATCH[1]}"
else
  echo "!! NO_PR: expected a $REPO PR number or URL, got '${ARG}'"
  exit 0
fi

echo "=== Local checkout ==="
echo "Branch: $(git -C "$REPO_ROOT" branch --show-current)"
echo "Uncommitted changes: $(git -C "$REPO_ROOT" status --porcelain | wc -l | tr -d ' ') file(s)"

echo ""
echo "=== PR State ==="
if ! PR_STATE="$("$SCRIPT_DIR/get-pr-state.sh" "$PR_NUMBER" 2>&1)"; then
  echo "$PR_STATE"
  echo "!! GH_FETCH_FAILED"
  exit 0
fi
echo "$PR_STATE"
BRANCH="$(sed -n 's/^Branch: //p' <<<"$PR_STATE")"

echo ""
echo "=== PR Title and Body (first 40 lines) ==="
if BODY="$(gh pr view "$PR_NUMBER" --repo "$REPO" --json title,url,body \
  --jq '"Title: \(.title)\nURL: \(.url)\n\n\(.body)"' 2>&1)"; then
  head -40 <<<"$BODY"
else
  echo "$BODY"
  echo "!! LOOKUP_FAILED"
fi

echo ""
echo "=== CI Check Status ==="
# gh pr checks also exits non-zero for failing or pending checks, so its exit code can't flag a failed lookup
gh pr checks "$PR_NUMBER" --repo "$REPO"

echo ""
echo "=== Failed CI Run Logs (Generate Model) ==="
if ! FAILED_RUN_ID="$(gh run list --repo "$REPO" --branch "$BRANCH" --workflow "Generate Model" \
  --status failure --limit 1 --json databaseId -q '.[0].databaseId // empty' 2>&1)"; then
  echo "$FAILED_RUN_ID"
  echo "!! LOOKUP_FAILED"
elif [ -z "$FAILED_RUN_ID" ]; then
  echo "No failed Generate Model run found."
elif ! LOG="$(gh run view "$FAILED_RUN_ID" --repo "$REPO" --log-failed 2>&1)"; then
  echo "$LOG"
  echo "!! LOOKUP_FAILED"
else
  echo "Run URL: https://github.com/$REPO/actions/runs/$FAILED_RUN_ID"
  # Drop the job/step/timestamp columns
  LOG="$(cut -f3- <<<"$LOG" | sed -E 's/^[0-9-]+T[0-9:.]+Z ?//')"
  LAST_ERROR="$(grep -n '##\[error\]' <<<"$LOG" | tail -1 | cut -d: -f1)"
  if [ -n "$LAST_ERROR" ]; then
    echo "--- Error lines ---"
    grep '##\[error\]' <<<"$LOG" | head -20
    # Later steps (e.g. workflow cleanup) can follow the errors, so end the excerpt at the last one
    echo "--- Log up to the last error (last 150 lines) ---"
    head -n "$LAST_ERROR" <<<"$LOG" | tail -150
  else
    echo "--- Failed job logs (last 150 lines) ---"
    tail -150 <<<"$LOG"
  fi
fi

echo ""
echo "=== go.mod direct dependencies on the local branch (first require block) ==="
awk '/^require \(/{found++} found==1{print} found==1 && /^\)/{exit}' "$GO_MOD"

echo ""
echo "=== replace directives on the local branch ==="
awk '/^\/\/ Required|^\/\/ Issues|^replace \(/,/^\)/' "$GO_MOD"

exit 0
