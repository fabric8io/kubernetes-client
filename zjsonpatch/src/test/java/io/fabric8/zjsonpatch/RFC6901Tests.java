/*
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
package io.fabric8.zjsonpatch;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class is ported from <a href=
 * "https://github.com/flipkart-incubator/zjsonpatch/blob/a446bf598231c06006d4e3df69b846cdb16d8889/src/test/java/com/flipkart/zjsonpatch/RFC6901Tests.java">FlipKart
 * zjsonpatch repository</a>
 */
class RFC6901Tests {

  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    objectMapper = new ObjectMapper();
  }

  @Test
  void testRFC6901Compliance() throws IOException {
    JsonNode data = objectMapper.readTree(RFC6901Tests.class.getResourceAsStream("/rfc6901.json"));
    JsonNode testData = data.get("testData");

    ObjectNode emptyJson = objectMapper.createObjectNode();
    JsonNode patch = JsonDiff.asJson(emptyJson, testData);
    JsonNode result = JsonPatch.apply(patch, emptyJson);
    assertEquals(testData, result);
  }
}
