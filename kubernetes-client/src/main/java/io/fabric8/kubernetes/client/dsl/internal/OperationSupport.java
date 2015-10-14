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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.internal.URLUtils;
import io.fabric8.kubernetes.client.internal.Utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class OperationSupport<C extends Client> {

  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  final C client;
  final String resourceT;
  final String namespace;
  final String name;


  public OperationSupport(C client, String resourceT, String namespace, String name) {
    this.client = client;
    this.resourceT = resourceT;
    this.namespace = namespace;
    this.name = name;
  }


  public C getClient() {
    return client;
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

  public boolean isNamespaceRequired() {
    return false;
  }

  public URL getRootUrl() {
    try {
      return new URL(URLUtils.join(client.getMasterUrl().toString(), "api", client.getApiVersion()));
    } catch (MalformedURLException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  protected URL getNamespacedUrl(String namespace) throws MalformedURLException {
    URL requestUrl = getRootUrl();
    if (namespace != null) {
      requestUrl = new URL(URLUtils.join(requestUrl.toString(), "namespaces", namespace));
    }
    requestUrl = new URL(URLUtils.join(requestUrl.toString(), resourceT));
    return requestUrl;
  }

  protected URL getNamespacedUrl() throws MalformedURLException {
    return getNamespacedUrl(getNamespace());
  }

  protected URL getResourceUrl(String namespace, String name) throws MalformedURLException {
    if (name == null) {
      return getNamespacedUrl(namespace);
    }
    return new URL(URLUtils.join(getNamespacedUrl(namespace).toString(), name));
  }

  protected URL getResourceUrl() throws MalformedURLException {
    if (name == null) {
      return getNamespacedUrl();
    }
    return new URL(URLUtils.join(getNamespacedUrl().toString(), name));
  }

  protected <T> String checkNamespace(T item) {
    String operationNs = getNamespace();
    String itemNs = item instanceof HasMetadata ? ((HasMetadata) item).getMetadata().getNamespace() : null;
    if (Utils.isNullOrEmpty(operationNs) && Utils.isNullOrEmpty(itemNs)) {
      if (!isNamespaceRequired()) {
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


  protected <T> void handleDelete(T resource) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    handleDelete(getResourceUrl(checkNamespace(resource), checkName(resource)));
  }

  protected void handleDelete(URL requestUrl) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().prepareDelete(requestUrl.toString());
    Future<Response> f = requestBuilder.execute();
    Response r = f.get();
    assertResponseCode(r, 200);
  }

  protected <T,I> T handleCreate(I resource, Class<T> outputType) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().preparePost(getNamespacedUrl(checkNamespace(resource)).toString());
    requestBuilder.setBody(OBJECT_MAPPER.writer().writeValueAsString(resource));
    return handleResponse(requestBuilder, 201, outputType);
  }

  protected <T> T handleReplace(T updated, Class<T> type) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().preparePut(getResourceUrl(checkNamespace(updated), checkName(updated)).toString());
    requestBuilder.setBody(OBJECT_MAPPER.writer().writeValueAsString(updated));
    return handleResponse(requestBuilder, 200, type);
  }

  protected <T> T handleGet(URL resourceUrl, Class<T> type) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().prepareGet(resourceUrl.toString());
    return handleResponse(requestBuilder, 200, type);
  }

  protected <T> T handleResponse(AsyncHttpClient.BoundRequestBuilder requestBuilder, int successStatusCode, Class<T> type) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    Future<Response> f = requestBuilder.execute();
    Response r = f.get();
    assertResponseCode(r, successStatusCode);
    return OBJECT_MAPPER.readValue(r.getResponseBodyAsStream(), type);
  }

  /**
   * Checks if the response status code is the expected and throws the appropriate KubernetesClientException if not.
   *
   * @param r                  The {@link com.ning.http.client.Response} object.
   * @param expectedStatusCode The expected status code.
   * @throws KubernetesClientException When the response code is not the expected.
   */
  protected void assertResponseCode(Response r, int expectedStatusCode) {
    int statusCode = r.getStatusCode();
    String customMessage = client.getConfiguration().getErrorMessages().get(statusCode);

    if (statusCode == expectedStatusCode) {
      return;
    } else if (customMessage != null) {
      throw new KubernetesClientException("Error accessing: " + r.getUri().toString() + ",due to:" + customMessage);
    } else {
      try {
        Status status = OBJECT_MAPPER.readValue(r.getResponseBodyAsStream(), Status.class);
        throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
      } catch (IOException e) {
        throw new KubernetesClientException(e.getMessage(), statusCode, new StatusBuilder()
          .withCode(statusCode)
          .withMessage(e.getMessage())
          .build());
      }
    }
  }

}
