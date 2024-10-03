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

MAVEN_OPTIONS ?=
OPENAPI_DIR=$(realpath ./kubernetes-model-generator/openapi)
OPENAPI_GENERATOR_DIR=$(OPENAPI_DIR)/generator
OPENAPI_GENERATOR_BINARY_NAME=generator
OPENAPI_GENERATOR_BINARY=$(OPENAPI_GENERATOR_DIR)/$(OPENAPI_GENERATOR_BINARY_NAME)
OPENAPI_SCHEMAS_DIR=$(OPENAPI_DIR)/schemas

.PHONY: clean-java
clean-java:
	mvn $(MAVEN_OPTIONS) clean

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
# TODO: Do for all modules once they've all been migrated
#	cd kubernetes-model-generator && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-common && mvn clean install
	cd kubernetes-model-generator/openapi/maven-plugin && mvn clean verify
	cd kubernetes-model-generator/kubernetes-model-core && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-rbac && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-admissionregistration && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-apiextensions && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-apps && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-autoscaling && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-batch && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-certificates && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-coordination && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-discovery && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-events && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-extensions && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-flowcontrol && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-gatewayapi && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-networking && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-metrics && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-node && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-policy && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-scheduling && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-storageclass && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-resource && mvn -Pgenerate clean install
	cd kubernetes-model-generator/kubernetes-model-kustomize && mvn -Pgenerate clean install
	cd kubernetes-model-generator/openshift-model-config && mvn -Pgenerate clean install
	cd kubernetes-model-generator/openshift-model && mvn -Pgenerate clean install
	cd kubernetes-model-generator/openshift-model-operator && mvn -Pgenerate clean install
	cd kubernetes-model-generator/openshift-model-miscellaneous && mvn -Pgenerate clean install
	cd kubernetes-model-generator/openshift-model-operatorhub && mvn -Pgenerate clean install
	cd kubernetes-model-generator/openshift-model-console && mvn -Pgenerate clean install
	cd kubernetes-model-generator/openshift-model-autoscaling && mvn -Pgenerate clean install
	cd kubernetes-model-generator/openshift-model-machine && mvn -Pgenerate clean install
	cd kubernetes-model-generator/openshift-model-machineconfiguration && mvn -Pgenerate clean install
	cd kubernetes-model-generator/openshift-model-monitoring && mvn -Pgenerate clean install
	cd kubernetes-model-generator/openshift-model-tuned && mvn -Pgenerate clean install
	cd kubernetes-model-generator/openshift-model-whereabouts && mvn -Pgenerate clean install
	cd kubernetes-model-generator/openshift-model-storageversionmigrator && mvn -Pgenerate clean install

# Legacy generation of the model: TODO: remove
.PHONY: generate-model-legacy
generate-model-legacy:
	cd kubernetes-model-generator && ./generateModel.sh

.PHONY: generate-model
generate-model: openapi-generate-schema openapi-generate-java-classes generate-model-legacy

.PHONY: sonar
sonar:
	mvn $(MAVEN_OPTIONS) clean install sonar:sonar -Psonar
