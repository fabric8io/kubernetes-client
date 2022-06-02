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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.APIResourceList;
import io.fabric8.kubernetes.api.model.APIResourceListBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.networking.v1.Ingress;
import io.fabric8.kubernetes.client.dsl.internal.OperationSupport;
import io.fabric8.kubernetes.client.http.HttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

class BaseClientTest {

  private HttpClient httpClient;
  private BaseClient baseClient;

  @BeforeEach
  void setUp() {
    httpClient = mock(HttpClient.class, RETURNS_DEEP_STUBS);
    baseClient = new BaseClient(httpClient, Config.empty(), () -> Runnable::run) {
      @Override
      BaseClient newInstance(Config config) {
        return baseClient;
      }

      @Override
      public Client newClient(RequestConfig requestConfig) {
        return baseClient;
      }
    };
  }

  @Test
  @DisplayName("supports, with matchingGroupPredicate function, should evaluate function")
  void supportsWithMatchingGroupPredicate() {
    // Given
    final AtomicBoolean called = new AtomicBoolean(false);
    baseClient.setMatchingGroupPredicate(s -> {
      called.set(true);
      return true;
    });
    // When
    final boolean result = baseClient.supports(Pod.class);
    // Then
    assertThat(called).isTrue();
    assertThat(result).isTrue();
  }

  @Test
  @DisplayName("supports Pod, with no support in server, should check API server and return false")
  void supportsPodNotInServer() {
    try (MockedConstruction<OperationSupport> ignore = mockConstruction(OperationSupport.class,
        (mock, ctx) -> when(mock.restCall(APIResourceList.class, "api", "v1"))
            .thenReturn(new APIResourceListBuilder().build()))) {
      // When
      final boolean result = baseClient.supports(Pod.class);
      // Then
      assertThat(result).isFalse();
    }
  }

  @Test
  @DisplayName("supports Pod, with support in server, should check API server and return true")
  void supportsPodInServer() {
    try (MockedConstruction<OperationSupport> ignore = mockConstruction(OperationSupport.class,
        (mock, ctx) -> when(mock.restCall(APIResourceList.class, "api", "v1"))
            .thenReturn(new APIResourceListBuilder().addNewResource().withKind("Pod").endResource().build()))) {
      // When
      final boolean result = baseClient.supports(Pod.class);
      // Then
      assertThat(result).isTrue();
    }
  }

  @Test
  @DisplayName("supports Ingress, with support in server, should check API server and return true")
  void supportsIngressInServer() {
    try (MockedConstruction<OperationSupport> ignore = mockConstruction(OperationSupport.class,
        (mock, ctx) -> when(mock.restCall(APIResourceList.class, "/apis", "networking.k8s.io/v1"))
            .thenReturn(new APIResourceListBuilder().addNewResource().withKind("Ingress").endResource().build()))) {
      // When
      final boolean result = baseClient.supports(Ingress.class);
      // Then
      assertThat(result).isTrue();
    }
  }

}
