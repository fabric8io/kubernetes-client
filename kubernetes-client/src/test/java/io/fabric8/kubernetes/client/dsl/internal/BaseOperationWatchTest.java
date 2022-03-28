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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.PodResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SuppressWarnings({ "rawtypes", "FieldCanBeLocal" })
class BaseOperationWatchTest {

  private Watcher<Pod> watcher;
  private OperationContext operationContext;
  private BaseOperation<Pod, PodList, PodResource> baseOperation;

  @SuppressWarnings("unchecked")
  @BeforeEach
  void setUp() {
    watcher = mock(Watcher.class);
    operationContext = mock(OperationContext.class, RETURNS_DEEP_STUBS);
    baseOperation = new BaseOperation<>(operationContext);
  }

  @Test
  @DisplayName("watch, with exception on connection open, should throw Exception and close WatchConnectionManager")
  void watchWithExceptionOnOpen() {
    try (
        final MockedConstruction<WatchConnectionManager> m = mockConstruction(WatchConnectionManager.class, (mock, context) -> {
          // Given
          Mockito.when(mock.getWebsocketFuture())
              .thenReturn(failedFuture(new KubernetesClientException("Mocked Connection Error")));
        })) {
      // When
      final KubernetesClientException result = assertThrows(KubernetesClientException.class,
          () -> {
            baseOperation.watch(watcher);
            fail();
          });
      // Then
      assertThat(result).hasMessage("Mocked Connection Error");
      assertThat(m.constructed())
          .hasSize(1)
          .element(0)
          .matches(wcm -> {
            verify(wcm, times(1)).close();
            return true;
          });
    }
  }

  @Test
  @DisplayName("watch, with retryable exception on connection open, should close initial WatchConnectionManager and retry")
  void watchWithRetryableExceptionOnOpen() {
    try (
        final MockedConstruction<WatchConnectionManager> m = mockConstruction(WatchConnectionManager.class, (mock, context) -> {
          // Given
          Mockito.when(mock.getWebsocketFuture())
              .thenReturn(failedFuture(new KubernetesClientException(new StatusBuilder().withCode(503).build())));
        });
        final MockedConstruction<WatchHTTPManager> mHttp = mockConstruction(WatchHTTPManager.class)) {
      // When
      final Watch result = baseOperation.watch(watcher);
      // Then
      assertThat(result).isInstanceOf(WatchHTTPManager.class).isSameAs(mHttp.constructed().get(0));
      assertThat(m.constructed())
          .hasSize(1)
          .element(0)
          .matches(wcm -> {
            verify(wcm, times(1)).close();
            return true;
          });
    }
  }

  private CompletableFuture failedFuture(KubernetesClientException kubernetesClientException) {
    CompletableFuture result = new CompletableFuture();
    result.completeExceptionally(kubernetesClientException);
    return result;
  }
}
