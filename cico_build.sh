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

set -x

# Exit on error
set -e

source ./cico_setup.sh

check_if_tagged
proceed=$?
if [ $proceed -eq '0' ]
then
    exit
fi

setup

# Build kubernetes-model image
docker build -t kubernetes-client --build-arg PUBRING=$PUBRING \
    SEC_JENKINS=$SEC_JENKINS \
    SECRING=$SECRING \
    TRUSTDB=$TRUSTDB \
    GPG_PASSPHRASE=$GPG_PASSPHRASE \
    SONATYPE_USERNAME=$SONATYPE_USERNAME \
    SONATYPE_PASSWORD=$SONATYPE_PASSWORD \
    .

CID=$(docker run --detach=true -t kubernetes-client)
# CID=$(docker run --detach=true -t kubernetes-client fabric8/maven-builder)
build

release