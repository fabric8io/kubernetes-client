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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesCrudDispatcher;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.mockwebserver.dsl.MockServerExpectation;
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import io.fabric8.openshift.client.OpenshiftAdapterSupport;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.rules.ExternalResource;

import java.util.HashMap;
import java.util.Queue;

public class OpenShiftServer extends ExternalResource {

  protected OpenShiftMockServer mock;
  private NamespacedOpenShiftClient client;

  private boolean https;
  private boolean curdMode;

  public OpenShiftServer() {
    this(true, false);
  }

  public OpenShiftServer(boolean https) {
    this(https, false);
  }

  public OpenShiftServer(boolean https, boolean curdMode) {
    this.https = https;
    this.curdMode = curdMode;
  }

  public void before() {
    mock = curdMode
      ? new OpenShiftMockServer(new Context(), new MockWebServer(), new HashMap<ServerRequest, Queue<ServerResponse>>(), new KubernetesCrudDispatcher(), true)
      : new OpenShiftMockServer(https);
    mock.init();
    client = mock.createOpenShiftClient();
  }

  public void after() {
    mock.destroy();
    client.close();
  }


  public KubernetesClient getKubernetesClient() {
    return client;
  }

  public NamespacedOpenShiftClient getOpenshiftClient() {
    return client;
  }

  public MockServerExpectation expect() {
    return mock.expect();
  }

  @Deprecated
  public <T> void expectAndReturnAsJson(String path, int code, T body) {
    expect().withPath(path).andReturn(code, body).always();
  }

  @Deprecated
  public void expectAndReturnAsString(String path, int code, String body) {
    expect().withPath(path).andReturn(code, body).always();
  }

  public MockWebServer getMockServer() {
    return mock.getServer();
  }

  public RecordedRequest getLastRequest() throws InterruptedException {
    int count = mock.getServer().getRequestCount();
    RecordedRequest request = null;
    while (count-- > 0) {
      request = mock.getServer().takeRequest();
    }
    return request;
  }
}
