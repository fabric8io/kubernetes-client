package io.fabric8.kubeapitest.junit;

import java.util.Map;

import org.assertj.core.api.Assertions;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

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
