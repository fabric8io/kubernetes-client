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
import io.fabric8.mockwebserver.internal.WebSocketMessage;

import static io.fabric8.kubernetes.client.server.mock.OutputStreamMessage.getBodyBytes;

public class StatusStreamMessage extends WebSocketMessage {

  private static final byte ERROR_CHANNEL_STREAM_ID = 3;

  public StatusStreamMessage(final int exitCode) {
    super(0L, getBodyBytes(ERROR_CHANNEL_STREAM_ID, getStatusBody(exitCode)), true, true);
  }

  private static String getStatusBody(int exitCode) {
    final Status status = new StatusBuilder() //
        .withStatus(exitCode == 0 ? "Success" : "Failure")
        .withReason(exitCode == 0 ? "ExitCode" : "NonZeroExitCode")
        .withNewDetails()
        .addNewCause()
        .withReason("ExitCode")
        .withMessage(String.valueOf(exitCode))
        .endCause()
        .endDetails()
        .build();
    return Serialization.asJson(status);
  }
}
