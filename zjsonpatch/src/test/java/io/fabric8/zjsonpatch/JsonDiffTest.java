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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JsonDiffTest {
  private static final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  @DisplayName("asJson should use ported ListUtils.longestCommonSubsequence in absence of Apache Commons Collections")
  void asJson_inAbsenceOfCommonsCollectionsDependency_shouldNotThrowError() {
    // Given
    Map<String, String> m1 = Collections.singletonMap("key1", "value1");
    Map<String, String> m2 = new HashMap<>();
    m2.put("key1", "value1");
    m2.put("key2", "value2");
    ArrayNode node1 = objectMapper.createArrayNode();
    node1.add(objectMapper.convertValue(m1, JsonNode.class));
    ArrayNode node2 = objectMapper.createArrayNode();
    node2.add(objectMapper.convertValue(m2, JsonNode.class));

    // When
    JsonNode jsonNode = JsonDiff.asJson(node1, node2);

    // Then
    assertThat(jsonNode)
        .satisfies(j -> assertThat(j.isArray()).isTrue())
        .satisfies(n -> assertThat(n.get(0).get("op").asText()).isEqualTo("add"))
        .satisfies(n -> assertThat(n.get(0).get("path").asText()).isEqualTo("/0/key2"))
        .satisfies(n -> assertThat(n.get(0).get("value").asText()).isEqualTo("value2"))
        .isNotNull();
  }
}
