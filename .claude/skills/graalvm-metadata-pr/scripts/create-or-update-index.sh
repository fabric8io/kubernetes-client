#!/bin/bash
# Creates or updates index.json for a fabric8 module in the oracle repo.
# Usage: ./create-or-update-index.sh <oracle-repo-root> <artifactId> <version>

set -euo pipefail

ORACLE_ROOT="${1:?Usage: $0 <oracle-repo-root> <artifactId> <version>}"
ARTIFACT_ID="${2:?Usage: $0 <oracle-repo-root> <artifactId> <version>}"
VERSION="${3:?Usage: $0 <oracle-repo-root> <artifactId> <version>}"

INDEX_FILE="${ORACLE_ROOT}/metadata/io.fabric8/${ARTIFACT_ID}/index.json"

# Derive allowed-packages from artifactId
derive_package() {
  local aid="$1"
  case "$aid" in
    kubernetes-model-common)   echo "io.fabric8.kubernetes" ;;
    kubernetes-model-core)     echo "io.fabric8.kubernetes.api.model" ;;
    kubernetes-client-api)     echo "io.fabric8.kubernetes.client" ;;
    kubernetes-client)         echo "io.fabric8.kubernetes.client" ;;
    zjsonpatch)                echo "io.fabric8.zjsonpatch" ;;
    openshift-model)           echo "io.fabric8.openshift.api.model" ;;
    openshift-client-api)      echo "io.fabric8.openshift.client" ;;
    openshift-client)          echo "io.fabric8.openshift.client" ;;
    openshift-model-*)
      local group="${aid#openshift-model-}"
      echo "io.fabric8.openshift.api.model.${group}"
      ;;
    kubernetes-model-*)
      local group="${aid#kubernetes-model-}"
      echo "io.fabric8.kubernetes.api.model.${group}"
      ;;
    *-model)
      local base="${aid%-model}"
      echo "io.fabric8.${base}.api.model"
      ;;
    *)
      echo "io.fabric8"
      ;;
  esac
}

# Derive a two-sentence description from artifactId
derive_description() {
  local aid="$1"
  case "$aid" in
    kubernetes-model-common)
      echo "kubernetes-model-common provides the common builder framework and utility classes shared across all Fabric8 Kubernetes model modules. It includes the fluent builder infrastructure, visitor pattern support, and JSON/YAML serialization helpers."
      ;;
    kubernetes-model-core)
      echo "kubernetes-model-core provides the core Java model classes for Kubernetes API resources used by the Fabric8 Kubernetes client. It includes generated and handwritten types, builders, and serialization metadata for representing Kubernetes core objects in JVM applications."
      ;;
    kubernetes-client-api)
      echo "kubernetes-client-api provides the public API interfaces and DSL for the Fabric8 Kubernetes client. It defines the fluent API for interacting with Kubernetes resources."
      ;;
    kubernetes-client)
      echo "kubernetes-client is the main implementation module of the Fabric8 Kubernetes client. It provides the concrete client implementation for interacting with Kubernetes clusters."
      ;;
    zjsonpatch)
      echo "zjsonpatch is Fabric8's Java library for applying RFC 6902 JSON Patch operations and generating diffs between Jackson JsonNode trees. It supports patch application, diff generation, and JSON Pointer path handling."
      ;;
    openshift-model)
      echo "openshift-model provides the core Java model classes for OpenShift API resources. It includes generated types, builders, and serialization metadata for OpenShift-specific resources."
      ;;
    openshift-model-*)
      local group="${aid#openshift-model-}"
      echo "${aid} provides Java model classes for the OpenShift ${group} API group. It includes generated types, builders, and serialization metadata for ${group} resources."
      ;;
    kubernetes-model-*)
      local group="${aid#kubernetes-model-}"
      echo "${aid} provides Java model classes for the Kubernetes ${group} API group. It includes generated types, builders, and serialization metadata for ${group} resources."
      ;;
    *-model)
      local base="${aid%-model}"
      echo "${aid} provides Java model classes for ${base} API resources used by the Fabric8 Kubernetes client extension. It includes generated types, builders, and serialization metadata."
      ;;
    *)
      echo "${aid} is a module of the Fabric8 Kubernetes Client project. It provides Java types and serialization metadata for use with GraalVM native image."
      ;;
  esac
}

PKG=$(derive_package "$ARTIFACT_ID")
DESC=$(derive_description "$ARTIFACT_ID")

if [ -f "$INDEX_FILE" ]; then
  # Existing module: check if this version already has its own metadata-version entry.
  # If not, create a new entry with its own metadata-version directory.
  # Each version gets its own entry because model classes can change between releases.
  # The latest entry has "latest": true; older entries do not.
  python3 -c "
import json, sys

version = '${VERSION}'

with open('${INDEX_FILE}') as f:
    d = json.load(f)

# Check if this version already has its own metadata-version entry
for entry in d:
    if entry.get('metadata-version') == version:
        if version in entry.get('tested-versions', []):
            print('SKIP: ${ARTIFACT_ID} (' + version + ' already has its own entry)')
            sys.exit(0)
        entry.setdefault('tested-versions', []).append(version)
        with open('${INDEX_FILE}', 'w') as f:
            json.dump(d, f, indent=2)
            f.write('\n')
        print('UPDATED: ${ARTIFACT_ID} (added ' + version + ' to existing entry)')
        sys.exit(0)

# Find the current latest entry to use as a template
latest_entry = next((e for e in d if e.get('latest')), d[0])

# Compare versions using tuple of ints (works for semver like 7.5.2 vs 7.7.0)
def version_tuple(v):
    try:
        return tuple(int(x) for x in v.split('.'))
    except (ValueError, AttributeError):
        return (0,)

is_newer = version_tuple(version) > version_tuple(latest_entry.get('metadata-version', '0'))

# Create a new entry for this version
new_entry = {
    'metadata-version': version,
    'tested-versions': [version],
    'allowed-packages': latest_entry.get('allowed-packages', ['${PKG}']),
}
for key in ['source-code-url', 'repository-url', 'test-code-url', 'documentation-url', 'description']:
    if key in latest_entry:
        new_entry[key] = latest_entry[key]

if is_newer:
    new_entry['latest'] = True
    latest_entry.pop('latest', None)

d.append(new_entry)

with open('${INDEX_FILE}', 'w') as f:
    json.dump(d, f, indent=2)
    f.write('\n')
print('UPDATED: ${ARTIFACT_ID} (added metadata-version ' + version + (', marked latest' if is_newer else '') + ')')
"
else
  # New module: create index.json
  mkdir -p "$(dirname "$INDEX_FILE")"
  python3 -c "
import json
index = [{
    'latest': True,
    'metadata-version': '${VERSION}',
    'source-code-url': 'https://repo.maven.apache.org/maven2/io/fabric8/${ARTIFACT_ID}/\$version\$/${ARTIFACT_ID}-\$version\$-sources.jar',
    'repository-url': 'https://github.com/fabric8io/kubernetes-client',
    'documentation-url': 'https://repo.maven.apache.org/maven2/io/fabric8/${ARTIFACT_ID}/\$version\$/${ARTIFACT_ID}-\$version\$-javadoc.jar',
    'description': '''${DESC}''',
    'tested-versions': ['${VERSION}'],
    'allowed-packages': ['${PKG}']
}]
with open('${INDEX_FILE}', 'w') as f:
    json.dump(index, f, indent=2)
    f.write('\n')
print('CREATED: ${ARTIFACT_ID} (NEW)')
"
fi
