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

source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

function cleanup() {
    return_code=$?
    rm -rf "${TMP_GENERATED_BOOTSTRAP_DIR}"
    os::test::junit::generate_report
    os::util::describe_return_code "${return_code}"
    exit "${return_code}"
}
trap "cleanup" EXIT

TMP_GENERATED_BOOTSTRAP_DIR="_output/verify-bindata"

os::test::junit::declare_suite_start "verify/bindata"
os::cmd::expect_success "OUTPUT_ROOT=${TMP_GENERATED_BOOTSTRAP_DIR} ${OS_ROOT}/hack/update-generated-bindata.sh"
os::cmd::expect_success "diff -Naup ${OS_ROOT}/pkg/oc/bootstrap/bindata.go ${TMP_GENERATED_BOOTSTRAP_DIR}/pkg/oc/bootstrap/bindata.go"
os::cmd::expect_success "diff -Naup ${OS_ROOT}/test/extended/testdata/bindata.go ${TMP_GENERATED_BOOTSTRAP_DIR}/test/extended/testdata/bindata.go"
os::test::junit::declare_suite_end