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
package io.fabric8.chaosmesh.server.mock;

import io.fabric8.chaosmesh.client.DefaultChaosMeshClient;
import io.fabric8.chaosmesh.client.NamespacedChaosMeshClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;

import java.util.Map;
import java.util.Queue;

public class ChaosMeshMockServer extends KubernetesMockServer {
  public ChaosMeshMockServer() {
    super();
  }

  public ChaosMeshMockServer(boolean useHttps) {
    super(useHttps);
  }

  public ChaosMeshMockServer(Context context, MockWebServer server, Map<ServerRequest, Queue<ServerResponse>> responses, Dispatcher dispatcher, boolean useHttps) {
    super(context, server, responses, dispatcher, useHttps);
  }

  @Override
  public String[] getRootPaths() {
    return new String[]{"/api", "/apis/chaos-mesh.org"};
  }

  public NamespacedChaosMeshClient createChaosMeshClient() {
    Config config = new ConfigBuilder()
      .withMasterUrl(url("/"))
      .withNamespace("test")
      .withTrustCerts(true)
      .withTlsVersions(TlsVersion.TLS_1_2)
      .build();
    return new DefaultChaosMeshClient(config);
  }
}
