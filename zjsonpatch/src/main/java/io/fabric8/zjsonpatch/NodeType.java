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

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.EnumMap;
import java.util.Map;

/**
 * This class is ported from <a href=
 * "https://github.com/flipkart-incubator/zjsonpatch/blob/a446bf598231c06006d4e3df69b846cdb16d8889/src/main/java/com/flipkart/zjsonpatch/NodeType.java#L25">FlipKart
 * JSONPatch repository</a>
 */
enum NodeType {
  /**
   * Array nodes
   */
  ARRAY("array"),
  /**
   * Boolean nodes
   */
  BOOLEAN("boolean"),
  /**
   * Integer nodes
   */
  INTEGER("integer"),
  /**
   * Number nodes (ie, decimal numbers)
   */
  NULL("null"),
  /**
   * Object nodes
   */
  NUMBER("number"),
  /**
   * Null nodes
   */
  OBJECT("object"),
  /**
   * String nodes
   */
  STRING("string");

  /**
   * The name for this type, as encountered in a JSON schema
   */
  private final String name;

  private static final Map<JsonToken, NodeType> TOKEN_MAP = new EnumMap<>(JsonToken.class);

  static {
    TOKEN_MAP.put(JsonToken.START_ARRAY, ARRAY);
    TOKEN_MAP.put(JsonToken.VALUE_TRUE, BOOLEAN);
    TOKEN_MAP.put(JsonToken.VALUE_FALSE, BOOLEAN);
    TOKEN_MAP.put(JsonToken.VALUE_NUMBER_INT, INTEGER);
    TOKEN_MAP.put(JsonToken.VALUE_NUMBER_FLOAT, NUMBER);
    TOKEN_MAP.put(JsonToken.VALUE_NULL, NULL);
    TOKEN_MAP.put(JsonToken.START_OBJECT, OBJECT);
    TOKEN_MAP.put(JsonToken.VALUE_STRING, STRING);

  }

  NodeType(final String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  public static NodeType getNodeType(final JsonNode node) {
    final JsonToken token = node.asToken();
    final NodeType ret = TOKEN_MAP.get(token);
    if (ret == null)
      throw new NullPointerException("unhandled token type " + token);
    return ret;
  }
}
