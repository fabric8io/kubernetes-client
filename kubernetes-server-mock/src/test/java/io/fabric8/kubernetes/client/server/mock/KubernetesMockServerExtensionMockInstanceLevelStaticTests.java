package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@EnableKubernetesMockClient(instanceMock = false)
public class KubernetesMockServerExtensionMockInstanceLevelStaticTests {

  private static KubernetesMockServer server;
  private static KubernetesClient client;

  @Test
  public void test() {
    Assertions.assertNotNull(server);
    Assertions.assertNotNull(client);
  }
}
