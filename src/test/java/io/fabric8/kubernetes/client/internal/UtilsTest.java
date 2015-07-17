package io.fabric8.kubernetes.client.internal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UtilsTest {

  @Test
  public void existingSysPropShouldReturnValue() {
    System.setProperty("something", "value");
    assertEquals("value", Utils.getSystemPropertyOrEnvVar("something"));
    System.getProperties().remove("something");
  }

  @Test
  public void missingSysPropAndEnvVarShouldReturnNull() {
    assertNull(Utils.getSystemPropertyOrEnvVar("doesn't exist"));
  }

  @Test
  public void existingEnvVarShouldReturnValue() {
    assertEquals("value", Utils.getSystemPropertyOrEnvVar("ENV_VAR_EXISTS"));
  }

  @Test
  public void existingEnvVarShouldReturnValueFromConvertedSysPropName() {
    assertEquals("value", Utils.getSystemPropertyOrEnvVar("env.var.exists"));
  }

  @Test
  public void existingEnvVarShouldReturnBooleanValueFromConvertedSysPropName() {
    assertEquals(true, Utils.getSystemPropertyOrEnvVar("env.var.exists.boolean", false));
  }

  @Test
  public void missingEnvVarShouldReturnDefaultValue() {
    assertEquals(true, Utils.getSystemPropertyOrEnvVar("DONT_EXIST", true));
  }

}
