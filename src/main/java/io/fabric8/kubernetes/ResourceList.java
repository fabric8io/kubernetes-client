package io.fabric8.kubernetes;

import io.fabric8.common.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;

import java.util.Map;

public interface ResourceList<Type extends HasMetadata, TypeList extends KubernetesResourceList, TypeBuilder extends Builder<Type>> {

  TypeList list() throws KubernetesClientException;

  void delete() throws KubernetesClientException;

  FilteredResourceList<Type, TypeList> withLabels(Map<String, String> labels);

  FilteredResourceList<Type, TypeList> withLabel(String key, String value);

  FilteredResourceList<Type, TypeList> withFields(Map<String, String> labels);

  FilteredResourceList<Type, TypeList> withField(String key, String value);

}
