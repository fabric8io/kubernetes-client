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
import io.fabric8.kubernetes.client.dsl.ConfigMapResource;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.MockedStatic;

import java.io.IOException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
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
  void fromFile_withBlankFilePath_shouldThrowException() {
    // Given
    ConfigMapResource configMapOp = configMapOperations
        .inNamespace("default")
        .withName("game-config");

    // When
    assertThatIllegalArgumentException()
        .isThrownBy(() -> configMapOp.fromFile(""))
        .withMessage("invalid file path provided");
  }

  @Test
  void fromFile_withInvalidFilePath_shouldThrowException() {
    // Given
    ConfigMapResource configMapOp = configMapOperations
        .inNamespace("default")
        .withName("game-config");

    // When
    assertThatIllegalArgumentException()
        .isThrownBy(() -> configMapOp.fromFile("invalid-file"))
        .withMessage("File invalid-file doesn't exist");
  }

  @Test
  void fromFile_withValidFilePath_shouldDelegateCallToHelpermethod() {
    try (MockedStatic<KubernetesResourceUtil> kubernetesResourceUtilMockedStatic = mockStatic(KubernetesResourceUtil.class)) {
      // Given
      ConfigMapResource configMapOp = configMapOperations
          .inNamespace("default")
          .withName("game-config");
      ArgumentCaptor<String> filePathCaptor = ArgumentCaptor.forClass(String.class);
      URL fileUrl = getClass().getResource("/test-config.yml");
      assertThat(fileUrl).isNotNull();

      // When
      configMapOp.fromFile(fileUrl.getFile());

      // Then
      kubernetesResourceUtilMockedStatic
          .verify(() -> KubernetesResourceUtil.createNewConfigMapFromDirOrFile(eq("game-config"), eq("test-config.yml"),
              filePathCaptor.capture()));
      assertThat(filePathCaptor.getValue()).isEqualTo(fileUrl.getFile());
    }
  }

  @Test
  void fromFile_whenConfigMapCreationFailed_shouldThrowException() {
    try (MockedStatic<KubernetesResourceUtil> kubernetesResourceUtilMockedStatic = mockStatic(KubernetesResourceUtil.class)) {
      // Given
      kubernetesResourceUtilMockedStatic
          .when(() -> KubernetesResourceUtil.createNewConfigMapFromDirOrFile(any(), any(), any()))
          .thenThrow(new IOException("I/O error"));
      ConfigMapResource configMapOp = configMapOperations
          .inNamespace("default")
          .withName("game-config");
      URL fileUrl = getClass().getResource("/test-config.yml");
      assertThat(fileUrl).isNotNull();
      String filePath = fileUrl.getFile();

      // When + Then
      assertThatExceptionOfType(KubernetesClientException.class)
          .isThrownBy(() -> configMapOp.fromFile(filePath))
          .withMessage("Unable to create ConfigMap game-config");
    }
  }
}
