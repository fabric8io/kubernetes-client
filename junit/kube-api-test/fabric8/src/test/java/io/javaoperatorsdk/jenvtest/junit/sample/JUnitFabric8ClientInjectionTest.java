package io.javaoperatorsdk.jenvtest.junit.sample;

import org.junit.jupiter.api.Test;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.javaoperatorsdk.jenvtest.junit.EnableKubeAPIServer;
import io.javaoperatorsdk.jenvtest.junit.KubeConfig;

import static io.javaoperatorsdk.jenvtest.junit.TestUtils.simpleTest;

@EnableKubeAPIServer
class JUnitFabric8ClientInjectionTest {

  static KubernetesClient client;

  // config yaml injection also works
  @KubeConfig
  static String configYaml;

  @Test
  void testClientInjection() {
    simpleTest(client, "test1");
  }

  @Test
  void testKubeConfigInjectionAlsoWorks() {
    simpleTest(new KubernetesClientBuilder().withConfig(Config.fromKubeconfig(configYaml)).build(),
        "test2");
  }
}
