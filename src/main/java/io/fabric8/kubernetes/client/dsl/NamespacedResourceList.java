package io.fabric8.kubernetes.client.dsl;

import com.ning.http.client.ws.WebSocket;
import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;

import java.util.Map;

public interface NamespacedResourceList<Type extends HasMetadata, TypeList extends KubernetesResourceList, TypeBuilder extends Builder<Type>> {

  TypeList list() throws KubernetesClientException;

  void delete() throws KubernetesClientException;

  Type create(Type resource) throws KubernetesClientException;

  WebSocket watch(Watcher<Type> watcher) throws KubernetesClientException;

  FilteredNamespacedResourceList<Type, TypeList> withLabels(Map<String, String> labels) throws KubernetesClientException;

  FilteredNamespacedResourceList<Type, TypeList> withLabel(String key, String value) throws KubernetesClientException;

  FilteredNamespacedResourceList<Type, TypeList> withFields(Map<String, String> labels) throws KubernetesClientException;

  FilteredNamespacedResourceList<Type, TypeList> withField(String key, String value) throws KubernetesClientException;

  NamedNamespacedResource<Type, TypeBuilder> withName(String name) throws KubernetesClientException;

}
