package io.fabric8.kubernetes.client.dsl.internal;

import com.ning.http.client.AsyncHttpClient;
import io.fabric8.kubernetes.client.dsl.ResourceList;
import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.client.dsl.FilteredResourceList;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.dsl.Updateable;

import java.net.URL;
import java.util.Map;

public class DefaultResourceList<T extends HasMetadata, L extends KubernetesResourceList, B extends Builder<T>, U extends Updateable<T>>
  extends BaseResourceList<T, L, B, U>
  implements ResourceList<T, L, B>,
             FilteredResourceList<T, L> {

  public DefaultResourceList(AsyncHttpClient httpClient, URL rootUrl, String resourceT, Class<T> clazz, Class<L> listClazz, Class<B> builderClazz, Class<U> updateableClazz) {
    super(httpClient, rootUrl, resourceT, clazz, listClazz, builderClazz, updateableClazz);
  }

  @Override
  public FilteredResourceList<T, L> withLabels(Map<String, String> labels) {
    getLabels().putAll(labels);
    return this;
  }

  @Override
  public FilteredResourceList<T, L> withLabel(String key, String value) {
    getLabels().put(key, value);
    return this;
  }

  @Override
  public FilteredResourceList<T, L> withFields(Map<String, String> labels) {
    getFields().putAll(labels);
    return this;
  }

  @Override
  public FilteredResourceList<T, L> withField(String key, String value) {
    getFields().put(key, value);
    return this;
  }

}
