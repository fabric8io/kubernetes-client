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


set -o errexit
set -o nounset
set -o pipefail

OS_ROOT=$(dirname "${BASH_SOURCE}")/../..
source "${OS_ROOT}/hack/lib/init.sh"
os::log::stacktrace::install
trap os::test::junit::reconcile_output EXIT

# Cleanup cluster resources created by this test
(
  set +e
  oc delete all --all
  exit 0
) &>/dev/null

os::test::junit::declare_suite_start "cmd/convert"
# This test validates the convert command

os::cmd::expect_success "oc convert -f test/testdata/convert/job-v1.yaml | grep 'apiVersion: batch/v1'"
os::cmd::expect_success "oc convert -f test/testdata/convert/job-v2.json | grep 'apiVersion: batch/v1beta1'"

os::cmd::expect_success_and_text "oc convert -f test/testdata/convert | oc create --dry-run -f -" 'job "pi" created'
os::cmd::expect_success_and_text "oc convert -f test/testdata/convert | oc create --dry-run -f -" 'cronjob "hello" created'

echo "convert: ok"
os::test::junit::declare_suite_end
