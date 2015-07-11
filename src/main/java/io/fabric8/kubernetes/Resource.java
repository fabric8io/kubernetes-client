package io.fabric8.kubernetes;

import com.ning.http.client.AsyncHttpClient;
import io.fabric8.common.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;

import java.net.URL;

public class Resource<ResourceListType extends KubernetesResourceList, ResourceType extends HasMetadata, ResourceBuilder extends Builder<ResourceType>>
  extends ResourceList<ResourceListType, ResourceType, ResourceBuilder> {

  public Resource(AsyncHttpClient httpClient, URL rootUrl, String resourceType, Class<ResourceListType> listClazz, Class<ResourceType> clazz, Class<ResourceBuilder> clazzBuilder) {
    super(rootUrl, listClazz, clazz, clazzBuilder, resourceType, httpClient);
  }

  public NamespacedResource<ResourceListType, ResourceType, ResourceBuilder> inNamespace(String namespace) {
    return new NamespacedResource<>(namespace, this);
  }

  public NamedResource<ResourceListType, ResourceType, ResourceBuilder> withName(String resourceName) {
    return new NamedResource<>(resourceName, this);
  }

}
