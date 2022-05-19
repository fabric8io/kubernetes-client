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

package io.fabric8.kubernetes.client.osgi;

import io.fabric8.kubernetes.api.model.APIService;
import io.fabric8.kubernetes.api.model.APIServiceList;
import io.fabric8.kubernetes.api.model.Binding;
import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.LimitRange;
import io.fabric8.kubernetes.api.model.LimitRangeList;
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
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.api.model.authentication.TokenReview;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestList;
import io.fabric8.kubernetes.api.model.coordination.v1.Lease;
import io.fabric8.kubernetes.api.model.coordination.v1.LeaseList;
import io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClass;
import io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClassList;
import io.fabric8.kubernetes.client.AdmissionRegistrationAPIGroupDSL;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.dsl.ApiextensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AppsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AuthorizationAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.BatchAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.CertificatesAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.DiscoveryAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.EventingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.ExtensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.FlowControlAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.InOutCreateable;
import io.fabric8.kubernetes.client.dsl.MetricAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.NamespaceableResource;
import io.fabric8.kubernetes.client.dsl.NetworkAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.PolicyAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.RbacAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.SchedulingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.ServiceResource;
import io.fabric8.kubernetes.client.dsl.StorageAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1APIGroupDSL;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.extended.leaderelection.LeaderElectorBuilder;
import io.fabric8.kubernetes.client.extended.run.RunOperations;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;

import java.io.InputStream;
import java.util.Collection;

public class NamespacedKubernetesClientAdapter<N extends NamespacedKubernetesClient>
    extends ClientAdapter<NamespacedKubernetesClientAdapter<N>> implements NamespacedKubernetesClient {

  private Class<N> type;

  public NamespacedKubernetesClientAdapter(Class<N> type) {
    this.type = type;
  }

  @Override
  public NamespacedKubernetesClientAdapter<N> newInstance() {
    return new NamespacedKubernetesClientAdapter<>(type);
  }

  @Override
  public N getClient() {
    return super.getClient().adapt(type);
  }

  @Override
  public FunctionCallable<? extends NamespacedKubernetesClient> withRequestConfig(RequestConfig requestConfig) {
    return getClient().withRequestConfig(requestConfig);
  }

  @Override
  public <T extends HasMetadata, L extends KubernetesResourceList<T>> MixedOperation<T, L, Resource<T>> resources(
      Class<T> resourceType, Class<L> listClass) {
    return getClient().resources(resourceType, listClass);
  }

  @Override
  public ApiextensionsAPIGroupDSL apiextensions() {
    return getClient().apiextensions();
  }

  @Override
  public NonNamespaceOperation<CertificateSigningRequest, CertificateSigningRequestList, Resource<CertificateSigningRequest>> certificateSigningRequests() {
    return getClient().certificateSigningRequests();
  }

  @Override
  public Client newClient(RequestConfig requestConfig) {
    return getClient().newClient(requestConfig);
  }

  @Override
  public CertificatesAPIGroupDSL certificates() {
    return getClient().certificates();
  }

  @Override
  public <T extends HasMetadata> MixedOperation<T, KubernetesResourceList<T>, Resource<T>> resources(Class<T> resourceType) {
    return getClient().resources(resourceType);
  }

  @Override
  public MixedOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> genericKubernetesResources(
      ResourceDefinitionContext context) {
    return getClient().genericKubernetesResources(context);
  }

  @Override
  public MixedOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> genericKubernetesResources(
      String apiVersion, String kind) {
    return getClient().genericKubernetesResources(apiVersion, kind);
  }

  @Override
  public DiscoveryAPIGroupDSL discovery() {
    return getClient().discovery();
  }

  @Override
  public EventingAPIGroupDSL events() {
    return getClient().events();
  }

  @Override
  public ExtensionsAPIGroupDSL extensions() {
    return getClient().extensions();
  }

  @Override
  public FlowControlAPIGroupDSL flowControl() {
    return getClient().flowControl();
  }

  @Override
  public VersionInfo getVersion() {
    return getClient().getVersion();
  }

  @Override
  public VersionInfo getKubernetesVersion() {
    return getClient().getKubernetesVersion();
  }

  @Override
  public AdmissionRegistrationAPIGroupDSL admissionRegistration() {
    return getClient().admissionRegistration();
  }

  @Override
  public AppsAPIGroupDSL apps() {
    return getClient().apps();
  }

  @Override
  public AutoscalingAPIGroupDSL autoscaling() {
    return getClient().autoscaling();
  }

  @Override
  public NetworkAPIGroupDSL network() {
    return getClient().network();
  }

  @Override
  public StorageAPIGroupDSL storage() {
    return getClient().storage();
  }

  @Override
  public BatchAPIGroupDSL batch() {
    return getClient().batch();
  }

  @Override
  public MetricAPIGroupDSL top() {
    return getClient().top();
  }

  @Override
  public PolicyAPIGroupDSL policy() {
    return getClient().policy();
  }

  @Override
  public RbacAPIGroupDSL rbac() {
    return getClient().rbac();
  }

  @Override
  public SchedulingAPIGroupDSL scheduling() {
    return getClient().scheduling();
  }

  @Override
  public NonNamespaceOperation<ComponentStatus, ComponentStatusList, Resource<ComponentStatus>> componentstatuses() {
    return getClient().componentstatuses();
  }

  @Override
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> load(InputStream is) {
    return getClient().load(is);
  }

  @Override
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(String s) {
    return getClient().resourceList(s);
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(KubernetesResourceList list) {
    return getClient().resourceList(list);
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(HasMetadata... items) {
    return getClient().resourceList(items);
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(
      Collection<? extends HasMetadata> items) {
    return getClient().resourceList(items);
  }

  @Override
  public <T extends HasMetadata> NamespaceableResource<T> resource(T is) {
    return getClient().resource(is);
  }

  @Override
  public NamespaceableResource<HasMetadata> resource(String s) {
    return getClient().resource(s);
  }

  @Override
  public MixedOperation<Binding, KubernetesResourceList<Binding>, Resource<Binding>> bindings() {
    return getClient().bindings();
  }

  @Override
  public MixedOperation<Endpoints, EndpointsList, Resource<Endpoints>> endpoints() {
    return getClient().endpoints();
  }

  @Override
  public NonNamespaceOperation<Namespace, NamespaceList, Resource<Namespace>> namespaces() {
    return getClient().namespaces();
  }

  @Override
  public NonNamespaceOperation<Node, NodeList, Resource<Node>> nodes() {
    return getClient().nodes();
  }

  @Override
  public NonNamespaceOperation<PersistentVolume, PersistentVolumeList, Resource<PersistentVolume>> persistentVolumes() {
    return getClient().persistentVolumes();
  }

  @Override
  public MixedOperation<PersistentVolumeClaim, PersistentVolumeClaimList, Resource<PersistentVolumeClaim>> persistentVolumeClaims() {
    return getClient().persistentVolumeClaims();
  }

  @Override
  public MixedOperation<Pod, PodList, PodResource> pods() {
    return getClient().pods();
  }

  @Override
  public MixedOperation<ReplicationController, ReplicationControllerList, RollableScalableResource<ReplicationController>> replicationControllers() {
    return getClient().replicationControllers();
  }

  @Override
  public MixedOperation<ResourceQuota, ResourceQuotaList, Resource<ResourceQuota>> resourceQuotas() {
    return getClient().resourceQuotas();
  }

  @Override
  public MixedOperation<Secret, SecretList, Resource<Secret>> secrets() {
    return getClient().secrets();
  }

  @Override
  public MixedOperation<Service, ServiceList, ServiceResource<Service>> services() {
    return getClient().services();
  }

  @Override
  public MixedOperation<ServiceAccount, ServiceAccountList, Resource<ServiceAccount>> serviceAccounts() {
    return getClient().serviceAccounts();
  }

  @Override
  public NonNamespaceOperation<APIService, APIServiceList, Resource<APIService>> apiServices() {
    return getClient().apiServices();
  }

  @Override
  public MixedOperation<ConfigMap, ConfigMapList, Resource<ConfigMap>> configMaps() {
    return getClient().configMaps();
  }

  @Override
  public MixedOperation<LimitRange, LimitRangeList, Resource<LimitRange>> limitRanges() {
    return getClient().limitRanges();
  }

  @Override
  public AuthorizationAPIGroupDSL authorization() {
    return getClient().authorization();
  }

  @Override
  public InOutCreateable<TokenReview, TokenReview> tokenReviews() {
    return getClient().tokenReviews();
  }

  @Override
  public SharedInformerFactory informers() {
    return getClient().informers();
  }

  @Override
  public LeaderElectorBuilder leaderElector() {
    return getClient().leaderElector();
  }

  @Override
  public MixedOperation<Lease, LeaseList, Resource<Lease>> leases() {
    return getClient().leases();
  }

  @Override
  public V1APIGroupDSL v1() {
    return getClient().v1();
  }

  @Override
  public RunOperations run() {
    return getClient().run();
  }

  @Override
  public NonNamespaceOperation<RuntimeClass, RuntimeClassList, Resource<RuntimeClass>> runtimeClasses() {
    return getClient().runtimeClasses();
  }

}
