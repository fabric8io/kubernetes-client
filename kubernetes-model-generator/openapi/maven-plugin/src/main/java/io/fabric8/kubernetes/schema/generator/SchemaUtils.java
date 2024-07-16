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
// Ported from https://github.com/manusa/yakc/blob/9272d649bfe05cd536d417fec64dcf679877bd14/buildSrc/src/main/java/com/marcnuri/yakc/schema/SchemaUtils.java
package io.fabric8.kubernetes.schema.generator;

import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.ComposedSchema;
import io.swagger.v3.oas.models.media.DateTimeSchema;
import io.swagger.v3.oas.models.media.MapSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SchemaUtils {

  public static final String APPLICATION_JSON = "application/json";

  private static final String OBJECT_PRIMITIVE = "Object";
  private static final String STRING_PRIMITIVE = "String";

  private static final Map<String, String> REF_TO_JAVA_TYPE_MAP = Map.of(
      "#/components/schemas/io.k8s.apimachinery.pkg.util.intstr.IntOrString", "io.fabric8.kubernetes.api.model.IntOrString",
      "#/components/schemas/io.k8s.apimachinery.pkg.api.resource.Quantity", "io.fabric8.kubernetes.api.model.Quantity",
      "#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta", "io.fabric8.kubernetes.api.model.ObjectMeta",
      "#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta_v2", "io.fabric8.kubernetes.api.model.ObjectMeta",
      "#/components/schemas/io.k8s.apimachinery.pkg.runtime.RawExtension", "io.fabric8.kubernetes.api.model.KubernetesResource",
      "#/components/schemas/io.k8s.apiextensions-apiserver.pkg.apis.apiextensions.v1beta1.JSON",
      "com.fasterxml.jackson.databind.JsonNode",
      "#/components/schemas/io.k8s.apiextensions-apiserver.pkg.apis.apiextensions.v1.JSON",
      "com.fasterxml.jackson.databind.JsonNode");

  private static final Map<String, String> REF_TO_JAVA_PRIMITIVE_MAP = Map.of(
      "#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.Time", "String");

  private static final Map<String, String> JAVA_CLASS_SERIALIZER_MAP = Map.of(
      "io.fabric8.kubernetes.api.model.MicroTime", "io.fabric8.kubernetes.api.model.MicroTimeSerDes.Serializer.class",
      "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArray",
      "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArraySerDe.Serializer.class",
      "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrArray",
      "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrArraySerDe.Serializer.class",
      "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBool",
      "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBoolSerDe.Serializer.class",
      "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrBool",
      "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrBoolSerDe.Serializer.class",
      "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArray",
      "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArraySerDe.Serializer.class",
      "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrStringArray",
      "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrStringArraySerDe.Serializer.class");

  private static final Map<String, String> JAVA_CLASS_DESERIALIZER_MAP = Map.of(
      "io.fabric8.kubernetes.api.model.MicroTime", "io.fabric8.kubernetes.api.model.MicroTimeSerDes.Deserializer.class",
      "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArray",
      "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArraySerDe.Deserializer.class",
      "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrArray",
      "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrArraySerDe.Deserializer.class",
      "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBool",
      "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBoolSerDe.Deserializer.class",
      "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrBool",
      "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrBoolSerDe.Deserializer.class",
      "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArray",
      "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArraySerDe.Deserializer.class",
      "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrStringArray",
      "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrStringArraySerDe.Deserializer.class");

  private static final Map<String, String> REF_SERIALIZER_MAP = Map.of(
  //    "#/components/schemas/io.k8s.apimachinery.pkg.util.intstr.IntOrString", "com.marcnuri.yakc.model.serialization.IntOrStringSerializer.class"
  );

  private static final Map<String, String> TYPE_MAP = Map.of(
      "boolean", "Boolean",
      "int32", "Integer",
      "int64", "Long",
      "double", "Double",
      "number", "Number",
      "object", OBJECT_PRIMITIVE,
      "string", STRING_PRIMITIVE);

  private static final Set<String> PROTECTED_WORDS = Set.of(
      "continue",
      "default",
      "enum",
      "class",
      "import",
      "int",
      "private",
      "for",
      "return",
      "package");

  private final GeneratorSettings settings;

  public SchemaUtils(GeneratorSettings settings) {
    this.settings = settings;
  }

  public static String refToClassName(String ref) {
    return capitalize(ref.substring(ref.lastIndexOf('.') + 1));
  }

  private String refToModelPackage(String ref) {
    final String packageName = ref.substring(ref.lastIndexOf('/') + 1, ref.lastIndexOf('.'));
    return toModelPackage(packageName).concat(".").concat(refToClassName(ref));
  }

  public String toModelPackage(String packageName) {
    for (String mapping : settings.getPackageMappings().keySet()) {
      if (packageName.startsWith(mapping + ".") || packageName.equals(mapping)) {
        packageName = packageName.replaceAll("^" + mapping, settings.getPackageMappings().get(mapping));
        break;
      }
    }
    return sanitizePackageName(packageName);
  }

  /**
   * Returns the mapped Class name associated to the provided {@link Schema} and adds
   * an import to the canonical path of the class represented by that name if necessary.
   *
   * @param addImport function to add an import that might be needed for the referneced class.
   * @param schema the schema from which to retrieve the mapped Class name.
   * @return String containing the Class name mapped to the provided Schema.
   */
  public String schemaToClassName(Consumer<String> addImport, Schema<?> schema) {
    final String ref = schema.get$ref();
    if (isArray(schema)) {
      final ArraySchema arraySchema = (ArraySchema) schema;
      addImport.accept("java.util.List");
      return String.format("List<%s>", schemaToClassName(addImport, arraySchema.getItems()));
    }
    if (isMap(schema)) {
      addImport.accept("java.util.Map");
      final String valueType;
      if (schema.getAdditionalProperties() instanceof Schema) {
        valueType = schemaToClassName(addImport, (Schema<?>) schema.getAdditionalProperties());
      } else {
        valueType = "Object";
      }
      return String.format("Map<String, %s>", valueType);
    }
    if (isDateTime(schema)) {
      // TODO: Evaluate if we want to introduce this breaking change
      //      addImport.accept("java.time.OffsetDateTime");
      //      return "OffsetDateTime";
      return "String";
    }
    if (isString(schema)) {
      return "String";
    }
    if (ref != null && !ref.isBlank()) {
      return schemaRefToJavaPrimitive(schema)
          .or(() -> schemaRefToJavaType(schema).map(javaType -> {
            addImport.accept(javaType);
            return javaType.substring(javaType.lastIndexOf('.') + 1);
          }))
          .orElseGet(() -> {
            addImport.accept(refToModelPackage(ref));
            return refToClassName(ref);
          });
    }
    // Plain OpenAPI object map to KubernetesResource (deserializer will take care of the rest)
    if (isObject(schema)) {
      addImport.accept(settings.getKubernetesResourceClass());
      return settings.getKubernetesResourceClassSimpleName();
    }
    return schemaTypeToJavaPrimitive(schema);
  }

  public static boolean isArray(Schema<?> schema) {
    return schema instanceof ArraySchema;
  }

  public boolean isDateTime(Schema<?> schema) {
    // TODO: Special handling for MicroTime class (with custom serializer and deserializer)
    // Fabric8 has a special (legacy) handling for MicroTime, we might consider removing this
    // completely and use OffsetDateTime as for the rest of temporal types
    if (schema.get$ref() != null && Objects.equals(refToClassName(schema.get$ref()), "MicroTime")) {
      return false;
    }
    return schema instanceof DateTimeSchema || isRefInstanceOf(schema.get$ref(), DateTimeSchema.class);
  }

  public boolean isHasMetadata(Schema<?> schema) {
    return schema != null
        && schema.getProperties() != null
        && schema.getProperties().containsKey("metadata")
        && schemaRefToJavaType(schema.getProperties().get("metadata"))
            .filter(settings.getObjectMetaClass()::equals).isPresent();
  }

  public static boolean isMap(Schema<?> schema) {
    if (schema instanceof MapSchema) {
      return true;
    }
    if (schema != null && schema.getAdditionalProperties() instanceof Schema) {
      return true;
    }
    if (schema != null && schema.getAdditionalProperties() instanceof Boolean
        && (Boolean) schema.getAdditionalProperties()) {
      return true;
    }
    return false;
  }

  private static boolean isObject(Schema<?> schema) {
    return Optional.ofNullable(schema.getType()).orElse("").equals("object");
  }

  public boolean isString(Schema<?> schema) {
    final String ref = schema.get$ref();
    if (ref != null && (REF_TO_JAVA_PRIMITIVE_MAP.containsKey(ref) || REF_TO_JAVA_TYPE_MAP.containsKey(ref))) {
      return false;
    }
    return schema instanceof StringSchema || isRefInstanceOf(ref, StringSchema.class);
  }

  public static boolean isComposed(Schema<?> schema) {
    return schema instanceof ComposedSchema;
  }

  public boolean isRefInstanceOf(String ref, Class<?> clazz) {
    if (ref == null) {
      return false;
    }
    return settings.getOpenAPI().getComponents().getSchemas().entrySet().stream()
        .filter(entry -> clazz.isInstance(entry.getValue()))
        .anyMatch(entry -> ref.endsWith(entry.getKey()));
  }

  public String kubernetesListType(Consumer<String> addImport, Schema<?> schema) {
    if (schema == null || !isObject(schema)) {
      return null;
    }
    return Optional.ofNullable(schema.getProperties())
        .map(p -> p.get("items"))
        .filter(s -> s instanceof ArraySchema)
        .map(s -> (ArraySchema) s)
        .map(as -> schemaToClassName(addImport, as.getItems()))
        .orElse(null);
  }

  private static Optional<String> schemaRefToJavaPrimitive(Schema<?> schema) {
    return Optional.ofNullable(REF_TO_JAVA_PRIMITIVE_MAP.get(schema.get$ref()));
  }

  private static Optional<String> schemaRefToJavaType(Schema<?> schema) {
    return Optional.ofNullable(REF_TO_JAVA_TYPE_MAP.get(schema.get$ref()));
  }

  private static String schemaTypeToJavaPrimitive(Schema<?> schema) {
    return Optional.ofNullable(schema.getType())
        .map(type -> type.equals("integer") && schema.getFormat() != null ? schema.getFormat() : type)
        .map(type -> type.equals("number") && schema.getFormat() != null ? schema.getFormat() : type)
        .map(TYPE_MAP::get)
        .orElse(schema.getType());
  }

  public static String sanitizePackageName(String packageName) {
    return packageName.replace("-", "").toLowerCase();
  }

  public static String sanitizeDescription(String description) {
    return Optional.ofNullable(description).orElse("")
        .replace("&", "&amp;")
        .replace("*", "&#42;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace('\u201C', '"')
        .replace('\u201D', '"')
        .replace("\n", "<br><p> ");
  }

  public static String removeDashes(String variable) {
    final StringBuilder sanitized = new StringBuilder();
    for (String part : variable.split("-")) {
      if (sanitized.length() == 0) {
        sanitized.append(part);
      } else {
        sanitized.append(capitalize(part));
      }
    }
    return sanitized.toString();
  }

  public static String sanitizeVariable(String variable) {
    final String sanitized = uncapitalize(removeDashes(variable));
    return PROTECTED_WORDS.contains(sanitized) ? "_" + sanitized : sanitized;
  }

  public static String getterName(String variable) {
    return "get".concat(capitalize(removeDashes(variable)));
  }

  public static String setterName(String variable) {
    return "set".concat(capitalize(removeDashes(variable)));
  }

  public Map<String, Schema<?>> extractComponentSchemas() {
    return settings.getOpenAPI().getComponents().getSchemas().entrySet().stream()
        .collect(Collectors.toMap(Map.Entry::getKey, v -> (Schema<?>) v.getValue()));
  }

  public static String serializerForSchema(Schema<?> schema) {
    return Optional.ofNullable(schema)
        .map(Schema::get$ref)
        .map(REF_SERIALIZER_MAP::get)
        .orElse(null);
  }

  public static String serializerForJavaClass(String java) {
    return JAVA_CLASS_SERIALIZER_MAP.get(java);
  }

  public static String deserializerForJavaClass(String java) {
    return JAVA_CLASS_DESERIALIZER_MAP.get(java);
  }

  /**
   * Returns the order in which properties should be serialized.
   *
   * @param schema the schema to extract properties from.
   * @return a map containing the list of sorted properties.
   */
  public static Map<String, Object> propertyOrder(Schema<?> schema) {
    // isEmpty is used as a hack to add an extra-space to the JsonPropertyOrder annotation to be
    // compatible with Fabric8 legacy output TODO: we can remove once merged
    final Map<String, Object> ret = new HashMap<>();
    if (schema != null && schema.getProperties() != null) {
      ret.put("isEmpty", false);
      ret.put("properties", schema.getProperties().keySet().stream()
          .sorted(new PropertyOrderComparator<>(Arrays.asList("apiVersion", "kind", "metadata")))
          .collect(Collectors.toList()));
    } else {
      ret.put("isEmpty", true);
    }
    return ret;
  }

  public static String capitalize(String string) {
    if (string == null) {
      return null;
    }
    if (string.isEmpty()) {
      return string;
    }
    return string.substring(0, 1).toUpperCase(Locale.ROOT) + string.substring(1);
  }

  public static String uncapitalize(String string) {
    if (string == null) {
      return null;
    }
    if (string.isEmpty()) {
      return string;
    }
    return string.substring(0, 1).toLowerCase(Locale.ROOT) + string.substring(1);
  }
}
