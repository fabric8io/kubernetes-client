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
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.OpenShiftConfigBuilder;

import static okhttp3.TlsVersion.TLS_1_0;

public class OpenShiftMockServer extends KubernetesMockServer {
  private boolean disableApiGroupCheck = true;

  public OpenShiftMockServer() {
    super();
  }

  public OpenShiftMockServer(boolean useHttps) {
    super(useHttps);
  }

  @Override
  public String[] getRootPaths() {
    return new String[]{"/api","/oapi"};
  }

  public NamespacedOpenShiftClient createOpenShiftClient() {
    OpenShiftConfig config = new OpenShiftConfigBuilder()
      .withMasterUrl(url("/"))
      .withNamespace("test")
      .withTrustCerts(true)
      .withTlsVersions(TLS_1_0)
      .withDisableApiGroupCheck(disableApiGroupCheck)
      .build();
    return new DefaultOpenShiftClient(config);
  }

  public boolean isDisableApiGroupCheck() {
    return disableApiGroupCheck;
  }

  public void setDisableApiGroupCheck(boolean disableApiGroupCheck) {
    this.disableApiGroupCheck = disableApiGroupCheck;
  }
}
