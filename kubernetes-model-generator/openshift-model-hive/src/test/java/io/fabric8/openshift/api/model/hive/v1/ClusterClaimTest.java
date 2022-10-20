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
import io.fabric8.kubernetes.api.model.Duration;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ClusterClaimTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException, ParseException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-clusterclaim.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ClusterClaim clusterClaim = mapper.readValue(originalJson, ClusterClaim.class);
    final String serializedJson = mapper.writeValueAsString(clusterClaim);
    final ClusterClaim clusterClaimFromSerializedJson = mapper.readValue(serializedJson, ClusterClaim.class);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(clusterClaim)
        .isNotNull()
        .isEqualTo(clusterClaimFromSerializedJson)
        .hasFieldOrPropertyWithValue("metadata.name", "foo")
        .hasFieldOrPropertyWithValue("metadata.namespace", "my-project")
        .hasFieldOrPropertyWithValue("spec.clusterPoolName", "openshift-46-aws-us-east-1")
        .hasFieldOrPropertyWithValue("spec.lifetime", Duration.parse("8h"))
        .hasFieldOrPropertyWithValue("spec.namespace", "openshift-46-aws-us-east-1-j495p");
  }

  @Test
  void builderShouldCreateObject() throws ParseException {
    // Given
    ClusterClaimBuilder clusterClaimBuilder = new ClusterClaimBuilder()
        .withNewMetadata()
        .withName("foo")
        .endMetadata()
        .withNewSpec()
        .withClusterPoolName("openshift-46-aws-us-east-1")
        .withLifetime(Duration.parse("8h"))
        .withNamespace("openshift-46-aws-us-east-1-j495p")
        .endSpec();

    // When
    ClusterClaim clusterClaim = clusterClaimBuilder.build();

    // Then
    assertThat(clusterClaim)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "foo")
        .hasFieldOrPropertyWithValue("spec.clusterPoolName", "openshift-46-aws-us-east-1")
        .hasFieldOrPropertyWithValue("spec.lifetime", Duration.parse("8h"))
        .hasFieldOrPropertyWithValue("spec.namespace", "openshift-46-aws-us-east-1-j495p");
  }
}
