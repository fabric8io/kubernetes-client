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
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestList;
import io.fabric8.kubernetes.api.model.authentication.TokenReview;
import io.fabric8.kubernetes.api.model.coordination.v1.Lease;
import io.fabric8.kubernetes.api.model.coordination.v1.LeaseList;
import io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClass;
import io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClassList;
import io.fabric8.kubernetes.client.Adapters;
import io.fabric8.kubernetes.client.AdmissionRegistrationAPIGroupDSL;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.OAuthTokenProvider;
import io.fabric8.kubernetes.client.ExtensionAdapter;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.Handlers;
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
import io.fabric8.kubernetes.client.dsl.KubernetesListMixedOperation;
import io.fabric8.kubernetes.client.dsl.MetricAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable;
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
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.extended.leaderelection.LeaderElectorBuilder;
import io.fabric8.kubernetes.client.extended.run.RunConfigBuilder;
import io.fabric8.kubernetes.client.extended.run.RunOperations;
import io.fabric8.kubernetes.client.extended.run.RunOperationsImpl;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.ConfigurationPolicy;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.ReferencePolicyOption;
import org.apache.felix.scr.annotations.References;
import org.apache.felix.scr.annotations.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import static io.fabric8.kubernetes.client.Config.*;

@Component(immediate = true, configurationPid = "io.fabric8.kubernetes.client", policy = ConfigurationPolicy.REQUIRE)
@Service({KubernetesClient.class,NamespacedKubernetesClient.class})
@References({
  @Reference(referenceInterface = io.fabric8.kubernetes.client.ResourceHandler.class, cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE, policy = ReferencePolicy.DYNAMIC, bind = "bindResourceHandler", unbind = "unbindResourceHandler"),
  @Reference(referenceInterface = ExtensionAdapter.class, cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE, policy = ReferencePolicy.DYNAMIC, bind = "bindExtensionAdapter", unbind = "unbindExtensionAdapter"),
  @Reference(referenceInterface = OAuthTokenProvider.class ,cardinality = ReferenceCardinality.OPTIONAL_UNARY, policyOption = ReferencePolicyOption.GREEDY, bind = "bindOAuthTokenProvider", unbind="unbindOAuthTokenProvider")
})
public class ManagedKubernetesClient extends BaseClient implements NamespacedKubernetesClient {

  private NamespacedKubernetesClient delegate;

  private OAuthTokenProvider provider;

  @Activate
  public void activate(Map<String, Object> properties) {
    final ConfigBuilder builder = new ConfigBuilder();

    if (properties.containsKey(KUBERNETES_MASTER_SYSTEM_PROPERTY)) {
      builder.withMasterUrl((String) properties.get(KUBERNETES_MASTER_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_API_VERSION_SYSTEM_PROPERTY)) {
      builder.withApiVersion((String) properties.get(KUBERNETES_API_VERSION_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_NAMESPACE_SYSTEM_PROPERTY)) {
      builder.withNamespace((String) properties.get(KUBERNETES_NAMESPACE_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY)) {
      builder.withCaCertFile((String) properties.get(KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY)) {
      builder.withCaCertData((String) properties.get(KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY)) {
      builder.withClientCertFile((String) properties.get(KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY)) {
      builder.withClientCertData((String) properties.get(KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY)) {
      builder.withClientKeyFile((String) properties.get(KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY)) {
      builder.withClientKeyData((String) properties.get(KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY)) {
      builder.withClientKeyAlgo((String) properties.get(KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY)) {
      builder.withClientKeyPassphrase((String) properties.get(KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY)) {
      builder.withUsername((String) properties.get(KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY)) {
      builder.withPassword((String) properties.get(KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY)) {
      builder.withOauthToken((String) properties.get(KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY)) {
      builder.withWatchReconnectInterval(Integer.parseInt((String) properties.get(KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY)));
    }
    if (properties.containsKey(KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY)) {
      builder.withWatchReconnectLimit(Integer.parseInt((String) properties.get(KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY)));
    }
    if (properties.containsKey(KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY)) {
      builder.withRequestTimeout(Integer.parseInt((String) properties.get(KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY)));
    }
    if (properties.containsKey(KUBERNETES_HTTP_PROXY)) {
      builder.withHttpProxy((String) properties.get(KUBERNETES_HTTP_PROXY));
    }
    if (properties.containsKey(KUBERNETES_HTTPS_PROXY)) {
      builder.withHttpsProxy((String) properties.get(KUBERNETES_HTTPS_PROXY));
    }
    if (properties.containsKey(KUBERNETES_NO_PROXY)) {
      String noProxyProperty = (String) properties.get(KUBERNETES_NO_PROXY);
      builder.withNoProxy(noProxyProperty.split(","));
    }
    if (properties.containsKey(KUBERNETES_WEBSOCKET_TIMEOUT_SYSTEM_PROPERTY)) {
      builder.withWebsocketTimeout(Long.parseLong((String) properties.get(KUBERNETES_WEBSOCKET_TIMEOUT_SYSTEM_PROPERTY)));
    }
    if (properties.containsKey(KUBERNETES_WEBSOCKET_PING_INTERVAL_SYSTEM_PROPERTY)) {
      builder.withWebsocketPingInterval(Long.parseLong((String) properties.get(KUBERNETES_WEBSOCKET_PING_INTERVAL_SYSTEM_PROPERTY)));
    }
    if (properties.containsKey(KUBERNETES_TRUSTSTORE_FILE_PROPERTY)) {
      builder.withTrustStoreFile((String) properties.get(KUBERNETES_TRUSTSTORE_FILE_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_TRUSTSTORE_PASSPHRASE_PROPERTY)) {
      builder.withTrustStorePassphrase((String) properties.get(KUBERNETES_TRUSTSTORE_PASSPHRASE_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_KEYSTORE_FILE_PROPERTY)) {
      builder.withKeyStoreFile((String) properties.get(KUBERNETES_KEYSTORE_FILE_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_KEYSTORE_PASSPHRASE_PROPERTY)) {
      builder.withKeyStorePassphrase((String) properties.get(KUBERNETES_KEYSTORE_PASSPHRASE_PROPERTY));
    }
    if (provider != null ) {
      builder.withOauthTokenProvider(provider);
    }

    delegate = new DefaultKubernetesClient(builder.build());
  }

  @Deactivate
  public void deactivate() {
    delegate.close();
  }

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
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(HasMetadata... items) {
    return delegate.resourceList(items);
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(Collection<HasMetadata> items) {
    return delegate.resourceList(items);
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
  public MixedOperation<Binding, KubernetesResourceList<Binding>, Resource<Binding>> bindings() {
    return delegate.bindings();
  }

  @Override
  public MixedOperation<Pod, PodList, PodResource<Pod>> pods() {
    return delegate.pods();
  }

  @Override
  public MixedOperation<io.fabric8.kubernetes.api.model.Service, ServiceList, ServiceResource<io.fabric8.kubernetes.api.model.Service>> services() {
    return delegate.services();
  }

  @Override
  public NonNamespaceOperation<Namespace, NamespaceList, Resource<Namespace>> namespaces() {
    return delegate.namespaces();
  }

  @Override
  public MixedOperation<ServiceAccount, ServiceAccountList, Resource<ServiceAccount>> serviceAccounts() {
    return delegate.serviceAccounts();
  }

  @Override
  public NonNamespaceOperation<APIService, APIServiceList, Resource<APIService>> apiServices() {
    return delegate.apiServices();
  }

  @Override
  public NonNamespaceOperation<PersistentVolume, PersistentVolumeList, Resource<PersistentVolume>> persistentVolumes() {
    return delegate.persistentVolumes();
  }

  @Override
  public MixedOperation<ResourceQuota, ResourceQuotaList, Resource<ResourceQuota>> resourceQuotas() {
    return delegate.resourceQuotas();
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
  public NonNamespaceOperation<Node, NodeList, Resource<Node>> nodes() {
    return delegate.nodes();
  }

  @Override
  public MixedOperation<PersistentVolumeClaim, PersistentVolumeClaimList, Resource<PersistentVolumeClaim>> persistentVolumeClaims() {
    return delegate.persistentVolumeClaims();
  }

  @Override
  public MixedOperation<ReplicationController, ReplicationControllerList, RollableScalableResource<ReplicationController>> replicationControllers() {
    return delegate.replicationControllers();
  }

  @Override
  public MixedOperation<Secret, SecretList, Resource<Secret>> secrets() {
    return delegate.secrets();
  }

  @Override
  public RootPaths rootPaths() {
    return delegate.rootPaths();
  }

  @Override
  public ExtensionsAPIGroupDSL extensions() {
    return delegate.extensions();
  }

  @Override
  public FlowControlAPIGroupDSL flowControl() {
    return delegate.flowControl();
  }

  @Override
  public VersionInfo getVersion() {
    return delegate.getVersion();
  }
  
  @Override
  public VersionInfo getKubernetesVersion() {
    return delegate.getVersion();
  }

  @Override
  public V1APIGroupDSL v1() {
    return delegate.v1();
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
  public SchedulingAPIGroupDSL scheduling() { return delegate.scheduling(); }

  @Override

  public NetworkAPIGroupDSL network() { return delegate.network(); }

  @Override
  public StorageAPIGroupDSL storage() { return delegate.storage(); }

  @Override
  public BatchAPIGroupDSL batch() { return delegate.batch(); }

  @Override
  public MetricAPIGroupDSL top() { return delegate.top(); }

  @Override
  public PolicyAPIGroupDSL policy() { return delegate.policy(); }

  @Override
  public RbacAPIGroupDSL rbac() { return delegate.rbac(); }

  @Override
  public ApiextensionsAPIGroupDSL apiextensions() {
    return delegate.apiextensions();
  }

  @Override
  public NonNamespaceOperation<CertificateSigningRequest, CertificateSigningRequestList, Resource<CertificateSigningRequest>> certificateSigningRequests() {
    return delegate.certificateSigningRequests();
  }

  @Override
  public CertificatesAPIGroupDSL certificates() {
    return delegate.certificates();
  }

  @Override
  public AuthorizationAPIGroupDSL authorization() {
    return delegate.authorization();
  }

  @Override
  public InOutCreateable<TokenReview, TokenReview> tokenReviews() {
    return delegate.tokenReviews();
  }

  @Override
  public <T extends CustomResource> MixedOperation<T, KubernetesResourceList<T>, Resource<T>> customResources(Class<T> resourceType) {
    return delegate.customResources(resourceType);
  }

  @Override
  public <T extends CustomResource, L extends KubernetesResourceList<T>> MixedOperation<T, L, Resource<T>> customResources(Class<T> resourceType, Class<L> listClass) {
    return delegate.customResources(resourceType, listClass);
  }

  @Override
  public <T extends HasMetadata, L extends KubernetesResourceList<T>> MixedOperation<T, L, Resource<T>> customResources(ResourceDefinitionContext crdContext, Class<T> resourceType, Class<L> listClass) {
    return delegate.customResources(crdContext, resourceType, listClass);
  }
  
  @Override
  public <T extends HasMetadata, L extends KubernetesResourceList<T>> MixedOperation<T, L, Resource<T>> resources(
      Class<T> resourceType, Class<L> listClass) {
    return delegate.resources(resourceType, listClass);
  }
  
  @Override
  public DiscoveryAPIGroupDSL discovery() {
    return delegate.discovery();
  }

  @Override
  public EventingAPIGroupDSL events() {
    return delegate.events();
  }

  @Override
  public SharedInformerFactory informers() {
    return delegate.informers();
  }

  @Override
  public SharedInformerFactory informers(ExecutorService executorService) {
    return delegate.informers(executorService);
  }

  @Override
  public LeaderElectorBuilder<NamespacedKubernetesClient> leaderElector() {
    return delegate.leaderElector();
  }

  @Override
  public MixedOperation<Lease, LeaseList, Resource<Lease>> leases() {
    return delegate.leases();
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
  public URL getMasterUrl() {
    return delegate.getMasterUrl();
  }

  @Override
  public <C> C adapt(Class<C> type) {
    return delegate.adapt(type);
  }

  @Override
  public void close() {
    delegate.close();
  }

  @Override
  public Config getConfiguration() {
    return delegate.getConfiguration();
  }

  /**
   * @deprecated ResourceHandlers to not need bound
   */
  @Deprecated
  public void bindResourceHandler(ResourceHandler resourceHandler) {
    // not used
  }

  /**
   * @deprecated ResourceHandlers to not need bound
   */
  @Deprecated
  public void unbindResourceHandler(ResourceHandler resourceHandler) {
    // not used
  }

  public void bindExtensionAdapter(ExtensionAdapter adapter) {
    Adapters.register(adapter);
  }

  public void unbindExtensionAdapter(ExtensionAdapter adapter) {
    Adapters.unregister(adapter);
  }

  public void bindOAuthTokenProvider(OAuthTokenProvider provider) {
      this.provider = provider;
  }

  public void unbindOAuthTokenProvider(OAuthTokenProvider provider) {
      if ( this.provider == provider ) {
          this.provider = null;
      }
  }

  @Override
  public NamespacedKubernetesClient inAnyNamespace() {
    return delegate.inAnyNamespace();
  }

  @Override
  public NamespacedKubernetesClient inNamespace(String name) {
    return delegate.inNamespace(name);
  }

  @Override
  public FunctionCallable<NamespacedKubernetesClient> withRequestConfig(RequestConfig requestConfig) {
    return delegate.withRequestConfig(requestConfig);
  }

  @Override
  public RunOperations run() {
    return new RunOperationsImpl(this, getNamespace(), new RunConfigBuilder());
  }

  @Override
  public NonNamespaceOperation<RuntimeClass, RuntimeClassList, Resource<RuntimeClass>> runtimeClasses() {
    return delegate.runtimeClasses();
  }
  
  @Override
  public MixedOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> genericKubernetesResources(
      String apiVersion, String kind) {
    return delegate.genericKubernetesResources(apiVersion, kind);
  }
  
}
