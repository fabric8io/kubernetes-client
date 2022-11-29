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

import io.fabric8.openshift.api.model.LocalResourceAccessReviewBuilder;
import io.fabric8.openshift.api.model.LocalSubjectAccessReviewBuilder;
import io.fabric8.openshift.api.model.ResourceAccessReviewBuilder;
import io.fabric8.openshift.api.model.ResourceAccessReviewResponse;
import io.fabric8.openshift.api.model.ResourceAccessReviewResponseBuilder;
import io.fabric8.openshift.api.model.SelfSubjectRulesReview;
import io.fabric8.openshift.api.model.SelfSubjectRulesReviewBuilder;
import io.fabric8.openshift.api.model.SubjectAccessReviewBuilder;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponse;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponseBuilder;
import io.fabric8.openshift.api.model.SubjectRulesReview;
import io.fabric8.openshift.api.model.SubjectRulesReviewBuilder;
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableOpenShiftMockClient
class SubjectAccessReviewTest {

  OpenShiftMockServer server;
  NamespacedOpenShiftClient client;

  @BeforeEach
  void setUp() {
    client = server.createOpenShiftClient();
  }

  @Test
  void testCreate() {
    server.expect().withPath("/apis/authorization.openshift.io/v1/subjectaccessreviews")
        .andReturn(201, new SubjectAccessReviewResponseBuilder()
            .withReason("r1")
            .build())
        .once();
    SubjectAccessReviewResponse response = client.inAnyNamespace().subjectAccessReviews()
        .create(new SubjectAccessReviewBuilder()
            .build());
    assertNotNull(response);
    assertEquals("r1", response.getReason());
  }

  @Test
  void testCreateInLine() {
    server.expect().withPath("/apis/authorization.openshift.io/v1/subjectaccessreviews")
        .andReturn(201, new SubjectAccessReviewResponseBuilder()
            .withReason("r2")
            .build())
        .once();

    SubjectAccessReviewResponse response = client.inAnyNamespace().subjectAccessReviews()
        .create(new SubjectAccessReviewBuilder().build());
    assertNotNull(response);
    assertEquals("r2", response.getReason());
  }

  @Test
  void testCreateLocal() {
    server.expect().withPath("/apis/authorization.openshift.io/v1/namespaces/test/localsubjectaccessreviews")
        .andReturn(201, new SubjectAccessReviewResponseBuilder()
            .withReason("r1")
            .build())
        .once();

    SubjectAccessReviewResponse response = client.localSubjectAccessReviews().inNamespace("test")
        .create(new LocalSubjectAccessReviewBuilder()
            .withNamespace("test")
            .withVerb("get")
            .withGroups("test.fabric8.io")
            .build());
    assertNotNull(response);
    assertEquals("r1", response.getReason());
  }

  @Test
  void testCreateLocalInLine() {
    server.expect().withPath("/apis/authorization.openshift.io/v1/namespaces/test/localsubjectaccessreviews")
        .andReturn(201, new SubjectAccessReviewResponseBuilder()
            .withReason("r2")
            .build())
        .once();

    SubjectAccessReviewResponse response = client.localSubjectAccessReviews().inNamespace("test")
        .create(new LocalSubjectAccessReviewBuilder()
            .withUser("user")
            .withVerb("verb")
            .build());
    assertNotNull(response);
    assertEquals("r2", response.getReason());
  }

  @Test
  void createResourceAccessReview() {
    // Given
    server.expect().post().withPath("/apis/authorization.openshift.io/v1/resourceaccessreviews")
        .andReturn(HTTP_CREATED, new ResourceAccessReviewResponseBuilder()
            .addToGroups("system:cluster-admins", "system:masters")
            .addToUsers("kubeadmin", "system:admin")
            .build())
        .once();

    // When
    ResourceAccessReviewResponse response = client.resourceAccessReviews().create(new ResourceAccessReviewBuilder()
        .withVerb("create")
        .withResourceName("ConfigMap")
        .build());

    // Then
    assertNotNull(response);
    assertArrayEquals(new String[] { "kubeadmin", "system:admin" }, response.getUsers().toArray());
    assertArrayEquals(new String[] { "system:cluster-admins", "system:masters" }, response.getGroups().toArray());
  }

  @Test
  void createLocalResourceAccessReview() {
    // Given
    server.expect().post().withPath("/apis/authorization.openshift.io/v1/namespaces/ns1/localresourceaccessreviews")
        .andReturn(HTTP_CREATED, new ResourceAccessReviewResponseBuilder()
            .withNamespace("ns1")
            .addToGroups("system:cluster-admins", "system:masters")
            .addToUsers("kubeadmin", "system:admin")
            .build())
        .once();

    // When
    ResourceAccessReviewResponse response = client.localResourceAccessReviews().inNamespace("ns1")
        .create(new LocalResourceAccessReviewBuilder()
            .withVerb("create")
            .withResourceName("ConfigMap")
            .build());

    // Then
    assertNotNull(response);
    assertArrayEquals(new String[] { "kubeadmin", "system:admin" }, response.getUsers().toArray());
    assertArrayEquals(new String[] { "system:cluster-admins", "system:masters" }, response.getGroups().toArray());
  }

  @Test
  void createSelfSubjectRulesReviews() {
    // Given
    server.expect().post().withPath("/apis/authorization.openshift.io/v1/namespaces/test/selfsubjectrulesreviews")
        .andReturn(HTTP_CREATED, new SelfSubjectRulesReviewBuilder()
            .withNewSpec()
            .endSpec()
            .withNewStatus()
            .addNewRule()
            .withVerbs("create", "get")
            .withApiGroups("")
            .withResources("buildconfigs/webhooks")
            .endRule()
            .endStatus()
            .build())
        .once();

    // When
    SelfSubjectRulesReview response = client.selfSubjectRulesReviews().inNamespace("test")
        .create(new SelfSubjectRulesReviewBuilder()
            .withNewSpec().endSpec()
            .build());

    // Then
    assertNotNull(response);
    assertNotNull(response.getStatus());
    assertEquals(1, response.getStatus().getRules().size());
  }

  @Test
  void createSubjectRulesReviews() {
    // Given
    server.expect().post().withPath("/apis/authorization.openshift.io/v1/namespaces/test/subjectrulesreviews")
        .andReturn(HTTP_CREATED, new SubjectRulesReviewBuilder()
            .withNewSpec()
            .endSpec()
            .withNewStatus()
            .addNewRule()
            .withVerbs("create", "delete", "deletecollection", "get", "list", "patch", "update", "watch")
            .withApiGroups("")
            .withResources("imagestreams")
            .endRule()
            .endStatus()
            .build())
        .once();

    // When
    SubjectRulesReview response = client.subjectRulesReviews().inNamespace("test").create(new SubjectRulesReviewBuilder()
        .withNewSpec()
        .withUser("developer")
        .endSpec()
        .build());

    // Then
    assertNotNull(response);
    assertNotNull(response.getStatus());
    assertEquals(1, response.getStatus().getRules().size());
  }

}
