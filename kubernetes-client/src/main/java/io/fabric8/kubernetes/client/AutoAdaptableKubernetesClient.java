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

import io.fabric8.kubernetes.api.model.DoneableLimitRange;
import io.fabric8.kubernetes.api.model.LimitRange;
import io.fabric8.kubernetes.api.model.LimitRangeList;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.DoneableComponentStatus;
import io.fabric8.kubernetes.api.model.DoneableConfigMap;
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
import io.fabric8.kubernetes.api.model.DoneableSecurityContextConstraints;
import io.fabric8.kubernetes.api.model.DoneableService;
import io.fabric8.kubernetes.api.model.DoneableServiceAccount;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventList;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.kubernetes.api.model.PersistentVolume;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimList;
import io.fabric8.kubernetes.api.model.PersistentVolumeList;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.api.model.ResourceQuotaList;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.api.model.SecurityContextConstraints;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsList;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.dsl.ClientKubernetesListMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientPodResource;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.dsl.ExtensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.NamespaceVisitFromServerGetDeleteRecreateApplicable;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class AutoAdaptableKubernetesClient extends DefaultKubernetesClient {

    private KubernetesClient delegate;

    public AutoAdaptableKubernetesClient() throws KubernetesClientException {
        delegate = adapt(new DefaultKubernetesClient());
    }

    public AutoAdaptableKubernetesClient(OkHttpClient httpClient, Config config) throws KubernetesClientException {
        delegate = adapt(new DefaultKubernetesClient(httpClient, config));
    }

    public AutoAdaptableKubernetesClient(Config config) throws KubernetesClientException {
        delegate = adapt(new DefaultKubernetesClient(config));
    }

    public AutoAdaptableKubernetesClient(String masterUrl) throws KubernetesClientException {
        delegate = adapt(new DefaultKubernetesClient(masterUrl));
    }


    public static KubernetesClient adapt(KubernetesClient initial) {
        KubernetesClient result = initial;
        for (ExtensionAdapter<? extends KubernetesClient> adapter : Adapters.list(KubernetesClient.class)) {
            if (adapter.isAdaptable(result)) {
                result = adapter.adapt(result);
            }
        }
        return result;
    }

    @Override
    public NamespacedKubernetesClient inNamespace(String namespace)
    {
        Config updated = new ConfigBuilder(getConfiguration()).withNamespace(namespace).build();
        return new AutoAdaptableKubernetesClient(httpClient, updated);
    }

    @Override
    public NamespacedKubernetesClient inAnyNamespace() {
        return inNamespace(null);
    }

    @Override
    public ExtensionsAPIGroupDSL extensions() {
        return delegate.extensions();
    }

    @Override
    public ClientMixedOperation<ComponentStatus, ComponentStatusList, DoneableComponentStatus, ClientResource<ComponentStatus, DoneableComponentStatus>> componentstatuses() {
        return delegate.componentstatuses();
    }

    @Override
    public NamespaceVisitFromServerGetDeleteRecreateApplicable<List<HasMetadata>, Boolean> load(InputStream is) {
        return delegate.load(is);
    }

    @Override
    public NamespaceVisitFromServerGetDeleteRecreateApplicable<List<HasMetadata>, Boolean> resource(HasMetadata is) {
        return delegate.resource(is);
    }

    @Override
    public ClientMixedOperation<Endpoints, EndpointsList, DoneableEndpoints, ClientResource<Endpoints, DoneableEndpoints>> endpoints() {
        return delegate.endpoints();
    }

    @Override
    public ClientMixedOperation<Event, EventList, DoneableEvent, ClientResource<Event, DoneableEvent>> events() {
        return delegate.events();
    }

    @Override
    public ClientNonNamespaceOperation<Namespace, NamespaceList, DoneableNamespace, ClientResource<Namespace, DoneableNamespace>> namespaces() {
        return delegate.namespaces();
    }

    @Override
    public ClientNonNamespaceOperation<Node, NodeList, DoneableNode, ClientResource<Node, DoneableNode>> nodes() {
        return delegate.nodes();
    }

    @Override
    public ClientNonNamespaceOperation<PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, ClientResource<PersistentVolume, DoneablePersistentVolume>> persistentVolumes() {
        return delegate.persistentVolumes();
    }

    @Override
    public ClientMixedOperation<PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, ClientResource<PersistentVolumeClaim, DoneablePersistentVolumeClaim>> persistentVolumeClaims() {
        return delegate.persistentVolumeClaims();
    }

    @Override
    public ClientMixedOperation<Pod, PodList, DoneablePod, ClientPodResource<Pod, DoneablePod>> pods() {
        return delegate.pods();
    }

    @Override
    public ClientMixedOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, ClientRollableScallableResource<ReplicationController, DoneableReplicationController>> replicationControllers() {
        return delegate.replicationControllers();
    }

    @Override
    public ClientMixedOperation<ResourceQuota, ResourceQuotaList, DoneableResourceQuota, ClientResource<ResourceQuota, DoneableResourceQuota>> resourceQuotas() {
        return delegate.resourceQuotas();
    }

    @Override
    public ClientMixedOperation<Secret, SecretList, DoneableSecret, ClientResource<Secret, DoneableSecret>> secrets() {
        return delegate.secrets();
    }

    @Override
    public ClientMixedOperation<Service, ServiceList, DoneableService, ClientResource<Service, DoneableService>> services() {
        return delegate.services();
    }

    @Override
    public ClientMixedOperation<ServiceAccount, ServiceAccountList, DoneableServiceAccount, ClientResource<ServiceAccount, DoneableServiceAccount>> serviceAccounts() {
        return delegate.serviceAccounts();
    }

    @Override
    public ClientKubernetesListMixedOperation lists() {
        return delegate.lists();
    }

    @Override
    public ClientNonNamespaceOperation<SecurityContextConstraints, SecurityContextConstraintsList, DoneableSecurityContextConstraints, ClientResource<SecurityContextConstraints, DoneableSecurityContextConstraints>> securityContextConstraints() {
        return delegate.securityContextConstraints();
    }

    @Override
    public ClientMixedOperation<ConfigMap, ConfigMapList, DoneableConfigMap, ClientResource<ConfigMap, DoneableConfigMap>> configMaps() {
        return delegate.configMaps();
    }

    @Override
    public ClientMixedOperation<LimitRange, LimitRangeList, DoneableLimitRange, ClientResource<LimitRange, DoneableLimitRange>> limitRanges() {
      return delegate.limitRanges();
    }

    @Override
    public <C> Boolean isAdaptable(Class<C> type) {
        return delegate.isAdaptable(type);
    }

    @Override
    public <C> C adapt(Class<C> type) {
        return delegate.adapt(type);
    }

    @Override
    public URL getMasterUrl() {
        return delegate.getMasterUrl();
    }

    @Override
    public String getApiVersion() {
        return delegate.getApiVersion();
    }

    @Override
    public String getNamespace() {
        return delegate.getNamespace();
    }

    @Override
    public RootPaths rootPaths() {
        return delegate.rootPaths();
    }

    @Override
    public void close() {
        delegate.close();
    }

    @Override
    public Config getConfiguration() {
        return delegate.getConfiguration();
    }
}
