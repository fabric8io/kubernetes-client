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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.utils.Utils;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KubernetesClientException extends RuntimeException {

  private final int code;
  private final Status status;
  private final RequestMetadata requestMetadata;

  public KubernetesClientException(String message) {
    this(message, null);
  }

  public KubernetesClientException(String message, Throwable t) {
    this(message, t, -1, null, (RequestMetadata) null);
  }

  public KubernetesClientException(Status status) {
    this(status.getMessage(), status.getCode(), status);
  }

  public KubernetesClientException(String message, int code, Status status) {
    this(message, null, code, status, (RequestMetadata) null);
  }

  public KubernetesClientException(String message, Throwable t, int code, Status status, HttpRequest httpRequest) {
    this(message, t, code, status, RequestMetadata.from(httpRequest));
  }

  private KubernetesClientException(String message, Throwable t, int code, Status status, RequestMetadata requestMetadata) {
    super(message, t);
    this.code = code;
    this.status = status;
    this.requestMetadata = requestMetadata == null ? RequestMetadata.EMPTY : requestMetadata;
  }

  /**
   * @deprecated use {@link #KubernetesClientException(String, Throwable, int, Status, HttpRequest)} instead
   */
  @Deprecated
  public KubernetesClientException(String message, int code, Status status, String group, String version, String resourcePlural,
      String namespace) {
    this(message, null, code, status,
        RequestMetadata.builder().group(group).version(version).plural(resourcePlural).namespace(namespace).build());
  }

  /**
   * @deprecated use {@link #KubernetesClientException(String, Throwable, int, Status, HttpRequest)} instead
   */
  @Deprecated
  public KubernetesClientException(String message, Throwable t, String group, String version, String resourcePlural,
      String namespace) {
    this(message, t, -1, null,
        RequestMetadata.builder().group(group).version(version).plural(resourcePlural).namespace(namespace).build());
  }

  public Status getStatus() {
    return status;
  }

  public int getCode() {
    return code;
  }

  public String getGroup() {
    return requestMetadata.group;
  }

  public String getVersion() {
    return requestMetadata.version;
  }

  public String getResourcePlural() {
    return requestMetadata.plural;
  }

  public String getNamespace() {
    return requestMetadata.namespace;
  }

  public String getName() {
    return requestMetadata.name;
  }

  public String getFullResourceName() {
    if (requestMetadata.plural != null && requestMetadata.group != null) {
      return HasMetadata.getFullResourceName(requestMetadata.plural, requestMetadata.group);
    }
    return null;
  }

  public static RuntimeException launderThrowable(Throwable cause) {
    return launderThrowable("An error has occurred.", cause);
  }

  public static RuntimeException launderThrowable(String message, Throwable cause) {
    RuntimeException processed = processCause(cause);
    if (processed != null)
      return processed;
    throw new KubernetesClientException(message, cause);
  }

  private static RuntimeException processCause(Throwable cause) {
    if (cause instanceof RuntimeException) {
      return ((RuntimeException) cause);
    } else if (cause instanceof Error) {
      throw ((Error) cause);
    } else if (cause instanceof InterruptedException) {
      Thread.currentThread().interrupt();
    }
    return null;
  }

  public static RuntimeException launderThrowable(OperationInfo spec, Throwable cause) {
    RuntimeException processed = processCause(cause);
    if (processed != null)
      return processed;

    StringBuilder sb = new StringBuilder();
    sb.append(describeOperation(spec)).append(" failed.");
    if (cause instanceof KubernetesClientException) {
      final Status status = ((KubernetesClientException) cause).getStatus();
      if (status != null && Utils.isNotNullOrEmpty(status.getMessage())) {
        sb.append("Reason: ").append(status.getMessage());
      }
    }

    throw new KubernetesClientException(sb.toString(), cause, -1, null, RequestMetadata.builder()
        .group(spec.getGroup()).version(spec.getVersion()).plural(spec.getPlural())
        .namespace(spec.getNamespace()).name(spec.getName()).build());
  }

  /**
   * @deprecated Use {@link #launderThrowable(OperationInfo, Throwable)} instead
   */
  @Deprecated
  public static RuntimeException launderThrowable(OperationInfo spec, Status status, Throwable cause) {
    StringBuilder sb = new StringBuilder();
    sb.append(describeOperation(spec)).append(" failed.");
    if (status != null && Utils.isNotNullOrEmpty(status.getMessage())) {
      sb.append("Reason: ").append(status.getMessage());
    }
    return launderThrowable(sb.toString(), cause);
  }

  private static String describeOperation(OperationInfo operation) {
    StringBuilder sb = new StringBuilder();
    sb.append("Operation");
    if (Utils.isNotNullOrEmpty(operation.getOperationType())) {
      sb.append(": [").append(operation.getOperationType()).append("]");
    }
    sb.append(" ");
    sb.append(" for kind: [").append(operation.getKind()).append("] ");
    sb.append(" with name: [").append(operation.getName()).append("] ");
    sb.append(" in namespace: [").append(operation.getNamespace()).append("] ");
    return sb.toString();
  }

  @Builder
  @EqualsAndHashCode
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  private static class RequestMetadata implements Serializable {

    private static final RequestMetadata EMPTY = new RequestMetadata(null, null, null, null, null);

    final String group;
    final String version;
    final String plural;
    final String namespace;
    final String name;

    static RequestMetadata from(HttpRequest request) {
      return from(request.uri());
    }

    static RequestMetadata from(URI request) {
      final List<String> segments = Arrays.stream(request.getRawPath().split("/"))
          .filter(s -> !s.isEmpty()).collect(Collectors.toList());
      switch (segments.size()) {
        case 3:
          // cluster URL for historic resources
          return RequestMetadata.builder().group("").version(segments.get(1)).plural(segments.get(2)).build();
        case 4:
          // cluster URL
          return RequestMetadata.builder().group(segments.get(1)).version(segments.get(2)).plural(segments.get(3)).build();
        case 6:
          // namespaced URL with potential name
          final String root = segments.get(0);
          if ("api".equals(root)) {
            return RequestMetadata.builder().group("").version(segments.get(1)).plural(segments.get(4))
                .namespace(segments.get(3)).name(segments.get(5)).build();
          }
          return RequestMetadata.builder().group(segments.get(1)).version(segments.get(2)).plural(segments.get(5))
              .namespace(segments.get(4)).build();
        case 7:
          // namespaced URL with name
          return RequestMetadata.builder().group(segments.get(1)).version(segments.get(2)).plural(segments.get(5))
              .namespace(segments.get(4)).name(segments.get(6)).build();
        default:
          return EMPTY;
      }
    }
  }

  /**
   * Create a new {@link KubernetesClientException} with this exception as the cause
   */
  public KubernetesClientException copyAsCause() {
    return new KubernetesClientException(this.getMessage(), this, this.getCode(), this.getStatus(),
        this.requestMetadata);
  }
}
