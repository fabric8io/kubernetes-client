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
package io.fabric8.kubernetes.api.model.authentication.v1beta1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class SelfSubjectReviewTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScoped() {
    assertThat(SelfSubjectReview.class).isNotInstanceOf(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-selfsubjectreview.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final SelfSubjectReview selfSubjectReview = mapper.readValue(originalJson, SelfSubjectReview.class);
    final String serializedJson = mapper.writeValueAsString(selfSubjectReview);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(selfSubjectReview)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-selfsubjectreview")
        .hasFieldOrPropertyWithValue("status.userInfo.username", "kubernetes-admin")
        .hasFieldOrPropertyWithValue("status.userInfo.uid", "some-user-id")
        .hasFieldOrPropertyWithValue("status.userInfo.groups", Arrays.asList("system:masters", "system:authenticated"));
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    SelfSubjectReviewBuilder selfSubjectReviewBuilder = new SelfSubjectReviewBuilder()
        .withNewMetadata()
        .withName("test-selfsubjectreview")
        .endMetadata()
        .withNewStatus()
        .withNewUserInfo()
        .withUsername("kubernetes-admin")
        .withUid("some-user-id")
        .addToGroups("system:masters", "system:authenticated")
        .endUserInfo()
        .endStatus();
    // When
    SelfSubjectReview selfSubjectReview = selfSubjectReviewBuilder.build();

    // Then
    assertThat(selfSubjectReview)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-selfsubjectreview")
        .hasFieldOrPropertyWithValue("status.userInfo.username", "kubernetes-admin")
        .hasFieldOrPropertyWithValue("status.userInfo.uid", "some-user-id")
        .hasFieldOrPropertyWithValue("status.userInfo.groups", Arrays.asList("system:masters", "system:authenticated"));
  }
}
