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
    #"openshift-model"
    #"openshift-model-operator"
    #"openshift-model-operatorhub"
    #"openshift-model-console"
    #"openshift-model-clusterautoscaling"
    #"openshift-model-machineconfig"
    #"openshift-model-machine"
    #"openshift-model-miscellaneous"
    #"openshift-model-monitoring"
    #"openshift-model-tuned"
    #"openshift-model-whereabouts"
    #"openshift-model-storageversionmigrator"
)

declare -a extensionModuleParents=(
    "../extensions/knative/pom.xml"
    "../extensions/camel-k/pom.xml"
    "../extensions/camel-k/pom.xml"
    "../extensions/chaosmesh/pom.xml"
    "../extensions/service-catalog/pom.xml"
    "../extensions/tekton/pom.xml"
    "../extensions/tekton/pom.xml"
    "../extensions/volumesnapshot/pom.xml"
)

declare -a extensionModules=(
    "../extensions/knative/generator"
    "../extensions/camel-k/generator-v1"
    "../extensions/camel-k/generator-v1alpha1"
    "../extensions/chaosmesh/generator"
    "../extensions/service-catalog/generator"
    "../extensions/tekton/generator-v1alpha1"
    "../extensions/tekton/generator-v1beta1"
    "../extensions/volumesnapshot/generator"
)

generateAll() {
  echo "Compiling core modules"
  generateSetOfModules "${modules[@]}"
  echo "Compiling extensions"
  extensionInstallCommonModules
  generateSetOfModules "${extensionModules[@]}"
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
    mvn clean install -f ../model-annotator/pom.xml
    #mvn clean install -DskipTests -f ../kubernetes-client/pom.xml
    #mvn clean install -DskipTests -f ../kubernetes-server-mock/pom.xml
    mvn clean install -N -f ../extensions/pom.xml
    for parent in ${extensionModuleParents[*]}
    do
        mvn clean install -N -f "$parent"
    done
    #mvn clean install -N -f ../extensions/knative/pom.xml
    #mvn clean install -N -f ../extensions/knative/model/pom.xml
}

echo "Installing required common modules"
mvn clean install -f ../pom.xml -N
mvn clean install -N
mvn clean install -pl kubernetes-model-common -pl kubernetes-model-jsonschema2pojo

if [ -z "$1" ]; then
  generateAll
else
  generateSingleModule "$1"
fi
