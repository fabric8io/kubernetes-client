package io.fabric8.kubernetes.internal;

import com.ning.http.client.AsyncHttpClient;
import io.fabric8.common.Builder;
import io.fabric8.kubernetes.FilteredResourceList;
import io.fabric8.kubernetes.ResourceList;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;

import java.net.URL;
import java.util.Map;

public class DefaultResourceList<Type extends HasMetadata, TypeList extends KubernetesResourceList, TypeBuilder extends Builder<Type>>
  extends BaseResourceList<Type, TypeList, TypeBuilder>
  implements ResourceList<Type, TypeList, TypeBuilder>,
             FilteredResourceList<Type, TypeList> {

  public DefaultResourceList(AsyncHttpClient httpClient, URL rootUrl, String resourceType, Class<Type> clazz, Class<TypeList> listClazz, Class<TypeBuilder> builderClazz) {
    super(httpClient, rootUrl, resourceType, clazz, listClazz, builderClazz);
  }

  @Override
  public FilteredResourceList<Type, TypeList> withLabels(Map<String, String> labels) {
    getLabels().putAll(labels);
    return this;
  }

  @Override
  public FilteredResourceList<Type, TypeList> withLabel(String key, String value) {
    getLabels().put(key, value);
    return this;
  }

  @Override
  public FilteredResourceList<Type, TypeList> withFields(Map<String, String> labels) {
    getFields().putAll(labels);
    return this;
  }

  @Override
  public FilteredResourceList<Type, TypeList> withField(String key, String value) {
    getFields().put(key, value);
    return this;
  }

}
