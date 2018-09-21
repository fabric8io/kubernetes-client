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

os::test::junit::declare_suite_start "cmd/completions"
# This test validates basic resource retrieval and command interaction

# test completion command help
os::cmd::expect_success_and_text "oc completion -h" "prints shell code"
os::cmd::expect_success_and_text "openshift completion -h" "prints shell code"
# test completion command output
os::cmd::expect_failure_and_text "oc completion" "Shell not specified."
os::cmd::expect_success "oc completion bash"
os::cmd::expect_success "oc completion zsh"
os::cmd::expect_failure_and_text "oc completion test_shell" 'Unsupported shell type "test_shell"'
# test completion command for openshift
os::cmd::expect_failure_and_text "openshift completion" "Shell not specified."
os::cmd::expect_success "openshift completion bash"
os::cmd::expect_success "openshift completion zsh"
os::cmd::expect_failure_and_text "openshift completion test_shell" 'Unsupported shell type "test_shell"'
echo "oc completion: ok"

os::test::junit::declare_suite_end
