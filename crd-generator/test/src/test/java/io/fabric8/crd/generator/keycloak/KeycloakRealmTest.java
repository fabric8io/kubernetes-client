/*
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.crd.generator.keycloak;

import io.fabric8.crdv2.generator.CRDGenerator;
import io.fabric8.crdv2.generator.CRDInfo;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.CleanupMode;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class KeycloakRealmTest {

  private static final String CRD_NAME = "keycloakrealms.sample.fabric8.io";

  @TempDir(cleanup = CleanupMode.ON_SUCCESS)
  File tempDir;

  private CustomResourceDefinition crd;

  @BeforeEach
  void setUp() throws IOException {
    final Map<String, Map<String, CRDInfo>> result = new CRDGenerator()
        .inOutputDir(tempDir)
        .customResourceClasses(KeycloakRealm.class)
        .forCRDVersions("v1")
        .detailedGenerate()
        .getCRDDetailsPerNameAndVersion();

    assertThat(result).containsKey(CRD_NAME);
    crd = Serialization.unmarshal(
        Files.newInputStream(Paths.get(result.get(CRD_NAME).get("v1").getFilePath())),
        CustomResourceDefinition.class);
  }

  @Test
  @DisplayName("A real-world model with hundreds of classes is generated in full")
  void generatesRealWorldModel() {
    assertThat(crd.getMetadata().getName()).isEqualTo(CRD_NAME);
    assertThat(specSchema().getProperties())
        .containsKeys("realm", "groups", "clients")
        .hasSizeGreaterThan(50);
  }

  @Test
  @DisplayName("A cyclic field is unrolled to the depth its @SchemaSwap declares")
  void unrollsCyclicFieldToDeclaredDepth() {
    // GroupRepresentation.subGroups is a self-cycle, swapped with depth = 10
    JSONSchemaProps group = specSchema().getProperties().get("groups").getItems().getSchema();
    int depth = 0;
    while (group != null && group.getProperties() != null && group.getProperties().containsKey("subGroups")) {
      final JSONSchemaProps subGroups = group.getProperties().get("subGroups");
      group = subGroups.getItems() == null ? null : subGroups.getItems().getSchema();
      depth++;
    }
    assertThat(depth).isEqualTo(10);
  }

  private JSONSchemaProps specSchema() {
    return crd.getSpec().getVersions().get(0).getSchema().getOpenAPIV3Schema().getProperties().get("spec");
  }
}
