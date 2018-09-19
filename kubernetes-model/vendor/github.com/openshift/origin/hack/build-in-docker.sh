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

source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

function cleanup() {
	return_code=$?
	os::util::describe_return_code "${return_code}"
	exit "${return_code}"
}
trap "cleanup" EXIT

origin_path="src/github.com/openshift/origin"

docker run -e "OWNER_GROUP=$UID:$GROUPS" --rm -v "$(absolute_path $OS_ROOT):/go/${origin_path}:z" openshift/origin-release /usr/bin/openshift-origin-build.sh $@
