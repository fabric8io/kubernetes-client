package io.javaoperatorsdk.jenvtest.sample;

import org.junit.jupiter.api.Test;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.javaoperatorsdk.jenvtest.junit.EnableKubeAPIServer;
import io.javaoperatorsdk.jenvtest.junit.KubeConfig;

import static io.javaoperatorsdk.jenvtest.sample.TestUtils.simpleTest;
import static org.assertj.core.api.Assertions.assertThat;

@EnableKubeAPIServer(kubeAPIVersion = TestUtils.NON_LATEST_API_SERVER_VERSION)
class JUnitExtensionTargetVersionTest {

  @KubeConfig
  static String kubeConfigYaml;

  @Test
  void simpleTestWithTargetVersion() {
    var client =
        new KubernetesClientBuilder().withConfig(Config.fromKubeconfig(kubeConfigYaml)).build();

    simpleTest(client);

    String kubeVersion = client.getKubernetesVersion().getGitVersion().substring(1);
    assertThat(kubeVersion).isEqualTo(TestUtils.NON_LATEST_API_SERVER_VERSION);
  }

}
