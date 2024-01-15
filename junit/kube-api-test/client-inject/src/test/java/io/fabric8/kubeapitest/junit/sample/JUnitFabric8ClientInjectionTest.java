package io.fabric8.kubeapitest.junit.sample;

import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubeapitest.junit.KubeConfig;
import io.fabric8.kubeapitest.junit.TestUtils;
import org.junit.jupiter.api.Test;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

@EnableKubeAPIServer
class JUnitFabric8ClientInjectionTest {

  static KubernetesClient client;

  // config yaml injection also works
  @KubeConfig
  static String configYaml;

  @Test
  void testClientInjection() {
    TestUtils.simpleTest(client, "test1");
  }

  @Test
  void testKubeConfigInjectionAlsoWorks() {
    TestUtils.simpleTest(new KubernetesClientBuilder().withConfig(Config.fromKubeconfig(configYaml)).build(),
        "test2");
  }
}
