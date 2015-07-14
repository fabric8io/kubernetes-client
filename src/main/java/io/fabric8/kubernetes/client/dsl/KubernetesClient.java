package io.fabric8.kubernetes.client.dsl;

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
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateableEndpoints;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateableEvent;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateableNamespace;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateableNode;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateablePersistentVolume;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateablePersistentVolumeClaim;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateablePod;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateableReplicationController;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateableResourceQuota;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateableSecret;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateableService;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateableServiceAccount;

public interface KubernetesClient extends AutoCloseable {

  void close();

  NamespaceAwareResourceList<Endpoints, EndpointsList, EndpointsBuilder, UpdateableEndpoints> endpoints();

  NamespaceAwareResourceList<Event, EventList, EventBuilder, UpdateableEvent> events();

  NonNamespacedResourceList<Namespace, NamespaceList, NamespaceBuilder, UpdateableNamespace> namespaces();

  NonNamespacedResourceList<Node, NodeList, NodeBuilder, UpdateableNode> nodes();

  NamespaceAwareResourceList<PersistentVolume, PersistentVolumeList, PersistentVolumeBuilder, UpdateablePersistentVolume> persistentVolumes();

  NamespaceAwareResourceList<PersistentVolumeClaim, PersistentVolumeClaimList, PersistentVolumeClaimBuilder, UpdateablePersistentVolumeClaim> persistentVolumeClaims();

  NamespaceAwareResourceList<Pod, PodList, PodBuilder, UpdateablePod> pods();

  NamespaceAwareResourceList<ReplicationController, ReplicationControllerList, ReplicationControllerBuilder, UpdateableReplicationController> replicationControllers();

  NamespaceAwareResourceList<ResourceQuota, ResourceQuotaList, ResourceQuotaBuilder, UpdateableResourceQuota> resourceQuotas();

  NamespaceAwareResourceList<Secret, SecretList, SecretBuilder, UpdateableSecret> secrets();

  NamespaceAwareResourceList<Service, ServiceList, ServiceBuilder, UpdateableService> services();

  NamespaceAwareResourceList<ServiceAccount, ServiceAccountList, ServiceAccountBuilder, UpdateableServiceAccount> serviceAccounts();

}
