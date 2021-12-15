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

import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.LimitRange;
import io.fabric8.kubernetes.api.model.LimitRangeList;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.kubernetes.api.model.PersistentVolume;
import io.fabric8.kubernetes.api.model.PersistentVolumeList;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimList;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.api.model.ResourceQuotaList;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.client.dsl.*;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.extended.run.RunOperations;

import java.io.InputStream;
import java.net.URL;

public class AutoAdaptableKubernetesClient extends DefaultKubernetesClient {

  private KubernetesClient delegate;

  public AutoAdaptableKubernetesClient() {
    delegate = adapt(new DefaultKubernetesClient());
  }

  public AutoAdaptableKubernetesClient(ClientContext clientContext) {
    delegate = adapt(new DefaultKubernetesClient(clientContext));
  }

  public AutoAdaptableKubernetesClient(Config config) {
    delegate = adapt(new DefaultKubernetesClient(config));
  }

  public AutoAdaptableKubernetesClient(String masterUrl) {
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
  public NamespacedKubernetesClient inNamespace(String namespace) {
    Config updated = new ConfigBuilder(getConfiguration()).withNamespace(namespace).build();
    return new AutoAdaptableKubernetesClient(newState(updated));
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
  public VersionInfo getVersion() {
    return delegate.getVersion();
  }

  @Override
  public AdmissionRegistrationAPIGroupDSL admissionRegistration() {
    return delegate.admissionRegistration();
  }

  @Override
  public AppsAPIGroupDSL apps() {
    return delegate.apps();
  }

  @Override
  public AutoscalingAPIGroupDSL autoscaling() {
    return delegate.autoscaling();
  }

  @Override
  public AuthorizationAPIGroupDSL authorization() {
    return delegate.authorization();
  }

  @Override
  public DiscoveryAPIGroupDSL discovery() {
    return delegate.discovery();
  }

  @Override
  public NetworkAPIGroupDSL network() { return delegate.network(); }

  @Override
  public StorageAPIGroupDSL storage() { return delegate.storage(); }

  @Override
  public BatchAPIGroupDSL batch() { return delegate.batch(); }

  @Override
  public PolicyAPIGroupDSL policy() { return delegate.policy(); }

  @Override
  public RbacAPIGroupDSL rbac() { return delegate.rbac(); }

  @Override
  public NonNamespaceOperation<ComponentStatus, ComponentStatusList, Resource<ComponentStatus>> componentstatuses() {
    return delegate.componentstatuses();
  }

  @Override
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> load(InputStream is) {
    return delegate.load(is);
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(KubernetesResourceList is) {
    return delegate.resourceList(is);
  }

  @Override
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(String s) {
    return delegate.resourceList(s);
  }

  @Override
  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata> resource(HasMetadata is) {
    return delegate.resource(is);
  }

  @Override
  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata> resource(String s) {
    return delegate.resource(s);
  }

  @Override
  public MixedOperation<Endpoints, EndpointsList, Resource<Endpoints>> endpoints() {
    return delegate.endpoints();
  }

  @Override
  public NonNamespaceOperation<Namespace, NamespaceList, Resource<Namespace>> namespaces() {
    return delegate.namespaces();
  }

  @Override
  public NonNamespaceOperation<Node, NodeList, Resource<Node>> nodes() {
    return delegate.nodes();
  }

  @Override
  public NonNamespaceOperation<PersistentVolume, PersistentVolumeList, Resource<PersistentVolume>> persistentVolumes() {
    return delegate.persistentVolumes();
  }

  @Override
  public MixedOperation<PersistentVolumeClaim, PersistentVolumeClaimList, Resource<PersistentVolumeClaim>> persistentVolumeClaims() {
    return delegate.persistentVolumeClaims();
  }

  @Override
  public MixedOperation<Pod, PodList, PodResource<Pod>> pods() {
    return delegate.pods();
  }

  @Override
  public MixedOperation<ReplicationController, ReplicationControllerList, RollableScalableResource<ReplicationController>> replicationControllers() {
    return delegate.replicationControllers();
  }

  @Override
  public MixedOperation<ResourceQuota, ResourceQuotaList, Resource<ResourceQuota>> resourceQuotas() {
    return delegate.resourceQuotas();
  }

  @Override
  public MixedOperation<Secret, SecretList, Resource<Secret>> secrets() {
    return delegate.secrets();
  }

  @Override
  public MixedOperation<Service, ServiceList, ServiceResource<Service>> services() {
    return delegate.services();
  }

  @Override
  public MixedOperation<ServiceAccount, ServiceAccountList, Resource<ServiceAccount>> serviceAccounts() {
    return delegate.serviceAccounts();
  }

  @Override
  public KubernetesListMixedOperation lists() {
    return delegate.lists();
  }

  @Override
  public MixedOperation<ConfigMap, ConfigMapList, Resource<ConfigMap>> configMaps() {
    return delegate.configMaps();
  }

  @Override
  public MixedOperation<LimitRange, LimitRangeList, Resource<LimitRange>> limitRanges() {
    return delegate.limitRanges();
  }

  @Override
  public RunOperations run() {
    return delegate.run();
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
