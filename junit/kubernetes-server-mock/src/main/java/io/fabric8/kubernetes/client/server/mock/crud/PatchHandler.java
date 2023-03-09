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
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.mockwebserver.crud.AttributeSet;
import io.fabric8.zjsonpatch.JsonPatch;
import okhttp3.MediaType;
import okhttp3.mockwebserver.MockResponse;

import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import static io.fabric8.kubernetes.client.server.mock.crud.KubernetesCrudDispatcherHandler.isStatusPath;
import static io.fabric8.kubernetes.client.server.mock.crud.KubernetesCrudDispatcherHandler.setStatus;
import static java.net.HttpURLConnection.HTTP_ACCEPTED;
import static java.net.HttpURLConnection.HTTP_UNSUPPORTED_TYPE;

public class PatchHandler implements KubernetesCrudDispatcherHandler {

  private static final String PATH = "path";

  private final KubernetesCrudPersistence persistence;

  public PatchHandler(KubernetesCrudPersistence persistence) {
    this.persistence = persistence;
  }

  @Override
  public MockResponse handle(String path, String contentType, String requestBody) throws KubernetesCrudDispatcherException {
    final AttributeSet query = persistence.getKey(path);

    final Map.Entry<AttributeSet, String> currentResourceEntry = persistence.findResource(query);
    if (currentResourceEntry == null) {
      return new MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_FOUND);
    }

    final JsonNode currentResource = persistence.asNode(currentResourceEntry);
    final JsonNode patch = persistence.asNode(requestBody);
    // Read the patch and create a complete resource (either from the body or by applying the PATCH operations)
    final JsonNode fullPatch;
    if (getMergeType(contentType) == PatchType.JSON) {
      fullPatch = JsonPatch.apply(patch, initPaths(currentResource.deepCopy(), patch));
    } else {
      fullPatch = persistence.merge(currentResource, requestBody);
    }
    validatePath(query, fullPatch);
    validateResourceVersion(currentResource, fullPatch);

    final JsonNode updatedResource;
    if (isStatusPath(path)) {
      updatedResource = currentResource.deepCopy();
      setStatus(updatedResource, fullPatch.get(STATUS));
    } else {
      updatedResource = fullPatch;
      // preserve original status (PATCH requests to the custom resource ignore changes to the status stanza)
      if (persistence.isStatusSubresourceEnabledForResource(path)) {
        setStatus(updatedResource, currentResource.path(STATUS));
      }
    }

    persistence.preserveMetadata(currentResource, updatedResource);
    if (!isStatusPath(path)) {
      persistence.touchGeneration(currentResource, updatedResource);
    }
    persistence.touchResourceVersion(currentResource, updatedResource);
    String updatedAsString = Serialization.asJson(updatedResource);
    GenericKubernetesResource deserializedResource = validateRequestBody(updatedAsString);
    if (deserializedResource.isMarkedForDeletion() && deserializedResource.getFinalizers().isEmpty()) {
      // Delete the resource.
      updatedAsString = null;
      deserializedResource = null;
    }

    persistence.processEvent(path, query, currentResourceEntry.getKey(), deserializedResource, updatedAsString);
    return new MockResponse().setResponseCode(HTTP_ACCEPTED).setBody(Utils.getNonNullOrElse(updatedAsString, ""));
  }

  private PatchType getMergeType(String contentType) throws KubernetesCrudDispatcherException {
    final PatchType mergeType;
    if (contentType == null) {
      mergeType = PatchType.JSON;
    } else {
      final String subtype = Objects.requireNonNull(MediaType.parse(contentType)).subtype();
      if (subtype.equals(MediaType.get(PatchType.JSON.getContentType()).subtype())) {
        mergeType = PatchType.JSON;
      } else if (subtype.equals(MediaType.get(PatchType.JSON_MERGE.getContentType()).subtype())) {
        mergeType = PatchType.JSON_MERGE;
      } else {
        throw new KubernetesCrudDispatcherException("Unsupported Media Type", HTTP_UNSUPPORTED_TYPE);
      }
    }
    return mergeType;
  }

  // Ensure resource contains all paths affected by the provided patch
  private JsonNode initPaths(JsonNode resource, JsonNode patch) {
    for (Iterator<JsonNode> it = patch.elements(); it.hasNext();) {
      final String fullPath = it.next().get(PATH).asText();
      final String[] paths = fullPath.replaceAll("^/", "").split("/");
      JsonNode node = resource;
      for (int p = 0; p < paths.length - 1; p++) {
        final String path = paths[p];
        if (node.get(path) == null && node.isObject()) {
          ((ObjectNode) node).set(path, ((ObjectNode) node).objectNode());
        }
        node = node.path(path);
      }
    }
    return resource;
  }
}
