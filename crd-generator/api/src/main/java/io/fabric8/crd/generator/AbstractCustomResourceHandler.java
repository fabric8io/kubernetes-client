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
package io.fabric8.crd.generator;

import io.fabric8.crd.generator.AbstractJsonSchema.AnnotationMetadata;
import io.fabric8.crd.generator.annotation.PrinterColumn;
import io.fabric8.crd.generator.decorator.Decorator;
import io.fabric8.kubernetes.client.utils.Utils;

import java.util.Map;

/**
 * This class encapsulates the common behavior between v1beta1 and v1 CRD generation logic. The
 * intent is that each CRD spec version is implemented as a sub-class of this one.
 */
public abstract class AbstractCustomResourceHandler {

  protected final Resources resources;

  protected AbstractCustomResourceHandler(Resources resources) {
    this.resources = resources;
  }

  public abstract void handle(CustomResourceInfo config);

  protected void handlePrinterColumns(String name, String version, Map<String, AnnotationMetadata> additionalPrinterColumns) {
    additionalPrinterColumns.forEach((path, property) -> {
      PrinterColumn printerColumn = ((PrinterColumn)property.annotation);
      String column = printerColumn.name();
      if (Utils.isNullOrEmpty(column)) {
        column = path.substring(path.lastIndexOf("."));
      }
      String format = printerColumn.format();
      int priority = printerColumn.priority();

      // TODO: add description to the annotation? The previous logic considered the comments, which are not available here
      String description = property.description;

      resources.decorate(
          getPrinterColumnDecorator(name, version, path, property.type, column, description, format, priority));
    });
  }

  /**
   * Provides the decorator implementation associated with the CRD generation version.
   *
   * @param name the resource name
   * @param version the associated version
   * @param path the path from which the printer column is extracted
   * @param type the data type of the printer column
   * @param column the name of the column
   * @param description the description of the column
   * @param format the format of the printer column
   * @return the concrete decorator implementing the addition of a printer column to the currently built CRD
   */
  protected abstract Decorator<?> getPrinterColumnDecorator(String name, String version, String path,
      String type, String column, String description, String format, int priority);

}
