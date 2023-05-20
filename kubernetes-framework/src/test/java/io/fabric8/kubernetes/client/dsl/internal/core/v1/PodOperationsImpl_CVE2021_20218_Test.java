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
package io.fabric8.kubernetes.client.dsl.internal.core.v1;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class PodOperationsImpl_CVE2021_20218_Test {

  private PodOperationContext baseContext;

  @BeforeEach
  void setUp() {
    baseContext = new PodOperationContext();
  }

  @Test
  void testWithForgedTar(@TempDir Path targetDirParent) {
    // Given
    final Path targetDir = targetDirParent.resolve("target");
    final PodOperationsImpl poi = spy(new PodOperationsImpl(baseContext.withDir("/var/source-dir"), new OperationContext()));
    doReturn(PodOperationsImpl_CVE2021_20218_Test.class.getResourceAsStream("/2021_20218/tar-with-parent-traversal.tar"))
        .when(poi).readTar("/var/source-dir");
    // When
    final KubernetesClientException exception = assertThrows(KubernetesClientException.class, () -> poi.copy(targetDir));
    // Then
    assertThat(exception).getCause()
        .hasMessage("Tar entry '../youve-been-hacked' has an invalid name");
    assertThat(targetDirParent).isDirectoryNotContaining("glob:**/youve-been-hacked");
  }

  @Test
  void testWithValidTar(@TempDir Path targetDirParent) throws Exception {
    // Given
    final Path targetDir = targetDirParent.resolve("target");
    final PodOperationsImpl poi = spy(new PodOperationsImpl(baseContext.withDir("/var/source-dir"), new OperationContext()));
    doReturn(PodOperationsImpl_CVE2021_20218_Test.class.getResourceAsStream("/2021_20218/valid.tar"))
        .when(poi).readTar("/var/source-dir");
    // When
    final boolean result = poi.copy(targetDir);
    // Then
    assertThat(result).isTrue();
    assertThat(targetDir)
        .isDirectoryContaining("glob:**/hello.txt")
        .isDirectoryRecursivelyContaining("glob:**/very/nested/dir/answer.txt");
  }
}
