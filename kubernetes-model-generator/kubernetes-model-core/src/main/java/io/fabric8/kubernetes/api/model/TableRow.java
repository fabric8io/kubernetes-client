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
import io.fabric8.kubernetes.api.model.runtime.RawExtension;

import java.util.List;

/**
 * TableRow is an individual row in a Table.
 */
@JsonDeserialize
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "cells", "object" })
public class TableRow {
  /**
   * cells will be as wide as the column definitions array and may contain strings, numbers,
   * booleans, or null values to match the column definition's type.
   */
  @JsonProperty("cells")
  private List<Object> cells;
  /**
   * object is the resource this row represents. It may be set when the server is asked to include
   * the object via the {@code includeObject} query parameter.
   */
  @JsonProperty("object")
  private RawExtension object;

  /**
   * cells will be as wide as the column definitions array and may contain strings, numbers,
   * booleans, or null values to match the column definition's type.
   */
  public List<Object> getCells() {
    return this.cells;
  }

  /**
   * object is the resource this row represents. It may be set when the server is asked to include
   * the object via the {@code includeObject} query parameter.
   */
  public RawExtension getObject() {
    return this.object;
  }

  /**
   * cells will be as wide as the column definitions array and may contain strings, numbers,
   * booleans, or null values to match the column definition's type.
   */
  public void setCells(final List<Object> cells) {
    this.cells = cells;
  }

  /**
   * object is the resource this row represents. It may be set when the server is asked to include
   * the object via the {@code includeObject} query parameter.
   */
  public void setObject(final RawExtension object) {
    this.object = object;
  }

  @java.lang.Override
  public java.lang.String toString() {
    return "TableRow(cells=" + this.getCells() + ", object=" + this.getObject() + ")";
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object o) {
    if (o == this)
      return true;
    if (!(o instanceof TableRow))
      return false;
    final TableRow other = (TableRow) o;
    if (!other.canEqual((java.lang.Object) this))
      return false;
    final java.lang.Object this$cells = this.getCells();
    final java.lang.Object other$cells = other.getCells();
    if (this$cells == null ? other$cells != null : !this$cells.equals(other$cells))
      return false;
    final java.lang.Object this$object = this.getObject();
    final java.lang.Object other$object = other.getObject();
    if (this$object == null ? other$object != null : !this$object.equals(other$object))
      return false;
    return true;
  }

  protected boolean canEqual(final java.lang.Object other) {
    return other instanceof TableRow;
  }

  @java.lang.Override
  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final java.lang.Object $cells = this.getCells();
    result = result * PRIME + ($cells == null ? 43 : $cells.hashCode());
    final java.lang.Object $object = this.getObject();
    result = result * PRIME + ($object == null ? 43 : $object.hashCode());
    return result;
  }
}
