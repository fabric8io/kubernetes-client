package io.fabric8.kubernetes.internal;

import com.ning.http.client.AsyncHttpClient;
import io.fabric8.common.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;

import java.net.URL;

public class NamespaceAwareResourceList<Type extends HasMetadata, TypeList extends KubernetesResourceList, TypeBuilder extends Builder<Type>>
  extends DefaultResourceList<Type, TypeList, TypeBuilder>
  implements io.fabric8.kubernetes.NamespaceAwareResourceList<Type, TypeList, TypeBuilder> {

  public NamespaceAwareResourceList(AsyncHttpClient httpClient, URL rootUrl, String resourceType, Class<Type> clazz, Class<TypeList> listClazz, Class<TypeBuilder> builderClazz) {
    super(httpClient, rootUrl, resourceType, clazz, listClazz, builderClazz);
  }

  @Override
  public io.fabric8.kubernetes.NamespacedResourceList<Type, TypeList, TypeBuilder> inNamespace(String namespace) {
    return new NamespacedResourceList<>(namespace, this);
  }

}
