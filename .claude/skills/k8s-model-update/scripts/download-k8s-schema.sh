#!/bin/bash
# Downloads Kubernetes OpenAPI spec (swagger.json) for a given version.
# Usage: ./download-k8s-schema.sh <version> [project_root]
# Example: ./download-k8s-schema.sh 1.36.0

set -euo pipefail

VERSION="${1:-}"

if [ -z "$VERSION" ]; then
    echo "Usage: $0 <version> [project_root]"
    echo "Example: $0 1.36.0"
    exit 1
fi

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="${2:-$(cd "${SCRIPT_DIR}/../../../.." && pwd)}"
SCHEMAS_DIR="${PROJECT_ROOT}/kubernetes-model-generator/openapi/schemas"
OUTPUT_FILE="${SCHEMAS_DIR}/kubernetes-${VERSION}.json"

if [ ! -d "$SCHEMAS_DIR" ]; then
    echo "ERROR: Schemas directory not found: ${SCHEMAS_DIR}"
    echo "Is ${PROJECT_ROOT} the correct project root?"
    exit 1
fi

if [ -f "$OUTPUT_FILE" ]; then
    echo "WARNING: ${OUTPUT_FILE} already exists. Overwriting."
fi

URL="https://raw.githubusercontent.com/kubernetes/kubernetes/v${VERSION}/api/openapi-spec/swagger.json"

echo "Downloading Kubernetes v${VERSION} OpenAPI spec..."
echo "  URL:    ${URL}"
echo "  Output: ${OUTPUT_FILE}"

HTTP_CODE=$(curl -fSL --progress-bar -w "%{http_code}" "${URL}" -o "${OUTPUT_FILE}")

if [ "$HTTP_CODE" -eq 200 ]; then
    FILE_SIZE=$(du -h "${OUTPUT_FILE}" | cut -f1)
    echo "Downloaded successfully (${FILE_SIZE})"
else
    rm -f "${OUTPUT_FILE}"
    echo "ERROR: Download failed with HTTP ${HTTP_CODE}."
    echo "Verify that tag v${VERSION} exists:"
    echo "  https://github.com/kubernetes/kubernetes/tree/v${VERSION}/api/openapi-spec"
    exit 1
fi