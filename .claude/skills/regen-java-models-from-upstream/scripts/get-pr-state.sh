#!/usr/bin/env bash
# Prints the PR state the skill checks before touching the Renovate branch and before pushing
# Usage: get-pr-state.sh <pr-number>
# Exits non-zero when the state can't be fetched.
set -uo pipefail

REPO="fabric8io/kubernetes-client"
PR_NUMBER="${1:?Usage: get-pr-state.sh <pr-number>}"

# GitHub computes mergeability lazily, so the first queries often report UNKNOWN
for _ in 1 2 3 4 5 6 7 8 9 10; do
  STATE="$(gh pr view "$PR_NUMBER" --repo "$REPO" \
    --json author,headRefName,headRefOid,headRepository,mergeable,state \
    --jq '[.author.login, .headRepository.nameWithOwner, .headRefName, .headRefOid, .state, .mergeable] | join("")')" || exit 1
  # Unit separator instead of tabs: whitespace IFS would collapse empty fields
  IFS=$'\x1f' read -r AUTHOR HEAD_REPO BRANCH HEAD_OID PR_STATE MERGEABLE <<<"$STATE"
  if [ "$PR_STATE" != "OPEN" ] || [ "$MERGEABLE" != "UNKNOWN" ]; then
    break
  fi
  sleep 3
done

PERMISSION="$(gh repo view "$REPO" --json viewerPermission -q .viewerPermission)" || exit 1

echo "Author: $AUTHOR"
echo "Head repository: $HEAD_REPO"
echo "Branch: $BRANCH"
echo "Head commit: $HEAD_OID"
echo "State: $PR_STATE"
echo "Mergeable: $MERGEABLE"
echo "Your permission on $REPO: $PERMISSION"

if [ -z "$AUTHOR" ] || [ -z "$HEAD_REPO" ] || [ -z "$BRANCH" ] || [ -z "$HEAD_OID" ] || [ -z "$PERMISSION" ]; then
  echo "Incomplete PR state"
  exit 1
fi
