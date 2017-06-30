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

import io.fabric8.kubernetes.client.utils.Serialization;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import io.fabric8.kubernetes.api.model.DeleteOptions;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.zjsonpatch.JsonDiff;

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

  protected final OkHttpClient client;
  protected final Config config;
  protected final String resourceT;
  protected final String namespace;
  protected final String name;
  protected final String apiGroup;
  protected final String apiVersion;

  public OperationSupport() {
    this(null, null, null, null, null, null, null);
  }

  public OperationSupport(OkHttpClient client, ConfigAndApiGroupsInfo configAndApiGroupsInfo, String resourceT, String namespace, String name) {
    this(client, configAndApiGroupsInfo.getConfig(), configAndApiGroupsInfo.getApiGroup(), configAndApiGroupsInfo.getApiGroupVersion(), resourceT, namespace ,name);
  }

  public OperationSupport(OkHttpClient client, Config config, String apiGroup, String apiVersion, String resourceT, String namespace, String name) {
    this.client = client;
    this.config = config;
    this.resourceT = resourceT;
    this.namespace = namespace;
    this.name = name;
    this.apiGroup = apiGroup;
    if (apiVersion != null) {
      this.apiVersion = apiVersion;
    } else if (config != null) {
      this.apiVersion = config.getApiVersion();
    } else {
      this.apiVersion = "v1";
    }
  }

  public String getAPIGroup() {
    return apiGroup;
  }

  public String getAPIVersion() {
    return apiVersion;
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
      if (apiGroup != null) {
        return new URL(URLUtils.join(config.getMasterUrl().toString(), "apis", apiGroup, apiVersion));
      }
      return new URL(URLUtils.join(config.getMasterUrl().toString(), "api", apiVersion));
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
   * @param resource
   * @param outputType
   * @param <T>
   * @param <I>
   * @return
   * @throws ExecutionException
   * @throws InterruptedException
   * @throws KubernetesClientException
     * @throws IOException
     */
  protected <T, I> T handleCreate(I resource, Class<T> outputType) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    RequestBody body = RequestBody.create(JSON, JSON_MAPPER.writeValueAsString(resource));
    Request.Builder requestBuilder = new Request.Builder().post(body).url(getNamespacedUrl(checkNamespace(resource)));
    return handleResponse(requestBuilder, outputType, Collections.<String, String>emptyMap());
  }


  /**
   * Replace a resource.
   * @param updated
   * @param type
   * @param <T>
   * @return
   * @throws ExecutionException
   * @throws InterruptedException
   * @throws KubernetesClientException
   * @throws IOException
   */
  protected <T> T handleReplace(T updated, Class<T> type) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    return handleReplace(updated, type, Collections.<String, String>emptyMap());
  }

  /**
   * Replace a resource, optionally performing placeholder substitution to the response.
   * @param updated
   * @param type
   * @param parameters
   * @param <T>
   * @return
   * @throws ExecutionException
   * @throws InterruptedException
   * @throws KubernetesClientException
     * @throws IOException
     */
  protected <T> T handleReplace(T updated, Class<T> type, Map<String, String> parameters) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    RequestBody body = RequestBody.create(JSON, JSON_MAPPER.writeValueAsString(updated));
    Request.Builder requestBuilder = new Request.Builder().put(body).url(getResourceUrl(checkNamespace(updated), checkName(updated)));
    return handleResponse(requestBuilder, type, parameters);
  }

  /**
   * Send an http patch and handle the response.
   * @param current
   * @param updated
   * @param type
   * @param <T>
   * @return
   * @throws ExecutionException
   * @throws InterruptedException
   * @throws KubernetesClientException
     * @throws IOException
     */
  protected <T> T handlePatch(T current, T updated, Class<T> type) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    JsonNode diff = JsonDiff.asJson(patchMapper().valueToTree(current), patchMapper().valueToTree(updated));
    RequestBody body = RequestBody.create(JSON_PATCH, JSON_MAPPER.writeValueAsString(diff));
    Request.Builder requestBuilder = new Request.Builder().patch(body).url(getResourceUrl(checkNamespace(updated), checkName(updated)));
    return handleResponse(requestBuilder, type, Collections.<String, String>emptyMap());
  }


  /**
   * Send an http get.
   * @param resourceUrl
   * @param type
   * @param <T>
   * @return
   * @throws ExecutionException
   * @throws InterruptedException
   * @throws KubernetesClientException
   * @throws IOException
   */
  protected <T> T handleGet(URL resourceUrl, Class<T> type) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    return handleGet(resourceUrl, type, Collections.<String, String>emptyMap());
  }

  /**
   * Send an http, optionally performing placeholder substitution to the response.
   * @param resourceUrl
   * @param type
   * @param parameters
   * @param <T>
   * @return
   * @throws ExecutionException
   * @throws InterruptedException
   * @throws KubernetesClientException
     * @throws IOException
     */
  protected <T> T handleGet(URL resourceUrl, Class<T> type, Map<String, String> parameters) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    Request.Builder requestBuilder = new Request.Builder().get().url(resourceUrl);
    return handleResponse(requestBuilder, type, parameters);
  }

  /**
   * Send an http request and handle the response.
   * @param requestBuilder
   * @param type
   * @param <T>
   * @return
   * @throws ExecutionException
   * @throws InterruptedException
   * @throws KubernetesClientException
   * @throws IOException
   */
  protected <T> T handleResponse(Request.Builder requestBuilder, Class<T> type) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    return handleResponse(requestBuilder, type, Collections.<String, String>emptyMap());
  }

  /**
   * Send an http request and handle the response, optionally performing placeholder substitution to the response.
   * @param requestBuilder
   * @param type
   * @param parameters
   * @param <T>
   * @return
   * @throws ExecutionException
   * @throws InterruptedException
   * @throws KubernetesClientException
   * @throws IOException
   */
  protected <T> T handleResponse(Request.Builder requestBuilder, Class<T> type, Map<String, String> parameters) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    return handleResponse(client, requestBuilder, type, parameters);
  }

  /**
   * Send an http request and handle the response.
   * @param client
   * @param requestBuilder
   * @param type
   * @param <T>
   * @return
   * @throws ExecutionException
   * @throws InterruptedException
   * @throws KubernetesClientException
   * @throws IOException
   */
  protected <T> T handleResponse(OkHttpClient client, Request.Builder requestBuilder, Class<T> type) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    return handleResponse(client, requestBuilder, type, Collections.<String, String>emptyMap());
  }

  /**
   * Send an http request and handle the response, optionally performing placeholder substitution to the response.
   * @param client
   * @param requestBuilder
   * @param type
   * @param parameters
   * @param <T>
   * @return
   * @throws ExecutionException
   * @throws InterruptedException
   * @throws KubernetesClientException
   * @throws IOException
   */
  protected <T> T handleResponse(OkHttpClient client, Request.Builder requestBuilder, Class<T> type, Map<String, String> parameters) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    Request request = requestBuilder.build();
    Response response = client.newCall(request).execute();
    try (ResponseBody body = response.body()) {
      assertResponseCode(request, response);
      if (type != null) {
        return Serialization.unmarshal(body.byteStream(), type, parameters);
      } else {
        return null;
      }
    } catch (Exception e) {
      if (e instanceof KubernetesClientException) {
        throw e;
      }
      throw requestException(request, e);
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
