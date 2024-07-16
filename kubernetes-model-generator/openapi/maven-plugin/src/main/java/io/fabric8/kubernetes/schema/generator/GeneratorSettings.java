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
// Ported from https://github.com/manusa/yakc/blob/9272d649bfe05cd536d417fec64dcf679877bd14/buildSrc/src/main/java/com/marcnuri/yakc/schema/GeneratorSettings.java
package io.fabric8.kubernetes.schema.generator;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.parser.OpenAPIV3Parser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static io.fabric8.kubernetes.schema.generator.SchemaUtils.APPLICATION_JSON;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GeneratorSettings {
  private Logger logger;
  @Singular
  private List<File> schemas;
  private OpenAPI openAPI;
  private Map<String, ApiVersion> apiVersions;
  private File outputDirectory;
  private File generatedSourcesDirectory;
  private File overridesDirectory;
  /**
   * Base package for generated classes.
   * <p>
   * Adjust with {@link #packageMappings} to place generated classes in different packages.
   */
  private String packageName;
  /**
   * Target package for Sundrio-generated builder classes.
   */
  private String builderPackage;
  /**
   * Whether to add buildable references to generated classes.
   *
   * <p>
   * This is required for Sundrio when the references buildables are located at different modules and packages.
   */
  private boolean addBuildableReferences;
  @Singular
  private Map<String, String> packageMappings;
  private final AtomicBoolean packageMappingsProcessed = new AtomicBoolean(false);
  @Singular
  private Set<String> skipGenerationRegexes;
  @Singular
  private Set<String> includeGenerationRegexes;
  private boolean generateJavadoc;
  @Builder.Default
  private final String genericKubernetesResourceClass = "io.fabric8.kubernetes.api.model.GenericKubernetesResource";
  @Builder.Default
  private final String hasMetadataClass = "io.fabric8.kubernetes.api.model.HasMetadata";
  @Builder.Default
  private final String kubernetesResourceClass = "io.fabric8.kubernetes.api.model.KubernetesResource";
  @Builder.Default
  private final String kubernetesResourceListClass = "io.fabric8.kubernetes.api.model.KubernetesResourceList";
  @Builder.Default
  private final String objectMetaClass = "io.fabric8.kubernetes.api.model.ObjectMeta";
  @Builder.Default
  private final String namespacedClass = "io.fabric8.kubernetes.api.model.Namespaced";
  @Builder.Default
  private final String rawExtensionClass = "io.fabric8.kubernetes.api.model.runtime.RawExtension";
  @Builder.Default
  private final List<String> buildableReferences = Arrays.asList(
      "io.fabric8.kubernetes.api.model.LabelSelector",
      "io.fabric8.kubernetes.api.model.Container",
      "io.fabric8.kubernetes.api.model.PodTemplateSpec",
      "io.fabric8.kubernetes.api.model.ResourceRequirements",
      "io.fabric8.kubernetes.api.model.IntOrString",
      "io.fabric8.kubernetes.api.model.ObjectReference",
      "io.fabric8.kubernetes.api.model.LocalObjectReference",
      "io.fabric8.kubernetes.api.model.PersistentVolumeClaim");

  public OpenAPI getOpenAPI() {
    synchronized (this) {
      if (openAPI == null) {
        openAPI = mergeSchemas(schemas);
      }
    }
    return openAPI;
  }

  public Map<String, ApiVersion> getApiVersions() {
    synchronized (this) {
      if (apiVersions == null) {
        apiVersions = computeApiVersions(getOpenAPI());
      }
    }
    return apiVersions;
  }

  public synchronized File getGeneratedSourcesDirectory() {
    if (generatedSourcesDirectory == null) {
      generatedSourcesDirectory = getOutputDirectory().toPath()
          .resolve("src").resolve("generated").resolve("java").toFile();
    }
    return generatedSourcesDirectory;
  }

  public synchronized File getOverridesDirectory() {
    if (overridesDirectory == null) {
      overridesDirectory = getOutputDirectory().toPath()
          .resolve("src").resolve("main").resolve("java").toFile();
    }
    return overridesDirectory;
  }

  // Package Mappings
  // Need to be sorted in reverse order so that resolution favors grandParent.parent.child over grandParent.parent
  public Map<String, String> getPackageMappings() {
    if (packageMappings == null) {
      return Collections.emptyMap();
    }
    if (!packageMappingsProcessed.getAndSet(true)) {
      synchronized (this) {
        packageMappings = Collections.unmodifiableMap(packageMappings.keySet().stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toMap(k -> k, packageMappings::get, (v1, v2) -> v2, LinkedHashMap::new)));
      }
    }
    return packageMappings;
  }

  public String getHasMetadataClassSimpleName() {
    return hasMetadataClass.substring(hasMetadataClass.lastIndexOf('.') + 1);
  }

  public String getKubernetesResourceClassSimpleName() {
    return kubernetesResourceClass.substring(kubernetesResourceClass.lastIndexOf('.') + 1);
  }

  public String getKubernetesResourceListClassSimpleName() {
    return kubernetesResourceListClass.substring(kubernetesResourceListClass.lastIndexOf('.') + 1);
  }

  public String getNamespacedClassSimpleName() {
    return namespacedClass.substring(namespacedClass.lastIndexOf('.') + 1);
  }

  private static Map<String, ApiVersion> computeApiVersions(OpenAPI openAPI) {
    final Map<String, ApiVersion> apiVersions = new HashMap<>();
    final List<Map.Entry<String, PathItem>> apiPaths = openAPI.getPaths().entrySet().stream()
        .filter(e -> isApplicablePath(e.getValue()))
        .collect(Collectors.toList());
    for (Map.Entry<String, PathItem> apiPath : apiPaths) {
      for (Operation operation : new Operation[] { apiPath.getValue().getGet(), apiPath.getValue().getPost() }) {
        if (operation == null
            || operation.getResponses().get("200") == null
            || operation.getResponses().get("200").getContent().get(APPLICATION_JSON) == null) {
          continue;
        }
        final String path = apiPath.getKey();
        final String[] segments = path.split("/");
        final ApiVersion.ApiVersionBuilder apiVersionBuilder = ApiVersion.builder();
        if (path.startsWith("/apis/") && segments.length > 3) {
          apiVersionBuilder.group(segments[2]).version(segments[3]);
        } else {
          apiVersionBuilder.group("").version("v1");
        }
        apiVersionBuilder.namespaced(isNamespaced(operation));
        final String ref = operation.getResponses().get("200").getContent().get(APPLICATION_JSON)
            .getSchema().get$ref();
        if (ref != null && !ref.startsWith("#/components/schemas/io.k8s.apimachinery.pkg.apis")) {
          apiVersions.put(ref.replaceFirst("#/components/schemas/", ""), apiVersionBuilder.build());
        }
      }
      // api machinery components always tagged as core v1
      // TODO: see if we want to omit the addition of group and version altogether in the future
      openAPI.getComponents().getSchemas().entrySet().stream()
          .filter(GeneratorSettings::isApplicableApiMachineryComponent)
          .forEach(e -> apiVersions.put(e.getKey(), ApiVersion.builder().group("").version("v1").build()));
    }
    return apiVersions;
  }

  private static boolean isApplicablePath(PathItem pathItem) {
    final Operation get = pathItem.getGet();
    final Operation post = pathItem.getPost();
    if (get == null && post == null) {
      return false;
    }
    // Lists (e.g. PodList)
    if (pathParameters(get).isEmpty() || (isNamespaced(get) && pathParameters(get).size() == 1)) {
      return true;
    }
    // Named resources (e.g. Pod, ComponentStatus)
    return pathParameters(get).stream().map(Parameter::getName).anyMatch("name"::equals) ||
        pathParameters(post).stream().map(Parameter::getName).anyMatch("name"::equals);
  }

  private static boolean isApplicableApiMachineryComponent(Map.Entry<String, Schema> componentSchema) {
    if (!componentSchema.getKey().startsWith("io.k8s.apimachinery.pkg.apis")) {
      return false;
    }
    if (componentSchema.getValue().getProperties() == null) {
      return false;
    }
    final Set<String> fields = componentSchema.getValue().getProperties().keySet();
    return fields.contains("apiVersion") && fields.contains("kind");
  }

  private static boolean isNamespaced(Operation operation) {
    final List<Parameter> parameters = pathParameters(operation);
    return parameters.stream().map(Parameter::getName).anyMatch("namespace"::equals);
  }

  private static List<Parameter> pathParameters(Operation operation) {
    if (operation == null || operation.getParameters() == null) {
      return Collections.emptyList();
    }
    return operation.getParameters().stream().filter(p -> p.getIn().equals("path"))
        .collect(Collectors.toList());
  }

  private static OpenAPI mergeSchemas(List<File> schemas) {
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
    for (File schema : schemas) {
      if (schema == null || !schema.exists()) {
        throw new IllegalArgumentException("Schema file not found: " + schema);
      }
      final OpenAPI currentApi = new OpenAPIV3Parser().read(schema.getAbsolutePath());
      new InlineModelResolver().flatten(currentApi);
      openAPI.getPaths().putAll(currentApi.getPaths());
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
}
