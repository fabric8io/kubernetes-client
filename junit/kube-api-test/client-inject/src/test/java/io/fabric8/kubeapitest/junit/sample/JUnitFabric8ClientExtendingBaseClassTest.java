package io.fabric8.kubeapitest.junit.sample;

import io.fabric8.kubeapitest.junit.TestCaseUtils;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.junit.jupiter.api.Test;

public class JUnitFabric8ClientExtendingBaseClassTest extends BaseTestClass {

  @Test
  void testClientInjection() {
    TestCaseUtils.simpleTest(client, "test1");
  }

  @Test
  void testKubeConfigInjectionAlsoWorks() {
    TestCaseUtils.simpleTest(new KubernetesClientBuilder().withConfig(Config.fromKubeconfig(configYaml)).build(),
        "test2");
  }

}
