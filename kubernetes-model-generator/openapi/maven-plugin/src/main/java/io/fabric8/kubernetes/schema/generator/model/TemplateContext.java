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
import io.fabric8.kubernetes.schema.generator.schema.SchemaUtils;
import io.swagger.v3.oas.models.media.Schema;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Getter
final class TemplateContext implements ImportManager {

  private final String classKey;
  private final Schema<?> classSchema;
  private final ApiVersion apiVersion;
  private final ClassInformation classInformation;
  private final Map<String, Object> context;

  TemplateContext(GeneratorSettings settings, Map.Entry<String, Schema<?>> clazz) {
    final SchemaUtils schemaUtils = new SchemaUtils(settings);
    classKey = clazz.getKey();
    classSchema = clazz.getValue();
    apiVersion = settings.getApiVersions().get(classKey);
    classInformation = new ClassInformation(schemaUtils, clazz);
    context = new HashMap<>();
    context.put("imports", classInformation.getImports());
    context.put("classInformation", classInformation);
  }

  void put(String key, Object value) {
    context.put(key, value);
  }

  Map<String, Schema> getSchemaProperties() {
    return classSchema.getProperties() == null ? Collections.emptyMap() : classSchema.getProperties();
  }

  @Override
  public String getPackageName() {
    return getClassInformation().getPackageName();
  }

  @Override
  public Collection<String> getImports() {
    return getClassInformation().getImports();
  }

  @Override
  public boolean hasSimpleClassName(String className) {
    return getClassInformation().hasSimpleClassName(className);
  }
}
