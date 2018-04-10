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

import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionList;
import io.fabric8.kubernetes.api.model.apiextensions.DoneableCustomResourceDefinition;
import io.fabric8.kubernetes.api.model.extensions.DoneablePodSecurityPolicy;
import io.fabric8.kubernetes.api.model.extensions.PodSecurityPolicy;
import io.fabric8.kubernetes.api.model.extensions.PodSecurityPolicyList;
import io.fabric8.kubernetes.client.dsl.*;
import io.fabric8.kubernetes.client.dsl.internal.*;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.openshift.api.model.DoneableSecurityContextConstraints;
import io.fabric8.openshift.api.model.SecurityContextConstraints;
import io.fabric8.openshift.api.model.SecurityContextConstraintsList;
import okhttp3.OkHttpClient;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

public class DefaultKubernetesClient extends BaseClient implements NamespacedKubernetesClient {

  public DefaultKubernetesClient() throws KubernetesClientException {
    super();
  }

  public DefaultKubernetesClient(String masterUrl) throws KubernetesClientException {
    super(masterUrl);
  }

  public DefaultKubernetesClient(Config config) throws KubernetesClientException {
    super(config);
  }


  public DefaultKubernetesClient(OkHttpClient httpClient, Config config) throws KubernetesClientException {
    super(httpClient, config);
  }

  public static DefaultKubernetesClient fromConfig(String config) {
    return new DefaultKubernetesClient(Serialization.unmarshal(config, Config.class));
  }

  public static DefaultKubernetesClient fromConfig(InputStream is) {
    return new DefaultKubernetesClient(Serialization.unmarshal(is, Config.class));
  }

  @Override
  public MixedOperation<ComponentStatus, ComponentStatusList, DoneableComponentStatus, Resource<ComponentStatus, DoneableComponentStatus>> componentstatuses() {
    return new ComponentStatusOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> load(InputStream is) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(httpClient, getConfiguration(), getNamespace(), null, false, false, new ArrayList<Visitor>(), is, null, false) {
    };
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> resourceList(KubernetesResourceList item) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(httpClient, getConfiguration(), getNamespace(), null, false, false, new ArrayList<Visitor>(), item, null, null, -1, false) {
    };
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> resourceList(HasMetadata... items) {
    return resourceList(new KubernetesListBuilder().withItems(items).build());
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> resourceList(Collection<HasMetadata> items) {
    return resourceList(new KubernetesListBuilder().withItems(new ArrayList<HasMetadata>(items)).build());
  }

  @Override
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> resourceList(String s) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(httpClient, getConfiguration(), getNamespace(), null, false, false, new ArrayList<Visitor>(), s, null, null, -1, false) {
    };
  }


  @Override
  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata, Boolean> resource(HasMetadata item) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(httpClient, getConfiguration(), getNamespace(), null, false, false, new ArrayList<Visitor>(), item, -1, false) {
    };
  }

  @Override
  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata, Boolean> resource(String s) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(httpClient, getConfiguration(), getNamespace(), null, false, false, new ArrayList<Visitor>(), s, -1, false) {
    };
  }

  @Override
  public MixedOperation<Endpoints, EndpointsList, DoneableEndpoints, Resource<Endpoints, DoneableEndpoints>> endpoints() {
    return new EndpointsOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public MixedOperation<Event, EventList, DoneableEvent, Resource<Event, DoneableEvent>> events() {
    return new EventOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public NonNamespaceOperation<Namespace, NamespaceList, DoneableNamespace, Resource<Namespace, DoneableNamespace>> namespaces() {
    return new NamespaceOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public NonNamespaceOperation<Node, NodeList, DoneableNode, Resource<Node, DoneableNode>> nodes() {
    return new NodeOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public NonNamespaceOperation<PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, Resource<PersistentVolume, DoneablePersistentVolume>> persistentVolumes() {
    return new PersistentVolumeOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public MixedOperation<PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, Resource<PersistentVolumeClaim, DoneablePersistentVolumeClaim>> persistentVolumeClaims() {
    return new PersistentVolumeClaimOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public MixedOperation<Pod, PodList, DoneablePod, PodResource<Pod, DoneablePod>> pods() {
    return new PodOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public MixedOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, RollableScalableResource<ReplicationController, DoneableReplicationController>> replicationControllers() {
    return new ReplicationControllerOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public MixedOperation<ResourceQuota, ResourceQuotaList, DoneableResourceQuota, Resource<ResourceQuota, DoneableResourceQuota>> resourceQuotas() {
    return new ResourceQuotaOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public MixedOperation<Secret, SecretList, DoneableSecret, Resource<Secret, DoneableSecret>> secrets() {
    return new SecretOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public MixedOperation<Service, ServiceList, DoneableService, Resource<Service, DoneableService>> services() {
    return new ServiceOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public MixedOperation<ServiceAccount, ServiceAccountList, DoneableServiceAccount, Resource<ServiceAccount, DoneableServiceAccount>> serviceAccounts() {
    return new ServiceAccountOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public KubernetesListMixedOperation lists() {
    return new KubernetesListOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public NonNamespaceOperation<SecurityContextConstraints, SecurityContextConstraintsList, DoneableSecurityContextConstraints, Resource<SecurityContextConstraints, DoneableSecurityContextConstraints>> securityContextConstraints() {
    return new SecurityContextConstraintsOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public MixedOperation<ConfigMap, ConfigMapList, DoneableConfigMap, Resource<ConfigMap, DoneableConfigMap>> configMaps() {
    return new ConfigMapOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public MixedOperation<LimitRange, LimitRangeList, DoneableLimitRange, Resource<LimitRange, DoneableLimitRange>> limitRanges() {
    return new LimitRangeOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public MixedOperation<StorageClass, StorageClassList, DoneableStorageClass, Resource<StorageClass, DoneableStorageClass>> storageClasses() {
    return new StorageClassOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public MixedOperation<PodSecurityPolicy, PodSecurityPolicyList, DoneablePodSecurityPolicy, Resource<PodSecurityPolicy, DoneablePodSecurityPolicy>> podSecurityPolicies() {
    return new PodSecurityPolicyOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public NonNamespaceOperation<CustomResourceDefinition, CustomResourceDefinitionList, DoneableCustomResourceDefinition, Resource<CustomResourceDefinition, DoneableCustomResourceDefinition>> customResourceDefinitions() {
    return new CustomResourceDefinitionOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public <T extends HasMetadata, L extends KubernetesResourceList, D extends Doneable<T>> MixedOperation<T, L, D, Resource<T, D>> customResources(CustomResourceDefinition crd, Class<T> resourceType, Class<L> listClass, Class<D> doneClass) {
    return new CustomResourceOperationsImpl<T,L,D>(httpClient, getConfiguration(), crd, resourceType, listClass, doneClass);
  }

  @Override
  public <T extends HasMetadata, L extends KubernetesResourceList, D extends Doneable<T>> MixedOperation<T, L, D, Resource<T, D>> customResource(CustomResourceDefinition crd, Class<T> resourceType, Class<L> listClass, Class<D> doneClass) {
    return customResources(crd, resourceType, listClass, doneClass);
  }

  @Override
  public NamespacedKubernetesClient inNamespace(String namespace)
  {
    Config updated = new ConfigBuilder(getConfiguration()).withNamespace(namespace).build();
    return new DefaultKubernetesClient(httpClient, updated);
  }

  @Override
  public NamespacedKubernetesClient inAnyNamespace() {
    return inNamespace(null);
  }


  @Override
  public FunctionCallable<NamespacedKubernetesClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<NamespacedKubernetesClient>(this, requestConfig);
  }

  @Override
  public ExtensionsAPIGroupDSL extensions() {
    return adapt(ExtensionsAPIGroupClient.class);
  }

  @Override
  public VersionInfo getVersion() {
    return new ClusterOperationsImpl(httpClient, getConfiguration(), "version").fetchVersion();
  }

  @Override
  public AppsAPIGroupDSL apps() {
    return adapt(AppsAPIGroupClient.class);
  }

  @Override
  public AutoscalingAPIGroupDSL autoscaling() {
    return adapt(AutoscalingAPIGroupClient.class);
  }

}
