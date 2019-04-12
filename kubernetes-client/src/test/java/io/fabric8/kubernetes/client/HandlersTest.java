package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.client.handlers.DeploymentHandler;
import org.junit.Assert;
import org.junit.Test;


public class HandlersTest {
  @Test
  public void testUnregister() {
    DeploymentHandler h = new DeploymentHandler();

    Handlers.unregister(h);

    // Pass class loader because we dont need load handler by ServiceLoader
    Assert.assertNull(Handlers.get(h.getKind(), h.getApiVersion(), ClassLoader.getSystemClassLoader().getParent()));
  }

  @Test
  public void testRegister() {
    DeploymentHandler h = new DeploymentHandler();

    Handlers.unregister(h);
    Handlers.register(h);

    Assert.assertSame(h, Handlers.get(h.getKind(), h.getApiVersion()));
  }
}
