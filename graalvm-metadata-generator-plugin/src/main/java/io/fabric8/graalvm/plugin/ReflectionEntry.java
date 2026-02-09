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
package io.fabric8.graalvm.plugin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Represents a single entry in GraalVM's reflect-config.json file.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReflectionEntry {

  @JsonProperty("condition")
  private Condition condition;

  @JsonProperty("name")
  private String name;

  @JsonProperty("allDeclaredConstructors")
  private Boolean allDeclaredConstructors;

  @JsonProperty("allDeclaredMethods")
  private Boolean allDeclaredMethods;

  @JsonProperty("allDeclaredFields")
  private Boolean allDeclaredFields;

  /**
   * Nested class representing the condition for reflection metadata.
   */
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Condition {
    @JsonProperty("typeReachable")
    private String typeReachable;

    public Condition() {
    }

    public Condition(String typeReachable) {
      this.typeReachable = typeReachable;
    }

    public String getTypeReachable() {
      return typeReachable;
    }

    public void setTypeReachable(String typeReachable) {
      this.typeReachable = typeReachable;
    }
  }

  public ReflectionEntry() {
  }

  public ReflectionEntry(String name) {
    this.name = name;
  }

  public Condition getCondition() {
    return condition;
  }

  public void setCondition(Condition condition) {
    this.condition = condition;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getAllDeclaredConstructors() {
    return allDeclaredConstructors;
  }

  public void setAllDeclaredConstructors(Boolean allDeclaredConstructors) {
    this.allDeclaredConstructors = allDeclaredConstructors;
  }

  public Boolean getAllDeclaredMethods() {
    return allDeclaredMethods;
  }

  public void setAllDeclaredMethods(Boolean allDeclaredMethods) {
    this.allDeclaredMethods = allDeclaredMethods;
  }

  public Boolean getAllDeclaredFields() {
    return allDeclaredFields;
  }

  public void setAllDeclaredFields(Boolean allDeclaredFields) {
    this.allDeclaredFields = allDeclaredFields;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    ReflectionEntry that = (ReflectionEntry) o;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "ReflectionEntry{" +
        "name='" + name + '\'' +
        ", allDeclaredConstructors=" + allDeclaredConstructors +
        ", allDeclaredMethods=" + allDeclaredMethods +
        ", allDeclaredFields=" + allDeclaredFields +
        '}';
  }
}
