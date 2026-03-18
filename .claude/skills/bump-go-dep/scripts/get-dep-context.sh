#!/usr/bin/env bash
# Fetches context for a Dependabot Go dependency bump PR
# Usage: get-dep-context.sh <pr-number>
set -euo pipefail

PR_NUMBER="${1:?Usage: get-dep-context.sh <pr-number>}"
REPO="fabric8io/kubernetes-client"

REPO_ROOT="$(cd "$(dirname "$0")/../../.." && pwd)"

echo "=== PR Details ==="
gh pr view "$PR_NUMBER" --repo "$REPO" --json number,title,state,headRefName,body,url \
  --template '{{printf "Number: %v\nTitle: %s\nState: %s\nBranch: %s\nURL: %s\n" .number .title .state .headRefName .url}}'

echo ""
echo "=== PR Body (first 40 lines) ==="
gh pr view "$PR_NUMBER" --repo "$REPO" --json body -q '.body' | head -40

echo ""
echo "=== CI Check Status ==="
gh pr checks "$PR_NUMBER" --repo "$REPO" 2>&1 || true

echo ""
echo "=== Failed CI Run Logs (Generate Model) ==="
# Find the failed Generate Model run
FAILED_RUN_ID=$(gh run list --repo "$REPO" --branch "$(gh pr view "$PR_NUMBER" --repo "$REPO" --json headRefName -q '.headRefName')" \
  --workflow "Generate Model" --status failure --json databaseId -q '.[0].databaseId' 2>/dev/null || echo "")

if [ -n "$FAILED_RUN_ID" ]; then
  echo "Run ID: $FAILED_RUN_ID"
  echo "Run URL: https://github.com/$REPO/actions/runs/$FAILED_RUN_ID"
  echo ""
  echo "--- Failed job logs (last 100 lines) ---"
  gh run view "$FAILED_RUN_ID" --repo "$REPO" --log-failed 2>&1 | tail -100
else
  echo "No failed Generate Model run found."
  # Try to find the most recent run
  LATEST_RUN_ID=$(gh run list --repo "$REPO" --branch "$(gh pr view "$PR_NUMBER" --repo "$REPO" --json headRefName -q '.headRefName')" \
    --workflow "Generate Model" --json databaseId,conclusion -q '.[0].databaseId' 2>/dev/null || echo "")
  if [ -n "$LATEST_RUN_ID" ]; then
    echo "Latest run: https://github.com/$REPO/actions/runs/$LATEST_RUN_ID"
  fi
fi

echo ""
echo "=== Current go.mod direct dependencies (first require block) ==="
awk '/^require \(/,/^\)/' $REPO_ROOT/kubernetes-model-generator/openapi/generator/go.mod | head -60

echo ""
echo "=== Current replace directives ==="
awk '/^\/\/ Required|^\/\/ Issues|^replace \(/,/^\)/' $REPO_ROOT/kubernetes-model-generator/openapi/generator/go.mod
