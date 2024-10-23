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
package io.fabric8.mockwebserver.http;

import io.vertx.core.net.SocketAddress;

import java.util.Objects;

public class RecordedHttpConnection {

  private final SocketAddress remoteAddress;
  private final SocketAddress localAddress;
  private final boolean ssl;

  public RecordedHttpConnection(SocketAddress remoteAddress, SocketAddress localAddress, boolean ssl) {
    this.remoteAddress = remoteAddress;
    this.localAddress = localAddress;
    this.ssl = ssl;
  }

  public SocketAddress getRemoteAddress() {
    return remoteAddress;
  }

  public SocketAddress getLocalAddress() {
    return localAddress;
  }

  public boolean isSsl() {
    return ssl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    RecordedHttpConnection that = (RecordedHttpConnection) o;
    return ssl == that.ssl && Objects.equals(remoteAddress, that.remoteAddress)
        && Objects.equals(localAddress, that.localAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(remoteAddress, localAddress, ssl);
  }
}
