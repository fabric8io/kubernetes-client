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

package io.fabric8.openshift.server.mock;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.server.mock.KubernetesMockServer;
import io.fabric8.openshift.client.OpenShiftClient;

public class OpenShiftMockServer extends KubernetesMockServer {

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

  public OpenShiftClient createOpenShiftClient() {
    Config config = new ConfigBuilder()
      .withMasterUrl(getServer().getUrl("/").toString())
      .withNamespace("test")
      .withTrustCerts(true)
      .build();
    return new DefaultKubernetesClient(config).adapt(OpenShiftClient.class);
  }
}
