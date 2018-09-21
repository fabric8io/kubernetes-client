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


# Provides simple utility functions

######
# end of common functions for extended test group's run.sh scripts
######

function find_files() {
	find . -not \( \
		\( \
		-wholename './_output' \
		-o -wholename './.*' \
		-o -wholename './pkg/assets/bindata.go' \
		-o -wholename './pkg/assets/*/bindata.go' \
		-o -wholename './pkg/bootstrap/bindata.go' \
		-o -wholename './openshift.local.*' \
		-o -wholename './test/extended/testdata/bindata.go' \
		-o -wholename '*/vendor/*' \
		-o -wholename './assets/bower_components/*' \
		\) -prune \
	\) -name '*.go' | sort -u
}
readonly -f find_files
