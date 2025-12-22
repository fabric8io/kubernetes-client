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

# This script removes Azure installer type references from the OpenAPI schema
# Azure installer types depend on cluster-api-provider-azure which we want to exclude

set -e

SCHEMA_FILE="${1:-kubernetes-model-generator/openapi/schemas/openshift-generated.json}"

if [ ! -f "$SCHEMA_FILE" ]; then
    echo "Error: Schema file not found: $SCHEMA_FILE"
    exit 1
fi

echo "Removing Azure installer type references from $SCHEMA_FILE..."

# Create backup
cp "$SCHEMA_FILE" "$SCHEMA_FILE.backup"

# Remove azure fields that reference com.github.openshift.installer.pkg.types.azure
jq 'walk(
  if type == "object" and has("azure") and (.azure | type == "object") and (.azure."$ref" // "" | type == "string" and contains("com.github.openshift.installer.pkg.types.azure")) then
    del(.azure)
  else
    .
  end
)' "$SCHEMA_FILE.backup" > "$SCHEMA_FILE"

# Count removed references
REMOVED=$(grep -c 'com.github.openshift.installer.pkg.types.azure' "$SCHEMA_FILE.backup" || true)
REMAINING=$(grep -c 'com.github.openshift.installer.pkg.types.azure' "$SCHEMA_FILE" || true)
: ${REMOVED:=0}
: ${REMAINING:=0}

echo "Removed $((REMOVED - REMAINING)) Azure installer type references"
echo "Done!"