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

package io.fabric8.kubeapitest.junit.sample;

import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubeapitest.junit.KubeConfig;
import io.fabric8.kubeapitest.junit.TestCaseUtils;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.junit.jupiter.api.Test;

@EnableKubeAPIServer
class JUnitFabric8ClientInjectionTest {

  static KubernetesClient client;

  // config yaml injection also works
  @KubeConfig
  static String configYaml;

  @Test
  void testClientInjection() {
    TestCaseUtils.simpleTest(client, "test1");
  }

  @Test
  void testKubeConfigInjectionAlsoWorks() {
    TestCaseUtils.simpleTest(new KubernetesClientBuilder().withConfig(Config.fromKubeconfig(configYaml)).build(),
        "test2");
  }
}
