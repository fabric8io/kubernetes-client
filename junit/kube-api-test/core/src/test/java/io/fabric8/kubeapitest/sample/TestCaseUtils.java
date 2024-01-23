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

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.assertj.core.api.Assertions;

import java.util.Map;

public class TestCaseUtils {

  /**
   * Used in multiple tests so no multiple additional binaries are downloaded, therefore increases
   * duration of tests.
   **/
  public static final String NON_LATEST_API_SERVER_VERSION = "1.26.0";

  public static ConfigMap testConfigMap() {
    return new ConfigMapBuilder()
        .withMetadata(new ObjectMetaBuilder()
            .withName("test1")
            .withNamespace("default")
            .build())
        .withData(Map.of("key", "data"))
        .build();
  }

  public static void simpleTest(String kubeConfigYaml) {
    simpleTest(
        new KubernetesClientBuilder().withConfig(Config.fromKubeconfig(kubeConfigYaml)).build());
  }

  public static void simpleTest() {
    simpleTest(new KubernetesClientBuilder().build());
  }

  public static void simpleTest(KubernetesClient client) {
    client.resource(TestCaseUtils.testConfigMap()).create();
    var cm = client.resource(TestCaseUtils.testConfigMap()).get();

    Assertions.assertThat(cm).isNotNull();

    client.resource(cm).delete();
  }

}
