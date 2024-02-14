/*
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

import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubeapitest.junit.KubeConfig;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.junit.jupiter.api.Test;

import static io.fabric8.kubeapitest.sample.TestCaseUtils.simpleTest;
import static org.assertj.core.api.Assertions.assertThat;

@EnableKubeAPIServer(kubeAPIVersion = TestCaseUtils.NON_LATEST_API_SERVER_VERSION)
class JUnitExtensionTargetVersionTest {

  @KubeConfig
  static String kubeConfigYaml;

  @Test
  void simpleTestWithTargetVersion() {
    var client = new KubernetesClientBuilder().withConfig(Config.fromKubeconfig(kubeConfigYaml)).build();

    simpleTest(client);

    String kubeVersion = client.getKubernetesVersion().getGitVersion().substring(1);
    assertThat(kubeVersion).isEqualTo(TestCaseUtils.NON_LATEST_API_SERVER_VERSION);
  }

}
