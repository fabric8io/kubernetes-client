/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client.internal;

import io.fabric8.kubernetes.client.utils.Utils;
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
