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

package io.fabric8.kubeapitest.junit;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.assertj.core.api.Assertions;

import java.util.Map;

public class TestUtils {

  public static final String TEST_1 = "test1";

  public static ConfigMap testConfigMap() {
    return testConfigMap(TEST_1);
  }

  public static ConfigMap testConfigMap(String name) {
    return new ConfigMapBuilder()
        .withMetadata(new ObjectMetaBuilder()
            .withName(name)
            .withNamespace("default")
            .build())
        .withData(Map.of("key", "data"))
        .build();
  }

  public static void simpleTest() {
    simpleTest(new KubernetesClientBuilder().build(), "test1");
  }

  public static void simpleTest(KubernetesClient client) {
    simpleTest(client, TEST_1);
  }

  public static void simpleTest(KubernetesClient client, String testResourceName) {
    client.resource(TestUtils.testConfigMap(testResourceName)).create();
    var cm = client.resource(TestUtils.testConfigMap(testResourceName)).get();

    Assertions.assertThat(cm).isNotNull();

    client.resource(cm).delete();
  }

}
