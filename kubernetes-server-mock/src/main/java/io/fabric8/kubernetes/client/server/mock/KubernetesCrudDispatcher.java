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
package io.fabric8.kubernetes.client.server.mock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.StatusCause;
import io.fabric8.kubernetes.api.model.StatusCauseBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.crud.Attribute;
import io.fabric8.mockwebserver.crud.AttributeSet;
import io.fabric8.mockwebserver.crud.CrudDispatcher;
import io.fabric8.mockwebserver.crud.ResponseComposer;
import io.fabric8.zjsonpatch.JsonPatch;
import okhttp3.MediaType;
import okhttp3.mockwebserver.MockResponse;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.Collectors;

import okhttp3.mockwebserver.RecordedRequest;
import okhttp3.mockwebserver.SocketPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.fabric8.kubernetes.client.server.mock.KubernetesAttributesExtractor.toKubernetesResource;

public class KubernetesCrudDispatcher extends CrudDispatcher {

  private static final String POST = "POST";
  private static final String PUT = "PUT";
  private static final String PATCH = "PATCH";
  private static final String GET = "GET";
  private static final String DELETE = "DELETE";

  private static final String ADDED = "ADDED";
  private static final String MODIFIED = "MODIFIED";
  private static final String STATUS = "status";

  private static final Logger LOGGER = LoggerFactory.getLogger(KubernetesCrudDispatcher.class);
  public static final int HTTP_UNPROCESSABLE_ENTITY = 422;
  private final Set<WatchEventsListener> watchEventListeners = new CopyOnWriteArraySet<>();
  private final CustomResourceDefinitionProcessor crdProcessor;
  private final KubernetesAttributesExtractor kubernetesAttributesExtractor;

  public KubernetesCrudDispatcher() {
    this(Collections.emptyList());
  }

  public KubernetesCrudDispatcher(List<CustomResourceDefinitionContext> crdContexts) {
    this(new KubernetesAttributesExtractor(crdContexts), new KubernetesResponseComposer());
  }

  public KubernetesCrudDispatcher(KubernetesAttributesExtractor attributeExtractor, ResponseComposer responseComposer) {
    super(new Context(Serialization.jsonMapper()), attributeExtractor, responseComposer);
    this.kubernetesAttributesExtractor = attributeExtractor;
    crdProcessor = new CustomResourceDefinitionProcessor(kubernetesAttributesExtractor);
  }

  @Override
  public synchronized MockResponse dispatch(RecordedRequest request) {
    String path = request.getPath();
    String method = request.getMethod();
    switch (method.toUpperCase()) {
      case POST:
        return handleCreate(path, request.getBody().readUtf8());
      case PUT:
        return handleReplace(path, request.getBody().readUtf8());
      case PATCH:
        return handlePatch(path, request.getBody().readUtf8(), request.getHeader("Content-Type"));
      case GET:
        return detectWatchMode(path)? handleWatch(path): handleGet(path);
      case DELETE:
        return handleDelete(path);
      default:
        return null;
    }
  }

  /**
   * Adds the specified object to the in-memory db.
   *
   * @param path String
   * @param s String
   * @return The {@link MockResponse}
   */
  @Override
  public MockResponse handleCreate(String path, String s) {
    return validateRequestBodyAndHandleRequest(s, (g) -> doCreateOrModify(path, g, ADDED));
  }

  /**
   * Replace the object on `path` endpoint with the object represented by `s`
   * @param path String
   * @param s String
   * @return The {@link MockResponse}
   */
  public MockResponse handleReplace(String path, String s) {
    return validateRequestBodyAndHandleRequest(s, (g) -> doCreateOrModify(path, g, MODIFIED));
  }

  /**
   * Performs a get for the corresponding object from the in-memory db.
   *
   * @param path The path.
   * @return The {@link MockResponse}
   */
  @Override
  public MockResponse handleGet(String path) {
    MockResponse response = new MockResponse();
    List<String> items = new ArrayList<>();
    AttributeSet query = attributeExtractor.fromPath(path);

    map.entrySet().stream().filter(entry -> entry.getKey()
      .matches(query)).forEach(entry -> {
      LOGGER.debug("Entry found for query {} : {}", query, entry);
      items.add(entry.getValue());
    });

    if (query.containsKey(KubernetesAttributesExtractor.NAME)) {
      if (!items.isEmpty()) {
        response.setBody(items.get(0));
        response.setResponseCode(HttpURLConnection.HTTP_OK);
      } else {
        response.setResponseCode(HttpURLConnection.HTTP_NOT_FOUND);
      }
    } else {
      response.setBody(responseComposer.compose(items));
      response.setResponseCode(HttpURLConnection.HTTP_OK);
    }
    return response;
  }

  /**
   * Patches the specified object to the in-memory db.
   *
   * @param path path of resource
   * @param s object
   * @param contentType
   * @return The {@link MockResponse}
   */
  public MockResponse handlePatch(String path, String s, String contentType) {
    MockResponse response = new MockResponse();
    String body = fetchResource(path);
    if (body == null) {
      response.setResponseCode(HttpURLConnection.HTTP_NOT_FOUND);
    } else {
      try {
        JsonNode patch = context.getMapper().readTree(s);
        JsonNode source = context.getMapper().readTree(body);
        JsonNode status = null;

        Map<String, String> pathValues = kubernetesAttributesExtractor.fromKubernetesPath(path);
        boolean statusSubresource =
            crdProcessor.isStatusSubresource(pathValues.get(KubernetesAttributesExtractor.KIND));

        if (statusSubresource && !isStatusPath(path)) {
          status = removeStatus(source);
        }

        if (contentType != null) {
          MediaType type = MediaType.parse(contentType);
          if (!type.subtype().equals(OperationSupport.JSON_PATCH.subtype())) {
            response.setResponseCode(HttpURLConnection.HTTP_UNSUPPORTED_TYPE);
            return response;
          }
        }
        JsonNode updated = JsonPatch.apply(patch, source);

        if (isStatusPath(path)) {
          status = removeStatus(updated);
          updated = context.getMapper().readTree(body);
        }

        // restore the status
        if (statusSubresource || isStatusPath(path)) {
          if (status == null) {
              removeStatus(updated);
          } else {
              ((ObjectNode)updated).set(STATUS, status);
          }
        }

        String updatedAsString = context.getMapper().writeValueAsString(updated);

        AttributeSet attributeSet;

        AttributeSet query = attributeExtractor.fromPath(path);

        attributeSet = map.entrySet().stream()
          .filter(entry -> entry.getKey().matches(query))
          .findFirst().orElseThrow(IllegalStateException::new).getKey();

        if (body.equals(updatedAsString)) {
          response.setResponseCode(HttpURLConnection.HTTP_ACCEPTED);
          response.setBody(updatedAsString);
          return response;
        }
        map.remove(attributeSet);
        AttributeSet newAttributeSet = AttributeSet.merge(attributeSet, attributeExtractor.fromResource(updatedAsString));
        map.put(newAttributeSet, updatedAsString);
        crdProcessor.process(path, updatedAsString, false);

        final AtomicBoolean flag = new AtomicBoolean(false);
        AttributeSet finalAttributeSet = attributeSet;
        watchEventListeners.stream()
          .filter(watchEventsListener -> watchEventsListener.attributeMatches(finalAttributeSet))
          .forEach(watchEventsListener -> {
              flag.set(true);
              watchEventsListener.sendWebSocketResponse(updatedAsString, MODIFIED);
          });

        if (!flag.get()) {
          watchEventListeners.stream()
            .filter(watchEventsListener -> watchEventsListener.attributeMatches(newAttributeSet))
            .forEach(watchEventsListener -> watchEventsListener.sendWebSocketResponse(updatedAsString, ADDED));
        }

        response.setResponseCode(HttpURLConnection.HTTP_ACCEPTED);
        response.setBody(updatedAsString);
      } catch (JsonProcessingException e) {
        response.setResponseCode(HTTP_UNPROCESSABLE_ENTITY);
      }
    }
    return response;
  }

  /**
   * Performs a delete for the corresponding object from the in-memory db.
   *
   * @param path String
   * @return The {@link MockResponse}
   */
  @Override
  public MockResponse handleDelete(String path) {
    return new MockResponse().setResponseCode(doDelete(path, "DELETED"));
  }

  /**
   * Watch the resource list on `path` endpoint
   *
   * @param path String
   * @return The {@link MockResponse}
   */
  public MockResponse handleWatch(String path) {
    MockResponse mockResponse = new MockResponse();
    String resourceName = fetchResourceNameFromWatchRequestPath(path);
    AttributeSet query = attributeExtractor.fromPath(path);
    if (resourceName != null) {
      query = query.add(new Attribute("name", resourceName));
    }
    WatchEventsListener watchEventListener = new WatchEventsListener(context, query, watchEventListeners, LOGGER,
      watch -> {
        map.entrySet().stream()
          .filter(entry -> watch.attributeMatches(entry.getKey()))
          .forEach(entry -> watch.sendWebSocketResponse(entry.getValue(), ADDED));
      });
    watchEventListeners.add(watchEventListener);
    mockResponse.setSocketPolicy(SocketPolicy.KEEP_OPEN);
    return mockResponse.withWebSocketUpgrade(watchEventListener);
  }

  private boolean detectWatchMode(String path) {
    String queryString = null;
    try {
      queryString = new URI(path).getQuery();
    } catch (URISyntaxException e) {
      LOGGER.debug("incorrect URI string: [{}]", path);
      return false;
    }
    if (queryString != null && !queryString.isEmpty()) {
      return queryString.contains("watch=true");
    }
    return false;
  }

  private String fetchResourceNameFromWatchRequestPath(String path) {
    String queryString = null;
    try {
      queryString = new URI(path).getQuery();
    } catch (URISyntaxException e) {
      LOGGER.debug("Incorrect URI string: [{}]", path);
      return null;
    }

    if (queryString == null || queryString.isEmpty()) {
      return null;
    }

    String name = "";
    for (String q: queryString.split("&")) {
      if (q.contains("fieldSelector") && q.contains("metadata.name")) {
        String[] s = q.split("=");
        name = s[s.length - 1];
      }
    }
    return name.isEmpty()? null: name;
  }

  private String fetchResource(String path) {
    List<String> items = new ArrayList<>();
    AttributeSet query = attributeExtractor.fromPath(path);

    map.entrySet().stream()
      .filter(entry -> entry.getKey().matches(query))
      .forEach(entry -> items.add(entry.getValue()));

    if (items.isEmpty()) {
      return null;
    } else if (items.size() == 1) {
      return items.get(0);
    } else {
      return responseComposer.compose(items);
    }
  }

  private int doDelete(String path, String event) {
    List<AttributeSet> items = findItems(attributeExtractor.fromPath(path));

    if (items.isEmpty()) return HttpURLConnection.HTTP_NOT_FOUND;


    items.forEach(item -> {
      if (event != null && !event.isEmpty()) {
        watchEventListeners.stream()
          .filter(listener -> listener.attributeMatches(item))
          .forEach(listener -> listener.sendWebSocketResponse(map.get(item), event));
      }
      String existing = map.remove(item);
      crdProcessor.process(path, existing, true);
    });
    return HttpURLConnection.HTTP_OK;
  }

  private List<AttributeSet> findItems(AttributeSet query) {
    return map.keySet().stream()
      .filter(entry -> entry.matches(query))
      .collect(Collectors.toList());
  }

  private MockResponse doCreateOrModify(String path, GenericKubernetesResource value, String event) {
    MockResponse mockResponse = new MockResponse();
    // workaround for mockserver https://github.com/fabric8io/mockwebserver/pull/59
    Map<String, String> pathValues = kubernetesAttributesExtractor.fromKubernetesPath(path);
    AttributeSet attributes = attributeExtractor.fromPath(path);

    try {
      int responseCode = HttpURLConnection.HTTP_OK;

      if (ADDED.equals(event) && value.getMetadata() != null && value.getMetadata().getName() != null) {
        attributes = AttributeSet.merge(attributes, new AttributeSet(new Attribute(KubernetesAttributesExtractor.NAME, value.getMetadata().getName())));
      }

      boolean statusSubresource = crdProcessor.isStatusSubresource(pathValues.get(KubernetesAttributesExtractor.KIND));

      GenericKubernetesResource updated = Serialization.clone(value);

      List<AttributeSet> items = findItems(attributes);
      if (items.isEmpty()) {
        if (MODIFIED.equals(event)) {
          responseCode = HttpURLConnection.HTTP_NOT_FOUND;
        } else {
          if (statusSubresource) {
            updated.getAdditionalProperties().remove(STATUS);
          }
          setDefaultMetadata(updated, pathValues, null);
        }
      } else if (ADDED.equals(event)) {
        responseCode = HttpURLConnection.HTTP_CONFLICT;
      } else if (MODIFIED.equals(event)) {
        String existing = map.remove(items.get(0));
        GenericKubernetesResource existingResource = toKubernetesResource(existing);
        Object status = null;
        if (isStatusPath(path)) {
          status = updated.getAdditionalProperties().remove(STATUS);
          // set the status on the existing node
          updated = Serialization.clone(existingResource);
        } else {
          // preserve status and generated fields
          if (statusSubresource) {
            status = existingResource.getAdditionalProperties().remove(STATUS);
          }
          setDefaultMetadata(updated, pathValues, existingResource.getMetadata());
        }
        if (statusSubresource || isStatusPath(path)) {
          if (status != null) {
            updated.getAdditionalProperties().put(STATUS, status);
          } else {
            updated.getAdditionalProperties().remove(STATUS);
          }
        }
        if (existingResource.equals(updated)) {
          event = null; // no change
        }
      }

      if (responseCode == HttpURLConnection.HTTP_OK) {
        String s = context.getMapper().writeValueAsString(updated);
        AttributeSet features = AttributeSet.merge(attributes, kubernetesAttributesExtractor.extract(updated));
        map.put(features, s); // always add back as it was proactively removed
        if (event != null && !event.isEmpty()) {
          crdProcessor.process(path, s, false);
          final String response = s;
          final String finalEvent = event;
          watchEventListeners.stream()
              .filter(listener -> listener.attributeMatches(features))
              .forEach(listener -> listener.sendWebSocketResponse(response, finalEvent));
        }
        mockResponse.setBody(s);
      }
      mockResponse.setResponseCode(responseCode);
      return mockResponse;
    } catch (JsonProcessingException e) {
      throw new IllegalArgumentException(e);
    }
  }

  private static boolean isStatusPath(String path) {
    return path.endsWith("/" + STATUS);
  }

  private void setDefaultMetadata(GenericKubernetesResource source, Map<String, String> pathValues, ObjectMeta exitingMetadata) {
    ObjectMeta metadata = source.getMetadata();
    if (metadata == null) {
      metadata = new ObjectMeta();
      source.setMetadata(metadata);
    }
    UUID uuid = UUID.randomUUID();
    if (metadata.getName() == null) {
      metadata.setName(metadata.getGenerateName() + "-" + uuid.toString());
    }
    if (metadata.getNamespace() == null) {
      metadata.setNamespace(pathValues.get(KubernetesAttributesExtractor.NAMESPACE));
    }
    metadata.setUid(getOrDefault(exitingMetadata, ObjectMeta::getUid, uuid.toString()));
    // resourceVersion is not yet handled appropriately
    metadata.setResourceVersion("1");
    metadata.setGeneration(1l);
    metadata.setCreationTimestamp(getOrDefault(exitingMetadata, ObjectMeta::getCreationTimestamp, ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT)));
  }

  private String getOrDefault(ObjectMeta metadata, Function<ObjectMeta, String> extractor, String defaultValue) {
    if (metadata != null) {
      String result = extractor.apply(metadata);
      if (result != null) {
        return result;
      }
    }
    return defaultValue;
  }

  private JsonNode removeStatus(JsonNode source) {
    return ((ObjectNode)source).remove(STATUS);
  }

  private MockResponse validateRequestBodyAndHandleRequest(String s, Function<GenericKubernetesResource, MockResponse> mockResponseFunction) {
    GenericKubernetesResource g = null;
    try {
      g = toKubernetesResource(s);
      validateResource(g);
      return mockResponseFunction.apply(g);
    } catch (IllegalArgumentException | KubernetesClientException e) {
      return getUnprocessableEntityMockResponse(s, g, e);
    }
  }

  private MockResponse getUnprocessableEntityMockResponse(String s, HasMetadata h, Exception ex) {
    String statusBody = getStatusBody(h, HTTP_UNPROCESSABLE_ENTITY, ex);
    if (statusBody == null) {
      statusBody = s;
    }
    return new MockResponse().setResponseCode(HTTP_UNPROCESSABLE_ENTITY).setBody(statusBody);
  }

  private String getStatusBody(HasMetadata h, int code, Exception ex) {
    String kind = "Unknown";
    if (h != null && Utils.isNotNullOrEmpty(h.getKind())) {
      kind = h.getKind();
    }
    Status status = new StatusBuilder().withStatus("Failure")
      .withReason("Invalid")
      .withMessage(kind + " is invalid")
      .withNewDetails()
      .withKind(kind)
      .withCauses(getFailureStatusCause(ex))
      .endDetails()
      .withCode(code)
      .build();
    try {
      return Serialization.jsonMapper().writeValueAsString(status);
    } catch (IOException ioException) {
      return null;
    }
  }

  private StatusCause getFailureStatusCause(Exception ex) {
    return new StatusCauseBuilder()
      .withMessage(ex.getMessage())
      .withReason("ValueRequired")
      .build();
  }

  private void validateResource(HasMetadata item) {
    if (item == null) {
      throw new IllegalArgumentException("No item provided");
    }
    if (item.getMetadata() == null) {
      throw new IllegalArgumentException("Required value: metadata is required");
    }
    if (Utils.isNullOrEmpty(item.getMetadata().getName()) && Utils.isNullOrEmpty(item.getMetadata().getGenerateName())) {
      throw new IllegalArgumentException("Required value: name or generateName is required");
    }
  }
}
