package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;

import java.util.Map;

public interface FilteredNamespacedResourceList<Type extends HasMetadata, TypeList extends KubernetesResourceList> {

  TypeList list() throws KubernetesClientException;

  void delete() throws KubernetesClientException;

  FilteredNamespacedResourceList<Type, TypeList> withLabels(Map<String, String> labels) throws KubernetesClientException;

  FilteredNamespacedResourceList<Type, TypeList> withLabel(String key, String value) throws KubernetesClientException;

  FilteredNamespacedResourceList<Type, TypeList> withFields(Map<String, String> labels) throws KubernetesClientException;

  FilteredNamespacedResourceList<Type, TypeList> withField(String key, String value) throws KubernetesClientException;

}
