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

SHELL := /bin/bash

all: build

build: gobuild
	mvn -f ../model-v1alpha1/pom.xml -Pgenerate clean install -DskipTests -o
	mvn -f ../model-v1beta1/pom.xml -Pgenerate clean install -DskipTests -o
	mvn -f ../model-v1/pom.xml -Pgenerate clean install -DskipTests -o

gobuild:
	go run ./cmd/generate/generate-v1.go > ../model-v1/src/main/resources/schema/tekton-schema-v1.json
	go run ./cmd/generate/generate-v1alpha1.go > ../model-v1alpha1/src/main/resources/schema/tekton-schema-v1alpha1.json
	go run ./cmd/generate/generate-v1beta1.go > ../model-v1beta1/src/main/resources/schema/tekton-schema-v1beta1.json
