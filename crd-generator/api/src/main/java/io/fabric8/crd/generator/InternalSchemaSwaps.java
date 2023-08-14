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
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class InternalSchemaSwaps {
  // swaps applicable above this point
  private final Map<Key, Value> parentSwaps;
  // swaps applicable to the current context
  private final Map<Key, Value> swaps;
  // current depths of all swaps
  private final Map<Key, Integer> swapDepths;

  public InternalSchemaSwaps() {
    this(new HashMap<>(), new HashMap<>(), new HashMap<>());
  }

  private InternalSchemaSwaps(Map<Key, Value> swaps, Map<Key, Integer> swapDepths, Map<Key, Value> parentSwaps) {
    this.parentSwaps = parentSwaps;
    this.swaps = swaps;
    this.swapDepths = swapDepths;
  }

  public InternalSchemaSwaps branchDepths() {
    InternalSchemaSwaps result = new InternalSchemaSwaps(this.swaps, new HashMap<>(), this.parentSwaps);
    result.swapDepths.putAll(this.swapDepths);
    return result;
  }

  public InternalSchemaSwaps branchAnnotations() {
    Map<Key, Value> combined = new HashMap<>(swaps);
    combined.putAll(parentSwaps);
    return new InternalSchemaSwaps(new HashMap<>(), this.swapDepths, combined);
  }

  public void registerSwap(ClassRef definitionType, ClassRef originalType, String fieldName, ClassRef targetType,
      int depth) {
    Value value = new Value(definitionType, originalType, fieldName, targetType, depth);
    Key key = new Key(originalType, fieldName);
    if (parentSwaps.containsKey(key)) {
      // it's simplest for now to just disallow this
      throw new IllegalArgumentException("Nested SchemaSwap: " + value);
    }
    if (swaps.put(key, value) != null) {
      throw new IllegalArgumentException("Duplicate SchemaSwap: " + value);
    }
  }

  static class SwapResult {
    final ClassRef classRef;
    final boolean onGoing;

    public SwapResult(ClassRef classRef, boolean onGoing) {
      this.classRef = classRef;
      this.onGoing = onGoing;
    }
  }

  public SwapResult lookupAndMark(ClassRef originalType, String name) {
    Key key = new Key(originalType, name);
    Value value = swaps.getOrDefault(key, parentSwaps.get(key));
    if (value != null) {
      int currentDepth = swapDepths.getOrDefault(key, 0);
      swapDepths.put(key, currentDepth + 1);
      value.markUsed();
      if (currentDepth == value.depth) {
        return new SwapResult(value.getTargetType(), false);
      }
      if (currentDepth > value.depth) {
        throw new IllegalStateException("Somthing has gone wrong with tracking swap depths, please raise an issue.");
      }
      return new SwapResult(null, true);
    }
    return new SwapResult(null, false);
  }

  public void throwIfUnmatchedSwaps() {
    String unmatchedSchemaSwaps = swaps.values().stream().filter(value -> !value.used)
        .map(Object::toString)
        .collect(Collectors.joining(", "));
    if (!unmatchedSchemaSwaps.isEmpty()) {
      throw new IllegalArgumentException("Unmatched SchemaSwaps: " + unmatchedSchemaSwaps);
    }
  }

  private static final class Key {
    private final ClassRef originalType;
    private final String fieldName;

    public Key(ClassRef originalType, String fieldName) {
      this.originalType = originalType;
      this.fieldName = fieldName;
    }

    public ClassRef getOriginalType() {
      return originalType;
    }

    public String getFieldName() {
      return fieldName;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Key key = (Key) o;
      return Objects.equals(originalType, key.originalType) && Objects.equals(fieldName, key.fieldName);
    }

    @Override
    public int hashCode() {
      return Objects.hash(originalType, fieldName);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Key.class.getSimpleName() + "[", "]")
          .add("originalType=" + originalType)
          .add("fieldName='" + fieldName + "'")
          .toString();
    }
  }

  private static class Value {
    private final ClassRef originalType;
    private final String fieldName;
    private final ClassRef targetType;
    private boolean used;
    private final ClassRef definitionType;
    private final int depth;

    public Value(ClassRef definitionType, ClassRef originalType, String fieldName, ClassRef targetType, int depth) {
      this.definitionType = definitionType;
      this.originalType = originalType;
      this.fieldName = fieldName;
      this.targetType = targetType;
      this.depth = depth;
      this.used = false;
    }

    private void markUsed() {
      this.used = true;
    }

    public ClassRef getOriginalType() {
      return originalType;
    }

    public String getFieldName() {
      return fieldName;
    }

    public ClassRef getTargetType() {
      return targetType;
    }

    public boolean isUsed() {
      return used;
    }

    @Override
    public String toString() {
      return "@SchemaSwap(originalType=" + originalType + ", fieldName=\"" + fieldName + "\", targetType=" + targetType
          + ") on " + definitionType;
    }
  }
}
