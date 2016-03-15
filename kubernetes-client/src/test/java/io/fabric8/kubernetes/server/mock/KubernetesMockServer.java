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

package io.fabric8.kubernetes.server.mock;

import com.squareup.okhttp.mockwebserver.MockWebServer;
import io.fabric8.kubernetes.api.model.RootPathsBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class KubernetesMockServer {

  private final boolean useHttps;

  private MockWebServer server = new MockWebServer();
  private Map<ServerRequest, Queue<ServerResponse>> responses = new HashMap<>();

  public KubernetesMockServer() {
    this(true);
  }

  public KubernetesMockServer(boolean useHttps) {
    this.useHttps = useHttps;
  }

  public void init()  {
    try {
      if (useHttps) {
        server.useHttps(MockSSLContextFactory.create().getSocketFactory(), false);
      }
      server.setDispatcher(new MockDispatcher(responses));
      expect().get().withPath("/").andReturn(200, new RootPathsBuilder().addToPaths(getRootPaths()).build()).always();
      server.start();
    } catch (Throwable t) {
      throw new RuntimeException(t);
    }
  }

  public String[] getRootPaths() {
    return new String[]{"/api", "/apis/extensions"};
  }

  public void destroy() throws IOException {
    server.shutdown();
  }

  public KubernetesClient createClient() {
    Config config = new ConfigBuilder()
      .withMasterUrl(server.getUrl("/").toString())
      .withTrustCerts(true)
      .withNamespace("test")
      .build();
    return new DefaultKubernetesClient(config);
  }

  public MockWebServer getServer() {
    return server;
  }

  public MockServerExpectation expect() {
    return new MockServerExpectationImpl(responses);
  }
}
