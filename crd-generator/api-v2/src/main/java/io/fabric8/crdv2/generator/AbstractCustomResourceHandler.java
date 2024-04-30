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
package io.fabric8.crdv2.generator;

import io.fabric8.crd.generator.annotation.PrinterColumn;
import io.fabric8.crdv2.generator.AbstractJsonSchema.AnnotationMetadata;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * This class encapsulates the common behavior between different CRD generation logic. The
 * intent is that each CRD spec version is implemented as a sub-class of this one.
 */
public abstract class AbstractCustomResourceHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractJsonSchema.class);

  public abstract void handle(CustomResourceInfo config, ResolvingContext resolvingContext);

  public interface PrinterColumnHandler {
    void addPrinterColumn(String path, String column, String format,
        int priority, String type, String description);
  }

  protected void handlePrinterColumns(AbstractJsonSchema<?, ?> resolver, PrinterColumnHandler handler) {
    TreeMap<String, AnnotationMetadata> sortedCols = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    sortedCols.putAll(resolver.getAllPaths(PrinterColumn.class));
    sortedCols.forEach((path, property) -> {
      PrinterColumn printerColumn = ((PrinterColumn) property.annotation);
      String column = printerColumn.name();
      if (Utils.isNullOrEmpty(column)) {
        column = path.substring(path.lastIndexOf(".") + 1).toUpperCase();
      }
      String format = printerColumn.format();
      format = Utils.isNotNullOrEmpty(format) ? format : null;
      int priority = printerColumn.priority();
      String type = property.schema.getType();
      if ("object".equals(type) || "array".equals(type)) {
        LOGGER.warn("Printer column '{}' has a type '{}' that is not allowed, will use string intead", column, type);
        type = "string";
      } else if ("string".equals(type) && "date".equals(property.schema.getFormat())) {
        type = "date";
      }

      // TODO: add description to the annotation? The previous logic considered the comments, which are not available here
      String description = property.schema.getDescription();
      description = Utils.isNotNullOrEmpty(description) ? description : null;

      handler.addPrinterColumn(path, column, format, priority, type, description);
    });
  }

  public abstract Stream<Map.Entry<? extends HasMetadata, Set<String>>> finish();

}
