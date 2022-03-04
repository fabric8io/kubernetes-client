/**
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
package io.fabric8.java.generator;

import io.fabric8.java.generator.nodes.GeneratorResult;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApprovalTest {

  CRGeneratorRunner runner = new CRGeneratorRunner(new Config());

  CustomResourceDefinition getCRD(String name) {
    return Serialization.unmarshal(
        this.getClass().getClassLoader().getResourceAsStream(name),
        CustomResourceDefinition.class);
  }

  String getJavaClass(List<GeneratorResult.ClassResult> classResults, String name) {
    GeneratorResult.ClassResult cr = classResults.stream().filter(c -> c.getName().equals(name)).findFirst().get();
    return cr.getCompilationUnit().toString();
  }

  @Test
  void testCrontabCrd() {
    // Arrange
    CustomResourceDefinition crd = getCRD("crontab-crd.yml");

    // Act
    List<WritableCRCompilationUnit> writables = runner.generate(crd, runner.getPackage("test.org"));

    // Assert
    assertEquals(1, writables.size());
    assertThat(writables.size()).isEqualTo(1);

    WritableCRCompilationUnit writable = writables.get(0);

    List<String> underTest = new ArrayList<>();
    List<GeneratorResult.ClassResult> crl = writable.getClassResults();
    underTest.add(getJavaClass(crl, "CronTab"));
    underTest.add(getJavaClass(crl, "CronTabSpec"));
    underTest.add(getJavaClass(crl, "CronTabStatus"));

    Approvals.verifyAll("CrontabJavaCr", underTest);
  }

  @Test
  void testKeycloakCrd() {
    // Arrange
    CustomResourceDefinition crd = getCRD("keycloak-crd.yml");

    // Act
    List<WritableCRCompilationUnit> writables = runner.generate(crd, runner.getPackage("test.org"));

    // Assert
    assertEquals(1, writables.size());
    assertThat(writables.size()).isEqualTo(1);

    WritableCRCompilationUnit writable = writables.get(0);

    List<String> underTest = new ArrayList<>();
    List<GeneratorResult.ClassResult> crl = writable.getClassResults();
    underTest.add(getJavaClass(crl, "Keycloak"));
    underTest.add(getJavaClass(crl, "KeycloakSpec"));
    underTest.add(getJavaClass(crl, "KeycloakStatus"));

    Approvals.verifyAll("KeycloakJavaCr", underTest);
  }

  @Test
  void testJokeCrd() {
    // Arrange
    CustomResourceDefinition crd = getCRD("jokerequests-crd.yml");

    // Act
    List<WritableCRCompilationUnit> writables = runner.generate(crd, runner.getPackage("test.org"));

    // Assert
    assertEquals(1, writables.size());
    assertThat(writables.size()).isEqualTo(1);

    WritableCRCompilationUnit writable = writables.get(0);

    List<String> underTest = new ArrayList<>();
    List<GeneratorResult.ClassResult> crl = writable.getClassResults();
    underTest.add(getJavaClass(crl, "JokeRequest"));
    underTest.add(getJavaClass(crl, "JokeRequestSpec"));
    underTest.add(getJavaClass(crl, "JokeRequestStatus"));

    Approvals.verifyAll("JokeRequestJavaCr", underTest);
  }
}
