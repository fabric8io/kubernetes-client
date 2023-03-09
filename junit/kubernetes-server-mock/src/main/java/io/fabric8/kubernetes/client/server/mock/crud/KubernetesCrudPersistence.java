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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.client.server.mock.Resetable;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.crud.AttributeSet;
import io.fabric8.zjsonpatch.JsonDiff;

import java.util.Map;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static io.fabric8.kubernetes.client.server.mock.KubernetesAttributesExtractor.NAMESPACE;
import static io.fabric8.kubernetes.client.server.mock.crud.KubernetesCrudDispatcherHandler.HTTP_UNPROCESSABLE_ENTITY;

public interface KubernetesCrudPersistence extends Resetable {

  String METADATA = "metadata";
  String UID = "uid";
  String CREATION_TIMESTAMP = "creationTimestamp";
  String RESOURCE_VERSION = "resourceVersion";
  String GENERATION = "generation";

  long requestResourceVersion();

  AttributeSet getKey(String path);

  Map.Entry<AttributeSet, String> findResource(AttributeSet attributes);

  boolean isStatusSubresourceEnabledForResource(String path);

  void processEvent(String path, AttributeSet pathAttributes, AttributeSet oldAttributes, GenericKubernetesResource resource,
      String newState);

  default JsonNode asNode(Map.Entry<AttributeSet, String> resource) throws KubernetesCrudDispatcherException {
    return asNode(resource.getValue());
  }

  default JsonNode asNode(String resourceBody) throws KubernetesCrudDispatcherException {
    try {
      return Serialization.jsonMapper().readTree(resourceBody);
    } catch (JsonProcessingException e) {
      throw new KubernetesCrudDispatcherException(e.getMessage(), HTTP_UNPROCESSABLE_ENTITY);
    }
  }

  default JsonNode merge(JsonNode baseResource, String updatedResource) throws KubernetesCrudDispatcherException {
    try {
      final ObjectReader objectReader = Serialization.jsonMapper().readerForUpdating(baseResource.deepCopy());
      return objectReader.readValue(updatedResource);
    } catch (JsonProcessingException e) {
      throw new KubernetesCrudDispatcherException(e.getMessage(), HTTP_UNPROCESSABLE_ENTITY);
    }
  }

  default void preserveMetadata(JsonNode currentResource, JsonNode updatedResource) {
    final ObjectNode currentMetadata = ((ObjectNode) currentResource.get(METADATA));
    final ObjectNode updatedMetadata = ((ObjectNode) updatedResource.get(METADATA));
    updatedMetadata.put(NAMESPACE, currentMetadata.path(NAMESPACE).asText(null));
    updatedMetadata.put(UID, currentMetadata.get(UID).asText());
    updatedMetadata.put(CREATION_TIMESTAMP, currentMetadata.get(CREATION_TIMESTAMP).asText());
    updatedMetadata.put(RESOURCE_VERSION, currentMetadata.get(RESOURCE_VERSION).asText());
    updatedMetadata.set(GENERATION, currentMetadata.get(GENERATION).deepCopy());
  }

  default void touchResourceVersion(JsonNode currentResource, JsonNode updatedResource) {
    if (!JsonDiff.asJson(currentResource, updatedResource).isEmpty()) {
      ((ObjectNode) updatedResource.get(METADATA)).put(RESOURCE_VERSION, String.valueOf(requestResourceVersion()));
    }
  }

  default void touchGeneration(JsonNode currentResource, JsonNode updatedResource) {
    final JsonNode diff = JsonDiff.asJson(currentResource, updatedResource);
    if (!diff.isEmpty() && shouldIncreaseGeneration(diff)) {
      ((ObjectNode) updatedResource.get(METADATA)).put(GENERATION,
          currentResource.path(METADATA).path(GENERATION).asInt(0) + 1);
    }
  }

  static boolean shouldIncreaseGeneration(JsonNode existing, JsonNode source) {
    final JsonNode differences = Optional.ofNullable(existing).map(e -> JsonDiff.asJson(e, source))
        .orElse(null);
    return shouldIncreaseGeneration(differences);
  }

  static boolean shouldIncreaseGeneration(JsonNode differences) {
    if (differences != null && !differences.isEmpty()) {
      return StreamSupport.stream(differences.spliterator(), false)
          .filter(n -> !n.get("path").asText().matches("/metadata(/.*)?"))
          .anyMatch(n -> !n.get("path").asText().matches("/status(/.*)?"));
    }
    return false;
  }
}
