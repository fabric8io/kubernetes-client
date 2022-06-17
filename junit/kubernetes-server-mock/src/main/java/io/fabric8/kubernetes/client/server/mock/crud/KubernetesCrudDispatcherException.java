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
package io.fabric8.kubernetes.client.server.mock.crud;

import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.StatusCause;
import io.fabric8.kubernetes.api.model.StatusCauseBuilder;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;

import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.stream.Collectors;

public class KubernetesCrudDispatcherException extends Exception {
  private final Integer code;
  private final String kind;
  private final String[] requiredFields;

  public KubernetesCrudDispatcherException(String message, Integer code) {
    this(message, code, null);
  }

  public KubernetesCrudDispatcherException(String message, Integer code, String kind, String... requiredFields) {
    super(message);
    this.code = code;
    this.kind = Utils.isNullOrEmpty(kind) ? "Unknown" : kind;
    this.requiredFields = requiredFields;
  }

  public int getCode() {
    return code == null ? HttpURLConnection.HTTP_BAD_REQUEST : code;
  }

  public Status toStatus() {
    return new StatusBuilder().withStatus("Failure")
        .withReason("Invalid")
        .withMessage(getMessage())
        .withNewDetails()
        .withKind(kind)
        .withCauses(Arrays.stream(requiredFields)
            .map(KubernetesCrudDispatcherException::toStatusCause).collect(Collectors.toList()))
        .endDetails()
        .withCode(getCode())
        .build();
  }

  public String toStatusBody() {
    return Serialization.asJson(toStatus());
  }

  private static StatusCause toStatusCause(String requiredField) {
    return new StatusCauseBuilder()
        .withMessage("Required value: " + requiredField + " is required")
        .withReason("ValueRequired")
        .build();
  }

}
