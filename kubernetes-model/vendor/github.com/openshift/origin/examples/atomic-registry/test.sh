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


###
# basic install and run test for atomic registry quickstart image
# run with "uninstall" argument to test tear down after test
###

# $1 is optional hostname override

set -o errexit
set -o pipefail
set -x

# we're going to use this for testing
# node ports aren't working with boxes default hostname localdomain.localhost
MASTER_CONTAINER=${1:-atomic-registry-master}
HOST=${2:-`hostname`}
CMD="docker exec -i ${MASTER_CONTAINER}"

USER=mary
PROJ=mary-project

function test_push() {
  # login as $USER and do a basic docker workflow
  $CMD oc login -u ${USER} -p test
  $CMD oc new-project ${PROJ}
  $CMD oc policy add-role-to-group registry-viewer system:authenticated
  TOKEN=$($CMD oc whoami -t)
  docker login -p ${TOKEN} -u unused -e test@example.com ${HOST}:5000
  docker pull busybox
  docker tag busybox ${HOST}:5000/${PROJ}/busybox
  docker push ${HOST}:5000/${PROJ}/busybox
  docker rmi busybox ${HOST}:5000/${PROJ}/busybox
  docker logout
}

function test_cannot_push() {
  # in shared mode...
  # we pull $USERS's image, tag and try to push
  # bob shouldn't be able to push
  $CMD oc login -u bob -p test
  TOKEN=$($CMD oc whoami -t)
  docker login -p ${TOKEN} -u unused -e test@example.com ${HOST}:5000
  docker pull ${HOST}:5000/${PROJ}/busybox
  docker tag ${HOST}:5000/${PROJ}/busybox ${HOST}:5000/${PROJ}/busybox:evil
  if docker push ${HOST}:5000/${PROJ}/busybox:evil; then
    echo "registry-viewer user should not have been able to push to repo"
    docker logout
    exit 1
  fi
  docker rmi ${HOST}:5000/${PROJ}/busybox ${HOST}:5000/${PROJ}/busybox:evil
  docker logout
}

# first we need to patch for the vagrant port mapping 443 -> 1443
$CMD oc login -u system:admin
$CMD oc patch oauthclient cockpit-oauth-client -p '{ "redirectURIs": [ "https://'"${HOST}"':1443" ] }'

test_push
test_cannot_push
