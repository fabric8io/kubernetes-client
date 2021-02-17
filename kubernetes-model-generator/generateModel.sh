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

set -e

BASEDIR=$(dirname "$BASH_SOURCE")
ABSOLUTE_BASEDIR=$(realpath "$BASEDIR")

# Array for all existing modules
declare -a modules=(
    "kubernetes-model-core"
    "kubernetes-model-rbac"
    "kubernetes-model-admissionregistration"
    "kubernetes-model-apiextensions"
    "kubernetes-model-apps"
    "kubernetes-model-autoscaling"
    "kubernetes-model-batch"
    "kubernetes-model-certificates"
    "kubernetes-model-coordination"
    "kubernetes-model-discovery"
    "kubernetes-model-events"
    "kubernetes-model-extensions"
    "kubernetes-model-networking"
    "kubernetes-model-metrics"
    "kubernetes-model-node"
    "kubernetes-model-policy"
    "kubernetes-model-scheduling"
    "kubernetes-model-storageclass"
    "openshift-model"
    "openshift-model-operator"
    "openshift-model-operatorhub"
    "openshift-model-console"
    "openshift-model-monitoring"
)
generateAll() {
  for module in ${modules[*]}
  do
    generateSingleModule "$module"
  done
}

generateSingleModule() {
  echo "Compiling $1"
  cd "$ABSOLUTE_BASEDIR/$1" || exit 1
  make "gobuild"
  if test -n "${LOCAL_USER-}"; then
    chown -R "$LOCAL_USER" ./src/main/resources/schema
  fi
  cd "$ABSOLUTE_BASEDIR" || exit 1
}

if [ -z "$1" ]; then
  generateAll
else
  generateSingleModule "$1"
fi
