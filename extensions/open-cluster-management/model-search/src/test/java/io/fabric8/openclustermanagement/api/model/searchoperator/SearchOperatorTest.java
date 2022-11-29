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
package io.fabric8.openclustermanagement.api.model.searchoperator;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchOperator;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchOperatorBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SearchOperatorTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-searchoperator.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final SearchOperator searchOperator = mapper.readValue(originalJson, SearchOperator.class);
    final String serializedJson = mapper.writeValueAsString(searchOperator);
    final SearchOperator searchOperatorFromSerializedJson = mapper.readValue(serializedJson, SearchOperator.class);

    // Then
    assertNotNull(searchOperator);
    assertNotNull(serializedJson);
    assertNotNull(searchOperatorFromSerializedJson);
    assertEquals(searchOperator.getMetadata().getName(), searchOperatorFromSerializedJson.getMetadata().getName());
    assertEquals("Always", searchOperator.getSpec().getPullpolicy());
    assertEquals("multiclusterhub-operator-pull-secret", searchOperator.getSpec().getPullsecret());
    assertEquals("1Gi", searchOperator.getSpec().getRedisgraphResource().getLimitMemory());
    assertEquals("64Mi", searchOperator.getSpec().getRedisgraphResource().getRequestMemory());
    assertEquals("25m", searchOperator.getSpec().getRedisgraphResource().getRequestCpu());
    assertEquals("quay.io/open-cluster-management/redisgraph-tls:2.4.0-e2ec66da43abff85a7fcf56f22ed5849e0589069",
        searchOperator.getSpec().getSearchimageoverrides().getRedisgraphTls());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    SearchOperatorBuilder searchOperatorBuilder = new SearchOperatorBuilder()
        .withNewMetadata()
        .withName("searchoperator")
        .endMetadata()
        .withNewSpec()
        .withPullpolicy("Always")
        .withNewRedisgraphResource()
        .withLimitMemory("1Gi")
        .withRequestCpu("25m")
        .withRequestMemory("64Mi")
        .endRedisgraphResource()
        .withPullpolicy("Always")
        .withPullsecret("multiclusterhub-operator-pull-secret")
        .withNewSearchimageoverrides()
        .withRedisgraphTls("quay.io/open-cluster-management/redisgraph-tls:2.4.0-e2ec66da43abff85a7fcf56f22ed5849e0589069")
        .endSearchimageoverrides()
        .endSpec();

    // When
    SearchOperator searchOperator = searchOperatorBuilder.build();

    // Then
    assertNotNull(searchOperator);
    assertEquals("searchoperator", searchOperator.getMetadata().getName());
    assertEquals("Always", searchOperator.getSpec().getPullpolicy());
    assertEquals("multiclusterhub-operator-pull-secret", searchOperator.getSpec().getPullsecret());
    assertEquals("1Gi", searchOperator.getSpec().getRedisgraphResource().getLimitMemory());
    assertEquals("64Mi", searchOperator.getSpec().getRedisgraphResource().getRequestMemory());
    assertEquals("25m", searchOperator.getSpec().getRedisgraphResource().getRequestCpu());
    assertEquals("quay.io/open-cluster-management/redisgraph-tls:2.4.0-e2ec66da43abff85a7fcf56f22ed5849e0589069",
        searchOperator.getSpec().getSearchimageoverrides().getRedisgraphTls());
  }
}
