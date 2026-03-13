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

import java.util.List;

/**
 * Table is a tabular representation of a set of API resources. The server transforms the object
 * into a set of preferred columns for quickly reviewing the resources.
 * <p>
 * This is used with the {@code Accept: application/json;as=Table;v=v1;g=meta.k8s.io} header.
 */
@JsonDeserialize
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "columnDefinitions",
    "rows"
})
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Table implements KubernetesResource {

  @JsonProperty("apiVersion")
  private String apiVersion;

  @JsonProperty("kind")
  private String kind;

  @JsonProperty("metadata")
  private ListMeta metadata;

  /** columnDefinitions describes each column in the returned items array. */
  @JsonProperty("columnDefinitions")
  private List<TableColumnDefinition> columnDefinitions;

  /** rows is the list of items in the table. */
  @JsonProperty("rows")
  private List<TableRow> rows;

}