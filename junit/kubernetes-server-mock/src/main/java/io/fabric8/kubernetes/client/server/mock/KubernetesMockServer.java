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
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.DefaultMockServer;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.mockwebserver.internal.MockDispatcher;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Pattern;

public class KubernetesMockServer extends DefaultMockServer implements Resetable {

  private final Map<ServerRequest, Queue<ServerResponse>> responses;
  private final VersionInfo versionInfo;
  private final Dispatcher dispatcher;
  private List<Pattern> unsupportedPatterns = Collections.emptyList();

  public KubernetesMockServer() {
    this(true);
  }

  public KubernetesMockServer(boolean useHttps) {
    this(new MockWebServer(), new HashMap<>(), useHttps);
  }

  public KubernetesMockServer(MockWebServer server, Map<ServerRequest, Queue<ServerResponse>> responses,
      boolean useHttps) {
    this(new Context(Serialization.jsonMapper()), server, responses, useHttps);
  }

  public KubernetesMockServer(Context context, MockWebServer server,
      Map<ServerRequest, Queue<ServerResponse>> responses,
      boolean useHttps) {
    this(context, server, responses, new MockDispatcher(responses), useHttps);
  }

  public KubernetesMockServer(Context context, MockWebServer server,
      Map<ServerRequest, Queue<ServerResponse>> responses,
      Dispatcher dispatcher, boolean useHttps) {
    this(context, server, responses, dispatcher, useHttps,
        new VersionInfo.Builder().withMajor("0").withMinor("0").build());
  }

  public KubernetesMockServer(Context context, MockWebServer server,
      Map<ServerRequest, Queue<ServerResponse>> responses,
      Dispatcher dispatcher, boolean useHttps, VersionInfo versionInfo) {
    super(context, server, responses, dispatcher, useHttps);
    this.dispatcher = dispatcher;
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
    return new String[] { "/api", "/apis/extensions" };
  }

  public NamespacedKubernetesClient createClient() {
    return createClient(null);
  }

  public NamespacedKubernetesClient createClient(HttpClient.Factory factory) {
    KubernetesClient client = new KubernetesClientBuilder().withConfig(getMockConfiguration()).withHttpClientFactory(factory)
        .build();
    client.adapt(BaseClient.class)
        .setMatchingGroupPredicate(s -> unsupportedPatterns.stream().noneMatch(p -> p.matcher(s).find()));
    return client.adapt(NamespacedKubernetesClient.class);
  }

  /**
   * Used to exclude support for the given apiGroups.
   * <br>
   * Each is a simple expression of the form: group[/version]
   * <br>
   * where * is a wildcard.
   * <br>
   * For example to exclude all openshift support, you would specify
   * openshift.io
   * <br>
   * To exclude a specific apiVersion, you would fully specify
   * route.openshift.io/v1
   * <p>
   * NOTE this affects calls to {@link Client#hasApiGroup(String, boolean)}
   * and {@link Client#supports(Class)}. Other calls to get the full root path or other
   * api group metadata will not return valid results in mock scenarios.
   *
   * @param unsupported apiGroup patterns
   */
  public void setUnsupported(String... unsupported) {
    this.unsupportedPatterns = new ArrayList<>(unsupported.length);
    for (int i = 0; i < unsupported.length; i++) {
      String asRegex = unsupported[i].replace(".", "\\.").replace("*", ".*");
      if (!asRegex.contains("/")) {
        asRegex += "(/.*)?";
      }
      asRegex += "$";
      this.unsupportedPatterns.add(Pattern.compile(asRegex));
    }
  }

  /**
   * Removes all recorded expectations.
   */
  public void clearExpectations() {
    responses.clear();
  }

  protected Config getMockConfiguration() {
    return new ConfigBuilder(Config.empty())
        .withMasterUrl(url("/"))
        .withTrustCerts(true)
        .withTlsVersions(TlsVersion.TLS_1_2)
        .withNamespace("test")
        .withHttp2Disable(true)
        .build();
  }

  @Override
  public void reset() {
    clearExpectations();
    onStart();
    unsupportedPatterns.clear();
    if (this.dispatcher instanceof Resetable) {
      ((Resetable) this.dispatcher).reset();
    }
  }
}
