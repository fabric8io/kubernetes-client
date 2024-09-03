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
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperationsTest {

  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    objectMapper = new ObjectMapper();
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "/operations-add.json",
      "/operations-copy.json",
      "/operations-move.json",
      "/operations-remove.json",
      "/operations-replace.json",
      "/operations-test.json"
  })
  public void testPatchAppliedCleanly(String operationData) throws Exception {
    final ArrayNode jsonNode = (ArrayNode) objectMapper
        .readTree(OperationsTest.class.getResourceAsStream(operationData))
        .get("ops");
    for (int i = 0; i < jsonNode.size(); i++) {
      JsonNode first = jsonNode.get(i).get("node");
      JsonNode second = jsonNode.get(i).get("expected");
      JsonNode patch = jsonNode.get(i).get("op");
      JsonNode secondPrime = JsonPatch.apply(patch, first);
      assertThat(secondPrime).isEqualTo(second);
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "/operations-add.json",
      "/operations-copy.json",
      "/operations-move.json",
      "/operations-remove.json",
      "/operations-replace.json",
      "/operations-test.json"
  })
  public void testErrorsAreCorrectlyReported(String operationData) throws Exception {
    final ArrayNode errorNode = (ArrayNode) objectMapper
        .readTree(OperationsTest.class.getResourceAsStream(operationData))
        .get("errors");
    for (int i = 0; i < errorNode.size(); i++) {
      JsonNode first = errorNode.get(i).get("node");
      JsonNode patch = errorNode.get(i).get("op");
      assertThatThrownBy(() -> JsonPatch.apply(patch, first))
          .isInstanceOf(JsonPatchException.class)
          .extracting(Objects::toString).asString()
          .contains(errorNode.get(i).get("message").asText());
    }
  }
}
