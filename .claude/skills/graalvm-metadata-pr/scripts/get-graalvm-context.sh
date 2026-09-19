#!/bin/bash
# Pre-fetches context for the graalvm-metadata-pr skill.
# Usage: ./get-graalvm-context.sh <tag-or-commit> [strategy]

set -euo pipefail

REF="${1:-}"
STRATEGY="${2:-JACKSON_ANNOTATIONS}"

if [ -z "$REF" ]; then
    echo "Missing argument. Expected: <tag-or-commit-id> [strategy]"
    echo "Example: ./get-graalvm-context.sh v7.5.2"
    echo "Example: ./get-graalvm-context.sh v7.5.2 COMPREHENSIVE"
    exit 1
fi

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "${SCRIPT_DIR}/../../../.." && pwd)"

echo "=== GraalVM Metadata PR Context ==="
echo "Target ref: ${REF}"
echo "Strategy: ${STRATEGY}"
echo ""

echo "--- Current branch ---"
git -C "${PROJECT_ROOT}" branch --show-current 2>/dev/null || echo "(detached HEAD)"
echo ""

echo "--- Ref validation ---"
if git -C "${PROJECT_ROOT}" rev-parse --verify "${REF}" >/dev/null 2>&1; then
    echo "Ref '${REF}' exists"
    echo "Commit: $(git -C "${PROJECT_ROOT}" rev-parse "${REF}")"
else
    echo "WARNING: Ref '${REF}' not found locally. May need 'git fetch --tags'."
fi
echo ""

echo "--- JBang scripts availability ---"
for f in GenerateGraalvmMetadata.java GenerateAllGraalvmMetadata.java; do
    if [ -f "${PROJECT_ROOT}/scripts/${f}" ]; then
        echo "  ${f}: present"
    else
        echo "  ${f}: MISSING"
    fi
done
echo ""

echo "--- jbang version ---"
jbang --version 2>/dev/null || echo "(jbang not found — install with: sdk install jbang)"
echo ""

echo "--- Java version ---"
java -version 2>&1 | head -1 || echo "(java not found)"
echo ""

echo "--- Existing fabric8 modules in oracle repo ---"
if command -v gh >/dev/null 2>&1; then
    gh api repos/oracle/graalvm-reachability-metadata/contents/metadata/io.fabric8 \
        --jq '.[].name' 2>/dev/null || echo "(could not fetch — check gh auth)"
else
    echo "(gh CLI not found)"
fi
echo ""

echo "--- Fork status ---"
if command -v gh >/dev/null 2>&1; then
    USER=$(gh api user --jq '.login' 2>/dev/null || echo "")
    if [ -n "$USER" ]; then
        if gh api "repos/${USER}/graalvm-reachability-metadata" --jq '.full_name' >/dev/null 2>&1; then
            echo "Fork exists: ${USER}/graalvm-reachability-metadata"
        else
            echo "No fork found. Will create one during PR phase."
        fi
    else
        echo "(could not determine GitHub user)"
    fi
fi
