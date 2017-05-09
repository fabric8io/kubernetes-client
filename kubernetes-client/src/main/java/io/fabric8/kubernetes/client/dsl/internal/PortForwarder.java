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
package io.fabric8.kubernetes.client.dsl.internal;

import java.net.InetAddress;
import java.net.URL;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import io.fabric8.kubernetes.client.LocalPortForward;
import io.fabric8.kubernetes.client.PortForward;

/**
 * Allows to forward local ports (or nio channels) to remote ports in Kubernetes pods.
 */
public interface PortForwarder {

  LocalPortForward forward(URL resourceBaseUrl, int port);

  LocalPortForward forward(URL resourceBaseUrl, int port, int localPort);

  LocalPortForward forward(URL resourceBaseUrl, int port, InetAddress localHost, int localPort);

  PortForward forward(URL resourceBaseUrl, int port, ReadableByteChannel in, WritableByteChannel out);

}
