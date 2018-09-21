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


# This script is meant to be the entrypoint for OpenShift Bash scripts to import all of the support
# libraries at once in order to make Bash script preambles as minimal as possible. This script recur-
# sively `source`s *.sh files in this directory tree. As such, no files should be `source`ed outside
# of this script to ensure that we do not attempt to overwrite read-only variables.

set -o errexit
set -o nounset
set -o pipefail

API_GROUP_VERSIONS="\
apps/v1 \
authorization/v1 \
build/v1 \
image/v1 \
network/v1 \
oauth/v1 \
project/v1 \
quota/v1 \
route/v1 \
security/v1 \
template/v1 \
user/v1 \
webconsole/v1 \
"
API_PACKAGES="\
github.com/openshift/api/apps/v1,\
github.com/openshift/api/authorization/v1,\
github.com/openshift/api/build/v1,\
github.com/openshift/api/image/v1,\
github.com/openshift/api/network/v1,\
github.com/openshift/api/oauth/v1,\
github.com/openshift/api/project/v1,\
github.com/openshift/api/quota/v1,\
github.com/openshift/api/route/v1,\
github.com/openshift/api/security/v1,\
github.com/openshift/api/template/v1,\
github.com/openshift/api/user/v1,\
github.com/openshift/api/webconsole/v1\
"
