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
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.crud.AttributeSet;
import okhttp3.mockwebserver.MockResponse;

import java.net.HttpURLConnection;
import java.util.Map;

import static io.fabric8.kubernetes.client.server.mock.crud.KubernetesCrudDispatcherHandler.isStatusPath;
import static io.fabric8.kubernetes.client.server.mock.crud.KubernetesCrudDispatcherHandler.setStatus;

public class PutHandler implements KubernetesCrudDispatcherHandler {

  private final KubernetesCrudPersistence persistence;

  public PutHandler(KubernetesCrudPersistence persistence) {
    this.persistence = persistence;
  }

  @Override
  public MockResponse handle(String path, String contentType, String requestBody) throws KubernetesCrudDispatcherException {
    GenericKubernetesResource resource = validateRequestBody(requestBody);
    final AttributeSet attributes = persistence.getKey(path);

    final Map.Entry<AttributeSet, String> currentResourceEntry = persistence.findResource(attributes);
    if (currentResourceEntry == null) {
      return new MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_FOUND);
    }

    // Delete the resource if it is marked for deletion and has no finalizers.
    if (resource.isMarkedForDeletion() && resource.getFinalizers().isEmpty()) {
      persistence.processEvent(path, attributes, currentResourceEntry.getKey(), null, null);
      return new MockResponse().setResponseCode(HttpURLConnection.HTTP_OK);
    }

    final JsonNode currentResource = persistence.asNode(currentResourceEntry);
    final JsonNode updatedResource;
    if (isStatusPath(path)) {
      updatedResource = currentResource.deepCopy();
      setStatus(updatedResource, persistence.asNode(requestBody).get(STATUS));
    } else {
      updatedResource = persistence.asNode(requestBody);
      // preserve original status (PUT requests to the custom resource ignore changes to the status stanza)
      if (persistence.isStatusSubresourceEnabledForResource(path)) {
        setStatus(updatedResource, currentResource.get(STATUS));
      }
    }
    validatePath(attributes, updatedResource);
    validateResourceVersion(currentResource, updatedResource);

    persistence.preserveMetadata(currentResource, updatedResource);
    if (!isStatusPath(path)) {
      persistence.touchGeneration(currentResource, updatedResource);
    }
    persistence.touchResourceVersion(currentResource, updatedResource);
    final String response = Serialization.asJson(updatedResource);
    persistence.processEvent(path, attributes, currentResourceEntry.getKey(), null, response);
    return new MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(response);
  }
}
