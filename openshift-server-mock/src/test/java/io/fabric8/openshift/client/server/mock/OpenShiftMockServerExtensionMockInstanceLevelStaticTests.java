package io.fabric8.openshift.client.server.mock;

import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@EnableOpenShiftMockClient(instanceMock = false)
public class OpenShiftMockServerExtensionMockInstanceLevelStaticTests {
  private static OpenShiftMockServer server;
  private static OpenShiftClient client;

  @Test
  public void test() {
    Assertions.assertNotNull(server);
    Assertions.assertNotNull(client);
  }
}
