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
import org.approvaltests.namer.NamedEnvironment;
import org.approvaltests.namer.NamerFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertThat;
import static io.fabric8.java.generator.CRGeneratorRunner.groupToPackage;

class ApprovalTest {

  private static Stream<Arguments> getCRDGenerationInputData() {
    return Stream.of(
        Arguments.of("testCrontabCrd", "crontab-crd.yml", "CronTab", "CrontabJavaCr", new Config()),
        Arguments.of("testCrontabExtraAnnotationsCrd", "crontab-crd.yml", "CronTab", "CrontabJavaExtraAnnotationsCr",
            new Config(null, null, null, null, Boolean.TRUE, null, true, new HashMap<>())),
        Arguments.of("testKeycloakCrd", "keycloak-crd.yml", "Keycloak", "KeycloakJavaCr", new Config()),
        Arguments.of("testJokeCrd", "jokerequests-crd.yml", "JokeRequest", "JokeRequestJavaCr", new Config()),
        Arguments.of("testAkkaMicroservicesCrd", "akka-microservices-crd.yml", "AkkaMicroservice", "AkkaMicroserviceJavaCr",
            new Config()));
  }

  @ParameterizedTest
  @MethodSource("getCRDGenerationInputData")
  void generate_withValidCrd_shouldGeneratePojos(String parameter, String crdYaml, String customResourceName,
      String approvalLabel, Config config) {
    try (NamedEnvironment en = NamerFactory.withParameters(parameter)) {
      // Arrange
      CRGeneratorRunner runner = new CRGeneratorRunner(config);
      CustomResourceDefinition crd = getCRD(crdYaml);

      // Act
      List<WritableCRCompilationUnit> writables = runner.generate(crd, groupToPackage("test.org"));

      // Assert
      assertThat(writables).hasSize(1);

      WritableCRCompilationUnit writable = writables.get(0);

      List<String> underTest = new ArrayList<>();
      List<GeneratorResult.ClassResult> crl = writable.getClassResults();
      underTest.add(getJavaClass(crl, customResourceName));
      underTest.add(getJavaClass(crl, customResourceName + "Spec"));
      underTest.add(getJavaClass(crl, customResourceName + "Status"));

      Approvals.verifyAll(approvalLabel, underTest);
    }
  }

  private CustomResourceDefinition getCRD(String name) {
    return Serialization.unmarshal(
        this.getClass().getClassLoader().getResourceAsStream(name),
        CustomResourceDefinition.class);
  }

  private String getJavaClass(List<GeneratorResult.ClassResult> classResults, String name) {
    GeneratorResult.ClassResult cr = classResults.stream().filter(c -> c.getName().equals(name)).findFirst().get();
    return cr.getCompilationUnit().toString();
  }
}
