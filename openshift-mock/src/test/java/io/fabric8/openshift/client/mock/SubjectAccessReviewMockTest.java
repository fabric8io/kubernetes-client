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

package io.fabric8.openshift.client.mock;


import io.fabric8.openshift.api.model.LocalSubjectAccessReview;
import io.fabric8.openshift.api.model.LocalSubjectAccessReviewBuilder;
import io.fabric8.openshift.api.model.SubjectAccessReview;
import io.fabric8.openshift.api.model.SubjectAccessReviewBuilder;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponse;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponseBuilder;
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import org.junit.Assert;
import org.junit.Test;

public class SubjectAccessReviewMockTest {

  @Test
  public void testCreate() {
    OpenShiftMockClient mock = new OpenShiftMockClient();

    SubjectAccessReview review1 = new SubjectAccessReviewBuilder().withUser("user1").withVerb("versb").withResource("res1").build();
    SubjectAccessReview review2 = new SubjectAccessReviewBuilder().withUser("user2").withVerb("verb").withResource("res1").build();

    SubjectAccessReviewResponse expectedResponse1 = new SubjectAccessReviewResponseBuilder()
      .withReason("r1")
      .build();

    SubjectAccessReviewResponse expectedResponse2 = new SubjectAccessReviewResponseBuilder()
      .withReason("r2")
      .build();

    mock.getSubjectAccessReviews().create(review1).andReturn(expectedResponse1);
    mock.getSubjectAccessReviews().create(review2).andReturn(expectedResponse2);


    NamespacedOpenShiftClient client = mock.replay();
    SubjectAccessReviewResponse response = client.subjectAccessReviews().create(review1);
    Assert.assertEquals(expectedResponse1, response);

    response = client.subjectAccessReviews().create(review2);
    Assert.assertEquals(expectedResponse2, response);
  }



  @Test
  public void testCreateLocal() {
    OpenShiftMockClient mock = new OpenShiftMockClient();

    LocalSubjectAccessReview review1 = new LocalSubjectAccessReviewBuilder().withUser("user1").withVerb("versb").withResource("res1").build();
    LocalSubjectAccessReview review2 = new LocalSubjectAccessReviewBuilder().withUser("user2").withVerb("verb").withResource("res1").build();

    SubjectAccessReviewResponse expectedResponse1 = new SubjectAccessReviewResponseBuilder()
      .withReason("r1")
      .build();

    SubjectAccessReviewResponse expectedResponse2 = new SubjectAccessReviewResponseBuilder()
      .withReason("r2")
      .build();

    mock.getSubjectAccessReviews().inNamespace("ns1").create(review1).andReturn(expectedResponse1);
    mock.getSubjectAccessReviews().inNamespace("ns2").create(review2).andReturn(expectedResponse2);


    NamespacedOpenShiftClient client = mock.replay();
    SubjectAccessReviewResponse response = client.subjectAccessReviews().inNamespace("ns1").create(review1);
    Assert.assertEquals(expectedResponse1, response);

    response = client.subjectAccessReviews().inNamespace("ns2").create(review2);
    Assert.assertEquals(expectedResponse2, response);
  }


}
