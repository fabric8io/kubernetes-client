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

echo "===== Verifying Generated Client sets ====="
output=$(VERIFY=true ${OS_ROOT}/hack/update-generated-clientsets.sh)

if [[ "$?" == "0" ]]; then
  echo "SUCCESS: Generated client sets up to date."
else
  echo  $output
  echo "FAILURE: Generated client sets out of date. Please run hack/update-generated-clientsets.sh"
  exit 1
fi
