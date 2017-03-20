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

public interface PortForwardable<H, L, I, O> {

  /**
   * Connects directly the remote port to the given input and output channels.
   */
  H portForward(int port, I in, O out);

  /**
   * Create a server socket on a specified local port. Every connection to the local port will be forwarded to the remote port on the resource.
   */
  L portForward(int port, int localPort);

  /**
   * Create a server socket on a random local port. Every connection to the local port will be forwarded to the remote port on the resource.
   * The random local port can be retrieved from the returned object.
   */
  L portForward(int port);

}
