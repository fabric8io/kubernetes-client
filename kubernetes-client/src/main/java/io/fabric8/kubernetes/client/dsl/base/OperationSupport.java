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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.DeleteOptions;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Preconditions;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.autoscaling.v1.Scale;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollback;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.internal.VersionUsageUtils;
import io.fabric8.kubernetes.client.utils.ExponentialBackoffIntervalCalculator;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.zjsonpatch.JsonDiff;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static io.fabric8.kubernetes.client.internal.PatchUtils.patchMapper;

public class OperationSupport {

  public static final MediaType JSON = MediaType.parse("application/json");
  public static final MediaType JSON_PATCH = MediaType.parse("application/json-patch+json");
  public static final MediaType STRATEGIC_MERGE_JSON_PATCH = MediaType.parse("application/strategic-merge-patch+json");
  public static final MediaType JSON_MERGE_PATCH = MediaType.parse("application/merge-patch+json");
  protected static final ObjectMapper JSON_MAPPER = Serialization.jsonMapper();
  protected static final ObjectMapper YAML_MAPPER = Serialization.yamlMapper();
  private static final Logger LOG = LoggerFactory.getLogger(OperationSupport.class);
  private static final String CLIENT_STATUS_FLAG = "CLIENT_STATUS_FLAG";
  private static final int maxRetryIntervalExponent = 5;

  protected OperationContext context;
  protected final OkHttpClient client;
  protected final Config config;
  protected final String resourceT;
  protected String namespace;
  protected String name;
  protected String apiGroupName;
  protected String apiGroupVersion;
  protected boolean dryRun;
  private final ExponentialBackoffIntervalCalculator retryIntervalCalculator;
  private final int requestRetryBackoffLimit;

  public OperationSupport() {
    this (new OperationContext());
  }

  public OperationSupport(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public OperationSupport(OkHttpClient client, Config config, String namespace, DeletionPropagation propagationPolicy, long gracePeriodInSeconds) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config).withNamespace(namespace).withPropagationPolicy(propagationPolicy).withGracePeriodSeconds(gracePeriodInSeconds));
  }

  public OperationSupport(OperationContext ctx) {
    this.context = ctx;
    this.client = ctx.getClient();
    this.config = ctx.getConfig();
    this.resourceT = ctx.getPlural();
    this.namespace = ctx.getNamespace();
    this.name = ctx.getName() ;
    this.apiGroupName = ctx.getApiGroupName();
    this.dryRun = ctx.getDryRun();
    if (ctx.getApiGroupVersion() != null) {
      this.apiGroupVersion = ctx.getApiGroupVersion();
    } else if (ctx.getConfig() != null) {
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
    this.retryIntervalCalculator = new ExponentialBackoffIntervalCalculator(requestRetryBackoffInterval, maxRetryIntervalExponent);
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
        return new URL(URLUtils.join(config.getMasterUrl().toString(), "apis", apiGroupName, apiGroupVersion));
      }
      return new URL(URLUtils.join(config.getMasterUrl().toString(), "api", apiGroupVersion));
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

  public <T> URL getNamespacedUrl(T item) throws MalformedURLException {
    return getNamespacedUrl(checkNamespace(item));
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
      if (patchContext.getFieldManager() != null) {
        url = URLUtils.join(url, "?fieldManager=" + patchContext.getFieldManager());
      }
      return new URL(url);
    }
    return resourceUrl;
  }

  protected <T> String checkNamespace(T item) {
    String operationNs = getNamespace();
    String itemNs = (item instanceof HasMetadata) ? KubernetesResourceUtil.getNamespace((HasMetadata)item) : null;
    if (Utils.isNullOrEmpty(operationNs) && Utils.isNullOrEmpty(itemNs)) {
      if (!isResourceNamespaced()) {
        return null;
      } else {
        throw new KubernetesClientException("namespace not specified for an operation requiring one.");
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
    } else if (itemName.equals(operationName)) {
      return itemName;
    }
    throw new KubernetesClientException("Name mismatch. Item name:" + itemName + ". Operation name:" + operationName + ".");
  }

  protected <T> T handleMetric(String resourceUrl, Class<T> type) throws InterruptedException, IOException, ExecutionException {
      Request.Builder requestBuilder = new Request.Builder()
        .get()
        .url(resourceUrl);
      return handleResponse(requestBuilder, type);
  }

  protected <T> void handleDelete(T resource, long gracePeriodSeconds, DeletionPropagation propagationPolicy, String resourceVersion, boolean cascading) throws ExecutionException, InterruptedException, IOException {
    handleDelete(getResourceURLForWriteOperation(getResourceUrl(checkNamespace(resource), checkName(resource))), gracePeriodSeconds, propagationPolicy, resourceVersion, cascading);
  }

  protected void handleDelete(URL requestUrl, long gracePeriodSeconds, DeletionPropagation propagationPolicy, String resourceVersion, boolean cascading) throws ExecutionException, InterruptedException, IOException {
    RequestBody requestBody = null;
    DeleteOptions deleteOptions = new DeleteOptions();
    if (gracePeriodSeconds >= 0) {
      deleteOptions.setGracePeriodSeconds(gracePeriodSeconds);
    }
    if (resourceVersion != null) {
      deleteOptions.setPreconditions(new Preconditions(resourceVersion, null));
    }
    /*
     * Either the propagation policy or the orphan dependent (deprecated) property must be set, but not both.
     */
    if (propagationPolicy != null) {
      deleteOptions.setPropagationPolicy(propagationPolicy.toString());
    } else {
      deleteOptions.setOrphanDependents(!cascading);
    }

    if (dryRun) {
      deleteOptions.setDryRun(Collections.singletonList("All"));
    }
    requestBody = RequestBody.create(JSON, JSON_MAPPER.writeValueAsString(deleteOptions));

    Request.Builder requestBuilder = new Request.Builder().delete(requestBody).url(requestUrl);
    handleResponse(requestBuilder, null, Collections.<String, String>emptyMap());
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
   * @throws ExecutionException Execution Exception
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException
   */
  protected <T, I> T handleCreate(I resource, Class<T> outputType) throws ExecutionException, InterruptedException, IOException {
    RequestBody body = RequestBody.create(JSON, JSON_MAPPER.writeValueAsString(resource));
    Request.Builder requestBuilder = new Request.Builder().post(body).url(getResourceURLForWriteOperation(getResourceUrl(checkNamespace(resource), null)));
    return handleResponse(requestBuilder, outputType, Collections.<String, String>emptyMap());
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
   * @throws ExecutionException Execution Exception
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException
   */
  protected <T> T handleUpdate(T updated, Class<T> type, boolean status) throws ExecutionException, InterruptedException, IOException {
    return handleUpdate(updated, type, Collections.<String, String>emptyMap(), status);
  }

  /**
   * Update a resource, optionally performing placeholder substitution to the response.
   *
   * @param updated updated object
   * @param type type of object provided
   * @param parameters a HashMap containing parameters for processing object
   * @param status if this is only the status subresource
   * @param <T> template argument provided
   *
   * @return returns de-serialized version of api server response.
   * @throws ExecutionException Execution Exception
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException
   */
  protected <T> T handleUpdate(T updated, Class<T> type, Map<String, String> parameters, boolean status) throws ExecutionException, InterruptedException, IOException {
    RequestBody body = RequestBody.create(JSON, JSON_MAPPER.writeValueAsString(updated));
    Request.Builder requestBuilder = new Request.Builder().put(body).url(getResourceURLForWriteOperation(getResourceUrl(checkNamespace(updated), checkName(updated), status)));
    return handleResponse(requestBuilder, type, parameters);
  }

  /**
   * Send an http patch and handle the response.
   * 
   * If current is not null and patchContext does not specify a patch type, then a JSON patch is assumed.  Otherwise a STRATEGIC MERGE is assumed.
   *
   * @param patchContext patch options for patch request
   * @param current current object
   * @param updated updated object
   * @param type type of object
   * @param status if this is only the status subresource
   * @param <T> template argument provided
   *
   * @return returns de-serialized version of api server response
   * @throws ExecutionException Execution Exception
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException
   */
  protected <T> T handlePatch(PatchContext patchContext, T current, T updated, Class<T> type, boolean status) throws ExecutionException, InterruptedException, IOException {
    String patchForUpdate = null;
    if (current != null && (patchContext == null || patchContext.getPatchType() == PatchType.JSON)) {
      patchForUpdate = JSON_MAPPER.writeValueAsString(JsonDiff.asJson(patchMapper().valueToTree(current), patchMapper().valueToTree(updated)));
      if (patchContext == null) {
        patchContext = new PatchContext.Builder().withPatchType(PatchType.JSON).build();
      }
    } else {
      patchForUpdate = Serialization.asJson(updated);
      current = updated; // use the updated to determine the path
    }
    return handlePatch(patchContext, current, patchForUpdate, type, status);
  }

  /**
   * Send an http patch and handle the response.
   *
   * @param current current object
   * @param patchForUpdate updated object spec as json string
   * @param type type of object
   * @param <T> template argument provided
   *
   * @return returns de-serialized version of api server response
   * @throws ExecutionException Execution Exception
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException
   */
  protected <T> T handlePatch(T current, Map<String, Object> patchForUpdate, Class<T> type) throws ExecutionException, InterruptedException, IOException {
    return handlePatch(new PatchContext.Builder().withPatchType(PatchType.STRATEGIC_MERGE).build(), current,
        JSON_MAPPER.writeValueAsString(patchForUpdate), type, false);
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
   * @throws ExecutionException Execution Exception
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException in case of network errors
   */
  protected <T> T handlePatch(PatchContext patchContext, T current, String patchForUpdate, Class<T> type, boolean status) throws ExecutionException, InterruptedException, IOException {
    MediaType bodyMediaType = getMediaTypeFromPatchContextOrDefault(patchContext);
    RequestBody body = RequestBody.create(bodyMediaType, patchForUpdate);
    Request.Builder requestBuilder = new Request.Builder().patch(body).url(getResourceURLForPatchOperation(getResourceUrl(checkNamespace(current), checkName(current), status), patchContext));
    return handleResponse(requestBuilder, type, Collections.emptyMap());
  }

  /**
   * Replace Scale of specified Kubernetes Resource
   *
   * @param resourceUrl Kubernetes resource URL
   * @param scale Scale object which we want to inject
   * @return updated Scale object
   * @throws ExecutionException in case of any execution exception
   * @throws InterruptedException in case thread is interrupted
   * @throws IOException in some other I/O problem
   */
  protected Scale handleScale(String resourceUrl, Scale scale) throws ExecutionException, InterruptedException, IOException {
    Request.Builder requestBuilder;
    if (scale != null) {
      RequestBody body = RequestBody.create(JSON, JSON_MAPPER.writeValueAsString(scale));
      requestBuilder = new Request.Builder().put(body).url(resourceUrl + "/scale");
    } else {
      requestBuilder = new Request.Builder().get().url(resourceUrl + "/scale");
    }
    return handleResponse(requestBuilder, Scale.class);
  }

  /**
   * Create rollback of a Deployment
   *
   * @param resourceUrl resource url
   * @param deploymentRollback DeploymentRollback resource
   * @return Status
   * @throws ExecutionException in case of any execution exception
   * @throws InterruptedException in case thread is interrupted
   * @throws IOException in some other I/O problem
   */
  protected Status handleDeploymentRollback(String resourceUrl, DeploymentRollback deploymentRollback) throws ExecutionException, InterruptedException, IOException {
    RequestBody body = RequestBody.create(JSON, JSON_MAPPER.writeValueAsString(deploymentRollback));
    Request.Builder requestBuilder = new Request.Builder().post(body).url(resourceUrl + "/rollback");
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
   * @throws ExecutionException Execution Exception
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException
   */
  protected <T> T handleGet(URL resourceUrl, Class<T> type) throws ExecutionException, InterruptedException, IOException {
    return handleGet(resourceUrl, type, Collections.<String, String>emptyMap());
  }

  /**
   * Send an http, optionally performing placeholder substitution to the response.
   *
   * @param resourceUrl resource URL to be processed
   * @param type type of resource
   * @param parameters A HashMap of strings containing parameters to be passed in request
   * @param <T> template argument provided
   *
   * @return Returns a deserialized object as api server response of provided type.
   * @throws ExecutionException Execution Exception
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException
   */
  protected <T> T handleGet(URL resourceUrl, Class<T> type, Map<String, String> parameters) throws ExecutionException, InterruptedException, IOException {
    Request.Builder requestBuilder = new Request.Builder().get().url(resourceUrl);
    return handleResponse(requestBuilder, type, parameters);
  }

  /**
   * Send an http request and handle the response.
   *
   * @param requestBuilder Request Builder object
   * @param type type of resource
   * @param <T> template argument provided
   *
   * @return Returns a de-serialized object as api server response of provided type.
   * @throws ExecutionException Execution Exception
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException
   */
  protected <T> T handleResponse(Request.Builder requestBuilder, Class<T> type) throws ExecutionException, InterruptedException, IOException {
    return handleResponse(requestBuilder, type, Collections.<String, String>emptyMap());
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
   * @throws ExecutionException Execution Exception
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException
   */
  protected <T> T handleResponse(Request.Builder requestBuilder, Class<T> type, Map<String, String> parameters) throws ExecutionException, InterruptedException, IOException {
    return handleResponse(client, requestBuilder, type, parameters);
  }

  /**
   * Send an http request and handle the response.
   *
   * @param client OkHttp client object
   * @param requestBuilder request builder
   * @param type type of object
   * @param <T> template argument provided
   *
   * @return Returns a de-serialized object as api server response of provided type.
   * @throws ExecutionException Execution Exception
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException
   */
  protected <T> T handleResponse(OkHttpClient client, Request.Builder requestBuilder, Class<T> type) throws ExecutionException, InterruptedException, IOException {
    return handleResponse(client, requestBuilder, type, Collections.<String, String>emptyMap());
  }

  /**
   * Send an http request and handle the response, optionally performing placeholder substitution to the response.
   *
   * @param client               OkHttp client provided
   * @param requestBuilder       Request builder
   * @param type                 Type of object provided
   * @param parameters           A hashmap containing parameters
   * @param <T>                  Template argument provided
   *
   * @return                      Returns a de-serialized object as api server response of provided type.
   * @throws ExecutionException   Execution Exception
   * @throws InterruptedException Interrupted Exception
   * @throws IOException IOException
   */
  protected <T> T handleResponse(OkHttpClient client, Request.Builder requestBuilder, Class<T> type, Map<String, String> parameters) throws ExecutionException, InterruptedException, IOException {
    VersionUsageUtils.log(this.resourceT, this.apiGroupVersion);
    Request request = requestBuilder.build();
    Response response = retryWithExponentialBackoff(client, request);
    try (ResponseBody body = response.body()) {
      assertResponseCode(request, response);
      if (type != null) {
        try (InputStream bodyInputStream = body.byteStream()) {
          return Serialization.unmarshal(bodyInputStream, type, parameters);
        }
      } else {
        return null;
      }
    } catch (Exception e) {
      if (e instanceof KubernetesClientException) {
        throw e;
      }
      throw requestException(request, e);
    } finally {
      if(response != null && response.body() != null) {
        response.body().close();
      }
    }
  }

  protected Response retryWithExponentialBackoff(OkHttpClient client, Request request) throws InterruptedException, IOException {
    int numRetries = 0;
    long retryInterval;
    while (true) {
      try {
        Response response = client.newCall(request).execute();
        if (numRetries < requestRetryBackoffLimit && response.code() >= 500) {
          retryInterval = retryIntervalCalculator.getInterval(numRetries);
          LOG.debug("HTTP operation on url: {} should be retried as the response code was {}, retrying after {} millis", request.url(), response.code(), retryInterval);
          if (response.body() != null) {
            response.body().close();
          }
        } else {
          return response;
        }
      } catch (IOException ie) {
        if (numRetries < requestRetryBackoffLimit) {
          retryInterval = retryIntervalCalculator.getInterval(numRetries);
          LOG.debug(String.format("HTTP operation on url: %s should be retried after %d millis because of IOException", request.url(), retryInterval), ie);
        } else {
          throw ie;
        }
      }
      Thread.sleep(retryInterval);
      numRetries++;
    }
  }

  /**
   * Checks if the response status code is the expected and throws the appropriate KubernetesClientException if not.
   *
   * @param request            The {#link Request} object.
   * @param response           The {@link Response} object.
   */
  protected void assertResponseCode(Request request, Response response) {
    int statusCode = response.code();
    String customMessage = config.getErrorMessages().get(statusCode);

    if (response.isSuccessful()) {
      return;
    } else if (customMessage != null) {
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


  public static Status createStatus(Response response) {
    String statusMessage = "";
    ResponseBody body = response != null ? response.body() : null;
    int statusCode = response != null ? response.code() : 0;
    try {
      if (response == null) {
        statusMessage = "No response";
      } else if (body != null) {
        statusMessage = body.string();
      } else if (response.message() != null) {
        statusMessage = response.message();
      }
      Status status = JSON_MAPPER.readValue(statusMessage, Status.class);
      if (status.getCode() == null) {
        status = new StatusBuilder(status).withCode(statusCode).build();
      }
      return status;
    } catch (IOException e) {
      return createStatus(statusCode, statusMessage);
    }
  }

  public static Status createStatus(int statusCode, String message) {
    Status status = new StatusBuilder()
            .withCode(statusCode)
            .withMessage(message)
            .build();
    status.getAdditionalProperties().put(CLIENT_STATUS_FLAG, "true");
    return status;
  }

  public static KubernetesClientException requestFailure(Request request, Status status) {
    return requestFailure(request, status, null);
  }

  public static KubernetesClientException requestFailure(Request request, Status status, String message) {
    StringBuilder sb = new StringBuilder();
    if(message != null && !message.isEmpty()) {
      sb.append(message).append(". ");
    }
    
    sb.append("Failure executing: ").append(request.method())
      .append(" at: ").append(request.url()).append(".");

    if (status.getMessage() != null && !status.getMessage().isEmpty()) {
      sb.append(" Message: ").append(status.getMessage()).append(".");
    }

    if (!status.getAdditionalProperties().containsKey(CLIENT_STATUS_FLAG)) {
      sb.append(" Received status: ").append(status).append(".");
    }

    final RequestMetadata metadata = RequestMetadata.from(request);
    return new KubernetesClientException(sb.toString(), status.getCode(), status, metadata.group, metadata.version, metadata.plural, metadata.namespace);
  }

  public static KubernetesClientException requestException(Request request, Throwable e, String message) {
    StringBuilder sb = new StringBuilder();
    if (message != null && !message.isEmpty()) {
      sb.append(message).append(". ");
    }
    
    sb.append("Error executing: ").append(request.method())
      .append(" at: ").append(request.url())
      .append(". Cause: ").append(e.getMessage());

    final RequestMetadata metadata = RequestMetadata.from(request);
    return new KubernetesClientException(sb.toString(), e, metadata.group, metadata.version, metadata.plural, metadata.namespace);
  }

  public static KubernetesClientException requestException(Request request, Exception e) {
    return requestException(request, e, null);
  }
  
  private static class RequestMetadata {
    private final String group;
    private final String version;
    private final String plural;
    private final String namespace;
    private final static RequestMetadata EMPTY = new RequestMetadata(null, null, null, null);

    private RequestMetadata(String group, String version, String plural, String namespace) {
      this.group = group;
      this.version = version;
      this.plural = plural;
      this.namespace = namespace;
    }

    static RequestMetadata from(Request request) {
      final List<String> segments = request.url().pathSegments();
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

  protected static <T> Map getObjectValueAsMap(T object) {
    return JSON_MAPPER.convertValue(object, Map.class);
  }

  public Config getConfig() {
    return config;
  }

  private MediaType getMediaTypeFromPatchContextOrDefault(PatchContext patchContext) {
    if (patchContext != null && patchContext.getPatchType() != null) {
      return patchContext.getPatchType().getMediaType();
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
      Request.Builder req = new Request.Builder().get().url(url);
      return handleResponse(req, result);
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
  
}
