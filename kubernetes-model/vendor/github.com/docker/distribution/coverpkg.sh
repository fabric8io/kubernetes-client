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

# Given a subpackage and the containing package, figures out which packages
# need to be passed to `go test -coverpkg`:  this includes all of the
# subpackage's dependencies within the containing package, as well as the
# subpackage itself.
DEPENDENCIES="$(go list -f $'{{range $f := .Deps}}{{$f}}\n{{end}}' ${1} | grep ${2} | grep -v github.com/docker/distribution/vendor)"
echo "${1} ${DEPENDENCIES}" | xargs echo -n | tr ' ' ','
