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

import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.DoneableComponentStatus;
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
import io.fabric8.kubernetes.api.model.KubernetesList;
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
import io.fabric8.kubernetes.client.dsl.ClientKubernetesListMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientPodResource;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.dsl.NamespaceVisitFromServerGetDeleteRecreateApplicable;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildList;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.api.model.DoneableBuild;
import io.fabric8.openshift.api.model.DoneableBuildConfig;
import io.fabric8.openshift.api.model.DoneableDeploymentConfig;
import io.fabric8.openshift.api.model.DoneableGroup;
import io.fabric8.openshift.api.model.DoneableImageStream;
import io.fabric8.openshift.api.model.DoneableOAuthAccessToken;
import io.fabric8.openshift.api.model.DoneableOAuthAuthorizeToken;
import io.fabric8.openshift.api.model.DoneableOAuthClient;
import io.fabric8.openshift.api.model.DoneablePolicy;
import io.fabric8.openshift.api.model.DoneablePolicyBinding;
import io.fabric8.openshift.api.model.DoneableProject;
import io.fabric8.openshift.api.model.DoneableRoleBinding;
import io.fabric8.openshift.api.model.DoneableRoute;
import io.fabric8.openshift.api.model.DoneableTemplate;
import io.fabric8.openshift.api.model.DoneableUser;
import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.GroupList;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamList;
import io.fabric8.openshift.api.model.OAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAccessTokenList;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeTokenList;
import io.fabric8.openshift.api.model.OAuthClient;
import io.fabric8.openshift.api.model.OAuthClientList;
import io.fabric8.openshift.api.model.Policy;
import io.fabric8.openshift.api.model.PolicyBinding;
import io.fabric8.openshift.api.model.PolicyBindingList;
import io.fabric8.openshift.api.model.PolicyList;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectList;
import io.fabric8.openshift.api.model.RoleBinding;
import io.fabric8.openshift.api.model.RoleBindingList;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteList;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.api.model.UserList;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.OpenShiftConfig;
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
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static io.fabric8.kubernetes.client.Config.KUBERNETES_ALL_PROXY;
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
import static io.fabric8.kubernetes.client.Config.KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY;
import static io.fabric8.openshift.client.OpenShiftConfig.KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY;
import static io.fabric8.openshift.client.OpenShiftConfig.OPENSHIFT_URL_SYTEM_PROPERTY;

@Component(immediate = true, configurationPid = "io.fabric8.openshift.client", policy = ConfigurationPolicy.OPTIONAL)
@Service(OpenShiftClient.class)
public class ManagedOpenShiftClient extends BaseClient implements OpenShiftClient {

  @Property(name = OPENSHIFT_URL_SYTEM_PROPERTY)
  private String openshiftUrl = Utils.getSystemPropertyOrEnvVar(OPENSHIFT_URL_SYTEM_PROPERTY);

  @Property(name = KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY, value = "v1")
  private String oapiVersion = Utils.getSystemPropertyOrEnvVar(KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY);

  @Property(name = KUBERNETES_MASTER_SYSTEM_PROPERTY, description = "Master URL", value = "https://kubernetes.default.svc")
  private String masterUrl = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY, "https://kubernetes.default.svc");
  @Property(name = KUBERNETES_API_VERSION_SYSTEM_PROPERTY, description = "Api Version", value = "v1")
  private String apiVersion = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_API_VERSION_SYSTEM_PROPERTY, "v1");
  @Property(name = KUBERNETES_NAMESPACE_SYSTEM_PROPERTY, description = "Default namespace", value = "default")
  private String namespace = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_NAMESPACE_SYSTEM_PROPERTY, "default");
  @Property(name = KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY, description = "CA Certificate (Path to file)")
  private String caCertFile = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY);
  @Property(name = KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY, description = "CA Certificate (Data)")
  private String caCertData = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY);
  @Property(name = KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY, description = "Client Certificate (Path to file)")
  private String clientCertFile = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY);
  @Property(name = KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY, description = "Client Certificate (Data)")
  private String clientCertData = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY);
  @Property(name = KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY, description = "Client Key (Path to file)")
  private String clientKeyFile = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY);
  @Property(name = KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY, description = "Client Key (Data)")
  private String clientKeyData = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY);
  @Property(name = KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY, description = "Client Key Algorithm")
  private String clientKeyAlgo = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY, "RSA");
  @Property(name = KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY, description = "Client passphrase")
  private String clientKeyPassphrase = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY, "changeit");
  @Property(name = KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY, description = "Username")
  private String username = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY);
  @Property(name = KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY, description = "Username")
  private String password = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY);
  @Property(name = KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY, description = "OAuth Token")
  private String oauthToken = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY);
  @Property(name = KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY, description = "Watch reconnect interval", intValue = 1000)
  private int watchReconnectInterval = Integer.parseInt(Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY, "1000"));
  @Property(name = KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY, description = "Watch reconnect limit", intValue = -1)
  private int watchReconnectLimit = Integer.parseInt(Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY, "-1"));
  @Property(name = KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY, description = "Request timeout", intValue = 10000)
  private int requestTimeout = Integer.parseInt(Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY, "10000"));
  @Property(name = KUBERNETES_HTTP_PROXY, description = "HTTP Proxy")
  private String httpProxy = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_HTTP_PROXY);
  @Property(name = KUBERNETES_HTTPS_PROXY, description = "HTTPS Proxy")
  private String httpsProxy = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_HTTPS_PROXY);
  @Property(name = KUBERNETES_ALL_PROXY, description = "All Proxy")
  private String allProxy = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_ALL_PROXY);
  @Property(name = KUBERNETES_NO_PROXY, description = "No Proxy")
  private String noProxy = Utils.getSystemPropertyOrEnvVar(Config.KUBERNETES_NO_PROXY);
  @Property(name = KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY, description = "Kubernetes trust certifacates flag", boolValue = false)
  private Boolean trustCerts = Utils.getSystemPropertyOrEnvVar(KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY, Boolean.FALSE);

  private OpenShiftClient delegate;

  @Activate
  public void activate(Map<String, Object> properties) {
    String masterUrl = (String) properties.get(KUBERNETES_MASTER_SYSTEM_PROPERTY);

    String openshiftUrl = (String) properties.get(OPENSHIFT_URL_SYTEM_PROPERTY);
    String oapiVersion = (String) properties.get(OPENSHIFT_URL_SYTEM_PROPERTY);

    String noProxyProperty = (String) properties.get(KUBERNETES_NO_PROXY);
    String[] noProxy = noProxyProperty != null ? noProxyProperty.split(",") : null;

    OpenShiftConfig config = new OpenShiftConfigBuilder()
      .withMasterUrl(masterUrl)
      .withApiVersion((String) properties.get(KUBERNETES_API_VERSION_SYSTEM_PROPERTY))
      .withNamespace((String) properties.get(KUBERNETES_NAMESPACE_SYSTEM_PROPERTY))
      .withCaCertFile((String) properties.get(KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY))
      .withCaCertData((String) properties.get(KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY))
      .withClientCertFile((String) properties.get(KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY))
      .withClientCertData((String) properties.get(KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY))
      .withClientKeyFile((String) properties.get(KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY))
      .withClientKeyData((String) properties.get(KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY))
      .withClientKeyAlgo((String) properties.get(KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY))
      .withClientKeyPassphrase((String) properties.get(KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY))
      .withUsername((String) properties.get(KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY))
      .withPassword((String) properties.get(KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY))
      .withOauthToken((String) properties.get(KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY))
      .withWatchReconnectInterval((int) properties.get(KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY))
      .withWatchReconnectLimit((int) properties.get(KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY))
      .withRequestTimeout((int) properties.get(KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY))
      .withHttpProxy((String) properties.get(KUBERNETES_HTTP_PROXY))
      .withHttpsProxy((String) properties.get(KUBERNETES_HTTPS_PROXY))
      .withNoProxy(noProxy)
      .withOpenShiftUrl((openshiftUrl != null && !openshiftUrl.isEmpty()) ? openshiftUrl : URLUtils.join(masterUrl, "oapi", oapiVersion))
      .build();

    delegate = new DefaultOpenShiftClient(config);
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
  public ClientMixedOperation<BuildConfig, BuildConfigList, DoneableBuildConfig, ClientBuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Void>> buildConfigs() {
    return delegate.buildConfigs();
  }

  @Override
  public ClientMixedOperation<DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig, ClientResource<DeploymentConfig, DoneableDeploymentConfig>> deploymentConfigs() {
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
  public NamespaceVisitFromServerGetDeleteRecreateApplicable<List<HasMetadata>, Boolean> load(InputStream is) {
    return delegate.load(is);
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
  public ClientMixedOperation<PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, ClientResource<PersistentVolume, DoneablePersistentVolume>> persistentVolumes() {
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
  public OpenShiftClient inNamespace(String name) {
    return delegate.inNamespace(name);
  }

  @Override
  public OpenShiftClient inAnyNamespace() {
    return delegate.inAnyNamespace();
  }

}
