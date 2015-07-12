package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.*;

public interface KubernetesClient extends AutoCloseable {

  void close();

  NamespaceAwareResourceList<Endpoints, EndpointsList, EndpointsBuilder> endpoints();

  NonNamespacedResourceList<Namespace, NamespaceList, NamespaceBuilder> namespaces();

  NonNamespacedResourceList<Node, NodeList, NodeBuilder> nodes();

  NamespaceAwareResourceList<Pod, PodList, PodBuilder> pods();

  NamespaceAwareResourceList<ReplicationController, ReplicationControllerList, ReplicationControllerBuilder> replicationControllers();

  NamespaceAwareResourceList<Secret, SecretList, SecretBuilder> secrets();

  NamespaceAwareResourceList<Service, ServiceList, ServiceBuilder> services();

  NamespaceAwareResourceList<ServiceAccount, ServiceAccountList, ServiceAccountBuilder> serviceAccounts();

}
