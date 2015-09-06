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
package io.fabric8.kubernetes.client.dsl.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.EditReplaceDeletable;
import io.fabric8.kubernetes.client.dsl.CreateFromLoadable;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeleteable;

import java.io.IOException;
import java.io.InputStream;
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

public class BaseOperation<K extends KubernetesClient, T, L extends KubernetesResourceList, D extends Doneable<T>, R extends ClientResource<T, D>, C extends CreateFromLoadable<T, D>>
  implements ClientMixedOperation<K, T, L, D, R>, CreateFromLoadable<T, D> {

  protected static final ObjectMapper mapper = new ObjectMapper();

  private final K client;

  private final String name;
  private final T item;
  private final String namespace;
  private final String resourceT;
  private final Boolean cascading;

  private final Map<String, String> labels = new TreeMap<>();
  private final Map<String, String> labelsNot = new TreeMap<>();
  private final Map<String, String[]> labelsIn = new TreeMap<>();
  private final Map<String, String[]> labelsNotIn = new TreeMap<>();
  private final Map<String, String> fields = new TreeMap<>();

  private final Class<T> clientType;
  private final Class<T> type;
  private final Class<L> listType;
  private final Class<D> doneableType;

  protected BaseOperation(K client, String resourceT, String namespace, String name) {

  protected BaseOperation(C client, String resourceT, String namespace, String name, Boolean cascading) {
    this.client = client;
    this.namespace = namespace;
    this.item = null;
    this.name = name;
    this.resourceT = resourceT;
    this.cascading = cascading;
    this.clientType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    this.listType = (Class<L>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
    this.doneableType = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[3];
  }

    protected BaseOperation(K client, String resourceT, String namespace, T item) {
      this.client = client;
      this.namespace = namespace;
      this.item = item;
      if (item instanceof HasMetadata) {
        this.name = ((HasMetadata) item).getMetadata().getName();
      } else {
        this.name = null;
      }
      this.resourceT = resourceT;
      this.clientType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
      this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
      this.listType = (Class<L>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
      this.doneableType = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[3];
    }

    protected BaseOperation(K client, String resourceT, String namespace, String name, Class<T> clientType, Class<T> type, Class<L> listType, Class<D> doneableType) {
      this.client = client;
      this.namespace = namespace;
      this.item = null;
      this.name = name;
      this.resourceT = resourceT;
      this.clientType = clientType;
      this.type = type;
      this.listType = listType;
      this.doneableType = doneableType;
    }

  @Override
  public T get() {
    if (item != null) {
      return item;
    }
    try {
      URL requestUrl = getNamespacedUrl();
      if (name != null) {
        requestUrl = new URL(requestUrl, name);
      }
      return handleGet(requestUrl);
    } catch (KubernetesClientException e) {
      if (e.getCode() != 404) {
        throw e;
      }
      return null;
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public D edit() throws KubernetesClientException {
    throw new KubernetesClientException("Cannot edit read-only resources");
  }

  @Override
  public R withName(String name) {
    try {
      return (R) getClass()
        .getConstructor(clientType, String.class, String.class, Boolean.class)
        .newInstance(client, namespace, name, cascading);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public ClientNonNamespaceOperation<K, T, L, D, R> inNamespace(String namespace) {
    try {
      return getClass()
        .getConstructor(clientType, String.class, String.class, Boolean.class)
        .newInstance(client, namespace, name, cascading);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }


  @Override
  public EditReplaceDeletable<T, T, D, Boolean> cascading(boolean enabled) {
    try {
      return getClass()
        .getConstructor(clientType, String.class, String.class, Boolean.class)
        .newInstance(client, namespace, name, enabled);
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
  public T create() throws KubernetesClientException {
    try {
      return handleCreate(item);
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
  public FilterWatchListDeleteable<T, L, Boolean> withLabels(Map<String, String> labels) {
    labels.putAll(labels);
    return this;
  }

  @Override
  public FilterWatchListDeleteable<T, L, Boolean> withoutLabels(Map<String, String> labels) throws
    KubernetesClientException {
    labelsNot.putAll(labels);
    return this;
  }

  @Override
  public FilterWatchListDeleteable<T, L, Boolean> withLabelIn(String key, String... values) throws
    KubernetesClientException {
    labelsIn.put(key, values);
    return this;
  }

  @Override
  public FilterWatchListDeleteable<T, L, Boolean> withLabelNotIn(String key, String... values) throws
    KubernetesClientException {
    labelsNotIn.put(key, values);
    return this;
  }

  @Override
  public FilterWatchListDeleteable<T, L, Boolean> withLabel(String key, String value) {
    labels.put(key, value);
    return this;
  }

  @Override
  public FilterWatchListDeleteable<T, L, Boolean> withoutLabel(String key, String value) throws
    KubernetesClientException {
    labelsNot.put(key, value);
    return this;
  }

  @Override
  public FilterWatchListDeleteable<T, L, Boolean> withFields(Map<String, String> labels) {
    fields.putAll(labels);
    return this;
  }

  @Override
  public FilterWatchListDeleteable<T, L, Boolean> withField(String key, String value) {
    fields.put(key, value);
    return this;
  }

  String getLabelQueryParam() {
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
    return sb.toString();
  }

  String getFieldQueryParam() {
    StringBuilder sb = new StringBuilder();
    if (fields != null && !fields.isEmpty()) {
      if (sb.length() > 0) {
        sb.append(",");
      }
      for (Iterator<Map.Entry<String, String>> iter = fields.entrySet().iterator(); iter.hasNext(); ) {
        Map.Entry<String, String> entry = iter.next();
        sb.append(entry.getKey()).append("=").append(entry.getValue());
      }
    }
    return sb.toString();
  }

  public L list() throws KubernetesClientException {
    try {
      URL requestUrl = getNamespacedUrl();
      AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().prepareGet(requestUrl.toString());

      String labelQueryParam = getLabelQueryParam();
      if (labelQueryParam.length() > 0) {
        requestBuilder.addQueryParam("labelSelector", labelQueryParam);
      }

      String fieldQueryString = getFieldQueryParam();
      if (fieldQueryString.length() > 0) {
        requestBuilder.addQueryParam("fieldSelector", fieldQueryString);
      }

      Future<Response> f = requestBuilder.execute();
      Response r = f.get();
      if (r.getStatusCode() != 200) {
        Status status = mapper.readerFor(Status.class).readValue(r.getResponseBodyAsStream());
        throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
      }
      return mapper.readerFor(listType).readValue(r.getResponseBodyAsStream());
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public Boolean delete() {
    if (name != null && !name.isEmpty()) {
      try {
        if (cascading) {
          Reaper reaper = ReaperFactory.getReaper(this);
          if (reaper != null) {
            reaper.reap();
          }
        }
        deleteThis();
        return true;
      } catch (KubernetesClientException e) {
        if (e.getCode() != 404) {
          throw e;
        }
        return false;
      }
    } else {
      try {
        deleteList();
        return true;
      } catch (KubernetesClientException e) {
        if (e.getCode() != 404) {
          throw e;
        }
        return false;
      }
    }
  }

  void deleteThis() throws KubernetesClientException {
    try {
      handleDelete(getResourceUrl());
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  void deleteList() throws KubernetesClientException {
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
        AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().prepareDelete(requestUrl.toString());
        Future<Response> f = requestBuilder.execute();
        Response r = f.get();
        if (r.getStatusCode() != 200) {
          Status status = mapper.readerFor(Status.class).readValue(r.getResponseBodyAsStream());
          throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
        }
      }
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  public Watch watch(final Watcher<T> watcher) throws KubernetesClientException {
    return watch(null, watcher);
  }

  public Watch watch(String resourceVersion, final Watcher<T> watcher) throws KubernetesClientException {
    try {
      return new WatchConnectionManager<>(this, resourceVersion, watcher, client.getConfiguration().getWatchReconnectInterval(), client.getConfiguration().getWatchReconnectLimit());
    } catch (MalformedURLException | InterruptedException | ExecutionException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public T update(T item) {
    return replace(item);
  }


  @Override
  public T replace(T item) {
    throw new KubernetesClientException("Cannot update read-only resources");
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
    if (name == null) {
      return getNamespacedUrl();
    }
    return new URL(getNamespacedUrl(), name);
  }

  protected T handleResponse(AsyncHttpClient.BoundRequestBuilder requestBuilder, int successStatusCode) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    Future<Response> f = requestBuilder.execute();
    Response r = f.get();
    if (r.getStatusCode() != successStatusCode) {
      Status status = mapper.readerFor(Status.class).readValue(r.getResponseBodyAsStream());
      throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
    }
    return mapper.readerFor(getType()).readValue(r.getResponseBodyAsStream());
  }

  protected void handleDelete(URL requestUrl) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().prepareDelete(requestUrl.toString());
    Future<Response> f = requestBuilder.execute();
    Response r = f.get();
    if (r.getStatusCode() != 200) {
      Status status = mapper.readerFor(Status.class).readValue(r.getResponseBodyAsStream());
      throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
    }
  }

  protected T handleCreate(T resource) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().preparePost(getNamespacedUrl().toString());
    requestBuilder.setBody(mapper.writer().writeValueAsString(resource));
    return handleResponse(requestBuilder, 201);
  }

  protected T handleReplace(URL resourceUrl, T updated) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().preparePut(resourceUrl.toString());
    requestBuilder.setBody(mapper.writer().writeValueAsString(updated));
    return handleResponse(requestBuilder, 200);
  }

  protected T handleGet(URL resourceUrl) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().prepareGet(resourceUrl.toString());
    return handleResponse(requestBuilder, 200);
  }

  public URL getRootUrl() {
    return client.getMasterUrl();
  }

  public String getName() {
    return name;
  }

  public String getNamespace() {
    return namespace;
  }

  public Boolean isCascading() {
    return cascading;
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

  @Override
  public K getClient() {
    return client;
  }

  @Override
  public C load(InputStream is) {
    try {
      return (C) getClass()
        .getConstructor(clientType, String.class, type)
        .newInstance(client, namespace, client.unmarshal(is, type));
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }
}
