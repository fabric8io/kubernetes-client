#!/bin/bash
#
# Copyright (C) 2015 Red Hat, Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#         http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Script to bundle multi-JDK Maven artifacts into a single directory
# to publish into the new Sonatype Maven Central repository
# using their web interface (https://central.sonatype.com/publishing)
# Usage:
#   ./scripts/6.x-bundle.sh

set -e

xml_grep="xml_grep --text_only --cond"
global_version=$($xml_grep '/project/version' "pom.xml" 2>/dev/null | tail -n1)
echo "Generating Fabric8 Kubernetes Client bundle for version: $global_version"

TMPDIR=$(mktemp -d)
echo "Using temp directory: $TMPDIR"

echo "Copying Maven artifacts..."
find . -name pom.xml | while read -r pom; do
  dir=$(dirname "$pom")

  # Extract Maven coordinates
  groupId=$($xml_grep '/project/parent/groupId|/project/groupId' "$pom" 2>/dev/null | tail -n1)
  artifactId=$($xml_grep '/project/artifactId' "$pom" 2>/dev/null | tail -n1)
  version=$($xml_grep '/project/parent/version|/project/version' "$pom" 2>/dev/null | tail -n1)

  if [ -z "$groupId" ] || [ -z "$artifactId" ] || [ -z "$version" ]; then
    echo "Exiting due to missing coordinates in $pom (groupId: $groupId, artifactId: $artifactId, version: $version)"
    exit 1
  fi

  if [ "$version" != "$global_version" ]; then
    echo " - Skipping $artifactId version $version as it does not match global version $global_version"
    continue
  fi

  # Build nested directory path
  IFS='.' read -ra GROUP_PARTS <<< "$groupId"
  path=""
  for part in "${GROUP_PARTS[@]}"; do
    path="$path/$part"
  done
  path="$path/$artifactId/$version"
  target_path="$TMPDIR/$path"
  mkdir -p "$target_path"
  source_path="$(realpath ~/.m2/repository)$path"

  # Copy files from source directory
  if [ -d "$source_path" ]; then
    find "$source_path" -maxdepth 1 -type f -name "${artifactId}-*" ! -name "*.lastUpdated" -exec cp {} "$target_path/" \;
  else
    echo " - Source directory $source_path does not exist. Skipping."
  fi
done

echo "Copying BOM files..."
BOMS="kubernetes-client-bom kubernetes-client-bom-with-deps"
for bom in $BOMS; do
  bom_path="target/classes/$bom/target"
  if [ -d "$bom_path" ]; then
    target_path="$TMPDIR/io/fabric8/$bom/$global_version/"
    mkdir -p "$target_path"
    find "$bom_path" -maxdepth 1 -type f -exec cp {} "$target_path" \;
  else
    echo " - BOM directory $bom_path does not exist. Skipping."
  fi
done

echo "Generating checksums..."
find "$TMPDIR" -type f | while read -r file; do
  if [[ ! "$file" =~ \.asc$ ]]; then
    md5sum "$file" | awk '{print $1}' > "$file.md5"
    sha1sum "$file" | awk '{print $1}' > "$file.sha1"
    sha256sum "$file" | awk '{print $1}' > "$file.sha256"
  fi
done

echo "Verifying signatures..."
find "$TMPDIR" -type f -name "*.asc" | while read -r signed_file; do
  output=$(gpg --verify "$signed_file" 2>&1 || true)
  if echo "$output" | grep -q 'Good signature from "FuseSource'; then
    : # NO OP
  else
    echo "Signature verification failed for $signed_file: $output"
    exit 1
  fi
done

echo "Creating ZIP archive..."
(cd "$TMPDIR" && zip -rq "kubernetes-client-${global_version}-bundle.zip" .)

echo "Done. Files are in $TMPDIR"
