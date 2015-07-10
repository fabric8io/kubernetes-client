package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.*;

public interface KubernetesClient {
  void close();

  ResourceList<NamespaceList> namespaces();

  Resource<Namespace, NamespaceBuilder> namespaces(String name);

  ResourceCreate<Namespace> newNamespace(Namespace namespace);

  ResourceList<PodList> pods();

  Resource<Pod, PodBuilder> pods(String name);

  ResourceList<ReplicationControllerList> replicationControllers();

  Resource<ReplicationController, ReplicationControllerBuilder> replicationControllers(String name);

  ResourceList<ServiceList> services();

  Resource<Service, ServiceBuilder> services(String name);
}
