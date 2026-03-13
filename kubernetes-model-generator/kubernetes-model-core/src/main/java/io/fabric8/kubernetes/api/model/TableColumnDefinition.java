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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * TableColumnDefinition contains information about a column returned in the Table.
 */
@JsonDeserialize
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "type",
    "format",
    "description",
    "priority"
})
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TableColumnDefinition {

  /** name is a human readable name for the column. */
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

  /** description is a human-readable description of the column. */
  @JsonProperty("description")
  private String description;

  /**
   * priority is an integer defining the relative importance of this column compared to others.
   * Lower numbers are considered higher priority. Columns that may be omitted in limited space
   * scenarios should be given a priority greater than 0.
   */
  @JsonProperty("priority")
  private int priority;

}