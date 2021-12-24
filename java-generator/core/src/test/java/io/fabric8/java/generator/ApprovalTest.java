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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.utils.Serialization;
import java.util.ArrayList;
import java.util.List;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

class ApprovalTest {

    CRGeneratorRunner runner = new CRGeneratorRunner();

    CustomResourceDefinition getCRD(String name) {
        return Serialization.unmarshal(
                this.getClass().getClassLoader().getResourceAsStream(name),
                CustomResourceDefinition.class);
    }

    @Test
    void testCrontabCrd() {
        // Arrange
        CustomResourceDefinition crd = getCRD("crontab-crd.yml");

        // Act
        List<WritableCRCompilationUnit> writables =
                runner.generate(crd, runner.getPackage("test.org"));

        // Assert
        assertEquals(1, writables.size());
        assertThat(writables.size()).isEqualTo(1);

        WritableCRCompilationUnit writable = writables.get(0);

        List<String> underTest = new ArrayList<>();
        underTest.add(writable.getJavaClass("CronTab"));
        underTest.add(writable.getJavaClass("CronTabSpec"));
        underTest.add(writable.getJavaClass("CronTabStatus"));

        Approvals.verifyAll("CrontabJavaCr", underTest);
    }

    @Test
    void testKeycloakCrd() {
        // Arrange
        CustomResourceDefinition crd = getCRD("keycloak-crd.yml");

        // Act
        List<WritableCRCompilationUnit> writables =
                runner.generate(crd, runner.getPackage("test.org"));

        // Assert
        assertEquals(1, writables.size());
        assertThat(writables.size()).isEqualTo(1);

        WritableCRCompilationUnit writable = writables.get(0);

        List<String> underTest = new ArrayList<>();
        underTest.add(writable.getJavaClass("Keycloak"));
        underTest.add(writable.getJavaClass("KeycloakSpec"));
        underTest.add(writable.getJavaClass("KeycloakStatus"));

        Approvals.verifyAll("KeycloakJavaCr", underTest);
    }

    @Test
    void testJokeCrd() {
        // Arrange
        CustomResourceDefinition crd = getCRD("jokerequests-crd.yml");

        // Act
        List<WritableCRCompilationUnit> writables =
                runner.generate(crd, runner.getPackage("test.org"));

        // Assert
        assertEquals(1, writables.size());
        assertThat(writables.size()).isEqualTo(1);

        WritableCRCompilationUnit writable = writables.get(0);

        List<String> underTest = new ArrayList<>();
        underTest.add(writable.getJavaClass("JokeRequest"));
        underTest.add(writable.getJavaClass("JokeRequestSpec"));
        underTest.add(writable.getJavaClass("JokeRequestStatus"));

        Approvals.verifyAll("JokeRequestJavaCr", underTest);
    }
}
