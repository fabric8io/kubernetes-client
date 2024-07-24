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
package io.fabric8.kubernetes.schema.generator.model;

import io.fabric8.kubernetes.schema.generator.ApiVersion;
import io.fabric8.kubernetes.schema.generator.GeneratorSettings;
import io.fabric8.kubernetes.schema.generator.ImportOrderComparator;
import io.fabric8.kubernetes.schema.generator.SchemaUtils;
import io.swagger.v3.oas.models.media.Schema;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

final class TemplateContext {

  @Getter
  private final String classKey;
  @Getter
  private final Schema<?> classSchema;
  @Getter
  private final ApiVersion apiVersion;
  @Getter
  private final String packageName;
  @Getter
  private final boolean inRootPackage;
  @Getter
  private final String classSimpleName;
  @Getter
  private final String className;
  @Getter
  private final boolean hasMetadata;
  @Getter
  private final String kubernetesListType;
  @Getter
  private final Map<String, Object> context;
  private final Set<String> imports;

  TemplateContext(GeneratorSettings settings, Map.Entry<String, Schema<?>> clazz) {
    final SchemaUtils schemaUtils = new SchemaUtils(settings);
    classKey = clazz.getKey();
    classSchema = clazz.getValue();
    apiVersion = settings.getApiVersions().get(classKey);
    packageName = schemaUtils.toModelPackage(classKey.substring(0, classKey.lastIndexOf('.')));
    inRootPackage = packageName.equals(settings.getPackageName());
    classSimpleName = SchemaUtils.refToClassName(classKey);
    className = packageName + "." + classSimpleName;
    imports = new TreeSet<>(new ImportOrderComparator());
    kubernetesListType = apiVersion == null ? null : schemaUtils.kubernetesListType(this::addImport, classSchema);
    hasMetadata = apiVersion != null && kubernetesListType == null && schemaUtils.isHasMetadata(classSchema);
    context = new HashMap<>();
    context.put("imports", imports);
  }

  void put(String key, Object value) {
    context.put(key, value);
  }

  void addImport(String importedClass) {
    // Only add import if it belongs to a different package
    if (!Objects.equals(importedClass.substring(0, importedClass.lastIndexOf('.')), packageName)) {
      imports.add(importedClass);
    }
  }

  void addAllImports(Collection<String> allImports) {
    allImports.forEach(this::addImport);
  }

  Map<String, Schema> getSchemaProperties() {
    return classSchema.getProperties() == null ? Collections.emptyMap() : classSchema.getProperties();
  }
}
