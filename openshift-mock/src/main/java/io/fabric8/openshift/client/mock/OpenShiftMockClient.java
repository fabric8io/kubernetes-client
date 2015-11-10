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

package io.fabric8.openshift.client.mock;

import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventList;
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
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.mock.MockKubernetesListOperation;
import io.fabric8.kubernetes.client.mock.MockLoggableResource;
import io.fabric8.kubernetes.client.mock.MockNonNamespaceOperation;
import io.fabric8.kubernetes.client.mock.MockOperation;
import io.fabric8.kubernetes.client.mock.MockResource;
import io.fabric8.kubernetes.client.mock.MockRollableScaleableResource;
import io.fabric8.kubernetes.client.mock.Replayable;
import io.fabric8.kubernetes.client.mock.Verifiable;
import io.fabric8.kubernetes.client.mock.impl.MockEndpoints;
import io.fabric8.kubernetes.client.mock.impl.MockEvent;
import io.fabric8.kubernetes.client.mock.impl.MockKubernetesListOperationImpl;
import io.fabric8.kubernetes.client.mock.impl.MockNamespace;
import io.fabric8.kubernetes.client.mock.impl.MockNode;
import io.fabric8.kubernetes.client.mock.impl.MockPersistentVolume;
import io.fabric8.kubernetes.client.mock.impl.MockPersistentVolumeClaim;
import io.fabric8.kubernetes.client.mock.impl.MockPod;
import io.fabric8.kubernetes.client.mock.impl.MockReplicationController;
import io.fabric8.kubernetes.client.mock.impl.MockResourceQuota;
import io.fabric8.kubernetes.client.mock.impl.MockSecret;
import io.fabric8.kubernetes.client.mock.impl.MockSecurityContextConstraints;
import io.fabric8.kubernetes.client.mock.impl.MockService;
import io.fabric8.kubernetes.client.mock.impl.MockServiceAccount;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableEndpoints;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableEvent;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableNamespace;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableNode;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneablePersistentVolume;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneablePersistentVolumeClaim;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneablePod;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableReplicationController;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableResourceQuota;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableSecret;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableSecurityContextConstraints;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableService;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableServiceAccount;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildList;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
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
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.mock.impl.MockBuild;
import io.fabric8.openshift.client.mock.impl.MockBuildConfig;
import io.fabric8.openshift.client.mock.impl.MockDeploymentConfig;
import io.fabric8.openshift.client.mock.impl.MockGroup;
import io.fabric8.openshift.client.mock.impl.MockImageStream;
import io.fabric8.openshift.client.mock.impl.MockOAuthAccessToken;
import io.fabric8.openshift.client.mock.impl.MockOAuthAuthorizeToken;
import io.fabric8.openshift.client.mock.impl.MockOAuthClient;
import io.fabric8.openshift.client.mock.impl.MockPolicy;
import io.fabric8.openshift.client.mock.impl.MockPolicyBinding;
import io.fabric8.openshift.client.mock.impl.MockProject;
import io.fabric8.openshift.client.mock.impl.MockProjectRequest;
import io.fabric8.openshift.client.mock.impl.MockRoleBinding;
import io.fabric8.openshift.client.mock.impl.MockRoute;
import io.fabric8.openshift.client.mock.impl.MockSubjectAccessReview;
import io.fabric8.openshift.client.mock.impl.MockTemplate;
import io.fabric8.openshift.client.mock.impl.MockUser;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableBuild;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableBuildConfig;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableDeploymentConfig;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableGroup;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableImageStream;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableOAuthAccessToken;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableOAuthAuthorizeToken;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableOAuthClient;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneablePolicy;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneablePolicyBinding;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableProject;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableRoleBinding;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableRoute;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableTemplate;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableUser;
import org.easymock.EasyMock;
import org.easymock.IAnswer;
import org.easymock.IArgumentMatcher;
import org.easymock.IExpectationSetters;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static io.fabric8.kubernetes.client.mock.util.MockUtils.getArgument;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

public class OpenShiftMockClient implements Replayable<OpenShiftClient>, Verifiable {

  private final OpenShiftClient client = createMock(OpenShiftClient.class);

  private OpenShiftMockClient anyNamespaceOp;
  private Map<IArgumentMatcher, OpenShiftMockClient> namespaceMap = new HashMap<>();

  private final MockEndpoints endpoints = new MockEndpoints();
  private final MockEvent events = new MockEvent();
  private final MockNode nodes = new MockNode();
  private final MockNamespace namespaces = new MockNamespace();
  private final MockPersistentVolume persistentVolumes = new MockPersistentVolume();
  private final MockPersistentVolumeClaim persistentVolumeClaims = new MockPersistentVolumeClaim();
  private final MockPod pods = new MockPod();
  private final MockService services = new MockService();
  private final MockReplicationController replicationControllers = new MockReplicationController();
  private final MockResourceQuota resourceQuotas = new MockResourceQuota();
  private final MockSecret secrets = new MockSecret();
  private final MockServiceAccount serviceAccounts = new MockServiceAccount();
  private final MockSecurityContextConstraints securityContextConstraints = new MockSecurityContextConstraints();
  private final MockKubernetesListOperationImpl kubernetesLists = new MockKubernetesListOperationImpl();

  private final MockTemplate templates = new MockTemplate();
  private final MockBuild builds = new MockBuild();
  private final MockBuildConfig buildConfigs = new MockBuildConfig();
  private final MockDeploymentConfig deploymentConfigs = new MockDeploymentConfig();
  private final MockImageStream imageStreams = new MockImageStream();
  private final MockOAuthAccessToken oAuthAccessTokens = new MockOAuthAccessToken();
  private final MockOAuthAuthorizeToken oAuthAuthorizeTokens = new MockOAuthAuthorizeToken();
  private final MockOAuthClient oAuthClients = new MockOAuthClient();
  private final MockProject projects = new MockProject();
  private final MockProjectRequest projectrequests = new MockProjectRequest();
  private final MockRoute routes = new MockRoute();
  private final MockUser users = new MockUser();
  private final MockGroup groups = new MockGroup();
  private final MockPolicy policies = new MockPolicy();
  private final MockPolicyBinding policyBindings = new MockPolicyBinding();
  private final MockRoleBinding roleBindings = new MockRoleBinding();
  private final MockSubjectAccessReview subjectAccessReviews = new MockSubjectAccessReview();

  public OpenShiftMockClient() {
    expect(client.adapt(OpenShiftClient.class)).andReturn(client).anyTimes();
    expect(client.endpoints()).andReturn(endpoints.getDelegate()).anyTimes();
    expect(client.events()).andReturn(events.getDelegate()).anyTimes();
    expect(client.nodes()).andReturn(nodes.getDelegate()).anyTimes();
    expect(client.namespaces()).andReturn(namespaces.getDelegate()).anyTimes();
    expect(client.persistentVolumes()).andReturn(persistentVolumes.getDelegate()).anyTimes();
    expect(client.persistentVolumeClaims()).andReturn(persistentVolumeClaims.getDelegate()).anyTimes();
    expect(client.pods()).andReturn(pods.getDelegate()).anyTimes();
    expect(client.services()).andReturn(services.getDelegate()).anyTimes();
    expect(client.replicationControllers()).andReturn(replicationControllers.getDelegate()).anyTimes();
    expect(client.resourceQuotas()).andReturn(resourceQuotas.getDelegate()).anyTimes();
    expect(client.secrets()).andReturn(secrets.getDelegate()).anyTimes();
    expect(client.serviceAccounts()).andReturn(serviceAccounts.getDelegate()).anyTimes();
    expect(client.securityContextConstraints()).andReturn(securityContextConstraints.getDelegate()).anyTimes();
    expect(client.lists()).andReturn(kubernetesLists.getDelegate()).anyTimes();

    expect(client.builds()).andReturn(builds.getDelegate()).anyTimes();
    expect(client.buildConfigs()).andReturn(buildConfigs.getDelegate()).anyTimes();
    expect(client.deploymentConfigs()).andReturn(deploymentConfigs.getDelegate()).anyTimes();
    expect(client.imageStreams()).andReturn(imageStreams.getDelegate()).anyTimes();
    expect(client.oAuthAccessTokens()).andReturn(oAuthAccessTokens.getDelegate()).anyTimes();
    expect(client.oAuthAuthorizeTokens()).andReturn(oAuthAuthorizeTokens.getDelegate()).anyTimes();
    expect(client.oAuthClients()).andReturn(oAuthClients.getDelegate()).anyTimes();
    expect(client.projects()).andReturn(projects.getDelegate()).anyTimes();
    expect(client.projectrequests()).andReturn(projectrequests.getDelegate()).anyTimes();
    expect(client.routes()).andReturn(routes.getDelegate()).anyTimes();
    expect(client.templates()).andReturn(templates.getDelegate()).anyTimes();
    expect(client.users()).andReturn(users.getDelegate()).anyTimes();
    expect(client.groups()).andReturn(groups.getDelegate()).anyTimes();
    expect(client.policies()).andReturn(policies.getDelegate()).anyTimes();
    expect(client.policyBindings()).andReturn(policyBindings.getDelegate()).anyTimes();
    expect(client.roleBindings()).andReturn(roleBindings.getDelegate()).anyTimes();
    expect(client.subjectAccessReviews()).andReturn(subjectAccessReviews.getDelegate()).anyTimes();

    client.close();
    EasyMock.expectLastCall().anyTimes();
  }

  public OpenShiftClient replay() {
    endpoints.replay();
    events.replay();
    nodes.replay();
    namespaces.replay();
    persistentVolumes.replay();
    persistentVolumeClaims.replay();
    pods.replay();
    services.replay();
    replicationControllers.replay();
    resourceQuotas.replay();
    secrets.replay();
    serviceAccounts.replay();
    securityContextConstraints.replay();
    kubernetesLists.replay();

    builds.replay();
    buildConfigs.replay();
    deploymentConfigs.replay();
    imageStreams.replay();
    oAuthAccessTokens.replay();
    oAuthAuthorizeTokens.replay();
    oAuthClients.replay();
    projects.replay();
    projectrequests.replay();
    routes.replay();
    templates.replay();

    users.replay();
    groups.replay();
    policies.replay();
    policyBindings.replay();
    roleBindings.replay();
    subjectAccessReviews.replay();

    EasyMock.replay(client);
    return client;
  }


  @Override
  public void verify() {
    endpoints.verify();
    events.verify();
    nodes.verify();
    namespaces.verify();
    persistentVolumes.verify();
    persistentVolumeClaims.verify();
    pods.verify();
    services.verify();
    replicationControllers.verify();
    resourceQuotas.verify();
    secrets.verify();
    serviceAccounts.verify();
    securityContextConstraints.verify();
    kubernetesLists.verify();

    builds.verify();
    buildConfigs.verify();
    deploymentConfigs.verify();
    imageStreams.verify();
    oAuthAccessTokens.verify();
    oAuthAuthorizeTokens.verify();
    oAuthClients.verify();
    projects.verify();
    projectrequests.verify();
    routes.verify();
    templates.verify();
    users.verify();
    groups.verify();
    policies.verify();
    policyBindings.verify();
    roleBindings.verify();
    subjectAccessReviews.verify();
    EasyMock.verify(client);
  }

  public IExpectationSetters<URL> getMasterUrl() {
    return expect(client.getMasterUrl());
  }

  public IExpectationSetters<Config> getConfiguration() {
    return expect(client.getConfiguration());
  }


  public IExpectationSetters<RootPaths> rootPaths() {
    return expect(client.rootPaths());
  }

  public MockOperation<Endpoints, EndpointsList, MockDoneableEndpoints, MockResource<Endpoints, MockDoneableEndpoints, Boolean>> endpoints() {
    return endpoints;
  }

  public MockOperation<Event, EventList, MockDoneableEvent, MockResource<Event, MockDoneableEvent, Boolean>> events() {
    return events;
  }

  public MockNonNamespaceOperation<Namespace, NamespaceList, MockDoneableNamespace, MockResource<Namespace, MockDoneableNamespace, Boolean>> namespaces() {
    return namespaces;
  }

  public MockNonNamespaceOperation<Node, NodeList, MockDoneableNode, MockResource<Node, MockDoneableNode, Boolean>> nodes() {
    return nodes;
  }

  public MockOperation<PersistentVolume, PersistentVolumeList, MockDoneablePersistentVolume, MockResource<PersistentVolume, MockDoneablePersistentVolume, Boolean>> persistentVolumes() {
    return persistentVolumes;
  }

  public MockOperation<PersistentVolumeClaim, PersistentVolumeClaimList, MockDoneablePersistentVolumeClaim, MockResource<PersistentVolumeClaim, MockDoneablePersistentVolumeClaim, Boolean>> persistentVolumeClaims() {
    return persistentVolumeClaims;
  }

  public MockOperation<Pod, PodList, MockDoneablePod, MockLoggableResource<Pod, MockDoneablePod, Boolean>> pods() {
    return pods;
  }

  public MockOperation<ReplicationController, ReplicationControllerList, MockDoneableReplicationController, MockRollableScaleableResource<ReplicationController, MockDoneableReplicationController, Boolean>> replicationControllers() {
    return replicationControllers;
  }

  public MockOperation<ResourceQuota, ResourceQuotaList, MockDoneableResourceQuota, MockResource<ResourceQuota, MockDoneableResourceQuota, Boolean>> resourceQuotas() {
    return resourceQuotas;
  }

  public MockOperation<Secret, SecretList, MockDoneableSecret, MockResource<Secret, MockDoneableSecret, Boolean>> secrets() {
    return secrets;
  }

  public MockOperation<Service, ServiceList, MockDoneableService, MockResource<Service, MockDoneableService, Boolean>> services() {
    return services;
  }

  public MockOperation<ServiceAccount, ServiceAccountList, MockDoneableServiceAccount, MockResource<ServiceAccount, MockDoneableServiceAccount, Boolean>> serviceAccounts() {
    return serviceAccounts;
  }
  public MockOperation<SecurityContextConstraints, SecurityContextConstraintsList, MockDoneableSecurityContextConstraints, MockResource<SecurityContextConstraints, MockDoneableSecurityContextConstraints, Boolean>> securityContextConstraints() {
    return securityContextConstraints;
  }

  public MockKubernetesListOperation lists() {
    return kubernetesLists;
  }

  public MockOperation<Build, BuildList, MockDoneableBuild, MockResource<Build, MockDoneableBuild, Boolean>> builds() {
    return builds;
  }

  public MockOperation<BuildConfig, BuildConfigList, MockDoneableBuildConfig, MockBuildConfigResource> buildConfigs() {
    return buildConfigs;
  }

  public MockOperation<DeploymentConfig, DeploymentConfigList, MockDoneableDeploymentConfig, MockResource<DeploymentConfig, MockDoneableDeploymentConfig, Boolean>> deploymentConfigs() {
    return deploymentConfigs;
  }

  public MockOperation<ImageStream, ImageStreamList, MockDoneableImageStream, MockResource<ImageStream, MockDoneableImageStream, Boolean>> imageStreams() {
    return imageStreams;
  }

  public MockNonNamespaceOperation<OAuthAccessToken, OAuthAccessTokenList, MockDoneableOAuthAccessToken, MockResource<OAuthAccessToken, MockDoneableOAuthAccessToken, Boolean>> oAuthAccessTokens() {
    return oAuthAccessTokens;
  }

  public MockNonNamespaceOperation<OAuthAuthorizeToken, OAuthAuthorizeTokenList, MockDoneableOAuthAuthorizeToken, MockResource<OAuthAuthorizeToken, MockDoneableOAuthAuthorizeToken, Boolean>> oAuthAuthorizeTokens() {
    return oAuthAuthorizeTokens;
  }

  public MockNonNamespaceOperation<OAuthClient, OAuthClientList, MockDoneableOAuthClient, MockResource<OAuthClient, MockDoneableOAuthClient, Boolean>> oAuthClients() {
    return oAuthClients;
  }

  public MockNonNamespaceOperation<Project, ProjectList, MockDoneableProject, MockResource<Project, MockDoneableProject, Boolean>> projects() {
    return projects;
  }

  public MockProjectRequest projectrequests() {
    return projectrequests;
  }


  public MockOperation<Route, RouteList, MockDoneableRoute, MockResource<Route, MockDoneableRoute, Boolean>> routes() {
    return routes;
  }

  public  MockOperation<Template, TemplateList, MockDoneableTemplate, MockProcessableResource<Template, MockDoneableTemplate, Boolean>> templates() {
    return templates;
  }

  public  MockOperation<Group, GroupList, MockDoneableGroup, MockResource<Group, MockDoneableGroup, Boolean>> groups() {
    return groups;
  }

  public  MockOperation<User, UserList, MockDoneableUser, MockResource<User, MockDoneableUser, Boolean>> users() {
    return users;
  }

  public  MockOperation<Policy, PolicyList, MockDoneablePolicy, MockResource<Policy, MockDoneablePolicy, Boolean>> policies() {
    return policies;
  }

  public  MockOperation<PolicyBinding, PolicyBindingList, MockDoneablePolicyBinding, MockResource<PolicyBinding, MockDoneablePolicyBinding, Boolean>> policyBindings() {
    return policyBindings;
  }

  public  MockOperation<RoleBinding, RoleBindingList, MockDoneableRoleBinding, MockResource<RoleBinding, MockDoneableRoleBinding, Boolean>> roleBindings() {
    return roleBindings;
  }

  public MockSubjectAccessReview getSubjectAccessReviews() {
    return subjectAccessReviews;
  }

  public OpenShiftMockClient inNamespace(final String namespace) {
    IArgumentMatcher matcher = getArgument(namespace);
    OpenShiftMockClient op = namespaceMap.get(matcher);
    if (op == null) {
      final OpenShiftMockClient namespacedClient = new OpenShiftMockClient();
      op = namespacedClient;
      expect(client.inNamespace(namespace)).andAnswer(new IAnswer<OpenShiftClient>() {
        @Override
        public OpenShiftClient answer() throws Throwable {
          namespacedClient.getNamespace().andReturn(namespace).anyTimes();
          return namespacedClient.replay();
        }
      }).anyTimes();
      namespaceMap.put(matcher, op);
    }
    return op;
  }

  public OpenShiftMockClient inAnyNamepace() {
    if (anyNamespaceOp == null) {
      final OpenShiftMockClient namespacedClient = new OpenShiftMockClient();
      anyNamespaceOp = namespacedClient;
      expect(client.inAnyNamespace()).andAnswer(new IAnswer<OpenShiftClient>() {
        @Override
        public OpenShiftClient answer() throws Throwable {
          namespacedClient.getNamespace().andReturn(null).anyTimes();
          return namespacedClient.replay();
        }
      }).anyTimes();
    }
    return anyNamespaceOp;
  }

  public IExpectationSetters<String> getNamespace() {
    return expect(client.getNamespace());
  }

  public  <T> IExpectationSetters<Boolean> isAdaptable(Class<T> type) {
    return expect(client.isAdaptable(type));
  }

  public <T> IExpectationSetters<T> adapt(Class<T> type) {
    return expect(client.adapt(type));
  }
}
