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

import java.net.HttpURLConnection;

public class WatcherException extends Exception {

  public WatcherException(String message, Throwable cause) {
    super(message, cause);
  }

  public WatcherException(String message) {
    super(message);
  }

  public KubernetesClientException asClientException() {
    final Throwable cause = getCause();
    return cause instanceof KubernetesClientException ?
      (KubernetesClientException) cause : new KubernetesClientException(getMessage(), cause);
  }

  public boolean isHttpGone() {
    final KubernetesClientException cause = asClientException();
    return cause.getCode() == HttpURLConnection.HTTP_GONE
      || (cause.getStatus() != null && cause.getStatus().getCode() == HttpURLConnection.HTTP_GONE);
  }

}
