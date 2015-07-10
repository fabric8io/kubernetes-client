package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.*;

public interface KubernetesClient {
  void close();

  Resource<NamespaceList, Namespace, NamespaceBuilder> namespaces();

  Resource<PodList, Pod, PodBuilder> pods();

  Resource<ReplicationControllerList, ReplicationController, ReplicationControllerBuilder> replicationControllers();

  Resource<ServiceList, Service, ServiceBuilder> services();
}
