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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.openshift.api.model.PodSecurityPolicySelfSubjectReview;
import io.fabric8.openshift.api.model.PodSecurityPolicySelfSubjectReviewBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class PodSecurityPolicySelfSubjectReviewTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void create() {
    // Given
    PodSecurityPolicySelfSubjectReview pspr = createPodSecurityPolicySelfSubjectReviewBuilder().build();
    server.expect().post().withPath("/apis/security.openshift.io/v1/namespaces/ns1/podsecuritypolicyselfsubjectreviews")
      .andReturn(HttpURLConnection.HTTP_CREATED, createPodSecurityPolicySelfSubjectReviewBuilder()
        .withNewStatus()
        .withNewAllowedBy()
        .withName("anyuid")
        .withUid("xyz")
        .withApiVersion("security.openshift.io/v1")
        .withKind("SecurityContextConstraint")
        .endAllowedBy()
        .endStatus().build())
      .once();

    // When
    PodSecurityPolicySelfSubjectReview createdPspr = client.podSecurityPolicySelfSubjectReviews().inNamespace("ns1").create(pspr);

    // Then
    assertThat(createdPspr).isNotNull();
    assertThat(createdPspr.getStatus().getAllowedBy()).isNotNull();
    assertThat(createdPspr.getStatus().getAllowedBy())
      .hasFieldOrPropertyWithValue("name", "anyuid")
      .hasFieldOrPropertyWithValue("uid", "xyz")
      .hasFieldOrPropertyWithValue("kind", "SecurityContextConstraint")
      .hasFieldOrPropertyWithValue("apiVersion", "security.openshift.io/v1");
  }

  private PodSecurityPolicySelfSubjectReviewBuilder createPodSecurityPolicySelfSubjectReviewBuilder() {
    return new PodSecurityPolicySelfSubjectReviewBuilder()
      .withNewSpec()
      .withNewTemplate()
      .withNewMetadata()
      .addToAnnotations("foo", "bar")
      .endMetadata()
      .withNewSpec()
      .addNewContainer()
      .withImage("nginx:perl-stable")
      .withName("test")
      .endContainer()
      .endSpec()
      .endTemplate()
      .endSpec();
  }
}
