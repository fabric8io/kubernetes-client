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

STARTTIME=$(date +%s)
source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

os::build::setup_env

OUTPUT_PARENT=${OUTPUT_ROOT:-$OS_ROOT}

pushd vendor/github.com/jteeuwen/go-bindata > /dev/null
  go install ./...
popd > /dev/null
os::util::ensure::gopath_binary_exists 'go-bindata'

pushd "${OS_ROOT}" > /dev/null
"$(os::util::find::gopath_binary go-bindata)" \
    -nocompress \
    -nometadata \
    -prefix "bootstrap" \
    -pkg "bootstrap" \
    -o "${OUTPUT_PARENT}/pkg/oc/bootstrap/bindata.go" \
    -ignore "OWNERS" \
    -ignore "README.md" \
    -ignore ".*\.go$" \
    -ignore "\.DS_Store" \
    -ignore application-template.json \
    -ignore "prometheus-standalone.yaml" \
    -ignore "node-exporter.yaml" \
    examples/image-streams/... \
    examples/db-templates/... \
    examples/jenkins \
    examples/jenkins/pipeline \
    examples/quickstarts/... \
    examples/logging/... \
    examples/heapster/... \
    examples/prometheus/... \
    examples/service-catalog/... \
    install/... \
    pkg/image/admission/apis/imagepolicy/v1/...

"$(os::util::find::gopath_binary go-bindata)" \
    -nocompress \
    -nometadata \
    -prefix "testextended" \
    -pkg "testdata" \
    -o "${OUTPUT_PARENT}/test/extended/testdata/bindata.go" \
    -ignore "OWNERS" \
    -ignore "\.DS_Store" \
    -ignore ".*\.(go|md)$" \
    -ignore "prometheus-standalone.yaml" \
    -ignore "node-exporter.yaml" \
    test/extended/testdata/... \
    test/integration/testdata \
    examples/db-templates \
    examples/image-streams \
    examples/sample-app \
    examples/quickstarts/... \
    examples/prometheus/... \
    examples/hello-openshift \
    examples/jenkins/... \
    examples/quickstarts/cakephp-mysql.json \
    install/...

popd > /dev/null

# If you hit this, please reduce other tests instead of importing more
if [[ "$( cat "${OUTPUT_PARENT}/test/extended/testdata/bindata.go" | wc -c )" -gt 1500000 ]]; then
    echo "error: extended bindata is $( cat "${OUTPUT_PARENT}/test/extended/testdata/bindata.go" | wc -c ) bytes, reduce the size of the import" 1>&2
    exit 1
fi

ret=$?; ENDTIME=$(date +%s); echo "$0 took $(($ENDTIME - $STARTTIME)) seconds"; exit "$ret"
