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
    "kubernetes-model-flowcontrol"
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
    "openshift-model-clusterautoscaling"
    "openshift-model-hive"
    "openshift-model-installer"
    "openshift-model-machineconfig"
    "openshift-model-machine"
    "openshift-model-miscellaneous"
    "openshift-model-monitoring"
    "openshift-model-tuned"
    "openshift-model-whereabouts"
    "openshift-model-storageversionmigrator"
    "../extensions/knative/generator"
    "../extensions/camel-k/generator-v1"
    "../extensions/camel-k/generator-v1alpha1"
    "../extensions/certmanager/generator-v1"
    "../extensions/certmanager/generator-v1alpha2"
    "../extensions/certmanager/generator-v1alpha3"
    "../extensions/certmanager/generator-v1beta1"
    "../extensions/chaosmesh/generator"
    "../extensions/service-catalog/generator"
    "../extensions/tekton/generator-v1alpha1"
    "../extensions/tekton/generator-v1beta1"
    "../extensions/tekton/generator-triggers"
    "../extensions/verticalpodautoscaler/generator-v1"
    "../extensions/volcano/generator-v1beta1"
    "../extensions/volumesnapshot/generator"
    "../extensions/istio/generator-v1alpha3"
    "../extensions/istio/generator-v1beta1"
    "../extensions/open-cluster-management/generator-apps"
    "../extensions/open-cluster-management/generator-agent"
    "../extensions/open-cluster-management/generator-cluster"
    "../extensions/open-cluster-management/generator-discovery"
    "../extensions/open-cluster-management/generator-observability"
    "../extensions/open-cluster-management/generator-operator"
    "../extensions/open-cluster-management/generator-placementruleapps"
    "../extensions/open-cluster-management/generator-policy"
    "../extensions/open-cluster-management/generator-search"
)

declare -a extensionModuleParents=(
    "../extensions/knative/pom.xml"
    "../extensions/camel-k/pom.xml"
    "../extensions/certmanager/pom.xml"
    "../extensions/chaosmesh/pom.xml"
    "../extensions/service-catalog/pom.xml"
    "../extensions/tekton/pom.xml"
    "../extensions/verticalpodautoscaler/pom.xml"
    "../extensions/volcano/pom.xml"
    "../extensions/volumesnapshot/pom.xml"
    "../extensions/istio/pom.xml"
)

generateAll() {
  generateSetOfModules "${modules[@]}"
}

generateSetOfModules() {
  moduleList=("$@")
  for module in "${moduleList[@]}"
  do
    generateSingleModule "$module"
  done
}

generateSingleModule() {
  echo "Compiling $1"
  cd "$ABSOLUTE_BASEDIR/$1" || exit 1
  make "build"
  if test -n "${LOCAL_USER-}"; then
    SCHEMA_FILE=./src/main/resources/schema
    EXTENSION_SCHEMA_FILE=../model/src/main/resources/schema
    if test -f $SCHEMA_FILE; then
        chown -R "$LOCAL_USER" ./src/main/resources/schema
    elif test -f $EXTENSION_SCHEMA_FILE; then
        chown -R "$LOCAL_USER" ../model/src/main/resources/schema
    fi
  fi
  cd "$ABSOLUTE_BASEDIR" || exit 1
}

extensionInstallCommonModules() {
    mvn clean install -N -f ../extensions/pom.xml
    for parent in ${extensionModuleParents[*]}
    do
        mvn clean install -N -f "$parent"
    done
}

echo "Installing required common modules"
mvn clean install -f ../pom.xml -N
mvn clean install -N
mvn clean install -pl kubernetes-model-common -pl kubernetes-model-jsonschema2pojo
extensionInstallCommonModules

if [ -z "$1" ]; then
  generateAll
else
  generateSingleModule "$1"
fi
