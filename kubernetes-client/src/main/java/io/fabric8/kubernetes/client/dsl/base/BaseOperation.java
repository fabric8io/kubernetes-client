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

import io.fabric8.kubernetes.api.Pluralize;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.client.dsl.WritableOperation;
import io.fabric8.kubernetes.client.utils.CreateOrReplaceHelper;

import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.autoscaling.v1.Scale;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollback;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.KubernetesClientTimeoutException;
import io.fabric8.kubernetes.client.OperationInfo;
import io.fabric8.kubernetes.client.ResourceNotFoundException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.EditReplacePatchDeletable;
import io.fabric8.kubernetes.client.dsl.FilterNested;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.Informable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ReplaceDeletable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.DefaultOperationInfo;
import io.fabric8.kubernetes.client.dsl.internal.WatchConnectionManager;
import io.fabric8.kubernetes.client.dsl.internal.WatchHTTPManager;
import io.fabric8.kubernetes.client.informers.ListerWatcher;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.impl.DefaultSharedIndexInformer;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.client.utils.WatcherToggle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import okhttp3.HttpUrl;
import okhttp3.Request;

public class BaseOperation<T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>>
  extends CreateOnlyResourceOperation<T, T>
  implements
  OperationInfo,
  MixedOperation<T, L, R>,
  Resource<T>,
  ListerWatcher<T, L> {

  private static final String READ_ONLY_UPDATE_EXCEPTION_MESSAGE = "Cannot update read-only resources";
  private static final String READ_ONLY_EDIT_EXCEPTION_MESSAGE = "Cannot edit read-only resources";

  private final boolean cascading;
  private final T item;

  private final String resourceVersion;
  private final boolean reloadingFromServer;
  private final long gracePeriodSeconds;
  private final DeletionPropagation propagationPolicy;

  protected String apiVersion;

  protected Class<L> listType;
  private Map<String, Function<T, List<String>>> indexers;

  protected BaseOperation(OperationContext ctx) {
    super(ctx);
    this.cascading = ctx.getCascading();
    this.item = (T) ctx.getItem();
    this.reloadingFromServer = ctx.isReloadingFromServer();
    this.resourceVersion = ctx.getResourceVersion();
    this.gracePeriodSeconds = ctx.getGracePeriodSeconds();
    this.propagationPolicy = ctx.getPropagationPolicy();
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
    try {
      T answer = getMandatory();
      if (answer == null) {
        throw new ResourceNotFoundException("The resource you request doesn't exist or couldn't be fetched.");
      }
      return answer;
    } catch (KubernetesClientException e) {
      if (e.getCode() != HttpURLConnection.HTTP_NOT_FOUND) {
        throw e;
      }
      throw new ResourceNotFoundException("Resource not found : " + e.getMessage(), e);
    }
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
  public ReplaceDeletable<T> lockResourceVersion(String resourceVersion) {
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
      m -> waitUntilCondition(Objects::nonNull, 1, TimeUnit.SECONDS),
      m -> fromServer().get()
    );

    return createOrReplaceHelper.createOrReplace(finalItemToCreateOrReplace);
  }

  @Override
  public FilterWatchListDeletable<T, L> withLabels(Map<String, String> labels) {
    return withNewFilter().withLabels(labels).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L> withLabelSelector(LabelSelector selector) {
    return withNewFilter().withLabelSelector(selector).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L> withoutLabels(Map<String, String> labels) {
    return withNewFilter().withoutLabels(labels).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L> withLabelIn(String key, String... values) {
    return withNewFilter().withLabelIn(key, values).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L> withLabelNotIn(String key, String... values) {
    return withNewFilter().withLabelNotIn(key, values).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L> withLabel(String key, String value) {
    return withNewFilter().withLabel(key, value).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L> withoutLabel(String key, String value) {
    return withNewFilter().withoutLabel(key, value).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L> withFields(Map<String, String> fields) {
    return withNewFilter().withFields(fields).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L> withField(String key, String value) {
    return withNewFilter().withField(key, value).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L> withInvolvedObject(ObjectReference objectReference) {
    if (objectReference != null) {
      return withNewFilter().withInvolvedObject(objectReference).endFilter();
    }
    return this;
  }

  @Override
  public FilterNested<FilterWatchListDeletable<T, L>> withNewFilter() {
    return new FilterNestedImpl<>(this);
  }

  @Override
  public FilterWatchListDeletable<T, L> withoutFields(Map<String, String> fields) {
    return withNewFilter().withoutFields(fields).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L> withoutField(String key, String value) {
    return withNewFilter().withoutField(key, value).endFilter();
  }

  public String getLabelQueryParam() {
    StringBuilder sb = new StringBuilder();

    Map<String, String> labels = context.getLabels();
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

    Map<String, String[]> labelsNot = context.getLabelsNot();
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

    Map<String, String[]> labelsIn = context.getLabelsIn();
    if (labelsIn != null && !labelsIn.isEmpty()) {
      for (Iterator<Map.Entry<String, String[]>> iter = labelsIn.entrySet().iterator(); iter.hasNext(); ) {
        if (sb.length() > 0) {
          sb.append(",");
        }
        Map.Entry<String, String[]> entry = iter.next();
        sb.append(entry.getKey()).append(" in ").append("(").append(Utils.join(entry.getValue())).append(")");
      }
    }

    Map<String, String[]> labelsNotIn = context.getLabelsNotIn();
    if (labelsNotIn != null && !labelsNotIn.isEmpty()) {
      for (Iterator<Map.Entry<String, String[]>> iter = labelsNotIn.entrySet().iterator(); iter.hasNext(); ) {
        if (sb.length() > 0) {
          sb.append(",");
        }
        Map.Entry<String, String[]> entry = iter.next();
        sb.append(entry.getKey()).append(" notin ").append("(").append(Utils.join(entry.getValue())).append(")");
      }
    }
    if (sb.length() > 0) {
      return sb.toString();
    }
    return null;
  }

  public String getFieldQueryParam() {
    StringBuilder sb = new StringBuilder();
    if (Utils.isNotNullOrEmpty(context.getName())) {
      sb.append("metadata.name").append("=").append(context.getName());
    }
    Map<String, String> fields = context.getFields();
    if (fields != null && !fields.isEmpty()) {
      for (Iterator<Map.Entry<String, String>> iter = fields.entrySet().iterator(); iter.hasNext(); ) {
        if (sb.length() > 0) {
          sb.append(",");
        }
        Map.Entry<String, String> entry = iter.next();
        sb.append(entry.getKey()).append("=").append(entry.getValue());
      }
    }
    Map<String, String[]> fieldsNot = context.getFieldsNot();
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
    if (sb.length() > 0) {
      return sb.toString();
    }
    return null;
  }

  @Override
  public L list() {
    return list(new ListOptions());
  }

  @Override
  public L list(Integer limitVal, String continueVal) {
    return list(new ListOptionsBuilder().withLimit(Long.parseLong(limitVal.toString())).withContinue(continueVal).build());
  }

  @Override
  public L list(ListOptions listOptions) {
    try {
      return listRequestHelper(
          fetchListUrl(getNamespacedUrl(), defaultListOptions(listOptions, null)));
    } catch (MalformedURLException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("list"), e);
    }
  }

  /**
   * Override the options based upon the context / call
   */
  private ListOptions defaultListOptions(ListOptions options, Boolean watch) {
    options.setWatch(watch);
    String fieldQueryParam = getFieldQueryParam();
    if (fieldQueryParam != null) {
      options.setFieldSelector(fieldQueryParam);
    }
    String lableQueryParam = getLabelQueryParam();
    if (lableQueryParam != null) {
      options.setLabelSelector(lableQueryParam);
    }
    if (resourceVersion != null) {
      options.setResourceVersion(resourceVersion);
    }
    return options;
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
        handleDelete(item, gracePeriodSeconds, propagationPolicy, resourceVersion, cascading);
      } else {
        handleDelete(getResourceURLForWriteOperation(getResourceUrl()), gracePeriodSeconds, propagationPolicy, resourceVersion, cascading);
      }
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(forOperationType("delete"), e);
    }
  }

  void deleteList() {
    delete(list().getItems());
  }

  @Override
  public BaseOperation<T, L, R> withResourceVersion(String resourceVersion) {
    return newInstance(context.withResourceVersion(resourceVersion));
  }

  @Override
  public Watch watch(final Watcher<T> watcher) {
    return watch(new ListOptions(), watcher); 
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
    options = defaultListOptions(options, true);
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

  @Override
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

  @Override
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
  
  public Class<L> getListType() {
    return listType;
  }

  @Override
  public String getKind() {
    return type != null ? HasMetadata.getKind(type) : "Resource";
  }

  @Override
  public String getGroup() {
    return getAPIGroupName();
  }

  @Override
  public String getPlural() {
    return getResourceT();
  }

  @Override
  public String getVersion() {
    return getAPIGroupVersion();
  }

  @Override
  public String getOperationType() {
    return null;
  }

  @Override
  public OperationInfo forOperationType(String type) {
    return new DefaultOperationInfo(getKind(), type, name, namespace, getGroup(), getPlural(), getVersion());
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
    return this;
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
    String version = apiVersion;
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
    String version = apiVersion;
    if (hasMetadata != null && version != null && version.length() > 0) {
      String current = hasMetadata.getApiVersion();
      // lets overwrite the api version if its currently missing, the resource uses an API Group with '/'
      // or we have the default of 'v1' when using an API group version like 'build.openshift.io/v1'
      if (current == null || "v1".equals(current) || current.indexOf('/') < 0 && version.indexOf('/') > 0) {
        hasMetadata.setApiVersion(version);
      }
    }
  }

  public Readiness getReadiness() {
    return config.getReadiness();
  }

  @Override
  public final boolean isReady() {
    T item = fromServer().get();
    if (item == null) {
      return false;
    }
    return getReadiness().isReady(item);
  }

  @Override
  public T waitUntilReady(long amount, TimeUnit timeUnit) {
    return waitUntilCondition(resource -> Objects.nonNull(resource) && getReadiness().isReady(resource), amount, timeUnit);
  }

  @Override
  public T waitUntilCondition(Predicate<T> condition, long amount, TimeUnit timeUnit) {
    CompletableFuture<T> futureCondition = informOnCondition(l -> {
      if (l.isEmpty()) {
        return condition.test(null);
      }
      return condition.test(l.get(0));
    }).thenApply(l -> l.isEmpty() ? null : l.get(0));
    
    if (!Utils.waitUntilReady(futureCondition, amount, timeUnit)) {
      futureCondition.cancel(true);
      T i = getItem();
      if (i != null) {
        throw new KubernetesClientTimeoutException(i, amount, timeUnit);
      }
      throw new KubernetesClientTimeoutException(getKind(), getName(), getNamespace(), amount, timeUnit);
    }
    return futureCondition.getNow(null);
  }
  
  @Override
  public CompletableFuture<List<T>> informOnCondition(Predicate<List<T>> condition) {
    CompletableFuture<List<T>> future = new CompletableFuture<>();
    AtomicReference<Runnable> tester = new AtomicReference<>();
    
    // create an informer that supplies the tester with events and empty list handling
    SharedIndexInformer<T> informer = this.createInformer(0);
    
    // prevent unnecessary watches and handle closure
    future.whenComplete((r, t) -> informer.stop());
    
    // use the cache to evaluate the list predicate, trapping any exceptions
    Runnable test = () -> {
      try {
        // could skip if lastResourceVersion has not changed
        List<T> list = informer.getStore().list();
        if (condition.test(list)) {
          future.complete(list);
        }
      } catch (Exception e) {
        future.completeExceptionally(e);
      }
    };
    tester.set(test);
    
    informer.addEventHandler(new ResourceEventHandler<T>() {
      @Override
      public void onAdd(T obj) {
        test.run();
      }
      @Override
      public void onDelete(T obj, boolean deletedFinalStateUnknown) {
        test.run();
      }
      @Override
      public void onUpdate(T oldObj, T newObj) {
        test.run();
      }
      @Override
      public void onNothing() {
        test.run();
      }
    });
    informer.run();
    return future;
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

  @Override
  public Informable<T> withIndexers(Map<String, Function<T, List<String>>> indexers) {
    BaseOperation<T, L, R> result = newInstance(context);
    result.indexers = indexers;
    return result;
  }

  @Override
  public SharedIndexInformer<T> inform(ResourceEventHandler<? super T> handler, long resync) {
    DefaultSharedIndexInformer<T, L> result = createInformer(resync);
    if (handler != null) {
      result.addEventHandler(handler);
    }
    // synchronous start list/watch must succeed in the calling thread
    // initial add events will be processed in the calling thread as well
    result.run();
    return result;
  }

  @Override
  public SharedIndexInformer<T> runnableInformer(long resync) {
    return createInformer(resync);
  }

  private DefaultSharedIndexInformer<T, L> createInformer(long resync) {
    T i = getItem();
    if (Utils.isNotNullOrEmpty(getName()) && i != null) {
      checkName(i);
    }

    // use the local context / namespace but without a resourceVersion
    DefaultSharedIndexInformer<T, L> informer = new DefaultSharedIndexInformer<>(getType(), this.withResourceVersion(null), resync, Runnable::run); // just run the event notification in the websocket thread
    if (indexers != null) {
      informer.addIndexers(indexers);
    }
    return informer;
  }
}

