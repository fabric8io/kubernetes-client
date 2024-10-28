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

import io.fabric8.kubernetes.schema.generator.ImportManager;
import io.fabric8.kubernetes.schema.generator.ImportOrderComparator;
import io.fabric8.kubernetes.schema.generator.schema.SchemaUtils;
import io.swagger.v3.oas.models.media.Schema;
import lombok.Getter;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Getter
public class ClassInformation implements ImportManager {

  private final SchemaUtils schemaUtils;
  private final Set<String> imports;
  private final String kubernetesListType;
  private final String packageName;
  private final boolean inRootPackage;
  private final boolean isEnum;
  private final String enumValues;
  private final boolean isInterface;
  private final boolean isHasMetadata;
  private final boolean isNamespaced;
  private final String classType;
  private final String classSimpleName;
  private final String className;
  private final String implementsExtends;
  private final JsonSubTypes jsonSubTypes;

  ClassInformation(SchemaUtils schemaUtils, Map.Entry<String, Schema<?>> clazz) {
    this.schemaUtils = schemaUtils;
    imports = new TreeSet<>(new ImportOrderComparator());
    final var classKey = clazz.getKey();
    final var classSchema = clazz.getValue();
    final var apiVersion = schemaUtils.getSettings().getApiVersions().get(classKey);
    // packageName must be resolved first, since the rest of computed fields depend on it
    packageName = schemaUtils.toModelPackage(classKey.substring(0, classKey.lastIndexOf('.')));
    kubernetesListType = apiVersion == null ? null : schemaUtils.kubernetesListType(this, classSchema);
    inRootPackage = getPackageName().equals(schemaUtils.getSettings().getPackageName());
    isEnum = SchemaUtils.isEnum(classSchema);
    if (isEnum) {
      addImport("com.fasterxml.jackson.annotation.JsonCreator");
      enumValues = String.join(",\n    ", SchemaUtils.enumValues(classSchema));
    } else {
      enumValues = null;
    }
    isInterface = SchemaUtils.isInterface(classSchema);
    isHasMetadata = apiVersion != null && kubernetesListType == null && schemaUtils.isHasMetadata(classSchema);
    isNamespaced = apiVersion != null && apiVersion.isNamespaced();
    classType = SchemaUtils.classType(classSchema);
    classSimpleName = SchemaUtils.refToClassName(classKey);
    className = getPackageName() + "." + getClassSimpleName();
    implementsExtends = resolveImplementsExtends(classSchema);
    if (isInterface) {
      addImport("com.fasterxml.jackson.annotation.JsonSubTypes");
      addImport("com.fasterxml.jackson.annotation.JsonTypeInfo");
      addImport("com.fasterxml.jackson.databind.annotation.JsonTypeResolver");
      jsonSubTypes = new JsonSubTypes(classSchema);
    } else {
      jsonSubTypes = null;
    }
  }

  @Override
  public boolean hasSimpleClassName(String className) {
    // If the provided class name matches the current class simple name it means that we'll need the fully
    // qualified class name to avoid conflicts.
    if (simpleClassName(className).equals(getClassSimpleName())) {
      return true;
    }
    return ImportManager.super.hasSimpleClassName(className);
  }

  boolean isEditable() {
    return !isEnum() && !isInterface();
  }

  public final String getBuilderName() {
    return getClassSimpleName() + "Builder";
  }

  private String resolveImplementsExtends(Schema<?> classSchema) {
    if (isEnum()) {
      return "";
    }
    final StringBuilder implementsExtends = new StringBuilder();
    if (isInterface()) {
      implementsExtends.append("extends ");
    } else {
      implementsExtends.append("implements ");
    }
    final var interfaceImplemented = SchemaUtils.interfaceImplemented(classSchema);
    if (interfaceImplemented != null) {
      implementsExtends.append(interfaceImplemented).append(", ");
    }
    if (isEditable()) {
      addImport("com.fasterxml.jackson.annotation.JsonIgnore");
      addImport(schemaUtils.getSettings().getBuilderPackage() + "." + "Editable");
      implementsExtends.append("Editable<").append(getBuilderName()).append(">");
      implementsExtends.append(" , "); // TODO: weird comma introduced by jsonschema2pojo
    }
    // HasMetadata
    if (isHasMetadata()) {
      if (!isInRootPackage()) {
        addImport(schemaUtils.getSettings().getHasMetadataClass());
      }
      implementsExtends.append(schemaUtils.getSettings().getHasMetadataClassSimpleName());
    }
    // KubernetesResource
    else {
      if (getClassSimpleName().equals(schemaUtils.getSettings().getKubernetesResourceClassSimpleName())) {
        // There's a class actually named KubernetesResource in the tekton package
        implementsExtends.append(schemaUtils.getSettings().getKubernetesResourceClass());
      } else {
        if (!isInRootPackage()) {
          addImport(schemaUtils.getSettings().getKubernetesResourceClass());
        }
        implementsExtends.append(schemaUtils.getSettings().getKubernetesResourceClassSimpleName());
      }
    }
    // Namespaced
    if (isNamespaced() && getKubernetesListType() == null) {
      if (!isInRootPackage()) {
        addImport(schemaUtils.getSettings().getNamespacedClass());
      }
      implementsExtends.append(", ").append(schemaUtils.getSettings().getNamespacedClassSimpleName());
    }
    // KubernetesResourceList
    if (getKubernetesListType() != null) {
      if (!isInRootPackage()) {
        addImport(schemaUtils.getSettings().getKubernetesResourceListClass());
      }
      implementsExtends.append(", ").append(schemaUtils.getSettings().getKubernetesResourceListClassSimpleName())
          .append("<")
          // TODO: remove after generator migration, match jsonschema2pojo generation for KubernetesResourceList
          .append(getPackageName()).append(".").append(getKubernetesListType())
          .append(">");
    }
    return implementsExtends.toString();
  }
}
