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

import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorRequirement;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.autoscaling.v1.Scale;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollback;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.OperationInfo;
import io.fabric8.kubernetes.client.ResourceNotFoundException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.EditReplacePatchDeletable;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Replaceable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.Watchable;
import io.fabric8.kubernetes.client.dsl.internal.DefaultOperationInfo;
import io.fabric8.kubernetes.client.dsl.internal.WatchConnectionManager;
import io.fabric8.kubernetes.client.dsl.internal.WatchHTTPManager;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.client.utils.WatcherToggle;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import okhttp3.HttpUrl;
import okhttp3.Request;

public class BaseOperation<T, L extends KubernetesResourceList, D extends Doneable<T>, R extends Resource<T, D>>
  extends OperationSupport
  implements
  OperationInfo,
  MixedOperation<T, L, D, R>,
  Resource<T,D> {

  private final Boolean cascading;
  private final T item;

  private final Map<String, String> labels;
  private final Map<String, String[]> labelsNot;
  private final Map<String, String[]> labelsIn;
  private final Map<String, String[]> labelsNotIn;
  private final Map<String, String> fields;
  // Use a multi-value map as its possible to define keyA != foo && keyA != bar
  private final Map<String, String[]> fieldsNot;

  private final String resourceVersion;
  private final Boolean reloadingFromServer;
  private final long gracePeriodSeconds;
  private final String propagationPolicy;

  protected String apiVersion;

  protected Class<T> type;
  protected Class<L> listType;
  protected Class<D> doneableType;

  protected BaseOperation(OperationContext ctx) {
    super(ctx);
    this.cascading = ctx.getCascading();
    this.item = (T) ctx.getItem();
    this.reloadingFromServer = ctx.getReloadingFromServer();
    this.resourceVersion = ctx.getResourceVersion();
    this.gracePeriodSeconds = ctx.getGracePeriodSeconds();
    this.propagationPolicy = ctx.getPropagationPolicy();
    this.labels = ctx.getLabels();
    this.labelsNot = ctx.getLabelsNot();
    this.labelsIn = ctx.getLabelsIn();
    this.labelsNotIn = ctx.getLabelsNotIn();
    this.fields = ctx.getFields();
    this.fieldsNot = ctx.getFieldsNot();
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


  public BaseOperation<T,L,D,R> newInstance(OperationContext context) {
    return new BaseOperation<T, L, D, R>(context);
  }

  /**
   * Helper method for list() and list(limit, continue) methods
   *
   * @param url
   * @return list of corresponding Kubernetes Resources
   */
  private L listRequestHelper(URL url) {
    try {
      HttpUrl.Builder requestUrlBuilder = HttpUrl.get(url).newBuilder();

      addQueryStringParam(requestUrlBuilder, "labelSelector", getLabelQueryParam());
      addQueryStringParam(requestUrlBuilder, "fieldSelector", getFieldQueryParam());

      Request.Builder requestBuilder = new Request.Builder().get().url(requestUrlBuilder.build());
      L answer = handleResponse(requestBuilder, listType);
      updateApiVersion(answer);
      return answer;
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("list"), e);
    }
  }

  private void addQueryStringParam(HttpUrl.Builder requestUrlBuilder, String name, String value) {
    if(Utils.isNotNullOrEmpty(value)) {
      requestUrlBuilder.addQueryParameter(name, value);
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
      if (e.getCode() != HttpURLConnection.HTTP_NOT_FOUND) {
        throw e;
      }
      return null;
    }
  }

  @Override
  public T require() throws ResourceNotFoundException {
    try {
      T answer = getMandatory();
      if (answer == null) {
        throw new ResourceNotFoundException("The resource you request doesn't exist or couldn't be fetched.");
      }
      if (answer instanceof HasMetadata) {
        HasMetadata hasMetadata = (HasMetadata) answer;
        updateApiVersion(hasMetadata);
      } else if (answer instanceof KubernetesResourceList) {
        KubernetesResourceList list = (KubernetesResourceList) answer;
        updateApiVersion(list);
      }
      return answer;
    } catch (KubernetesClientException e) {
      if (e.getCode() != HttpURLConnection.HTTP_NOT_FOUND) {
        throw e;
      }
      throw new ResourceNotFoundException("Resource not found : " + e.getMessage());
    }
  }

  public T getMandatory() {
    if (item != null && !reloadingFromServer) {
      return item;
    }
    try {
      URL requestUrl = getCompleteResourceUrl();
      return handleGet(requestUrl);
    } catch (KubernetesClientException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("get"), e);
      //if (e.getCode() != HttpURLConnection.HTTP_NOT_FOUND) {
     //   throw e;
      //} else {
      //  String resourceType = type != null ? type.getSimpleName() : "Resource";
      //  String msg = resourceType + " with name: [" + getName() + "]  not found in namespace: [" + (Utils.isNotNullOrEmpty(getNamespace()) ? getName() : getConfig().getNamespace()) + "]";
     //   throw new KubernetesClientException(msg, HttpURLConnection.HTTP_NOT_FOUND, new StatusBuilder().withCode(HttpURLConnection.HTTP_NOT_FOUND).withMessage(msg).build());
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
      if (e.getCode() != HttpURLConnection.HTTP_NOT_FOUND) {
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
    return (R) newInstance(context.withName(name));
  }

  @Override
  public Replaceable<T, T> lockResourceVersion(String resourceVersion) {
    return newInstance(context.withResourceVersion(resourceVersion));
  }

  @Override
  public NonNamespaceOperation<T, L, D, R> inNamespace(String namespace) {
    return newInstance(context.withNamespace(namespace));
  }

  @Override
  public NonNamespaceOperation<T, L, D, R> inAnyNamespace() {
    Config updated = new ConfigBuilder(config).withNamespace(null).build();
    return newInstance(context.withConfig(updated).withNamespace(null));
  }


  @Override
  public EditReplacePatchDeletable<T, T, D, Boolean> cascading(boolean cascading) {
    return newInstance(context.withCascading(cascading));
  }

  @Override
  public R load(InputStream is) {
    return (R) newInstance(context.withItem(unmarshal(is, type)));
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
    return newInstance(context.withReloadingFromServer(true));
  }

  @Override
  public T create(T... resources) throws KubernetesClientException {
    try {
      if (resources.length > 1) {
        throw new IllegalArgumentException("Too many items to create.");
      } else if (resources.length == 1) {
        return withItem(resources[0]).create();
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
  public T create(T resource) {
    try {
      if (resource != null) {
        return handleCreate(resource);
      } else {
        throw new IllegalArgumentException("Nothing to create.");
      }
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("create"), e);
    }
  }

  @Override
  public D createNew() throws KubernetesClientException {
    final Function<T, T> visitor = resource -> {
      try {
        return create(resource);
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(forOperationType("create"), e);
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
    final Function<T, T> visitor = resource -> {
      try {
        return createOrReplace(resource);
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(forOperationType("create or replace"), e);
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

  // Deprecated as the underlying implementation does not align with the arguments anymore.
  // It is possible to negate multiple values with the same key, e.g.:
  // foo != bar , foo != baz
  // To support this a multi-value map is needed, as a regular map would override the key with the new value.
  @Override
  @Deprecated
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withoutLabels(Map<String, String> labels) throws
    KubernetesClientException {
    // Re-use "withoutLabel" to convert values from String to String[]
    labels.forEach(this::withoutLabel);
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
    labelsNot.merge(key, new String[]{value}, (oldList, newList) -> {
      final String[] concatList = (String[]) Array.newInstance(String.class, oldList.length + newList.length);
      System.arraycopy(oldList, 0, concatList, 0, oldList.length);
      System.arraycopy(newList, 0, concatList, oldList.length, newList.length);
      return concatList;
    });
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withoutLabel(String key) {
    return withoutLabel(key, null);
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withFields(Map<String, String> fields) {
    this.fields.putAll(fields);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withField(String key, String value) {
    fields.put(key, value);
    return this;
  }

  // Deprecated as the underlying implementation does not align with the arguments fully.
  // Method is created to have a similar API as `withoutLabels`, but should eventually be replaced with something
  // better for the same reasons.
  // It is possible to negate multiple values with the same key, e.g.:
  // foo != bar , foo != baz
  // To support this a multi-value map is needed, as a regular map would override the key with the new value.
  @Override
  @Deprecated
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withoutFields(Map<String, String> fields) throws
    KubernetesClientException {
    // Re-use "withoutField" to convert values from String to String[]
    labels.forEach(this::withoutField);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withoutField(String key, String value) {
    fieldsNot.merge(key, new String[]{value}, (oldList, newList) -> {
      if (Utils.isNotNullOrEmpty(newList[0])) { // Only add new values when not null
        final String[] concatList = (String[]) Array.newInstance(String.class, oldList.length + newList.length);
        System.arraycopy(oldList, 0, concatList, 0, oldList.length);
        System.arraycopy(newList, 0, concatList, oldList.length, newList.length);
        return concatList;
      } else {
        return oldList;
      }
    });
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
      for (Iterator<Map.Entry<String, String[]>> iter = labelsNot.entrySet().iterator(); iter.hasNext(); ) {
        if (sb.length() > 0) {
          sb.append(",");
        }
        Map.Entry<String, String[]> entry = iter.next();
        if (Utils.isNotNull(entry.getValue())) {
          for (int i = 0; i < entry.getValue().length; i++) {
            if (i > 0) {
              sb.append(",");
            }
            sb.append(entry.getKey()).append("!=").append(entry.getValue()[i]);
          }
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
        sb.append(entry.getKey()).append(" in ").append("(").append(Utils.join(entry.getValue())).append(")");
      }
    }

    if (labelsNotIn != null && !labelsNotIn.isEmpty()) {
      for (Iterator<Map.Entry<String, String[]>> iter = labelsNotIn.entrySet().iterator(); iter.hasNext(); ) {
        if (sb.length() > 0) {
          sb.append(",");
        }
        Map.Entry<String, String[]> entry = iter.next();
        sb.append(entry.getKey()).append(" notin ").append("(").append(Utils.join(entry.getValue())).append(")");
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
    if (fieldsNot != null && !fieldsNot.isEmpty()) {
      for (Iterator<Map.Entry<String, String[]>> iter = fieldsNot.entrySet().iterator(); iter.hasNext(); ) {
        if (sb.length() > 0) {
          sb.append(",");
        }
        Map.Entry<String, String[]> entry = iter.next();
        for (int i = 0; i < entry.getValue().length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(entry.getKey()).append("!=").append(entry.getValue()[i]);
        }
      }
    }
    return sb.toString();
  }

  public L list() throws KubernetesClientException {
    try {
      return listRequestHelper(getNamespacedUrl());
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("list"), e);
    }
  }

  public L list(Integer limitVal, String continueVal) throws KubernetesClientException {
    try {
      URL url = getNamespacedUrl();
      if(limitVal != null && continueVal == null) {
        url = new URL(URLUtils.join(url.toString(), "?limit=" + limitVal.toString()));
      } else if(continueVal != null) {
        url = new URL(URLUtils.join(url.toString(), "?continue=" + continueVal + "&limit=" + limitVal.toString() ));
      }
      return listRequestHelper(url);
    } catch (MalformedURLException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("list"), e);
    }
  }

  @Override
  public Boolean delete() {
    if (item != null || (name != null && !name.isEmpty())) {
      try {
        deleteThis();
        return true;
      } catch (KubernetesClientException e) {
        if (e.getCode() != HttpURLConnection.HTTP_NOT_FOUND) {
          throw e;
        }
        return false;
      }
    } else {
      try {
        deleteList();
        return true;
      } catch (KubernetesClientException e) {
        if (e.getCode() != HttpURLConnection.HTTP_NOT_FOUND) {
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
          R op;

          if (item instanceof HasMetadata
            && ((HasMetadata) item).getMetadata() != null
            && ((HasMetadata) item).getMetadata().getName() != null
            && !((HasMetadata) item).getMetadata().getName().isEmpty())  {
            op = (R) inNamespace(checkNamespace(item)).withName(((HasMetadata) item).getMetadata().getName());
          } else {
            op = (R) withItem(item);
          }

          deleted &= op.delete();
        } catch (KubernetesClientException e) {
          if (e.getCode() != HttpURLConnection.HTTP_NOT_FOUND) {
            throw e;
          }
          return false;
        }
      }
    }
    return deleted;
  }

  @Override
  public T updateStatus(T item) throws KubernetesClientException {
    try {
      return handleStatusUpdate(item, getType());
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("statusUpdate"), e);
    }
  }

  public BaseOperation<T,L,D,R> withItem(T item) {
    return newInstance(context.withItem(item));
  }

  void deleteThis() throws KubernetesClientException {
    try {
      if (item != null) {
        updateApiVersionResource(item);
        handleDelete(item, gracePeriodSeconds, propagationPolicy, cascading);
      } else {
        handleDelete(getResourceUrl(), gracePeriodSeconds, propagationPolicy, cascading);
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
    return newInstance(context.withResourceVersion(resourceVersion));
  }

  public Watch watch(final Watcher<T> watcher) throws KubernetesClientException {
    return watch(resourceVersion, watcher);
  }

  public Watch watch(String resourceVersion, final Watcher<T> watcher) throws KubernetesClientException {
    WatcherToggle<T> watcherToggle = new WatcherToggle<>(watcher, true);
    WatchConnectionManager watch = null;
    try {
      watch = new WatchConnectionManager(
        client,
        this,
        resourceVersion,
        watcherToggle,
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
        if(watch != null){
          //release the watch
          watch.close();
        }

        throw ke;
      }

      if(watch != null){
        //release the watch after disabling the watcher (to avoid premature call to onClose)
        watcherToggle.disable();
        watch.close();
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

  protected Scale handleScale(Scale scaleParam) {
    try {
      return handleScale(getCompleteResourceUrl().toString(), scaleParam);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("scale"), e);
    }
  }

  protected Status handleDeploymentRollback(DeploymentRollback deploymentRollback) {
    try {
      return handleDeploymentRollback(getCompleteResourceUrl().toString(), deploymentRollback);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("rollback"), e);
    }
  }

  protected T handleGet(URL resourceUrl) throws InterruptedException, ExecutionException, IOException {
    T answer = handleGet(resourceUrl, getType());
    updateApiVersionResource(answer);
    return answer;
  }

  private URL getCompleteResourceUrl() throws MalformedURLException {
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
    return requestUrl;
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

  public String getPropagationPolicy() {
    return propagationPolicy;
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

  protected Map<String, String> getLabels() {
    return labels;
  }

  protected Map<String, String[]> getLabelsNot() {
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

  protected Map<String, String[]> getFieldsNot() {
    return fieldsNot;
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
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withGracePeriod(long gracePeriodSeconds)
  {
    return newInstance(context.withGracePeriodSeconds(gracePeriodSeconds));
  }

  @Override
  public FilterWatchListDeletable<T, L, Boolean, Watch, Watcher<T>> withPropagationPolicy(String propagationPolicy)
  {
    return newInstance(context.withPropagationPolicy(propagationPolicy));
  }

  protected Class<? extends Config> getConfigType() {
    return Config.class;
  }

  /**
   * Updates the list or single item if it has a missing or incorrect apiGroupVersion
   *
   * @param resource resource object
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
   * Updates the list items if they have missing or default apiGroupVersion values and the resource is currently
   * using API Groups with custom version strings
   *
   * @param list Kubernetes resource list
   */
  protected void updateApiVersion(KubernetesResourceList list) {
    String version = getApiVersion();
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
   * Updates the resource if it has missing or default apiGroupVersion values and the resource is currently
   * using API Groups with custom version strings
   *
   * @param hasMetadata object whose api version needs to be updated
   */
  protected void updateApiVersion(HasMetadata hasMetadata) {
    String version = getApiVersion();
    if (hasMetadata != null && version != null && version.length() > 0) {
      String current = hasMetadata.getApiVersion();
      // lets overwrite the api version if its currently missing, the resource uses an API Group with '/'
      // or we have the default of 'v1' when using an API group version like 'build.openshift.io/v1'
      if (current == null || "v1".equals(current) || current.indexOf('/') < 0 && version.indexOf('/') > 0) {
        hasMetadata.setApiVersion(version);
      }
    }
  }

  public String getApiVersion() {
    return apiVersion;
  }

  /**
   * Return true if this is an API Group where the versions include a slash in them
   *
   * @return boolean value indicating whether API group or not
   */
  public boolean isApiGroup() {
    return apiVersion != null && apiVersion.indexOf('/') > 0;
  }

  @Override
  public Boolean isReady() {
    T i = get();
    return i instanceof HasMetadata && Readiness.isReady((HasMetadata)i);
  }

  protected T waitUntilExists(long amount, TimeUnit timeUnit) throws InterruptedException {
    return waitUntilCondition(Objects::nonNull, amount, timeUnit);
  }

  @Override
  public T waitUntilReady(long amount, TimeUnit timeUnit) throws InterruptedException {

    long timeoutInNanos = timeUnit.toNanos(amount);
    long end = System.nanoTime() + timeoutInNanos;

    while (System.nanoTime() < end) {
      T item = fromServer().get();
      try {
        if (Readiness.isReady((HasMetadata) item)) {
          return item;
        }

        Thread.sleep(500);
      } catch (IllegalArgumentException illegalArgumentException) {
        // This might be thrown if Resource passed doesn't comply with concept of "readiness"
        throw illegalArgumentException;
      }
    }

    T item = fromServer().get();
    if (Readiness.isReady((HasMetadata) item)) {
      return item;
    }

    throw new IllegalStateException(type.getSimpleName() + " with name:[" + name + "] in namespace:[" + namespace + "] not ready!");
  }

  @Override
  public T waitUntilCondition(Predicate<T> condition, long amount, TimeUnit timeUnit)
    throws InterruptedException {

    long timeoutInMillis = timeUnit.toNanos(amount);

    long end = System.nanoTime() + timeoutInMillis;
    while (System.nanoTime() < end) {
      T item = get();
      if (condition.test(item)) {
        return item;
      }

      // in the future, this should probably be more intelligent
      Thread.sleep(500);
    }

    T item = get();
    if (condition.test(item)) {
      return item;
    }

    throw new IllegalArgumentException(type.getSimpleName() + " with name:[" + name + "] in namespace:[" + namespace + "] not found!");
  }

  public void setType(Class<T> type) {
    this.type = type;
  }

  public void setListType(Class<L> listType) {
    this.listType = listType;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }
}
