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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KubernetesResponseComposerTest {
  private KubernetesResponseComposer kubernetesResponseComposer;

  @BeforeEach
  void setUp() {
    kubernetesResponseComposer = new KubernetesResponseComposer();
  }

  static Stream<Arguments> composeInput() {
    return Stream.of(
        // https://github.com/fabric8io/kubernetes-client/issues/6220
        //        arguments("Secret", "SecretList"),
        arguments("", "List"));
  }

  @ParameterizedTest
  @MethodSource("composeInput")
  void compose_whenKindProvidedInListItem_shouldInferListKindCorrectly(String providedKind, String parsedListKind) {
    // Given
    Collection<String> collection = new ArrayList<>();
    collection.add(String.format("{\"kind\": \"%s\", \"apiVersion\": \"v1\", \"metadata\": {}}", providedKind));

    // When
    String listString = kubernetesResponseComposer.compose(collection, "1");

    // Then
    assertThat(Serialization.unmarshal(listString, KubernetesResourceList.class))
        .hasFieldOrPropertyWithValue("kind", parsedListKind);
  }
}
