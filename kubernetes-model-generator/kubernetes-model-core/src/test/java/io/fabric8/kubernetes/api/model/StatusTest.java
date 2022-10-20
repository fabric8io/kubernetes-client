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
package io.fabric8.kubernetes.api.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusTest {
  @Test
  public void testBuilder() {
    Status status = new io.fabric8.kubernetes.api.model.StatusBuilder()
        .withNewMetadata().withContinue("2343212").endMetadata()
        .withStatus("Some status")
        .withMessage("Some message")
        .withCode(200)
        .withNewDetails()
        .withGroup("apps")
        .withKind("Deployment")
        .withName("nginx-deploy")
        .addNewCause()
        .withField("spec.replicas")
        .withMessage("Detailed message")
        .endCause()
        .endDetails()
        .build();

    assertEquals("2343212", status.getMetadata().getContinue());
    assertEquals("Some status", status.getStatus());
    assertEquals("Some message", status.getMessage());
    assertEquals(200, status.getCode());
    assertEquals(1, status.getDetails().getCauses().size());
  }
}
