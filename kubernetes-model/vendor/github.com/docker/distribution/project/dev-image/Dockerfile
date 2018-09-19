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

FROM ubuntu:14.04

ENV GOLANG_VERSION 1.4rc1
ENV GOPATH /var/cache/drone
ENV GOROOT /usr/local/go
ENV PATH $PATH:$GOROOT/bin:$GOPATH/bin

ENV LANG C
ENV LC_ALL C

RUN apt-get update && apt-get install -y \
  wget ca-certificates git mercurial bzr \
  --no-install-recommends \
  && rm -rf /var/lib/apt/lists/*

RUN wget https://golang.org/dl/go$GOLANG_VERSION.linux-amd64.tar.gz --quiet && \
  tar -C /usr/local -xzf go$GOLANG_VERSION.linux-amd64.tar.gz && \
  rm go${GOLANG_VERSION}.linux-amd64.tar.gz

RUN go get github.com/axw/gocov/gocov github.com/mattn/goveralls github.com/golang/lint/golint
