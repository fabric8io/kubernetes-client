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


os::test::junit::declare_suite_start "cmd/set-probe-liveness"
# This test setting a liveness probe, without warning about replication controllers whose deployment depends on deployment configs
os::cmd::expect_success_and_text 'oc create -f pkg/oc/graph/genericgraph/test/simple-deployment.yaml' 'deploymentconfig "simple-deployment" created'
os::cmd::expect_success_and_text 'oc status -v' 'dc/simple-deployment has no liveness probe'

# test --local flag
os::cmd::expect_failure_and_text 'oc set probe dc/simple-deployment --liveness --get-url=http://google.com:80 --local' 'You must provide one or more resources by argument or filename'
# test --dry-run flag with -o formats
os::cmd::expect_success_and_text 'oc set probe dc/simple-deployment --liveness --get-url=http://google.com:80 --dry-run' 'simple-deployment'
os::cmd::expect_success_and_text 'oc set probe dc/simple-deployment --liveness --get-url=http://google.com:80 --dry-run -o name' 'deploymentconfigs/simple-deployment'
# ensure backwards compatibility with -o formats acting as --dry-run (e.g. all commands after this one succeed if specifying -o without --dry-run does not mutate resources in server)
os::cmd::expect_success_and_text 'oc set probe dc/simple-deployment --liveness --get-url=http://google.com:80 -o yaml' 'name: simple-deployment'

os::cmd::expect_success_and_not_text 'oc status -v' 'rc/simple-deployment-1 has no liveness probe'
os::cmd::expect_success_and_text 'oc set probe dc/simple-deployment --liveness --get-url=http://google.com:80' 'deploymentconfig "simple-deployment" updated'
os::cmd::expect_success_and_not_text 'oc status -v' 'dc/simple-deployment has no liveness probe'
echo "set-probe-liveness: ok"
os::test::junit::declare_suite_end
