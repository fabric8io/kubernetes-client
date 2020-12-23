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
package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReviewBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class SelfSubjectAccessReviewIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @Test
  public void testCreate() {
    // Given
    SelfSubjectAccessReview selfSubjectAccessReview = new SelfSubjectAccessReviewBuilder()
      .withNewSpec()
      .withNewResourceAttributes()
      .withNamespace(session.getNamespace())
      .withVerb("get")
      .withResource("pods")
      .endResourceAttributes()
      .endSpec()
      .build();

    // When
    selfSubjectAccessReview = client.authorization().v1().selfSubjectAccessReview().create(selfSubjectAccessReview);

    // Then
    assertTrue(selfSubjectAccessReview.getStatus().getAllowed());
    assertNull(selfSubjectAccessReview.getStatus().getDenied());
  }
}
