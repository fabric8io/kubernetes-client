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

}
