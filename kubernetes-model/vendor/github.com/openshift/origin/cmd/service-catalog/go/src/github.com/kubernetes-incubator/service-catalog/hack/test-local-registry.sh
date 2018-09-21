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

os::build::setup_env

os::util::ensure::built_binary_exists 'dockerregistry'

url="${DOCKER_REGISTRY_URL:-localhost:5000}"
# find the first builder service account token
token="$(oc get $(oc get secrets -o name | grep builder-token | head -n 1) --template '{{ .data.token }}' | os::util::base64decode)"
echo
echo "Login with:"
echo "  docker login -p \"${token}\" -u user ${url}"
echo

REGISTRY_STORAGE_FILESYSTEM_ROOTDIRECTORY="${REGISTRY_STORAGE_FILESYSTEM_ROOTDIRECTORY:-/tmp/registry}" \
  DOCKER_REGISTRY_URL="${url}" \
	KUBECONFIG=openshift.local.config/master/openshift-registry.kubeconfig \
	dockerregistry images/dockerregistry/config.yml
