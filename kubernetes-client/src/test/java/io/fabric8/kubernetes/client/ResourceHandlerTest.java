package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.client.ResourceHandler.Key;
import org.junit.Assert;
import org.junit.Test;


public class ResourceHandlerTest {

  @Test
  public void testKeyString() {
    Key k = new Key("deployment", "apps/v1");
    Assert.assertEquals("Key[kind=`deployment`, apiVersion=`apps/v1`]", k.toString());
  }

  @Test
  public void testKeyHashCode() {
    Key k1 = new Key("deployment", "apps/v1");
    Key k2 = new Key("deployment", "apps/v1");
    Assert.assertEquals(k1.hashCode(), k2.hashCode());
  }

  @Test
  public void testKeyEquals() {
    Key k1 = new Key("deployment", "apps/v1");
    Key k2 = new Key("deployment", "apps/v1");
    Assert.assertEquals(k1, k2);

    k1 = new Key("deployment", "apps/v1");
    k2 = new Key("other", "apps/v1");
    Assert.assertNotEquals(k1, k2);

    k1 = new Key("deployment", "apps/v1");
    k2 = new Key("deployment", "other");
    Assert.assertNotEquals(k1, k2);
  }

}
