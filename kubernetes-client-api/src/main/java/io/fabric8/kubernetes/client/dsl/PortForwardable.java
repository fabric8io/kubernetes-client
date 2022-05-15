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
package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.client.LocalPortForward;
import io.fabric8.kubernetes.client.PortForward;

import java.net.InetAddress;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public interface PortForwardable {
  /**
   * Connects directly the remote port to the given input and output channels.
   *
   * @param port port as integer
   * @param in input channel
   * @param out output channel
   * @return returns port forward interface
   */
  PortForward portForward(int port, ReadableByteChannel in, WritableByteChannel out);

  /**
   * Create a server socket on a specified local port. Every connection to the local port will be forwarded to the remote port
   * on the resource.
   *
   * @param port port in integer
   * @param localPort local port in integer
   * @return returns local port forward interface
   */
  LocalPortForward portForward(int port, int localPort);

  /**
   * Listen on port <code>localPort</code> on selected IP <code>inetAddress</code>, forwarding to <code>port</code>
   * in the pod
   *
   * @param port port in integer
   * @param localInetAddress {@link InetAddress} selected IP Address
   * @param localPort local port in integer
   * @return PortForward interface
   */
  LocalPortForward portForward(int port, InetAddress localInetAddress, int localPort);

  /**
   * Create a server socket on a random local port. Every connection to the local port will be forwarded to the remote port on
   * the resource.
   * The random local port can be retrieved from the returned object.
   *
   * @param port port as integer
   * @return returns local port
   */
  LocalPortForward portForward(int port);

}
