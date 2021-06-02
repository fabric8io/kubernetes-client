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
package io.fabric8.kubernetes.jsonschema2pojo;

import org.junit.jupiter.api.Test;

import static io.fabric8.kubernetes.jsonschema2pojo.Fabric8NameHelper.correctCamelCaseMethodNameIfInvalid;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Fabric8NameHelperTest {
  @Test
  void testCorrectCamelCaseMethodNameIfInvalidWithVariableWithSingleLetterDash() {
    assertEquals("getXField", correctCamelCaseMethodNameIfInvalid("get", "x-field", "getxField"));
    assertEquals("setXField", correctCamelCaseMethodNameIfInvalid("set", "x-field", "setxField"));
  }

  @Test
  void testCorrectCamelCaseMethodNameIfInvalidWithFormatSingleLetterCamelCase() {
    assertEquals("getSFlow", correctCamelCaseMethodNameIfInvalid("get", "sFlow", "getsFlow"));
    assertEquals("setSFlow", correctCamelCaseMethodNameIfInvalid("set", "sFlow", "setsFlow"));
  }


  @Test
  void testCorrectCamelCaseMethodNameIfInvalidWithStandardVariableShouldDoNothing() {
    assertEquals("getIpfix", correctCamelCaseMethodNameIfInvalid("get", "ipfix", "getIpfix"));
    assertEquals("setIpfix", correctCamelCaseMethodNameIfInvalid("set", "ipfix", "setIpfix"));

    assertEquals("getNetFlow", correctCamelCaseMethodNameIfInvalid("get", "netFlow", "getNetFlow"));
    assertEquals("setNetFlow", correctCamelCaseMethodNameIfInvalid("set", "netFlow", "setNetFlow"));
  }
}
