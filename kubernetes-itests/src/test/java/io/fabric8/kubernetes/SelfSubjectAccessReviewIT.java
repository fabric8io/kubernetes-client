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

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReviewBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SelfSubjectAccessReviewIT {

  KubernetesClient client;

  Namespace namespace;

  @Test
  void testCreate() {
    // Given
    SelfSubjectAccessReview selfSubjectAccessReview = new SelfSubjectAccessReviewBuilder()
        .withNewSpec()
        .withNewResourceAttributes()
        .withNamespace(namespace.getMetadata().getName())
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
