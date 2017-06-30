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
import io.fabric8.openshift.client.OpenshiftAdapterSupport;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.rules.ExternalResource;

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
    // lets eagerly force the loading of the supported <code>/apis</code>  on the cluster
    // so that we can then remove and ignore the REST API invocation to avoid
    // breaking test cases with the <code>/apis</code> request
    if (!new OpenshiftAdapterSupport().isAdaptable(client)) {
      throw new IllegalArgumentException("Client does not support OpenShift!");
    }

    // now lets remove the REST request to access the apis to avoid breaking tests :)
    try {
      mock.takeRequest();
    } catch (InterruptedException e) {
      // ignore
    }
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
