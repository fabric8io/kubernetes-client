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

# Test that resource printer includes resource kind on multiple resources
os::test::junit::declare_suite_start "cmd/basicresources/printer"
os::cmd::expect_success 'oc create imagestream test1'
os::cmd::expect_success 'oc new-app node'
os::cmd::expect_success_and_text 'oc get all' 'imagestreams/test1'
os::cmd::expect_success_and_not_text 'oc get is' 'imagestreams/test1'

# Test that resource printer includes namespaces for buildconfigs with custom strategies
os::cmd::expect_success 'oc create -f examples/sample-app/application-template-custombuild.json'
os::cmd::expect_success_and_text 'oc new-app ruby-helloworld-sample' 'deploymentconfig "frontend" created'
os::cmd::expect_success_and_text 'oc get all --all-namespaces' 'cmd-printer[\ ]+buildconfigs\/ruby\-sample\-build'

# Test that infos printer supports all outputFormat options
os::cmd::expect_success_and_text 'oc new-app node -o yaml | oc set env -f - MYVAR=value' 'deploymentconfig "node" updated'
os::cmd::expect_success 'oc new-app node -o yaml | oc set env -f - MYVAR=value -o custom-colums="NAME:.metadata.name"'
os::cmd::expect_success_and_text 'oc new-app node -o yaml | oc set env -f - MYVAR=value -o yaml' 'apiVersion: v1'
os::cmd::expect_success_and_text 'oc new-app node -o yaml | oc set env -f - MYVAR=value -o json' '"apiVersion": "v1"'
os::cmd::expect_success_and_text 'oc new-app node -o yaml | oc set env -f - MYVAR=value -o wide' 'node'
os::cmd::expect_success_and_text 'oc new-app node -o yaml | oc set env -f - MYVAR=value -o name' 'deploymentconfigs/node'
echo "resource printer: ok"
os::test::junit::declare_suite_end