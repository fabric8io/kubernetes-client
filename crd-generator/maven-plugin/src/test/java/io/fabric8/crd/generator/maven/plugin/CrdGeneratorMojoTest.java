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
package io.fabric8.crd.generator.maven.plugin;

import io.fabric8.crd.generator.collector.CustomResourceCollector;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.ArgumentCaptor;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

class CrdGeneratorMojoTest {

  @Test
  void checkFindingJarArchiveForDependency(@TempDir File tempDir) throws MojoExecutionException, IOException {
    CrdGeneratorMojo crdGeneratorMojo = new CrdGeneratorMojo();
    crdGeneratorMojo.mavenProject = Mockito.mock(MavenProject.class);
    crdGeneratorMojo.classpath = Mockito.mock(ClasspathType.class);

    crdGeneratorMojo.classesToIndex = tempDir;
    crdGeneratorMojo.outputDirectory = tempDir;

    File dummyJar = new File(tempDir, "test.jar");
    Files.write(dummyJar.toPath(), "dummy".getBytes());

    Artifact artifact1 = Mockito.mock(Artifact.class);
    when(artifact1.getGroupId()).thenReturn("othergroup");
    when(artifact1.getArtifactId()).thenReturn("otherartifact");
    when(artifact1.getFile()).thenReturn(new File("/not-existing"));

    Artifact artifact2 = Mockito.mock(Artifact.class);
    when(artifact2.getGroupId()).thenReturn("mygroup");
    when(artifact2.getArtifactId()).thenReturn("otherartifact");
    when(artifact2.getFile()).thenReturn(new File("/not-existing"));

    Artifact artifact3 = Mockito.mock(Artifact.class);
    when(artifact3.getGroupId()).thenReturn("mygroup");
    when(artifact3.getArtifactId()).thenReturn("myartifact");
    when(artifact3.getFile()).thenReturn(dummyJar);
    when(crdGeneratorMojo.mavenProject.getArtifacts())
        .thenReturn(Stream.of(artifact1, artifact2, artifact3).collect(Collectors.toSet()));

    Dependency dependency = new Dependency();
    dependency.setGroupId("mygroup");
    dependency.setArtifactId("myartifact");
    crdGeneratorMojo.dependenciesToIndex = Collections.singletonList(dependency);

    @SuppressWarnings("unchecked")
    ArgumentCaptor<List<File>> captor = ArgumentCaptor.forClass(List.class);

    try (MockedConstruction<CustomResourceCollector> mockedConstruction = Mockito
        .mockConstruction(CustomResourceCollector.class, (mock, context) -> {
          given(mock.withParentClassLoader(any())).willReturn(mock);
          given(mock.withClasspathElements(any())).willReturn(mock);
          given(mock.withFilesToIndex(captor.capture())).willReturn(mock);
          given(mock.withForceIndex(anyBoolean())).willReturn(mock);
          given(mock.withCustomResourceClasses(any())).willReturn(mock);
          given(mock.withIncludePackages(any())).willReturn(mock);
          given(mock.withIncludeGroups(any())).willReturn(mock);
          given(mock.withIncludeVersions(any())).willReturn(mock);
          given(mock.withExcludePackages(any())).willReturn(mock);
          given(mock.withExcludeGroups(any())).willReturn(mock);
          given(mock.withExcludeVersions(any())).willReturn(mock);
        })) {
      crdGeneratorMojo.execute();
      assertTrue(captor.getValue().contains(dummyJar));
    }
  }
}
