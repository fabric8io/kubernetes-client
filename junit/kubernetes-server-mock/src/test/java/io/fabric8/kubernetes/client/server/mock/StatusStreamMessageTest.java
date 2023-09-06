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
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StatusStreamMessageTest {

  @Test
  void testMessageEncoding_withExitCode0() {
    final StatusStreamMessage message = new StatusStreamMessage(0);
    assertThat(message.isBinary()).isTrue();
    assertThat(message.isToBeRemoved()).isTrue();
    assertThat(message.getBytes()).startsWith(StatusStreamMessage.ERROR_CHANNEL_STREAM_ID);

    final Status status = new StatusBuilder() //
        .withStatus("Success")
        .withReason("ExitCode")
        .withNewDetails()
        .addNewCause()
        .withReason("ExitCode")
        .withMessage(String.valueOf(0))
        .endCause()
        .endDetails()
        .build();
    assertThat(message.getBody().substring(1)).isEqualTo(Serialization.asJson(status));
  }

  @Test
  void testMessageEncoding_withExitCode1() {
    final StatusStreamMessage message = new StatusStreamMessage(1);
    assertThat(message.isBinary()).isTrue();
    assertThat(message.isToBeRemoved()).isTrue();
    assertThat(message.getBytes()).startsWith(StatusStreamMessage.ERROR_CHANNEL_STREAM_ID);

    final Status status = new StatusBuilder() //
        .withStatus("Failure")
        .withReason("NonZeroExitCode")
        .withNewDetails()
        .addNewCause()
        .withReason("ExitCode")
        .withMessage(String.valueOf(1))
        .endCause()
        .endDetails()
        .build();
    assertThat(message.getBody().substring(1)).isEqualTo(Serialization.asJson(status));
  }
}
