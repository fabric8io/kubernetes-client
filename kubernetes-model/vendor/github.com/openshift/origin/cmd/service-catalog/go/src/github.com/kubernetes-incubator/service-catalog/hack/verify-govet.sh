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

os::golang::verify_go_version

govet_blacklist=(
	"pkg/auth/ldaputil/client.go:[0-9]+: assignment copies lock value to c: crypto/tls.Config contains sync.Once contains sync.Mutex"
	"pkg/.*/client/clientset_generated/internalclientset/fake/clientset_generated.go:[0-9]+: literal copies lock value from fakePtr: github.com/openshift/origin/vendor/k8s.io/kubernetes/pkg/client/testing/core.Fake"
	"pkg/.*/client/clientset_generated/release_v1_./fake/clientset_generated.go:[0-9]+: literal copies lock value from fakePtr: github.com/openshift/origin/vendor/k8s.io/kubernetes/pkg/client/testing/core.Fake"
	"pkg/.*/clientset/internalclientset/fake/clientset_generated.go:[0-9]+: literal copies lock value from fakePtr: github.com/openshift/origin/vendor/k8s.io/kubernetes/pkg/client/testing/core.Fake"
	"pkg/.*/clientset/release_v3_./fake/clientset_generated.go:[0-9]+: literal copies lock value from fakePtr: github.com/openshift/origin/vendor/k8s.io/kubernetes/pkg/client/testing/core.Fake"
)

function govet_blacklist_contains() {
	local text=$1
	for blacklist_entry in "${govet_blacklist[@]}"; do
		if grep -Eqx "${blacklist_entry}" <<<"${text}"; then
			# the text we got matches this blacklist entry
			return 0
		fi
	done
	return 1
}

test_dirs="$(find_files | cut -d '/' -f 1-2 | sort -u)"
for test_dir in ${test_dirs}; do
	if ! result="$(go tool vet -shadow=false "${test_dir}" 2>&1)"; then
		while read -r line; do
			if ! govet_blacklist_contains "${line}"; then
				echo "${line}"
				FAILURE=true
			fi
		done <<<"${result}"
	fi
done

# We don't want to exit on the first failure of go vet, so just keep track of
# whether a failure occurred or not.
if [[ -n "${FAILURE:-}" ]]; then
	echo "FAILURE: go vet failed!"
	exit 1
else
	echo "SUCCESS: go vet succeeded!"
	exit 0
fi
