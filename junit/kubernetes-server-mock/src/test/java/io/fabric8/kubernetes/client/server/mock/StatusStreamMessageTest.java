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

package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StatusStreamMessageTest {

  private StatusStreamMessage message;

  @BeforeEach
  void setUp() {
    message = new StatusStreamMessage(1);
  }

  @Test
  void isBinaryReturnsTrue() {
    assertThat(message.isBinary()).isTrue();
  }

  @Test
  void isToBeRemovedReturnsTrue() {
    assertThat(message.isToBeRemoved()).isTrue();
  }

  @Test
  void bodyStartsWithErrorStreamId() {
    assertThat(message.getBytes()).startsWith(3);
  }

  @Test
  void withExitCode0_bodyContainsSuccessStatusObject() {
    message = new StatusStreamMessage(0);
    assertThat(new KubernetesSerialization().unmarshal(message.getBody().substring(1), Status.class))
        .isEqualTo(new StatusBuilder()
            .withStatus("Success")
            .withReason("ExitCode")
            .withNewDetails()
            .addNewCause()
            .withReason("ExitCode")
            .withMessage(String.valueOf(0))
            .endCause()
            .endDetails()
            .build());
  }

  @Test
  void withExitCode1_bodyContainsFailureStatusObject() {
    message = new StatusStreamMessage(1);
    assertThat(new KubernetesSerialization().unmarshal(message.getBody().substring(1), Status.class))
        .isEqualTo(new StatusBuilder()
            .withStatus("Failure")
            .withReason("NonZeroExitCode")
            .withNewDetails()
            .addNewCause()
            .withReason("ExitCode")
            .withMessage(String.valueOf(1))
            .endCause()
            .endDetails()
            .build());
  }
}
