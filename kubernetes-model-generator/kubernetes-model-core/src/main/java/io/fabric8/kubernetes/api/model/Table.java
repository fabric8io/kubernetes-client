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
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;

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
@JsonPropertyOrder({ "apiVersion", "kind", "metadata", "columnDefinitions", "rows" })
@Group("meta.k8s.io")
@Version("v1")
public class Table implements KubernetesResource {
  @JsonProperty("apiVersion")
  private String apiVersion;
  @JsonProperty("kind")
  private String kind;
  @JsonProperty("metadata")
  private ListMeta metadata;
  /**
   * columnDefinitions describes each column in the returned items array.
   */
  @JsonProperty("columnDefinitions")
  private List<TableColumnDefinition> columnDefinitions;
  /**
   * rows is the list of items in the table.
   */
  @JsonProperty("rows")
  private List<TableRow> rows;

  public String getApiVersion() {
    return this.apiVersion;
  }

  public String getKind() {
    return this.kind;
  }

  public ListMeta getMetadata() {
    return this.metadata;
  }

  /**
   * columnDefinitions describes each column in the returned items array.
   */
  public List<TableColumnDefinition> getColumnDefinitions() {
    return this.columnDefinitions;
  }

  /**
   * rows is the list of items in the table.
   */
  public List<TableRow> getRows() {
    return this.rows;
  }

  public void setApiVersion(final String apiVersion) {
    this.apiVersion = apiVersion;
  }

  public void setKind(final String kind) {
    this.kind = kind;
  }

  public void setMetadata(final ListMeta metadata) {
    this.metadata = metadata;
  }

  /**
   * columnDefinitions describes each column in the returned items array.
   */
  public void setColumnDefinitions(final List<TableColumnDefinition> columnDefinitions) {
    this.columnDefinitions = columnDefinitions;
  }

  /**
   * rows is the list of items in the table.
   */
  public void setRows(final List<TableRow> rows) {
    this.rows = rows;
  }

  @java.lang.Override
  public java.lang.String toString() {
    return "Table(apiVersion=" + this.getApiVersion() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata()
        + ", columnDefinitions=" + this.getColumnDefinitions() + ", rows=" + this.getRows() + ")";
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Table))
      return false;
    final Table other = (Table) o;
    if (!other.canEqual((java.lang.Object) this))
      return false;
    final java.lang.Object this$apiVersion = this.getApiVersion();
    final java.lang.Object other$apiVersion = other.getApiVersion();
    if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion))
      return false;
    final java.lang.Object this$kind = this.getKind();
    final java.lang.Object other$kind = other.getKind();
    if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind))
      return false;
    final java.lang.Object this$metadata = this.getMetadata();
    final java.lang.Object other$metadata = other.getMetadata();
    if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata))
      return false;
    final java.lang.Object this$columnDefinitions = this.getColumnDefinitions();
    final java.lang.Object other$columnDefinitions = other.getColumnDefinitions();
    if (this$columnDefinitions == null ? other$columnDefinitions != null
        : !this$columnDefinitions.equals(other$columnDefinitions))
      return false;
    final java.lang.Object this$rows = this.getRows();
    final java.lang.Object other$rows = other.getRows();
    if (this$rows == null ? other$rows != null : !this$rows.equals(other$rows))
      return false;
    return true;
  }

  protected boolean canEqual(final java.lang.Object other) {
    return other instanceof Table;
  }

  @java.lang.Override
  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final java.lang.Object $apiVersion = this.getApiVersion();
    result = result * PRIME + ($apiVersion == null ? 43 : $apiVersion.hashCode());
    final java.lang.Object $kind = this.getKind();
    result = result * PRIME + ($kind == null ? 43 : $kind.hashCode());
    final java.lang.Object $metadata = this.getMetadata();
    result = result * PRIME + ($metadata == null ? 43 : $metadata.hashCode());
    final java.lang.Object $columnDefinitions = this.getColumnDefinitions();
    result = result * PRIME + ($columnDefinitions == null ? 43 : $columnDefinitions.hashCode());
    final java.lang.Object $rows = this.getRows();
    result = result * PRIME + ($rows == null ? 43 : $rows.hashCode());
    return result;
  }
}
