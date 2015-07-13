package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.*;

public interface KubernetesClient extends AutoCloseable {

  void close();

  NamespaceAwareResourceList<Endpoints, EndpointsList, EndpointsBuilder> endpoints();

  NamespaceAwareResourceList<Event, EventList, EventBuilder> events();

  NonNamespacedResourceList<Namespace, NamespaceList, NamespaceBuilder> namespaces();

  NonNamespacedResourceList<Node, NodeList, NodeBuilder> nodes();

  NamespaceAwareResourceList<PersistentVolume, PersistentVolumeList, PersistentVolumeBuilder> persistentVolumes();

  NamespaceAwareResourceList<PersistentVolumeClaim, PersistentVolumeClaimList, PersistentVolumeClaimBuilder> persistentVolumeClaims();

  NamespaceAwareResourceList<Pod, PodList, PodBuilder> pods();

  NamespaceAwareResourceList<ReplicationController, ReplicationControllerList, ReplicationControllerBuilder> replicationControllers();

  NamespaceAwareResourceList<ResourceQuota, ResourceQuotaList, ResourceQuotaBuilder> resourceQuotas();

  NamespaceAwareResourceList<Secret, SecretList, SecretBuilder> secrets();

  NamespaceAwareResourceList<Service, ServiceList, ServiceBuilder> services();

  NamespaceAwareResourceList<ServiceAccount, ServiceAccountList, ServiceAccountBuilder> serviceAccounts();

}
