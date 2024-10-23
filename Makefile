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

.DEFAULT_GOAL := quickly
MAVEN_ARGS ?=
override MAVEN_ARGS += -T 1C
OPENAPI_DIR=$(realpath ./kubernetes-model-generator/openapi)
OPENAPI_GENERATOR_DIR=$(OPENAPI_DIR)/generator
OPENAPI_GENERATOR_BINARY_NAME=generator
OPENAPI_GENERATOR_BINARY=$(OPENAPI_GENERATOR_DIR)/$(OPENAPI_GENERATOR_BINARY_NAME)
OPENAPI_SCHEMAS_DIR=$(OPENAPI_DIR)/schemas

.PHONY: clean-java
clean-java:
	mvn $(MAVEN_ARGS) clean

.PHONY: clean
clean: clean-java

.PHONY: openapi-generate-schema
openapi-generate-schema:
	cd $(OPENAPI_GENERATOR_DIR) && go generate ./...
	cd $(OPENAPI_GENERATOR_DIR) && go build -o $(OPENAPI_GENERATOR_BINARY_NAME) ./cmd
	$(OPENAPI_GENERATOR_BINARY) reflection $(OPENAPI_SCHEMAS_DIR)
  # To be able to access the go sources and mod information must be run from the root of the (Go) project
	cd $(OPENAPI_GENERATOR_DIR) && ./$(OPENAPI_GENERATOR_BINARY_NAME) open-api $(OPENAPI_SCHEMAS_DIR)

.PHONY: openapi-generate-java-classes
openapi-generate-java-classes:
	cd kubernetes-model-generator && mvn $(MAVEN_ARGS) -Pgenerate clean install
	# TODO: run generate from extensions module root once all extensions are migrated
	cd extensions && mvn $(MAVEN_ARGS) -N clean install
	cd extensions/knative && mvn $(MAVEN_ARGS) -N clean install
	cd extensions/knative/model && mvn $(MAVEN_ARGS) -Pgenerate clean install
	cd extensions/tekton && mvn $(MAVEN_ARGS) -N clean install
	cd extensions/tekton/model && mvn $(MAVEN_ARGS) -Pgenerate clean install
	cd extensions/verticalpodautoscaler && mvn $(MAVEN_ARGS) -N clean install
	cd extensions/verticalpodautoscaler/model && mvn $(MAVEN_ARGS) -Pgenerate clean install
	cd extensions/volcano && mvn $(MAVEN_ARGS) -N clean install
	cd extensions/volcano/model && mvn $(MAVEN_ARGS) -Pgenerate clean install
	cd extensions/volumesnapshot && mvn $(MAVEN_ARGS) -N clean install
	cd extensions/volumesnapshot/model && mvn $(MAVEN_ARGS) -Pgenerate clean install

# Legacy generation of the model: TODO: remove
.PHONY: generate-model-legacy
generate-model-legacy:
	cd kubernetes-model-generator && ./generateModel.sh

.PHONY: generate-model
generate-model: openapi-generate-schema openapi-generate-java-classes generate-model-legacy

.PHONY: sonar
sonar: clean
	# $(MAVEN_ARGS) ---> -T 1C won't work with sonar analysis (yet)
	mvn -Psonar install sonar:sonar

.PHONY: javadoc
javadoc: clean
	mvn $(MAVEN_ARGS) install javadoc:jar -DskipTests -Pjavadoc-test

.PHONY: format-license
format-license:
	mvn $(MAVEN_ARGS) -N license:format

.PHONY: format-java
format-java:
	mvn $(MAVEN_ARGS) spotless:apply -Pitests

.PHONY: format
format: format-license format-java

.PHONY:
quickly: clean
	mvn $(MAVEN_ARGS) install -DskipTests -Djacoco.skip=true
