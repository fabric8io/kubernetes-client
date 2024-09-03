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
import com.fasterxml.jackson.databind.node.NullNode;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * This class is ported from <a href=
 * "https://github.com/flipkart-incubator/zjsonpatch/blob/a446bf598231c06006d4e3df69b846cdb16d8889/src/main/java/com/flipkart/zjsonpatch/JsonPatch.java">FlipKart
 * zjsonpatch repository</a>
 */
public class JsonPatch {

  private static final String OP = "op";
  public static final String VALUE = "value";
  private static final String PATH = "path";
  public static final String FROM = "from";

  private JsonPatch() {
  }

  private static JsonNode getPatchStringAttr(JsonNode jsonNode, String attr) {
    JsonNode child = getPatchAttr(jsonNode, attr);

    if (!child.isTextual()) {
      throw new JsonPatchException("Invalid JSON Patch payload (non-text '" + attr + "' field)");
    }

    return child;
  }

  private static JsonNode getPatchAttr(JsonNode jsonNode, String attr) {
    JsonNode child = jsonNode.get(attr);
    if (child == null)
      throw new JsonPatchException("Invalid JSON Patch payload (missing '" + attr + "' field)");

    return child;
  }

  private static JsonNode getPatchAttrWithDefault(JsonNode jsonNode, String attr, JsonNode defaultValue) {
    JsonNode child = jsonNode.get(attr);
    if (child == null)
      return defaultValue;
    else
      return child;
  }

  private static void process(JsonNode patch, JsonPatchProcessor processor, EnumSet<CompatibilityFlags> flags) {

    if (!patch.isArray()) {
      throw new JsonPatchException("Invalid JSON Patch payload (not an array)");
    }
    Iterator<JsonNode> operations = patch.iterator();
    while (operations.hasNext()) {
      JsonNode jsonNode = operations.next();
      if (!jsonNode.isObject()) {
        throw new JsonPatchException("Invalid JSON Patch payload (not an object)");
      }
      Operation operation = Operation.fromRfcName(getPatchStringAttr(jsonNode, OP).textValue());
      JsonPointer path = JsonPointer.parse(getPatchStringAttr(jsonNode, PATH).textValue());

      try {
        switch (operation) {
          case REMOVE: {
            processor.remove(path);
            break;
          }

          case ADD: {
            JsonNode value;
            if (!flags.contains(CompatibilityFlags.MISSING_VALUES_AS_NULLS))
              value = getPatchAttr(jsonNode, VALUE);
            else
              value = getPatchAttrWithDefault(jsonNode, VALUE, NullNode.getInstance());
            processor.add(path, value.deepCopy());
            break;
          }

          case REPLACE: {
            JsonNode value;
            if (!flags.contains(CompatibilityFlags.MISSING_VALUES_AS_NULLS))
              value = getPatchAttr(jsonNode, VALUE);
            else
              value = getPatchAttrWithDefault(jsonNode, VALUE, NullNode.getInstance());
            processor.replace(path, value.deepCopy());
            break;
          }

          case MOVE: {
            JsonPointer fromPath = JsonPointer.parse(getPatchStringAttr(jsonNode, FROM).textValue());
            processor.move(fromPath, path);
            break;
          }

          case COPY: {
            JsonPointer fromPath = JsonPointer.parse(getPatchStringAttr(jsonNode, FROM).textValue());
            processor.copy(fromPath, path);
            break;
          }

          case TEST: {
            JsonNode value;
            if (!flags.contains(CompatibilityFlags.MISSING_VALUES_AS_NULLS))
              value = getPatchAttr(jsonNode, VALUE);
            else
              value = getPatchAttrWithDefault(jsonNode, VALUE, NullNode.getInstance());
            processor.test(path, value.deepCopy());
            break;
          }
        }
      } catch (JsonPointerEvaluationException e) {
        throw new JsonPatchException(e.getMessage(), operation, e.getPath());
      }
    }
  }

  public static JsonNode apply(JsonNode patch, JsonNode source, EnumSet<CompatibilityFlags> flags) {
    CopyingApplyProcessor processor = new CopyingApplyProcessor(source, flags);
    process(patch, processor, flags);
    return processor.result();
  }

  public static JsonNode apply(JsonNode patch, JsonNode source) {
    return apply(patch, source, CompatibilityFlags.defaults());
  }

}
