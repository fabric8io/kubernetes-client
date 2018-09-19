#!/usr/bin/env bash
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


TEST_SUFFIX=$(date +%s | base64 | head -c 15)

TEST_OPTS="RELEASE_TEST=y INTEGRATION=y PASSES='build unit release integration_e2e functional' MANUAL_VER=v3.2.11"
if [ "$TEST_ARCH" == "386" ]; then
	TEST_OPTS="GOARCH=386 PASSES='build unit integration_e2e'"
fi

docker run \
	--rm \
	--volume=`pwd`:/go/src/github.com/coreos/etcd \
	gcr.io/etcd-development/etcd-test:go1.8.5 \
	/bin/bash -c "${TEST_OPTS} ./test 2>&1 | tee test-${TEST_SUFFIX}.log"

! egrep "(--- FAIL:|panic: test timed out|appears to have leaked)" -B50 -A10 test-${TEST_SUFFIX}.log
