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

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.authorization.LocalSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.LocalSubjectAccessReviewBuilder;
import io.fabric8.kubernetes.api.model.authorization.SubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.SubjectAccessReviewBuilder;
import io.fabric8.kubernetes.api.model.authorization.SubjectAccessReviewStatus;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubjectAccessReviewAuthTest {

  @Rule
  public KubernetesServer server = new KubernetesServer();

  private static final Logger logger = LoggerFactory.getLogger(ClusterRoleBindingCrudTest.class);

  @Test
  public void createSubjectAccessReviewTest() {


    KubernetesClient client = server.getClient();

    SubjectAccessReview review = new SubjectAccessReviewBuilder().withNewSpec()
      .withUser("admin-user")
      .withNewResourceAttributes()
      .withResource("pod")
      .withVerb("create")
      .endResourceAttributes()
      .endSpec()
      .build();

    server.expect().post().withPath("/apis/authorization.k8s.io/v1/subjectaccessreviews").andReply(200, recordedRequest -> {
      ObjectMapper mapper = new ObjectMapper();
      SubjectAccessReview reviewResponse = null;
      try {
        reviewResponse = mapper.readValue(recordedRequest.getBody().readString(Charset.defaultCharset()), SubjectAccessReview.class);

        reviewResponse.setStatus(new SubjectAccessReviewStatus(true, false, "",""));
      } catch (IOException e) {
        logger.error("Invalid response received", e);
      }

      return reviewResponse;
    }).once();

    SubjectAccessReview reviewResponse = client.subjectAccessReviewAuth().create(review);

    assertNotNull(reviewResponse);
    assertEquals(true, reviewResponse.getStatus().getAllowed());

  }

  @Test
  public void createLocalSubjectAccessReviewTest() {


    KubernetesClient client = server.getClient();

    LocalSubjectAccessReview review = new LocalSubjectAccessReviewBuilder().withNewSpec()
      .withUser("admin-user")
      .withNewResourceAttributes()
      .withResource("pod")
      .withVerb("create")
      .endResourceAttributes()
      .endSpec()
      .build();

    server.expect().post().withPath("/apis/authorization.k8s.io/v1/namespaces/test/localsubjectaccessreviews").andReply(200, recordedRequest -> {
      ObjectMapper mapper = new ObjectMapper();
      LocalSubjectAccessReview reviewResponse = null;
      try {
        reviewResponse = mapper.readValue(recordedRequest.getBody().readString(Charset.defaultCharset()), LocalSubjectAccessReview.class);
        reviewResponse.setStatus(new SubjectAccessReviewStatus(true, false, "",""));
      } catch (IOException e) {
        logger.error("Invalid response received", e);
      }

      return reviewResponse;
    }).once();

    LocalSubjectAccessReview reviewResponse = client.subjectAccessReviewAuth()
      .inNamespace("test").create(review);

    assertNotNull(reviewResponse);
    assertNotNull(reviewResponse.getMetadata());
    assertEquals("test", reviewResponse.getMetadata().getNamespace());
    assertEquals("test", reviewResponse.getSpec().getResourceAttributes().getNamespace());
    assertEquals(true, reviewResponse.getStatus().getAllowed());

  }
}
