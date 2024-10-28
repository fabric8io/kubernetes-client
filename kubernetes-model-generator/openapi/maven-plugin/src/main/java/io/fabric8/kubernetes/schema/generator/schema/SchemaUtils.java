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
package io.fabric8.kubernetes.schema.generator.schema;

import io.fabric8.kubernetes.schema.generator.GeneratorSettings;
import io.fabric8.kubernetes.schema.generator.ImportManager;
import io.fabric8.kubernetes.schema.generator.PropertyOrderComparator;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.DateTimeSchema;
import io.swagger.v3.oas.models.media.MapSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class SchemaUtils {

  public static final String APPLICATION_JSON = "application/json";

  private static final String OBJECT_PRIMITIVE = "Object";
  private static final String STRING_PRIMITIVE = "String";

  private static final Map<String, String> REF_TO_JAVA_TYPE_MAP = new LinkedHashMap<>();
  static {
    REF_TO_JAVA_TYPE_MAP.put("#/components/schemas/io.k8s.apimachinery.pkg.util.intstr.IntOrString",
        "io.fabric8.kubernetes.api.model.IntOrString");
    REF_TO_JAVA_TYPE_MAP.put("#/components/schemas/io.k8s.apimachinery.pkg.api.resource.Quantity",
        "io.fabric8.kubernetes.api.model.Quantity");
    REF_TO_JAVA_TYPE_MAP.put("#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta",
        "io.fabric8.kubernetes.api.model.ObjectMeta");
    REF_TO_JAVA_TYPE_MAP.put("#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta_v2",
        "io.fabric8.kubernetes.api.model.ObjectMeta");
    REF_TO_JAVA_TYPE_MAP.put("#/components/schemas/io.k8s.apiextensions-apiserver.pkg.apis.apiextensions.v1beta1.JSON",
        "com.fasterxml.jackson.databind.JsonNode");
    REF_TO_JAVA_TYPE_MAP.put("#/components/schemas/io.k8s.apiextensions-apiserver.pkg.apis.apiextensions.v1.JSON",
        "com.fasterxml.jackson.databind.JsonNode");
  }

  private static final Map<String, String> REF_TO_JAVA_PRIMITIVE_MAP = new LinkedHashMap<>();
  static {
    REF_TO_JAVA_PRIMITIVE_MAP.put("#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.Time", STRING_PRIMITIVE);
    REF_TO_JAVA_PRIMITIVE_MAP.put("#/components/schemas/io.k8s.apimachinery.pkg.runtime.RawExtension", OBJECT_PRIMITIVE);
    REF_TO_JAVA_PRIMITIVE_MAP.put("#/components/schemas/com.github.operator-framework.api.pkg.lib.version.OperatorVersion",
        STRING_PRIMITIVE);
    REF_TO_JAVA_PRIMITIVE_MAP.put("#/components/schemas/dev.knative.pkg.apis.URL", STRING_PRIMITIVE);
  }

  private static final Map<String, String> JAVA_CLASS_SERIALIZER_MAP = new LinkedHashMap<>();
  static {
    JAVA_CLASS_SERIALIZER_MAP.put("io.fabric8.kubernetes.api.model.MicroTime",
        "io.fabric8.kubernetes.api.model.MicroTimeSerDes.Serializer.class");
    JAVA_CLASS_SERIALIZER_MAP.put("io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArray",
        "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArraySerDe.Serializer.class");
    JAVA_CLASS_SERIALIZER_MAP.put("io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrArray",
        "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrArraySerDe.Serializer.class");
    JAVA_CLASS_SERIALIZER_MAP.put("io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBool",
        "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBoolSerDe.Serializer.class");
    JAVA_CLASS_SERIALIZER_MAP.put("io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrBool",
        "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrBoolSerDe.Serializer.class");
    JAVA_CLASS_SERIALIZER_MAP.put("io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArray",
        "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArraySerDe.Serializer.class");
    JAVA_CLASS_SERIALIZER_MAP.put("io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrStringArray",
        "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrStringArraySerDe.Serializer.class");
  }

  private static final Map<String, String> JAVA_CLASS_DESERIALIZER_MAP = new LinkedHashMap<>();
  static {
    JAVA_CLASS_DESERIALIZER_MAP.put("io.fabric8.kubernetes.api.model.MicroTime",
        "io.fabric8.kubernetes.api.model.MicroTimeSerDes.Deserializer.class");
    JAVA_CLASS_DESERIALIZER_MAP.put("io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArray",
        "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArraySerDe.Deserializer.class");
    JAVA_CLASS_DESERIALIZER_MAP.put("io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrArray",
        "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrArraySerDe.Deserializer.class");
    JAVA_CLASS_DESERIALIZER_MAP.put("io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBool",
        "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBoolSerDe.Deserializer.class");
    JAVA_CLASS_DESERIALIZER_MAP.put("io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrBool",
        "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrBoolSerDe.Deserializer.class");
    JAVA_CLASS_DESERIALIZER_MAP.put("io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArray",
        "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArraySerDe.Deserializer.class");
    JAVA_CLASS_DESERIALIZER_MAP.put("io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrStringArray",
        "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrStringArraySerDe.Deserializer.class");
    JAVA_CLASS_DESERIALIZER_MAP.put("io.fabric8.openshift.api.model.Template",
        "io.fabric8.openshift.api.model.TemplateDeserializer.class");
  }

  private static final Map<String, String> REF_SERIALIZER_MAP = Collections.emptyMap();// new LinkedHashMap<>();
  //  static {
  //    REF_SERIALIZER_MAP.put("#/components/schemas/io.k8s.apimachinery.pkg.util.intstr.IntOrString", "com.marcnuri.yakc.model.serialization.IntOrStringSerializer.class");
  //  }

  private static final Map<String, String> TYPE_DESERIALIZER_MAP = new LinkedHashMap<>();
  static {
    TYPE_DESERIALIZER_MAP.put(OBJECT_PRIMITIVE, "io.fabric8.kubernetes.internal.KubernetesDeserializer.class");
    TYPE_DESERIALIZER_MAP.put("List<Object>", "io.fabric8.kubernetes.internal.KubernetesDeserializerForList.class");
    TYPE_DESERIALIZER_MAP.put("Map<String, Object>", "io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class");
  }

  private static final Map<String, String> TYPE_MAP = new LinkedHashMap<>();
  static {
    TYPE_MAP.put("boolean", "Boolean");
    TYPE_MAP.put("int32", "Integer");
    TYPE_MAP.put("integer", "Integer");
    TYPE_MAP.put("int64", "Long");
    TYPE_MAP.put("float", "Float");
    TYPE_MAP.put("double", "Double");
    TYPE_MAP.put("number", "Number");
    TYPE_MAP.put("object", OBJECT_PRIMITIVE);
    TYPE_MAP.put("string", STRING_PRIMITIVE);
  }

  private static final Set<String> PROTECTED_WORDS = new HashSet<>(Arrays.asList(
      "abstract",
      "class",
      "continue",
      "default",
      "enum",
      "finally",
      "for",
      "import",
      "int",
      "interface",
      "package",
      "private",
      "public",
      "return",
      "short",
      "static"));

  private static final Map<String, String> MAPPED_WORDS = new LinkedHashMap<>();
  static {
    MAPPED_WORDS.put("class", "className");
  }

  private final GeneratorSettings settings;

  public SchemaUtils(GeneratorSettings settings) {
    this.settings = settings;
  }

  /**
   * Returns the simple class name associated to the provided Schema reference.
   *
   * @param ref the reference to extract the class name from.
   * @return the simple class name associated to the provided Schema reference.
   */
  public static String refToClassName(String ref) {
    return capitalize(ref.substring(ref.lastIndexOf('.') + 1))
        // Remove underscores from Class Names, this doesn't look good in Java :)
        .replace("_", "");
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
   * @param imports import manager to add an import to the class in case it's necessary.
   * @param schema the schema from which to retrieve the mapped Class name.
   * @return String containing the Class name mapped to the provided Schema.
   */
  public String schemaToClassName(ImportManager imports, Schema<?> schema) {
    if (isArray(schema)) {
      final ArraySchema arraySchema = (ArraySchema) schema;
      imports.addImport("java.util.List");
      return String.format("List<%s>", schemaToClassName(imports, arraySchema.getItems()));
    }
    if (isMap(schema)) {
      imports.addImport("java.util.Map"); // Type
      imports.addImport("java.util.LinkedHashMap"); // Default value
      final String valueType;
      if (schema.getAdditionalProperties() instanceof Schema) {
        valueType = schemaToClassName(imports, (Schema<?>) schema.getAdditionalProperties());
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
    if (isRef(schema)) {
      final String ref = schema.get$ref();
      final Optional<String> javaPrimitive = schemaRefToJavaPrimitive(schema);
      if (javaPrimitive.isPresent()) {
        return javaPrimitive.get();
      }
      final String javaType = schemaRefToJavaType(schema);
      if (javaType != null) {
        imports.addImport(javaType);
        return javaType.substring(javaType.lastIndexOf('.') + 1);
      }
      if (imports.hasSimpleClassName(refToModelPackage(ref))) {
        return refToModelPackage(ref);
      } else {
        imports.addImport(refToModelPackage(ref));
        return refToClassName(ref);
      }
    }
    // Plain OpenAPI object map to Object (Model generator will need to annotate field with deserializer to take care of the rest)
    if (isObject(schema)) {
      return OBJECT_PRIMITIVE;
    }
    return schemaTypeToJavaPrimitive(schema);
  }

  public static String classType(Schema<?> schema) {
    if (schema.getExtensions() != null && schema.getExtensions().get("x-kubernetes-fabric8-type") != null) {
      return schema.getExtensions().get("x-kubernetes-fabric8-type").toString();
    }
    return "class";
  }

  public static boolean isEnum(Schema<?> schema) {
    return Objects.equals(classType(schema), "enum");
  }

  public static Set<String> enumValues(Schema<?> schema) {
    if (isEnum(schema) && schema.getExtensions().containsKey("x-kubernetes-fabric8-enum-values")) {
      return Set.of(schema.getExtensions().get("x-kubernetes-fabric8-enum-values").toString().split(","));
    }
    return Collections.emptySet();
  }

  public static boolean isInterface(Schema<?> schema) {
    return Objects.equals(classType(schema), "interface");
  }

  public static boolean hasInterfaceFields(Schema<?> schema) {
    return schema.getExtensions() != null
        && schema.getExtensions().containsKey("x-kubernetes-fabric8-interface-fields");
  }

  public static Set<String> interfaceFields(Schema<?> schema) {
    if (hasInterfaceFields(schema)) {
      return Set.of(schema.getExtensions().get("x-kubernetes-fabric8-interface-fields").toString().split(","));
    }
    return Collections.emptySet();
  }

  public static List<String> interfaceImplementation(Schema<?> schema) {
    if (schema.getExtensions() != null && schema.getExtensions().containsKey("x-kubernetes-fabric8-implementation")) {
      return Stream.of(schema.getExtensions().get("x-kubernetes-fabric8-implementation").toString().split(","))
          .map(SchemaUtils::refToClassName)
          .sorted()
          .collect(Collectors.toList());
    }
    return Collections.emptyList();
  }

  public static String interfaceImplemented(Schema<?> schema) {
    if (schema.getExtensions() != null && schema.getExtensions().containsKey("x-kubernetes-fabric8-implements")) {
      return refToClassName(schema.getExtensions().get("x-kubernetes-fabric8-implements").toString());
    }
    return null;
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
        && Objects.equals(settings.getObjectMetaClass(), schemaRefToJavaType(schema.getProperties().get("metadata")));
  }

  public static boolean isMap(Schema<?> schema) {
    if (schema != null && schema.getAdditionalProperties() instanceof Schema) {
      return true;
    }
    if (schema != null && schema.getAdditionalProperties() instanceof Boolean
        && (Boolean) schema.getAdditionalProperties()) {
      return true;
    }
    return schema instanceof MapSchema;
  }

  public static boolean isRef(Schema<?> schema) {
    return schema != null && schema.get$ref() != null && !schema.get$ref().trim().isEmpty();
  }

  public static boolean isObject(Schema<?> schema) {
    return schema != null && Objects.equals("object", schema.getType());
  }

  public boolean isString(Schema<?> schema) {
    final String ref = schema.get$ref();
    if (ref != null && (REF_TO_JAVA_PRIMITIVE_MAP.containsKey(ref) || schemaRefToJavaType(schema) != null)) {
      return false;
    }
    return schema instanceof StringSchema || isRefInstanceOf(ref, StringSchema.class);
  }

  public boolean isRefInstanceOf(String ref, Class<?> clazz) {
    if (ref == null) {
      return false;
    }
    return settings.getOpenAPI().getComponents().getSchemas().entrySet().stream()
        .filter(entry -> clazz.isInstance(entry.getValue()))
        .anyMatch(entry -> ref.endsWith(entry.getKey()));
  }

  public String kubernetesListType(ImportManager imports, Schema<?> schema) {
    if (!isObject(schema)) {
      return null;
    }
    return Optional.ofNullable(schema.getProperties())
        .map(p -> p.get("items"))
        .filter(s -> s instanceof ArraySchema)
        .map(s -> (ArraySchema) s)
        .map(as -> schemaToClassName(imports, as.getItems()))
        .orElse(null);
  }

  private static Optional<String> schemaRefToJavaPrimitive(Schema<?> schema) {
    return Optional.ofNullable(REF_TO_JAVA_PRIMITIVE_MAP.get(schema.get$ref()));
  }

  private String schemaRefToJavaType(Schema<?> schema) {
    if (settings.getRefToJavaTypeMappings().containsKey(schema.get$ref())) {
      return settings.getRefToJavaTypeMappings().getProperty(schema.get$ref());
    }
    return REF_TO_JAVA_TYPE_MAP.get(schema.get$ref());
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
        .replace('“', '"')
        .replace('”', '"')
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

  public String sanitizeFieldName(String fieldName) {
    final String sanitized = uncapitalize(removeDashes(fieldName));
    final String mapped = MAPPED_WORDS.getOrDefault(sanitized, sanitized);
    final String userMapped = settings.getFieldNameMappings().getOrDefault(mapped, mapped);
    return PROTECTED_WORDS.contains(userMapped) ? "_" + userMapped : userMapped;
  }

  public static String getterName(String variable) {
    final String property = removeDashes(variable);
    final String mapped = MAPPED_WORDS.getOrDefault(property, property);
    return "get".concat(capitalize(mapped));
  }

  public static String setterName(String variable) {
    final String property = removeDashes(variable);
    final String mapped = MAPPED_WORDS.getOrDefault(property, property);
    return "set".concat(capitalize(mapped));
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

  public static String deserializerForType(String type) {
    if (TYPE_DESERIALIZER_MAP.containsKey(type)) {
      return TYPE_DESERIALIZER_MAP.get(type);
    }
    return null;
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

  public static OpenAPI mergeSchemas(Collection<OpenAPI> schemas) {
    final OpenAPI openAPI = new OpenAPI(SpecVersion.V31);
    openAPI.setComponents(new Components());
    openAPI.getComponents().setSchemas(new HashMap<>());
    openAPI.getComponents().setResponses(new HashMap<>());
    openAPI.getComponents().setParameters(new HashMap<>());
    openAPI.getComponents().setExamples(new HashMap<>());
    openAPI.getComponents().setRequestBodies(new HashMap<>());
    openAPI.getComponents().setHeaders(new HashMap<>());
    openAPI.getComponents().setSecuritySchemes(new HashMap<>());
    openAPI.getComponents().setLinks(new HashMap<>());
    openAPI.getComponents().setCallbacks(new HashMap<>());
    openAPI.getComponents().setExtensions(new HashMap<>());
    openAPI.setPaths(new Paths());
    int apiCounter = 0;
    for (OpenAPI currentApi : schemas) {
      apiCounter++;
      // Merge Paths
      for (Map.Entry<String, PathItem> paths : currentApi.getPaths().entrySet()) {
        // Let's preserve the existing paths in case multiple versions of the same schema are added
        // This is necessary for proper computation of APIVersion for the components
        // We do this bases in the paths instead of the x-kubernetes-group-version-kind extension of the component
        // because it's the only way to figure out if the object is namespaced or cluster scoped
        if (openAPI.getPaths().containsKey(paths.getKey())) {
          openAPI.getPaths().addPathItem(paths.getKey() + "/" + apiCounter, paths.getValue());
        } else {
          openAPI.getPaths().addPathItem(paths.getKey(), paths.getValue());
        }
      }
      // Merge components
      if (currentApi.getComponents() != null) {
        Optional.ofNullable(currentApi.getComponents().getSchemas()).ifPresent(openAPI.getComponents().getSchemas()::putAll);
        Optional.ofNullable(currentApi.getComponents().getResponses())
            .ifPresent(openAPI.getComponents().getResponses()::putAll);
        Optional.ofNullable(currentApi.getComponents().getParameters())
            .ifPresent(openAPI.getComponents().getParameters()::putAll);
        Optional.ofNullable(currentApi.getComponents().getExamples()).ifPresent(openAPI.getComponents().getExamples()::putAll);
        Optional.ofNullable(currentApi.getComponents().getRequestBodies())
            .ifPresent(openAPI.getComponents().getRequestBodies()::putAll);
        Optional.ofNullable(currentApi.getComponents().getHeaders()).ifPresent(openAPI.getComponents().getHeaders()::putAll);
      }
    }
    return openAPI;
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
