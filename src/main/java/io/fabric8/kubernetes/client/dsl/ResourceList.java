package io.fabric8.kubernetes.client.dsl;

import com.ning.http.client.ws.WebSocket;
import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;

import java.util.Map;

public interface ResourceList<T extends HasMetadata, L extends KubernetesResourceList, B extends Builder<T>> {

  L list() throws KubernetesClientException;

  void delete() throws KubernetesClientException;

  WebSocket watch(Watcher<T> watcher) throws KubernetesClientException;

  FilteredResourceList<T, L> withLabels(Map<String, String> labels);

  FilteredResourceList<T, L> withLabel(String key, String value);

  FilteredResourceList<T, L> withFields(Map<String, String> labels);

  FilteredResourceList<T, L> withField(String key, String value);

}
