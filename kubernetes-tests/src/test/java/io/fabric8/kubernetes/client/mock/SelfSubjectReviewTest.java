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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.authentication.v1alpha1.SelfSubjectReview;
import io.fabric8.kubernetes.api.model.authentication.v1alpha1.SelfSubjectReviewBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@EnableKubernetesMockClient
class SelfSubjectReviewTest {
  private KubernetesClient client;
  private KubernetesMockServer server;

  @Test
  void create_whenInvoked_shouldReturnObjectWithUpdatedStatus() {
    // Given
    SelfSubjectReview ssr = new SelfSubjectReview();
    server.expect().post()
        .withPath("/apis/authentication.k8s.io/v1alpha1/selfsubjectreviews")
        .andReturn(HTTP_CREATED, createNewSelfSubjectReview(Arrays.asList("system:masters", "system:authenticated")))
        .once();

    // When
    SelfSubjectReview result = client.authentication().v1alpha1().selfSubjectReview().create(ssr);

    // Then
    assertThat(result)
        .isNotNull()
        .hasFieldOrPropertyWithValue("status.userInfo.username", "kubernetes-admin")
        .hasFieldOrPropertyWithValue("status.userInfo.groups", Arrays.asList("system:masters", "system:authenticated"));
  }

  private SelfSubjectReview createNewSelfSubjectReview(List<String> groups) {
    return new SelfSubjectReviewBuilder()
        .withNewStatus()
        .withNewUserInfo()
        .withUsername("kubernetes-admin")
        .withGroups(groups)
        .endUserInfo()
        .endStatus()
        .build();
  }
}
