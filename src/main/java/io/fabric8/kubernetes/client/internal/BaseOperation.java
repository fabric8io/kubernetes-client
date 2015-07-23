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
package io.fabric8.kubernetes.client.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import com.ning.http.client.ws.DefaultWebSocketListener;
import com.ning.http.client.ws.WebSocket;
import com.ning.http.client.ws.WebSocketUpgradeHandler;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.CreateWatchListDeleteable;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.FilterWatchListDeleteable;
import io.fabric8.kubernetes.client.GetEditUpdateDeleteWatchable;
import io.fabric8.kubernetes.client.NonNamespaceOperation;
import io.fabric8.kubernetes.client.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static io.fabric8.kubernetes.client.internal.Utils.join;

public class BaseOperation<T extends HasMetadata, L extends KubernetesResourceList, D extends Doneable<T>>
  implements Operation<T, L, D>,
  NonNamespaceOperation<T,L,D>,
  CreateWatchListDeleteable<T,L,D>,
  GetEditUpdateDeleteWatchable<T, D> {

  protected static final ObjectMapper mapper = new ObjectMapper();

  private final URL rootUrl;

  private final AsyncHttpClient httpClient;

  private final String name;
  private final String namespace;
  private final String resourceT;

  private final Map<String, String> labels = new TreeMap<>();
  private final Map<String, String> labelsNot = new TreeMap<>();
  private final Map<String, String[]> labelsIn = new TreeMap<>();
  private final Map<String, String[]> labelsNotIn = new TreeMap<>();
  private final Map<String, String> fields = new TreeMap<>();

  private final Class<T> type;
  private final Class<L> listType;
  private final Class<D> doneableType;

  protected BaseOperation(AsyncHttpClient httpClient, URL rootUrl, String resourceT, String namespace, String name) {
    this.rootUrl = rootUrl;
    this.httpClient = httpClient;
    this.namespace = namespace;
    this.name = name;
    this.resourceT = resourceT;
    this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    this.listType = (Class<L>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    this.doneableType = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
  }

  protected BaseOperation(AsyncHttpClient httpClient, URL rootUrl, String resourceT, String namespace, String name, Class<T> type, Class<L> listType, Class<D> doneableType) {
    this.rootUrl = rootUrl;
    this.httpClient = httpClient;
    this.namespace = namespace;
    this.name = name;
    this.resourceT = resourceT;
    this.type = type;
    this.listType = listType;
    this.doneableType = doneableType;
  }

  @Override
  public T get() throws KubernetesClientException {
    try {
      URL requestUrl = getNamespacedUrl();
      URL resourceUrl = new URL(requestUrl, name);
      return handleGet(resourceUrl);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public D edit() throws KubernetesClientException {

    final Visitor<T> visitor = new Visitor<T>() {
      @Override
      public void visit(T resource) {
        try {
          handleUpdate(getResourceUrl(), resource);
        } catch (Exception e) {
          throw KubernetesClientException.launderThrowable(e);
        }
      }
    };

    try {

      return getDoneableType().getDeclaredConstructor(getType(), Visitor.class).newInstance(get(), visitor);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public GetEditUpdateDeleteWatchable<T, D> withName(String name) {
    try {
      return getClass()
        .getConstructor(AsyncHttpClient.class, URL.class, String.class, String.class)
        .newInstance(httpClient, rootUrl, namespace, name);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public NonNamespaceOperation<T, L, D> inNamespace(String namespace) {
    try {
      return getClass()
        .getConstructor(AsyncHttpClient.class, URL.class, String.class, String.class)
        .newInstance(httpClient, rootUrl, namespace, name);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }



  @Override
  public T create(T resource) throws KubernetesClientException {
    try {
      return handleCreate(resource);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public D createNew() throws KubernetesClientException {
    final Visitor<T> visitor = new Visitor<T>() {
      @Override
      public void visit(T resource) {
        try {
          create(resource);
        } catch (Exception e) {
          throw KubernetesClientException.launderThrowable(e);
        }
      }
    };

    try {
      return getDoneableType().getDeclaredConstructor(Visitor.class).newInstance(visitor);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public FilterWatchListDeleteable<T, L> withLabels(Map<String, String> labels) {
    labels.putAll(labels);
    return this;
  }

  @Override
  public FilterWatchListDeleteable<T, L> withoutLabels(Map<String, String> labels) throws KubernetesClientException {
    labelsNot.putAll(labels);
    return this;
  }

  @Override
  public FilterWatchListDeleteable<T, L> withLabelIn(String key, String... values) throws KubernetesClientException {
    labelsIn.put(key, values);
    return this;
  }

  @Override
  public FilterWatchListDeleteable<T, L>withLabelNotIn(String key, String... values) throws KubernetesClientException {
    labelsNotIn.put(key, values);
    return this;
  }

  @Override
  public FilterWatchListDeleteable<T, L> withLabel(String key, String value) {
    labels.put(key, value);
    return this;
  }

  @Override
  public FilterWatchListDeleteable<T, L> withoutLabel(String key, String value) throws KubernetesClientException {
    labelsNot.put(key, value);
    return this;
  }

  @Override
  public FilterWatchListDeleteable<T, L>withFields(Map<String, String> labels) {
    fields.putAll(labels);
    return this;
  }

  @Override
  public FilterWatchListDeleteable<T, L> withField(String key, String value) {
    fields.put(key, value);
    return this;
  }

  public L list() throws KubernetesClientException {
    try {
      URL requestUrl = getNamespacedUrl();
      AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().prepareGet(requestUrl.toString());
      StringBuilder sb = new StringBuilder();
      if (labels != null && !labels.isEmpty()) {
        if (sb.length() > 0) {
          sb.append(",");
        }
        for (Iterator<Map.Entry<String, String>> iter = labels.entrySet().iterator(); iter.hasNext(); ) {
          Map.Entry<String, String> entry = iter.next();
          sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
      }
      if (labelsNot != null && !labelsNot.isEmpty()) {
        for (Iterator<Map.Entry<String, String>> iter = labelsNot.entrySet().iterator(); iter.hasNext(); ) {
          if (sb.length() > 0) {
            sb.append(",");
          }
          Map.Entry<String, String> entry = iter.next();
          sb.append(entry.getKey()).append("!=").append(entry.getValue());
        }
      }
      if (labelsIn != null && !labelsIn.isEmpty()) {
        for (Iterator<Map.Entry<String, String[]>> iter = labelsIn.entrySet().iterator(); iter.hasNext(); ) {
          if (sb.length() > 0) {
            sb.append(",");
          }
          Map.Entry<String, String[]> entry = iter.next();
          sb.append(entry.getKey()).append(" in ").append("(").append(join(entry.getValue())).append(")");
        }
      }
      if (labelsNotIn != null && !labelsNotIn.isEmpty()) {
        for (Iterator<Map.Entry<String, String[]>> iter = labelsNotIn.entrySet().iterator(); iter.hasNext(); ) {
          if (sb.length() > 0) {
            sb.append(",");
          }
          Map.Entry<String, String[]> entry = iter.next();
          sb.append(entry.getKey()).append(" notin ").append("(").append(join(entry.getValue())).append(")");
        }
      }
      if (sb.length() > 0) {
        requestBuilder.addQueryParam("labelSelector", sb.toString());
      }

      sb = new StringBuilder();
      if (fields != null && !fields.isEmpty()) {
        if (sb.length() > 0) {
          sb.append(",");
        }
        for (Iterator<Map.Entry<String, String>> iter = fields.entrySet().iterator(); iter.hasNext(); ) {
          Map.Entry<String, String> entry = iter.next();
          sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
      }if (sb.length() > 0) {
        requestBuilder.addQueryParam("fieldSelector", sb.toString());
      }
      Future<Response> f = requestBuilder.execute();
      Response r = f.get();
      if (r.getStatusCode() != 200) {
        Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
        throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
      }
      return mapper.reader(listType).readValue(r.getResponseBodyAsStream());
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  public void delete() throws KubernetesClientException {
    try {
      L discoveredResources = list();

      for (Object resource : discoveredResources.getItems()) {
        // Dirty cast but should always be valid...
        HasMetadata metadataResource = (HasMetadata) resource;

        URL requestUrl = getRootUrl();
        if (metadataResource.getMetadata().getNamespace() != null) {
          requestUrl = new URL(requestUrl, "namespaces/" + metadataResource.getMetadata().getNamespace() + "/");
        }
        requestUrl = new URL(requestUrl, getResourceT() + "/" + metadataResource.getMetadata().getName());
        AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().prepareDelete(requestUrl.toString());
        Future<Response> f = requestBuilder.execute();
        Response r = f.get();
        if (r.getStatusCode() != 200) {
          Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
          throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
        }
      }
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  public WebSocket watch(final Watcher<T> watcher) throws KubernetesClientException {
    try {
      URL requestUrl = getNamespacedUrl();
      AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().prepareGet(requestUrl.toString().replaceFirst("^http", "ws"));
      if (labels != null && !labels.isEmpty()) {
        StringBuilder sb = new StringBuilder();
        for (Iterator<Map.Entry<String, String>> iter = labels.entrySet().iterator(); iter.hasNext(); ) {
          Map.Entry<String, String> entry = iter.next();
          sb.append(entry.getKey()).append("=").append(entry.getValue());
          if (iter.hasNext()) {
            sb.append(",");
          }
        }
        requestBuilder.addQueryParam("labelSelector", sb.toString());
      }
      if (fields != null && !fields.isEmpty()) {
        StringBuilder sb = new StringBuilder();
        for (Iterator<Map.Entry<String, String>> iter = fields.entrySet().iterator(); iter.hasNext(); ) {
          Map.Entry<String, String> entry = iter.next();
          sb.append(entry.getKey()).append("=").append(entry.getValue());
          if (iter.hasNext()) {
            sb.append(",");
          }
        }
        requestBuilder.addQueryParam("fieldSelector", sb.toString());
      }
      requestBuilder.addQueryParam("watch", "true");
      Future<WebSocket> f = requestBuilder.execute(new WebSocketUpgradeHandler.Builder().addWebSocketListener(
          new DefaultWebSocketListener() {

            private final Logger logger = LoggerFactory.getLogger(this.getClass());

            @Override
            public void onMessage(String message) {
              try {
                WatchEvent event = mapper.reader(WatchEvent.class).readValue(message);
                T obj = (T) event.getObject();
                Watcher.Action action = Watcher.Action.valueOf(event.getType());
                watcher.eventReceived(action, obj);
              } catch (IOException e) {
                logger.error("Could not deserialize watch event: {}", message, e);
              } catch (ClassCastException e) {
                logger.error("Received wrong type of object for watch", e);
              } catch (IllegalArgumentException e) {
                logger.error("Invalid event type", e);
              }
            }
          }).build()
      );
      return f.get();
    } catch (MalformedURLException | InterruptedException | ExecutionException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public void update(T item) {
    try {
      handleUpdate(getResourceUrl(), item);
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  protected URL getNamespacedUrl() throws MalformedURLException {
    URL requestUrl = getRootUrl();
    if (getNamespace() != null) {
      requestUrl = new URL(requestUrl, "namespaces/" + getNamespace() + "/");
    }
    requestUrl = new URL(requestUrl, resourceT + "/");
    return requestUrl;
  }


  protected URL getResourceUrl() throws MalformedURLException {
    return new URL(getNamespacedUrl(), name);
  }

  private T handleResponse(AsyncHttpClient.BoundRequestBuilder requestBuilder, int successStatusCode) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    Future<Response> f = requestBuilder.execute();
    Response r = f.get();
    if (r.getStatusCode() != successStatusCode) {
      Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
      throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
    }
    return mapper.reader(getType()).readValue(r.getResponseBodyAsStream());
  }

  protected void handleDelete(URL requestUrl) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().prepareDelete(requestUrl.toString());
    Future<Response> f = requestBuilder.execute();
    Response r = f.get();
    if (r.getStatusCode() != 200) {
      Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
      throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
    }
  }

  protected T handleCreate(T resource) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().preparePost(getNamespacedUrl().toString());
    requestBuilder.setBody(mapper.writer().writeValueAsString(resource));
    return handleResponse(requestBuilder, 201);
  }

  protected T handleUpdate(URL resourceUrl, T updated) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().preparePut(resourceUrl.toString());
    requestBuilder.setBody(mapper.writer().writeValueAsString(updated));
    return handleResponse(requestBuilder, 200);
  }

  protected T handleGet(URL resourceUrl) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().prepareGet(resourceUrl.toString());
    return handleResponse(requestBuilder, 200);
  }

  public URL getRootUrl() {
    return rootUrl;
  }

  public AsyncHttpClient getHttpClient() {
    return httpClient;
  }

  public String getNamespace() {
    return namespace;
  }

  public String getResourceT() {
    return resourceT;
  }

  public Class<T> getType() {
    return type;
  }

  public Class<L> getListType() {
    return listType;
  }

  public Class<D> getDoneableType() {
    return doneableType;
  }
}
