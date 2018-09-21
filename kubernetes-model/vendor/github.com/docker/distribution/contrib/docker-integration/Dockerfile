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

FROM distribution/golem:0.1

MAINTAINER Docker Distribution Team <distribution@docker.com>

RUN apk add --no-cache git

ENV TMPDIR /var/lib/docker/tmp

WORKDIR /go/src/github.com/docker/distribution/contrib/docker-integration
