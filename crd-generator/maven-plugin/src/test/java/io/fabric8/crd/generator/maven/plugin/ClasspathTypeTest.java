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

import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.model.Build;
import org.apache.maven.project.MavenProject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class ClasspathTypeTest {

  private static final String RUNTIME_PATH = "/runtime";
  private static final String COMPILE_PATH = "/compile";
  private static final String TEST_PATH = "/test";
  private static final String PROJECT_PATH = "/project";

  private MavenProject project;

  @BeforeEach
  public void setUp() throws DependencyResolutionRequiredException {
    this.project = Mockito.mock(MavenProject.class);
    when(this.project.getRuntimeClasspathElements())
        .thenReturn(Collections.singletonList(RUNTIME_PATH));
    when(this.project.getCompileClasspathElements())
        .thenReturn(Collections.singletonList(COMPILE_PATH));
    when(this.project.getTestClasspathElements())
        .thenReturn(Collections.singletonList(TEST_PATH));

    Build build = new Build();
    build.setOutputDirectory(PROJECT_PATH);
    when(this.project.getBuild()).thenReturn(build);
  }

  @Test
  public void testGetUrlsCompile() {
    Set<String> urls = ClasspathType.WITH_COMPILE_DEPENDENCIES.getClasspathElements(this.project);
    assertEquals(1, urls.size());
    assertTrue(urls.contains(COMPILE_PATH));
  }

  @Test
  public void testGetUrlsRuntime() {
    Set<String> urls = ClasspathType.WITH_RUNTIME_DEPENDENCIES.getClasspathElements(this.project);
    assertEquals(1, urls.size());
    assertTrue(urls.contains(RUNTIME_PATH));
  }

  @Test
  public void testGetUrlsAll() {
    Set<String> urls = ClasspathType.WITH_ALL_DEPENDENCIES.getClasspathElements(this.project);
    assertEquals(2, urls.size());
    assertTrue(urls.contains(RUNTIME_PATH));
    assertTrue(urls.contains(COMPILE_PATH));
  }

  @Test
  public void testGetUrlsAllAndTests() {
    Set<String> urls = ClasspathType.WITH_ALL_DEPENDENCIES_AND_TESTS.getClasspathElements(this.project);
    assertEquals(3, urls.size());
    assertTrue(urls.contains(RUNTIME_PATH));
    assertTrue(urls.contains(COMPILE_PATH));
    assertTrue(urls.contains(TEST_PATH));
  }

  @Test
  public void testGetUrlsProject() {
    Set<String> urls = ClasspathType.PROJECT_ONLY.getClasspathElements(this.project);
    assertEquals(1, urls.size());
    assertTrue(urls.contains(PROJECT_PATH));
  }

}
