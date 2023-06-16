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
package io.fabric8.kubernetes.api.model.internal.apiserver.v1alpha1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class StorageVersionTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScoped() {
    assertThat(StorageVersion.class).isNotInstanceOf(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-internal-apiserver-storageversion.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final StorageVersion storageVersion = mapper.readValue(originalJson, StorageVersion.class);
    final String serializedJson = mapper.writeValueAsString(storageVersion);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(storageVersion)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "apps.deployments")
        .hasFieldOrPropertyWithValue("status.commonEncodingVersion", "apps/v1")
        .satisfies(s -> assertThat(s.getStatus().getConditions())
            .singleElement(InstanceOfAssertFactories.type(StorageVersionCondition.class))
            .hasFieldOrPropertyWithValue("lastTransitionTime", "2023-06-04T17:16:57Z")
            .hasFieldOrPropertyWithValue("message", "Common encoding version set")
            .hasFieldOrPropertyWithValue("reason", "CommonEncodingVersionSet")
            .hasFieldOrPropertyWithValue("status", "True")
            .hasFieldOrPropertyWithValue("type", "AllEncodingVersionsEqual"))
        .satisfies(s -> assertThat(s.getStatus().getStorageVersions())
            .singleElement(InstanceOfAssertFactories.type(ServerStorageVersion.class))
            .hasFieldOrPropertyWithValue("apiServerID", "kube-apiserver-803c62b1-340f-4055-93ca-44aba8a35574")
            .hasFieldOrPropertyWithValue("decodableVersions", Arrays.asList("apps/v1", "apps/v1beta2", "apps/v1beta1"))
            .hasFieldOrPropertyWithValue("encodingVersion", "apps/v1"));
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    StorageVersionBuilder storageVersionBuilder = new StorageVersionBuilder()
        .withNewMetadata()
        .withName("apps.deployments")
        .endMetadata()
        .withNewSpec()
        .endSpec()
        .withNewStatus()
        .withCommonEncodingVersion("apps/v1")
        .addNewCondition()
        .withLastTransitionTime("2023-06-04T17:16:57Z")
        .withMessage("Common encoding version set")
        .withReason("CommonEncodingVersionSet")
        .withStatus("True")
        .withType("AllEncodingVersionsEqual")
        .endCondition()
        .addNewStorageVersion()
        .withApiServerID("kube-apiserver-803c62b1-340f-4055-93ca-44aba8a35574")
        .addToDecodableVersions("apps/v1", "apps/v1beta2", "apps/v1beta1")
        .withEncodingVersion("apps/v1")
        .endStorageVersion()
        .endStatus();
    // When
    StorageVersion storageVersion = storageVersionBuilder.build();

    // Then
    assertThat(storageVersion)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "apps.deployments")
        .hasFieldOrPropertyWithValue("status.commonEncodingVersion", "apps/v1")
        .satisfies(s -> assertThat(s.getStatus().getConditions())
            .singleElement(InstanceOfAssertFactories.type(StorageVersionCondition.class))
            .hasFieldOrPropertyWithValue("lastTransitionTime", "2023-06-04T17:16:57Z")
            .hasFieldOrPropertyWithValue("message", "Common encoding version set")
            .hasFieldOrPropertyWithValue("reason", "CommonEncodingVersionSet")
            .hasFieldOrPropertyWithValue("status", "True")
            .hasFieldOrPropertyWithValue("type", "AllEncodingVersionsEqual"))
        .satisfies(s -> assertThat(s.getStatus().getStorageVersions())
            .singleElement(InstanceOfAssertFactories.type(ServerStorageVersion.class))
            .hasFieldOrPropertyWithValue("apiServerID", "kube-apiserver-803c62b1-340f-4055-93ca-44aba8a35574")
            .hasFieldOrPropertyWithValue("decodableVersions", Arrays.asList("apps/v1", "apps/v1beta2", "apps/v1beta1"))
            .hasFieldOrPropertyWithValue("encodingVersion", "apps/v1"));
  }
}
