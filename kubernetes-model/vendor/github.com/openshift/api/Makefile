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

all: build
.PHONY: all

build:
	go build github.com/openshift/api/authorization/...
	go build github.com/openshift/api/apps/...
	go build github.com/openshift/api/build/...
	go build github.com/openshift/api/image/...
	go build github.com/openshift/api/network/...
	go build github.com/openshift/api/oauth/...
	go build github.com/openshift/api/project/...
	go build github.com/openshift/api/quota/...
	go build github.com/openshift/api/route/...
	go build github.com/openshift/api/security/...
	go build github.com/openshift/api/template/...
	go build github.com/openshift/api/user/...
	go build github.com/openshift/api/webconsole/...
.PHONY: build

test:
	go test github.com/openshift/api/pkg/testing/...
.PHONY: test

verify:
	hack/verify-deepcopy.sh
	hack/verify-protobuf.sh
	hack/verify-swagger-docs.sh
.PHONY: verify

update-deps:
	hack/update-deps.sh
.PHONY: update-deps

generate:
	hack/update-deepcopy.sh
	hack/update-protobuf.sh
	hack/update-swagger-docs.sh
.PHONY: generate
