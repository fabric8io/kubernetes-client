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
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ClusterDeprovisionTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-clusterdeprovision.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ClusterDeprovision clusterDeprovision = mapper.readValue(originalJson, ClusterDeprovision.class);
    final String serializedJson = mapper.writeValueAsString(clusterDeprovision);
    final ClusterDeprovision clusterDeprovisionFromSerializedJson = mapper.readValue(serializedJson, ClusterDeprovision.class);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(clusterDeprovision)
        .isNotNull()
        .isEqualTo(clusterDeprovisionFromSerializedJson)
        .hasFieldOrPropertyWithValue("metadata.name", "clusterdeprovision-sample")
        .hasFieldOrPropertyWithValue("spec.infraID", "cluster-infra-id")
        .hasFieldOrPropertyWithValue("spec.platform.aws.region", "us-east-1")
        .hasFieldOrPropertyWithValue("spec.platform.aws.credentialsSecretRef.name", "cluster-aws-creds");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ClusterDeprovisionBuilder clusterDeprovisionBuilder = new ClusterDeprovisionBuilder()
        .withNewMetadata()
        .withName("clusterdeprovision-sample")
        .endMetadata()
        .withNewSpec()
        .withInfraID("cluster-infra-id")
        .withNewPlatform()
        .withNewAws()
        .withNewCredentialsSecretRef().withName("cluster-aws-creds").endCredentialsSecretRef()
        .withRegion("us-east-1")
        .endAws()
        .endPlatform()
        .endSpec();

    // When
    ClusterDeprovision clusterDeprovision = clusterDeprovisionBuilder.build();

    // Then
    assertThat(clusterDeprovision)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "clusterdeprovision-sample")
        .hasFieldOrPropertyWithValue("spec.infraID", "cluster-infra-id")
        .hasFieldOrPropertyWithValue("spec.platform.aws.region", "us-east-1")
        .hasFieldOrPropertyWithValue("spec.platform.aws.credentialsSecretRef.name", "cluster-aws-creds");
  }
}
