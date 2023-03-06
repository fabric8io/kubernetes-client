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

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.server.mock.KubernetesAttributesExtractor;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.mockwebserver.crud.Attribute;
import io.fabric8.mockwebserver.crud.AttributeSet;
import okhttp3.mockwebserver.MockResponse;

import java.net.HttpURLConnection;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;

public class PostHandler implements KubernetesCrudDispatcherHandler {

  private final KubernetesAttributesExtractor attributeExtractor;
  private final KubernetesCrudPersistence persistence;

  public PostHandler(KubernetesAttributesExtractor attributeExtractor, KubernetesCrudPersistence persistence) {
    this.attributeExtractor = attributeExtractor;
    this.persistence = persistence;
  }

  @Override
  public MockResponse handle(String path, String contentType, String requestBody) throws KubernetesCrudDispatcherException {
    final GenericKubernetesResource resource = validateRequestBody(requestBody);
    final AttributeSet attributes = persistence.getKey(path)
        .add(new Attribute(KubernetesAttributesExtractor.NAME, KubernetesResourceUtil.getName(resource)));
    if (persistence.findResource(attributes) != null) {
      throw new KubernetesCrudDispatcherException(String.format("%s '%s' already exists",
          resource.getKind(), resource.getMetadata().getName()), HttpURLConnection.HTTP_CONFLICT, resource.getKind());
    }
    if (resource.isMarkedForDeletion()) {
      // Since the resource is newly created, a deletionTimestamp was most likely set accidentally.
      resource.getMetadata().setDeletionTimestamp(null);
    }

    initMetadata(resource, path);
    if (persistence.isStatusSubresourceEnabledForResource(path)) {
      resource.getAdditionalProperties().remove(STATUS);
    }
    final String response = Serialization.asJson(resource);
    persistence.processEvent(path, attributes, null, resource, response);
    return new MockResponse().setResponseCode(HttpURLConnection.HTTP_CREATED).setBody(response);
  }

  private void initMetadata(HasMetadata resource, String path) throws KubernetesCrudDispatcherException {
    final UUID uuid = UUID.randomUUID();
    if (Utils.isNullOrEmpty(resource.getMetadata().getName())) {
      resource.getMetadata().setName(resource.getMetadata().getGenerateName() + "-" + uuid);
    }
    final String pathNamespace = attributeExtractor.fromKubernetesPath(path)
        .get(KubernetesAttributesExtractor.NAMESPACE);
    final String metadataNamespace = resource.getMetadata().getNamespace();
    if (Utils.isNotNullOrEmpty(metadataNamespace) && !pathNamespace.equals(metadataNamespace)) {
      throw new KubernetesCrudDispatcherException(
          "the namespace of the object (" + metadataNamespace + ") does not match the namespace on the URL ("
              + pathNamespace + ")",
          HTTP_BAD_REQUEST,
          resource.getKind());
    }
    resource.getMetadata().setNamespace(pathNamespace);
    resource.getMetadata().setUid(uuid.toString());
    resource.getMetadata().setCreationTimestamp(ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT));
    resource.getMetadata().setResourceVersion(String.valueOf(persistence.requestResourceVersion()));
    resource.getMetadata().setGeneration(1L);
  }
}
