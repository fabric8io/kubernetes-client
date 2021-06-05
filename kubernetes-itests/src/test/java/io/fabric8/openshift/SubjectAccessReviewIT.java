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
package io.fabric8.openshift;

import io.fabric8.openshift.api.model.SubjectAccessReview;
import io.fabric8.openshift.api.model.SubjectAccessReviewBuilder;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponse;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class SubjectAccessReviewIT {
  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  @Test
  public void testCreate() {
    // Given
    SubjectAccessReview sar = new SubjectAccessReviewBuilder()
      .withResource("Pod")
      .withVerb("get")
      .withNamespace(session.getNamespace())
      .build();

    // When
    SubjectAccessReviewResponse response = client.subjectAccessReviews().create(sar);

    // Then
    assertNotNull(response);
    assertTrue(response.getAllowed());
  }
}
