package io.fabric8.kubernetes.client.dsl.internal;

import com.ning.http.client.AsyncHttpClient;
import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.dsl.NamespacedResourceList;

import java.net.URL;

public class NamespaceAwareResourceList<T extends HasMetadata, L extends KubernetesResourceList, B extends Builder<T>, D extends Doneable<T>>
  extends DefaultResourceList<T, L, B, D>
  implements io.fabric8.kubernetes.client.dsl.NamespaceAwareResourceList<T, L, B, D> {

  public NamespaceAwareResourceList(AsyncHttpClient httpClient, URL rootUrl, String resourceT, Class<T> clazz, Class<L> listClazz, Class<B> builderClazz, Class<D> updateableClazz) {
    super(httpClient, rootUrl, resourceT, clazz, listClazz, builderClazz, updateableClazz);
  }

  @Override
  public NamespacedResourceList<T, L, B, D> inNamespace(String namespace) {
    return new io.fabric8.kubernetes.client.dsl.internal.NamespacedResourceList<>(namespace, this);
  }

}
