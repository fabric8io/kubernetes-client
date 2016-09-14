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

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.DoneableComponentStatus;
import io.fabric8.kubernetes.api.model.DoneableConfigMap;
import io.fabric8.kubernetes.api.model.DoneableEndpoints;
import io.fabric8.kubernetes.api.model.DoneableEvent;
import io.fabric8.kubernetes.api.model.DoneableLimitRange;
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
import io.fabric8.kubernetes.api.model.SecurityContextConstraints;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsList;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.Adapters;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.ExtensionAdapter;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.dsl.ClientKubernetesListMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientPodResource;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.dsl.ExtensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.NamespaceVisitFromServerGetDeleteRecreateApplicable;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.ConfigurationPolicy;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.References;
import org.apache.felix.scr.annotations.Service;

import static io.fabric8.kubernetes.client.Config.KUBERNETES_API_VERSION_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_HTTPS_PROXY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_HTTP_PROXY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_MASTER_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_NAMESPACE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_NO_PROXY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY;

@Component(immediate = true, configurationPid = "io.fabric8.kubernetes.client", policy = ConfigurationPolicy.OPTIONAL)
@Service({KubernetesClient.class,NamespacedKubernetesClient.class})
@References({
  @Reference(referenceInterface = io.fabric8.kubernetes.client.ResourceHandler.class, cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE, policy = ReferencePolicy.DYNAMIC, bind = "bindResourceHandler", unbind = "unbindResourceHandler"),
  @Reference(referenceInterface = ExtensionAdapter.class, cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE, policy = ReferencePolicy.DYNAMIC, bind = "bindExtensionAdapter", unbind = "unbindExtensionAdapter")
})
public class ManagedKubernetesClient extends BaseClient implements NamespacedKubernetesClient {

  private NamespacedKubernetesClient delegate;

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

    delegate = new DefaultKubernetesClient(builder.build());
  }

  @Deactivate
  public void deactivate() {
    delegate.close();
  }

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

  public ClientMixedOperation<Endpoints, EndpointsList, DoneableEndpoints, ClientResource<Endpoints, DoneableEndpoints>> endpoints() {
    return delegate.endpoints();
  }

  public ClientMixedOperation<Pod, PodList, DoneablePod, ClientPodResource<Pod, DoneablePod>> pods() {
    return delegate.pods();
  }

  public ClientMixedOperation<io.fabric8.kubernetes.api.model.Service, ServiceList, DoneableService, ClientResource<io.fabric8.kubernetes.api.model.Service, DoneableService>> services() {
    return delegate.services();
  }

  public ClientNonNamespaceOperation<Namespace, NamespaceList, DoneableNamespace, ClientResource<Namespace, DoneableNamespace>> namespaces() {
    return delegate.namespaces();
  }

  public ClientMixedOperation<ServiceAccount, ServiceAccountList, DoneableServiceAccount, ClientResource<ServiceAccount, DoneableServiceAccount>> serviceAccounts() {
    return delegate.serviceAccounts();
  }

  public ClientNonNamespaceOperation<PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, ClientResource<PersistentVolume, DoneablePersistentVolume>> persistentVolumes() {
    return delegate.persistentVolumes();
  }

  public ClientMixedOperation<ResourceQuota, ResourceQuotaList, DoneableResourceQuota, ClientResource<ResourceQuota, DoneableResourceQuota>> resourceQuotas() {
    return delegate.resourceQuotas();
  }

  public ClientKubernetesListMixedOperation lists() {
    return delegate.lists();
  }

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

  public ClientNonNamespaceOperation<Node, NodeList, DoneableNode, ClientResource<Node, DoneableNode>> nodes() {
    return delegate.nodes();
  }

  public ClientMixedOperation<PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, ClientResource<PersistentVolumeClaim, DoneablePersistentVolumeClaim>> persistentVolumeClaims() {
    return delegate.persistentVolumeClaims();
  }

  public ClientMixedOperation<Event, EventList, DoneableEvent, ClientResource<Event, DoneableEvent>> events() {
    return delegate.events();
  }

  public ClientMixedOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, ClientRollableScallableResource<ReplicationController, DoneableReplicationController>> replicationControllers() {
    return delegate.replicationControllers();
  }

  public ClientMixedOperation<Secret, SecretList, DoneableSecret, ClientResource<Secret, DoneableSecret>> secrets() {
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

  public void bindResourceHandler(ResourceHandler resourceHandler) {
    Handlers.register(resourceHandler);
  }

  public void unbindResourceHandler(ResourceHandler resourceHandler) {
    Handlers.unregister(resourceHandler);
  }

  public void bindExtensionAdapter(ExtensionAdapter adapter) {
    Adapters.register(adapter);
  }

  public void unbindExtensionAdapter(ExtensionAdapter adapter) {
    Adapters.unregister(adapter);
  }

  @Override
  public NamespacedKubernetesClient inAnyNamespace() {
    return delegate.inAnyNamespace();
  }

  @Override
  public NamespacedKubernetesClient inNamespace(String name) {
    return delegate.inNamespace(name);
  }
}
