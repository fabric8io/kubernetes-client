package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.DoneableEndpoints;
import io.fabric8.kubernetes.api.model.DoneableEvent;
import io.fabric8.kubernetes.api.model.DoneableNamespace;
import io.fabric8.kubernetes.api.model.DoneableNode;
import io.fabric8.kubernetes.api.model.DoneablePersistentVolume;
import io.fabric8.kubernetes.api.model.DoneablePersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.DoneableReplicationController;
import io.fabric8.kubernetes.api.model.DoneableResourceQuota;
import io.fabric8.kubernetes.api.model.DoneableSecret;
import io.fabric8.kubernetes.api.model.DoneableService;
import io.fabric8.kubernetes.api.model.DoneableServiceAccount;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsBuilder;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventBuilder;
import io.fabric8.kubernetes.api.model.EventList;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeBuilder;
import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.kubernetes.api.model.PersistentVolume;
import io.fabric8.kubernetes.api.model.PersistentVolumeBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimList;
import io.fabric8.kubernetes.api.model.PersistentVolumeList;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.api.model.ResourceQuotaBuilder;
import io.fabric8.kubernetes.api.model.ResourceQuotaList;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretBuilder;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountBuilder;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.api.model.ServiceList;


public interface KubernetesClient extends AutoCloseable {

  void close();

  NamespaceAwareResourceList<Endpoints, EndpointsList, EndpointsBuilder, DoneableEndpoints> endpoints();

  NamespaceAwareResourceList<Event, EventList, EventBuilder, DoneableEvent> events();

  NonNamespacedResourceList<Namespace, NamespaceList, NamespaceBuilder, DoneableNamespace> namespaces();

  NonNamespacedResourceList<Node, NodeList, NodeBuilder, DoneableNode> nodes();

  NamespaceAwareResourceList<PersistentVolume, PersistentVolumeList, PersistentVolumeBuilder, DoneablePersistentVolume> persistentVolumes();

  NamespaceAwareResourceList<PersistentVolumeClaim, PersistentVolumeClaimList, PersistentVolumeClaimBuilder, DoneablePersistentVolumeClaim> persistentVolumeClaims();

  NamespaceAwareResourceList<Pod, PodList, PodBuilder, DoneablePod> pods();

  NamespaceAwareResourceList<ReplicationController, ReplicationControllerList, ReplicationControllerBuilder, DoneableReplicationController> replicationControllers();

  NamespaceAwareResourceList<ResourceQuota, ResourceQuotaList, ResourceQuotaBuilder, DoneableResourceQuota> resourceQuotas();

  NamespaceAwareResourceList<Secret, SecretList, SecretBuilder, DoneableSecret> secrets();

  NamespaceAwareResourceList<Service, ServiceList, ServiceBuilder, DoneableService> services();

  NamespaceAwareResourceList<ServiceAccount, ServiceAccountList, ServiceAccountBuilder, DoneableServiceAccount> serviceAccounts();

}
