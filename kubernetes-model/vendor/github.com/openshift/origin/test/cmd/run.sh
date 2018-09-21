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

os::test::junit::declare_suite_start "cmd/run"
# This test validates the value of --image for oc run
os::cmd::expect_success_and_text 'oc run newdcforimage --image=validimagevalue' 'deploymentconfig "newdcforimage" created'
os::cmd::expect_failure_and_text 'oc run newdcforimage2 --image="InvalidImageValue0192"' 'error: Invalid image name "InvalidImageValue0192": invalid reference format'
os::cmd::expect_failure_and_text 'oc run test1 --image=busybox --attach --dry-run' "dry-run can't be used with attached containers options"
os::cmd::expect_failure_and_text 'oc run test1 --image=busybox --stdin --dry-run' "dry-run can't be used with attached containers options"
echo "oc run: ok"
os::test::junit::declare_suite_end
