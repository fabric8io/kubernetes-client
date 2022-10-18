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
package io.fabric8.java.generator.nodes;

public class JPrimitiveNameAndType extends JavaNameAndType {
  static final JPrimitiveNameAndType INT_OR_STRING = new JPrimitiveNameAndType("io.fabric8.kubernetes.api.model.IntOrString");
  static final JPrimitiveNameAndType BOOL = new JPrimitiveNameAndType("Boolean");
  static final JPrimitiveNameAndType INTEGER = new JPrimitiveNameAndType("Integer");
  static final JPrimitiveNameAndType LONG = new JPrimitiveNameAndType("Long");
  static final JPrimitiveNameAndType FLOAT = new JPrimitiveNameAndType("Float");
  static final JPrimitiveNameAndType DOUBLE = new JPrimitiveNameAndType("Double");
  static final JPrimitiveNameAndType STRING = new JPrimitiveNameAndType("String");
  static final JPrimitiveNameAndType ANY_TYPE = new JPrimitiveNameAndType("io.fabric8.kubernetes.api.model.AnyType");

  public JPrimitiveNameAndType(String name) {
    super(name, JavaType.PRIMITIVE);
  }
}
