/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.dsl.AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.ClientKubernetesListMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientPodResource;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.dsl.ExtensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.NamespaceVisitFromServerGetDeleteRecreateApplicable;

import java.io.InputStream;
import java.util.List;

public interface KubernetesClient extends Client {

  ExtensionsAPIGroupDSL extensions();

  AutoscalingAPIGroupDSL autoscaling();

  ClientMixedOperation<ComponentStatus, ComponentStatusList, DoneableComponentStatus, ClientResource<ComponentStatus, DoneableComponentStatus>> componentstatuses();

  NamespaceVisitFromServerGetDeleteRecreateApplicable<List<HasMetadata>,Boolean> load(InputStream is);

  NamespaceVisitFromServerGetDeleteRecreateApplicable<List<HasMetadata>,Boolean> resource(HasMetadata is);

  ClientMixedOperation<Endpoints, EndpointsList, DoneableEndpoints, ClientResource<Endpoints, DoneableEndpoints>> endpoints();

  ClientMixedOperation<Event, EventList, DoneableEvent, ClientResource<Event, DoneableEvent>> events();

  ClientNonNamespaceOperation< Namespace, NamespaceList, DoneableNamespace, ClientResource<Namespace, DoneableNamespace>> namespaces();

  ClientNonNamespaceOperation<Node, NodeList, DoneableNode, ClientResource<Node, DoneableNode>> nodes();

  ClientNonNamespaceOperation<PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, ClientResource<PersistentVolume, DoneablePersistentVolume>> persistentVolumes();

  ClientMixedOperation<PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, ClientResource<PersistentVolumeClaim, DoneablePersistentVolumeClaim>> persistentVolumeClaims();

  ClientMixedOperation<Pod, PodList, DoneablePod, ClientPodResource<Pod, DoneablePod>> pods();

  ClientMixedOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, ClientRollableScallableResource<ReplicationController, DoneableReplicationController>> replicationControllers();

  ClientMixedOperation<ResourceQuota, ResourceQuotaList, DoneableResourceQuota, ClientResource<ResourceQuota, DoneableResourceQuota>> resourceQuotas();

  ClientMixedOperation<Secret, SecretList, DoneableSecret, ClientResource<Secret, DoneableSecret>> secrets();

  ClientMixedOperation<Service, ServiceList, DoneableService, ClientResource<Service, DoneableService>> services();

  ClientMixedOperation<ServiceAccount, ServiceAccountList, DoneableServiceAccount, ClientResource<ServiceAccount, DoneableServiceAccount>> serviceAccounts();

  ClientKubernetesListMixedOperation lists();

  ClientNonNamespaceOperation<SecurityContextConstraints, SecurityContextConstraintsList, DoneableSecurityContextConstraints, ClientResource<SecurityContextConstraints, DoneableSecurityContextConstraints>> securityContextConstraints();

  ClientMixedOperation<ConfigMap, ConfigMapList, DoneableConfigMap, ClientResource<ConfigMap, DoneableConfigMap>> configMaps();

  ClientMixedOperation<LimitRange, LimitRangeList, DoneableLimitRange, ClientResource<LimitRange, DoneableLimitRange>> limitRanges();
}
