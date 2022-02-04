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

import static com.google.testing.compile.Compiler.javac;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.tools.JavaFileObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;

class CompilationTest {

    private static TemporaryFolder tmpFolder = TemporaryFolder.builder().build();

    CRGeneratorRunner runner = new CRGeneratorRunner();

    List<JavaFileObject> getSources(File basePath) throws IOException {
        List<JavaFileObject> sources = new ArrayList<JavaFileObject>();
        for (Path f : Files.list(basePath.toPath()).collect(Collectors.toList())) {
            if (f.toFile().isDirectory()) {
                sources.addAll(getSources(f.toFile()));
            } else {
                sources.add(JavaFileObjects.forResource(f.toUri().toURL()));
            }
        }

        return sources;
    }

    File getCRD(String name) throws Exception {
        return Paths.get(this.getClass().getClassLoader().getResource(name).toURI()).toFile();
    }

    @BeforeAll
    public static void beforeAll() throws IOException {
        tmpFolder.create();
    }

    @Test
    void testCrontabCRDCompiles() throws Exception {
        // Arrange
        File crd = getCRD("crontab-crd.yml");
        File dest = tmpFolder.newFolder("crontab");

        // Act
        runner.run(crd, dest);
        Compilation compilation = javac().compile(getSources(dest));

        // Assert
        assertTrue(compilation.errors().isEmpty());
        assertEquals(3, compilation.sourceFiles().size());
        assertEquals(Compilation.Status.SUCCESS, compilation.status());
    }

    @Test
    void testKeycloakCRDCompiles() throws Exception {
        // Arrange
        File crd = getCRD("keycloak-crd.yml");
        File dest = tmpFolder.newFolder("keycloak");

        // Act
        runner.run(crd, dest);
        Compilation compilation = javac().compile(getSources(dest));

        // Assert
        assertTrue(compilation.errors().isEmpty());
        assertEquals(32, compilation.sourceFiles().size());
        assertEquals(Compilation.Status.SUCCESS, compilation.status());
    }

    @Test
    void testAkkaMicroservicesCRDCompiles() throws Exception {
        // Arrange
        File crd = getCRD("akka-microservices-crd.yml");
        File dest = tmpFolder.newFolder("akka-microservices");

        // Act
        runner.run(crd, dest);
        Compilation compilation = javac().compile(getSources(dest));

        // Assert
        assertTrue(compilation.errors().isEmpty());
        assertEquals(27, compilation.sourceFiles().size());
        assertEquals(Compilation.Status.SUCCESS, compilation.status());
    }

    @Test
    void testStrimziCRDCompiles() throws Exception {
        // Arrange
        File crd = getCRD("strimzi-kafka-crd.yml");
        File dest = tmpFolder.newFolder("strimzi");

        // Act
        runner.run(crd, dest);
        Compilation compilation = javac().compile(getSources(dest));

        // Assert
        assertTrue(compilation.errors().isEmpty());
        assertEquals(72, compilation.sourceFiles().size());
        assertEquals(Compilation.Status.SUCCESS, compilation.status());
    }

    @Test
    void testSparkCRDCompiles() throws Exception {
        // Arrange
        File crd = getCRD("spark-crd.yml");
        File dest = tmpFolder.newFolder("spark");

        // Act
        runner.run(crd, dest);
        Compilation compilation = javac().compile(getSources(dest));

        // Assert
        assertTrue(compilation.errors().isEmpty());
        assertEquals(97, compilation.sourceFiles().size());
        assertEquals(Compilation.Status.SUCCESS, compilation.status());
    }

    @Test
    void testCrunchyCRDCompiles() throws Exception {
        // Arrange
        File crd = getCRD("crunchy-postgres-crd.yml");
        File dest = tmpFolder.newFolder("crunchy");

        // Act
        runner.run(crd, dest);
        Compilation compilation = javac().compile(getSources(dest));

        // Assert
        assertTrue(compilation.errors().isEmpty());
        assertEquals(73, compilation.sourceFiles().size());
        assertEquals(Compilation.Status.SUCCESS, compilation.status());
    }

    @Test
    void testKameletCRDCompiles() throws Exception {
        // Arrange
        File crd = getCRD("kamelet-crd.yml");
        File dest = tmpFolder.newFolder("kamelet");

        // Act
        runner.run(crd, dest);
        Compilation compilation = javac().compile(getSources(dest));

        // Assert
        assertTrue(compilation.errors().isEmpty());
        assertEquals(15, compilation.sourceFiles().size());
        assertEquals(Compilation.Status.SUCCESS, compilation.status());
    }

    @Test
    void testJokeRequestsCRDCompiles() throws Exception {
        // Arrange
        File crd = getCRD("jokerequests-crd.yml");
        File dest = tmpFolder.newFolder("jokes");

        // Act
        runner.run(crd, dest);
        Compilation compilation = javac().compile(getSources(dest));

        // Assert
        assertTrue(compilation.errors().isEmpty());
        assertEquals(3, compilation.sourceFiles().size());
        assertEquals(Compilation.Status.SUCCESS, compilation.status());
    }

    @Test
    void testCertManagerCRDCompiles() throws Exception {
        // Arrange
        File crd = getCRD("cert-manager-crd.yml");
        File dest = tmpFolder.newFolder("cert-manager");

        // Act
        runner.run(crd, dest);
        Compilation compilation = javac().compile(getSources(dest));

        // Assert
        assertTrue(compilation.errors().isEmpty());
        assertEquals(5, compilation.sourceFiles().size());
        assertEquals(Compilation.Status.SUCCESS, compilation.status());
    }

    @Test
    void testMultipleCRDsCompiles() throws Exception {
        // Arrange
        File crd = getCRD("two-crds.yml");
        File dest = tmpFolder.newFolder("two-crds");

        // Act
        runner.run(crd, dest);
        Compilation compilation = javac().compile(getSources(dest));

        // Assert
        assertTrue(compilation.errors().isEmpty());
        assertEquals(6, compilation.sourceFiles().size());
        assertEquals(Compilation.Status.SUCCESS, compilation.status());
    }

    @AfterAll
    public static void afterAll() {
        tmpFolder.delete();
    }
}
