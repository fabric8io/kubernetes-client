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
package io.fabric8.crd.example.annotated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.fabric8.crd.generator.annotation.constraints.Nullable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AnnotatedSpec {
  @JsonProperty("from-field")
  @JsonPropertyDescription("from-field-description")
  private String field;
  private int foo;
  private int min;
  private int max;
  private String singleDigit;
  private String nullable;
  @JsonProperty
  private String unnamed;
  @NotNull
  private boolean emptySetter;
  private AnnotatedEnum anEnum;
  @Min(0) // a non-string value attribute
  private int sizedField;

  @JsonIgnore
  private int ignoredFoo;

  private boolean ignoredBar;

  @JsonProperty("from-getter")
  @JsonPropertyDescription("from-getter-description")
  @NotNull
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

  @JsonProperty
  public void setEmptySetter(boolean emptySetter) {
    this.emptySetter = emptySetter;
  }

  public enum AnnotatedEnum {
    non,
    @JsonProperty("oui")
    Yes
  }

  @Max(5)
  public int getMax() {
    return 1;
  }

  @Min(-5)
  public int getMin() {
    return 1;
  }

  @Pattern(regexp = "\\b[1-9]\\b")
  public String getSingleDigit() {
    return "1";
  }

  @Nullable
  public String getNullable() {
    return null;
  }

}
