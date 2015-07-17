package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;

import java.util.Map;

public interface FilteredNamespacedResourceList<T extends HasMetadata, L extends KubernetesResourceList> {

  L list() throws KubernetesClientException;

  void delete() throws KubernetesClientException;

  FilteredNamespacedResourceList<T, L> withLabels(Map<String, String> labels) throws KubernetesClientException;

  FilteredNamespacedResourceList<T, L> withLabel(String key, String value) throws KubernetesClientException;

  FilteredNamespacedResourceList<T, L> withFields(Map<String, String> labels) throws KubernetesClientException;

  FilteredNamespacedResourceList<T, L> withField(String key, String value) throws KubernetesClientException;

}
