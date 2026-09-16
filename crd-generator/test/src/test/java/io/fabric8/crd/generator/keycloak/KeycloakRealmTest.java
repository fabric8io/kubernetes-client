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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.CleanupMode;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class KeycloakRealmTest {

  @TempDir(cleanup = CleanupMode.ON_SUCCESS)
  File tempDir;

  @Test
  @DisplayName("A deep real-world model with cycles is generated without overflowing the stack")
  void generatesDeeplyNestedModel() {
    final Map<String, Map<String, CRDInfo>> result = new CRDGenerator()
        .inOutputDir(tempDir)
        .customResourceClasses(KeycloakRealm.class)
        .forCRDVersions("v1")
        .detailedGenerate()
        .getCRDDetailsPerNameAndVersion();

    assertThat(result).containsKey("keycloakrealms.sample.fabric8.io");
    assertThat(result.get("keycloakrealms.sample.fabric8.io").get("v1").getFilePath())
        .asString()
        .isNotEmpty();
  }
}
