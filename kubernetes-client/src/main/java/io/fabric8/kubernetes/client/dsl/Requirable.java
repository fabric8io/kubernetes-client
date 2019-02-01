package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.client.ResourceNotFoundException;

public interface Requirable<T> {

  /**
   * @return the item or throws an exception if the item doesn't exist.
   * @throws io.fabric8.kubernetes.client.KubernetesClientException if an error occurs
   * @throws io.fabric8.kubernetes.client.ResourceNotFoundException if resource is absent
   */
  T require() throws ResourceNotFoundException;

}
