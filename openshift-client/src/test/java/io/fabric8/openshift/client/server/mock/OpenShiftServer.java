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
import io.fabric8.mockwebserver.dsl.MockServerExpectation;
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.rules.ExternalResource;

@Deprecated
// The class has moved under mvn:io.fabric8:openshift-server-mock in package: io.fabric8.openshift.client.server.mock
public class OpenShiftServer extends ExternalResource {
  protected OpenShiftMockServer mock = new OpenShiftMockServer();
  private NamespacedOpenShiftClient client;

  public void before() {
    mock.init();
    client = mock.createOpenShiftClient();
  }

  public void after() {
    client.close();
    mock.destroy();
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
}
