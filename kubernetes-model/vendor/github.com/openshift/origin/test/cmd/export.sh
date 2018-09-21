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


os::test::junit::declare_suite_start "cmd/export"
# This test validates the export command

os::cmd::expect_success 'oc new-app -f examples/sample-app/application-template-stibuild.json --name=sample'

# this checks to make sure that the generated tokens and dockercfg secrets are excluded by default
# and included when --exact is requested
os::cmd::expect_success_and_text "oc export sa/default --template='{{ .secrets }}'" '<no value>'
os::cmd::expect_success_and_text "oc export sa/default --exact --template='{{ .secrets }}'" 'default-token'

os::cmd::expect_success 'oc export all --all-namespaces'
# make sure the deprecated flag doesn't fail
os::cmd::expect_success 'oc export all --all'

os::cmd::expect_success_and_not_text "oc export svc --template='{{range .items}}{{.metadata.name}}{{\"\n\"}}{{end}}' | wc -l" '^0' # don't expect a leading zero, i.e. expect non-zero count
os::cmd::expect_success_and_text 'oc export svc --as-template=template' 'kind: Template'
os::cmd::expect_success_and_not_text 'oc export svc' 'clusterIP'
os::cmd::expect_success_and_not_text 'oc export svc --exact' 'clusterIP: ""'
os::cmd::expect_success_and_not_text 'oc export svc --raw' 'clusterIP: ""'
os::cmd::expect_failure 'oc export svc --raw --exact'
os::cmd::expect_failure 'oc export svc -l a=b' # return error if no items match selector
os::cmd::expect_failure_and_text 'oc export svc -l a=b' 'no resources found'
os::cmd::expect_success 'oc export svc -l app=sample'
os::cmd::expect_success_and_text 'oc export -f examples/sample-app/application-template-stibuild.json --raw --output-version=v1' 'apiVersion: v1'
os::cmd::expect_success_and_text 'oc export dc/database --template="{{.status.latestVersion}}"' '0'
os::cmd::expect_success_and_text 'oc get dc/database --export --template="{{.status.conditions}}"' '<no value>'
echo "export: ok"
os::test::junit::declare_suite_end

