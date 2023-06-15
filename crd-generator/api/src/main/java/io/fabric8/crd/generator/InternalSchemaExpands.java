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
package io.fabric8.crd.generator;

import io.sundr.model.ClassRef;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class InternalSchemaExpands {
  private final Map<ClassRef, Value> terminalTypes;
  private final Map<ClassRef, Integer> replacementDepths = new HashMap<>();

  public InternalSchemaExpands() {
    this(new HashMap<>());
  }

  private InternalSchemaExpands(Map<ClassRef, Value> terminalTypes) {
    this.terminalTypes = terminalTypes;
  }

  public InternalSchemaExpands branchDepths() {
    InternalSchemaExpands result = new InternalSchemaExpands(this.terminalTypes);
    result.replacementDepths.putAll(this.replacementDepths);
    return result;
  }

  public void registerReplacement(ClassRef definitionType, ClassRef originalType, ClassRef terminalType,
      int depth) {
    Value value = new Value(definitionType, originalType, terminalType, depth);
    terminalTypes.put(originalType, value);
  }

  public ClassRef lookupAndMark(ClassRef originalType, Runnable swapApplicableAction) {
    Value value = terminalTypes.get(originalType);
    if (value != null) {
      swapApplicableAction.run();
      int depth = replacementDepths.compute(originalType, (k, v) -> {
        if (v == null) {
          return 1;
        }
        return v + 1;
      });
      value.used = true;
      if (depth > value.depth) {
        return value.terminalType;
      }
    }
    return null;
  }

  public void throwIfUnmatchedReplacements() {
    String unmatchedSchemaSwaps = terminalTypes.values().stream().filter(value -> !value.used)
        .map(Object::toString)
        .collect(Collectors.joining(", "));
    if (!unmatchedSchemaSwaps.isEmpty()) {
      throw new IllegalArgumentException("Unmatched SchemaExpands: " + unmatchedSchemaSwaps);
    }
  }

  private static class Value {
    private final ClassRef originalType;
    private final ClassRef terminalType;
    private boolean used;
    private final ClassRef definitionType;
    private final int depth;

    public Value(ClassRef definitionType, ClassRef originalType, ClassRef terminalType, int cycleDepth) {
      this.definitionType = definitionType;
      this.originalType = originalType;
      this.terminalType = terminalType;
      this.depth = cycleDepth;
      this.used = false;
    }

    @Override
    public String toString() {
      return "@SchemaSwap(originalType=" + originalType + ", depth=\"" + depth + "\", terminalType=" + terminalType
          + ") on " + definitionType;
    }
  }
}
