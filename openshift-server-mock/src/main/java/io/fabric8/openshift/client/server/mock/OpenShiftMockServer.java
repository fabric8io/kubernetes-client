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

import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftConfig;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;

import java.util.Map;
import java.util.Queue;

import static io.fabric8.kubernetes.client.utils.HttpClientUtils.createHttpClientForMockServer;

public class OpenShiftMockServer extends KubernetesMockServer {
  private boolean disableApiGroupCheck = true;

  public OpenShiftMockServer() {
    super();
  }

  public OpenShiftMockServer(boolean useHttps) {
    super(useHttps);
  }

  public OpenShiftMockServer(Context context, MockWebServer server, Map<ServerRequest, Queue<ServerResponse>> responses, Dispatcher dispatcher, boolean useHttps) {
    super(context, server, responses, dispatcher, useHttps);
  }

  @Override
  public String[] getRootPaths() {
    return new String[]{"/api","/oapi"};
  }

  public NamespacedOpenShiftClient createOpenShiftClient() {
    OpenShiftConfig config = OpenShiftConfig.wrap(getMockConfiguration());
    config.setDisableApiGroupCheck(disableApiGroupCheck);
    return new DefaultOpenShiftClient(createHttpClientForMockServer(config), config);
  }

  public boolean isDisableApiGroupCheck() {
    return disableApiGroupCheck;
  }

  public void setDisableApiGroupCheck(boolean disableApiGroupCheck) {
    this.disableApiGroupCheck = disableApiGroupCheck;
  }
}
