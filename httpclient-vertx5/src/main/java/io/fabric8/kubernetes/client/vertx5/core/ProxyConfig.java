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
package io.fabric8.kubernetes.client.vertx5.core;

import io.fabric8.kubernetes.client.http.HttpClient;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.net.InetSocketAddress;

@Value
@Builder
public final class ProxyConfig {
  @NonNull
  HttpClient.ProxyType type;
  @NonNull
  InetSocketAddress address;
  String username;
  String password;
  String authorization;

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("ProxyConfig(type=").append(type)
        .append(", address=").append(address)
        .append(", username=").append(username);

    if (password != null) {
      sb.append(", credentials=***");
    }

    if (authorization != null) {
      sb.append(", auth=***");
    }

    return sb.append(")").toString();
  }
}