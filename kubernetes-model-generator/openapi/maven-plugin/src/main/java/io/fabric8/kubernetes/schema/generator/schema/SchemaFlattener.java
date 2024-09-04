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
package io.fabric8.kubernetes.schema.generator.schema;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Alternative to InlineModelResolver to extract inline schemas into reusable schemas.
 *
 * Check the see also section for the original implementations.
 *
 * @see <a href=
 *      "https://github.com/OpenAPITools/openapi-generator/blob/057647cf1ee0793f2987e89f8a588aa3db3ceb5d/modules/openapi-generator/src/main/java/org/openapitools/codegen/InlineModelResolver.java">InlineModelResolver</a>
 * @see <a href=
 *      "https://github.com/manusa/yakc/blob/9272d649bfe05cd536d417fec64dcf679877bd14/buildSrc/src/main/java/com/marcnuri/yakc/schema/InlineModelResolver.java">InlineModelResolver
 *      (YAKC)</a>
 */
public class SchemaFlattener {

  private static final String PACKAGE_SEPARATOR_CHARACTER = ".";
  private static final String SEPARATOR_CHARACTER = "_";

  private static final Set<String> preservedNames = ConcurrentHashMap.newKeySet();
  static {
    preservedNames.add("spec");
    preservedNames.add("status");
    // makes class names in openshift-model-config more user-friendly
    preservedNames.add("aws");
    preservedNames.add("azure");
    preservedNames.add("baremetal");
    preservedNames.add("gcp");
    preservedNames.add("ibmcloud");
    preservedNames.add("libvirt");
    preservedNames.add("nutanix");
    preservedNames.add("none");
    preservedNames.add("openstack");
    preservedNames.add("ovirt");
    preservedNames.add("powervs");
    preservedNames.add("vsphere");
    preservedNames.add("basicAuth");
    preservedNames.add("openID");
  }
  private static final ObjectMapper structureMapper = Json.mapper().copy();
  static {
    structureMapper.getSerializationConfig().with(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
    structureMapper.writer(new DefaultPrettyPrinter());
  }

  private SchemaFlattener() {
  }

  public static void flatten(OpenAPI model) {
    final SchemaFlattenerContext context = SchemaFlattenerContext.get(model);
    flattenComponents(context);
    context.getComponents().getSchemas().putAll(context.componentsToAdd);
    SchemaFlattenerContext.clear(model);
  }

  private static void flattenComponents(SchemaFlattenerContext context) {
    for (String componentKey : context.getComponents().getSchemas().keySet()) {
      final Schema<?> componentSchema = context.getComponents().getSchemas().get(componentKey);
      flattenProperties(context, componentSchema, ComponentName.resolve(componentSchema, componentKey));
    }
  }

  private static void flattenProperties(SchemaFlattenerContext context, Schema<?> schema, ComponentName path) {
    if (schema.getProperties() == null || schema.getProperties().isEmpty()) {
      return;
    }
    final Map<String, Schema<?>> propertiesToUpdate = new HashMap<>();
    for (String propertyKey : schema.getProperties().keySet()) {
      final Schema<?> propertySchema = schema.getProperties().get(propertyKey);
      final ComponentName flatComponentName = path.inline(propertySchema, propertyKey);
      if (propertySchema instanceof ObjectSchema && propertySchema.getProperties() != null
          && !propertySchema.getProperties().isEmpty()) {
        final ObjectSchema objectSchema = (ObjectSchema) propertySchema;
        flattenProperties(context, objectSchema, flatComponentName);
        propertiesToUpdate.put(propertyKey, context.toRef(objectSchema, flatComponentName));
      } else if (SchemaUtils.isArray(propertySchema)) {
        final Schema<?> arrayItemsSchema = propertySchema.getItems();
        if (arrayItemsSchema instanceof ObjectSchema && arrayItemsSchema.getProperties() != null
            && !arrayItemsSchema.getProperties().isEmpty()) {
          flattenProperties(context, arrayItemsSchema, flatComponentName);
          propertySchema.setItems(context.toRef(arrayItemsSchema, flatComponentName));
        }
      } else if (SchemaUtils.isMap(propertySchema) && propertySchema.getAdditionalProperties() instanceof Schema) {
        final Schema<?> additionalPropertiesSchema = (Schema<?>) propertySchema.getAdditionalProperties();
        if (additionalPropertiesSchema instanceof ObjectSchema && additionalPropertiesSchema.getProperties() != null
            && !additionalPropertiesSchema.getProperties().isEmpty()) {
          flattenProperties(context, additionalPropertiesSchema, flatComponentName);
          propertySchema.setAdditionalProperties(context.toRef(additionalPropertiesSchema, flatComponentName));
        }
      }
    }
    for (Map.Entry<String, Schema<?>> entry : propertiesToUpdate.entrySet()) {
      schema.getProperties().put(entry.getKey(), entry.getValue());
    }
  }

  /**
   * Context to keep track of the current schema flattening process.
   * <p>
   * Should be cleared from the OpenAPI model after the flattening process is done.
   */
  private static final class SchemaFlattenerContext {

    private static final String CONTEXT_KEY = SchemaFlattenerContext.class.getName();

    /**
     * Retrieves the context from the provided OpenAPI extensions.
     *
     * @param openAPI the openAPI instance where the context is stored.
     * @return the context.
     */
    private static synchronized SchemaFlattenerContext get(OpenAPI openAPI) {
      if (openAPI.getExtensions() == null) {
        openAPI.setExtensions(new HashMap<>());
      }
      return (SchemaFlattenerContext) openAPI.getExtensions()
          .computeIfAbsent(CONTEXT_KEY, k -> new SchemaFlattenerContext(openAPI));
    }

    /**
     * Remove the context from the OpenAPI extensions.
     *
     * @param openAPI the openAPI instance where the context is stored.
     */
    private static synchronized void clear(OpenAPI openAPI) {
      if (openAPI.getExtensions() != null) {
        openAPI.getExtensions().remove(CONTEXT_KEY);
      }
    }

    private final OpenAPI openAPI;
    private final Set<String> uniqueNames;
    private final Map<String, String> reusableComponentSignatures;
    private final Map<String, Schema<?>> componentsToAdd;

    public SchemaFlattenerContext(OpenAPI openAPI) {
      this.openAPI = openAPI;
      if (openAPI.getComponents() == null) {
        openAPI.setComponents(new Components());
      }
      if (openAPI.getComponents().getSchemas() == null) {
        openAPI.getComponents().setSchemas(new HashMap<>());
      }
      uniqueNames = ConcurrentHashMap.newKeySet();
      reusableComponentSignatures = new HashMap<>();
      // Compute signatures of all defined components to be able to reuse them from inlined component definitions
      for (String key : openAPI.getComponents().getSchemas().keySet()) {
        reusableComponentSignatures.put(toJson(openAPI.getComponents().getSchemas().get(key)), key);
      }
      componentsToAdd = new ConcurrentHashMap<>();
    }

    Components getComponents() {
      return openAPI.getComponents();
    }

    void addComponentSchema(String key, Schema<?> componentSchema) {
      componentsToAdd.put(key, componentSchema);
    }

    Schema<?> toRef(Schema<?> schema, ComponentName componentName) {
      final String existingModelName = reusableComponentSignatures.getOrDefault(toJson(schema), null);
      final Schema<?> refSchema = new Schema<>();
      refSchema.setRequired(schema.getRequired());
      if (existingModelName != null) {
        refSchema.$ref(existingModelName);
      } else {
        final String uniqueName = uniqueName(componentName.toString());
        refSchema.$ref(uniqueName);
        addComponentSchema(uniqueName, schema);
      }
      return refSchema;
    }

    private String toJson(Schema<?> schema) {
      try {
        return structureMapper.writeValueAsString(schema);
      } catch (JsonProcessingException e) {
        throw new IllegalArgumentException("Error serializing schema to JSON", e);
      }
    }

    private String uniqueName(final String name) {
      String uniqueName = name;
      int count = 0;
      while (true) {
        if (!uniqueNames.contains(uniqueName) && !getComponents().getSchemas().containsKey(uniqueName)) {
          uniqueNames.add(uniqueName);
          return uniqueName;
        }
        uniqueName = name + SEPARATOR_CHARACTER + ++count;
      }
    }
  }

  private static final class ComponentName {

    private final String pkg;
    private final List<String> nameParts;

    static ComponentName resolve(Schema<?> schema, String key) {
      final ComponentName componentName;
      if (schema.getTitle() != null && !schema.getTitle().isEmpty()) {
        componentName = new ComponentName(schema.getTitle());
      } else {
        componentName = new ComponentName(key);
      }
      return componentName;
    }

    private ComponentName(String name) {
      final String simpleClassName;
      if (name.contains(PACKAGE_SEPARATOR_CHARACTER)) {
        pkg = name.substring(0, name.lastIndexOf(PACKAGE_SEPARATOR_CHARACTER));
        simpleClassName = name.substring(name.lastIndexOf(PACKAGE_SEPARATOR_CHARACTER) + 1);
      } else {
        pkg = "";
        simpleClassName = name;
      }
      nameParts = Arrays.stream(simpleClassName.split(SEPARATOR_CHARACTER, 0))
          .filter(s -> !s.isEmpty())
          .collect(Collectors.toList());

    }

    private ComponentName(String pkg, List<String> nameParts) {
      this.pkg = pkg;
      this.nameParts = nameParts;
    }

    ComponentName inline(Schema<?> schema, String path) {
      if (schema.getTitle() != null && !schema.getTitle().isEmpty()) {
        return new ComponentName(schema.getTitle());
      }
      if (path.isEmpty()) {
        throw new IllegalArgumentException("Path cannot be empty");
      }
      final ComponentName inline = new ComponentName(pkg, new ArrayList<>(nameParts));
      inline.nameParts.add(path);
      return inline;
    }

    // Avoid creating extremely enterprise-like names such as InfrastructureSpecPlatformSpecVsphereNodeNetworkingExternal
    // Prefer InfrastructureSPSVNNetworkingExternal
    public String toString() {
      final StringBuilder sb = new StringBuilder();
      if (!pkg.isEmpty()) {
        sb.append(pkg).append(PACKAGE_SEPARATOR_CHARACTER);
      }
      // First part is always preserved
      sb.append(nameParts.get(0));
      // Middle parts are contracted (unless preserved)
      for (int it = 1; it < nameParts.size() - 1; it++) {
        final String part = nameParts.get(it);
        if (preservedNames.contains(part)) {
          sb.append(part.substring(0, 1).toUpperCase()).append(part.substring(1));
        } else {
          sb.append(contract(part));
        }
      }
      // Last part is capitalized
      if (nameParts.size() > 1) {
        final String lastPart = nameParts.get(nameParts.size() - 1);
        sb.append(lastPart.substring(0, 1).toUpperCase());
        sb.append(lastPart.substring(1));
      }
      return sb.toString();
    }
  }

  private static String contract(String word) {
    final StringBuilder sb = new StringBuilder();
    sb.append(word.substring(0, 1).toUpperCase());
    boolean inWord = true;
    for (int i = 1; i < word.length(); i++) {
      final char c = word.charAt(i);
      if (!inWord && Character.isUpperCase(c)) {
        sb.append(c);
        inWord = true;
      } else if (inWord && Character.isLowerCase(c)) {
        inWord = false;
      }
    }
    return sb.toString();
  }
}
