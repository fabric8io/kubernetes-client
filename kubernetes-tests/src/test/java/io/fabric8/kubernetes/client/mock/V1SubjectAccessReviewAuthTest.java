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

import io.fabric8.kubernetes.api.model.authorization.v1.LocalSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.LocalSubjectAccessReviewBuilder;
import io.fabric8.kubernetes.api.model.authorization.v1.NonResourceRule;
import io.fabric8.kubernetes.api.model.authorization.v1.NonResourceRuleBuilder;
import io.fabric8.kubernetes.api.model.authorization.v1.ResourceRule;
import io.fabric8.kubernetes.api.model.authorization.v1.ResourceRuleBuilder;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReviewBuilder;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectRulesReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectRulesReviewBuilder;
import io.fabric8.kubernetes.api.model.authorization.v1.SubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SubjectAccessReviewBuilder;
import io.fabric8.kubernetes.api.model.authorization.v1.SubjectAccessReviewStatus;
import io.fabric8.kubernetes.api.model.authorization.v1.SubjectRulesReviewStatusBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class V1SubjectAccessReviewAuthTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  @DisplayName("Should Create SubjectAccessReview")
  void createSubjectAccessReviewTest() {
    // Given
    SubjectAccessReview review = new SubjectAccessReviewBuilder()
        .withNewSpec()
        .withUser("admin-user")
        .withNewResourceAttributes()
        .withResource("pod")
        .withVerb("create")
        .endResourceAttributes()
        .endSpec()
        .build();

    server.expect().post().withPath("/apis/authorization.k8s.io/v1/subjectaccessreviews")
        .andReply(HttpURLConnection.HTTP_OK, recordedRequest -> {
          LocalSubjectAccessReview reviewResponse = Serialization
              .unmarshal(recordedRequest.getBody().readString(Charset.defaultCharset()), LocalSubjectAccessReview.class);
          reviewResponse.setStatus(new SubjectAccessReviewStatus(true, false, "", ""));

          return reviewResponse;
        }).once();

    // When
    SubjectAccessReview reviewResponse = client.authorization().v1().subjectAccessReview().create(review);

    // Then
    assertNotNull(reviewResponse);
    assertEquals(true, reviewResponse.getStatus().getAllowed());
  }

  @Test
  @DisplayName("Should Create LocalSubjectAccessReview")
  void createLocalSubjectAccessReviewTest() {
    // Given
    LocalSubjectAccessReview review = new LocalSubjectAccessReviewBuilder().withNewSpec()
        .withUser("admin-user")
        .withNewResourceAttributes()
        .withResource("pod")
        .withNamespace("test")
        .withVerb("create")
        .endResourceAttributes()
        .endSpec()
        .build();

    server.expect().post().withPath("/apis/authorization.k8s.io/v1/namespaces/test/localsubjectaccessreviews")
        .andReply(HttpURLConnection.HTTP_OK, recordedRequest -> {
          LocalSubjectAccessReview reviewResponse = Serialization
              .unmarshal(recordedRequest.getBody().readString(Charset.defaultCharset()), LocalSubjectAccessReview.class);
          reviewResponse.setStatus(new SubjectAccessReviewStatus(true, false, "", ""));

          return reviewResponse;
        }).once();

    // When
    LocalSubjectAccessReview reviewResponse = client.authorization().v1()
        .localSubjectAccessReview()
        .inNamespace("test")
        .create(review);

    // Then
    assertNotNull(reviewResponse);
    assertEquals("test", reviewResponse.getSpec().getResourceAttributes().getNamespace());
    assertTrue(reviewResponse.getStatus().getAllowed());
  }

  @Test
  @DisplayName("Create SelfSubjectRulesReview")
  void testCreateSelfSubjectRulesReview() {
    // Given
    SelfSubjectRulesReview selfSubjectRulesReview = new SelfSubjectRulesReviewBuilder()
        .withNewMetadata().withName("foo").endMetadata()
        .withNewSpec()
        .withNamespace("test")
        .endSpec()
        .build();

    server.expect().post().withPath("/apis/authorization.k8s.io/v1/selfsubjectrulesreviews")
        .andReply(HttpURLConnection.HTTP_OK, recordedRequest -> {
          SelfSubjectRulesReview reviewResponse = Serialization
              .unmarshal(recordedRequest.getBody().readString(Charset.defaultCharset()), SelfSubjectRulesReview.class);
          List<NonResourceRule> nonResourceRuleList = new ArrayList<>();
          nonResourceRuleList.add(new NonResourceRuleBuilder().withNonResourceURLs("*").withVerbs("*").build());
          nonResourceRuleList.add(new NonResourceRuleBuilder()
              .withNonResourceURLs("/healthz", "/livez", "/readyz", "/version", "/version/")
              .withVerbs("get")
              .build());
          nonResourceRuleList.add(new NonResourceRuleBuilder()
              .withNonResourceURLs("/api", "/api/*", "/apis", "/apis/*", "/healthz", "/livez", "/openapi", "/openapi/*",
                  "/readyz", "/version", "/version/")
              .withVerbs("get")
              .build());

          List<ResourceRule> resourceRuleList = new ArrayList<>();
          resourceRuleList.add(new ResourceRuleBuilder().withApiGroups("*").withResources("*").withVerbs("*").build());
          resourceRuleList.add(new ResourceRuleBuilder()
              .withApiGroups("authorization.k8s.io")
              .withResources("selfsubjectaccessreviews", "selfsubjectrulesreviews")
              .withVerbs("create")
              .build());

          reviewResponse.setStatus(new SubjectRulesReviewStatusBuilder()
              .withIncomplete(false)
              .withNonResourceRules(nonResourceRuleList)
              .withResourceRules(resourceRuleList)
              .build());

          return reviewResponse;
        }).once();

    // When
    SelfSubjectRulesReview reviewResponse = client.authorization().v1()
        .selfSubjectRulesReview()
        .create(selfSubjectRulesReview);

    // Then
    assertNotNull(reviewResponse);
    assertEquals("test", reviewResponse.getSpec().getNamespace());
    assertNotNull(reviewResponse.getStatus());
    assertFalse(reviewResponse.getStatus().getIncomplete());
    assertEquals(3, reviewResponse.getStatus().getNonResourceRules().size());
    assertEquals(2, reviewResponse.getStatus().getResourceRules().size());
  }

  @Test
  @DisplayName("Create SelfSubjectAccessReview")
  void testCreateSelfSubjectAccessReview() {
    // Given
    SelfSubjectAccessReview ssar = new SelfSubjectAccessReviewBuilder()
        .withNewSpec()
        .withNewResourceAttributes()
        .withGroup("apps")
        .withResource("deployments")
        .withVerb("create")
        .withNamespace("test")
        .endResourceAttributes()
        .endSpec()
        .build();

    server.expect().post().withPath("/apis/authorization.k8s.io/v1/selfsubjectaccessreviews")
        .andReply(HttpURLConnection.HTTP_OK, recordedRequest -> {
          SelfSubjectAccessReview reviewResponse = Serialization
              .unmarshal(recordedRequest.getBody().readString(Charset.defaultCharset()), SelfSubjectAccessReview.class);
          reviewResponse.setStatus(new SubjectAccessReviewStatus(true, false, "", ""));

          return reviewResponse;
        }).once();

    // When
    SelfSubjectAccessReview reviewResponse = client.authorization().v1()
        .selfSubjectAccessReview()
        .create(ssar);

    // Then
    assertNotNull(reviewResponse);
    assertEquals("test", reviewResponse.getSpec().getResourceAttributes().getNamespace());
    assertTrue(reviewResponse.getStatus().getAllowed());
  }
}
