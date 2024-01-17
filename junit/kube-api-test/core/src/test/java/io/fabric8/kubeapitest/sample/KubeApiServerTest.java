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

package io.fabric8.kubeapitest.sample;

import io.fabric8.kubeapitest.KubeAPIServer;
import io.fabric8.kubeapitest.KubeAPIServerConfigBuilder;
import io.fabric8.kubeapitest.KubeAPITestException;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.junit.jupiter.api.Test;

import static io.fabric8.kubeapitest.sample.TestUtils.simpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KubeApiServerTest {

  @Test
  void trivialCase() {
    testWithAPIServer(new KubeAPIServer());
  }

  @Test
  void apiServerWithSpecificVersion() {
    testWithAPIServer(new KubeAPIServer(KubeAPIServerConfigBuilder.anAPIServerConfig()
        .withApiServerVersion(TestUtils.NON_LATEST_API_SERVER_VERSION)
        .build()));
  }

  @Test
  void canWaitForEtcdHealthCheckOnStartup() {
    var kubeApi = new KubeAPIServer(KubeAPIServerConfigBuilder.anAPIServerConfig()
        .withWaitForEtcdHealthCheckOnStartup(true)
        .build());
    kubeApi.start();

    var client = createClient(kubeApi.getKubeConfigYaml());
    TestUtils.simpleTest(client);

    kubeApi.stop();
  }

  @Test
  void usingWildcardVersion() {
    var kubeApi = new KubeAPIServer(KubeAPIServerConfigBuilder.anAPIServerConfig()
        .withApiServerVersion("1.26.*")
        .build());
    kubeApi.start();

    var client = createClient(kubeApi.getKubeConfigYaml());
    TestUtils.simpleTest(client);
    assertThat(client.getKubernetesVersion().getMinor()).isEqualTo("26");

    kubeApi.stop();
  }

  @Test
  void creatingClientFromConfigString() {
    var kubeApi = new KubeAPIServer(KubeAPIServerConfigBuilder.anAPIServerConfig()
        .withUpdateKubeConfig(false)
        .build());
    kubeApi.start();

    var client = createClient(kubeApi.getKubeConfigYaml());
    TestUtils.simpleTest(client);

    kubeApi.stop();
  }

  @Test
  void canSetStartupTimeout() {
    var kubeApi = new KubeAPIServer(KubeAPIServerConfigBuilder.anAPIServerConfig()
        .withStartupTimeout(500)
        .build());
    assertThrows(KubeAPITestException.class, kubeApi::start);
  }

  void testWithAPIServer(KubeAPIServer kubeApi) {
    kubeApi.start();
    var client = createClient(kubeApi.getKubeConfigYaml());
    simpleTest(client);
    kubeApi.stop();
  }

  KubernetesClient createClient(String yaml) {
    return new KubernetesClientBuilder().withConfig(Config.fromKubeconfig(yaml)).build();
  }

}
