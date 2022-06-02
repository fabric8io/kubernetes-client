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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.DeleteOptions;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Preconditions;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.autoscaling.v1.Scale;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollback;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.internal.PatchUtils;
import io.fabric8.kubernetes.client.internal.VersionUsageUtils;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.client.utils.internal.ExponentialBackoffIntervalCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OperationSupport {

  public static final String JSON = "application/json";
  public static final String JSON_PATCH = "application/json-patch+json";
  public static final String STRATEGIC_MERGE_JSON_PATCH = "application/strategic-merge-patch+json";
  public static final String JSON_MERGE_PATCH = "application/merge-patch+json";

  protected static final ObjectMapper JSON_MAPPER = Serialization.jsonMapper();
  private static final Logger LOG = LoggerFactory.getLogger(OperationSupport.class);
  private static final String CLIENT_STATUS_FLAG = "CLIENT_STATUS_FLAG";
  private static final int MAX_RETRY_INTERVAL_EXPONENT = 5;

  protected OperationContext context;
  protected final HttpClient httpClient;
  protected final Config config;
  protected final String resourceT;
  protected String namespace;
  protected String name;
  protected String apiGroupName;
  protected String apiGroupVersion;
  protected boolean dryRun;
  private final ExponentialBackoffIntervalCalculator retryIntervalCalculator;
  private final int requestRetryBackoffLimit;

  public OperationSupport(Client client) {
    this(new OperationContext().withClient(client));
  }

  public OperationSupport(OperationContext ctx) {
    this.context = ctx;
    this.httpClient = ctx.getHttpClient();
    this.config = ctx.getConfig();
    this.resourceT = ctx.getPlural();
    this.namespace = ctx.getNamespace();
    this.name = ctx.getName();
    this.apiGroupName = ctx.getApiGroupName();
    this.dryRun = ctx.getDryRun();
    if (Utils.isNotNullOrEmpty(ctx.getApiGroupVersion())) {
      this.apiGroupVersion = ctx.getApiGroupVersion();
    } else if (ctx.getConfig() != null && Utils.isNotNullOrEmpty(ctx.getConfig().getApiVersion())) {
      this.apiGroupVersion = ctx.getConfig().getApiVersion();
    } else {
      this.apiGroupVersion = "v1";
    }

    final int requestRetryBackoffInterval;
    if (ctx.getConfig() != null) {
      requestRetryBackoffInterval = ctx.getConfig().getRequestRetryBackoffInterval();
      this.requestRetryBackoffLimit = ctx.getConfig().getRequestRetryBackoffLimit();
    } else {
      requestRetryBackoffInterval = Config.DEFAULT_REQUEST_RETRY_BACKOFFINTERVAL;
      this.requestRetryBackoffLimit = Config.DEFAULT_REQUEST_RETRY_BACKOFFLIMIT;
    }
    this.retryIntervalCalculator = new ExponentialBackoffIntervalCalculator(requestRetryBackoffInterval,
        MAX_RETRY_INTERVAL_EXPONENT);
  }

  public String getAPIGroupName() {
    return apiGroupName;
  }

  public String getAPIGroupVersion() {
    return apiGroupVersion;
  }

  public String getResourceT() {
    return resourceT;
  }

  public String getNamespace() {
    return namespace;
  }

  public String getName() {
    return name;
  }

  public boolean isResourceNamespaced() {
    return true;
  }

  public URL getRootUrl() {
    try {
      if (!Utils.isNullOrEmpty(apiGroupName)) {
        return new URL(URLUtils.join(config.getMasterUrl(), "apis", apiGroupName, apiGroupVersion));
      }
      return new URL(URLUtils.join(config.getMasterUrl(), "api", apiGroupVersion));
    } catch (MalformedURLException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  public URL getNamespacedUrl(String namespace) throws MalformedURLException {
    URL requestUrl = getRootUrl();
    if (!isResourceNamespaced()) {
      //if resource is not namespaced don't even bother to check the namespace.
    } else if (Utils.isNotNullOrEmpty(namespace)) {
      requestUrl = new URL(URLUtils.join(requestUrl.toString(), "namespaces", namespace));
    }
    requestUrl = new URL(URLUtils.join(requestUrl.toString(), resourceT));
    return requestUrl;
  }

  public URL getNamespacedUrl() throws MalformedURLException {
    return getNamespacedUrl(getNamespace());
  }

  public URL getResourceUrl(String namespace, String name) throws MalformedURLException {
    return getResourceUrl(namespace, name, false);
  }

  public URL getResourceUrl(String namespace, String name, boolean status) throws MalformedURLException {
    if (name == null) {
      if (status) {
        throw new KubernetesClientException("name not specified for an operation requiring one.");
      }
      return getNamespacedUrl(namespace);
    }
    if (status) {
      return new URL(URLUtils.join(getNamespacedUrl(namespace).toString(), name, "status"));
    }
    return new URL(URLUtils.join(getNamespacedUrl(namespace).toString(), name));
  }

  public URL getResourceUrl() throws MalformedURLException {
    if (name == null) {
      return getNamespacedUrl();
    }
    return new URL(URLUtils.join(getNamespacedUrl().toString(), name));
  }

  public URL getResourceURLForWriteOperation(URL resourceURL) throws MalformedURLException {
    if (dryRun) {
      return new URL(URLUtils.join(resourceURL.toString(), "?dryRun=All"));
    }
    return resourceURL;
  }

  public URL getResourceURLForPatchOperation(URL resourceUrl, PatchContext patchContext) throws MalformedURLException {
    if (patchContext != null) {
      String url = resourceUrl.toString();
      if (patchContext.getForce() != null) {
        url = URLUtils.join(url, "?force=" + patchContext.getForce());
      }
      if ((patchContext.getDryRun() != null && !patchContext.getDryRun().isEmpty()) || dryRun) {
        url = URLUtils.join(url, "?dryRun=All");
      }
      String fieldManager = patchContext.getFieldManager();
      if (fieldManager == null && patchContext.getPatchType() == PatchType.SERVER_SIDE_APPLY) {
        fieldManager = "fabric8";
      }
      if (fieldManager != null) {
        url = URLUtils.join(url, "?fieldManager=" + fieldManager);
      }
      if (patchContext.getFieldValidation() != null) {
        url = URLUtils.join(url, "?fieldValidation=" + patchContext.getFieldValidation());
      }
      return new URL(url);
    }
    return resourceUrl;
  }

  protected <T> T correctNamespace(T item) {
    if (!isResourceNamespaced() || this.context.isDefaultNamespace() || !(item instanceof HasMetadata)) {
      return item;
    }
    String itemNs = KubernetesResourceUtil.getNamespace((HasMetadata) item);

    if (Utils.isNotNullOrEmpty(namespace) && Utils.isNotNullOrEmpty(itemNs) && !namespace.equals(itemNs)) {
      item = Serialization.clone(item);
      KubernetesResourceUtil.setNamespace((HasMetadata) item, namespace);
    }
    return item;
  }

  protected <T> String checkNamespace(T item) {
    if (!isResourceNamespaced()) {
      return null;
    }
    String operationNs = getNamespace();
    String itemNs = (item instanceof HasMetadata) ? KubernetesResourceUtil.getNamespace((HasMetadata) item) : null;
    if (Utils.isNullOrEmpty(operationNs) && Utils.isNullOrEmpty(itemNs)) {
      if (context.isDefaultNamespace()) {
        throw new KubernetesClientException(
            "namespace not specified for an operation requiring one and no default was found in the Config.");
      }
      throw new KubernetesClientException("namespace not specified for an operation requiring one.");
    } else if (!Utils.isNullOrEmpty(itemNs) && (Utils.isNullOrEmpty(operationNs)
        || this.context.isDefaultNamespace())) {
      return itemNs;
    }
    return operationNs;
  }

  protected <T> String checkName(T item) {
    String operationName = getName();
    ObjectMeta metadata = item instanceof HasMetadata ? ((HasMetadata) item).getMetadata() : null;
    String itemName = metadata != null ? metadata.getName() : null;
    if (Utils.isNullOrEmpty(operationName) && Utils.isNullOrEmpty(itemName)) {
      return null;
    } else if (Utils.isNullOrEmpty(itemName)) {
      return operationName;
    } else if (Utils.isNullOrEmpty(operationName)) {
      return itemName;
    } else if (Objects.equals(itemName, operationName)) {
      return itemName;
    }
    throw new KubernetesClientException("Name mismatch. Item name:" + itemName + ". Operation name:" + operationName + ".");
  }

  protected <T> T handleMetric(String resourceUrl, Class<T> type) throws InterruptedException, IOException {
    HttpRequest.Builder requestBuilder = httpClient.newHttpRequestBuilder()
        .uri(resourceUrl);
    return handleResponse(requestBuilder, type);
  }

  protected KubernetesResource handleDelete(URL requestUrl, long gracePeriodSeconds, DeletionPropagation propagationPolicy,
      String resourceVersion) throws InterruptedException, IOException {
    DeleteOptions deleteOptions = new DeleteOptions();
    if (gracePeriodSeconds >= 0) {
      deleteOptions.setGracePeriodSeconds(gracePeriodSeconds);
    }
    if (resourceVersion != null) {
      deleteOptions.setPreconditions(new Preconditions(resourceVersion, null));
    }
    if (propagationPolicy != null) {
      deleteOptions.setPropagationPolicy(propagationPolicy.toString());
    }

    if (dryRun) {
      deleteOptions.setDryRun(Collections.singletonList("All"));
    }

    HttpRequest.Builder requestBuilder = httpClient.newHttpRequestBuilder()
        .delete(JSON, JSON_MAPPER.writeValueAsString(deleteOptions)).url(requestUrl);

    return handleResponse(requestBuilder, KubernetesResource.class);
  }

  /**
   * Create a resource.
   *
   * @param resource resource provided
   * @param outputType resource type you want as output
   * @param <T> template argument for output type
   * @param <I> template argument for resource
   *
   * @return returns de-serialized version of apiserver response in form of type provided
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException
   */
  protected <T, I> T handleCreate(I resource, Class<T> outputType) throws InterruptedException, IOException {
    resource = correctNamespace(resource);
    HttpRequest.Builder requestBuilder = httpClient.newHttpRequestBuilder()
        .post(JSON, JSON_MAPPER.writeValueAsString(resource))
        .url(getResourceURLForWriteOperation(getResourceUrl(checkNamespace(resource), null)));
    return handleResponse(requestBuilder, outputType);
  }

  /**
   * Replace a resource.
   *
   * @param updated updated object
   * @param type type of the object provided
   * @param status if this is only the status subresource
   * @param <T> template argument provided
   *
   * @return returns de-serialized version of api server response
   * @throws IOException IOException
   */
  protected <T> T handleUpdate(T updated, Class<T> type, boolean status) throws IOException {
    updated = correctNamespace(updated);
    HttpRequest.Builder requestBuilder = httpClient.newHttpRequestBuilder()
        .put(JSON, JSON_MAPPER.writeValueAsString(updated))
        .url(getResourceURLForWriteOperation(getResourceUrl(checkNamespace(updated), checkName(updated), status)));
    return handleResponse(requestBuilder, type, getParameters());
  }

  /**
   * Send an http patch and handle the response.
   *
   * If current is not null and patchContext does not specify a patch type, then a JSON patch is assumed. Otherwise a STRATEGIC
   * MERGE is assumed.
   *
   * @param patchContext patch options for patch request
   * @param current current object
   * @param updated updated object
   * @param type type of object
   * @param status if this is only the status subresource
   * @param <T> template argument provided
   *
   * @return returns de-serialized version of api server response
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException
   */
  protected <T> T handlePatch(PatchContext patchContext, T current, T updated, Class<T> type, boolean status)
      throws InterruptedException, IOException {
    String patchForUpdate;
    if (current != null && (patchContext == null || patchContext.getPatchType() == PatchType.JSON)) {
      // we can't omit status unless this is not a status operation and we know this has a status subresource
      patchForUpdate = PatchUtils.jsonDiff(current, updated, false);
      if (patchContext == null) {
        patchContext = new PatchContext.Builder().withPatchType(PatchType.JSON).build();
      }
    } else {
      if (patchContext != null
          && patchContext.getPatchType() == PatchType.SERVER_SIDE_APPLY) {
        // TODO: it would probably be better to do this with a mixin
        if (updated instanceof HasMetadata) {
          ObjectMeta meta = ((HasMetadata) updated).getMetadata();
          if (meta != null && meta.getManagedFields() != null && !meta.getManagedFields().isEmpty()) {
            // the item should have already been cloned
            meta.setManagedFields(null);
          }
        }
      }
      patchForUpdate = Serialization.asJson(updated);
      current = updated; // use the updated to determine the path
    }
    return handlePatch(patchContext, current, patchForUpdate, type, status);
  }

  /**
   * Send an http patch and handle the response.
   *
   * @param patchContext patch options for patch request
   * @param current current object
   * @param patchForUpdate Patch string
   * @param type type of object
   * @param status if this is only the status subresource
   * @param <T> template argument provided
   * @return returns de-serialized version of api server response
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException in case of network errors
   */
  protected <T> T handlePatch(PatchContext patchContext, T current, String patchForUpdate, Class<T> type, boolean status)
      throws InterruptedException, IOException {
    String bodyContentType = getContentTypeFromPatchContextOrDefault(patchContext);
    HttpRequest.Builder requestBuilder = httpClient.newHttpRequestBuilder()
        .patch(bodyContentType, patchForUpdate)
        .url(getResourceURLForPatchOperation(getResourceUrl(checkNamespace(current), checkName(current), status),
            patchContext));
    return handleResponse(requestBuilder, type);
  }

  /**
   * Replace Scale of specified Kubernetes Resource
   *
   * @param resourceUrl Kubernetes resource URL
   * @param scale Scale object which we want to inject
   * @return updated Scale object
   * @throws InterruptedException in case thread is interrupted
   * @throws IOException in some other I/O problem
   */
  protected Scale handleScale(String resourceUrl, Scale scale) throws InterruptedException, IOException {
    HttpRequest.Builder requestBuilder = httpClient.newHttpRequestBuilder().uri(resourceUrl + "/scale");
    if (scale != null) {
      requestBuilder.put(JSON, JSON_MAPPER.writeValueAsString(scale));
    }
    return handleResponse(requestBuilder, Scale.class);
  }

  /**
   * Create rollback of a Deployment
   *
   * @param resourceUrl resource url
   * @param deploymentRollback DeploymentRollback resource
   * @return Status
   * @throws InterruptedException in case thread is interrupted
   * @throws IOException in some other I/O problem
   */
  protected Status handleDeploymentRollback(String resourceUrl, DeploymentRollback deploymentRollback)
      throws InterruptedException, IOException {
    HttpRequest.Builder requestBuilder = httpClient.newHttpRequestBuilder().uri(resourceUrl + "/rollback").post(JSON,
        JSON_MAPPER.writeValueAsString(deploymentRollback));
    return handleResponse(requestBuilder, Status.class);
  }

  /**
   * Send an http get.
   *
   * @param resourceUrl resource URL to be processed
   * @param type type of resource
   * @param <T> template argument provided
   *
   * @return returns a deserialized object as api server response of provided type.
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException
   */
  protected <T> T handleGet(URL resourceUrl, Class<T> type) throws InterruptedException, IOException {
    HttpRequest.Builder requestBuilder = httpClient.newHttpRequestBuilder().url(resourceUrl);
    return handleResponse(requestBuilder, type, getParameters());
  }

  protected Map<String, String> getParameters() {
    return Collections.emptyMap();
  }

  /**
   * Send a raw get - where the type should be one of String, Reader, InputStream
   * <br>
   * NOTE: Currently does not utilize the retry logic
   */
  protected <T> T handleRawGet(URL resourceUrl, Class<T> type) throws IOException {
    HttpRequest.Builder requestBuilder = httpClient.newHttpRequestBuilder().url(resourceUrl);
    HttpRequest request = requestBuilder.build();
    HttpResponse<T> response = waitForResult(httpClient.sendAsync(request, type));
    assertResponseCode(request, response);
    return response.body();
  }

  /**
   * Waits for the provided {@link CompletableFuture} to complete and returns the result in case of success.
   *
   * @param future the CompletableFuture to wait for
   * @param <T> the type of the result
   * @return the result of the completed future
   * @throws IOException in case there's an I/O problem
   */
  protected <T> T waitForResult(CompletableFuture<T> future) throws IOException {
    try {
      // readTimeout should be enforced
      return future.get();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      InterruptedIOException ie = new InterruptedIOException();
      ie.initCause(e);
      throw ie;
    } catch (ExecutionException e) {
      Throwable t = e;
      if (e.getCause() != null) {
        t = e.getCause();
      }
      if (t instanceof IOException) {
        throw (IOException) t;
      }
      if (t instanceof RuntimeException) {
        throw (RuntimeException) t;
      }
      InterruptedIOException ie = new InterruptedIOException();
      ie.initCause(e);
      throw ie;
    }
  }

  /**
   * Send an http request and handle the response.
   *
   * @param requestBuilder Request Builder object
   * @param type type of resource
   * @param <T> template argument provided
   *
   * @return Returns a de-serialized object as api server response of provided type.
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException
   */
  protected <T> T handleResponse(HttpRequest.Builder requestBuilder, Class<T> type) throws InterruptedException, IOException {
    return handleResponse(requestBuilder, type, getParameters());
  }

  /**
   * Send an http request and handle the response, optionally performing placeholder substitution to the response.
   *
   * @param requestBuilder request builder
   * @param type type of object
   * @param parameters a hashmap containing parameters
   * @param <T> template argument provided
   *
   * @return Returns a de-serialized object as api server response of provided type.
   * @throws IOException IOException
   */
  private <T> T handleResponse(HttpRequest.Builder requestBuilder, Class<T> type, Map<String, String> parameters)
      throws IOException {
    return waitForResult(handleResponse(httpClient, requestBuilder, type, parameters));
  }

  /**
   * Send an http request and handle the response, optionally performing placeholder substitution to the response.
   *
   * @param client the client
   * @param requestBuilder Request builder
   * @param type Type of object provided
   * @param parameters A hashmap containing parameters
   * @param <T> Template argument provided
   *
   * @return Returns a de-serialized object as api server response of provided type.
   */
  protected <T> CompletableFuture<T> handleResponse(HttpClient client, HttpRequest.Builder requestBuilder, Class<T> type,
      Map<String, String> parameters) {
    VersionUsageUtils.log(this.resourceT, this.apiGroupVersion);
    HttpRequest request = requestBuilder.build();
    CompletableFuture<HttpResponse<byte[]>> futureResponse = new CompletableFuture<>();
    retryWithExponentialBackoff(futureResponse, new AtomicInteger(), Utils.getNonNullOrElse(client, httpClient), request);

    return futureResponse.thenApply(response -> {
      try {
        assertResponseCode(request, response);
        if (type != null) {
          return Serialization.unmarshal(new ByteArrayInputStream(response.body()), type, parameters);
        } else {
          return null;
        }
      } catch (KubernetesClientException e) {
        throw e;
      } catch (Exception e) {
        throw requestException(request, e);
      }
    });
  }

  protected void retryWithExponentialBackoff(CompletableFuture<HttpResponse<byte[]>> result,
      AtomicInteger numRetries,
      HttpClient client, HttpRequest request) {
    client.sendAsync(request, byte[].class)
        .whenComplete((response, throwable) -> {
          int retries = numRetries.getAndIncrement();
          if (retries < requestRetryBackoffLimit) {
            long retryInterval = retryIntervalCalculator.getInterval(retries);
            boolean retry = false;
            if (response != null && response.code() >= 500) {
              LOG.debug("HTTP operation on url: {} should be retried as the response code was {}, retrying after {} millis",
                  request.uri(), response.code(), retryInterval);
              retry = true;
            } else if (throwable instanceof IOException) {
              LOG.debug(String.format("HTTP operation on url: %s should be retried after %d millis because of IOException",
                  request.uri(), retryInterval), throwable);
              retry = true;
            }
            if (retry) {
              Utils.schedule(context.getExecutor(),
                  () -> retryWithExponentialBackoff(result, numRetries, client, request), retryInterval, TimeUnit.MILLISECONDS);
              return;
            }
          }
          if (throwable != null) {
            result.completeExceptionally(throwable);
          } else {
            result.complete(response);
          }
        });
  }

  /**
   * Checks if the response status code is the expected and throws the appropriate KubernetesClientException if not.
   *
   * @param request The {#link HttpRequest} object.
   * @param response The {@link HttpResponse} object.
   */
  protected void assertResponseCode(HttpRequest request, HttpResponse<?> response) {
    if (response.isSuccessful()) {
      return;
    }

    int statusCode = response.code();
    String customMessage = config.getErrorMessages().get(statusCode);

    if (customMessage != null) {
      throw requestFailure(request, createStatus(statusCode, combineMessages(customMessage, createStatus(response))));
    } else {
      throw requestFailure(request, createStatus(response));
    }
  }

  private String combineMessages(String customMessage, Status defaultStatus) {
    if (defaultStatus != null) {
      String message = defaultStatus.getMessage();
      if (message != null && message.length() > 0) {
        return customMessage + " " + message;
      }
    }
    return customMessage;
  }

  public static Status createStatus(HttpResponse<?> response) {
    String statusMessage = "";
    int statusCode = response != null ? response.code() : 0;
    if (response == null) {
      statusMessage = "No response";
    } else {
      try {
        String bodyString = response.bodyString();
        if (Utils.isNotNullOrEmpty(bodyString)) {
          Status status = JSON_MAPPER.readValue(bodyString, Status.class);
          if (status.getCode() == null) {
            status = new StatusBuilder(status).withCode(statusCode).build();
          }
          return status;
        }
      } catch (IOException e) {
        // ignored
      }
      if (response.message() != null) {
        statusMessage = response.message();
      }
    }
    return createStatus(statusCode, statusMessage);
  }

  public static Status createStatus(int statusCode, String message) {
    Status status = new StatusBuilder()
        .withCode(statusCode)
        .withMessage(message)
        .build();
    status.getAdditionalProperties().put(CLIENT_STATUS_FLAG, "true");
    return status;
  }

  public static KubernetesClientException requestFailure(HttpRequest request, Status status) {
    return requestFailure(request, status, null);
  }

  public static KubernetesClientException requestFailure(HttpRequest request, Status status, String message) {
    StringBuilder sb = new StringBuilder();
    if (message != null && !message.isEmpty()) {
      sb.append(message).append(". ");
    }

    sb.append("Failure executing: ").append(request.method())
        .append(" at: ").append(request.uri()).append(".");

    if (status.getMessage() != null && !status.getMessage().isEmpty()) {
      sb.append(" Message: ").append(status.getMessage()).append(".");
    }

    if (!status.getAdditionalProperties().containsKey(CLIENT_STATUS_FLAG)) {
      sb.append(" Received status: ").append(status).append(".");
    }

    final RequestMetadata metadata = RequestMetadata.from(request);
    return new KubernetesClientException(sb.toString(), status.getCode(), status, metadata.group, metadata.version,
        metadata.plural, metadata.namespace);
  }

  public static KubernetesClientException requestException(HttpRequest request, Throwable e, String message) {
    StringBuilder sb = new StringBuilder();
    if (message != null && !message.isEmpty()) {
      sb.append(message).append(". ");
    }

    sb.append("Error executing: ").append(request.method())
        .append(" at: ").append(request.uri())
        .append(". Cause: ").append(e.getMessage());

    final RequestMetadata metadata = RequestMetadata.from(request);
    return new KubernetesClientException(sb.toString(), e, metadata.group, metadata.version, metadata.plural,
        metadata.namespace);
  }

  public static KubernetesClientException requestException(HttpRequest request, Exception e) {
    return requestException(request, e, null);
  }

  private static class RequestMetadata {
    private final String group;
    private final String version;
    private final String plural;
    private final String namespace;
    private static final RequestMetadata EMPTY = new RequestMetadata(null, null, null, null);

    private RequestMetadata(String group, String version, String plural, String namespace) {
      this.group = group;
      this.version = version;
      this.plural = plural;
      this.namespace = namespace;
    }

    static RequestMetadata from(HttpRequest request) {
      final List<String> segments = Arrays.asList(request.uri().getRawPath().split("\\/"));
      switch (segments.size()) {
        case 4:
          // cluster URL
          return new RequestMetadata(segments.get(1), segments.get(2), segments.get(3), null);
        case 6:
          // namespaced URL
          return new RequestMetadata(segments.get(1), segments.get(2), segments.get(5), segments.get(4));
        default:
          return EMPTY;
      }
    }
  }

  protected static <T> T unmarshal(InputStream is) {
    return Serialization.unmarshal(is);
  }

  protected static <T> T unmarshal(InputStream is, final Class<T> type) {
    return Serialization.unmarshal(is, type);
  }

  protected static <T> T unmarshal(InputStream is, TypeReference<T> type) {
    return Serialization.unmarshal(is, type);
  }

  protected static <T> Map<String, Object> getObjectValueAsMap(T object) {
    return JSON_MAPPER.convertValue(object, new TypeReference<Map<String, Object>>() {
    });
  }

  public Config getConfig() {
    return config;
  }

  private String getContentTypeFromPatchContextOrDefault(PatchContext patchContext) {
    if (patchContext != null && patchContext.getPatchType() != null) {
      return patchContext.getPatchType().getContentType();
    }
    return STRATEGIC_MERGE_JSON_PATCH;
  }

  public <R1> R1 restCall(Class<R1> result, String... path) {
    try {
      URL requestUrl = new URL(config.getMasterUrl());
      String url = requestUrl.toString();
      if (path != null && path.length > 0) {
        url = URLUtils.join(url, URLUtils.pathJoin(path));
      }
      HttpRequest.Builder req = httpClient.newHttpRequestBuilder().uri(url);
      return handleResponse(req, result);
    } catch (KubernetesClientException e) {
      if (e.getCode() != HttpURLConnection.HTTP_NOT_FOUND) {
        throw e;
      }
      return null;
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(ie);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

}
