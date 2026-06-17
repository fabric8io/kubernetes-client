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
package io.fabric8.crd.generator.approvaltests.described;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Test spec for @JsonClassDescription support.
 */
@Data
@JsonClassDescription("This is a spec-class-level description.")
public class DescribedSpec {

  @JsonPropertyDescription("This is a field-level description.")
  private String field;

  private Nested nested;

  // A field-level description takes precedence over the referenced type's class-level description.
  @JsonPropertyDescription("This is a field-level description that overrides the class-level one.")
  private DeeplyNested overridden;

  // The class-level description is inherited from the superclass when the subclass does not declare one.
  private InheritingChild inheriting;

  // An object-typed field with neither a class- nor a field-level description emits no description.
  private Plain plain;

  @Data
  @JsonClassDescription("This is a nested-class-level description.")
  public static class Nested {

    @JsonPropertyDescription("This is a nested-field-level description.")
    private String nestedField;

    private DeeplyNested deeplyNested;
  }

  @Data
  @JsonClassDescription("This is a deeply-nested-class-level description.")
  public static class DeeplyNested {

    @JsonPropertyDescription("This is a leaf-field-level description.")
    private String leafField;
  }

  @Data
  @JsonClassDescription("This is an inherited base-class-level description.")
  public static class InheritingBase {

    @JsonPropertyDescription("This is a base-field-level description.")
    private String baseField;
  }

  @Data
  @EqualsAndHashCode(callSuper = true)
  public static class InheritingChild extends InheritingBase {

    @JsonPropertyDescription("This is a child-field-level description.")
    private String childField;
  }

  @Data
  public static class Plain {

    private String plainField;
  }
}
