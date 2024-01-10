package io.javaoperatorsdk.jenvtest.sample;

import org.junit.jupiter.api.Test;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.javaoperatorsdk.jenvtest.junit.EnableKubeAPIServer;
import io.javaoperatorsdk.jenvtest.junit.KubeConfig;

import static io.javaoperatorsdk.jenvtest.sample.TestUtils.simpleTest;

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
