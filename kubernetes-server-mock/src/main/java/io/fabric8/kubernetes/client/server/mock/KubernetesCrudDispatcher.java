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

import com.fasterxml.jackson.databind.JsonNode;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.dsl.Watchable;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.crud.AttributeExtractor;
import io.fabric8.mockwebserver.crud.AttributeSet;
import io.fabric8.mockwebserver.crud.CrudDispatcher;
import io.fabric8.mockwebserver.crud.ResponseComposer;
import io.fabric8.zjsonpatch.JsonPatch;
import okhttp3.Headers;
import okhttp3.WebSocketListener;
import okhttp3.mockwebserver.MockResponse;

import java.net.*;
import java.util.*;
import java.util.concurrent.*;

import okhttp3.mockwebserver.RecordedRequest;
import okhttp3.mockwebserver.SocketPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KubernetesCrudDispatcher extends CrudDispatcher {

  private static final String POST = "POST";
  private static final String PUT = "PUT";
  private static final String PATCH = "PATCH";
  private static final String GET = "GET";
  private static final String DELETE = "DELETE";

  private static final Logger LOGGER = LoggerFactory.getLogger(KubernetesCrudDispatcher.class);

  ConcurrentHashMap<KubernetesResourceIdentifier, WatchEventsListener> watchEventListenerMapping = new ConcurrentHashMap<>();
  public KubernetesCrudDispatcher() {
    this(new KubernetesCrudAttributesExtractor(), new KubernetesResponseComposer());
  }

  public KubernetesCrudDispatcher(AttributeExtractor attributeExtractor, ResponseComposer responseComposer) {
    super(new Context(Serialization.jsonMapper()), attributeExtractor, responseComposer);
  }

  @Override
  public MockResponse dispatch(RecordedRequest request) {
    String path = request.getPath();
    String method = request.getMethod();
    switch (method.toUpperCase()) {
      case POST:
      case PUT:
        return handleCreate(path, request.getBody().readUtf8());
      case PATCH:
        return handlePatch(path, request.getBody().readUtf8());
      case GET:
        return detectWatchMode(path)? handleWatch(request): handleGet(path);
      case DELETE:
        return handleDelete(path);
      default:
        return null;
    }
  }

  /**
   * Adds the specified object to the in-memory db.
   *
   * @param path
   * @param s
   * @return
   */
  public MockResponse handleCreate(String path, String s) {
    MockResponse response = new MockResponse();
    AttributeSet features = AttributeSet.merge(attributeExtractor.fromPath(path), attributeExtractor.fromResource(s));
    map.put(features, s);
    response.setBody(s);
    response.setResponseCode(202);
    return response;
  }

  /**
   * Performs a get for the corresponding object from the in-memory db.
   *
   * @param path The path.
   * @return The {@link MockResponse}
   */
  public MockResponse handleGet(String path) {
    MockResponse response = new MockResponse();
    List<String> items = new ArrayList<>();
    AttributeSet query = attributeExtractor.extract(path);
    for (Map.Entry<AttributeSet, String> entry : map.entrySet()) {
      if (entry.getKey().matches(query)) {
        LOGGER.debug("Entry found for query {} : {}", query, entry);
        items.add(entry.getValue());
      }
    }
    if (query.containsKey(KubernetesAttributesExtractor.NAME)) {
      if (!items.isEmpty()) {
        response.setBody(items.get(0));
        response.setResponseCode(200);
      } else {
        response.setResponseCode(404);
      }
    } else {
      response.setBody(responseComposer.compose(items));
      response.setResponseCode(200);
    }
    return response;
  }

  /**
   * Patches the specified object to the in-memory db.
   *
   * @param path
   * @param s
   * @return
   */
  public MockResponse handlePatch(String path, String s) {
    MockResponse response = new MockResponse();
    String body = doGet(path);
    if (body == null) {
      response.setResponseCode(404);
    } else {
      try {
        JsonNode patch = context.getMapper().readTree(s);
        JsonNode source = context.getMapper().readTree(body);
        JsonNode updated = JsonPatch.apply(patch, source);
        String updatedAsString = context.getMapper().writeValueAsString(updated);
        AttributeSet features = AttributeSet.merge(attributeExtractor.fromPath(path),
          attributeExtractor.fromResource(updatedAsString));
        map.put(features, updatedAsString);
        if (features.containsKey(KubernetesAttributesExtractor.KIND) && features.containsKey(KubernetesAttributesExtractor.NAME) && features.containsKey(KubernetesAttributesExtractor.NAMESPACE)) {
          String namespace = fetchNameSpace(path);
          String name = fetchResourceNameFromResourceRequestPath(path);
          String kind = fetchKindFromResourceRequestPath(path);
          for (Map.Entry<KubernetesResourceIdentifier, WatchEventsListener> entry: watchEventListenerMapping.entrySet()) {
            if (entry.getKey().matches(name, kind, namespace)) {
              entry.getValue().getEventQueue().offer(new WatchEvent(Serialization.unmarshal(map.get(updatedAsString), KubernetesResource.class), DELETE));
            }
          }
        }
        response.setResponseCode(202);
        response.setBody(updatedAsString);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }

    }
    return response;
  }

  /**
   * Performs a delete for the corresponding object from the in-memory db.
   *
   * @param path
   * @return
   */
  public MockResponse handleDelete(String path) {
    MockResponse response = new MockResponse();
    List<AttributeSet> items = new ArrayList<>();
    AttributeSet query = attributeExtractor.extract(path);

    for (Map.Entry<AttributeSet, String> entry : map.entrySet()) {
      if (entry.getKey().matches(query)) {
        items.add(entry.getKey());
      }
    }
    if (!items.isEmpty()) {
      for (AttributeSet item : items) {
        if (item.containsKey(KubernetesAttributesExtractor.KIND) && item.containsKey(KubernetesAttributesExtractor.NAME) && item.containsKey(KubernetesAttributesExtractor.NAMESPACE)) {
          String namespace = fetchNameSpace(path);
          String name = fetchResourceNameFromResourceRequestPath(path);
          String kind = fetchKindFromResourceRequestPath(path);

          for (Map.Entry<KubernetesResourceIdentifier, WatchEventsListener> entry: watchEventListenerMapping.entrySet()) {
            if (entry.getKey().matches(name, kind, namespace)) {
              entry.getValue().getEventQueue().offer(new WatchEvent(Serialization.unmarshal(map.get(item), KubernetesResource.class), DELETE));
            }
          }
        }
        map.remove(item);
      }
      response.setResponseCode(200);
    } else {
      response.setResponseCode(404);
    }
    return response;
  }

  public MockResponse handleWatch(RecordedRequest request) {
    MockResponse mockResponse = new MockResponse();
    String path = request.getPath();
    String resourceName = fetchResourceNameFromWatchRequestPath(path);
    String kind = fetchKindFromCollectionRequestPath(path);
    String namespace = fetchNameSpace(path);

    final Map<String, String> headers = new HashMap<>();
    headers.put("Upgrade", "websocket");
    headers.put("Connection", "Upgrade");
    setResponseHeader(mockResponse, headers);
    WatchEventsListener watchEventListener = new WatchEventsListener(context);
    watchEventListenerMapping.put(new KubernetesResourceIdentifier(resourceName, kind, namespace), watchEventListener);
    return mockResponse.withWebSocketUpgrade(watchEventListener).setSocketPolicy(SocketPolicy.KEEP_OPEN);
  }

  private void setResponseHeader(MockResponse response, final Map<String, String> headers) {
    response.setHeaders(Headers.of(headers));
    response.setResponseCode(101);
    response.setSocketPolicy(SocketPolicy.CONTINUE_ALWAYS);
  }

  boolean detectWatchMode(String path) {
    String queryString = null;
    try {
      queryString = new URI(path).getQuery();
    } catch (URISyntaxException e) {
      LOGGER.debug("incorrect URI string: " + path);
      return false;
    }
    return queryString == null || queryString.isEmpty()? false: queryString.contains("watch=true");
  }

  String fetchResourceNameFromWatchRequestPath(String path) {
    String queryString = null;
    try {
      queryString = new URI(path).getQuery();
    } catch (URISyntaxException e) {
      LOGGER.debug("Incorrect URI string: " + path);
      return null;
    }

    if (queryString == null || queryString.isEmpty()) {
      return null;
    }

    String name = "";
    for (String q: queryString.split("&")) {
      String[] s = q.split("=");
      if (s[0].equals("metadata.name")) {
        name = s[1];
      }
    }
    return name.isEmpty()? null: name;
  }

  String fetchKindFromCollectionRequestPath(String path) {
    String s[] = path.split("/");
    return s[s.length - 1];
  }

  String fetchResourceNameFromResourceRequestPath(String path) {
    String s[] = path.split("/");
    return s[s.length - 1];
  }

  String fetchKindFromResourceRequestPath(String path) {
    String s[] = path.split("/");
    return s[s.length - 2];
  }

  String fetchNameSpace(String path) {

    String s[] = path.split("/");
    int i;
    for (i = 0; i < s.length; i++) {
      if (s[i].equals("namespaces")) break;
    }
    return s[i++];
  }

  private String doGet(String path) {
    List<String> items = new ArrayList<>();
    AttributeSet query = attributeExtractor.extract(path);
    for (Map.Entry<AttributeSet, String> entry : map.entrySet()) {
      if (entry.getKey().matches(query)) {
        items.add(entry.getValue());
      }
    }

    if (items.isEmpty()) {
      return null;
    } else if (items.size() == 1) {
      return items.get(0);
    } else {
      return responseComposer.compose(items);
    }
  }
}
