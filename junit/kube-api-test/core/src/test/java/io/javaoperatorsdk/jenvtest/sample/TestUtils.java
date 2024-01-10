package io.javaoperatorsdk.jenvtest.sample;

import java.util.Map;

import org.assertj.core.api.Assertions;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

public class TestUtils {

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
    client.resource(TestUtils.testConfigMap()).create();
    var cm = client.resource(TestUtils.testConfigMap()).get();

    Assertions.assertThat(cm).isNotNull();

    client.resource(cm).delete();
  }

}
