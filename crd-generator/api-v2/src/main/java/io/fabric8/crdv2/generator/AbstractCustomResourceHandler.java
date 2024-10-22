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

import io.fabric8.crd.generator.annotation.AdditionalPrinterColumn;
import io.fabric8.crd.generator.annotation.PrinterColumn;
import io.fabric8.crd.generator.annotation.PrinterColumnFormat;
import io.fabric8.crd.generator.annotation.SelectableField;
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

  public interface SelectableFieldHandler {
    void addSelectableField(String jsonPath);
  }

  protected void handlePrinterColumns(AbstractJsonSchema<?, ?> resolver, PrinterColumnHandler handler) {
    TreeMap<String, AnnotationMetadata> sortedCols = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    resolver.getAdditionalPrinterColumns().forEach(apc -> sortedCols.put(apc.jsonPath(), new AnnotationMetadata(apc, null)));
    sortedCols.putAll(resolver.getAllPaths(PrinterColumn.class));
    sortedCols.forEach((path, property) -> {
      if (property.annotation instanceof AdditionalPrinterColumn) {
        AdditionalPrinterColumn printerColumn = ((AdditionalPrinterColumn) property.annotation);
        String column = printerColumn.name();
        String format = printerColumn.format() == PrinterColumnFormat.NONE ? null : printerColumn.format().getValue();
        String type = printerColumn.type().getValue();
        int priority = printerColumn.priority();
        String description = printerColumn.getDescription();
        handler.addPrinterColumn(path, column, format, priority, type, description);
      } else {
        PrinterColumn printerColumn = ((PrinterColumn) property.annotation);
        String column = printerColumn.name();
        String format = printerColumn.format();
        format = Utils.isNotNullOrEmpty(format) ? format : null;
        String type = property.schema.getType();
        if ("object".equals(type) || "array".equals(type)) {
          LOGGER.warn("Printer column '{}' has a type '{}' that is not allowed, will use string intead", column, type);
          type = "string";
        } else if ("string".equals(type) && "date".equals(property.schema.getFormat())) {
          type = "date";
        }
        int priority = printerColumn.priority();

        // TODO: add description to the annotation? The previous logic considered the comments, which are not available here
        String description = property.schema.getDescription();
        handler.addPrinterColumn(path, column, format, priority, type, description);
      }
    });
  }

  protected void handleSelectableField(AbstractJsonSchema<?, ?> resolver, SelectableFieldHandler handler) {
    TreeMap<String, AnnotationMetadata> sortedCols = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    resolver.getAdditionalSelectableFields()
        .forEach(apc -> sortedCols.put(apc.jsonPath(), new AnnotationMetadata(apc, null)));
    sortedCols.putAll(resolver.getAllPaths(SelectableField.class));
    sortedCols.forEach((jsonPath, property) -> handler.addSelectableField(jsonPath));
  }

  public abstract Stream<Map.Entry<? extends HasMetadata, Set<String>>> finish();

}
