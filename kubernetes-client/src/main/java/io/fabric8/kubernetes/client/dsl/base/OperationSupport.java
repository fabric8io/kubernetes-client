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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class OperationSupport {


  public static final MediaType JSON = MediaType.parse("application/json");
  protected static final ObjectMapper JSON_MAPPER = new ObjectMapper();
  protected static final ObjectMapper YAML_MAPPER = new ObjectMapper(new YAMLFactory());
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


  protected <T> void handleDelete(T resource, long gracePeriodSeconds) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    handleDelete(getResourceUrl(checkNamespace(resource), checkName(resource)), gracePeriodSeconds);
  }

  protected void handleDelete(URL requestUrl, long gracePeriodSeconds) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    RequestBody requestBody = null;
    if (gracePeriodSeconds >= 0) {
      DeleteOptions deleteOptions = new DeleteOptions();
      deleteOptions.setGracePeriodSeconds(gracePeriodSeconds);
      requestBody = RequestBody.create(JSON, JSON_MAPPER.writeValueAsString(deleteOptions));
    }

    Request.Builder requestBuilder = new Request.Builder().delete(requestBody).url(requestUrl);
    handleResponse(requestBuilder, 200, null);
  }

  protected <T, I> T handleCreate(I resource, Class<T> outputType) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    RequestBody body = RequestBody.create(JSON, JSON_MAPPER.writeValueAsString(resource));
    Request.Builder requestBuilder = new Request.Builder().post(body).url(getNamespacedUrl(checkNamespace(resource)));
    return handleResponse(requestBuilder, 201, outputType);
  }

  protected <T> T handleReplace(T updated, Class<T> type) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    RequestBody body = RequestBody.create(JSON, JSON_MAPPER.writeValueAsString(updated));
    Request.Builder requestBuilder = new Request.Builder().put(body).url(getResourceUrl(checkNamespace(updated), checkName(updated)));
    return handleResponse(requestBuilder, 200, type);
  }

  protected <T> T handleGet(URL resourceUrl, Class<T> type) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    Request.Builder requestBuilder = new Request.Builder().get().url(resourceUrl);
    return handleResponse(requestBuilder, 200, type);
  }

  protected <T> T handleResponse(Request.Builder requestBuilder, int successStatusCode, Class<T> type) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    Request request = requestBuilder.build();
    Response response = client.newCall(request).execute();
    try (ResponseBody body = response.body()) {
      assertResponseCode(request, response, successStatusCode);
      if (type != null) {
        return JSON_MAPPER.readValue(body.byteStream(), type);
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
   * @param expectedStatusCode The expected status code.
   * @throws KubernetesClientException When the response code is not the expected.
   */
  protected void assertResponseCode(Request request, Response response, int expectedStatusCode) {
    int statusCode = response.code();
    String customMessage = config.getErrorMessages().get(statusCode);

    if (statusCode == expectedStatusCode) {
      return;
    } else if (customMessage != null) {
      throw requestFailure(request, createStatus(statusCode, customMessage));
    } else {
      throw requestFailure(request, createStatus(response));
    }
  }


  public static Status createStatus(Response response) {
    int statusCode = response.code();
    String statusMessage = "";
    ResponseBody body = response != null ? response.body() : null;
    try {
      if (response == null) {
        statusMessage = "No response";
      } else if (body != null) {
        statusMessage = body.string();
      } else if (response.message() != null) {
        statusMessage = response.message();
      }
      return JSON_MAPPER.readValue(statusMessage, Status.class);
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

  KubernetesClientException requestFailure(Request request, Status status) {
    StringBuilder sb = new StringBuilder();
    sb.append("Failure executing: ").append(request.method())
      .append(" at: ").append(request.urlString()).append(".");

    if (status.getMessage() != null && !status.getMessage().isEmpty()) {
      sb.append(" Message: ").append(status.getMessage()).append(".");
    }

    if (status != null && !status.getAdditionalProperties().containsKey(CLIENT_STATUS_FLAG)) {
      sb.append(" Received status: ").append(status).append(".");
    }

    return new KubernetesClientException(sb.toString(), status.getCode(), status);
  }

  KubernetesClientException requestException(Request request, Exception e) {
    StringBuilder sb = new StringBuilder();
    sb.append("Error executing: ").append(request.method())
      .append(" at: ").append(request.urlString())
      .append(". Cause: ").append(e.getMessage());

    return new KubernetesClientException(sb.toString(), e);
  }

  protected static <T> T unmarshal(InputStream is) throws KubernetesClientException {
    try (BufferedInputStream bis = new BufferedInputStream(is)) {
      bis.mark(-1);
      int intch;
      do {
        intch = bis.read();
      } while (intch > -1 && Character.isWhitespace(intch));
      bis.reset();

      ObjectMapper mapper = JSON_MAPPER;
      if (intch != '{') {
        mapper = YAML_MAPPER;
      }
      return mapper.readerFor(KubernetesResource.class).readValue(bis);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

   protected static <T> T unmarshal(InputStream is, Class<T> type) throws KubernetesClientException {
    try (BufferedInputStream bis = new BufferedInputStream(is)) {
      bis.mark(-1);
      int intch;
      do {
        intch = bis.read();
      } while (intch > -1 && Character.isWhitespace(intch));
      bis.reset();

      ObjectMapper mapper = JSON_MAPPER;
      if (intch != '{') {
        mapper = YAML_MAPPER;
      }
      return mapper.readValue(bis, type);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  public Config getConfig() {
    return config;
  }
}
