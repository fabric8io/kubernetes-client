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

import io.fabric8.kubernetes.api.model.APIResource;
import io.fabric8.kubernetes.api.model.APIResourceBuilder;
import io.fabric8.kubernetes.api.model.APIResourceList;
import io.fabric8.kubernetes.api.model.APIResourceListBuilder;
import io.fabric8.kubernetes.api.model.RootPathsBuilder;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.fabric8.kubernetes.client.impl.BaseClient;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.DefaultMockServer;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.mockwebserver.internal.MockDispatcher;
import io.fabric8.servicecatalog.client.DefaultServiceCatalogClient;
import io.fabric8.servicecatalog.client.NamespacedServiceCatalogClient;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.regex.Pattern;

public class KubernetesMockServer extends DefaultMockServer implements Resetable, CustomResourceAware {

  private final Map<ServerRequest, Queue<ServerResponse>> responses;
  private final Dispatcher dispatcher;
  private VersionInfo versionInfo;
  private List<Pattern> unsupportedPatterns;

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
    unsupportedPatterns = Collections.emptyList();
  }

  @Override
  public void onStart() {
    expect().get().withPath("/").andReturn(200, new RootPathsBuilder().addToPaths(getRootPaths()).build()).always();
    expect().get().withPath("/version").andReply(200, request -> versionInfo).always();
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
   * Replace the current {@link VersionInfo} instance.
   *
   * @param versionInfo the new VersionInfo.
   */
  public final void setVersionInfo(VersionInfo versionInfo) {
    this.versionInfo = Objects.requireNonNull(versionInfo);
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

  public NamespacedServiceCatalogClient createServiceCatalog() {
    Config config = this.getMockConfiguration();
    return new DefaultServiceCatalogClient(config);
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

  /**
   * Ensure that the server will supply an {@link APIResourceList} containing an {@link APIResource}
   * representing the {@link CustomResourceDefinitionContext} from the apis/group/version endpoint.
   * <p>
   * This is useful when testing calls through the {@link KubernetesClient#genericKubernetesResources(String, String)}
   * entry point.
   * <p>
   * If this is a crud server, the custom resource will be added to the set of previously added resources
   * and the resources inferred from custom resource definitions that have been added.
   * <p>
   * If this server is not crud, this call will add a single expectation for the given resource. Direct handling of
   * multiple resources for a given api group/version has not yet been added.
   *
   * @param rdc the resource definition context
   */
  @Override
  public void expectCustomResource(CustomResourceDefinitionContext rdc) {
    if (this.dispatcher instanceof CustomResourceAware) {
      ((CustomResourceAware) this.dispatcher).expectCustomResource(rdc);
    } else {
      expect()
          .get()
          .withPath(String.format("/apis/%s/%s", rdc.getGroup(), rdc.getVersion()))
          .andReturn(HttpURLConnection.HTTP_OK,
              new APIResourceListBuilder()
                  .withResources(
                      new APIResourceBuilder().withKind(rdc.getKind())
                          .withNamespaced(rdc.isNamespaceScoped())
                          .withName(rdc.getPlural())
                          .build())
                  .withGroupVersion(ApiVersionUtil.joinApiGroupAndVersion(rdc.getGroup(), rdc.getVersion()))
                  .build())
          .once();
    }
  }
}
