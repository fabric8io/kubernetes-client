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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * TableColumnDefinition contains information about a column returned in the Table.
 */
@JsonDeserialize
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "type", "format", "description", "priority" })
public class TableColumnDefinition {
  /**
   * name is a human readable name for the column.
   */
  @JsonProperty("name")
  private String name;
  /**
   * type is an OpenAPI type definition for this column, such as "string", "integer",
   * "number", "boolean", "object", or "array".
   */
  @JsonProperty("type")
  private String type;
  /**
   * format is an optional OpenAPI type modifier for this column. A format modifies the type
   * and imposes additional rules, like "date-time" or "int64".
   */
  @JsonProperty("format")
  private String format;
  /**
   * description is a human-readable description of the column.
   */
  @JsonProperty("description")
  private String description;
  /**
   * priority is an integer defining the relative importance of this column compared to others.
   * Priority 0 columns are shown in the default view (equivalent to {@code kubectl get}); columns
   * with a priority greater than 0 are wide-only columns shown with {@code kubectl get -o wide}
   * and may be omitted in limited-space scenarios.
   */
  @JsonProperty("priority")
  private Integer priority;

  /**
   * name is a human readable name for the column.
   */
  public String getName() {
    return this.name;
  }

  /**
   * type is an OpenAPI type definition for this column, such as "string", "integer",
   * "number", "boolean", "object", or "array".
   */
  public String getType() {
    return this.type;
  }

  /**
   * format is an optional OpenAPI type modifier for this column. A format modifies the type
   * and imposes additional rules, like "date-time" or "int64".
   */
  public String getFormat() {
    return this.format;
  }

  /**
   * description is a human-readable description of the column.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * priority is an integer defining the relative importance of this column compared to others.
   * Priority 0 columns are shown in the default view (equivalent to {@code kubectl get}); columns
   * with a priority greater than 0 are wide-only columns shown with {@code kubectl get -o wide}
   * and may be omitted in limited-space scenarios.
   */
  public Integer getPriority() {
    return this.priority;
  }

  /**
   * name is a human readable name for the column.
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * type is an OpenAPI type definition for this column, such as "string", "integer",
   * "number", "boolean", "object", or "array".
   */
  public void setType(final String type) {
    this.type = type;
  }

  /**
   * format is an optional OpenAPI type modifier for this column. A format modifies the type
   * and imposes additional rules, like "date-time" or "int64".
   */
  public void setFormat(final String format) {
    this.format = format;
  }

  /**
   * description is a human-readable description of the column.
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * priority is an integer defining the relative importance of this column compared to others.
   * Priority 0 columns are shown in the default view (equivalent to {@code kubectl get}); columns
   * with a priority greater than 0 are wide-only columns shown with {@code kubectl get -o wide}
   * and may be omitted in limited-space scenarios.
   */
  public void setPriority(final Integer priority) {
    this.priority = priority;
  }

  @java.lang.Override
  public java.lang.String toString() {
    return "TableColumnDefinition(name=" + this.getName() + ", type=" + this.getType() + ", format=" + this.getFormat()
        + ", description=" + this.getDescription() + ", priority=" + this.getPriority() + ")";
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object o) {
    if (o == this)
      return true;
    if (!(o instanceof TableColumnDefinition))
      return false;
    final TableColumnDefinition other = (TableColumnDefinition) o;
    if (!other.canEqual((java.lang.Object) this))
      return false;
    final java.lang.Object this$priority = this.getPriority();
    final java.lang.Object other$priority = other.getPriority();
    if (this$priority == null ? other$priority != null : !this$priority.equals(other$priority))
      return false;
    final java.lang.Object this$name = this.getName();
    final java.lang.Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name))
      return false;
    final java.lang.Object this$type = this.getType();
    final java.lang.Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type))
      return false;
    final java.lang.Object this$format = this.getFormat();
    final java.lang.Object other$format = other.getFormat();
    if (this$format == null ? other$format != null : !this$format.equals(other$format))
      return false;
    final java.lang.Object this$description = this.getDescription();
    final java.lang.Object other$description = other.getDescription();
    if (this$description == null ? other$description != null : !this$description.equals(other$description))
      return false;
    return true;
  }

  protected boolean canEqual(final java.lang.Object other) {
    return other instanceof TableColumnDefinition;
  }

  @java.lang.Override
  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final java.lang.Object $priority = this.getPriority();
    result = result * PRIME + ($priority == null ? 43 : $priority.hashCode());
    final java.lang.Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final java.lang.Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    final java.lang.Object $format = this.getFormat();
    result = result * PRIME + ($format == null ? 43 : $format.hashCode());
    final java.lang.Object $description = this.getDescription();
    result = result * PRIME + ($description == null ? 43 : $description.hashCode());
    return result;
  }
}
