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
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class InternalSchemaSwaps {
  private final Map<Key, Value> swaps = new HashMap<>();

  public void registerSwap(ClassRef definitionType, ClassRef originalType, String fieldName, ClassRef targetType) {
    Value value = new Value(definitionType, originalType, fieldName, targetType);
    swaps.put(new Key(originalType, fieldName), value);
  }

  public Optional<ClassRef> lookupAndMark(ClassRef originalType, String name) {
    Value value = swaps.get(new Key(originalType, name));
    if (value != null) {
      value.markUsed();
      return Optional.of(value.getTargetType());
    } else {
      return Optional.empty();
    }
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

    public Value(ClassRef definitionType, ClassRef originalType, String fieldName, ClassRef targetType) {
      this.definitionType = definitionType;
      this.originalType = originalType;
      this.fieldName = fieldName;
      this.targetType = targetType;
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
