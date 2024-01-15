package io.fabric8.kubeapitest.sample;

import org.junit.jupiter.api.Test;

import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;

import static io.fabric8.kubeapitest.sample.TestUtils.simpleTest;

@EnableKubeAPIServer(updateKubeConfigFile = true)
class JUnitExtensionKubeConfigUpdateTest {

  @Test
  void usesConfigFromGenericKubeConfig() {
    TestUtils.simpleTest();
  }
}
