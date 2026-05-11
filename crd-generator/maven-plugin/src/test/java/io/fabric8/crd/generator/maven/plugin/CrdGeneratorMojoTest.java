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

import org.apache.maven.toolchain.Toolchain;
import org.apache.maven.toolchain.ToolchainManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

class CrdGeneratorMojoTest {

  private CrdGeneratorMojo mojo;
  private ToolchainManager toolchainManager;

  @BeforeEach
  void setUp() {
    toolchainManager = mock(ToolchainManager.class);
    // session is only forwarded to toolchainManager; since toolchainManager is mocked
    // we stub with any() and don't need to mock MavenSession itself
    mojo = new CrdGeneratorMojo(toolchainManager, null, null);
  }

  @Test
  void resolveJavaExecutable_returnsNull_whenNeitherToolchainNorExplicitSet() {
    when(toolchainManager.getToolchainFromBuildContext(eq("jdk"), any())).thenReturn(null);
    assertNull(mojo.resolveJavaExecutable());
  }

  @Test
  void resolveJavaExecutable_returnsExplicit_whenSet() {
    mojo.javaExecutable = "/path/to/java";
    assertEquals("/path/to/java", mojo.resolveJavaExecutable());
    verifyNoInteractions(toolchainManager);
  }

  @Test
  void resolveJavaExecutable_returnsToolchainJava_whenToolchainConfigured() {
    Toolchain tc = mock(Toolchain.class);
    when(toolchainManager.getToolchainFromBuildContext(eq("jdk"), any())).thenReturn(tc);
    when(tc.findTool("java")).thenReturn("/toolchain/bin/java");
    assertEquals("/toolchain/bin/java", mojo.resolveJavaExecutable());
  }

  @Test
  void resolveJavaExecutable_prefersExplicit_overToolchain() {
    mojo.javaExecutable = "/explicit/java";
    // toolchain should not even be consulted when javaExecutable is set
    assertEquals("/explicit/java", mojo.resolveJavaExecutable());
    verifyNoInteractions(toolchainManager);
  }

  @Test
  void resolveJavaExecutable_returnsNull_whenToolchainReturnsNoJavaTool() {
    Toolchain tc = mock(Toolchain.class);
    when(toolchainManager.getToolchainFromBuildContext(eq("jdk"), any())).thenReturn(tc);
    when(tc.findTool("java")).thenReturn(null);
    assertNull(mojo.resolveJavaExecutable());
  }

  @Test
  void resolveJavaExecutable_returnsNull_whenToolchainManagerIsNull() {
    CrdGeneratorMojo mojoWithoutToolchain = new CrdGeneratorMojo(null, null, null);
    assertNull(mojoWithoutToolchain.resolveJavaExecutable());
  }
}
