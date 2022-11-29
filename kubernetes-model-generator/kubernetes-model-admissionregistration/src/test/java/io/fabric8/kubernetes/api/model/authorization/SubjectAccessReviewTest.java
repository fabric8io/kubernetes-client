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
package io.fabric8.kubernetes.api.model.authorization;

import io.fabric8.kubernetes.api.model.authorization.v1.SubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SubjectAccessReviewBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubjectAccessReviewTest {
  @Test
  public void testBuilder() {
    SubjectAccessReview sar = new SubjectAccessReviewBuilder()
        .withNewMetadata().withName("test-sar").endMetadata()
        .withNewSpec()
        .withNewResourceAttributes()
        .withGroup("apps")
        .withResource("deployments")
        .withNamespace("dev")
        .withVerb("create")
        .endResourceAttributes()
        .endSpec()
        .build();

    Assertions.assertEquals("test-sar", sar.getMetadata().getName());
    Assertions.assertEquals("apps", sar.getSpec().getResourceAttributes().getGroup());
    Assertions.assertEquals("deployments", sar.getSpec().getResourceAttributes().getResource());
    Assertions.assertEquals("dev", sar.getSpec().getResourceAttributes().getNamespace());
    Assertions.assertEquals("create", sar.getSpec().getResourceAttributes().getVerb());
  }
}
