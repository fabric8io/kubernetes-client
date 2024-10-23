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
package io.fabric8.mockwebserver.vertx;

import io.vertx.core.http.HttpVersion;

import java.util.Locale;

/**
 * Compatibility layer for OkHttp.
 */
public enum Protocol {
  HTTP_1_0(HttpVersion.HTTP_1_0, "http/1.0"),
  HTTP_1_1(HttpVersion.HTTP_1_1, "http/1.1"),
  HTTP_2(HttpVersion.HTTP_2, "h2", "h2_prior_knowledge", "h2c", "http/2", "http/2.0");

  private final String[] protocolNames;
  private final HttpVersion httpVersion;

  Protocol(HttpVersion httpVersion, String... protocolNames) {
    this.httpVersion = httpVersion;
    this.protocolNames = protocolNames;
  }

  public static Protocol get(String protocol) {
    for (Protocol p : Protocol.values()) {
      for (String protocolName : p.protocolNames) {
        if (protocolName.equals(protocol.toLowerCase(Locale.ROOT))) {
          return p;
        }
      }
    }
    throw new IllegalArgumentException("Unknown protocol: " + protocol);
  }

  public HttpVersion getHttpVersion() {
    return httpVersion;
  }

  @Override
  public String toString() {
    return protocolNames[0];
  }
}
