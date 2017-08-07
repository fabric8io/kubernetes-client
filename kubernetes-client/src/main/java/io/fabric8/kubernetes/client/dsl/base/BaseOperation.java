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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorRequirement;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.OperationInfo;
import io.fabric8.kubernetes.client.dsl.Replaceable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.DefaultOperationInfo;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Deletable;
import io.fabric8.kubernetes.client.dsl.EditReplacePatchDeletable;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.Reaper;
import io.fabric8.kubernetes.client.dsl.Watchable;
import io.fabric8.kubernetes.client.dsl.internal.WatchConnectionManager;
import io.fabric8.kubernetes.client.dsl.internal.WatchHTTPManager;
import io.fabric8.kubernetes.client.utils.URLUtils;

import java.io.File;
import java.io.FileInputStream;
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
import java.util.concurrent.TimeUnit;

import static io.fabric8.kubernetes.client.utils.Utils.isNotNullOrEmpty;
import static io.fabric8.kubernetes.client.utils.Utils.join;

public class BaseOperation<T, L extends KubernetesResourceList, D extends Doneable<T>, R extends Resource<T, D>>
  extends OperationSupport
  implements
  OperationInfo,
  MixedOperation<T, L, D, R>,
  Resource<T,D> {

  private final Boolean cascading;
  private final T item;

  private final Map<String, String> labels;
  private final Map<String, String> labelsNot;
  private final Map<String, String[]> labelsIn;
  private final Map<String, String[]> labelsNotIn;
  private final Map<String, String> fields;

  private final Class<T> type;
  private final Class<L> listType;
  private final Class<D> doneableType;
  private final String resourceVersion;
  private final Boolean reloadingFromServer;
  private final long gracePeriodSeconds;

  private boolean reaping;
  protected Reaper reaper;
  protected String apiGroupVersion;

  protected BaseOperation(OkHttpClient client, Config config, String apiGroup, String apiVersion, String resourceT, String namespace, String name, Boolean cascading, T item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields)  {
    super(client, config, apiGroup, apiVersion(item, apiVersion), resourceT, namespace, name(item, name));
    this.cascading = cascading;
    this.item = item;
    this.reloadingFromServer = reloadingFromServer;
    this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    this.listType = (Class<L>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    this.doneableType = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
    this.reaper = null;
    this.resourceVersion = resourceVersion;
    this.gracePeriodSeconds = gracePeriodSeconds;
    this.labels = labels;
    this.labelsNot = labelsNot;
    this.labelsIn = labelsIn;
    this.labelsNotIn = labelsNotIn;
    this.fields = fields;
  }

  protected BaseOperation(OkHttpClient client, Config config, String apiGroup, String apiVersion, String resourceT, String namespace, String name, Boolean cascading, T item, String resourceVersion, Boolean reloadingFromServer, Class<T> type, Class<L> listType, Class<D> doneableType) {
    super(client, config, apiGroup, apiVersion(item, apiVersion), resourceT, namespace, name(item, name));
    this.cascading = cascading;
    this.item = item;
    this.resourceVersion = resourceVersion;
    this.reloadingFromServer = reloadingFromServer;
    this.type = type;
    this.listType = listType;
    this.doneableType = doneableType;
    this.reaper = null;
    this.gracePeriodSeconds = -1;
    this.labels = new TreeMap<>();
    this.labelsNot = new TreeMap<>();
    this.labelsIn = new TreeMap<>();
    this.labelsNotIn = new TreeMap<>();
    this.fields = new TreeMap<>();
  }


  /**
   * Returns the name and falls back to the item name.
   * @param item  The item.
   * @param name  The name to check.
   * @param <T>
     * @return
     */
  private static <T> String name(T item, String name) {
    if (name != null && !name.isEmpty()) {
      return name;
    } else if (item instanceof HasMetadata) {
      HasMetadata h = (HasMetadata) item;
      return h.getMetadata() != null ? h.getMetadata().getName() : null;
    }
    return null;
  }

  /**
   * Returns the api version falling back to the items apiVersion if not null.
   * @param <T>
   * @param item
   * @param apiVersion
   * @return
   */
  private static <T> String apiVersion(T item, String apiVersion) {
    if (apiVersion != null && !apiVersion.isEmpty()) {
      return trimVersion(apiVersion);
    } else if (item instanceof HasMetadata) {
      return trimVersion(((HasMetadata)item).getApiVersion());
    }
    return null;
  }

  /**
   * Separates apiVersion for apiGroup/apiVersion combination.
   * @param apiVersion  The apiVersion or apiGroup/apiVersion combo.
   * @return            Just the apiVersion part without the apiGroup.
     */
  private static String trimVersion(String apiVersion) {
    if (apiVersion == null) {
      return null;
    } else {
      String[] versionParts = apiVersion.split("/");
      return versionParts[versionParts.length - 1];
    }
  }

  @Override
  public T get() {
    try {
      T answer = getMandatory();
      if (answer instanceof HasMetadata) {
        HasMetadata hasMetadata = (HasMetadata) answer;
        updateApiVersion(hasMetadata);
      } else if (answer instanceof KubernetesResourceList) {
        KubernetesResourceList list = (KubernetesResourceList) answer;
        updateApiVersion(list);
      }
      return answer;
    } catch (KubernetesClientException e) {
      if (e.getCode() != 404) {
        throw e;
      }
      return null;
    }
  }

  public T getMandatory() {
    if (item != null && !reloadingFromServer) {
      return item;
    }
    try {
      URL requestUrl = null;
      if (item != null) {
        requestUrl = getNamespacedUrl(item);
      } else {
        requestUrl = getNamespacedUrl();
      }
      if (name != null) {
        requestUrl = new URL(URLUtils.join(requestUrl.toString(), name));
      } else if (item != null && reloadingFromServer) {
        requestUrl = new URL(URLUtils.join(requestUrl.toString(), checkName(item)));
      }
      return handleGet(requestUrl);
    } catch (KubernetesClientException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("get"), e);
      //if (e.getCode() != 404) {
     //   throw e;
      //} else {
      //  String resourceType = type != null ? type.getSimpleName() : "Resource";
      //  String msg = resourceType + " with name: [" + getName() + "]  not found in namespace: [" + (Utils.isNotNullOrEmpty(getNamespace()) ? getName() : getConfig().getNamespace()) + "]";
     //   throw new KubernetesClientException(msg, 404, new StatusBuilder().withCode(404).withMessage(msg).build());
     // }
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("get"), e);
    }
  }

  public RootPaths getRootPaths() {
    try {
      URL requestUrl = new URL(config.getMasterUrl());
      Request.Builder req = new Request.Builder().get().url(requestUrl);
      return handleResponse(req, RootPaths.class);
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
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name must be provided.");
    }
    try {
      return (R) getClass()
        .getConstructor(OkHttpClient.class, getConfigType(), String.class, String.class, String.class, Boolean.class, getType(), String.class, Boolean.class, long.class, Map.class, Map.class, Map.class, Map.class, Map.class)
        .newInstance(client, getConfig(), getAPIVersion(), getNamespace(), name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public Replaceable<T, T> lockResourceVersion(String resourceVersion) {
    try {
      return getClass()
        .getConstructor(OkHttpClient.class, getConfigType(), String.class, String.class, String.class, Boolean.class, getType(), String.class, Boolean.class, long.class, Map.class, Map.class, Map.class, Map.class, Map.class)
        .newInstance(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), resourceVersion, isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public NonNamespaceOperation<T, L, D, R> inNamespace(String namespace) {
    try {
      return getClass()
        .getConstructor(OkHttpClient.class, getConfigType(), String.class, String.class, String.class, Boolean.class, getType(), String.class, Boolean.class, long.class, Map.class, Map.class, Map.class, Map.class, Map.class)
        .newInstance(client, getConfig(), getAPIVersion(), namespace, getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public NonNamespaceOperation<T, L, D, R> inAnyNamespace() {
    return inNamespace(null);
  }


  @Override
  public EditReplacePatchDeletable<T, T, D, Boolean> cascading(boolean cascading) {
    try {
      return getClass()
        .getConstructor(OkHttpClient.class, getConfigType(), String.class, String.class, String.class, Boolean.class, getType(), String.class, Boolean.class, long.class, Map.class, Map.class, Map.class, Map.class, Map.class)
        .newInstance(client, getConfig(), getAPIVersion(), getNamespace(), getName(), cascading, getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public R load(InputStream is) {
    try {
      return (R) getClass()
        .getConstructor(OkHttpClient.class, getConfigType(), String.class, String.class, String.class, Boolean.class, getType(), String.class, Boolean.class, long.class, Map.class, Map.class, Map.class, Map.class, Map.class)
        .newInstance(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), unmarshal(is, type), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public R load(URL url) {
    try (InputStream inputStream = url.openStream()) {
      return load(inputStream);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public R load(File file) {
    try (FileInputStream fis = new FileInputStream(file)) {
      return load(fis);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public R load(String path) {
    return load(new File(path));
  }

  @Override
  public Gettable<T> fromServer() {
    try {
      return (R) getClass()
        .getConstructor(OkHttpClient.class, getConfigType(), String.class, String.class, String.class, Boolean.class, getType(), String.class, Boolean.class, long.class, Map.class, Map.class, Map.class, Map.class, Map.class)
        .newInstance(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), true, getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
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
      throw KubernetesClientException.launderThrowable(forOperationType("create"), e);
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
          throw KubernetesClientException.launderThrowable(forOperationType("create"), e);
        }
      }
    };

    try {
      return getDoneableType().getDeclaredConstructor(Function.class).newInstance(visitor);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("create"), e);
    }
  }


  @Override
  public D createOrReplaceWithNew() throws KubernetesClientException {
    final Function<T, T> visitor = new Function<T, T>() {
      @Override
      public T apply(T resource) {
        try {
          return createOrReplace(resource);
        } catch (Exception e) {
          throw KubernetesClientException.launderThrowable(forOperationType("create or replace"), e);
        }
      }
    };

    try {
      return getDoneableType().getDeclaredConstructor(Function.class).newInstance(visitor);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("create or replace"), e);
    }
  }

  @Override
  public T createOrReplace(T... items) {
    T item = getItem();
    if (items.length > 1) {
      throw new IllegalArgumentException("Too many items to create.");
    } else if (items.length == 1) {
      item = items[0];
    }

    if (item == null) {
      throw new IllegalArgumentException("Nothing to create.");
    }

    if (Utils.isNullOrEmpty(name) && item instanceof HasMetadata) {
      return withName(((HasMetadata)item).getMetadata().getName()).createOrReplace(item);
    }
    if (fromServer().get() == null) {
      return create(item);
    } else {
      return replace(item);
    }
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withLabels(Map<String, String> labels) {
    this.labels.putAll(labels);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withLabelSelector(LabelSelector selector) {
    Map<String, String> matchLabels = selector.getMatchLabels();
    if (matchLabels != null) {
      this.labels.putAll(matchLabels);
    }
    List<LabelSelectorRequirement> matchExpressions = selector.getMatchExpressions();
    if (matchExpressions != null) {
      for (LabelSelectorRequirement req : matchExpressions) {
        String operator = req.getOperator();
        String key = req.getKey();
        switch (operator) {
          case "In":
            withLabelIn(key, req.getValues().toArray(new String[]{}));
            break;
          case "NotIn":
            withLabelNotIn(key, req.getValues().toArray(new String[]{}));
            break;
          case "DoesNotExist":
            withoutLabel(key);
            break;
          case "Exists":
            withLabel(key);
            break;
          default:
            throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
      }
    }
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
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withLabel(String key) {
    return withLabel(key, null);
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withoutLabel(String key, String value) {
    labelsNot.put(key, value);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withoutLabel(String key) {
    return withoutLabel(key, null);
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
        if (entry.getValue() != null) {
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        } else {
            sb.append(entry.getKey());
        }
      }
    }

    if (labelsNot != null && !labelsNot.isEmpty()) {
      for (Iterator<Map.Entry<String, String>> iter = labelsNot.entrySet().iterator(); iter.hasNext(); ) {
        if (sb.length() > 0) {
          sb.append(",");
        }
        Map.Entry<String, String> entry = iter.next();
        if (entry.getValue() != null) {
            sb.append(entry.getKey()).append("!=").append(entry.getValue());
        } else {
            sb.append('!').append(entry.getKey());
        }
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
      for (Iterator<Map.Entry<String, String>> iter = fields.entrySet().iterator(); iter.hasNext(); ) {
        if (sb.length() > 0) {
          sb.append(",");
        }
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
      if (isNotNullOrEmpty(labelQueryParam)) {
        requestUrlBuilder.addQueryParameter("labelSelector", labelQueryParam);
      }

      String fieldQueryString = getFieldQueryParam();
      if (isNotNullOrEmpty(fieldQueryString)) {
        requestUrlBuilder.addQueryParameter("fieldSelector", fieldQueryString);
      }

      Request.Builder requestBuilder = new Request.Builder().get().url(requestUrlBuilder.build());
      L answer = handleResponse(requestBuilder, listType);
      updateApiVersion(answer);
      return answer;
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("list"), e);
    }
  }

  @Override
  public Boolean delete() {
    if (item != null || (name != null && !name.isEmpty())) {
      try {
        if (cascading && !isReaping()) {
          if (reaper != null) {
            setReaping(true);
            //If the reaper also removes the target resource, we can return asap.
            if (reaper.reap()) {
              return true;
            }
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
    boolean deleted = true;
    if (items != null) {
      for (T item : items) {
        updateApiVersionResource(item);

        try {
          R op = (R) getClass()
            .getConstructor(OkHttpClient.class, getConfigType(), String.class, String.class, String.class, Boolean.class, getType(), String.class, Boolean.class, long.class, Map.class, Map.class, Map.class, Map.class, Map.class)
            .newInstance(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), item, getResourceVersion(), true, getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
          deleted &= op.delete();
        } catch (KubernetesClientException e) {
          if (e.getCode() != 404) {
            throw e;
          }
          return false;
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
          throw KubernetesClientException.launderThrowable(forOperationType("delete"), e);
        }
      }
    }
    return deleted;
  }

  void deleteThis() throws KubernetesClientException {
    try {
      if (item != null) {
        updateApiVersionResource(item);
        handleDelete(item, gracePeriodSeconds, cascading);
      } else {
        handleDelete(getResourceUrl(), gracePeriodSeconds, cascading);
      }
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(forOperationType("delete"), e);
    }
  }

  void deleteList() throws KubernetesClientException {
    delete(list().getItems());
  }

  @Override
  public Watchable<Watch, Watcher<T>> withResourceVersion(String resourceVersion) {
    try {
      return getClass()
        .getConstructor(OkHttpClient.class, getConfigType(), String.class, String.class, String.class, Boolean.class, getType(), String.class, Boolean.class, long.class, Map.class, Map.class, Map.class, Map.class, Map.class)
        .newInstance(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), resourceVersion, isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  public Watch watch(final Watcher<T> watcher) throws KubernetesClientException {
    return watch(resourceVersion, watcher);
  }

  public Watch watch(String resourceVersion, final Watcher<T> watcher) throws KubernetesClientException {
    try {
      WatchConnectionManager watch = new WatchConnectionManager(
        client,
        this,
        resourceVersion,
        watcher,
        config.getWatchReconnectInterval(),
        config.getWatchReconnectLimit(),
        config.getWebsocketTimeout()
      );
      watch.waitUntilReady();
      return watch;
    } catch (MalformedURLException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("watch"), e);
    } catch (KubernetesClientException ke) {
      if (ke.getCode() != 200) {
        throw ke;
      }

      // If the HTTP return code is 200, we retry the watch again using a persistent hanging
      // HTTP GET. This is meant to handle cases like kubectl local proxy which does not support
      // websockets. Issue: https://github.com/kubernetes/kubernetes/issues/25126
      try {
        return new WatchHTTPManager(
          client,
          this,
          resourceVersion,
          watcher,
          config.getWatchReconnectInterval(),
          config.getWatchReconnectLimit(),
          config.getConnectionTimeout()
        );
      } catch (MalformedURLException e) {
        throw KubernetesClientException.launderThrowable(forOperationType("watch"), e);
      }
    }
  }

  @Override
  public T replace(T item) {
    throw new KubernetesClientException("Cannot update read-only resources");
  }

  @Override
  public T patch(T item) {
    throw new KubernetesClientException("Cannot update read-only resources");
  }

  public boolean isResourceNamespaced() {
    return true;
  }

  protected T handleResponse(Request.Builder requestBuilder) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    return handleResponse(requestBuilder, getType());
  }

  protected T handleCreate(T resource) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    updateApiVersionResource(resource);
    return handleCreate(resource, getType());
  }

  protected T handleReplace(T updated) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    updateApiVersionResource(updated);
    return handleReplace(updated, getType());
  }

  protected T handlePatch(T current, T updated) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    updateApiVersionResource(updated);
    return handlePatch(current, updated, getType());
  }

  protected T handleGet(URL resourceUrl) throws InterruptedException, ExecutionException, IOException {
    T answer = handleGet(resourceUrl, getType());
    updateApiVersionResource(answer);
    return answer;
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

  @Deprecated
  public Boolean getReloadingFromServer() {
    return isReloadingFromServer();
  }

  public Boolean isReloadingFromServer() {
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

  protected Map<String, String> getLabels() {
    return labels;
  }

  protected Map<String, String> getLabelsNot() {
    return labelsNot;
  }

  protected Map<String, String[]> getLabelsIn() {
    return labelsIn;
  }

  protected Map<String, String[]> getLabelsNotIn() {
    return labelsNotIn;
  }

  protected Map<String, String> getFields() {
    return fields;
  }

  @Override
  public String getKind() {
    return type != null ? type.getSimpleName() : "Resource";
  }

  @Override
  public String getOperationType() {
    return null;
  }

  @Override
  public OperationInfo forOperationType(String type) {
    return new DefaultOperationInfo(getKind(), type, name, namespace);
  }

  @Override
  public Deletable<Boolean> withGracePeriod(long gracePeriodSeconds)
  {
    try {
      return getClass()
        .getConstructor(OkHttpClient.class, getConfigType(), String.class, String.class, String.class, Boolean.class, getType(), String.class, Boolean.class, long.class, Map.class, Map.class, Map.class, Map.class, Map.class)
        .newInstance(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), gracePeriodSeconds, getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  protected Class<? extends Config> getConfigType() {
    return Config.class;
  }

  /**
   * Updates the list or single item if it has a missing or incorrect apiVersion
   */
  protected void updateApiVersionResource(Object resource) {
    if (resource instanceof HasMetadata) {
      HasMetadata hasMetadata = (HasMetadata) resource;
      updateApiVersion(hasMetadata);
    } else if (resource instanceof KubernetesResourceList) {
      KubernetesResourceList list = (KubernetesResourceList) resource;
      updateApiVersion(list);
    }
  }

  /**
   * Updates the list items if they have missing or default apiVersion values and the resource is currently
   * using API Groups with custom version strings
   */
  protected void updateApiVersion(KubernetesResourceList list) {
    String version = getApiGroupVersion();
    if (list != null && version != null && version.length() > 0) {
      List items = list.getItems();
      if (items != null) {
        for (Object item : items) {
          if (item instanceof HasMetadata) {
            updateApiVersion((HasMetadata) item);
          }
        }
      }
    }
  }


  /**
   * Updates the resource if it has missing or default apiVersion values and the resource is currently
   * using API Groups with custom version strings
   */
  protected void updateApiVersion(HasMetadata hasMetadata) {
    String version = getApiGroupVersion();
    if (hasMetadata != null && version != null && version.length() > 0) {
      String current = hasMetadata.getApiVersion();
      // lets overwrite the api version if its currently missing, the resource uses an API Group with '/'
      // or we have the default of 'v1' when using an API group version like 'build.openshift.io/v1'
      if (current == null || "v1".equals(current) || current.indexOf('/') < 0 && version.indexOf('/') > 0) {
        hasMetadata.setApiVersion(version);
      }
    }
  }

  public String getApiGroupVersion() {
    return apiGroupVersion;
  }

  /**
   * Return true if this is an API Group where the versions include a slash in them
   */
  public boolean isApiGroup() {
    return apiGroupVersion != null && apiGroupVersion.indexOf('/') > 0;
  }

  @Override
  public Boolean isReady() {
    T i = get();
    return i instanceof HasMetadata && Readiness.isReady((HasMetadata)i);
  }

  @Override
  public T waitUntilReady(long amount, TimeUnit timeUnit) throws InterruptedException {
    return get();
  }
}
