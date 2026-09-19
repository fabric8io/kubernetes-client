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
package io.fabric8.crdv2.generator.v1;

import io.fabric8.generator.annotation.Max;
import io.fabric8.generator.annotation.Min;
import io.fabric8.generator.annotation.Pattern;
import io.fabric8.generator.annotation.Size;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import lombok.Getter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class JsonSchemaValidationTest {

  @Getter
  private static final class ClassInTest {
    @Min(1)
    @Max(3)
    private Integer integerMin1Max3;

    @Min(value = 1, inclusive = false)
    @Max(value = 3, inclusive = false)
    private Integer integerMinExclusive1MaxExclusive3;

    @Size(min = 1, max = 3)
    private String stringMin1Max3;

    @Size(min = 1, max = 3)
    private List<String> listMin1Max3;

    @Size(min = 1, max = 3)
    private Map<String, String> mapMin1Max3;

    @Size(min = 1, max = 3)
    private NestedPojo pojoWithSize;
  }

  @Getter
  private static final class NestedPojo {
    private String name;
    private int age;
  }

  @Test
  @DisplayName("Min and Max can be combined")
  void integerMin1Max3() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting(props -> props.get("integerMin1Max3"))
        .extracting(JSONSchemaProps::getMinimum)
        .isEqualTo(1.0);

    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting(props -> props.get("integerMin1Max3"))
        .extracting(JSONSchemaProps::getMaximum)
        .isEqualTo(3.0);
  }

  @Test
  @DisplayName("Exclusive Min and exclusive Max can be combined")
  void integerMinExclusive1MaxExclusive3() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting(props -> props.get("integerMinExclusive1MaxExclusive3"))
        .extracting(JSONSchemaProps::getMinimum)
        .isEqualTo(1.0);

    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting(props -> props.get("integerMinExclusive1MaxExclusive3"))
        .extracting(JSONSchemaProps::getExclusiveMinimum)
        .isEqualTo(true);

    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting(props -> props.get("integerMinExclusive1MaxExclusive3"))
        .extracting(JSONSchemaProps::getMaximum)
        .isEqualTo(3.0);

    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting(props -> props.get("integerMinExclusive1MaxExclusive3"))
        .extracting(JSONSchemaProps::getExclusiveMaximum)
        .isEqualTo(true);
  }

  @Test
  @DisplayName("Strings can have size limits")
  void stringMin1Max3() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting(props -> props.get("stringMin1Max3"))
        .extracting(JSONSchemaProps::getMinLength)
        .isEqualTo(1L);

    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting(props -> props.get("stringMin1Max3"))
        .extracting(JSONSchemaProps::getMaxLength)
        .isEqualTo(3L);
  }

  @Test
  @DisplayName("Lists can have size limits")
  void listMin1Max3() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting(props -> props.get("listMin1Max3"))
        .extracting(JSONSchemaProps::getMinItems)
        .isEqualTo(1L);

    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting(props -> props.get("listMin1Max3"))
        .extracting(JSONSchemaProps::getMaxItems)
        .isEqualTo(3L);
  }

  @Test
  @DisplayName("Maps can have size limits")
  void mapMin1Max3() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting(props -> props.get("mapMin1Max3"))
        .extracting(JSONSchemaProps::getMinProperties)
        .isEqualTo(1L);

    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting(props -> props.get("mapMin1Max3"))
        .extracting(JSONSchemaProps::getMaxProperties)
        .isEqualTo(3L);
  }

  @Test
  @DisplayName("POJOs should not have minProperties/maxProperties even with @Size")
  void pojoShouldNotHaveMinMaxProperties() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting(props -> props.get("pojoWithSize"))
        .extracting(JSONSchemaProps::getMinProperties)
        .isNull();

    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting(props -> props.get("pojoWithSize"))
        .extracting(JSONSchemaProps::getMaxProperties)
        .isNull();
  }

  // --- Additional constraint extraction tests ---

  @Getter
  private static final class NumericConstraintsClass {
    @Max(100)
    private Integer maxOnly;

    @Min(5)
    private Integer minOnly;

    @Min(1)
    @Max(10)
    private Double doubleMinMax;
  }

  @Test
  @DisplayName("Numeric constraint with only @Max should have no minimum")
  void numericMaxOnlyShouldHaveNoMinimum() {
    assertThat(JsonSchema.from(NumericConstraintsClass.class).getProperties())
        .extracting(props -> props.get("maxOnly"))
        .satisfies(prop -> {
          assertThat(prop.getMaximum()).isEqualTo(100.0);
          assertThat(prop.getMinimum()).isNull();
        });
  }

  @Test
  @DisplayName("Numeric constraint with only @Min should have no maximum")
  void numericMinOnlyShouldHaveNoMaximum() {
    assertThat(JsonSchema.from(NumericConstraintsClass.class).getProperties())
        .extracting(props -> props.get("minOnly"))
        .satisfies(prop -> {
          assertThat(prop.getMinimum()).isEqualTo(5.0);
          assertThat(prop.getMaximum()).isNull();
        });
  }

  @Test
  @DisplayName("Numeric constraints on Double should work the same as Integer")
  void doubleMinMaxConstraints() {
    assertThat(JsonSchema.from(NumericConstraintsClass.class).getProperties())
        .extracting(props -> props.get("doubleMinMax"))
        .satisfies(prop -> {
          assertThat(prop.getMinimum()).isEqualTo(1.0);
          assertThat(prop.getMaximum()).isEqualTo(10.0);
        });
  }

  @Getter
  private static final class StringConstraintsClass {
    @Pattern("[a-z]+")
    private String patternOnly;

    @Size(min = 5)
    private String minLengthOnly;

    @Size(max = 100)
    private String maxLengthOnly;

    @Pattern("[A-Z]+")
    @Size(min = 1, max = 10)
    private String patternWithSize;
  }

  @Test
  @DisplayName("String with @Pattern only should have pattern but no length constraints")
  void stringPatternOnlyShouldHaveNoLengthConstraints() {
    assertThat(JsonSchema.from(StringConstraintsClass.class).getProperties())
        .extracting(props -> props.get("patternOnly"))
        .satisfies(prop -> {
          assertThat(prop.getPattern()).isEqualTo("[a-z]+");
          assertThat(prop.getMinLength()).isNull();
          assertThat(prop.getMaxLength()).isNull();
        });
  }

  @Test
  @DisplayName("String with @Size(min=5) should have minLength but no maxLength")
  void stringMinLengthOnlyShouldHaveNoMaxLength() {
    assertThat(JsonSchema.from(StringConstraintsClass.class).getProperties())
        .extracting(props -> props.get("minLengthOnly"))
        .satisfies(prop -> {
          assertThat(prop.getMinLength()).isEqualTo(5L);
          assertThat(prop.getMaxLength()).isNull();
        });
  }

  @Test
  @DisplayName("String with @Pattern and @Size should have both pattern and length constraints")
  void stringPatternWithSizeShouldHaveBoth() {
    assertThat(JsonSchema.from(StringConstraintsClass.class).getProperties())
        .extracting(props -> props.get("patternWithSize"))
        .satisfies(prop -> {
          assertThat(prop.getPattern()).isEqualTo("[A-Z]+");
          assertThat(prop.getMinLength()).isEqualTo(1L);
          assertThat(prop.getMaxLength()).isEqualTo(10L);
        });
  }

}
