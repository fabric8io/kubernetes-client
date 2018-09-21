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


os::test::junit::declare_suite_start "cmd/explain"
# This test validates that the explain command works with openshift resources

os::cmd::expect_success 'oc explain dc'
os::cmd::expect_success_and_text 'oc explain dc.status.replicas' 'FIELD\: replicas'

os::cmd::expect_success 'oc explain routes'
os::cmd::expect_success_and_text 'oc explain route.metadata.name' 'string'

os::cmd::expect_success 'oc explain bc'
os::cmd::expect_success 'oc explain image'
os::cmd::expect_success 'oc explain is'

os::cmd::expect_success 'oc explain cronjob'

echo "explain: ok"
os::test::junit::declare_suite_end

