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


# This script builds the dind images so they can be baked into the ami
# to reduce minimize the potential for dnf flakes in ci.
#
# Reference: https://github.com/openshift/origin/issues/11452

STARTTIME=$(date +%s)
source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

os::build::image "${OS_ROOT}/images/dind"        openshift/dind
os::build::image "${OS_ROOT}/images/dind/node"   openshift/dind-node
os::build::image "${OS_ROOT}/images/dind/master" openshift/dind-master

ret=$?; ENDTIME=$(date +%s); echo "$0 took $(($ENDTIME - $STARTTIME)) seconds"; exit "$ret"
