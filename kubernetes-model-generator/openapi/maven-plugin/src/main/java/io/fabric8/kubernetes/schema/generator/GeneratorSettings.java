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

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static io.fabric8.kubernetes.schema.generator.schema.SchemaUtils.APPLICATION_JSON;
import static io.fabric8.kubernetes.schema.generator.schema.SchemaUtils.mergeSchemas;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GeneratorSettings {
  private Logger logger;
  @Singular
  private List<File> schemas;
  @Singular
  private List<String> urls;
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
  /**
   * Allows configuring the mapping of OpenAPI references to Java class names.
   * <p>
   * We can use this to customize the name of a generated class.
   */
  @Builder.Default
  private Properties refToClassNameMappings = new Properties();
  /**
   * Allows configuring the mapping of OpenAPI references to <b>existing</b> Java classes.
   * <p>
   * This is useful when the OpenAPI schema references classes that are already present in the classpath and
   * we don't want to generate.
   */
  @Builder.Default
  private Properties refToJavaTypeMappings = new Properties();
  /**
   * Allows configuring the mapping of specific field names to other names.
   * <p>
   * This is currently needed as a workaround for Sundrio's issues when generating builders when a class has two
   * List or array fields with a plural and singular.
   * <p>
   * For example, when a class has both `List<String> items` and `List<String></String> item`, Sundrio generates a
   * fluent builder with conflicting names such as buildItem(int), buildFirstItem(), and so on.
   */
  @Singular
  private Map<String, String> fieldNameMappings;
  @Singular
  private Set<String> skipGenerationRegexes;
  @Singular
  private Set<String> includeGenerationRegexes;
  private boolean generateJavadoc;
  @Builder.Default
  private boolean generateGraalVmReflectConfig = false;
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
      "io.fabric8.kubernetes.api.model.PersistentVolumeClaim",
      "io.fabric8.kubernetes.api.model.EnvVar",
      "io.fabric8.kubernetes.api.model.ContainerPort",
      "io.fabric8.kubernetes.api.model.Volume",
      "io.fabric8.kubernetes.api.model.VolumeMount");

  public OpenAPI getOpenAPI() {
    synchronized (this) {
      if (openAPI == null) {
        final List<OpenAPI> openApis = new ArrayList<>();
        schemas.stream().map(GeneratorUtils::parse).forEach(openApis::add);
        urls.stream().map(URI::create).map(GeneratorUtils::parse).forEach(openApis::add);
        openAPI = mergeSchemas(openApis);
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
            || operation.getResponses().get("200").getContent().get(APPLICATION_JSON) == null
            || operation.getExtensions() == null
            || operation.getExtensions().get("x-kubernetes-group-version-kind") == null) {
          continue;
        }
        final ApiVersion.ApiVersionBuilder apiVersionBuilder = ApiVersion.builder();
        //        final String path = apiPath.getKey();
        //        final String[] segments = path.split("/");
        //        if (path.startsWith("/apis/") && segments.length > 3) {
        //          apiVersionBuilder.group(segments[2]).version(segments[3]);
        //        } else {
        //          apiVersionBuilder.group("").version("v1");
        //        }
        final Map<String, String> groupVersionKind = (Map<String, String>) operation.getExtensions()
            .get("x-kubernetes-group-version-kind");
        apiVersionBuilder.group(groupVersionKind.get("group"));
        apiVersionBuilder.version(groupVersionKind.get("version"));
        apiVersionBuilder.namespaced(isNamespaced(operation));
        final String ref = operation.getResponses().get("200").getContent().get(APPLICATION_JSON)
            .getSchema().get$ref();
        if (ref != null && !ref.startsWith("#/components/schemas/io.k8s.apimachinery.pkg.apis")) {
          apiVersions.put(ref.replaceFirst("#/components/schemas/", ""), apiVersionBuilder.build());
        }
      }
    }
    openAPI.getComponents().getSchemas().entrySet().stream()
        .filter(e -> e.getValue().getExtensions() != null)
        .filter(e -> e.getValue().getExtensions().containsKey("x-fabric8-info"))
        .forEach(e -> {
          final Map<String, Object> fabric8Info = (Map<String, Object>) e.getValue().getExtensions().get("x-fabric8-info");
          // Consider only Kubernetes object and list types (top-level resources)
          if (!Objects.equals(fabric8Info.get("Type"), "nested")) {
            apiVersions.putIfAbsent(e.getKey(),
                ApiVersion.builder()
                    .group(fabric8Info.get("Group").toString())
                    .version(fabric8Info.get("Version").toString())
                    .namespaced(Objects.equals(fabric8Info.get("Scope").toString(), "Namespaced"))
                    .build());
          }
        });
    // api machinery + core components always tagged as core v1
    // TODO: see if we want to omit the addition of group and version altogether in the future
    openAPI.getComponents().getSchemas().entrySet().stream()
        .filter(GeneratorSettings::isApplicableApiMachineryOrCoreComponent)
        .forEach(e -> apiVersions.putIfAbsent(e.getKey(), ApiVersion.builder().group("").version("v1").build()));
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

  private static boolean isApplicableApiMachineryOrCoreComponent(Map.Entry<String, Schema> componentSchema) {
    if (!componentSchema.getKey().startsWith("io.k8s.apimachinery.pkg.apis")
        && !componentSchema.getKey().startsWith("io.k8s.api.core.v1.PodExecOptions")) {
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

}
