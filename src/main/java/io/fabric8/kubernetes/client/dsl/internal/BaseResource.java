package io.fabric8.kubernetes.client.dsl.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.dsl.KubernetesClientException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class BaseResource<Type extends HasMetadata, TypeBuilder extends Builder<Type>> {

  protected static final ObjectMapper mapper = new ObjectMapper();

  private URL rootUrl;

  private AsyncHttpClient httpClient;

  private String namespace;
  private String resourceType;

  private Class<Type> clazz;
  private Class<TypeBuilder> builderClazz;

  protected BaseResource(AsyncHttpClient httpClient, URL rootUrl, String resourceType, Class<Type> clazz, Class<TypeBuilder> builderClazz) {
    this.httpClient = httpClient;
    this.rootUrl = rootUrl;
    this.clazz = clazz;
    this.builderClazz = builderClazz;
    this.resourceType = resourceType;
  }

  protected Class<TypeBuilder> getBuilderClazz() {
    return builderClazz;
  }

  protected Class<Type> getClazz() {
    return clazz;
  }

  protected String getResourceType() {
    return resourceType;
  }

  protected String getNamespace() {
    return namespace;
  }

  protected void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  protected AsyncHttpClient getHttpClient() {
    return httpClient;
  }

  protected URL getRootUrl() {
    return rootUrl;
  }

  protected URL getNamespacedUrl() throws MalformedURLException {
    URL requestUrl = getRootUrl();
    if (getNamespace() != null) {
      requestUrl = new URL(requestUrl, "namespaces/" + getNamespace() + "/");
    }
    requestUrl = new URL(requestUrl, resourceType + "/");
    return requestUrl;
  }

  private Type handleResponse(AsyncHttpClient.BoundRequestBuilder requestBuilder, int successStatusCode) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    Future<Response> f = requestBuilder.execute();
    Response r = f.get();
    if (r.getStatusCode() != successStatusCode) {
      Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
      throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
    }
    return mapper.reader(getClazz()).readValue(r.getResponseBodyAsStream());
  }

  protected void handleDelete(URL requestUrl) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().prepareDelete(requestUrl.toString());
    Future<Response> f = requestBuilder.execute();
    Response r = f.get();
    if (r.getStatusCode() != 200) {
      Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
      throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
    }
  }

  protected Type handleCreate(Type resource) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().preparePost(getNamespacedUrl().toString());
    requestBuilder.setBody(mapper.writer().writeValueAsString(resource));
    return handleResponse(requestBuilder, 201);
  }

  protected Type handleUpdate(URL resourceUrl, Type updated) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().preparePut(resourceUrl.toString());
    requestBuilder.setBody(mapper.writer().writeValueAsString(updated));
    return handleResponse(requestBuilder, 200);
  }

  protected Type handleGet(URL resourceUrl) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().prepareGet(resourceUrl.toString());
    return handleResponse(requestBuilder, 200);
  }
}
