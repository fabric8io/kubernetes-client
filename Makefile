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
	# Test dependency needed for model de/serialization validation
	mvn $(MAVEN_ARGS) clean install -pl . -pl zjsonpatch
	cd kubernetes-model-generator && mvn $(MAVEN_ARGS) -Pgenerate clean install
	# Every extensions/**/model module, discovered rather than enumerated: this list also decides what
	# the generate-model.yml drift check can see, so a hand-written one fails open — an extension model
	# module missing from it is never regenerated and its committed Builders go stale silently.
	# Discovery has to be guarded or it fails open the same way: an empty result would collapse to
	# `-pl .`, which builds only the aggregator and reports success having regenerated nothing.
	cd extensions && \
		MODELS="$$(find . -path '*/target' -prune -o -path '*/model/pom.xml' -print | sed 's|/pom.xml$$||;s|^\./||' | sort | tr '\n' ',' | sed 's/,$$//')" && \
		{ [ -n "$$MODELS" ] || { echo 'ERROR: no extensions/**/model modules discovered; refusing to regenerate nothing' >&2; exit 1; }; } && \
		mvn $(MAVEN_ARGS) -pl ".,$$MODELS" -Pgenerate clean install

.PHONY: generate-model
generate-model: openapi-generate-schema openapi-generate-java-classes

.PHONY: sonar
sonar: clean
	mvn $(MAVEN_ARGS) -Pcoverage install
	mvn -Pcoverage,sonar sonar:sonar -DskipTests

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

JAVADOC_LINK_MODULES = \
  kubernetes-model-core:kubernetes-model-generator/kubernetes-model-core \
  kubernetes-model-common:kubernetes-model-generator/kubernetes-model-common \
  kubernetes-client-api:kubernetes-client-api \
  kubernetes-client:kubernetes-client \
  openshift-client-api:openshift-client-api \
  openshift-client:openshift-client

.PHONY: generate-javadoc-links
generate-javadoc-links:
	@for entry in $(JAVADOC_LINK_MODULES); do \
	  name=$${entry%%:*}; \
	  path=$${entry##*:}; \
	  mkdir -p doc/javadoc-links/$$name; \
	  { find $$path/src/main/java $$path/src/generated/java $$path/src/generated-builders/java $$path/target/generated-sources/annotations -name "*.java" 2>/dev/null || true; } | \
	    sed 's|.*/main/java/||;s|.*/generated-builders/java/||;s|.*/generated/java/||;s|.*/generated-sources/annotations/||;s|/[^/]*\.java$$||;s|/|.|g' | \
	    sort -u > doc/javadoc-links/$$name/element-list; \
	  echo "Generated doc/javadoc-links/$$name/element-list"; \
	done

.PHONY: quickly
quickly: clean
	mvn $(MAVEN_ARGS) install -DskipTests -Djacoco.skip=true

.PHONY: install
install: clean
	mvn $(MAVEN_ARGS) install

# Generate Revapi compatibility reports comparing against last release
.PHONY: revapi-report
revapi-report: quickly
	@echo "Generating Revapi JSON reports"
	# || true is intentional: revapi:check exits non-zero when it detects API differences, which was
	# causing the build to fail even when the goal is only to generate a report, not enforce compatibility.
	@if [ -z "$(OLD_ARTIFACT_VERSION)" ]; then \
		mvn $(MAVEN_ARGS) -Prevapi-compare revapi:check || true; \
	else \
		mvn $(MAVEN_ARGS) -Prevapi-compare -Drevapi.oldVersion=$(OLD_ARTIFACT_VERSION) revapi:check || true; \
	fi
	@echo "Aggregating reports into target/staging..."
	jbang scripts/AggregateRevapiReports.java

# Compare two specific published versions (fetches JARs from Maven Central, no local build needed)
# Usage: make revapi-compare-jars OLD_ARTIFACT_VERSION=7.5.0 NEW_ARTIFACT_VERSION=7.6.0
.PHONY: revapi-compare-jars
revapi-compare-jars:
	@if [ -z "$(OLD_ARTIFACT_VERSION)" ] || [ -z "$(NEW_ARTIFACT_VERSION)" ]; then \
		echo "Error: Both OLD_ARTIFACT_VERSION and NEW_ARTIFACT_VERSION must be specified"; \
		echo "Usage: make revapi-compare-jars OLD_ARTIFACT_VERSION=7.5.0 NEW_ARTIFACT_VERSION=7.6.0"; \
		exit 1; \
	fi
	@echo "Comparing $(OLD_ARTIFACT_VERSION) -> $(NEW_ARTIFACT_VERSION)"
	@echo "Generating Revapi JSON reports"
	# || true is intentional: revapi:check exits non-zero when it detects API differences, which was
	# causing the build to fail even when the goal is only to generate a report, not enforce compatibility.
	mvn $(MAVEN_ARGS) -Prevapi-compare-jars -Drevapi.oldArtifactVersion=$(OLD_ARTIFACT_VERSION) -Drevapi.newArtifactVersion=$(NEW_ARTIFACT_VERSION) revapi:check || true
	@echo "Aggregating reports into target/staging..."
	REVAPI_OLD_VERSION=$(OLD_ARTIFACT_VERSION) REVAPI_NEW_VERSION=$(NEW_ARTIFACT_VERSION) jbang scripts/AggregateRevapiReports.java
	@echo "✓ Reports generated in target/staging/"
