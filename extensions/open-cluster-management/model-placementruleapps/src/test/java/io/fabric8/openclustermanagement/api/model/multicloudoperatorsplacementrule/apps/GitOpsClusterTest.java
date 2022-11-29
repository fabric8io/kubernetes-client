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
package io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openclustermanagement.api.model.multicloudintegration.apps.v1beta1.GitOpsCluster;
import io.fabric8.openclustermanagement.api.model.multicloudintegration.apps.v1beta1.GitOpsClusterBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GitOpsClusterTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-gitopscluster.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final GitOpsCluster gitOpsCluster = mapper.readValue(originalJson, GitOpsCluster.class);
    final String serializedJson = mapper.writeValueAsString(gitOpsCluster);
    final GitOpsCluster gocFromSerializedJson = mapper.readValue(serializedJson, GitOpsCluster.class);

    // Then
    assertNotNull(gitOpsCluster);
    assertNotNull(serializedJson);
    assertNotNull(gocFromSerializedJson);
    assertEquals(gitOpsCluster.getMetadata().getName(), gocFromSerializedJson.getMetadata().getName());
    assertEquals("notused", gitOpsCluster.getSpec().getArgoServer().getCluster());
    assertEquals("openshift-gitops", gitOpsCluster.getSpec().getArgoServer().getArgoNamespace());
    assertEquals("all-openshift-clusters", gitOpsCluster.getSpec().getPlacementRef().getName());
    assertEquals("Placement", gitOpsCluster.getSpec().getPlacementRef().getKind());
    assertEquals("cluster.open-cluster-management.io/v1alpha1", gitOpsCluster.getSpec().getPlacementRef().getApiVersion());
    assertEquals("openshift-gitops", gitOpsCluster.getSpec().getPlacementRef().getNamespace());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    GitOpsClusterBuilder gitOpsClusterBuilder = new GitOpsClusterBuilder()
        .withNewMetadata()
        .withName("argo-acm-importer")
        .endMetadata()
        .withNewSpec()
        .withNewArgoServer()
        .withCluster("notused")
        .withArgoNamespace("openshift-gitops")
        .endArgoServer()
        .withNewPlacementRef()
        .withApiVersion("cluster.open-cluster-management.io/v1alpha1")
        .withKind("Placement")
        .withName("all-openshift-clusters")
        .withNamespace("openshift-gitops")
        .endPlacementRef()
        .endSpec();

    // When
    GitOpsCluster gitOpsCluster = gitOpsClusterBuilder.build();

    // Then
    assertNotNull(gitOpsCluster);
    assertEquals("argo-acm-importer", gitOpsCluster.getMetadata().getName());
    assertEquals("notused", gitOpsCluster.getSpec().getArgoServer().getCluster());
    assertEquals("openshift-gitops", gitOpsCluster.getSpec().getArgoServer().getArgoNamespace());
    assertEquals("all-openshift-clusters", gitOpsCluster.getSpec().getPlacementRef().getName());
    assertEquals("Placement", gitOpsCluster.getSpec().getPlacementRef().getKind());
    assertEquals("cluster.open-cluster-management.io/v1alpha1", gitOpsCluster.getSpec().getPlacementRef().getApiVersion());
    assertEquals("openshift-gitops", gitOpsCluster.getSpec().getPlacementRef().getNamespace());
  }
}
