package io.fabric8.kubernetes.client.utils.informers;

import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;

/**
 * ListerWatcher is any object that knows how to perform an initial list and
 * start a watch on a resource.
 *
 * @param <T> type
 * @param <TList> list for that type
 */
public interface ListerWatcher<T, TList> {
  Watch watch(ListOptions params, String namespace, Watcher<T> watcher) throws KubernetesClientException;

  TList list(ListOptions params, String namespace) throws KubernetesClientException;
}
