package io.javaoperatorsdk.jenvtest.junit.sample;

import org.junit.jupiter.api.Test;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.javaoperatorsdk.jenvtest.junit.EnableKubeAPIServer;
import io.javaoperatorsdk.jenvtest.junit.TestUtils;

class JUnitFabric8ClientInjectPerMethodTest {

  KubernetesClient client;

  @Test
  @EnableKubeAPIServer
  void simpleTest1() {
    TestUtils.simpleTest(client);
  }

  @Test
  @EnableKubeAPIServer
  void simpleTest2() {
    TestUtils.simpleTest(client);
  }
}
