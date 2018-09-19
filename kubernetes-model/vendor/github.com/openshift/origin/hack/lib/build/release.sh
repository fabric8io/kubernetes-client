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


# This library holds utility functions for building releases.

# os::build::release::check_for_rpms checks that an RPM release has been built
function os::build::release::check_for_rpms() {
	if [[ ! -d "${OS_OUTPUT_RPMPATH}" || ! -d "${OS_OUTPUT_RPMPATH}/repodata" ]]; then
		relative_release_path="$( os::util::repository_relative_path "${OS_OUTPUT_RELEASEPATH}" )"
		relative_bin_path="$( os::util::repository_relative_path "${OS_OUTPUT_BINPATH}" )"
		os::log::fatal "No release RPMs have been built! RPMs are necessary to build container images.
Build them with:
  $ OS_BUILD_ENV_PRESERVE=${relative_bin_path}:${relative_release_path} hack/env make build-rpms"
	fi
}
