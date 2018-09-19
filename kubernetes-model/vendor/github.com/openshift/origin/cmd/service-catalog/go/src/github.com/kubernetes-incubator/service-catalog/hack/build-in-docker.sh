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


# This script build the sources in openshift/origin-release image using
# the Fedora environment and Go compiler.
function absolute_path() {
  pushd . > /dev/null
  [ -d "$1" ] && cd "$1" && dirs -l +0
  popd > /dev/null
}

STARTTIME=$(date +%s)
source "$(dirname "${BASH_SOURCE}")/lib/init.sh"
origin_path="src/github.com/openshift/origin"

# TODO: Remove this check and fix the docker command instead after the
#       following PR is merged: https://github.com/docker/docker/pull/5910
#       should be done in docker 1.6.
if [ -d /sys/fs/selinux ]; then
    if ! ls --context "$(absolute_path $OS_ROOT)" | grep --quiet svirt_sandbox_file_t; then
        os::text::print_red "Warning: SELinux labels are not set correctly; run chcon -Rt svirt_sandbox_file_t $(absolute_path $OS_ROOT)"
        exit 1
    fi
fi

docker run -e "OWNER_GROUP=$UID:$GROUPS" --rm -v "$(absolute_path $OS_ROOT):/go/${origin_path}" openshift/origin-release /usr/bin/openshift-origin-build.sh $@

ret=$?; ENDTIME=$(date +%s); echo "$0 took $(($ENDTIME - $STARTTIME)) seconds"; exit "$ret"
