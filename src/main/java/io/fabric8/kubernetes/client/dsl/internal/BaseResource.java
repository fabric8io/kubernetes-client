package io.fabric8.kubernetes.client.dsl.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;
import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;

import java.net.URL;

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

  protected AsyncHttpClient getHttpClient() {
    return httpClient;
  }

  protected URL getRootUrl() {
    return rootUrl;
  }

  protected void setNamespace(String namespace) {
    this.namespace = namespace;
  }
}
