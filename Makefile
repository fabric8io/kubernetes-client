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

.PHONY: clean-java
clean-java:
	mvn $(MAVEN_OPTIONS) clean

.PHONY: clean
clean: clean-java

.PHONY: generate-openapi
generate-openapi:
	cd kubernetes-model-generator/openapi/generator && go build
	./kubernetes-model-generator/openapi/generator/generator ./kubernetes-model-generator/openapi/schemas

.PHONY: generate-openapi-classes
generate-openapi-classes:
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

# Legacy generation of the model: TODO: remove
.PHONY: generate-model-legacy
generate-model-legacy:
	cd kubernetes-model-generator && ./generateModel.sh

.PHONY: generate-model
generate-model: generate-openapi generate-openapi-classes generate-model-legacy

.PHONY: sonar
sonar:
	mvn $(MAVEN_OPTIONS) clean install sonar:sonar -Psonar
