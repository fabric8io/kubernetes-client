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
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.IOHelpers;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class RawCustomResourceOperationsImpl extends OperationSupport {
  private OkHttpClient client;
  private Config config;
  private CustomResourceDefinitionContext customResourceDefinition;
  private ObjectMapper objectMapper;

  private enum HttpCallMethod { GET, POST, PUT, DELETE };

  public RawCustomResourceOperationsImpl(OkHttpClient client, Config config, CustomResourceDefinitionContext customResourceDefinition) {
    this.client = client;
    this.config = config;
    this.customResourceDefinition = customResourceDefinition;
    this.objectMapper = new ObjectMapper();
  }

  public Map<String, Object> load(InputStream fileInputStream) throws IOException {
    return convertJsonStringToMap(IOHelpers.readFully(fileInputStream));
  }

  public Map<String, Object> load(String objectAsJsonString) throws IOException {
    return convertJsonStringToMap(objectAsJsonString);
  }

  public Map<String, Object> create(String objectAsString) throws IOException {
    return validateAndSubmitRequest(null, null, objectAsString, HttpCallMethod.POST);
  }

  public Map<String, Object> create(Map<String, Object> object) throws KubernetesClientException, IOException {
    return validateAndSubmitRequest(null, null, objectMapper.writeValueAsString(object), HttpCallMethod.POST);
  }

  public Map<String, Object> create(String namespace, String objectAsString) throws KubernetesClientException, IOException {
    return validateAndSubmitRequest(namespace, null, objectAsString, HttpCallMethod.POST);
  }

  public Map<String, Object> create(InputStream objectAsStream) throws KubernetesClientException, IOException {
    return validateAndSubmitRequest(null, null, IOHelpers.readFully(objectAsStream), HttpCallMethod.POST);
  }

  public Map<String, Object> create(String namespace, InputStream objectAsStream) throws KubernetesClientException, IOException {
    return validateAndSubmitRequest(namespace, null, IOHelpers.readFully(objectAsStream), HttpCallMethod.POST);
  }

  public Map<String, Object> create(String namespace, Map<String, Object> object) throws KubernetesClientException, IOException {
    return validateAndSubmitRequest(namespace, null, objectMapper.writeValueAsString(object), HttpCallMethod.POST);
  }

  public Map<String, Object> createOrReplace(String objectAsString) throws IOException {
    return createOrReplaceJsonStringObject(null, objectAsString);
  }

  public Map<String, Object> createOrReplace(Map<String, Object> customResourceObject) throws IOException {
    return createOrReplace(objectMapper.writeValueAsString(customResourceObject));
  }

  public Map<String, Object> createOrReplace(InputStream inputStream) throws IOException {
    return createOrReplace(IOHelpers.readFully(inputStream));
  }

  public Map<String, Object> createOrReplace(String namespace, String objectAsString) throws IOException {
    return createOrReplaceJsonStringObject(namespace, objectAsString);
  }

  public Map<String, Object> createOrReplace(String namespace, Map<String, Object> customResourceObject) throws IOException {
    return createOrReplace(namespace, objectMapper.writeValueAsString(customResourceObject));
  }

  public Map<String, Object> createOrReplace(String namespace, InputStream objectAsString) throws IOException {
    return createOrReplace(namespace, IOHelpers.readFully(objectAsString));
  }

  public Map<String, Object> edit(String name, Map<String, Object> object) throws IOException {
    return validateAndSubmitRequest(null, name, objectMapper.writeValueAsString(object), HttpCallMethod.PUT);
  }

  public Map<String, Object> edit(String name, String objectAsString) throws IOException {
    return validateAndSubmitRequest(null, name, objectAsString, HttpCallMethod.PUT);
  }

  public Map<String, Object> edit(String namespace, String name, Map<String, Object> object) throws IOException {
    return validateAndSubmitRequest(namespace, name, objectMapper.writeValueAsString(object), HttpCallMethod.PUT);
  }

  public Map<String, Object> edit(String namespace, String name, String objectAsString) throws IOException {
    return validateAndSubmitRequest(namespace, name, objectAsString, HttpCallMethod.PUT);
  }

  public Map<String, Object> edit(String name, InputStream objectAsStream) throws IOException, KubernetesClientException {
    return validateAndSubmitRequest(null, name, IOHelpers.readFully(objectAsStream), HttpCallMethod.PUT);
  }

  public Map<String, Object> edit(String namespace, String name, InputStream objectAsStream) throws IOException, KubernetesClientException {
    return validateAndSubmitRequest(namespace, name, IOHelpers.readFully(objectAsStream), HttpCallMethod.PUT);
  }

  public Map<String, Object> get(String name) {
    return makeCall(fetchUrl(null, null) + name, null, HttpCallMethod.GET);
  }

  public Map<String, Object> get(String namespace, String name) {
      return makeCall(fetchUrl(namespace, null) + name, null, HttpCallMethod.GET);
  }

  public Map<String, Object> list() {
    return makeCall(fetchUrl(null, null), null, HttpCallMethod.GET);
  }

  public Map<String, Object> list(String namespace) {
    return makeCall(fetchUrl(namespace, null), null, HttpCallMethod.GET);
  }

  public Map<String, Object> list(String namespace, Map<String, String> labels) {
    return makeCall(fetchUrl(namespace, labels), null, HttpCallMethod.GET);
  }

  public Map<String, Object> delete(String namespace) {
    return makeCall(fetchUrl(namespace, null), null, HttpCallMethod.DELETE);
  }

  public Map<String, Object> delete(String namespace, String name) {
    return makeCall(fetchUrl(namespace, null) + name, null, HttpCallMethod.DELETE);
  }

  private Map<String, Object> createOrReplaceJsonStringObject(String namespace, String objectAsString) throws IOException {
    Map<String, Object> ret;
    try {
      if(namespace != null) {
        ret = create(namespace, objectAsString);
      } else {
        ret = create(objectAsString);
      }
    } catch (KubernetesClientException exception) {
      try {
        Map<String, Object> objectMap = load(objectAsString);
        String name = ((Map<String, Object>) objectMap.get("metadata")).get("name").toString();
        ret =  namespace != null ?
          edit(namespace, name, objectAsString) : edit(name, objectAsString);
      } catch (NullPointerException nullPointerException) {
        throw KubernetesClientException.launderThrowable(new IllegalStateException("Invalid json string provided."));
      }
    }
    return ret;
  }

  private Map<String, Object> convertJsonStringToMap(String objectAsString) throws IOException {
    HashMap<String, Object> retVal = null;
    if (IOHelpers.isJSONValid(objectAsString)) {
      retVal =  objectMapper.readValue(objectAsString, HashMap.class);
    } else {
      retVal = objectMapper.readValue(IOHelpers.convertYamlToJson(objectAsString), HashMap.class);
    }
    return retVal;
  }

  private String fetchUrl(String namespace, Map<String, String> labels) {
    StringBuilder urlBuilder = new StringBuilder(config.getMasterUrl());
    urlBuilder.append("apis/")
      .append(customResourceDefinition.getGroup())
      .append("/")
      .append(customResourceDefinition.getVersion())
      .append("/");

    if(customResourceDefinition.getScope().equals("Namespaced") && namespace != null) {
      urlBuilder.append("namespaces/").append(namespace).append("/");
    }
    urlBuilder.append(customResourceDefinition.getPlural()).append("/");
    if(labels != null) {
      urlBuilder.deleteCharAt(urlBuilder.lastIndexOf("/"));
      urlBuilder.append("?labelSelector").append("=").append(getLabelsQueryParam(labels));
    }
    return urlBuilder.toString();
  }

  private String getLabelsQueryParam(Map<String, String> labels) {
    StringBuilder labelQueryBuilder = new StringBuilder();
    for(Map.Entry<String, String> entry : labels.entrySet()) {
      if(labelQueryBuilder.length() > 0) {
        labelQueryBuilder.append(",");
      }
      labelQueryBuilder.append(entry.getKey()).append(Utils.toUrlEncoded("=")).append(entry.getValue());
    }
    return labelQueryBuilder.toString();
  }

  private Map<String, Object> makeCall(String url, String body, HttpCallMethod callMethod) throws RuntimeException {
    try {
      Response response;
      if(body == null) {
        response = client.newCall(getRequest(url, callMethod)).execute();
      }
      else {
        response = client.newCall(getRequest(url, body, callMethod)).execute();
      }
      if(response.code() != HttpURLConnection.HTTP_NOT_FOUND &&
         response.code() != HttpURLConnection.HTTP_SERVER_ERROR &&
         response.code() != HttpURLConnection.HTTP_BAD_REQUEST) {
        return objectMapper.readValue(response.body().string(), HashMap.class);
      } else {
        if(response.body() != null) {
          throw new KubernetesClientException(response.body().string());
        } else {
          response.close();
          throw new KubernetesClientException(response.message());
        }
      }
    } catch(Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  private Map<String, Object> validateAndSubmitRequest(String namespace, String name, String objectAsString, HttpCallMethod httpCallMethod) throws IOException {
    if (IOHelpers.isJSONValid(objectAsString)) {
      return makeCall(fetchUrl(namespace, null) + (name != null ? name : ""), objectAsString, httpCallMethod);
    } else {
      return makeCall(fetchUrl(namespace, null) + (name != null ? name : ""), IOHelpers.convertYamlToJson(objectAsString), httpCallMethod);
    }
  }

  private Request getRequest(String url, HttpCallMethod httpCallMethod) {
    Request.Builder requestBuilder = new Request.Builder();
    switch(httpCallMethod) {
      case GET:
        requestBuilder.get().url(url);
        break;
      case DELETE:
        requestBuilder.delete().url(url);
        break;
    }

    return requestBuilder.build();
  }

  private Request getRequest(String url, String body, HttpCallMethod httpCallMethod) {
    Request.Builder requestBuilder = new Request.Builder();
    RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), body);
    switch(httpCallMethod) {
      case POST:
        return requestBuilder.post(requestBody).url(url).build();
      case PUT:
        return requestBuilder.put(requestBody).url(url).build();
    }
    return requestBuilder.build();
  }
}
