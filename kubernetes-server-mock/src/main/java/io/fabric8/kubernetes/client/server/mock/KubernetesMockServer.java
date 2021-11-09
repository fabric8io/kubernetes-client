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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.api.model.RootPathsBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.DefaultMockServer;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.mockwebserver.internal.MockDispatcher;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import static io.fabric8.kubernetes.client.utils.HttpClientUtils.createHttpClientForMockServer;
import static okhttp3.TlsVersion.TLS_1_2;

public class KubernetesMockServer extends DefaultMockServer {

    private static final Context context = new Context(Serialization.jsonMapper());

    private final Map<ServerRequest, Queue<ServerResponse>> responses;
    private final VersionInfo versionInfo;

    public KubernetesMockServer() {
        this(true);
    }

    public KubernetesMockServer(boolean useHttps) {
        this(new MockWebServer(), new HashMap<>(), useHttps);
    }

    public KubernetesMockServer(MockWebServer server, Map<ServerRequest, Queue<ServerResponse>> responses, boolean useHttps) {
        this(context, server, responses, useHttps);
    }

    public KubernetesMockServer(Context context, MockWebServer server, Map<ServerRequest, Queue<ServerResponse>> responses, boolean useHttps) {
        this(context, server, responses, new MockDispatcher(responses), useHttps);
    }

    public KubernetesMockServer(Context context, MockWebServer server, Map<ServerRequest, Queue<ServerResponse>> responses, Dispatcher dispatcher, boolean useHttps) {
        this(context, server, responses, dispatcher, useHttps,
          new VersionInfo.Builder().withMajor("0").withMinor("0").build());
    }

    public KubernetesMockServer(Context context, MockWebServer server, Map<ServerRequest, Queue<ServerResponse>> responses, Dispatcher dispatcher, boolean useHttps, VersionInfo versionInfo) {
        super(context, server, responses, dispatcher, useHttps);
        this.responses = responses;
        this.versionInfo = versionInfo;
    }

    @Override
    public void onStart() {
        expect().get().withPath("/").andReturn(200, new RootPathsBuilder().addToPaths(getRootPaths()).build()).always();
        expect().get().withPath("/version").andReturn(200, versionInfo).always();
    }

    public void init() {
        start();
    }

    public void init(InetAddress address, int port) {
        start(address, port);
    }

    public void destroy() {
        shutdown();
    }

    public String[] getRootPaths() {
        return new String[]{"/api", "/apis/extensions"};
    }

    public NamespacedKubernetesClient createClient() {
        Config config = getMockConfiguration();
        return new DefaultKubernetesClient(createHttpClientForMockServer(config), config);
    }

  /**
   * Removes all recorded expectations.
   */
  public void clearExpectations(){
      responses.clear();
    }

    protected Config getMockConfiguration() {
        return new ConfigBuilder(Config.empty())
                .withMasterUrl(url("/"))
                .withTrustCerts(true)
                .withTlsVersions(TLS_1_2)
                .withNamespace("test")
                .build();
    }
}
