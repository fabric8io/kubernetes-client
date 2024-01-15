package io.fabric8.kubeapitest.sample;

import org.junit.jupiter.api.Test;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubeapitest.junit.KubeConfig;

import static io.fabric8.kubeapitest.sample.TestUtils.simpleTest;

@EnableKubeAPIServer
class JUnitExtensionSimpleCaseTest {

  // static is required in case the config is shared between test cases
  @KubeConfig
  static String kubeConfigYaml;

  @Test
  void simpleTestWithTargetVersion() {
    var client = new KubernetesClientBuilder()
        .withConfig(Config.fromKubeconfig(kubeConfigYaml))
        .build();

    simpleTest(client);
  }
}
