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

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.Duration;

import javax.net.ssl.SSLContext;

@Value
@Builder
public final class ConnectionConfig {
  @NonNull
  @Builder.Default
  Duration connectTimeout = Duration.ofSeconds(10);
  @NonNull
  @Builder.Default
  Duration idleTimeout = Duration.ofSeconds(30);
  @Builder.Default
  int maxPoolSize = 8192;
  @Builder.Default
  int maxWebSocketFrameSize = Integer.MAX_VALUE;
  @Builder.Default
  int maxWebSocketMessageSize = Integer.MAX_VALUE;
  @Builder.Default
  boolean followRedirects = false;
  @Builder.Default
  boolean preferHttp11 = false;

  ProxyConfig proxy;
  SSLContext sslContext;
  String[] tlsVersions;

  public String[] getTlsVersions() {
    return tlsVersions == null ? null : tlsVersions.clone();
  }
}