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

import com.github.victools.jsonschema.generator.CustomDefinition;
import com.github.victools.jsonschema.generator.FieldScope;
import com.github.victools.jsonschema.generator.Option;
import com.github.victools.jsonschema.generator.OptionPreset;
import com.github.victools.jsonschema.generator.SchemaGenerator;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfig;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder;
import com.github.victools.jsonschema.generator.SchemaVersion;
import com.github.victools.jsonschema.module.jackson.JacksonOption;
import com.github.victools.jsonschema.module.jackson.JacksonSchemaModule;
import io.fabric8.kubernetes.api.model.AnyType;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.runtime.RawExtension;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import io.fabric8.kubernetes.client.utils.YamlDumpSettings;
import io.fabric8.kubernetes.client.utils.YamlDumpSettingsBuilder;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ObjectNode;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Encapsulates the stateful schema generation context for CRD generation.
 * Uses victools jsonschema-generator to produce JSON schemas from Java classes.
 */
public class ResolvingContext {

  final ObjectMapper objectMapper;
  final KubernetesSerialization kubernetesSerialization;
  final boolean implicitPreserveUnknownFields;

  // Captured per-property metadata during schema generation
  // Key: declaringClassName + ":" + jsonPropertyName
  private final Map<String, FieldScope> fieldScopes = new ConcurrentHashMap<>();

  // $defs from the last toJsonSchema() call
  private Map<String, ObjectNode> defs = Collections.emptyMap();

  // Root schema from the last toJsonSchema() call (for resolving "#" self-references)
  private ObjectNode rootSchema;

  private static ObjectMapper OBJECT_MAPPER;

  public static ResolvingContext defaultResolvingContext(boolean implicitPreserveUnknownFields) {
    return defaultResolvingContext(implicitPreserveUnknownFields, new YamlDumpSettingsBuilder().build());
  }

  public static ResolvingContext defaultResolvingContext(boolean implicitPreserveUnknownFields,
      YamlDumpSettings yamlDumpSettings) {
    if (OBJECT_MAPPER == null) {
      OBJECT_MAPPER = new ObjectMapper();
    }
    return new ResolvingContext(
        OBJECT_MAPPER,
        new KubernetesSerialization(OBJECT_MAPPER, false, yamlDumpSettings),
        implicitPreserveUnknownFields);
  }

  public ResolvingContext forkContext() {
    return new ResolvingContext(objectMapper, kubernetesSerialization, implicitPreserveUnknownFields);
  }

  public ResolvingContext(ObjectMapper mapper, KubernetesSerialization kubernetesSerialization,
      boolean implicitPreserveUnknownFields) {
    this.objectMapper = mapper;
    this.kubernetesSerialization = kubernetesSerialization;
    this.implicitPreserveUnknownFields = implicitPreserveUnknownFields;
  }

  ObjectNode toJsonSchema(Class<?> clazz) {
    // Do NOT clear fieldScopes; secondary toJsonSchema() calls (for SchemaSwap/SchemaFrom)
    // must not lose field scopes captured from the primary generation.

    SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(
        objectMapper,
        SchemaVersion.DRAFT_2020_12,
        OptionPreset.PLAIN_JSON);

    // Jackson module to respect Jackson annotations on model classes
    JacksonSchemaModule jacksonModule = new JacksonSchemaModule(
        JacksonOption.FLATTENED_ENUMS_FROM_JSONPROPERTY,
        JacksonOption.RESPECT_JSONPROPERTY_ORDER);
    configBuilder.with(jacksonModule);

    configBuilder.with(
        Option.MAP_VALUES_AS_ADDITIONAL_PROPERTIES,
        Option.FLATTENED_ENUMS);

    // Custom type definitions for Kubernetes special types that victools can't handle
    configBuilder.forTypesInGeneral()
        .withCustomDefinitionProvider(
            (javaType, context) -> kubernetesTypeDefinition(javaType.getErasedType(), context.getGeneratorConfig()));

    // Capture FieldScope per property for annotation access in AbstractJsonSchema.
    // For array/map fields, victools calls this override multiple times (once for the
    // container, once for items/values). We always prefer the FieldScope whose resolved
    // type matches the raw field's declared type, so that handleTypeAnnotations can
    // correctly detect container types (List, Map).
    configBuilder.forFields()
        .withInstanceAttributeOverride((propSchema, field, context) -> {
          String key = field.getDeclaringType().getErasedType().getName()
              + ":" + field.getSchemaPropertyName();
          Class<?> rawFieldType = field.getRawMember().getType();
          Class<?> scopeType = field.getType().getErasedType();
          FieldScope existing = fieldScopes.get(key);
          if (existing == null || rawFieldType.isAssignableFrom(scopeType)) {
            fieldScopes.put(key, field);
          }
        });

    SchemaGeneratorConfig config = configBuilder.build();
    SchemaGenerator generator = new SchemaGenerator(config);
    ObjectNode schema = generator.generateSchema(clazz);

    // Store the root schema for "#" self-reference resolution
    this.rootSchema = schema;
    extractDefs(schema);

    return schema;
  }

  /**
   * Maps Kubernetes-specific Java types to custom JSON Schema definitions.
   * These types have no standard JSON Schema representation, so victools would
   * generate incorrect schemas without this override.
   */
  private static CustomDefinition kubernetesTypeDefinition(Class<?> raw, SchemaGeneratorConfig generatorConfig) {
    // IntOrString and Quantity are represented as x-kubernetes-int-or-string in CRDs
    if (raw == IntOrString.class || raw == Quantity.class) {
      return inlineDefinition(generatorConfig, "x-kubernetes-int-or-string", true);
    }
    // RawExtension and GenericKubernetesResource are embedded resources
    if (raw == RawExtension.class || raw == GenericKubernetesResource.class) {
      return inlineDefinition(generatorConfig, "x-kubernetes-embedded-resource", true);
    }
    // ObjectNode is a free-form JSON object
    if (raw == ObjectNode.class) {
      return inlineDefinition(generatorConfig, "type", "object");
    }
    // JsonNode and subclasses (except ObjectNode, handled above) represent arbitrary JSON
    if (JsonNode.class.isAssignableFrom(raw)) {
      return inlineDefinition(generatorConfig, "x-kubernetes-preserve-unknown-fields", true);
    }
    // AnyType represents "any" type content
    if (raw == AnyType.class) {
      return inlineDefinition(generatorConfig, "x-kubernetes-preserve-unknown-fields", true);
    }
    // HasMetadata interfaces are embedded Kubernetes resources
    if (HasMetadata.class.isAssignableFrom(raw) && raw.isInterface()) {
      return inlineDefinition(generatorConfig, "x-kubernetes-embedded-resource", true);
    }
    return null;
  }

  private static CustomDefinition inlineDefinition(SchemaGeneratorConfig config, String key, Object value) {
    ObjectNode schema = config.createObjectNode();
    if (value instanceof Boolean b) {
      schema.put(key, b);
    } else {
      schema.put(key, value.toString());
    }
    return new CustomDefinition(schema,
        CustomDefinition.DefinitionType.INLINE,
        CustomDefinition.AttributeInclusion.NO);
  }

  /**
   * Extracts $defs from the generated schema for $ref resolution.
   * CRDs don't support $ref, so AbstractJsonSchema resolves them inline during traversal.
   */
  private void extractDefs(ObjectNode schema) {
    if (schema.has("$defs")) {
      ObjectNode defsNode = (ObjectNode) schema.get("$defs");
      Map<String, ObjectNode> extractedDefs = new ConcurrentHashMap<>();
      defsNode.properties().forEach(entry -> extractedDefs.put("#/$defs/" + entry.getKey(), (ObjectNode) entry.getValue()));
      this.defs = extractedDefs;
    } else {
      this.defs = Collections.emptyMap();
    }
  }

  /**
   * Generates a JSON schema for a secondary type (SchemaSwap/SchemaFrom target),
   * preserving the defs and rootSchema from the primary schema generation.
   * Without this, the primary $defs are lost when a secondary schema is generated.
   */
  ObjectNode toJsonSchemaForSwap(Class<?> clazz) {
    Map<String, ObjectNode> savedDefs = this.defs;
    ObjectNode savedRoot = this.rootSchema;
    ObjectNode schema = toJsonSchema(clazz);
    this.defs = savedDefs;
    this.rootSchema = savedRoot;
    return schema;
  }

  /**
   * Finds a FieldScope by walking up the class hierarchy from the given class.
   * Field scopes are stored using the declaring class name as key prefix, so inherited
   * properties need hierarchy traversal.
   */
  FieldScope getFieldScope(Class<?> clazz, String propertyName) {
    Class<?> current = clazz;
    while (current != null && current != Object.class) {
      FieldScope fs = fieldScopes.get(current.getName() + ":" + propertyName);
      if (fs != null) {
        return fs;
      }
      current = current.getSuperclass();
    }
    return null;
  }

  Map<String, ObjectNode> getDefs() {
    return defs;
  }

  ObjectNode getRootSchema() {
    return rootSchema;
  }
}
