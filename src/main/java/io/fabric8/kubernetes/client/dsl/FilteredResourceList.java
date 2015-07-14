package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;

import java.util.Map;

public interface FilteredResourceList<T extends HasMetadata, L extends KubernetesResourceList> {

  L list() throws KubernetesClientException;

  void delete() throws KubernetesClientException;

  FilteredResourceList<T, L> withLabels(Map<String, String> labels) throws KubernetesClientException;

  FilteredResourceList<T, L> withLabel(String key, String value) throws KubernetesClientException;

  FilteredResourceList<T, L> withFields(Map<String, String> labels) throws KubernetesClientException;

  FilteredResourceList<T, L> withField(String key, String value) throws KubernetesClientException;

}
