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

class ClusterPoolTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-clusterpool.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ClusterPool clusterPool = mapper.readValue(originalJson, ClusterPool.class);
    final String serializedJson = mapper.writeValueAsString(clusterPool);
    final ClusterPool clusterPoolFromSerializedJson = mapper.readValue(serializedJson, ClusterPool.class);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(clusterPool)
        .isNotNull()
        .isEqualTo(clusterPoolFromSerializedJson)
        .hasFieldOrPropertyWithValue("metadata.name", "openshift-46-aws-us-east-1")
        .hasFieldOrPropertyWithValue("metadata.namespace", "my-project")
        .hasFieldOrPropertyWithValue("spec.baseDomain", "new-installer.openshift.com")
        .hasFieldOrPropertyWithValue("spec.platform.aws.region", "us-east-1")
        .hasFieldOrPropertyWithValue("spec.platform.aws.credentialsSecretRef.name", "hive-team-aws-creds")
        .hasFieldOrPropertyWithValue("spec.pullSecretRef.name", "hive-team-pull-secret")
        .hasFieldOrPropertyWithValue("spec.runningCount", 1)
        .hasFieldOrPropertyWithValue("spec.size", 3);
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ClusterPoolBuilder clusterPoolBuilder = new ClusterPoolBuilder()
        .withNewMetadata()
        .withName("openshift-46-aws-us-east-1")
        .withNamespace("my-project")
        .endMetadata()
        .withNewSpec()
        .withBaseDomain("new-installer.openshift.com")
        .withNewImageSetRef()
        .withName("openshift-4-6")
        .endImageSetRef()
        .withNewPlatform()
        .withNewAws()
        .withNewCredentialsSecretRef()
        .withName("hive-team-aws-creds")
        .endCredentialsSecretRef()
        .withRegion("us-east-1")
        .endAws()
        .endPlatform()
        .withNewPullSecretRef()
        .withName("hive-team-pull-secret")
        .endPullSecretRef()
        .withRunningCount(1)
        .withSize(3)
        .endSpec();

    // When
    ClusterPool clusterPool = clusterPoolBuilder.build();

    // Then
    assertThat(clusterPool)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "openshift-46-aws-us-east-1")
        .hasFieldOrPropertyWithValue("metadata.namespace", "my-project")
        .hasFieldOrPropertyWithValue("spec.baseDomain", "new-installer.openshift.com")
        .hasFieldOrPropertyWithValue("spec.platform.aws.region", "us-east-1")
        .hasFieldOrPropertyWithValue("spec.platform.aws.credentialsSecretRef.name", "hive-team-aws-creds")
        .hasFieldOrPropertyWithValue("spec.pullSecretRef.name", "hive-team-pull-secret")
        .hasFieldOrPropertyWithValue("spec.runningCount", 1)
        .hasFieldOrPropertyWithValue("spec.size", 3);
  }
}
