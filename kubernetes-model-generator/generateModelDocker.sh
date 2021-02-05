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

# Build Docker Image using Dockerfile and run a container
# Parameter: module name
doDockerBuildBasedOnDockerFileAndRunContainer() {
    echo "Starting Docker Build for Dockerfile";
    docker build -t $1-model-generator-image .
    echo "Deleting container named $1 if exists";
    docker rm -f $1 || true
    echo "Running container named $1 based on image $1-generator-image";
    docker run --name $1 $1-model-generator-image  
}

# Once Docker container is running, copy schema files from container to host
# Parameter: container id, module name
copyGeneratedJsonSchemaFromContainerToHost() {
    echo "Copying $1:/home/generator/generated-schema/$2/kube-schema.json -> ./$2/src/main/resources/schema/kube-schema.json";
    docker cp $1:/home/generator/generated-schema/$2/kube-schema.json ./$2/src/main/resources/schema/kube-schema.json
    echo "Copying $1:/home/generator/generated-schema/$2/validation-schema.json -> ./$2/src/main/resources/schema/validation-schema.json";
    docker cp $1:/home/generator/generated-schema/$2/validation-schema.json ./$2/src/main/resources/schema/validation-schema.json
}

# Builds up a Dockerfile and docker image, then spins up a docker container 
# based on the image created. Finally the generated schema files are copied to
# specified module's src/main/resources/schema directory
# Parameter: module name
generateKubernetesModelSchemaForModule() {
    echo "Generating Dockerfile for module: $1";
    generateDockerFileForModule $1
    echo "Dockerfile generated. Starting docker build now...";
    doDockerBuildBasedOnDockerFileAndRunContainer $1;
    local containerId=`docker ps -aqf "name=$1"`;
    echo "Checking container: $containerId";

    copyGeneratedJsonSchemaFromContainerToHost $containerId $1
    rm Dockerfile
    echo "[Success] You can check updated JSON schema files in $1/src/main/resources/schema";
}

# Builds up a Dockerfile for all modules and docker image, then spings up a docker container
# based on the image created. Final all the generated schema files are copied to
# respective modules' src/main/resources/schema directories
generateKubernetesModelSchemaForAllModules() {
    moduleName="kubernetes-model-complete"
    echo "Generating Dockerfile for ALL modules";
    generateDockerFileForAllModules
    doDockerBuildBasedOnDockerFileAndRunContainer $moduleName;
    local containerId=`docker ps -aqf "name=$moduleName"`;
    for module in ${modules[*]}
    do
        copyGeneratedJsonSchemaFromContainerToHost $containerId $module
        echo "[Success] You can check updated JSON schema files in $module/src/main/resources/schema";
    done
    rm Dockerfile
}

# Generate Dockerfile for a docker based build for a specific module
# Parameter: module name
generateDockerFileForModule() {
    writeFromAndWorkdirToDockerfile;
    writeModelGenerationRunsToDockerFile $1;
    writeEntrypointToDockerFile;
}

# Write Dockerfile Header statements like FROM, ADD etc
writeFromAndWorkdirToDockerfile() {
    cat << EOF > Dockerfile
FROM golang:1.15.6
ADD .  /home/generator/
WORKDIR /home/generator/
RUN mkdir generated-schema
EOF
}

# Write Go Build and schema generation statements for a particular module
# Parameter: module name
writeModelGenerationRunsToDockerFile() {
    printf "RUN CGO_ENABLED=0 GO111MODULE=on GO15VENDOREXPERIMENT=1 go build -a ./$1/cmd/generate/generate.go\n" >> Dockerfile;
    printf "RUN sh -c 'mkdir -p ./generated-schema/$1'\n" >> Dockerfile;
    printf "RUN sh -c './generate > ./generated-schema/$1/kube-schema.json'\n" >> Dockerfile;
    printf "RUN sh -c './generate validation > ./generated-schema/$1/validation-schema.json'\n" >> Dockerfile
}

# Write an entrypoint which just lists contents of generated-schema folder
writeEntrypointToDockerFile() {
    printf "ENTRYPOINT [\"ls\", \"generated-schema\"]" >> Dockerfile; 
}

# Generate a Dockerfile for Schema generation for all modules
generateDockerFileForAllModules() {
    echo "generateDockerFileForAllModules";
    writeFromAndWorkdirToDockerfile;
    for module in ${modules[*]}
    do
        writeModelGenerationRunsToDockerFile $module;
    done
    writeEntrypointToDockerFile;
}

# Generate Kubernetes Model Schema for ALL modules by calling generateKubernetesModelSchemaForModule for each
# element of modules array
generateKubernetesModelSchemasForAllModules() {
    generateKubernetesModelSchemaForAllModules
}

# Check whether Docker is running by running a basic process list command
checkWhetherDockerRunning() {
    docker ps > /dev/null;
}

# Validate whether first argument is not null
checkWhetherCommandLineArgumentProvided() {
    if [ -z $1 ];
    then
        echo "Invalid argument; Sample Usage: sh generateModelDocker.sh [module-name]";
        exit 1;
    fi;
}

#####################################################################################
## Main 
#####################################################################################
checkWhetherCommandLineArgumentProvided $1
checkWhetherDockerRunning
if [ $1 == "all" ];
then
    echo "Building Model for ALL modules";
    generateKubernetesModelSchemasForAllModules
    exit 0;
fi;
generateKubernetesModelSchemaForModule $1
