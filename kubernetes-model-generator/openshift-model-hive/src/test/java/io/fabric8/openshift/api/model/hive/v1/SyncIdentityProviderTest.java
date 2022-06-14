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
import io.fabric8.openshift.api.model.config.v1.GitHubIdentityProviderBuilder;
import io.fabric8.openshift.api.model.config.v1.IdentityProviderBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class SyncIdentityProviderTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-syncidentityprovider.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final SyncIdentityProvider syncIdentityProvider = mapper.readValue(originalJson, SyncIdentityProvider.class);
    final String serializedJson = mapper.writeValueAsString(syncIdentityProvider);
    final SyncIdentityProvider syncIdentityProviderFromSerializedJson = mapper.readValue(serializedJson,
        SyncIdentityProvider.class);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(syncIdentityProvider)
        .isNotNull()
        .isEqualTo(syncIdentityProviderFromSerializedJson)
        .hasFieldOrPropertyWithValue("metadata.name", "allowall-identity-provider")
        .extracting("spec.identityProviders").asList()
        .hasSize(1).first()
        .hasFieldOrPropertyWithValue("name", "myprovider")
        .hasFieldOrPropertyWithValue("type", "GitHubIdentityProvider")
        .hasFieldOrPropertyWithValue("github.clientID", "sample-client-id")
        .hasFieldOrPropertyWithValue("github.clientSecret.name", "foo")
        .hasFieldOrPropertyWithValue("github.hostname", "github.com");
    assertThat(syncIdentityProvider.getSpec().getClusterDeploymentRefs())
        .hasSize(1)
        .first()
        .hasFieldOrPropertyWithValue("name", "MyCluster");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    SyncIdentityProviderBuilder syncIdentityProviderBuilder = new SyncIdentityProviderBuilder()
        .withNewMetadata()
        .withName("allowall-identity-provider")
        .endMetadata()
        .withNewSpec()
        .addNewClusterDeploymentRef("MyCluster")
        .addToIdentityProviders(new IdentityProviderBuilder()
            .withName("myprovider")
            .withType("GitHubIdentityProvider")
            .withGithub(new GitHubIdentityProviderBuilder()
                .withClientID("sample-client-id")
                .withNewClientSecret()
                .withName("foo")
                .endClientSecret()
                .withHostname("github.com")
                .build())
            .build())
        .endSpec();

    // When
    SyncIdentityProvider syncIdentityProvider = syncIdentityProviderBuilder.build();

    // Then
    assertThat(syncIdentityProvider)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "allowall-identity-provider")
        .extracting("spec.identityProviders").asList()
        .hasSize(1).first()
        .hasFieldOrPropertyWithValue("name", "myprovider")
        .hasFieldOrPropertyWithValue("type", "GitHubIdentityProvider")
        .hasFieldOrPropertyWithValue("github.clientID", "sample-client-id")
        .hasFieldOrPropertyWithValue("github.clientSecret.name", "foo")
        .hasFieldOrPropertyWithValue("github.hostname", "github.com");
    assertThat(syncIdentityProvider.getSpec().getClusterDeploymentRefs())
        .hasSize(1)
        .first()
        .hasFieldOrPropertyWithValue("name", "MyCluster");
  }
}
