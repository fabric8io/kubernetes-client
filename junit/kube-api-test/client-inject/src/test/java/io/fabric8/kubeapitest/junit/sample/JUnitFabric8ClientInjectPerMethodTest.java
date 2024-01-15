package io.fabric8.kubeapitest.junit.sample;

import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubeapitest.junit.TestUtils;
import org.junit.jupiter.api.Test;

import io.fabric8.kubernetes.client.KubernetesClient;

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
