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

import io.fabric8.openshift.api.model.LocalSubjectAccessReviewBuilder;
import io.fabric8.openshift.api.model.SubjectAccessReviewBuilder;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponse;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponseBuilder;
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableRuleMigrationSupport
class SubjectAccessReviewTest {
  @Rule
  public OpenShiftServer server = new OpenShiftServer();

  @Test
  void testCreate() {
    server.expect().withPath("/apis/authorization.openshift.io/v1/subjectaccessreviews").andReturn(201, new SubjectAccessReviewResponseBuilder()
      .withReason("r1")
      .build()).once();

    NamespacedOpenShiftClient client = server.getOpenshiftClient();

    SubjectAccessReviewResponse response = client.inAnyNamespace().subjectAccessReviews().create(new SubjectAccessReviewBuilder()
      .build());
    assertNotNull(response);
    assertEquals("r1", response.getReason());
  }


  @Test
  void testCreateInLine() {
    server.expect().withPath("/apis/authorization.openshift.io/v1/subjectaccessreviews").andReturn(201, new SubjectAccessReviewResponseBuilder()
      .withReason("r2")
      .build()).once();

    NamespacedOpenShiftClient client = server.getOpenshiftClient();

    SubjectAccessReviewResponse response = client.inAnyNamespace().subjectAccessReviews()
      .create(new SubjectAccessReviewBuilder().build());
    assertNotNull(response);
    assertEquals("r2", response.getReason());
  }


  @Test
  void testCreateLocal() {
   server.expect().withPath("/apis/authorization.openshift.io/v1/namespaces/test/localsubjectaccessreviews").andReturn(201, new SubjectAccessReviewResponseBuilder()
      .withReason("r1")
      .build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

    SubjectAccessReviewResponse response = client.localSubjectAccessReviews().inNamespace("test").create(new LocalSubjectAccessReviewBuilder()
      .withNamespace("test")
      .withVerb("get")
      .withGroups("test.fabric8.io")
      .build());
    assertNotNull(response);
    assertEquals("r1", response.getReason());
  }


  @Test
  void testCreateLocalInLine() {
   server.expect().withPath("/apis/authorization.openshift.io/v1/namespaces/test/localsubjectaccessreviews").andReturn( 201, new SubjectAccessReviewResponseBuilder()
      .withReason("r2")
      .build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

    SubjectAccessReviewResponse response = client.localSubjectAccessReviews().inNamespace("test").create(new LocalSubjectAccessReviewBuilder()
      .withUser("user")
      .withVerb("verb")
      .build());
    assertNotNull(response);
    assertEquals("r2", response.getReason());
  }

}
