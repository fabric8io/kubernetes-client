#!/bin/bash
# Collects generated reachability-metadata.json files and prints a summary table.
# Also outputs a markdown table suitable for PR descriptions.
# Usage: ./collect-metadata-summary.sh <project-root> [oracle-repo-root]

set -euo pipefail

PROJECT_ROOT="${1:?Usage: $0 <project-root> [oracle-repo-root]}"
ORACLE_ROOT="${2:-}"

# Modules to exclude from the PR (test/example modules)
EXCLUDE_MODULES="kubernetes-examples"

echo "=== Generated Metadata Summary ==="
echo ""
printf "%-45s %8s %s\n" "Module" "Entries" "Oracle"
printf "%-45s %8s %s\n" "------" "-------" "------"

# Collect existing modules from oracle repo if path provided
EXISTING_MODULES=""
if [ -n "$ORACLE_ROOT" ] && [ -d "$ORACLE_ROOT/metadata/io.fabric8" ]; then
  EXISTING_MODULES=$(ls -1 "$ORACLE_ROOT/metadata/io.fabric8/" 2>/dev/null | tr '\n' ' ')
fi

# Also generate markdown table for PR body
MD_TABLE="| Module | Entries | Status |\n|--------|---------|--------|"

TOTAL=0
SKIPPED=0

find "$PROJECT_ROOT" -path '*/META-INF/native-image/io.fabric8/*/reachability-metadata.json' -type f | sort | while read f; do
  aid=$(echo "$f" | sed 's|.*io\.fabric8/\([^/]*\)/reachability-metadata\.json|\1|')

  # Skip excluded modules
  if echo "$EXCLUDE_MODULES" | grep -qw "$aid"; then
    echo "  EXCLUDED: $aid"
    continue
  fi

  cnt=$(python3 -c "import json; d=json.load(open('$f')); print(len(d.get('reflection',[])))" 2>/dev/null || echo "?")

  if echo "$EXISTING_MODULES" | grep -qw "$aid"; then
    oracle_tag="UPDATE"
  else
    oracle_tag="NEW"
  fi

  printf "%-45s %8s %s\n" "$aid" "$cnt" "$oracle_tag"
done

echo ""
echo "=== Markdown table for PR body ==="
echo ""
echo "| Module | Entries | Status |"
echo "|--------|---------|--------|"

find "$PROJECT_ROOT" -path '*/META-INF/native-image/io.fabric8/*/reachability-metadata.json' -type f | sort | while read f; do
  aid=$(echo "$f" | sed 's|.*io\.fabric8/\([^/]*\)/reachability-metadata\.json|\1|')
  if echo "$EXCLUDE_MODULES" | grep -qw "$aid"; then
    continue
  fi
  cnt=$(python3 -c "import json; d=json.load(open('$f')); print(len(d.get('reflection',[])))" 2>/dev/null || echo "?")
  if echo "$EXISTING_MODULES" | grep -qw "$aid"; then
    oracle_tag="UPDATE"
  else
    oracle_tag="NEW"
  fi
  echo "| ${aid} | ${cnt} | ${oracle_tag} |"
done
