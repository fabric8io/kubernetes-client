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

class ClusterDeploymentTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-clusterdeployment.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ClusterDeployment clusterDeployment = mapper.readValue(originalJson, ClusterDeployment.class);
    final String serializedJson = mapper.writeValueAsString(clusterDeployment);
    final ClusterDeployment clusterDeploymentFromSerializedJson = mapper.readValue(serializedJson, ClusterDeployment.class);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(clusterDeployment)
        .isNotNull()
        .isEqualTo(clusterDeploymentFromSerializedJson)
        .hasFieldOrPropertyWithValue("metadata.annotations", Collections.singletonMap("hive.openshift.io/delete-after", "8h"))
        .hasFieldOrPropertyWithValue("metadata.name", "foo")
        .hasFieldOrPropertyWithValue("spec.clusterName", "foo")
        .hasFieldOrPropertyWithValue("spec.preserveOnDelete", false)
        .hasFieldOrPropertyWithValue("spec.baseDomain", "bar.baz")
        .hasFieldOrPropertyWithValue("spec.platform.aws.region", "us-east-1")
        .hasFieldOrPropertyWithValue("spec.platform.aws.credentialsSecretRef.name", "foo-aws-creds")
        .hasFieldOrPropertyWithValue("spec.provisioning.installConfigSecretRef.name", "foo-install-config")
        .hasFieldOrPropertyWithValue("spec.provisioning.imageSetRef.name", "clusterimageset-sample")
        .hasFieldOrPropertyWithValue("spec.pullSecretRef.name", "foo-pull-secret");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ClusterDeploymentBuilder clusterDeploymentBuilder = new ClusterDeploymentBuilder()
        .withNewMetadata()
        .addToAnnotations(Collections.singletonMap("hive.openshift.io/delete-after", "8h"))
        .withName("foo")
        .endMetadata()
        .withNewSpec()
        .withPreserveOnDelete(false)
        .withClusterName("foo")
        .withBaseDomain("bar.baz")
        .withNewPlatform()
        .withNewAws()
        .withRegion("us-east-1")
        .withNewCredentialsSecretRef().withName("foo-aws-creds").endCredentialsSecretRef()
        .endAws()
        .endPlatform()
        .withNewProvisioning()
        .withNewInstallConfigSecretRef()
        .withName("foo-install-config")
        .endInstallConfigSecretRef()
        .withNewImageSetRef()
        .withName("clusterimageset-sample")
        .endImageSetRef()
        .endProvisioning()
        .withNewPullSecretRef()
        .withName("foo-pull-secret")
        .endPullSecretRef()
        .endSpec();

    // When
    ClusterDeployment clusterDeployment = clusterDeploymentBuilder.build();

    // Then
    assertThat(clusterDeployment)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.annotations", Collections.singletonMap("hive.openshift.io/delete-after", "8h"))
        .hasFieldOrPropertyWithValue("metadata.name", "foo")
        .hasFieldOrPropertyWithValue("spec.clusterName", "foo")
        .hasFieldOrPropertyWithValue("spec.preserveOnDelete", false)
        .hasFieldOrPropertyWithValue("spec.baseDomain", "bar.baz")
        .hasFieldOrPropertyWithValue("spec.platform.aws.region", "us-east-1")
        .hasFieldOrPropertyWithValue("spec.platform.aws.credentialsSecretRef.name", "foo-aws-creds")
        .hasFieldOrPropertyWithValue("spec.provisioning.installConfigSecretRef.name", "foo-install-config")
        .hasFieldOrPropertyWithValue("spec.provisioning.imageSetRef.name", "clusterimageset-sample")
        .hasFieldOrPropertyWithValue("spec.pullSecretRef.name", "foo-pull-secret");
  }
}
