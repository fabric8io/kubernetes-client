#!/bin/bash
# Pre-fetches context for the k8s-model-update skill.
# Usage: ./get-update-context.sh <version> <issue-number>
#
# Always exits 0: a failing injected command aborts the whole skill, so failures are
# reported inline with a "!! " prefix and SKILL.md explains how to recover.

set -uo pipefail
exec 2>&1

VERSION="${1:-}"
ISSUE="${2:-}"

if [ -z "$VERSION" ] || [ -z "$ISSUE" ]; then
    echo "!! MISSING_ARGS: expected <version> <issue-number>"
    echo "Example: /k8s-model-update 1.36.0 7500"
    exit 0
fi

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "${SCRIPT_DIR}/../../../.." && pwd)"

echo "=== K8s Model Update Context ==="
echo "Version: ${VERSION}"
echo "Issue: #${ISSUE}"
echo ""

echo "--- Current schema property ---"
grep -n 'openapi.schema.kubernetes-latest' "${PROJECT_ROOT}/kubernetes-model-generator/pom.xml" || echo "(not found)"
echo ""

echo "--- Existing schema files ---"
ls -1 "${PROJECT_ROOT}/kubernetes-model-generator/openapi/schemas/kubernetes-"*.json 2>/dev/null | sort -V | tail -5 || echo "(none found)"
echo ""

echo "--- Current branch ---"
git -C "${PROJECT_ROOT}" branch --show-current || echo "(unknown)"
echo ""

echo "--- GitHub issue #${ISSUE} ---"
gh issue view "${ISSUE}" --repo fabric8io/kubernetes-client --json title,state --jq '"Title: \(.title)\nState: \(.state)\n"' \
  || echo "!! GH_FETCH_FAILED"
echo ""

echo "--- Java version ---"
java -version 2>&1 | head -1

exit 0
