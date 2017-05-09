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

import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.mockwebserver.dsl.MockServerExpectation;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.rules.ExternalResource;

@Deprecated
// The class has moved under mvn:io.fabric8:kubernetes-server-mock in package: io.fabric8.client.server.mock
public class KubernetesServer extends ExternalResource {
  private KubernetesMockServer mock;
  private NamespacedKubernetesClient client;
  private boolean https;

  public KubernetesServer() {
    this(true);
  }

  public KubernetesServer(boolean https) {
    this.https = https;
  }

  public void before() {
    mock = new KubernetesMockServer(https);
    mock.init();
    client = mock.createClient();
  }

  public void after() {
    mock.destroy();
    client.close();
  }

  public NamespacedKubernetesClient getClient() {
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
  @Deprecated
  public <T> void expectAndReturnAsJson(String method, String path, int code, T body) {
    expect().withPath(path).andReturn(code, body).always();
  }
  @Deprecated
  public void expectAndReturnAsString(String method, String path, int code, String body) {
    expect().withPath(path).andReturn(code, body).always();
  }

  public MockWebServer getMockServer() {
    return mock.getServer();
  }
}
