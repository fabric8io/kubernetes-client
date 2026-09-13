#!/bin/bash
# Gather release context for the Fabric8 Kubernetes Client
# Usage: get-release-context.sh <released-version> <next-version>
#
# Always exits 0: a failing injected command aborts the whole skill, so failures are
# reported inline with a "!! " prefix and SKILL.md explains how to recover.
exec 2>&1

VERSION="${1:-}"
NEXT_VERSION="${2:-}"

if [ -z "$VERSION" ] || [ -z "$NEXT_VERSION" ]; then
  echo "!! MISSING_ARGS"
  echo "Usage: /gh-issue-release <released-version> <next-version>"
  echo "Example: /gh-issue-release 7.6.0 7.7.0"
  exit 0
fi

REPO="fabric8io/kubernetes-client"

# Prints the query output, "Not found" when it is empty, or a failure marker when the query fails
lookup() {
  local out
  if out="$("$@")"; then
    if [ -n "$out" ]; then echo "$out"; else echo "Not found"; fi
  else
    echo "!! LOOKUP_FAILED"
  fi
}

echo "Released Version: $VERSION"
echo "Next Version: $NEXT_VERSION"
echo "Repository: $REPO"
echo ""

# Without this check, an unreachable GitHub API would report every item below as "Not found"
if ! gh api user --jq .login > /dev/null; then
  echo "!! GH_FETCH_FAILED"
  exit 0
fi

echo "### Current Release Issue ($VERSION)"
lookup gh issue list --repo "$REPO" \
  --search "Release Fabric8 Kubernetes Client $VERSION in:title" \
  --state all --json number,title,state,url \
  --jq '.[] | "#\(.number) [\(.state)] \(.title)\n  \(.url)"'
echo ""

echo "### Milestone ($VERSION)"
lookup gh api "repos/$REPO/milestones?state=all&per_page=100" \
  --jq ".[] | select(.title == \"$VERSION\") | \"\(.html_url) (\(.state))\""
echo ""

echo "### Release Tag (v$VERSION)"
lookup gh release list --repo "$REPO" --limit 100 --json tagName \
  --jq ".[] | select(.tagName == \"v$VERSION\") | \"https://github.com/$REPO/releases/tag/\(.tagName)\""
echo ""

echo "### Next Milestone ($NEXT_VERSION)"
lookup gh api "repos/$REPO/milestones?state=all&per_page=100" \
  --jq ".[] | select(.title == \"$NEXT_VERSION\") | \"\(.html_url) (\(.state))\""
echo ""

echo "### Existing Next Release Issue ($NEXT_VERSION)"
lookup gh issue list --repo "$REPO" \
  --search "Release Fabric8 Kubernetes Client $NEXT_VERSION in:title" \
  --state all --json number,title,state,url \
  --jq '.[] | "#\(.number) [\(.state)] \(.title)\n  \(.url)"'
echo ""

echo "### Quarkus Version Bump PR"
lookup gh pr list --repo quarkusio/quarkus \
  --search "kubernetes-client-bom $VERSION in:title" \
  --state all --json number,title,state,url \
  --jq '.[] | "#\(.number) [\(.state)] \(.title)\n  \(.url)"' --limit 5

exit 0
