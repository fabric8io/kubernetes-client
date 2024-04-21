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

@SchemaSwap(originalType = DeeplyNestedSchemaSwaps.MyObject.class, fieldName = "shouldBeString", targetType = String.class)
public class DeeplyNestedSchemaSwaps extends CustomResource<DeeplyNestedSchemaSwaps.Spec, Void> {

  public static class Spec {
    public MyObject myObject;
    public Level1 level1;
  }

  private static class Level1 {
    public Level2 level2a;
    public MyObject myObject;
    public Level2 level2b;
  }

  private static class Level2 {
    public MyObject myObject1;
    public Level3 level3;
    public MyObject myObject2;
  }

  private static class Level3 {
    public MyObject myObject1;
    public MyObject myObject2;
  }

  public static class MyObject {
    public int shouldBeString;
  }
}
