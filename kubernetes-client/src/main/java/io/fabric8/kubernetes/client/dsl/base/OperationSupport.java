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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.DeleteOptions;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.internal.VersionUsageUtils;
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

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static io.fabric8.kubernetes.client.internal.PatchUtils.patchMapper;

public class OperationSupport {


  public static final MediaType JSON = MediaType.parse("application/json");
  public static final MediaType JSON_PATCH = MediaType.parse("application/json-patch+json");
  protected static final ObjectMapper JSON_MAPPER = Serialization.jsonMapper();
  protected static final ObjectMapper YAML_MAPPER = Serialization.yamlMapper();
  private static final String CLIENT_STATUS_FLAG = "CLIENT_STATUS_FLAG";

  protected OperationContext context;
  protected final OkHttpClient client;
  protected final Config config;
  protected final String resourceT;
  protected String namespace;
  protected String name;
  protected String apiGroupName;
  protected String apiGroupVersion;

  public OperationSupport() {
    this (new OperationContext());
  }

  public OperationSupport(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public OperationSupport(OkHttpClient client, Config config, String namespace) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config).withNamespace(namespace));
  }

  public OperationSupport(OperationContext ctx) {
    this.context = ctx;
    this.client = ctx.getClient();
    this.config = ctx.getConfig();
    this.resourceT = ctx.getPlural();
    this.namespace = ctx.getNamespace();
    this.name = ctx.getName() ;
    this.apiGroupName = ctx.getApiGroupName();
    if (ctx.getApiGroupVersion() != null) {
      this.apiGroupVersion = ctx.getApiGroupVersion();
    } else if (ctx.getConfig() != null) {
      this.apiGroupVersion = ctx.getConfig().getApiVersion();
    } else {
      this.apiGroupVersion = "v1";
    }
  }

  public String getAPIGroup() {
    return apiGroupName;
  }

  public String getAPIVersion() {
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
    if (name == null) {
      return getNamespacedUrl(namespace);
    }
    return new URL(URLUtils.join(getNamespacedUrl(namespace).toString(), name));
  }

  public URL getResourceUrl() throws MalformedURLException {
    if (name == null) {
      return getNamespacedUrl();
    }
    return new URL(URLUtils.join(getNamespacedUrl().toString(), name));
  }

  protected <T> String checkNamespace(T item) {
    String operationNs = getNamespace();
    String itemNs = (item instanceof HasMetadata && ((HasMetadata)item).getMetadata() != null) ? ((HasMetadata) item).getMetadata().getNamespace() : null;
    if (Utils.isNullOrEmpty(operationNs) && Utils.isNullOrEmpty(itemNs)) {
      if (!isResourceNamespaced()) {
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

  protected <T> String checkName(T item) {
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


  protected <T> void handleDelete(T resource, long gracePeriodSeconds, boolean cascading) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    handleDelete(getResourceUrl(checkNamespace(resource), checkName(resource)), gracePeriodSeconds, cascading);
  }

  protected void handleDelete(URL requestUrl, long gracePeriodSeconds, boolean cascading) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    RequestBody requestBody = null;
    DeleteOptions deleteOptions = new DeleteOptions();
    deleteOptions.setOrphanDependents(!cascading);
    if (gracePeriodSeconds >= 0) {
      deleteOptions.setGracePeriodSeconds(gracePeriodSeconds);
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
   * @throws KubernetesClientException KubernetesClientException
   * @throws IOException IOException
   */
  protected <T, I> T handleCreate(I resource, Class<T> outputType) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    RequestBody body = RequestBody.create(JSON, JSON_MAPPER.writeValueAsString(resource));
    Request.Builder requestBuilder = new Request.Builder().post(body).url(getNamespacedUrl(checkNamespace(resource)));
    return handleResponse(requestBuilder, outputType, Collections.<String, String>emptyMap());
  }


  /**
   * Replace a resource.
   *
   * @param updated updated object
   * @param type type of the object provided
   * @param <T> template argument provided
   *
   * @return returns de-serialized version of api server response
   * @throws ExecutionException Execution Exception
   * @throws InterruptedException Interrupted Exception
   * @throws KubernetesClientException KubernetesClientException
   * @throws IOException IOException
   */
  protected <T> T handleReplace(T updated, Class<T> type) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    return handleReplace(updated, type, Collections.<String, String>emptyMap());
  }

  /**
   * Replace a resource, optionally performing placeholder substitution to the response.
   *
   * @param updated updated object
   * @param type type of object provided
   * @param parameters a HashMap containing parameters for processing object
   * @param <T> template argument provided
   *
   * @return returns de-serialized version of api server response.
   * @throws ExecutionException Execution Exception
   * @throws InterruptedException Interrupted Exception
   * @throws KubernetesClientException KubernetesClientException
   * @throws IOException IOException
   */
  protected <T> T handleReplace(T updated, Class<T> type, Map<String, String> parameters) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    RequestBody body = RequestBody.create(JSON, JSON_MAPPER.writeValueAsString(updated));
    Request.Builder requestBuilder = new Request.Builder().put(body).url(getResourceUrl(checkNamespace(updated), checkName(updated)));
    return handleResponse(requestBuilder, type, parameters);
  }

  /**
   * Send an http patch and handle the response.
   *
   * @param current current object
   * @param updated updated object
   * @param type type of object
   * @param <T> template argument provided
   *
   * @return returns de-serialized version of api server response
   * @throws ExecutionException Execution Exception
   * @throws InterruptedException Interrupted Exception
   * @throws KubernetesClientException KubernetesClientException
   * @throws IOException IOException
   */
  protected <T> T handlePatch(T current, T updated, Class<T> type) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    JsonNode diff = JsonDiff.asJson(patchMapper().valueToTree(current), patchMapper().valueToTree(updated));
    RequestBody body = RequestBody.create(JSON_PATCH, JSON_MAPPER.writeValueAsString(diff));
    Request.Builder requestBuilder = new Request.Builder().patch(body).url(getResourceUrl(checkNamespace(updated), checkName(updated)));
    return handleResponse(requestBuilder, type, Collections.<String, String>emptyMap());
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
   * @throws KubernetesClientException KubernetesClientException
   * @throws IOException IOException
   */
  protected <T> T handleGet(URL resourceUrl, Class<T> type) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
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
   * @throws KubernetesClientException KubernetesClientException
   * @throws IOException IOException
   */
  protected <T> T handleGet(URL resourceUrl, Class<T> type, Map<String, String> parameters) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
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
   * @throws KubernetesClientException KubernetesClientException
   * @throws IOException IOException
   */
  protected <T> T handleResponse(Request.Builder requestBuilder, Class<T> type) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
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
   * @throws KubernetesClientException KubernetesClientException
   * @throws IOException IOException
   */
  protected <T> T handleResponse(Request.Builder requestBuilder, Class<T> type, Map<String, String> parameters) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
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
   * @throws KubernetesClientException KubernetesClientException
   * @throws IOException IOException
   */
  protected <T> T handleResponse(OkHttpClient client, Request.Builder requestBuilder, Class<T> type) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
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
   * @throws KubernetesClientException KubernetesClientException
   * @throws IOException IOException
   */
  protected <T> T handleResponse(OkHttpClient client, Request.Builder requestBuilder, Class<T> type, Map<String, String> parameters) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    VersionUsageUtils.log(this.resourceT, this.apiGroupVersion);
    Request request = requestBuilder.build();
    Response response = client.newCall(request).execute();
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

  /**
   * Checks if the response status code is the expected and throws the appropriate KubernetesClientException if not.
   *
   * @param request            The {#link Request} object.
   * @param response           The {@link Response} object.
   * @throws KubernetesClientException When the response code is not the expected.
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
    } catch (JsonParseException e) {
      return createStatus(statusCode, statusMessage);
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
    StringBuilder sb = new StringBuilder();
    sb.append("Failure executing: ").append(request.method())
      .append(" at: ").append(request.url().toString()).append(".");

    if (status.getMessage() != null && !status.getMessage().isEmpty()) {
      sb.append(" Message: ").append(status.getMessage()).append(".");
    }

    if (status != null && !status.getAdditionalProperties().containsKey(CLIENT_STATUS_FLAG)) {
      sb.append(" Received status: ").append(status).append(".");
    }

    return new KubernetesClientException(sb.toString(), status.getCode(), status);
  }

  public static KubernetesClientException requestException(Request request, Exception e) {
    StringBuilder sb = new StringBuilder();
    sb.append("Error executing: ").append(request.method())
      .append(" at: ").append(request.url().toString())
      .append(". Cause: ").append(e.getMessage());

    return new KubernetesClientException(sb.toString(), e);
  }

  protected static <T> T unmarshal(InputStream is) throws KubernetesClientException {
    return Serialization.unmarshal(is);
  }

  protected static <T> T unmarshal(InputStream is, final Class<T> type) throws KubernetesClientException {
    return Serialization.unmarshal(is, type);
  }

  protected static <T> T unmarshal(InputStream is, TypeReference<T> type) throws KubernetesClientException {
   return Serialization.unmarshal(is, type);
  }

  public Config getConfig() {
    return config;
  }
}
