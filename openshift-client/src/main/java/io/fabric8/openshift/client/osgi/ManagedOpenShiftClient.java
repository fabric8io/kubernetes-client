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

package io.fabric8.openshift.client.osgi;

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
import io.fabric8.kubernetes.api.model.KubernetesList;
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
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.ClientKubernetesListMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientPodResource;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.dsl.ClientScaleableResource;
import io.fabric8.kubernetes.client.dsl.ExtensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.NamespaceVisitFromServerGetDeleteRecreateApplicable;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.openshift.api.model.*;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.OpenShiftConfigBuilder;
import io.fabric8.openshift.client.dsl.ClientBuildConfigResource;
import io.fabric8.openshift.client.dsl.ClientProjectRequestOperation;
import io.fabric8.openshift.client.dsl.ClientSubjectAccessReviewOperation;
import io.fabric8.openshift.client.dsl.ClientTemplateResource;
import io.fabric8.openshift.client.dsl.CreateableLocalSubjectAccessReview;
import io.fabric8.openshift.client.dsl.CreateableSubjectAccessReview;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.ConfigurationPolicy;
import org.apache.felix.scr.annotations.Deactivate;
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
import static io.fabric8.openshift.client.OpenShiftConfig.DEFAULT_BUILD_TIMEOUT;
import static io.fabric8.openshift.client.OpenShiftConfig.OPENSHIFT_BUILD_TIMEOUT_SYSTEM_PROPERTY;
import static io.fabric8.openshift.client.OpenShiftConfig.OPENSHIFT_URL_SYTEM_PROPERTY;

@Component(immediate = true, configurationPid = "io.fabric8.openshift.client", policy = ConfigurationPolicy.OPTIONAL)
@Service({OpenShiftClient.class, NamespacedOpenShiftClient.class})
public class ManagedOpenShiftClient extends BaseClient implements NamespacedOpenShiftClient {

  private DefaultOpenShiftClient delegate;

  @Activate
  public void activate(Map<String, Object> properties) {
    final OpenShiftConfigBuilder builder = new OpenShiftConfigBuilder();

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
    if (properties.containsKey(OPENSHIFT_URL_SYTEM_PROPERTY)) {
      builder.withOpenShiftUrl((String) properties.get(OPENSHIFT_URL_SYTEM_PROPERTY));
    } else {
      builder.withOpenShiftUrl(URLUtils.join(builder.getMasterUrl(), "oapi", builder.getOapiVersion()));
    }
    if (properties.containsKey(OPENSHIFT_BUILD_TIMEOUT_SYSTEM_PROPERTY)) {
      builder.withBuildTimeout(Integer.parseInt((String) properties.get(OPENSHIFT_BUILD_TIMEOUT_SYSTEM_PROPERTY)));
    } else {
      builder.withBuildTimeout(DEFAULT_BUILD_TIMEOUT);
    }

    delegate = new DefaultOpenShiftClient(builder.build());
  }

  @Deactivate
  public void deactivate() {
    delegate.close();
  }

  @Override
  public URL getOpenshiftUrl() {
    return delegate.getOpenshiftUrl();
  }

  @Override
  public ClientMixedOperation<Build, BuildList, DoneableBuild, ClientResource<Build, DoneableBuild>> builds() {
    return delegate.builds();
  }

  @Override
  public ClientMixedOperation<ComponentStatus, ComponentStatusList, DoneableComponentStatus, ClientResource<ComponentStatus, DoneableComponentStatus>> componentstatuses() {
    return delegate.componentstatuses();
  }

  @Override
  public ClientMixedOperation<BuildConfig, BuildConfigList, DoneableBuildConfig, ClientBuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Build>> buildConfigs() {
    return delegate.buildConfigs();
  }

  @Override
  public ClientMixedOperation<DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig, ClientScaleableResource<DeploymentConfig, DoneableDeploymentConfig>> deploymentConfigs() {
    return delegate.deploymentConfigs();
  }

  @Override
  public ClientNonNamespaceOperation<Group, GroupList, DoneableGroup, ClientResource<Group, DoneableGroup>> groups() {
    return delegate.groups();
  }

  @Override
  public ClientMixedOperation<ImageStream, ImageStreamList, DoneableImageStream, ClientResource<ImageStream, DoneableImageStream>> imageStreams() {
    return delegate.imageStreams();
  }

  @Override
  public ClientMixedOperation<ImageStreamTag, ImageStreamTagList, DoneableImageStreamTag, ClientResource<ImageStreamTag, DoneableImageStreamTag>> imageStreamTags() {
    return delegate.imageStreamTags();
  }

  @Override
  public ClientNonNamespaceOperation<OAuthAccessToken, OAuthAccessTokenList, DoneableOAuthAccessToken, ClientResource<OAuthAccessToken, DoneableOAuthAccessToken>> oAuthAccessTokens() {
    return delegate.oAuthAccessTokens();
  }

  @Override
  public ClientNonNamespaceOperation<OAuthAuthorizeToken, OAuthAuthorizeTokenList, DoneableOAuthAuthorizeToken, ClientResource<OAuthAuthorizeToken, DoneableOAuthAuthorizeToken>> oAuthAuthorizeTokens() {
    return delegate.oAuthAuthorizeTokens();
  }

  @Override
  public ClientNonNamespaceOperation<OAuthClient, OAuthClientList, DoneableOAuthClient, ClientResource<OAuthClient, DoneableOAuthClient>> oAuthClients() {
    return delegate.oAuthClients();
  }

  @Override
  public ClientMixedOperation<Policy, PolicyList, DoneablePolicy, ClientResource<Policy, DoneablePolicy>> policies() {
    return delegate.policies();
  }

  @Override
  public ClientMixedOperation<PolicyBinding, PolicyBindingList, DoneablePolicyBinding, ClientResource<PolicyBinding, DoneablePolicyBinding>> policyBindings() {
    return delegate.policyBindings();
  }

  @Override
  public ClientNonNamespaceOperation<Project, ProjectList, DoneableProject, ClientResource<Project, DoneableProject>> projects() {
    return delegate.projects();
  }

  @Override
  public ClientProjectRequestOperation projectrequests() {
    return delegate.projectrequests();
  }

  @Override
  public ClientMixedOperation<RoleBinding, RoleBindingList, DoneableRoleBinding, ClientResource<RoleBinding, DoneableRoleBinding>> roleBindings() {
    return delegate.roleBindings();
  }

  @Override
  public ClientMixedOperation<Route, RouteList, DoneableRoute, ClientResource<Route, DoneableRoute>> routes() {
    return delegate.routes();
  }

  @Override
  public ClientMixedOperation<Template, TemplateList, DoneableTemplate, ClientTemplateResource<Template, KubernetesList, DoneableTemplate>> templates() {
    return delegate.templates();
  }

  @Override
  public ClientNonNamespaceOperation<User, UserList, DoneableUser, ClientResource<User, DoneableUser>> users() {
    return delegate.users();
  }

  @Override
  public ClientSubjectAccessReviewOperation<CreateableSubjectAccessReview, CreateableLocalSubjectAccessReview> subjectAccessReviews() {
    return delegate.subjectAccessReviews();
  }

  @Override
  public ClientMixedOperation<ClusterRoleBinding, ClusterRoleBindingList, DoneableClusterRoleBinding, ClientResource<ClusterRoleBinding, DoneableClusterRoleBinding>> clusterRoleBindings() {
    return delegate.clusterRoleBindings();
  }

  @Override
  public NamespaceVisitFromServerGetDeleteRecreateApplicable<List<HasMetadata>, Boolean> load(InputStream is) {
    return delegate.load(is);
  }

  @Override
  public NamespaceVisitFromServerGetDeleteRecreateApplicable<List<HasMetadata>, Boolean> resource(HasMetadata item) {
    return delegate.resource(item);
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
  public ClientMixedOperation<io.fabric8.kubernetes.api.model.Service, ServiceList, DoneableService, ClientResource<io.fabric8.kubernetes.api.model.Service, DoneableService>> services() {
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

  @Override
  public ExtensionsAPIGroupDSL extensions() {
    return delegate.extensions();
  }

  @Override
  public AutoscalingAPIGroupDSL autoscaling() {
    return delegate.autoscaling();
  }

  @Override
  public NamespacedOpenShiftClient inAnyNamespace() {
    return delegate.inAnyNamespace();
  }

  @Override
  public NamespacedOpenShiftClient inNamespace(String name) {
    return delegate.inNamespace(name);
  }
}
