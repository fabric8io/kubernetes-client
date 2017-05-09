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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.utils.Utils;

public class KubernetesClientException extends RuntimeException {

  private int code;
  private Status status;

  public KubernetesClientException(String message) {
    super(message);
  }

  public KubernetesClientException(String message, Throwable t) {
    super(message, t);
  }

  public KubernetesClientException(Status status) {
    this(status.getMessage(), status.getCode(), status);
  }

  public KubernetesClientException(String message, int code, Status status) {
    super(message);
    this.code = code;
    this.status = status;
  }

  public Status getStatus() {
    return status;
  }

  public int getCode() {
    return code;
  }

  public static RuntimeException launderThrowable(Throwable cause) {
    return launderThrowable("An error has occurred.", cause);
  }

  public static RuntimeException launderThrowable(String message, Throwable cause) {
    if (cause instanceof RuntimeException) {
      return ((RuntimeException) cause);
    } else if (cause instanceof Error) {
      throw ((Error) cause);
    } else {
      throw new KubernetesClientException(message, cause);
    }
  }

  public static RuntimeException launderThrowable(OperationInfo spec, Throwable cause) {
    if (cause instanceof KubernetesClientException) {
      return launderThrowable(spec, ((KubernetesClientException)cause).getStatus(), cause);
    }

    return launderThrowable(describeOperation(spec)+ " failed.", cause);
  }

  public static RuntimeException launderThrowable(OperationInfo spec, Status status, Throwable cause) {
    StringBuilder sb = new StringBuilder();
    sb.append(describeOperation(spec)+ " failed.");
    if (status != null && Utils.isNotNullOrEmpty(status.getMessage())) {
      sb.append("Reason: ").append(status.getMessage());
    }
    return launderThrowable(sb.toString(), cause);
  }

  private static final String describeOperation(OperationInfo operation) {
    StringBuilder sb = new StringBuilder();
    sb.append("Operation");
    if (Utils.isNotNullOrEmpty(operation.getOperationType())) {
      sb.append(": [").append(operation.getOperationType() + "]");
    }
    sb.append(" ");
    sb.append(" for kind: [").append(operation.getKind()).append("] ");
    sb.append(" with name: [").append(operation.getName()).append("] ");
    sb.append(" in namespace: [").append(operation.getNamespace()).append("] ");
    return sb.toString();
  }
}
