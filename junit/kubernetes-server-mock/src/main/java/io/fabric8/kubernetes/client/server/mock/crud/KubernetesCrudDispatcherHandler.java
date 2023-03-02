/**
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
package io.fabric8.kubernetes.client.server.mock.crud;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.mockwebserver.crud.AttributeSet;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;

import java.net.HttpURLConnection;

import static io.fabric8.kubernetes.client.http.StandardHttpHeaders.CONTENT_TYPE;
import static io.fabric8.kubernetes.client.server.mock.KubernetesAttributesExtractor.NAME;
import static io.fabric8.kubernetes.client.server.mock.KubernetesAttributesExtractor.NAMESPACE;
import static io.fabric8.kubernetes.client.server.mock.crud.KubernetesCrudPersistence.METADATA;
import static io.fabric8.kubernetes.client.server.mock.crud.KubernetesCrudPersistence.RESOURCE_VERSION;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;

@FunctionalInterface
public interface KubernetesCrudDispatcherHandler {

  int HTTP_UNPROCESSABLE_ENTITY = 422;
  String KIND = "kind";
  String STATUS = "status";

  default MockResponse handle(RecordedRequest request) throws KubernetesCrudDispatcherException {
    final String path = request.getPath();
    final String contentType = request.getHeader(CONTENT_TYPE);
    final String requestBody = request.getBody().readUtf8();
    return handle(path, contentType, requestBody);
  }

  MockResponse handle(String path, String contentType, String requestBody) throws KubernetesCrudDispatcherException;

  default void validatePath(AttributeSet query, JsonNode updatedResource) throws KubernetesCrudDispatcherException {
    // metadata.name
    final String updatedName = updatedResource.path(METADATA).path(NAME).asText();
    final String pathName = query.getAttribute(NAME).getValue().toString();
    if (!updatedName.isEmpty() && !pathName.equals(updatedName)) {
      throw new KubernetesCrudDispatcherException(
          "the name of the object (" + updatedName + ") does not match the name on the URL (" + pathName + ")",
          HTTP_BAD_REQUEST,
          updatedResource.path(KIND).asText());
    }
    // metadata.namespace
    if (query.getAttribute(NAMESPACE) != null) {
      final String updatedNamespace = updatedResource.path(METADATA).path(NAMESPACE).asText();
      final String pathNamespace = query.getAttribute(NAMESPACE).getValue().toString();
      if (!updatedNamespace.isEmpty() && !updatedNamespace.equals(pathNamespace)) {
        throw new KubernetesCrudDispatcherException(
            "the namespace of the object (" + updatedNamespace + ") does not match the namespace on the URL ("
                + pathNamespace + ")",
            HTTP_BAD_REQUEST,
            updatedResource.path(KIND).asText());
      }
    }
  }

  default void validateResourceVersion(JsonNode currentResource, JsonNode updatedResource)
      throws KubernetesCrudDispatcherException {
    String currentVersion = currentResource.path(METADATA).path(RESOURCE_VERSION).asText();
    String updateBasedOnVersion = updatedResource.path(METADATA).path(RESOURCE_VERSION).asText();
    if (!updateBasedOnVersion.isEmpty()
        && !currentVersion.equals(updateBasedOnVersion)) {
      String kind = updatedResource.path(KIND).asText();
      String name = updatedResource.path(METADATA).path(NAME).asText();
      throw new KubernetesCrudDispatcherException(
          String.format("Operation cannot be fulfilled on %s \"%s\": the object has been modified; " +
              "please apply your changes to the latest version and try again",
              kind, name),
          HttpURLConnection.HTTP_CONFLICT, kind);

    }
  }

  default GenericKubernetesResource validateRequestBody(String requestBody) throws KubernetesCrudDispatcherException {
    final GenericKubernetesResource resource = Serialization.unmarshal(requestBody, GenericKubernetesResource.class);
    if (resource == null) {
      throw new KubernetesCrudDispatcherException("No resource or invalid resource provided", HTTP_BAD_REQUEST);
    }
    final String kind = resource.getKind();
    if (Utils.isNullOrEmpty(kind)) {
      throw new KubernetesCrudDispatcherException("Invalid", HTTP_UNPROCESSABLE_ENTITY, null, "kind");
    }
    if (Utils.isNullOrEmpty(resource.getApiVersion())) {
      throw new KubernetesCrudDispatcherException(kind + " is invalid", HTTP_UNPROCESSABLE_ENTITY, kind, "apiVersion");
    }
    if (resource.getMetadata() == null) {
      throw new KubernetesCrudDispatcherException(kind + " is invalid", HTTP_UNPROCESSABLE_ENTITY, kind, "metadata");
    }
    if (Utils.isNullOrEmpty(resource.getMetadata().getName())
        && Utils.isNullOrEmpty(resource.getMetadata().getGenerateName())) {
      throw new KubernetesCrudDispatcherException(kind + " is invalid", HTTP_UNPROCESSABLE_ENTITY, kind,
          "name or generateName");
    }
    return resource;
  }

  static boolean isStatusPath(String path) {
    return path.endsWith("/" + STATUS);
  }

  static void setStatus(JsonNode source, JsonNode status) {
    if (status != null) {
      ((ObjectNode) source).set(STATUS, status);
    } else {
      ((ObjectNode) source).remove(STATUS);
    }
  }

}
