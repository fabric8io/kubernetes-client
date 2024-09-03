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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JsonDiffTest {

  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    objectMapper = new ObjectMapper();
  }

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

  @Nested
  /*
   * This class is ported from <a href=
   * "https://github.com/flipkart-incubator/zjsonpatch/blob/a446bf598231c06006d4e3df69b846cdb16d8889/src/test/java/com/flipkart/zjsonpatch/JsonDiffTest.java"
   * >FlipKart
   * zjsonpatch repository</a>
   */
  class ZjsondiffTests {

    private ArrayNode jsonNode;

    @BeforeEach
    public void setUp() throws IOException {
      jsonNode = (ArrayNode) objectMapper.readTree(JsonDiffTest.class.getResourceAsStream("/json-diff.json"));
    }

    @Test
    public void testSampleJsonDiff() {
      for (int i = 0; i < jsonNode.size(); i++) {
        JsonNode first = jsonNode.get(i).get("first");
        JsonNode second = jsonNode.get(i).get("second");
        JsonNode actualPatch = JsonDiff.asJson(first, second);
        JsonNode secondPrime = JsonPatch.apply(actualPatch, first);
        assertEquals(second, secondPrime, "JSON Patch not symmetrical [index=" + i + ", first=" + first + "]");
      }
    }

    @Test
    public void testRenderedRemoveOperationOmitsValueByDefault() {
      ObjectNode source = objectMapper.createObjectNode();
      ObjectNode target = objectMapper.createObjectNode();
      source.put("field", "value");

      JsonNode diff = JsonDiff.asJson(source, target);

      assertEquals(Operation.REMOVE.rfcName(), diff.get(0).get("op").textValue());
      assertEquals("/field", diff.get(0).get("path").textValue());
      assertNull(diff.get(0).get("value"));
    }

    @Test
    public void testRenderedRemoveOperationRetainsValueIfOmitDiffFlagNotSet() {
      ObjectNode source = objectMapper.createObjectNode();
      ObjectNode target = objectMapper.createObjectNode();
      source.put("field", "value");

      EnumSet<DiffFlags> flags = DiffFlags.defaults().clone();
      assertTrue(flags.remove(DiffFlags.OMIT_VALUE_ON_REMOVE), "Expected OMIT_VALUE_ON_REMOVE by default");
      JsonNode diff = JsonDiff.asJson(source, target, flags);

      assertEquals(Operation.REMOVE.rfcName(), diff.get(0).get("op").textValue());
      assertEquals("/field", diff.get(0).get("path").textValue());
      assertEquals("value", diff.get(0).get("value").textValue());
    }

    @Test
    public void testRenderedOperationsExceptMoveAndCopy() throws Exception {
      JsonNode source = objectMapper.readTree("{\"age\": 10}");
      JsonNode target = objectMapper.readTree("{\"height\": 10}");

      EnumSet<DiffFlags> flags = DiffFlags.dontNormalizeOpIntoMoveAndCopy().clone(); //only have ADD, REMOVE, REPLACE, Don't normalize operations into MOVE & COPY

      JsonNode diff = JsonDiff.asJson(source, target, flags);

      for (JsonNode d : diff) {
        assertNotEquals(Operation.MOVE.rfcName(), d.get("op").textValue());
        assertNotEquals(Operation.COPY.rfcName(), d.get("op").textValue());
      }

      JsonNode targetPrime = JsonPatch.apply(diff, source);
      assertEquals(target, targetPrime);
    }

    @Test
    public void testPath() throws Exception {
      JsonNode source = objectMapper.readTree("{\"profiles\":{\"abc\":[],\"def\":[{\"hello\":\"world\"}]}}");
      JsonNode patch = objectMapper.readTree(
          "[{\"op\":\"copy\",\"from\":\"/profiles/def/0\", \"path\":\"/profiles/def/0\"},{\"op\":\"replace\",\"path\":\"/profiles/def/0/hello\",\"value\":\"world2\"}]");

      JsonNode target = JsonPatch.apply(patch, source);
      JsonNode expected = objectMapper
          .readTree("{\"profiles\":{\"abc\":[],\"def\":[{\"hello\":\"world2\"},{\"hello\":\"world\"}]}}");
      assertEquals(target, expected);
    }

    @Test
    public void testJsonDiffReturnsEmptyNodeExceptionWhenBothSourceAndTargetNodeIsNull() {
      JsonNode diff = JsonDiff.asJson(null, null);
      assertEquals(0, diff.size());
    }

    @Test
    public void testJsonDiffShowsDiffWhenSourceNodeIsNull() throws JsonProcessingException {
      String target = "{ \"K1\": {\"K2\": \"V1\"} }";
      JsonNode diff = JsonDiff.asJson(null, objectMapper.reader().readTree(target));
      assertEquals(1, diff.size());

      System.out.println(diff);
      assertEquals(Operation.ADD.rfcName(), diff.get(0).get("op").textValue());
      assertEquals(JsonPointer.ROOT.toString(), diff.get(0).get("path").textValue());
      assertEquals("V1", diff.get(0).get("value").get("K1").get("K2").textValue());
    }

    @Test
    public void testJsonDiffShowsDiffWhenTargetNodeIsNullWithFlags() throws JsonProcessingException {
      String source = "{ \"K1\": \"V1\" }";
      JsonNode sourceNode = objectMapper.reader().readTree(source);
      JsonNode diff = JsonDiff.asJson(sourceNode, null, EnumSet.of(DiffFlags.ADD_ORIGINAL_VALUE_ON_REPLACE));

      assertEquals(1, diff.size());
      assertEquals(Operation.REMOVE.rfcName(), diff.get(0).get("op").textValue());
      assertEquals(JsonPointer.ROOT.toString(), diff.get(0).get("path").textValue());
      assertEquals("V1", diff.get(0).get("value").get("K1").textValue());
    }
  }
}
