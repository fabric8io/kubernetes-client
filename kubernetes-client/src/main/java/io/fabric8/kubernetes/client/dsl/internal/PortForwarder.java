/*
 * Copyright 2016 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package io.fabric8.kubernetes.client.dsl.internal;

import java.net.InetAddress;
import java.nio.channels.ByteChannel;

/**
 * Allows to forward local ports (or nio channels) to remote ports in Kubernetes pods.
 */
public interface PortForwarder {

  PortForwarderBridgedHandle forward(String namespace, String pod, int port);

  PortForwarderBridgedHandle forward(String namespace, String pod, int port, int localPort);

  PortForwarderBridgedHandle forward(String namespace, String pod, int port, InetAddress localHost, int localPort);

  PortForwarderHandle forward(String namespace, String pod, int port, ByteChannel channel);

}
