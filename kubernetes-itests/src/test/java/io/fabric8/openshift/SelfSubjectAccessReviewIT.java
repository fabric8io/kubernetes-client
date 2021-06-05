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

import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReviewBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class SelfSubjectAccessReviewIT {
  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  @Test
  public void create() {
    // Given
    SelfSubjectAccessReview ssar = new SelfSubjectAccessReviewBuilder()
      .withNewSpec()
      .withNewResourceAttributes()
      .withGroup("apps")
      .withResource("deployments")
      .withVerb("create")
      .withNamespace(session.getNamespace())
      .endResourceAttributes()
      .endSpec()
      .build();

    // When
    ssar = client.authorization().v1().selfSubjectAccessReview().create(ssar);

    // Then
    assertTrue(ssar.getStatus().getAllowed());
  }
}
