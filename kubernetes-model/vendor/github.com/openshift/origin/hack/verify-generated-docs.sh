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
    rm -rf "${TMP_GENERATED_DOCS_ROOT}"
    rm -rf "${TMP_GENERATED_DOCS_MAN_ROOT}"
    os::test::junit::generate_report
    os::util::describe_return_code "${return_code}"
    exit "${return_code}"
}
trap "cleanup" EXIT

GENERATED_DOCS_ROOT_REL="docs/generated"
GENERATED_DOCS_ROOT="${OS_ROOT}/${GENERATED_DOCS_ROOT_REL}"
TMP_GENERATED_DOCS_ROOT_REL="_output/verify-generated-docs"
TMP_GENERATED_DOCS_ROOT="${OS_ROOT}/${TMP_GENERATED_DOCS_ROOT_REL}/${GENERATED_DOCS_ROOT_REL}"

GENERATED_DOCS_MAN_ROOT_REL="docs/man/man1"
GENERATED_DOCS_MAN_ROOT="${OS_ROOT}/${GENERATED_DOCS_MAN_ROOT_REL}"
TMP_GENERATED_DOCS_MAN_ROOT="${OS_ROOT}/${TMP_GENERATED_DOCS_ROOT_REL}/${GENERATED_DOCS_MAN_ROOT_REL}"

os::test::junit::declare_suite_start "verify/docs"
os::cmd::expect_success "${OS_ROOT}/hack/update-generated-docs.sh ${TMP_GENERATED_DOCS_ROOT_REL}"
os::cmd::expect_success "diff -Naupr ${GENERATED_DOCS_ROOT} ${TMP_GENERATED_DOCS_ROOT}"
os::cmd::expect_success "diff -Naupr ${GENERATED_DOCS_MAN_ROOT} ${TMP_GENERATED_DOCS_MAN_ROOT}"
os::test::junit::declare_suite_end