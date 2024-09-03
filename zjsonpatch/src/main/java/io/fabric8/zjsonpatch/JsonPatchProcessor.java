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

/**
 * This class is ported from <a href=
 * "https://github.com/flipkart-incubator/zjsonpatch/blob/a446bf598231c06006d4e3df69b846cdb16d8889/src/main/java/com/flipkart/zjsonpatch/JsonPatchProcessor.java">FlipKart
 * zjsonpatch repository</a>
 */
public interface JsonPatchProcessor {
  void remove(JsonPointer path) throws JsonPointerEvaluationException;

  void replace(JsonPointer path, JsonNode value) throws JsonPointerEvaluationException;

  void add(JsonPointer path, JsonNode value) throws JsonPointerEvaluationException;

  void move(JsonPointer fromPath, JsonPointer toPath) throws JsonPointerEvaluationException;

  void copy(JsonPointer fromPath, JsonPointer toPath) throws JsonPointerEvaluationException;

  void test(JsonPointer path, JsonNode value) throws JsonPointerEvaluationException;
}
