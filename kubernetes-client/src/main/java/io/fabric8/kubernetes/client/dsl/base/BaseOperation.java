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

import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.WritableOperation;
import io.fabric8.kubernetes.client.utils.CreateOrReplaceHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorRequirement;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
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
import io.fabric8.kubernetes.client.dsl.internal.DefaultOperationInfo;
import io.fabric8.kubernetes.client.dsl.internal.WatchConnectionManager;
import io.fabric8.kubernetes.client.dsl.internal.WatchHTTPManager;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.client.utils.WatcherToggle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
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
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import okhttp3.HttpUrl;
import okhttp3.Request;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class BaseOperation<T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>>
  extends OperationSupport
  implements
  OperationInfo,
  MixedOperation<T, L, R>,
  Resource<T> {

  private static final Logger LOG = LoggerFactory.getLogger(BaseOperation.class);
  private static final String INVOLVED_OBJECT_NAME = "involvedObject.name";
  private static final String INVOLVED_OBJECT_NAMESPACE = "involvedObject.namespace";
  private static final String INVOLVED_OBJECT_KIND = "involvedObject.kind";
  private static final String INVOLVED_OBJECT_UID = "involvedObject.uid";
  private static final String INVOLVED_OBJECT_RESOURCE_VERSION = "involvedObject.resourceVersion";
  private static final String INVOLVED_OBJECT_API_VERSION = "involvedObject.apiVersion";
  private static final String INVOLVED_OBJECT_FIELD_PATH = "involvedObject.fieldPath";
  private static final String READ_ONLY_UPDATE_EXCEPTION_MESSAGE = "Cannot update read-only resources";
  private static final String READ_ONLY_EDIT_EXCEPTION_MESSAGE = "Cannot edit read-only resources";

  private final boolean cascading;
  private final T item;

  private final Map<String, String> labels;
  private final Map<String, String[]> labelsNot;
  private final Map<String, String[]> labelsIn;
  private final Map<String, String[]> labelsNotIn;
  private final Map<String, String> fields;
  // Use a multi-value map as its possible to define keyA != foo && keyA != bar
  private final Map<String, String[]> fieldsNot;

  private final String resourceVersion;
  private final boolean reloadingFromServer;
  private final long gracePeriodSeconds;
  private final DeletionPropagation propagationPolicy;
  private final long watchRetryInitialBackoffMillis;
  private final double watchRetryBackoffMultiplier;

  protected String apiVersion;

  protected Class<T> type;
  protected Class<L> listType;

  protected BaseOperation(OperationContext ctx) {
    super(ctx);
    this.cascading = ctx.getCascading();
    this.item = (T) ctx.getItem();
    this.reloadingFromServer = ctx.isReloadingFromServer();
    this.resourceVersion = ctx.getResourceVersion();
    this.gracePeriodSeconds = ctx.getGracePeriodSeconds();
    this.propagationPolicy = ctx.getPropagationPolicy();
    this.labels = ctx.getLabels();
    this.labelsNot = ctx.getLabelsNot();
    this.labelsIn = ctx.getLabelsIn();
    this.labelsNotIn = ctx.getLabelsNotIn();
    this.fields = ctx.getFields();
    this.fieldsNot = ctx.getFieldsNot();
    this.watchRetryInitialBackoffMillis = ctx.getWatchRetryInitialBackoffMillis();
    this.watchRetryBackoffMultiplier = ctx.getWatchRetryBackoffMultiplier();
  }

  public BaseOperation<T, L, R> newInstance(OperationContext context) {
    return new BaseOperation<>(context);
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
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(forOperationType("list"), ie);
    } catch (ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("list"), e);
    }
 }

  protected URL fetchListUrl(URL url, ListOptions listOptions) throws MalformedURLException {
    return new URL(HttpClientUtils.appendListOptionParams(HttpUrl.get(url.toString()).newBuilder(), listOptions).toString());
  }

  private void addQueryStringParam(HttpUrl.Builder requestUrlBuilder, String name, String value) {
    if (Utils.isNotNullOrEmpty(value)) {
      requestUrlBuilder.addQueryParameter(name, value);
    }
  }

  @Override
  public T get() {
    try {
      final T answer = getMandatory();
      updateApiVersion(answer);
      return answer;
    } catch (KubernetesClientException e) {
      if (e.getCode() != HttpURLConnection.HTTP_NOT_FOUND) {
        throw e;
      }
      return null;
    }
  }

  @Override
  public T require() {
    T answer = getMandatory();
    if (answer == null) {
      throw new ResourceNotFoundException("The resource you request doesn't exist or couldn't be fetched.");
    }
    return answer;
  }

  public T getMandatory() {
    if (item != null && !reloadingFromServer) {
      return item;
    }
    try {
      URL requestUrl = getCompleteResourceUrl();
      return handleGet(requestUrl);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(forOperationType("get"), ie);
    } catch (ExecutionException | IOException e) {
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
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(ie);
    } catch (ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
 }

  @Override
  public T edit(UnaryOperator<T> function) {
    throw new KubernetesClientException(READ_ONLY_EDIT_EXCEPTION_MESSAGE);
  }
  
  @Override
  public T editStatus(UnaryOperator<T> function) {
    throw new KubernetesClientException(READ_ONLY_EDIT_EXCEPTION_MESSAGE);
  }

  @Override
  public T edit(Visitor... visitors) {
    throw new KubernetesClientException(READ_ONLY_EDIT_EXCEPTION_MESSAGE);
  }

  @Override
  public <V> T edit(final Class<V> visitorType, final Visitor<V> visitor) {
    return edit(new TypedVisitor<V>() {
        @Override
        public Class<V> getType() {
          return visitorType;
        }
        @Override
        public void visit(V item) {
          visitor.visit(item);
        }
    });
  }


  @Override
  public T accept(Consumer<T> consumer) {
    throw new KubernetesClientException(READ_ONLY_EDIT_EXCEPTION_MESSAGE);
  }

  @Override
  public R withName(String name) {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name must be provided.");
    }
    return (R) newInstance(context.withName(name));
  }

  @Override
  public Replaceable<T> lockResourceVersion(String resourceVersion) {
    return newInstance(context.withResourceVersion(resourceVersion));
  }

  @Override
  public NonNamespaceOperation<T, L, R> inNamespace(String namespace) {
    return newInstance(context.withNamespace(namespace));
  }

  @Override
  public NonNamespaceOperation<T, L, R> inAnyNamespace() {
    Config updated = new ConfigBuilder(config).withNamespace(null).build();
    return newInstance(context.withConfig(updated).withNamespace(null));
  }


  @Override
  public EditReplacePatchDeletable<T> cascading(boolean cascading) {
    return newInstance(context.withCascading(cascading).withPropagationPolicy(null));
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

  @SafeVarargs
  @Override
  public final T create(T... resources) {
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
    }  catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(forOperationType("create"), ie);
    } catch (ExecutionException | IOException e) {
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
    }  catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(forOperationType("create"), ie);
    } catch (ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("create"), e);
    }

  }

  @SafeVarargs
  @Override
  public final T createOrReplace(T... items) {
    T itemToCreateOrReplace = getItem();
    if (items.length > 1) {
      throw new IllegalArgumentException("Too many items to create.");
    } else if (items.length == 1) {
      itemToCreateOrReplace = items[0];
    }

    if (itemToCreateOrReplace == null) {
      throw new IllegalArgumentException("Nothing to create.");
    }

    if (Utils.isNullOrEmpty(name)) {

      return withName(itemToCreateOrReplace.getMetadata().getName()).createOrReplace(itemToCreateOrReplace);
    }
    T finalItemToCreateOrReplace = itemToCreateOrReplace;
    CreateOrReplaceHelper<T> createOrReplaceHelper = new CreateOrReplaceHelper<>(
      this::create,
      this::replace,
      m -> {
        try {
          return waitUntilCondition(Objects::nonNull, 1, TimeUnit.SECONDS);
        } catch (InterruptedException interruptedException) {
          LOG.warn("Interrupted while waiting for the resource to be created or replaced. Gracefully assuming the resource has not been created and doesn't exist. ({})", interruptedException.getMessage());
          Thread.currentThread().interrupt();
        }
        return null;
      },
      m -> fromServer().get()
    );

    return createOrReplaceHelper.createOrReplace(finalItemToCreateOrReplace);
  }

  @Override
  public FilterWatchListDeletable<T, L> withLabels(Map<String, String> labels) {
    this.labels.putAll(labels);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L> withLabelSelector(LabelSelector selector) {
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

  /**
   * @deprecated as the underlying implementation does not align with the arguments anymore.
   *    It is possible to negate multiple values with the same key, e.g.:
   *    foo != bar , foo != baz
   *    To support this a multi-value map is needed, as a regular map would override the key with the new value.
   */
  @Override
  @Deprecated
  public FilterWatchListDeletable<T, L> withoutLabels(Map<String, String> labels) {
    // Re-use "withoutLabel" to convert values from String to String[]
    labels.forEach(this::withoutLabel);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L> withLabelIn(String key, String... values) {
    labelsIn.put(key, values);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L> withLabelNotIn(String key, String... values) {
    labelsNotIn.put(key, values);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L> withLabel(String key, String value) {
    labels.put(key, value);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L> withLabel(String key) {
    return withLabel(key, null);
  }

  @Override
  public FilterWatchListDeletable<T, L> withoutLabel(String key, String value) {
    labelsNot.merge(key, new String[]{value}, (oldList, newList) -> {
      final String[] concatList = (String[]) Array.newInstance(String.class, oldList.length + newList.length);
      System.arraycopy(oldList, 0, concatList, 0, oldList.length);
      System.arraycopy(newList, 0, concatList, oldList.length, newList.length);
      return concatList;
    });
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L> withoutLabel(String key) {
    return withoutLabel(key, null);
  }

  @Override
  public FilterWatchListDeletable<T, L> withFields(Map<String, String> fields) {
    this.fields.putAll(fields);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L> withField(String key, String value) {
    fields.put(key, value);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L> withInvolvedObject(ObjectReference objectReference) {
    if (objectReference != null) {
      if (objectReference.getName() != null) {
        fields.put(INVOLVED_OBJECT_NAME, objectReference.getName());
      }
      if (objectReference.getNamespace() != null) {
        fields.put(INVOLVED_OBJECT_NAMESPACE, objectReference.getNamespace());
      }
      if (objectReference.getKind() != null) {
        fields.put(INVOLVED_OBJECT_KIND, objectReference.getKind());
      }
      if (objectReference.getUid() != null) {
        fields.put(INVOLVED_OBJECT_UID, objectReference.getUid());
      }
      if (objectReference.getResourceVersion() != null) {
        fields.put(INVOLVED_OBJECT_RESOURCE_VERSION, objectReference.getResourceVersion());
      }
      if (objectReference.getApiVersion() != null) {
        fields.put(INVOLVED_OBJECT_API_VERSION, objectReference.getApiVersion());
      }
      if (objectReference.getFieldPath() != null) {
        fields.put(INVOLVED_OBJECT_FIELD_PATH, objectReference.getFieldPath());
      }
    }
    return this;
  }


  /**
   * @deprecated as the underlying implementation does not align with the arguments fully.
   *    Method is created to have a similar API as `withoutLabels`, but should eventually be replaced
   *    with something better for the same reasons.
   *    It is possible to negate multiple values with the same key, e.g.:
   *    foo != bar , foo != baz
   *    To support this a multi-value map is needed, as a regular map would override the key with the new value.
   */
  @Override
  @Deprecated
  public FilterWatchListDeletable<T, L> withoutFields(Map<String, String> fields) {
    // Re-use "withoutField" to convert values from String to String[]
    labels.forEach(this::withoutField);
    return this;
  }

  @Override
  public FilterWatchListDeletable<T, L> withoutField(String key, String value) {
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

  public L list() {
    try {
      return listRequestHelper(getResourceUrl(namespace, name));
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("list"), e);
    }
  }

  public L list(Integer limitVal, String continueVal) {
    return list(new ListOptionsBuilder().withLimit(Long.parseLong(limitVal.toString())).withContinue(continueVal).build());
  }

  public L list(ListOptions listOptions) {
    try {
      return listRequestHelper(fetchListUrl(getNamespacedUrl(), listOptions));
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

  @SafeVarargs
  @Override
  public final Boolean delete(T... items) {
    return delete(Arrays.asList(items));
  }

  @Override
  public Boolean delete(List<T> items) {
    boolean deleted = true;
    if (items != null) {
      for (T toDelete : items) {
        if (toDelete == null) {
          continue;
        }
        updateApiVersion(toDelete);

        try {
          if (toDelete.getMetadata() != null
            && toDelete.getMetadata().getName() != null
            && !toDelete.getMetadata().getName().isEmpty()) {
            deleted &= inNamespace(checkNamespace(toDelete)).withName(toDelete.getMetadata().getName()).delete();
          } else {
            deleted &= withItem(toDelete).delete();
          }
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
  public T updateStatus(T item) {
    try {
      return handleUpdate(item, true);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(forOperationType("statusUpdate"), ie);
    } catch (ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("statusUpdate"), e);
    }

  }
  
  @Override
  public T patchStatus(T item) {
    throw new KubernetesClientException(READ_ONLY_UPDATE_EXCEPTION_MESSAGE);
  }

  public BaseOperation<T, L, R> withItem(T item) {
    return newInstance(context.withItem(item));
  }

  void deleteThis() {
    try {
      if (item != null) {
        updateApiVersion(item);
        handleDelete(item, gracePeriodSeconds, propagationPolicy, cascading);
      } else {
        handleDelete(getResourceURLForWriteOperation(getResourceUrl()), gracePeriodSeconds, propagationPolicy, cascading);
      }
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(forOperationType("delete"), e);
    }
  }

  void deleteList() {
    delete(list().getItems());
  }

  @Override
  public R withResourceVersion(String resourceVersion) {
    return (R) newInstance(context.withResourceVersion(resourceVersion));
  }

  public Watch watch(final Watcher<T> watcher) {
    return watch(new ListOptionsBuilder()
      .withResourceVersion(resourceVersion)
      .build(), watcher);
  }

  @Override
  public Watch watch(String resourceVersion, Watcher<T> watcher) {
    return watch(new ListOptionsBuilder()
      .withResourceVersion(resourceVersion)
      .build(), watcher);
  }

  @Override
  public Watch watch(ListOptions options, final Watcher<T> watcher) {
    WatcherToggle<T> watcherToggle = new WatcherToggle<>(watcher, true);
    options.setWatch(Boolean.TRUE);
    WatchConnectionManager<T, L> watch = null;
    try {
      watch = new WatchConnectionManager<>(
        client,
        this,
        options,
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
      List<Integer> furtherProcessedCodes = Arrays.asList(200, 503);
      if (! furtherProcessedCodes.contains(ke.getCode())) {
        if (watch != null) {
          //release the watch
          watch.close();
        }

        throw ke;
      }

      if (watch != null) {
        //release the watch after disabling the watcher (to avoid premature call to onClose)
        watcherToggle.disable();
        watch.close();
      }

      // If the HTTP return code is 200 or 503, we retry the watch again using a persistent hanging
      // HTTP GET. This is meant to handle cases like kubectl local proxy which does not support
      // websockets. Issue: https://github.com/kubernetes/kubernetes/issues/25126
      try {
        return new WatchHTTPManager<>(
          client,
          this,
          options,
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
    throw new KubernetesClientException(READ_ONLY_UPDATE_EXCEPTION_MESSAGE);
  }
  
  @Override
  public T replaceStatus(T item) {
    throw new KubernetesClientException(READ_ONLY_UPDATE_EXCEPTION_MESSAGE);
  }

  @Override
  public T patch(PatchContext patchContext, String patch) {
    throw new KubernetesClientException(READ_ONLY_UPDATE_EXCEPTION_MESSAGE);
  }
  
  @Override
  public T patch(PatchContext patchContext, T item) {
    throw new KubernetesClientException(READ_ONLY_UPDATE_EXCEPTION_MESSAGE);
  }

  @Override
  public boolean isResourceNamespaced() {
    return Utils.isResourceNamespaced(getType());
  }

  protected T handleResponse(Request.Builder requestBuilder) throws ExecutionException, InterruptedException, IOException {
    return handleResponse(requestBuilder, getType());
  }

  protected T handleCreate(T resource) throws ExecutionException, InterruptedException, IOException {
    updateApiVersion(resource);
    return handleCreate(resource, getType());
  }

  protected T handleUpdate(T updated, boolean status) throws ExecutionException, InterruptedException, IOException {
    updateApiVersion(updated);
    return handleUpdate(updated, getType(), status);
  }

  protected T handlePatch(PatchContext context, T current, T updated, boolean status) throws ExecutionException, InterruptedException, IOException {
    updateApiVersion(updated);
    return handlePatch(context, current, updated, getType(), status);
  }

  protected T handlePatch(T current, Map<String, Object> patchedUpdate) throws ExecutionException, InterruptedException, IOException {
    updateApiVersion(current);
    return handlePatch(current, patchedUpdate, getType());
  }

  protected T sendPatchedObject(T oldObject, T updatedObject) {
    try {
      return handlePatch(null, oldObject, updatedObject, false);
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(interruptedException);
    } catch (ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  protected Scale handleScale(Scale scaleParam) {
    try {
      return handleScale(getCompleteResourceUrl().toString(), scaleParam);
    }  catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(forOperationType("scale"), ie);
    } catch (ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("scale"), e);
    }

  }

  protected Status handleDeploymentRollback(DeploymentRollback deploymentRollback) {
    try {
      return handleDeploymentRollback(getCompleteResourceUrl().toString(), deploymentRollback);
    }  catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(forOperationType("rollback"), ie);
    } catch (ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("rollback"), e);
    }

  }

  protected T handleGet(URL resourceUrl) throws InterruptedException, ExecutionException, IOException {
    T answer = handleGet(resourceUrl, getType());
    updateApiVersion(answer);
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

  public Boolean isReloadingFromServer() {
    return reloadingFromServer;
  }

  public Long getGracePeriodSeconds() {
    return gracePeriodSeconds;
  }

  public DeletionPropagation getPropagationPolicy() {
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
  public FilterWatchListDeletable<T, L> withGracePeriod(long gracePeriodSeconds) {
    return newInstance(context.withGracePeriodSeconds(gracePeriodSeconds));
  }

  @Override
  public EditReplacePatchDeletable<T> withPropagationPolicy(DeletionPropagation propagationPolicy) {
    return newInstance(context.withPropagationPolicy(propagationPolicy));
  }

  @Override
  public BaseOperation<T, L, R> withWaitRetryBackoff(long initialBackoff, TimeUnit backoffUnit, double backoffMultiplier) {
    return newInstance(context.withWatchRetryInitialBackoffMillis(backoffUnit.toMillis(initialBackoff)).withWatchRetryBackoffMultiplier(backoffMultiplier));
  }

  protected Class<? extends Config> getConfigType() {
    return Config.class;
  }

  /**
   * Updates the list items if they have missing or default apiGroupVersion values and the resource is currently
   * using API Groups with custom version strings
   *
   * @param list Kubernetes resource list
   */
  protected void updateApiVersion(KubernetesResourceList<T> list) {
    String version = getApiVersion();
    if (list != null && version != null && version.length() > 0 && list.getItems() != null) {
      list.getItems().forEach(this::updateApiVersion);
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

  public Readiness getReadiness() {
    return Readiness.getInstance();
  }

  @Override
  public final Boolean isReady() {
    return getReadiness().isReady(get());
  }

  @Override
  public T waitUntilReady(long amount, TimeUnit timeUnit) throws InterruptedException {
    return waitUntilCondition(resource -> Objects.nonNull(resource) && getReadiness().isReady(resource), amount, timeUnit);
  }

  @Override
  public T waitUntilCondition(Predicate<T> condition, long amount, TimeUnit timeUnit)
    throws InterruptedException {
    return waitUntilConditionWithRetries(condition, timeUnit.toNanos(amount), watchRetryInitialBackoffMillis);
  }

  private T waitUntilConditionWithRetries(Predicate<T> condition, long timeoutNanos, long backoffMillis)
    throws InterruptedException {
    ListOptions options = null;

    if (resourceVersion != null) {
      options = createListOptions(resourceVersion);
    }

    long currentBackOff = backoffMillis;
    long remainingNanosToWait = timeoutNanos;
    while (remainingNanosToWait > 0) {

      T item = fromServer().get();
      if (condition.test(item)) {
        return item;
      } else if (options == null) {
        options = createListOptions(getResourceVersion(item));
      }

      final WaitForConditionWatcher<T> watcher = new WaitForConditionWatcher<>(condition);
      final long startTime = System.nanoTime();
      try (Watch ignored = watch(options, watcher)) {
        return watcher.getFuture().get(remainingNanosToWait, NANOSECONDS);
      } catch (ExecutionException e) {
        Throwable cause = e.getCause();
        if (cause instanceof WatcherException && ((WatcherException) cause).isShouldRetry()) {
          LOG.debug("retryable watch exception encountered, retrying after {} millis", currentBackOff, cause);
          Thread.sleep(currentBackOff);
          currentBackOff *= watchRetryBackoffMultiplier;
          remainingNanosToWait -= (System.nanoTime() - startTime);
        } else {
          throw KubernetesClientException.launderThrowable(cause);
        }
      } catch (TimeoutException e) {
        break;
      }
    }

    LOG.debug("ran out of time waiting for watcher, wait condition not met");
    throw new IllegalArgumentException(type.getSimpleName() + " with name:[" + name + "] in namespace:[" + namespace + "] matching condition not found!");
  }

  private static String getResourceVersion(HasMetadata item) {
    return (item == null) ? null : item.getMetadata().getResourceVersion();
  }

  private static ListOptions createListOptions(String resourceVersion) {
    return new ListOptionsBuilder()
      .withResourceVersion(resourceVersion)
      .build();
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

  @Override
  public WritableOperation<T> dryRun(boolean isDryRun) {
    return newInstance(context.withDryRun(isDryRun));
  }
}

