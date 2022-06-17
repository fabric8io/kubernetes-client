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

import io.fabric8.kubernetes.client.Watcher.Action;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.server.mock.crud.KubernetesCrudDispatcherHandler;
import io.fabric8.kubernetes.client.server.mock.crud.KubernetesCrudPersistence;
import io.fabric8.kubernetes.client.server.mock.crud.PatchHandler;
import io.fabric8.kubernetes.client.server.mock.crud.PostHandler;
import io.fabric8.kubernetes.client.server.mock.crud.PutHandler;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.crud.Attribute;
import io.fabric8.mockwebserver.crud.AttributeSet;
import io.fabric8.mockwebserver.crud.CrudDispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okhttp3.mockwebserver.SocketPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;

import static io.fabric8.kubernetes.client.server.mock.crud.KubernetesCrudDispatcherHandler.process;

public class KubernetesCrudDispatcher extends CrudDispatcher implements KubernetesCrudPersistence {

  private static final Logger LOGGER = LoggerFactory.getLogger(KubernetesCrudDispatcher.class);
  private final Set<WatchEventsListener> watchEventListeners;
  private final CustomResourceDefinitionProcessor crdProcessor;
  private final KubernetesAttributesExtractor kubernetesAttributesExtractor;
  private final AtomicLong resourceVersion;
  private final KubernetesResponseComposer kubernetesResponseComposer;
  private final KubernetesCrudDispatcherHandler postHandler;
  private final KubernetesCrudDispatcherHandler putHandler;
  private final KubernetesCrudDispatcherHandler patchHandler;

  public KubernetesCrudDispatcher() {
    this(Collections.emptyList());
  }

  public KubernetesCrudDispatcher(List<CustomResourceDefinitionContext> crdContexts) {
    this(new KubernetesAttributesExtractor(crdContexts), new KubernetesResponseComposer());
  }

  public KubernetesCrudDispatcher(KubernetesAttributesExtractor attributeExtractor,
      KubernetesResponseComposer responseComposer) {
    super(new Context(Serialization.jsonMapper()), attributeExtractor, responseComposer);
    this.kubernetesAttributesExtractor = attributeExtractor;
    this.kubernetesResponseComposer = responseComposer;
    watchEventListeners = new CopyOnWriteArraySet<>();
    crdProcessor = new CustomResourceDefinitionProcessor(kubernetesAttributesExtractor);
    resourceVersion = new AtomicLong();

    postHandler = new PostHandler(attributeExtractor, this);
    putHandler = new PutHandler(this);
    patchHandler = new PatchHandler(this);
  }

  /**
   * Adds the specified object to the in-memory db.
   *
   * @param request RecordedRequest information.
   * @return a MockResponse to be dispatched.
   */
  @Override
  public MockResponse handleCreate(RecordedRequest request) {
    return process(request, postHandler);
  }

  /**
   * Updates the specified object to the in-memory db.
   *
   * @param request RecordedRequest information.
   * @return a MockResponse to be dispatched.
   */
  @Override
  public MockResponse handleUpdate(RecordedRequest request) {
    return process(request, putHandler);
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
    return handle(path, null);
  }

  private interface EventProcessor {
    void processEvent(String path, AttributeSet pathAttributes, AttributeSet oldAttributes);
  }

  private MockResponse handle(String path, EventProcessor eventProcessor) {
    MockResponse response = new MockResponse();
    List<String> items = new ArrayList<>();
    AttributeSet query = attributeExtractor.fromPath(path);

    synchronized (map) {
      new ArrayList<>(map.entrySet()).stream()
          .filter(entry -> entry.getKey().matches(query))
          .forEach(entry -> {
            LOGGER.debug("Entry found for query {} : {}", query, entry);
            items.add(entry.getValue());
            if (eventProcessor != null) {
              eventProcessor.processEvent(path, query, entry.getKey());
            }
          });
    }

    if (query.containsKey(KubernetesAttributesExtractor.NAME)) {
      if (!items.isEmpty()) {
        response.setBody(items.get(0));
        response.setResponseCode(HttpURLConnection.HTTP_OK);
      } else {
        response.setResponseCode(HttpURLConnection.HTTP_NOT_FOUND);
      }
    } else {
      response.setBody(kubernetesResponseComposer.compose(items, String.valueOf(resourceVersion.get())));
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
    return process(request, patchHandler);
  }

  /**
   * Performs a delete for the corresponding object from the in-memory db.
   *
   * @param path String
   * @return The {@link MockResponse}
   */
  @Override
  public MockResponse handleDelete(String path) {
    return handle(path, (p, a, o) -> processEvent(path, a, o, null));
  }

  @Override
  public long requestResourceVersion() {
    return resourceVersion.incrementAndGet();
  }

  @Override
  public AttributeSet getKey(String path) {
    return kubernetesAttributesExtractor.fromPath(path);
  }

  @Override
  public Map.Entry<AttributeSet, String> findResource(AttributeSet attributes) {
    synchronized (map) {
      return map.entrySet().stream()
          .filter(entry -> entry.getKey().matches(attributes))
          .findFirst().orElse(null);
    }
  }

  @Override
  public boolean isStatusSubresourceEnabledForResource(String path) {
    return crdProcessor.isStatusSubresourceEnabledForResource(kubernetesAttributesExtractor.fromKubernetesPath(path));
  }

  @Override
  public void processEvent(String path, AttributeSet pathAttributes, AttributeSet oldAttributes, String newState) {
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
          synchronized (map) {
            map.entrySet().stream()
                .filter(entry -> watch.attributeMatches(entry.getKey()))
                .forEach(entry -> watch.sendWebSocketResponse(entry.getValue(), Action.ADDED));
          }
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
    for (String q : queryString.split("&")) {
      if (q.contains("fieldSelector") && q.contains("metadata.name")) {
        String[] s = q.split("=");
        name = s[s.length - 1];
      }
    }
    return name.isEmpty() ? null : name;
  }

  @Override
  public void reset() {
    map.clear();
  }
}
