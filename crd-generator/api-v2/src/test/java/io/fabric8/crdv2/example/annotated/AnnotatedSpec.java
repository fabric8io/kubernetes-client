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
package io.fabric8.crdv2.example.annotated;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.fabric8.generator.annotation.Default;
import io.fabric8.generator.annotation.Max;
import io.fabric8.generator.annotation.Min;
import io.fabric8.generator.annotation.Nullable;
import io.fabric8.generator.annotation.Pattern;
import io.fabric8.generator.annotation.Required;
import io.fabric8.generator.annotation.ValidationRule;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@Data
public class AnnotatedSpec {
  @JsonProperty("from-field")
  @JsonPropertyDescription("from-field-description")
  private String field;
  private int foo;
  @JsonProperty
  private String unnamed;
  private int min;
  private int max;
  private String singleDigit;
  private String nullable;
  private String defaultValue;
  @Default("my-value2")
  private String defaultValue2;
  @Required
  private boolean emptySetter;
  @Required
  private boolean emptySetter2;
  private AnnotatedEnum anEnum;
  @javax.validation.constraints.Min(0) // a non-string value attribute
  private int sizedField;
  private String bool;
  private String num;
  private String numInt;
  private String numFloat;
  private ZonedDateTime issuedAt;

  private List<@Pattern("[a-z].*") String> typeAnnotationCollection;
  private Map<String, @Min(1) @Max(255) Integer> typeAnnotationMap;

  @JsonIgnore
  private int ignoredFoo;

  private boolean ignoredBar;

  @ValidationRule(value = "self.startwith('prefix-')", message = "kubernetesValidationRule must start with prefix 'prefix-'")
  private String kubernetesValidationRule;

  @ValidationRule("first.rule")
  @ValidationRule("second.rule")
  @ValidationRule(value = "third.rule", reason = "FieldValueForbidden")
  private String kubernetesValidationRules;

  @JsonProperty("from-getter")
  @JsonPropertyDescription("from-getter-description")
  @Required
  public int getFoo() {
    return foo;
  }

  public int getIgnoredFoo() {
    return ignoredFoo;
  }

  @JsonIgnore
  public boolean getIgnoredBar() {
    return ignoredBar;
  }

  @Max(5.0)
  public int getMax() {
    return 1;
  }

  @Min(-5)
  public int getMin() {
    return 1;
  }

  @Pattern("\\b[1-9]\\b")
  public String getSingleDigit() {
    return "1";
  }

  @Nullable
  public String getNullable() {
    return null;
  }

  @Default("my-value")
  public String getDefaultValue() {
    return "foo";
  }

  @JsonProperty
  public void setEmptySetter(boolean emptySetter) {
    this.emptySetter = emptySetter;
  }

  @JsonProperty
  public void setEmptySetter2(boolean emptySetter2) {
    this.emptySetter2 = emptySetter2;
  }

  @JsonFormat(shape = JsonFormat.Shape.BOOLEAN)
  public String getBool() {
    return bool;
  }

  @JsonFormat(shape = JsonFormat.Shape.NUMBER)
  public String getNum() {
    return num;
  }

  @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
  public String getNumFloat() {
    return numFloat;
  }

  @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
  public String getNumInt() {
    return numInt;
  }

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
  public java.time.ZonedDateTime getIssuedAt() {
    return issuedAt;
  }

  public enum AnnotatedEnum {
    non("N"),
    @JsonProperty("oui")
    es("O"),
    @JsonProperty("foo")
    @JsonIgnore
    Maybe("Maybe");

    private final String abbreviation;

    AnnotatedEnum(String abbreviation) {
      this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
      return abbreviation;
    }

    public static AnnotatedEnum SIM = es;

    public AnotherEnum one = AnotherEnum.ONE;

    public AnotherEnum getOne() {
      return one;
    }

    public void setOne(AnotherEnum one) {
      this.one = one;
    }
  }

  public enum AnotherEnum {
    ONE
  }
}
