package io.fabric8.kubeapitest.sample;

import org.junit.jupiter.api.Test;

import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubeapitest.junit.KubeConfig;

import static io.fabric8.kubeapitest.sample.TestUtils.simpleTest;

/**
 * Shows usage for the case when fresh Kube API is started for each use test method.
 */
class JUnitExtensionOnMethodTest {

  // not static in case if API server is restarted for each test
  @KubeConfig
  String kubeConfigYaml;

  @Test
  @EnableKubeAPIServer
  void simpleTest1() {
    TestUtils.simpleTest(kubeConfigYaml);
  }

  @Test
  @EnableKubeAPIServer
  void simpleTest2() {
    TestUtils.simpleTest(kubeConfigYaml);
  }
}
