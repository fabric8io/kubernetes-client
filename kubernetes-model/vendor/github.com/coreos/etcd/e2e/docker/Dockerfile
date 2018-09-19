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

FROM golang:1.8.4-stretch

RUN apt-get -y update
RUN apt-get -y install \
  netcat \
  libaspell-dev \
  libhunspell-dev \
  hunspell-en-us \
  aspell-en \
  shellcheck

RUN mkdir -p ${GOPATH}/src/github.com/coreos/etcd
WORKDIR ${GOPATH}/src/github.com/coreos/etcd

ADD ./scripts/install-marker.sh ./scripts/install-marker.sh

RUN go get -v -u -tags spell github.com/chzchzchz/goword \
  && go get -v -u github.com/coreos/license-bill-of-materials \
  && go get -v -u honnef.co/go/tools/cmd/gosimple \
  && go get -v -u honnef.co/go/tools/cmd/unused \
  && go get -v -u honnef.co/go/tools/cmd/staticcheck \
  && go get -v -u github.com/wadey/gocovmerge \
  && ./scripts/install-marker.sh amd64
