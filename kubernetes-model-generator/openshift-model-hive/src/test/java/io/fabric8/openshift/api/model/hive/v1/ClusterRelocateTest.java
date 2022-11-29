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
package io.fabric8.openshift.api.model.hive.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ClusterRelocateTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-clusterrelocate.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ClusterRelocate clusterRelocate = mapper.readValue(originalJson, ClusterRelocate.class);
    final String serializedJson = mapper.writeValueAsString(clusterRelocate);
    final ClusterRelocate clusterRelocateFromSerializedJson = mapper.readValue(serializedJson, ClusterRelocate.class);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(clusterRelocate)
        .isNotNull()
        .isEqualTo(clusterRelocateFromSerializedJson)
        .hasFieldOrPropertyWithValue("metadata.name", "hive2-cluster-relocator")
        .hasFieldOrPropertyWithValue("spec.kubeconfigSecretRef.name", "hive2-remote-kubeconfig-secret")
        .hasFieldOrPropertyWithValue("spec.kubeconfigSecretRef.namespace", "hive")
        .hasFieldOrPropertyWithValue("spec.clusterDeploymentSelector.matchLabels",
            Collections.singletonMap("hive-instance", "hive2"));
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ClusterRelocateBuilder clusterRelocateBuilder = new ClusterRelocateBuilder()
        .withNewMetadata()
        .withName("hive2-cluster-relocator")
        .endMetadata()
        .withNewSpec()
        .withNewKubeconfigSecretRef()
        .withName("hive2-remote-kubeconfig-secret")
        .withNamespace("hive")
        .endKubeconfigSecretRef()
        .withNewClusterDeploymentSelector()
        .addToMatchLabels("hive-instance", "hive2")
        .endClusterDeploymentSelector()
        .endSpec();

    // When
    ClusterRelocate clusterRelocate = clusterRelocateBuilder.build();

    // Then
    assertThat(clusterRelocate)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "hive2-cluster-relocator")
        .hasFieldOrPropertyWithValue("spec.kubeconfigSecretRef.name", "hive2-remote-kubeconfig-secret")
        .hasFieldOrPropertyWithValue("spec.kubeconfigSecretRef.namespace", "hive")
        .hasFieldOrPropertyWithValue("spec.clusterDeploymentSelector.matchLabels",
            Collections.singletonMap("hive-instance", "hive2"));
  }
}
