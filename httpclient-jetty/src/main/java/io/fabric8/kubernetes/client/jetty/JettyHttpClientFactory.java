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
package io.fabric8.kubernetes.client.jetty;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.http.HttpClient;
import org.eclipse.jetty.websocket.client.WebSocketClient;

public class JettyHttpClientFactory implements HttpClient.Factory {

  @Override
  public JettyHttpClientBuilder newBuilder() {
    return new JettyHttpClientBuilder(this);
  }

  /**
   * Additional configuration to be applied to the clients after the {@link Config} has been processed.
   */
  protected void additionalConfig(org.eclipse.jetty.client.HttpClient httpClient, WebSocketClient webSocketClient) {
    // no default implementation
  }
}
