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
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.EditReplaceDeletable;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.internal.URLUtils;
import io.fabric8.kubernetes.client.internal.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static io.fabric8.kubernetes.client.internal.Utils.join;

public class BaseOperation<C extends Client, T, L extends KubernetesResourceList, D extends Doneable<T>, R extends ClientResource<T, D>>
  implements ClientMixedOperation<C, T, L, D, R> {

  protected static final ObjectMapper mapper = new ObjectMapper();

  private final C client;

  private final String name;
  private final String namespace;
  private final String resourceT;
  private final Boolean cascading;
  private final T item;

  private final Map<String, String> labels = new TreeMap<>();
  private final Map<String, String> labelsNot = new TreeMap<>();
  private final Map<String, String[]> labelsIn = new TreeMap<>();
  private final Map<String, String[]> labelsNotIn = new TreeMap<>();
  private final Map<String, String> fields = new TreeMap<>();

  private final Class<T> type;
  private final Class<L> listType;
  private final Class<D> doneableType;

  private boolean reaping;

  protected BaseOperation(C client, String resourceT, String namespace, String name, Boolean cascading, T item) {
    this.client = client;
    this.resourceT = resourceT;
    this.namespace = namespace;
    this.name = name;
    this.cascading = cascading;
    this.item = item;
    this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    this.listType = (Class<L>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
    this.doneableType = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[3];
  }

  protected BaseOperation(C client, String resourceT, String namespace, String name, Boolean cascading, T item, Class<T> type, Class<L> listType, Class<D> doneableType) {
    this.client = client;
    this.resourceT = resourceT;
    this.namespace = namespace;
    this.name = name;
    this.cascading = cascading;
    this.item = item;
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
        requestUrl = new URL(URLUtils.join(requestUrl.toString(), name));
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

  public RootPaths getRootPaths() {
    try {
      URL requestUrl = client.getMasterUrl();
      Future<Response> f = getClient().getHttpClient().prepareGet(requestUrl.toString()).execute();
      Response r = f.get();
      assertResponseCode(r, 200);
      return mapper.readValue(r.getResponseBodyAsStream(), RootPaths.class);
    } catch (KubernetesClientException e) {
      if (e.getCode() != 404) {
        throw e;
      }
      return null;
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  T getMandatory() {
    T item = get();
    if (item != null) {
      return item;
    }
    throw new KubernetesClientException("Resource not found!", 404, new StatusBuilder().withCode(404).withMessage("Not found.").build());
  }

  @Override
  public D edit() throws KubernetesClientException {
    throw new KubernetesClientException("Cannot edit read-only resources");
  }

  @Override
  public R withName(String name) {
    try {
      return (R) getClass()
        .getConstructor(Client.class, String.class, String.class, Boolean.class, type)
        .newInstance(client, namespace, name, cascading, item);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public ClientNonNamespaceOperation<C, T, L, D, R> inNamespace(String namespace) {
    try {
      return getClass()
        .getConstructor(Client.class, String.class, String.class, Boolean.class, type)
        .newInstance(client, namespace, name, cascading, item);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public ClientNonNamespaceOperation<C, T, L, D, R> inAnyNamespace() {
    return inNamespace(null);
  }


  @Override
  public EditReplaceDeletable<T, T, D, Boolean> cascading(boolean enabled) {
    try {
      return getClass()
        .getConstructor(Client.class, String.class, String.class, Boolean.class, type)
        .newInstance(client, namespace, name, enabled, item);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public R load(InputStream is) {
    try {
      return (R) getClass()
        .getConstructor(Client.class, String.class, String.class, Boolean.class, type)
        .newInstance(client, namespace, name, cascading, client.unmarshal(is, type));
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public T create(T... resources) throws KubernetesClientException {
    try {
      if (resources.length > 1) {
        throw new IllegalArgumentException("Too many items to create.");
      } else if (resources.length == 1) {
        return handleCreate(resources[0]);
      } else if (getItem() == null) {
        throw new IllegalArgumentException("Nothing to create.");
      } else {
        return handleCreate(getItem());
      }
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
  public FilterWatchListDeletable<T, L, Boolean> withLabels(Map<String, String> labels) {
    this.labels.putAll(labels);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean> withoutLabels(Map<String, String> labels) throws
    KubernetesClientException {
    labelsNot.putAll(labels);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean> withLabelIn(String key, String... values) throws
    KubernetesClientException {
    labelsIn.put(key, values);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean> withLabelNotIn(String key, String... values) throws
    KubernetesClientException {
    labelsNotIn.put(key, values);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean> withLabel(String key, String value) {
    labels.put(key, value);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean> withoutLabel(String key, String value) throws
    KubernetesClientException {
    labelsNot.put(key, value);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean> withFields(Map<String, String> labels) {
    fields.putAll(labels);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean> withField(String key, String value) {
    fields.put(key, value);
    return this;
  }

  String getLabelQueryParam() {
    StringBuilder sb = new StringBuilder();
    if (labels != null && !labels.isEmpty()) {
      for (Iterator<Map.Entry<String, String>> iter = labels.entrySet().iterator(); iter.hasNext(); ) {
        if (sb.length() > 0) {
          sb.append(",");
        }
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
      assertResponseCode(r, 200);
      return mapper.readValue(r.getResponseBodyAsStream(), listType);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public Boolean delete() {
    if (name != null && !name.isEmpty()) {
      try {
        if (cascading && !isReaping()) {
          Reaper reaper = ReaperFactory.getReaper(this);
          if (reaper != null) {
            setReaping(true);
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


  @Override
  public Boolean delete(T... items) {
    return delete(Arrays.asList(items));
  }

  @Override
  public Boolean delete(List<T> items) {
    try {
      for (T item : items) {
        handleDelete(item);
      }
    } catch (KubernetesClientException e) {
      if (e.getCode() != 404) {
        throw e;
      }
      return false;
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
    return true;
  }

  void deleteThis() throws KubernetesClientException {
    try {
      if (item != null) {
        handleDelete(item);
      } else {
        handleDelete(getResourceUrl());
      }
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  void deleteList() throws KubernetesClientException {
    delete(list().getItems());
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

  public boolean isNamespaceRequired() {
    return true;
  }

  protected URL getNamespacedUrl(String namespace) throws MalformedURLException {
    URL requestUrl = getRootUrl();
    if (namespace != null) {
      requestUrl = new URL(URLUtils.join(requestUrl.toString(), "namespaces", namespace));
    }
    requestUrl = new URL(URLUtils.join(requestUrl.toString(), resourceT));
    return requestUrl;
  }

  protected URL getNamespacedUrl() throws MalformedURLException {
    return getNamespacedUrl(getNamespace());
  }

  protected URL getResourceUrl(String namespace, String name) throws MalformedURLException {
    if (name == null) {
      return getNamespacedUrl(namespace);
    }
    return new URL(URLUtils.join(getNamespacedUrl(namespace).toString(), name));
  }

  protected URL getResourceUrl() throws MalformedURLException {
    if (name == null) {
      return getNamespacedUrl();
    }
    return new URL(URLUtils.join(getNamespacedUrl().toString(), name));
  }

  protected String checkNamespace(T item) {
    String operationNs = getNamespace();
    String itemNs = item instanceof HasMetadata ? ((HasMetadata) item).getMetadata().getNamespace() : null;
    if (Utils.isNullOrEmpty(operationNs) && Utils.isNullOrEmpty(itemNs)) {
      if (!isNamespaceRequired()) {
        return null;
      } else {
        throw new KubernetesClientException("Namespace not specified. But operation requires namespace.");
      }
    } else if (Utils.isNullOrEmpty(itemNs)) {
      return operationNs;
    } else if (Utils.isNullOrEmpty(operationNs)) {
      return itemNs;
    } else if (itemNs.equals(operationNs)) {
      return itemNs;
    }
    throw new KubernetesClientException("Namespace mismatch. Item namespace:" + itemNs + ". Operation namespace:" + operationNs + ".");
  }

  protected String checkName(T item) {
    String operationName = getName();
    String itemName = item instanceof HasMetadata ? ((HasMetadata) item).getMetadata().getName() : null;
    if (Utils.isNullOrEmpty(operationName) && Utils.isNullOrEmpty(itemName)) {
      return null;
    } else if (Utils.isNullOrEmpty(itemName)) {
      return operationName;
    } else if (Utils.isNullOrEmpty(operationName)) {
      return itemName;
    } else if (itemName.equals(operationName)) {
      return itemName;
    }
    throw new KubernetesClientException("Name mismatch. Item name:" + itemName + ". Operation name:" + operationName + ".");
  }

  /**
   * Checks if the response status code is the expected and throws the appropriate KubernetesClientException if not.
   *
   * @param r                  The {@link com.ning.http.client.Response} object.
   * @param expectedStatusCode The expected status code.
   * @throws KubernetesClientException When the response code is not the expected.
   */
  protected void assertResponseCode(Response r, int expectedStatusCode) {
    int statusCode = r.getStatusCode();
    String customMessage = client.getConfiguration().getErrorMessages().get(statusCode);

    if (statusCode == expectedStatusCode) {
      return;
    } else if (customMessage != null) {
      throw new KubernetesClientException("Error accessing: " + r.getUri().toString() + ",due to:" + customMessage);
    } else {
      try {
        Status status = mapper.readValue(r.getResponseBodyAsStream(), Status.class);
        throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
      } catch (IOException e) {
        throw new KubernetesClientException(e.getMessage(), statusCode, new StatusBuilder()
          .withCode(statusCode)
          .withMessage(e.getMessage())
          .build());
      }
    }
  }


  protected T handleResponse(AsyncHttpClient.BoundRequestBuilder requestBuilder, int successStatusCode) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    Future<Response> f = requestBuilder.execute();
    Response r = f.get();
    assertResponseCode(r, successStatusCode);
    return mapper.readValue(r.getResponseBodyAsStream(), getType());
  }

  protected void handleDelete(T resource) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    handleDelete(getResourceUrl(checkNamespace(resource), checkName(resource)));
  }

  protected void handleDelete(URL requestUrl) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().prepareDelete(requestUrl.toString());
    Future<Response> f = requestBuilder.execute();
    Response r = f.get();
    assertResponseCode(r, 200);
  }

  protected T handleCreate(T resource) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().preparePost(getNamespacedUrl(checkNamespace(resource)).toString());
    requestBuilder.setBody(mapper.writer().writeValueAsString(resource));
    return handleResponse(requestBuilder, 201);
  }

  protected T handleReplace(T updated) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().preparePut(getResourceUrl(checkNamespace(updated), checkName(updated)).toString());
    requestBuilder.setBody(mapper.writer().writeValueAsString(updated));
    return handleResponse(requestBuilder, 200);
  }

  protected T handleGet(URL resourceUrl) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().prepareGet(resourceUrl.toString());
    return handleResponse(requestBuilder, 200);
  }

  public URL getRootUrl() {
    try {
      return new URL(URLUtils.join(client.getMasterUrl().toString(), "api", client.getApiVersion()));
    } catch (MalformedURLException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
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

  public T getItem() {
    return item;
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
  public C getClient() {
    return client;
  }

  protected boolean isReaping() {
    return reaping;
  }

  protected void setReaping(boolean reaping) {
    this.reaping = reaping;
  }
}
