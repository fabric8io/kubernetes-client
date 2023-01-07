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
package io.fabric8.chaosmesh.client;

import io.fabric8.kubernetes.api.model.APIGroup;
import io.fabric8.kubernetes.api.model.APIGroupBuilder;
import io.fabric8.kubernetes.api.model.APIGroupList;
import io.fabric8.kubernetes.api.model.APIGroupListBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.internal.OperationSupport;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.impl.KubernetesClientImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

class ChaosMeshClientAdaptTest {
  private KubernetesClient kubernetesClient;

  @BeforeEach
  public void setUp() {
    HttpClient mockClient = Mockito.mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    Config config = new ConfigBuilder().withMasterUrl("https://localhost:8443/").build();
    kubernetesClient = new KubernetesClientImpl(mockClient, config);
  }

  @AfterEach
  void tearDown() {
    kubernetesClient.close();
    kubernetesClient = null;
  }

  @ParameterizedTest
  @MethodSource("getInputData")
  void isSupported_withGivenApiGroup_shouldValidateSupport(String apiGroupName, boolean expectedResult) {
    try (MockedConstruction<OperationSupport> ignored = mockConstruction(OperationSupport.class, (mock, ctx) -> {
      givenApiGroupsCallReturns(mock, new APIGroupBuilder().withName(apiGroupName).build());
    })) {
      assertThat(kubernetesClient.isAdaptable(ChaosMeshClient.class)).isEqualTo(expectedResult);
    }
  }

  private static Stream<Arguments> getInputData() {
    return Stream.of(
        Arguments.of("chaos-mesh.org", true),
        Arguments.of("test.chaos-mesh.org", true),
        Arguments.of("tekton.dev", false));
  }

  private void givenApiGroupsCallReturns(OperationSupport operationSupport, APIGroup apiGroup) {
    when(operationSupport.restCall(APIGroupList.class, "/apis"))
        .thenReturn(new APIGroupListBuilder()
            .addToGroups(apiGroup)
            .build());
  }
}
