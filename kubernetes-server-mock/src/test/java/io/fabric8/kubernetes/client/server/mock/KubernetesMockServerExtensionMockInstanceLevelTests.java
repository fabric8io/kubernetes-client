package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class KubernetesMockServerExtensionMockInstanceLevelTests {

  // when "instanceMock = false", server and client are not mocked
  @Nested
  @EnableKubernetesMockClient(instanceMock = false)
  class InstanceLevelFalse {
    private KubernetesMockServer server;
    private KubernetesClient client;

    @Test
    public void test() {
      Assertions.assertNull(server);
      Assertions.assertNull(client);
    }
  }

  // when "instanceMock = true", server and client are mocked
  @Nested
  @EnableKubernetesMockClient(instanceMock = true)
  class InstanceLevelTrue {
    private KubernetesMockServer server;
    private KubernetesClient client;

    @Test
    public void test() {
      Assertions.assertNotNull(server);
      Assertions.assertNotNull(client);
    }
  }

}
