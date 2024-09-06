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
// Ported from https://github.com/manusa/yakc/blob/9272d649bfe05cd536d417fec64dcf679877bd14/buildSrc/src/main/java/com/marcnuri/yakc/schema/model/ModelGenerator.java
package io.fabric8.kubernetes.schema.generator.model;

import com.samskivert.mustache.Escapers;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import io.fabric8.kubernetes.schema.generator.GeneratorException;
import io.fabric8.kubernetes.schema.generator.GeneratorSettings;
import io.fabric8.kubernetes.schema.generator.GeneratorUtils;
import io.fabric8.kubernetes.schema.generator.schema.SchemaUtils;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static io.fabric8.kubernetes.schema.generator.GeneratorUtils.cleanSourceDirectory;
import static io.fabric8.kubernetes.schema.generator.schema.SchemaUtils.deserializerForJavaClass;
import static io.fabric8.kubernetes.schema.generator.schema.SchemaUtils.deserializerForType;
import static io.fabric8.kubernetes.schema.generator.schema.SchemaUtils.getterName;
import static io.fabric8.kubernetes.schema.generator.schema.SchemaUtils.isArray;
import static io.fabric8.kubernetes.schema.generator.schema.SchemaUtils.isMap;
import static io.fabric8.kubernetes.schema.generator.schema.SchemaUtils.sanitizeDescription;
import static io.fabric8.kubernetes.schema.generator.schema.SchemaUtils.sanitizeVariable;
import static io.fabric8.kubernetes.schema.generator.schema.SchemaUtils.serializerForJavaClass;
import static io.fabric8.kubernetes.schema.generator.schema.SchemaUtils.serializerForSchema;
import static io.fabric8.kubernetes.schema.generator.schema.SchemaUtils.setterName;

class ModelGenerator {

  private final GeneratorSettings settings;
  private final SchemaUtils utils;
  private final GeneratorUtils generatorUtils;
  private final Template modelTemplate;

  ModelGenerator(GeneratorSettings settings) {
    this.settings = settings;
    this.utils = new SchemaUtils(settings);
    this.generatorUtils = new GeneratorUtils(settings);
    this.modelTemplate = Mustache.compiler()
        .withLoader(name -> new StringReader(generatorUtils.readTemplate(name)))
        .defaultValue("")
        .withEscaper(Escapers.NONE)
        .compile(generatorUtils.readTemplate("model"));
  }

  void generate() {
    cleanSourceDirectory(settings.getGeneratedSourcesDirectory());
    final Map<String, Schema<?>> schemas = utils.extractComponentSchemas();
    settings.getLogger().info(String.format("Found %s schemas", schemas.size()));
    final AtomicInteger generatedClasses = new AtomicInteger();
    schemas.entrySet().stream()
        .filter(GeneratorUtils.filter(settings))
        .filter(entry -> entry.getValue() instanceof ObjectSchema)
        .forEach(classEntry -> {
          final TemplateContext templateContext = new TemplateContext(settings, classEntry);
          if (hasOverride(templateContext)) {
            settings.getLogger().fine(String.format("Skipping %s since it has an override", templateContext.getClassName()));
            return;
          }
          settings.getLogger().fine(String.format("Generating %ss", templateContext.getClassName()));
          mkPackageDirectories(templateContext);
          processTemplate(templateContext);
          final String fileContents = modelTemplate.execute(templateContext.getContext());
          writeFile(templateContext, fileContents);
          generatedClasses.incrementAndGet();
        });
    settings.getLogger().info(String.format("Generated %s model entries", generatedClasses.get()));
  }

  private void processTemplate(TemplateContext ret) {
    ret.put("emptySpace", " "); // TODO: remove after generator migration, current workaround so that models match with jsonschema2pojo

    ret.addAllImports(initDefaultImports());
    if (ret.getApiVersion() != null) {
      ret.addImport("io.fabric8.kubernetes.model.annotation.Version");
      ret.put("version", ret.getApiVersion().getVersion());
      // TODO: we might want to generify this logic for other annotations and imports
      if (Objects.equals("Group", ret.getClassSimpleName())) {
        ret.put("group", "@io.fabric8.kubernetes.model.annotation.Group(\"" + ret.getApiVersion().getGroup() + "\")");
      } else {
        ret.addImport("io.fabric8.kubernetes.model.annotation.Group");
        ret.put("group", "@Group(\"" + ret.getApiVersion().getGroup() + "\")");
      }
      ret.addImport("io.sundr.transform.annotations.TemplateTransformation");
      ret.addImport("io.sundr.transform.annotations.TemplateTransformations");
      ret.put("kubernetesResourceClass", settings.getKubernetesResourceClass());
    }
    final String serializer = serializerForJavaClass(ret.getClassName());
    if (serializer != null) {
      ret.addImport("com.fasterxml.jackson.databind.annotation.JsonSerialize");
      ret.put("classJsonSerializeUsing", serializer);
    }
    ret.put("classJsonDeserializeUsing", Optional.ofNullable(deserializerForJavaClass(ret.getClassName()))
        .orElse("com.fasterxml.jackson.databind.JsonDeserializer.None.class"));
    ret.put("package", ret.getPackageName());
    if (settings.isGenerateJavadoc()) {
      ret.put("hasDescription", !sanitizeDescription(ret.getClassSchema().getDescription()).trim().isEmpty());
      ret.put("description", sanitizeDescription(ret.getClassSchema().getDescription()));
    }
    ret.addImport("com.fasterxml.jackson.annotation.JsonInclude");
    ret.put("classJsonInclude", "NON_NULL");
    ret.put("className", ret.getClassSimpleName());
    ret.put("implementedInterfaces", resolveImplementedInterfaces(ret));
    final List<Map<String, Object>> templateFields = templateFields(ret);
    ret.put("fields", templateFields);
    if (!templateFields.isEmpty()) {
      ret.put("hasFields", true);
      ret.addImport("com.fasterxml.jackson.annotation.JsonProperty");
    }
    ret.put("propertyOrder", SchemaUtils.propertyOrder(ret.getClassSchema()));
    ret.put("builderPackage", settings.getBuilderPackage());
    if (settings.isAddBuildableReferences()) {
      ret.put("buildable", false);
      ret.addImport("io.sundr.builder.annotations.BuildableReference");
      ret.put("buildableReferences", buildableReferences(ret, templateFields));
    } else {
      ret.put("buildable", true);
    }
    if (!ret.getSchemaProperties().containsKey("additionalProperties")) {
      ret.put("additionalProperties", true);
      ret.addImport("com.fasterxml.jackson.annotation.JsonAnyGetter");
      ret.addImport("com.fasterxml.jackson.annotation.JsonAnySetter");
    }
  }

  private List<Map<String, Object>> templateFields(TemplateContext templateContext) {
    final List<Map<String, Object>> properties = new ArrayList<>();
    for (Entry<String, Schema> property : templateContext.getSchemaProperties().entrySet()) {
      final Map<String, Object> templateProp = new HashMap<>();
      final Schema<?> propertySchema = property.getValue();
      properties.add(templateProp);
      final String type = utils.schemaToClassName(templateContext, propertySchema);
      templateProp.put("propertyName", property.getKey());
      templateProp.put("type", type);
      templateProp.put("name", sanitizeVariable(property.getKey()));
      templateProp.put("getterName", getterName(property.getKey()));
      templateProp.put("setterName", setterName(property.getKey()));
      if (Optional.ofNullable(templateContext.getClassSchema().getRequired()).orElse(Collections.emptyList())
          .contains(property.getKey())) {
        templateProp.put("required", true);
      }
      if (settings.isGenerateJavadoc()) {
        templateProp.put("hasDescription", !sanitizeDescription(propertySchema.getDescription()).trim().isEmpty());
        templateProp.put("description", sanitizeDescription(propertySchema.getDescription()));
      }
      final String serializeUsing = serializerForSchema(propertySchema);
      if (serializeUsing != null) {
        templateContext.addImport("com.fasterxml.jackson.databind.annotation.JsonSerialize");
        templateProp.put("serializeUsing", serializeUsing);
      }
      final String deserializeUsing = deserializerForType(type);
      if (deserializeUsing != null) {
        templateContext.addImport("com.fasterxml.jackson.databind.annotation.JsonDeserialize");
        templateProp.put("deserializeUsing", deserializeUsing);
      }
      // Default values
      if (isArray(propertySchema)) {
        templateContext.addImport("com.fasterxml.jackson.annotation.JsonInclude");
        templateProp.put("jsonInclude", "NON_EMPTY");
        templateContext.addImport("java.util.ArrayList");
        templateProp.put("defaultValue", "new ArrayList<>()");
      } else if (isMap(propertySchema)) {
        templateContext.addImport("com.fasterxml.jackson.annotation.JsonInclude");
        templateProp.put("jsonInclude", "NON_EMPTY");
        templateProp.put("defaultValue", "new LinkedHashMap<>()");
      } else if (Objects.equals(property.getKey(), "kind")
          && Objects.equals(type, "String")
          && templateContext.getApiVersion() != null) {
        templateProp.put("legacyRequired", true); // TODO: remove after generator migration
        templateProp.put("defaultValue", String.format("\"%s\"", templateContext.getClassSimpleName()));
      } else if (Objects.equals(property.getKey(), "apiVersion")
          && Objects.equals(type, "String")
          && templateContext.getApiVersion() != null) {
        templateProp.put("legacyRequired", true); // TODO: remove after generator migration
        templateProp.put("defaultValue", String.format("\"%s\"", templateContext.getApiVersion()));
      }
      // TODO: remove after generator migration, match jsonschema2pojo generation for items
      if (templateContext.getKubernetesListType() != null
          && Objects.equals(property.getKey(), "items")) {
        templateProp.put("type",
            "List<" + templateContext.getPackageName() + "." + templateContext.getKubernetesListType() + ">");
      }
    }
    return properties;
  }

  private void mkPackageDirectories(TemplateContext templateContext) {
    try {
      FileUtils.forceMkdir(resolvePackageDirectory(templateContext).toFile());
    } catch (IOException e) {
      throw new GeneratorException("Can't generate package directory for " + templateContext.getClassKey());
    }
  }

  private boolean hasOverride(TemplateContext templateContext) {
    return settings.getOverridesDirectory().toPath()
        .resolve(templateContext.getPackageName().replace('.', File.separatorChar))
        .resolve(templateContext.getClassSimpleName().concat(".java"))
        .toFile().exists();
  }

  private Path resolvePackageDirectory(TemplateContext templateContext) {
    return settings.getGeneratedSourcesDirectory().toPath()
        .resolve(templateContext.getPackageName().replace('.', File.separatorChar));
  }

  private String resolveImplementedInterfaces(TemplateContext templateContext) {
    // Editable (all classes)
    templateContext.addImport(settings.getBuilderPackage() + "." + "Editable");
    final StringBuilder implementedInterfaces = new StringBuilder();
    implementedInterfaces.append("Editable<").append(templateContext.getClassSimpleName()).append("Builder>");
    // HasMetadata
    implementedInterfaces.append(" , "); // TODO: weird comma introduced by jsonschema2pojo
    if (templateContext.isHasMetadata()) {
      if (!templateContext.isInRootPackage()) {
        templateContext.addImport(settings.getHasMetadataClass());
      }
      implementedInterfaces.append(settings.getHasMetadataClassSimpleName());
    }
    // KubernetesResource
    else {
      if (!templateContext.isInRootPackage()) {
        templateContext.addImport(settings.getKubernetesResourceClass());
      }
      implementedInterfaces.append(settings.getKubernetesResourceClassSimpleName());
    }
    // Namespaced
    if (templateContext.isNamespaced() && templateContext.getKubernetesListType() == null) {
      if (!templateContext.isInRootPackage()) {
        templateContext.addImport(settings.getNamespacedClass());
      }
      implementedInterfaces.append(", ").append(settings.getNamespacedClassSimpleName());
    }
    // KubernetesResourceList
    if (templateContext.getKubernetesListType() != null) {
      if (!templateContext.isInRootPackage()) {
        templateContext.addImport(settings.getKubernetesResourceListClass());
      }
      implementedInterfaces.append(", ").append(settings.getKubernetesResourceListClassSimpleName())
          .append("<")
          // TODO: remove after generator migration, match jsonschema2pojo generation for KubernetesResourceList
          .append(templateContext.getPackageName()).append(".").append(templateContext.getKubernetesListType())
          .append(">");
    }
    return implementedInterfaces.toString();
  }

  private Map<String, List<String>> buildableReferences(TemplateContext templateContext, List<Map<String, Object>> fields) {
    final List<String> references = new ArrayList<>(settings.getBuildableReferences());
    references.add(0, settings.getObjectMetaClass());
    if (fields.stream().map(f -> f.get("type")).filter(Objects::nonNull).map(Object::toString)
        .anyMatch(r -> r.contains("KubernetesResource") || r.contains("HasMetadata") || r.contains("RawExtension"))) {
      references.add(settings.getGenericKubernetesResourceClass());
      references.add(settings.getRawExtensionClass());
    }
    return Collections.singletonMap("refs", references.stream()
        .map(r -> {
          final String referenceSimpleClass = r.substring(r.lastIndexOf('.') + 1);
          if (templateContext.getClassSimpleName().equals(referenceSimpleClass)) {
            return r;
          }
          templateContext.addImport(r);
          return referenceSimpleClass;
        })
        .map(ref -> ref.concat(".class")).collect(Collectors.toList()));
  }

  private void writeFile(TemplateContext context, String fileContents) {
    final Path file = resolvePackageDirectory(context).resolve(context.getClassSimpleName().concat(".java"));
    generatorUtils.writeFile(file, fileContents);
  }

  private static Set<String> initDefaultImports() {
    return new HashSet<>(Arrays.asList(
        "java.util.LinkedHashMap",
        "java.util.Map",
        "javax.annotation.Generated",
        "com.fasterxml.jackson.annotation.JsonIgnore",
        "com.fasterxml.jackson.annotation.JsonPropertyOrder",
        "com.fasterxml.jackson.databind.annotation.JsonDeserialize",
        "io.sundr.builder.annotations.Buildable",
        "lombok.EqualsAndHashCode",
        "lombok.ToString",
        "lombok.experimental.Accessors"));
  }

}
