package io.javaoperatorsdk.jenvtest.sample;

import org.junit.jupiter.api.Test;

import io.javaoperatorsdk.jenvtest.junit.EnableKubeAPIServer;
import io.javaoperatorsdk.jenvtest.junit.KubeConfig;

import static io.javaoperatorsdk.jenvtest.sample.TestUtils.simpleTest;

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
