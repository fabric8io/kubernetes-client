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
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.MockedStatic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

class ConfigMapOperationsImplTest {
  private ConfigMapOperationsImpl configMapOperations;

  @BeforeEach
  void setUp() {
    OperationContext operationContext = new OperationContext();
    configMapOperations = new ConfigMapOperationsImpl(operationContext);
  }

  @Test
  void fromFile_withValidFilePath_shouldDelegateCallToHelperMethod() {
    try (MockedStatic<KubernetesResourceUtil> kubernetesResourceUtilMockedStatic = mockStatic(KubernetesResourceUtil.class)) {
      // Given
      ArgumentCaptor<Path> filePathCaptor = ArgumentCaptor.forClass(Path.class);
      Path path = new File(getClass().getResource("/test-config.yml").getFile()).toPath();

      // When
      configMapOperations.fromFile("game-config", path);

      // Then
      kubernetesResourceUtilMockedStatic
          .verify(() -> KubernetesResourceUtil.createNewConfigMapWithEntry(eq("game-config"),
              filePathCaptor.capture()));
      kubernetesResourceUtilMockedStatic
          .verify(() -> KubernetesResourceUtil.mergeConfigMapData(any(), any()));
      assertThat(filePathCaptor.getValue()).isEqualTo(path);
    }
  }

  @Test
  void fromFile_whenConfigMapCreationFailed_shouldThrowException() {
    try (MockedStatic<KubernetesResourceUtil> kubernetesResourceUtilMockedStatic = mockStatic(KubernetesResourceUtil.class)) {
      // Given
      kubernetesResourceUtilMockedStatic
          .when(() -> KubernetesResourceUtil.createNewConfigMapWithEntry(any(), any()))
          .thenThrow(new IOException("I/O error"));
      Path path = new File(getClass().getResource("/test-config.yml").getFile()).toPath();

      // When + Then
      assertThatExceptionOfType(KubernetesClientException.class)
          .isThrownBy(() -> configMapOperations.fromFile("game-config", path))
          .withMessage("Unable to create ConfigMap game-config");
    }
  }
}
