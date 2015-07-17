package io.fabric8.kubernetes.client;

import com.ning.http.client.ws.WebSocket;
import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;

import java.util.Map;

public interface NamespacedResourceList<T extends HasMetadata, L extends KubernetesResourceList, B extends Builder<T>, D extends Doneable<T>> {

  L list() throws KubernetesClientException;

  void delete() throws KubernetesClientException;

  T create(T resource) throws KubernetesClientException;

  D createNew() throws KubernetesClientException;

  WebSocket watch(Watcher<T> watcher) throws KubernetesClientException;

  FilteredNamespacedResourceList<T, L> withLabels(Map<String, String> labels) throws KubernetesClientException;

  FilteredNamespacedResourceList<T, L> withLabel(String key, String value) throws KubernetesClientException;

  FilteredNamespacedResourceList<T, L> withFields(Map<String, String> labels) throws KubernetesClientException;

  FilteredNamespacedResourceList<T, L> withField(String key, String value) throws KubernetesClientException;

  NamedNamespacedResource<T, B, D> withName(String name) throws KubernetesClientException;

}
