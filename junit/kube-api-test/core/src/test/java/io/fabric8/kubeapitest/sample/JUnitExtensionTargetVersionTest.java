package io.fabric8.kubeapitest.sample;

import org.junit.jupiter.api.Test;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubeapitest.junit.KubeConfig;

import static io.fabric8.kubeapitest.sample.TestUtils.simpleTest;
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
