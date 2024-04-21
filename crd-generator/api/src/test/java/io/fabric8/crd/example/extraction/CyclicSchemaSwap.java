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
package io.fabric8.crd.example.extraction;

import io.fabric8.crd.generator.annotation.SchemaSwap;
import io.fabric8.kubernetes.client.CustomResource;

import java.util.List;

@SchemaSwap(originalType = CyclicSchemaSwap.Level.class, fieldName = "level", depth = 1)
public class CyclicSchemaSwap extends CustomResource<CyclicSchemaSwap.Spec, Void> {

  public static class Spec {
    public MyObject myObject;
    public Level root;
    public List<Level> roots; // should not interfere with the rendering depth of level of its sibling
  }

  public static class Level {
    public MyObject myObject;
    public Level level;
  }

  public static class MyObject {
    public int value;
  }
}
