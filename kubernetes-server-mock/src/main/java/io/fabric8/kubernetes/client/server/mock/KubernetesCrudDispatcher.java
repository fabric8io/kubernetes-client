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
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.StatusCause;
import io.fabric8.kubernetes.api.model.StatusCauseBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher.Action;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.crud.Attribute;
import io.fabric8.mockwebserver.crud.AttributeSet;
import io.fabric8.mockwebserver.crud.CrudDispatcher;
import io.fabric8.mockwebserver.crud.ResponseComposer;
import io.fabric8.zjsonpatch.JsonDiff;
import io.fabric8.zjsonpatch.JsonPatch;
import okhttp3.MediaType;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okhttp3.mockwebserver.SocketPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static io.fabric8.kubernetes.client.server.mock.KubernetesAttributesExtractor.toKubernetesResource;

public class KubernetesCrudDispatcher extends CrudDispatcher {

  private static final String GENERATION = "generation";
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

  /**
   * Adds the specified object to the in-memory db.
   *
   * @param path String
   * @param s String
   * @return The {@link MockResponse}
   */
  @Override
  public MockResponse handleCreate(String path, String s) {
    return validateRequestBodyAndHandleRequest(s, h -> doCreateOrModify(path, s, h, Action.ADDED));
  }

  /**
   * Replace the object on `path` endpoint with the object represented by `s`
   * @param path String
   * @param s String
   * @return The {@link MockResponse}
   */
  @Override
  public MockResponse handleUpdate(String path, String s) {
    return validateRequestBodyAndHandleRequest(s, h -> doCreateOrModify(path, s, h, Action.MODIFIED));
  }

  /**
   * Performs a get for the corresponding object from the in-memory db.
   *
   * @param path The path.
   * @return The {@link MockResponse}
   */
  @Override
  public MockResponse handleGet(String path) {
    if (detectWatchMode(path)) {
      return handleWatch(path);
    }
    MockResponse response = new MockResponse();
    List<String> items = new ArrayList<>();
    AttributeSet query = attributeExtractor.fromPath(path);

    map.entrySet().stream()
      .filter(entry -> entry.getKey().matches(query))
      .forEach(entry -> {
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
   * @return The {@link MockResponse}
   */
  @Override
  public MockResponse handlePatch(RecordedRequest request) {
    final String path = request.getPath();
    final String requestBody = request.getBody().readUtf8();
    final String contentType = request.getHeader("Content-Type");
    MockResponse response = new MockResponse();

    AttributeSet query = attributeExtractor.fromPath(path);

    Optional<Map.Entry<AttributeSet, String>> bodyEntry = map.entrySet().stream()
        .filter(entry -> entry.getKey().matches(query))
        .findFirst();

    if (!bodyEntry.isPresent()) {
      response.setResponseCode(HttpURLConnection.HTTP_NOT_FOUND);
    } else {
      String body = bodyEntry.get().getValue();
      try {
        JsonNode patch = context.getMapper().readTree(requestBody);
        JsonNode source = context.getMapper().readTree(body);
        JsonNode status = null;

        Map<String, String> pathValues = kubernetesAttributesExtractor.fromKubernetesPath(path);
        boolean statusSubresource =
            crdProcessor.isStatusSubresource(pathValues);

        if (statusSubresource && !isStatusPath(path)) {
          status = removeStatus(source);
        }

        MediaType mergeType;
        if (contentType == null) {
          mergeType = OperationSupport.JSON_PATCH;
        } else {
          MediaType mediaType = MediaType.parse(contentType);
          String subtype = mediaType.subtype();

          if (subtype.equals(OperationSupport.JSON_PATCH.subtype())) {
            mergeType = OperationSupport.JSON_PATCH;
          } else if (subtype.equals(OperationSupport.JSON_MERGE_PATCH.subtype())) {
            mergeType = OperationSupport.JSON_MERGE_PATCH;
          } else {
            response.setResponseCode(HttpURLConnection.HTTP_UNSUPPORTED_TYPE);
            return response;
          }
        }

        JsonNode updated;
        if (mergeType == OperationSupport.JSON_PATCH)  {
          updated = JsonPatch.apply(patch, source);
        } else {
          ObjectReader objectReader = context.getMapper().readerForUpdating(source);
          updated = objectReader.readValue(requestBody);
        }

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

        setDefaultMetadata(updated, pathValues, source);

        String updatedAsString = Serialization.asJson(updated);

        return validateRequestBodyAndHandleRequest(updatedAsString, h -> {
          processEvent(path, query, bodyEntry.get().getKey(), updatedAsString);

          response.setResponseCode(HttpURLConnection.HTTP_ACCEPTED);
          response.setBody(updatedAsString);
          return response;
        });
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
    return new MockResponse().setResponseCode(doDelete(path));
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
        synchronized (KubernetesCrudDispatcher.this) {
          map.entrySet().stream()
            .filter(entry -> watch.attributeMatches(entry.getKey()))
            .forEach(entry -> watch.sendWebSocketResponse(entry.getValue(), Action.ADDED));
        }
      }
    );
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

  private int doDelete(String path) {
    AttributeSet fromPath = attributeExtractor.fromPath(path);
    List<AttributeSet> items = findItems(fromPath);

    if (items.isEmpty()) return HttpURLConnection.HTTP_NOT_FOUND;

    items.forEach(item -> processEvent(path, fromPath, item, null));
    return HttpURLConnection.HTTP_OK;
  }

  private void processEvent(String path, AttributeSet pathAttributes, AttributeSet oldAttributes, String newState) {
    String existing = map.remove(oldAttributes);
    AttributeSet newAttributes = null;
    if (newState != null) {
      newAttributes = kubernetesAttributesExtractor.fromResource(newState);
      // corner case - we need to get the plural from the path
      if (!newAttributes.containsKey(KubernetesAttributesExtractor.PLURAL)) {
        newAttributes = AttributeSet.merge(pathAttributes, newAttributes);
      }
      map.put(newAttributes, newState);
    }
    if (!Objects.equals(existing, newState)) {
      AttributeSet finalAttributeSet = newAttributes;
      watchEventListeners.forEach(listener -> {
        boolean matchesOld = oldAttributes != null && listener.attributeMatches(oldAttributes);
        boolean matchesNew = finalAttributeSet != null && listener.attributeMatches(finalAttributeSet);
        if (matchesOld && matchesNew) {
          listener.sendWebSocketResponse(newState, Action.MODIFIED);
        } else if (matchesOld) {
          listener.sendWebSocketResponse(existing, Action.DELETED);
        } else if (matchesNew) {
          listener.sendWebSocketResponse(newState, Action.ADDED);
        }
      });

      crdProcessor.process(path, Utils.getNonNullOrElse(newState, existing), newState == null);
    }
  }

  private List<AttributeSet> findItems(AttributeSet query) {
    return map.keySet().stream()
      .filter(entry -> entry.matches(query))
      .collect(Collectors.toList());
  }

  private MockResponse doCreateOrModify(String path, String initial, HasMetadata value, Action event) {
    MockResponse mockResponse = new MockResponse();
    // workaround for mockserver https://github.com/fabric8io/mockwebserver/pull/59
    Map<String, String> pathValues = kubernetesAttributesExtractor.fromKubernetesPath(path);
    AttributeSet attributes = attributeExtractor.fromPath(path);

    try {
      int responseCode = HttpURLConnection.HTTP_OK;

      boolean statusSubresource = crdProcessor.isStatusSubresource(pathValues);

      JsonNode updated = context.getMapper().readTree(initial);
      AttributeSet existingAttributes = null;

      if (event == Action.ADDED) {
        attributes = attributes.add(new Attribute(KubernetesAttributesExtractor.NAME, KubernetesResourceUtil.getName(value)));
        List<AttributeSet> items = findItems(attributes);
        if (items.isEmpty()) {
          if (statusSubresource) {
            removeStatus(updated);
          }
          setDefaultMetadata(updated, pathValues, null);
        } else {
          responseCode = HttpURLConnection.HTTP_CONFLICT;
        }
      } else {
        List<AttributeSet> items = findItems(attributes);
        if (items.isEmpty()) {
          responseCode = HttpURLConnection.HTTP_NOT_FOUND;
        } else {
          existingAttributes = items.get(0);
          String existing = map.get(existingAttributes);
          JsonNode existingNode = context.getMapper().readTree(existing);
          if (isStatusPath(path)) {
            JsonNode status = removeStatus(updated);
            // set the status on the existing node
            updated = existingNode;
            setStatus(updated, status);
          } else {
            // preserve status and generated fields
            if (statusSubresource) {
              setStatus(updated, removeStatus(existingNode));
            }
            setDefaultMetadata(updated, pathValues, existingNode);
          }
        }
      }

      if (responseCode == HttpURLConnection.HTTP_OK) {
        String s = context.getMapper().writeValueAsString(updated);
        processEvent(path, attributes, existingAttributes, s);
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

  // Visible for testing
  static boolean shouldIncreaseGeneration(JsonNode existing, JsonNode source) {
    final JsonNode differences = Optional.ofNullable(existing).map(e -> JsonDiff.asJson(e, source))
      .orElse(null);
    if (differences != null && !differences.isEmpty()) {
      return StreamSupport.stream(differences.spliterator(), false)
        .filter(n -> !n.get("path").asText().startsWith("/metadata/"))
        .anyMatch(n -> !n.get("path").asText().startsWith("/status/"));
    }
    return false;
  }

  private void setDefaultMetadata(JsonNode source, Map<String, String> pathValues, JsonNode existing) {
    ObjectNode metadata = (ObjectNode)source.findValue("metadata");
    ObjectNode existingMetadata = null;
    if (existing != null) {
      existingMetadata = (ObjectNode)existing.findValue("metadata");
    }
    UUID uuid = UUID.randomUUID();
    if (metadata.get("name") == null) {
      metadata.put("name", metadata.get("generateName").asText() + "-" + uuid.toString());
    }
    if (metadata.get("namespace") == null) {
      metadata.put("namespace", pathValues.get(KubernetesAttributesExtractor.NAMESPACE));
    }
    metadata.put("uid", getOrDefault(existingMetadata, "uid", uuid.toString()));
    // resourceVersion is not yet handled appropriately
    metadata.put("resourceVersion", "1");

    if (shouldIncreaseGeneration(existing, source)) {
      metadata.put(GENERATION, Integer.parseInt(getOrDefault(existingMetadata, GENERATION, "0")) + 1);
    } else {
      metadata.put(GENERATION, getOrDefault(existingMetadata, GENERATION, "1"));
    }

    metadata.put("creationTimestamp", getOrDefault(existingMetadata, "creationTimestamp", ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT)));
  }

  private String getOrDefault(JsonNode node, String name, String defaultValue) {
    if (node != null) {
      JsonNode field = node.get(name);
      if (field != null) {
        return field.asText();
      }
    }
    return defaultValue;
  }

  private JsonNode removeStatus(JsonNode source) {
    return ((ObjectNode)source).remove(STATUS);
  }

  private void setStatus(JsonNode source, JsonNode status) {
    if (status != null) {
      ((ObjectNode) source).set(STATUS, status);
    } else {
      ((ObjectNode) source).remove(STATUS);
    }
  }

  // eventually this should validate against the path
  private MockResponse validateRequestBodyAndHandleRequest(String s, Function<HasMetadata, MockResponse> mockResponseFunction) {
    HasMetadata h = null;
    try {
      h = toKubernetesResource(s);
      validateResource(h);
      return mockResponseFunction.apply(h);
    } catch (IllegalArgumentException | KubernetesClientException e) {
      return getUnprocessableEntityMockResponse(s, h, e);
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
    if (Utils.isNullOrEmpty(item.getKind())) {
      throw new IllegalArgumentException("Required value: kind is required");
    }
    if (Utils.isNullOrEmpty(item.getApiVersion())) {
      throw new IllegalArgumentException("Required value: apiVersion is required");
    }
  }
}
