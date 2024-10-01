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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;
import io.swagger.v3.core.util.DeserializationModule31;
import io.swagger.v3.core.util.Json31;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.parser.OpenAPIV3Parser;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CrdParser {

  private static final ObjectMapper objectMapper = new ObjectMapper();
  private static final YAMLFactory yaml = new YAMLFactory(objectMapper);
  static {
    objectMapper.registerModule(new DeserializationModule31());
  }

  private static final Schema<Object> objectMeta = new Schema<>();
  static {
    objectMeta.$ref("#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta");
  }

  private static final Schema<Object> listMeta = new Schema<>();
  static {
    listMeta.$ref("#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.ListMeta");
  }

  public static OpenAPI crdToOpenApi(URI crdUri) throws IOException {
    final YAMLParser parser = yaml.createParser(crdUri.toURL());
    final List<JsonNode> crds = objectMapper.readValues(parser, JsonNode.class)
        .readAll()
        .stream()
        .filter(node -> node.path("apiVersion").asText().equals("apiextensions.k8s.io/v1"))
        .filter(node -> node.path("kind").asText().equals("CustomResourceDefinition"))
        .filter(node -> node.path("spec").path("versions").isArray())
        .collect(Collectors.toList());
    final OpenAPI openAPI = new OpenAPI(SpecVersion.V31);
    openAPI.setInfo(new Info().title(""));
    openAPI.setPaths(new Paths());
    openAPI.setComponents(new Components());
    openAPI.getComponents().setSchemas(new HashMap<>());
    for (JsonNode crd : crds) {
      openAPI.getInfo().setTitle(openAPI.getInfo().getTitle() + crd.path("metadata").path("name").asText() + ";");
      for (Iterator<JsonNode> it = crd.path("spec").path("versions").elements(); it.hasNext();) {
        final JsonNode crdVersion = it.next();
        final GroupVersionKind gvk = new GroupVersionKind();
        gvk.group = crd.path("spec").path("group").asText();
        gvk.version = crdVersion.path("name").asText();
        gvk.kind = crd.path("spec").path("names").path("kind").asText();
        gvk.plural = crd.path("spec").path("names").path("plural").asText();
        gvk.namespaced = crd.path("spec").path("scope").asText().equals("Namespaced");
        final JsonNode openAPIV3Schema = crdVersion.path("schema").path("openAPIV3Schema");
        final ObjectSchema schema = objectMapper.convertValue(openAPIV3Schema, ObjectSchema.class);
        if (schema.getProperties().get("metadata") == null) {
          continue;
        }
        // Object Type
        schema.getProperties().put("metadata", objectMeta);
        openAPI.getPaths().addPathItem(gvk.getApiPath(), gvk.toPathItem());
        openAPI.getComponents().getSchemas().put(gvk.getRef(), schema);
        // List Type
        openAPI.getPaths().addPathItem(gvk.getListApiPath(), gvk.toListPathItem());
        openAPI.getComponents().getSchemas().put(gvk.getListRef(), listSchema(gvk));
      }
    }
    final File tempOpenApi = Files.createTempFile("openapi", ".json").toFile();
    Objects.requireNonNull(tempOpenApi.setReadable(true, true) ? true : null, "Unable to set readable");
    Objects.requireNonNull(tempOpenApi.setWritable(true, true) ? true : null, "Unable to set writeable");
    Objects.requireNonNull(tempOpenApi.setExecutable(true, true) ? true : null, "Unable to set executable");
    tempOpenApi.deleteOnExit();
    // Writing to a file and parsing it fixes any issue with the computed OpenAPI values, this step is necessary
    Json31.pretty().writeValue(tempOpenApi, openAPI);
    return new OpenAPIV3Parser().read(tempOpenApi.getAbsolutePath());
  }

  private static Schema<Object> listSchema(GroupVersionKind gvk) {
    final ObjectSchema ret = new ObjectSchema();
    ret.addProperty("apiVersion", new StringSchema());
    ret.addProperty("items", new ArraySchema().items(new Schema<>().$ref(gvk.getComponentRef())));
    ret.addProperty("kind", new StringSchema());
    ret.addProperty("metadata", listMeta);
    return ret;
  }

  @Getter
  private static class GroupVersionKind {
    String group;
    String version;
    String kind;
    String plural;
    boolean namespaced;

    private String getRef() {
      final String[] groupParts = group.split("\\.");
      final StringBuilder ret = new StringBuilder();
      for (int it = groupParts.length - 1; it >= 0; it--) {
        ret.append(groupParts[it]).append(".");
      }
      return ret.append(plural).append(".").append(version).append(".").append(kind).toString();
    }

    private String getListRef() {
      return getRef() + "List";
    }

    private String getComponentRef() {
      return "#/components/schemas/" + getRef();
    }

    private String getListComponentRef() {
      return getComponentRef() + "List";
    }

    private String getApiPath() {
      final StringBuilder apiPath = new StringBuilder()
          .append("/apis/").append(group).append("/").append(version);
      if (namespaced) {
        apiPath.append("/namespaces/{namespace}");
      }
      apiPath.append("/").append(plural);
      apiPath.append("/{name}");
      return apiPath.toString();
    }

    private PathItem toPathItem() {
      final PathItem ret = new PathItem();
      ret.operation(PathItem.HttpMethod.GET, new Operation());
      if (namespaced) {
        ret.getGet().addParametersItem(new Parameter().name("namespace").in("path").required(true));
      }
      final Content content = new Content()
          .addMediaType("application/json", new MediaType().schema(new Schema<>().$ref(getListComponentRef())));
      ret.getGet().responses(new ApiResponses().addApiResponse(
          "200", new ApiResponse().description("OK").content(content)));
      ret.getGet().extensions(new HashMap<>());
      ret.getGet().getExtensions().put("x-kubernetes-group-version-kind", this);
      return ret;
    }

    private String getListApiPath() {
      final StringBuilder apiPath = new StringBuilder()
          .append("/apis/").append(group).append("/").append(version);
      if (namespaced) {
        apiPath.append("/namespaces/{namespace}");
      }
      apiPath.append("/").append(plural);
      return apiPath.toString();
    }

    private PathItem toListPathItem() {
      final PathItem ret = new PathItem();
      ret.operation(PathItem.HttpMethod.GET, new Operation());
      if (namespaced) {
        ret.getGet().addParametersItem(new Parameter().name("namespace").in("path").required(true));
      }
      ret.getGet().addParametersItem(new Parameter().name("name").in("path").required(true));
      final Content content = new Content()
          .addMediaType("application/json", new MediaType().schema(new Schema<>().$ref(getComponentRef())));
      ret.getGet().responses(new ApiResponses().addApiResponse(
          "200", new ApiResponse().description("OK").content(content)));
      ret.getGet().extensions(new HashMap<>());
      ret.getGet().getExtensions().put("x-kubernetes-group-version-kind", this);
      return ret;
    }
  }
}
