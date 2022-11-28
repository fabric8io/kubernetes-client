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
package io.fabric8.crd.generator.v1.decorator;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceColumnDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersionFluent;
import io.fabric8.kubernetes.client.utils.Utils;

import java.util.function.Predicate;

public class AddAdditionPrinterColumnDecorator extends
    CustomResourceDefinitionVersionDecorator<CustomResourceDefinitionVersionFluent<?>> {

  private final String type;
  private final String columnName;
  private final String path;
  private final String format;
  private final String description;

  public AddAdditionPrinterColumnDecorator(String name, String version, String type, String columnName, String path,
      String format, String description) {
    super(name, version);
    this.type = type;
    this.columnName = columnName;
    this.path = path;
    this.format = format;
    this.description = description;
  }

  @Override
  public void andThenVisit(CustomResourceDefinitionVersionFluent<?> spec) {
    Predicate<CustomResourceColumnDefinitionBuilder> matchingColumn = col -> col.getName() != null
        && col.getName().equals(columnName) && col.getJsonPath() != null && col.getJsonPath().equals(path);
    spec.removeMatchingFromAdditionalPrinterColumns(matchingColumn);

    spec.addNewAdditionalPrinterColumn()
        .withType(type)
        .withName(columnName)
        .withJsonPath(path)
        .withFormat(Utils.isNotNullOrEmpty(format) ? format : null)
        .withDescription(Utils.isNotNullOrEmpty(description) ? description : null)
        .endAdditionalPrinterColumn();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
    result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
    result = prime * result + ((columnName == null) ? 0 : columnName.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    result = prime * result + ((path == null) ? 0 : path.hashCode());
    result = prime * result + ((format == null) ? 0 : format.hashCode());
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    AddAdditionPrinterColumnDecorator other = (AddAdditionPrinterColumnDecorator) obj;
    if (getName() == null) {
      if (other.getName() != null)
        return false;
    } else if (!getName().equals(other.getName()))
      return false;
    if (getVersion() == null) {
      if (other.getVersion() != null)
        return false;
    } else if (!getVersion().equals(other.getVersion()))
      return false;
    if (description == null) {
      if (other.description != null)
        return false;
    } else if (!description.equals(other.description))
      return false;
    if (format == null) {
      if (other.format != null)
        return false;
    } else if (!format.equals(other.format))
      return false;
    if (columnName == null) {
      if (other.columnName != null)
        return false;
    } else if (!columnName.equals(other.columnName))
      return false;
    if (path == null) {
      if (other.path != null)
        return false;
    } else if (!path.equals(other.path))
      return false;
    if (type == null) {
      if (other.type != null)
        return false;
    } else if (!type.equals(other.type))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return getClass().getName() + " [name:" + getName() + ", version:" + getVersion() + "column:" + columnName + "]";
  }
}
