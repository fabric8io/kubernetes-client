package io.fabric8.kubernetes.client.dsl.internal;

import com.ning.http.client.AsyncHttpClient;
import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.dsl.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.NamedResource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class NonNamespacedResourceList<Type extends HasMetadata, TypeList extends KubernetesResourceList, TypeBuilder extends Builder<Type>>
  extends DefaultResourceList<Type, TypeList, TypeBuilder>
  implements io.fabric8.kubernetes.client.dsl.NonNamespacedResourceList<Type, TypeList, TypeBuilder> {

  public NonNamespacedResourceList(AsyncHttpClient httpClient, URL rootUrl, String resourceType, Class<Type> clazz, Class<TypeList> listClazz, Class<TypeBuilder> builderClazz) {
    super(httpClient, rootUrl, resourceType, clazz, listClazz, builderClazz);
  }

  @Override
  public NamedResource<Type, TypeBuilder> withName(String name) throws KubernetesClientException {
    try {
      return new io.fabric8.kubernetes.client.dsl.internal.NamedResource<>(name, this);
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Malformed resource URL", e);
    }
  }

  @Override
  public Type create(Type resource) throws KubernetesClientException {
    try {
      return handleCreate(resource);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw new KubernetesClientException("Unable to create resource", e);
    }
  }

}
