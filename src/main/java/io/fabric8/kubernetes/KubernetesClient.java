package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.*;

public interface KubernetesClient {
  void close();

  Resource<EndpointsList, Endpoints, EndpointsBuilder> endpoints();

  Resource<NamespaceList, Namespace, NamespaceBuilder> namespaces();

  Resource<NodeList, Node, NodeBuilder> nodes();

  Resource<PodList, Pod, PodBuilder> pods();

  ReplicationControllerResource replicationControllers();

  Resource<SecretList, Secret, SecretBuilder> secrets();

  Resource<ServiceList, Service, ServiceBuilder> services();

  Resource<ServiceAccountList, ServiceAccount, ServiceAccountBuilder> serviceAccounts();
}
