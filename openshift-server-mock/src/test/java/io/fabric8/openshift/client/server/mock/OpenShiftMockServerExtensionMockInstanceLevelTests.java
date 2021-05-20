package io.fabric8.openshift.client.server.mock;

import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class OpenShiftMockServerExtensionMockInstanceLevelTests {
  // when "instanceMock = false", server and client are not mocked
  @Nested
  @EnableOpenShiftMockClient(instanceMock = false)
  class InstanceLevelFalse {
    private OpenShiftMockServer server;
    private OpenShiftClient client;

    @Test
    public void test() {
      Assertions.assertNull(server);
      Assertions.assertNull(client);
    }
  }

  // when "instanceMock = true", server and client are mocked
  @Nested
  @EnableOpenShiftMockClient(instanceMock = true)
  class InstanceLevelTrue {
    private OpenShiftMockServer server;
    private OpenShiftClient client;

    @Test
    public void test() {
      Assertions.assertNotNull(server);
      Assertions.assertNotNull(client);
    }
  }
}
