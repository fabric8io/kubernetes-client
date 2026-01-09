/*
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

import java.net.HttpURLConnection;
import java.util.Optional;

public class WatcherException extends Exception {
  private final String rawWatchMessage;
  private final boolean reconnectionError;

  public WatcherException(String message, Throwable cause) {
    this(message, cause, null);
  }

  public WatcherException(String message) {
    this(message, null, null);
  }

  public WatcherException(String message, Throwable cause, boolean reconnectionError) {
    super(message);
    rawWatchMessage = null;
    this.reconnectionError = reconnectionError;
  }

  public WatcherException(String message, Throwable cause, String rawWatchMessage) {
    super(message, cause);
    this.rawWatchMessage = rawWatchMessage;
    this.reconnectionError = false;
  }

  public KubernetesClientException asClientException() {
    final Throwable cause = Optional.ofNullable(getCause()).orElse(this);
    return cause instanceof KubernetesClientException ? (KubernetesClientException) cause
        : new KubernetesClientException(getMessage(), cause);
  }

  public boolean isHttpGone() {
    final KubernetesClientException cause = asClientException();
    return cause != null && (cause.getCode() == HttpURLConnection.HTTP_GONE
        || (cause.getStatus() != null && cause.getStatus().getCode() == HttpURLConnection.HTTP_GONE));
  }

  public boolean isReconnectionError() {
    return reconnectionError;
  }

  @SuppressWarnings("unused")
  public Optional<String> getRawWatchMessage() {
    return Optional.ofNullable(rawWatchMessage);
  }

}
