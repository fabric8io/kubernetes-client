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
package io.fabric8.kubernetes.client.dsl.base;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.Deletable;
import io.fabric8.kubernetes.client.dsl.EditReplaceDeletable;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.Reaper;
import io.fabric8.kubernetes.client.dsl.Watchable;
import io.fabric8.kubernetes.client.dsl.internal.WatchConnectionManager;
import io.fabric8.kubernetes.client.utils.URLUtils;

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

import static io.fabric8.kubernetes.client.utils.Utils.join;

public class BaseOperation<T, L extends KubernetesResourceList, D extends Doneable<T>, R extends ClientResource<T, D>>
  extends OperationSupport
  implements ClientMixedOperation<T, L, D, R> {

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
  private final String resourceVersion;
  private final Boolean reloadingFromServer;
  private final long gracePeriodSeconds;

  private boolean reaping;
  protected Reaper reaper;

  protected BaseOperation(OkHttpClient client, Config config, String apiGroup, String apiVersion, String resourceT, String namespace, String name, Boolean cascading, T item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds) {
    super(client, config, apiGroup, apiVersion, resourceT, namespace, name);
    this.cascading = cascading;
    this.item = item;
    this.reloadingFromServer = reloadingFromServer;
    this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    this.listType = (Class<L>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    this.doneableType = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
    this.reaper = null;
    this.resourceVersion = resourceVersion;
    this.gracePeriodSeconds = gracePeriodSeconds;
  }

  protected BaseOperation(OkHttpClient client, Config config, String apiGroup, String apiVersion, String resourceT, String namespace, String name, Boolean cascading, T item, String resourceVersion, Boolean reloadingFromServer, Class<T> type, Class<L> listType, Class<D> doneableType) {
    super(client, config, apiGroup, apiVersion, resourceT, namespace, name);
    this.cascading = cascading;
    this.item = item;
    this.resourceVersion = resourceVersion;
    this.reloadingFromServer = reloadingFromServer;
    this.type = type;
    this.listType = listType;
    this.doneableType = doneableType;
    this.reaper = null;
    this.gracePeriodSeconds = -1;
  }

  @Override
  public T get() {
    if (item != null && !reloadingFromServer) {
      return item;
    }
    try {
      URL requestUrl = getNamespacedUrl();
      if (name != null) {
        requestUrl = new URL(URLUtils.join(requestUrl.toString(), name));
      } else if (item != null && reloadingFromServer) {
        requestUrl = new URL(URLUtils.join(requestUrl.toString(), checkName(item)));
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
      URL requestUrl = new URL(config.getMasterUrl());
      Request.Builder req = new Request.Builder().get().url(requestUrl);
      return handleResponse(req, 200, RootPaths.class);
    } catch (KubernetesClientException e) {
      if (e.getCode() != 404) {
        throw e;
      }
      return null;
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  public T getMandatory() {
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
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name must be provided.");
    }
    try {
      return (R) getClass()
        .getConstructor(OkHttpClient.class, Config.class, String.class, String.class, String.class, Boolean.class, type, String.class, Boolean.class, long.class)
        .newInstance(client, config, apiVersion, namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public ClientNonNamespaceOperation<T, L, D, R> inNamespace(String namespace) {
    try {
      return getClass()
        .getConstructor(OkHttpClient.class, Config.class, String.class, String.class, String.class, Boolean.class, type, String.class, Boolean.class, long.class)
        .newInstance(client, config, apiVersion, namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public ClientNonNamespaceOperation<T, L, D, R> inAnyNamespace() {
    return inNamespace(null);
  }


  @Override
  public EditReplaceDeletable<T, T, D, Boolean> cascading(boolean cascading) {
    try {
      return getClass()
        .getConstructor(OkHttpClient.class, Config.class, String.class, String.class, String.class, Boolean.class, type, String.class, Boolean.class, long.class)
        .newInstance(client, config, apiVersion, namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public R load(InputStream is) {
    try {
      return (R) getClass()
        .getConstructor(OkHttpClient.class, Config.class, String.class, String.class, String.class, Boolean.class, type, String.class, Boolean.class, long.class)
        .newInstance(client, config, apiVersion, namespace, name, cascading, unmarshal(is, type), resourceVersion, reloadingFromServer, gracePeriodSeconds);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public Gettable<T> fromServer() {
    try {
      return (R) getClass()
              .getConstructor(OkHttpClient.class, Config.class, String.class, String.class, String.class, Boolean.class, type, String.class, Boolean.class, long.class)
              .newInstance(client, config, apiVersion, namespace, name, cascading, item, resourceVersion, true, gracePeriodSeconds);
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
    final Function<T, T> visitor = new Function<T, T>() {
      @Override
      public T apply(T resource) {
        try {
          return create(resource);
        } catch (Exception e) {
          throw KubernetesClientException.launderThrowable(e);
        }
      }
    };

    try {
      return getDoneableType().getDeclaredConstructor(Function.class).newInstance(visitor);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withLabels(Map<String, String> labels) {
    this.labels.putAll(labels);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withoutLabels(Map<String, String> labels) throws
    KubernetesClientException {
    labelsNot.putAll(labels);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withLabelIn(String key, String... values) throws
    KubernetesClientException {
    labelsIn.put(key, values);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withLabelNotIn(String key, String... values) throws
    KubernetesClientException {
    labelsNotIn.put(key, values);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withLabel(String key, String value) {
    labels.put(key, value);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withoutLabel(String key, String value) throws
    KubernetesClientException {
    labelsNot.put(key, value);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withFields(Map<String, String> labels) {
    fields.putAll(labels);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withField(String key, String value) {
    fields.put(key, value);
    return this;
  }

  public String getLabelQueryParam() {
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

  public String getFieldQueryParam() {
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
      HttpUrl.Builder requestUrlBuilder = HttpUrl.get(getNamespacedUrl()).newBuilder();

      String labelQueryParam = getLabelQueryParam();
      if (labelQueryParam.length() > 0) {
        requestUrlBuilder.addQueryParameter("labelSelector", labelQueryParam);
      }

      String fieldQueryString = getFieldQueryParam();
      if (fieldQueryString.length() > 0) {
        requestUrlBuilder.addQueryParameter("fieldSelector", fieldQueryString);
      }

      Request.Builder requestBuilder = new Request.Builder().get().url(requestUrlBuilder.build());
      return handleResponse(requestBuilder, 200, listType);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public Boolean delete() {
    if (name != null && !name.isEmpty()) {
      try {
        if (cascading && !isReaping()) {
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
        handleDelete(item, gracePeriodSeconds);
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
        handleDelete(item, gracePeriodSeconds);
      } else {
        handleDelete(getResourceUrl(), gracePeriodSeconds);
      }
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  void deleteList() throws KubernetesClientException {
    delete(list().getItems());
  }

  @Override
  public Watchable<Watch, Watcher<T>> withResourceVersion(String resourceVersion) {
    try {
      return getClass()
              .getConstructor(OkHttpClient.class, Config.class, String.class, String.class, String.class, Boolean.class, type, String.class, Boolean.class, long.class)
              .newInstance(client, config, apiVersion, namespace, name, cascading, item, resourceVersion, false, gracePeriodSeconds);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  public Watch watch(final Watcher<T> watcher) throws KubernetesClientException {
    return watch(resourceVersion, watcher);
  }

  public Watch watch(String resourceVersion, final Watcher<T> watcher) throws KubernetesClientException {
    try {
      return new WatchConnectionManager(client, this, resourceVersion, watcher, config.getWatchReconnectInterval(), config.getWatchReconnectLimit());
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

  public boolean isResourceNamespaced() {
    return true;
  }

  protected T handleResponse(Request.Builder requestBuilder, int successStatusCode) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    return handleResponse(requestBuilder, successStatusCode, getType());
  }

  protected T handleCreate(T resource) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    return handleCreate(resource, getType());
  }

  protected T handleReplace(T updated) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    return handleReplace(updated, getType());
  }

  protected T handleGet(URL resourceUrl) throws InterruptedException, ExecutionException, IOException {
    return handleGet(resourceUrl, getType());
  }

  public Boolean isCascading() {
    return cascading;
  }

  public T getItem() {
    return item;
  }

  public String getResourceVersion() {
    return resourceVersion;
  }

  public Boolean getReloadingFromServer() {
    return reloadingFromServer;
  }

  public Long getGracePeriodSeconds() {
    return gracePeriodSeconds;
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

  protected boolean isReaping() {
    return reaping;
  }

  protected void setReaping(boolean reaping) {
    this.reaping = reaping;
  }

  @Override
  public Deletable<Boolean> withGracePeriod(long gracePeriodSeconds)
  {
    try {
      return getClass()
        .getConstructor(OkHttpClient.class, Config.class, String.class, String.class, String.class, Boolean.class, type, String.class, Boolean.class, long.class)
        .newInstance(client, config, apiVersion, namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }
}
