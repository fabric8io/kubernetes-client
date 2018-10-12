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

# Output command before executing
set -x

# Exit on error
set -e

# Source environment variables of the jenkins slave
# that might interest this worker.
function load_jenkins_vars() {
  if [ -e "jenkins-env.json" ]; then
    eval "$(./env-toolkit load -f jenkins-env.json \
      JENKINS_URL \
      GIT_BRANCH \
      GIT_COMMIT \
      BUILD_NUMBER \
      ghprbSourceBranch \
      ghprbActualCommit \
      BUILD_URL \
      ghprbPullId \
      PUBRING \
      SEC_JENKINS \
      SECRING \
      TRUSTDB \
      GPG_PASSPHRASE \
      SONATYPE_USERNAME \
      SONATYPE_PASSWORD \
      )"
  fi
}

function install_deps() {
  # We need to disable selinux for now, XXX
  /usr/sbin/setenforce 0 || :

  # Get all the deps in
  yum -y install docker

  service docker start

  echo 'CICO: Dependencies installed'
}

function setup() {
  load_jenkins_vars
  install_deps
}

function build() {
  docker exec $CID mvn clean install -DskipTests
}

function release() {
  docker exec -i $CID /bin/bash -c 'bash release.sh '
}

function check_if_tagged() {
  # We need to disable selinux for now, XXX
  /usr/sbin/setenforce 0 || :

  # Get all the deps in
  yum -y install git

  head=$(git ls-remote https://github.com/fabric8io/kubernetes-client.git cico-test | cut -c1-40)
  latest_tagged=$(git ls-remote --tags https://github.com/fabric8io/kubernetes-client.git | grep $head)
  echo $latest_tagged

  if [ -z "$latest_tagged" ]
  then
    is_latest_tagged=1
    echo 'Latest tagged commit is not tagged. No need to run the release pipeline'
    return 0
  else
    is_latest_tagged=0
    echo 'Latest commit is tagged. Proceeding the release pipeline'
    return 1
  fi
}
