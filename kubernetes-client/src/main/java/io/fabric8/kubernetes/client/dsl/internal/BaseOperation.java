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

import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusDetails;
import io.fabric8.kubernetes.api.model.StatusDetailsBuilder;
import io.fabric8.kubernetes.api.model.autoscaling.v1.Scale;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollback;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.KubernetesClientTimeoutException;
import io.fabric8.kubernetes.client.OperationInfo;
import io.fabric8.kubernetes.client.ResourceNotFoundException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.FilterNested;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.extension.ExtensibleResource;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.impl.DefaultSharedIndexInformer;
import io.fabric8.kubernetes.client.informers.impl.ListerWatcher;
import io.fabric8.kubernetes.client.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.URLUtils.URLBuilder;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.client.utils.internal.CreateOrReplaceHelper;
import io.fabric8.kubernetes.client.utils.internal.WatcherToggle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseOperation<T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>>
    extends CreateOnlyResourceOperation<T, T>
    implements
    OperationInfo,
    MixedOperation<T, L, R>,
    ExtensibleResource<T>,
    ListerWatcher<T, L> {

  private static final String WATCH = "watch";
  private static final String READ_ONLY_UPDATE_EXCEPTION_MESSAGE = "Cannot update read-only resources";
  private static final String READ_ONLY_EDIT_EXCEPTION_MESSAGE = "Cannot edit read-only resources";

  private final T item;

  private final String resourceVersion;
  private final boolean reloadingFromServer;
  private final long gracePeriodSeconds;
  private final DeletionPropagation propagationPolicy;

  protected String apiVersion;

  protected Class<L> listType;
  // informable state
  private Map<String, Function<T, List<String>>> indexers;
  private Long limit;

  protected BaseOperation(OperationContext ctx) {
    super(ctx);
    this.item = (T) ctx.getItem();
    this.reloadingFromServer = ctx.isReloadingFromServer();
    this.resourceVersion = ctx.getResourceVersion();
    this.gracePeriodSeconds = ctx.getGracePeriodSeconds();
    this.propagationPolicy = ctx.getPropagationPolicy();
    this.apiVersion = ApiVersionUtil.joinApiGroupAndVersion(getAPIGroupName(), getAPIGroupVersion());
  }

  public BaseOperation<T, L, R> newInstance(OperationContext context) {
    return new BaseOperation<>(context);
  }

  protected R newResource(OperationContext context) {
    return (R) newInstance(context);
  }

  protected URL fetchListUrl(URL url, ListOptions listOptions) {
    return appendListOptionParams(url, listOptions);
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
      return Serialization.clone(item);
    }
    try {
      URL requestUrl = getCompleteResourceUrl();
      return handleGet(requestUrl);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(forOperationType("get"), ie);
    } catch (IOException e) {
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
    return newResource(context.withName(name));
  }

  @Override
  public ExtensibleResource<T> lockResourceVersion(String resourceVersion) {
    if (resourceVersion == null) {
      throw new KubernetesClientException("resourceVersion cannot be null");
    }
    return newInstance(context.withResourceVersion(resourceVersion));
  }

  @Override
  public BaseOperation<T, L, R> inNamespace(String namespace) {
    if (namespace == null) {
      throw new KubernetesClientException("namespace cannot be null");
    }
    return newInstance(context.withNamespace(namespace));
  }

  @Override
  public BaseOperation<T, L, R> inAnyNamespace() {
    return newInstance(context.withNamespace(null));
  }

  @Override
  public R load(InputStream is) {
    T unmarshal = unmarshal(is, type);
    // if you do something like client.foo().v2().load(v1 resource)
    // it will parse as v2, but have a v1 apiVersion, so we need to
    // force the apiVersion
    unmarshal.setApiVersion(apiVersion);
    return resource(unmarshal);
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
  public ExtensibleResource<T> fromServer() {
    return newInstance(context.withReloadingFromServer(true));
  }

  @Override
  public final T createOrReplace() {
    if (item == null) {
      throw new IllegalArgumentException("Nothing to create.");
    }
    R resource = resource(item);

    CreateOrReplaceHelper<T> createOrReplaceHelper = new CreateOrReplaceHelper<>(
        resource::create,
        resource::replace,
        m -> resource.waitUntilCondition(Objects::nonNull, 1, TimeUnit.SECONDS),
        m -> resource.fromServer().get());

    return createOrReplaceHelper.createOrReplace(item);
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withLabels(Map<String, String> labels) {
    return withNewFilter().withLabels(labels).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withLabelSelector(LabelSelector selector) {
    return withNewFilter().withLabelSelector(selector).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withoutLabels(Map<String, String> labels) {
    return withNewFilter().withoutLabels(labels).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withLabelIn(String key, String... values) {
    return withNewFilter().withLabelIn(key, values).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withLabelNotIn(String key, String... values) {
    return withNewFilter().withLabelNotIn(key, values).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withLabel(String key, String value) {
    return withNewFilter().withLabel(key, value).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withoutLabel(String key, String value) {
    return withNewFilter().withoutLabel(key, value).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withLabelSelector(String selectorAsString) {
    return withNewFilter().withLabelSelector(selectorAsString).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withFields(Map<String, String> fields) {
    return withNewFilter().withFields(fields).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withField(String key, String value) {
    return withNewFilter().withField(key, value).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withInvolvedObject(ObjectReference objectReference) {
    if (objectReference != null) {
      return withNewFilter().withInvolvedObject(objectReference).endFilter();
    }
    return this;
  }

  @Override
  public FilterNested<FilterWatchListDeletable<T, L, R>> withNewFilter() {
    return new FilterNestedImpl<>(this);
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withoutFields(Map<String, String> fields) {
    return withNewFilter().withoutFields(fields).endFilter();
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withoutField(String key, String value) {
    return withNewFilter().withoutField(key, value).endFilter();
  }

  public String getFieldQueryParam() {
    return context.getFieldQueryParam();
  }

  @Override
  public L list() {
    return list(new ListOptions());
  }

  @Override
  public L list(Integer limitVal, String continueVal) {
    return list(new ListOptionsBuilder().withLimit(limitVal.longValue()).withContinue(continueVal).build());
  }

  @Override
  public CompletableFuture<L> submitList(ListOptions listOptions) {
    try {
      URL fetchListUrl = fetchListUrl(getNamespacedUrl(), defaultListOptions(listOptions, null));
      HttpRequest.Builder requestBuilder = httpClient.newHttpRequestBuilder().url(fetchListUrl);
      CompletableFuture<L> futureAnswer = handleResponse(httpClient, requestBuilder, listType, getParameters());
      return futureAnswer.thenApply(l -> {
        updateApiVersion(l);
        return l;
      });
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("list"), e);
    }
  }

  @Override
  public L list(ListOptions listOptions) {
    try {
      return waitForResult(submitList(listOptions));
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("list"), e);
    }
  }

  /**
   * Override the options based upon the context / call
   */
  private ListOptions defaultListOptions(ListOptions options, Boolean watch) {
    options.setWatch(watch);
    String fieldQueryParam = context.getFieldQueryParam();
    if (fieldQueryParam != null) {
      options.setFieldSelector(fieldQueryParam);
    }
    String labelQueryParam = context.getLabelQueryParam();
    if (labelQueryParam != null) {
      options.setLabelSelector(labelQueryParam);
    }
    if (resourceVersion != null) {
      options.setResourceVersion(resourceVersion);
    }
    return options;
  }

  static void toStatusDetails(KubernetesResource obj, List<StatusDetails> details) {
    if (obj instanceof HasMetadata) {
      HasMetadata meta = (HasMetadata) obj;
      ObjectMeta metadata = meta.getMetadata();
      details.add(new StatusDetailsBuilder()
          .withGroup(ApiVersionUtil.trimGroup(meta.getApiVersion()))
          .withKind(meta.getKind())
          .withName(metadata == null ? null : metadata.getName())
          .withUid(metadata == null ? null : metadata.getUid())
          .build());
    } else if (obj instanceof Status) {
      details.add(((Status) obj).getDetails());
    } else if (obj instanceof KubernetesResourceList) {
      List<HasMetadata> items = ((KubernetesResourceList<HasMetadata>) obj).getItems();
      if (items != null) {
        items.forEach(i -> toStatusDetails(i, details));
      }
    } else {
      // log?
    }
  }

  @Override
  public List<StatusDetails> delete() {
    if (Utils.isNotNullOrEmpty(name) || Utils.isNotNullOrEmpty(namespace) || !isResourceNamespaced()) {
      try {
        URL resourceURLForWriteOperation = getResourceURLForWriteOperation(getResourceUrl());
        ListOptions options = new ListOptions();
        boolean useOptions = false;
        if (Utils.isNullOrEmpty(name)) {
          String fieldQueryParam = context.getFieldQueryParam();
          if (fieldQueryParam != null) {
            options.setFieldSelector(fieldQueryParam);
            useOptions = true;
          }
          String labelQueryParam = context.getLabelQueryParam();
          if (labelQueryParam != null) {
            options.setLabelSelector(labelQueryParam);
            useOptions = true;
          }
        }
        if (useOptions) {
          resourceURLForWriteOperation = appendListOptionParams(resourceURLForWriteOperation, options);
        }
        KubernetesResource result = handleDelete(resourceURLForWriteOperation, gracePeriodSeconds, propagationPolicy,
            resourceVersion);
        ArrayList<StatusDetails> details = new ArrayList<>();
        toStatusDetails(result, details);
        return details;
      } catch (Exception e) {
        RuntimeException re = KubernetesClientException.launderThrowable(forOperationType("delete"), e);
        if (re instanceof KubernetesClientException) {
          KubernetesClientException ke = (KubernetesClientException) re;
          if (Utils.isNotNullOrEmpty(name)) {
            if (ke.getCode() == HttpURLConnection.HTTP_NOT_FOUND) {
              return Collections.emptyList();
            }
          } else if (ke.getCode() == HttpURLConnection.HTTP_BAD_METHOD) {
            // collection delete may not be supported, fall-back to single item delete
            return list().getItems().stream().flatMap(i -> resource(i).delete().stream()).collect(Collectors.toList());
          }
        }
        throw re;
      }
    }
    // if there is no name nor namespace and this is a namespaced resource, find each applicable namespace and issue a delete
    Set<String> namespaces = list().getItems().stream().map(i -> i.getMetadata().getNamespace()).collect(Collectors.toSet());
    return namespaces.stream().flatMap(n -> inNamespace(n).delete().stream()).collect(Collectors.toList());
  }

  @Override
  public boolean delete(List<T> items) {
    if (items != null) {
      for (T toDelete : items) {
        if (toDelete == null) {
          continue;
        }
        try {
          resource(toDelete).delete();
        } catch (KubernetesClientException e) {
          if (e.getCode() != HttpURLConnection.HTTP_NOT_FOUND) {
            throw e;
          }
        }
      }
    }
    return true;
  }

  @Override
  public T patchStatus(T item) {
    throw new KubernetesClientException(READ_ONLY_UPDATE_EXCEPTION_MESSAGE);
  }

  @Override
  public T patchStatus() {
    return patchStatus(getNonNullItem());
  }

  @Override
  public T patch() {
    return patch(getNonNullItem());
  }

  @Override
  public T patch(PatchContext patchContext) {
    return patch(patchContext, getNonNullItem());
  }

  protected T getNonNullItem() {
    T result = getItem();
    if (result == null) {
      throw new KubernetesClientException("item required");
    }
    return result;
  }

  @Override
  public R resource(T item) {
    // set the name, namespace, and item - not all operations are looking at the item for the name
    // things like configMaps().load(...).watch(...) for example
    item = correctNamespace(item);
    updateApiVersion(item);
    String itemNs = KubernetesResourceUtil.getNamespace(item);
    OperationContext ctx = context.withName(checkName(item)).withItem(item);
    if (Utils.isNotNullOrEmpty(itemNs)) {
      ctx = ctx.withNamespace(itemNs);
    }
    return newResource(ctx);
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
    CompletableFuture<Watch> startedFuture = submitWatch(options, watcher);
    Utils.waitUntilReadyOrFail(startedFuture, -1, TimeUnit.SECONDS);
    return startedFuture.join();
  }

  @Override
  public CompletableFuture<Watch> submitWatch(ListOptions options, final Watcher<T> watcher) {
    WatcherToggle<T> watcherToggle = new WatcherToggle<>(watcher, true);
    ListOptions optionsToUse = defaultListOptions(options, true);
    WatchConnectionManager<T, L> watch;
    try {
      watch = new WatchConnectionManager<>(
          httpClient,
          this,
          optionsToUse,
          watcherToggle,
          config.getWatchReconnectInterval(),
          config.getWatchReconnectLimit(),
          config.getWebsocketTimeout());
    } catch (MalformedURLException e) {
      throw KubernetesClientException.launderThrowable(forOperationType(WATCH), e);
    }
    return watch.getWebsocketFuture().handle((w, t) -> {
      if (t != null) {
        try {
          if (t instanceof CompletionException) {
            t = t.getCause();
          }
          if (t instanceof KubernetesClientException) {
            KubernetesClientException ke = (KubernetesClientException) t;
            List<Integer> furtherProcessedCodes = Arrays.asList(200, 503);
            if (!furtherProcessedCodes.contains(ke.getCode())) {
              throw ke;
            }

            //release the watch after disabling the watcher (to avoid premature call to onClose)
            watcherToggle.disable();

            // If the HTTP return code is 200 or 503, we retry the watch again using a persistent hanging
            // HTTP GET. This is meant to handle cases like kubectl local proxy which does not support
            // websockets. Issue: https://github.com/kubernetes/kubernetes/issues/25126
            try {
              return new WatchHTTPManager<>(
                  httpClient,
                  this,
                  optionsToUse,
                  watcher,
                  config.getWatchReconnectInterval(),
                  config.getWatchReconnectLimit());
            } catch (MalformedURLException e) {
              throw KubernetesClientException.launderThrowable(forOperationType(WATCH), e);
            }
          }
        } finally {
          watch.close();
        }
      }
      return watch;
    });

  }

  @Override
  public T replace() {
    throw new KubernetesClientException(READ_ONLY_UPDATE_EXCEPTION_MESSAGE);
  }

  @Override
  public T replaceStatus() {
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

  protected T handleResponse(HttpRequest.Builder requestBuilder) throws InterruptedException, IOException {
    return handleResponse(requestBuilder, getType());
  }

  @Override
  protected T handleCreate(T resource) throws InterruptedException, IOException {
    updateApiVersion(resource);
    return handleCreate(resource, getType());
  }

  protected T handleUpdate(T updated, boolean status) throws InterruptedException, IOException {
    updateApiVersion(updated);
    return handleUpdate(updated, getType(), status);
  }

  protected T handlePatch(PatchContext context, T current, T updated, boolean status) throws InterruptedException, IOException {
    updateApiVersion(updated);
    return handlePatch(context, current, updated, getType(), status);
  }

  protected Scale handleScale(Scale scaleParam) {
    try {
      return handleScale(getCompleteResourceUrl().toString(), scaleParam);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(forOperationType("scale"), ie);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("scale"), e);
    }

  }

  protected Status handleDeploymentRollback(DeploymentRollback deploymentRollback) {
    try {
      return handleDeploymentRollback(getCompleteResourceUrl().toString(), deploymentRollback);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(forOperationType("rollback"), ie);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("rollback"), e);
    }

  }

  protected T handleGet(URL resourceUrl) throws InterruptedException, IOException {
    T answer = handleGet(resourceUrl, getType());
    updateApiVersion(answer);
    return answer;
  }

  private URL getCompleteResourceUrl() throws MalformedURLException {
    URL requestUrl = getNamespacedUrl(checkNamespace(item));
    if (name != null) {
      requestUrl = new URL(URLUtils.join(requestUrl.toString(), name));
    } else if (item != null && reloadingFromServer) {
      requestUrl = new URL(URLUtils.join(requestUrl.toString(), checkName(item)));
    }
    return requestUrl;
  }

  @Override
  public final T getItem() {
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
  public ExtensibleResource<T> withGracePeriod(long gracePeriodSeconds) {
    return newInstance(context.withGracePeriodSeconds(gracePeriodSeconds));
  }

  @Override
  public ExtensibleResource<T> withPropagationPolicy(DeletionPropagation propagationPolicy) {
    return newInstance(context.withPropagationPolicy(propagationPolicy));
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
    CompletableFuture<List<T>> futureCondition = informOnCondition(l -> {
      if (l.isEmpty()) {
        return condition.test(null);
      }
      return l.stream().allMatch(condition);
    });

    if (!Utils.waitUntilReady(futureCondition, amount, timeUnit)) {
      futureCondition.cancel(true);
      T i = getItem();
      if (i != null) {
        throw new KubernetesClientTimeoutException(i, amount, timeUnit);
      }
      throw new KubernetesClientTimeoutException(getKind(), getName(), getNamespace(), amount, timeUnit);
    }
    return futureCondition.thenApply(l -> l.isEmpty() ? null : l.get(0)).getNow(null);
  }

  @Override
  public CompletableFuture<List<T>> informOnCondition(Predicate<List<T>> condition) {
    CompletableFuture<List<T>> future = new CompletableFuture<>();

    // create an informer that supplies the tester with events and empty list handling
    SharedIndexInformer<T> informer = this.createInformer(0, Runnable::run);

    // prevent unnecessary watches and handle closure
    future.whenComplete((r, t) -> informer.stop());

    // use the cache to evaluate the list predicate, trapping any exceptions
    Consumer<List<T>> test = list -> {
      try {
        // could skip if lastResourceVersion has not changed
        if (condition.test(list)) {
          future.complete(list);
        }
      } catch (Exception e) {
        future.completeExceptionally(e);
      }
    };

    informer.addEventHandler(new ResourceEventHandler<T>() {
      @Override
      public void onAdd(T obj) {
        test.accept(informer.getStore().list());
      }

      @Override
      public void onDelete(T obj, boolean deletedFinalStateUnknown) {
        test.accept(informer.getStore().list());
      }

      @Override
      public void onUpdate(T oldObj, T newObj) {
        test.accept(informer.getStore().list());
      }

      @Override
      public void onNothing() {
        test.accept(informer.getStore().list());
      }
    }).start().whenComplete((v, t) -> {
      if (t != null) {
        future.completeExceptionally(t);
      }
    });
    return future;
  }

  public void setType(Class<T> type) {
    this.type = type;
  }

  public void setListType(Class<L> listType) {
    this.listType = listType;
  }

  @Override
  public ExtensibleResource<T> dryRun(boolean isDryRun) {
    return newInstance(context.withDryRun(isDryRun));
  }

  @Override
  public ExtensibleResource<T> withIndexers(Map<String, Function<T, List<String>>> indexers) {
    BaseOperation<T, L, R> result = newInstance(context);
    result.indexers = indexers;
    result.limit = this.limit;
    return result;
  }

  @Override
  public BaseOperation<T, L, R> withLimit(Long limit) {
    BaseOperation<T, L, R> result = newInstance(context);
    result.indexers = this.indexers;
    result.limit = limit;
    return result;
  }

  @Override
  public Long getLimit() {
    return this.limit;
  }

  @Override
  public SharedIndexInformer<T> inform(ResourceEventHandler<? super T> handler, long resync) {
    SharedIndexInformer<T> result = runnableInformer(resync);
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
    // create the informer using the client executor
    return createInformer(resync, context.getExecutor());
  }

  private DefaultSharedIndexInformer<T, L> createInformer(long resync, Executor executor) {
    T i = getItem();
    if (Utils.isNotNullOrEmpty(getName()) && i != null) {
      checkName(i);
    }

    // use the local context / namespace but without a resourceVersion
    DefaultSharedIndexInformer<T, L> informer = new DefaultSharedIndexInformer<>(getType(),
        this.withResourceVersion(null).withLimit(this.limit), resync, executor);
    if (indexers != null) {
      informer.addIndexers(indexers);
    }
    return informer;
  }

  public static URL appendListOptionParams(URL base, ListOptions listOptions) {
    if (listOptions == null) {
      return base;
    }
    URLBuilder urlBuilder = new URLBuilder(base);
    if (listOptions.getLimit() != null) {
      urlBuilder.addQueryParameter("limit", listOptions.getLimit().toString());
    }
    if (listOptions.getContinue() != null) {
      urlBuilder.addQueryParameter("continue", listOptions.getContinue());
    }

    if (listOptions.getFieldSelector() != null) {
      urlBuilder.addQueryParameter("fieldSelector", listOptions.getFieldSelector());
    }

    if (listOptions.getLabelSelector() != null) {
      urlBuilder.addQueryParameter("labelSelector", listOptions.getLabelSelector());
    }

    if (listOptions.getResourceVersion() != null) {
      urlBuilder.addQueryParameter("resourceVersion", listOptions.getResourceVersion());
    }

    if (listOptions.getTimeoutSeconds() != null) {
      urlBuilder.addQueryParameter("timeoutSeconds", listOptions.getTimeoutSeconds().toString());
    }

    if (listOptions.getAllowWatchBookmarks() != null) {
      urlBuilder.addQueryParameter("allowWatchBookmarks", listOptions.getAllowWatchBookmarks().toString());
    }

    if (listOptions.getWatch() != null) {
      urlBuilder.addQueryParameter(WATCH, listOptions.getWatch().toString());
    }
    return urlBuilder.build();
  }

  @Override
  public <C extends Client> C inWriteContext(Class<C> clazz) {
    return context.clientInWriteContext(clazz);
  }

  @Override
  public int getWatchReconnectInterval() {
    return config.getWatchReconnectInterval();
  }

  @Override
  public Stream<R> resources() {
    return list().getItems().stream().map(this::resource);
  }

  @Override
  public T createOrReplace(T item) {
    return resource(item).createOrReplace();
  }

  @Override
  public T replace(T item) {
    return resource(item).replace();
  }

  @Override
  public T replaceStatus(T item) {
    return resource(item).replaceStatus();
  }

  @Override
  public List<StatusDetails> delete(T item) {
    return resource(item).delete();
  }

  @Override
  public ExtensibleResource<T> dryRun() {
    return dryRun(true);
  }

  @Override
  public ExtensibleResource<T> lockResourceVersion() {
    return lockResourceVersion(KubernetesResourceUtil.getResourceVersion(getNonNullItem()));
  }

  @Override
  public T updateStatus(T item) {
    return resource(item).lockResourceVersion().replaceStatus();
  }

  @Override
  public T create() {
    return create(getNonNullItem());
  }

}
