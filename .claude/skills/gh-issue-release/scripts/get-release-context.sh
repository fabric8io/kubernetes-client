#!/bin/bash
# Gather release context for the Fabric8 Kubernetes Client
# Usage: get-release-context.sh <released-version> <next-version>

VERSION="$1"
NEXT_VERSION="$2"

if [ -z "$VERSION" ] || [ -z "$NEXT_VERSION" ]; then
  echo "ERROR: Missing arguments."
  echo "Usage: /gh-issue-release <released-version> <next-version>"
  echo "Example: /gh-issue-release 7.6.0 7.7.0"
  exit 0
fi

REPO="fabric8io/kubernetes-client"

echo "Released Version: $VERSION"
echo "Next Version: $NEXT_VERSION"
echo "Repository: $REPO"
echo ""

echo "### Current Release Issue ($VERSION)"
gh issue list --repo "$REPO" \
  --search "Release Fabric8 Kubernetes Client $VERSION in:title" \
  --state all --json number,title,state,url \
  --jq '.[] | "#\(.number) [\(.state)] \(.title)\n  \(.url)"' 2>/dev/null || echo "Not found"
echo ""

echo "### Milestone ($VERSION)"
gh api "repos/$REPO/milestones?state=all&per_page=100" \
  --jq ".[] | select(.title == \"$VERSION\") | \"\(.html_url) (\(.state))\"" 2>/dev/null || echo "Not found"
echo ""

echo "### Release Tag (v$VERSION)"
gh release view "v$VERSION" --repo "$REPO" --json url --jq '.url' 2>/dev/null || echo "Not found"
echo ""

echo "### Next Milestone ($NEXT_VERSION)"
gh api "repos/$REPO/milestones?state=all&per_page=100" \
  --jq ".[] | select(.title == \"$NEXT_VERSION\") | \"\(.html_url) (\(.state))\"" 2>/dev/null || echo "Not found"
echo ""

echo "### Existing Next Release Issue ($NEXT_VERSION)"
gh issue list --repo "$REPO" \
  --search "Release Fabric8 Kubernetes Client $NEXT_VERSION in:title" \
  --state all --json number,title,state,url \
  --jq '.[] | "#\(.number) [\(.state)] \(.title)\n  \(.url)"' 2>/dev/null || echo "None found"
echo ""

echo "### Quarkus Version Bump PR"
gh pr list --repo quarkusio/quarkus \
  --search "kubernetes-client-bom $VERSION in:title" \
  --state all --json number,title,state,url \
  --jq '.[] | "#\(.number) [\(.state)] \(.title)\n  \(.url)"' --limit 5 2>/dev/null || echo "Not found"
