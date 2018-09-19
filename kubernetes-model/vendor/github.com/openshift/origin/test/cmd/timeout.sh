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

source "$(dirname "${BASH_SOURCE}")/../../hack/lib/init.sh"
trap os::test::junit::reconcile_output EXIT

# Cleanup cluster resources created by this test
(
  set +e
  oc delete all,templates --all
  exit 0
) &>/dev/null


os::test::junit::declare_suite_start "cmd/request-timeout"
# This test validates the global request-timeout option
os::cmd::expect_success_and_text 'oc new-app node' 'Success'
os::cmd::expect_success_and_text 'oc get dc node -w --request-timeout=1s 2>&1' 'Timeout exceeded while reading body'
os::cmd::expect_success_and_text 'oc get dc node --request-timeout=1s' 'node'
os::cmd::expect_success_and_text 'oc get dc node --request-timeout=1' 'node'
os::cmd::expect_success_and_text 'oc get pods --watch --request-timeout=1s 2>&1' 'Timeout exceeded while reading body'

echo "request-timeout: ok"
os::test::junit::declare_suite_end
