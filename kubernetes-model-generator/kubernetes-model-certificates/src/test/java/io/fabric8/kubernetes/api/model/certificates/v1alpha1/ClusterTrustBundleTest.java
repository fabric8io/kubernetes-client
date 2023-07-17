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
package io.fabric8.kubernetes.api.model.certificates.v1alpha1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ClusterTrustBundleTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScoped() {
    assertThat(ClusterTrustBundle.class).isNotInstanceOf(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-clustertrustbundle.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ClusterTrustBundle clusterTrustBundle = mapper.readValue(originalJson, ClusterTrustBundle.class);
    final String serializedJson = mapper.writeValueAsString(clusterTrustBundle);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(clusterTrustBundle)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "example.com:mysigner:foo")
        .hasFieldOrPropertyWithValue("spec.signerName", "example.com/mysigner")
        .hasFieldOrPropertyWithValue("spec.trustBundle", "-----BEGIN CERTIFICATE----- PEM data -----END CERTIFICATE-----");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ClusterTrustBundleBuilder clusterTrustBundleBuilder = new ClusterTrustBundleBuilder()
        .withNewMetadata()
        .withName("example.com:mysigner:foo")
        .endMetadata()
        .withNewSpec()
        .withSignerName("example.com/mysigner")
        .withTrustBundle("-----BEGIN CERTIFICATE----- PEM data -----END CERTIFICATE-----")
        .endSpec();

    // When
    ClusterTrustBundle resourceClaim = clusterTrustBundleBuilder.build();

    // Then
    assertThat(resourceClaim)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "example.com:mysigner:foo")
        .hasFieldOrPropertyWithValue("spec.signerName", "example.com/mysigner")
        .hasFieldOrPropertyWithValue("spec.trustBundle", "-----BEGIN CERTIFICATE----- PEM data -----END CERTIFICATE-----");
  }
}
