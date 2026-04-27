#!/bin/bash
# Pre-fetches context for the k8s-model-update skill.
# Usage: ./get-update-context.sh <version> <issue-number>

set -euo pipefail

VERSION="${1:-}"
ISSUE="${2:-}"

if [ -z "$VERSION" ] || [ -z "$ISSUE" ]; then
    echo "Missing arguments. Expected: <version> <issue-number>"
    echo "Example: ./get-update-context.sh 1.36.0 7500"
    exit 1
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
git -C "${PROJECT_ROOT}" branch --show-current 2>/dev/null || echo "(unknown)"
echo ""

echo "--- GitHub issue #${ISSUE} ---"
gh issue view "${ISSUE}" --repo fabric8io/kubernetes-client --json title,state,body --jq '"Title: \(.title)\nState: \(.state)\n"' 2>/dev/null || echo "(could not fetch issue)"
echo ""

echo "--- Java version ---"
java -version 2>&1 | head -1 || echo "(java not found)"