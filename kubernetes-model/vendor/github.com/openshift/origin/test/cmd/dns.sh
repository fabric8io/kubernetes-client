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
  oc delete svc,endpoints --all
  exit 0
) &>/dev/null


os::test::junit::declare_suite_start "cmd/dns"
# This test validates DNS behavior

ns="$(oc project -q)"
dig="dig @${API_HOST} -p 8053"
if ! os::util::ensure::system_binary_exists 'dig'; then
  dig="echo SKIPPED TEST: dig is not installed: "
fi

os::cmd::expect_success 'oc create -f test/testdata/services.yaml'
os::cmd::try_until_success "${dig} +short headless.${ns}.svc.cluster.local"

ip="$( oc get svc/clusterip --template '{{ .spec.clusterIP }}' )"

os::cmd::expect_success_and_text "${dig} +short headless.${ns}.svc.cluster.local | wc -l" "2"
os::cmd::expect_success_and_text "${dig} +short headless.${ns}.svc.cluster.local" "10.1.2.3"
os::cmd::expect_success_and_text "${dig} +short headless.${ns}.svc.cluster.local" "10.1.2.4"
os::cmd::expect_success_and_text "${dig} +short test2.headless.${ns}.svc.cluster.local" "^10.1.2.4$"
os::cmd::expect_success_and_text "${dig} +short _endpoints.headless.${ns}.svc.cluster.local | wc -l" "2"
os::cmd::expect_success_and_text "${dig} +short _endpoints.headless.${ns}.svc.cluster.local" "10.1.2.3"
os::cmd::expect_success_and_text "${dig} +short _endpoints.headless.${ns}.svc.cluster.local" "10.1.2.4"
os::cmd::expect_success_and_text "${dig} +short headless.${ns}.svc.cluster.local SRV" "^10 50 0 3987d90a.headless.${ns}.svc.cluster.local"
os::cmd::expect_success_and_text "${dig} +short headless.${ns}.svc.cluster.local SRV" "^10 50 0 test2.headless.${ns}.svc.cluster.local"
os::cmd::expect_success_and_text "${dig} +short test2.headless.${ns}.svc.cluster.local SRV" "^10 100 0 test2.headless.${ns}.svc.cluster.local"
os::cmd::expect_success_and_text "${dig} +short _http._tcp.headless.${ns}.svc.cluster.local SRV" "^10 50 80 3987d90a.headless.${ns}.svc.cluster.local"
os::cmd::expect_success_and_text "${dig} +short _http._tcp.headless.${ns}.svc.cluster.local SRV" "^10 50 80 test2.headless.${ns}.svc.cluster.local"

os::cmd::expect_success_and_text "${dig} +short clusterip.${ns}.svc.cluster.local" "^${ip}$"
os::cmd::expect_success_and_text "${dig} +short clusterip.${ns}.svc.cluster.local SRV" "^10 100 0 [0-9a-f]+.clusterip.${ns}.svc.cluster.local"
os::cmd::expect_success_and_text "${dig} +short _http._tcp.clusterip.${ns}.svc.cluster.local SRV" "^10 100 80 [0-9a-f]+.clusterip.${ns}.svc.cluster.local"
os::cmd::expect_success_and_text "${dig} +short _endpoints.clusterip.${ns}.svc.cluster.local | wc -l" "2"
os::cmd::expect_success_and_text "${dig} +short _endpoints.clusterip.${ns}.svc.cluster.local" "10.1.2.3"
os::cmd::expect_success_and_text "${dig} +short _endpoints.clusterip.${ns}.svc.cluster.local" "10.1.2.4"

echo "dns: ok"
os::test::junit::declare_suite_end
