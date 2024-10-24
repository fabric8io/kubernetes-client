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
import io.fabric8.kubernetes.schema.generator.ImportManager;
import io.fabric8.kubernetes.schema.generator.ImportOrderComparator;
import io.fabric8.kubernetes.schema.generator.schema.SchemaUtils;
import io.swagger.v3.oas.models.media.Schema;
import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Getter
final class TemplateContext implements ImportManager {

  private final String classKey;
  private final Schema<?> classSchema;
  private final ApiVersion apiVersion;
  private final String packageName;
  private final boolean inRootPackage;
  private final String classSimpleName;
  private final String className;
  private final boolean isInterface;
  private final boolean hasMetadata;
  private final String kubernetesListType;
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
    isInterface = classSchema.getExtensions() != null
        && Objects.equals(classSchema.getExtensions().get("x-kubernetes-fabric8-type"), "interface");
    imports = new TreeSet<>(new ImportOrderComparator());
    kubernetesListType = apiVersion == null ? null : schemaUtils.kubernetesListType(this, classSchema);
    hasMetadata = apiVersion != null && kubernetesListType == null && schemaUtils.isHasMetadata(classSchema);
    context = new HashMap<>();
    context.put("imports", imports);
  }

  void put(String key, Object value) {
    context.put(key, value);
  }

  Map<String, Schema> getSchemaProperties() {
    return classSchema.getProperties() == null ? Collections.emptyMap() : classSchema.getProperties();
  }

  boolean isNamespaced() {
    return getApiVersion() != null && getApiVersion().isNamespaced();
  }

  @Override
  public boolean hasSimpleClassName(String className) {
    // If the provided class name matches the current class simple name it means that we'll need the fully
    // qualified class name to avoid conflicts.
    if (simpleClassName(className).equals(classSimpleName)) {
      return true;
    }
    return ImportManager.super.hasSimpleClassName(className);
  }
}
